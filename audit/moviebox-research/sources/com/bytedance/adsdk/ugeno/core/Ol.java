package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol {
    private boolean BT;
    private Tf ExN;
    private String Ol;
    private ExN Qj;
    private com.bytedance.adsdk.ugeno.We.sc.sc SR;
    private BT TRI;
    private JSONObject UFX;
    private Qj WH;
    private TRI We;
    private List<String> dE;
    private JSONObject pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Ql f26389qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26390sc;
    private com.bytedance.adsdk.ugeno.pFF.zY<View> zY;
    private boolean Tf = true;
    private boolean Ql = false;

    public Ol(Context context) {
        this.f26390sc = context;
    }

    private void pFF(com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        try {
            if (!zYVar.McK() || zYVar.II() == null || zYVar.II().TRI() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", zYVar.II().TRI());
            this.pFF.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    private void sc(com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar) {
        List<com.bytedance.adsdk.ugeno.pFF.zY<View>> listSc;
        if (zYVar == null) {
            return;
        }
        JSONObject jSONObjectUEA = zYVar.uEA();
        Iterator<String> itKeys = jSONObjectUEA.keys();
        com.bytedance.adsdk.ugeno.pFF.sc scVarHJN = zYVar.HJN();
        com.bytedance.adsdk.ugeno.pFF.sc.C0233sc c0233scZY = scVarHJN != null ? scVarHJN.zY() : null;
        pFF(zYVar);
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strSc = com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObjectUEA.optString(next), this.pFF);
            zYVar.sc(next, strSc);
            if (c0233scZY != null) {
                c0233scZY.sc(this.f26390sc, next, strSc);
            }
        }
        zYVar.sc(this.We);
        zYVar.sc(this.ExN);
        zYVar.sc(this.f26389qr);
        if ((zYVar instanceof com.bytedance.adsdk.ugeno.pFF.sc) && (listSc = ((com.bytedance.adsdk.ugeno.pFF.sc) zYVar).sc()) != null && listSc.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.pFF.zY<View>> it = listSc.iterator();
            while (it.hasNext()) {
                sc(it.next());
            }
        }
        if (c0233scZY != null) {
            zYVar.sc(c0233scZY.sc());
        }
        zYVar.pFF();
    }

    public com.bytedance.adsdk.ugeno.pFF.zY<View> pFF(ExN.sc scVar, com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar) {
        List<ExN.sc> listZY;
        com.bytedance.adsdk.ugeno.pFF.sc.C0233sc c0233scZY = null;
        if (!ExN.sc(scVar)) {
            return null;
        }
        String strZY = scVar.zY();
        pFF pffSc = We.sc(strZY);
        if (pffSc == null) {
            "not found component ".concat(String.valueOf(strZY));
            this.BT = true;
            if (this.dE == null) {
                this.dE = new ArrayList();
            }
            this.dE.add(strZY);
            return null;
        }
        com.bytedance.adsdk.ugeno.pFF.zY zYVarSc = pffSc.sc(this.f26390sc);
        if (zYVarSc == null) {
            return null;
        }
        zYVarSc.ExN(com.bytedance.adsdk.ugeno.zY.pFF.sc(scVar.sc(), this.pFF));
        zYVarSc.TRI(strZY);
        zYVarSc.pFF(scVar.We());
        zYVarSc.sc(scVar);
        zYVarSc.sc(this.WH);
        if (zYVar instanceof com.bytedance.adsdk.ugeno.pFF.sc) {
            com.bytedance.adsdk.ugeno.pFF.sc scVar2 = (com.bytedance.adsdk.ugeno.pFF.sc) zYVar;
            zYVarSc.sc(scVar2);
            c0233scZY = scVar2.zY();
        }
        Iterator<String> itKeys = scVar.We().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strSc = com.bytedance.adsdk.ugeno.zY.pFF.sc(scVar.We().optString(next), this.pFF);
            zYVarSc.sc(next, strSc);
            if (c0233scZY != null) {
                c0233scZY.sc(this.f26390sc, next, strSc);
            }
        }
        if (zYVarSc instanceof com.bytedance.adsdk.ugeno.pFF.sc) {
            List<ExN.sc> listExN = scVar.ExN();
            if (listExN == null || listExN.size() <= 0) {
                if (TextUtils.equals(zYVarSc.cD(), "RecyclerLayout") && (listZY = this.Qj.zY()) != null && listZY.size() > 0) {
                    Iterator<ExN.sc> it = listZY.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.pFF.zY<View> zYVarPFF = pFF(it.next(), zYVarSc);
                        if (zYVarPFF != null && zYVarPFF.cJ()) {
                            ((com.bytedance.adsdk.ugeno.pFF.sc) zYVarSc).sc(zYVarPFF);
                        }
                    }
                }
                return zYVarSc;
            }
            if (TextUtils.equals(zYVarSc.cD(), "Swiper") && listExN.size() != 1) {
                Log.e("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<ExN.sc> it2 = listExN.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.pFF.zY<View> zYVarPFF2 = pFF(it2.next(), zYVarSc);
                if (zYVarPFF2 != null && zYVarPFF2.cJ()) {
                    ((com.bytedance.adsdk.ugeno.pFF.sc) zYVarSc).sc(zYVarPFF2);
                }
            }
        }
        if (c0233scZY != null) {
            zYVarSc.sc(c0233scZY.sc());
        }
        this.zY = zYVarSc;
        return zYVarSc;
    }

    public List<String> pFF() {
        return this.dE;
    }

    public void pFF(JSONObject jSONObject) {
        BT bt2 = this.TRI;
        if (bt2 != null) {
            bt2.zY();
        }
        this.pFF = jSONObject;
        sc(this.zY, jSONObject);
        sc(this.zY);
        if (this.TRI != null) {
            SR sr2 = new SR();
            sr2.sc(0);
            sr2.sc(this.zY);
            this.TRI.sc(sr2);
        }
    }

    public com.bytedance.adsdk.ugeno.pFF.zY<View> sc(ExN.sc scVar, com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar) {
        pFF pff;
        List<ExN.sc> listZY;
        com.bytedance.adsdk.ugeno.pFF.sc.C0233sc c0233scZY = null;
        if (!ExN.sc(scVar)) {
            return null;
        }
        String strZY = scVar.zY();
        pFF pffSc = We.sc(strZY);
        if (pffSc == null) {
            this.BT = true;
            if (this.dE == null) {
                pff = pffSc;
                this.dE = new ArrayList();
            }
            pff = pffSc;
            this.dE.add(strZY);
            strZY = "View";
            scVar.sc("View");
            pFF pffSc2 = We.sc("View");
            pff = pffSc2;
            if (pffSc2 == null) {
                "not found component ".concat("View");
                return null;
            }
        }
        pff = pffSc;
        com.bytedance.adsdk.ugeno.pFF.zY zYVarSc = pff.sc(this.f26390sc);
        if (zYVarSc == null) {
            return null;
        }
        JSONObject jSONObjectWe = scVar.We();
        zYVarSc.ExN(com.bytedance.adsdk.ugeno.zY.pFF.sc(scVar.sc(), this.pFF));
        zYVarSc.TRI(strZY);
        zYVarSc.pFF(jSONObjectWe);
        zYVarSc.sc(scVar);
        zYVarSc.sc(this.Qj.We());
        zYVarSc.sc(this.WH);
        zYVarSc.sc(this.SR);
        Iterator<String> itKeys = jSONObjectWe.keys();
        if (zYVar instanceof com.bytedance.adsdk.ugeno.pFF.sc) {
            com.bytedance.adsdk.ugeno.pFF.sc scVar2 = (com.bytedance.adsdk.ugeno.pFF.sc) zYVar;
            c0233scZY = scVar2.zY();
            zYVarSc.sc(scVar2);
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strSc = com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObjectWe.optString(next), this.pFF);
            zYVarSc.sc(next, strSc);
            if (c0233scZY != null) {
                c0233scZY.sc(this.f26390sc, next, strSc);
            }
        }
        if (c0233scZY != null) {
            zYVarSc.sc(c0233scZY.sc());
        }
        if (zYVarSc instanceof com.bytedance.adsdk.ugeno.pFF.sc) {
            List<ExN.sc> listExN = scVar.ExN();
            if (listExN == null || listExN.size() <= 0) {
                if (TextUtils.equals(zYVarSc.cD(), "RecyclerLayout") && (listZY = this.Qj.zY()) != null && listZY.size() > 0) {
                    Iterator<ExN.sc> it = listZY.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.pFF.zY<View> zYVarSc2 = sc(it.next(), (com.bytedance.adsdk.ugeno.pFF.zY<View>) zYVarSc);
                        if (zYVarSc2 != null && zYVarSc2.cJ()) {
                            ((com.bytedance.adsdk.ugeno.pFF.sc) zYVarSc).sc(zYVarSc2);
                        }
                    }
                }
                return zYVarSc;
            }
            if (TextUtils.equals(zYVarSc.cD(), "Swiper") && listExN.size() != 1) {
                Log.e("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<ExN.sc> it2 = listExN.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.pFF.zY<View> zYVarSc3 = sc(it2.next(), (com.bytedance.adsdk.ugeno.pFF.zY<View>) zYVarSc);
                if (zYVarSc3 != null && !zYVarSc3.QLv()) {
                    ((com.bytedance.adsdk.ugeno.pFF.sc) zYVarSc).sc(zYVarSc3, zYVarSc3.WP());
                }
            }
        }
        this.zY = zYVarSc;
        return zYVarSc;
    }

    public com.bytedance.adsdk.ugeno.pFF.zY<View> sc(JSONObject jSONObject) {
        BT bt2 = this.TRI;
        if (bt2 != null) {
            bt2.sc();
        }
        ExN exN = new ExN(jSONObject, this.pFF);
        this.Qj = exN;
        Tf tf2 = this.ExN;
        if (tf2 instanceof com.bytedance.adsdk.ugeno.core.sc.sc) {
            ((com.bytedance.adsdk.ugeno.core.sc.sc) tf2).sc(exN.pFF());
        }
        this.zY = pFF(this.Qj.sc(), null);
        BT bt3 = this.TRI;
        if (bt3 != null) {
            bt3.pFF();
            this.zY.sc(this.TRI);
        }
        return this.zY;
    }

    public com.bytedance.adsdk.ugeno.pFF.zY<View> sc(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.pFF = jSONObject2;
        BT bt2 = this.TRI;
        if (bt2 != null) {
            bt2.sc();
        }
        this.Qj = new ExN(jSONObject, jSONObject2, jSONObject3);
        this.SR = new com.bytedance.adsdk.ugeno.We.sc.sc();
        Tf tf2 = this.ExN;
        if (tf2 instanceof com.bytedance.adsdk.ugeno.core.sc.sc) {
            ((com.bytedance.adsdk.ugeno.core.sc.sc) tf2).sc(this.Qj.pFF());
        }
        this.zY = sc(this.Qj.sc(), (com.bytedance.adsdk.ugeno.pFF.zY<View>) null);
        BT bt3 = this.TRI;
        if (bt3 != null) {
            bt3.pFF();
            this.zY.sc(this.TRI);
        }
        sc(this.zY);
        return this.zY;
    }

    public void sc(Ql ql2) {
        this.f26389qr = ql2;
    }

    public void sc(Tf tf2) {
        com.bytedance.adsdk.ugeno.core.sc.sc scVar = new com.bytedance.adsdk.ugeno.core.sc.sc(tf2);
        scVar.sc(this.UFX);
        scVar.sc(this.Tf);
        scVar.pFF(this.Ql);
        ExN exN = this.Qj;
        if (exN != null) {
            scVar.sc(exN.pFF());
        }
        this.ExN = scVar;
    }

    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, JSONObject jSONObject) {
        if (zYVar == null) {
            return;
        }
        if (!(zYVar instanceof com.bytedance.adsdk.ugeno.pFF.sc)) {
            zYVar.sc(jSONObject);
            return;
        }
        zYVar.sc(jSONObject);
        List<com.bytedance.adsdk.ugeno.pFF.zY<View>> listSc = ((com.bytedance.adsdk.ugeno.pFF.sc) zYVar).sc();
        if (listSc == null || listSc.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.pFF.zY<View>> it = listSc.iterator();
        while (it.hasNext()) {
            sc(it.next(), jSONObject);
        }
    }

    public void sc(String str, Qj qj2) {
        this.WH = qj2;
        this.Ol = str;
        if (qj2 != null) {
            this.pFF = qj2.sc();
        }
    }

    public boolean sc() {
        return this.BT;
    }
}
