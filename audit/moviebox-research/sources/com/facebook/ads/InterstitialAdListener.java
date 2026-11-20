package com.facebook.ads;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface InterstitialAdListener extends AdListener {
    void onInterstitialDismissed(Ad ad2);

    void onInterstitialDisplayed(Ad ad2);
}
