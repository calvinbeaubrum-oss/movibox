package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class SignedBytes {

    /* JADX INFO: compiled from: source.java */
    public enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int iMin = Math.min(bArr.length, bArr2.length);
            for (int i11 = 0; i11 < iMin; i11++) {
                int iB = SignedBytes.b(bArr[i11], bArr2[i11]);
                if (iB != 0) {
                    return iB;
                }
            }
            return bArr.length - bArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    public static byte a(long j11) {
        byte b11 = (byte) j11;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.h(((long) b11) == j11, "Out of range: %s", j11);
        return b11;
    }

    public static int b(byte b11, byte b12) {
        return b11 - b12;
    }
}
