package com.applovin.impl.mediation;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.applovin.impl.ge;
import com.applovin.impl.pe;
import com.applovin.impl.zj;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxAdapterParametersImpl implements MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters, MaxAdapterInitializationParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f20678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f20679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f20680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f20681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f20682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Boolean f20683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f20684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f20685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f20686i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f20687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f20688k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f20689l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MaxAdFormat f20690m;

    private MaxAdapterParametersImpl() {
    }

    public static MaxAdapterParametersImpl a(ge geVar) {
        MaxAdapterParametersImpl maxAdapterParametersImplA = a((pe) geVar);
        maxAdapterParametersImplA.f20687j = geVar.V();
        maxAdapterParametersImplA.f20688k = geVar.E();
        maxAdapterParametersImplA.f20689l = geVar.D();
        return maxAdapterParametersImplA;
    }

    public static MaxAdapterParametersImpl a(pe peVar) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.f20678a = peVar.getAdUnitId();
        maxAdapterParametersImpl.f20682e = peVar.n();
        maxAdapterParametersImpl.f20683f = peVar.o();
        maxAdapterParametersImpl.f20684g = peVar.p();
        maxAdapterParametersImpl.f20685h = peVar.d();
        maxAdapterParametersImpl.f20679b = peVar.i();
        maxAdapterParametersImpl.f20680c = peVar.l();
        maxAdapterParametersImpl.f20681d = peVar.f();
        maxAdapterParametersImpl.f20686i = peVar.q();
        return maxAdapterParametersImpl;
    }

    public static MaxAdapterParametersImpl a(zj zjVar, String str, MaxAdFormat maxAdFormat) {
        MaxAdapterParametersImpl maxAdapterParametersImplA = a(zjVar);
        maxAdapterParametersImplA.f20678a = str;
        maxAdapterParametersImplA.f20690m = maxAdFormat;
        return maxAdapterParametersImplA;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters
    public MaxAdFormat getAdFormat() {
        return this.f20690m;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public String getAdUnitId() {
        return this.f20678a;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public long getBidExpirationMillis() {
        return this.f20689l;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public String getBidResponse() {
        return this.f20688k;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    @Nullable
    public String getConsentString() {
        return this.f20685h;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Bundle getCustomParameters() {
        return this.f20681d;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Map<String, Object> getLocalExtraParameters() {
        return this.f20679b;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Bundle getServerParameters() {
        return this.f20680c;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public String getThirdPartyAdPlacementId() {
        return this.f20687j;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean hasUserConsent() {
        return this.f20682e;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean isAgeRestrictedUser() {
        return this.f20683f;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean isDoNotSell() {
        return this.f20684g;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public boolean isTesting() {
        return this.f20686i;
    }
}
