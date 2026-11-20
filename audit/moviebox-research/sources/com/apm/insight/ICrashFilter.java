package com.apm.insight;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ICrashFilter {
    boolean onJavaCrashFilter(Throwable th2, Thread thread);

    boolean onNativeCrashFilter(String str, String str2);
}
