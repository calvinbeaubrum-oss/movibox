package com.alibaba.android.arouter.facade.template;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public interface ILogger {
    public static final String defaultTag = "ARouter::";
    public static final boolean isShowLog = false;
    public static final boolean isShowStackTrace = false;

    void debug(String str, String str2);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th2);

    String getDefaultTag();

    void info(String str, String str2);

    boolean isMonitorMode();

    void monitor(String str);

    void showLog(boolean z11);

    void showStackTrace(boolean z11);

    void warning(String str, String str2);
}
