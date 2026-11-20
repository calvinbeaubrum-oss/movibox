package com.mbridge.msdk.thrid.okio;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int i11, int i12) {
        long j11;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i11);
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i12 + " < " + i11);
        }
        if (i12 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i12 + " > " + str.length());
        }
        long j12 = 0;
        while (i11 < i12) {
            char cCharAt = str.charAt(i11);
            if (cCharAt < 128) {
                j12++;
            } else {
                if (cCharAt < 2048) {
                    j11 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    j11 = 3;
                } else {
                    int i13 = i11 + 1;
                    char cCharAt2 = i13 < i12 ? str.charAt(i13) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j12++;
                        i11 = i13;
                    } else {
                        j12 += 4;
                        i11 += 2;
                    }
                }
                j12 += j11;
            }
            i11++;
        }
        return j12;
    }
}
