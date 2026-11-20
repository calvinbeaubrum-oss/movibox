package com.google.common.collect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    BoundType(boolean z11) {
        this.inclusive = z11;
    }

    public static BoundType forBoolean(boolean z11) {
        return z11 ? CLOSED : OPEN;
    }
}
