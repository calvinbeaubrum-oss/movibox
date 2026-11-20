package com.bytedance.sdk.openadsdk.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.ExN.Qj;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.core.widget.dE;
import com.bytedance.sdk.openadsdk.utils.BT;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    private Qj BT;
    private float Dl;
    protected final com.bytedance.sdk.openadsdk.component.sc ExN;
    private Qj FI;
    private View II;
    private com.bytedance.sdk.openadsdk.component.Qj.zY JPJ;
    protected View Ol;
    protected FrameLayout Qj;
    private ImageView Ql;
    private PAGLogoView SR;
    private Qj Sfl;
    protected final int TRI;
    private RelativeLayout Tf;
    protected final com.bytedance.sdk.openadsdk.component.Qj.sc UFX;
    protected com.bytedance.sdk.openadsdk.core.ExN.We WH;
    private com.bytedance.sdk.openadsdk.core.ExN.We WP;
    protected final FrameLayout We;
    private Xc Xc;
    private float YIK;
    private dE cvk;
    private ImageView dE;
    protected final Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected int f27987qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final Activity f27988sc;

    @NonNull
    private final com.bytedance.sdk.openadsdk.component.Ol.Qj uEA = new com.bytedance.sdk.openadsdk.component.Ol.Qj();
    private Qj wjp;
    protected final boolean zY;

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements BT.sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final WeakReference<zY> f27994sc;

        public pFF(zY zYVar) {
            this.f27994sc = new WeakReference<>(zYVar);
        }

        @Override // com.bytedance.sdk.openadsdk.utils.BT.sc
        public void sc() {
        }

        @Override // com.bytedance.sdk.openadsdk.utils.BT.sc
        public void sc(com.bytedance.sdk.openadsdk.Xc.sc.pFF pff) {
            zY zYVar;
            if (!pff.We() || (zYVar = this.f27994sc.get()) == null) {
                return;
            }
            zYVar.sc(pff);
            if (pff.pFF() != null) {
                zYVar.sc(pff.sc());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class sc implements TRI.We {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        WeakReference<Activity> f27995sc;

        public sc(Activity activity) {
            this.f27995sc = new WeakReference<>(activity);
        }

        @Override // com.bytedance.sdk.openadsdk.component.TRI.We
        public void sc(Bitmap bitmap) {
            if (this.f27995sc.get() == null || this.f27995sc.get().isFinishing()) {
                return;
            }
            zY.this.sc(bitmap);
        }
    }

    public zY(Activity activity, Sfl sfl, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.sc scVar, int i11, boolean z11, com.bytedance.sdk.openadsdk.component.Qj.sc scVar2) {
        this.f27988sc = activity;
        this.pFF = sfl;
        this.We = frameLayout;
        this.f27987qr = i11;
        this.zY = z11;
        this.ExN = scVar;
        this.TRI = sfl.QT();
        this.UFX = scVar2;
    }

    private void Ol() {
        if (this.wjp != null) {
            if (this.pFF.NP() != null && !TextUtils.isEmpty(this.pFF.NP().pFF())) {
                this.wjp.setText(this.pFF.NP().pFF());
            } else if (TextUtils.isEmpty(this.pFF.MxZ())) {
                this.wjp.setVisibility(8);
            } else {
                this.wjp.setText(this.pFF.MxZ());
            }
        }
        if (this.Sfl != null) {
            if (TextUtils.isEmpty(this.pFF.YdT())) {
                this.Sfl.setVisibility(8);
            } else {
                this.Sfl.setText(this.pFF.YdT());
            }
        }
        if (this.Xc != null && this.pFF.qfG() != null && !TextUtils.isEmpty(this.pFF.qfG().sc())) {
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.pFF.qfG().sc(), this.pFF.qfG().pFF(), this.pFF.qfG().zY(), this.Xc, this.pFF);
        }
        this.ExN.zY();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008f  */
    private void Qj() {
        boolean z11;
        this.uEA.sc();
        this.BT.setText(this.pFF.NQ());
        if (this.pFF.LVf()) {
            Ol();
            return;
        }
        if (this.zY) {
            pFF(0);
            sc(8);
            if (sc(this.Qj)) {
                this.ExN.zY();
            } else {
                this.ExN.We();
            }
            TRI.sc(this.pFF, new sc(this.f27988sc), 25);
        } else {
            pFF(8);
            sc(0);
            WH();
            this.ExN.zY();
        }
        boolean z12 = true;
        if (this.FI == null) {
            z11 = false;
        } else {
            if (!TextUtils.isEmpty(this.pFF.MxZ())) {
                this.FI.setText(this.pFF.MxZ());
            } else if (this.pFF.NP() != null) {
                this.FI.setText(this.pFF.NP().pFF());
            } else {
                z11 = false;
            }
            z11 = true;
        }
        if (this.WP != null) {
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.pFF.qfG(), this.WP, this.pFF);
        }
        dE dEVar = this.cvk;
        if (dEVar != null) {
            kX.sc((TextView) null, dEVar, this.pFF);
            if (this.pFF.NP() == null || this.pFF.NP().We() < 0.0d) {
                this.cvk.setVisibility(8);
                z12 = z11;
            }
        } else {
            z12 = z11;
        }
        View view = this.II;
        if (view != null) {
            view.setVisibility(z12 ? 0 : 8);
        }
    }

    private void WH() {
        com.bytedance.sdk.openadsdk.core.model.BT bt2 = this.pFF.ht().get(0);
        BT.sc(new com.bytedance.sdk.openadsdk.Xc.sc(bt2.sc(), bt2.qr()), bt2.pFF(), bt2.zY(), new pFF(this), com.bytedance.sdk.openadsdk.component.qr.sc.pFF(TextUtils.isEmpty(bt2.qr()) ? com.bytedance.sdk.component.utils.ExN.sc(bt2.sc()) : bt2.qr()).getParent(), 25);
    }

    private void pFF(int i11) {
        kX.sc((View) this.Qj, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                this.dE.setImageDrawable(new BitmapDrawable(com.bytedance.sdk.openadsdk.core.Xc.sc().getResources(), bitmap));
            } catch (Throwable unused) {
                Tf.sc("AppOpenAdNativeManager", "open_ad", "bindBackGroundImage error");
            }
        }
    }

    public void ExN() {
    }

    public void TRI() {
        this.Ol.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.zY.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.component.sc scVar = zY.this.ExN;
                if (scVar != null) {
                    scVar.pFF(view);
                }
            }
        });
        this.WH.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.zY.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.component.sc scVar = zY.this.ExN;
                if (scVar != null) {
                    scVar.sc(view);
                }
            }
        });
    }

    public int We() {
        return -1;
    }

    public void pFF() {
        if (this.pFF.Pu()) {
            this.ExN.zY();
        } else {
            Qj();
        }
    }

    public com.bytedance.sdk.openadsdk.component.Qj.zY qr() {
        return this.JPJ;
    }

    public JSONObject sc(JSONObject jSONObject) {
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void sc() {
        this.SR.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.zY.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    zY zYVar = zY.this;
                    TTWebsiteActivity.sc(zYVar.f27988sc, zYVar.pFF, "open_ad");
                } catch (Throwable th2) {
                    Tf.sc("AppOpenAdNativeManager", th2.getMessage());
                }
            }
        });
        TRI();
        if (this.pFF.Pu()) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.sc.sc scVarSc = com.bytedance.sdk.openadsdk.component.sc.pFF.sc(this.pFF, this.f27988sc, this.UFX);
        scVarSc.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.component.zY.3
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
            public void sc(View view, int i11) {
                zY.this.ExN.ExN();
            }
        });
        scVarSc.sc(this.JPJ);
        if (this.pFF.Ql() == 1) {
            this.Tf.setOnClickListener(scVarSc);
            this.Tf.setOnTouchListener(scVarSc);
        }
        this.BT.setOnClickListener(scVarSc);
        this.BT.setOnTouchListener(scVarSc);
    }

    public void sc(float f11, float f12) {
        this.Dl = f11;
        this.YIK = f12;
    }

    public void sc(int i11) {
        kX.sc((View) this.Ql, i11);
    }

    public void sc(int i11, int i12, boolean z11) {
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = this.WH;
        if (we2 == null) {
            return;
        }
        int i13 = z11 ? 0 : 8;
        if (we2.getVisibility() != i13) {
            this.WH.setVisibility(i13);
        }
    }

    public void sc(ViewGroup viewGroup) {
        com.bytedance.sdk.openadsdk.component.Ol.zY we2 = new com.bytedance.sdk.openadsdk.component.Ol.We(this.f27988sc);
        int iSR = this.pFF.SR();
        if (iSR == 5) {
            we2 = new com.bytedance.sdk.openadsdk.component.Ol.TRI(this.f27988sc);
        } else if (iSR == 4) {
            we2 = new com.bytedance.sdk.openadsdk.component.Ol.ExN(this.f27988sc, this.pFF);
        }
        this.Tf = we2;
        viewGroup.addView(we2);
        this.dE = we2.getBackImage();
        this.Qj = we2.getVideoContainer();
        this.Ql = we2.getImageView();
        this.BT = we2.getClickButton();
        this.SR = we2.getAdLogo();
        this.FI = we2.getAdTitleTextView();
        this.WP = we2.getAdIconView();
        this.cvk = we2.getScoreBar();
        this.II = we2.getOverlayLayout();
        if (this.pFF.LVf()) {
            this.Xc = we2.getIconOnlyView();
            this.wjp = we2.getTitle();
            this.Sfl = we2.getContent();
        }
        if (we2.getDspAdChoice() != null) {
            we2.getDspAdChoice().sc(14, this.pFF);
        }
        if (!this.pFF.Pu()) {
            this.uEA.sc(we2, this.pFF, this.Dl, this.YIK, this.zY);
        }
        this.Ol = we2.getTopDisLike();
        this.WH = we2.getTopSkip();
        if (we2 instanceof com.bytedance.sdk.openadsdk.component.Ol.ExN) {
            ((com.bytedance.sdk.openadsdk.component.Ol.ExN) we2).setRenderListener(new com.bytedance.sdk.openadsdk.component.Ol.ExN.sc() { // from class: com.bytedance.sdk.openadsdk.component.zY.1
                @Override // com.bytedance.sdk.openadsdk.component.Ol.ExN.sc
                public void sc(View view, int i11) {
                    zY.this.ExN.ExN();
                }
            });
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.Xc.sc.pFF pff) {
        if (pff.pFF() != null) {
            this.Ql.setImageBitmap(pff.pFF());
            return;
        }
        if (this.pFF.ht() == null || this.pFF.ht().get(0) == null) {
            return;
        }
        Drawable drawableSc = BT.sc(pff.zY(), this.pFF.ht().get(0).pFF());
        this.Ql.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.Ql.setImageDrawable(drawableSc);
    }

    public boolean sc(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.Qj.zY zYVar = new com.bytedance.sdk.openadsdk.component.Qj.zY(this.f27988sc);
        this.JPJ = zYVar;
        return zYVar.sc(frameLayout, this.ExN, this.pFF);
    }

    public void zY() {
        com.bytedance.sdk.openadsdk.component.Qj.zY zYVar = this.JPJ;
        if (zYVar != null) {
            zYVar.UFX();
        }
    }
}
