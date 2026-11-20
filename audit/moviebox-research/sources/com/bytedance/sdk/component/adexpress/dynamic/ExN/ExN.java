package com.bytedance.sdk.component.adexpress.dynamic.ExN;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bytedance.sdk.component.adexpress.pFF.Ql;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {
    private sc We;
    protected pFF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public com.bytedance.sdk.component.adexpress.dynamic.We.pFF f26734sc;
    private com.bytedance.sdk.component.adexpress.dynamic.We.Qj zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        float pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        float f26735sc;
        float zY;
    }

    public ExN(double d11, int i11, double d12, String str, Ql ql2) {
        this.pFF = new pFF(d11, i11, d12, str, ql2);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.We.Ol sc(com.bytedance.sdk.component.adexpress.dynamic.We.TRI tri, pFF.zY zYVar, pFF.zY zYVar2) {
        float fIEI = tri.IEI();
        float fGsl = tri.gsl();
        float fPPh = tri.PPh();
        float fQST = tri.QST();
        boolean zBs = tri.Bs();
        boolean zYdT = tri.YdT();
        boolean zBSP = tri.bSP();
        boolean zNQ = tri.NQ();
        if (!zBs) {
            if (zYdT) {
                float f11 = this.We.f26735sc;
                fIEI = ((f11 != 0.0f ? Math.min(f11, zYVar.f26744sc) : zYVar.f26744sc) - fPPh) - zYVar2.f26744sc;
            } else {
                fIEI = 0.0f;
            }
        }
        if (!zBSP) {
            if (zNQ) {
                float f12 = this.We.pFF;
                if (f12 == 0.0f) {
                    f12 = zYVar.pFF;
                }
                fGsl = (f12 - fQST) - zYVar2.pFF;
            } else {
                fGsl = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.We.Ol(fIEI, fGsl);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.We.Ol sc(com.bytedance.sdk.component.adexpress.dynamic.We.pFF pff, com.bytedance.sdk.component.adexpress.dynamic.We.TRI tri, float f11, float f12) {
        float f13;
        float f14;
        float f15 = pff.f26769sc;
        float f16 = pff.pFF;
        float fIEI = tri.IEI();
        float fGsl = tri.gsl();
        float fPPh = tri.PPh();
        float fQST = tri.QST();
        boolean zBs = tri.Bs();
        boolean zYdT = tri.YdT();
        boolean zBSP = tri.bSP();
        boolean zNQ = tri.NQ();
        String strFT = tri.fT();
        float f17 = pff.zY;
        float f18 = pff.We;
        if (TextUtils.equals(strFT, "0")) {
            if (zBs) {
                f15 = pff.f26769sc + fIEI;
            } else if (zYdT) {
                f15 = ((pff.f26769sc + f17) - fPPh) - f11;
            }
            if (zBSP) {
                f14 = pff.pFF;
                f16 = f14 + fGsl;
            } else if (zNQ) {
                f13 = pff.pFF;
                f16 = ((f13 + f18) - fQST) - f12;
            }
        } else if (TextUtils.equals(strFT, "1")) {
            f15 = pff.f26769sc + ((f17 - f11) / 2.0f);
            if (zBSP) {
                f14 = pff.pFF;
                f16 = f14 + fGsl;
            } else if (zNQ) {
                f13 = pff.pFF;
                f16 = ((f13 + f18) - fQST) - f12;
            }
        } else if (TextUtils.equals(strFT, "2")) {
            f16 = pff.pFF + ((f18 - f12) / 2.0f);
            if (zBs) {
                f15 = pff.f26769sc + fIEI;
            } else if (zYdT) {
                f15 = ((pff.f26769sc + f17) - fPPh) - f11;
            }
        } else if (TextUtils.equals(strFT, "3")) {
            f15 = pff.f26769sc + ((f17 - f11) / 2.0f);
            f16 = pff.pFF + ((f18 - f12) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.We.Ol(f15, f16);
    }

    /* JADX WARN: Code duplicated, block: B:134:0x0317  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f4  */
    public com.bytedance.sdk.component.adexpress.dynamic.We.pFF sc(com.bytedance.sdk.component.adexpress.dynamic.We.pFF pff, float f11) {
        float fSc;
        float fSc2;
        float f12;
        com.bytedance.sdk.component.adexpress.dynamic.We.TRI tri;
        float fSc3;
        float fSc4;
        com.bytedance.sdk.component.adexpress.dynamic.We.pFF pff2;
        com.bytedance.sdk.component.adexpress.dynamic.We.Ol olSc;
        float f13;
        com.bytedance.sdk.component.adexpress.dynamic.We.Ol ol2;
        pFF.zY zYVarSc;
        pFF.zY zYVarSc2;
        com.bytedance.sdk.component.adexpress.dynamic.We.pFF pff3 = pff;
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 = pff3.TRI;
        if (qj2 == null) {
            return pff3;
        }
        qj2.Dl();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> listXc = qj2.Xc();
        if (listXc == null || listXc.size() <= 0) {
            return pff3;
        }
        com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN = qj2.WH().ExN();
        float fXc = triExN.Xc();
        float fDE = triExN.dE();
        float fSR = triExN.SR();
        float fBT = triExN.BT();
        float fTf = triExN.Tf();
        String strQKn = triExN.qKn();
        String strPc = triExN.pc();
        float f14 = pff3.f26769sc + fBT;
        float f15 = pff3.pFF + fXc;
        float f16 = fTf * 2.0f;
        float f17 = ((pff3.zY - fBT) - fDE) - f16;
        float f18 = ((pff3.We - fXc) - fSR) - f16;
        com.bytedance.sdk.component.adexpress.dynamic.We.Ol ol3 = new com.bytedance.sdk.component.adexpress.dynamic.We.Ol(f14, f15);
        if (pff3.f26768qr == null) {
            pff3.f26768qr = new ArrayList();
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> it = listXc.iterator();
        float f19 = 0.0f;
        while (it.hasNext()) {
            pFF.zY zYVarSc3 = this.pFF.sc(it.next());
            if (zYVarSc3 != null) {
                f19 += zYVarSc3.pFF;
            }
        }
        String str = "space-between";
        String str2 = "space-around";
        if (f19 >= f18) {
            fSc = 0.0f;
            fSc2 = 0.0f;
        } else {
            if (TextUtils.equals(strPc, TtmlNode.CENTER)) {
                fSc = (f18 - f19) / 2.0f;
            } else if (TextUtils.equals(strPc, "flex-end")) {
                fSc = f18 - f19;
            } else if (TextUtils.equals(strPc, "space-around")) {
                fSc = WH.sc((f18 - f19) / (listXc.size() + 1));
                fSc2 = fSc;
            } else if (!TextUtils.equals(strPc, "space-between") || listXc.size() <= 1) {
                fSc = 0.0f;
            } else {
                fSc2 = WH.sc((f18 - f19) / (listXc.size() - 1));
                fSc = 0.0f;
            }
            fSc2 = 0.0f;
        }
        ol3.pFF += fSc;
        float f21 = f11;
        int i11 = 0;
        while (i11 < listXc.size()) {
            List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list = listXc.get(i11);
            int i12 = i11 + 1;
            List<List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>> list2 = listXc;
            if (i12 >= pff3.f26768qr.size()) {
                int size = (i12 - pff3.f26768qr.size()) + 1;
                int i13 = 0;
                while (i13 < size) {
                    pff3.f26768qr.add(new ArrayList());
                    i13++;
                    size = size;
                    fSc2 = fSc2;
                }
                f12 = fSc2;
            } else {
                f12 = fSc2;
            }
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it2 = list.iterator();
            float f22 = 0.0f;
            while (true) {
                tri = triExN;
                if (!it2.hasNext()) {
                    break;
                }
                com.bytedance.sdk.component.adexpress.dynamic.We.Qj next = it2.next();
                com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN2 = next.WH().ExN();
                String strMcK = triExN2.McK();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it3 = it2;
                int iIdT = triExN2.idT();
                if (!TextUtils.equals(strMcK, "flex") && iIdT != 1 && iIdT != 2 && (zYVarSc2 = this.pFF.sc(next)) != null) {
                    f22 += zYVarSc2.f26744sc;
                }
                triExN = tri;
                it2 = it3;
            }
            float fMax = Math.max(f17 - f22, 0.0f);
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it4 = list.iterator();
            float f23 = 0.0f;
            while (it4.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.We.Qj next2 = it4.next();
                com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN3 = next2.WH().ExN();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it5 = it4;
                if (triExN3.idT() != 1 && triExN3.idT() != 2 && (zYVarSc = this.pFF.sc(next2)) != null) {
                    f23 += zYVarSc.f26744sc;
                }
                it4 = it5;
            }
            if (f23 >= f17) {
                fSc3 = 0.0f;
                fSc4 = 0.0f;
            } else {
                if (TextUtils.equals(strQKn, TtmlNode.CENTER)) {
                    fSc3 = (f17 - f23) / 2.0f;
                } else if (TextUtils.equals(strQKn, "flex-end")) {
                    fSc3 = f17 - f23;
                } else if (TextUtils.equals(strQKn, str2)) {
                    fSc3 = WH.sc((f17 - f23) / (list.size() + 1));
                    fSc4 = fSc3;
                } else if (!TextUtils.equals(strQKn, str) || list.size() <= 1) {
                    fSc3 = 0.0f;
                } else {
                    fSc4 = WH.sc((f17 - f23) / (list.size() - 1.0f));
                    fSc3 = 0.0f;
                }
                fSc4 = 0.0f;
            }
            ol3.f26748sc += fSc3;
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it6 = list.iterator();
            float fMax2 = 0.0f;
            while (it6.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.We.Qj next3 = it6.next();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it7 = it6;
                float f24 = this.pFF.sc(next3) != null ? this.pFF.sc(next3).pFF : 0.0f;
                com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN4 = next3.WH().ExN();
                String str3 = str;
                fMax2 = Math.max(fMax2, (triExN4.idT() == 1 || triExN4.idT() == 2) ? 0.0f : f24);
                it6 = it7;
                str = str3;
            }
            String str4 = str;
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it8 = list.iterator();
            f21 = f21;
            while (it8.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.We.Qj next4 = it8.next();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it9 = it8;
                pFF.zY zYVarSc4 = this.pFF.sc(next4);
                String str5 = str2;
                com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN5 = next4.WH().ExN();
                String str6 = strQKn;
                float fQLv = triExN5.QLv();
                float f25 = f21;
                float fYhz = triExN5.Yhz();
                float f26 = f17;
                float fEo = triExN5.eo();
                float f27 = fSc4;
                float fYL = triExN5.yL();
                com.bytedance.sdk.component.adexpress.dynamic.We.Ol ol4 = ol3;
                float f28 = zYVarSc4 == null ? 0.0f : zYVarSc4.f26744sc;
                float f29 = zYVarSc4 == null ? 0.0f : zYVarSc4.pFF;
                com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj3 = qj2;
                float f31 = TextUtils.equals(qj2.zY(), "root") ? i12 : f25;
                int i14 = i12;
                if (triExN5.idT() == 1) {
                    pff2 = pff;
                    olSc = sc(pff2, triExN5, (f28 - fYhz) - fYL, (f29 - fQLv) - fEo);
                } else {
                    pff2 = pff;
                    olSc = ol4;
                }
                com.bytedance.sdk.component.adexpress.dynamic.We.Ol olSc2 = triExN5.idT() == 2 ? sc(triExN5, this.pFF.sc(this.zY), new pFF.zY((f28 - fYhz) - fYL, (f29 - fQLv) - fEo)) : olSc;
                String strEoh = tri.eoh();
                if (fMax2 > f29 && !TextUtils.equals(strEoh, "flex-start")) {
                    strEoh.hashCode();
                    if (strEoh.equals(TtmlNode.CENTER)) {
                        f13 = (fMax2 - f29) / 2.0f;
                    } else {
                        f13 = !strEoh.equals("flex-end") ? 0.0f : fMax2 - f29;
                    }
                }
                com.bytedance.sdk.component.adexpress.dynamic.We.pFF pff4 = new com.bytedance.sdk.component.adexpress.dynamic.We.pFF();
                pff4.f26769sc = olSc2.f26748sc + fYL;
                pff4.pFF = olSc2.pFF + fQLv + f13;
                pff4.zY = (f28 - fYhz) - fYL;
                pff4.We = (f29 - fQLv) - fEo;
                pff4.ExN = pff2.ExN + InstructionFileId.DOT + next4.zY();
                pff4.Qj = pff2;
                pff4.TRI = next4;
                fMax = fMax;
                pff4.Ol = fMax;
                List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> list3 = list;
                pff4.WH = list3;
                next4.zY(pff4.f26769sc);
                pff4.TRI.We(pff4.pFF);
                pff4.TRI.ExN(pff4.zY);
                pff4.TRI.TRI(pff4.We);
                float f32 = f31;
                pff2.f26768qr.get(i14).add(sc(pff4, f32));
                if (triExN5.idT() == 1) {
                    ol2 = ol4;
                } else if (triExN5.idT() != 2) {
                    ol2 = ol4;
                    ol2.f26748sc += f28 + f27;
                } else {
                    ol2 = ol4;
                }
                list = list3;
                f21 = f32;
                ol3 = ol2;
                i12 = i14;
                strQKn = str6;
                str2 = str5;
                f17 = f26;
                fSc4 = f27;
                qj2 = qj3;
                it8 = it9;
            }
            com.bytedance.sdk.component.adexpress.dynamic.We.Ol ol5 = ol3;
            ol5.f26748sc = f14;
            ol5.pFF += fMax2 + f12;
            pff3 = pff;
            i11 = i12;
            strQKn = strQKn;
            listXc = list2;
            triExN = tri;
            fSc2 = f12;
            str = str4;
            qj2 = qj2;
        }
        return pff3;
    }

    public void sc() {
        this.pFF.sc();
    }

    public void sc(sc scVar) {
        this.We = scVar;
    }

    public void sc(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, float f11, float f12) {
        if (qj2 != null) {
            this.zY = qj2;
        }
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj3 = this.zY;
        float fQj = qj3.Qj();
        float fOl = qj3.Ol();
        float f13 = TextUtils.equals(qj3.WH().ExN().II(), "fixed") ? fOl : 65536.0f;
        this.pFF.sc();
        this.pFF.zY(qj3, fQj, f13);
        pFF.zY zYVarSc = this.pFF.sc(qj3);
        com.bytedance.sdk.component.adexpress.dynamic.We.pFF pff = new com.bytedance.sdk.component.adexpress.dynamic.We.pFF();
        pff.f26769sc = f11;
        pff.pFF = f12;
        if (zYVarSc != null) {
            fQj = zYVarSc.f26744sc;
        }
        pff.zY = fQj;
        if (zYVarSc != null) {
            fOl = zYVarSc.pFF;
        }
        pff.We = fOl;
        pff.ExN = "root";
        pff.Ol = 1280.0f;
        pff.TRI = qj3;
        qj3.zY(f11);
        pff.TRI.We(pff.pFF);
        pff.TRI.ExN(pff.zY);
        pff.TRI.TRI(pff.We);
        com.bytedance.sdk.component.adexpress.dynamic.We.pFF pffSc = sc(pff, 0.0f);
        this.f26734sc = pffSc;
        sc(pffSc);
    }

    public void sc(com.bytedance.sdk.component.adexpress.dynamic.We.pFF pff) {
        if (pff == null) {
            return;
        }
        pff.TRI.WH().pFF();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.We.pFF>> list = pff.f26768qr;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.We.pFF> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.pFF> it = list2.iterator();
                while (it.hasNext()) {
                    sc(it.next());
                }
            }
        }
    }
}
