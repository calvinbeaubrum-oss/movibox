package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends We {
    public TRI(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        super(view, scVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We
    public List<ObjectAnimator> sc() {
        float f11 = this.zY.getLayoutParams().width;
        this.zY.setTranslationX(f11);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zY, "translationX", f11, 0.0f).setDuration((int) (this.pFF.WH() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.zY, "alpha", 0.0f, 1.0f).setDuration((int) (this.pFF.WH() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(sc(duration));
        arrayList.add(sc(duration2));
        return arrayList;
    }
}
