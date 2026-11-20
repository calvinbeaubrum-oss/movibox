package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InitializationCompleteCallback {
    void onInitializationFailed(@NonNull String str);

    void onInitializationSucceeded();
}
