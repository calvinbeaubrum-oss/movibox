package k8;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static File a(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static long b(String str, String str2) {
        File fileD = d(str, str2);
        if (fileD.exists()) {
            return fileD.length();
        }
        File fileA = a(str, str2);
        if (fileA.exists()) {
            return fileA.length();
        }
        return 0L;
    }

    public static void c(RandomAccessFile randomAccessFile, byte[] bArr, int i11, int i12, String str) throws IOException {
        try {
            randomAccessFile.seek(i11);
            randomAccessFile.write(bArr, 0, i12);
        } catch (Throwable unused) {
        }
    }

    public static File d(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }
}
