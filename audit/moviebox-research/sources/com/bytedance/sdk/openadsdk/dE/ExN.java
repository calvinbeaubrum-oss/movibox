package com.bytedance.sdk.openadsdk.dE;

import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.SR;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class ExN implements We {
    private int ExN;
    private int We;
    private We pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    long f28601sc = System.currentTimeMillis();
    private int zY;

    public ExN(We we2, int i11, int i12, int i13) {
        this.pFF = we2;
        this.zY = i11;
        this.We = i12;
        this.ExN = i13;
    }

    @Override // com.bytedance.sdk.openadsdk.dE.We
    public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
        com.bytedance.sdk.openadsdk.dE.pFF.sc scVarGeneratorModel = this.pFF.generatorModel();
        scVarGeneratorModel.sc(BuildConfig.VERSION_NAME);
        scVarGeneratorModel.sc(this.zY);
        scVarGeneratorModel.pFF(this.We);
        scVarGeneratorModel.zY(this.ExN);
        scVarGeneratorModel.pFF(this.f28601sc);
        scVarGeneratorModel.TRI(Ol.pFF().ExN());
        scVarGeneratorModel.We(SR.We());
        return scVarGeneratorModel;
    }
}
