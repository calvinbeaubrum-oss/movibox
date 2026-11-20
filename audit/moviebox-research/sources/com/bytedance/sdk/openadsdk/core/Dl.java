package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.component.embedapplog.IDefaultEncrypt;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Dl implements IDefaultEncrypt {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PangleEncryptConstant.CryptDataScene f28002sc;

    public Dl(PangleEncryptConstant.CryptDataScene cryptDataScene) {
        this.f28002sc = cryptDataScene;
    }

    @Override // com.bytedance.sdk.component.embedapplog.IDefaultEncrypt
    public JSONObject encrypt(JSONObject jSONObject, int i11) {
        uEA.sc(1, this.f28002sc, i11);
        return com.bytedance.sdk.component.utils.sc.sc(jSONObject);
    }
}
