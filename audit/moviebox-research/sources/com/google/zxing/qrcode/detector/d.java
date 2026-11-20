package com.google.zxing.qrcode.detector;

import com.google.zxing.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f41575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41576d;

    public d(float f11, float f12, float f13) {
        this(f11, f12, f13, 1);
    }

    public d(float f11, float f12, float f13, int i11) {
        super(f11, f12);
        this.f41575c = f13;
        this.f41576d = i11;
    }

    public boolean f(float f11, float f12, float f13) {
        if (Math.abs(f12 - d()) > f11 || Math.abs(f13 - c()) > f11) {
            return false;
        }
        float fAbs = Math.abs(f11 - this.f41575c);
        return fAbs <= 1.0f || fAbs <= this.f41575c;
    }

    public d g(float f11, float f12, float f13) {
        int i11 = this.f41576d;
        int i12 = i11 + 1;
        float fC = (i11 * c()) + f12;
        float f14 = i12;
        return new d(fC / f14, ((this.f41576d * d()) + f11) / f14, ((this.f41576d * this.f41575c) + f13) / f14, i12);
    }

    public int h() {
        return this.f41576d;
    }

    public float i() {
        return this.f41575c;
    }
}
