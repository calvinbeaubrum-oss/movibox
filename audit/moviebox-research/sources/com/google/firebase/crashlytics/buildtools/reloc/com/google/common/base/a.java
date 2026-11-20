package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static boolean a(char c11) {
        return c11 >= 'a' && c11 <= 'z';
    }

    public static boolean b(char c11) {
        return c11 >= 'A' && c11 <= 'Z';
    }

    public static String c(String str) {
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            if (b(str.charAt(i11))) {
                char[] charArray = str.toCharArray();
                while (i11 < length) {
                    char c11 = charArray[i11];
                    if (b(c11)) {
                        charArray[i11] = (char) (c11 ^ ' ');
                    }
                    i11++;
                }
                return String.valueOf(charArray);
            }
            i11++;
        }
        return str;
    }

    public static char d(char c11) {
        return a(c11) ? (char) (c11 & '_') : c11;
    }

    public static String e(String str) {
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            if (a(str.charAt(i11))) {
                char[] charArray = str.toCharArray();
                while (i11 < length) {
                    char c11 = charArray[i11];
                    if (a(c11)) {
                        charArray[i11] = (char) (c11 & '_');
                    }
                    i11++;
                }
                return String.valueOf(charArray);
            }
            i11++;
        }
        return str;
    }
}
