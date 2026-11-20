package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX extends We {
    public UFX(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        super(view, scVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We
    public List<ObjectAnimator> sc() {
        float f11;
        float fUFX = (float) this.pFF.UFX();
        float fTf = (float) this.pFF.Tf();
        String strDE = this.pFF.dE();
        float f12 = 1.0f;
        if ("reverse".equals(strDE) || "alternate-reverse".equals(strDE)) {
            f11 = 1.0f;
        } else {
            f12 = fUFX;
            f11 = fTf;
            fUFX = 1.0f;
            fTf = 1.0f;
        }
        this.zY.setTag(2097610710, this.pFF.pFF());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zY, "scaleX", fUFX, f12).setDuration((int) (this.pFF.WH() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.zY, "scaleY", fTf, f11).setDuration((int) (this.pFF.WH() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(sc(duration));
        arrayList.add(sc(duration2));
        return arrayList;
    }
}
