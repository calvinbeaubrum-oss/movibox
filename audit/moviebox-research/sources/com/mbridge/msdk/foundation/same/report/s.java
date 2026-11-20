package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f44918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f44919b;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, String> f44920a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f44921b;

        public a(String str) {
            this.f44921b = str;
        }

        public final s a() {
            return new s(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends com.mbridge.msdk.foundation.same.report.e.b {
        @Override // com.mbridge.msdk.foundation.same.report.e.b
        public final void onFailed(String str) {
            if (MBridgeConstans.DEBUG) {
                ad.a("SameCommonReporter", "report failed for： " + str);
            }
        }

        @Override // com.mbridge.msdk.foundation.same.report.e.b
        public final void onSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                ad.a("SameCommonReporter", "report success for： " + str);
            }
        }
    }

    private s(a aVar) {
        this.f44919b = aVar.f44921b;
        this.f44918a = aVar.f44920a;
    }

    private String a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb2 = new StringBuilder();
            try {
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String strEncode = map.get(str);
                        if (!TextUtils.isEmpty(strEncode)) {
                            try {
                                strEncode = URLEncoder.encode(strEncode, "utf-8");
                            } catch (Exception e11) {
                                if (MBridgeConstans.DEBUG) {
                                    ad.b("SameCommonReporter", e11.getMessage());
                                }
                            }
                            sb2.append("&");
                            sb2.append(str);
                            sb2.append("=");
                            sb2.append(strEncode);
                        }
                    }
                }
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("SameCommonReporter", e12.getMessage());
                }
                sb2 = null;
            }
            if (sb2 != null && sb2.length() > 0) {
                return sb2.toString();
            }
        }
        return null;
    }

    public final void a(String str) {
        String strA;
        if (TextUtils.isEmpty(this.f44919b)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("key=");
        sb2.append(this.f44919b);
        com.mbridge.msdk.foundation.same.net.h.e eVarA = null;
        try {
            strA = a(this.f44918a);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("SameCommonReporter", e11.getMessage());
            }
            strA = null;
        }
        if (!TextUtils.isEmpty(strA)) {
            sb2.append(strA);
        }
        if (j.a().b()) {
            j.a().a(sb2.toString());
            return;
        }
        try {
            eVarA = q.a(sb2.toString(), com.mbridge.msdk.foundation.controller.c.m().c(), str);
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                ad.b("SameCommonReporter", e12.getMessage());
            }
        }
        if (eVarA != null) {
            try {
                new com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.c.m().c()).post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, eVarA, new b());
            } catch (Exception e13) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("SameCommonReporter", e13.getMessage());
                }
            }
        }
    }
}
