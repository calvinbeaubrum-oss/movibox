package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum ExN {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);

    private final int WH;

    ExN(int i11) {
        this.WH = i11;
    }

    public int sc() {
        return this.WH;
    }
}
