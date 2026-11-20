package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SA extends RelativeLayout implements RC, QE {
    public static byte[] A0E;
    public static String[] A0F = {"bTF0mPynjITMPKd7AWnGFE0wjuUHqGk", "NLuteA0O4hImypGMVaagZ7KROvpQko", "vHIsSgA1dNPe0TxNLDw8T5r", "Tu3OEd7", "fTm", "FLX2LFKD3Z9kyRG7iyj3Ajj18EKg1", "ES7oyLysdjBWPeOJZDQ9P8Sn", "e8"};
    public static final C1571Pt A0G;
    public static final O8 A0H;
    public static final C1513Nn A0I;
    public static final C1479Mf A0J;
    public static final C1474Ma A0K;
    public static final MW A0L;
    public static final MU A0M;
    public static final C1468Lu A0N;
    public int A00;
    public JA A01;
    public QJ A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final Handler A07;
    public final Handler A08;
    public final View.OnTouchListener A09;
    public final C1795Yn A0A;
    public final C11568r<AbstractC11578s, C11558q> A0B;
    public final List<QN> A0C;
    public final R9 A0D;

    static {
        A0I();
        A0I = new C1513Nn();
        A0G = new C1571Pt();
        A0J = new C1479Mf();
        A0K = new C1474Ma();
        A0H = new O8();
        A0L = new MW();
        A0N = new C1468Lu();
        A0M = new MU();
    }

    public SA(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A0C = new ArrayList();
        this.A07 = new Handler();
        this.A08 = new Handler();
        this.A0B = new C11568r<>();
        this.A05 = true;
        this.A00 = 200;
        this.A09 = new QD(this);
        this.A0A = c1795Yn;
        if (A0S(c1795Yn)) {
            this.A0D = new TextureViewSurfaceTextureListenerC1420Jv(c1795Yn);
        } else {
            this.A0D = new TextureViewSurfaceTextureListenerC1419Ju(c1795Yn);
        }
        A0G();
    }

    public SA(C1795Yn c1795Yn, AttributeSet attributeSet) {
        super(c1795Yn, attributeSet);
        this.A0C = new ArrayList();
        this.A07 = new Handler();
        this.A08 = new Handler();
        this.A0B = new C11568r<>();
        this.A05 = true;
        this.A00 = 200;
        this.A09 = new QD(this);
        this.A0A = c1795Yn;
        if (A0S(c1795Yn)) {
            this.A0D = new TextureViewSurfaceTextureListenerC1420Jv(c1795Yn, attributeSet);
        } else {
            this.A0D = new TextureViewSurfaceTextureListenerC1419Ju(c1795Yn, attributeSet);
        }
        A0G();
    }

    public SA(C1795Yn c1795Yn, AttributeSet attributeSet, int i11) {
        super(c1795Yn, attributeSet, i11);
        this.A0C = new ArrayList();
        this.A07 = new Handler();
        this.A08 = new Handler();
        this.A0B = new C11568r<>();
        this.A05 = true;
        this.A00 = 200;
        this.A09 = new QD(this);
        this.A0A = c1795Yn;
        if (A0S(c1795Yn)) {
            this.A0D = new TextureViewSurfaceTextureListenerC1420Jv(c1795Yn, attributeSet, i11);
        } else {
            this.A0D = new TextureViewSurfaceTextureListenerC1419Ju(c1795Yn, attributeSet, i11);
        }
        A0G();
    }

    public static /* synthetic */ C1513Nn A0C() {
        C1513Nn c1513Nn = A0I;
        if (A0F[0].length() != 31) {
            throw new RuntimeException();
        }
        A0F[6] = "XnBln0F0zo0j2g49JSScdoR2";
        return c1513Nn;
    }

    public static String A0F(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 103);
        }
        return new String(bArrCopyOfRange);
    }

    private void A0G() {
        this.A06 = C1384Ih.A0o(this.A0A);
        this.A0A.A0E().A32();
        this.A0D.setRequestedVolume(1.0f);
        this.A0D.setVideoStateChangeListener(this);
        this.A02 = new QJ(this.A0A, this.A0D);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.A02, layoutParams);
        setOnTouchListener(this.A09);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H() {
        this.A07.postDelayed(new SE(this), this.A00);
    }

    public static void A0I() {
        byte[] bArr = {4, 87, 73, 71, 4, 88, 83, 88, 69, 80, 4, 91, 69, 88, 71, 76, 4, 88, 77, 81, 73, 38, 88, 85, 85, 72, 81, 87, 79, 92, 3, 68, 87, 3};
        if (A0F[6].length() != 24) {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[5] = "dnbQEbQJ0095hjHrUlDt4BBpkj0Wp";
        strArr[7] = "GI";
        A0E = bArr;
    }

    private final void A0J() {
        for (QN qn2 : this.A0C) {
            if (qn2 instanceof QQ) {
                A0Q((QQ) qn2);
            }
            qn2.A9R(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0K(int i11) {
        if (C1384Ih.A0s(this.A0A)) {
            Toast.makeText(this.A0A, A0F(21, 13, 124) + (i11 / 1000.0f) + A0F(0, 21, 125), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L(J9 j11) {
        JA ja2 = this.A01;
        if (ja2 == null) {
            return;
        }
        ja2.A04(j11, null);
    }

    private void A0P(QN qn2) {
        if (qn2 instanceof QQ) {
            A0R((QQ) qn2);
        }
        qn2.AGl(this);
    }

    private void A0Q(QQ qq2) {
        if (qq2.getParent() == null) {
            if (qq2 instanceof C7R) {
                this.A02.A00(qq2);
            } else {
                addView(qq2);
            }
        }
    }

    private void A0R(QQ qq2) {
        if (qq2 instanceof C7R) {
            this.A02.A01(qq2);
        } else {
            AbstractC1462Lo.A0J(qq2);
        }
    }

    private boolean A0S(C1795Yn c1795Yn) {
        return C1384Ih.A2S(c1795Yn, C1600Qw.A03());
    }

    public final void A0V() {
        this.A0D.setVideoStateChangeListener(null);
        this.A0D.destroy();
    }

    public final void A0W() {
        if (A0i()) {
            return;
        }
        this.A0D.A8Q();
    }

    public final void A0X() {
        Iterator<QN> it = this.A0C.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0F[0].length() != 31) {
                throw new RuntimeException();
            }
            A0F[0] = "GYUlZXdJo7nruMh2UHaMalRUd7rYm0D";
            if (!zHasNext) {
                this.A0C.clear();
                String[] strArr = A0F;
                if (strArr[4].length() != strArr[3].length()) {
                    String[] strArr2 = A0F;
                    strArr2[4] = "dBG";
                    strArr2[3] = "pEPub8w";
                    return;
                }
                return;
            }
            A0P(it.next());
        }
    }

    public final void A0Y(int i11) {
        this.A07.removeCallbacksAndMessages(null);
        this.A0D.seekTo(i11);
    }

    public final void A0Z(int i11) {
        this.A0D.AGZ(i11);
    }

    public final void A0a(QH qh2) {
        SB sb2 = new SB(this);
        if (this.A06) {
            ExecutorC1456Li.A00(sb2);
        } else {
            Handler handler = this.A08;
            if (A0F[6].length() != 24) {
                throw new RuntimeException();
            }
            A0F[6] = "kK0l9LoMdPIpLA2D0gOeof4W";
            handler.post(sb2);
        }
        this.A0D.AGN(qh2.A02());
    }

    public final void A0b(QM qm2, int i11) {
        if (this.A03 && this.A0D.getState() == RB.A06) {
            this.A03 = false;
        }
        this.A0D.AGS(qm2, i11);
    }

    public final void A0c(QN qn2) {
        this.A0C.add(qn2);
    }

    public final void A0d(QN qn2) {
        this.A0C.remove(qn2);
        A0P(qn2);
    }

    public final void A0e(boolean z11, int i11) {
        if (A0i()) {
            return;
        }
        this.A0D.ADu(z11, i11);
    }

    public final void A0f(boolean z11, boolean z12, int i11) {
        this.A05 = z12;
        A0e(z11, i11);
    }

    public final boolean A0g() {
        return this.A0D.A8b();
    }

    public final boolean A0h() {
        return getVolume() == 0.0f;
    }

    public final boolean A0i() {
        return getState() == RB.A05;
    }

    public final boolean A0j() {
        return A0i() && this.A0D.A9B();
    }

    public final boolean A0k() {
        return getState() == RB.A0A;
    }

    public final boolean A0l() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.uinode.QE
    public final boolean A92() {
        return A0S(this.A0A);
    }

    @Override // com.facebook.ads.redexgen.uinode.QE
    public final boolean A95() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.uinode.RC
    public final void ABa(final long j11, final long j12, final long j13, final float f11) {
        if (C1384Ih.A1X(this.A0A)) {
            this.A0B.A02(new QA(j11, j12, j13, f11) { // from class: com.facebook.ads.redexgen.X.9F
            });
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.RC
    public final void ACD() {
        A0e(true, 4);
    }

    @Override // com.facebook.ads.redexgen.uinode.RC
    public final void ACE() {
        A0b(QM.A04, 6);
    }

    @Override // com.facebook.ads.redexgen.uinode.RC
    public final void AD3(int i11, int i12) {
        SC sc2 = new SC(this, i11, i12);
        if (this.A06) {
            ExecutorC1456Li.A00(sc2);
        } else {
            this.A08.post(sc2);
        }
        A0H();
    }

    @Override // com.facebook.ads.redexgen.uinode.RC
    public final void ADh(RB rb2) {
        SD sd2 = new SD(this, rb2, getCurrentPositionInMillis(), getDuration());
        if (this.A06) {
            ExecutorC1456Li.A00(sd2);
        } else {
            this.A08.post(sd2);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.QE
    public int getCurrentPositionInMillis() {
        return this.A0D.getCurrentPosition();
    }

    public int getDuration() {
        return this.A0D.getDuration();
    }

    public C11568r<AbstractC11578s, C11558q> getEventBus() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.uinode.QE
    public long getInitialBufferTime() {
        return this.A0D.getInitialBufferTime();
    }

    public RB getState() {
        return this.A0D.getState();
    }

    public Handler getStateHandler() {
        return this.A08;
    }

    public TextureView getTextureView() {
        return (TextureView) this.A0D;
    }

    public int getVideoHeight() {
        return this.A0D.getVideoHeight();
    }

    public View getVideoImplView() {
        return this.A0D.getView();
    }

    public int getVideoProgressReportIntervalMs() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.QE
    public QM getVideoStartReason() {
        return this.A0D.getStartReason();
    }

    public View getVideoView() {
        return this.A02;
    }

    public int getVideoWidth() {
        return this.A0D.getVideoWidth();
    }

    @Override // com.facebook.ads.redexgen.uinode.QE
    public float getVolume() {
        return this.A0D.getVolume();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.A0B.A02(A0M);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.A0B.A02(A0N);
        super.onDetachedFromWindow();
    }

    public void setControlsAnchorView(View view) {
        R9 r11 = this.A0D;
        if (r11 != null) {
            r11.setControlsAnchorView(view);
        }
    }

    public void setFunnelLoggingHandler(JA ja2) {
        this.A01 = ja2;
    }

    public void setIsFullScreen(boolean z11) {
        this.A04 = z11;
        this.A0D.setFullScreen(z11);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setVideoMPD(String str) {
        this.A0D.setVideoMPD(str);
    }

    public void setVideoProgressReportIntervalMs(int i11) {
        this.A00 = i11;
    }

    public void setVideoURI(Uri uri) {
        if (uri == null) {
            A0X();
        } else {
            A0J();
            this.A0D.setup(uri);
        }
        this.A03 = false;
    }

    public void setVideoURI(String str) {
        this.A0A.A0E().A39(str);
        setVideoURI(str != null ? AbstractC1446Ky.A00(str) : null);
    }

    public void setVolume(float f11) {
        if (f11 == 1.0f) {
            A0L(J9.A0f);
            this.A0A.A0E().A3D();
        } else {
            A0L(J9.A0e);
            this.A0A.A0E().A3C();
        }
        this.A0D.setRequestedVolume(f11);
        C11568r<AbstractC11578s, C11558q> eventBus = getEventBus();
        if (A0F[2].length() == 19) {
            throw new RuntimeException();
        }
        A0F[2] = "etD2zaPMct9y2wbR2YehsJmmTem";
        eventBus.A02(A0L);
    }
}
