package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VQ implements J2 {
    public static J2 A03;
    public static byte[] A04;
    public static final String A05;
    public static volatile boolean A06;
    public final C1794Ym A00;
    public final C8w A01;
    public final J1 A02;

    static {
        A03();
        A05 = VQ.class.getSimpleName();
        A06 = false;
    }

    public VQ(C1794Ym c1794Ym) {
        J0 j0A01;
        this.A00 = c1794Ym;
        if (Ij.A0T(c1794Ym)) {
            C8w c8wA00 = AbstractC11598u.A00(c1794Ym);
            this.A01 = c8wA00;
            j0A01 = J7.A00(c1794Ym, c8wA00);
        } else {
            EN enA01 = AbstractC11598u.A01(c1794Ym);
            j0A01 = J7.A01(c1794Ym, enA01);
            this.A01 = enA01;
        }
        this.A02 = new VT(c1794Ym, j0A01);
        ExecutorC1467Lt.A08.execute(new VS(this));
        A04(c1794Ym);
    }

    public static synchronized J2 A01(C1794Ym c1794Ym) {
        if (A03 == null) {
            A03 = new VQ(c1794Ym);
        }
        return A03;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{-90, -21, -4, -21, -12, -6, -76, -88, -37, -37, -52, -44, -41, -37, -48, -43, -50, -121, -37, -42, -121, -45, -42, -50, -121, -56, -43, -121, -48, -43, -35, -56, -45, -48, -53, -121, -43, -13, -30, -28, -26, -24, -26, -17, -26, -13, -22, -28, 46, 51, 42, Ascii.US};
    }

    public static synchronized void A04(C1794Ym c1794Ym) {
        if (A06) {
            return;
        }
        c1794Ym.A03().AAd();
        A06 = true;
    }

    private void A05(C1400Iz c1400Iz) {
        if (!c1400Iz.A0A()) {
            Log.e(A05, A02(7, 29, 24) + c1400Iz.A06() + A02(0, 7, 55));
        } else {
            A06(c1400Iz);
            this.A01.AHE(c1400Iz, new VR(this, c1400Iz));
        }
    }

    private void A06(C1400Iz c1400Iz) {
        switch (J3.A00[c1400Iz.A06().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                C8B c8b = new C8B(new Exception(A02(36, 5, 50)));
                c8b.A05(1);
                try {
                    c8b.A07(new JSONObject().put(A02(48, 4, 107), c1400Iz.A06().toString()));
                    break;
                } catch (JSONException unused) {
                }
                this.A00.A07().A9b(A02(41, 7, 50), C8A.A1H, c8b);
                break;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9T(String str, Map<String, String> map) {
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A04).A02(J5.A04).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9V(String str, Map<String, String> map) {
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A04).A02(J5.A06).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9W(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A04).A02(J5.A07).A06(JC.A0A(str, J9.A0I)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9X(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A04).A02(J5.A08).A06(JC.A0A(str, J9.A06)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9Z(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A04).A02(J5.A0B).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9d(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A04).A02(J5.A0C).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9g(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A05).A02(J5.A0D).A06(JC.A0A(str, J9.A0T)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9h(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A05).A02(J5.A0E).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9i(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A05).A02(J5.A0F).A06(JC.A0A(str, J9.A0V)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9j(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A05).A02(J5.A0K).A06(JC.A0A(str, J9.A0W)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9s(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A05).A02(J5.A0H).A06(JC.A0A(str, J9.A0X)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9u(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A04).A02(J5.A0J).A06(JC.A0A(str, J9.A0Y)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9v(String str, Map<String, String> map, String str2, J4 j11) {
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(j11).A02(J5.A00(str2)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void A9w(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A04).A02(J5.A0L).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void AA0(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A05).A02(J5.A0N).A06(JC.A0A(str, J9.A0a)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void AA1(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A05).A02(J5.A0O).A06(JC.A0A(str, J9.A0b)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void AA3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A01(J4.A04).A02(J5.A0P).A06(JC.A0A(str, J9.A0c)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void AA4(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A04).A02(J5.A0G).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void AA8(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A05).A02(J5.A0Q).A06(JC.A0A(str, J9.A0g)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void AA9(String str, Map<String, String> map) {
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A05).A02(J5.A0V).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void AAB(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new C1399Iy().A04(str).A00(this.A00.A08().A01()).A03(this.A00.A08().A02()).A05(map).A01(J4.A05).A02(J5.A0W).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.J2
    public final void AE1(String str) {
        new AsyncTaskC1608Re(this.A00).execute(str);
    }
}
