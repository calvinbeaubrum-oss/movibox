package com.quickjs;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class QuickJSException extends RuntimeException {
    private String name;

    public QuickJSException(String str, String str2) {
        super(str + "," + str2);
        this.name = str;
    }

    public QuickJSException(String str, Throwable th2) {
        super(str, th2);
    }

    public QuickJSException(Throwable th2) {
        super(th2);
    }

    public String getName() {
        return this.name;
    }
}
