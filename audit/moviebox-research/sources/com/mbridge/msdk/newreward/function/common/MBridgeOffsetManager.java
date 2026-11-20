package com.mbridge.msdk.newreward.function.common;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeOffsetManager {
    private int offset = 0;

    public int getOffset() {
        return Math.max(this.offset, 0);
    }

    public void increaseOffset(int i11) {
        this.offset += i11;
    }

    public void resetOffset() {
        this.offset = 0;
    }
}
