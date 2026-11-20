package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Cb;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends com.bytedance.sdk.component.Qj.Qj {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final List<? extends com.bytedance.sdk.component.Qj.Qj> f27838sc;

    public pFF(String str, List<? extends com.bytedance.sdk.component.Qj.Qj> list) {
        super(str);
        this.f27838sc = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<? extends com.bytedance.sdk.component.Qj.Qj> list;
        if (BT.zY(Xc.sc()) != 0 && (list = this.f27838sc) != null) {
            Iterator<? extends com.bytedance.sdk.component.Qj.Qj> it = list.iterator();
            while (it.hasNext()) {
                Cb.sc(it.next(), 1);
                it.remove();
            }
        }
        try {
            com.bytedance.sdk.component.utils.qr.sc().removeCallbacks(this);
        } catch (Exception unused) {
        }
    }
}
