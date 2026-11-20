package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.R;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.YIK;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.pgl.ssdk.ces.out.DungeonFlag;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX {
    private final com.bytedance.sdk.openadsdk.core.pFF.pFF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc f27889sc;
    private final com.bytedance.sdk.openadsdk.core.pFF.ExN zY;

    @DungeonFlag
    public UFX(sc scVar) {
        this.f27889sc = scVar;
        this.zY = sc(scVar, scVar.pFF);
        this.pFF = new com.bytedance.sdk.openadsdk.core.pFF.pFF(scVar.CYO, scVar.pFF, scVar.ExN, scVar.We ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.UFX.1
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
            public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, boolean z11) {
                try {
                    UFX.this.sc(view, f11, f12, f13, f14, sparseArray, this.HJN, this.II, this.McK);
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFReportManager", "onClickReport error :" + e11.getMessage());
                }
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(UFX.this.f27889sc.pFF, 9);
                UFX.this.f27889sc.JPJ.Cb();
            }
        };
    }

    private JSONObject Ol() {
        try {
            long jDE = this.f27889sc.JPJ.dE();
            int iXc = this.f27889sc.JPJ.Xc();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", jDE);
                jSONObject.put("percent", iXc);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private boolean Qj() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f27889sc.pFF;
        return sfl != null && sfl.pc() == 1;
    }

    private void pFF(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, int i11, int i12, int i13) {
        if (!Qj() || this.f27889sc.pFF == null || view == null) {
            return;
        }
        int id2 = view.getId();
        if (id2 == com.bytedance.sdk.openadsdk.utils.SR.ExN || id2 == com.bytedance.sdk.openadsdk.utils.SR.We || id2 == com.bytedance.sdk.openadsdk.utils.SR.zY || id2 == com.bytedance.sdk.openadsdk.utils.SR.pFF || id2 == com.bytedance.sdk.openadsdk.utils.SR.Tf || id2 == com.bytedance.sdk.openadsdk.utils.SR.AZJ || id2 == com.bytedance.sdk.openadsdk.utils.SR.Xc || id2 == 520093705 || id2 == com.bytedance.sdk.openadsdk.utils.SR.UFX || id2 == 520093707 || id2 == com.bytedance.sdk.openadsdk.utils.SR.f28752qr) {
            int iQr = kX.qr(com.bytedance.sdk.openadsdk.core.Xc.sc());
            com.bytedance.sdk.openadsdk.core.model.WH whSc = new com.bytedance.sdk.openadsdk.core.model.WH.sc().TRI(f11).ExN(f12).We(f13).zY(f14).pFF(System.currentTimeMillis()).sc(0L).pFF(kX.sc(this.f27889sc.BR.UFX())).sc(kX.sc((View) null)).zY(kX.zY(this.f27889sc.BR.UFX())).We(kX.zY((View) null)).We(i12).ExN(i13).TRI(i11).sc(sparseArray).pFF(com.bytedance.sdk.openadsdk.core.Ol.pFF().sc() ? 1 : 2).zY(iQr).sc(kX.ExN(com.bytedance.sdk.openadsdk.core.Xc.sc())).pFF(kX.TRI(com.bytedance.sdk.openadsdk.core.Xc.sc())).sc();
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(this.f27889sc.JPJ.qr()));
            sc scVar = this.f27889sc;
            com.bytedance.sdk.openadsdk.We.zY.sc("click_other", scVar.pFF, whSc, scVar.ExN, true, (Map<String, Object>) map, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, int i11, int i12, int i13) {
        if (view == null) {
            return;
        }
        if (view.getId() == com.bytedance.sdk.openadsdk.utils.SR.ExN) {
            sc("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.SR.We || view.getId() == com.bytedance.sdk.openadsdk.utils.SR.f28752qr) {
            sc("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.SR.zY) {
            sc("click_play_source", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.SR.pFF) {
            sc("click_play_logo", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.SR.Tf || view.getId() == com.bytedance.sdk.openadsdk.utils.SR.AZJ || view.getId() == com.bytedance.sdk.openadsdk.utils.SR.Xc) {
            sc("click_start_play_bar", Ol());
        } else if (view.getId() == 520093705) {
            sc("click_start_play", Ol());
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.SR.UFX) {
            sc("click_video", Ol());
        } else if (view.getId() == 520093707 || view.getId() == com.bytedance.sdk.openadsdk.utils.SR.Qj) {
            sc("fallback_endcard_click", Ol());
        }
        pFF(view, f11, f12, f13, f14, sparseArray, i11, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(String str, JSONObject jSONObject) {
        sc scVar = this.f27889sc;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar.pFF;
        String str2 = scVar.ExN;
        if (!scVar.We) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str2, str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.activity.TRI tri;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f27889sc.pFF;
        if ((sfl instanceof YIK) && ((YIK) sfl).QfS()) {
            try {
                jSONObject.put("choose_one_ad_real_show", true);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFReportManager", "reportShow json error", e11);
            }
        }
        sc scVar = this.f27889sc;
        if (!scVar.otH || (tri = scVar.dix) == null) {
            return;
        }
        try {
            jSONObject.put("ad_show_order", tri.Ol + 1);
        } catch (JSONException unused) {
        }
    }

    public com.bytedance.sdk.openadsdk.core.pFF.ExN ExN() {
        return this.zY;
    }

    public void TRI() {
        JSONObject jSONObject = new JSONObject();
        if (JPJ.wjp(this.f27889sc.pFF)) {
            this.f27889sc.WP.sc(jSONObject);
        }
        int i11 = 1;
        try {
            if (this.f27889sc.WH.get()) {
                if (!this.f27889sc.Cb.zY()) {
                    if (this.f27889sc.OXF.We()) {
                        i11 = 3;
                    } else {
                        i11 = this.f27889sc.Cb.We() ? 2 : 0;
                    }
                }
                jSONObject.put("endcard_content", i11);
            } else {
                jSONObject.put("endCardNotShow", 1);
            }
        } catch (JSONException unused) {
        }
        sc scVar = this.f27889sc;
        com.bytedance.sdk.openadsdk.We.zY.pFF(scVar.pFF, scVar.ExN, "click_close", jSONObject);
    }

    public com.bytedance.sdk.openadsdk.core.pFF.pFF We() {
        return this.pFF;
    }

    @DungeonFlag
    public void pFF() {
        boolean z11;
        com.bytedance.sdk.openadsdk.activity.TRI tri;
        com.bytedance.sdk.openadsdk.component.reward.view.Qj qj2;
        if (this.f27889sc.Ql.get()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.f27889sc.pFF.sc() || (qj2 = this.f27889sc.cvk) == null) {
                z11 = false;
            } else {
                jSONObject.put("dynamic_show_type", qj2.Ol());
                this.f27889sc.cvk.sc(jSONObject);
                z11 = true;
            }
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f27889sc.pFF;
            sc(jSONObject);
            View viewFindViewById = this.f27889sc.CYO.findViewById(R.id.content);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", viewFindViewById.getWidth());
                jSONObject2.put("height", viewFindViewById.getHeight());
                jSONObject2.put("alpha", viewFindViewById.getAlpha());
            } catch (Throwable unused) {
            }
            jSONObject.put("root_view", jSONObject2.toString());
            if (this.f27889sc.Ql.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.We.zY.sc(sfl, this.f27889sc.ExN, jSONObject);
                this.f27889sc.qKn.TRI();
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc scVar = new com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(z11 ? this.f27889sc.cvk.Ol() : -1);
                sc scVar2 = this.f27889sc;
                if (scVar2.otH && (tri = scVar2.dix) != null) {
                    scVar.pFF = tri.Ol;
                }
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(scVar2.CYO.findViewById(R.id.content), sfl, scVar);
                com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(sfl);
            }
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFReportManager", "reportShowWhenBindVideoAd error", e11);
        }
    }

    @DungeonFlag
    public void pFF(boolean z11) {
        sc scVar = this.f27889sc;
        if (scVar == null) {
            return;
        }
        if (z11 || !scVar.Ql.get() || this.f27889sc.YdT <= 0) {
            this.f27889sc.YdT = SystemClock.elapsedRealtime();
        } else {
            String strValueOf = String.valueOf(SystemClock.elapsedRealtime() - this.f27889sc.YdT);
            sc scVar2 = this.f27889sc;
            com.bytedance.sdk.openadsdk.We.zY.sc(strValueOf, scVar2.pFF, scVar2.ExN, scVar2.JPJ.sc());
            this.f27889sc.YdT = 0L;
        }
        com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.f27889sc.pFF, z11 ? 4 : 8);
        com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(this.f27889sc.pFF, z11 ? 4 : 8);
    }

    public void qr() {
        JSONObject jSONObject = new JSONObject();
        sc(jSONObject);
        sc scVar = this.f27889sc;
        com.bytedance.sdk.openadsdk.We.zY.ExN(scVar.pFF, scVar.ExN, jSONObject);
    }

    public com.bytedance.sdk.openadsdk.core.pFF.ExN sc(final sc scVar, final com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        return new com.bytedance.sdk.openadsdk.core.pFF.ExN(scVar.CYO, sfl, scVar.ExN, scVar.We ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.UFX.4
            @Override // com.bytedance.sdk.openadsdk.core.pFF.ExN
            public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, int i11, int i12, int i13, boolean z11) {
                if (sfl.ymG() && view != null) {
                    Object tag = view.getTag(570425345);
                    if (tag instanceof String) {
                        sc((String) tag);
                    }
                }
                HashMap map = new HashMap();
                map.put("duration", Long.valueOf(scVar.JPJ.qr()));
                if (scVar.WH.get()) {
                    map.put("click_scence", 2);
                } else if (JPJ.wjp(sfl)) {
                    map.put("click_scence", 3);
                } else {
                    map.put("click_scence", 1);
                }
                sc(map);
                scVar.qKn.c_();
                if (view.getId() == com.bytedance.sdk.openadsdk.utils.SR.zGQ && JPJ.wjp(sfl)) {
                    JSONObject jSONObject = new JSONObject();
                    if (sfl.GI() != null) {
                        try {
                            jSONObject.put("playable_url", sfl.GI().p());
                        } catch (JSONException e11) {
                            com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFReportManager", "onRewardBarClick json error", e11);
                        }
                    }
                    com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, scVar.ExN, "click_playable_download_button_loading", jSONObject);
                }
                scVar.FI.sc(view, f11, f12, f13, f14, sparseArray, i11, i12, i13, new We.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.UFX.4.1
                    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.We.sc
                    public void sc(View view2, float f15, float f16, float f17, float f18, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray2, int i14, int i15, int i16) {
                        UFX.this.sc(view2, f15, f16, f17, f18, sparseArray2, i14, i15, i16);
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.We.sc
                    public void sc(String str, JSONObject jSONObject2) {
                        UFX.this.sc(str, jSONObject2);
                    }
                });
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(sfl, 9);
                scVar.JPJ.Cb();
            }
        };
    }

    @DungeonFlag
    public void sc() {
        com.bytedance.sdk.openadsdk.activity.TRI tri;
        if (this.f27889sc.Ql.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f27889sc.pFF;
        sc(jSONObject);
        if (this.f27889sc.Ql.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, this.f27889sc.ExN, jSONObject);
            this.f27889sc.qKn.TRI();
            com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc scVar = new com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(-1);
            sc scVar2 = this.f27889sc;
            if (scVar2.otH && (tri = scVar2.dix) != null) {
                scVar.pFF = tri.Ol;
            }
            com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(scVar2.CYO.findViewById(R.id.content), sfl, scVar);
            com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(sfl);
        }
    }

    @DungeonFlag
    public void sc(final Map<String, Object> map) {
        if (this.f27889sc.Ql.get()) {
            return;
        }
        this.f27889sc.Ql.set(true);
        final View viewFindViewById = this.f27889sc.CYO.findViewById(R.id.content);
        if (viewFindViewById == null) {
            viewFindViewById = this.f27889sc.CYO.getWindow().getDecorView();
        }
        viewFindViewById.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.UFX.2
            @Override // java.lang.Runnable
            public void run() {
                Map map2;
                boolean z11 = false;
                if (UFX.this.f27889sc.SR.compareAndSet(false, true)) {
                    com.bytedance.sdk.openadsdk.core.model.Sfl sfl = UFX.this.f27889sc.pFF;
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = map != null ? new JSONObject(map) : new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("width", viewFindViewById.getWidth());
                        jSONObject2.put("height", viewFindViewById.getHeight());
                        jSONObject2.put("alpha", viewFindViewById.getAlpha());
                        jSONObject.put("root_view", jSONObject2.toString());
                        UFX.this.sc(jSONObject);
                    } catch (Throwable th2) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFReportManager", "run: ", th2);
                    }
                    com.bytedance.sdk.openadsdk.We.zY.sc(sfl, UFX.this.f27889sc.ExN, jSONObject);
                    UFX.this.f27889sc.qKn.TRI();
                    if (UFX.this.f27889sc.cvk != null && (map2 = map) != null && map2.containsKey("dynamic_show_type")) {
                        z11 = true;
                    }
                    com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc scVar = new com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(z11 ? UFX.this.f27889sc.cvk.Ol() : -1);
                    if (UFX.this.f27889sc.otH && UFX.this.f27889sc.dix != null) {
                        scVar.pFF = UFX.this.f27889sc.dix.Ol;
                    }
                    com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(UFX.this.f27889sc.CYO.findViewById(R.id.content), sfl, scVar);
                    com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(sfl);
                }
            }
        });
    }

    public void sc(boolean z11) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f27889sc.pFF;
        if (sfl == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.SR.sc.We weExN = com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc(z11 ? 7 : 8).zY(String.valueOf(sfl.QT())).ExN(this.f27889sc.pFF.ofL());
        weExN.pFF(this.f27889sc.Cb.JPJ()).TRI(this.f27889sc.Cb.FI());
        weExN.qr(this.f27889sc.pFF.mD()).We(this.f27889sc.pFF.kDg());
        com.bytedance.sdk.openadsdk.SR.zY.sc().pFF(weExN);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public com.bytedance.sdk.openadsdk.core.pFF.ExN zY() {
        this.zY.sc(this.f27889sc.CYO.findViewById(R.id.content));
        this.zY.pFF(this.f27889sc.JoC.findViewById(520093713));
        if (this.f27889sc.FI.zY() != null) {
            this.zY.sc(this.f27889sc.FI.zY());
        }
        this.f27889sc.WP.sc(this.zY);
        this.zY.sc(new com.bytedance.sdk.openadsdk.core.pFF.sc.InterfaceC0305sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.UFX.3
            @Override // com.bytedance.sdk.openadsdk.core.pFF.sc.InterfaceC0305sc
            public long getVideoProgress() {
                return UFX.this.f27889sc.JPJ.qr();
            }
        });
        com.bytedance.sdk.openadsdk.component.reward.view.WH wh2 = this.f27889sc.BR;
        com.bytedance.sdk.openadsdk.core.pFF.ExN exN = this.zY;
        wh2.sc(exN, exN, this.pFF);
        this.f27889sc.kX.sc(this.zY);
        return this.zY;
    }

    public void zY(boolean z11) {
        sc scVar = this.f27889sc;
        if (scVar != null && z11 && scVar.pFF.RiV() && !this.f27889sc.pFF.AIZ()) {
            this.f27889sc.pFF.qr(true);
            sc scVar2 = this.f27889sc;
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar2.pFF;
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, scVar2.ExN, sfl.fKf());
        }
    }
}
