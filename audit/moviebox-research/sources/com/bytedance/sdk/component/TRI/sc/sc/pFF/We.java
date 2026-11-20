package com.bytedance.sdk.component.TRI.sc.sc.pFF;

import com.bytedance.sdk.component.TRI.sc.We.sc;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class We<T extends com.bytedance.sdk.component.TRI.sc.We.sc> {
    private String We;
    private Queue<T> pFF = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc f26635sc;
    private Queue<String> zY;

    public We(com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar, Queue<String> queue, String str) {
        this.f26635sc = scVar;
        this.zY = queue;
        this.We = str;
    }

    public synchronized boolean pFF(int i11, int i12) {
        int size = this.pFF.size();
        int iSc = this.f26635sc.sc();
        if (i11 != 2 && i11 != 1) {
            return size >= iSc;
        }
        if (com.bytedance.sdk.component.TRI.sc.zY.sc.zY()) {
            return size > 0;
        }
        return size >= iSc;
    }

    public synchronized List<com.bytedance.sdk.component.TRI.sc.We.sc> sc(int i11, int i12) {
        if (!pFF(i11, i12)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f26635sc.sc());
        do {
            T tPoll = this.pFF.poll();
            if (tPoll == null) {
                break;
            }
            arrayList.add(tPoll);
        } while (arrayList.size() != this.f26635sc.pFF());
        return arrayList;
    }

    public synchronized void sc(int i11, List<T> list) {
        try {
            if (i11 == -1 || i11 == 200 || i11 == 509) {
                this.pFF.size();
            } else {
                this.pFF.addAll(list);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void sc(T t11) {
        Queue<T> queue = this.pFF;
        if (queue == null || t11 == null) {
            return;
        }
        queue.offer(t11);
    }
}
