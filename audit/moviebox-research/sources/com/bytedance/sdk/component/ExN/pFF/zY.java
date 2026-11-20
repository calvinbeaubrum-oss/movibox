package com.bytedance.sdk.component.ExN.pFF;

import com.bytedance.sdk.component.ExN.SR;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements com.bytedance.sdk.component.ExN.ExN {
    private SR We;
    private boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f26497sc;
    private boolean zY;

    public zY(String str, boolean z11, boolean z12, SR sr2) {
        this.f26497sc = str;
        this.pFF = z11;
        this.zY = z12;
        this.We = sr2;
    }

    @Override // com.bytedance.sdk.component.ExN.ExN
    public boolean pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.component.ExN.ExN
    public String sc() {
        return this.f26497sc;
    }

    @Override // com.bytedance.sdk.component.ExN.ExN
    public boolean zY() {
        return this.zY;
    }
}
