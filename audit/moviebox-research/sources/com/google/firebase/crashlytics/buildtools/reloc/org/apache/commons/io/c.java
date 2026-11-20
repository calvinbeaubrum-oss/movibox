package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f40071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f40072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f40073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f40074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f40075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f40076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f40077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final File[] f40079i;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(1024L);
        f40071a = bigIntegerValueOf;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf);
        f40072b = bigIntegerMultiply;
        BigInteger bigIntegerMultiply2 = bigIntegerValueOf.multiply(bigIntegerMultiply);
        f40073c = bigIntegerMultiply2;
        BigInteger bigIntegerMultiply3 = bigIntegerValueOf.multiply(bigIntegerMultiply2);
        f40074d = bigIntegerMultiply3;
        BigInteger bigIntegerMultiply4 = bigIntegerValueOf.multiply(bigIntegerMultiply3);
        f40075e = bigIntegerMultiply4;
        f40076f = bigIntegerValueOf.multiply(bigIntegerMultiply4);
        BigInteger bigIntegerMultiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
        f40077g = bigIntegerMultiply5;
        f40078h = bigIntegerValueOf.multiply(bigIntegerMultiply5);
        f40079i = new File[0];
    }

    public static void a(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (file.isDirectory()) {
            return;
        }
        throw new IllegalArgumentException(file + " is not a directory");
    }

    public static boolean b(File file, long j11) {
        if (file != null) {
            return file.exists() && file.lastModified() > j11;
        }
        throw new IllegalArgumentException("No specified file");
    }

    public static boolean c(File file) throws IOException {
        if (file != null) {
            return Files.isSymbolicLink(file.toPath());
        }
        throw new NullPointerException("File must not be null");
    }

    public static long d(File file) {
        return file.isDirectory() ? f(file) : file.length();
    }

    public static long e(File file) {
        a(file);
        return f(file);
    }

    public static long f(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        long jD = 0;
        for (File file2 : fileArrListFiles) {
            try {
                if (!c(file2)) {
                    jD += d(file2);
                    if (jD < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            } catch (IOException unused) {
            }
        }
        return jD;
    }
}
