package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR extends We {
    public SR(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        super(view, scVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We
    public List<ObjectAnimator> sc() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zY, "rotation", 0.0f, this.pFF.ExN(), 0.0f, this.pFF.ExN(), 0.0f).setDuration((int) (this.pFF.WH() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(sc(duration));
        return arrayList;
    }
}
