package com.bytedance.sdk.openadsdk.core.Ql.pFF;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.ExN.UFX;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.core.widget.wjp;
import com.bytedance.sdk.openadsdk.utils.Ol;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.bytedance.sdk.openadsdk.wjp.sc.sc.qr;
import com.hisavana.common.tracking.TrackingKey;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import s8.b;
import t8.a;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN implements b, a<Sfl>, FI.sc, com.bytedance.sdk.openadsdk.core.pFF.sc.InterfaceC0305sc, com.bytedance.sdk.openadsdk.core.widget.Sfl.pFF, wjp.sc {
    private long BR;
    TextView BT;
    com.bytedance.sdk.openadsdk.core.pFF.sc Cb;
    boolean Dl;
    ImageView ExN;
    int FI;
    com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI Gb;
    boolean HJN;
    com.bytedance.sdk.openadsdk.core.widget.Sfl II;
    int JPJ;
    private final String JoC;
    sc McK;
    com.bytedance.sdk.openadsdk.core.pFF.sc OXF;
    View Ol;
    ImageView Qj;
    com.bytedance.sdk.openadsdk.core.widget.sc Ql;
    TextView SR;
    int Sfl;
    View TRI;
    View Tf;
    ImageView UFX;
    View WH;
    Sfl WP;
    com.bykv.vk.openvk.sc.sc.sc.TRI.a We;
    int Xc;
    int YIK;
    c cD;
    boolean cJ;
    Context cvk;
    TextView dE;
    private TRI.sc kX;
    protected final int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    View f28130qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final int f28131sc;
    boolean uEA;
    int wjp;
    ViewGroup zY;

    public ExN(Context context, ViewGroup viewGroup, boolean z11, int i11, Sfl sfl, c cVar) {
        this(context, viewGroup, z11, i11, sfl, cVar, true);
    }

    public ExN(Context context, ViewGroup viewGroup, boolean z11, int i11, Sfl sfl, c cVar, boolean z12) {
        this.f28131sc = 228;
        this.pFF = 160;
        this.Dl = true;
        this.HJN = true;
        this.cJ = true;
        this.JoC = Build.MODEL;
        if (this instanceof We) {
            return;
        }
        this.cvk = Xc.sc().getApplicationContext();
        We(z12);
        this.zY = viewGroup;
        this.Dl = z11;
        this.FI = i11;
        this.cD = cVar;
        this.WP = sfl;
        We(8);
        sc(context, this.zY);
        We();
        Tf();
    }

    private int ExN(int i11) {
        if (this.Sfl <= 0 || this.YIK <= 0) {
            return 0;
        }
        int iZY = kX.zY(this.cvk, 228.0f);
        int iZY2 = kX.zY(this.cvk, 160.0f);
        int i12 = (int) (this.YIK * ((i11 * 1.0f) / this.Sfl));
        if (i12 > iZY) {
            return iZY;
        }
        return i12 < iZY2 ? iZY2 : i12;
    }

    private void TRI(int i11) {
        kX.sc(this.Tf, i11);
    }

    private boolean WP() {
        return Sfl.ExN(this.WP) && (!com.bytedance.sdk.openadsdk.core.UFX.zY.sc(this.WP.cvk()) ? this.WP.JoC() == null : this.WP.qKn() == null) && this.WP.WP() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final int i11, final String str, final Sfl sfl) {
        com.bytedance.sdk.openadsdk.We.zY.sc(new Qj("load_vast_icon_fail") { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TrackingKey.ERROR_CODE, i11);
                    jSONObject.put(TrackingKey.DESCRIPTION, i11 + ":" + str);
                    jSONObject.put("url", ExN.this.WP.qfG().sc());
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.We.zY.pFF(ExN.this.WP, ExN.this.WP != null ? cJ.zY(sfl.qY()) : null, "load_vast_icon_fail", jSONObject);
            }
        });
    }

    public void BT() {
        com.bytedance.sdk.openadsdk.core.widget.Sfl sfl = this.II;
        if (sfl != null) {
            sfl.sc(false);
        }
    }

    public boolean Dl() {
        return this.Dl;
    }

    public void ExN() {
    }

    public boolean FI() {
        return (this.FI & 4) != 4 || this.Dl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.wjp.sc
    public boolean JPJ() {
        com.bytedance.sdk.openadsdk.core.widget.Sfl sfl = this.II;
        return sfl != null && sfl.sc();
    }

    public void Ol() {
        We(8);
        if (FI()) {
            this.We.setVisibility(8);
        }
        ImageView imageView = this.Qj;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        We(8);
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

    public void Qj() {
        kX.ExN(this.TRI);
    }

    public com.bykv.vk.openvk.sc.sc.sc.TRI.a Ql() {
        return this.We;
    }

    public void SR() {
        if (this.McK == null || this.II != null) {
            return;
        }
        System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.widget.Sfl sfl = new com.bytedance.sdk.openadsdk.core.widget.Sfl();
        this.II = sfl;
        sfl.sc(this.cvk, this.zY);
        this.II.sc(this.McK, this);
        System.currentTimeMillis();
    }

    public void Sfl() {
        try {
            kX.sc(this.WH, 8);
            kX.sc((View) this.UFX, 8);
            kX.sc(this.Tf, 8);
            kX.sc((View) this.Ql, 8);
            kX.sc((View) this.SR, 8);
            kX.sc((View) this.BT, 8);
            kX.sc((View) this.dE, 8);
        } catch (Exception unused) {
        }
    }

    public void TRI() {
    }

    public void Tf() {
        String str;
        int i11;
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar;
        String str2 = this.HJN ? "embeded_ad" : "embeded_ad_landingpage";
        if (this.WP.xP()) {
            str = "rewarded_video";
            i11 = 7;
        } else if (this.WP.Eyy()) {
            str = "fullscreen_interstitial_ad";
            i11 = 5;
        } else if (this.WP.VU()) {
            str = "banner_ad";
            i11 = 2;
        } else {
            str = str2;
            i11 = 1;
        }
        if (this.WP.QLv() == 4) {
            this.Gb = qr.sc(this.cvk, this.WP, str);
        }
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.core.pFF.sc(this.cvk, this.WP, str, i11);
        this.Cb = scVar2;
        scVar2.sc(this);
        this.Cb.pFF(true);
        if (this.HJN) {
            this.Cb.sc(true);
        } else {
            this.Cb.sc(false);
            this.Cb.zY(true);
        }
        this.Cb.sc(this.cD);
        this.Cb.ExN(true);
        this.Cb.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN.1
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
            public void sc(View view, int i12) {
                if (ExN.this.kX != null) {
                    ExN.this.kX.sc(view, i12);
                }
            }
        });
        com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri = this.Gb;
        if (tri != null && (scVar = this.Cb) != null) {
            scVar.sc(tri);
        }
        if (WP()) {
            com.bytedance.sdk.openadsdk.core.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.core.pFF.sc(this.cvk, this.WP, str, i11) { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN.2
                @Override // com.bytedance.sdk.openadsdk.core.pFF.sc
                public boolean pFF() {
                    com.bytedance.sdk.openadsdk.core.widget.Sfl sfl = ExN.this.II;
                    boolean zSc = sfl != null ? sfl.sc() : false;
                    ExN.this.ExN.getVisibility();
                    return zSc || ExN.this.ExN.getVisibility() == 0;
                }

                @Override // com.bytedance.sdk.openadsdk.core.pFF.sc
                public boolean zY() {
                    View view = ExN.this.WH;
                    if (view != null && view.getVisibility() == 0) {
                        return true;
                    }
                    View view2 = ExN.this.Tf;
                    if (view2 != null && view2.getVisibility() == 0) {
                        return true;
                    }
                    com.bytedance.sdk.openadsdk.core.widget.sc scVar4 = ExN.this.Ql;
                    if (scVar4 != null && scVar4.getVisibility() == 0) {
                        return true;
                    }
                    TextView textView = ExN.this.SR;
                    return textView != null && textView.getVisibility() == 0;
                }
            };
            this.OXF = scVar3;
            scVar3.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN.3
                @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
                public void sc(View view, int i12) {
                    if (ExN.this.kX != null) {
                        ExN.this.kX.sc(view, i12);
                    }
                }
            });
            this.OXF.pFF(true);
            this.OXF.sc(this.HJN);
            this.OXF.sc(this.cD);
            this.OXF.ExN(true);
            com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri2 = this.Gb;
            if (tri2 != null) {
                this.OXF.sc(tri2);
            }
            this.OXF.sc(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.Sfl.pFF
    public void UFX() {
        sc(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.Sfl.pFF
    public boolean WH() {
        return false;
    }

    public void We() {
        this.We.sc(this);
        this.ExN.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExN.this.dE()) {
                    TextView textView = ExN.this.dE;
                    if (textView == null || textView.getVisibility() != 0) {
                        ExN exN = ExN.this;
                        exN.McK.sc(exN, view);
                    }
                }
            }
        });
    }

    public void We(int i11) {
        this.JPJ = i11;
        kX.sc((View) this.zY, i11);
    }

    public void We(boolean z11) {
        this.HJN = z11;
        if (z11) {
            com.bytedance.sdk.openadsdk.core.pFF.sc scVar = this.Cb;
            if (scVar != null) {
                scVar.sc(true);
            }
            com.bytedance.sdk.openadsdk.core.pFF.sc scVar2 = this.OXF;
            if (scVar2 != null) {
                scVar2.sc(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar3 = this.Cb;
        if (scVar3 != null) {
            scVar3.sc(false);
        }
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar4 = this.OXF;
        if (scVar4 != null) {
            scVar4.sc(false);
        }
    }

    public void Xc() {
        kX.TRI(this.TRI);
        kX.TRI(this.f28130qr);
        if (this.ExN.getVisibility() == 0) {
            kX.sc((View) this.ExN, 8);
        }
    }

    public void YIK() {
        ImageView imageView = this.UFX;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        com.bytedance.sdk.openadsdk.core.widget.sc scVar = this.Ql;
        if (scVar != null) {
            scVar.setImageBitmap(null);
        }
    }

    public boolean dE() {
        if (this.McK != null) {
            return true;
        }
        Tf.sc("NewLiveViewLayout", "callback is null");
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.sc.InterfaceC0305sc
    public long getVideoProgress() {
        if (this.BR <= 0) {
            Sfl sfl = this.WP;
            if (sfl != null && sfl.GI() != null) {
                this.BR = (long) (this.WP.GI().m() * 1000.0d);
            }
            c cVar = this.cD;
            if (cVar != null) {
                this.BR = cVar.Qj();
            }
        }
        return this.BR;
    }

    @Override // t8.a
    public void pFF() {
        kX.ExN(this.TRI);
        kX.ExN(this.f28130qr);
        ImageView imageView = this.Qj;
        if (imageView != null) {
            kX.ExN(imageView);
        }
    }

    public void pFF(int i11, int i12) {
        ViewGroup.LayoutParams layoutParams = this.zY.getLayoutParams();
        if (i11 == -1 || i11 == -2 || i11 > 0) {
            layoutParams.width = i11;
        }
        if (i12 == -1 || i12 == -2 || i12 > 0) {
            layoutParams.height = i12;
        }
        this.zY.setLayoutParams(layoutParams);
    }

    @Override // s8.b
    public void pFF(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.We.getHolder()) {
            return;
        }
        this.uEA = false;
        if (dE()) {
            this.McK.pFF(this, surfaceHolder);
        }
    }

    public void pFF(ViewGroup viewGroup) {
    }

    public void pFF(boolean z11) {
    }

    public void pFF(boolean z11, boolean z12) {
        ImageView imageView = this.ExN;
        if (imageView != null) {
            if (z11) {
                imageView.setImageDrawable(Ol.sc(this.cvk, "tt_play_movebar_textpage"));
            } else {
                imageView.setImageDrawable(Ol.sc(this.cvk, "tt_stop_movebar_textpage"));
            }
        }
    }

    public boolean pFF(int i11) {
        return false;
    }

    public void qr() {
        Sfl sfl;
        kX.TRI(this.TRI);
        kX.TRI(this.f28130qr);
        if (this.Qj != null && (sfl = this.WP) != null && sfl.GI() != null && this.WP.GI().r() != null) {
            kX.TRI(this.Qj);
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.WP.GI().r(), this.WP.GI().L(), this.WP.GI().z(), this.Qj, this.WP);
        }
        if (this.ExN.getVisibility() == 0) {
            kX.sc((View) this.ExN, 8);
        }
    }

    @Override // t8.a
    public void sc() {
        sc(false, this.Dl);
        Sfl();
    }

    public void sc(int i11) {
    }

    public void sc(int i11, int i12) {
        if (i11 == -1) {
            i11 = kX.zY(this.cvk);
        }
        if (i11 <= 0) {
            return;
        }
        this.Xc = i11;
        if (Dl() || WH() || (this.FI & 8) == 8) {
            this.wjp = i12;
        } else {
            this.wjp = ExN(i11);
        }
        pFF(this.Xc, this.wjp);
    }

    public void sc(long j11) {
    }

    public void sc(long j11, long j12) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.ViewGroup, android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View, com.bykv.vk.openvk.sc.sc.sc.TRI.a] */
    public void sc(Context context, View view) {
        System.currentTimeMillis();
        Sfl sfl = this.WP;
        if ((sfl == null || ((!sfl.HL() && !this.WP.VU()) || dE.ef().ymG())) && view != null) {
            view.setKeepScreenOn(true);
        }
        c cVar = this.cD;
        ?? zYVar = (cVar == null || !cVar.Xc()) ? new com.bykv.vk.openvk.sc.sc.sc.TRI.zY(this.cvk) : new com.bykv.vk.openvk.sc.sc.sc.TRI.We(this.cvk);
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(zYVar, 0, layoutParams);
        }
        kX.sc((View) zYVar, 8);
        this.We = zYVar;
        this.ExN = (ImageView) view.findViewById(SR.WgX);
        this.TRI = view.findViewById(SR.f28741ag);
        this.f28130qr = view.findViewById(SR.f28743bp);
        this.Qj = (ImageView) view.findViewById(SR.pCa);
        this.Ol = view.findViewById(SR.VZ);
        System.currentTimeMillis();
    }

    @Override // s8.b
    public void sc(SurfaceTexture surfaceTexture, int i11, int i12) {
        this.uEA = true;
        if (dE()) {
            this.McK.sc(this, surfaceTexture);
        }
    }

    @Override // t8.a
    public void sc(Drawable drawable) {
        ViewGroup viewGroup = this.zY;
        if (viewGroup != null) {
            viewGroup.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
    }

    @Override // s8.b
    public void sc(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.We.getHolder()) {
            return;
        }
        this.uEA = true;
        if (dE()) {
            this.McK.sc(this, surfaceHolder);
        }
    }

    @Override // s8.b
    public void sc(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
        if (surfaceHolder != this.We.getHolder()) {
            return;
        }
        dE();
    }

    public void sc(View view, Context context) {
        View view2;
        if (view == null || context == null || (view2 = this.Ol) == null || view2.getParent() == null || this.WH != null) {
            return;
        }
        this.WH = this.Ol;
        this.UFX = (ImageView) view.findViewById(SR.f28755vl);
        this.Tf = view.findViewById(SR.f28745ef);
        this.Ql = (com.bytedance.sdk.openadsdk.core.widget.sc) view.findViewById(SR.qKn);
        this.SR = (TextView) view.findViewById(SR.f28751pc);
        this.BT = (TextView) view.findViewById(SR.GI);
        this.dE = (TextView) view.findViewById(SR.MxZ);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.wjp.sc
    public void sc(View view, boolean z11) {
    }

    public void sc(ViewGroup viewGroup) {
    }

    public void sc(PAGNativeAd pAGNativeAd) {
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar = this.Cb;
        if (scVar != null) {
            scVar.sc(pAGNativeAd);
        }
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar2 = this.OXF;
        if (scVar2 != null) {
            scVar2.sc(pAGNativeAd);
        }
    }

    public void sc(TRI.sc scVar) {
        this.kX = scVar;
    }

    /* JADX WARN: Code duplicated, block: B:94:0x021a  */
    @SuppressLint({"ClickableViewAccessibility"})
    /* JADX INFO: renamed from: sc, reason: avoid collision after fix types in other method */
    public void sc2(final Sfl sfl, WeakReference<Context> weakReference, boolean z11) {
        String strBSP;
        Sfl sfl2;
        Sfl sfl3;
        if (sfl == null) {
            return;
        }
        sc(false, this.Dl);
        sc(this.zY, Xc.sc());
        View view = this.WH;
        if (view != null) {
            kX.sc(view, 0);
        }
        ImageView imageView = this.UFX;
        if (imageView != null) {
            kX.sc((View) imageView, 0);
        }
        kX.sc(this.Tf, 0);
        if (this.UFX != null && (sfl3 = this.WP) != null && sfl3.GI() != null && this.WP.GI().r() != null) {
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.WP.GI().r(), this.WP.GI().L(), this.WP.GI().z(), this.UFX, sfl);
        }
        if (!TextUtils.isEmpty(sfl.MxZ())) {
            strBSP = sfl.MxZ();
        } else if (TextUtils.isEmpty(sfl.YdT())) {
            strBSP = !TextUtils.isEmpty(sfl.bSP()) ? sfl.bSP() : "";
        } else {
            strBSP = sfl.YdT();
        }
        if (this.Ql != null && (sfl2 = this.WP) != null && sfl2.qfG() != null && this.WP.qfG().sc() != null) {
            kX.sc((View) this.Ql, 0);
            kX.sc((View) this.SR, 4);
            Sfl sfl4 = this.WP;
            if (sfl4 == null || !sfl4.ymG()) {
                com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.WP.qfG(), this.Ql, sfl);
            } else {
                com.bytedance.sdk.openadsdk.Ol.We.sc(this.WP.qfG()).zY(2).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(sfl, this.WP.qfG().sc(), new com.bytedance.sdk.component.ExN.dE<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN.5
                    @Override // com.bytedance.sdk.component.ExN.dE
                    public void sc(int i11, String str, Throwable th2) {
                        ExN.this.sc(i11, str, sfl);
                    }

                    @Override // com.bytedance.sdk.component.ExN.dE
                    public void sc(UFX<Bitmap> ufx) {
                        if (ufx == null || ufx.pFF() == null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.widget.sc scVar = ExN.this.Ql;
                        if (scVar != null) {
                            scVar.setImageBitmap(ufx.pFF());
                        }
                        com.bytedance.sdk.openadsdk.We.zY.pFF(ExN.this.WP, ExN.this.WP != null ? cJ.zY(sfl.qY()) : null, "load_vast_icon_success", (JSONObject) null);
                    }
                }));
                if (this.WP.GOt() != null && this.WP.GOt().pFF() != null) {
                    this.WP.GOt().pFF().pFF(0L);
                }
            }
            Sfl sfl5 = this.WP;
            if (sfl5 != null && sfl5.ymG()) {
                try {
                    this.Ql.setTag(570425345, "VAST_ICON");
                } catch (Throwable unused) {
                }
            }
            Sfl sfl6 = this.WP;
            if (sfl6 != null && sfl6.GOt() != null && this.WP.GOt().pFF() != null) {
                final com.bytedance.sdk.openadsdk.core.Tf.pFF pFF = this.WP.GOt().pFF();
                com.bytedance.sdk.openadsdk.core.widget.sc scVar = this.Ql;
                if (scVar != null) {
                    scVar.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.pFF.ExN.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.openadsdk.core.Tf.pFF pff;
                            com.bytedance.sdk.openadsdk.core.widget.sc scVar2 = ExN.this.Ql;
                            if (scVar2 == null || !scVar2.isShown() || (pff = pFF) == null) {
                                return;
                            }
                            pff.pFF(ExN.this.getVideoProgress());
                        }
                    });
                }
            }
            if (WP()) {
                this.Ql.setOnClickListener(this.OXF);
                this.Ql.setOnTouchListener(this.OXF);
            } else {
                this.Ql.setOnClickListener(this.Cb);
                this.Ql.setOnTouchListener(this.Cb);
            }
        } else if (!TextUtils.isEmpty(strBSP)) {
            kX.sc((View) this.Ql, 4);
            kX.sc((View) this.SR, 0);
            TextView textView = this.SR;
            if (textView != null) {
                textView.setText(strBSP.substring(0, 1));
                if (WP()) {
                    this.SR.setOnClickListener(this.OXF);
                    this.SR.setOnTouchListener(this.OXF);
                } else {
                    this.SR.setOnClickListener(this.Cb);
                    this.SR.setOnTouchListener(this.Cb);
                }
            }
        }
        if (this.BT != null && !TextUtils.isEmpty(strBSP)) {
            this.BT.setText(strBSP);
            this.BT.setTag(570425345, "VAST_TITLE");
        }
        kX.sc((View) this.BT, 0);
        kX.sc((View) this.dE, 0);
        String strNQ = sfl.NQ();
        if (TextUtils.isEmpty(strNQ)) {
            int iQLv = sfl.QLv();
            if (iQLv == 2 || iQLv == 3) {
                strNQ = com.bytedance.sdk.component.utils.Sfl.sc(this.cvk, "tt_video_mobile_go_detail");
            } else if (iQLv == 4) {
                strNQ = com.bytedance.sdk.component.utils.Sfl.sc(this.cvk, "tt_video_download_apk");
            } else if (iQLv == 5) {
                strNQ = com.bytedance.sdk.component.utils.Sfl.sc(this.cvk, "tt_video_dial_phone");
            } else if (iQLv != 8) {
                strNQ = com.bytedance.sdk.component.utils.Sfl.sc(this.cvk, "tt_video_mobile_go_detail");
            } else {
                strNQ = com.bytedance.sdk.component.utils.Sfl.sc(this.cvk, "tt_video_mobile_go_detail");
            }
        }
        TextView textView2 = this.dE;
        if (textView2 != null) {
            textView2.setText(strNQ);
            this.dE.setOnClickListener(this.Cb);
            this.dE.setOnTouchListener(this.Cb);
        }
        if (this.cJ) {
            return;
        }
        TRI(4);
    }

    @Override // t8.a
    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void sc(Sfl sfl, WeakReference weakReference, boolean z11) {
        sc2(sfl, (WeakReference<Context>) weakReference, z11);
    }

    public void sc(String str) {
    }

    public void sc(t8.b bVar) {
        if (bVar instanceof sc) {
            this.McK = (sc) bVar;
            SR();
        }
    }

    @Override // t8.a
    public void sc(boolean z11) {
        this.cJ = z11;
    }

    public void sc(boolean z11, boolean z12) {
        kX.sc((View) this.ExN, 8);
    }

    public void sc(boolean z11, boolean z12, boolean z13) {
        kX.sc((View) this.ExN, (!z11 || this.TRI.getVisibility() == 0) ? 8 : 0);
    }

    public boolean sc(int i11, x8.a aVar, boolean z11) {
        com.bytedance.sdk.openadsdk.core.widget.Sfl sfl = this.II;
        return sfl == null || sfl.sc(i11, aVar, z11);
    }

    @Override // s8.b
    public boolean sc(SurfaceTexture surfaceTexture) {
        this.uEA = false;
        if (!dE()) {
            return true;
        }
        this.McK.pFF(this, surfaceTexture);
        return true;
    }

    public boolean uEA() {
        return this.uEA;
    }

    @TargetApi(14)
    public void wjp() {
        kX.sc((View) this.zY, 0);
        com.bykv.vk.openvk.sc.sc.sc.TRI.a aVar = this.We;
        if (aVar != null) {
            kX.sc(aVar.getView(), 0);
        }
    }

    @Override // t8.a
    public View zY() {
        return this.zY;
    }

    public void zY(int i11) {
        kX.sc((View) this.zY, 0);
        com.bykv.vk.openvk.sc.sc.sc.TRI.a aVar = this.We;
        if (aVar != null) {
            aVar.setVisibility(i11);
        }
    }

    public void zY(int i11, int i12) {
        this.Sfl = i11;
        this.YIK = i12;
    }

    public void zY(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.zY.getParent() == null) {
            viewGroup.addView(this.zY);
        }
        We(0);
    }

    public void zY(boolean z11) {
    }
}
