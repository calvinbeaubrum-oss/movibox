package com.amazonaws.util;

import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class Base16Codec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f16254a = CodecUtils.toBytesDirect("0123456789ABCDEF");

    /* JADX INFO: compiled from: source.java */
    public static class LazyHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte[] f16255a = b();

        public static byte[] b() {
            byte[] bArr = new byte[Worker.WHAT_SYNC_DATA];
            for (int i11 = 0; i11 <= 102; i11++) {
                if (i11 >= 48 && i11 <= 57) {
                    bArr[i11] = (byte) (i11 - 48);
                } else if (i11 >= 65 && i11 <= 70) {
                    bArr[i11] = (byte) (i11 - 55);
                } else if (i11 < 97 || i11 > 102) {
                    bArr[i11] = -1;
                } else {
                    bArr[i11] = (byte) (i11 - 87);
                }
            }
            return bArr;
        }
    }

    public byte[] a(byte[] bArr, int i11) {
        if (i11 % 2 != 0) {
            throw new IllegalArgumentException("Input is expected to be encoded in multiple of 2 bytes but found: " + i11);
        }
        int i12 = i11 / 2;
        byte[] bArr2 = new byte[i12];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            int i15 = i13 + 1;
            int iC = c(bArr[i13]) << 4;
            i13 += 2;
            bArr2[i14] = (byte) (c(bArr[i15]) | iC);
        }
        return bArr2;
    }

    public byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            byte[] bArr3 = this.f16254a;
            bArr2[i11] = bArr3[(b11 >>> 4) & 15];
            i11 += 2;
            bArr2[i12] = bArr3[b11 & Ascii.SI];
        }
        return bArr2;
    }

    public int c(byte b11) {
        byte b12 = LazyHolder.f16255a[b11];
        if (b12 > -1) {
            return b12;
        }
        throw new IllegalArgumentException("Invalid base 16 character: '" + ((char) b11) + "'");
    }
}
