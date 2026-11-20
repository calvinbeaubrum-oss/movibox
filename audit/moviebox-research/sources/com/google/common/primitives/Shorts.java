package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class Shorts extends f {

    /* JADX INFO: compiled from: source.java */
    public enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(short[] sArr, short[] sArr2) {
            int iMin = Math.min(sArr.length, sArr2.length);
            for (int i11 = 0; i11 < iMin; i11++) {
                int iA = Shorts.a(sArr[i11], sArr2[i11]);
                if (iA != 0) {
                    return iA;
                }
            }
            return sArr.length - sArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }
    }

    public static int a(short s11, short s12) {
        return s11 - s12;
    }
}
