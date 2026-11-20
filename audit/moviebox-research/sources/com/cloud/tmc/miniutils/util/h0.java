package com.cloud.tmc.miniutils.util;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f31994a = new Handler(Looper.getMainLooper());

    public static File A(Uri uri) {
        return d0.d(uri);
    }

    public static boolean B(String str, InputStream inputStream) {
        return i.g(str, inputStream);
    }

    public static String b(byte[] bArr) {
        return e.b(bArr);
    }

    public static boolean c(File file) {
        return j.g(file);
    }

    public static boolean d(File file) {
        return j.k(file);
    }

    public static boolean e(CharSequence charSequence, CharSequence charSequence2) {
        return y.a(charSequence, charSequence2);
    }

    public static void f(Activity activity) {
        p.a(activity);
    }

    public static List<Activity> g() {
        return UtilsActivityLifecycleImpl.f31975h.h();
    }

    public static Application h() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return UtilsActivityLifecycleImpl.f31975h.l();
        }
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cloud.tmc.miniutils.util.g0
                @Override // java.lang.Runnable
                public final void run() {
                    h0.v(atomicReference, countDownLatch);
                }
            });
            if (countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                Log.e("UtilsBridge", "getApplicationByReflect: get app by reflection");
                return (Application) atomicReference.get();
            }
        } catch (InterruptedException e11) {
            Log.e("UtilsBridge", "getApplicationByReflect: ", e11);
            Thread.currentThread().interrupt();
        } catch (Throwable th2) {
            Log.e("UtilsBridge", "getApplicationByReflect: ", th2);
        }
        return (Application) atomicReference.get();
    }

    public static File i(String str) {
        return j.r(str);
    }

    public static long j(String str) {
        return j.t(str);
    }

    public static long k(String str) {
        return j.u(str);
    }

    public static Intent l(String str, boolean z11) {
        return n.b(str, z11);
    }

    public static Activity m() {
        return UtilsActivityLifecycleImpl.f31975h.m();
    }

    public static void n(Application application) {
        try {
            if (t.e()) {
                UtilsActivityLifecycleImpl.f31975h.n(application);
            }
        } catch (Throwable th2) {
            Log.e("UtilsBridge", "init: " + th2);
        }
    }

    public static byte[] o(InputStream inputStream) {
        return e.e(inputStream);
    }

    public static boolean p(Activity activity) {
        return a.d(activity);
    }

    public static boolean q(File file) {
        return j.z(file);
    }

    public static boolean r(String... strArr) {
        return PermissionUtils.s(strArr);
    }

    public static boolean s(Intent intent) {
        return n.c(intent);
    }

    public static boolean t() {
        return v.f();
    }

    public static boolean u(String str) {
        return y.e(str);
    }

    public static /* synthetic */ void v(AtomicReference atomicReference, CountDownLatch countDownLatch) {
        atomicReference.set(UtilsActivityLifecycleImpl.f31975h.l());
        countDownLatch.countDown();
    }

    public static void w(File file) {
        j.I(file);
    }

    public static void x(Runnable runnable) {
        f31994a.post(runnable);
    }

    public static void y(Runnable runnable, long j11) {
        f31994a.postDelayed(runnable, j11);
    }

    public static void z(Application application) {
        try {
            if (t.e()) {
                UtilsActivityLifecycleImpl.f31975h.t(application);
            }
        } catch (Throwable th2) {
            Log.e("UtilsBridge", "unInit: " + th2);
        }
    }
}
