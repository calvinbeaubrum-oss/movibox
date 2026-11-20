package com.google.android.gms.ads.initialization;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AdapterStatus {

    /* JADX INFO: compiled from: source.java */
    public enum State {
        NOT_READY,
        READY
    }

    @NonNull
    String getDescription();

    @NonNull
    State getInitializationState();

    int getLatency();
}
