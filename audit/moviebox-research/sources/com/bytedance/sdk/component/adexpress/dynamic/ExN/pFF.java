package com.bytedance.sdk.component.adexpress.dynamic.ExN;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.pFF.Ql;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    private double ExN;
    private Ql Ol;
    private String Qj;
    private int TRI;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private double f26740qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public Map<String, zY> f26741sc = new HashMap();
    public Map<String, zY> pFF = new HashMap();
    public Map<String, zY> zY = new HashMap();
    private double We = Math.random();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.ExN.pFF$pFF, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0256pFF {
        float ExN;
        double We;
        int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        float f26742sc;
        int zY;

        public static JSONObject sc(C0256pFF c0256pFF) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_SIZE, c0256pFF.f26742sc);
                jSONObject.put("letterSpacing", c0256pFF.pFF);
                jSONObject.put("lineHeight", c0256pFF.We);
                jSONObject.put("maxWidth", c0256pFF.ExN);
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_WEIGHT, c0256pFF.zY);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc implements Cloneable {
        boolean pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        float f26743sc;
        float zY;

        public Object clone() {
            try {
                return (sc) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY {
        float pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        float f26744sc;

        public zY() {
        }

        public zY(float f11, float f12) {
            this.f26744sc = f11;
            this.pFF = f12;
        }

        public String toString() {
            return "UnitSize{width=" + this.f26744sc + ", height=" + this.pFF + '}';
        }
    }

    public pFF(double d11, int i11, double d12, String str, Ql ql2) {
        this.ExN = d11;
        this.TRI = i11;
        this.f26740qr = d12;
        this.Qj = str;
        this.Ol = ql2;
    }

    private zY ExN(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, float f11, float f12) {
        String str = qj2.zY() + "_" + f11 + "_" + f12;
        if (this.zY.containsKey(str)) {
            return this.zY.get(str);
        }
        zY zYVarTRI = TRI(qj2, f11, f12);
        this.zY.put(str, zYVarTRI);
        return zYVarTRI;
    }

    private String ExN(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        return qj2.zY();
    }

    private zY TRI(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, float f11, float f12) {
        new zY();
        com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN = qj2.WH().ExN();
        qj2.WH().zY();
        triExN.ko();
        float fWjp = triExN.wjp();
        int iOKY = triExN.OKY();
        double dQfG = triExN.qfG();
        int iHt = triExN.ht();
        boolean zGI = triExN.GI();
        boolean zZM = triExN.ZM();
        int iMxZ = triExN.MxZ();
        C0256pFF c0256pFF = new C0256pFF();
        c0256pFF.f26742sc = fWjp;
        c0256pFF.pFF = iOKY;
        c0256pFF.zY = iHt;
        c0256pFF.We = dQfG;
        c0256pFF.ExN = f11;
        return sc(qj2.WH().zY(), c0256pFF, zGI, zZM, iMxZ, qj2);
    }

    private String We(List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String strZY = list.get(i11).zY();
            if (i11 < list.size() - 1) {
                sb2.append(strZY);
                sb2.append("-");
            } else {
                sb2.append(strZY);
            }
        }
        return sb2.toString();
    }

    private void We(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        this.f26741sc.remove(ExN(qj2));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> listXc = qj2.Xc();
        if (listXc == null || listXc.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> it = listXc.iterator();
        while (it.hasNext()) {
            zY(it.next());
        }
    }

    private zY pFF(List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list, float f11, float f12) {
        zY zYVarSc = sc(list);
        if (zYVarSc != null && (zYVarSc.f26744sc != 0.0f || zYVarSc.pFF != 0.0f)) {
            return zYVarSc;
        }
        zY zYVarZY = zY(list, f11, f12);
        sc(list, zYVarZY);
        return zYVarZY;
    }

    private boolean pFF(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        if (qj2 == null) {
            return false;
        }
        if (TextUtils.equals(qj2.WH().ExN().II(), "flex")) {
            return true;
        }
        return zY(qj2);
    }

    private boolean pFF(List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> listXc;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().WH().ExN().McK(), "flex")) {
                return true;
            }
        }
        while (true) {
            boolean z11 = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 : list) {
                if (TextUtils.equals(qj2.WH().ExN().McK(), "auto") && (listXc = qj2.Xc()) != null) {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> it2 = listXc.iterator();
                    int i11 = 0;
                    while (true) {
                        if (it2.hasNext()) {
                            List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> next = it2.next();
                            i11++;
                            if (pFF(next)) {
                                if (i11 == next.size()) {
                                    z11 = true;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return z11;
        }
    }

    private zY sc(String str, C0256pFF c0256pFF, boolean z11, boolean z12, int i11, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        return UFX.sc(str, qj2.WH().pFF(), C0256pFF.sc(c0256pFF).toString(), z11, z12, i11, qj2, this.ExN, this.TRI, this.f26740qr, this.Qj, this.Ol);
    }

    private void sc(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, zY zYVar) {
        this.f26741sc.put(ExN(qj2), zYVar);
    }

    private void sc(List<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> list, float f11, float f12) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> it = list.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (sc(it.next(), false)) {
                z11 = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list2 : list) {
            sc scVar = new sc();
            boolean zSc = sc(list2, !z11);
            scVar.f26743sc = zSc ? 1.0f : pFF(list2, f11, f12).pFF;
            scVar.pFF = !zSc;
            arrayList.add(scVar);
        }
        List<sc> listSc = WH.sc(f12, arrayList);
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (((sc) arrayList.get(i11)).f26743sc != listSc.get(i11).f26743sc) {
                List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list3 = list.get(i11);
                zY(list3);
                pFF(list3, f11, listSc.get(i11).f26743sc);
            }
        }
    }

    private void sc(List<sc> list, float f11, List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list2) {
        float f12 = 0.0f;
        for (sc scVar : list) {
            if (scVar.pFF) {
                f12 += scVar.f26743sc;
            }
        }
        if (f12 > f11) {
            int i11 = 0;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                if (list.get(i12).pFF && list2.get(i12).uEA()) {
                    i11++;
                }
            }
            if (i11 > 0) {
                float fCeil = (float) (Math.ceil(((f12 - f11) / i11) * 1000.0f) / 1000.0d);
                for (int i13 = 0; i13 < list2.size(); i13++) {
                    sc scVar2 = list.get(i13);
                    if (scVar2.pFF && list2.get(i13).uEA()) {
                        scVar2.f26743sc -= fCeil;
                    }
                }
            }
        }
    }

    private void sc(List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list, zY zYVar) {
        this.pFF.put(We(list), zYVar);
    }

    private boolean sc(List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list, boolean z11) {
        for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 : list) {
            com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN = qj2.WH().ExN();
            String strII = triExN.II();
            if (TextUtils.equals(strII, "flex") || (z11 && ((TextUtils.equals(triExN.McK(), "flex") && TextUtils.equals(triExN.II(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.We.ExN.f26747sc.get(qj2.WH().pFF()).intValue() == 7) || TextUtils.equals(strII, "flex")))) {
                return true;
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it = list.iterator();
        while (it.hasNext()) {
            if (zY(it.next())) {
                return true;
            }
        }
        return false;
    }

    private zY zY(List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list, float f11, float f12) {
        float fMax;
        We(list);
        zY zYVar = new zY();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 : list) {
            com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN = qj2.WH().ExN();
            if (triExN.idT() == 1 || triExN.idT() == 2) {
                arrayList.add(qj2);
            }
            if (triExN.idT() != 1 && triExN.idT() != 2) {
                arrayList2.add(qj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zY((com.bytedance.sdk.component.adexpress.dynamic.We.Qj) it.next(), f11, f12);
        }
        if (arrayList2.size() <= 0) {
            return zYVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(zY(it2.next(), f11, f12).f26744sc));
        }
        ArrayList arrayList4 = new ArrayList();
        int i11 = 0;
        while (true) {
            fMax = 0.0f;
            if (i11 >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj3 = arrayList2.get(i11);
            String strMcK = qj3.WH().ExN().McK();
            float fQj = qj3.Qj();
            boolean zEquals = TextUtils.equals(strMcK, "flex");
            if (TextUtils.equals(strMcK, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> listXc = qj3.Xc();
                if (listXc == null || listXc.size() <= 0) {
                    zEquals = false;
                    break;
                }
                Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> it3 = listXc.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        zEquals = false;
                        break;
                    }
                    if (pFF(it3.next())) {
                        zEquals = true;
                        break;
                    }
                }
            }
            sc scVar = new sc();
            if (!zEquals) {
                fQj = ((Float) arrayList3.get(i11)).floatValue();
            }
            scVar.f26743sc = fQj;
            scVar.pFF = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i11)).floatValue();
            }
            scVar.zY = fMax;
            arrayList4.add(scVar);
            i11++;
        }
        sc(arrayList4, f11, arrayList2);
        List<sc> listSc = WH.sc(f11, arrayList4);
        float f13 = 0.0f;
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            f13 += listSc.get(i12).f26743sc;
            if (((Float) arrayList3.get(i12)).floatValue() != listSc.get(i12).f26743sc) {
                We(arrayList2.get(i12));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it4 = arrayList2.iterator();
        int i13 = 0;
        boolean z11 = false;
        while (it4.hasNext()) {
            i13++;
            if (!pFF(it4.next())) {
                z11 = false;
                break;
            }
            if (i13 == arrayList2.size()) {
                z11 = true;
            }
        }
        fMax = z11 ? f12 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i14 = 0; i14 < arrayList2.size(); i14++) {
            com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj4 = arrayList2.get(i14);
            zY zYVarZY = zY(qj4, listSc.get(i14).f26743sc, f12);
            if (!pFF(qj4)) {
                fMax = Math.max(fMax, zYVarZY.pFF);
            }
            arrayList5.add(zYVarZY);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((zY) it5.next()).pFF));
        }
        if (!z11) {
            for (int i15 = 0; i15 < arrayList2.size(); i15++) {
                com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj5 = arrayList2.get(i15);
                if (pFF(qj5) && ((Float) arrayList6.get(i15)).floatValue() != fMax) {
                    We(qj5);
                    zY(qj5, listSc.get(i15).f26743sc, fMax);
                }
            }
        }
        zYVar.f26744sc = f13;
        zYVar.pFF = fMax;
        return zYVar;
    }

    private void zY(List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.pFF.remove(We(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it = list.iterator();
        while (it.hasNext()) {
            We(it.next());
        }
    }

    private boolean zY(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> listXc;
        if (!qj2.wjp() && TextUtils.equals(qj2.WH().ExN().II(), "auto") && (listXc = qj2.Xc()) != null && listXc.size() > 0) {
            if (listXc.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it = listXc.get(0).iterator();
                while (it.hasNext()) {
                    if (!pFF(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> it2 = listXc.iterator();
            while (it2.hasNext()) {
                if (sc(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public zY We(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, float f11, float f12) {
        float fMin;
        zY zYVar = new zY();
        float f13 = 0.0f;
        if (f12 <= 0.0f || f11 <= 0.0f) {
            zYVar.f26744sc = 0.0f;
            zYVar.pFF = 0.0f;
            return zYVar;
        }
        if (qj2.wjp()) {
            return sc(qj2, f11, f12);
        }
        float fQj = qj2.Qj();
        float fOl = qj2.Ol();
        float fBT = qj2.BT();
        float fDE = qj2.dE();
        com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN = qj2.WH().ExN();
        String strMcK = triExN.McK();
        String strII = triExN.II();
        float fMin2 = ((TextUtils.equals(strMcK, "flex") || TextUtils.equals(strMcK, "auto")) ? f11 : Math.min(fQj, f11)) - fBT;
        if (TextUtils.equals(strII, "scale")) {
            fMin = Math.round(fMin2 / fOl) + fDE;
            if (fMin > f12) {
                fMin2 = Math.round((f12 - fDE) * fOl);
            }
        } else {
            fMin = (TextUtils.equals(strII, "auto") || TextUtils.equals(strII, "flex")) ? f12 : Math.min(fOl, f12);
        }
        float f14 = fMin - fDE;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> listXc = qj2.Xc();
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> it = listXc.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> it2 = it;
            List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> next = it.next();
            zY zYVar2 = zYVar;
            zY zYVarPFF = pFF(next, fMin2, f14);
            if (pFF(next)) {
                f13 += 1.0f;
            } else {
                fMax = Math.max(fMax, zYVarPFF.f26744sc);
            }
            float f15 = f13;
            fMax2 = qj2.WH().pFF().equals("carousel") ? Math.max(qj2.Ol(), zYVarPFF.pFF) : fMax2 + zYVarPFF.pFF;
            zYVar = zYVar2;
            it = it2;
            f13 = f15;
        }
        zY zYVar3 = zYVar;
        if (TextUtils.equals(strMcK, "auto")) {
            if (f13 == listXc.size()) {
                fMin2 = f11;
            } else {
                for (List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list : listXc) {
                    zY(list);
                    pFF(list, fMax, f14);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strII, "auto")) {
            if (fMax2 <= f12) {
                f14 = fMax2;
            } else {
                sc(listXc, fMin2, f14);
            }
        } else if ((TextUtils.equals(strII, "fixed") || TextUtils.equals(strII, "flex")) && f14 < fMax2) {
            sc(listXc, fMin2, f14);
        }
        zYVar3.f26744sc = Math.min(fMin2 + fBT, f11);
        zYVar3.pFF = Math.min(f14 + fDE, f12);
        return zYVar3;
    }

    public zY pFF(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, float f11, float f12) {
        zY zYVar = new zY();
        if (qj2.WH().ExN() == null) {
            return zYVar;
        }
        zY zYVarExN = ExN(qj2, f11, f12);
        float f13 = zYVarExN.f26744sc;
        float f14 = zYVarExN.pFF;
        zYVar.f26744sc = Math.min(f13, f11);
        zYVar.pFF = Math.min(f14, f12);
        return zYVar;
    }

    public zY sc(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        return this.f26741sc.get(ExN(qj2));
    }

    public zY sc(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, float f11, float f12) {
        float f13;
        if ((!TextUtils.isEmpty(qj2.WH().zY()) || qj2.WH().ExN().kDg() != null) && !TextUtils.equals(qj2.WH().pFF(), "creative-playable-bait")) {
            float fQj = qj2.Qj();
            float fOl = qj2.Ol();
            com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN = qj2.WH().ExN();
            String strMcK = triExN.McK();
            String strII = triExN.II();
            float fQl = qj2.Ql();
            float fSR = qj2.SR();
            float fBT = qj2.BT();
            float fDE = qj2.dE();
            if (TextUtils.equals(strMcK, "fixed")) {
                f11 = Math.min(fQj, f11);
                if (TextUtils.equals(strII, "auto")) {
                    f13 = pFF(qj2, f11 - fBT, f12 - fDE).pFF;
                    fOl = f13 + fDE;
                }
            } else if (TextUtils.equals(strMcK, "auto")) {
                zY zYVarPFF = pFF(qj2, f11 - fBT, f12 - fDE);
                f11 = zYVarPFF.f26744sc + fBT;
                if (TextUtils.equals(strII, "auto")) {
                    f13 = zYVarPFF.pFF;
                    fOl = f13 + fDE;
                }
            } else if (!TextUtils.equals(strMcK, "flex")) {
                f11 = fQj;
            } else if (TextUtils.equals(strII, "auto")) {
                f13 = pFF(qj2, f11 - fBT, f12 - fDE).pFF;
                fOl = f13 + fDE;
            }
            if (TextUtils.equals(strII, "scale")) {
                float fRound = Math.round((f11 - fQl) / fOl) + fSR;
                if (fRound > f12) {
                    f11 = Math.round((f12 - fSR) * fOl) + fQl;
                } else {
                    f12 = fRound;
                }
            } else if (TextUtils.equals(strII, "fixed")) {
                f12 = Math.min(fOl + fSR, f12);
            } else if (!TextUtils.equals(strII, "flex")) {
                f12 = fOl;
            }
            zY zYVar = new zY();
            zYVar.f26744sc = f11;
            zYVar.pFF = f12;
            return zYVar;
        }
        return new zY(0.0f, 0.0f);
    }

    public zY sc(List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list) {
        return this.pFF.get(We(list));
    }

    public void sc() {
        this.zY.clear();
        this.f26741sc.clear();
        this.pFF.clear();
    }

    public zY zY(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, float f11, float f12) {
        if (qj2 == null) {
            return null;
        }
        zY zYVarSc = sc(qj2);
        if (zYVarSc != null && (zYVarSc.f26744sc != 0.0f || zYVarSc.pFF != 0.0f)) {
            return zYVarSc;
        }
        zY zYVarWe = We(qj2, f11, f12);
        sc(qj2, zYVarWe);
        return zYVarWe;
    }
}
