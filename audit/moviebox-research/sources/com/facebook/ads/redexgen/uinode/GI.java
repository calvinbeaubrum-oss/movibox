package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GI {
    public static byte[] A02;
    public static String[] A03 = {"o6dtQbEX6DUU2ZPrt5fMpvPTiwhNIFVw", "", "MFXGqw4wC6wJal5", "uC7LPUo8IknDiYQWYNCx", "R0uPVJBemfZgswV0fGveV9P1kI7oDQdd", "Ua883bT78DPlxnLPMdUDySsZEoLcqfDA", "dE9C57ZljM4PWQ1xUFFc", "KkKO0GZU5SD8UwtXdKEVEJnvfx0O6Fgr"};
    public static final Pattern A04;
    public final C1376Hz A00 = new C1376Hz();
    public final StringBuilder A01 = new StringBuilder();

    static {
        A07();
        A04 = Pattern.compile(A01(11, 19, 122));
    }

    public static char A00(C1376Hz c1376Hz, int i11) {
        return (char) c1376Hz.A00[i11];
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 6);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A02(C1376Hz c1376Hz) {
        int iA06 = c1376Hz.A06();
        int iA07 = c1376Hz.A07();
        boolean z11 = false;
        while (iA06 < iA07 && !z11) {
            int i11 = iA06 + 1;
            z11 = ((char) c1376Hz.A00[iA06]) == ')';
            iA06 = i11;
        }
        return c1376Hz.A0S((iA06 - 1) - c1376Hz.A06()).trim();
    }

    public static String A03(C1376Hz c1376Hz, StringBuilder sb2) {
        sb2.setLength(0);
        int iA06 = c1376Hz.A06();
        int iA07 = c1376Hz.A07();
        boolean z11 = false;
        while (iA06 < iA07 && !z11) {
            char c11 = (char) c1376Hz.A00[iA06];
            if ((c11 < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !((c11 >= '0' && c11 <= '9') || c11 == '#' || c11 == '-' || c11 == '.' || c11 == '_'))) {
                z11 = true;
            } else {
                iA06++;
                sb2.append(c11);
            }
        }
        c1376Hz.A0Z(iA06 - c1376Hz.A06());
        return sb2.toString();
    }

    public static String A04(C1376Hz c1376Hz, StringBuilder sb2) {
        A0A(c1376Hz);
        if (c1376Hz.A04() == 0) {
            return null;
        }
        String strA03 = A03(c1376Hz, sb2);
        String strA01 = A01(0, 0, 115);
        return !strA01.equals(strA03) ? strA03 : strA01 + ((char) c1376Hz.A0E());
    }

    public static String A05(C1376Hz c1376Hz, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        boolean z11 = false;
        while (!z11) {
            int iA06 = c1376Hz.A06();
            String strA04 = A04(c1376Hz, sb2);
            if (strA04 == null) {
                return null;
            }
            if (A01(118, 1, 1).equals(strA04) || A01(8, 1, 20).equals(strA04)) {
                c1376Hz.A0Y(iA06);
                z11 = true;
            } else {
                sb3.append(strA04);
            }
        }
        return sb3.toString();
    }

    public static String A06(C1376Hz c1376Hz, StringBuilder sb2) {
        A0A(c1376Hz);
        if (c1376Hz.A04() < 5) {
            return null;
        }
        if (!A01(3, 5, 78).equals(c1376Hz.A0S(5))) {
            return null;
        }
        int iA06 = c1376Hz.A06();
        String strA04 = A04(c1376Hz, sb2);
        if (strA04 == null) {
            return null;
        }
        if (A01(117, 1, 24).equals(strA04)) {
            c1376Hz.A0Y(iA06);
            return A01(0, 0, 115);
        }
        String strA02 = A01(0, 1, 73).equals(strA04) ? A02(c1376Hz) : null;
        String strA05 = A04(c1376Hz, sb2);
        if (!A01(1, 1, 95).equals(strA05) || strA05 == null) {
            return null;
        }
        return strA02;
    }

    public static void A07() {
        A02 = new byte[]{119, -114, -93, -114, -114, -73, -55, -71, 85, -81, -127, -36, -37, -10, -17, -23, -29, -27, -67, -94, -88, -37, -34, -94, -35, -86, -87, -94, -36, -35, -128, Ascii.DEL, -127, -119, -123, -112, -115, -109, -116, -126, 75, -127, -115, -118, -115, -112, -72, -59, -62, -70, -97, -85, -88, -85, -82, 123, -124, -125, -119, 66, 123, 118, -126, 126, -127, -114, -90, -81, -82, -76, 109, -77, -76, -71, -84, -91, -74, -65, -66, -60, 125, -57, -75, -71, -73, -72, -60, -36, -25, -44, -33, -36, -42, -33, -48, -29, -33, -104, -49, -48, -50, -38, -35, -52, -33, -44, -38, -39, -80, -87, -97, -96, -83, -89, -92, -87, -96, -103, -124};
    }

    private void A08(GM gm2, String str) {
        if (A01(0, 0, 115).equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        String[] strArr = A03;
        if (strArr[6].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        A03[2] = "CW487BEDmC1UFYo";
        if (iIndexOf != -1) {
            Matcher matcher = A04.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                gm2.A0K(matcher.group(1));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrA0l = IF.A0l(str, A01(9, 2, 77));
        String str2 = strArrA0l[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            gm2.A0J(str2.substring(0, iIndexOf2));
            gm2.A0I(str2.substring(iIndexOf2 + 1));
        } else {
            gm2.A0J(str2);
        }
        if (strArrA0l.length > 1) {
            gm2.A0L((String[]) Arrays.copyOfRange(strArrA0l, 1, strArrA0l.length));
        }
    }

    public static void A09(C1376Hz c1376Hz) {
        while (!TextUtils.isEmpty(c1376Hz.A0P())) {
        }
    }

    public static void A0A(C1376Hz c1376Hz) {
        boolean z11 = true;
        while (c1376Hz.A04() > 0 && z11) {
            z11 = A0D(c1376Hz) || A0C(c1376Hz);
        }
    }

    public static void A0B(C1376Hz c1376Hz, GM gm2, StringBuilder sb2) {
        A0A(c1376Hz);
        String strA03 = A03(c1376Hz, sb2);
        String strA01 = A01(0, 0, 115);
        if (!strA01.equals(strA03) && A01(2, 1, 99).equals(A04(c1376Hz, sb2))) {
            A0A(c1376Hz);
            String strA05 = A05(c1376Hz, sb2);
            if (strA05 == null || strA01.equals(strA05)) {
                return;
            }
            int iA06 = c1376Hz.A06();
            String strA04 = A04(c1376Hz, sb2);
            String[] strArr = A03;
            if (strArr[4].charAt(25) != strArr[7].charAt(25)) {
                A03[2] = "4K4C1V7x7MHXc7r";
                if (!A01(8, 1, 20).equals(strA04)) {
                    if (A03[2].length() == 15) {
                        A03[2] = "7FFtYIqbw4CKtyv";
                        if (!A01(118, 1, 1).equals(strA04)) {
                            return;
                        }
                    } else if (!A01(118, 1, 1).equals(strA04)) {
                        return;
                    }
                    c1376Hz.A0Y(iA06);
                }
                if (A01(50, 5, 54).equals(strA03)) {
                    gm2.A0C(AbstractC1356Hf.A02(strA05));
                    return;
                }
                if (A01(30, 16, 24).equals(strA03)) {
                    gm2.A0B(AbstractC1356Hf.A02(strA05));
                    return;
                }
                if (!A01(93, 15, 101).equals(strA03)) {
                    if (A01(55, 11, 15).equals(strA03)) {
                        gm2.A0D(strA05);
                        return;
                    }
                    if (A01(76, 11, 74).equals(strA03)) {
                        if (A01(46, 4, 80).equals(strA05)) {
                            gm2.A0E(true);
                            return;
                        }
                        return;
                    } else {
                        if (A01(66, 10, 58).equals(strA03) && A01(87, 6, 109).equals(strA05)) {
                            gm2.A0F(true);
                            return;
                        }
                        return;
                    }
                }
                String[] strArr2 = A03;
                if (strArr2[6].length() == strArr2[3].length()) {
                    String[] strArr3 = A03;
                    strArr3[6] = "4EBATBo3G3iJZ8CvpiMB";
                    strArr3[3] = "oi6BgvCdqkOJFnhZ1QlM";
                    if (A01(108, 9, 53).equals(strA05)) {
                        gm2.A0G(true);
                        return;
                    }
                    return;
                }
            }
            throw new RuntimeException();
        }
    }

    public static boolean A0C(C1376Hz c1376Hz) {
        int iA06 = c1376Hz.A06();
        int iA07 = c1376Hz.A07();
        byte[] bArr = c1376Hz.A00;
        if (iA06 + 2 > iA07) {
            return false;
        }
        int i11 = iA06 + 1;
        if (bArr[iA06] != 47) {
            return false;
        }
        int i12 = i11 + 1;
        if (bArr[i11] != 42) {
            return false;
        }
        while (i12 + 1 < iA07) {
            int i13 = i12 + 1;
            if (((char) bArr[i12]) == '*' && ((char) bArr[i13]) == '/') {
                iA07 = i13 + 1;
                i12 = iA07;
            } else {
                i12 = i13;
            }
        }
        c1376Hz.A0Z(iA07 - c1376Hz.A06());
        return true;
    }

    public static boolean A0D(C1376Hz c1376Hz) {
        switch (A00(c1376Hz, c1376Hz.A06())) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
                c1376Hz.A0Z(1);
                return true;
            default:
                return false;
        }
    }

    public final GM A0E(C1376Hz c1376Hz) {
        this.A01.setLength(0);
        int iA06 = c1376Hz.A06();
        A09(c1376Hz);
        this.A00.A0b(c1376Hz.A00, c1376Hz.A06());
        this.A00.A0Y(iA06);
        String strA06 = A06(this.A00, this.A01);
        if (strA06 != null) {
            if (A01(117, 1, 24).equals(A04(this.A00, this.A01))) {
                GM gm2 = new GM();
                A08(gm2, strA06);
                String strA04 = null;
                boolean z11 = false;
                while (A03[2].length() == 15) {
                    String[] strArr = A03;
                    strArr[0] = "u1M5SbGaD18kT3mlqswMZWeIcd6Kf1Bl";
                    strArr[5] = "tCvfJbvExhfaq7uM8GkpPqKnHxthSgb1";
                    String strA01 = A01(118, 1, 1);
                    if (z11) {
                        if (strA01.equals(strA04)) {
                            return gm2;
                        }
                        return null;
                    }
                    int iA07 = this.A00.A06();
                    strA04 = A04(this.A00, this.A01);
                    z11 = strA04 == null || strA01.equals(strA04);
                    if (!z11) {
                        this.A00.A0Y(iA07);
                        A0B(this.A00, gm2, this.A01);
                    }
                }
                throw new RuntimeException();
            }
        }
        return null;
    }
}
