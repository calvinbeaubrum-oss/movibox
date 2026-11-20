package com.applovin.impl;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdCallback;
import com.amazon.device.ads.DTBAdRequest;
import com.amazon.device.ads.DTBAdResponse;
import com.amazon.device.ads.DTBAdSize;
import com.applovin.mediation.MaxAdFormat;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class o0 implements DTBAdCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxAdFormat f21434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f21435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DTBAdRequest f21436c;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat);

        void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat);
    }

    public o0(p0 p0Var, MaxAdFormat maxAdFormat, a aVar) {
        this(Arrays.asList(p0Var.a()), maxAdFormat, aVar);
    }

    public o0(List list, MaxAdFormat maxAdFormat, a aVar) {
        this.f21434a = maxAdFormat;
        this.f21435b = aVar;
        try {
            DTBAdSize[] dTBAdSizeArr = new DTBAdSize[list.size()];
            for (int i11 = 0; i11 < list.size(); i11++) {
                Object obj = list.get(i11);
                if (obj instanceof DTBAdSize) {
                    dTBAdSizeArr[i11] = (DTBAdSize) obj;
                }
            }
            DTBAdRequest dTBAdRequest = new DTBAdRequest();
            this.f21436c = dTBAdRequest;
            dTBAdRequest.setSizes(dTBAdSizeArr);
        } catch (Throwable unused) {
        }
    }

    public void a() {
        DTBAdRequest dTBAdRequest = this.f21436c;
        if (dTBAdRequest == null) {
            this.f21435b.onAdLoadFailed(null, this.f21434a);
        } else {
            dTBAdRequest.loadAd(this);
        }
    }

    public void onFailure(AdError adError) {
        this.f21435b.onAdLoadFailed(adError, this.f21434a);
    }

    public void onSuccess(DTBAdResponse dTBAdResponse) {
        this.f21435b.onAdResponseLoaded(dTBAdResponse, this.f21434a);
    }
}
