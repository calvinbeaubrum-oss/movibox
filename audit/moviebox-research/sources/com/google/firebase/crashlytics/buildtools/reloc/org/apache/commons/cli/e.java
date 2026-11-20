package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("--")) {
            return str.substring(2, str.length());
        }
        return str.startsWith("-") ? str.substring(1, str.length()) : str;
    }
}
