package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BT extends We {
    public BT(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        super(view, scVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We
    public List<ObjectAnimator> sc() {
        float f11;
        float fSc = com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.pFF.TRI());
        float fSc2 = com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), this.pFF.qr());
        float f12 = 0.0f;
        if ("reverse".equals(this.pFF.dE())) {
            f12 = fSc;
            f11 = fSc2;
            fSc = 0.0f;
            fSc2 = 0.0f;
        } else {
            f11 = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.We.pFF.sc(this.zY.getContext())) {
            fSc = -fSc;
            f12 = -f12;
        }
        this.zY.setTranslationX(fSc);
        this.zY.setTranslationY(fSc2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zY, "translationX", fSc, f12).setDuration((int) (this.pFF.WH() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.zY, "translationY", fSc2, f11).setDuration((int) (this.pFF.WH() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(sc(duration));
        arrayList.add(sc(duration2));
        return arrayList;
    }
}
