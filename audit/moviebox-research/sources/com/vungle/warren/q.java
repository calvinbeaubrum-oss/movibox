package com.vungle.warren;

import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface q {
    void creativeId(String str);

    void onAdClick(String str);

    void onAdEnd(String str);

    @Deprecated
    void onAdEnd(String str, boolean z11, boolean z12);

    void onAdLeftApplication(String str);

    void onAdRewarded(String str);

    void onAdStart(String str);

    void onAdViewed(String str);

    void onError(String str, VungleException vungleException);
}
