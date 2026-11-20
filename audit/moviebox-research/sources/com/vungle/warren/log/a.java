package com.vungle.warren.log;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.AppMeasurement;
import com.vungle.warren.VungleLogger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LogManager.b f62074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f62075c = LogManager.f62057o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f62073a = Thread.getDefaultUncaughtExceptionHandler();

    public a(@NonNull LogManager.b bVar) {
        this.f62074b = bVar;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void a(@NonNull String str) {
        this.f62075c = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        if (this.f62074b.b() && thread != null && th2 != null) {
            boolean z11 = false;
            for (Throwable cause = th2; cause != null; cause = cause.getCause()) {
                for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                    if (stackTraceElement.getClassName().startsWith(this.f62075c)) {
                        z11 = true;
                        break;
                    }
                }
            }
            if (z11) {
                this.f62074b.c(VungleLogger.LoggerLevel.CRASH, AppMeasurement.CRASH_ORIGIN, Log.getStackTraceString(th2), th2.getClass().toString(), String.valueOf(thread.getId()));
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f62073a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }
}
