package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j0 {
    public static boolean A() {
        return l0.a();
    }

    public static boolean B() {
        return a0.j();
    }

    public static boolean C(String str) {
        return g0.d(str);
    }

    public static View D(int i11) {
        return l0.b(i11);
    }

    public static void E() {
        F(AdaptScreenUtils.f());
    }

    public static void F(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            ThreadUtils.d().execute(runnable);
        }
    }

    public static void G(Utils.a aVar) {
        UtilsActivityLifecycleImpl.f25290h.u(aVar);
    }

    public static void H(Runnable runnable) {
        ThreadUtils.j(runnable);
    }

    public static void I(Runnable runnable, long j11) {
        ThreadUtils.k(runnable, j11);
    }

    public static void J(Application application) {
        UtilsActivityLifecycleImpl.f25290h.y(application);
    }

    public static Bitmap K(View view) {
        return ImageUtils.h(view);
    }

    public static void a(Utils.a aVar) {
        UtilsActivityLifecycleImpl.f25290h.e(aVar);
    }

    public static String b(byte[] bArr) {
        return i.c(bArr);
    }

    public static boolean c(File file) {
        return m.d(file);
    }

    public static int d(float f11) {
        return f0.a(f11);
    }

    public static boolean e(CharSequence charSequence, CharSequence charSequence2) {
        return g0.a(charSequence, charSequence2);
    }

    public static void f(Activity activity) {
        KeyboardUtils.a(activity);
    }

    public static String g(@Nullable String str, Object... objArr) {
        return g0.c(str, objArr);
    }

    public static List<Activity> h() {
        return UtilsActivityLifecycleImpl.f25290h.j();
    }

    public static int i() {
        return d0.b();
    }

    public static Application j() {
        return UtilsActivityLifecycleImpl.f25290h.n();
    }

    public static String k() {
        return y.a();
    }

    public static File l(String str) {
        return m.h(str);
    }

    public static long m(String str) {
        return m.l(str);
    }

    public static long n(String str) {
        return m.m(str);
    }

    public static Intent o(String str, boolean z11) {
        return o.b(str, z11);
    }

    public static int p() {
        return d.a();
    }

    public static Notification q(t.a aVar, Utils.b<NotificationCompat.m> bVar) {
        return t.a(aVar, bVar);
    }

    public static c0 r() {
        return c0.a("Utils");
    }

    public static int s() {
        return d.c();
    }

    public static Activity t() {
        return UtilsActivityLifecycleImpl.f25290h.o();
    }

    public static void u(Application application) {
        UtilsActivityLifecycleImpl.f25290h.p(application);
    }

    public static boolean v(Activity activity) {
        return a.c(activity);
    }

    public static boolean w() {
        return UtilsActivityLifecycleImpl.f25290h.q();
    }

    public static boolean x(File file) {
        return m.o(file);
    }

    @RequiresApi(api = 23)
    public static boolean y() {
        return PermissionUtils.t();
    }

    public static boolean z(Intent intent) {
        return o.c(intent);
    }
}
