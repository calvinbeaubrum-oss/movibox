package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class kn extends mn {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.b f20264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinAdRewardListener f20265i;

    public kn(com.applovin.impl.sdk.ad.b bVar, AppLovinAdRewardListener appLovinAdRewardListener, com.applovin.impl.sdk.j jVar) {
        super("TaskValidateAppLovinReward", jVar);
        this.f20264h = bVar;
        this.f20265i = appLovinAdRewardListener;
    }

    @Override // com.applovin.impl.in
    public void a(int i11) {
        String str;
        super.a(i11);
        if (i11 < 400 || i11 >= 500) {
            this.f20265i.validationRequestFailed(this.f20264h, i11);
            str = "network_timeout";
        } else {
            this.f20265i.userRewardRejected(this.f20264h, Collections.emptyMap());
            str = "rejected";
        }
        this.f20264h.a(fh.a(str));
    }

    @Override // com.applovin.impl.mn
    public void a(fh fhVar) {
        this.f20264h.a(fhVar);
        String strB = fhVar.b();
        Map<String, String> mapA = fhVar.a();
        if (strB.equals("accepted")) {
            this.f20265i.userRewardVerified(this.f20264h, mapA);
            return;
        }
        if (strB.equals("quota_exceeded")) {
            this.f20265i.userOverQuota(this.f20264h, mapA);
        } else if (strB.equals("rejected")) {
            this.f20265i.userRewardRejected(this.f20264h, mapA);
        } else {
            this.f20265i.validationRequestFailed(this.f20264h, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    @Override // com.applovin.impl.in
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.f20264h.getAdZone().e());
        String clCode = this.f20264h.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    @Override // com.applovin.impl.in
    public String f() {
        return "2.0/vr";
    }

    @Override // com.applovin.impl.mn
    public boolean h() {
        return this.f20264h.P0();
    }
}
