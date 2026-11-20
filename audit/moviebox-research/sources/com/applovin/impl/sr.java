package com.applovin.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WebView f23125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f23126b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f23129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f23130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f23131g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f23127c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f23128d = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicBoolean f23132h = new AtomicBoolean();

    static {
        if (e()) {
            f23126b = (String) vj.a(uj.J, "", com.applovin.impl.sdk.j.l());
            return;
        }
        f23126b = "";
        vj.b(uj.J, (Object) null, com.applovin.impl.sdk.j.l());
        vj.b(uj.K, (Object) null, com.applovin.impl.sdk.j.l());
    }

    public static String a() {
        String str;
        synchronized (f23127c) {
            str = f23126b;
        }
        return str;
    }

    public static void a(final com.applovin.impl.sdk.j jVar) {
        if (e() || f23128d.getAndSet(true)) {
            return;
        }
        if (z3.d()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.s50
                @Override // java.lang.Runnable
                public final void run() {
                    sr.d(jVar);
                }
            });
        } else {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.t50
                @Override // java.lang.Runnable
                public final void run() {
                    sr.e(jVar);
                }
            });
        }
    }

    public static String b() {
        return f23131g;
    }

    public static void b(com.applovin.impl.sdk.j jVar) {
        if (f23132h.getAndSet(true)) {
            return;
        }
        PackageInfo packageInfoC = c(jVar);
        if (packageInfoC != null) {
            f23129e = packageInfoC.versionCode;
            f23130f = packageInfoC.versionName;
            f23131g = packageInfoC.packageName;
        } else {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("WebViewDataCollector", "Failed to get WebView package info");
            }
        }
    }

    private static PackageInfo c(com.applovin.impl.sdk.j jVar) {
        PackageManager packageManager = com.applovin.impl.sdk.j.l().getPackageManager();
        if (z3.i()) {
            return WebView.getCurrentWebViewPackage();
        }
        Iterator it = jVar.c(sj.f23105y4).iterator();
        while (it.hasNext()) {
            try {
                return packageManager.getPackageInfo((String) it.next(), 0);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String c() {
        return f23130f;
    }

    public static int d() {
        return f23129e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0028 */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void d(com.applovin.impl.sdk.j jVar) {
        synchronized (f23127c) {
            try {
                f23126b = WebSettings.getDefaultUserAgent(com.applovin.impl.sdk.j.l());
                vj.b(uj.J, f23126b, com.applovin.impl.sdk.j.l());
                vj.b(uj.K, Build.VERSION.RELEASE, com.applovin.impl.sdk.j.l());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Bottom block not found for handler: all -> 0x002d */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void e(com.applovin.impl.sdk.j jVar) {
        f(jVar);
        synchronized (f23127c) {
            try {
                f23126b = f23125a.getSettings().getUserAgentString();
                vj.b(uj.J, f23126b, com.applovin.impl.sdk.j.l());
                vj.b(uj.K, Build.VERSION.RELEASE, com.applovin.impl.sdk.j.l());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean e() {
        boolean zEquals;
        synchronized (f23127c) {
            zEquals = Build.VERSION.RELEASE.equals((String) vj.a(uj.K, "", com.applovin.impl.sdk.j.l()));
        }
        return zEquals;
    }

    public static void f(com.applovin.impl.sdk.j jVar) {
    }
}
