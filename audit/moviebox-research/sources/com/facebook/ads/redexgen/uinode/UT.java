package com.facebook.ads.redexgen.uinode;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class UT extends RelativeLayout implements MD {
    public static byte[] A0F;
    public static String[] A0G = {"VjNTozFJBHBTAbZvfj55MfAwGP9LBSf6", "Pq0aBOwFzXTv3d8c4kUbGJ29Dl7JaeBe", "6Jh9GB1FdSmhvo4jirjJmKwQUVM2B32M", "TGGBgusTs1FvyAgmLwAY3Gsc6eBuJSRW", "x90wDNv6CtBtNBa5WCDyDNAaFj8t5cCY", "GDNjvFSJPJLifqCEdIwxfegvvEeKItWd", "ZGbO0A4ZRQBBFZeQfXm02pkO19XETszh", "zRbEM6nv1u3uOOYe"};
    public static final String A0H;
    public long A00;
    public long A01;
    public String A02;
    public boolean A03;
    public String A04;
    public boolean A05;
    public final C5T A06;
    public final C5V A07;
    public final C1795Yn A08;
    public final J2 A09;
    public final MC A0A;
    public final NJ A0B;
    public final NK A0C;
    public final NS A0D;
    public final U1 A0E;

    static {
        A0D();
        A0H = UT.class.getSimpleName();
    }

    public UT(C5V c5v, C1795Yn c1795Yn, J2 j11, MC mc2) {
        super(c1795Yn);
        UW uw2 = new UW(this);
        this.A06 = uw2;
        this.A05 = true;
        this.A01 = -1L;
        this.A03 = true;
        this.A07 = c5v;
        this.A09 = j11;
        this.A0A = mc2;
        this.A08 = c1795Yn;
        if (c1795Yn.A0D() == null) {
            c1795Yn.A0E().A8e();
        }
        NS nsA0E = A0E();
        this.A0D = nsA0E;
        U1 u11 = (AbstractC1385Ii.A02(c1795Yn) || c1795Yn.A0D() == null) ? new U1(c1795Yn, nsA0E) : new U1(c1795Yn, c1795Yn.A0D(), nsA0E);
        this.A0E = u11;
        NJ nj2 = new NJ(c1795Yn, u11);
        this.A0B = nj2;
        nj2.setId(View.generateViewId());
        nj2.setListener(new UV(this));
        u11.setBrowserNavigationListener(nj2.getBrowserNavigationListener());
        this.A0C = new NK(c1795Yn, null, R.attr.progressBarStyleHorizontal);
        A0F();
        c5v.A0N(uw2);
    }

    public static String A0C(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0G;
            if (strArr[1].charAt(18) == strArr[4].charAt(18)) {
                throw new RuntimeException();
            }
            A0G[7] = "WrA4t0RN";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 62);
            i14++;
        }
    }

    public static void A0D() {
        A0F = new byte[]{114, -120, -120, -107, -120, -84, -41, -43, -120, -85, -41, -42, -36, -51, -42, -36, -120, -76, -41, -55, -52, -51, -52, -120, -68, -47, -43, -51, -94, -120, -70, -48, -48, -35, -48, -4, Ascii.US, 17, Ascii.DC4, -48, -10, Ascii.EM, Ascii.RS, Ascii.EM, 35, Ascii.CAN, -48, 4, Ascii.EM, Ascii.GS, Ascii.NAK, -22, -48, -98, -76, -76, -63, -76, -32, 3, -11, -8, -76, -25, 8, -11, 6, 8, -76, -24, -3, 1, -7, -50, -76, -101, -79, -79, -66, -79, -29, -10, 4, 1, 0, -1, 4, -10, -79, -42, -1, -11, -79, -27, -6, -2, -10, -53, -79, -57, -35, -35, -22, -35, Ascii.DLE, 32, 47, 44, 41, 41, -35, Ascii.SI, 34, Ascii.RS, 33, 54, -35, 17, 38, 42, 34, -9, -35, -112, -90, -90, -77, -90, -39, -21, -7, -7, -17, -11, -12, -90, -52, -17, -12, -17, -7, -18, -90, -38, -17, -13, -21, -64, -90, -116, 92, 114, 114, Ascii.DEL, 114, -102, -77, -64, -74, -66, -73, -60, 114, -90, -69, -65, -73, -116, 114, -90, -42, -45, -37, -41, -55, -42, -124, -41, -55, -41, -41, -51, -45, -46, -124, -56, -59, -40, -59, -124, -48, -45, -53, -53, -55, -56, -124, -92, -124, -58, -57, -44, -38, -39, -97, -57, -47, -58, -45, -48, 9, Ascii.EM, Ascii.SYN, Ascii.RS, Ascii.SUB, Ascii.FF, Ascii.EM, -4, -7, -13, Ascii.CAN, 33, Ascii.RS, Ascii.SUB, 35, 41, 9, 36, 32, Ascii.SUB, 35, -54, -61, -48, -58, -50, -57, -44, -74, -53, -49, -57};
    }

    public NS A0E() {
        return new UU(this);
    }

    public void A0F() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.A0A.A3U(this.A0B, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, this.A0B.getId());
        layoutParams2.addRule(12);
        this.A0A.A3U(this.A0E, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (LD.A02 * 2.0f));
        layoutParams3.addRule(3, this.A0B.getId());
        this.A0C.setProgress(0);
        this.A0A.A3U(this.A0C, layoutParams3);
    }

    public void A0G() {
        this.A07.finish(1);
    }

    public void A0H(String str) {
    }

    public void A9Q(Intent intent, Bundle bundle, C5V c5v) {
        if (this.A01 < 0) {
            this.A01 = System.currentTimeMillis();
        }
        String strA0C = A0C(231, 11, 36);
        String strA0C2 = A0C(220, 11, 119);
        String strA0C3 = A0C(210, 10, 105);
        if (bundle == null) {
            this.A02 = intent.getStringExtra(strA0C3);
            this.A04 = intent.getStringExtra(strA0C2);
            String[] strArr = A0G;
            if (strArr[0].charAt(28) != strArr[2].charAt(28)) {
                throw new RuntimeException();
            }
            A0G[5] = "h34ynCyxETZN0C4DuHOjqZ0ETc7IsjOt";
            this.A00 = intent.getLongExtra(strA0C, -1L);
        } else {
            this.A02 = bundle.getString(strA0C3);
            this.A04 = bundle.getString(strA0C2);
            this.A00 = bundle.getLong(strA0C, -1L);
        }
        String strA0C4 = this.A02;
        if (strA0C4 == null) {
            strA0C4 = A0C(199, 11, 39);
        }
        this.A0B.setUrl(strA0C4);
        this.A0E.loadUrl(strA0C4);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACW(boolean z11) {
        this.A0E.onPause();
        if (this.A03) {
            this.A03 = false;
            NN nnA07 = new NM(this.A0E.getFirstUrl()).A01(this.A00).A03(this.A01).A04(this.A0E.getResponseEndMs()).A00(this.A0E.getDomContentLoadedMs()).A05(this.A0E.getScrollReadyMs()).A02(this.A0E.getLoadFinishMs()).A06(System.currentTimeMillis()).A07();
            this.A09.A9V(this.A04, nnA07.A02());
            if (BuildConfigApi.isDebug()) {
                String str = A0C(169, 30, 38) + System.currentTimeMillis() + A0C(149, 20, 20) + nnA07.A01 + A0C(53, 22, 86) + nnA07.A03 + A0C(75, 24, 83) + nnA07.A04 + A0C(0, 30, 42) + nnA07.A00 + A0C(99, 24, 127) + nnA07.A05 + A0C(30, 23, 114) + nnA07.A02 + A0C(123, 26, 72) + nnA07.A06;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACu(boolean z11) {
        this.A0E.onResume();
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void AFT(Bundle bundle) {
        bundle.putString(A0C(210, 10, 105), this.A02);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public String getCurrentClientToken() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final boolean onActivityResult(int i11, int i12, Intent intent) {
        return false;
    }

    public void onDestroy() {
        this.A07.A0O(this.A06);
        AbstractC1504Ne.A03(this.A0E);
        this.A0E.destroy();
    }

    public void setListener(MC mc2) {
    }
}
