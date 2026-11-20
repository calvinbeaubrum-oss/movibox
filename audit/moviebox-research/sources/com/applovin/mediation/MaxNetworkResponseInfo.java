package com.applovin.mediation;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MaxNetworkResponseInfo {

    /* JADX INFO: compiled from: source.java */
    public enum AdLoadState {
        AD_LOAD_NOT_ATTEMPTED,
        AD_LOADED,
        FAILED_TO_LOAD
    }

    AdLoadState getAdLoadState();

    Bundle getCredentials();

    MaxError getError();

    long getLatencyMillis();

    MaxMediatedNetworkInfo getMediatedNetwork();

    boolean isBidding();
}
