package com.google.common.primitives;

import com.google.common.base.m;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class Chars {

    /* JADX INFO: compiled from: source.java */
    public enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(char[] cArr, char[] cArr2) {
            int iMin = Math.min(cArr.length, cArr2.length);
            for (int i11 = 0; i11 < iMin; i11++) {
                int iB = Chars.b(cArr[i11], cArr2[i11]);
                if (iB != 0) {
                    return iB;
                }
            }
            return cArr.length - cArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }
    }

    public static char a(long j11) {
        char c11 = (char) j11;
        m.i(((long) c11) == j11, "Out of range: %s", j11);
        return c11;
    }

    public static int b(char c11, char c12) {
        return c11 - c12;
    }

    public static boolean c(char[] cArr, char c11) {
        for (char c12 : cArr) {
            if (c12 == c11) {
                return true;
            }
        }
        return false;
    }

    public static char d(byte b11, byte b12) {
        return (char) ((b11 << 8) | (b12 & 255));
    }
}
