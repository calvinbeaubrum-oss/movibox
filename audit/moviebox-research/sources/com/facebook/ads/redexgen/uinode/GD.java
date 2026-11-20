package com.facebook.ads.redexgen.uinode;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class GD {
    public static byte[] A00;
    public static String[] A01 = {"xVcH0cVTcM5dU0QEBrIHPQrgB87ckwr3", "Yf7aft0T7tBGFrMB58RtpYM4TkcmUw5V", "ISkGeuFN5Zur6LMrf", "n8NQXDKEWUvjAMPXZcFJTvL046WVMJJd", "llz3D7", "D2JaB4yw3jvtMDgGovIRxLPj", "1AmkBf3sygWt0Ydi8ksa8eUE1O", "BOb6KOWWr15AuA974NLt7KdVjpKhFTgP"};

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
    
        if (r4 == 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
    
        return r6.A0E(r8.get(r7[0]));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if (r4 == 1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static GH A00(GH gh2, String[] strArr, Map<String, GH> map) {
        if (gh2 == null && strArr == null) {
            if (A01[2].length() != 17) {
                throw new RuntimeException();
            }
            A01[3] = "hdj5xkr89sMqDNtQe3zjMhPrx8WAgiZJ";
            return null;
        }
        int i11 = 0;
        if (gh2 == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (gh2 == null && strArr.length > 1) {
            GH gh3 = new GH();
            int length = strArr.length;
            while (i11 < length) {
                gh3.A0E(map.get(strArr[i11]));
                i11++;
            }
            return gh3;
        }
        if (gh2 != null && strArr != null) {
            int length2 = strArr.length;
            if (A01[3].charAt(24) != '6') {
                A01[4] = "zDaVAZ4";
            }
        }
        if (gh2 == null || strArr == null || strArr.length <= 1) {
            return gh2;
        }
        int length3 = strArr.length;
        while (i11 < length3) {
            gh2.A0E(map.get(strArr[i11]));
            i11++;
        }
        return gh2;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A02(String str) {
        String strA01 = A01(1, 2, 90);
        String strA02 = A01(0, 1, 123);
        String strReplaceAll = str.replaceAll(strA01, strA02).replaceAll(A01(4, 5, 59), strA02);
        String strA03 = A01(3, 1, 49);
        return strReplaceAll.replaceAll(strA02, strA03).replaceAll(A01(9, 11, 63), strA03);
    }

    public static void A03() {
        if (A01[4].length() == 29) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[5] = "VQDAG0Hjx9dAkblLnkOv7N5A";
        strArr[6] = "N4JdvVtxtXseuXAHK8DjAghucx";
        A00 = new byte[]{-26, -56, -59, -78, -68, -58, -90, -68, -58, -5, -64, -87, -4, Ascii.CAN, -48, -30, -84, -83, -3, -53};
    }

    public static void A04(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    public static void A05(SpannableStringBuilder spannableStringBuilder, int i11, int i12, GH gh2) {
        if (gh2.A07() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(gh2.A07()), i11, i12, 33);
        }
        if (gh2.A0P()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i11, i12, 33);
        }
        if (gh2.A0Q()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
        }
        if (gh2.A0O()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(gh2.A05()), i11, i12, 33);
        }
        if (gh2.A0N()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(gh2.A04()), i11, i12, 33);
        }
        if (gh2.A0L() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(gh2.A0L()), i11, i12, 33);
        }
        if (gh2.A08() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(gh2.A08()), i11, i12, 33);
        }
        switch (gh2.A06()) {
            case 1:
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) gh2.A03(), true), i11, i12, 33);
                break;
            case 2:
                spannableStringBuilder.setSpan(new RelativeSizeSpan(gh2.A03()), i11, i12, 33);
                break;
            case 3:
                spannableStringBuilder.setSpan(new RelativeSizeSpan(gh2.A03() / 100.0f), i11, i12, 33);
                break;
        }
    }
}
