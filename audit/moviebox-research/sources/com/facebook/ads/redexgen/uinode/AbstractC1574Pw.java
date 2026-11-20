package com.facebook.ads.redexgen.uinode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1574Pw {
    public static boolean A00;
    public static byte[] A01;
    public static String[] A02 = {"Y0rICHp14ARSNu9MlXOQlrQKpJ7V2hwf", "9bmfgm9m8nITbmWk0ICcMAG3MrS", "cwEc0HiI6y8ZhWJ4MUGuUSsWKgKIPOUb", "CeguwAwwe", "1UN8Pz5pD", "KG5kSs2s3o8nfvSCZiVMOrQyfdZTA2DP", "BO8EwxINC4bfwl9QwPIiUjcYWt5Jq71N", "VnsxrIf3KddrD6MinhDJfsdqz9CBs5tu"};

    static {
        A03();
        A00 = true;
    }

    public static BitmapDrawable A00(C1795Yn c1795Yn, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bArrDecode = Base64.decode(str, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (bitmapDecodeByteArray != null && (!A00 || A05(c1795Yn, bitmapDecodeByteArray))) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapDecodeByteArray);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                Resources resources = c1795Yn.getResources();
                if (resources != null) {
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    if (displayMetrics != null) {
                        bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                    } else {
                        A04(c1795Yn, A02(0, 23, 116));
                    }
                } else {
                    A04(c1795Yn, A02(23, 18, 112));
                }
                return bitmapDrawable;
            }
            return null;
        } catch (Throwable th2) {
            c1795Yn.A07().A9a(A02(59, 3, 42), C8A.A1u, new C8B(th2));
            return null;
        }
    }

    public static C1575Px A01(C1795Yn c1795Yn, String str) {
        BitmapDrawable bitmapDrawableA00;
        try {
            if (TextUtils.isEmpty(str) || (bitmapDrawableA00 = A00(c1795Yn, str)) == null) {
                return null;
            }
            C1575Px c1575Px = new C1575Px(c1795Yn);
            if (Build.VERSION.SDK_INT >= 16) {
                c1575Px.setBackground(bitmapDrawableA00);
            } else {
                c1575Px.setBackgroundDrawable(bitmapDrawableA00);
            }
            c1575Px.setClickable(false);
            c1575Px.setFocusable(false);
            return c1575Px;
        } catch (Throwable th2) {
            c1795Yn.A07().A9a(A02(59, 3, 42), C8A.A1u, new C8B(th2));
            return null;
        }
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[2].charAt(4) == 'h') {
                throw new RuntimeException();
            }
            A02[5] = "V4DWKv2CalsHghC0GoFw5ZQ5aRA0odCa";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 71);
            i14++;
        }
    }

    public static void A03() {
        A01 = new byte[]{-1, 36, 46, 43, 39, Ascii.FS, 52, 8, 32, 47, 45, 36, Ascii.RS, 46, -37, 36, 46, -37, 41, 48, 39, 39, -23, 9, Ascii.FS, 42, 38, 44, 41, Ascii.SUB, Ascii.FS, 42, -41, 32, 42, -41, 37, 44, 35, 35, -27, -65, -54, -43, -46, -51, -54, -35, -46, -40, -41, -119, -49, -54, -46, -43, -50, -51, -105, -34, -32, -35};
    }

    public static void A04(C1795Yn c1795Yn, String str) {
        c1795Yn.A07().A9a(A02(59, 3, 42), C8A.A1u, new C8B(str));
    }

    public static boolean A05(C1795Yn c1795Yn, Bitmap bitmap) {
        int i11 = 0;
        while (true) {
            int width = bitmap.getWidth();
            if (A02[2].charAt(4) == 'h') {
                throw new RuntimeException();
            }
            A02[2] = "44dBdHmZhYYzc5DiIB6SXSnn6xfqMO61";
            if (i11 >= width) {
                return true;
            }
            for (int i12 = 0; i12 < bitmap.getHeight(); i12++) {
                if (Color.alpha(bitmap.getPixel(i11, i12)) / 255.0f > 0.03f) {
                    A04(c1795Yn, A02(41, 18, 34));
                    return false;
                }
            }
            i11++;
        }
    }
}
