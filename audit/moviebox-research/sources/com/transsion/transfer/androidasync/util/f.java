package com.transsion.transfer.androidasync.util;

import java.util.Hashtable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable<String, Object> f58878a = new Hashtable<>();

    public <T> T a(String str) {
        return (T) this.f58878a.get(str);
    }

    public void b(String str, Object obj) {
        this.f58878a.put(str, obj);
    }
}
