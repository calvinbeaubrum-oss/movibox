package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class SR implements TTClientBidding {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Qj f27805sc;

    public SR(Context context, com.bytedance.sdk.openadsdk.core.model.sc scVar, AdSlot adSlot) {
        this.f27805sc = new Qj(context, scVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d11, String str, String str2) {
        this.f27805sc.loss(d11, str, str2);
    }

    public void pFF() {
        this.f27805sc.sc();
    }

    public Qj sc() {
        return this.f27805sc;
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d11) {
        this.f27805sc.win(d11);
    }
}
