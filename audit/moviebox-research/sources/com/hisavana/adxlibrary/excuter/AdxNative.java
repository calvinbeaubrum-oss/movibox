package com.hisavana.adxlibrary.excuter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import r9.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdxNative extends BaseNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f41744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdNativeInfo f41745b;

    /* JADX INFO: compiled from: source.java */
    public class a extends s9.a {
        public a() {
        }

        @Override // s9.a
        public void d(TaNativeInfo taNativeInfo) {
            super.b();
            AdxNative.this.adClosed(AdxNative.this.a(taNativeInfo));
        }

        @Override // s9.a
        public void f(List<TaNativeInfo> list) {
            AdLogUtil.Log().d("AdxNative", "onAdLoaded multi");
            int i11 = 0;
            int i12 = 0;
            while (i11 < list.size()) {
                TAdNativeInfo tAdNativeInfoA = fn.a.a(list.get(i11), ((BaseNative) AdxNative.this).mAdt, AdxNative.this.getTtl(), AdxNative.this);
                int iFilter = AdxNative.this.filter(tAdNativeInfoA);
                if (iFilter == 0) {
                    ((BaseNative) AdxNative.this).mNatives.add(tAdNativeInfoA);
                } else {
                    AdUtil.release(tAdNativeInfoA);
                }
                i11++;
                i12 = iFilter;
            }
            AdxNative adxNative = AdxNative.this;
            List<TAdNativeInfo> listA = adxNative.a((List<TAdNativeInfo>) ((BaseNative) adxNative).mNatives);
            if (listA != null && !listA.isEmpty()) {
                AdxNative.this.b(list);
                AdxNative.this.adLoaded(listA);
                return;
            }
            AdxNative.this.adFailedToLoad(new TAdErrorCode(i12, "ad filter"));
            AdLogUtil.Log().w("AdxNative", "ad not pass filter check or no icon or image filter:" + i12);
        }

        @Override // s9.a
        public void k(TaErrorCode taErrorCode) {
            AdLogUtil.Log().w("AdxNative", "onAdLoaded error +" + taErrorCode.getErrorCode() + ":::" + taErrorCode.getErrorMessage());
            AdxNative.this.adFailedToLoad(new TAdErrorCode(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage()));
        }

        @Override // s9.a
        public void l(TaNativeInfo taNativeInfo) {
            TAdNativeInfo tAdNativeInfoA = AdxNative.this.a(taNativeInfo);
            if (tAdNativeInfoA instanceof AdNativeInfo) {
                AdxNative.this.adClicked((AdNativeInfo) tAdNativeInfoA);
            } else {
                AdxNative.this.adClicked(null);
            }
        }

        @Override // s9.a
        public void m(TaNativeInfo taNativeInfo) {
            super.g();
            TAdNativeInfo tAdNativeInfoA = AdxNative.this.a(taNativeInfo);
            if (tAdNativeInfoA instanceof AdNativeInfo) {
                AdxNative.this.adImpression((AdNativeInfo) tAdNativeInfoA);
            } else {
                AdxNative.this.adImpression(null);
            }
        }

        @Override // s9.a
        public void o() {
            AdxNative.this.adFailedToLoad(TAdErrorCode.ERROR_AD_REQUEST_TIME_OUT);
        }
    }

    public AdxNative(Context context, Network network, int i11) {
        super(context, network, i11);
    }

    public final TAdNativeInfo a(TaNativeInfo taNativeInfo) {
        List<TAdNativeInfo> list = this.mNatives;
        if (list != null && !list.isEmpty()) {
            for (TAdNativeInfo tAdNativeInfo : this.mNatives) {
                if (tAdNativeInfo != null && tAdNativeInfo.getNativeAdWrapper() != null && ((TaNativeInfo) tAdNativeInfo.getNativeAdWrapper().getNativeAd()) == taNativeInfo) {
                    return tAdNativeInfo;
                }
            }
        }
        return null;
    }

    public final List<TAdNativeInfo> a(List<TAdNativeInfo> list) {
        if (list == null || getAdType() != 6) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TAdNativeInfo tAdNativeInfo : list) {
            if (!TextUtils.isEmpty(tAdNativeInfo.getFilterSource()) && !arrayList2.contains(tAdNativeInfo.getFilterSource())) {
                arrayList2.add(tAdNativeInfo.getFilterSource());
                arrayList.add(tAdNativeInfo);
            }
        }
        return arrayList;
    }

    public final void b(List<TaNativeInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (TaNativeInfo taNativeInfo : list) {
            if (taNativeInfo != null) {
                Bundle bundle = new Bundle();
                bundle.putString(TrackingKey.AD_TITLE, taNativeInfo.getTitle());
                bundle.putString(TrackingKey.AD_URL, "");
                bundle.putString(TrackingKey.DESCRIPTION, taNativeInfo.getDescription());
                if (taNativeInfo.getImage() != null) {
                    bundle.putString("image_url", taNativeInfo.getImage().getImgUrl());
                }
                if (taNativeInfo.getIconImage() != null) {
                    bundle.putString("icon_url", taNativeInfo.getIconImage().getImgUrl());
                }
                bundle.putString("endcard_url", "");
                bundle.putString("app_name", "");
                bundle.putString("package_name", "");
                bundle.putString("download_url", "");
                HashMap map = new HashMap();
                for (String str : bundle.keySet()) {
                    String str2 = (String) bundle.get(str);
                    if (str2 != null) {
                        map.put(str, str2);
                    }
                }
                arrayList.add(map);
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(TrackingKey.NATIVE_INFO_LIST, GsonUtil.d(arrayList));
        setTrackingBundle(bundle2);
    }

    @Override // com.hisavana.common.base.BaseNative, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        b bVar = this.f41744a;
        if (bVar != null) {
            bVar.a();
            this.f41744a = null;
        }
        this.f41745b = null;
        AdLogUtil.Log().d("AdxNative", PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    public b getNativeAd() {
        return this.f41744a;
    }

    @Override // com.hisavana.common.base.BaseNative
    public void initNative() {
        if (this.mNetwork != null) {
            this.mNatives.clear();
            b bVar = new b(this.mNetwork.getCodeSeatId());
            this.f41744a = bVar;
            bVar.g(this.mAdCount);
            AdManager.f29117b = this.mNetwork.getApplicationId();
            a aVar = new a();
            this.f41744a.n(t9.a.a().a());
            this.f41744a.k(aVar);
            this.f41744a.m(this.mNetwork.getCodeSeatId());
        }
    }

    @Override // com.hisavana.common.base.BaseNative, com.hisavana.common.interfacz.ICacheAd
    public boolean isOfflineAd() {
        List<TAdNativeInfo> list = this.mNatives;
        return (list == null || list.isEmpty() || !this.mNatives.get(0).isOfflineAd()) ? false : true;
    }

    @Override // com.hisavana.common.base.BaseNative
    public void onNativeAdStartLoad() {
        String codeSeatId;
        b bVar = this.f41744a;
        if (bVar != null && bVar.d() != null) {
            t9.a aVarD = this.f41744a.d();
            aVarD.k(this.requestType);
            aVarD.l("hisa-" + this.mTriggerId);
            aVarD.j("hisa-" + this.mRequestId);
            aVarD.i(getSupportHisavanaFlag() >= 2);
            this.f41744a.n(aVarD);
            this.f41744a.i(this.isContainVulgarContent);
            this.f41744a.l(this.mAdt == 6);
            this.f41744a.h(this.mGameName, this.mGameScene, this.mExtInfo);
            this.f41744a.j(this.mCurrActivityFullscreen);
            this.f41744a.e();
        }
        AdLogUtil adLogUtilLog = AdLogUtil.Log();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("adx native load mPlacementId:");
        Network network = this.mNetwork;
        if (network != null) {
            codeSeatId = network.getCodeSeatId();
        } else {
            codeSeatId = " num:" + this.mAdCount;
        }
        sb2.append(codeSeatId);
        adLogUtilLog.d("AdxNative", sb2.toString());
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdNativeInfo adNativeInfo) {
        this.f41745b = adNativeInfo;
        logTrigerShow(adNativeInfo);
        if (viewGroup == null || this.f41744a == null) {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e("AdxNative", "registerViewForInteraction error, mNativeAd is null");
            return;
        }
        unregisterView(adNativeInfo);
        try {
            TaNativeInfo taNativeInfo = (TaNativeInfo) adNativeInfo.getNativeAdWrapper().getNativeAd();
            double secondPrice = adNativeInfo.getSecondPrice();
            if (secondPrice != 0.0d) {
                taNativeInfo.setSecondPrice(secondPrice);
            }
            this.f41744a.f(viewGroup, list, taNativeInfo);
        } catch (Exception e11) {
            AdLogUtil.Log().e("AdxNative", Log.getStackTraceString(e11));
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, e11.getMessage()));
        }
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void unregisterView(AdNativeInfo adNativeInfo) {
    }
}
