package com.danikula.videocache;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ProxyCacheException extends Exception {
    public ProxyCacheException(String str) {
        super(str);
    }

    public ProxyCacheException(String str, Throwable th2) {
        super(str, th2);
    }

    public ProxyCacheException(Throwable th2) {
        super("No explanation error", th2);
    }
}
