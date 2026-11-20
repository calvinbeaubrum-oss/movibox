package com.bytedance.sdk.component.ExN.zY.pFF;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private int ExN;
    private final ImageView.ScaleType Qj;
    private final int TRI;
    private int We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final int f26511qr;
    private final Bitmap.Config zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final ImageView.ScaleType f26510sc = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config pFF = Bitmap.Config.ARGB_4444;
    private final int Ol = 3840;
    private final int WH = 104857600;

    public sc(int i11, int i12, ImageView.ScaleType scaleType, Bitmap.Config config, int i13, int i14) {
        this.zY = config;
        this.We = i11;
        this.ExN = i12;
        this.Qj = scaleType;
        this.TRI = i13;
        this.f26511qr = i14;
        sc(i11, i12);
    }

    public static int sc(int i11, int i12, int i13, int i14, int i15, int i16) {
        double dMin = Math.min(((double) i11) / ((double) i13), ((double) i12) / ((double) i14));
        if (i15 > 0 && i16 > 0) {
            dMin = Math.max(dMin, Math.min(((double) Math.max(i11, i12)) / ((double) Math.max(i15, i16)), ((double) Math.min(i11, i12)) / ((double) Math.min(i15, i16))));
        }
        float f11 = 1.0f;
        while (true) {
            float f12 = 2.0f * f11;
            if (f12 > dMin) {
                return (int) f11;
            }
            f11 = f12;
        }
    }

    private static int sc(int i11, int i12, int i13, int i14, ImageView.ScaleType scaleType) {
        if (i11 == 0 && i12 == 0) {
            return i13;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i11 == 0 ? i13 : i11;
        }
        if (i11 == 0) {
            return (int) (((double) i13) * (((double) i12) / ((double) i14)));
        }
        if (i12 == 0) {
            return i11;
        }
        double d11 = ((double) i14) / ((double) i13);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d12 = i12;
            return ((double) i11) * d11 < d12 ? (int) (d12 / d11) : i11;
        }
        double d13 = i12;
        return ((double) i11) * d11 > d13 ? (int) (d13 / d11) : i11;
    }

    private void sc(int i11, int i12) {
        if (i11 > 3840 && i12 > 3840) {
            if (i11 > i12) {
                this.We = 3840;
                this.ExN = (i12 * 3840) / i11;
                return;
            } else {
                this.We = (i11 * 3840) / i12;
                this.ExN = 3840;
                return;
            }
        }
        if (i11 > 3840) {
            this.We = 3840;
            this.ExN = (i12 * 3840) / i11;
        } else if (i12 > 3840) {
            this.We = (i11 * 3840) / i12;
            this.ExN = 3840;
        }
    }

    public Bitmap sc(byte[] bArr) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.We == 0 && this.ExN == 0) {
            options.inPreferredConfig = this.zY;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i11 = options.outWidth;
            int i12 = options.outHeight;
            int iSc = sc(this.We, this.ExN, i11, i12, this.Qj);
            int iSc2 = sc(this.ExN, this.We, i12, i11, this.Qj);
            options.inJustDecodeBounds = false;
            options.inSampleSize = sc(i11, i12, iSc, iSc2, this.TRI, this.f26511qr);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iSc || bitmapDecodeByteArray.getHeight() > iSc2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iSc, iSc2, true);
                if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 104857600) {
            int width = bitmapDecodeByteArray.getWidth() / 2;
            int height = bitmapDecodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray, width, height, true);
                if (bitmapCreateScaledBitmap2 != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                return bitmapCreateScaledBitmap2;
            }
        }
        return bitmapDecodeByteArray;
    }
}
