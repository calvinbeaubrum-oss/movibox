package com.facebook.ads.redexgen.uinode;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class BK extends TS {
    public MZ A00;
    public InterfaceC1542Oq A01;
    public C1569Pr A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public RelativeLayout A06;
    public C1631Sb A07;
    public final C1795Yn A08;
    public final AbstractC1572Pu A09;
    public final AbstractC1539On A0A;
    public final O7 A0B;
    public final NX A0C;
    public final MV A0D;
    public final String A0E;
    public final Paint A0F;
    public final Path A0G;
    public final RectF A0H;
    public final OP A0I;
    public static String[] A0J = {"dJoea1DbFsfm9GTpKIzcXYdmCRfBe4FS", "N1xc2MysRccxXRgwDgHXZSQeh7bFq7uk", "3nDu3mubCrSGPsHb", "SUxuavEQD34fwSKO8hxc7w", "hmAyL1Y1BI3zOyZEMNvfuG", "1nycCDmAbpyAo4RWRzHJ2ixoeiRT", "fh6VcnyoMwgZMcb2oBIx6", "bmD"};
    public static final int A0L = (int) (LD.A02 * 0.0f);
    public static final int A0M = (int) (LD.A02 * 9.0f);
    public static final int A0K = (int) (LD.A02 * 9.0f);

    public BK(OP op2, boolean z11, String str, C1631Sb c1631Sb) {
        super(op2, z11);
        this.A0G = new Path();
        this.A0H = new RectF();
        this.A0D = new BP(this);
        this.A09 = new BO(this);
        this.A0B = new BN(this);
        this.A0A = new BM(this);
        this.A0C = new BL(this);
        this.A0I = op2;
        this.A07 = c1631Sb;
        this.A0E = str;
        C1795Yn c1795YnA05 = op2.A05();
        this.A08 = c1795YnA05;
        setGravity(17);
        int i11 = A0L;
        setPadding(i11, 0, i11, i11);
        AbstractC1462Lo.A0M(this, 0);
        setUpView(c1795YnA05);
        Paint paint = new Paint();
        this.A0F = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(16);
        paint.setAntiAlias(true);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        if (this.A0I.A0A() == null || this.A02 == null) {
            return;
        }
        this.A0I.A0A().A9R(this.A02.getSimpleVideoView());
        if (C1384Ih.A1r(getContext())) {
            this.A0I.A0A().A07(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        if (this.A0I.A0A() != null) {
            this.A0I.A0A().A05();
            if (this.A02 != null) {
                this.A0I.A0A().AGl(this.A02.getSimpleVideoView());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        if (this.A01 == null) {
            return;
        }
        if (!A18() || !this.A05) {
            boolean zA18 = A18();
            String[] strArr = A0J;
            if (strArr[3].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0J;
            strArr2[3] = "whWH7G9NZGoicUCMK8TGye";
            strArr2[4] = "jQqQ2QRGHP0rmsCqitHuog";
            if (zA18 || !this.A04) {
                return;
            }
        }
        this.A01.AAn();
    }

    private void A05(View view) {
        RelativeLayout.LayoutParams layoutParams;
        if (view == null || (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    public static void A06(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        AbstractC1462Lo.A0K(view);
    }

    private void setUpView(C1795Yn c1795Yn) {
        setUpImageView(c1795Yn);
        setUpVideoView(c1795Yn);
        setUpMediaContainer(c1795Yn);
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final boolean A0D() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final boolean A11() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.TS
    public final void A14() {
        C1569Pr c1569Pr;
        if (!A18() || (c1569Pr = this.A02) == null) {
            return;
        }
        c1569Pr.A01();
    }

    @Override // com.facebook.ads.redexgen.uinode.TS
    public final void A15() {
        if (A18()) {
            A16();
            C1569Pr c1569Pr = this.A02;
            if (c1569Pr != null) {
                c1569Pr.A05(QM.A02);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.TS
    public final void A16() {
        C1569Pr c1569Pr;
        float volume = this.A07.A0P().getVolume();
        if (!A18() || (c1569Pr = this.A02) == null || volume == c1569Pr.getVolume()) {
            return;
        }
        this.A02.setVolume(volume);
    }

    @Override // com.facebook.ads.redexgen.uinode.TS
    public final boolean A17() {
        C1569Pr c1569Pr;
        return A18() && (c1569Pr = this.A02) != null && c1569Pr.A06();
    }

    @Override // com.facebook.ads.redexgen.uinode.TS
    public final boolean A18() {
        return this.A03;
    }

    public final void A19(Map<String, String> map) {
        C1569Pr c1569Pr = this.A02;
        if (c1569Pr != null) {
            c1569Pr.A02();
            if (A18()) {
                this.A02.A04(getAdEventManager(), this.A0E, map);
            }
        }
    }

    public final C1569Pr getVideoView() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.A0G.reset();
        this.A0H.set(0.0f, 0.0f, getWidth(), getHeight());
        boolean z11 = getResources().getConfiguration().orientation == 1;
        int i11 = z11 ? A0K : 0;
        this.A0G.addRoundRect(this.A0H, i11, i11, Path.Direction.CW);
        canvas.drawPath(this.A0G, this.A0F);
        RectF rectF = this.A0H;
        int i12 = A0L;
        rectF.set(i12, 0.0f, getWidth() - i12, getHeight() - i12);
        if (z11) {
            i11 = A0M;
        }
        this.A0G.addRoundRect(this.A0H, i11, i11, Path.Direction.CW);
        canvas.clipPath(this.A0G);
        super.onDraw(canvas);
    }

    public void setCTAInfo(C1Q c1q, Map<String, String> map) {
        getCtaButton().setCta(c1q, this.A0E, map);
    }

    public void setImageUrl(String str) {
        MZ mz2 = this.A00;
        if (mz2 != null) {
            mz2.setVisibility(0);
            new AsyncTaskC1672Tq(this.A00, this.A08).A04().A06(new C1664Ti(this, null)).A07(str);
        }
        C1569Pr c1569Pr = this.A02;
        if (c1569Pr != null) {
            c1569Pr.setVisibility(8);
        }
    }

    public void setIsVideo(boolean z11) {
        this.A03 = z11;
    }

    public void setOnAssetsLoadedListener(InterfaceC1542Oq interfaceC1542Oq) {
        this.A01 = interfaceC1542Oq;
    }

    public void setUpImageView(C1795Yn c1795Yn) {
        this.A00 = new MZ(c1795Yn);
        if (C1384Ih.A16(c1795Yn)) {
            AbstractC1511Nl.A00(this.A00, C1384Ih.A17(c1795Yn), new ViewOnClickListenerC1522Nw(this));
        }
        A06(this.A00);
    }

    public void setUpMediaContainer(C1795Yn c1795Yn) {
        RelativeLayout relativeLayout = new RelativeLayout(c1795Yn);
        this.A06 = relativeLayout;
        A06(relativeLayout);
        MZ mz2 = this.A00;
        if (mz2 != null) {
            this.A06.addView(mz2);
            A05(this.A00);
        }
        C1569Pr c1569Pr = this.A02;
        if (c1569Pr != null) {
            this.A06.addView(c1569Pr);
            A05(this.A02);
        }
        addView(this.A06);
    }

    public void setUpVideoView(C1795Yn c1795Yn) {
        this.A02 = new C1569Pr(c1795Yn, new JA(this.A0E, getAdEventManager()));
        if (C1384Ih.A18(c1795Yn)) {
            AbstractC1511Nl.A00(this.A02, C1384Ih.A19(c1795Yn), new ViewOnClickListenerC1523Nx(this));
        }
        A06(this.A02);
    }

    public void setVideoPlaceholderUrl(String str) {
        C1569Pr c1569Pr = this.A02;
        if (c1569Pr != null) {
            c1569Pr.setPlaceholderUrl(str);
        }
    }

    public void setVideoUrl(String str) {
        MZ mz2 = this.A00;
        if (mz2 != null) {
            if (A0J[5].length() == 10) {
                throw new RuntimeException();
            }
            A0J[2] = "s54OOOYMcUndmM7F";
            mz2.setVisibility(8);
        }
        C1569Pr c1569Pr = this.A02;
        if (c1569Pr != null) {
            c1569Pr.setVisibility(0);
            this.A02.setVideoURI(str);
            this.A02.A03(this.A0D);
            this.A02.A03(this.A09);
            this.A02.A03(this.A0B);
            this.A02.A03(this.A0A);
            this.A02.A03(this.A0C);
        }
    }
}
