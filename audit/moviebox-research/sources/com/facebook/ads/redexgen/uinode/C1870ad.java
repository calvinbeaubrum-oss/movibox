package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.Locale;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ad, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1870ad implements AnonymousClass21 {
    public static byte[] A05;
    public static String[] A06 = {"iEaWyjzULIZCFnp1nESlU5XZjwcvRjHd", "KbGYZiX8Pduw0KfpYwrRe1NWFWC1OMxy", "fhu9engps4P6WEn4zln6smGq5lQXex4h", "tbT6PfDqIL055", "rKa5gX4b0", "TAsNWcfBygYGmj6nueBPL3we7Mc4FYi0", "mn5595Nd0", "gAb4cPpeQcskkpTdmUE6rt9G8rZq3FNo"};
    public AdError A00;
    public AnonymousClass20 A01 = AnonymousClass20.A03;
    public AnonymousClass20 A02 = AnonymousClass20.A03;
    public final AbstractC1867aa A03;
    public final C1795Yn A04;

    static {
        A01();
    }

    public C1870ad(C1795Yn c1795Yn, AbstractC1867aa abstractC1867aa) {
        this.A04 = c1795Yn;
        this.A03 = abstractC1867aa;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A06;
            if (strArr[7].charAt(1) != strArr[5].charAt(1)) {
                throw new RuntimeException();
            }
            A06[0] = "d2XCtNqKB2PlkmIVLWNasBjUSsZJOiBr";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 29);
            i14++;
        }
    }

    public static void A01() {
        A05 = new byte[]{-73, Ascii.VT, 6, -73, 118, 104, -95, -73, -67, 104, -85, -87, -74, 104, -85, -80, -87, -74, -81, -83, 104, -111, -74, -68, -83, -81, -70, -87, -68, -79, -73, -74, 104, -115, -70, -70, -73, -70, 104, -75, -73, -84, -83, 104, -86, -63, 104, -69, -83, -68, -68, -79, -74, -81, 104, -119, -84, -101, -83, -68, -68, -79, -74, -81, -69, 118, -69, -83, -68, -111, -74, -68, -83, -81, -70, -87, -68, -79, -73, -74, -115, -70, -70, -73, -70, -107, -73, -84, -83, 112, 113, 112, 108, 107, -97, -114, -109, -113, -104, -115, -113, 120, -113, -98, -95, -103, -100, -107, -103, -59, -62, -64, 115, -41, -14, -17, -18, -25, -96, -23, -18, -12, -27, -14, -18, -31, -20, -96, -12, -14, -31, -18, -13, -23, -12, -23, -17, -18, -82, -15, 0, -7, -67, -64, -78, -75, 121, 122, -63, -74, -67, -59, 118, 119, Ascii.SI, 3, -4, Ascii.SI, -69, 4, Ascii.SO, -69, -4, 7, Ascii.CR, 0, -4, -1, Ascii.DC4, -69, -25, -22, -36, -33, -28, -23, -30, -57, -69, -25, -22, -36, -33, -32, -33, -69, 10, Ascii.CR, -69, -18, -29, -22, -14, -28, -23, -30, -45, -57, -64, -45, Ascii.DEL, -56, -46, Ascii.DEL, -64, -53, -47, -60, -64, -61, -40, Ascii.DEL, -78, -89, -82, -74, -88, -83, -90, -14, -26, -33, -14, -98, -25, -15, -98, -20, -19, -14, -98, -54, -51, -65, -62, -61, -62};
    }

    private void A02(AnonymousClass20 anonymousClass20, AnonymousClass20 anonymousClass21) {
        String strA00 = A00(113, 26, 99);
        String str = A00(108, 5, 54) + anonymousClass20 + A00(0, 4, 122) + anonymousClass21;
        this.A04.A07().A9a(A00(139, 3, 115), C8A.A0e, new C8B(strA00, str));
        this.A04.A0E().AHI(strA00 + ' ' + str);
    }

    private void A03(String str, String str2, boolean z11) {
        AdSettings.IntegrationErrorMode integrationErrorModeA00 = AbstractC09931x.A00(this.A04);
        String str3 = String.format(Locale.US, AdErrorType.INCORRECT_API_CALL_ERROR.getDefaultErrorMessage(), str, str2);
        String strA00 = A00(139, 3, 115);
        String strA01 = A00(91, 17, 13);
        if (!z11) {
            Log.e(strA01, str3);
            this.A04.A07().A9a(strA00, C8A.A0c, new C8B(str3));
            this.A04.A0E().AHH(str3);
            return;
        }
        switch (C09951z.A00[integrationErrorModeA00.ordinal()]) {
            case 1:
                throw new AnonymousClass22(str3 + A00(4, 87, 43));
            case 2:
                this.A03.A08();
                this.A03.A0B(10, AdErrorType.INCORRECT_STATE_ERROR, str3);
                this.A04.A0E().AHH(str3);
                Log.e(strA01, str3);
                this.A04.A07().A9a(strA00, C8A.A0c, new C8B(str3));
                break;
        }
        Log.e(strA01, str3);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass21
    public final boolean A5d() {
        boolean z11 = (this.A01 == AnonymousClass20.A03 || this.A01 == AnonymousClass20.A05) && this.A02 != AnonymousClass20.A08;
        if (z11) {
            this.A01 = AnonymousClass20.A07;
        } else {
            A03(A00(142, 6, 52), A00(154, 42, WebSocketProtocol.PAYLOAD_SHORT), false);
        }
        return !z11;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass21
    public final boolean A5e() {
        AdError adError;
        if (this.A01 == AnonymousClass20.A05 && (adError = this.A00) != null && adError.getErrorCode() == 2008) {
            this.A04.A0E().AEt();
            this.A03.A0B(10, AdErrorType.AD_PRESENTATION_ERROR, null);
            return true;
        }
        boolean z11 = this.A01 == AnonymousClass20.A06 && (this.A02 != AnonymousClass20.A08 || C1384Ih.A0e(this.A04));
        if (z11) {
            this.A01 = AnonymousClass20.A03;
            this.A02 = AnonymousClass20.A08;
        } else {
            AnonymousClass20 anonymousClass20 = this.A01;
            AnonymousClass20 anonymousClass21 = AnonymousClass20.A06;
            String strA00 = A00(148, 6, 49);
            if (anonymousClass20 != anonymousClass21) {
                A03(strA00, A00(219, 18, 97), true);
            } else {
                A03(strA00, A00(196, 23, 66), false);
            }
        }
        return !z11;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass21
    public final AnonymousClass20 A5v() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass21
    public final AnonymousClass20 A5w() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass21
    public final void AFw(AnonymousClass20 anonymousClass20) {
        this.A01 = anonymousClass20;
        this.A02 = anonymousClass20;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass21
    public final void AG0(AdError adError) {
        this.A01 = AnonymousClass20.A05;
        this.A02 = AnonymousClass20.A05;
        this.A00 = adError;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass21
    public final void AG5() {
        if (this.A01 != AnonymousClass20.A07) {
            A02(this.A01, AnonymousClass20.A06);
        }
        this.A01 = AnonymousClass20.A06;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass21
    public final void AGF() {
        if (this.A02 != AnonymousClass20.A08) {
            A02(this.A01, AnonymousClass20.A09);
        }
        this.A02 = AnonymousClass20.A09;
    }
}
