package com.mbridge.msdk.foundation.tools;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class ap {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final char[] f45016a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final SecureRandom f45017b = new SecureRandom();
    }

    public static int a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get(null), new Object[0])).intValue();
        } catch (Throwable unused) {
            return 4096;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file) {
        try {
            if (file.exists()) {
                d(file);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(File file, byte[] bArr, int i11) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i12 = 0;
        while (i12 < i11) {
            try {
                int i13 = randomAccessFile.read(bArr, i12, i11 - i12);
                if (i13 < 0) {
                    break;
                } else {
                    i12 += i13;
                }
            } finally {
                a(randomAccessFile);
            }
        }
    }

    public static boolean a(File file, byte[] bArr) {
        try {
            File file2 = new File(file.getParent(), file.getName() + ".tmp");
            if (!c(file2)) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                randomAccessFile.setLength(bArr.length);
                randomAccessFile.write(bArr);
                a(randomAccessFile);
                if (!file.exists() || file.delete()) {
                    return file2.renameTo(file);
                }
            } catch (Throwable th2) {
                a(randomAccessFile);
                throw th2;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String b() {
        byte[] bArr = new byte[16];
        a.f45017b.nextBytes(bArr);
        char[] cArr = new char[32];
        for (int i11 = 0; i11 < 16; i11++) {
            byte b11 = bArr[i11];
            int i12 = i11 << 1;
            char[] cArr2 = a.f45016a;
            cArr[i12] = cArr2[(b11 >> 4) & 15];
            cArr[i12 + 1] = cArr2[b11 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static byte[] b(File file) throws IOException {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) == 0) {
            int i11 = (int) length;
            byte[] bArr = new byte[i11];
            a(file, bArr, i11);
            return bArr;
        }
        throw new IllegalArgumentException("file too large, path:" + file.getPath());
    }

    public static boolean c(File file) throws IOException {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        return parentFile != null && (parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile();
    }

    private static void d(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                d(file2);
            }
        }
        file.delete();
    }
}
