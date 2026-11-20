package com.bytedance.sdk.openadsdk.core.zY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Qj.Sfl;
import com.bytedance.sdk.openadsdk.core.Qj.wjp;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.BR;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.JPJ;
import com.bytedance.sdk.openadsdk.utils.McK;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends PAGBannerAd {
    TTDislikeDialogAbstract ExN;
    private com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI Ol;
    private PAGBannerAdWrapperListener Qj;
    private Sfl SR;
    private boolean Tf;
    private boolean UFX;
    protected AdSlot We;
    private boolean dE;
    protected final Context pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final boolean f28573qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected zY f28574sc;
    protected com.bytedance.sdk.openadsdk.core.model.Sfl zY;
    private final Queue<Long> WH = new LinkedList();
    private String Ql = "banner_ad";
    private final AtomicBoolean BT = new AtomicBoolean(false);
    protected final View.OnAttachStateChangeListener TRI = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.zY.We.1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (We.this.dE) {
                return;
            }
            We we2 = We.this;
            we2.sc(we2.f28574sc.getCurView(), We.this.zY);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            We.this.f28574sc.zY();
        }
    };

    /* JADX INFO: compiled from: source.java */
    public static class pFF extends Qj {
        com.bytedance.sdk.openadsdk.core.model.Sfl pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        boolean f28583sc;
        WeakReference<We> zY;

        public pFF(boolean z11, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, We we2) {
            super("ReportWindowFocusChangedAdShow");
            this.f28583sc = z11;
            this.pFF = sfl;
            this.zY = new WeakReference<>(we2);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<We> weakReference = this.zY;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.zY.get().pFF(this.f28583sc, this.pFF);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc();
    }

    public We(Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot) {
        this.pFF = context;
        this.zY = sfl;
        this.We = adSlot;
        sc(context, sfl, adSlot);
        this.f28573qr = false;
        this.dE = false;
    }

    private void pFF(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        Queue<Long> queue = this.WH;
        if (queue == null || queue.size() <= 0 || sfl == null) {
            return;
        }
        try {
            long jLongValue = this.WH.poll().longValue();
            if (jLongValue <= 0 || this.SR == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.We.zY.sc(String.valueOf(System.currentTimeMillis() - jLongValue), sfl, this.Ql, this.SR.getAdShowTime());
        } catch (Exception e11) {
            Tf.sc("PAGBannerAdImpl", e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(boolean z11, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        Long lPoll;
        try {
            if (z11) {
                this.WH.offer(Long.valueOf(System.currentTimeMillis()));
            } else {
                if (this.WH.size() <= 0 || this.SR == null || (lPoll = this.WH.poll()) == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.We.zY.sc(String.valueOf(System.currentTimeMillis() - lPoll.longValue()), sfl, this.Ql, this.SR.getAdShowTime());
            }
        } catch (Exception e11) {
            Tf.sc("PAGBannerAdImpl", e11.getMessage());
        }
    }

    private com.bytedance.sdk.openadsdk.core.qr sc(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            try {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt instanceof com.bytedance.sdk.openadsdk.core.qr) {
                    return (com.bytedance.sdk.openadsdk.core.qr) childAt;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl.QLv() == 4) {
            return com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(this.pFF, sfl, this.Ql);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(View view, Sfl sfl, com.bytedance.sdk.openadsdk.core.model.Sfl sfl2, String str, sc scVar) {
        Ol.pFF().sc(str, scVar);
        Queue<Long> queue = this.WH;
        if (queue != null) {
            queue.offer(Long.valueOf(System.currentTimeMillis()));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (sfl != null) {
                jSONObject.put("dynamic_show_type", sfl.getDynamicShowType());
                sfl.sc(jSONObject, sfl2);
            }
            if (view != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("width", view.getWidth());
                    jSONObject2.put("height", view.getHeight());
                    jSONObject2.put("alpha", view.getAlpha());
                } catch (Throwable unused) {
                }
                jSONObject.put("root_view", jSONObject2.toString());
            }
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl2, this.Ql, jSONObject);
            com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(sfl2);
        } catch (JSONException unused2) {
            Tf.sc("PAGBannerAdImpl", "onShowFun json error");
        }
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.Qj;
        if (pAGBannerAdWrapperListener != null) {
            pAGBannerAdWrapperListener.onAdShow(view, sfl2.QLv());
        }
        if (sfl2.QST()) {
            cJ.sc(sfl2, view);
        }
        zY zYVar = this.f28574sc;
        if (zYVar == null || zYVar.getCurView() == null) {
            return;
        }
        this.f28574sc.getCurView().WH();
        this.f28574sc.getCurView().Qj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(com.bytedance.sdk.openadsdk.core.qr qrVar, boolean z11, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        pFF(sfl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z11, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (z11 && this.zY.RiV() && !this.zY.AIZ()) {
            this.zY.qr(true);
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = this.zY;
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl2, this.Ql, sfl2.fKf());
        }
        Cb.pFF(new pFF(z11, sfl, this), 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY() {
        pFF();
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void destroy() {
        zY zYVar = this.f28574sc;
        if (zYVar != null) {
            try {
                zYVar.zY();
                this.f28574sc.removeOnAttachStateChangeListener(this.TRI);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public View getBannerView() {
        com.bytedance.sdk.openadsdk.utils.pFF.sc(this.zY);
        IPMiBroadcastReceiver.sc(this.pFF, this.zY);
        return this.f28574sc;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.zY;
        if (sfl == null || sfl.eoh() == null) {
            return null;
        }
        try {
            return this.zY.eoh().get(str);
        } catch (Throwable th2) {
            Tf.sc("PAGBannerAdImpl", th2.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.zY;
        if (sfl != null) {
            return sfl.eoh();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d11, String str, String str2) {
        if (this.Tf) {
            return;
        }
        McK.sc(this.zY, d11, str, str2);
        this.Tf = true;
    }

    public void pFF() {
        this.zY.sc(SystemClock.elapsedRealtime());
        this.f28574sc.pFF();
    }

    public sc sc() {
        return new sc() { // from class: com.bytedance.sdk.openadsdk.core.zY.We.7
            private View sc(boolean z11) {
                com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(We.this.pFF);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                zYVar.setBackgroundColor(-1);
                zYVar.setLayoutParams(layoutParams);
                View view = new View(We.this.pFF);
                ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                view.setAlpha(0.3f);
                view.setBackgroundColor(Color.parseColor("#F3F7F8"));
                zYVar.addView(view, layoutParams2);
                com.bytedance.sdk.openadsdk.core.ExN.zY zYVar2 = new com.bytedance.sdk.openadsdk.core.ExN.zY(We.this.pFF);
                ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                if (z11) {
                    zYVar2.setBackground(com.bytedance.sdk.component.utils.Sfl.zY(We.this.pFF, "tt_ad_closed_background_300_250"));
                } else {
                    zYVar2.setBackground(com.bytedance.sdk.component.utils.Sfl.zY(We.this.pFF, "tt_ad_closed_background_320_50"));
                }
                zYVar.addView(zYVar2, layoutParams3);
                com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(We.this.pFF);
                we2.setId(520093739);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
                if (z11) {
                    int iZY = kX.zY(We.this.pFF, 16.0f);
                    layoutParams4.width = kX.zY(We.this.pFF, 77.0f);
                    layoutParams4.height = kX.zY(We.this.pFF, 14.0f);
                    layoutParams4.leftMargin = iZY;
                    layoutParams4.topMargin = iZY;
                } else {
                    int iZY2 = kX.zY(We.this.pFF, 8.0f);
                    layoutParams4.width = kX.zY(We.this.pFF, 45.0f);
                    layoutParams4.height = kX.zY(We.this.pFF, 8.18f);
                    layoutParams4.leftMargin = iZY2;
                    layoutParams4.topMargin = iZY2;
                }
                we2.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(We.this.pFF, "tt_ad_closed_logo_red"));
                zYVar2.addView(we2, layoutParams4);
                com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(We.this.pFF);
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams5.gravity = 17;
                qj2.setAlpha(0.5f);
                qj2.setLines(1);
                qj2.setText(com.bytedance.sdk.component.utils.Sfl.sc(We.this.pFF, "tt_ad_is_closed"));
                if (z11) {
                    qj2.setTextSize(18.0f);
                } else {
                    qj2.setTextSize(12.0f);
                }
                zYVar2.addView(qj2, layoutParams5);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.zY.We.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        We we3 = We.this;
                        TTWebsiteActivity.sc(we3.pFF, we3.zY, we3.Ql);
                    }
                };
                we2.setOnClickListener(onClickListener);
                qj2.setOnClickListener(onClickListener);
                return zYVar;
            }

            @Override // com.bytedance.sdk.openadsdk.core.zY.We.sc
            public void sc() {
                int width = We.this.SR.getWidth();
                int height = We.this.SR.getHeight();
                View viewSc = sc(((double) height) >= Math.floor((((double) width) * 450.0d) / 600.0d));
                We.this.SR.SR();
                We.this.SR.removeAllViews();
                We.this.SR.addView(viewSc, new ViewGroup.LayoutParams(width, height));
                We.this.SR.setClickCreativeListener(null);
                We.this.SR.setClickListener(null);
                if (We.this.Qj != null) {
                    We.this.Qj.onAdDismissed();
                }
                We.this.dE = true;
            }
        };
    }

    public void sc(Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot) {
        zY zYVar = new zY(context, sfl, adSlot);
        this.f28574sc = zYVar;
        zYVar.addOnAttachStateChangeListener(this.TRI);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void sc(@NonNull final Sfl sfl, @NonNull final com.bytedance.sdk.openadsdk.core.model.Sfl sfl2) {
        final com.bytedance.sdk.openadsdk.core.qr qrVar;
        if (sfl == null || sfl2 == null) {
            return;
        }
        this.zY = sfl2;
        this.Ol = sc(sfl2);
        this.SR = sfl;
        final String strSc = JPJ.sc();
        final sc scVarSc = sc();
        sfl.setClosedListenerKey(strSc);
        sfl.setBannerClickClosedListener(scVarSc);
        sfl.setBackupListener(new com.bytedance.sdk.component.adexpress.pFF.zY() { // from class: com.bytedance.sdk.openadsdk.core.zY.We.2
            @Override // com.bytedance.sdk.component.adexpress.pFF.zY
            public boolean sc(ViewGroup viewGroup, int i11) {
                try {
                    sfl.Tf();
                    if (!We.this.zY.ymG()) {
                        com.bytedance.sdk.openadsdk.core.zY.sc scVar = new com.bytedance.sdk.openadsdk.core.zY.sc(sfl.getContext());
                        scVar.setClosedListenerKey(strSc);
                        We we2 = We.this;
                        scVar.sc(we2.zY, sfl, we2.Ol);
                        scVar.setDislikeOuter(We.this.ExN);
                        scVar.setAdInteractionListener(We.this.Qj);
                        return true;
                    }
                    qr qrVar2 = new qr(sfl.getContext());
                    qrVar2.setClosedListenerKey(strSc);
                    We we3 = We.this;
                    qrVar2.sc(we3.zY, sfl, we3.Ol);
                    qrVar2.setDislikeOuter(We.this.ExN);
                    qrVar2.setAdInteractionListener(We.this.Qj);
                    sfl.setVastVideoHelper(qrVar2);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        if (this.f28573qr) {
            BR.sc(sfl, true, 1, new BR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.zY.We.4
                @Override // com.bytedance.sdk.openadsdk.utils.BR.pFF
                public void pFF() {
                    We.this.sc((com.bytedance.sdk.openadsdk.core.qr) null, true, sfl2);
                }

                @Override // com.bytedance.sdk.openadsdk.utils.BR.pFF
                public void sc() {
                    We.this.zY();
                }

                @Override // com.bytedance.sdk.openadsdk.utils.BR.pFF
                public void sc(View view, boolean z11) {
                    if (!z11) {
                        com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(We.this.zY, 8);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(We.this.zY, 4);
                    if (We.this.BT.compareAndSet(false, true)) {
                        We.this.sc(view, sfl, sfl2, strSc, scVarSc);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.BR.pFF
                public void sc(boolean z11) {
                    We.this.sc(z11, sfl2);
                }
            }, null);
            qrVar = null;
        } else {
            com.bytedance.sdk.openadsdk.core.qr qrVarSc = sc(sfl);
            if (qrVarSc == null) {
                qrVarSc = new com.bytedance.sdk.openadsdk.core.qr(this.pFF, sfl);
                sfl.addView(qrVarSc);
            }
            qrVar = qrVarSc;
            qrVar.setCallback(new com.bytedance.sdk.openadsdk.core.qr.sc() { // from class: com.bytedance.sdk.openadsdk.core.zY.We.3
                @Override // com.bytedance.sdk.openadsdk.core.qr.sc
                public void pFF() {
                    We.this.sc(qrVar, false, sfl2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.qr.sc
                public void sc() {
                    We.this.zY();
                }

                @Override // com.bytedance.sdk.openadsdk.core.qr.sc
                public void sc(View view) {
                    if (We.this.BT.compareAndSet(false, true)) {
                        We.this.sc(view, sfl, sfl2, strSc, scVarSc);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.qr.sc
                public void sc(boolean z11) {
                    We.this.sc(z11, sfl2);
                }
            });
        }
        Context contextSc = com.bytedance.sdk.component.utils.pFF.sc(sfl);
        if (contextSc == null) {
            contextSc = this.pFF;
        }
        com.bytedance.sdk.openadsdk.core.Qj.Ol ol2 = new com.bytedance.sdk.openadsdk.core.Qj.Ol(contextSc, sfl2, this.Ql, 2);
        ol2.sc(sfl);
        ol2.sc(this);
        ol2.sc(this.Ol);
        ol2.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.core.zY.We.5
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
            public void sc(View view, int i11) {
                if (We.this.Qj != null) {
                    We.this.Qj.onAdClicked();
                }
            }
        });
        sfl.setClickListener(ol2);
        com.bytedance.sdk.openadsdk.core.Qj.Qj qj2 = new com.bytedance.sdk.openadsdk.core.Qj.Qj(this.pFF, sfl2, this.Ql, 2);
        qj2.sc((View) sfl);
        qj2.sc(this);
        qj2.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.core.zY.We.6
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
            public void sc(View view, int i11) {
                if (We.this.Qj != null) {
                    We.this.Qj.onAdClicked();
                }
            }
        });
        Sfl sfl3 = this.SR;
        if (sfl3 instanceof wjp) {
            qj2.sc(((wjp) sfl3).getVideoController());
        }
        qj2.sc(this.Ol);
        sfl.setClickCreativeListener(qj2);
        if (this.f28573qr) {
            return;
        }
        qrVar.setNeedCheckingShow(true);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionCallback(PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback) {
        ExN exN = new ExN(pAGBannerAdInteractionCallback);
        this.Qj = exN;
        this.f28574sc.setExpressInteractionListener(exN);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionListener(PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        ExN exN = new ExN(pAGBannerAdInteractionListener);
        this.Qj = exN;
        this.f28574sc.setExpressInteractionListener(exN);
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d11) {
        if (this.UFX) {
            return;
        }
        McK.sc(this.zY, d11);
        this.UFX = true;
    }
}
