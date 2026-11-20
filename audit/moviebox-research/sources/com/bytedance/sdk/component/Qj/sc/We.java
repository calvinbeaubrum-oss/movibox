package com.bytedance.sdk.component.Qj.sc;

import com.bytedance.sdk.component.Qj.sc.zY;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We<T extends zY> {
    private BlockingQueue<T> pFF = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26567sc;

    private We(int i11) {
        this.f26567sc = i11;
    }

    public static We sc(int i11) {
        return new We(i11);
    }

    public T sc() {
        return this.pFF.poll();
    }

    public boolean sc(T t11) {
        if (t11 == null) {
            return false;
        }
        t11.sc();
        if (this.pFF.size() >= this.f26567sc) {
            return false;
        }
        return this.pFF.offer(t11);
    }
}
