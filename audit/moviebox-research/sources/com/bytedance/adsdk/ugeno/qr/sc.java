package com.bytedance.adsdk.ugeno.qr;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.transsion.gslb.Utils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.qr.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0234sc {
        public int[] pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public GradientDrawable.Orientation f26444sc;
        public float[] zY;
    }

    public static GradientDrawable.Orientation We(String str) {
        try {
            int i11 = str.contains("deg") ? Integer.parseInt(str.substring(0, str.length() - 3).trim()) : Integer.parseInt(str);
            if (i11 == 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i11 == 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i11 == 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            if (i11 == 135) {
                return GradientDrawable.Orientation.TL_BR;
            }
            return i11 == 45 ? GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    public static C0234sc pFF(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strSubstring = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")"));
            if (TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            int iSc = sc(strSubstring, '%');
            int iIndexOf = strSubstring.indexOf(",");
            String strSubstring2 = strSubstring.substring(0, iIndexOf);
            C0234sc c0234sc = new C0234sc();
            c0234sc.f26444sc = We(strSubstring2);
            String strSubstring3 = strSubstring.substring(iIndexOf + 1);
            int[] iArr = new int[iSc];
            float[] fArr = new float[iSc];
            for (int i11 = 0; i11 < iSc; i11++) {
                int iIndexOf2 = strSubstring3.indexOf("%");
                String strTrim = strSubstring3.substring(0, iIndexOf2 + 1).trim();
                int iIndexOf3 = (strTrim.contains("rgba") ? strTrim.indexOf(")") : strTrim.indexOf(" ")) + 1;
                iArr[i11] = sc(strTrim.substring(0, iIndexOf3).trim());
                fArr[i11] = zY.sc(strTrim.substring(iIndexOf3, strTrim.indexOf("%")).trim(), 0.0f) / 100.0f;
                int i12 = iIndexOf2 + 2;
                if (strSubstring3.length() <= i12) {
                    break;
                }
                strSubstring3 = strSubstring3.substring(i12);
            }
            if (iSc < 2) {
                return null;
            }
            c0234sc.pFF = iArr;
            c0234sc.zY = fArr;
            return c0234sc;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int sc(int i11, int i12) {
        if (i12 < 0 || i12 > 255) {
            Log.e("ColorUtils", "alpha must be between 0 and 255. ");
            i12 = 255;
        }
        return (i11 & 16777215) | (i12 << 24);
    }

    public static int sc(String str) {
        return sc(str, ViewCompat.MEASURED_STATE_MASK);
    }

    public static int sc(String str, char c11) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            if (str.charAt(i12) == c11) {
                i11++;
            }
        }
        return i11;
    }

    public static int sc(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 4) {
            StringBuilder sb2 = new StringBuilder(Utils.SEPARATOR);
            char[] charArray = str.toCharArray();
            for (int i12 = 1; i12 < charArray.length; i12++) {
                sb2.append(charArray[i12]);
                sb2.append(charArray[i12]);
            }
            return Color.parseColor(sb2.toString());
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (!str.startsWith("rgba")) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (strArrSplit == null || strArrSplit.length != 4) {
            return i11;
        }
        return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2]));
    }

    public static boolean zY(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("linear-gradient");
    }
}
