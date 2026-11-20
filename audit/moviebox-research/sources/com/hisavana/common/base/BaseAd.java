package com.hisavana.common.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import ca.d;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.RunTimer;
import com.cloud.sdk.commonutil.util.c;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TInnerAdRequestBody;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.Iad;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.hisavana.common.interfacz.WrapTAdAllianceListener;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.manager.RequestingAdManager;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import da.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseAd implements Iad {
    private int adSource;
    private TAdditionalListener additionalListener;
    protected boolean isContainVulgarContent;
    protected boolean isOfflineAd;
    private boolean isPreload;
    protected String mAdUnit;
    protected WeakReference<Context> mContext;
    protected boolean mCurrActivityFullscreen;
    protected Map<String, Object> mExtInfo;
    protected String mGameName;
    protected String mGameScene;
    private long mImpressionTime;
    private int mLoadStatus;
    private long mLoadedTime;
    protected final Network mNetwork;
    private double maxPrice;
    private long requestTime;
    protected int requestType;
    protected RunTimer runTimer;
    private String sceneId;
    private String sceneToken;
    public double secondPrice;
    protected long startTime;
    private int ttl;
    private boolean isTimeOut = false;
    private int supportHisavanaFlag = 0;
    protected int mAdCount = 1;
    private final String TAG = "BaseAd";
    private double price = 0.0d;
    protected boolean isLoaded = false;
    protected final List<WrapTAdAllianceListener> mListenerList = new CopyOnWriteArrayList();
    private int mRequestRound = -1;
    public final Bundle mBundle = new Bundle();
    protected String mRequestId = null;
    protected String mTriggerId = null;
    protected String mShowId = null;
    private boolean isDestroyed = false;
    protected RunTimer.a timeOutCallback = new RunTimer.a() { // from class: com.hisavana.common.base.BaseAd.1
        @Override // com.cloud.sdk.commonutil.util.RunTimer.a
        public void isTimeOut() {
            AdLogUtil.Log().d("BaseAd", "Load ad is time out" + BaseAd.this.getLogString());
            BaseAd.this.onTimeOut();
        }
    };

    public BaseAd(Context context, Network network) {
        this.mContext = new WeakReference<>(context);
        Preconditions.b(network);
        this.mNetwork = network;
    }

    private void adFailedToLoadTemp(TAdErrorCode tAdErrorCode) {
        RequestingAdManager.getInstance().removeRequest(this);
        AdLogUtil adLogUtilLog = AdLogUtil.Log();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ad request has been destroyed or loaded,isLoaded = ");
        sb2.append(this.isLoaded);
        sb2.append(",isDestroyed = ");
        sb2.append(this.isDestroyed);
        sb2.append("( triggerId is ");
        sb2.append(this.mTriggerId);
        sb2.append(", code seat id is ");
        Network network = this.mNetwork;
        sb2.append(network == null ? "" : network.getCodeSeatId());
        sb2.append(" )");
        adLogUtilLog.d("BaseAd", sb2.toString());
        if (this.isLoaded) {
            return;
        }
        this.isLoaded = true;
        Bundle bundle = new Bundle();
        int i11 = TAdErrorCode.CODE_AD_REQUEST_FAILED;
        int errorCode = tAdErrorCode != null ? tAdErrorCode.getErrorCode() : TAdErrorCode.CODE_AD_REQUEST_FAILED;
        if (errorCode != 0) {
            i11 = errorCode;
        }
        bundle.putInt(TrackingKey.ERROR_CODE, i11);
        bundle.putString(TrackingKey.ERROR_MESSAGE, tAdErrorCode == null ? "null" : TAdErrorCode.simpleErrorMessage(tAdErrorCode.getErrorMessage()));
        bundle.putInt(TrackingKey.REQUEST_NUM, this.mAdCount);
        adReturnTracking(bundle);
        errorCallBack(tAdErrorCode);
        if (supportTimer()) {
            stopTimer();
        }
        destroyAd();
    }

    private void adLoadedTemp() {
        AdLogUtil adLogUtilLog = AdLogUtil.Log();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ad request has been destroyed or loaded,isLoaded = ");
        sb2.append(this.isLoaded);
        sb2.append(",isDestroyed = ");
        sb2.append(this.isDestroyed);
        sb2.append("( triggerId is ");
        sb2.append(this.mTriggerId);
        sb2.append(", code seat id is ");
        Network network = this.mNetwork;
        sb2.append(network == null ? "" : network.getCodeSeatId());
        sb2.append(" )");
        adLogUtilLog.d("BaseAd", sb2.toString());
        RequestingAdManager.getInstance().removeRequest(this);
        if (this.isLoaded) {
            return;
        }
        if (this.mNetwork != null) {
            MediaLogUtil.d("BaseAd", "loadSuccess adSource " + this.mNetwork.getSource() + " id " + this.mNetwork.getCodeSeatId() + " " + getLogString());
        }
        ArrayList arrayList = new ArrayList(this.mListenerList.size());
        arrayList.addAll(this.mListenerList);
        AdCache cache = AdCacheManager.getCache(getAdType());
        if (cache != null) {
            cache.addCache(this.mAdUnit, this);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(TrackingKey.ERROR_CODE, 0);
        bundle.putInt(TrackingKey.REQUEST_NUM, this.mAdCount);
        bundle.putInt(TrackingKey.IS_INTERNAL_AD, isInternalAd() ? 1 : 0);
        adReturnTracking(bundle);
        this.isLoaded = true;
        this.mLoadedTime = System.currentTimeMillis();
        loadedCallBack(arrayList);
        if (supportTimer()) {
            stopTimer();
        }
    }

    private void adLoadedTemp(List<TAdNativeInfo> list) {
        AdLogUtil adLogUtilLog = AdLogUtil.Log();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ad request has been destroyed or loaded,isLoaded = ");
        sb2.append(this.isLoaded);
        sb2.append(",isDestroyed = ");
        sb2.append(this.isDestroyed);
        sb2.append("( triggerId is ");
        sb2.append(this.mTriggerId);
        sb2.append(", code seat id is ");
        Network network = this.mNetwork;
        sb2.append(network == null ? "" : network.getCodeSeatId());
        sb2.append(" )");
        adLogUtilLog.d("BaseAd", sb2.toString());
        RequestingAdManager.getInstance().removeRequest(this);
        if (this.isLoaded) {
            return;
        }
        if (this.mNetwork != null) {
            MediaLogUtil.d("BaseAd", "loadSuccess adSource " + this.mNetwork.getSource() + " id " + this.mNetwork.getCodeSeatId() + " " + getLogString());
        }
        ArrayList arrayList = new ArrayList(this.mListenerList.size());
        arrayList.addAll(this.mListenerList);
        AdCache cache = AdCacheManager.getCache(getAdType());
        if (list != null && list.size() > 0 && cache != null) {
            cache.addCaches(this.mAdUnit, list);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(TrackingKey.ERROR_CODE, 0);
        if (list != null && list.size() > 0) {
            TAdNativeInfo tAdNativeInfo = list.get(0);
            if (tAdNativeInfo.getEcpmPrice() > 0.0d) {
                this.price = tAdNativeInfo.getEcpmPrice();
            }
            bundle.putInt(TrackingKey.IS_INTERNAL_AD, tAdNativeInfo.isInternalAd() ? 1 : 0);
        }
        adReturnTracking(bundle);
        this.isLoaded = true;
        this.mLoadedTime = System.currentTimeMillis();
        loadedCallBack(arrayList, list);
        if (supportTimer()) {
            stopTimer();
        }
    }

    private void addToContextParam(String str, Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Integer) {
            this.mBundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            this.mBundle.putString(str, (String) obj);
        } else if (obj instanceof Long) {
            this.mBundle.putLong(str, ((Long) obj).longValue());
        }
    }

    private void appendContextParam(Bundle bundle) {
        bundle.putString(TrackingKey.TRIGGER_ID, this.mBundle.getString(TrackingKey.TRIGGER_ID));
        bundle.putLong(TrackingKey.TRIGGER_TS, this.mBundle.getLong(TrackingKey.TRIGGER_TS));
        bundle.putInt("ad_type", this.mBundle.getInt("ad_type"));
        bundle.putString(TrackingKey.CLD_APP_ID, this.mBundle.getString(TrackingKey.CLD_APP_ID));
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.mBundle.getString(TrackingKey.CLD_CODE_SEAT_ID));
        bundle.putInt(TrackingKey.PLATFORM, this.mBundle.getInt(TrackingKey.PLATFORM));
        bundle.putString("app_id", this.mBundle.getString("app_id"));
        bundle.putString(TrackingKey.CODE_SEAT_ID, this.mBundle.getString(TrackingKey.CODE_SEAT_ID));
        bundle.putDouble(TrackingKey.BIDDING_PRICE, this.mBundle.getDouble(TrackingKey.BIDDING_PRICE));
        bundle.putInt(TrackingKey.PRIORITY, this.mBundle.getInt(TrackingKey.PRIORITY));
        bundle.putInt(TrackingKey.AD_COUNT, this.mBundle.getInt(TrackingKey.AD_COUNT));
        bundle.putInt(TrackingKey.IS_RETREATAD, this.mBundle.getInt(TrackingKey.IS_RETREATAD));
        bundle.putInt(TrackingKey.IS_DEFAULT_AD, 0);
        bundle.putLong(TrackingKey.REQUEST_TS, this.mBundle.getLong(TrackingKey.REQUEST_TS));
        bundle.putInt(TrackingKey.REQUEST_TIME, this.mBundle.getInt(TrackingKey.REQUEST_TIME));
        bundle.putString(TrackingKey.REQUEST_ID, this.mBundle.getString(TrackingKey.REQUEST_ID));
        bundle.putLong(TrackingKey.RETURN_TS, this.mBundle.getLong(TrackingKey.RETURN_TS));
        bundle.putInt(TrackingKey.RETURN_TIME, this.mBundle.getInt(TrackingKey.RETURN_TIME));
        bundle.putInt(TrackingKey.REQUEST_TYPE, this.mBundle.getInt(TrackingKey.REQUEST_TYPE));
    }

    private void errorCallBack(TAdErrorCode tAdErrorCode) {
        for (WrapTAdAllianceListener wrapTAdAllianceListener : this.mListenerList) {
            if (wrapTAdAllianceListener != null) {
                wrapTAdAllianceListener.onError(tAdErrorCode);
            }
        }
    }

    private AdditionalInfo getBaseAdditionalInfo() {
        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setPlacementId(this.mAdUnit);
        additionalInfo.setMcc(d.d());
        additionalInfo.setTriggerId(this.mBundle.getString(TrackingKey.TRIGGER_ID));
        additionalInfo.setTrafficGroupId(this.mBundle.getString(TrackingKey.TRAFFIC_GROUP_ID));
        additionalInfo.setExperimentGroupId(this.mBundle.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        additionalInfo.setSdkVersion(d.l());
        return additionalInfo;
    }

    private AdditionalInfo getShowAdditionalInfo(AdNativeInfo adNativeInfo) {
        AdditionalInfo baseAdditionalInfo = getBaseAdditionalInfo();
        Network network = this.mNetwork;
        if (network != null) {
            baseAdditionalInfo.setSource(network.getSource());
            baseAdditionalInfo.setApplicationId(this.mNetwork.getApplicationId());
            baseAdditionalInfo.setApplicationKey(this.mNetwork.getApplicationKey());
            baseAdditionalInfo.setCodeSeatId(this.mNetwork.getCodeSeatId());
            baseAdditionalInfo.setECPM(Double.valueOf(this.mBundle.getDouble(TrackingKey.BIDDING_PRICE)));
            baseAdditionalInfo.setPrecision(isWaterFallExecutor() ? "estimated" : "exact");
            baseAdditionalInfo.setCurrency("USD");
            baseAdditionalInfo.setBidding(Boolean.valueOf(AdUtil.isBiddingNetwork(this.mNetwork.getSource().intValue())));
            baseAdditionalInfo.setMediatorSource(this.mNetwork.getMediatorSource());
        }
        baseAdditionalInfo.setInternalAd(Boolean.valueOf(adNativeInfo == null ? isInternalAd() : adNativeInfo.isInternalAd()));
        return baseAdditionalInfo;
    }

    private boolean isWaterFallExecutor() {
        return AdUtil.isWaterFall(this.adSource);
    }

    private void loadedCallBack(List<WrapTAdAllianceListener> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (WrapTAdAllianceListener wrapTAdAllianceListener : list) {
            if (wrapTAdAllianceListener != null) {
                wrapTAdAllianceListener.onLoad();
            }
        }
    }

    private void loadedCallBack(List<WrapTAdAllianceListener> list, List<TAdNativeInfo> list2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (WrapTAdAllianceListener wrapTAdAllianceListener : list) {
            if (wrapTAdAllianceListener != null) {
                wrapTAdAllianceListener.onLoad(list2);
            }
        }
    }

    private void saveShowedValue(long j11) {
        if (this.mNetwork == null || j11 <= 0) {
            return;
        }
        a.d().o(this.mNetwork.getCodeSeatId(), j11);
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> codeSeatId: " + this.mNetwork.getCodeSeatId() + " | adType : " + this.mNetwork.getAdt() + " | valueMicros: " + j11);
    }

    public void adClicked(AdNativeInfo adNativeInfo) {
        logClick(adNativeInfo);
        WrapTAdAllianceListener wrapTAdAllianceListener = this.mListenerList.isEmpty() ? null : this.mListenerList.get(0);
        if (wrapTAdAllianceListener != null) {
            wrapTAdAllianceListener.onNativeFeedClicked(getAdSource(), adNativeInfo, getClickAdditionalInfo(adNativeInfo));
        }
    }

    public void adClosed() {
        logClose(null);
        WrapTAdAllianceListener wrapTAdAllianceListener = this.mListenerList.isEmpty() ? null : this.mListenerList.get(0);
        if (wrapTAdAllianceListener != null) {
            wrapTAdAllianceListener.onClosed(getAdSource());
        }
    }

    public void adClosed(TAdNativeInfo tAdNativeInfo) {
        logClose(tAdNativeInfo);
        WrapTAdAllianceListener wrapTAdAllianceListener = this.mListenerList.isEmpty() ? null : this.mListenerList.get(0);
        if (wrapTAdAllianceListener != null) {
            wrapTAdAllianceListener.onClosed(tAdNativeInfo);
        }
    }

    public void adFailedToLoad(TAdErrorCode tAdErrorCode) {
        adFailedToLoadTemp(tAdErrorCode);
    }

    public void adImpression(AdNativeInfo adNativeInfo) {
        logImpression(adNativeInfo, true, TAdErrorCode.SUCCESS_MESSAGE);
        this.mImpressionTime = System.currentTimeMillis();
        WrapTAdAllianceListener wrapTAdAllianceListener = this.mListenerList.isEmpty() ? null : this.mListenerList.get(0);
        if (wrapTAdAllianceListener != null) {
            wrapTAdAllianceListener.onNativeFeedShow(getAdSource(), adNativeInfo, getShowAdditionalInfo(adNativeInfo));
        }
    }

    public void adLoaded() {
        adLoadedTemp();
    }

    public void adLoaded(List<TAdNativeInfo> list) {
        adLoadedTemp(list);
    }

    public void adReturnTracking(Bundle bundle) {
        Bundle bundle2;
        if (bundle == null || (bundle2 = this.mBundle) == null) {
            return;
        }
        if (bundle2.containsKey(TrackingKey.CLD_CONFIGURE_ID)) {
            this.mBundle.remove(TrackingKey.CLD_CONFIGURE_ID);
        }
        bundle.putString(TrackingKey.TRIGGER_ID, this.mBundle.getString(TrackingKey.TRIGGER_ID));
        bundle.putLong(TrackingKey.TRIGGER_TS, this.mBundle.getLong(TrackingKey.TRIGGER_TS));
        bundle.putLong(TrackingKey.REQUEST_TS, this.mBundle.getLong(TrackingKey.REQUEST_TS));
        bundle.putInt(TrackingKey.REQUEST_TIME, (int) (this.mBundle.getLong(TrackingKey.REQUEST_TS) - this.mBundle.getLong(TrackingKey.TRIGGER_TS)));
        bundle.putString(TrackingKey.REQUEST_ID, this.mBundle.getString(TrackingKey.REQUEST_ID));
        bundle.putLong(TrackingKey.RETURN_TS, System.currentTimeMillis());
        bundle.putInt(TrackingKey.RETURN_TIME, (int) (System.currentTimeMillis() - this.mBundle.getLong(TrackingKey.REQUEST_TS)));
        this.mBundle.putLong(TrackingKey.RETURN_TS, System.currentTimeMillis());
        this.mBundle.putInt(TrackingKey.RETURN_TIME, (int) (System.currentTimeMillis() - this.mBundle.getLong(TrackingKey.REQUEST_TS)));
        bundle.putInt("ad_type", this.mBundle.getInt("ad_type"));
        bundle.putString(TrackingKey.CLD_APP_ID, this.mBundle.getString(TrackingKey.CLD_APP_ID));
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.mBundle.getString(TrackingKey.CLD_CODE_SEAT_ID));
        bundle.putInt(TrackingKey.PLATFORM, this.mBundle.getInt(TrackingKey.PLATFORM));
        bundle.putString("app_id", this.mBundle.getString("app_id"));
        bundle.putString(TrackingKey.CODE_SEAT_ID, this.mBundle.getString(TrackingKey.CODE_SEAT_ID));
        bundle.putDouble(TrackingKey.BIDDING_PRICE, AdUtil.isBiddingNetwork(this.adSource) ? this.price : this.mBundle.getDouble(TrackingKey.BIDDING_PRICE));
        RecordTestInfo.record("adReturnTracking code_seat_id:" + this.mBundle.getString(TrackingKey.CODE_SEAT_ID) + ",bidding_price:" + bundle.getDouble(TrackingKey.BIDDING_PRICE));
        bundle.putInt(TrackingKey.PRIORITY, this.mBundle.getInt(TrackingKey.PRIORITY));
        bundle.putInt(TrackingKey.AD_COUNT, this.mBundle.getInt(TrackingKey.AD_COUNT));
        bundle.putInt(TrackingKey.IS_RETREATAD, this.mBundle.getInt(TrackingKey.IS_RETREATAD));
        bundle.putInt(TrackingKey.IS_DEFAULT_AD, 0);
        bundle.putInt(TrackingKey.REQUEST_TYPE, this.mBundle.getInt(TrackingKey.REQUEST_TYPE));
        bundle.putInt(TrackingKey.IS_PRE_TRIGGER, this.mBundle.getInt(TrackingKey.IS_PRE_TRIGGER));
        bundle.putString(TrackingKey.AD_TITLE, this.mBundle.getString(TrackingKey.AD_TITLE));
        bundle.putString(TrackingKey.AD_URL, this.mBundle.getString(TrackingKey.AD_URL));
        bundle.putString(TrackingKey.DESCRIPTION, this.mBundle.getString(TrackingKey.DESCRIPTION));
        bundle.putString("image_url", this.mBundle.getString("image_url"));
        bundle.putString("icon_url", this.mBundle.getString("icon_url"));
        bundle.putString("endcard_url", this.mBundle.getString("endcard_url"));
        bundle.putString("app_name", this.mBundle.getString("app_name"));
        bundle.putString("package_name", this.mBundle.getString("package_name"));
        bundle.putString(TrackingKey.NATIVE_INFO_LIST, this.mBundle.getString(TrackingKey.NATIVE_INFO_LIST));
        bundle.putString("download_url", this.mBundle.getString("download_url"));
        bundle.putInt(TrackingKey.IS_TIMEOUT, this.isTimeOut ? 1 : 0);
        bundle.putInt(TrackingKey.REQUEST_NUM, this.mAdCount);
        bundle.putLong(TrackingKey.IS_OFFLINE_AD, isOfflineAd() ? 1L : 0L);
        bundle.putLong(TrackingKey.AD_TRIGGER_STATUS, this.mBundle.getInt(TrackingKey.AD_TRIGGER_STATUS));
        bundle.putInt(TrackingKey.REQUEST_ROUND, this.mBundle.getInt(TrackingKey.REQUEST_ROUND));
        bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, this.mBundle.getString(TrackingKey.TRAFFIC_GROUP_ID));
        bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.mBundle.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        bundle.putInt(TrackingKey.OPTIMIZE_STATUS, this.mBundle.getInt(TrackingKey.OPTIMIZE_STATUS));
        bundle.putInt(TrackingKey.PRIORITY_CODE, this.mBundle.getInt(TrackingKey.PRIORITY_CODE));
        Network network = this.mNetwork;
        bundle.putString(TrackingKey.MEDIATOR_SOURCE, network != null ? network.getMediatorSource() : "");
        Network network2 = this.mNetwork;
        bundle.putDouble(TrackingKey.PRICE_COEFFICIENT, network2 != null ? network2.getShowPriceCoefficient().doubleValue() : 0.0d);
        TrackingManager.trackingAdReturn(bundle);
    }

    public void adTrackingRequest() {
        RecordTestInfo.record("adTrackingRequest code_seat_id:" + getPlacementId() + ",bidding_price:" + this.mBundle.getDouble(TrackingKey.BIDDING_PRICE));
        this.mBundle.putInt(TrackingKey.AD_COUNT, this.mAdCount);
        this.mBundle.putInt(TrackingKey.IS_RETREATAD, 0);
        this.mBundle.putInt(TrackingKey.IS_DEFAULT_AD, 0);
        if (TextUtils.isEmpty(this.mRequestId)) {
            this.mRequestId = DeviceUtil.n();
        }
        this.mTriggerId = this.mBundle.getString(TrackingKey.TRIGGER_ID);
        this.mBundle.putString(TrackingKey.REQUEST_ID, this.mRequestId);
        this.mBundle.putString(TrackingKey.CLD_CONFIGURE_ID, a.d().i("cloudControlVersion"));
        this.mBundle.putInt(TrackingKey.REQUEST_NUM, this.mAdCount);
        this.mBundle.putInt(TrackingKey.REQUEST_ROUND, this.mRequestRound);
        Bundle bundle = this.mBundle;
        Network network = this.mNetwork;
        bundle.putDouble(TrackingKey.PRICE_COEFFICIENT, network != null ? network.getShowPriceCoefficient().doubleValue() : 0.0d);
        this.mBundle.putInt(TrackingKey.IS_PRELOAD, this.isPreload ? 1 : 0);
        TrackingManager.trackingAdRequest(this.mBundle);
    }

    @Override // com.hisavana.common.interfacz.Iad
    public void addRequestBody(TInnerAdRequestBody tInnerAdRequestBody) {
        if (tInnerAdRequestBody != null) {
            this.mListenerList.add(tInnerAdRequestBody.getAdListener());
            if (this.mListenerList.size() > 2) {
                this.mListenerList.remove(0);
            }
        }
    }

    public void admobShowPriceTracking(float f11, String str, int i11) {
        Bundle bundle = new Bundle();
        bundle.putString(TrackingKey.TRIGGER_ID, this.mBundle.getString(TrackingKey.TRIGGER_ID));
        bundle.putString(TrackingKey.REQUEST_ID, this.mBundle.getString(TrackingKey.REQUEST_ID));
        bundle.putString(TrackingKey.CLD_APP_ID, this.mBundle.getString(TrackingKey.CLD_APP_ID));
        bundle.putString("app_id", this.mBundle.getString("app_id"));
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.mBundle.getString(TrackingKey.CLD_CODE_SEAT_ID));
        bundle.putString(TrackingKey.CODE_SEAT_ID, this.mBundle.getString(TrackingKey.CODE_SEAT_ID));
        bundle.putFloat(TrackingKey.AD_VALUE, f11);
        bundle.putString(TrackingKey.ADVALUE_CURRENCY_CODE, str);
        bundle.putInt(TrackingKey.AD_VALUE_TYPE, i11);
        bundle.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
        TrackingManager.trackingAdmobShowPrice(bundle);
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        this.isDestroyed = true;
        detachContext();
        stopTimer();
        if (this.isLoaded) {
            return;
        }
        this.isLoaded = true;
        Bundle bundle = new Bundle();
        bundle.putInt(TrackingKey.ERROR_CODE, TAdErrorCode.CODE_REQUEST_OBJECT_IS_DESTROYED);
        bundle.putString(TrackingKey.ERROR_MESSAGE, TAdErrorCode.ERROR_REQUEST_OBJECT_IS_DESTROYED.getErrorMessage());
        bundle.putInt(TrackingKey.REQUEST_NUM, this.mAdCount);
        adReturnTracking(bundle);
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void detachContext() {
        this.mListenerList.clear();
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public int getAdSource() {
        return this.adSource;
    }

    @Override // com.hisavana.common.interfacz.Iad
    public String getAdUnit() {
        return this.mAdUnit;
    }

    public AdditionalInfo getClickAdditionalInfo(AdNativeInfo adNativeInfo) {
        AdditionalInfo baseAdditionalInfo = getBaseAdditionalInfo();
        Network network = this.mNetwork;
        if (network != null) {
            baseAdditionalInfo.setSource(network.getSource());
            baseAdditionalInfo.setApplicationId(this.mNetwork.getApplicationId());
            baseAdditionalInfo.setApplicationKey(this.mNetwork.getApplicationKey());
            baseAdditionalInfo.setCodeSeatId(this.mNetwork.getCodeSeatId());
            baseAdditionalInfo.setECPM(Double.valueOf(this.mBundle.getDouble(TrackingKey.BIDDING_PRICE)));
            baseAdditionalInfo.setPrecision(isWaterFallExecutor() ? "estimated" : "exact");
            baseAdditionalInfo.setCurrency("USD");
            baseAdditionalInfo.setBidding(Boolean.valueOf(AdUtil.isBiddingNetwork(this.mNetwork.getSource().intValue())));
            baseAdditionalInfo.setMediatorSource(this.mNetwork.getMediatorSource());
        }
        baseAdditionalInfo.setInternalAd(Boolean.valueOf(adNativeInfo == null ? isInternalAd() : adNativeInfo.isInternalAd()));
        return baseAdditionalInfo;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public double getEcpmPrice() {
        return this.price;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public String getExt() {
        return "";
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public String getFilterSource() {
        return "";
    }

    @Override // com.hisavana.common.interfacz.Iad
    public int getLoadStatus() {
        return this.mLoadStatus;
    }

    public String getLogString() {
        return "----- class name = " + getClass().getSimpleName() + " ----- mAdUnit = " + this.mAdUnit;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public Network getNetwork() {
        return this.mNetwork;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public String getPlacementId() {
        return this.mNetwork.getCodeSeatId();
    }

    @Override // com.hisavana.common.interfacz.Iad
    public long getRequestTime() {
        return this.requestTime;
    }

    public int getSupportHisavanaFlag() {
        return this.supportHisavanaFlag;
    }

    public int getTimeOutTime() {
        return ComConstants.AD_TIMEOUT_MILLIS;
    }

    public int getTtl() {
        return this.ttl;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public long getValidTimeLimit() {
        int i11 = this.ttl;
        if (i11 <= 0) {
            return Long.MAX_VALUE;
        }
        return (((long) i11) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) - Math.abs(System.currentTimeMillis() - this.startTime);
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isAdxAd() {
        return false;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isEwAd() {
        return false;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isExpired() {
        return getValidTimeLimit() <= 0;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isIconAd() {
        Network network = this.mNetwork;
        return network != null && network.getAdt() == 6;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isInternalAd() {
        return false;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public boolean isMatchVulgarBrand() {
        return false;
    }

    @Override // com.hisavana.common.interfacz.Iad
    public boolean isSupportRtBidding() {
        return false;
    }

    public boolean isSupportStopRequest() {
        return false;
    }

    @Override // com.hisavana.common.interfacz.Iad
    public void loadAd() {
        this.mRequestId = DeviceUtil.n();
        this.startTime = System.currentTimeMillis();
        if (supportTimer()) {
            startTimer();
        }
        adTrackingRequest();
        if (this.mNetwork != null) {
            MediaLogUtil.d("BaseAd", "loadAd adSource " + this.mNetwork.getSource() + " id " + this.mNetwork.getCodeSeatId() + " " + getLogString());
        }
        if (TextUtils.isEmpty(this.mAdUnit)) {
            return;
        }
        RequestingAdManager.getInstance().addRequest(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void logClick(TAdNativeInfo tAdNativeInfo) {
        Bundle bundle = new Bundle();
        appendContextParam(bundle);
        bundle.putInt(TrackingKey.REQUEST_TIME, this.mBundle.getInt(TrackingKey.REQUEST_TIME));
        bundle.putLong(TrackingKey.RETURN_TS, this.mBundle.getLong(TrackingKey.RETURN_TS));
        bundle.putInt(TrackingKey.RETURN_TIME, this.mBundle.getInt(TrackingKey.RETURN_TIME));
        bundle.putLong(TrackingKey.SHOW_TS, this.mBundle.getLong(TrackingKey.SHOW_TS));
        bundle.putLong(TrackingKey.SHOW_TIME, this.mBundle.getLong(TrackingKey.SHOW_TIME));
        bundle.putLong(TrackingKey.CLICK_TS, System.currentTimeMillis());
        bundle.putInt(TrackingKey.CLICK_TIME, (int) (System.currentTimeMillis() - this.mImpressionTime));
        bundle.putString(TrackingKey.AD_TITLE, this.mBundle.getString(TrackingKey.AD_TITLE));
        bundle.putString(TrackingKey.AD_URL, this.mBundle.getString(TrackingKey.AD_URL));
        bundle.putInt(TrackingKey.FILLING_SOURCE, this.mBundle.getInt(TrackingKey.FILLING_SOURCE));
        bundle.putString(TrackingKey.DESCRIPTION, this.mBundle.getString(TrackingKey.DESCRIPTION));
        bundle.putString("image_url", this.mBundle.getString("image_url"));
        bundle.putString("icon_url", this.mBundle.getString("icon_url"));
        bundle.putString("endcard_url", this.mBundle.getString("app_name"));
        bundle.putString("app_name", this.mBundle.getString("app_name"));
        bundle.putString("package_name", this.mBundle.getString("package_name"));
        bundle.putString("download_url", this.mBundle.getString("download_url"));
        bundle.putInt(TrackingKey.SLOT_HEIGHT, this.mBundle.getInt(TrackingKey.SLOT_HEIGHT));
        bundle.putInt(TrackingKey.SLOT_WIDTH, this.mBundle.getInt(TrackingKey.SLOT_WIDTH));
        bundle.putInt(TrackingKey.IS_PRE_TRIGGER, this.mBundle.getInt(TrackingKey.IS_PRE_TRIGGER));
        bundle.putInt(TrackingKey.REQUEST_TYPE, this.mBundle.getInt(TrackingKey.REQUEST_TYPE));
        bundle.putString(TrackingKey.REQUEST_ID, this.mBundle.getString(TrackingKey.REQUEST_ID));
        bundle.putInt(TrackingKey.CLICK_X, 0);
        bundle.putInt(TrackingKey.CLICK_Y, 0);
        bundle.putInt(TrackingKey.IS_EXPIRED, isExpired() ? 1 : 0);
        bundle.putInt(TrackingKey.REQUEST_NUM, this.mBundle.getInt(TrackingKey.REQUEST_NUM));
        bundle.putInt(TrackingKey.AD_TRIGGER_STATUS, this.mBundle.getInt(TrackingKey.AD_TRIGGER_STATUS));
        bundle.putInt(TrackingKey.IS_OFFLINE_AD, isOfflineAd() ? 1 : 0);
        bundle.putInt(TrackingKey.FILLING_AD_TYPE, this.mBundle.getInt(TrackingKey.FILLING_AD_TYPE));
        bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, this.mBundle.getString(TrackingKey.TRAFFIC_GROUP_ID));
        bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.mBundle.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        bundle.putInt(TrackingKey.PRIORITY_CODE, this.mBundle.getInt(TrackingKey.PRIORITY_CODE));
        bundle.putDouble(TrackingKey.MAX_PRICE, this.mBundle.getDouble(TrackingKey.MAX_PRICE));
        bundle.putString(TrackingKey.SCENE_ID, this.sceneId);
        Network network = this.mNetwork;
        bundle.putString(TrackingKey.MEDIATOR_SOURCE, network != null ? network.getMediatorSource() : "");
        Network network2 = this.mNetwork;
        bundle.putDouble(TrackingKey.PRICE_COEFFICIENT, network2 != null ? network2.getShowPriceCoefficient().doubleValue() : 0.0d);
        bundle.putInt(TrackingKey.IS_INTERNAL_AD, tAdNativeInfo == null ? isInternalAd() : tAdNativeInfo.isInternalAd());
        String str = this.mGameName;
        if (str == null) {
            str = "";
        }
        bundle.putString(TrackingKey.GAME_NAME, str);
        String str2 = this.mGameScene;
        bundle.putString(TrackingKey.GAME_SCENE, str2 != null ? str2 : "");
        TrackingManager.trackingAdClick(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void logClose(TAdNativeInfo tAdNativeInfo) {
        Bundle bundle = new Bundle();
        appendContextParam(bundle);
        bundle.putInt(TrackingKey.REQUEST_TIME, this.mBundle.getInt(TrackingKey.REQUEST_TIME));
        bundle.putLong(TrackingKey.RETURN_TS, this.mBundle.getLong(TrackingKey.RETURN_TS));
        bundle.putInt(TrackingKey.RETURN_TIME, this.mBundle.getInt(TrackingKey.RETURN_TIME));
        bundle.putLong(TrackingKey.SHOW_TS, this.mBundle.getLong(TrackingKey.SHOW_TS));
        bundle.putLong(TrackingKey.SHOW_TIME, this.mBundle.getLong(TrackingKey.SHOW_TIME));
        bundle.putLong(TrackingKey.CLICK_TS, System.currentTimeMillis());
        bundle.putInt(TrackingKey.CLICK_TIME, (int) (System.currentTimeMillis() - this.mImpressionTime));
        bundle.putString(TrackingKey.AD_TITLE, this.mBundle.getString(TrackingKey.AD_TITLE));
        bundle.putString(TrackingKey.AD_URL, this.mBundle.getString(TrackingKey.AD_URL));
        bundle.putInt(TrackingKey.FILLING_SOURCE, this.mBundle.getInt(TrackingKey.FILLING_SOURCE));
        bundle.putString(TrackingKey.DESCRIPTION, this.mBundle.getString(TrackingKey.DESCRIPTION));
        bundle.putString("image_url", this.mBundle.getString("image_url"));
        bundle.putString("icon_url", this.mBundle.getString("icon_url"));
        bundle.putString("endcard_url", this.mBundle.getString("endcard_url"));
        bundle.putString("app_name", this.mBundle.getString("app_name"));
        bundle.putString("package_name", this.mBundle.getString("package_name"));
        bundle.putString("download_url", this.mBundle.getString("download_url"));
        bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, this.mBundle.getString(TrackingKey.TRAFFIC_GROUP_ID));
        bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.mBundle.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        bundle.putInt(TrackingKey.SLOT_HEIGHT, 0);
        bundle.putInt(TrackingKey.SLOT_WIDTH, 0);
        bundle.putInt(TrackingKey.CLICK_X, 0);
        bundle.putInt(TrackingKey.CLICK_Y, 0);
        bundle.putString(TrackingKey.SCENE_ID, this.sceneId);
        Network network = this.mNetwork;
        bundle.putString(TrackingKey.MEDIATOR_SOURCE, network != null ? network.getMediatorSource() : "");
        Network network2 = this.mNetwork;
        bundle.putDouble(TrackingKey.PRICE_COEFFICIENT, network2 != null ? network2.getShowPriceCoefficient().doubleValue() : 0.0d);
        bundle.putInt(TrackingKey.IS_INTERNAL_AD, tAdNativeInfo == null ? isInternalAd() : tAdNativeInfo.isInternalAd());
        String str = this.mGameName;
        if (str == null) {
            str = "";
        }
        bundle.putString(TrackingKey.GAME_NAME, str);
        String str2 = this.mGameScene;
        bundle.putString(TrackingKey.GAME_SCENE, str2 != null ? str2 : "");
        TrackingManager.trackingAdClose(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void logImpression(TAdNativeInfo tAdNativeInfo, boolean z11, TAdErrorCode tAdErrorCode) {
        Bundle bundle = new Bundle();
        appendContextParam(bundle);
        bundle.putLong(TrackingKey.SHOW_TS, System.currentTimeMillis());
        bundle.putLong(TrackingKey.SHOW_TIME, System.currentTimeMillis() - this.mLoadedTime);
        bundle.putString(TrackingKey.AD_TITLE, this.mBundle.getString(TrackingKey.AD_TITLE));
        bundle.putString(TrackingKey.AD_URL, this.mBundle.getString(TrackingKey.AD_URL));
        bundle.putInt(TrackingKey.FILLING_SOURCE, this.mBundle.getInt(TrackingKey.FILLING_SOURCE));
        bundle.putString(TrackingKey.DESCRIPTION, this.mBundle.getString(TrackingKey.DESCRIPTION));
        bundle.putString("image_url", this.mBundle.getString("image_url"));
        bundle.putString("icon_url", this.mBundle.getString("icon_url"));
        bundle.putString("endcard_url", this.mBundle.getString("endcard_url"));
        bundle.putString("app_name", this.mBundle.getString("app_name"));
        bundle.putString("package_name", this.mBundle.getString("package_name"));
        bundle.putString("download_url", this.mBundle.getString("download_url"));
        bundle.putInt(TrackingKey.AD_TRIGGER_STATUS, this.mBundle.getInt(TrackingKey.AD_TRIGGER_STATUS));
        bundle.putInt(TrackingKey.IS_OFFLINE_AD, isOfflineAd() ? 1 : 0);
        bundle.putInt(TrackingKey.FILLING_AD_TYPE, this.mBundle.getInt(TrackingKey.FILLING_AD_TYPE));
        int i11 = 0;
        bundle.putInt(TrackingKey.SLOT_HEIGHT, 0);
        bundle.putInt(TrackingKey.SLOT_WIDTH, 0);
        bundle.putString(TrackingKey.SCENE_ID, this.sceneId);
        bundle.putInt(TrackingKey.IS_EXPIRED, isExpired() ? 1 : 0);
        if (z11) {
            bundle.putInt(TrackingKey.SHOW_STATUS, 1);
        } else {
            i11 = 2;
            bundle.putInt(TrackingKey.SHOW_STATUS, 2);
        }
        bundle.putInt(TrackingKey.FAIL_REASON, i11);
        bundle.putInt(TrackingKey.IS_PRE_TRIGGER, this.mBundle.getInt(TrackingKey.IS_PRE_TRIGGER));
        bundle.putInt(TrackingKey.FILLING_SOURCE, this.mBundle.getInt(TrackingKey.FILLING_SOURCE));
        bundle.putString(TrackingKey.REQUEST_ID, this.mBundle.getString(TrackingKey.REQUEST_ID));
        bundle.putInt(TrackingKey.REQUEST_NUM, this.mBundle.getInt(TrackingKey.REQUEST_NUM));
        bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, this.mBundle.getString(TrackingKey.TRAFFIC_GROUP_ID));
        bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.mBundle.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        bundle.putInt(TrackingKey.OPTIMIZE_STATUS, this.mBundle.getInt(TrackingKey.OPTIMIZE_STATUS));
        bundle.putInt(TrackingKey.PRIORITY_CODE, this.mBundle.getInt(TrackingKey.PRIORITY_CODE));
        if (this.maxPrice == 0.0d) {
            this.maxPrice = this.mBundle.getDouble(TrackingKey.MAX_PRICE);
        }
        bundle.putDouble(TrackingKey.MAX_PRICE, this.maxPrice);
        bundle.putDouble(TrackingKey.ECPM, tAdNativeInfo == null ? this.price : tAdNativeInfo.getEcpmPrice());
        bundle.putString(TrackingKey.ECPM_PRECISION, isWaterFallExecutor() ? "estimated" : "exact");
        bundle.putString(TrackingKey.SHOW_ID, tAdNativeInfo == null ? this.mShowId : tAdNativeInfo.getShowId());
        bundle.putString(TrackingKey.SCENE_TOKEN, tAdNativeInfo == null ? this.sceneToken : tAdNativeInfo.getSceneToken());
        bundle.putString(TrackingKey.ERROR_CODE, tAdErrorCode == null ? null : String.valueOf(tAdErrorCode.getErrorCode()));
        bundle.putString(TrackingKey.ERROR_MESSAGE, tAdErrorCode == null ? null : TAdErrorCode.simpleErrorMessage(tAdErrorCode.getErrorMessage()));
        bundle.putInt(TrackingKey.IS_OFFLINE, !NetStateManager.checkNetworkState() ? 1 : 0);
        bundle.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.mBundle.getInt(TrackingKey.IS_CONTAIN_VULGAR));
        Network network = this.mNetwork;
        bundle.putString(TrackingKey.MEDIATOR_SOURCE, network != null ? network.getMediatorSource() : "");
        Network network2 = this.mNetwork;
        bundle.putDouble(TrackingKey.PRICE_COEFFICIENT, network2 != null ? network2.getShowPriceCoefficient().doubleValue() : 0.0d);
        bundle.putInt(TrackingKey.IS_INTERNAL_AD, tAdNativeInfo == null ? isInternalAd() : tAdNativeInfo.isInternalAd());
        String str = this.mGameName;
        if (str == null) {
            str = "";
        }
        bundle.putString(TrackingKey.GAME_NAME, str);
        String str2 = this.mGameScene;
        bundle.putString(TrackingKey.GAME_SCENE, str2 != null ? str2 : "");
        TrackingManager.trackingImpression(bundle);
        addToContextParam(TrackingKey.SHOW_TS, Long.valueOf(bundle.getLong(TrackingKey.SHOW_TS)));
        addToContextParam(TrackingKey.SHOW_TIME, Long.valueOf(bundle.getLong(TrackingKey.SHOW_TIME)));
        addToContextParam(TrackingKey.SLOT_HEIGHT, Integer.valueOf(bundle.getInt(TrackingKey.SLOT_HEIGHT)));
        addToContextParam(TrackingKey.SLOT_WIDTH, Integer.valueOf(bundle.getInt(TrackingKey.SLOT_WIDTH)));
        addToContextParam(TrackingKey.SHOW_STATUS, Integer.valueOf(bundle.getInt(TrackingKey.SHOW_STATUS)));
        addToContextParam(TrackingKey.FAIL_REASON, Integer.valueOf(bundle.getInt(TrackingKey.FAIL_REASON)));
        this.mBundle.putDouble(TrackingKey.MAX_PRICE, bundle.getDouble(TrackingKey.MAX_PRICE));
    }

    public void logTrigerShow(TAdNativeInfo tAdNativeInfo) {
        trigerShow(tAdNativeInfo, "", "");
    }

    public void logTrigerShow(String str, String str2) {
        trigerShow(null, str, str2);
    }

    public void onAdShowError(TAdErrorCode tAdErrorCode) {
        onAdShowError(null, tAdErrorCode);
    }

    public void onAdShowError(TAdNativeInfo tAdNativeInfo, TAdErrorCode tAdErrorCode) {
        logImpression(tAdNativeInfo, false, tAdErrorCode);
        WrapTAdAllianceListener wrapTAdAllianceListener = this.mListenerList.isEmpty() ? null : this.mListenerList.get(0);
        if (wrapTAdAllianceListener != null) {
            wrapTAdAllianceListener.onShowError(tAdErrorCode);
        }
    }

    public void onAdditionalShowed(long j11, String str, int i11) {
        saveShowedValue(j11);
        WrapTAdAllianceListener wrapTAdAllianceListener = this.mListenerList.isEmpty() ? null : this.mListenerList.get(0);
        if (wrapTAdAllianceListener == null) {
            return;
        }
        AdditionalInfo baseAdditionalInfo = getBaseAdditionalInfo();
        baseAdditionalInfo.setAdmobECPM(Double.valueOf(j11 / 1000000.0d));
        baseAdditionalInfo.setCurrencyCode(str);
        baseAdditionalInfo.setPrecisionType(Integer.valueOf(i11));
        Network network = this.mNetwork;
        if (network != null) {
            baseAdditionalInfo.setSource(network.getSource());
            baseAdditionalInfo.setApplicationId(this.mNetwork.getApplicationId());
            baseAdditionalInfo.setApplicationKey(this.mNetwork.getApplicationKey());
            baseAdditionalInfo.setCodeSeatId(this.mNetwork.getCodeSeatId());
            baseAdditionalInfo.setBidding(Boolean.valueOf(AdUtil.isBiddingNetwork(this.mNetwork.getSource().intValue())));
            baseAdditionalInfo.setMediatorSource(this.mNetwork.getMediatorSource());
        }
        wrapTAdAllianceListener.onShowed(baseAdditionalInfo);
    }

    public void onReward() {
        WrapTAdAllianceListener wrapTAdAllianceListener = this.mListenerList.isEmpty() ? null : this.mListenerList.get(0);
        if (wrapTAdAllianceListener != null) {
            wrapTAdAllianceListener.onRewarded();
        }
    }

    public void onTimeOut() {
        adFailedToLoad(TAdErrorCode.ERROR_AD_REQUEST_TIME_OUT);
        destroyAd();
    }

    public void post(Handler handler, Runnable runnable) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void setAdLoadScenes(String str, String str2, Map<String, Object> map) {
        this.mGameName = str;
        this.mGameScene = str2;
        this.mExtInfo = map;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setAdSource(int i11) {
        this.adSource = i11;
    }

    @Override // com.hisavana.common.interfacz.Iad
    public void setAdUnit(String str) {
        this.mAdUnit = str;
    }

    public void setAdmobMediatorInfo(String str) {
        if (this.mNetwork == null) {
            return;
        }
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> sourceName: " + str + " | " + this.mNetwork.getCodeSeatId());
        this.mNetwork.setMediatorSource(str);
    }

    public void setContainVulgarContent(boolean z11) {
        this.isContainVulgarContent = z11;
    }

    public void setCurrActivityFullscreen(boolean z11) {
        this.mCurrActivityFullscreen = z11;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setEcpmPrice(double d11) {
        this.price = d11;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setExt(String str) {
    }

    @Override // com.hisavana.common.interfacz.Iad
    public void setLoadStatus(int i11) {
        this.mLoadStatus = i11;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setMaxPrice(double d11) {
        AdLogUtil.Log().d("Athena", "setMaxPrice " + d11);
        this.maxPrice = d11;
    }

    @Override // com.hisavana.common.interfacz.Iad
    public void setOfflineAd(boolean z11) {
        this.isOfflineAd = z11;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setPreload(boolean z11) {
        this.isPreload = z11;
    }

    @Override // com.hisavana.common.interfacz.Iad
    public void setRequestRound(int i11) {
        AdLogUtil.Log().d("BaseAd", "setRequestRound " + i11 + " " + getLogString());
        this.mRequestRound = i11;
    }

    @Override // com.hisavana.common.interfacz.Iad
    public void setRequestTime(long j11) {
        this.requestTime = j11;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setRequestType(int i11) {
        this.requestType = i11;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setSecondPrice(double d11) {
        AdLogUtil.Log().d(c.SECOND_PRICE_TAG, "*----> BaseAd setSecondPrice price" + d11 + getLogString());
        this.secondPrice = d11;
    }

    public void setShowId(String str) {
        this.mShowId = str;
    }

    @Override // com.hisavana.common.interfacz.Iad
    public void setSupportFlag(int i11) {
        this.supportHisavanaFlag = i11;
    }

    @Override // com.hisavana.common.interfacz.ICacheAd
    public void setTimeOut(boolean z11) {
        this.isTimeOut = z11;
    }

    @Override // com.hisavana.common.interfacz.Iad
    public void setTrackingBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mBundle.putAll(bundle);
        this.mBundle.putDouble(TrackingKey.BIDDING_PRICE, this.mNetwork.getPrice().doubleValue());
    }

    public void setTtl(int i11) {
        this.ttl = i11;
    }

    public void startTimer() {
        if (this.runTimer == null) {
            RunTimer runTimer = new RunTimer();
            this.runTimer = runTimer;
            runTimer.d(getTimeOutTime());
            this.runTimer.e(this.timeOutCallback);
        }
        this.runTimer.c();
        AdLogUtil.Log().d("BaseAd", "启动广告请求超时监听...");
    }

    @Override // com.hisavana.common.interfacz.Iad
    public void stopLoader() {
        if (this.isLoaded) {
            return;
        }
        try {
            if (isSupportStopRequest()) {
                destroyAd();
            } else {
                detachContext();
                setLoadStatus(4);
            }
        } catch (Exception e11) {
            AdLogUtil.Log().e("BaseAd", Log.getStackTraceString(e11));
        }
    }

    public void stopTimer() {
        RunTimer runTimer = this.runTimer;
        if (runTimer != null) {
            runTimer.b();
            this.runTimer = null;
        }
    }

    public boolean supportTimer() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void trigerShow(TAdNativeInfo tAdNativeInfo, String str, String str2) {
        int iIsInternalAd;
        Bundle bundle = new Bundle();
        appendContextParam(bundle);
        if (bundle.containsKey(TrackingKey.IS_DEFAULT_AD)) {
            bundle.remove(TrackingKey.IS_DEFAULT_AD);
        }
        bundle.putInt(TrackingKey.IS_TIMEOUT, this.mBundle.getInt(TrackingKey.IS_TIMEOUT));
        bundle.putString(TrackingKey.ERROR_CODE, this.mBundle.getString(TrackingKey.ERROR_CODE));
        bundle.putString(TrackingKey.ERROR_MESSAGE, TAdErrorCode.simpleErrorMessage(this.mBundle.getString(TrackingKey.ERROR_MESSAGE)));
        if (tAdNativeInfo != null) {
            bundle.putString(TrackingKey.AD_TITLE, tAdNativeInfo.getTitle());
            bundle.putString(TrackingKey.AD_URL, "");
            bundle.putString(TrackingKey.DESCRIPTION, tAdNativeInfo.getDescription());
            if (tAdNativeInfo.getIcon() != null) {
                bundle.putString("icon_url", tAdNativeInfo.getIcon().getUrl());
            }
            bundle.putString("endcard_url", "");
            bundle.putString("app_name", "");
            bundle.putString("package_name", "");
            bundle.putString("download_url", "");
            bundle.putString(TrackingKey.SCENE_ID, tAdNativeInfo.getSceneId());
            this.sceneId = tAdNativeInfo.getSceneId() == null ? "" : tAdNativeInfo.getSceneId();
            bundle.putString(TrackingKey.SCENE_TOKEN, tAdNativeInfo.getSceneToken());
            this.sceneToken = tAdNativeInfo.getSceneToken();
            iIsInternalAd = tAdNativeInfo.isInternalAd();
        } else {
            bundle.putString(TrackingKey.SCENE_ID, str2);
            if (str2 == null) {
                str2 = "";
            }
            this.sceneId = str2;
            bundle.putString(TrackingKey.SCENE_TOKEN, str);
            this.sceneToken = str;
            iIsInternalAd = isInternalAd();
        }
        bundle.putInt(TrackingKey.IS_INTERNAL_AD, iIsInternalAd);
        bundle.putInt(TrackingKey.IS_PRE_TRIGGER, this.mBundle.getInt(TrackingKey.IS_PRE_TRIGGER));
        bundle.putInt(TrackingKey.FILLING_SOURCE, this.mBundle.getInt(TrackingKey.FILLING_SOURCE));
        bundle.putString(TrackingKey.REQUEST_ID, this.mBundle.getString(TrackingKey.REQUEST_ID));
        bundle.putInt(TrackingKey.AD_TRIGGER_STATUS, this.mBundle.getInt(TrackingKey.AD_TRIGGER_STATUS));
        bundle.putInt(TrackingKey.IS_OFFLINE_AD, isOfflineAd() ? 1 : 0);
        bundle.putInt(TrackingKey.FILLING_AD_TYPE, this.mBundle.getInt(TrackingKey.FILLING_AD_TYPE));
        bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, this.mBundle.getString(TrackingKey.TRAFFIC_GROUP_ID));
        bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.mBundle.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        bundle.putString(TrackingKey.SHOW_ID, tAdNativeInfo == null ? this.mShowId : tAdNativeInfo.getShowId());
        bundle.putInt(TrackingKey.IS_OFFLINE, !NetStateManager.checkNetworkState() ? 1 : 0);
        bundle.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.mBundle.getInt(TrackingKey.IS_CONTAIN_VULGAR));
        Network network = this.mNetwork;
        bundle.putString(TrackingKey.MEDIATOR_SOURCE, network != null ? network.getMediatorSource() : "");
        Network network2 = this.mNetwork;
        bundle.putDouble(TrackingKey.PRICE_COEFFICIENT, network2 != null ? network2.getShowPriceCoefficient().doubleValue() : 0.0d);
        TrackingManager.trackingTriggerShow(bundle);
        addToContextParam(TrackingKey.AD_TITLE, bundle.getString(TrackingKey.AD_TITLE));
        addToContextParam(TrackingKey.AD_URL, "");
        addToContextParam(TrackingKey.DESCRIPTION, bundle.getString(TrackingKey.DESCRIPTION));
        addToContextParam("image_url", bundle.getString("image_url"));
        addToContextParam("icon_url", bundle.getString("icon_url"));
        addToContextParam("endcard_url", "");
        addToContextParam("app_name", "");
        addToContextParam("package_name", "");
        addToContextParam("download_url", "");
        addToContextParam(TrackingKey.REQUEST_NUM, Integer.valueOf(this.mAdCount));
    }
}
