package com.mbridge.msdk.foundation.tools;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f45079a = 2048;

    public static Bitmap a(Bitmap bitmap, int i11) {
        int i12 = i11 <= 0 ? 10 : i11;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / i12, bitmap.getHeight() / i12, false);
        int width = bitmapCreateScaledBitmap.getWidth();
        int height = bitmapCreateScaledBitmap.getHeight();
        int i13 = width * height;
        int[] iArr = new int[i13];
        bitmapCreateScaledBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i14 = width - 1;
        int i15 = height - 1;
        int[] iArr2 = new int[i13];
        int[] iArr3 = new int[i13];
        int[] iArr4 = new int[i13];
        int[] iArr5 = new int[Math.max(width, height)];
        int[] iArr6 = new int[20736];
        for (int i16 = 0; i16 < 20736; i16++) {
            iArr6[i16] = i16 / 81;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 17, 3);
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i17 >= height) {
                break;
            }
            int i21 = -8;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i31 = 0;
            for (int i32 = 8; i21 <= i32; i32 = 8) {
                Bitmap bitmap2 = bitmapCreateScaledBitmap;
                int i33 = iArr[Math.min(i14, Math.max(i21, 0)) + i18];
                int[] iArr8 = iArr7[i21 + 8];
                iArr8[0] = (i33 & 16711680) >> 16;
                iArr8[1] = (i33 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr8[2] = i33 & 255;
                int iAbs = 9 - Math.abs(i21);
                int i34 = iArr8[0];
                i22 += i34 * iAbs;
                int i35 = iArr8[1];
                i23 += i35 * iAbs;
                int i36 = iArr8[2];
                i24 += iAbs * i36;
                if (i21 > 0) {
                    i28 += i34;
                    i29 += i35;
                    i31 += i36;
                } else {
                    i25 += i34;
                    i26 += i35;
                    i27 += i36;
                }
                i21++;
                bitmapCreateScaledBitmap = bitmap2;
            }
            Bitmap bitmap3 = bitmapCreateScaledBitmap;
            int i37 = 0;
            int i38 = 8;
            while (i37 < width) {
                iArr2[i18] = iArr6[i22];
                iArr3[i18] = iArr6[i23];
                iArr4[i18] = iArr6[i24];
                int i39 = i22 - i25;
                int i40 = i23 - i26;
                int i41 = i24 - i27;
                int[] iArr9 = iArr7[(i38 + 9) % 17];
                int i42 = i25 - iArr9[0];
                int i43 = i26 - iArr9[1];
                int i44 = i27 - iArr9[2];
                if (i17 == 0) {
                    iArr5[i37] = Math.min(i37 + 9, i14);
                }
                int i45 = iArr[i19 + iArr5[i37]];
                int i46 = (i45 & 16711680) >> 16;
                iArr9[0] = i46;
                int i47 = (i45 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[1] = i47;
                int i48 = i45 & 255;
                iArr9[2] = i48;
                int i49 = i28 + i46;
                int i50 = i29 + i47;
                int i51 = i31 + i48;
                i22 = i39 + i49;
                i23 = i40 + i50;
                i24 = i41 + i51;
                i38 = (i38 + 1) % 17;
                int[] iArr10 = iArr7[i38 % 17];
                int i52 = iArr10[0];
                i25 = i42 + i52;
                int i53 = iArr10[1];
                i26 = i43 + i53;
                int i54 = iArr10[2];
                i27 = i44 + i54;
                i28 = i49 - i52;
                i29 = i50 - i53;
                i31 = i51 - i54;
                i18++;
                i37++;
                iArr6 = iArr6;
            }
            i19 += width;
            i17++;
            bitmapCreateScaledBitmap = bitmap3;
        }
        Bitmap bitmap4 = bitmapCreateScaledBitmap;
        int[] iArr11 = iArr6;
        int i55 = 0;
        while (i55 < width) {
            int[] iArr12 = iArr5;
            int i56 = height;
            int[] iArr13 = iArr;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = -8;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            int i65 = 0;
            int i66 = (-8) * width;
            int i67 = 0;
            for (int i68 = 8; i60 <= i68; i68 = 8) {
                int iMax = Math.max(0, i66) + i55;
                int[] iArr14 = iArr7[i60 + 8];
                iArr14[0] = iArr2[iMax];
                iArr14[1] = iArr3[iMax];
                iArr14[2] = iArr4[iMax];
                int iAbs2 = 9 - Math.abs(i60);
                i67 += iArr2[iMax] * iAbs2;
                i57 += iArr3[iMax] * iAbs2;
                i58 += iArr4[iMax] * iAbs2;
                if (i60 > 0) {
                    i63 += iArr14[0];
                    i64 += iArr14[1];
                    i65 += iArr14[2];
                } else {
                    i59 += iArr14[0];
                    i61 += iArr14[1];
                    i62 += iArr14[2];
                }
                if (i60 < i15) {
                    i66 += width;
                }
                i60++;
            }
            int i69 = i55;
            int i70 = i56;
            int i71 = 0;
            int i72 = 8;
            while (i71 < i70) {
                iArr13[i69] = (iArr13[i69] & ViewCompat.MEASURED_STATE_MASK) | (iArr11[i67] << 16) | (iArr11[i57] << 8) | iArr11[i58];
                int i73 = i67 - i59;
                int i74 = i57 - i61;
                int i75 = i58 - i62;
                int[] iArr15 = iArr7[(i72 + 9) % 17];
                int i76 = i59 - iArr15[0];
                int i77 = i61 - iArr15[1];
                int i78 = i62 - iArr15[2];
                if (i55 == 0) {
                    iArr12[i71] = Math.min(i71 + 9, i15) * width;
                }
                int i79 = iArr12[i71] + i55;
                int i80 = iArr2[i79];
                iArr15[0] = i80;
                int i81 = iArr3[i79];
                iArr15[1] = i81;
                int i82 = iArr4[i79];
                iArr15[2] = i82;
                int i83 = i63 + i80;
                int i84 = i64 + i81;
                int i85 = i65 + i82;
                i67 = i73 + i83;
                i57 = i74 + i84;
                i58 = i75 + i85;
                i72 = (i72 + 1) % 17;
                int[] iArr16 = iArr7[i72];
                int i86 = iArr16[0];
                i59 = i76 + i86;
                int i87 = iArr16[1];
                i61 = i77 + i87;
                int i88 = iArr16[2];
                i62 = i78 + i88;
                i63 = i83 - i86;
                i64 = i84 - i87;
                i65 = i85 - i88;
                i69 += width;
                i71++;
                i70 = i70;
            }
            i55++;
            iArr5 = iArr12;
            iArr = iArr13;
            height = i70;
        }
        bitmap4.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap4;
    }
}
