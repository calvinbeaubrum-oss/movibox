package com.applovin.impl;

import android.opengl.Matrix;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class k9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f20191a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f20192b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final eo f20193c = new eo();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20194d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f11 = fArr2[10];
        float f12 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f11 * f11) + (f12 * f12));
        float f13 = fArr2[10] / fSqrt;
        fArr[0] = f13;
        float f14 = fArr2[8];
        fArr[2] = f14 / fSqrt;
        fArr[8] = (-f14) / fSqrt;
        fArr[10] = f13;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f11 = fArr2[0];
        float f12 = -fArr2[1];
        float f13 = -fArr2[2];
        float length = Matrix.length(f11, f12, f13);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f11 / length, f12 / length, f13 / length);
        } else {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public void a() {
        this.f20193c.a();
        this.f20194d = false;
    }

    public void a(long j11, float[] fArr) {
        this.f20193c.a(j11, fArr);
    }

    public boolean a(float[] fArr, long j11) {
        float[] fArr2 = (float[]) this.f20193c.c(j11);
        if (fArr2 == null) {
            return false;
        }
        b(this.f20192b, fArr2);
        if (!this.f20194d) {
            a(this.f20191a, this.f20192b);
            this.f20194d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f20191a, 0, this.f20192b, 0);
        return true;
    }
}
