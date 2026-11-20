package com.mbridge.msdk.out;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public enum ZoomOutTypeEnum {
    FloatBall(1),
    BigView(4),
    MediumView(3),
    SmallView(2);

    private int index;

    ZoomOutTypeEnum(int i11) {
        this.index = i11;
    }

    public final int getIndex() {
        return this.index;
    }
}
