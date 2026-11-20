package com.bytedance.adsdk.pFF;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Tf<V> {
    private final Throwable pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final V f26158sc;

    public Tf(V v11) {
        this.f26158sc = v11;
        this.pFF = null;
    }

    public Tf(Throwable th2) {
        this.pFF = th2;
        this.f26158sc = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tf)) {
            return false;
        }
        Tf tf2 = (Tf) obj;
        if (sc() != null && sc().equals(tf2.sc())) {
            return true;
        }
        if (pFF() == null || tf2.pFF() == null) {
            return false;
        }
        return pFF().toString().equals(pFF().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{sc(), pFF()});
    }

    public Throwable pFF() {
        return this.pFF;
    }

    public V sc() {
        return this.f26158sc;
    }
}
