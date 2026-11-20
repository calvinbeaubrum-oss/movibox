package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VE extends C10725a implements DefaultMediaViewVideoRendererApi {
    public static byte[] A0F;
    public static String[] A0G = {"mcYgxpLQMmIwsDd5yEmcOVEUvqtoI", "GHoJM0N9xHnxy27wJlEicj6316JJBG", "sAgmez8xlBVRjdgohc9cPNZKpCHjl", "UXd4O0RMEZeMz8rPKuZc9Jx8", "lkMSGOb1N9f2znZPpxO7v43dGPgWn", "ZJq7h5cFUWj9FCmvTSQNl6xA6rnC8", "yifDfgH7QVrqMR4w0vNHSMY9h4Ewh", "QZpfE8IVFABXRQwraZ"};
    public static final String A0H;
    public MediaViewVideoRenderer A00;
    public C1795Yn A01;
    public JK A02;
    public C1215Ba A04;
    public C7R A05;
    public C7I A06;
    public RD A07;
    public RE A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final QI A0C = new VK(this);
    public final AtomicBoolean A0D = new AtomicBoolean(false);
    public final AtomicBoolean A0E = new AtomicBoolean(false);
    public JU A03 = JU.A03;

    static {
        A0E();
        A0H = VE.class.getSimpleName();
    }

    private VJ A00(MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        return new VJ(this, mediaViewVideoRendererApi);
    }

    private VI A01(MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        return new VI(this, mediaViewVideoRendererApi);
    }

    private VG A02() {
        return new VG(this);
    }

    private RE A05() {
        return new RE(this.A00, 50, true, new WeakReference(this.A07), this.A01);
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 127);
        }
        return new String(bArrCopyOfRange);
    }

    private void A09() {
        C1215Ba c1215Ba = this.A04;
        if (c1215Ba != null) {
            QJ qj2 = (QJ) c1215Ba.getVideoView();
            if (A0G[3].length() != 24) {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[2] = "uL1T6UePNJ7Kw1irCYcqiA1GlgiEZ";
            strArr[0] = "2BZHbySyGqLzqR4K5b7TQMpiAd64K";
            qj2.setViewImplInflationListener(this.A0C);
        }
    }

    private void A0A() {
        C1215Ba c1215Ba = this.A04;
        if (c1215Ba != null) {
            c1215Ba.getVideoView().setOnTouchListener(new JJ(this));
        }
    }

    private void A0B() {
        C1215Ba c1215Ba = this.A04;
        if (c1215Ba != null) {
            QJ qj2 = (QJ) c1215Ba.getVideoView();
            String[] strArr = A0G;
            if (strArr[4].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A0G[7] = "MUEPyY1MJMWvhU3XHu";
            qj2.setViewImplInflationListener(null);
        }
    }

    private void A0C() {
        if (this.A00.getVisibility() == 0 && this.A09) {
            MediaViewVideoRenderer mediaViewVideoRenderer = this.A00;
            String[] strArr = A0G;
            if (strArr[4].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[4] = "vtumVYeB8x7vkBeCNzRl37Vgwgf5m";
            strArr2[1] = "l5c2Nb35iHyego1JNAmcVzJY15xyfp";
            if (mediaViewVideoRenderer.hasWindowFocus()) {
                this.A08.A0U();
                return;
            }
        }
        C1215Ba c1215Ba = this.A04;
        if (c1215Ba != null && c1215Ba.getState() == RB.A05) {
            this.A0B = true;
        }
        this.A08.A0V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D() {
        this.A03 = JU.A03;
        A0B();
    }

    public static void A0E() {
        A0F = new byte[]{7, 32, 56, 47, 34, 39, 42, 110, 60, 43, 32, 42, 43, 60, 43, 60, 110, 45, 38, 39, 34, 42, 110, 45, 33, 32, 40, 39, 41, 96, Ascii.SO, 38, 39, 42, 34, Ascii.NAK, 42, 38, 52, Ascii.NAK, 42, 39, 38, 44, 99, 42, 48, 99, 45, 54, 47, 47, 120, 99, 54, 45, 34, 33, 47, 38, 99, 55, 44, 99, 37, 42, 45, 39, 99, 42, 55, 109, Ascii.DLE, 43, 36, 39, 41, 32, 101, 49, 42, 101, 35, 44, 43, 33, 101, 8, 32, 33, 44, 36, 19, 44, 32, 50, 19, 44, 33, 32, 42, 101, 38, 45, 44, 41, 33, 107};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x002a  */
    public void A0I(V2 v11, JK jk2) {
        String url;
        this.A0A = false;
        this.A0B = false;
        this.A02 = jk2;
        A09();
        C7R c7r = this.A05;
        if (v11 != null) {
            JP adCoverImage = v11.getAdCoverImage();
            String[] strArr = A0G;
            if (strArr[2].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            A0G[3] = "zpp3cHPhluFOPvL30kkcY8af";
            if (adCoverImage != null) {
                url = v11.getAdCoverImage().getUrl();
            } else {
                url = null;
            }
        } else {
            url = null;
        }
        c7r.setImage(url, new VH(this));
        this.A03 = v11.A18();
        this.A06.setPlayAccessibilityLabel(v11.A1E());
        this.A06.setPauseAccessibilityLabel(v11.A1D());
        this.A08.A0U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0J(QM qm2) {
        C1215Ba c1215Ba = this.A04;
        if (c1215Ba != null) {
            c1215Ba.A0b(qm2, 24);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.e(A0H, A06(30, 42, 60));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0K() {
        C1215Ba c1215Ba = this.A04;
        if (c1215Ba == null || c1215Ba.getState() == RB.A06) {
            return false;
        }
        return this.A03 == JU.A05 || this.A03 == JU.A03;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:23:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:25:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:30:0x010d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0113  */
    @Override // com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi
    public final void initialize(Context context, MediaViewVideoRenderer mediaViewVideoRenderer, MediaViewVideoRendererApi mediaViewVideoRendererApi, int i11) {
        JM jmA01;
        C1215Ba c1215Ba;
        String[] strArr;
        C1215Ba c1215Ba2;
        String[] strArr2;
        ((C10725a) mediaViewVideoRendererApi.getAdComponentViewApi()).A00(this);
        switch (i11) {
            case 0:
                jmA01 = A01(mediaViewVideoRendererApi);
                break;
            case 1:
                jmA01 = A00(mediaViewVideoRendererApi);
                break;
            default:
                throw new IllegalArgumentException(A06(0, 30, 49));
        }
        ((C10795h) mediaViewVideoRendererApi).A06(jmA01);
        this.A01 = C10745c.A03(context);
        this.A00 = mediaViewVideoRenderer;
        this.A05 = new C7R(this.A01);
        this.A07 = A02();
        this.A08 = A05();
        float f11 = LD.A02;
        int i12 = (int) (2.0f * f11);
        int i13 = (int) (25.0f * f11);
        this.A06 = new C7I(this.A01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        this.A06.setPadding(i12, i13, i13, i12);
        this.A06.setLayoutParams(layoutParams);
        for (int i14 = 0; i14 < this.A00.getChildCount(); i14++) {
            View childAt = this.A00.getChildAt(0);
            if (childAt instanceof C1215Ba) {
                C1215Ba c1215Ba3 = (C1215Ba) childAt;
                String[] strArr3 = A0G;
                if (strArr3[4].length() != strArr3[1].length()) {
                    A0G[3] = "bzrDqpY4LpZuK9aeaZZijHYv";
                    this.A04 = c1215Ba3;
                    c1215Ba = this.A04;
                    strArr = A0G;
                    if (strArr[2].length() == strArr[0].length()) {
                        String[] strArr4 = A0G;
                        strArr4[6] = "2aK7TrzSKlLOXQMMYyslcv3rZKnIT";
                        strArr4[5] = "rJ0uIs3irNdkufru0tgAA9z3l7YlJ";
                        if (c1215Ba == null) {
                            c1215Ba.A0c(this.A05);
                            c1215Ba2 = this.A04;
                            strArr2 = A0G;
                            if (strArr2[6].length() != strArr2[5].length()) {
                                throw new RuntimeException();
                            }
                            A0G[3] = "N5wNlZvELtjdUjcESL7VUEU7";
                            c1215Ba2.A0c(this.A06);
                        } else if (AdInternalSettings.isDebugBuild()) {
                            Log.e(A0H, A06(72, 36, 58));
                        }
                        this.A08.A0W(0);
                        this.A08.A0X(250);
                        jmA01.AG3();
                        return;
                    }
                }
                throw new RuntimeException();
            }
        }
        c1215Ba = this.A04;
        strArr = A0G;
        if (strArr[2].length() == strArr[0].length()) {
            String[] strArr5 = A0G;
            strArr5[6] = "2aK7TrzSKlLOXQMMYyslcv3rZKnIT";
            strArr5[5] = "rJ0uIs3irNdkufru0tgAA9z3l7YlJ";
            if (c1215Ba == null) {
                c1215Ba.A0c(this.A05);
                c1215Ba2 = this.A04;
                strArr2 = A0G;
                if (strArr2[6].length() != strArr2[5].length()) {
                    throw new RuntimeException();
                }
                A0G[3] = "N5wNlZvELtjdUjcESL7VUEU7";
                c1215Ba2.A0c(this.A06);
            } else if (AdInternalSettings.isDebugBuild()) {
                Log.e(A0H, A06(72, 36, 58));
            }
            this.A08.A0W(0);
            this.A08.A0X(250);
            jmA01.AG3();
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.uinode.C10725a, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A09 = true;
        A0C();
    }

    @Override // com.facebook.ads.redexgen.uinode.C10725a, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A09 = false;
        A0C();
    }

    @Override // com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi
    public final void onPrepared() {
        boolean zA0n = C1384Ih.A0n(this.A01);
        this.A00.setOnTouchListener(new JI(this, zA0n));
        if (zA0n) {
            return;
        }
        A0A();
    }

    @Override // com.facebook.ads.redexgen.uinode.C10725a, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        A0C();
    }

    @Override // com.facebook.ads.redexgen.uinode.C10725a, com.facebook.ads.internal.api.AdComponentView
    public final void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        A0C();
    }
}
