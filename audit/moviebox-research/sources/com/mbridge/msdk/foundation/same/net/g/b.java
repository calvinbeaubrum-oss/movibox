package com.mbridge.msdk.foundation.same.net.g;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ao;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f44609a = "b";

    public static String a(List<com.mbridge.msdk.foundation.same.net.d.b> list) {
        com.mbridge.msdk.foundation.same.net.d.b bVarB = b(list, HttpHeaders.CONTENT_TYPE);
        if (bVarB != null) {
            String strB = bVarB.b();
            if (!TextUtils.isEmpty(strB)) {
                String[] strArrSplit = strB.split(";");
                for (int i11 = 1; i11 < strArrSplit.length; i11++) {
                    String[] strArrSplit2 = strArrSplit[i11].trim().split("=");
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        return strArrSplit2[1];
                    }
                }
            }
        }
        return "UTF-8";
    }

    public static String a(List<com.mbridge.msdk.foundation.same.net.d.b> list, String str) {
        com.mbridge.msdk.foundation.same.net.d.b bVarB = b(list, str);
        return bVarB != null ? bVarB.b() : "";
    }

    public static void a(e eVar, String str, String str2) {
        if (eVar != null) {
            try {
                if (!an.a(str) && !an.a(str2)) {
                    eVar.a(str, str2);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                str = ao.a(str);
            }
            if (!TextUtils.isEmpty(str) && com.mbridge.msdk.f.c.c()) {
                com.mbridge.msdk.foundation.same.net.a.a.a().a(str);
            }
        } catch (Throwable th2) {
            ad.b(f44609a, th2.getMessage());
        }
    }

    private static com.mbridge.msdk.foundation.same.net.d.b b(List<com.mbridge.msdk.foundation.same.net.d.b> list, String str) {
        if (list != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                com.mbridge.msdk.foundation.same.net.d.b bVar = list.get(i11);
                if (bVar != null && str.equals(bVar.a())) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public static boolean b(List<com.mbridge.msdk.foundation.same.net.d.b> list) {
        return TextUtils.equals(a(list, HttpHeaders.CONTENT_ENCODING), "gzip");
    }
}
