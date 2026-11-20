package com.cloud.tupdate.net.sign;

import android.text.TextUtils;
import com.cloud.tupdate.net.utils.LogUtil;
import com.google.gson.Gson;
import com.transsion.core.utils.c;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class HttpSigner {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f32209b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Signer f32210a;

    public HttpSigner(Signer signer) {
        this.f32210a = signer;
    }

    public static String b(String str, String str2, String str3, String str4, String str5) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = System.currentTimeMillis() + SharedPreferencesHelper.a().g("time_offset");
        String strH = new HttpSigner(new BasicSigner(e())).h(str, str2, str3, str4, str5, jCurrentTimeMillis2);
        LogUtil logUtil = LogUtil.f32213a;
        logUtil.b("x-tr-signature: " + jCurrentTimeMillis2 + "|2|" + strH);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("doSign latency: ");
        sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
        logUtil.b(sb2.toString());
        return jCurrentTimeMillis2 + "|2|" + strH;
    }

    public static String e() {
        return f32209b ? "Xqn2nnO41/L92o1iuXhSLHTbXvY4Z5ZZ62m8mSLA" : "76iRl07s0xSN9jqmEWAt79EBJZulIQIsV64FZr2O";
    }

    public static boolean f(int i11, String str) {
        if (i11 != 500 && TextUtils.isEmpty(str)) {
            return false;
        }
        Gson gson = new Gson();
        try {
            LogUtil logUtil = LogUtil.f32213a;
            logUtil.b("response" + str);
            GatewayResponse gatewayResponse = (GatewayResponse) gson.fromJson(str, GatewayResponse.class);
            if ("GW.4410".equals(gatewayResponse.error_code)) {
                logUtil.b("verify sign failed, retrying update time");
                TimeBean timeBean = (TimeBean) gson.fromJson(Crypto.a(gatewayResponse.error_msg), TimeBean.class);
                if (timeBean.time > 0) {
                    SharedPreferencesHelper.a().o("time_offset", timeBean.time - System.currentTimeMillis());
                    return true;
                }
            }
        } catch (Exception e11) {
            LogUtil.f32213a.d(e11);
        }
        return false;
    }

    public static void g(boolean z11) {
        f32209b = z11;
    }

    public final String a(String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            URI uri = new URI(str);
            sb2.append(uri.getPath());
            if (!TextUtils.isEmpty(uri.getQuery())) {
                String strI = i(uri.getQuery());
                if (!TextUtils.isEmpty(strI)) {
                    LogUtil.f32213a.b("formatedUrl" + strI);
                    sb2.append("?");
                    sb2.append(strI);
                }
            }
            return sb2.toString();
        } catch (URISyntaxException e11) {
            LogUtil.f32213a.d(e11);
            return "";
        }
    }

    public final String c(Map<String, String> map) {
        try {
            ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.cloud.tupdate.net.sign.HttpSigner.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    return entry.getKey().compareTo(entry2.getKey());
                }
            });
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry entry : arrayList) {
                if (!"".equals(entry.getKey())) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    sb2.append(str);
                    sb2.append("=");
                    sb2.append(str2);
                    sb2.append("&");
                }
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String d(String str, String str2, String str3, String str4, String str5, long j11) {
        String strB;
        long length;
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(str5)) {
            LogUtil.f32213a.b("request body is null");
            strB = "";
            length = 0;
        } else {
            LogUtil logUtil = LogUtil.f32213a;
            logUtil.b("request body is not null");
            try {
                length = str5.getBytes("UTF-8").length;
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    strB = str5.length() > 102400 ? c.b(str5.substring(0, 102400), "MD5") : c.b(str5, "MD5");
                    try {
                        logUtil.b("md5 duration" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    } catch (Exception e11) {
                        e = e11;
                        LogUtil.f32213a.b("generateContent exception" + e.toString());
                    }
                } catch (Exception e12) {
                    e = e12;
                    strB = "";
                }
            } catch (Exception e13) {
                e = e13;
                strB = "";
                length = 0;
            }
        }
        sb2.append(str.toUpperCase());
        sb2.append("\n");
        sb2.append(str2 == null ? "" : str2);
        sb2.append("\n");
        sb2.append(str3 == null ? "" : str3);
        sb2.append("\n");
        sb2.append(length == 0 ? "" : Long.valueOf(length));
        sb2.append("\n");
        sb2.append(j11);
        sb2.append("\n");
        sb2.append(TextUtils.isEmpty(strB) ? "" : strB);
        sb2.append("\n");
        sb2.append(a(str4));
        LogUtil.f32213a.b(sb2.toString());
        return sb2.toString();
    }

    public String h(String str, String str2, String str3, String str4, String str5, long j11) {
        return this.f32210a.a(SignAlgorithm.HmacMD5, d(str, str2, str3, str4, str5, j11));
    }

    public final String i(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            int iIndexOf = str2.indexOf("=");
            try {
                map.put(URLDecoder.decode(str2.substring(0, iIndexOf), "UTF-8"), URLDecoder.decode(str2.substring(iIndexOf + 1), "UTF-8"));
            } catch (Exception e11) {
                LogUtil.f32213a.d(e11);
            }
        }
        return c(map);
    }
}
