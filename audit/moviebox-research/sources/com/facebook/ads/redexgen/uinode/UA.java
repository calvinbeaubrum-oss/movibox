package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UA implements MD {
    public static byte[] A0D;
    public int A00;
    public SF A01;
    public C9I A02;
    public String A03;
    public final C1795Yn A04;
    public final J2 A05;
    public final MC A06;
    public final InterfaceC1478Me A07;
    public final SA A08;
    public final AbstractC1572Pu A09;
    public final AbstractC1570Ps A0A;
    public final AbstractC1539On A0B;
    public final O7 A0C;

    static {
        A03();
    }

    public UA(C1795Yn c1795Yn, InterfaceC1478Me interfaceC1478Me, J2 j11, MC mc2) {
        BU bu2 = new BU(this);
        this.A0C = bu2;
        BT bt2 = new BT(this);
        this.A0B = bt2;
        BS bs2 = new BS(this);
        this.A09 = bs2;
        BR br2 = new BR(this);
        this.A0A = br2;
        this.A04 = c1795Yn;
        this.A05 = j11;
        this.A07 = interfaceC1478Me;
        SA sa2 = new SA(c1795Yn);
        this.A08 = sa2;
        sa2.A0c(new AnonymousClass86(c1795Yn));
        sa2.getEventBus().A03(bu2, bt2, bs2, br2);
        this.A06 = mc2;
        sa2.setIsFullScreen(true);
        sa2.setVolume(1.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        mc2.A3U(sa2, layoutParams);
        MK mk2 = new MK(c1795Yn);
        mk2.setOnClickListener(new ViewOnClickListenerC1476Mc(this));
        mc2.A3U(mk2, mk2.getDefaultLayoutParams());
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 38);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0D = new byte[]{-49, -29, -30, -35, -34, -38, -49, -25, -17, -8, -11, -15, -6, 0, -32, -5, -9, -15, -6, -68, -70, -84, -107, -88, -69, -80, -67, -84, -118, -69, -88, -119, -68, -69, -69, -74, -75, -73, -86, -91, -90, -80, -118, -81, -75, -90, -77, -76, -75, -86, -75, -94, -83, -122, -73, -90, -81, -75, -99, -112, -117, -116, -106, 115, -106, -114, -114, -116, -103, -2, -15, -20, -19, -9, -43, -40, -52, Ascii.CAN, Ascii.VT, 6, 7, 17, -11, 7, 7, Ascii.CR, -10, Ascii.VT, Ascii.SI, 7, -66, -79, -84, -83, -73, -99, -102, -108};
    }

    public final void A04(int i11) {
        this.A08.setVideoProgressReportIntervalMs(i11);
    }

    public final void A05(View view) {
        this.A08.setControlsAnchorView(view);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void A9Q(Intent intent, Bundle bundle, C5V c5v) {
        String strA02 = A02(8, 11, 102);
        if (bundle == null) {
            this.A03 = intent.getStringExtra(strA02);
        } else {
            this.A03 = bundle.getString(strA02);
        }
        String stringExtra = intent.getStringExtra(A02(19, 18, 33));
        if (stringExtra != null && !stringExtra.isEmpty()) {
            C1565Pn c1565Pn = new C1565Pn(this.A04, stringExtra);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i11 = (int) (16.0f * LD.A02);
            layoutParams.setMargins(i11, i11, i11, i11);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            c1565Pn.setOnClickListener(new ViewOnClickListenerC1477Md(this));
            this.A06.A3U(c1565Pn, layoutParams);
        }
        this.A00 = intent.getIntExtra(A02(77, 13, 124), 0);
        this.A02 = new C9I(this.A04, this.A05, this.A08, this.A03, intent.getBundleExtra(A02(58, 11, 1)));
        if (C1384Ih.A1X(this.A04)) {
            this.A01 = new SF(this.A04, this.A05, this.A08, this.A03, this.A02, null);
        } else {
            this.A01 = null;
        }
        this.A08.setVideoMPD(intent.getStringExtra(A02(69, 8, 98)));
        this.A08.setVideoURI(intent.getStringExtra(A02(90, 8, 34)));
        int i12 = this.A00;
        if (i12 > 0) {
            this.A08.A0Y(i12);
        }
        if (intent.getBooleanExtra(A02(0, 8, 72), false)) {
            this.A08.A0b(QM.A04, 17);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACW(boolean z11) {
        this.A06.A44(A02(37, 21, 27), new C1562Pk());
        this.A08.A0W();
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACu(boolean z11) {
        this.A06.A44(A02(37, 21, 27), new P5());
        if (this.A08.A0j()) {
            return;
        }
        this.A08.A0b(QM.A04, 18);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void AFT(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final String getCurrentClientToken() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final boolean onActivityResult(int i11, int i12, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void onDestroy() {
        this.A06.A44(A02(37, 21, 27), new C1491Mr(this.A00, this.A08.getCurrentPositionInMillis()));
        this.A02.A0e(this.A08.getCurrentPositionInMillis());
        SF sf2 = this.A01;
        if (sf2 != null) {
            sf2.A0D();
        }
        this.A08.A0Z(1);
        this.A08.A0V();
    }
}
