package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5m, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10845m implements NativeAdsManagerApi {
    public static final String A0A = NativeAdsManager.class.getSimpleName();
    public NativeAdsManager.Listener A01;
    public C1873ag A02;
    public String A03;
    public final int A06;
    public final C1795Yn A07;
    public final String A08;
    public final List<NativeAd> A09;
    public int A00 = -1;
    public boolean A04 = false;
    public boolean A05 = false;

    public C10845m(Context context, String str, int i11) {
        this.A07 = C10745c.A03(context);
        this.A08 = str;
        this.A06 = Math.max(i11, 0);
        this.A09 = new ArrayList(i11);
    }

    public final NativeAdsManager.Listener A00() {
        return this.A01;
    }

    public final C1873ag A01() {
        return this.A02;
    }

    public final void A02() {
        this.A09.clear();
    }

    public final void A03(int i11) {
        this.A00 = i11;
    }

    public final void A04(NativeAd nativeAd) {
        this.A09.add(nativeAd);
    }

    public final void A05(boolean z11) {
        this.A04 = z11;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void disableAutoRefresh() {
        this.A05 = true;
        C1873ag c1873ag = this.A02;
        if (c1873ag != null) {
            c1873ag.A06();
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final int getUniqueNativeAdCount() {
        return this.A09.size();
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final boolean isLoaded() {
        return this.A04;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void loadAds() {
        loadAds(NativeAdBase.MediaCacheFlag.ALL);
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void loadAds(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        EnumC1405Jg enumC1405Jg = EnumC1405Jg.A05;
        int i11 = this.A06;
        C1873ag c1873ag = this.A02;
        C1873ag c1873ag2 = new C1873ag(this.A07, this.A08, enumC1405Jg, null, i11);
        this.A02 = c1873ag2;
        if (this.A05) {
            c1873ag2.A06();
        }
        this.A02.A09(this.A03);
        this.A02.A08(new ZA(this, this.A07, mediaCacheFlag));
        this.A02.A07();
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final NativeAd nextNativeAd() {
        return nextNativeAd(null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final NativeAd nextNativeAd(NativeAdListener nativeAdListener) {
        if (this.A09.size() == 0) {
            return null;
        }
        int i11 = this.A00;
        this.A00 = i11 + 1;
        List<NativeAd> list = this.A09;
        NativeAd nativeAd = list.get(i11 % list.size());
        if (nativeAdListener != null) {
            ((V2) nativeAd.getInternalNativeAd()).A1R(nativeAd, nativeAdListener);
        }
        return i11 >= this.A09.size() ? new NativeAd(this.A07, nativeAd) : nativeAd;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void setExtraHints(String str) {
        this.A03 = str;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void setListener(NativeAdsManager.Listener listener) {
        this.A01 = listener;
    }
}
