package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends We {
    public sc(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        super(view, scVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We
    public List<ObjectAnimator> sc() {
        float fWjp = this.pFF.wjp() / 100.0f;
        float fSfl = this.pFF.Sfl() / 100.0f;
        if ("reverse".equals(this.pFF.dE()) && this.pFF.SR() <= 0.0d) {
            fSfl = fWjp;
            fWjp = fSfl;
        }
        this.zY.setAlpha(fWjp);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zY, "alpha", fWjp, fSfl).setDuration((int) (this.pFF.WH() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(sc(duration));
        return arrayList;
    }
}
