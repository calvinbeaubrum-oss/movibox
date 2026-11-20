package com.cloud.tupdate.utils;

import android.text.TextUtils;
import com.transsion.core.log.ObjectLogUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ObjectLogUtils f32236d = new ObjectLogUtils.a().p("UPDATE_N").q(false).n(false).m();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f32237e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObjectLogUtils f32239b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32238a = "UPDATE_S";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f32240c = 2;

    public c() {
        ObjectLogUtils objectLogUtilsM = new ObjectLogUtils.a().p("UPDATE").r(true).n(false).m();
        this.f32239b = objectLogUtilsM;
        objectLogUtilsM.x(3);
    }

    public static void g(String str) {
        f32236d.n(str);
    }

    public void a(String str) {
        e(6, "", "******" + str + "******");
    }

    public void b(String str, String str2) {
        e(6, str, "******" + str2 + "******");
    }

    public String c() {
        throw null;
    }

    public void d(String str, String str2) {
        e(4, str, str2);
    }

    public void e(int i11, String str, String str2) {
        f(i11, str, str2, null);
    }

    public void f(int i11, String str, String str2, Throwable th2) {
        try {
            if (i(i11)) {
                if (!TextUtils.isEmpty(str)) {
                    str = c() + "_" + str;
                }
                if (i11 == 2) {
                    if (th2 != null) {
                        this.f32239b.y(str, str2, th2);
                        return;
                    } else {
                        this.f32239b.y(str, str2);
                        return;
                    }
                }
                if (i11 == 3) {
                    if (th2 != null) {
                        this.f32239b.h(str, str2, th2);
                        return;
                    } else {
                        this.f32239b.h(str, str2);
                        return;
                    }
                }
                if (i11 == 4) {
                    if (th2 != null) {
                        this.f32239b.o(str, str2, th2);
                        return;
                    } else {
                        this.f32239b.o(str, str2);
                        return;
                    }
                }
                if (i11 == 5) {
                    if (th2 != null) {
                        this.f32239b.A(str, str2, th2);
                        return;
                    } else {
                        this.f32239b.A(str, str2);
                        return;
                    }
                }
                if (i11 != 6) {
                    if (i11 != 9) {
                        return;
                    }
                    this.f32239b.q(str, str2);
                } else if (th2 != null) {
                    this.f32239b.j(str, str2, th2);
                } else {
                    this.f32239b.j(str, str2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void h(boolean z11) {
        this.f32239b.m().r(z11);
    }

    public final boolean i(int i11) {
        return i11 >= 2;
    }
}
