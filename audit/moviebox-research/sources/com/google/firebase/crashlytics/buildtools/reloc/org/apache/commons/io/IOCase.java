package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum IOCase implements Serializable {
    SENSITIVE("Sensitive", true),
    INSENSITIVE("Insensitive", false),
    SYSTEM("System", !d.d());

    private static final long serialVersionUID = -6343169151696340687L;
    private final String name;
    private final transient boolean sensitive;

    IOCase(String str, boolean z11) {
        this.name = str;
        this.sensitive = z11;
    }

    public static IOCase forName(String str) {
        for (IOCase iOCase : values()) {
            if (iOCase.getName().equals(str)) {
                return iOCase;
            }
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + str);
    }

    private Object readResolve() {
        return forName(this.name);
    }

    public int checkCompareTo(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.sensitive ? str.compareTo(str2) : str.compareToIgnoreCase(str2);
    }

    public boolean checkEndsWith(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(!this.sensitive, str.length() - length, str2, 0, length);
    }

    public boolean checkEquals(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.sensitive ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public int checkIndexOf(String str, int i11, String str2) {
        int length = str.length() - str2.length();
        if (length < i11) {
            return -1;
        }
        while (i11 <= length) {
            if (checkRegionMatches(str, i11, str2)) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public boolean checkRegionMatches(String str, int i11, String str2) {
        return str.regionMatches(!this.sensitive, i11, str2, 0, str2.length());
    }

    public boolean checkStartsWith(String str, String str2) {
        return str.regionMatches(!this.sensitive, 0, str2, 0, str2.length());
    }

    public String getName() {
        return this.name;
    }

    public boolean isCaseSensitive() {
        return this.sensitive;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
