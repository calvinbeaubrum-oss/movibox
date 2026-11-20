package com.vungle.warren;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.AppMeasurement;
import com.vungle.warren.log.LogManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class VungleLogger {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final VungleLogger f61879c = new VungleLogger();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoggerLevel f61880a = LoggerLevel.DEBUG;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LogManager f61881b;

    /* JADX INFO: compiled from: source.java */
    @Keep
    public enum LoggerLevel {
        VERBOSE(0, "verbose"),
        DEBUG(1, "debug"),
        INFO(2, "info"),
        WARNING(3, "warn"),
        ERROR(4, "error"),
        CRASH(5, AppMeasurement.CRASH_ORIGIN);

        private int level;
        private String levelString;

        LoggerLevel(int i11, String str) {
            this.level = i11;
            this.levelString = str;
        }

        @Override // java.lang.Enum
        @NonNull
        public String toString() {
            return this.levelString;
        }
    }

    public static void a(boolean z11, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (z11) {
            Log.e(str, "[" + str2 + "] " + str3);
        }
        c(str2, str3);
    }

    public static void b(@NonNull String str, @NonNull String str2) {
        f(LoggerLevel.DEBUG, str, str2);
    }

    public static void c(@NonNull String str, @NonNull String str2) {
        f(LoggerLevel.ERROR, str, str2);
    }

    public static void d(boolean z11, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (z11) {
            Log.e(str, "[" + str2 + "] " + str3);
        }
        c(str2, str3);
    }

    public static boolean e(@NonNull LoggerLevel loggerLevel) {
        return loggerLevel.level >= f61879c.f61880a.level;
    }

    public static void f(@NonNull LoggerLevel loggerLevel, @NonNull String str, @NonNull String str2) {
        VungleLogger vungleLogger = f61879c;
        LogManager logManager = vungleLogger.f61881b;
        if (logManager != null && logManager.h() && e(loggerLevel)) {
            vungleLogger.f61881b.i(loggerLevel, str, str2, null, null);
        }
    }

    public static void g(@NonNull LogManager logManager, @NonNull LoggerLevel loggerLevel, int i11) {
        VungleLogger vungleLogger = f61879c;
        vungleLogger.f61880a = loggerLevel;
        vungleLogger.f61881b = logManager;
        logManager.n(i11);
    }

    public static void h(@NonNull String str, @NonNull String str2) {
        f(LoggerLevel.VERBOSE, str, str2);
    }

    public static void i(boolean z11, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (z11) {
            Log.v(str, "[" + str2 + "] " + str3);
        }
        h(str2, str3);
    }

    public static void j(@NonNull String str, @NonNull String str2) {
        f(LoggerLevel.WARNING, str, str2);
    }

    public static void k(boolean z11, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (z11) {
            Log.w(str, "[" + str2 + "] " + str3);
        }
        j(str2, str3);
    }
}
