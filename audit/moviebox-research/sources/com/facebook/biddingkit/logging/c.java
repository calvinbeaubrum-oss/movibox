package com.facebook.biddingkit.logging;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f32464a;

    public c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f32464a = uncaughtExceptionHandler;
    }

    public static void b() {
        Thread.setDefaultUncaughtExceptionHandler(new c(Thread.getDefaultUncaughtExceptionHandler()));
    }

    @SuppressLint({"CatchGeneralException"})
    public static void c() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
        try {
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }

    public final void a(Thread thread, Throwable th2) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f32464a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        } else {
            c();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    @SuppressLint({"CatchGeneralException"})
    public void uncaughtException(Thread thread, Throwable th2) {
        try {
            String strA = g.a(th2);
            if (!TextUtils.isEmpty(strA) && strA.contains("com.facebook.biddingkit")) {
                b.c("CrashReportHandler", strA);
            }
        } catch (Exception unused) {
        }
        a(thread, th2);
    }
}
