package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC11056h {
    public static byte[] A00;

    static {
        A04();
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
        options.inSampleSize = A00(options, i12, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(c0n, null, options);
    }

    public static Bitmap A02(String str, int i11, int i12, C11237f c11237f) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = A00(options, i12, i11);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Throwable th2) {
            c11237f.A07().A9a(A03(0, 5, 99), C8A.A1h, new C8B(th2));
            return null;
        }
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{92, 88, 84, 82, 80};
    }
}
