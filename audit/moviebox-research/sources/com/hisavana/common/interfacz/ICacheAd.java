package com.hisavana.common.interfacz;

import com.hisavana.common.bean.Network;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface ICacheAd {
    void destroyAd();

    void detachContext();

    int getAdSource();

    int getAdType();

    double getEcpmPrice();

    String getExt();

    String getFilterSource();

    Network getNetwork();

    String getPlacementId();

    long getValidTimeLimit();

    boolean isAdxAd();

    boolean isEwAd();

    boolean isExpired();

    boolean isIconAd();

    boolean isInternalAd();

    boolean isMatchVulgarBrand();

    boolean isOfflineAd();

    void setAdSource(int i11);

    void setEcpmPrice(double d11);

    void setExt(String str);

    void setMaxPrice(double d11);

    void setPreload(boolean z11);

    void setRequestType(int i11);

    void setSecondPrice(double d11);

    void setTimeOut(boolean z11);
}
