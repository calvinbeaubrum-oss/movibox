package wt;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f79597a = Charset.forName(C.ASCII_NAME);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f79598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f79599c;

    static {
        Charset.forName("UTF-8");
        f79598b = "0123456789abcdef".toCharArray();
        f79599c = new char[64];
    }

    public static String a(byte[] bArr) {
        String str;
        char[] cArr = f79599c;
        synchronized (cArr) {
            for (int i11 = 0; i11 < bArr.length; i11++) {
                try {
                    byte b11 = bArr[i11];
                    int i12 = i11 * 2;
                    char[] cArr2 = f79598b;
                    cArr[i12] = cArr2[(b11 & 255) >>> 4];
                    cArr[i12 + 1] = cArr2[b11 & Ascii.SI];
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            str = new String(cArr);
        }
        return str;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static void c(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                c(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
