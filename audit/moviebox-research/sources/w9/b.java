package w9;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static Bitmap a(Bitmap bitmap, int i11, boolean z11) {
        Bitmap bitmapCopy;
        Bitmap bitmap2;
        int i12 = i11;
        if (z11) {
            bitmapCopy = bitmap;
        } else {
            try {
                bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
            } catch (Throwable th2) {
                com.cloud.hisavana.sdk.z.a().e(Log.getStackTraceString(th2));
                return null;
            }
        }
        if (i12 < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i13 = width * height;
        int[] iArr = new int[i13];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i14 = width - 1;
        int i15 = height - 1;
        int i16 = i12 + i12;
        int i17 = i16 + 1;
        int[] iArr2 = new int[i13];
        int[] iArr3 = new int[i13];
        int[] iArr4 = new int[i13];
        int[] iArr5 = new int[Math.max(width, height)];
        int i18 = (i16 + 2) >> 1;
        int i19 = i18 * i18;
        int i21 = i19 * 256;
        int[] iArr6 = new int[i21];
        for (int i22 = 0; i22 < i21; i22++) {
            iArr6[i22] = i22 / i19;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i17, 3);
        int i23 = i12 + 1;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (true) {
            bitmap2 = bitmapCopy;
            if (i24 >= height) {
                break;
            }
            int i27 = height;
            int i28 = 0;
            int i29 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            int i36 = 0;
            int i37 = -i12;
            int i38 = 0;
            while (i37 <= i12) {
                int i39 = i15;
                int[] iArr8 = iArr5;
                int i40 = iArr[i25 + Math.min(i14, Math.max(i37, 0))];
                int[] iArr9 = iArr7[i37 + i12];
                iArr9[0] = (i40 & 16711680) >> 16;
                iArr9[1] = (i40 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i40 & 255;
                int iAbs = i23 - Math.abs(i37);
                int i41 = iArr9[0];
                i29 += i41 * iAbs;
                int i42 = iArr9[1];
                i28 += i42 * iAbs;
                int i43 = iArr9[2];
                i38 += iAbs * i43;
                if (i37 > 0) {
                    i34 += i41;
                    i36 += i42;
                    i35 += i43;
                } else {
                    i33 += i41;
                    i32 += i42;
                    i31 += i43;
                }
                i37++;
                i15 = i39;
                iArr5 = iArr8;
            }
            int i44 = i15;
            int[] iArr10 = iArr5;
            int i45 = i12;
            int i46 = i38;
            int i47 = 0;
            while (i47 < width) {
                iArr2[i25] = iArr6[i29];
                iArr3[i25] = iArr6[i28];
                iArr4[i25] = iArr6[i46];
                int i48 = i29 - i33;
                int i49 = i28 - i32;
                int i50 = i46 - i31;
                int[] iArr11 = iArr7[((i45 - i12) + i17) % i17];
                int i51 = i33 - iArr11[0];
                int i52 = i32 - iArr11[1];
                int i53 = i31 - iArr11[2];
                if (i24 == 0) {
                    iArr10[i47] = Math.min(i47 + i12 + 1, i14);
                }
                int i54 = iArr[i26 + iArr10[i47]];
                int i55 = (i54 & 16711680) >> 16;
                iArr11[0] = i55;
                int i56 = (i54 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[1] = i56;
                int i57 = i54 & 255;
                iArr11[2] = i57;
                int i58 = i34 + i55;
                int i59 = i36 + i56;
                int i60 = i35 + i57;
                i29 = i48 + i58;
                i28 = i49 + i59;
                i46 = i50 + i60;
                i45 = (i45 + 1) % i17;
                int[] iArr12 = iArr7[i45 % i17];
                int i61 = iArr12[0];
                i33 = i51 + i61;
                int i62 = iArr12[1];
                i32 = i52 + i62;
                int i63 = iArr12[2];
                i31 = i53 + i63;
                i34 = i58 - i61;
                i36 = i59 - i62;
                i35 = i60 - i63;
                i25++;
                i47++;
                iArr6 = iArr6;
            }
            i26 += width;
            i24++;
            bitmapCopy = bitmap2;
            height = i27;
            i15 = i44;
            iArr5 = iArr10;
        }
        int i64 = i15;
        int[] iArr13 = iArr5;
        int i65 = height;
        int[] iArr14 = iArr6;
        int i66 = 0;
        while (i66 < width) {
            int i67 = -i12;
            int i68 = i17;
            int[] iArr15 = iArr;
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            int i72 = 0;
            int i73 = 0;
            int i74 = 0;
            int i75 = 0;
            int i76 = i67;
            int i77 = i67 * width;
            int i78 = 0;
            int i79 = 0;
            while (i76 <= i12) {
                int i80 = width;
                int iMax = Math.max(0, i77) + i66;
                int[] iArr16 = iArr7[i76 + i12];
                iArr16[0] = iArr2[iMax];
                iArr16[1] = iArr3[iMax];
                iArr16[2] = iArr4[iMax];
                int iAbs2 = i23 - Math.abs(i76);
                i69 += iArr2[iMax] * iAbs2;
                i79 += iArr3[iMax] * iAbs2;
                i78 += iArr4[iMax] * iAbs2;
                if (i76 > 0) {
                    i75 += iArr16[0];
                    i74 += iArr16[1];
                    i73 += iArr16[2];
                } else {
                    i72 += iArr16[0];
                    i71 += iArr16[1];
                    i70 += iArr16[2];
                }
                int i81 = i64;
                if (i76 < i81) {
                    i77 += i80;
                }
                i76++;
                i64 = i81;
                width = i80;
            }
            int i82 = width;
            int i83 = i64;
            int i84 = i12;
            int i85 = i66;
            int i86 = i69;
            int i87 = i65;
            int i88 = 0;
            while (i88 < i87) {
                iArr15[i85] = (iArr15[i85] & ViewCompat.MEASURED_STATE_MASK) | (iArr14[i86] << 16) | (iArr14[i79] << 8) | iArr14[i78];
                int i89 = i86 - i72;
                int i90 = i79 - i71;
                int i91 = i78 - i70;
                int[] iArr17 = iArr7[((i84 - i12) + i68) % i68];
                int i92 = i72 - iArr17[0];
                int i93 = i71 - iArr17[1];
                int i94 = i70 - iArr17[2];
                if (i66 == 0) {
                    iArr13[i88] = Math.min(i88 + i23, i83) * i82;
                }
                int i95 = iArr13[i88] + i66;
                int i96 = iArr2[i95];
                iArr17[0] = i96;
                int i97 = iArr3[i95];
                iArr17[1] = i97;
                int i98 = iArr4[i95];
                iArr17[2] = i98;
                int i99 = i75 + i96;
                int i100 = i74 + i97;
                int i101 = i73 + i98;
                i86 = i89 + i99;
                i79 = i90 + i100;
                i78 = i91 + i101;
                i84 = (i84 + 1) % i68;
                int[] iArr18 = iArr7[i84];
                int i102 = iArr18[0];
                i72 = i92 + i102;
                int i103 = iArr18[1];
                i71 = i93 + i103;
                int i104 = iArr18[2];
                i70 = i94 + i104;
                i75 = i99 - i102;
                i74 = i100 - i103;
                i73 = i101 - i104;
                i85 += i82;
                i88++;
                i12 = i11;
            }
            i66++;
            i12 = i11;
            i64 = i83;
            i65 = i87;
            i17 = i68;
            iArr = iArr15;
            width = i82;
        }
        int i105 = width;
        bitmap2.setPixels(iArr, 0, i105, 0, 0, i105, i65);
        return bitmap2;
    }
}
