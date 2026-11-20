package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr extends We {
    public qr(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        super(view, scVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> sc() {
        this.zY.setTag(2097610709, Integer.valueOf(this.pFF.zY()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zY, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.pFF.WH() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(sc(duration));
        return arrayList;
    }
}
