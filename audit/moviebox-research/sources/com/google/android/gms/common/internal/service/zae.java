package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zae {
    public final PendingResult zaa(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zac(this, googleApiClient));
    }
}
