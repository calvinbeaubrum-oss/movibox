package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1471Lx {
    public static Bitmap A00(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setScale(-1.0f, 1.0f);
        matrix.postTranslate(bitmap.getWidth(), 0.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap A01(EnumC1470Lw enumC1470Lw) {
        byte[] bArrDecode = Base64.decode(enumC1470Lw.A00(LD.A02), 0);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static Bitmap A02(EnumC1470Lw enumC1470Lw) {
        byte[] bArrDecode = Base64.decode(enumC1470Lw.A00(LD.A02), 0);
        return A00(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    public static Drawable A03(C1795Yn c1795Yn, EnumC1470Lw enumC1470Lw) {
        return new BitmapDrawable(c1795Yn.getResources(), A01(enumC1470Lw));
    }
}
