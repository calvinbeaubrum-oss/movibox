package com.facebook.ads.redexgen.uinode;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class T8 extends PQ {
    public static String[] A07 = {"itiy11Wl5lP7QtpB3", "v6A5WW2CB", "SYp5FzxPKMl", "MKN0lN1Uug", "IQIXhYysWoH9a5YMZx5hFMUL6lEdxT5q", "FECz3BMfLn4pJfwLFVrIm2wrzlNMsWJ3", "RmVgcuWcoU56A5AXkQhrmgSRFj76ryom", "F5uv5dts8QHAu8Ovw"};
    public static final RelativeLayout.LayoutParams A08 = new RelativeLayout.LayoutParams(-1, -1);
    public L9 A00;
    public OL A01;
    public final int A02;
    public final ImageView A03;
    public final MB A04;
    public final InterfaceC1555Pd A05;
    public final AtomicBoolean A06;

    public T8(C1795Yn c1795Yn, InterfaceC1483Mj interfaceC1483Mj, int i11, J2 j11, AbstractC1898b5 abstractC1898b5, MC mc2, FullScreenAdToolbar fullScreenAdToolbar, boolean z11, boolean z12, InterfaceC1555Pd interfaceC1555Pd, int i12) {
        super(c1795Yn, interfaceC1483Mj, j11, abstractC1898b5, i11, z11, z12, mc2);
        this.A06 = new AtomicBoolean(false);
        this.A02 = i12;
        this.A05 = interfaceC1555Pd;
        ImageView imageView = new ImageView(getContext());
        this.A03 = imageView;
        this.A04 = fullScreenAdToolbar;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setAdjustViewBounds(true);
        new AsyncTaskC1672Tq(imageView, c1795Yn).A05(abstractC1898b5.A0x().A0D().A00(), abstractC1898b5.A0x().A0D().A01()).A06(new TA(this)).A07(abstractC1898b5.A0x().A0D().A07());
        A08(c1795Yn.getResources().getConfiguration().orientation);
    }

    private OL A04(int i11) {
        if (this.A03.getParent() != null) {
            ImageView imageView = this.A03;
            if (A07[4].charAt(16) != 'Z') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[3] = "PnJcnL34IR";
            strArr[1] = "4gIzhBkuZ";
            AbstractC1462Lo.A0J(imageView);
        }
        if (A07[4].charAt(16) != 'Z') {
            throw new RuntimeException();
        }
        A07[4] = "hUws06ULbo6w3OlBZNW9WYMgHjAED42u";
        return OM.A00(new OO(super.A06, this.A07, this.A09, super.A05, this.A03, this.A0B, this.A08).A0E(this.A04.getToolbarHeight()).A0H(this.A04).A0D(i11).A0J(i11 != 2).A0K(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        if (this.A06.get()) {
            A03();
        }
    }

    private void A08(int i11) {
        AbstractC1462Lo.A0J(this.A01);
        OL olA04 = A04(i11);
        this.A01 = olA04;
        addView(olA04, 0, A08);
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final void A0z() {
        if (C1384Ih.A1W(super.A06)) {
            super.A06.A0A().AGk(this.A03);
        }
        OL ol2 = this.A01;
        if (ol2 != null) {
            ol2.A0v();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final void A10() {
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final void A11() {
        int i11 = this.A02;
        if (i11 <= 0) {
            this.A05.AD7(false);
            return;
        }
        L9 l11 = new L9(i11, 100.0f, 100L, new Handler(Looper.getMainLooper()), new T9(this));
        this.A00 = l11;
        l11.A07();
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final void A12(boolean z11) {
        L9 l11 = this.A00;
        if (l11 == null || !l11.A05()) {
            return;
        }
        this.A00.A06();
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final void A13(boolean z11) {
        L9 l11 = this.A00;
        if (l11 == null || l11.A04()) {
            return;
        }
        this.A00.A07();
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final boolean A14() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final boolean A15() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public C1554Pc getFullScreenAdStyle() {
        C1P colors = this.A01.getColors();
        return new C1554Pc(this.A01.A11(), C1554Pc.A07, colors, ViewOnClickListenerC1667Tl.A08(super.A05), colors.A07(this.A01.A11() || (this.A01 instanceof AbstractC1662Tg)), null);
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (super.A05.A0x().A0N()) {
            return;
        }
        A08(configuration.orientation);
    }
}
