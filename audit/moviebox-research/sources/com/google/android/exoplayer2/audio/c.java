package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m1;
import com.google.logging.type.LogSeverity;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f32800a = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, LogSeverity.EMERGENCY_VALUE, LogSeverity.EMERGENCY_VALUE, 480, LogSeverity.WARNING_VALUE, LogSeverity.WARNING_VALUE, 2048};

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32803c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f32804d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f32805e;

        public b(int i11, int i12, int i13, int i14, int i15) {
            this.f32801a = i11;
            this.f32803c = i12;
            this.f32802b = i13;
            this.f32804d = i14;
            this.f32805e = i15;
        }
    }

    public static void a(int i11, com.google.android.exoplayer2.util.c0 c0Var) {
        c0Var.L(7);
        byte[] bArrD = c0Var.d();
        bArrD[0] = -84;
        bArrD[1] = 64;
        bArrD[2] = -1;
        bArrD[3] = -1;
        bArrD[4] = (byte) ((i11 >> 16) & 255);
        bArrD[5] = (byte) ((i11 >> 8) & 255);
        bArrD[6] = (byte) (i11 & 255);
    }

    public static m1 b(com.google.android.exoplayer2.util.c0 c0Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        c0Var.Q(1);
        return new m1.b().S(str).e0("audio/ac4").H(2).f0(((c0Var.D() & 32) >> 5) == 1 ? 48000 : 44100).M(drmInitData).V(str2).E();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return d(new com.google.android.exoplayer2.util.b0(bArr)).f32805e;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0086  */
    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0094  */
    public static b d(com.google.android.exoplayer2.util.b0 b0Var) {
        int i11;
        int i12;
        int iH = b0Var.h(16);
        int iH2 = b0Var.h(16);
        if (iH2 == 65535) {
            iH2 = b0Var.h(24);
            i11 = 7;
        } else {
            i11 = 4;
        }
        int i13 = iH2 + i11;
        if (iH == 44097) {
            i13 += 2;
        }
        int i14 = i13;
        int iH3 = b0Var.h(2);
        if (iH3 == 3) {
            iH3 += f(b0Var, 2);
        }
        int i15 = iH3;
        int iH4 = b0Var.h(10);
        if (b0Var.g() && b0Var.h(3) > 0) {
            b0Var.r(2);
        }
        int i16 = b0Var.g() ? 48000 : 44100;
        int iH5 = b0Var.h(4);
        if (i16 == 44100 && iH5 == 13) {
            i12 = f32800a[iH5];
        } else if (i16 == 48000) {
            int[] iArr = f32800a;
            if (iH5 < iArr.length) {
                int i17 = iArr[iH5];
                int i18 = iH4 % 5;
                if (i18 == 1) {
                    if (iH5 != 3 || iH5 == 8) {
                        i17++;
                    }
                } else if (i18 != 2) {
                    if (i18 != 3) {
                        if (i18 == 4 && (iH5 == 3 || iH5 == 8 || iH5 == 11)) {
                            i17++;
                        }
                    } else if (iH5 != 3) {
                        i17++;
                    } else {
                        i17++;
                    }
                } else if (iH5 == 8 || iH5 == 11) {
                    i17++;
                }
                i12 = i17;
            } else {
                i12 = 0;
            }
        } else {
            i12 = 0;
        }
        return new b(i15, 2, i16, i14, i12);
    }

    public static int e(byte[] bArr, int i11) {
        int i12 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i13 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i13 == 65535) {
            i13 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i12 = 4;
        }
        if (i11 == 44097) {
            i12 += 2;
        }
        return i13 + i12;
    }

    public static int f(com.google.android.exoplayer2.util.b0 b0Var, int i11) {
        int i12 = 0;
        while (true) {
            int iH = i12 + b0Var.h(i11);
            if (!b0Var.g()) {
                return iH;
            }
            i12 = (iH + 1) << i11;
        }
    }
}
