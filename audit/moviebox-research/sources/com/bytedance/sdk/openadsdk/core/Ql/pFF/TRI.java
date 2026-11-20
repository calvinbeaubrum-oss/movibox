package com.bytedance.sdk.openadsdk.core.Ql.pFF;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.Gb;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Qj.JPJ;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.UFX;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import t8.a;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
public class TRI extends com.bytedance.sdk.openadsdk.core.ExN.zY implements c.InterfaceC0849c, FI.sc, zY.sc {
    private static final Integer Dl = 0;
    private static final Integer uEA = 1;
    private c.d BR;
    public pFF BT;
    private final AtomicBoolean CYO;
    private long Cb;
    public boolean ExN;
    private boolean FI;
    private final AtomicBoolean GI;
    private final Handler Gb;
    private final boolean HJN;
    private boolean II;
    private String JPJ;
    private ViewTreeObserver.OnGlobalLayoutListener JoC;
    private long McK;
    private final ViewTreeObserver.OnScrollChangedListener MxZ;
    private boolean OXF;
    protected ImageView Ol;
    protected ImageView Qj;
    protected int Ql;
    boolean SR;
    private boolean Sfl;
    public qr TRI;
    protected String Tf;
    protected boolean UFX;
    protected ImageView WH;
    private boolean WP;
    protected boolean We;
    private ViewGroup Xc;
    private String YIK;
    private boolean cD;
    private final String cJ;
    private boolean cvk;
    private final Context dE;
    private View kX;
    protected c pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private boolean f28139pc;
    private final Runnable qKn;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected RelativeLayout f28140qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final Sfl f28141sc;
    private boolean wjp;
    protected FrameLayout zY;

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
        void sc(boolean z11, long j11, long j12, long j13, boolean z12);
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(View view, int i11);
    }

    public TRI(@NonNull Context context, @NonNull Sfl sfl, qr qrVar) {
        this(context, sfl, false, qrVar);
    }

    public TRI(@NonNull Context context, @NonNull Sfl sfl, String str, boolean z11, boolean z12, qr qrVar) {
        this(context, sfl, false, str, z11, z12, qrVar);
    }

    public TRI(@NonNull Context context, @NonNull Sfl sfl, boolean z11, qr qrVar) {
        this(context, sfl, z11, "embeded_ad", false, false, qrVar);
    }

    public TRI(@NonNull Context context, @NonNull Sfl sfl, boolean z11, String str, boolean z12, boolean z13, qr qrVar) {
        super(context);
        this.wjp = true;
        this.We = true;
        this.Sfl = false;
        this.ExN = false;
        this.FI = true;
        this.WP = false;
        this.cvk = true;
        this.UFX = true;
        this.Tf = "embeded_ad";
        this.Ql = 50;
        this.II = true;
        this.HJN = false;
        this.Gb = new FI(SR.pFF().getLooper(), this);
        this.OXF = false;
        this.cJ = Build.MODEL;
        this.SR = false;
        this.CYO = new AtomicBoolean(false);
        this.qKn = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.4
            @Override // java.lang.Runnable
            public void run() {
                TRI tri = TRI.this;
                tri.sc(tri.cD, TRI.Dl.intValue());
            }
        };
        this.f28139pc = true;
        this.GI = new AtomicBoolean(false);
        this.MxZ = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.6
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                TRI.this.Xc();
            }
        };
        try {
            if (sfl.fb()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    this.JPJ = CacheDirFactory.getICacheDir(0).pFF();
                } else {
                    this.JPJ = UFX.sc();
                }
            }
        } catch (Throwable unused) {
        }
        if (qrVar != null) {
            this.TRI = qrVar;
        }
        this.Tf = str;
        this.dE = context;
        this.f28141sc = sfl;
        this.Sfl = z11;
        setContentDescription("NativeVideoTsView");
        this.WP = z12;
        this.cvk = z13;
        pFF();
        ExN();
    }

    private void Cb() {
        kX.ExN(this.Ol);
        kX.ExN(this.f28140qr);
    }

    private void Dl() {
        this.BT = null;
        if ((this.pFF instanceof zY) && !cD()) {
            ((zY) this.pFF).Cb();
        }
        WH();
        sc(false);
        uEA();
    }

    private void ExN() {
        addView(sc(this.dE));
        wjp();
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                TRI.this.Xc();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                TRI.this.Xc();
            }
        });
    }

    private boolean FI() {
        Sfl sfl = this.f28141sc;
        if (sfl == null) {
            return false;
        }
        return sfl.yH();
    }

    private boolean Gb() {
        return 5 == Xc.We().pFF(this.f28141sc.QT());
    }

    private boolean HJN() {
        return 2 == Xc.We().pFF(this.f28141sc.QT());
    }

    private void II() {
        this.Gb.removeMessages(1);
        SR.zY().removeCallbacks(this.qKn);
    }

    private void JPJ() {
        this.cD = UFX();
        Cb.sc(this.qKn);
    }

    private void McK() {
        if (this.pFF == null || cD()) {
            return;
        }
        if ((!FI() || com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_is_update_flag", false)) && FI()) {
            long jQj = this.pFF.Qj();
            long jTRI = this.pFF.TRI() + jQj;
            boolean zSc = com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_native_video_complete", false);
            long jSc = com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_current_play_position", 0L);
            long jSc2 = com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_total_play_duration", jTRI);
            long jSc3 = com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_duration", jQj);
            com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
            this.pFF.zY(zSc);
            this.pFF.sc(jSc);
            this.pFF.pFF(jSc2);
            this.pFF.zY(jSc3);
            Tf.sc("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + zSc + ",position=" + jSc + ",totalPlayDuration=" + jSc2 + ",duration=" + jSc3);
        }
    }

    private void Sfl() {
        c cVar = this.pFF;
        if (cVar == null) {
            return;
        }
        cVar.We(this.wjp);
        ((zY) this.pFF).sc((zY.sc) this);
        this.pFF.sc(this);
    }

    private boolean WP() {
        if (cD() || !FI()) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
    }

    private void We() {
        sc(0L, 0);
        this.BR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Handler handler = this.Gb;
        if (handler == null || jElapsedRealtime - this.Cb <= 500) {
            return;
        }
        this.Cb = jElapsedRealtime;
        handler.sendEmptyMessageDelayed(1, 500L);
    }

    private void YIK() {
        c cVar = this.pFF;
        if (cVar == null) {
            wjp();
        } else if ((cVar instanceof zY) && !cD()) {
            ((zY) this.pFF).wjp();
        }
        if (this.pFF == null || !this.CYO.get()) {
            return;
        }
        this.CYO.set(false);
        pFF();
        if (!Qj()) {
            if (this.pFF.BT()) {
                this.pFF.BT();
                pFF(true);
                return;
            } else {
                qr();
                kX.sc((View) this.f28140qr, 0);
                return;
            }
        }
        kX.sc((View) this.f28140qr, 8);
        ImageView imageView = this.Ol;
        if (imageView != null) {
            kX.sc((View) imageView, 8);
        }
        Sfl sfl = this.f28141sc;
        if (sfl == null || sfl.GI() == null) {
            Tf.sc("NativeVideoTsView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(CacheDirFactory.getICacheDir(this.f28141sc.Flm()).zY(), this.f28141sc);
        pffSc.pFF(this.f28141sc.kDg());
        pffSc.sc(this.Xc.getWidth());
        pffSc.pFF(this.Xc.getHeight());
        pffSc.zY(this.f28141sc.mD());
        pffSc.sc(0L);
        pffSc.sc(Ol());
        sc(pffSc);
        this.pFF.sc(pffSc);
        this.pFF.zY(false);
    }

    private boolean cD() {
        return this.Sfl;
    }

    private void cvk() {
        if (cD() || !FI()) {
            return;
        }
        Boolean bool = Boolean.FALSE;
        com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_isfromvideodetailpage", bool);
        com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_is_from_detail_page", bool);
    }

    private RelativeLayout pFF(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.qr qrVar = new com.bytedance.sdk.openadsdk.core.ExN.qr(context);
        qrVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        qrVar.setVisibility(8);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        we2.setLayoutParams(layoutParams);
        we2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Qj = we2;
        com.bytedance.sdk.openadsdk.core.ExN.We we3 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        we3.setLayoutParams(layoutParams2);
        we3.setVisibility(8);
        we3.setBackground(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_new_play_video"));
        this.WH = we3;
        qrVar.addView(we2);
        qrVar.addView(we3);
        return qrVar;
    }

    private View sc(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        new FrameLayout.LayoutParams(-1, -1).gravity = 17;
        frameLayout.setVisibility(8);
        this.Xc = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams);
        frameLayout.addView(frameLayout2);
        this.zY = frameLayout2;
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(view);
        this.kX = view;
        return frameLayout;
    }

    private void sc(View view, ViewGroup viewGroup, View view2) {
        int iIndexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeViewInLayout(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    private void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar) {
        try {
            if (this.f28141sc.fb()) {
                zYVar.sc(this.JPJ);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z11, int i11) {
        if (this.f28141sc == null || this.pFF == null) {
            return;
        }
        boolean zWP = WP();
        cvk();
        if (zWP && this.pFF.BT()) {
            this.pFF.BT();
            pFF(true);
            We();
            return;
        }
        if (!z11 || !this.FI || this.pFF.BT() || this.pFF.UFX()) {
            if (this.pFF.Tf() == null || !this.pFF.Tf().TRI()) {
                return;
            }
            this.pFF.sc();
            sc(true);
            c.d dVar = this.BR;
            if (dVar != null) {
                dVar.g_();
                return;
            }
            return;
        }
        if (this.pFF.Tf() == null || !this.pFF.Tf().qr()) {
            if (this.wjp && this.pFF.Tf() == null) {
                if (!this.CYO.get()) {
                    this.CYO.set(true);
                }
                this.GI.set(false);
                YIK();
                return;
            }
            return;
        }
        if (this.wjp || i11 == 1) {
            c cVar = this.pFF;
            if (cVar != null) {
                setIsQuiet(cVar.SR());
            }
            if ("ALP-AL00".equals(this.cJ)) {
                this.pFF.pFF();
            } else {
                if (!Ol.pFF().BT()) {
                    zWP = true;
                }
                ((zY) this.pFF).Qj(zWP);
            }
            sc(false);
            c.d dVar2 = this.BR;
            if (dVar2 != null) {
                dVar2.h_();
            }
        }
    }

    private void uEA() {
        if (!this.CYO.get()) {
            this.CYO.set(true);
            c cVar = this.pFF;
            if (cVar != null) {
                cVar.sc(true, 3);
            }
        }
        this.GI.set(false);
    }

    private void wjp() {
        this.pFF = new zY(this.dE, this.zY, this.f28141sc, this.Tf, !cD(), this.WP, this.cvk, this.TRI);
        Sfl();
        if (this.JoC == null) {
            this.JoC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    TRI tri;
                    c cVar;
                    if (TRI.this.Xc == null || TRI.this.Xc.getViewTreeObserver() == null || (cVar = (tri = TRI.this).pFF) == null) {
                        return;
                    }
                    ((zY) cVar).sc(tri.Xc.getWidth(), TRI.this.Xc.getHeight());
                    TRI.this.Xc.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    TRI.this.JoC = null;
                }
            };
            this.Xc.getViewTreeObserver().addOnGlobalLayoutListener(this.JoC);
        }
    }

    public void BT() {
        Sfl sfl = this.f28141sc;
        if (sfl == null || sfl.GOt() == null) {
            return;
        }
        this.f28141sc.GOt().BT();
        this.f28141sc.GOt().sc().ExN(this.McK);
    }

    public boolean Ol() {
        return this.We;
    }

    public boolean Qj() {
        return this.wjp;
    }

    public void Ql() {
        if (getNativeVideoController() == null || !(getNativeVideoController() instanceof zY)) {
            return;
        }
        zY zYVar = (zY) getNativeVideoController();
        zYVar.sc(zYVar.Ql(), this);
    }

    public void SR() {
        if (BT.zY(Xc.sc()) != 0 && UFX()) {
            if (this.pFF.Tf() != null && this.pFF.Tf().qr()) {
                sc(true, uEA.intValue());
                pFF();
                Handler handler = this.Gb;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                return;
            }
            if (Qj() || this.GI.get()) {
                return;
            }
            this.GI.set(true);
            Cb();
            Sfl sfl = this.f28141sc;
            if (sfl != null && sfl.GI() != null) {
                Cb();
                this.f28141sc.GI();
                com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(CacheDirFactory.getICacheDir(this.f28141sc.Flm()).zY(), this.f28141sc);
                pffSc.pFF(this.f28141sc.kDg());
                pffSc.sc(this.Xc.getWidth());
                pffSc.pFF(this.Xc.getHeight());
                pffSc.zY(this.f28141sc.mD());
                pffSc.sc(this.McK);
                pffSc.sc(Ol());
                pffSc.sc(CacheDirFactory.getICacheDir(this.f28141sc.Flm()).zY());
                sc(pffSc);
                this.pFF.sc(pffSc);
            }
            Handler handler2 = this.Gb;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(1, 500L);
            }
            sc(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.sc
    public void TRI() {
        c.d dVar = this.BR;
        if (dVar != null) {
            dVar.d_();
        }
    }

    public boolean Tf() {
        boolean z11 = false;
        if (BT.zY(Xc.sc()) == 0) {
            return false;
        }
        if (this.pFF.Tf() != null && this.pFF.Tf().TRI()) {
            sc(false, Dl.intValue());
            Handler handler = this.Gb;
            z11 = true;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
        return z11;
    }

    public boolean UFX() {
        return Gb.sc(this, 50, JPJ.pFF(this.Tf) ? 1 : 5);
    }

    public void WH() {
        a aVarQl;
        c cVar = this.pFF;
        if (cVar == null || (aVarQl = cVar.Ql()) == null) {
            return;
        }
        aVarQl.sc();
        View viewZY = aVarQl.zY();
        if (viewZY != null) {
            viewZY.setVisibility(8);
            if (viewZY.getParent() != null) {
                ((ViewGroup) viewZY.getParent()).removeView(viewZY);
            }
        }
    }

    public double getCurrentPlayTime() {
        c cVar = this.pFF;
        if (cVar != null) {
            return (cVar.ExN() * 1.0d) / 1000.0d;
        }
        return 0.0d;
    }

    public c getNativeVideoController() {
        return this.pFF;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        YIK();
        getViewTreeObserver().addOnScrollChangedListener(this.MxZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Dl();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.MxZ);
        }
        ViewGroup viewGroup = this.Xc;
        if (viewGroup == null || this.JoC == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver2 = viewGroup.getViewTreeObserver();
        if (viewTreeObserver2.isAlive()) {
            viewTreeObserver2.removeOnGlobalLayoutListener(this.JoC);
            this.JoC = null;
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        YIK();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        pFF pff;
        c cVar;
        if (!this.Sfl && (pff = this.BT) != null && (cVar = this.pFF) != null) {
            pff.sc(cVar.BT(), this.pFF.Qj(), this.pFF.Ol(), this.pFF.ExN(), this.wjp);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Dl();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        if ("open_ad".equals(this.Tf)) {
            II();
            return;
        }
        this.FI = z11;
        super.onWindowFocusChanged(z11);
        com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(this.f28141sc, z11);
        McK();
        if (WP() && (cVar4 = this.pFF) != null && cVar4.BT()) {
            cvk();
            kX.sc((View) this.f28140qr, 8);
            pFF(true);
            We();
            return;
        }
        pFF();
        if (!cD() && Qj() && (cVar2 = this.pFF) != null && !cVar2.UFX()) {
            if (this.Gb != null) {
                if (z11 && (cVar3 = this.pFF) != null && !cVar3.BT()) {
                    this.Gb.obtainMessage(1).sendToTarget();
                    return;
                } else {
                    II();
                    sc(false, Dl.intValue());
                    return;
                }
            }
            return;
        }
        if (Qj()) {
            return;
        }
        if (!z11 && (cVar = this.pFF) != null && cVar.Tf() != null && this.pFF.Tf().TRI()) {
            II();
            sc(false, Dl.intValue());
        } else if (z11) {
            this.Gb.obtainMessage(1).sendToTarget();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        c cVar;
        Sfl sfl;
        c cVar2;
        c cVar3;
        super.onWindowVisibilityChanged(i11);
        McK();
        if (this.f28139pc) {
            this.f28139pc = i11 == 0;
        }
        if (WP() && (cVar3 = this.pFF) != null && cVar3.BT()) {
            cvk();
            kX.sc((View) this.f28140qr, 8);
            pFF(true);
            We();
            return;
        }
        pFF();
        if (cD() || !Qj() || (cVar = this.pFF) == null || cVar.UFX() || (sfl = this.f28141sc) == null) {
            return;
        }
        if (!this.II || sfl.GI() == null) {
            Tf.sc("NativeVideoTsView", "attachTask materialMeta.getVideo() is null !!");
        } else {
            this.f28141sc.GI();
            com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(CacheDirFactory.getICacheDir(this.f28141sc.Flm()).zY(), this.f28141sc);
            pffSc.pFF(this.f28141sc.kDg());
            pffSc.sc(this.Xc.getWidth());
            pffSc.pFF(this.Xc.getHeight());
            pffSc.zY(this.f28141sc.mD());
            pffSc.sc(this.McK);
            pffSc.sc(Ol());
            sc(pffSc);
            this.pFF.sc(pffSc);
            this.II = false;
            kX.sc((View) this.f28140qr, 8);
        }
        if (i11 != 0 || this.Gb == null || (cVar2 = this.pFF) == null || cVar2.BT()) {
            return;
        }
        this.Gb.obtainMessage(1).sendToTarget();
    }

    public void pFF() {
        Sfl sfl = this.f28141sc;
        if (sfl == null) {
            return;
        }
        int iQT = sfl.QT();
        int iPFF = Xc.We().pFF(iQT);
        int iZY = BT.zY(Xc.sc());
        if (iPFF == 1) {
            this.wjp = cJ.We(iZY);
        } else if (iPFF == 2) {
            this.wjp = cJ.ExN(iZY) || cJ.We(iZY) || cJ.TRI(iZY);
        } else if (iPFF == 3) {
            this.wjp = false;
        } else if (iPFF == 4) {
            this.SR = true;
        } else if (iPFF == 5) {
            this.wjp = cJ.We(iZY) || cJ.TRI(iZY);
        }
        if (this.Sfl) {
            this.We = false;
        } else if (!this.ExN || !JPJ.pFF(this.Tf)) {
            this.We = Xc.We().zY(String.valueOf(iQT));
        }
        if ("open_ad".equals(this.Tf)) {
            this.wjp = true;
            this.We = true;
        }
        c cVar = this.pFF;
        if (cVar != null) {
            cVar.We(this.wjp);
        }
        this.ExN = true;
    }

    @Override // t8.c.InterfaceC0849c
    public void pFF(long j11, int i11) {
    }

    public void pFF(boolean z11) {
        c cVar = this.pFF;
        if (cVar != null) {
            cVar.zY(z11);
            a aVarQl = this.pFF.Ql();
            if (aVarQl != null) {
                aVarQl.pFF();
                View viewZY = aVarQl.zY();
                if (viewZY != null) {
                    if (viewZY.getParent() != null) {
                        ((ViewGroup) viewZY.getParent()).removeView(viewZY);
                    }
                    viewZY.setVisibility(0);
                    addView(viewZY);
                    aVarQl.sc(this.f28141sc, new WeakReference<>(this.dE), false);
                }
            }
        }
    }

    public void qr() {
        View view;
        if (this.dE == null || (view = this.kX) == null || view.getParent() == null || this.f28141sc == null || this.f28140qr != null) {
            return;
        }
        ViewParent parent = this.kX.getParent();
        RelativeLayout relativeLayoutPFF = pFF(this.dE);
        if (parent != null && (parent instanceof ViewGroup)) {
            sc(relativeLayoutPFF, (ViewGroup) parent, this.kX);
        }
        this.f28140qr = relativeLayoutPFF;
        if (this.UFX) {
            kX.sc((View) this.WH, 0);
        }
        if (this.f28141sc.GI() != null && this.f28141sc.GI().r() != null) {
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.f28141sc.GI().r(), this.f28141sc.GI().L(), this.f28141sc.GI().z(), this.Qj, this.f28141sc);
        }
        ImageView imageView = this.WH;
        if (imageView != null) {
            imageView.setClickable(true);
            this.WH.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TRI.this.zY();
                }
            });
        }
    }

    public com.bytedance.sdk.openadsdk.core.Tf.TRI sc(List<Pair<View, FriendlyObstructionPurpose>> list) {
        c cVar = this.pFF;
        if (cVar instanceof zY) {
            return ((zY) cVar).sc(this, list);
        }
        return null;
    }

    @Override // t8.c.InterfaceC0849c
    public void sc() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.zY.sc
    public void sc(int i11) {
        pFF();
    }

    @Override // t8.c.InterfaceC0849c
    public void sc(long j11, int i11) {
        c.d dVar = this.BR;
        if (dVar != null) {
            dVar.i_();
        }
    }

    @Override // t8.c.InterfaceC0849c
    public void sc(long j11, long j12) {
        c.d dVar = this.BR;
        if (dVar != null) {
            dVar.sc(j11, j12);
        }
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        if (message.what == 1) {
            JPJ();
        }
    }

    public void sc(boolean z11) {
        if (this.Ol == null) {
            this.Ol = new ImageView(getContext());
            if (Ol.pFF().dE() != null) {
                this.Ol.setImageBitmap(Ol.pFF().dE());
            } else {
                this.Ol.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(Xc.sc(), "tt_new_play_video"));
            }
            this.Ol.setScaleType(ImageView.ScaleType.FIT_XY);
            int iZY = kX.zY(getContext(), this.Ql);
            int iZY2 = kX.zY(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iZY, iZY);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = iZY2;
            layoutParams.bottomMargin = iZY2;
            this.Xc.addView(this.Ol, layoutParams);
            this.Ol.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TRI.this.SR();
                }
            });
        }
        if (z11) {
            this.Ol.setVisibility(0);
        } else {
            this.Ol.setVisibility(8);
        }
    }

    public boolean sc(long j11, boolean z11, boolean z12) {
        boolean zSc = false;
        this.Xc.setVisibility(0);
        this.McK = j11;
        if (!cD()) {
            return true;
        }
        this.pFF.sc(false);
        Sfl sfl = this.f28141sc;
        if (sfl != null && sfl.GI() != null) {
            com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(CacheDirFactory.getICacheDir(this.f28141sc.Flm()).zY(), this.f28141sc);
            pffSc.pFF(this.f28141sc.kDg());
            pffSc.sc(this.Xc.getWidth());
            pffSc.pFF(this.Xc.getHeight());
            pffSc.zY(this.f28141sc.mD());
            pffSc.sc(j11);
            pffSc.sc(Ol());
            sc(pffSc);
            if (z12) {
                this.pFF.pFF(pffSc);
                return true;
            }
            zSc = this.pFF.sc(pffSc);
        }
        if (((j11 > 0 && !z11 && !z12) || (j11 > 0 && z11)) && this.pFF != null) {
            com.bytedance.sdk.openadsdk.We.ExN.pFF.BT.sc scVar = new com.bytedance.sdk.openadsdk.We.ExN.pFF.BT.sc();
            scVar.sc(this.pFF.ExN());
            scVar.zY(this.pFF.Qj());
            scVar.pFF(this.pFF.TRI());
            com.bytedance.sdk.openadsdk.We.ExN.sc.sc.pFF(this.pFF.Ql(), scVar);
        }
        return zSc;
    }

    public void setAdCreativeClickListener(sc scVar) {
        c cVar = this.pFF;
        if (cVar != null) {
            ((zY) cVar).sc(scVar);
        }
    }

    public void setControllerStatusCallBack(pFF pff) {
        this.BT = pff;
    }

    public void setIsAutoPlay(boolean z11) {
        if (this.OXF) {
            return;
        }
        int iPFF = Xc.We().pFF(this.f28141sc.QT());
        if (z11 && iPFF != 4 && (!BT.ExN(this.dE) ? !(!BT.TRI(this.dE) ? BT.We(this.dE) : HJN() || Gb()) : !HJN())) {
            z11 = false;
        }
        this.wjp = z11;
        c cVar = this.pFF;
        if (cVar != null) {
            cVar.We(z11);
        }
        if (this.wjp) {
            kX.sc((View) this.f28140qr, 8);
        } else {
            qr();
            RelativeLayout relativeLayout = this.f28140qr;
            if (relativeLayout != null) {
                kX.sc((View) relativeLayout, 0);
                Sfl sfl = this.f28141sc;
                if (sfl != null && sfl.GI() != null) {
                    com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.f28141sc.GI().r(), this.f28141sc.GI().L(), this.f28141sc.GI().z(), this.Qj, this.f28141sc);
                }
            }
        }
        this.OXF = true;
    }

    public void setIsQuiet(boolean z11) {
        this.We = z11;
        c cVar = this.pFF;
        if (cVar != null) {
            cVar.pFF(z11);
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z11) {
        this.UFX = z11;
    }

    public void setVideoAdClickListenerTTNativeAd(PAGNativeAd pAGNativeAd) {
        c cVar = this.pFF;
        if (cVar != null) {
            ((zY) cVar).sc(pAGNativeAd);
        }
    }

    public void setVideoAdInteractionListener(c.d dVar) {
        this.BR = dVar;
    }

    public void setVideoAdLoadListener(c.a aVar) {
        c cVar = this.pFF;
        if (cVar != null) {
            cVar.sc(aVar);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.YIK = str;
    }

    public void setVideoPlayCallback(com.bytedance.sdk.openadsdk.core.Ql.pFF.pFF pff) {
        c cVar = this.pFF;
        if (cVar != null) {
            ((zY) cVar).sc(pff);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        if (i11 == 4 || i11 == 8) {
            uEA();
        }
    }

    public void zY() {
        if (Tf()) {
            return;
        }
        SR();
    }
}
