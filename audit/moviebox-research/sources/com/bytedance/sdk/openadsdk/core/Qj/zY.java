package com.bytedance.sdk.openadsdk.core.Qj;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.WP;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    private Sfl ExN;
    private int Ol;
    private ScheduledFuture<?> Qj;
    private int TRI;
    private com.bytedance.sdk.component.adexpress.pFF.BT We;
    private final Context pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f28104qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.model.Sfl f28105sc;
    private sc zY;

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements Runnable {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        InterfaceC0285zY f28107sc;

        public pFF(InterfaceC0285zY interfaceC0285zY) {
            this.f28107sc = interfaceC0285zY;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0285zY interfaceC0285zY = this.f28107sc;
            if (interfaceC0285zY != null) {
                interfaceC0285zY.sc(107, 107);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc implements com.bytedance.sdk.component.adexpress.pFF.We<View>, ExN.pFF {
        private PAGExpressAdWrapperListener BT;
        private final Context ExN;
        private com.bytedance.sdk.openadsdk.core.model.Sfl Ol;
        private FrameLayout Qj;
        private int Ql;
        private com.bytedance.sdk.component.adexpress.pFF.qr SR;
        private final int TRI;
        private ExN Tf;
        private String UFX;
        private final int WH;
        private String We;
        private com.bytedance.sdk.openadsdk.zY.zY pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private final int f28108qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        AtomicBoolean f28109sc = new AtomicBoolean(false);
        private TTDislikeDialogAbstract zY;

        public sc(Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11, int i12, String str, int i13) {
            this.UFX = str;
            if (sfl != null && sfl.ixT()) {
                this.UFX = "fullscreen_interstitial_ad";
            }
            this.ExN = context;
            this.TRI = i11;
            this.f28108qr = i12;
            this.Ol = sfl;
            this.WH = kX.zY(context, 3.0f);
            this.Ql = i13;
            TRI();
        }

        @SuppressLint({"ClickableViewAccessibility"})
        private ExN Qj() {
            ExN exNPFF = We.sc().pFF();
            this.Tf = exNPFF;
            if (exNPFF == null) {
                this.Tf = new ExN(this.ExN);
            }
            We.sc().zY(this.Tf);
            this.Tf.sc(this.Ol, this, this.UFX);
            this.Tf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this.Tf;
        }

        private void TRI() {
            FrameLayout frameLayout = new FrameLayout(this.ExN);
            this.Qj = frameLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.TRI, this.f28108qr);
            }
            layoutParams.width = this.TRI;
            layoutParams.height = this.f28108qr;
            layoutParams.gravity = 17;
            this.Qj.setLayoutParams(layoutParams);
            ExN exNQj = Qj();
            this.Qj.addView(exNQj);
            View viewQr = qr();
            this.Qj.addView(viewQr);
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Ol;
            if (sfl != null && sfl.ixT()) {
                exNQj.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                exNQj.sc(((Activity) this.ExN).findViewById(com.bytedance.sdk.openadsdk.utils.SR.Ao), FriendlyObstructionPurpose.OTHER);
            }
            FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
            exNQj.sc(viewQr, friendlyObstructionPurpose);
            Context context = this.ExN;
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            View viewFindViewById = ((Activity) context).findViewById(com.bytedance.sdk.openadsdk.utils.SR.Cwg);
            if (viewFindViewById != null) {
                exNQj.sc(viewFindViewById, friendlyObstructionPurpose);
            }
            View viewFindViewById2 = ((Activity) this.ExN).findViewById(com.bytedance.sdk.openadsdk.utils.SR.BU);
            if (viewFindViewById2 != null) {
                exNQj.sc(viewFindViewById2, friendlyObstructionPurpose);
            }
        }

        private View qr() {
            PAGLogoView pAGLogoView = new PAGLogoView(this.ExN);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Ol;
            if (sfl == null || !sfl.ixT()) {
                int i11 = this.WH;
                layoutParams.topMargin = i11;
                layoutParams.leftMargin = i11;
            } else {
                layoutParams.leftMargin = kX.zY(this.ExN, 20.0f);
                layoutParams.bottomMargin = kX.zY(this.ExN, 20.0f);
                layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
            }
            pAGLogoView.setLayoutParams(layoutParams);
            pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Qj.zY.sc.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebsiteActivity.sc(sc.this.ExN, sc.this.Ol, sc.this.UFX);
                }
            });
            return pAGLogoView;
        }

        @Override // com.bytedance.sdk.component.adexpress.pFF.We
        public View ExN() {
            return this.Qj;
        }

        public void We() {
            this.Qj = null;
            this.pFF = null;
            this.zY = null;
            this.SR = null;
            this.Ol = null;
            ExN exN = this.Tf;
            if (exN != null) {
                exN.Tf();
                We.sc().sc(this.Tf);
            }
            this.f28109sc.set(true);
        }

        @Override // com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF
        @SuppressLint({"ClickableViewAccessibility"})
        public void e_() {
            if (this.SR != null) {
                com.bytedance.sdk.component.adexpress.pFF.SR sr2 = new com.bytedance.sdk.component.adexpress.pFF.SR();
                sr2.sc(true);
                sr2.sc(kX.We(this.ExN, this.TRI));
                sr2.pFF(kX.We(this.ExN, this.f28108qr));
                this.SR.sc(this.Qj, sr2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF
        public View pFF() {
            FrameLayout frameLayout = this.Qj;
            if (frameLayout == null) {
                return null;
            }
            return (View) frameLayout.getParent();
        }

        @Override // com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF
        public View sc() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF
        public void sc(int i11, int i12) {
            com.bytedance.sdk.component.adexpress.pFF.qr qrVar = this.SR;
            if (qrVar != null) {
                qrVar.sc(i11, "render fail");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF
        public void sc(View view, int i11) {
            PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.BT;
            if (pAGExpressAdWrapperListener != null) {
                pAGExpressAdWrapperListener.onAdClicked();
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.pFF.We
        public void sc(com.bytedance.sdk.component.adexpress.pFF.qr qrVar) {
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl;
            if (this.f28109sc.get()) {
                return;
            }
            if (this.ExN == null || (sfl = this.Ol) == null) {
                qrVar.sc(106, "material null");
                return;
            }
            this.SR = qrVar;
            if (TextUtils.isEmpty(sfl.VZ())) {
                qrVar.sc(106, "dsp data is null");
            } else {
                this.Tf.dE();
            }
        }

        public void sc(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl;
            if (tTDislikeDialogAbstract != null && (sfl = this.Ol) != null) {
                tTDislikeDialogAbstract.setMaterialMeta(sfl.mD(), this.Ol.IEI());
            }
            this.zY = tTDislikeDialogAbstract;
        }

        public void sc(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
            this.BT = pAGExpressAdWrapperListener;
        }

        public void sc(WP wp2) {
            if (wp2 instanceof com.bytedance.sdk.openadsdk.zY.zY) {
                this.pFF = (com.bytedance.sdk.openadsdk.zY.zY) wp2;
            }
        }

        public void sc(String str) {
            this.We = str;
        }

        @Override // com.bytedance.sdk.component.adexpress.pFF.We
        public int zY() {
            return 5;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Qj.zY$zY, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0285zY {
        void pFF(String str);

        void sc();

        void sc(int i11, int i12);

        void sc(String str);
    }

    public zY(Context context, Sfl sfl, com.bytedance.sdk.openadsdk.core.model.Sfl sfl2, String str) {
        this.f28105sc = sfl2;
        this.pFF = context;
        this.ExN = sfl;
        sc(sfl);
        this.zY = new sc(context, sfl2, this.TRI, this.f28104qr, str, this.Ol);
    }

    private void sc(Sfl sfl) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = this.f28105sc;
        if (sfl2 != null && sfl2.ixT()) {
            this.TRI = -1;
            this.f28104qr = -1;
            return;
        }
        Xc xcSc = com.bytedance.sdk.openadsdk.core.zY.sc.sc(sfl.getExpectExpressWidth(), sfl.getExpectExpressHeight());
        this.Ol = xcSc.f28083sc;
        if (sfl.getExpectExpressWidth() <= 0 || sfl.getExpectExpressHeight() <= 0) {
            int iZY = kX.zY(this.pFF);
            this.TRI = iZY;
            this.f28104qr = Float.valueOf(iZY / xcSc.pFF).intValue();
        } else {
            this.TRI = kX.zY(this.pFF, sfl.getExpectExpressWidth());
            this.f28104qr = kX.zY(this.pFF, sfl.getExpectExpressHeight());
        }
        int i11 = this.TRI;
        if (i11 <= 0 || i11 <= kX.zY(this.pFF)) {
            return;
        }
        float fZY = kX.zY(this.pFF) / this.TRI;
        this.TRI = kX.zY(this.pFF);
        this.f28104qr = Float.valueOf(this.f28104qr * fZY).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY() {
        try {
            ScheduledFuture<?> scheduledFuture = this.Qj;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.Qj.cancel(false);
            this.Qj = null;
        } catch (Throwable unused) {
        }
    }

    public void pFF() {
        sc scVar = this.zY;
        if (scVar != null) {
            scVar.We();
            this.zY = null;
        }
        zY();
        this.We = null;
        this.ExN = null;
    }

    public void sc() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f28105sc;
        if (sfl != null && sfl.ixT()) {
            this.Qj = Cb.sc().schedule(new pFF(this.zY.Tf), com.bytedance.sdk.openadsdk.core.Xc.We().II(), TimeUnit.MILLISECONDS);
        }
        sc scVar = this.zY;
        if (scVar == null) {
            com.bytedance.sdk.component.adexpress.pFF.BT bt2 = this.We;
            if (bt2 != null) {
                bt2.a_(106);
                return;
            }
            return;
        }
        scVar.sc(new com.bytedance.sdk.component.adexpress.pFF.qr() { // from class: com.bytedance.sdk.openadsdk.core.Qj.zY.1
            @Override // com.bytedance.sdk.component.adexpress.pFF.qr
            public void sc(int i11, String str) {
                if (zY.this.We != null) {
                    zY.this.We.a_(106);
                }
                zY.this.zY();
            }

            @Override // com.bytedance.sdk.component.adexpress.pFF.qr
            public void sc(View view, com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
                if (zY.this.ExN == null || view == null) {
                    if (zY.this.We != null) {
                        zY.this.We.a_(106);
                    }
                } else if (zY.this.We != null) {
                    zY.this.We.sc(zY.this.zY, sr2);
                }
                zY.this.zY();
            }
        });
        View viewExN = this.zY.ExN();
        this.ExN.removeView(viewExN);
        if (viewExN.getParent() != null) {
            ((ViewGroup) viewExN.getParent()).removeView(viewExN);
        }
        this.ExN.addView(viewExN, new ViewGroup.LayoutParams(-1, -1));
    }

    public void sc(com.bytedance.sdk.component.adexpress.pFF.BT bt2) {
        this.We = bt2;
    }

    public void sc(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        sc scVar = this.zY;
        if (scVar != null) {
            scVar.sc(tTDislikeDialogAbstract);
        }
    }

    public void sc(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        sc scVar = this.zY;
        if (scVar != null) {
            scVar.sc(pAGExpressAdWrapperListener);
        }
    }

    public void sc(WP wp2) {
        sc scVar = this.zY;
        if (scVar != null) {
            scVar.sc(wp2);
        }
    }

    public void sc(String str) {
        sc scVar = this.zY;
        if (scVar != null) {
            scVar.sc(str);
        }
    }
}
