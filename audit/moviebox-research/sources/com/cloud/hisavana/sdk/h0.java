package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.sign.GatewayResponse;
import com.cloud.hisavana.sdk.sign.SignAlgorithm;
import com.cloud.hisavana.sdk.sign.TimeBean;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f29741b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i1 f29742a;

    /* JADX INFO: compiled from: source.java */
    public class a implements Comparator<Map.Entry<String, String>> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    }

    public h0(i1 i1Var) {
        this.f29742a = i1Var;
    }

    public static String a() {
        return f29741b ? "Xqn2nnO41/L92o1iuXhSLHTbXvY4Z5ZZ62m8mSLA" : "76iRl07s0xSN9jqmEWAt79EBJZulIQIsV64FZr2O";
    }

    public static String c(String str, String str2, String str3, String str4, String str5) {
        System.currentTimeMillis();
        long jCurrentTimeMillis = System.currentTimeMillis() + da.a.d().g("time_offset");
        return jCurrentTimeMillis + "|2|" + new h0(new l3(a())).i(str, str2, str3, str4, str5, jCurrentTimeMillis);
    }

    public static void f(boolean z11) {
        f29741b = z11;
    }

    public static boolean g(int i11, String str) {
        if (i11 != 500 && TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            z.a().d("ssp", "response" + str);
            GatewayResponse gatewayResponse = (GatewayResponse) GsonUtil.a(str, GatewayResponse.class);
            if ("GW.4410".equals(gatewayResponse.error_code)) {
                z.a().d("ssp", "verify sign failed, retrying update time");
                TimeBean timeBean = (TimeBean) GsonUtil.a(x3.a(gatewayResponse.error_msg), TimeBean.class);
                if (timeBean.time > 0) {
                    da.a.d().o("time_offset", timeBean.time - System.currentTimeMillis());
                    return true;
                }
            }
        } catch (Exception e11) {
            z.a().e(Log.getStackTraceString(e11));
        }
        return false;
    }

    public final String b(String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            URI uri = new URI(str);
            sb2.append(uri.getPath());
            if (!TextUtils.isEmpty(uri.getQuery())) {
                String strH = h(uri.getQuery());
                if (!TextUtils.isEmpty(strH)) {
                    z.a().d("ssp", "formatedUrl" + strH);
                    sb2.append("?");
                    sb2.append(strH);
                }
            }
            return sb2.toString();
        } catch (URISyntaxException e11) {
            z.a().e(Log.getStackTraceString(e11));
            return "";
        }
    }

    public final String d(String str, String str2, String str3, String str4, String str5, long j11) {
        long length;
        String strB;
        String strSubstring = str5;
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(str5)) {
            z.a().d("ssp", "request body is null");
            strB = "";
            length = 0;
        } else {
            try {
                length = strSubstring.getBytes(StandardCharsets.UTF_8).length;
                try {
                    System.currentTimeMillis();
                    if (str5.length() > 102400) {
                        strSubstring = strSubstring.substring(0, 102400);
                    }
                    strB = com.transsion.infra.gateway.core.utils.b.b(strSubstring, "MD5");
                } catch (Exception e11) {
                    e = e11;
                    z.a().d("ssp", "generateContent exception" + e);
                    strB = "";
                }
            } catch (Exception e12) {
                e = e12;
                length = 0;
            }
        }
        sb2.append(TextUtils.isEmpty(str) ? "" : str.toUpperCase());
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
        sb2.append(b(str4));
        return sb2.toString();
    }

    public final String e(Map<String, String> map) {
        try {
            ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new a());
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

    public final String h(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            if (str2 != null) {
                int iIndexOf = str2.indexOf("=");
                try {
                    map.put(URLDecoder.decode(str2.substring(0, iIndexOf), "UTF-8"), URLDecoder.decode(str2.substring(iIndexOf + 1), "UTF-8"));
                } catch (Exception e11) {
                    z.a().e(Log.getStackTraceString(e11));
                }
            }
        }
        return e(map);
    }

    public String i(String str, String str2, String str3, String str4, String str5, long j11) {
        String strD = d(str, str2, str3, str4, str5, j11);
        i1 i1Var = this.f29742a;
        return i1Var != null ? i1Var.a(SignAlgorithm.HmacMD5, strD) : "";
    }
}
