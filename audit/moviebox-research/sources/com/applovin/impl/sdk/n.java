package com.applovin.impl.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.qc;
import com.applovin.impl.sj;
import com.applovin.impl.z3;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f22669b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22670a;

    public n(j jVar) {
        this.f22670a = jVar;
        a("SDK Session Begin");
    }

    private void a(String str) {
        qc qcVar = new qc();
        qcVar.a().a(str).a();
        g("AppLovinSdk", qcVar.toString());
    }

    public static void a(boolean z11) {
        f22669b = z11;
    }

    public static boolean a() {
        return a(j.f22563v0);
    }

    public static boolean a(j jVar) {
        return jVar != null && jVar.h0().c();
    }

    public static void b(String str, String str2, Throwable th2) {
        j jVar = j.f22563v0;
        if (jVar == null) {
            return;
        }
        jVar.J();
        if (a()) {
            j.f22563v0.J().a(str, str2, th2);
        }
    }

    public static void c(String str, String str2) {
        b(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th2) {
        if (!f22669b || a()) {
            Log.e("AppLovinSdk", "[" + str + "] " + str2, th2);
        }
    }

    public static void e(String str, String str2) {
        g(str, str2);
    }

    public static void g(String str, String str2) {
        if (!f22669b || a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(str);
            sb2.append("] ");
            sb2.append(str2);
        }
    }

    public static void h(String str, String str2) {
        c(str, str2, null);
    }

    public static void i(String str, String str2) {
        if (!f22669b || a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(str);
            sb2.append("] ");
            sb2.append(str2);
        }
    }

    public static void j(String str, String str2) {
        if (!f22669b || a()) {
            Log.w("AppLovinSdk", "[" + str + "] " + str2);
        }
    }

    public static void l(String str, String str2) {
        j jVar = j.f22563v0;
        if (jVar == null) {
            return;
        }
        jVar.J();
        if (a()) {
            j.f22563v0.J().k(str, str2);
        }
    }

    public void a(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(str);
        sb2.append("] ");
        sb2.append(str2);
    }

    public void a(String str, String str2, Throwable th2) {
        Log.e("AppLovinSdk", "[" + str + "] " + str2, th2);
    }

    public void a(String str, Throwable th2) {
        if (z3.e()) {
            for (Throwable th3 : th2.getSuppressed()) {
                b(str, th3.toString());
            }
        }
    }

    public void b(String str, String str2) {
        a(str, str2, null);
    }

    public void d(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(str);
        sb2.append("] ");
        sb2.append(str2);
    }

    public void d(String str, String str2, Throwable th2) {
        Log.w("AppLovinSdk", "[" + str + "] " + str2, th2);
    }

    public void f(String str, String str2) {
        int iIntValue;
        if (a(this.f22670a) && !TextUtils.isEmpty(str2) && (iIntValue = ((Integer) this.f22670a.a(sj.f23060t)).intValue()) > 0) {
            int length = str2.length();
            int i11 = ((length + iIntValue) - 1) / iIntValue;
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = i12 * iIntValue;
                a(str, str2.substring(i13, Math.min(length, i13 + iIntValue)));
            }
        }
    }

    public void k(String str, String str2) {
        d(str, str2, null);
    }
}
