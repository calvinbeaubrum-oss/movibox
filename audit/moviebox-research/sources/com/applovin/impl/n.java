package com.applovin.impl;

import com.google.logging.type.LogSeverity;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f21212a = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, LogSeverity.EMERGENCY_VALUE, LogSeverity.EMERGENCY_VALUE, 480, LogSeverity.WARNING_VALUE, LogSeverity.WARNING_VALUE, 2048};

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f21216d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f21217e;

        private b(int i11, int i12, int i13, int i14, int i15) {
            this.f21213a = i11;
            this.f21215c = i12;
            this.f21214b = i13;
            this.f21216d = i14;
            this.f21217e = i15;
        }
    }

    private static int a(ah ahVar, int i11) {
        int i12 = 0;
        while (true) {
            int iA = i12 + ahVar.a(i11);
            if (!ahVar.f()) {
                return iA;
            }
            i12 = (iA + 1) << i11;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return a(new ah(bArr)).f21217e;
    }

    public static int a(byte[] bArr, int i11) {
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

    public static f9 a(bh bhVar, String str, String str2, y6 y6Var) {
        bhVar.g(1);
        return new f9.b().c(str).f("audio/ac4").c(2).n(((bhVar.w() & 32) >> 5) == 1 ? 48000 : 44100).a(y6Var).e(str2).a();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x008c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:48:0x0096  */
    public static b a(ah ahVar) {
        int i11;
        int i12;
        int iA = ahVar.a(16);
        int iA2 = ahVar.a(16);
        if (iA2 == 65535) {
            iA2 = ahVar.a(24);
            i11 = 7;
        } else {
            i11 = 4;
        }
        int i13 = iA2 + i11;
        if (iA == 44097) {
            i13 += 2;
        }
        int i14 = i13;
        int iA3 = ahVar.a(2);
        if (iA3 == 3) {
            iA3 += a(ahVar, 2);
        }
        int i15 = iA3;
        int iA4 = ahVar.a(10);
        if (ahVar.f() && ahVar.a(3) > 0) {
            ahVar.d(2);
        }
        int i16 = ahVar.f() ? 48000 : 44100;
        int iA5 = ahVar.a(4);
        if (i16 == 44100 && iA5 == 13) {
            i12 = f21212a[iA5];
        } else if (i16 == 48000) {
            int[] iArr = f21212a;
            if (iA5 < iArr.length) {
                int i17 = iArr[iA5];
                int i18 = iA4 % 5;
                if (i18 == 1) {
                    if (iA5 != 3 || iA5 == 8) {
                        i17++;
                    }
                } else if (i18 != 2) {
                    if (i18 != 3) {
                        if (i18 == 4 && (iA5 == 3 || iA5 == 8 || iA5 == 11)) {
                            i17++;
                        }
                    } else if (iA5 != 3) {
                        i17++;
                    } else {
                        i17++;
                    }
                } else if (iA5 == 8 || iA5 == 11) {
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

    public static void a(int i11, bh bhVar) {
        bhVar.d(7);
        byte[] bArrC = bhVar.c();
        bArrC[0] = -84;
        bArrC[1] = 64;
        bArrC[2] = -1;
        bArrC[3] = -1;
        bArrC[4] = (byte) ((i11 >> 16) & 255);
        bArrC[5] = (byte) ((i11 >> 8) & 255);
        bArrC[6] = (byte) (i11 & 255);
    }
}
