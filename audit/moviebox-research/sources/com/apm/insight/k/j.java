package com.apm.insight.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.apm.insight.runtime.n;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f16925a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f16926b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f16927c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, String> f16928d;

    public static void a(String str) {
        if (f16928d == null) {
            f16928d = new HashMap();
        }
        f16928d.put(str, String.valueOf(System.currentTimeMillis()));
    }

    public static void a(JSONArray jSONArray) {
        try {
            com.apm.insight.l.f.a(new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/configCrash/configFile"), jSONArray);
        } catch (IOException unused) {
        }
        try {
            com.apm.insight.l.f.a(h(), f16928d);
        } catch (Throwable unused2) {
        }
    }

    public static boolean a() {
        return f16926b;
    }

    public static boolean b() {
        return f16927c;
    }

    public static void c() {
        if (f16926b) {
            return;
        }
        f16927c = true;
        File file = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/configCrash/configFile");
        if (file.exists()) {
            try {
                com.apm.insight.runtime.a.a(new JSONArray(com.apm.insight.l.f.a(file, "\n")), false);
                f16926b = true;
            } catch (Throwable unused) {
                com.apm.insight.runtime.a.a((JSONArray) null, false);
            }
        }
    }

    public static void d() {
        c();
        if (g()) {
            a.a();
        }
    }

    public static void e() {
        n.a().a(new Runnable() { // from class: com.apm.insight.k.j.1
            @Override // java.lang.Runnable
            public final void run() {
                if (j.g()) {
                    a.a();
                }
            }
        });
    }

    public static void f() {
        Map<String, String> map = f16928d;
        if (map != null) {
            map.clear();
        }
    }

    public static boolean g() {
        File fileH = h();
        try {
            Map<String, String> mapC = f16928d;
            if (mapC == null) {
                mapC = com.apm.insight.l.f.c(fileH);
            }
            f16928d = mapC;
            if (mapC == null) {
                f16928d = new HashMap();
                return true;
            }
            if (mapC.size() < com.apm.insight.entity.b.c()) {
                return true;
            }
            Iterator<String> it = com.apm.insight.entity.b.d().iterator();
            while (it.hasNext()) {
                if (!f16928d.containsKey(it.next())) {
                    return true;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z11 = false;
            for (Map.Entry<String, String> entry : f16928d.entrySet()) {
                try {
                    long jLongValue = Long.decode(entry.getValue()).longValue();
                    if (jCurrentTimeMillis - jLongValue > com.apm.insight.runtime.d.d(entry.getKey())) {
                        z11 = true;
                    }
                } catch (Throwable th2) {
                    com.apm.insight.a.a(th2);
                }
            }
            if (z11) {
                com.apm.insight.a.a((Object) "config should be updated");
            } else {
                com.apm.insight.a.a((Object) "config should not be updated");
            }
            return z11;
        } catch (Throwable th3) {
            Log.e("npth", NotificationCompat.CATEGORY_ERROR, th3);
            return true;
        }
    }

    @NonNull
    private static File h() {
        if (f16925a == null) {
            f16925a = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/configCrash/configInvalid");
        }
        return f16925a;
    }
}
