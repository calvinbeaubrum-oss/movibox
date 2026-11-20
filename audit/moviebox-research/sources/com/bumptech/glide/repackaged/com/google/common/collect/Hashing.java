package com.bumptech.glide.repackaged.com.google.common.collect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class Hashing {
    private static int MAX_TABLE_SIZE = 1073741824;

    public static int closedTableSize(int i11, double d11) {
        int iMax = Math.max(i11, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= ((int) (d11 * ((double) iHighestOneBit)))) {
            return iHighestOneBit;
        }
        int i12 = iHighestOneBit << 1;
        return i12 > 0 ? i12 : MAX_TABLE_SIZE;
    }

    public static int smear(int i11) {
        return Integer.rotateLeft(i11 * (-862048943), 15) * 461845907;
    }

    public static int smearedHash(Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}
