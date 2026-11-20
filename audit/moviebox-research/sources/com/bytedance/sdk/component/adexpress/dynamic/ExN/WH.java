package com.bytedance.sdk.component.adexpress.dynamic.ExN;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH {
    public static float sc(float f11) {
        return (float) Math.ceil((f11 * 16.0f) / 16.0f);
    }

    public static List<pFF.sc> sc(float f11, List<pFF.sc> list) {
        ArrayList<pFF.sc> arrayList = new ArrayList();
        Iterator<pFF.sc> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((pFF.sc) it.next().clone());
        }
        boolean z11 = true;
        int i11 = 0;
        int i12 = 0;
        for (pFF.sc scVar : arrayList) {
            if (scVar.pFF) {
                i11 = (int) (i11 + scVar.f26743sc);
            } else {
                i12 = (int) (i12 + scVar.f26743sc);
                z11 = false;
            }
        }
        if (z11 && f11 > i11) {
            return arrayList;
        }
        float f12 = i11;
        float f13 = f11 < f12 ? f11 / f12 : 1.0f;
        float f14 = f11 > f12 ? (f11 - f12) / i12 : 0.0f;
        if (f14 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z12 = false;
            for (pFF.sc scVar2 : arrayList) {
                if (!scVar2.pFF) {
                    float f15 = scVar2.zY;
                    if (f15 != 0.0f && scVar2.f26743sc * f14 > f15) {
                        scVar2.f26743sc = f15;
                        scVar2.pFF = true;
                        z12 = true;
                    }
                }
                arrayList2.add(scVar2);
            }
            if (z12) {
                return sc(f11, arrayList2);
            }
        }
        int i13 = 0;
        for (pFF.sc scVar3 : arrayList) {
            if (scVar3.pFF) {
                scVar3.f26743sc = sc(scVar3.f26743sc * f13);
            } else {
                scVar3.f26743sc = sc(scVar3.f26743sc * f14);
            }
            i13 = (int) (i13 + scVar3.f26743sc);
        }
        float f16 = i13;
        if (f16 < f11) {
            float f17 = f11 - f16;
            for (int size = 0; size < arrayList.size() && f17 > 0.0f; size = (size + 1) % arrayList.size()) {
                pFF.sc scVar4 = (pFF.sc) arrayList.get(size);
                if ((f11 < f12 && scVar4.pFF) || (f11 > f12 && !scVar4.pFF)) {
                    scVar4.f26743sc += 0.0625f;
                    f17 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
