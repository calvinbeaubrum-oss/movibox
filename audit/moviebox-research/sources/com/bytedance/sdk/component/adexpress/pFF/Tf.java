package com.bytedance.sdk.component.adexpress.pFF;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Tf implements WH.sc {
    private AtomicBoolean We = new AtomicBoolean(false);

    @NonNull
    private List<WH> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    BT f26888sc;
    private Ol zY;

    public Tf(List<WH> list, Ol ol2) {
        this.pFF = list;
        this.zY = ol2;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH.sc
    public BT pFF() {
        return this.f26888sc;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH.sc
    public boolean pFF(WH wh2) {
        int iIndexOf = this.pFF.indexOf(wh2);
        return iIndexOf < this.pFF.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH.sc
    public void sc() {
        this.zY.We();
        Iterator<WH> it = this.pFF.iterator();
        while (it.hasNext() && !it.next().sc(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH.sc
    public void sc(BT bt2) {
        this.f26888sc = bt2;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH.sc
    public void sc(WH wh2) {
        int iIndexOf = this.pFF.indexOf(wh2);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.pFF.size()) {
                return;
            }
        } while (!this.pFF.get(iIndexOf).sc(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH.sc
    public void sc(boolean z11) {
        this.We.getAndSet(z11);
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH.sc
    public boolean zY() {
        return this.We.get();
    }
}
