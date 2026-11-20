package com.transsion.transfer.androidasync.util;

import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class TaggedList<T> extends ArrayList<T> {
    private Object tag;

    public synchronized <V> V tag() {
        return (V) this.tag;
    }

    public synchronized <V> void tag(V v11) {
        this.tag = v11;
    }

    public synchronized <V> void tagNull(V v11) {
        if (this.tag == null) {
            this.tag = v11;
        }
    }
}
