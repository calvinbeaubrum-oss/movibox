package com.bytedance.sdk.component.pFF.sc.pFF;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class sc implements pFF, zY, Cloneable, ByteChannel {
    private static final byte[] zY = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    ExN f26946sc;

    public final We ExN() {
        long j11 = this.pFF;
        if (j11 <= 2147483647L) {
            return We((int) j11);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.pFF);
    }

    public final We We(int i11) {
        return i11 == 0 ? We.zY : new qr(this, i11);
    }

    /* JADX INFO: renamed from: We, reason: merged with bridge method [inline-methods] */
    public sc clone() {
        sc scVar = new sc();
        if (this.pFF == 0) {
            return scVar;
        }
        ExN exNSc = this.f26946sc.sc();
        scVar.f26946sc = exNSc;
        exNSc.f26940qr = exNSc;
        exNSc.TRI = exNSc;
        ExN exN = this.f26946sc;
        while (true) {
            exN = exN.TRI;
            if (exN == this.f26946sc) {
                scVar.pFF = this.pFF;
                return scVar;
            }
            scVar.f26946sc.f26940qr.sc(exN.sc());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sc)) {
            return false;
        }
        sc scVar = (sc) obj;
        long j11 = this.pFF;
        if (j11 != scVar.pFF) {
            return false;
        }
        long j12 = 0;
        if (j11 == 0) {
            return true;
        }
        ExN exN = this.f26946sc;
        ExN exN2 = scVar.f26946sc;
        int i11 = exN.pFF;
        int i12 = exN2.pFF;
        while (j12 < this.pFF) {
            long jMin = Math.min(exN.zY - i11, exN2.zY - i12);
            int i13 = 0;
            while (i13 < jMin) {
                int i14 = i11 + 1;
                int i15 = i12 + 1;
                if (exN.f26941sc[i11] != exN2.f26941sc[i12]) {
                    return false;
                }
                i13++;
                i11 = i14;
                i12 = i15;
            }
            if (i11 == exN.zY) {
                exN = exN.TRI;
                i11 = exN.pFF;
            }
            if (i12 == exN2.zY) {
                exN2 = exN2.TRI;
                i12 = exN2.pFF;
            }
            j12 += jMin;
        }
        return true;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        ExN exN = this.f26946sc;
        if (exN == null) {
            return 0;
        }
        int i11 = 1;
        do {
            int i12 = exN.zY;
            for (int i13 = exN.pFF; i13 < i12; i13++) {
                i11 = (i11 * 31) + exN.f26941sc[i13];
            }
            exN = exN.TRI;
        } while (exN != this.f26946sc);
        return i11;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public byte pFF() {
        long j11 = this.pFF;
        if (j11 == 0) {
            throw new IllegalStateException("size == 0");
        }
        ExN exN = this.f26946sc;
        int i11 = exN.pFF;
        int i12 = exN.zY;
        int i13 = i11 + 1;
        byte b11 = exN.f26941sc[i11];
        this.pFF = j11 - 1;
        if (i13 == i12) {
            this.f26946sc = exN.pFF();
            TRI.sc(exN);
        } else {
            exN.pFF = i13;
        }
        return b11;
    }

    public sc pFF(int i11) {
        ExN exNZY = zY(1);
        byte[] bArr = exNZY.f26941sc;
        int i12 = exNZY.zY;
        exNZY.zY = i12 + 1;
        bArr[i12] = (byte) i11;
        this.pFF++;
        return this;
    }

    public sc pFF(long j11) {
        if (j11 == 0) {
            return pFF(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j11)) / 4) + 1;
        ExN exNZY = zY(iNumberOfTrailingZeros);
        byte[] bArr = exNZY.f26941sc;
        int i11 = exNZY.zY;
        for (int i12 = (i11 + iNumberOfTrailingZeros) - 1; i12 >= i11; i12--) {
            bArr[i12] = zY[(int) (15 & j11)];
            j11 >>>= 4;
        }
        exNZY.zY += iNumberOfTrailingZeros;
        this.pFF += (long) iNumberOfTrailingZeros;
        return this;
    }

    public sc pFF(byte[] bArr, int i11, int i12) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j11 = i12;
        Ol.sc(bArr.length, i11, j11);
        int i13 = i12 + i11;
        while (i11 < i13) {
            ExN exNZY = zY(1);
            int iMin = Math.min(i13 - i11, 8192 - exNZY.zY);
            System.arraycopy(bArr, i11, exNZY.f26941sc, exNZY.zY, iMin);
            i11 += iMin;
            exNZY.zY += iMin;
        }
        this.pFF += j11;
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        ExN exN = this.f26946sc;
        if (exN == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), exN.zY - exN.pFF);
        byteBuffer.put(exN.f26941sc, exN.pFF, iMin);
        int i11 = exN.pFF + iMin;
        exN.pFF = i11;
        this.pFF -= (long) iMin;
        if (i11 == exN.zY) {
            this.f26946sc = exN.pFF();
            TRI.sc(exN);
        }
        return iMin;
    }

    public int sc(byte[] bArr, int i11, int i12) {
        Ol.sc(bArr.length, i11, i12);
        ExN exN = this.f26946sc;
        if (exN == null) {
            return -1;
        }
        int iMin = Math.min(i12, exN.zY - exN.pFF);
        System.arraycopy(exN.f26941sc, exN.pFF, bArr, i11, iMin);
        int i13 = exN.pFF + iMin;
        exN.pFF = i13;
        this.pFF -= (long) iMin;
        if (i13 == exN.zY) {
            this.f26946sc = exN.pFF();
            TRI.sc(exN);
        }
        return iMin;
    }

    public sc sc(int i11) {
        if (i11 < 128) {
            pFF(i11);
        } else if (i11 < 2048) {
            pFF((i11 >> 6) | PsExtractor.AUDIO_STREAM);
            pFF((i11 & 63) | 128);
        } else if (i11 < 65536) {
            if (i11 < 55296 || i11 > 57343) {
                pFF((i11 >> 12) | 224);
                pFF(((i11 >> 6) & 63) | 128);
                pFF((i11 & 63) | 128);
            } else {
                pFF(63);
            }
        } else {
            if (i11 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i11));
            }
            pFF((i11 >> 18) | 240);
            pFF(((i11 >> 12) & 63) | 128);
            pFF(((i11 >> 6) & 63) | 128);
            pFF((i11 & 63) | 128);
        }
        return this;
    }

    public sc sc(String str) {
        return sc(str, 0, str.length());
    }

    public sc sc(String str, int i11, int i12) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i11)));
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i12 + " < " + i11);
        }
        if (i12 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i12 + " > " + str.length());
        }
        while (i11 < i12) {
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 128) {
                ExN exNZY = zY(1);
                byte[] bArr = exNZY.f26941sc;
                int i13 = exNZY.zY - i11;
                int iMin = Math.min(i12, 8192 - i13);
                int i14 = i11 + 1;
                bArr[i11 + i13] = (byte) cCharAt2;
                while (true) {
                    i11 = i14;
                    if (i11 >= iMin || (cCharAt = str.charAt(i11)) >= 128) {
                        break;
                    }
                    i14 = i11 + 1;
                    bArr[i11 + i13] = (byte) cCharAt;
                }
                int i15 = exNZY.zY;
                int i16 = (i13 + i11) - i15;
                exNZY.zY = i15 + i16;
                this.pFF += (long) i16;
            } else {
                if (cCharAt2 < 2048) {
                    pFF((cCharAt2 >> 6) | PsExtractor.AUDIO_STREAM);
                    pFF((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    pFF((cCharAt2 >> '\f') | 224);
                    pFF(((cCharAt2 >> 6) & 63) | 128);
                    pFF((cCharAt2 & '?') | 128);
                } else {
                    int i17 = i11 + 1;
                    char cCharAt3 = i17 < i12 ? str.charAt(i17) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        pFF(63);
                        i11 = i17;
                    } else {
                        int i18 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        pFF((i18 >> 18) | 240);
                        pFF(((i18 >> 12) & 63) | 128);
                        pFF(((i18 >> 6) & 63) | 128);
                        pFF((i18 & 63) | 128);
                        i11 += 2;
                    }
                }
                i11++;
            }
        }
        return this;
    }

    public sc sc(String str, int i11, int i12, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i11 < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i11)));
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i12 + " < " + i11);
        }
        if (i12 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i12 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(Ol.f26942sc)) {
            return sc(str, i11, i12);
        }
        byte[] bytes = str.substring(i11, i12).getBytes(charset);
        return pFF(bytes, 0, bytes.length);
    }

    public String sc(long j11, Charset charset) throws EOFException {
        Ol.sc(this.pFF, 0L, j11);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j11)));
        }
        if (j11 == 0) {
            return "";
        }
        ExN exN = this.f26946sc;
        int i11 = exN.pFF;
        if (((long) i11) + j11 > exN.zY) {
            return new String(sc(j11), charset);
        }
        String str = new String(exN.f26941sc, i11, (int) j11, charset);
        int i12 = (int) (((long) exN.pFF) + j11);
        exN.pFF = i12;
        this.pFF -= j11;
        if (i12 == exN.zY) {
            this.f26946sc = exN.pFF();
            TRI.sc(exN);
        }
        return str;
    }

    public void sc(byte[] bArr) throws EOFException {
        int i11 = 0;
        while (i11 < bArr.length) {
            int iSc = sc(bArr, i11, bArr.length - i11);
            if (iSc == -1) {
                throw new EOFException();
            }
            i11 += iSc;
        }
    }

    public boolean sc() {
        return this.pFF == 0;
    }

    public byte[] sc(long j11) throws EOFException {
        Ol.sc(this.pFF, 0L, j11);
        if (j11 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j11)));
        }
        byte[] bArr = new byte[(int) j11];
        sc(bArr);
        return bArr;
    }

    public String toString() {
        return ExN().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i11 = iRemaining;
        while (i11 > 0) {
            ExN exNZY = zY(1);
            int iMin = Math.min(i11, 8192 - exNZY.zY);
            byteBuffer.get(exNZY.f26941sc, exNZY.zY, iMin);
            i11 -= iMin;
            exNZY.zY += iMin;
        }
        this.pFF += (long) iRemaining;
        return iRemaining;
    }

    public ExN zY(int i11) {
        if (i11 <= 0 || i11 > 8192) {
            throw new IllegalArgumentException();
        }
        ExN exN = this.f26946sc;
        if (exN != null) {
            ExN exN2 = exN.f26940qr;
            return (exN2.zY + i11 > 8192 || !exN2.ExN) ? exN2.sc(TRI.sc()) : exN2;
        }
        ExN exNSc = TRI.sc();
        this.f26946sc = exNSc;
        exNSc.f26940qr = exNSc;
        exNSc.TRI = exNSc;
        return exNSc;
    }

    public String zY() {
        try {
            return sc(this.pFF, Ol.f26942sc);
        } catch (EOFException e11) {
            throw new AssertionError(e11);
        }
    }
}
