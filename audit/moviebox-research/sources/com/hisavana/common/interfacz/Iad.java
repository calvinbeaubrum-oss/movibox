package com.hisavana.common.interfacz;

import android.os.Bundle;
import com.hisavana.common.bean.TInnerAdRequestBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface Iad extends ICacheAd {
    void addRequestBody(TInnerAdRequestBody tInnerAdRequestBody);

    String getAdUnit();

    int getLoadStatus();

    long getRequestTime();

    boolean isSupportRtBidding();

    void loadAd();

    void setAdUnit(String str);

    void setLoadStatus(int i11);

    void setOfflineAd(boolean z11);

    void setRequestRound(int i11);

    void setRequestTime(long j11);

    void setSupportFlag(int i11);

    void setTrackingBundle(Bundle bundle);

    void stopLoader();
}
