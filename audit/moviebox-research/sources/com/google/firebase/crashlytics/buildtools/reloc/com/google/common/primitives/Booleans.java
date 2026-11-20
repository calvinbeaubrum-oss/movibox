package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Booleans {

    /* JADX INFO: compiled from: source.java */
    public enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");

        private final String toString;
        private final int trueValue;

        BooleanComparator(int i11, String str) {
            this.trueValue = i11;
            this.toString = str;
        }

        @Override // java.util.Comparator
        public int compare(Boolean bool, Boolean bool2) {
            return (bool2.booleanValue() ? this.trueValue : 0) - (bool.booleanValue() ? this.trueValue : 0);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.toString;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(boolean[] zArr, boolean[] zArr2) {
            int iMin = Math.min(zArr.length, zArr2.length);
            for (int i11 = 0; i11 < iMin; i11++) {
                int iA = Booleans.a(zArr[i11], zArr2[i11]);
                if (iA != 0) {
                    return iA;
                }
            }
            return zArr.length - zArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }
    }

    public static int a(boolean z11, boolean z12) {
        if (z11 == z12) {
            return 0;
        }
        return z11 ? 1 : -1;
    }
}
