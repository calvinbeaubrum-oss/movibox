package com.bytedance.sdk.component.adexpress.We;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final byte[] f26732sc = sc("VP8X");

    private static void We(ImageView imageView, byte[] bArr, int i11, int i12) {
        Bitmap bitmapSc = new com.bytedance.sdk.component.ExN.zY.pFF.sc(i11, i12, imageView.getScaleType(), Bitmap.Config.ARGB_4444, i11, i12).sc(bArr);
        if (bitmapSc != null) {
            imageView.setImageBitmap(bitmapSc);
        }
    }

    public static void pFF(ImageView imageView, byte[] bArr, int i11, int i12) {
        if (TextUtils.equals("png", com.bytedance.sdk.component.utils.Qj.sc(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.Qj.sc())))) {
            zY(imageView, bArr, i11, i12);
        } else {
            sc(imageView, bArr, i11, i12);
        }
    }

    public static void sc(ImageView imageView, byte[] bArr, int i11, int i12) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT < 28) {
            We(imageView, bArr, i11, i12);
        } else {
            try {
                imageView.setImageDrawable(ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap)));
            } catch (IOException unused) {
            }
        }
    }

    public static boolean sc(byte[] bArr, int i11) {
        try {
            boolean zSc = sc(bArr, i11 + 12, f26732sc);
            int i12 = i11 + 20;
            if (bArr.length <= i12) {
                return false;
            }
            boolean z11 = (bArr[i12] & 2) == 2;
            if (zSc && z11) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean sc(byte[] bArr, int i11, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i11 > bArr.length) {
            return false;
        }
        for (int i12 = 0; i12 < bArr2.length; i12++) {
            if (bArr[i12 + i11] != bArr2[i12]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] sc(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    private static void zY(ImageView imageView, byte[] bArr, int i11, int i12) {
        We(imageView, bArr, i11, i12);
    }
}
