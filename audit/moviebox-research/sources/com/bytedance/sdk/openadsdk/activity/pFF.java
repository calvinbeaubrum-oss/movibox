package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.Ql.UFX;
import com.bytedance.sdk.openadsdk.core.ExN.Qj;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.YIK;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.utils.Tf;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.bytedance.sdk.openadsdk.utils.qr;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    private static com.bytedance.sdk.openadsdk.sc.ExN.sc pFF;
    private static com.bytedance.sdk.openadsdk.sc.zY.pFF zY;
    private com.bytedance.sdk.openadsdk.activity.zY BT;
    private com.bytedance.sdk.openadsdk.component.reward.top.zY Dl;
    private final Sfl ExN;
    private boolean FI;
    private boolean JPJ;
    private com.bytedance.sdk.openadsdk.sc.zY.pFF Ol;
    private com.bytedance.sdk.openadsdk.sc.ExN.sc Qj;
    private int Ql;
    private com.bytedance.sdk.openadsdk.core.ExN.zY SR;
    private Bundle Sfl;
    private TRI Tf;
    private Activity UFX;
    private boolean WH;
    private int WP;
    private Qj Xc;
    private UFX YIK;
    private Runnable cvk;
    private com.bytedance.sdk.openadsdk.core.ExN.zY dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.Tf.Qj f27625qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public Tf f27626sc;
    private AbstractC0279pFF uEA;
    private int wjp;
    private final List<TRI> We = new ArrayList();
    private final Bundle TRI = new Bundle();

    /* JADX INFO: compiled from: source.java */
    public static class ExN {
        public boolean ExN;
        public boolean We;
        public final int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public final Bundle f27632sc = new Bundle();
        public final com.bytedance.sdk.openadsdk.component.reward.sc.sc zY;

        public ExN(int i11, com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
            this.pFF = i11;
            this.zY = scVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class We extends AbstractC0279pFF {
        private boolean Qj;
        private final int TRI;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private int f27633qr;

        public We(pFF pff, Sfl sfl, com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar) {
            super(pff, sfl, zYVar);
            this.TRI = Xc.We().II(String.valueOf(sfl.QT())).TRI;
        }

        @Override // com.bytedance.sdk.openadsdk.activity.pFF.AbstractC0279pFF, android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (!this.Qj && this.We <= this.f27633qr) {
                this.Qj = true;
                TRI triSfl = this.f27635sc.Sfl();
                if (triSfl instanceof com.bytedance.sdk.openadsdk.activity.ExN) {
                    ((com.bytedance.sdk.openadsdk.activity.ExN) triSfl).JPJ();
                }
            }
            super.handleMessage(message);
            return true;
        }

        @Override // com.bytedance.sdk.openadsdk.activity.pFF.AbstractC0279pFF
        public int sc(Sfl sfl) {
            return Xc.We().UFX(String.valueOf(sfl.QT()));
        }

        @Override // com.bytedance.sdk.openadsdk.activity.pFF.AbstractC0279pFF
        public void sc(int i11) {
            boolean z11 = this.ExN == 0;
            int i12 = this.We;
            super.sc(i11);
            if (!z11) {
                if (this.zY < i12) {
                    this.f27633qr = (int) ((1.0f - (this.TRI / 100.0f)) * this.We);
                }
            } else if (this.ExN == 1) {
                this.f27633qr = 3;
            } else {
                this.f27633qr = (int) ((1.0f - (this.TRI / 100.0f)) * this.zY);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.activity.pFF$pFF, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractC0279pFF implements Handler.Callback {
        protected int ExN;
        private boolean Ol;
        private final Context Qj;
        private final Handler TRI = new Handler(Looper.getMainLooper(), this);
        private boolean WH;
        protected int We;
        protected final Sfl pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.component.reward.top.zY f27634qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        protected final pFF f27635sc;
        protected float zY;

        public AbstractC0279pFF(pFF pff, Sfl sfl, com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar) {
            this.f27635sc = pff;
            this.pFF = sfl;
            this.f27634qr = zYVar;
            this.Qj = zYVar.getContext();
            this.We = sc(sfl);
        }

        private void We() {
            if (this.f27635sc.YIK()) {
                this.f27634qr.showSkipButton();
                this.Ol = true;
            } else {
                this.WH = true;
                this.f27634qr.showCloseButton();
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                if (this.We > 0) {
                    this.f27634qr.setSkipText(this.We + "s");
                    int i12 = this.We - 1;
                    this.We = i12;
                    if (i12 >= 0) {
                        this.TRI.removeMessages(message.what);
                        this.TRI.sendEmptyMessageDelayed(message.what, 1000L);
                    }
                } else {
                    We();
                }
            } else if (i11 == 2) {
                if (this.We > 0) {
                    this.f27634qr.setSkipText(this.We + "s");
                    int i13 = this.We - 1;
                    this.We = i13;
                    if (i13 >= 0) {
                        this.TRI.removeMessages(message.what);
                        this.TRI.sendEmptyMessageDelayed(message.what, 1000L);
                    }
                } else {
                    We();
                }
            }
            return true;
        }

        public void pFF() {
            if (this.We < 0 || this.Ol || this.WH) {
                return;
            }
            this.TRI.removeMessages(this.ExN);
            this.TRI.sendEmptyMessage(this.ExN);
        }

        public abstract int sc(Sfl sfl);

        public void sc() {
            this.TRI.removeMessages(this.ExN);
        }

        public void sc(int i11) {
            if (this.Ol || this.WH) {
                return;
            }
            float f11 = i11;
            this.zY = f11;
            if (f11 <= this.We) {
                this.ExN = 2;
                this.We = (int) f11;
            } else if (this.ExN == 0) {
                this.ExN = 1;
            }
            this.TRI.removeCallbacksAndMessages(null);
            this.TRI.sendEmptyMessage(this.ExN);
        }

        public void zY() {
            this.TRI.removeMessages(this.ExN);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc extends AbstractC0279pFF {
        public sc(pFF pff, Sfl sfl, com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar) {
            super(pff, sfl, zYVar);
        }

        @Override // com.bytedance.sdk.openadsdk.activity.pFF.AbstractC0279pFF
        public int sc(Sfl sfl) {
            return Xc.We().Sfl(String.valueOf(sfl.QT()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY implements Runnable {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final Sfl f27636sc;

        public zY(Sfl sfl) {
            this.f27636sc = sfl;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27636sc.xP()) {
                com.bytedance.sdk.openadsdk.component.reward.Tf.sc(Xc.sc()).sc(this.f27636sc.Cb());
            } else {
                com.bytedance.sdk.openadsdk.component.reward.ExN.sc(Xc.sc()).sc(this.f27636sc.Cb());
            }
        }
    }

    public pFF(Activity activity, Sfl sfl) {
        com.bytedance.sdk.openadsdk.core.model.sc scVarVBa;
        List<Sfl> listWe;
        this.ExN = sfl;
        this.UFX = activity;
        this.f27625qr = new com.bytedance.sdk.openadsdk.Tf.Qj(activity.getApplicationContext());
        int i11 = 0;
        if ((sfl instanceof YIK) && (scVarVBa = ((YIK) sfl).vBa()) != null) {
            boolean zTf = scVarVBa.Tf();
            this.WH = zTf;
            if (zTf) {
                if (!dE.ef().hE()) {
                    this.WH = false;
                }
                if (this.WH && (listWe = scVarVBa.We()) != null) {
                    Iterator<Sfl> it = listWe.iterator();
                    while (it.hasNext()) {
                        this.We.add(sc(this, it.next(), i11));
                        this.WP++;
                        i11++;
                    }
                }
            }
        }
        if (this.We.isEmpty() && !JPJ.zY(sfl)) {
            this.We.add(sc(this, sfl, i11));
            i11++;
        }
        if (dE.ef().SR(String.valueOf(sfl.QT())) || JPJ.zY(sfl)) {
            this.We.add(new com.bytedance.sdk.openadsdk.activity.zY(this, sfl, i11));
        } else if (sc()) {
            this.f27626sc = qr.sc(activity, new qr.sc() { // from class: com.bytedance.sdk.openadsdk.activity.pFF.1
                @Override // com.bytedance.sdk.openadsdk.utils.qr.sc
                public void pFF() {
                    if (pFF.this.Dl != null) {
                        pFF.this.Dl.setSkipInvisiable();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.qr.sc
                public View sc() {
                    if (pFF.this.Dl != null) {
                        return pFF.this.Dl.getCloseButton();
                    }
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TRI Sfl() {
        return this.Tf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YIK() {
        if (this.We.isEmpty()) {
            return false;
        }
        List<TRI> list = this.We;
        return list.get(list.size() - 1) instanceof com.bytedance.sdk.openadsdk.activity.zY;
    }

    private static TRI sc(pFF pff, Sfl sfl, int i11) {
        boolean zXP = sfl.xP();
        AdSlot adSlotCb = sfl.Cb();
        return (adSlotCb == null ? !zXP : adSlotCb.getDurationSlotType() != 7) ? new com.bytedance.sdk.openadsdk.activity.We(pff, sfl, i11) : new com.bytedance.sdk.openadsdk.activity.ExN(pff, sfl, i11);
    }

    private void sc(TRI tri, TRI tri2, ExN exN) {
        if (this.WH) {
            boolean z11 = tri2 instanceof com.bytedance.sdk.openadsdk.activity.sc;
            if (z11) {
                this.Ql++;
                sc(0.0f);
                if (this.uEA == null) {
                    if (tri2 instanceof com.bytedance.sdk.openadsdk.activity.We) {
                        this.uEA = new sc(this, this.ExN, this.Dl);
                    } else {
                        this.uEA = new We(this, this.ExN, this.Dl);
                    }
                }
                int iM = 0;
                for (int i11 = tri2.Ol; i11 < this.We.size(); i11++) {
                    TRI tri3 = this.We.get(i11);
                    if (tri3 instanceof com.bytedance.sdk.openadsdk.activity.zY) {
                        break;
                    }
                    x8.a aVarGI = tri3.Qj.GI();
                    iM = aVarGI != null ? (int) (((double) iM) + aVarGI.m()) : (int) (((long) iM) + 10);
                }
                this.uEA.sc(iM);
                Tf tf2 = this.f27626sc;
                if (tf2 != null && tri == null) {
                    tf2.sc(iM * 1000);
                }
            } else if (tri2 instanceof com.bytedance.sdk.openadsdk.activity.zY) {
                UFX ufx = this.YIK;
                if (ufx != null) {
                    kX.qr(ufx);
                    this.YIK = null;
                }
                com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar = this.Dl;
                if (zYVar != null) {
                    kX.qr(zYVar);
                    kX.qr(this.Dl.getITopLayout());
                    this.Dl = null;
                }
                AbstractC0279pFF abstractC0279pFF = this.uEA;
                if (abstractC0279pFF != null) {
                    abstractC0279pFF.zY();
                }
                if (tri instanceof com.bytedance.sdk.openadsdk.activity.ExN) {
                    ((com.bytedance.sdk.openadsdk.activity.ExN) tri).JPJ();
                }
                Tf tf3 = this.f27626sc;
                if (tf3 != null) {
                    tf3.zY();
                }
            }
            if (z11) {
                this.Xc.setText(this.UFX.getString(com.bytedance.sdk.component.utils.Sfl.pFF(Xc.sc(), "tt_multiple_ad_indicator"), Integer.valueOf(tri2.Ol + 1), Integer.valueOf(this.WP)));
            } else {
                this.Xc.setVisibility(8);
            }
        }
        for (int i12 = tri != null ? tri.Ol : 0; i12 < this.We.size(); i12++) {
            this.We.get(i12).sc(tri, tri2, exN);
        }
        tri2.sc(this.UFX, this.Sfl);
        int i13 = this.wjp;
        if (i13 == 2) {
            tri2.We(this.UFX);
            return;
        }
        if (i13 == 3) {
            tri2.We(this.UFX);
            tri2.pFF(this.UFX);
            tri2.pFF(true);
        } else if (i13 == 4) {
            tri2.pFF(false);
            tri2.ExN(this.UFX);
        } else {
            if (i13 != 5) {
                return;
            }
            tri2.zY(this.UFX);
        }
    }

    private void zY(TRI tri, ExN exN) {
        if (this.UFX == null) {
            return;
        }
        pFF();
        if (tri == null) {
            TRI tri2 = this.Tf;
            int i11 = tri2 != null ? tri2.Ol + 1 : 0;
            if (i11 < this.We.size()) {
                tri = this.We.get(i11);
            }
            if (tri == null) {
                sc(this.Tf);
                return;
            }
        }
        TRI tri3 = this.Tf;
        if (tri3 != null) {
            if (tri3 == tri) {
                return;
            }
            tri3.ExN(this.UFX);
            this.Tf.zY(this.UFX);
            View viewSc = this.Tf.sc();
            if (viewSc != null) {
                this.dE.removeView(viewSc);
            }
            this.Tf.BT();
            this.Tf.WH = false;
        }
        tri.WH = true;
        tri.sc(this.UFX, exN);
        View viewSc2 = tri.sc();
        if (viewSc2 != null) {
            ViewParent parent = viewSc2.getParent();
            if (parent != null) {
                if (parent == this.dE) {
                    viewSc2.setVisibility(0);
                } else if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(viewSc2);
                }
            }
            if (viewSc2.getParent() == null) {
                this.dE.addView(viewSc2, new ViewGroup.LayoutParams(-1, -1));
            }
            if (this.UFX.getWindow().getContainer() == null) {
                this.UFX.setContentView(this.SR);
            }
        }
        TRI tri4 = this.Tf;
        this.Tf = tri;
        sc(tri4, tri, exN);
    }

    public void BT() {
        this.FI = true;
    }

    public com.bytedance.sdk.openadsdk.activity.zY ExN() {
        com.bytedance.sdk.openadsdk.activity.zY zYVar = this.BT;
        if (zYVar != null) {
            return zYVar;
        }
        TRI tri = this.Tf;
        int i11 = tri != null ? tri.Ol : -1;
        for (int size = this.We.size() - 1; size > i11; size--) {
            TRI tri2 = this.We.get(size);
            if (tri2 instanceof com.bytedance.sdk.openadsdk.activity.zY) {
                this.BT = (com.bytedance.sdk.openadsdk.activity.zY) tri2;
                break;
            }
        }
        return this.BT;
    }

    public void ExN(TTAdActivity tTAdActivity) {
        this.wjp = 6;
        int iPFF = pFF();
        for (TRI tri : this.We) {
            if (tri.Ol >= iPFF) {
                tri.BT();
            }
        }
        TRI tri2 = this.Tf;
        if (tri2 != null) {
            tri2.II();
        }
        TRI tri3 = this.Tf;
        if (tri3 != null && !tri3.Sfl()) {
            SR.pFF().post(new zY(this.ExN));
        }
        AbstractC0279pFF abstractC0279pFF = this.uEA;
        if (abstractC0279pFF != null) {
            abstractC0279pFF.zY();
        }
        Tf tf2 = this.f27626sc;
        if (tf2 != null) {
            tf2.zY();
        }
        this.Tf = null;
        this.UFX = null;
    }

    @Nullable
    public TRI Ol() {
        int i11;
        TRI tri = this.Tf;
        if (tri != null && (i11 = tri.Ol + 1) >= 0 && i11 < this.We.size()) {
            return this.We.get(i11);
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.component.reward.top.zY Qj() {
        return this.Dl;
    }

    public void Ql() {
        if (dE()) {
            return;
        }
        Xc();
        com.bytedance.sdk.openadsdk.sc.ExN.sc scVar = this.Qj;
        if (scVar != null) {
            scVar.sc();
        } else {
            com.bytedance.sdk.openadsdk.sc.zY.pFF pff = this.Ol;
            if (pff != null) {
                pff.sc();
            }
        }
        Runnable runnable = this.cvk;
        if (runnable != null) {
            runnable.run();
            this.cvk = null;
        }
    }

    public boolean SR() {
        return this.FI;
    }

    public com.bytedance.sdk.openadsdk.activity.sc TRI() {
        TRI tri;
        TRI tri2 = this.Tf;
        if (tri2 == null) {
            return null;
        }
        int i11 = tri2.Ol;
        do {
            i11++;
            if (i11 >= this.We.size()) {
                return null;
            }
            tri = this.We.get(i11);
        } while (!(tri instanceof com.bytedance.sdk.openadsdk.activity.sc));
        return (com.bytedance.sdk.openadsdk.activity.sc) tri;
    }

    public void Tf() {
        com.bytedance.sdk.openadsdk.sc.ExN.sc scVar = this.Qj;
        if (scVar != null) {
            scVar.pFF();
            return;
        }
        com.bytedance.sdk.openadsdk.sc.zY.pFF pff = this.Ol;
        if (pff != null) {
            pff.pFF();
        }
    }

    public void UFX() {
        com.bytedance.sdk.openadsdk.sc.ExN.sc scVar = this.Qj;
        if (scVar != null) {
            scVar.onAdClicked();
            return;
        }
        com.bytedance.sdk.openadsdk.sc.zY.pFF pff = this.Ol;
        if (pff != null) {
            pff.onAdClicked();
        }
    }

    public Bundle WH() {
        return this.TRI;
    }

    public void We() {
        TRI tri = this.Tf;
        if (tri != null) {
            tri.Xc();
        }
    }

    public void We(TTAdActivity tTAdActivity) {
        this.wjp = 5;
        TRI tri = this.Tf;
        if (tri != null) {
            tri.zY(tTAdActivity);
        }
    }

    public void Xc() {
        this.JPJ = true;
    }

    public boolean dE() {
        return this.JPJ;
    }

    public int pFF() {
        TRI tri = this.Tf;
        if (tri != null) {
            return tri.Ol;
        }
        return -1;
    }

    public void pFF(TRI tri, ExN exN) {
        TRI tri2 = this.Tf;
        if (tri2 == null || tri2 == tri) {
            if (tri2 != null && (tri2 instanceof com.bytedance.sdk.openadsdk.activity.sc)) {
                final long jQj = (tri2.uEA() == null || this.Tf.uEA().JPJ == null) ? 0L : this.Tf.uEA().JPJ.Qj();
                final int i11 = this.Tf.Ol + 1;
                long jCurrentTimeMillis = System.currentTimeMillis();
                TRI tri3 = this.Tf;
                com.bytedance.sdk.openadsdk.We.zY.sc(jCurrentTimeMillis, tri3.Qj, tri3.b_(), "dislike_skip", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.activity.pFF.2
                    @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                    public JSONObject sc() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("ad_show_order", i11);
                            jSONObject2.put("pag_json_data", jSONObject3.toString());
                            jSONObject.put("duration", jQj);
                            jSONObject.put("ad_extra_data", jSONObject2);
                        } catch (Throwable unused) {
                        }
                        return jSONObject;
                    }
                });
            }
            zY(TRI(), exN);
        }
    }

    public void pFF(TTAdActivity tTAdActivity) {
        this.wjp = 3;
        TRI tri = this.Tf;
        if (tri != null) {
            tri.pFF(tTAdActivity);
        }
        AbstractC0279pFF abstractC0279pFF = this.uEA;
        if (abstractC0279pFF != null) {
            abstractC0279pFF.pFF();
        }
        Tf tf2 = this.f27626sc;
        if (tf2 != null) {
            tf2.sc();
        }
    }

    public int qr() {
        return this.Ql;
    }

    public void sc(float f11) {
        UFX ufx = this.YIK;
        if (ufx == null) {
            return;
        }
        ufx.setProgress(f11);
        if (f11 == 0.0f && this.YIK.getVisibility() == 0) {
            this.YIK.setVisibility(4);
        } else {
            if (f11 <= 0.0f || this.YIK.getVisibility() == 0) {
                return;
            }
            this.YIK.setVisibility(0);
        }
    }

    public void sc(int i11) {
        AbstractC0279pFF abstractC0279pFF = this.uEA;
        if (abstractC0279pFF == null) {
            return;
        }
        if (i11 == 2) {
            abstractC0279pFF.sc();
            Tf tf2 = this.f27626sc;
            if (tf2 != null) {
                tf2.pFF();
                return;
            }
            return;
        }
        if (i11 == 1) {
            abstractC0279pFF.pFF();
            Tf tf3 = this.f27626sc;
            if (tf3 != null) {
                tf3.sc();
            }
        }
    }

    public void sc(Activity activity) {
        TRI tri = this.Tf;
        if (tri != null) {
            tri.sc(activity);
        }
    }

    public void sc(View view) {
        if (view.getParent() != null) {
            return;
        }
        view.setVisibility(4);
        this.dE.addView(view, 0);
    }

    public void sc(TRI tri) {
        Activity activity = this.UFX;
        if (activity != null) {
            activity.finish();
        }
    }

    public void sc(TRI tri, ExN exN) {
        TRI tri2 = this.Tf;
        if (tri2 == null || tri2 == tri) {
            zY(null, exN);
        }
    }

    public void sc(final TRI tri, final boolean z11, final int i11, final String str, final int i12, final String str2) {
        Activity activity;
        if (!this.JPJ) {
            this.cvk = new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.pFF.3
                @Override // java.lang.Runnable
                public void run() {
                    pFF.this.sc(tri, z11, i11, str, i12, str2);
                }
            };
            return;
        }
        if (SR()) {
            return;
        }
        BT();
        if (this.Qj == null || (activity = this.UFX) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.pFF.4
            @Override // java.lang.Runnable
            public void run() {
                pFF.this.Qj.sc(z11, i11, str, i12, str2);
            }
        });
        if (sc()) {
            com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), tri.Qj, tri.b_(), z11 ? "reward_success" : "reward_fail");
        }
    }

    public void sc(TRI tri, boolean z11, boolean z12, boolean z13, int i11) {
        com.bytedance.sdk.openadsdk.activity.zY zYVarExN;
        TRI tri2 = this.Tf;
        if ((tri2 == null || tri2 == tri) && (zYVarExN = ExN()) != null) {
            ExN exN = new ExN(i11, tri != null ? tri.uEA() : null);
            exN.f27632sc.putBoolean("isSkip", z11);
            exN.f27632sc.putBoolean("force", z12);
            exN.f27632sc.putBoolean("isFromLandingPage", z13);
            zY(zYVarExN, exN);
        }
    }

    public void sc(TTAdActivity tTAdActivity) {
        this.wjp = 2;
        TRI tri = this.Tf;
        if (tri != null) {
            tri.We(tTAdActivity);
        }
    }

    public void sc(TTAdActivity tTAdActivity, Bundle bundle) {
        com.bytedance.sdk.openadsdk.sc.ExN.sc scVar = this.Qj;
        if (scVar != null) {
            pFF = scVar;
            return;
        }
        com.bytedance.sdk.openadsdk.sc.zY.pFF pff = this.Ol;
        if (pff != null) {
            zY = pff;
        }
    }

    public void sc(TTAdActivity tTAdActivity, Bundle bundle, com.bytedance.sdk.openadsdk.sc.ExN.sc scVar, com.bytedance.sdk.openadsdk.sc.zY.pFF pff) {
        this.Sfl = bundle;
        this.wjp = 1;
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(tTAdActivity);
        this.SR = zYVar;
        if (Build.VERSION.SDK_INT >= 35) {
            zYVar.setFitsSystemWindows(true);
        }
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar2 = new com.bytedance.sdk.openadsdk.core.ExN.zY(tTAdActivity);
        this.dE = zYVar2;
        this.SR.addView(zYVar2, new FrameLayout.LayoutParams(-1, -1));
        if (this.WH) {
            this.YIK = new UFX(tTAdActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, kX.zY(tTAdActivity, 2.0f));
            layoutParams.gravity = 80;
            this.SR.addView(this.YIK, layoutParams);
            Qj qj2 = new Qj(tTAdActivity);
            this.Xc = qj2;
            qj2.setTextColor(-1);
            this.Xc.setTextSize(15.0f);
            this.Xc.setShadowLayer(1.0f, 0.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = kX.zY(tTAdActivity, 60.0f);
            layoutParams2.rightMargin = kX.zY(tTAdActivity, 16.0f);
            layoutParams2.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
            this.SR.addView(this.Xc, layoutParams2);
            com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar3 = new com.bytedance.sdk.openadsdk.component.reward.top.zY(tTAdActivity);
            this.Dl = zYVar3;
            this.SR.addView(zYVar3, new FrameLayout.LayoutParams(-1, -2));
            this.Dl.sc(this.ExN);
            this.Dl.setShowDislike(true);
        }
        this.Qj = scVar;
        this.Ol = pff;
        if (scVar == null && bundle != null) {
            this.Qj = pFF;
            pFF = null;
        }
        if (pff == null && bundle != null) {
            this.Ol = zY;
            zY = null;
        }
        zY(null, new ExN(1, null));
    }

    public void sc(boolean z11) {
        TRI tri = this.Tf;
        if (tri != null) {
            tri.pFF(z11);
        }
    }

    public boolean sc() {
        return this.WH;
    }

    public com.bytedance.sdk.openadsdk.Tf.Qj wjp() {
        return this.f27625qr;
    }

    public Activity zY() {
        return this.UFX;
    }

    public void zY(TTAdActivity tTAdActivity) {
        this.wjp = 4;
        TRI tri = this.Tf;
        if (tri != null) {
            tri.ExN(tTAdActivity);
        }
        AbstractC0279pFF abstractC0279pFF = this.uEA;
        if (abstractC0279pFF != null) {
            abstractC0279pFF.sc();
        }
        Tf tf2 = this.f27626sc;
        if (tf2 != null) {
            tf2.pFF();
        }
    }
}
