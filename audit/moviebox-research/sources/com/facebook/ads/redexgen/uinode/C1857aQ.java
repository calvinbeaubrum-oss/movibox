package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1857aQ implements AnonymousClass23 {
    public static byte[] A0A;
    public static String[] A0B = {"gd6Snq8TqC5qGLc", "5Vo8FrFWo5Fl4YG5W1yHT6ZfMsOXSACT", "HYpFHiAeuVvng5d4eXQK0awgijL0SEef", "zgL9OdntC9Jt", "c4pha1QVXZPHNWU", "oPtBq8V8zceab2K03f0YSkruz1vfGvQp", "tGZii7gSURWSZ1CI0FSKqsks", "YmWpveYB3lCv"};
    public static final String A0C;
    public long A02;
    public RewardedVideoAd A03;
    public C1F A04;
    public FG A05;
    public final C1795Yn A07;
    public final S2SRewardedVideoAdExtendedListener A08;
    public final C2F A09;
    public int A00 = 0;
    public boolean A06 = false;
    public long A01 = -1;

    static {
        A0A();
        A0C = C1857aQ.class.getSimpleName();
    }

    public C1857aQ(C2F c2f, C2K c2k, String str) {
        this.A09 = c2f;
        this.A07 = c2f.A0B;
        this.A08 = new C1847aG(str, c2k, this, c2f);
    }

    public static String A09(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 93);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0A = new byte[]{120, 87, Ascii.EM, 88, 93, Ascii.EM, 85, 86, 88, 93, Ascii.EM, 80, 74, Ascii.EM, 88, 85, 75, 92, 88, 93, 64, Ascii.EM, 80, 87, Ascii.EM, 73, 75, 86, 94, 75, 92, 74, 74, Ascii.ETB, Ascii.EM, 96, 86, 76, Ascii.EM, 74, 81, 86, 76, 85, 93, Ascii.EM, 78, 88, 80, 77, Ascii.EM, 95, 86, 75, Ascii.EM, 88, 93, 117, 86, 88, 93, 92, 93, 17, Ascii.DLE, Ascii.EM, 77, 86, Ascii.EM, 91, 92, Ascii.EM, 90, 88, 85, 85, 92, 93, 47, Ascii.CAN, Ascii.CAN, 5, Ascii.CAN, 74, 6, 5, Ascii.VT, Ascii.SO, 3, 4, Ascii.CR, 74, Ascii.CAN, Ascii.SI, Ascii.GS, Ascii.VT, Ascii.CAN, Ascii.SO, Ascii.SI, Ascii.SO, 74, Ascii.FS, 3, Ascii.SO, Ascii.SI, 5, 74, Ascii.VT, Ascii.SO, 92, 77, 84};
        if (A0B[6].length() != 24) {
            throw new RuntimeException();
        }
        String[] strArr = A0B;
        strArr[4] = "OGOVhUIoezz1oHK";
        strArr[0] = "xl2MkcRK0CWEWUY";
    }

    private void A0C(String str, AdExperienceType adExperienceType, boolean z11) {
        String strA02;
        if (!this.A06 && this.A05 != null) {
            Log.w(A0C, A09(0, 78, 100));
        }
        A0D(false);
        this.A06 = false;
        C09901u c09901u = new C09901u(this.A09.A0D, EnumC1405Jg.A06, AdPlacementType.REWARDED_VIDEO, EnumC1403Je.A07, 1, this.A09.A0C);
        c09901u.A08(z11);
        if (C1384Ih.A28(this.A07) && (strA02 = C1447Kz.A02(this.A07, this.A09.A06)) != null) {
            C2F c2f = this.A09;
            String[] strArr = A0B;
            if (strArr[2].charAt(28) != strArr[1].charAt(28)) {
                throw new RuntimeException();
            }
            A0B[6] = "NRWBzlFLQPOGySbiiYXSLDN6";
            c2f.A06 = strA02;
        }
        c09901u.A06(this.A09.A06);
        c09901u.A07(this.A09.A07);
        FG fg2 = new FG(this.A09.A0B, c09901u);
        this.A05 = fg2;
        fg2.A0P(new C1859aS(this));
        this.A05.A0U(str, adExperienceType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(boolean z11) {
        FG fg2 = this.A05;
        if (fg2 != null) {
            fg2.A0P(new C1858aR(this));
            this.A05.A0V(z11);
            this.A05 = null;
        }
    }

    public final long A0F() {
        FG fg2 = this.A05;
        if (fg2 != null) {
            return fg2.A0E();
        }
        return -1L;
    }

    public final C2F A0G() {
        return this.A09;
    }

    public final C1795Yn A0H() {
        return this.A07;
    }

    public final void A0I(RewardData rewardData) {
        FG fg2;
        this.A09.A03 = rewardData;
        if (!this.A06 || (fg2 = this.A05) == null) {
            return;
        }
        fg2.A0X(rewardData);
    }

    public final void A0J(String str, AdExperienceType adExperienceType, boolean z11) {
        this.A01 = System.currentTimeMillis();
        try {
            A0C(str, adExperienceType, z11);
        } catch (Exception e11) {
            Log.e(A0C, A09(78, 31, 55), e11);
            this.A09.A0B.A07().A9a(A09(109, 3, 96), C8A.A0b, new C8B(e11));
            AdError adErrorInternalError = AdError.internalError(2004);
            this.A09.A0B.A0E().A2m(C1453Lf.A01(this.A01), adErrorInternalError.getErrorCode(), adErrorInternalError.getErrorMessage());
            this.A08.onError(this.A09.A00(), adErrorInternalError);
        }
    }

    public final boolean A0K() {
        FG fg2 = this.A05;
        return fg2 == null || fg2.A0W();
    }

    public final boolean A0L() {
        return this.A06;
    }

    public final boolean A0M(int i11, long j11) {
        if (!this.A06) {
            this.A08.onError(this.A09.A00(), AdError.SHOW_CALLED_BEFORE_LOAD_ERROR);
            return false;
        }
        if (this.A05 == null) {
            this.A06 = false;
            return false;
        }
        this.A02 = System.currentTimeMillis();
        this.A05.A07.A02(i11);
        this.A05.A07.A03(j11);
        this.A05.A0J();
        this.A06 = false;
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass23
    public final void destroy() {
        A0D(true);
    }
}
