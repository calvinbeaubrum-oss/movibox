package com.mbridge.msdk.thrid.okio;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class Util {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private Util() {
    }

    public static boolean arrayRangeEquals(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            if (bArr[i14 + i11] != bArr2[i14 + i12]) {
                return false;
            }
        }
        return true;
    }

    public static void checkOffsetAndCount(long j11, long j12, long j13) {
        if ((j12 | j13) < 0 || j12 > j11 || j11 - j12 < j13) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13)));
        }
    }

    public static int reverseBytesInt(int i11) {
        return ((i11 & 255) << 24) | (((-16777216) & i11) >>> 24) | ((16711680 & i11) >>> 8) | ((65280 & i11) << 8);
    }

    public static long reverseBytesLong(long j11) {
        return ((j11 & 255) << 56) | (((-72057594037927936L) & j11) >>> 56) | ((71776119061217280L & j11) >>> 40) | ((280375465082880L & j11) >>> 24) | ((1095216660480L & j11) >>> 8) | ((4278190080L & j11) << 8) | ((16711680 & j11) << 24) | ((65280 & j11) << 40);
    }

    public static short reverseBytesShort(short s11) {
        return (short) (((s11 & 255) << 8) | ((65280 & s11) >>> 8));
    }

    public static void sneakyRethrow(Throwable th2) throws Throwable {
        sneakyThrow2(th2);
    }

    private static <T extends Throwable> void sneakyThrow2(Throwable th2) throws Throwable {
        throw th2;
    }
}
