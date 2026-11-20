package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Tf extends We {
    public Tf(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        super(view, scVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> sc() {
        int i11;
        int i12;
        this.zY.setTag(2097610711, Integer.valueOf(this.pFF.We()));
        View view = this.zY;
        if (view == null || !com.bytedance.sdk.component.adexpress.We.pFF.sc(view.getContext())) {
            i11 = 0;
            i12 = 1;
        } else {
            i11 = 1;
            i12 = 0;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zY, "shineValue", i11, i12).setDuration((int) (this.pFF.WH() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(sc(duration));
        return arrayList;
    }
}
