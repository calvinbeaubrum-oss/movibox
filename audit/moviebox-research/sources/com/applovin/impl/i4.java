package com.applovin.impl;

import android.net.Uri;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings;
import com.cloud.tmc.integration.core.TmcEngineFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class i4 implements AppLovinTermsAndPrivacyPolicyFlowSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f19617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppLovinSdkConfiguration.ConsentFlowUserGeography f19618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f19619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f19620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Uri f19621e;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        TERMS(TmcEngineFactory.ENGINE_TYPE_DEFAULT),
        UNIFIED("unified");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19625a;

        a(String str) {
            this.f19625a = str;
        }

        public String b() {
            return this.f19625a;
        }
    }

    public i4(boolean z11, AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, a aVar, Uri uri, Uri uri2) {
        this.f19617a = z11;
        this.f19618b = consentFlowUserGeography;
        this.f19619c = aVar;
        this.f19620d = uri;
        this.f19621e = uri2;
    }

    public a a() {
        return this.f19619c;
    }

    public void a(a aVar) {
        this.f19619c = aVar;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography() {
        return this.f19618b;
    }

    @Override // com.applovin.sdk.AppLovinTermsFlowSettings
    public Uri getPrivacyPolicyUri() {
        return this.f19620d;
    }

    @Override // com.applovin.sdk.AppLovinTermsFlowSettings
    public Uri getTermsOfServiceUri() {
        return this.f19621e;
    }

    @Override // com.applovin.sdk.AppLovinTermsFlowSettings
    public boolean isEnabled() {
        return this.f19617a;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public void setDebugUserGeography(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography) {
        com.applovin.impl.sdk.n.g("ConsentFlowSettingsImpl", "Setting user debug geography: " + consentFlowUserGeography);
        this.f19618b = consentFlowUserGeography;
    }

    @Override // com.applovin.sdk.AppLovinTermsFlowSettings
    public void setEnabled(boolean z11) {
        com.applovin.impl.sdk.n.g("ConsentFlowSettingsImpl", "Setting consent flow enabled: " + z11);
        this.f19617a = z11;
    }

    @Override // com.applovin.sdk.AppLovinTermsFlowSettings
    public void setPrivacyPolicyUri(Uri uri) {
        com.applovin.impl.sdk.n.g("ConsentFlowSettingsImpl", "Setting privacy policy: " + uri);
        this.f19620d = uri;
    }

    @Override // com.applovin.sdk.AppLovinTermsFlowSettings
    public void setTermsOfServiceUri(Uri uri) {
        com.applovin.impl.sdk.n.g("ConsentFlowSettingsImpl", "Setting terms of service: " + uri);
        this.f19621e = uri;
    }

    public String toString() {
        return "ConsentFlowSettings{isEnabled=" + this.f19617a + ", privacyPolicyUri=" + this.f19620d + ", termsOfServiceUri=" + this.f19621e + '}';
    }
}
