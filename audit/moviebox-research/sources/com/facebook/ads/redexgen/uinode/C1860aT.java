package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1860aT implements AnonymousClass23 {
    public static byte[] A09;
    public static String[] A0A = {"Q9RghtL5kPMxXUG2hlpmHrVaJwYYGwGq", "TIO3FaU0Mikock0w3rckrPhiuYRMfGhJ", "k6SAISDvmHdOF1rkjeEeymm6HvDlJVR0", "eDRhFd25R2oFsFg27vb0d5UADzs1KoZv", "MaVPWgska1IH7XOKtPwNB8GdxIWUIxDt", "dS1g8OO0fBonmOwqVSSlXi39LbvMIXQb", "JdFW5Fpsu4G", "QGzwgj8zvaLwI8"};
    public static final String A0B;
    public long A00 = -1;
    public InterstitialAd A01;
    public C1F A02;
    public FQ A03;
    public boolean A04;
    public boolean A05;
    public final C1795Yn A06;
    public final InterstitialAdExtendedListener A07;
    public final AnonymousClass26 A08;

    static {
        A0A();
        A0B = C1860aT.class.getSimpleName();
    }

    public C1860aT(AnonymousClass26 anonymousClass26, C2K c2k, String str) {
        this.A08 = anonymousClass26;
        this.A06 = anonymousClass26.A05();
        this.A07 = new C1848aH(str, c2k, this);
    }

    public static String A09(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 110);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A09 = new byte[]{-59, -14, -92, -27, -24, -92, -16, -13, -27, -24, -92, -19, -9, -92, -27, -16, -10, -23, -27, -24, -3, -92, -19, -14, -92, -12, -10, -13, -21, -10, -23, -9, -9, -78, -92, -35, -13, -7, -92, -9, -20, -13, -7, -16, -24, -92, -5, -27, -19, -8, -92, -22, -13, -10, -92, -27, -24, -48, -13, -27, -24, -23, -24, -84, -83, -92, -8, -13, -92, -26, -23, -92, -25, -27, -16, -16, -23, -24, -4, 33, 39, Ascii.CAN, 37, 38, 39, Ascii.FS, 39, Ascii.FS, Ascii.DC4, Ascii.US, -45, Ascii.US, 34, Ascii.DC4, Ascii.ETB, -45, Ascii.SYN, Ascii.DC4, Ascii.US, Ascii.US, Ascii.CAN, Ascii.ETB, -45, 42, Ascii.ESC, Ascii.FS, Ascii.US, Ascii.CAN, -45, 38, Ascii.ESC, 34, 42, Ascii.FS, 33, Ascii.SUB, -45, Ascii.FS, 33, 39, Ascii.CAN, 37, 38, 39, Ascii.FS, 39, Ascii.FS, Ascii.DC4, Ascii.US, -31, Ascii.CR, Ascii.FS, Ascii.NAK};
    }

    public final long A0D() {
        FQ fq2 = this.A03;
        if (fq2 != null) {
            return fq2.A0E();
        }
        return -1L;
    }

    public final AnonymousClass26 A0E() {
        return this.A08;
    }

    public final C1795Yn A0F() {
        return this.A06;
    }

    public final void A0G(EnumSet<CacheFlag> enumSet, String str) {
        String strA02;
        this.A00 = System.currentTimeMillis();
        if (!this.A05 && this.A03 != null) {
            Log.w(A0B, A09(0, 78, 22));
        }
        this.A05 = false;
        if (this.A04 && !C1384Ih.A0e(this.A06)) {
            this.A06.A07().A9a(A09(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 3, 62), C8A.A0L, new C8B(A09(78, 52, 69)));
            AdErrorType adErrorType = AdErrorType.LOAD_CALLED_WHILE_SHOWING_AD;
            this.A06.A0E().A2m(C1453Lf.A01(this.A00), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
            this.A07.onError(this.A08.A01(), new AdError(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage()));
            return;
        }
        FQ fq2 = this.A03;
        if (fq2 != null) {
            fq2.A0P(new C1865aY(this));
            this.A03.A0K();
            this.A03 = null;
        }
        C09901u c09901u = new C09901u(this.A08.A0A(), AbstractC1407Ji.A00(this.A06.getResources().getDisplayMetrics()), AdPlacementType.INTERSTITIAL, EnumC1403Je.A07, 1, enumSet, this.A08.A06());
        if (C1384Ih.A28(this.A06) && (strA02 = C1447Kz.A02(this.A06, this.A08.A08())) != null) {
            AnonymousClass26 anonymousClass26 = this.A08;
            if (A0A[6].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[3] = "6YCA3PHZSlLj0jmN2b2hvaW99ZyRMwjh";
            strArr[5] = "7PoIPIeUN8KAt8vfreK3c69iBAU82q7R";
            anonymousClass26.A0I(strA02);
        }
        c09901u.A06(this.A08.A08());
        c09901u.A07(this.A08.A09());
        c09901u.A04(this.A08.A03());
        FQ fq3 = new FQ(this.A06, c09901u);
        this.A03 = fq3;
        fq3.A0P(new C1862aV(this));
        this.A03.A0T(str);
    }

    public final boolean A0H() {
        FQ fq2 = this.A03;
        return fq2 == null || fq2.A0W();
    }

    public final boolean A0I() {
        return this.A05;
    }

    public final boolean A0J() {
        AdError adError = AdError.SHOW_CALLED_BEFORE_LOAD_ERROR;
        if (!this.A05) {
            this.A06.A0E().A2m(C1453Lf.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A07.onError(this.A08.A01(), adError);
            return false;
        }
        FQ fq2 = this.A03;
        if (fq2 != null) {
            fq2.A0J();
            this.A04 = true;
            this.A05 = false;
            return true;
        }
        this.A06.A07().A9a(A09(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 3, 62), C8A.A0S, new C8B(AdErrorType.INTERSTITIAL_CONTROLLER_IS_NULL.getDefaultErrorMessage()));
        this.A06.A0E().A2m(C1453Lf.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
        this.A07.onError(this.A08.A01(), adError);
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass23
    public final void destroy() {
        FQ fq2 = this.A03;
        if (fq2 != null) {
            fq2.A0P(new C1861aU(this));
            this.A03.A0V(true);
            this.A03 = null;
            this.A05 = false;
            this.A04 = false;
        }
    }
}
