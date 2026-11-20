package com.alibaba.fastjson;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import n7.j1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j1 f15479a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f15479a.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f15479a.flush();
    }
}
