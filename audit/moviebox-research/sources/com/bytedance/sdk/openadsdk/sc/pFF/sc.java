package com.bytedance.sdk.openadsdk.sc.pFF;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.core.Qj.Ol;
import com.bytedance.sdk.openadsdk.core.Qj.Sfl;
import com.bytedance.sdk.openadsdk.core.Qj.wjp;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.BT;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private WeakReference<com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI> ExN;
    private Sfl Ol;
    private PAGMediaView Qj;
    private boolean Ql = false;
    private WeakReference<com.bytedance.sdk.openadsdk.core.Tf.TRI> SR;
    private pFF TRI;
    private com.bytedance.sdk.openadsdk.core.pFF.pFF Tf;
    private com.bytedance.sdk.openadsdk.core.pFF.sc UFX;
    private PAGMediaView WH;
    private boolean We;
    private final Context pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.sc.pFF.sc.zY f28687qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.core.model.Sfl f28688sc;
    private final String zY;

    public sc(Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str) {
        this.pFF = context;
        this.f28688sc = sfl;
        this.zY = str;
    }

    private PAGMediaView SR() {
        if (!com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.f28688sc)) {
            com.bytedance.sdk.openadsdk.sc.pFF.sc.zY zYVar = this.f28687qr;
            if (zYVar == null) {
                return null;
            }
            Sfl sflWe = zYVar.We();
            sflWe.setTag(520093762, Boolean.TRUE);
            if (!this.Ql) {
                this.f28687qr.ExN();
            }
            this.Ql = true;
            return sc(sflWe);
        }
        com.bytedance.sdk.openadsdk.sc.pFF.sc.zY zYVar2 = this.f28687qr;
        if (zYVar2 == null || !(zYVar2 instanceof com.bytedance.sdk.openadsdk.sc.pFF.sc.pFF)) {
            return null;
        }
        wjp wjpVar = (wjp) zYVar2.We();
        wjpVar.setTag(520093762, Boolean.TRUE);
        if (!this.Ql) {
            this.f28687qr.ExN();
        }
        this.Ql = true;
        return sc(wjpVar);
    }

    private zY pFF(final PAGVideoAdListener pAGVideoAdListener) {
        return new zY() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.sc.5
            @Override // com.bytedance.sdk.openadsdk.sc.pFF.zY
            public void pFF(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.sc.pFF.zY
            public void sc(int i11, int i12) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoError();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.sc.pFF.zY
            public void sc(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.sc.pFF.zY
            public void zY(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdComplete();
                }
            }
        };
    }

    private String pFF(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (TextUtils.isEmpty(sfl.YdT())) {
            return !TextUtils.isEmpty(sfl.bSP()) ? sfl.bSP() : "";
        }
        return sfl.YdT();
    }

    private PAGMediaView sc(final View view) {
        int i11;
        if (view == null) {
            return null;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        Sfl sfl = this.Ol;
        if (sfl != null) {
            sfl.setClickListener(null);
            this.Ol.setClickCreativeListener(null);
        }
        com.bytedance.sdk.openadsdk.core.pFF.pFF pff = this.Tf;
        if (pff != null && (pff instanceof Ol) && (view instanceof Sfl)) {
            ((Sfl) view).setClickListener((Ol) pff);
        }
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar = this.UFX;
        if (scVar != null && (scVar instanceof com.bytedance.sdk.openadsdk.core.Qj.Qj) && (view instanceof Sfl)) {
            ((Sfl) view).setClickCreativeListener((com.bytedance.sdk.openadsdk.core.Qj.Qj) scVar);
        }
        PAGMediaView pAGMediaView = new PAGMediaView(this.pFF) { // from class: com.bytedance.sdk.openadsdk.sc.pFF.sc.3
            private void sc(boolean z11) {
                Integer num = this.f27675sc;
                if (num != null) {
                    com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(num), z11 ? 4 : 8);
                }
                com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = sc.this.f28688sc;
                if (sfl2 != null) {
                    com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(sfl2, z11);
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                com.bytedance.sdk.openadsdk.utils.zY.sc(this, sc.this.f28688sc);
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z11) {
                super.onWindowFocusChanged(z11);
                if (view instanceof Sfl) {
                    return;
                }
                sc(z11);
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
            public void setVideoAdListener(PAGVideoAdListener pAGVideoAdListener) {
                super.setVideoAdListener(pAGVideoAdListener);
                sc.this.sc(pAGVideoAdListener);
            }
        };
        int i12 = -1;
        pAGMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i12 = layoutParams.width;
            i11 = layoutParams.height;
        } else {
            i11 = -1;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i12, i11);
        layoutParams2.gravity = 17;
        pAGMediaView.addView(view, layoutParams2);
        if (view instanceof Sfl) {
            this.Ol = (Sfl) view;
        }
        return pAGMediaView;
    }

    private String sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl.NP() != null && !TextUtils.isEmpty(sfl.NP().pFF())) {
            return sfl.NP().pFF();
        }
        if (TextUtils.isEmpty(sfl.MxZ())) {
            return !TextUtils.isEmpty(sfl.YdT()) ? sfl.YdT() : "";
        }
        return sfl.MxZ();
    }

    private void sc(PAGMediaView pAGMediaView) {
        if (pAGMediaView == null) {
            return;
        }
        try {
            pAGMediaView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } catch (Exception unused) {
        }
    }

    public String ExN() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f28688sc;
        if (sfl != null) {
            return pFF(sfl);
        }
        return null;
    }

    public PAGMediaView Ol() {
        if (!com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.f28688sc)) {
            List<BT> listHt = this.f28688sc.ht();
            if (listHt == null || listHt.isEmpty()) {
                ApmHelper.reportCustomError("images empty", "getMediaView return null", new RuntimeException());
                return null;
            }
            ImageView imageView = new ImageView(this.pFF);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BT bt2 = listHt.get(0);
            if (bt2 != null) {
                com.bytedance.sdk.openadsdk.Ol.We.sc(bt2).zY(2).sc(com.bytedance.sdk.openadsdk.Ol.zY.sc(this.f28688sc, bt2.sc(), imageView));
            }
            PAGMediaView pAGMediaViewSc = sc(imageView);
            if (this.UFX == null || !dE.ef().We(String.valueOf(this.f28688sc.QT()))) {
                pAGMediaViewSc.setOnClickListener(null);
                pAGMediaViewSc.setOnTouchListener(null);
            } else {
                pAGMediaViewSc.setOnClickListener(this.UFX);
                pAGMediaViewSc.setOnTouchListener(this.UFX);
            }
            pAGMediaViewSc.setTag(520093762, Boolean.TRUE);
            PAGMediaView pAGMediaView = this.Qj;
            if (pAGMediaView != null) {
                pAGMediaView.setOnClickListener(null);
                this.Qj.setOnTouchListener(null);
            }
            this.Qj = pAGMediaViewSc;
            return pAGMediaViewSc;
        }
        pFF pff = this.TRI;
        if (pff == null) {
            ApmHelper.reportCustomError("mPAGFeedVideoAdImpl null", "getMediaView return null", new RuntimeException());
            return null;
        }
        View viewExN = pff.ExN();
        if (viewExN == null) {
            ApmHelper.reportCustomError("adVideoView null", "getMediaView return null", new RuntimeException());
            return null;
        }
        if (viewExN.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewExN.getParent()).removeView(viewExN);
        }
        PAGMediaView pAGMediaView2 = this.Qj;
        if (pAGMediaView2 != null) {
            pAGMediaView2.setOnClickListener(null);
            this.Qj.setOnTouchListener(null);
        }
        PAGVideoMediaView pAGVideoMediaView = new PAGVideoMediaView(this.pFF, viewExN, this);
        pAGVideoMediaView.setTag(520093762, Boolean.TRUE);
        if (this.UFX == null || !dE.ef().We(String.valueOf(this.f28688sc.QT()))) {
            com.bytedance.sdk.openadsdk.core.pFF.zY zYVar = new com.bytedance.sdk.openadsdk.core.pFF.zY() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.sc.2
                @Override // com.bytedance.sdk.openadsdk.core.pFF.zY
                public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, boolean z11) {
                    try {
                        ((PAGVideoMediaView) view).handleInterruptVideo();
                    } catch (Exception unused) {
                    }
                }
            };
            pAGVideoMediaView.setOnClickListener(zYVar);
            pAGVideoMediaView.setOnTouchListener(zYVar);
        } else {
            pAGVideoMediaView.setOnClickListener(this.UFX);
            pAGVideoMediaView.setOnTouchListener(this.UFX);
        }
        this.Qj = pAGVideoMediaView;
        pAGVideoMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return pAGVideoMediaView;
    }

    public PAGMediaView Qj() {
        return this.WH;
    }

    public void Ql() {
        com.bytedance.sdk.openadsdk.core.Tf.TRI tri;
        WeakReference<com.bytedance.sdk.openadsdk.core.Tf.TRI> weakReference = this.SR;
        if (weakReference == null || (tri = weakReference.get()) == null) {
            return;
        }
        tri.sc(13);
    }

    public String TRI() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f28688sc;
        if (sfl != null) {
            return sfl.NQ();
        }
        return null;
    }

    public void Tf() {
        Context context = this.pFF;
        if (context != null) {
            TTWebsiteActivity.sc(context, this.f28688sc, this.zY);
        }
    }

    public View UFX() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl;
        if (Xc.sc() == null || (sfl = this.f28688sc) == null) {
            Tf.sc("TTNativeAdImpl", "getAdChoicesView mContext == null");
            return null;
        }
        if (!sfl.ymG() || !this.f28688sc.Qj()) {
            return null;
        }
        ImageView imageView = new ImageView(Xc.sc());
        com.bytedance.sdk.openadsdk.Xc.zY.sc().sc((int) kX.sc(Xc.sc(), 14.0f, true), imageView, this.f28688sc);
        return imageView;
    }

    public View WH() {
        if (Xc.sc() == null) {
            Tf.sc("TTNativeAdImpl", "getAdLogoView mContext == null");
            return null;
        }
        ImageView imageView = new ImageView(Xc.sc());
        imageView.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(Xc.sc(), "tt_ad_logo_new"));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.sc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sc.this.Tf();
            }
        });
        return imageView;
    }

    public String We() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f28688sc;
        if (sfl != null) {
            return sc(sfl);
        }
        return null;
    }

    public Sfl pFF() {
        return this.Ol;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public PAGMediaView qr() {
        PAGMediaView pAGMediaViewOl;
        com.bytedance.sdk.openadsdk.utils.pFF.sc(this.f28688sc);
        if (this.f28688sc.JPJ() == 2) {
            pAGMediaViewOl = SR();
            sc(pAGMediaViewOl);
        } else {
            pAGMediaViewOl = Ol();
        }
        if (pAGMediaViewOl != null) {
            pAGMediaViewOl.setMrcTrackerKey(com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.pFF(this.f28688sc));
        } else {
            pAGMediaViewOl = new PAGMediaView(this.pFF) { // from class: com.bytedance.sdk.openadsdk.sc.pFF.sc.1
                @Override // android.view.ViewGroup, android.view.View
                public void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    com.bytedance.sdk.openadsdk.utils.zY.sc(this, sc.this.f28688sc);
                }
            };
        }
        if (pAGMediaViewOl instanceof PAGVideoMediaView) {
            ((PAGVideoMediaView) pAGMediaViewOl).setMaterialMeta(this.f28688sc);
        }
        this.WH = pAGMediaViewOl;
        return pAGMediaViewOl;
    }

    public PAGMediaView sc() {
        return this.Qj;
    }

    public void sc(PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.sc.pFF.sc.zY zYVar;
        if (this.f28688sc.JPJ() == 2 && com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.f28688sc) && (zYVar = this.f28687qr) != null && (zYVar instanceof com.bytedance.sdk.openadsdk.sc.pFF.sc.pFF)) {
            wjp wjpVar = (wjp) zYVar.We();
            if (wjpVar != null) {
                wjpVar.setVideoAdListener(pFF(pAGVideoAdListener));
                return;
            }
            return;
        }
        pFF pff = this.TRI;
        if (pff != null) {
            pff.sc(pFF(pAGVideoAdListener));
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri) {
        this.ExN = new WeakReference<>(tri);
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Tf.TRI tri) {
        this.SR = new WeakReference<>(tri);
    }

    public void sc(com.bytedance.sdk.openadsdk.core.pFF.pFF pff) {
        this.Tf = pff;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.pFF.sc scVar) {
        this.UFX = scVar;
    }

    public void sc(pFF pff) {
        this.TRI = pff;
    }

    public void sc(com.bytedance.sdk.openadsdk.sc.pFF.sc.zY zYVar) {
        this.f28687qr = zYVar;
    }

    public void sc(boolean z11) {
        this.We = z11;
    }

    public PAGImageItem zY() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f28688sc;
        if (sfl == null || sfl.qfG() == null) {
            return null;
        }
        return new PAGImageItem(this.f28688sc.qfG().zY(), this.f28688sc.qfG().pFF(), this.f28688sc.qfG().sc(), (float) this.f28688sc.qfG().We());
    }
}
