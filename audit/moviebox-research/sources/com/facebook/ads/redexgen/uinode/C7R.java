package com.facebook.ads.redexgen.uinode;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7R extends QQ {
    public static String[] A04 = {"t7nWMgaAgPrF08nCpsue0KJ0bXYxildh", "6KdtKMmtzfHYFwbGu3Z1Ir1zVfPvm0mZ", "4a3tRJ2Sc2HJRD7iGLBoGFg5dIAFXATk", "UpueiF5Mlf4qFrRwKkN0oaj1wZcm2sVE", "2I2trXzlQyfCpDc0SWIB9I9l1xDqUCt2", "pVCp6f81Bxfp7pGgyLuO3QWY2ZOI1Rz7", "JWrnXr9CYPwxDsxVPLOhiB9OxQPOAEin", "O346HS8RGmqKBjl58VTWQBGWIRLrpgc9"};
    public final ImageView A00;
    public final C1795Yn A01;
    public final AbstractC11578s<C9H> A02;
    public final AbstractC11578s<O8> A03;

    public C7R(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A03 = new C1430Kg(this);
        this.A02 = new C1429Kf(this);
        this.A01 = c1795Yn;
        ImageView imageView = new ImageView(c1795Yn);
        this.A00 = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        AbstractC1462Lo.A0M(imageView, ViewCompat.MEASURED_STATE_MASK);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(imageView);
    }

    @Override // com.facebook.ads.redexgen.uinode.QQ
    public final void A07() {
        super.A07();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A03(this.A03, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.QQ
    public final void A08() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A02, this.A03);
        }
        super.A08();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.A00.layout(0, 0, i13 - i11, i14 - i12);
    }

    public void setImage(String str) {
        setImage(str, null);
    }

    public void setImage(String str, InterfaceC1507Nh interfaceC1507Nh) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        AsyncTaskC1672Tq asyncTaskC1672TqA04 = new AsyncTaskC1672Tq(this.A00, this.A01).A04();
        if (interfaceC1507Nh != null) {
            asyncTaskC1672TqA04.A06(interfaceC1507Nh);
        }
        asyncTaskC1672TqA04.A07(str);
        String[] strArr = A04;
        if (strArr[0].charAt(21) == strArr[6].charAt(21)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "kA5c9xFlh2VnhKEqDnwhhyQ6vC8xp51l";
        strArr2[6] = "v6NK46wFN1tyoiPUrV3jpTAezqYTXUDI";
    }
}
