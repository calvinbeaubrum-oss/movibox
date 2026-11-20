package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj extends We {
    public Qj(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        super(view, scVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> sc() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zY, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.pFF.WH() * 1000.0d));
        ((ViewGroup) this.zY.getParent()).setClipChildren(false);
        ((ViewGroup) this.zY.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.zY.getParent().getParent().getParent()).setClipChildren(false);
        this.zY.setTag(2097610712, this.pFF.Qj());
        ArrayList arrayList = new ArrayList();
        arrayList.add(sc(duration));
        return arrayList;
    }
}
