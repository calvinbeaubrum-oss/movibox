package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Chars {

    /* JADX INFO: compiled from: source.java */
    public enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(char[] cArr, char[] cArr2) {
            int iMin = Math.min(cArr.length, cArr2.length);
            for (int i11 = 0; i11 < iMin; i11++) {
                int iA = Chars.a(cArr[i11], cArr2[i11]);
                if (iA != 0) {
                    return iA;
                }
            }
            return cArr.length - cArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }
    }

    public static int a(char c11, char c12) {
        return c11 - c12;
    }
}
