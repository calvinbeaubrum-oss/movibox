package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Xc implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, Sfl {
    private com.bytedance.adsdk.pFF.zY.pFF.SR We;
    private final String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.adsdk.pFF.Ol f26212sc;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> zY;

    public Xc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.Ql ql2) {
        this.f26212sc = ol2;
        this.pFF = ql2.sc();
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc = ql2.pFF().sc();
        this.zY = scVarSc;
        scVar.sc(scVarSc);
        scVarSc.sc(this);
    }

    private static int pFF(int i11, int i12) {
        int i13 = i11 / i12;
        return ((i11 ^ i12) >= 0 || i12 * i13 == i11) ? i13 : i13 - 1;
    }

    private com.bytedance.adsdk.pFF.zY.pFF.SR pFF(com.bytedance.adsdk.pFF.zY.pFF.SR sr2) {
        List<com.bytedance.adsdk.pFF.zY.sc> listZY = sr2.zY();
        boolean zPFF = sr2.pFF();
        int size = listZY.size() - 1;
        int i11 = 0;
        while (size >= 0) {
            com.bytedance.adsdk.pFF.zY.sc scVar = listZY.get(size);
            com.bytedance.adsdk.pFF.zY.sc scVar2 = listZY.get(sc(size - 1, listZY.size()));
            PointF pointFZY = (size != 0 || zPFF) ? scVar2.zY() : sr2.sc();
            i11 = (((size != 0 || zPFF) ? scVar2.pFF() : pointFZY).equals(pointFZY) && scVar.sc().equals(pointFZY) && !(!sr2.pFF() && size == 0 && size == listZY.size() - 1)) ? i11 + 2 : i11 + 1;
            size--;
        }
        com.bytedance.adsdk.pFF.zY.pFF.SR sr3 = this.We;
        if (sr3 == null || sr3.zY().size() != i11) {
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList.add(new com.bytedance.adsdk.pFF.zY.sc());
            }
            this.We = new com.bytedance.adsdk.pFF.zY.pFF.SR(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.We.sc(zPFF);
        return this.We;
    }

    private static int sc(int i11, int i12) {
        return i11 - (pFF(i11, i12) * i12);
    }

    public com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> pFF() {
        return this.zY;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x009f  */
    @Override // com.bytedance.adsdk.pFF.sc.sc.Sfl
    public com.bytedance.adsdk.pFF.zY.pFF.SR sc(com.bytedance.adsdk.pFF.zY.pFF.SR sr2) {
        boolean z11;
        List<com.bytedance.adsdk.pFF.zY.sc> listZY = sr2.zY();
        if (listZY.size() <= 2) {
            return sr2;
        }
        float fFloatValue = this.zY.qr().floatValue();
        if (fFloatValue == 0.0f) {
            return sr2;
        }
        com.bytedance.adsdk.pFF.zY.pFF.SR srPFF = pFF(sr2);
        srPFF.sc(sr2.sc().x, sr2.sc().y);
        List<com.bytedance.adsdk.pFF.zY.sc> listZY2 = srPFF.zY();
        boolean zPFF = sr2.pFF();
        int i11 = 0;
        int i12 = 0;
        while (i11 < listZY.size()) {
            com.bytedance.adsdk.pFF.zY.sc scVar = listZY.get(i11);
            com.bytedance.adsdk.pFF.zY.sc scVar2 = listZY.get(sc(i11 - 1, listZY.size()));
            com.bytedance.adsdk.pFF.zY.sc scVar3 = listZY.get(sc(i11 - 2, listZY.size()));
            PointF pointFZY = (i11 != 0 || zPFF) ? scVar2.zY() : sr2.sc();
            PointF pointFPFF = (i11 != 0 || zPFF) ? scVar2.pFF() : pointFZY;
            PointF pointFSc = scVar.sc();
            PointF pointFZY2 = scVar3.zY();
            PointF pointFZY3 = scVar.zY();
            if (!sr2.pFF() && i11 == 0) {
                z11 = i11 == listZY.size() + (-1);
            }
            if (pointFPFF.equals(pointFZY) && pointFSc.equals(pointFZY) && !z11) {
                float f11 = pointFZY.x;
                float f12 = f11 - pointFZY2.x;
                float f13 = pointFZY.y;
                float f14 = f13 - pointFZY2.y;
                float f15 = pointFZY3.x - f11;
                float f16 = pointFZY3.y - f13;
                float fHypot = (float) Math.hypot(f12, f14);
                float fHypot2 = (float) Math.hypot(f15, f16);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f17 = pointFZY.x;
                float f18 = ((pointFZY2.x - f17) * fMin) + f17;
                float f19 = pointFZY.y;
                float f21 = ((pointFZY2.y - f19) * fMin) + f19;
                float f22 = ((pointFZY3.x - f17) * fMin2) + f17;
                float f23 = ((pointFZY3.y - f19) * fMin2) + f19;
                float f24 = f18 - ((f18 - f17) * 0.5519f);
                float f25 = f21 - ((f21 - f19) * 0.5519f);
                float f26 = f22 - ((f22 - f17) * 0.5519f);
                float f27 = f23 - ((f23 - f19) * 0.5519f);
                com.bytedance.adsdk.pFF.zY.sc scVar4 = listZY2.get(sc(i12 - 1, listZY2.size()));
                com.bytedance.adsdk.pFF.zY.sc scVar5 = listZY2.get(i12);
                scVar4.pFF(f18, f21);
                scVar4.zY(f18, f21);
                if (i11 == 0) {
                    srPFF.sc(f18, f21);
                }
                scVar5.sc(f24, f25);
                com.bytedance.adsdk.pFF.zY.sc scVar6 = listZY2.get(i12 + 1);
                scVar5.pFF(f26, f27);
                scVar5.zY(f22, f23);
                scVar6.sc(f22, f23);
                i12 += 2;
            } else {
                com.bytedance.adsdk.pFF.zY.sc scVar7 = listZY2.get(sc(i12 - 1, listZY2.size()));
                com.bytedance.adsdk.pFF.zY.sc scVar8 = listZY2.get(i12);
                scVar7.pFF(scVar2.pFF().x, scVar2.pFF().y);
                scVar7.zY(scVar2.zY().x, scVar2.zY().y);
                scVar8.sc(scVar.sc().x, scVar.sc().y);
                i12++;
            }
            i11++;
            listZY = listZY;
        }
        return srPFF;
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        this.f26212sc.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
    }
}
