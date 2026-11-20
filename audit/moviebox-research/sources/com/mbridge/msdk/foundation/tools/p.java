package com.mbridge.msdk.foundation.tools;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.charset.StandardCharsets;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f45080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private char[] f45082c;

    public p(int i11) {
        this(new byte[i11], 0);
    }

    public p(byte[] bArr) {
        this(bArr, 0);
    }

    public p(byte[] bArr, int i11) {
        this.f45082c = null;
        this.f45080a = bArr;
        this.f45081b = i11;
    }

    public static int a(String str) {
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = i11 + 1;
            char cCharAt = str.charAt(i11);
            if (cCharAt < 128) {
                i12++;
            } else if (cCharAt < 2048) {
                i12 += 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i12 += 3;
            } else {
                i11 += 2;
                i12 += 4;
            }
            i11 = i13;
        }
        return i12;
    }

    private long c(int i11) {
        byte[] bArr = this.f45080a;
        int i12 = i11 + 6;
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i12]) & 255) << 48) | (((long) bArr[i11 + 7]) << 56);
    }

    public final byte a() {
        byte[] bArr = this.f45080a;
        int i11 = this.f45081b;
        this.f45081b = i11 + 1;
        return bArr[i11];
    }

    public final long a(int i11, int i12) {
        long jC = 0;
        if (i12 <= 0) {
            return 0L;
        }
        int i13 = i12 >> 3;
        int i14 = i12 & 7;
        int i15 = 0;
        int i16 = i11;
        for (int i17 = 0; i17 < i13; i17++) {
            jC ^= c(i16);
            i16 += 8;
        }
        int i18 = i14 << 3;
        while (i15 < i18) {
            jC ^= (((long) this.f45080a[i16]) & 255) << i15;
            i15 += 8;
            i16++;
        }
        int i19 = (i11 & 7) << 3;
        return (jC >>> (64 - i19)) | (jC << i19);
    }

    public final String a(int i11) {
        String str;
        if (i11 < 0) {
            return null;
        }
        if (i11 == 0) {
            return "";
        }
        if (i11 > 2048) {
            str = new String(this.f45080a, this.f45081b, i11, StandardCharsets.UTF_8);
        } else {
            char[] cArr = this.f45082c;
            if (cArr == null) {
                if (i11 <= 256) {
                    this.f45082c = new char[256];
                } else {
                    this.f45082c = new char[2048];
                }
            } else if (cArr.length < i11) {
                this.f45082c = new char[2048];
            }
            char[] cArr2 = this.f45082c;
            byte[] bArr = this.f45080a;
            int i12 = this.f45081b;
            int i13 = i12 + i11;
            int i14 = 0;
            while (i12 < i13) {
                int i15 = i12 + 1;
                byte b11 = bArr[i12];
                if (b11 > 0) {
                    cArr2[i14] = (char) b11;
                    i14++;
                    i12 = i15;
                } else if (b11 < -32) {
                    i12 += 2;
                    cArr2[i14] = (char) ((bArr[i15] & Utf8.REPLACEMENT_BYTE) | ((b11 & Ascii.US) << 6));
                    i14++;
                } else if (b11 < -16) {
                    int i16 = i12 + 2;
                    i12 += 3;
                    cArr2[i14] = (char) (((bArr[i15] & Utf8.REPLACEMENT_BYTE) << 6) | ((b11 & Ascii.SI) << 12) | (bArr[i16] & Utf8.REPLACEMENT_BYTE));
                    i14++;
                } else {
                    byte b12 = bArr[i15];
                    int i17 = i12 + 3;
                    byte b13 = bArr[i12 + 2];
                    i12 += 4;
                    int i18 = ((b12 & Utf8.REPLACEMENT_BYTE) << 12) | ((b11 & 7) << 18) | ((b13 & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i17] & Utf8.REPLACEMENT_BYTE);
                    int i19 = i14 + 1;
                    cArr2[i14] = (char) ((i18 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                    i14 += 2;
                    cArr2[i19] = (char) ((i18 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                }
            }
            if (i12 > i13) {
                throw new IllegalArgumentException("Invalid String");
            }
            str = new String(cArr2, 0, i14);
        }
        this.f45081b += i11;
        return str;
    }

    public final void a(byte b11) {
        byte[] bArr = this.f45080a;
        int i11 = this.f45081b;
        this.f45081b = i11 + 1;
        bArr[i11] = b11;
    }

    public final void a(int i11, long j11) {
        byte[] bArr = this.f45080a;
        bArr[i11] = (byte) j11;
        bArr[i11 + 1] = (byte) (j11 >> 8);
        bArr[i11 + 2] = (byte) (j11 >> 16);
        bArr[i11 + 3] = (byte) (j11 >> 24);
        bArr[i11 + 4] = (byte) (j11 >> 32);
        bArr[i11 + 5] = (byte) (j11 >> 40);
        bArr[i11 + 6] = (byte) (j11 >> 48);
        bArr[i11 + 7] = (byte) (j11 >> 56);
    }

    public final void a(long j11) {
        a(this.f45081b, j11);
        this.f45081b += 8;
    }

    public final void a(short s11) {
        byte[] bArr = this.f45080a;
        int i11 = this.f45081b;
        bArr[i11] = (byte) s11;
        this.f45081b = i11 + 2;
        bArr[i11 + 1] = (byte) (s11 >> 8);
    }

    public final void a(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.f45080a, this.f45081b, length);
            this.f45081b += length;
        }
    }

    public final long b() {
        long jC = c(this.f45081b);
        this.f45081b += 8;
        return jC;
    }

    public final void b(int i11) {
        byte[] bArr = this.f45080a;
        int i12 = this.f45081b;
        bArr[i12] = (byte) i11;
        bArr[i12 + 1] = (byte) (i11 >> 8);
        bArr[i12 + 2] = (byte) (i11 >> 16);
        this.f45081b = i12 + 4;
        bArr[i12 + 3] = (byte) (i11 >> 24);
    }

    public final void b(int i11, int i12) {
        byte[] bArr = this.f45080a;
        bArr[i11] = (byte) i12;
        bArr[i11 + 1] = (byte) (i12 >> 8);
        bArr[i11 + 2] = (byte) (i12 >> 16);
        bArr[i11 + 3] = (byte) (i12 >> 24);
    }

    public final void b(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        byte[] bArr = this.f45080a;
        int i11 = this.f45081b;
        int length = str.length();
        int i12 = 0;
        while (i12 < length) {
            int i13 = i12 + 1;
            char cCharAt = str.charAt(i12);
            if (cCharAt < 128) {
                bArr[i11] = (byte) cCharAt;
                i11++;
            } else if (cCharAt < 2048) {
                int i14 = i11 + 1;
                bArr[i11] = (byte) ((cCharAt >>> 6) | PsExtractor.AUDIO_STREAM);
                i11 += 2;
                bArr[i14] = (byte) ((cCharAt & '?') | 128);
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                bArr[i11] = (byte) ((cCharAt >>> '\f') | 224);
                int i15 = i11 + 2;
                bArr[i11 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                i11 += 3;
                bArr[i15] = (byte) ((cCharAt & '?') | 128);
            } else {
                i12 += 2;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i13)) - 56613888;
                bArr[i11] = (byte) ((iCharAt >>> 18) | 240);
                bArr[i11 + 1] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i16 = i11 + 3;
                bArr[i11 + 2] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i11 += 4;
                bArr[i16] = (byte) ((iCharAt & 63) | 128);
            }
            i12 = i13;
        }
        this.f45081b = i11;
    }

    public final int c() {
        byte[] bArr = this.f45080a;
        int i11 = this.f45081b;
        int i12 = ((bArr[i11 + 1] & 255) << 8) | (bArr[i11] & 255);
        int i13 = i11 + 3;
        int i14 = i12 | ((bArr[i11 + 2] & 255) << 16);
        this.f45081b = i11 + 4;
        return (bArr[i13] << Ascii.CAN) | i14;
    }

    public final short d() {
        byte[] bArr = this.f45080a;
        int i11 = this.f45081b;
        int i12 = i11 + 1;
        int i13 = bArr[i11] & 255;
        this.f45081b = i11 + 2;
        return (short) ((bArr[i12] << 8) | i13);
    }
}
