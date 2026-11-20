package lc;

import lc.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d<T extends d<T>> {
    public boolean equals(Object obj) {
        return (obj instanceof d) && obj.hashCode() == hashCode();
    }

    public int hashCode() {
        return super.hashCode();
    }
}
