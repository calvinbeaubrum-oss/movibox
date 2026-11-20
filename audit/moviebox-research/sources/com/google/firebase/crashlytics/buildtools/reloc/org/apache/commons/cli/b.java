package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static boolean a(char c11) {
        return Character.isJavaIdentifierPart(c11);
    }

    public static boolean b(char c11) {
        return a(c11) || c11 == '?' || c11 == '@';
    }

    public static void c(String str) throws IllegalArgumentException {
        if (str == null) {
            return;
        }
        if (str.length() == 1) {
            char cCharAt = str.charAt(0);
            if (b(cCharAt)) {
                return;
            }
            throw new IllegalArgumentException("Illegal option name '" + cCharAt + "'");
        }
        for (char c11 : str.toCharArray()) {
            if (!a(c11)) {
                throw new IllegalArgumentException("The option '" + str + "' contains an illegal character : '" + c11 + "'");
            }
        }
    }
}
