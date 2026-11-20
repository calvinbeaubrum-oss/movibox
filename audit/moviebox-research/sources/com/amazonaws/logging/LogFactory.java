package com.amazonaws.logging;

import com.google.android.gms.common.api.Api;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class LogFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f15765a = "LogFactory";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Log> f15766b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Level f15767c = null;

    /* JADX INFO: compiled from: source.java */
    public enum Level {
        ALL(Integer.MIN_VALUE),
        TRACE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
        OFF(Api.BaseClientBuilder.API_PRIORITY_OTHER);

        private final int value;

        Level(int i11) {
            this.value = i11;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static Level a() {
        return f15767c;
    }

    public static synchronized Log b(Class<?> cls) {
        return c(d(cls.getSimpleName()));
    }

    public static synchronized Log c(String str) {
        try {
            String strD = d(str);
            Map<String, Log> map = f15766b;
            Log log = map.get(strD);
            if (log != null) {
                return log;
            }
            Log consoleLog = Environment.a() ? new ConsoleLog(strD) : new AndroidLog(strD);
            map.put(strD, consoleLog);
            return consoleLog;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static String d(String str) {
        if (str.length() <= 23) {
            return str;
        }
        c(f15765a).j("Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
        return str.substring(0, 23);
    }
}
