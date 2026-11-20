package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class Ql implements TTClientBidding {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final TRI f27804sc;

    public Ql(Context context, com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        this.f27804sc = new TRI(context, scVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d11, String str, String str2) {
        this.f27804sc.loss(d11, str, str2);
    }

    public void pFF() {
        this.f27804sc.sc();
    }

    public TRI sc() {
        return this.f27804sc;
    }

    public void sc(boolean z11) {
        this.f27804sc.sc(z11);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d11) {
        this.f27804sc.win(d11);
    }
}
