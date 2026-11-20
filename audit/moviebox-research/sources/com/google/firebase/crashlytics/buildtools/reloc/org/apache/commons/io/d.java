package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40080a = Character.toString('.');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char f40081b = File.separatorChar;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char f40082c;

    static {
        if (d()) {
            f40082c = '/';
        } else {
            f40082c = '\\';
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        int iB = b(str);
        return iB == -1 ? "" : str.substring(iB + 1);
    }

    public static int b(String str) {
        int iLastIndexOf;
        if (str != null && c(str) <= (iLastIndexOf = str.lastIndexOf(46))) {
            return iLastIndexOf;
        }
        return -1;
    }

    public static int c(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean d() {
        return f40081b == '\\';
    }

    public static String[] e(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int length = charArray.length;
        int i11 = 0;
        char c11 = 0;
        while (i11 < length) {
            char c12 = charArray[i11];
            if (c12 == '?' || c12 == '*') {
                if (sb2.length() != 0) {
                    arrayList.add(sb2.toString());
                    sb2.setLength(0);
                }
                if (c12 == '?') {
                    arrayList.add("?");
                } else if (c11 != '*') {
                    arrayList.add("*");
                }
            } else {
                sb2.append(c12);
            }
            i11++;
            c11 = c12;
        }
        if (sb2.length() != 0) {
            arrayList.add(sb2.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean f(String str, String str2) {
        return g(str, str2, IOCase.SENSITIVE);
    }

    public static boolean g(String str, String str2, IOCase iOCase) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 != null) {
            if (iOCase == null) {
                iOCase = IOCase.SENSITIVE;
            }
            String[] strArrE = e(str2);
            Stack stack = new Stack();
            boolean z11 = false;
            int length = 0;
            int i11 = 0;
            do {
                if (stack.size() > 0) {
                    int[] iArr = (int[]) stack.pop();
                    i11 = iArr[0];
                    length = iArr[1];
                    z11 = true;
                }
                while (i11 < strArrE.length) {
                    if (strArrE[i11].equals("?")) {
                        length++;
                        if (length > str.length()) {
                            break;
                        }
                        z11 = false;
                        i11++;
                    } else {
                        if (strArrE[i11].equals("*")) {
                            if (i11 == strArrE.length - 1) {
                                length = str.length();
                            }
                            z11 = true;
                        } else if (z11) {
                            length = iOCase.checkIndexOf(str, length, strArrE[i11]);
                            if (length == -1) {
                                break;
                            }
                            int iCheckIndexOf = iOCase.checkIndexOf(str, length + 1, strArrE[i11]);
                            if (iCheckIndexOf >= 0) {
                                stack.push(new int[]{i11, iCheckIndexOf});
                            }
                            length += strArrE[i11].length();
                            z11 = false;
                        } else {
                            if (!iOCase.checkRegionMatches(str, length, strArrE[i11])) {
                                break;
                            }
                            length += strArrE[i11].length();
                            z11 = false;
                        }
                        i11++;
                    }
                }
                if (i11 == strArrE.length && length == str.length()) {
                    return true;
                }
            } while (stack.size() > 0);
        }
        return false;
    }
}
