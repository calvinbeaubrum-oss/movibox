package com.bytedance.adsdk.pFF.zY.pFF;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    private final int[] pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final float[] f26250sc;

    public We(float[] fArr, int[] iArr) {
        this.f26250sc = fArr;
        this.pFF = iArr;
    }

    private int sc(float f11) {
        int iBinarySearch = Arrays.binarySearch(this.f26250sc, f11);
        if (iBinarySearch >= 0) {
            return this.pFF[iBinarySearch];
        }
        int i11 = -(iBinarySearch + 1);
        if (i11 == 0) {
            return this.pFF[0];
        }
        int[] iArr = this.pFF;
        if (i11 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f26250sc;
        int i12 = i11 - 1;
        float f12 = fArr[i12];
        return com.bytedance.adsdk.pFF.TRI.pFF.sc((f11 - f12) / (fArr[i11] - f12), iArr[i12], iArr[i11]);
    }

    public int[] pFF() {
        return this.pFF;
    }

    public We sc(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i11 = 0; i11 < fArr.length; i11++) {
            iArr[i11] = sc(fArr[i11]);
        }
        return new We(fArr, iArr);
    }

    public void sc(We we2, We we3, float f11) {
        if (we2.pFF.length == we3.pFF.length) {
            for (int i11 = 0; i11 < we2.pFF.length; i11++) {
                this.f26250sc[i11] = com.bytedance.adsdk.pFF.TRI.ExN.sc(we2.f26250sc[i11], we3.f26250sc[i11], f11);
                this.pFF[i11] = com.bytedance.adsdk.pFF.TRI.pFF.sc(f11, we2.pFF[i11], we3.pFF[i11]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + we2.pFF.length + " vs " + we3.pFF.length + ")");
    }

    public float[] sc() {
        return this.f26250sc;
    }

    public int zY() {
        return this.pFF.length;
    }
}
