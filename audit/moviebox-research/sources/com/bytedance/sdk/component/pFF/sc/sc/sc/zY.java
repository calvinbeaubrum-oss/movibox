package com.bytedance.sdk.component.pFF.sc.sc.sc;

import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ql;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements com.bytedance.sdk.component.pFF.sc.Qj.sc {
    Ql pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    List<com.bytedance.sdk.component.pFF.sc.Qj> f26963sc;
    int zY = 0;

    public zY(List<com.bytedance.sdk.component.pFF.sc.Qj> list, Ql ql2) {
        this.f26963sc = list;
        this.pFF = ql2;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.Qj.sc
    public BT sc(Ql ql2) throws IOException {
        this.pFF = ql2;
        int i11 = this.zY + 1;
        this.zY = i11;
        if (i11 >= this.f26963sc.size()) {
            return null;
        }
        return this.f26963sc.get(this.zY).sc(this);
    }

    @Override // com.bytedance.sdk.component.pFF.sc.Qj.sc
    public Ql sc() {
        return this.pFF;
    }
}
