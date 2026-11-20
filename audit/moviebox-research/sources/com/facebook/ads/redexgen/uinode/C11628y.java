package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11628y implements Closeable {
    public static byte[] A03;
    public static String[] A04 = {"SDO1JVQRVztc05U6wH4HJTiF5V86WLZV", "JUkWBi3mNnUEcI1zFAO0icxdG8wRWdD7", "QP9Vd5zf9OYRCERvVtyUemXpYBL6EKiE", "xOOYiIXMxQksUvny4QEKcKXl4UDniIsU", "x87Ktc1IWjLpjjicmuhI7Z2IzrOHGBC3", "WGZ", "wfI1QUU7hCcnQ3hBelCxr5juQnjBiotI", "E2gfbhu1TU9ChELgnqQ3ne7CNBbav8TU"};
    public C11638z A00;
    public boolean A01;
    public final RandomAccessFile A02;

    static {
        A02();
    }

    public C11628y(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, A00(53, 3, 10));
        this.A02 = randomAccessFile;
        if (randomAccessFile.length() != 8) {
            randomAccessFile.setLength(8L);
            this.A00 = new C11638z(0, 0);
            A01();
            return;
        }
        int i11 = randomAccessFile.readInt();
        int i12 = randomAccessFile.readInt();
        if (i11 < 0 || i12 < 0) {
            i11 = 0;
            i12 = 0;
        }
        this.A00 = new C11638z(i11, i12);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            byte b11 = bArrCopyOfRange[i14];
            if (A04[5].length() != 3) {
                throw new RuntimeException();
            }
            A04[6] = "pH7cradwiFTKLrbheOx3UovjSmwH9sX8";
            bArrCopyOfRange[i14] = (byte) ((b11 ^ i13) ^ 38);
        }
        return new String(bArrCopyOfRange);
    }

    private void A01() throws IOException {
        this.A02.seek(0L);
        this.A02.writeInt(this.A00.A02());
        this.A02.writeInt(this.A00.A03());
        this.A02.getFD().sync();
    }

    public static void A02() {
        A03 = new byte[]{95, 105, 110, 111, 115, 110, 90, 117, 112, 121, 60, 117, 111, 60, 125, 112, 110, 121, 125, 120, 101, 60, Ascii.DEL, 112, 115, 111, 121, 120, Ascii.SI, 40, 48, 39, 42, 47, 34, 102, 54, 41, 53, 47, 50, 47, 41, 40, 124, 102, 110, 99, 34, 106, 99, 34, 111, 94, 91, 95};
    }

    public final C11638z A03() throws IOException {
        if (this.A01) {
            throw new IOException(A00(0, 28, 58));
        }
        return this.A00;
    }

    public final void A04(C11638z c11638z) throws IOException {
        if (this.A01) {
            throw new IOException(A00(0, 28, 58));
        }
        if (c11638z.A02() < 0 || c11638z.A03() < 0) {
            throw new IOException(String.format(Locale.US, A00(28, 25, 96), Integer.valueOf(c11638z.A02()), Integer.valueOf(c11638z.A03())));
        }
        this.A00 = c11638z;
        A01();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.A01) {
            return;
        }
        this.A01 = true;
        this.A02.close();
    }
}
