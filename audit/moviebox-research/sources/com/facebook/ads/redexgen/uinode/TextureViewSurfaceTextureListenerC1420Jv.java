package com.facebook.ads.redexgen.uinode;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TextureViewSurfaceTextureListenerC1420Jv extends TextureView implements TextureView.SurfaceTextureListener, InterfaceC1597Qt, R9, InterfaceC1599Qv {
    public static byte[] A0O;
    public static String[] A0P = {"5i34yksohRV8hSvEB2dTOBGqhO", "V2RNkeamXobpzSRVkM4sjlG", "1HR", "8SLqGCa2wxiVkGjIaPVK9LXerY", "SSmTkZgpl4jZsKBndOsNgmbhAq5FKejN", "hgMiihLf1lx1lIiVFZ8jC", "euSTtDnbG06q2RqThlQcyR1Es6oMHQDw", "iHXqYQoKvaPWKvo"};
    public static final String A0Q;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public Uri A06;
    public Surface A07;
    public View A08;
    public MediaController A09;
    public C1795Yn A0A;
    public QM A0B;
    public C1600Qw A0C;
    public RB A0D;
    public RB A0E;
    public RC A0F;
    public String A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;
    public boolean A0N;

    static {
        A07();
        A0Q = TextureViewSurfaceTextureListenerC1420Jv.class.getSimpleName();
    }

    public TextureViewSurfaceTextureListenerC1420Jv(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A0D = RB.A04;
        this.A0E = RB.A04;
        this.A0M = false;
        this.A0N = false;
        this.A0J = false;
        this.A03 = 0;
        this.A02 = 0;
        this.A00 = 1.0f;
        this.A01 = -1;
        this.A0I = false;
        this.A0H = false;
        this.A0B = QM.A03;
        this.A0K = false;
        this.A0L = false;
        this.A0A = c1795Yn;
    }

    public TextureViewSurfaceTextureListenerC1420Jv(C1795Yn c1795Yn, AttributeSet attributeSet) {
        super(c1795Yn, attributeSet);
        this.A0D = RB.A04;
        this.A0E = RB.A04;
        this.A0M = false;
        this.A0N = false;
        this.A0J = false;
        this.A03 = 0;
        this.A02 = 0;
        this.A00 = 1.0f;
        this.A01 = -1;
        this.A0I = false;
        this.A0H = false;
        this.A0B = QM.A03;
        this.A0K = false;
        this.A0L = false;
        this.A0A = c1795Yn;
    }

    public TextureViewSurfaceTextureListenerC1420Jv(C1795Yn c1795Yn, AttributeSet attributeSet, int i11) {
        super(c1795Yn, attributeSet, i11);
        this.A0D = RB.A04;
        this.A0E = RB.A04;
        this.A0M = false;
        this.A0N = false;
        this.A0J = false;
        this.A03 = 0;
        this.A02 = 0;
        this.A00 = 1.0f;
        this.A01 = -1;
        this.A0I = false;
        this.A0H = false;
        this.A0B = QM.A03;
        this.A0K = false;
        this.A0L = false;
        this.A0A = c1795Yn;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0O, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 68);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0083  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    private void A04() {
        C1600Qw c1600Qw = new C1600Qw(this.A0A);
        this.A0C = c1600Qw;
        c1600Qw.A0H(this);
        this.A0C.A0G(this);
        this.A0C.A0I(false);
        if (this.A0J && !this.A0I) {
            Activity activityA0D = this.A0A.A0D();
            if (A0P[5].length() != 21) {
                throw new RuntimeException();
            }
            String[] strArr = A0P;
            strArr[4] = "kOzpobq3cn2ENPvO1dz11rE9gYrdsM2t";
            strArr[6] = "XeC6T5eSgweGxN3AGx0qK1AhpVQau6BW";
            if (activityA0D != null) {
                MediaController mediaController = new MediaController(activityA0D);
                this.A09 = mediaController;
                View view = this.A08;
                if (view == null) {
                    view = this;
                }
                mediaController.setAnchorView(view);
                this.A09.setMediaPlayer(new R2(this));
                this.A09.setEnabled(true);
            } else {
                this.A09 = null;
            }
        }
        String str = this.A0G;
        String[] strArr2 = A0P;
        if (strArr2[4].charAt(4) != strArr2[6].charAt(4)) {
            A0P[1] = "7OzxCvlMe7OewOex";
            if (str != null) {
                if (str.length() != 0 || this.A0K) {
                }
            }
            setVideoState(RB.A08);
            if (isAvailable()) {
                onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
            }
        }
        String[] strArr3 = A0P;
        strArr3[4] = "NXAVCVHzJxAz58YH1UEgH4PHy83Kp8aQ";
        strArr3[6] = "f1ODdwAOeVqSGvJpvEMDUKedn4FgojKu";
        if (str != null) {
            if (str.length() != 0) {
            }
        }
        setVideoState(RB.A08);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
        this.A0C.A0F(this.A0A.A01(), this.A06);
        setVideoState(RB.A08);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    private void A05() {
        C1600Qw c1600Qw = this.A0C;
        if (c1600Qw == null) {
            return;
        }
        C1598Qu c1598QuA08 = c1600Qw.A08();
        String[] strArr = A0P;
        if (strArr[3].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0P;
        strArr2[3] = "yniwio37QFCiL85s5GWvJngxgc";
        strArr2[0] = "95HbvmBBNGyB2bovEph22CE4vZ";
        if (c1598QuA08 != null) {
            A08(c1598QuA08.A01, c1598QuA08.A00);
        }
    }

    private void A06() {
        Surface surface = this.A07;
        if (surface != null) {
            surface.release();
            this.A07 = null;
        }
        C1600Qw c1600Qw = this.A0C;
        if (c1600Qw != null) {
            c1600Qw.A09();
            if (A0P[5].length() != 21) {
                throw new RuntimeException();
            }
            String[] strArr = A0P;
            strArr[3] = "he0jjWxzFB8qDestWT3k7cDZmQ";
            strArr[0] = "YQusGxI3ZRGEiRLtvLIlZ3cCdg";
            this.A0C = null;
        }
        this.A09 = null;
        this.A0N = false;
        setVideoState(RB.A04);
    }

    public static void A07() {
        A0O = new byte[]{86, 126, 126, 118, 125, 116, 49, 112, 125, 102, 112, 104, 98, 49, 101, 121, 99, 126, 102, 49, 112, Ascii.DEL, 49, 116, 105, 114, 116, 97, 101, 120, 126, Ascii.DEL, 49, 102, 120, 101, 121, 49, 98, 116, 101, 83, 112, 114, 122, 118, 99, 126, 100, Ascii.DEL, 117, 85, 99, 112, 102, 112, 115, 125, 116, 49, 126, Ascii.DEL, 49, 95, 126, 100, 118, 112, 101, 49, 112, 115, 126, 103, 116, Utf8.REPLACEMENT_BYTE, 49, 98, 126, 49, 102, 116, 49, 98, 120, 125, 116, Ascii.DEL, 101, 125, 104, 49, 120, 118, Ascii.DEL, 126, 99, 116, 49, 120, 101, Utf8.REPLACEMENT_BYTE, 76, 100, 100, 108, 103, 110, 43, 106, 103, 124, 106, 114, 120, 43, Ascii.DEL, 99, 121, 100, 124, 43, 106, 101, 43, 110, 115, 104, 110, 123, Ascii.DEL, 98, 100, 101, 43, 124, 98, Ascii.DEL, 99, 43, 120, 110, Ascii.DEL, 77, 100, 121, 110, 108, 121, 100, 126, 101, 111, 43, 100, 101, 43, 69, 100, 126, 108, 106, Ascii.DEL, 43, 106, 105, 100, 125, 110, 37, 43, 120, 100, 43, 124, 110, 43, 120, 98, 103, 110, 101, Ascii.DEL, 103, 114, 43, 98, 108, 101, 100, 121, 110, 43, 98, Ascii.DEL, 37, 33, Ascii.RS, 19, Ascii.DC2, Ascii.CAN, 87, 4, 3, Ascii.SYN, 3, Ascii.DC2, 87, Ascii.DC4, Ascii.US, Ascii.SYN, Ascii.EM, Ascii.DLE, Ascii.DC2, 19, 87, 3, Ascii.CAN, 87, 95, 93, 86, 93, 74, 81, 91};
        String[] strArr = A0P;
        if (strArr[4].charAt(4) == strArr[6].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0P;
        strArr2[3] = "4Rjqxy3w03hT2rk3wOaPN94qCv";
        strArr2[0] = "J56YrdEaTg6GnpCj3tljjm9xxp";
    }

    private void A08(int i11, int i12) {
        if (i11 == this.A03 && i12 == this.A02) {
            return;
        }
        this.A03 = i11;
        this.A02 = i12;
        if (i11 == 0 || i12 == 0) {
            return;
        }
        requestLayout();
    }

    public static boolean A09() {
        return C1600Qw.A03();
    }

    private void setVideoState(RB rb2) {
        if (rb2 != this.A0D) {
            if (this.A0A.A04().A8z()) {
                String str = A03(196, 23, 51) + rb2;
            }
            this.A0D = rb2;
            if (rb2 == RB.A0A) {
                this.A0N = true;
            }
            RC rc2 = this.A0F;
            if (rc2 != null) {
                rc2.ADh(rb2);
            }
        }
    }

    public final /* synthetic */ void A0A() {
        Activity activityA0D = this.A0A.A0D();
        if (activityA0D == null || !activityA0D.isInMultiWindowMode()) {
            A8Q();
            if (A0P[1].length() == 30) {
                throw new RuntimeException();
            }
            String[] strArr = A0P;
            strArr[3] = "ibP83lPIHp18E6DzSXuO582r7E";
            strArr[0] = "bqS8XhAkEDMP7WptTe4caNAUJi";
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public final void A8Q() {
        if (this.A0H) {
            return;
        }
        ADu(false, 3);
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public final boolean A8b() {
        C1600Qw c1600Qw = this.A0C;
        return c1600Qw != null && c1600Qw.A0K();
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public final boolean A8c() {
        return this.A0N;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public final boolean A9B() {
        return this.A0M;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1597Qt
    public final void ACe(String str, Exception exc) {
        this.A0A.A0E().AAR(str);
        this.A0A.A0E().A37(1);
        setVideoState(RB.A03);
        this.A0A.A07().A9a(A03(219, 7, 124), C8A.A1N, new C8B(exc));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1597Qt
    public final void ACf(boolean z11, int i11) {
        if (this.A0C == null) {
            return;
        }
        switch (i11) {
            case 1:
                setVideoState(RB.A04);
                return;
            case 2:
                A05();
                if (this.A01 >= 0) {
                    int i12 = this.A01;
                    this.A01 = -1;
                    RC rc2 = this.A0F;
                    String[] strArr = A0P;
                    if (strArr[2].length() == strArr[7].length()) {
                        throw new RuntimeException();
                    }
                    A0P[1] = "rrPXv2FoHSgfFGcrQjG2fRVM";
                    if (rc2 != null) {
                        rc2.AD3(i12, getCurrentPosition());
                        return;
                    }
                    return;
                }
                return;
            case 3:
                A05();
                this.A04 = System.currentTimeMillis();
                setRequestedVolume(this.A00);
                long j11 = this.A05;
                if (j11 > 0 && j11 < this.A0C.A07()) {
                    this.A0C.A0D(this.A05);
                    this.A05 = 0L;
                }
                if (this.A0C.A06() != 0 && !z11 && this.A0N) {
                    setVideoState(RB.A05);
                    return;
                }
                if (z11 || this.A0D == RB.A06) {
                    return;
                }
                setVideoState(RB.A07);
                if (this.A0E == RB.A0A) {
                    AGS(this.A0B, 8);
                    this.A0E = RB.A04;
                    return;
                }
                return;
            case 4:
                if (z11) {
                    setVideoState(RB.A06);
                }
                C1600Qw c1600Qw = this.A0C;
                if (c1600Qw != null) {
                    c1600Qw.A0I(false);
                    if (!z11) {
                        this.A0C.A0A();
                    }
                }
                this.A0N = false;
                return;
            default:
                return;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1599Qv
    public final void ADf(int i11, int i12, int i13, float f11) {
        A08(i11, i12);
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public final void ADu(boolean z11, int i11) {
        this.A0A.A0E().A33(i11);
        this.A0E = RB.A05;
        this.A0M = z11;
        C1600Qw c1600Qw = this.A0C;
        if (c1600Qw != null) {
            c1600Qw.A0I(false);
        } else {
            setVideoState(RB.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public final void AGN(int i11) {
        this.A0A.A0E().AAS(i11);
        setVideoState(RB.A09);
        AGZ(5);
        this.A05 = 0L;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public final void AGS(QM qm2, int i11) {
        this.A0A.A0E().A3E(i11);
        this.A0M = false;
        this.A0E = RB.A0A;
        this.A0B = qm2;
        if (this.A0C == null) {
            setup(this.A06);
        } else if (this.A0D == RB.A07 || this.A0D == RB.A05 || this.A0D == RB.A06) {
            this.A0C.A0I(true);
            setVideoState(RB.A0A);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public final void AGZ(int i11) {
        this.A0A.A0E().A3G(i11);
        this.A0E = RB.A04;
        C1600Qw c1600Qw = this.A0C;
        if (c1600Qw != null) {
            c1600Qw.A0B();
            this.A0C.A09();
            this.A0C = null;
        }
        setVideoState(RB.A04);
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public final void destroy() {
        A06();
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public int getCurrentPosition() {
        C1600Qw c1600Qw = this.A0C;
        if (c1600Qw != null) {
            return (int) c1600Qw.A06();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public int getDuration() {
        C1600Qw c1600Qw = this.A0C;
        if (c1600Qw == null) {
            return 0;
        }
        return (int) c1600Qw.A07();
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public long getInitialBufferTime() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public QM getStartReason() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public RB getState() {
        return this.A0D;
    }

    public RB getTargetState() {
        return this.A0E;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public int getVideoHeight() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public int getVideoWidth() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public float getVolume() {
        return this.A00;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!C1384Ih.A2D(getContext()) || isHardwareAccelerated()) {
            return;
        }
        setVideoState(RB.A03);
        AGZ(8);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
        Surface surface = this.A07;
        if (surface != null) {
            surface.release();
        }
        Surface surface2 = new Surface(surfaceTexture);
        this.A07 = surface2;
        C1600Qw c1600Qw = this.A0C;
        if (c1600Qw == null) {
            return;
        }
        c1600Qw.A0E(surface2);
        if (this.A0D != RB.A05 || this.A0M) {
            return;
        }
        AGS(this.A0B, 7);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Surface surface = this.A07;
        if (surface != null) {
            surface.release();
            this.A07 = null;
            C1600Qw c1600Qw = this.A0C;
            if (c1600Qw != null) {
                c1600Qw.A0E(null);
            }
        }
        if (this.A0D == RB.A05) {
            return true;
        }
        if (A0P[5].length() != 21) {
            throw new RuntimeException();
        }
        A0P[5] = "TScQzo9LVHiM3saFvXTgi";
        ADu(false, 5);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (C1384Ih.A1X(this.A0A) && this.A0D != RB.A08) {
            if (!this.A0L) {
                this.A0L = true;
                this.A0A.A0E().AFY();
            }
            long currentPosition = getCurrentPosition();
            long currentPosition2 = getCurrentPosition();
            long jCurrentTimeMillis = System.currentTimeMillis();
            float volume = getVolume();
            RC rc2 = this.A0F;
            if (rc2 != null) {
                rc2.ABa(currentPosition, currentPosition2, jCurrentTimeMillis, volume);
            }
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (this.A0C == null) {
            return;
        }
        MediaController mediaController = this.A09;
        if (mediaController == null || !mediaController.isShowing()) {
            if (z11) {
                if (this.A0D != RB.A05 || this.A0M) {
                    return;
                }
                AGS(this.A0B, 9);
                return;
            }
            if (this.A0D != RB.A05) {
                if ((this.A0A.A0F().A01() || C1384Ih.A1c(this.A0A)) && Build.VERSION.SDK_INT >= 24) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.R1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.A00.A0A();
                        }
                    }, 1000L);
                } else {
                    A8Q();
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public final void seekTo(int i11) {
        if (this.A0C != null) {
            this.A01 = getCurrentPosition();
            this.A0C.A0D(i11);
            return;
        }
        long j11 = i11;
        String[] strArr = A0P;
        if (strArr[2].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        A0P[5] = "kfjJwAtkK1UY2s6fcoM3d";
        this.A05 = j11;
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        boolean zIsDebugBuild = AdInternalSettings.isDebugBuild();
        if (A0P[5].length() != 21) {
            throw new RuntimeException();
        }
        A0P[1] = "HF5JdwiOlRNKOfaOH";
        if (zIsDebugBuild) {
            Log.w(A0Q, A03(0, 102, 85));
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public void setBackgroundPlaybackEnabled(boolean z11) {
        this.A0H = z11;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public void setControlsAnchorView(View view) {
        this.A08 = view;
        view.setOnTouchListener(new R4(this));
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setForeground(drawable);
            return;
        }
        if (AdInternalSettings.isDebugBuild()) {
            String str = A0Q;
            String[] strArr = A0P;
            if (strArr[3].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0P;
            strArr2[4] = "adR4uJi1AjYNmamYU7fKdN8LPQzpuqJY";
            strArr2[6] = "LCKmfGi2Ka9VnYBnqFwdGZK0MZJmec2m";
            Log.w(str, A03(102, 94, 79));
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public void setFullScreen(boolean z11) {
        this.A0J = z11;
        if (!z11 || this.A0I) {
            return;
        }
        setOnTouchListener(new R3(this));
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public void setRequestedVolume(float f11) {
        this.A00 = f11;
        if (this.A0C == null || this.A0D == RB.A08 || this.A0D == RB.A04) {
            return;
        }
        this.A0C.A0C(f11);
    }

    public void setTestMode(boolean z11) {
        this.A0K = z11;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public void setVideoMPD(String str) {
        this.A0G = str;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public void setVideoStateChangeListener(RC rc2) {
        this.A0F = rc2;
    }

    @Override // com.facebook.ads.redexgen.uinode.R9
    public void setup(Uri uri) {
        this.A0A.A0E().A36();
        if (this.A0C != null) {
            A06();
        }
        this.A06 = uri;
        setSurfaceTextureListener(this);
        A04();
    }
}
