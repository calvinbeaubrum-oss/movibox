package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f18879a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f18880b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f18881c = {64, 112, 128, PsExtractor.AUDIO_STREAM, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static int a(ByteBuffer byteBuffer) {
        int i11;
        byte b11;
        int i12;
        byte b12;
        int iPosition = byteBuffer.position();
        byte b13 = byteBuffer.get(iPosition);
        if (b13 != -2) {
            if (b13 == -1) {
                i11 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b12 = byteBuffer.get(iPosition + 7);
            } else if (b13 != 31) {
                i11 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b11 = byteBuffer.get(iPosition + 5);
            } else {
                i11 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b12 = byteBuffer.get(iPosition + 6);
            }
            i12 = b12 & 60;
            return (((i12 >> 2) | i11) + 1) * 32;
        }
        i11 = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b11 = byteBuffer.get(iPosition + 4);
        i12 = b11 & 252;
        return (((i12 >> 2) | i11) + 1) * 32;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0060  */
    /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
    public static int a(byte[] bArr) {
        int i11;
        byte b11;
        int i12;
        int i13;
        byte b12;
        boolean z11 = false;
        byte b13 = bArr[0];
        if (b13 != -2) {
            if (b13 == -1) {
                i13 = ((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4);
                b12 = bArr[9];
            } else if (b13 != 31) {
                i11 = ((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4);
                b11 = bArr[7];
            } else {
                i13 = ((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4);
                b12 = bArr[8];
            }
            i12 = (((b12 & 60) >> 2) | i13) + 1;
            z11 = true;
            if (z11) {
                return (i12 * 16) / 14;
            }
            return i12;
        }
        i11 = ((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4);
        b11 = bArr[6];
        i12 = (((b11 & 240) >> 4) | i11) + 1;
        if (z11) {
            return (i12 * 16) / 14;
        }
        return i12;
    }

    public static f9 a(byte[] bArr, String str, String str2, y6 y6Var) {
        ah ahVarB = b(bArr);
        ahVarB.d(60);
        int i11 = f18879a[ahVarB.a(6)];
        int i12 = f18880b[ahVarB.a(4)];
        int iA = ahVarB.a(5);
        int[] iArr = f18881c;
        int i13 = iA >= iArr.length ? -1 : (iArr[iA] * 1000) / 2;
        ahVarB.d(10);
        return new f9.b().c(str).f(MimeTypes.AUDIO_DTS).b(i13).c(i11 + (ahVarB.a(2) > 0 ? 1 : 0)).n(i12).a(y6Var).e(str2).a();
    }

    public static boolean a(int i11) {
        return i11 == 2147385345 || i11 == -25230976 || i11 == 536864768 || i11 == -14745368;
    }

    private static ah b(byte[] bArr) {
        if (bArr[0] == 127) {
            return new ah(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (c(bArrCopyOf)) {
            for (int i11 = 0; i11 < bArrCopyOf.length - 1; i11 += 2) {
                byte b11 = bArrCopyOf[i11];
                int i12 = i11 + 1;
                bArrCopyOf[i11] = bArrCopyOf[i12];
                bArrCopyOf[i12] = b11;
            }
        }
        ah ahVar = new ah(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            ah ahVar2 = new ah(bArrCopyOf);
            while (ahVar2.b() >= 16) {
                ahVar2.d(2);
                ahVar.a(ahVar2.a(14), 14);
            }
        }
        ahVar.a(bArrCopyOf);
        return ahVar;
    }

    private static boolean c(byte[] bArr) {
        byte b11 = bArr[0];
        return b11 == -2 || b11 == -1;
    }

    public static int d(byte[] bArr) {
        int i11;
        byte b11;
        int i12;
        byte b12;
        byte b13 = bArr[0];
        if (b13 != -2) {
            if (b13 == -1) {
                i11 = (bArr[4] & 7) << 4;
                b12 = bArr[7];
            } else if (b13 != 31) {
                i11 = (bArr[4] & 1) << 6;
                b11 = bArr[5];
            } else {
                i11 = (bArr[5] & 7) << 4;
                b12 = bArr[6];
            }
            i12 = b12 & 60;
            return (((i12 >> 2) | i11) + 1) * 32;
        }
        i11 = (bArr[5] & 1) << 6;
        b11 = bArr[4];
        i12 = b11 & 252;
        return (((i12 >> 2) | i11) + 1) * 32;
    }
}
