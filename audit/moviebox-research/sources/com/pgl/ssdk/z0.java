package com.pgl.ssdk;

import com.pgl.ssdk.y0;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class z0<T extends y0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f48869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BlockingQueue<T> f48870b = new LinkedBlockingQueue();

    private z0(int i11) {
        this.f48869a = i11;
    }

    public static z0 a(int i11) {
        return new z0(i11);
    }

    public T a() {
        return this.f48870b.poll();
    }
}
