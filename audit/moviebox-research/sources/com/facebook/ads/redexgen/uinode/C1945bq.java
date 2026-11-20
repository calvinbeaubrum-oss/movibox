package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1945bq implements AnonymousClass03<Bitmap> {
    public static byte[] A06;
    public static String[] A07 = {"O8BWLXPdzHA", "6sEzkrKiC7tSlAyzako7Jr1QeLTjq7r7", "buIAODYM5Oo034kKCIV4I7ZzRqvLqiIh", "ENOGp8Grp5cb6hByXNSQMpF2JyONyocp", "tnh", "2Zn0DxkDz4CuR43sN", "3j1ga9q4MlHQ2cRzMN", "NuleDR7CXAFlpWhCDunnHJWIhrQ2pSEs"};
    public final int A00;
    public final int A01;
    public final String A02 = C1945bq.class.getSimpleName();
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;

    static {
        A02();
    }

    public C1945bq(int i11, int i12, boolean z11, boolean z12, boolean z13) {
        this.A01 = i11;
        this.A00 = i12;
        this.A05 = z11;
        this.A03 = z12;
        this.A04 = z13;
    }

    public static AnonymousClass02<Bitmap> A00(Throwable th2) {
        return new AnonymousClass02<>(false, null, th2);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            byte b11 = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 8);
            if (A07[7].charAt(0) == 'p') {
                throw new RuntimeException();
            }
            A07[6] = "rTtdlTA5qc3UePbll3p";
            bArrCopyOfRange[i14] = b11;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        if (A07[4].length() != 3) {
            throw new RuntimeException();
        }
        A07[6] = "j2OKbozXXbIBudrsn6AX9zPsXXh";
        A06 = new byte[]{1, 91, 66, 95, 7, 44, 49, 40, 36, 53, 101, 44, 54, 101, 43, 48, 41, 41, 124, 65, 90, 92, 73, 77, 80, 86, 87, Ascii.EM, 93, 76, 75, 80, 87, 94, Ascii.EM, 95, 80, 85, 92, Ascii.EM, 90, 86, 84, 73, 75, 92, 74, 74, 80, 86, 87};
    }

    private void A03(File file, Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= 3145728) {
                return;
            }
            String str = file.getCanonicalPath() + A01(0, 4, 39);
            File file2 = new File(str);
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(str);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.flush();
            fileInputStream = new FileInputStream(str);
            fileOutputStream2 = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i11 = fileInputStream.read(bArr);
                if (i11 <= 0) {
                    file2.delete();
                    return;
                }
                fileOutputStream2.write(bArr, 0, i11);
            }
        } finally {
            C0M.A07(byteArrayOutputStream);
            C0M.A07(fileOutputStream);
            C0M.A07(fileInputStream);
            C0M.A07(fileOutputStream2);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass03
    public final AnonymousClass02<Bitmap> A3M(File file, C0L c0l) {
        if (!this.A04) {
            return new AnonymousClass02<>(true, null);
        }
        try {
            Bitmap bitmapA03 = C0M.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
            if (bitmapA03 != null) {
                return new AnonymousClass02<>(true, bitmapA03);
            }
            c0l.A9U(new C1939bk(A01(4, 14, 77)));
            return A00(null);
        } catch (Throwable th2) {
            file.delete();
            c0l.A9U(th2);
            return A00(th2);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass03
    public final void A4U(File file, C0L c0l) throws C1939bk {
        if (this.A03) {
            try {
                Bitmap bitmapA03 = C0M.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
                if (bitmapA03 != null) {
                    A03(file, bitmapA03);
                } else {
                    file.delete();
                    throw new C1939bk(A01(4, 14, 77));
                }
            } catch (C1939bk e11) {
                c0l.A9f(e11);
                throw e11;
            } catch (Throwable th2) {
                c0l.A9f(th2);
                throw new C1939bk(A01(18, 33, 49), th2);
            }
        }
    }
}
