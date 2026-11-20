package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cJ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements cJ {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    List<We> f26783sc = new ArrayList();

    public pFF(View view, List<com.bytedance.sdk.component.adexpress.dynamic.We.sc> list) {
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.sc> it = list.iterator();
        while (it.hasNext()) {
            We weSc = zY.sc().sc(view, it.next());
            if (weSc != null) {
                this.f26783sc.add(weSc);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cJ
    public void pFF() {
        Iterator<We> it = this.f26783sc.iterator();
        while (it.hasNext()) {
            try {
                it.next().pFF();
            } catch (Exception unused) {
            }
        }
    }

    public void sc() {
        Iterator<We> it = this.f26783sc.iterator();
        while (it.hasNext()) {
            try {
                it.next().zY();
            } catch (Exception unused) {
            }
        }
    }
}
