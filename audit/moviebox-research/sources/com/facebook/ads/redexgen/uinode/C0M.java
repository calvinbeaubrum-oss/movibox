package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C0M {
    public static byte[] A00;

    static {
        A06();
    }

    public static int A00(BitmapFactory.Options options, int i11, int i12) {
        int i13 = options.outHeight;
        int i14 = options.outWidth;
        int i15 = 1;
        if (i13 > i12 || i14 > i11) {
            int i16 = i13 / 2;
            int i17 = i14 / 2;
            while (i16 / i15 >= i12 && i17 / i15 >= i11) {
                i15 *= 2;
            }
        }
        return i15;
    }

    public static Bitmap A01(InputStream inputStream, int i11, int i12) throws IOException {
        if (Build.VERSION.SDK_INT < 19) {
            return BitmapFactory.decodeStream(inputStream);
        }
        C0N c0n = new C0N(inputStream);
        c0n.mark(8192);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(c0n, null, options);
        c0n.reset();
        if (c0n.A00()) {
            return BitmapFactory.decodeStream(c0n);
        }
        options.inSampleSize = A00(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(c0n, null, options);
    }

    public static Bitmap A02(String str, int i11, int i12) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = A00(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap A03(String str, int i11, int i12, boolean z11) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            if (i11 <= 0 || i12 <= 0) {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
                A07(fileInputStream);
                return bitmapDecodeStream;
            }
            if (z11) {
                Bitmap bitmapA01 = A01(fileInputStream, i11, i12);
                A07(fileInputStream);
                return bitmapA01;
            }
            Bitmap bitmapA02 = A02(str, i11, i12);
            A07(fileInputStream);
            return bitmapA02;
        } catch (Throwable th2) {
            A07(null);
            throw th2;
        }
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A05(File file) {
        if (file != null) {
            return A04(0, 7, 117) + file.getPath();
        }
        return null;
    }

    public static void A06() {
        A00 = new byte[]{46, 33, 36, 45, 114, 103, 103};
    }

    public static void A07(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
