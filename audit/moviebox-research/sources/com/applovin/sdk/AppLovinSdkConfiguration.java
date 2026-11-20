package com.applovin.sdk;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AppLovinSdkConfiguration {

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public enum ConsentDialogState {
        UNKNOWN,
        APPLIES,
        DOES_NOT_APPLY
    }

    /* JADX INFO: compiled from: source.java */
    public enum ConsentFlowUserGeography {
        UNKNOWN,
        GDPR,
        OTHER
    }

    @Deprecated
    ConsentDialogState getConsentDialogState();

    ConsentFlowUserGeography getConsentFlowUserGeography();

    String getCountryCode();

    @Nullable
    List<String> getEnabledAmazonAdUnitIds();

    boolean isTestModeEnabled();
}
