package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.utils.BR;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class dE {
    private long Qj;
    private com.bytedance.sdk.openadsdk.core.pFF.pFF Ql;
    private com.bytedance.sdk.openadsdk.core.pFF.sc SR;
    private final String TRI;
    private c UFX;
    private final com.bytedance.sdk.openadsdk.sc.pFF.sc WH;
    private final PAGNativeAd We;
    private com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.sc.pFF.TRI f28365qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.model.Sfl f28366sc;
    private final Context zY;
    private List<View> ExN = new ArrayList();
    private final com.bytedance.sdk.openadsdk.We.qr Ol = new com.bytedance.sdk.openadsdk.We.qr();
    private final AtomicBoolean Tf = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    public static class sc implements View.OnLayoutChangeListener {
        private final ViewGroup pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.We.qr f28373sc;

        public sc(com.bytedance.sdk.openadsdk.We.qr qrVar, ViewGroup viewGroup) {
            this.f28373sc = qrVar;
            this.pFF = viewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.f28373sc.sc(System.currentTimeMillis(), Gb.sc(this.pFF));
        }
    }

    public dE(Context context, PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str, com.bytedance.sdk.openadsdk.sc.pFF.sc scVar) {
        this.We = pAGNativeAd;
        this.f28366sc = sfl;
        this.zY = context;
        this.TRI = str;
        this.WH = scVar;
        if (sfl.QLv() == 4) {
            this.pFF = com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(context, sfl, str);
        }
    }

    private qr We(ViewGroup viewGroup) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof qr) {
                return (qr) childAt;
            }
        }
        return null;
    }

    private qr pFF(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, @Nullable List<View> list3, com.bytedance.sdk.openadsdk.sc.pFF.TRI tri) {
        this.f28365qr = tri;
        viewGroup.addOnLayoutChangeListener(new sc(this.Ol, viewGroup));
        this.ExN = list;
        qr qrVarWe = We(viewGroup);
        if (qrVarWe == null) {
            qrVarWe = new qr(this.zY, viewGroup);
            viewGroup.addView(qrVarWe);
        }
        qrVarWe.sc();
        qrVarWe.setRefClickViews(list2);
        if (list != null) {
            for (View view : this.ExN) {
                if (view != null) {
                    view.setTag(520093762, Boolean.TRUE);
                }
            }
            if (list3 != null) {
                list3.addAll(list);
            }
        }
        qrVarWe.setRefCreativeViews(list3);
        return qrVarWe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF() {
        if (this.Qj > 0) {
            com.bytedance.sdk.openadsdk.We.zY.sc(String.valueOf(SystemClock.elapsedRealtime() - this.Qj), this.f28366sc, this.TRI, this.Ol);
            this.Qj = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(ViewGroup viewGroup) {
        this.Ol.sc(System.currentTimeMillis(), Gb.sc(viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(ViewGroup viewGroup, View view) {
        if (this.Tf.get()) {
            return;
        }
        this.Tf.set(true);
        if (this.We instanceof com.bytedance.sdk.openadsdk.sc.pFF.sc.zY) {
            com.bytedance.sdk.openadsdk.core.Qj.Sfl sflPFF = this.WH.pFF();
            if (sflPFF != null) {
                sflPFF.Qj();
            }
            ((com.bytedance.sdk.openadsdk.sc.pFF.sc.zY) this.We).sc(true);
        }
        this.Ol.sc(System.currentTimeMillis(), Gb.sc(viewGroup));
        this.Qj = SystemClock.elapsedRealtime();
        zY(viewGroup);
        com.bytedance.sdk.openadsdk.sc.pFF.TRI tri = this.f28365qr;
        if (tri != null) {
            tri.sc(this.We);
        }
        if (this.f28366sc.QST()) {
            cJ.sc(this.f28366sc, view);
        }
        if (this.f28366sc.GOt() != null) {
            this.f28366sc.GOt().sc().sc(0L);
        }
    }

    private void pFF(com.bytedance.sdk.openadsdk.core.pFF.pFF pff, com.bytedance.sdk.openadsdk.core.pFF.sc scVar) {
        com.bytedance.sdk.openadsdk.sc.pFF.sc scVar2 = this.WH;
        if (scVar2 != null && scVar2.pFF() != null) {
            com.bytedance.sdk.openadsdk.core.Qj.Sfl sflPFF = this.WH.pFF();
            if ((pff instanceof com.bytedance.sdk.openadsdk.core.Qj.Ol) && (scVar instanceof com.bytedance.sdk.openadsdk.core.Qj.Qj)) {
                sflPFF.setClickListener((com.bytedance.sdk.openadsdk.core.Qj.Ol) pff);
                sflPFF.setClickCreativeListener((com.bytedance.sdk.openadsdk.core.Qj.Qj) scVar);
            }
            sflPFF.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.TRI() { // from class: com.bytedance.sdk.openadsdk.core.dE.3
                @Override // com.bytedance.sdk.openadsdk.core.widget.TRI
                public void sc() {
                    if (dE.this.f28365qr != null) {
                        dE.this.f28365qr.onAdClicked();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.sc.pFF.sc scVar3 = this.WH;
        if (scVar3 != null && scVar3.sc() != null) {
            this.WH.sc().setOnClickListener(scVar);
            this.WH.sc().setOnTouchListener(scVar);
        }
        com.bytedance.sdk.openadsdk.sc.pFF.sc scVar4 = this.WH;
        if (scVar4 != null) {
            scVar4.sc(scVar);
            this.WH.sc(pff);
        }
    }

    private void sc(final ViewGroup viewGroup) {
        BR.sc(viewGroup, true, 5, new BR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.dE.6
            @Override // com.bytedance.sdk.openadsdk.utils.BR.pFF
            public void pFF() {
                dE.this.pFF();
            }

            @Override // com.bytedance.sdk.openadsdk.utils.BR.pFF
            public void sc() {
                dE.this.pFF(viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.BR.pFF
            public void sc(View view, boolean z11) {
                if (!z11) {
                    com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(dE.this.f28366sc, 8);
                } else {
                    com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(dE.this.f28366sc, 4);
                    dE.this.pFF(viewGroup, view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.BR.pFF
            public void sc(boolean z11) {
                dE.this.sc(z11, viewGroup);
            }
        }, null);
    }

    private void sc(@NonNull ViewGroup viewGroup, @Nullable View view) {
        HashMap map = new HashMap();
        map.put("click_scence", 1);
        Context contextSc = viewGroup != null ? com.bytedance.sdk.component.utils.pFF.sc(viewGroup) : null;
        if (contextSc == null) {
            contextSc = this.zY;
        }
        if (this.f28366sc.JPJ() == 2) {
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f28366sc;
            String str = this.TRI;
            this.Ql = new com.bytedance.sdk.openadsdk.core.Qj.Ol(contextSc, sfl, str, cJ.sc(str));
        } else {
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = this.f28366sc;
            String str2 = this.TRI;
            this.Ql = new com.bytedance.sdk.openadsdk.core.pFF.pFF(contextSc, sfl2, str2, cJ.sc(str2));
        }
        this.Ql.sc(viewGroup);
        this.Ql.sc(this.UFX);
        this.Ql.pFF(view);
        this.Ql.sc(this.pFF);
        this.Ql.sc(this.We);
        this.Ql.sc(map);
        this.Ql.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.core.dE.1
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
            public void sc(View view2, int i11) {
                if (dE.this.f28365qr != null) {
                    dE.this.f28365qr.onAdClicked();
                }
            }
        });
        if (this.f28366sc.JPJ() == 2) {
            Context context = this.zY;
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl3 = this.f28366sc;
            String str3 = this.TRI;
            this.SR = new com.bytedance.sdk.openadsdk.core.Qj.Qj(context, sfl3, str3, cJ.sc(str3));
        } else {
            Context context2 = this.zY;
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl4 = this.f28366sc;
            String str4 = this.TRI;
            this.SR = new com.bytedance.sdk.openadsdk.core.pFF.sc(context2, sfl4, str4, cJ.sc(str4));
        }
        this.SR.sc(viewGroup);
        this.SR.sc(this.UFX);
        this.SR.pFF(view);
        this.SR.sc(this.pFF);
        this.SR.sc(this.We);
        this.SR.sc(map);
        this.SR.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.core.dE.2
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
            public void sc(View view2, int i11) {
                if (dE.this.f28365qr != null) {
                    dE.this.f28365qr.onAdClicked();
                }
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(dE.this.f28366sc, 9);
                dE.this.WH.Ql();
            }
        });
    }

    private void sc(@NonNull ViewGroup viewGroup, qr qrVar, List<View> list, @Nullable List<View> list2) {
        com.bytedance.sdk.openadsdk.core.pFF.pFF pff = this.Ql;
        if (pff == null || this.SR == null) {
            return;
        }
        qrVar.sc(list, pff);
        qrVar.sc(list2, this.SR);
        sc(this.Ql, this.SR);
        sc(qrVar, viewGroup);
    }

    private void sc(@NonNull ViewGroup viewGroup, List<View> list, @Nullable List<View> list2) {
        com.bytedance.sdk.openadsdk.core.pFF.pFF pff = this.Ql;
        if (pff == null || this.SR == null) {
            return;
        }
        sc(list, pff);
        sc(list2, this.SR);
        sc(this.Ql, this.SR);
        sc(viewGroup);
    }

    private void sc(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, @Nullable List<View> list3, com.bytedance.sdk.openadsdk.sc.pFF.TRI tri) {
        this.f28365qr = tri;
        viewGroup.addOnLayoutChangeListener(new sc(this.Ol, viewGroup));
        this.ExN = list;
        sc(list2, (com.bytedance.sdk.openadsdk.core.pFF.zY) null);
        if (list != null) {
            for (View view : this.ExN) {
                if (view != null) {
                    view.setTag(520093762, Boolean.TRUE);
                }
            }
            if (list3 != null) {
                list3.addAll(list);
            }
        }
        sc(list3, (com.bytedance.sdk.openadsdk.core.pFF.zY) null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void sc(com.bytedance.sdk.openadsdk.core.pFF.pFF pff, com.bytedance.sdk.openadsdk.core.pFF.sc scVar) {
        if (this.f28366sc.JPJ() == 2) {
            pFF(pff, scVar);
        } else {
            sc(scVar);
        }
    }

    private void sc(com.bytedance.sdk.openadsdk.core.pFF.sc scVar) {
        if (com.bytedance.sdk.openadsdk.core.settings.dE.ef().We(String.valueOf(this.f28366sc.QT()))) {
            com.bytedance.sdk.openadsdk.sc.pFF.sc scVar2 = this.WH;
            if (scVar2 != null && scVar2.sc() != null) {
                this.WH.sc().setOnClickListener(scVar);
                this.WH.sc().setOnTouchListener(scVar);
            }
            com.bytedance.sdk.openadsdk.sc.pFF.sc scVar3 = this.WH;
            if (scVar3 != null) {
                scVar3.sc(scVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.sc.pFF.sc scVar4 = this.WH;
        if (scVar4 != null && scVar4.sc() != null) {
            PAGMediaView pAGMediaViewSc = this.WH.sc();
            com.bytedance.sdk.openadsdk.core.pFF.zY zYVar = new com.bytedance.sdk.openadsdk.core.pFF.zY() { // from class: com.bytedance.sdk.openadsdk.core.dE.4
                @Override // com.bytedance.sdk.openadsdk.core.pFF.zY
                public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, boolean z11) {
                    if (view instanceof PAGVideoMediaView) {
                        ((PAGVideoMediaView) view).handleInterruptVideo();
                    }
                }
            };
            pAGMediaViewSc.setOnClickListener(zYVar);
            pAGMediaViewSc.setOnTouchListener(zYVar);
        }
        com.bytedance.sdk.openadsdk.sc.pFF.sc scVar5 = this.WH;
        if (scVar5 != null) {
            scVar5.sc((com.bytedance.sdk.openadsdk.core.pFF.sc) null);
        }
    }

    private void sc(qr qrVar, final ViewGroup viewGroup) {
        qrVar.setCallback(new qr.sc() { // from class: com.bytedance.sdk.openadsdk.core.dE.5
            @Override // com.bytedance.sdk.openadsdk.core.qr.sc
            public void pFF() {
                dE.this.pFF();
            }

            @Override // com.bytedance.sdk.openadsdk.core.qr.sc
            public void sc() {
                dE.this.pFF(viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qr.sc
            @JProtect
            public void sc(View view) {
                dE.this.pFF(viewGroup, view);
            }

            @Override // com.bytedance.sdk.openadsdk.core.qr.sc
            public void sc(boolean z11) {
                dE.this.sc(z11, viewGroup);
            }
        });
    }

    private void sc(List<View> list, com.bytedance.sdk.openadsdk.core.pFF.zY zYVar) {
        if (com.bytedance.sdk.component.utils.WH.pFF(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(zYVar);
                    view.setOnTouchListener(zYVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z11, ViewGroup viewGroup) {
        if (z11 && this.f28366sc.RiV() && !this.f28366sc.AIZ()) {
            this.f28366sc.qr(true);
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f28366sc;
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, this.TRI, sfl.fKf());
        }
        if (z11 || this.Qj <= 0) {
            this.Ol.sc(System.currentTimeMillis(), Gb.sc(viewGroup));
            this.Qj = SystemClock.elapsedRealtime();
        } else {
            String strValueOf = String.valueOf(SystemClock.elapsedRealtime() - this.Qj);
            this.Ol.sc(System.currentTimeMillis(), Gb.sc(viewGroup));
            com.bytedance.sdk.openadsdk.We.zY.sc(strValueOf, this.f28366sc, this.TRI, this.Ol);
            this.Qj = 0L;
        }
    }

    private void zY(ViewGroup viewGroup) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl;
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.ExN != null) {
                JSONArray jSONArray = new JSONArray();
                for (View view : this.ExN) {
                    if (view != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("width", view.getWidth());
                            jSONObject2.put("height", view.getHeight());
                            jSONObject2.put("alpha", view.getAlpha());
                        } catch (Throwable unused) {
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("image_view", jSONArray.toString());
            }
            if (viewGroup != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("width", viewGroup.getWidth());
                    jSONObject3.put("height", viewGroup.getHeight());
                    jSONObject3.put("alpha", viewGroup.getAlpha());
                } catch (Throwable unused2) {
                }
                jSONObject.put("root_view", jSONObject3.toString());
            }
            PAGMediaView pAGMediaViewQj = this.WH.Qj();
            if (pAGMediaViewQj != null) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("width", kX.We(this.zY, pAGMediaViewQj.getWidth()) * 1.0f);
                    jSONObject4.put("height", kX.We(this.zY, pAGMediaViewQj.getHeight()) * 1.0f);
                } catch (Throwable unused3) {
                }
                jSONObject.put("media_view", jSONObject4.toString());
            }
            com.bytedance.sdk.openadsdk.core.Qj.Sfl sflPFF = this.WH.pFF();
            if (sflPFF != null && (sfl = this.f28366sc) != null) {
                jSONObject.put("dynamic_show_type", sfl.cvk());
                sflPFF.sc(jSONObject, this.f28366sc);
            }
            com.bytedance.sdk.openadsdk.We.zY.sc(this.f28366sc, this.TRI, jSONObject);
            com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(this.f28366sc);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("InteractionManager", "onShowFun json error", e11);
        }
    }

    public com.bytedance.sdk.openadsdk.We.qr sc() {
        return this.Ol;
    }

    public void sc(View view, int i11) {
        com.bytedance.sdk.openadsdk.sc.pFF.TRI tri = this.f28365qr;
        if (tri != null) {
            tri.onAdClicked();
        }
    }

    public void sc(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, @Nullable List<View> list3, @Nullable View view, com.bytedance.sdk.openadsdk.sc.pFF.TRI tri) {
        sc(viewGroup, list, list2, list3, tri);
        sc(viewGroup, view);
        sc(viewGroup, list2, list3);
    }

    public void sc(c cVar) {
        this.UFX = cVar;
        com.bytedance.sdk.openadsdk.core.pFF.pFF pff = this.Ql;
        if (pff != null) {
            pff.sc(cVar);
        }
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar = this.SR;
        if (scVar != null) {
            scVar.sc(cVar);
        }
    }
}
