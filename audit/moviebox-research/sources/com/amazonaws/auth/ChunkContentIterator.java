package com.amazonaws.auth;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class ChunkContentIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f15690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15691b;

    public ChunkContentIterator(byte[] bArr) {
        this.f15690a = bArr;
    }

    public boolean a() {
        return this.f15691b < this.f15690a.length;
    }

    public int b(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        if (!a()) {
            return -1;
        }
        int iMin = Math.min(this.f15690a.length - this.f15691b, i12);
        System.arraycopy(this.f15690a, this.f15691b, bArr, i11, iMin);
        this.f15691b += iMin;
        return iMin;
    }
}
