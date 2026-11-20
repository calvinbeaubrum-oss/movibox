package com.bytedance.sdk.openadsdk.core.Ql.pFF;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.wjp;
import com.bytedance.sdk.openadsdk.utils.Ol;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import k8.b;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends ExN {
    private float AZJ;
    private ImageView BR;
    private int Bs;
    private TextView CYO;
    private ColorStateList DNB;
    private ImageView GI;
    private final int IEI;
    private final Rect JP;
    private View JoC;
    private float Mrq;
    private View MxZ;
    private float NP;
    private int NQ;
    private TextView OKY;
    private final wjp PPh;
    private ImageView QLv;
    private float QST;
    private final Rect WMT;
    private int YdT;
    private SeekBar Yhz;
    private boolean ZM;
    private int bSP;
    private final int dix;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private TextView f28148eo;
    private ColorStateList eoh;
    private int fT;
    private final View.OnTouchListener gsl;

    /* JADX INFO: renamed from: gx, reason: collision with root package name */
    private final Rect f28149gx;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    private final FI f28150ht;
    private boolean idT;
    private final Rect kDg;
    private TextView kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private ImageView f28151ko;
    private int mD;
    private ColorStateList mbO;
    private final Rect otH;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private TextView f28152pc;
    private TextView qKn;
    private TextView qfG;
    private float vYl;
    private View yL;

    public We(Context context, ViewGroup viewGroup, boolean z11, int i11, Sfl sfl, c cVar, boolean z12) {
        super(context, viewGroup, z11, i11, sfl, cVar, z12);
        this.f28150ht = new FI(this);
        this.ZM = false;
        this.idT = false;
        this.fT = 0;
        this.Bs = 0;
        this.YdT = 0;
        this.bSP = 0;
        this.NQ = 0;
        this.kDg = new Rect();
        this.otH = new Rect();
        this.mD = 0;
        this.gsl = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.We.7
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 2) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (actionMasked == 3) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        };
        this.f28149gx = new Rect();
        this.JP = new Rect();
        this.WMT = new Rect();
        this.cvk = Xc.sc().getApplicationContext();
        We(z12);
        this.zY = viewGroup;
        this.Dl = z11;
        wjp wjpVar = new wjp(this);
        this.PPh = wjpVar;
        wjpVar.sc(this.Dl);
        DisplayMetrics displayMetrics = this.cvk.getResources().getDisplayMetrics();
        this.dix = displayMetrics.widthPixels;
        this.IEI = displayMetrics.heightPixels;
        this.FI = i11;
        this.cD = cVar;
        this.WP = sfl;
        We(8);
        sc(context, this.zY);
        We();
        Tf();
    }

    private void ExN(boolean z11) {
        if (z11) {
            WP();
        } else {
            cvk();
        }
    }

    private void WP() {
        DisplayMetrics displayMetrics = this.cvk.getResources().getDisplayMetrics();
        TextView textView = this.OKY;
        if (textView != null) {
            this.QST = textView.getTextSize();
            this.OKY.setTextSize(2, 14.0f);
            ColorStateList textColors = this.OKY.getTextColors();
            this.eoh = textColors;
            if (textColors != null) {
                this.OKY.setTextColor(-1);
            }
            this.Mrq = this.OKY.getAlpha();
            this.OKY.setAlpha(0.85f);
            this.OKY.setShadowLayer(0.0f, kX.zY(this.cvk, 0.5f), kX.zY(this.cvk, 0.5f), com.bytedance.sdk.component.utils.Sfl.qr(this.cvk, "tt_b2000000"));
            ViewGroup.LayoutParams layoutParams = this.OKY.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.f28149gx.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                kX.sc(this.OKY, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.f28149gx.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.f28149gx.bottom);
            }
        }
        TextView textView2 = this.qfG;
        if (textView2 != null) {
            this.AZJ = textView2.getTextSize();
            this.qfG.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.qfG.getTextColors();
            this.mbO = textColors2;
            if (textColors2 != null) {
                this.qfG.setTextColor(-1);
            }
            this.vYl = this.qfG.getAlpha();
            this.qfG.setAlpha(0.85f);
            this.qfG.setShadowLayer(0.0f, kX.zY(this.cvk, 0.5f), kX.zY(this.cvk, 0.5f), com.bytedance.sdk.component.utils.Sfl.qr(this.cvk, "tt_b2000000"));
            ViewGroup.LayoutParams layoutParams2 = this.qfG.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.JP.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                TextView textView3 = this.qfG;
                int iApplyDimension = (int) TypedValue.applyDimension(1, 14.0f, displayMetrics);
                Rect rect = this.JP;
                kX.sc(textView3, iApplyDimension, rect.top, rect.right, rect.bottom);
            }
        }
        ImageView imageView = this.f28151ko;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.WMT.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ImageView imageView2 = this.f28151ko;
                Rect rect2 = this.WMT;
                kX.sc(imageView2, rect2.left, rect2.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.WMT.bottom);
            }
        }
        ImageView imageView3 = this.f28151ko;
        if (imageView3 != null) {
            imageView3.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(this.cvk, "tt_shrink_fullscreen"));
        }
        TextView textView4 = this.qKn;
        if (textView4 != null) {
            ColorStateList textColors3 = textView4.getTextColors();
            this.DNB = textColors3;
            if (textColors3 != null) {
                this.qKn.setTextColor(-1);
            }
            this.NP = this.qKn.getAlpha();
            this.qKn.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.qKn.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.otH.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                TextView textView5 = this.qKn;
                int iApplyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
                Rect rect3 = this.JP;
                kX.sc(textView5, iApplyDimension2, rect3.top, rect3.right, rect3.bottom);
            }
        }
        View view = this.JoC;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.mD = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.JoC.setLayoutParams(layoutParams5);
            this.JoC.setBackgroundResource(com.bytedance.sdk.component.utils.Sfl.We(this.cvk, "tt_shadow_fullscreen_top"));
        }
        pFF(false, true);
    }

    private void cvk() {
        TextView textView = this.OKY;
        if (textView != null) {
            textView.setTextSize(0, this.QST);
            ColorStateList colorStateList = this.eoh;
            if (colorStateList != null) {
                this.OKY.setTextColor(colorStateList);
            }
            this.OKY.setAlpha(this.Mrq);
            this.OKY.setShadowLayer(kX.zY(this.cvk, 1.0f), 0.0f, 0.0f, com.bytedance.sdk.component.utils.Sfl.qr(this.cvk, "tt_72000000"));
            TextView textView2 = this.OKY;
            Rect rect = this.f28149gx;
            kX.sc(textView2, rect.left, rect.top, rect.right, rect.bottom);
        }
        TextView textView3 = this.qfG;
        if (textView3 != null) {
            textView3.setTextSize(0, this.AZJ);
            ColorStateList colorStateList2 = this.mbO;
            if (colorStateList2 != null) {
                this.qfG.setTextColor(colorStateList2);
            }
            this.qfG.setAlpha(this.vYl);
            this.qfG.setShadowLayer(kX.zY(this.cvk, 1.0f), 0.0f, 0.0f, com.bytedance.sdk.component.utils.Sfl.qr(this.cvk, "tt_72000000"));
            TextView textView4 = this.qfG;
            Rect rect2 = this.JP;
            kX.sc(textView4, rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        ImageView imageView = this.f28151ko;
        if (imageView != null) {
            Rect rect3 = this.WMT;
            kX.sc(imageView, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        ImageView imageView2 = this.f28151ko;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(this.cvk, "tt_enlarge_video"));
        }
        TextView textView5 = this.qKn;
        if (textView5 != null) {
            ColorStateList colorStateList3 = this.DNB;
            if (colorStateList3 != null) {
                textView5.setTextColor(colorStateList3);
            }
            this.qKn.setAlpha(this.NP);
            TextView textView6 = this.qKn;
            Rect rect4 = this.JP;
            kX.sc(textView6, rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
        View view = this.JoC;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.mD;
            this.JoC.setLayoutParams(layoutParams);
            this.JoC.setBackground(Ol.sc(this.cvk, "tt_video_black_desc_gradient"));
        }
        pFF(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void ExN() {
        this.f28150ht.removeMessages(1);
        this.f28150ht.sendMessageDelayed(this.f28150ht.obtainMessage(1), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void Ol() {
        this.Yhz.setProgress(0);
        this.Yhz.setSecondaryProgress(0);
        this.qfG.setText(com.bytedance.sdk.component.utils.Sfl.sc(this.cvk, "tt_00_00"));
        this.OKY.setText(com.bytedance.sdk.component.utils.Sfl.sc(this.cvk, "tt_00_00"));
        We(8);
        if (FI()) {
            this.We.setVisibility(8);
        }
        ImageView imageView = this.Qj;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        We(8);
        kX.sc(this.yL, 8);
        kX.sc(this.WH, 8);
        kX.sc((View) this.UFX, 8);
        kX.sc(this.Tf, 8);
        kX.sc((View) this.Ql, 8);
        kX.sc((View) this.SR, 8);
        kX.sc((View) this.BT, 8);
        com.bytedance.sdk.openadsdk.core.widget.Sfl sfl = this.II;
        if (sfl != null) {
            sfl.sc(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void Qj() {
        kX.ExN(this.TRI);
        kX.ExN(this.MxZ);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void TRI() {
        this.f28150ht.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN, com.bytedance.sdk.openadsdk.core.widget.Sfl.pFF
    public void UFX() {
        sc(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN, com.bytedance.sdk.openadsdk.core.widget.Sfl.pFF
    public boolean WH() {
        return this.ZM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    @SuppressLint({"ClickableViewAccessibility"})
    public void We() {
        super.We();
        this.PPh.sc(this.zY);
        kX.sc((View) this.BR, (this.Dl || (this.FI & 1) == 1) ? 8 : 0);
        this.BR.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.We.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (We.this.dE()) {
                    We we2 = We.this;
                    we2.McK.zY(we2, view);
                }
            }
        });
        kX.sc((View) this.kX, (!this.Dl || (this.FI & 2) == 2) ? 0 : 8);
        this.kX.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.We.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (We.this.dE()) {
                    We we2 = We.this;
                    we2.McK.We(we2, view);
                }
            }
        });
        this.GI.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.We.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (We.this.dE()) {
                    We we2 = We.this;
                    we2.McK.ExN(we2, view);
                }
            }
        });
        this.QLv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.We.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                We.this.pFF(false, true);
                We.this.Qj();
                We.this.qr();
                We.this.dE();
            }
        });
        this.f28151ko.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.We.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (We.this.dE()) {
                    We we2 = We.this;
                    we2.McK.pFF(we2, view);
                }
            }
        });
        this.Yhz.setThumbOffset(0);
        this.Yhz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.We.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i11, boolean z11) {
                if (We.this.dE()) {
                    We we2 = We.this;
                    we2.McK.sc(we2, i11, z11);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!We.this.ZM && We.this.cvk != null) {
                    seekBar.setThumb(Ol.sc(Xc.sc(), "tt_seek_thumb_press"));
                }
                if (We.this.dE()) {
                    seekBar.setThumbOffset(0);
                    We we2 = We.this;
                    we2.McK.pFF(we2, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!We.this.ZM && We.this.cvk != null) {
                    seekBar.setThumb(Ol.sc(Xc.sc(), "tt_seek_thumb_normal"));
                }
                if (We.this.dE()) {
                    seekBar.setThumbOffset(0);
                    We we2 = We.this;
                    we2.McK.sc(we2, seekBar.getProgress());
                }
            }
        });
        this.Yhz.setOnTouchListener(this.gsl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void pFF(@Nullable ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        Tf.sc("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || (viewGroup2 = this.zY) == null || !(viewGroup2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.ZM = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.zY.getLayoutParams();
        marginLayoutParams.width = this.YdT;
        marginLayoutParams.height = this.bSP;
        marginLayoutParams.leftMargin = this.Bs;
        marginLayoutParams.topMargin = this.fT;
        this.zY.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.NQ);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Rect rect = this.kDg;
            kX.sc(viewGroup, rect.left, rect.top, rect.right, rect.bottom);
        }
        pFF(true);
        this.f28151ko.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(this.cvk, "tt_enlarge_video"));
        this.Yhz.setThumb(Ol.sc(this.cvk, "tt_seek_thumb_normal"));
        this.Yhz.setThumbOffset(0);
        b.c(this.zY, true);
        ExN(this.ZM);
        kX.sc(this.JoC, 8);
        if ((this.FI & 2) == 2) {
            kX.sc((View) this.kX, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void pFF(boolean z11) {
        int i11 = WH() ? this.IEI : this.Xc;
        int iZY = WH() ? this.dix : this.wjp;
        if (this.YIK <= 0 || this.Sfl <= 0 || i11 <= 0) {
            return;
        }
        if (!Dl() && !WH() && (this.FI & 8) != 8) {
            iZY = kX.zY(this.cvk, 228.0f);
        }
        int i12 = this.Sfl;
        int i13 = this.YIK;
        int i14 = (int) (i13 * ((i11 * 1.0f) / i12));
        if (i14 > iZY) {
            i11 = (int) (i12 * ((iZY * 1.0f) / i13));
        } else {
            iZY = i14;
        }
        if (!z11 && !WH()) {
            i11 = this.Xc;
            iZY = this.wjp;
        }
        this.We.sc(i11, iZY);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public boolean pFF(int i11) {
        SeekBar seekBar = this.Yhz;
        return seekBar != null && i11 > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void qr() {
        Sfl sfl;
        kX.TRI(this.TRI);
        kX.TRI(this.f28130qr);
        kX.ExN(this.MxZ);
        if (this.Qj != null && (sfl = this.WP) != null && sfl.GI() != null && this.WP.GI().r() != null) {
            kX.TRI(this.Qj);
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.WP.GI().r(), this.WP.GI().L(), this.WP.GI().z(), this.Qj, this.WP);
        }
        if (this.ExN.getVisibility() == 0) {
            kX.sc((View) this.ExN, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN, t8.a
    public void sc() {
        sc(false, this.Dl);
        Sfl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void sc(int i11) {
        View view = this.yL;
        if (view == null || view.getVisibility() != 0) {
            this.Yhz.setProgress(i11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void sc(long j11) {
        this.OKY.setText(b.b(j11));
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void sc(long j11, long j12) {
        this.qfG.setText(b.b(j12));
        this.OKY.setText(b.b(j11));
        this.Yhz.setProgress(b.a(j11, j12));
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void sc(Context context, View view) {
        super.sc(context, view);
        this.kX = (TextView) view.findViewById(SR.f28747fb);
        this.BR = (ImageView) view.findViewById(SR.bZj);
        this.JoC = view.findViewById(SR.EZl);
        this.GI = (ImageView) view.findViewById(SR.lD);
        this.CYO = (TextView) view.findViewById(SR.Flm);
        this.qKn = (TextView) view.findViewById(SR.auq);
        this.f28152pc = (TextView) view.findViewById(SR.TI);
        this.MxZ = view.findViewById(SR.f28753ra);
        this.QLv = (ImageView) view.findViewById(SR.ypJ);
        TextView textView = (TextView) view.findViewById(SR.qOv);
        this.f28148eo = textView;
        textView.setText(com.bytedance.sdk.component.utils.Sfl.sc(context, "tt_video_retry_des_txt"));
        this.Yhz = (SeekBar) view.findViewById(SR.qY);
        this.qfG = (TextView) view.findViewById(SR.Zn);
        this.OKY = (TextView) view.findViewById(SR.jxU);
        this.yL = view.findViewById(SR.TEo);
        this.f28151ko = (ImageView) view.findViewById(SR.EOI);
        this.Ol = view.findViewById(SR.VZ);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN, com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        if (message.what != 1) {
            return;
        }
        UFX();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN, com.bytedance.sdk.openadsdk.core.widget.wjp.sc
    public void sc(View view, boolean z11) {
        if (WH()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            Sfl sfl = this.WP;
            if (sfl != null && !TextUtils.isEmpty(sfl.YdT())) {
                sc(this.WP.YdT());
            }
            this.f28152pc.setText(str);
        } else {
            sc("");
            this.f28152pc.setText("");
        }
        if (this.HJN) {
            return;
        }
        zY(this.Dl && !this.ZM);
        if (dE()) {
            this.McK.sc(this, view, true, this.TRI.getVisibility() != 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void sc(@Nullable ViewGroup viewGroup) {
        if (viewGroup != null && (this.zY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.ZM = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.zY.getLayoutParams();
            this.Bs = marginLayoutParams.leftMargin;
            this.fT = marginLayoutParams.topMargin;
            this.YdT = marginLayoutParams.width;
            this.bSP = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.zY.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.NQ = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.kDg.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                kX.sc(viewGroup, 0, 0, 0, 0);
            }
            pFF(true);
            this.f28151ko.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(this.cvk, "tt_shrink_video"));
            this.Yhz.setThumb(Ol.sc(this.cvk, "tt_seek_thumb_fullscreen_selector"));
            this.Yhz.setThumbOffset(0);
            b.c(this.zY, false);
            ExN(this.ZM);
            kX.sc(this.JoC, 8);
            if (!this.Dl) {
                kX.sc((View) this.BR, 8);
                kX.sc((View) this.kX, 8);
            } else if ((this.FI & 1) == 1) {
                kX.sc((View) this.BR, 8);
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    @SuppressLint({"ClickableViewAccessibility"})
    public void sc(Sfl sfl, WeakReference<Context> weakReference, boolean z11) {
        String strBSP;
        String strSc;
        Sfl sfl2;
        if (sfl == null) {
            return;
        }
        sc(this.zY, Xc.sc());
        sc(false, this.Dl);
        kX.sc(this.WH, 0);
        kX.sc((View) this.UFX, 0);
        kX.sc(this.Tf, 0);
        if (this.UFX != null && (sfl2 = this.WP) != null && sfl2.GI() != null && this.WP.GI().r() != null) {
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.WP.GI().r(), this.WP.GI().L(), this.WP.GI().z(), this.UFX, this.WP);
        }
        if (!TextUtils.isEmpty(sfl.MxZ())) {
            strBSP = sfl.MxZ();
        } else if (TextUtils.isEmpty(sfl.YdT())) {
            strBSP = !TextUtils.isEmpty(sfl.bSP()) ? sfl.bSP() : "";
        } else {
            strBSP = sfl.YdT();
        }
        Sfl sfl3 = this.WP;
        if (sfl3 != null && sfl3.qfG() != null && this.WP.qfG().sc() != null) {
            kX.sc((View) this.Ql, 0);
            kX.sc((View) this.SR, 4);
            if (this.Ql != null) {
                com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.WP.qfG(), this.Ql, sfl);
                this.Ql.setOnClickListener(this.Cb);
                this.Ql.setOnTouchListener(this.Cb);
            }
        } else if (!TextUtils.isEmpty(strBSP)) {
            kX.sc((View) this.Ql, 4);
            kX.sc((View) this.SR, 0);
            TextView textView = this.SR;
            if (textView != null) {
                textView.setText(strBSP.substring(0, 1));
                this.SR.setOnClickListener(this.Cb);
                this.SR.setOnTouchListener(this.Cb);
            }
        }
        if (this.BT != null && !TextUtils.isEmpty(strBSP)) {
            this.BT.setText(strBSP);
        }
        kX.sc((View) this.BT, 0);
        kX.sc((View) this.dE, 0);
        int iQLv = sfl.QLv();
        if (iQLv != 4) {
            strSc = iQLv != 5 ? com.bytedance.sdk.component.utils.Sfl.sc(this.cvk, "tt_video_mobile_go_detail") : com.bytedance.sdk.component.utils.Sfl.sc(this.cvk, "tt_video_dial_phone");
        } else {
            strSc = com.bytedance.sdk.component.utils.Sfl.sc(this.cvk, "tt_video_download_apk");
        }
        TextView textView2 = this.dE;
        if (textView2 != null) {
            textView2.setText(strSc);
            this.dE.setOnClickListener(this.Cb);
            this.dE.setOnTouchListener(this.Cb);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN, t8.a
    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void sc(Sfl sfl, WeakReference weakReference, boolean z11) {
        sc(sfl, (WeakReference<Context>) weakReference, z11);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void sc(String str) {
        TextView textView = this.CYO;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.qKn;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void sc(boolean z11, boolean z12) {
        kX.sc(this.yL, 8);
        kX.sc(this.JoC, 8);
        kX.sc((View) this.ExN, 8);
        if (!this.Dl && !this.ZM) {
            kX.sc((View) this.BR, 8);
            if ((this.FI & 2) != 2) {
                kX.sc((View) this.kX, 8);
            }
        } else if ((this.FI & 1) == 1) {
            kX.sc((View) this.BR, 8);
        }
        if (z12) {
            kX.sc((View) this.BR, 8);
            kX.sc((View) this.kX, 8);
        }
        zY(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void sc(boolean z11, boolean z12, boolean z13) {
        kX.sc(this.yL, 0);
        if (this.ZM) {
            kX.sc(this.JoC, 0);
            kX.sc((View) this.qKn, 0);
        } else if (z13) {
            kX.sc(this.JoC, 8);
        }
        kX.sc((View) this.ExN, (!z11 || this.TRI.getVisibility() == 0) ? 8 : 0);
        if (!this.Dl && !this.ZM) {
            if ((this.FI & 1) != 1 && !z13) {
                kX.sc((View) this.BR, 0);
            }
            kX.sc((View) this.kX, z13 ? 8 : 0);
        }
        kX.sc((View) this.qfG, 0);
        kX.sc((View) this.OKY, 0);
        kX.sc((View) this.Yhz, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN
    public void zY(boolean z11) {
        TextView textView = this.CYO;
        if (textView != null) {
            kX.sc((View) textView, (!this.Dl && z11) ? 0 : 8);
        }
    }
}
