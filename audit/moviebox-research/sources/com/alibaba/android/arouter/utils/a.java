package com.alibaba.android.arouter.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.facade.template.ILogger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements ILogger {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f15378b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f15379c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f15380d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15381a;

    public a(String str) {
        this.f15381a = str;
    }

    public static String a(StackTraceElement stackTraceElement) {
        if (!f15379c) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder("[");
        String name = Thread.currentThread().getName();
        String fileName = stackTraceElement.getFileName();
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        long id2 = Thread.currentThread().getId();
        int lineNumber = stackTraceElement.getLineNumber();
        sb2.append("ThreadId=");
        sb2.append(id2);
        sb2.append(" & ");
        sb2.append("ThreadName=");
        sb2.append(name);
        sb2.append(" & ");
        sb2.append("FileName=");
        sb2.append(fileName);
        sb2.append(" & ");
        sb2.append("ClassName=");
        sb2.append(className);
        sb2.append(" & ");
        sb2.append("MethodName=");
        sb2.append(methodName);
        sb2.append(" & ");
        sb2.append("LineNumber=");
        sb2.append(lineNumber);
        sb2.append(" ] ");
        return sb2.toString();
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void debug(String str, String str2) {
        if (f15378b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                getDefaultTag();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void error(String str, String str2) {
        if (f15378b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.e(str, str2 + a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void error(String str, String str2, Throwable th2) {
        if (f15378b) {
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.e(str, str2, th2);
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public String getDefaultTag() {
        return this.f15381a;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void info(String str, String str2) {
        if (f15378b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                getDefaultTag();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public boolean isMonitorMode() {
        return f15380d;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void monitor(String str) {
        if (f15378b && isMonitorMode()) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f15381a);
            sb2.append("::monitor");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void showLog(boolean z11) {
        f15378b = z11;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void showStackTrace(boolean z11) {
        f15379c = z11;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void warning(String str, String str2) {
        if (f15378b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.w(str, str2 + a(stackTraceElement));
        }
    }
}
