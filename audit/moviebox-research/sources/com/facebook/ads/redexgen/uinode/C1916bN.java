package com.facebook.ads.redexgen.uinode;

import android.content.res.Resources;
import android.widget.LinearLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.transsion.gslb.Worker;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1916bN<NativeViewabilityLogger> implements InterfaceC09590p {
    public static byte[] A0I;
    public static String[] A0J = {"1VlIdrj3fRAASVh0IRQbA", "AKXoeI10d8PJONEXEmQHjWIEkAB2E", "HfXt1ktTFXNYFvURT1ePpe", "VNbNAjzqH3UXN3t9RrTP5z6I5Qa6gPQJ", "DeawL9PzUIlDumNdtXISYTaSpfy6P3Cj", "KNbO6MhxkLbBAZAqlm1H7U8Ouut8mEhI", "i536pd2CEb7n0lc", "TelURl5RBqiFivFSJRRvco6RCKborqoX"};
    public static final String A0K;
    public InterfaceC09670x A00;
    public C09680y A01;
    public C1904bB A02;
    public FV A03;
    public EQ A04;
    public J2 A05;
    public InterfaceC1501Nb A07;
    public C1674Ts A08;
    public B0 A09;
    public RD A0A;
    public RE A0B;
    public String A0D;
    public final String A0H = UUID.randomUUID().toString();
    public boolean A0E = false;
    public boolean A0F = false;
    public boolean A0G = false;
    public C1454Lg A06 = new C1454Lg();
    public Boolean A0C = false;

    static {
        A0B();
        A0K = C1916bN.class.getSimpleName();
    }

    public static String A08(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 19);
            if (A0J[2].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A0J;
            strArr[3] = "viF0h1063r6cbXDqGfnWrC6qPBVBGzAv";
            strArr[7] = "3ywSXssJKLxMazlfVUMLvW6ymO505mlb";
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        FV fv2;
        if (this.A00 != null && this.A09 != null && (fv2 = this.A03) != null && fv2.A0m()) {
            this.A00.AAy(this, this.A09);
        }
        InterfaceC09670x interfaceC09670x = this.A00;
        if (interfaceC09670x != null && this.A0E) {
            boolean z11 = this.A0F;
            if (A0J[2].length() == 29) {
                throw new RuntimeException();
            }
            A0J[2] = "DQYu3GBVfiN4Ml";
            if (z11 || !this.A0G) {
                interfaceC09670x.AAy(this, this.A08);
            }
        }
        this.A04.A0E().A3i(this.A00 != null);
    }

    public static void A0B() {
        A0I = new byte[]{-28, -16, -18, -81, -25, -30, -28, -26, -29, -16, -16, -20, -81, -30, -27, -12, -81, -29, -30, -17, -17, -26, -13, -81, -28, -19, -22, -28, -20, -26, -27, -24, -39, -20, -24, -93, -36, -24, -31, -32, -68, -69, -83, 116, Ascii.DEL};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(int i11, C8T c8t) {
        this.A09 = new B0(this.A04, this.A05, new C1919bQ(this), this.A03, A08(0, 31, Worker.WHAT_QUIT), 2, this.A06);
        this.A0A = new C1918bP(this);
        RE re2 = new RE(this.A09, c8t.A04(), c8t.A09(), true, new WeakReference(this.A0A), this.A04);
        this.A0B = re2;
        re2.A0W(this.A03.A0C());
        this.A0B.A0X(this.A03.A0D());
        this.A09.setVisibility(0);
        this.A04.getResources();
        this.A09.setLayoutParams(new LinearLayout.LayoutParams(-1, i11));
        this.A09.AGY();
    }

    private void A0F(C8T c8t, JSONObject jSONObject) {
        this.A0F = false;
        C1906bD c1906bDA00 = C1906bD.A00(this.A04, jSONObject);
        this.A0D = c1906bDA00.A6T();
        if (AbstractC09560l.A06(this.A04, c1906bDA00, this.A05)) {
            this.A04.A0E().A4K();
            if (A0J[1].length() == 21) {
                throw new RuntimeException();
            }
            String[] strArr = A0J;
            strArr[5] = "gZR2JDZ5mWWs6r6NI6wXuGixksRp1MVw";
            strArr[4] = "FWucwUozmNtfNObopNjSpGj6qBSknBll";
            this.A00.ABw(this, C1401Jb.A00(AdErrorType.NO_FILL));
            return;
        }
        this.A07 = new C1305Fc(this, c1906bDA00);
        C1674Ts c1674Ts = new C1674Ts(this.A04, (WeakReference<InterfaceC1501Nb>) new WeakReference(this.A07), c8t.A04(), A6T());
        this.A08 = c1674Ts;
        c1674Ts.A0G(c8t.A07(), c8t.A08());
        C1917bO c1917bO = new C1917bO(this);
        EQ eq2 = this.A04;
        J2 j11 = this.A05;
        C1674Ts c1674Ts2 = this.A08;
        C1904bB c1904bB = new C1904bB(eq2, j11, c1674Ts2, c1674Ts2.getViewabilityChecker(), c1917bO);
        this.A02 = c1904bB;
        c1904bB.A08(c1906bDA00);
        this.A08.loadDataWithBaseURL(AbstractC1504Ne.A01(AdInternalSettings.getUrlPrefix()), c1906bDA00.A04(), A08(31, 9, 97), A08(40, 5, 52), null);
        this.A0E = true;
        A0A();
    }

    private void A0G(EnumC1403Je enumC1403Je, C8T c8t) {
        if (this.A03 == null || this.A05 == null) {
            return;
        }
        int iA02 = (int) (enumC1403Je.A02() * Resources.getSystem().getDisplayMetrics().density);
        if (C1384Ih.A1n(this.A04) && AnonymousClass62.A0A(this.A03.A0V())) {
            new AnonymousClass62(new C11006c(this.A04), this.A03.A0V(), this.A03.A0P(), this.A03.A0S(), true, new C1921bS(this, iA02, c8t, this)).A0B();
        } else {
            A0C(iA02, c8t);
        }
    }

    public final void A0J(EQ eq2, J2 j11, EnumC1403Je enumC1403Je, InterfaceC09670x interfaceC09670x, JSONObject jSONObject, C8T c8t) {
        eq2.A0E().A3h();
        this.A04 = eq2;
        this.A05 = j11;
        this.A00 = interfaceC09670x;
        this.A0G = C1384Ih.A1M(eq2.getApplicationContext());
        FV fvA02 = FV.A02(jSONObject, this.A04);
        this.A03 = fvA02;
        if (fvA02.A0m()) {
            A0G(enumC1403Je, c8t);
        } else {
            A0F(c8t, jSONObject);
        }
        C09680y c09680y = new C09680y(this.A04, this.A0H, this, interfaceC09670x);
        this.A01 = c09680y;
        c09680y.A02();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09590p
    public final String A6T() {
        return this.A0D;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09590p
    public final AdPlacementType A7e() {
        return AdPlacementType.BANNER;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09590p
    public final boolean AGd() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09590p
    public final void onDestroy() {
        this.A04.A0E().A3f(this.A08 != null);
        C1674Ts c1674Ts = this.A08;
        if (c1674Ts != null) {
            c1674Ts.destroy();
            this.A08 = null;
            this.A07 = null;
        }
        C09680y c09680y = this.A01;
        if (c09680y != null) {
            c09680y.A03();
        }
    }
}
