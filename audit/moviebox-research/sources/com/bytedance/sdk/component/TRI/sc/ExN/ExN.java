package com.bytedance.sdk.component.TRI.sc.ExN;

import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ExN implements Comparable<ExN>, Runnable {
    private String zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26583sc = 5;
    private String pFF = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public ExN(String str) {
        this.zY = str;
    }

    public int sc() {
        return this.f26583sc;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public int compareTo(ExN exN) {
        if (sc() < exN.sc()) {
            return 1;
        }
        return sc() >= exN.sc() ? -1 : 0;
    }

    public void sc(int i11) {
        this.f26583sc = i11;
    }
}
