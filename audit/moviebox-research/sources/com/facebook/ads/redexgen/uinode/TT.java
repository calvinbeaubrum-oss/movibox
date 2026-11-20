package com.facebook.ads.redexgen.uinode;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TT extends OL {
    public static byte[] A0k;
    public static String[] A0l = {"E7d9V", "HfiTPdnQE6JsOHdYoOA4lRNnbQ3", "7AVXCU5oRbsgBqmorHmAVCwb6r5tuTQ8", "hoWzaZbN7yXesQFa", "a3ZYa3", "EXUfJIeYYGyfdCGOPOS2l0on83CPH94Z", "MYJwByDzw5bCUSkxw6qgTJ7WJbI", "X3l5ZIwYV4"};
    public static final int A0m;
    public static final int A0n;
    public static final int A0o;
    public static final int A0p;
    public static final int A0q;
    public static final int A0r;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public Handler A09;
    public View A0A;
    public InputMethodManager A0B;
    public LinearLayout A0C;
    public LinearLayout A0D;
    public RelativeLayout A0E;
    public TextView A0F;
    public AbstractC1898b5 A0G;
    public NJ A0H;
    public NK A0I;
    public U1 A0J;
    public ViewOnClickListenerC1667Tl A0K;
    public OP A0L;
    public C1540Oo A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public final Handler A0a;
    public final View A0b;
    public final AbstractC09520h A0c;
    public final JA A0d;
    public final O0 A0e;
    public final O1 A0f;
    public final KP A0g;
    public final Runnable A0h;
    public final Runnable A0i;
    public final Set<String> A0j;

    static {
        A0X();
        A0p = (int) (LD.A02 * 26.0f);
        A0m = (int) (LD.A02 * 4.0f);
        A0r = (int) (LD.A02 * 8.0f);
        A0n = (int) (LD.A02 * 24.0f);
        A0o = AbstractC10112p.A01(-1, 77);
        A0q = (int) (LD.A02 * 12.0f);
    }

    public TT(OP op2) {
        super(op2, true);
        this.A0X = false;
        this.A02 = -1;
        this.A0Y = false;
        this.A03 = 0;
        this.A0N = false;
        this.A0U = false;
        this.A0W = false;
        this.A0V = false;
        this.A0Z = false;
        this.A0R = false;
        this.A0T = false;
        this.A0S = false;
        this.A0Q = false;
        this.A08 = 0;
        this.A01 = 0;
        this.A0i = new RunnableC1532Og(this);
        this.A0P = false;
        this.A0j = new HashSet();
        this.A0a = new Handler(Looper.getMainLooper());
        this.A0h = new Runnable() { // from class: com.facebook.ads.redexgen.X.Ob
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A16();
            }
        };
        this.A09 = new Handler(Looper.getMainLooper());
        this.A0B = (InputMethodManager) op2.A05().getSystemService(A0J(25, 12, 127));
        this.A0L = op2;
        this.A0G = op2.A04();
        this.A0d = new JA(op2.A04().A12(), op2.A06());
        KP kpA0A = this.A0L.A0A();
        this.A0g = kpA0A;
        if (kpA0A != null) {
            AbstractC1462Lo.A0K(kpA0A);
        }
        View viewA03 = this.A0L.A03();
        this.A0b = viewA03;
        this.A0c = C09530i.A01(op2.A05(), op2.A06(), op2.A04().A12(), AbstractC1446Ky.A00(op2.A04().A0x().A0F().A05()), new HashMap(), false, true, this.A0G.A0y());
        OA.A00(op2.A05(), this, op2.A04().A0x().A0D().A07());
        setupLayoutConfiguration(false);
        A0T();
        A0P();
        postDelayed(new TW(this), 1000L);
        A0W();
        TV tv2 = new TV(this);
        this.A0e = tv2;
        SA sa2 = this.A0L.A02() instanceof SA ? (SA) this.A0L.A02() : null;
        this.A0f = new O1(op2, this.A0G, sa2, this.A0L.A09(), tv2, this.A0F, this.A0M, kpA0A, viewA03);
        if (sa2 != null && C1384Ih.A18(getAdContextWrapper())) {
            AbstractC1511Nl.A00(sa2.getVideoImplView(), C1384Ih.A19(getAdContextWrapper()), new ViewOnClickListenerC1533Oh(this));
        } else if (sa2 == null && this.A0A != null && C1384Ih.A16(getAdContextWrapper())) {
            AbstractC1511Nl.A00(this.A0A, C1384Ih.A17(getAdContextWrapper()), new ViewOnClickListenerC1534Oi(this));
        }
        this.A0E = null;
        this.A0K = null;
    }

    public TT(OP op2, boolean z11) {
        this(op2);
        this.A0X = z11;
        AbstractC1898b5 abstractC1898b5A04 = op2.A04();
        this.A0Y = this.A0X && abstractC1898b5A04.A0o();
        if (this.A0X) {
            int iA0E = abstractC1898b5A04.A0E();
            this.A02 = iA0E;
            if (iA0E == 0) {
                A16();
            } else if (iA0E > 0 && iA0E <= 10000) {
                this.A0a.postDelayed(this.A0h, iA0E);
            }
            String strA0U = abstractC1898b5A04.A0U();
            if (TextUtils.isEmpty(strA0U)) {
                return;
            }
            for (String str : strA0U.split(A0J(0, 1, 39))) {
                this.A0j.add(str);
            }
        }
    }

    public static /* synthetic */ int A03(TT tt2) {
        int i11 = tt2.A01;
        tt2.A01 = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int A05(TT tt2) {
        int i11 = tt2.A08;
        tt2.A08 = i11 + 1;
        return i11;
    }

    public static String A0J(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0k, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 122);
        }
        return new String(bArrCopyOfRange);
    }

    private void A0K() {
        AbstractC1462Lo.A0J(this.A0D);
        LinearLayout linearLayout = new LinearLayout(this.A0L.A05());
        this.A0D = linearLayout;
        AbstractC1462Lo.A0R(linearLayout, getAdContextWrapper());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A0N ? this.A04 / 4 : this.A04 / 5);
        layoutParams.addRule(12);
        this.A0D.setLayoutParams(layoutParams);
        addView(this.A0D, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A0L, reason: merged with bridge method [inline-methods] */
    public void A16() {
        A0d(((C1308Ff) this.A0c).A0G().toString());
        A0g(true);
    }

    private void A0M() {
        ExecutorC1456Li.A00(new Runnable() { // from class: com.facebook.ads.redexgen.X.Oa
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A15();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N() {
        if (this.A0G.A0l() && this.A0P) {
            this.A0P = false;
            A0e(A0J(37, 18, 2));
        }
    }

    private void A0O() {
        if (this.A0G.A0l() && this.A0P) {
            this.A0P = false;
            Map<String, String> mapA05 = new C1508Ni().A03(null).A02(null).A05();
            mapA05.put(A0J(1, 12, 19), A0J(37, 18, 2));
            getAdEventManager().A9W(this.A0G.A12(), mapA05);
        }
    }

    private void A0P() {
        AbstractC1462Lo.A0J(this.A0C);
        LinearLayout linearLayout = new LinearLayout(this.A0L.A05());
        this.A0C = linearLayout;
        linearLayout.setOrientation(1);
        AbstractC1462Lo.A0K(this.A0C);
        A0U();
        this.A0C.setBackgroundColor(-1);
        addView(this.A0C);
    }

    private void A0Q() {
        View view = this.A0b;
        if (view != null) {
            AbstractC1462Lo.A0J(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(OL.A08, OL.A08);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.setMargins(OL.A07, this.A07, OL.A07, OL.A07);
            addView(this.A0b, layoutParams);
        }
    }

    private void A0R() {
        KP kp2 = this.A0g;
        if (kp2 != null) {
            AbstractC1462Lo.A0J(kp2);
            KP kp3 = this.A0g;
            int i11 = A0q;
            kp3.setPadding(i11, i11, i11, i11);
            this.A0g.A06(-1, A0o);
            this.A0g.setTranslationY(0.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0p);
            layoutParams.addRule(12);
            addView(this.A0g, layoutParams);
        }
    }

    private void A0S() {
        MB mbA08 = this.A0L.A08();
        if (mbA08 == null) {
            return;
        }
        mbA08.setPageDetailsVisible((this.A0O || mbA08.A07()) ? false : true);
    }

    private void A0T() {
        this.A0A = this.A0L.A02();
        if (this.A0G.A0l()) {
            this.A0A.setOnClickListener(new ViewOnClickListenerC1535Oj(this));
        }
        AbstractC1462Lo.A0J(this.A0A);
        AbstractC1462Lo.A0K(this.A0A);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        addView(this.A0A, 1, layoutParams);
        TextView textView = new TextView(this.A0L.A05());
        this.A0F = textView;
        AbstractC1462Lo.A0K(textView);
        this.A0F.setGravity(17);
        this.A0F.setTextColor(getColors().A05(true));
        this.A0F.setEllipsize(TextUtils.TruncateAt.END);
        this.A0F.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        int i11 = A0r;
        layoutParams2.setMargins(i11, i11 / 2, i11, this.A0g == null ? i11 : A0p);
        addView(this.A0F, layoutParams2);
        AbstractC1462Lo.A0K(this.A0F);
        C1540Oo c1540Oo = new C1540Oo(this.A0L.A05(), this.A0L.A04(), this.A0L.A06(), this.A0L.A09(), this.A0L.A0B(), this.A0L.A07(), getColors(), new TU(this));
        this.A0M = c1540Oo;
        c1540Oo.setAutoClickTime(this.A0L.A04(), this.A0L.A08());
        AbstractC1462Lo.A0G(1001, this.A0M);
        addView(this.A0M);
        A0V();
        A0K();
        if (C1384Ih.A0y(this.A0L.A05())) {
            this.A0D.setOnClickListener(new ViewOnClickListenerC1536Ok(this));
            if (this.A0L.A08() != null) {
                this.A0L.A08().setCTAClickListener(new ViewOnClickListenerC1537Ol(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0U() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A05);
        if (A19()) {
            layoutParams.setMargins(0, this.A05 / 5, 0, 0);
            layoutParams.addRule(12);
            String[] strArr = A0l;
            if (strArr[7].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0l;
            strArr2[7] = "mOqhFUC5R4";
            strArr2[4] = "x2rQdK";
            this.A0C.setLayoutParams(layoutParams);
        } else {
            layoutParams.setMargins(0, this.A05 + 1, 0, 0);
        }
        this.A0C.setTranslationY(0.0f);
        this.A0C.setLayoutParams(layoutParams);
    }

    private void A0V() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.A0N ? this.A04 / 4 : this.A04 / 5);
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.A0F.getId());
        layoutParams.setMargins(0, 0, 0, 0);
        this.A0M.setLayoutParams(layoutParams);
        if (!this.A0Y || this.A0K == null) {
            return;
        }
        boolean z11 = this.A0N;
        if (A0l[5].charAt(10) == 'N') {
            throw new RuntimeException();
        }
        A0l[2] = "dOHlU7mObztTib9yLp7cTgFqT8sjFKca";
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(z11 ? -2 : -1, -2);
        layoutParams2.addRule(12);
        layoutParams2.addRule(14);
        int i11 = A0n;
        layoutParams2.setMargins(i11, 0, i11, i11);
        this.A0K.setUpButtonColors(getContext().getResources().getConfiguration().orientation == 1 ? this.A0L.A04().A0w().A01() : this.A0L.A04().A0w().A00());
        if (this.A0N) {
            this.A0K.setPadding(i11, 0, i11, 0);
        }
        this.A0K.setLayoutParams(layoutParams2);
    }

    private void A0W() {
        A0R();
        A0Q();
        A0S();
    }

    public static void A0X() {
        A0k = new byte[]{125, 10, 5, 0, 10, 2, 54, Ascii.SUB, 6, Ascii.FS, Ascii.ESC, 10, Ascii.FF, Ascii.VT, 9, Ascii.CAN, 62, Ascii.CR, Ascii.ESC, 36, 9, 5, Ascii.VT, 4, Ascii.CAN, 108, 107, 117, 112, 113, 90, 104, 96, 113, 109, 106, 97, Ascii.CR, Ascii.VT, Ascii.GS, 10, Ascii.ESC, Ascii.DC4, 17, Ascii.ESC, 19, 39, Ascii.RS, 17, Ascii.DC4, Ascii.FF, Ascii.GS, 10, Ascii.GS, Ascii.FS, 102, 120, Ascii.DEL, 117, 126, 102, 2, Ascii.ESC, Ascii.FS, 42, Ascii.SYN, 1, Ascii.DC4, 42, Ascii.ETB, 0, 1, 1, Ascii.SUB, Ascii.ESC, Ascii.DEL, 102, 97, 87, Ascii.DEL, 109, 106, 87, 97, 102, 123, 124, 105, 100, 100, 87, 106, 125, 124, 124, 103, 102, 10};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0d(String str) {
        if (this.A0Y) {
            AbstractC1462Lo.A0J(this.A0E);
            AbstractC1462Lo.A0J(this.A0K);
        }
        AbstractC1462Lo.A0J(this.A0J);
        TY ty2 = new TY(this);
        if (this.A0L.A05().A0D() == null) {
            this.A0L.A05().A0E().A8e();
        }
        U1 u11 = (AbstractC1385Ii.A02(this.A0L.A05()) || this.A0L.A05().A0D() == null) ? new U1(this.A0L.A05(), ty2) : new U1(this.A0L.A05(), this.A0L.A05().A0D(), ty2);
        this.A0J = u11;
        if (this.A0X) {
            u11.setInterceptRedirectRequest(new NR() { // from class: com.facebook.ads.redexgen.X.Tb
                @Override // com.facebook.ads.redexgen.uinode.NR
                public final boolean A9D(String str2) {
                    return this.A00.A1A(str2);
                }
            });
        }
        if (this.A0G.A0n() && Build.VERSION.SDK_INT > 16) {
            this.A0J.addJavascriptInterface(new OC(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.OY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A17(view);
                }
            }, this.A0J, new OB() { // from class: com.facebook.ads.redexgen.X.Ta
                @Override // com.facebook.ads.redexgen.uinode.OB
                public final void AB5() {
                    this.A00.A13();
                }
            }), OC.A01());
        }
        this.A0J.setOnTouchListener(new ViewOnTouchListenerC1529Od(this));
        setUpBrowserControls(this.A0J);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 0.9f;
        if (this.A0Y || this.A0G.A0n()) {
            ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl = new ViewOnClickListenerC1667Tl(this.A0L.A05(), this.A0L.A04().A0L(), this.A0L.A00() == 1 ? this.A0L.A04().A0w().A01() : this.A0L.A04().A0w().A00(), this.A0L.A04().A0x().A0F().A06(), this.A0L.A06(), this.A0L.A09(), this.A0L.A0B(), this.A0L.A07(), this.A0L.A04().A0y());
            this.A0K = viewOnClickListenerC1667Tl;
            viewOnClickListenerC1667Tl.setCta(this.A0L.A04().A0x().A0F(), this.A0L.A04().A12(), new HashMap());
        }
        if (!this.A0Y || this.A0K == null) {
            this.A0C.addView(this.A0J, layoutParams);
        } else {
            this.A0E = new RelativeLayout(getContext());
            this.A0E.addView(this.A0J, new RelativeLayout.LayoutParams(-1, -1));
            AbstractC1462Lo.A0K(this.A0K);
            this.A0K.setRoundedCornersEnabled(A00());
            this.A0K.setViewShowsOverMedia(A0D());
            this.A0K.setUpButtonColors(getContext().getResources().getConfiguration().orientation == 1 ? this.A0L.A04().A0w().A01() : this.A0L.A04().A0w().A00());
            if (this.A0N) {
                ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl2 = this.A0K;
                int i11 = A0n;
                viewOnClickListenerC1667Tl2.setPadding(i11, 0, i11, 0);
            }
            this.A0K.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.OZ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A18(view);
                }
            });
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.A0N ? -2 : -1, -2);
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
            int i12 = A0n;
            layoutParams2.setMargins(i12, 0, i12, i12);
            this.A0E.addView(this.A0K, layoutParams2);
            this.A0C.addView(this.A0E, layoutParams);
        }
        this.A0J.loadUrl(str);
    }

    private void A0e(String str) {
        Map<String, String> mapA05 = new C1508Ni().A03(null).A02(null).A05();
        mapA05.put(A0J(1, 12, 19), str);
        this.A0d.A04(J9.A0J, mapA05);
        this.A0L.A09().A43(this.A0G.A0L());
        getAdEventManager().A9j(this.A0G.A12(), mapA05);
        if (C1384Ih.A20(this.A0L.A05())) {
            HashMap map = new HashMap();
            map.put(AbstractC1928bZ.A03, Boolean.TRUE.toString());
            map.put(AbstractC1928bZ.A04, Boolean.TRUE.toString());
            map.put(AbstractC1928bZ.A05, Boolean.TRUE.toString());
            getAdEventManager().A9s(this.A0G.A12(), map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0f(String str) {
        if (this.A0G.A0u() <= 0) {
            if (this.A0G.A0k()) {
                A0N();
            }
        } else {
            if (this.A0G.A19() && this.A0Q) {
                return;
            }
            this.A0Q = true;
            A0e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0g(boolean z11) {
        this.A0O = z11;
        if (this.A0X && z11) {
            this.A0a.removeCallbacks(this.A0h);
        }
        ObjectAnimator objectAnimatorOfFloat = null;
        if (z11) {
            this.A01 = 0;
            this.A08 = 0;
            this.A0R = false;
            this.A0S = false;
            this.A0T = false;
            this.A0Q = false;
        } else {
            this.A09.removeCallbacksAndMessages(null);
        }
        postDelayed(new TX(this, z11), 250L);
        String strA0J = A0J(97, 1, 9);
        if (z11) {
            C1540Oo c1540Oo = this.A0M;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(c1540Oo, strA0J, c1540Oo.getY(), this.A05 / 5);
        }
        LinearLayout linearLayout = this.A0C;
        float[] fArr = new float[2];
        fArr[0] = linearLayout.getY();
        int i11 = this.A05;
        if (z11) {
            i11 /= 5;
        }
        fArr[1] = i11;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(linearLayout, strA0J, fArr);
        objectAnimatorOfFloat2.setDuration(500L);
        View view = this.A0A;
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, strA0J, view.getY(), 0.0f);
        objectAnimatorOfFloat3.setDuration(500L);
        int[] iArr = new int[2];
        iArr[0] = this.A0A.getHeight();
        int i12 = this.A05;
        if (z11) {
            i12 /= 5;
        }
        iArr[1] = i12;
        ValueAnimator duration = ValueAnimator.ofInt(iArr).setDuration(500L);
        duration.addUpdateListener(new C1530Oe(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, duration);
        if (objectAnimatorOfFloat != null) {
            objectAnimatorOfFloat.setDuration(500L);
            Animator[] animatorArr = {objectAnimatorOfFloat};
            String[] strArr = A0l;
            if (strArr[3].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0l;
            strArr2[6] = "3HcTndNMKO02itZ1YB9OuMlfPHE";
            strArr2[1] = "rUq8gYLqYGWwvrPw2H7I5hxcdAd";
            animatorSet.playTogether(animatorArr);
        }
        animatorSet.addListener(new C1531Of(this, z11));
        animatorSet.start();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0097  */
    /* JADX WARN: Code duplicated, block: B:20:0x009d  */
    private void A0h(boolean z11) {
        RelativeLayout.LayoutParams layoutParams;
        setupLayoutConfiguration(z11);
        AbstractC1462Lo.A0J(this.A0A);
        if (this.A0A == null) {
            View viewA02 = this.A0L.A02();
            this.A0A = viewA02;
            AbstractC1462Lo.A0K(viewA02);
        }
        boolean z12 = this.A0O;
        String[] strArr = A0l;
        if (strArr[3].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0l;
        strArr2[7] = "FZuJEB1DgE";
        strArr2[4] = "ioAK5D";
        if (z12) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.A05 / 5);
            layoutParams.addRule(14);
            layoutParams.addRule(10);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (C1384Ih.A16(getAdContextWrapper())) {
                Resources resources = getResources();
                if (A0l[2].charAt(2) != 'l') {
                    String[] strArr3 = A0l;
                    strArr3[6] = "pPe40HbQyCL07tY4s4c8j3Lf22g";
                    strArr3[1] = "FpZU0oL4KOaHbXLVjTxOhAl2PJv";
                    if (resources.getConfiguration().orientation == 2) {
                        if (!(this.A0A instanceof SA)) {
                            layoutParams = new RelativeLayout.LayoutParams(-2, -1);
                        }
                    }
                } else if (resources.getConfiguration().orientation == 2) {
                    if (!(this.A0A instanceof SA)) {
                        layoutParams = new RelativeLayout.LayoutParams(-2, -1);
                    }
                }
            }
            layoutParams.addRule(13);
            A0P();
        }
        this.A0A.setTranslationY(0.0f);
        addView(this.A0A, 1, layoutParams);
        A0K();
        A0V();
    }

    private boolean A0i() {
        if (this.A0G.A0x().A0D().A0A()) {
            boolean z11 = this.A0V;
            String[] strArr = A0l;
            if (strArr[3].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0l;
            strArr2[7] = "WvW0Ef6T7c";
            strArr2[4] = "9KXIlI";
            if (z11 && !this.A0Z && !this.A0W) {
                return true;
            }
        }
        return false;
    }

    private void setUpBrowserControls(U1 u11) {
        AbstractC1462Lo.A0J(this.A0H);
        NJ nj2 = new NJ(this.A0L.A05(), u11, true);
        this.A0H = nj2;
        u11.setBrowserNavigationListener(nj2.getBrowserNavigationListener());
        AbstractC1462Lo.A0K(this.A0H);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 0.1f;
        this.A0H.setListener(new TZ(this));
        this.A0H.setOnTouchListener(new ViewOnTouchListenerC1528Oc(this));
        this.A0C.addView(this.A0H, layoutParams);
        AbstractC1462Lo.A0J(this.A0I);
        this.A0I = new NK(this.A0L.A05(), null, R.attr.progressBarStyleHorizontal);
        this.A0C.addView(this.A0I, new LinearLayout.LayoutParams(-1, A0m));
    }

    private void setupLayoutConfiguration(boolean z11) {
        this.A0N = getResources().getConfiguration().orientation == 2;
        this.A07 = this.A0L.A08() == null ? 0 : this.A0L.A08().getToolbarHeight();
        this.A0O = z11;
        this.A04 = Resources.getSystem().getDisplayMetrics().heightPixels;
        this.A06 = Resources.getSystem().getDisplayMetrics().widthPixels;
        Point point = new Point();
        WindowManager windowManager = (WindowManager) getAdContextWrapper().getSystemService(A0J(55, 6, 107));
        if (windowManager != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                point.y = currentWindowMetrics.getBounds().bottom - currentWindowMetrics.getBounds().top;
            } else {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                if (Build.VERSION.SDK_INT >= 17) {
                    defaultDisplay.getRealSize(point);
                } else {
                    try {
                        Integer num = (Integer) Display.class.getMethod(A0J(13, 12, 22), new Class[0]).invoke(defaultDisplay, new Object[0]);
                        point.y = num != null ? num.intValue() : 0;
                    } catch (Exception unused) {
                    }
                }
            }
        }
        this.A05 = point.y > 0 ? point.y : this.A04;
        this.A03 = this.A04;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A0v() {
        if (this.A0X) {
            this.A0a.removeCallbacks(this.A0h);
        }
        A0O();
        super.A0v();
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A0w() {
        MB mbA08 = this.A0L.A08();
        if (mbA08 != null) {
            mbA08.setPageDetailsVisible((A19() || mbA08.A07()) ? false : true);
        }
        this.A0V = false;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A0x() {
        if (this.A0L.A08() != null) {
            MB mbA08 = this.A0L.A08();
            String[] strArr = A0l;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0l;
            strArr2[3] = "MMiJw7TNUivh7iTB";
            strArr2[0] = "GEB80";
            mbA08.setPageDetailsVisible(false);
        }
        this.A0V = true;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A0y() {
        this.A0W = false;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A0z() {
        this.A0W = this.A0G.A0x().A0D().A03() > 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A10(C1G c1g, String str, double d11, Bundle bundle) {
        super.A10(c1g, str, d11, bundle);
        String strA05 = c1g.A0E().A05();
        if (strA05 == null || strA05.trim().length() == 0) {
            AbstractC1462Lo.A0N(this.A0D, 8);
            if (C1384Ih.A0y(this.A0L.A05())) {
                this.A0D.setClickable(false);
            }
        } else {
            this.A0F.setText(strA05);
            if (C1384Ih.A0y(this.A0L.A05())) {
                LinearLayout linearLayout = this.A0D;
                String[] strArr = A0l;
                if (strArr[3].length() != strArr[0].length()) {
                    A0l[2] = "Tti1ERh3982vMPWOgwyCGNbTUdK6PILe";
                    linearLayout.setClickable(true);
                } else {
                    A0l[2] = "fnWnWSkw0ES4UX172ZpEF9XfJQ6oKenC";
                    linearLayout.setClickable(true);
                }
            }
        }
        if (d11 > 0.0d) {
            this.A03 = (int) (((double) this.A06) / d11);
        }
        boolean z11 = this.A0N;
        String[] strArr2 = A0l;
        if (strArr2[6].length() != strArr2[1].length()) {
            throw new RuntimeException();
        }
        A0l[2] = "7Lq3s7aOnX5NGbRVe2GBF9HLZ2EE6fpE";
        this.A03 = z11 ? this.A04 : this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final boolean A11() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final boolean A12(boolean z11) {
        if (A19()) {
            A0g(false);
            return true;
        }
        if (!A0i()) {
            return false;
        }
        this.A0f.A07(this);
        return true;
    }

    public final /* synthetic */ void A13() {
        this.A0L.A05().A0E().AAD();
    }

    public final /* synthetic */ void A14() {
        if (this.A0K != null) {
            this.A0L.A05().A0E().AAC();
            this.A0K.A09(A0J(61, 14, 15));
        }
    }

    public final /* synthetic */ void A15() {
        if (this.A0K != null) {
            this.A0L.A05().A0E().AAG();
            String[] strArr = A0l;
            if (strArr[3].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0l;
            strArr2[3] = "tCgjPTcwsN2cZ99v";
            strArr2[0] = "Ilqrg";
            this.A0K.A09(A0J(75, 22, 114));
        }
    }

    public final /* synthetic */ void A17(View view) {
        A0M();
    }

    public final /* synthetic */ void A18(View view) {
        ExecutorC1456Li.A00(new Runnable() { // from class: com.facebook.ads.redexgen.X.OX
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A14();
            }
        });
    }

    public final boolean A19() {
        return this.A0O;
    }

    public final /* synthetic */ boolean A1A(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.A0j.isEmpty()) {
            return true;
        }
        Iterator<String> it = this.A0j.iterator();
        while (it.hasNext()) {
            boolean zContains = str.contains(it.next());
            if (A0l[2].charAt(2) == 'l') {
                throw new RuntimeException();
            }
            A0l[5] = "Sf20Awxc2HRh1lAKHxXJmSVrTf5ojylw";
            if (!zContains) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public int getCloseButtonStyle() {
        if (A19()) {
            return 3;
        }
        if (this.A0W) {
            return 2;
        }
        if (this.A0G.A0x().A0D().A0A()) {
            return 1;
        }
        if (!this.A0V) {
            return super.getCloseButtonStyle();
        }
        if (A0l[5].charAt(10) == 'N') {
            throw new RuntimeException();
        }
        String[] strArr = A0l;
        strArr[6] = "NhzVRhgvHrOwM64xV2PIAOEbNcq";
        strArr[1] = "xEzMNY3CkayGfsMDFyAKLsf22gx";
        return 4;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A0h(A19());
        A0W();
        setupLayoutConfiguration(A19());
        A0U();
    }
}
