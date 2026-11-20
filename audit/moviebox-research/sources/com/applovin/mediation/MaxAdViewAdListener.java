package com.applovin.mediation;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MaxAdViewAdListener extends MaxAdListener {
    void onAdCollapsed(@NonNull MaxAd maxAd);

    void onAdExpanded(@NonNull MaxAd maxAd);
}
