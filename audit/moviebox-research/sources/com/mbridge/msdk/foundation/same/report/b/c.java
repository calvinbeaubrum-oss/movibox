package com.mbridge.msdk.foundation.same.report.b;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.e.e;
import com.mbridge.msdk.foundation.same.report.g;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f44796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f44797b;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements com.mbridge.msdk.foundation.same.report.b.a {
        @Override // com.mbridge.msdk.foundation.same.report.b.a
        public final void a() {
        }

        @Override // com.mbridge.msdk.foundation.same.report.b.a
        public final void a(final String str, final StackTraceElement[] stackTraceElementArr) {
            if (MBridgeConstans.DEBUG) {
                ad.a("AnrMonitorManager", "onAnrHappened: " + str);
            }
            if (!c.d(str)) {
                ad.a("AnrMonitorManager", "onAnrHappened: can track false");
                return;
            }
            long unused = c.f44797b = System.currentTimeMillis();
            com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.b.c.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    String str2 = str;
                    StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
                    try {
                        if (af.a().a("metrics", "e_t_l", af.a().a("e_t_l", 1)) == 1) {
                            c.a(str2, stackTraceElementArr2);
                        } else {
                            new o(com.mbridge.msdk.foundation.controller.c.m().c()).a("key=m_anr_report&exception=" + c.c(str2) + "&crash_first_index_from_mtg=" + c.b(stackTraceElementArr2), (File) null);
                        }
                    } catch (Exception e11) {
                        ad.a("AnrMonitorManager", "handler anr failed", e11);
                    }
                }
            });
        }
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null && stackTraceElementArr.length != 0) {
            try {
                StringBuilder sb2 = new StringBuilder();
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (stackTraceElement != null) {
                        sb2.append(stackTraceElement.toString());
                        sb2.append("\r\n");
                    }
                }
                return sb2.toString();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static void a() {
        if (!b()) {
            ad.a("AnrMonitorManager", "anr monitor is not available");
            return;
        }
        try {
            b.a().a(c(), new a()).start();
        } catch (Exception e11) {
            ad.a("AnrMonitorManager", "start anr monitor failed", e11);
        }
    }

    public static /* synthetic */ void a(String str, StackTraceElement[] stackTraceElementArr) throws JSONException {
        try {
            JSONObject jSONObjectC = c(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", jSONObjectC.toString());
            jSONObject.put("crash_first_index_from_mtg", b(stackTraceElementArr));
            e eVar = new e("m_anr_report");
            eVar.a(jSONObject);
            eVar.a(g.c());
            eVar.a(0);
            eVar.b(1);
            l.a().d().a(eVar);
        } catch (JSONException e11) {
            ad.a("AnrMonitorManager", "reportANRByEventLibrary anr failed", e11);
        }
    }

    public static String b(StackTraceElement[] stackTraceElementArr) {
        return c(stackTraceElementArr) ? "1" : "0";
    }

    private static boolean b() {
        try {
            return af.a().a("anr_monitor_available", false);
        } catch (Exception e11) {
            ad.a("AnrMonitorManager", "get anr monitor available failed", e11);
            return false;
        }
    }

    private static int c() {
        try {
            int iA = af.a().a("anr_check_timeout", 5000);
            if (iA <= 0) {
                return 5000;
            }
            return iA;
        } catch (Exception e11) {
            ad.a("AnrMonitorManager", "get anr check timeout failed", e11);
            return 5000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject c(String str) throws JSONException {
        JSONObject jSONObjectB = d.a(com.mbridge.msdk.foundation.controller.c.m().c()).b(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        jSONObjectB.put("crashinfo", str);
        return jSONObjectB;
    }

    private static boolean c(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null && stackTraceElementArr.length != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (stackTraceElement != null && !TextUtils.isEmpty(stackTraceElement.toString())) {
                        String string = stackTraceElement.toString();
                        if (TextUtils.isEmpty(string) || (!string.contains(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && !string.contains("com.google") && !string.contains("java.lang") && !string.contains(MBridgeConstans.APPLICATION_STACK_ANDROID_OS) && !string.contains(MBridgeConstans.APPLICATION_STACK_ANDROID_APP))) {
                            arrayList.add(string);
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    return false;
                }
                return d((String) arrayList.get(0));
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("AnrMonitorManager", "isMBridgeFirst exception", e11);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (String str2 : d.a(d.a())) {
                if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
