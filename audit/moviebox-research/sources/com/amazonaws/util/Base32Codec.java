package com.amazonaws.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class Base32Codec extends AbstractBase32Codec {

    /* JADX INFO: compiled from: source.java */
    public static class LazyHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte[] f16256a = b();

        public static byte[] b() {
            byte[] bArr = new byte[123];
            for (int i11 = 0; i11 <= 122; i11++) {
                if (i11 >= 65 && i11 <= 90) {
                    bArr[i11] = (byte) (i11 - 65);
                } else if (i11 >= 50 && i11 <= 55) {
                    bArr[i11] = (byte) (i11 - 24);
                } else if (i11 < 97 || i11 > 122) {
                    bArr[i11] = -1;
                } else {
                    bArr[i11] = (byte) (i11 - 97);
                }
            }
            return bArr;
        }
    }

    public Base32Codec() {
        super(k());
    }

    public static byte[] k() {
        return CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
    }

    @Override // com.amazonaws.util.AbstractBase32Codec
    public int j(byte b11) {
        byte b12 = LazyHolder.f16256a[b11];
        if (b12 > -1) {
            return b12;
        }
        throw new IllegalArgumentException("Invalid base 32 character: '" + ((char) b11) + "'");
    }
}
