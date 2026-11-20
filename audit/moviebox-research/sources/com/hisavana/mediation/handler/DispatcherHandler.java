package com.hisavana.mediation.handler;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TInnerAdRequestBody;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBaseAdSummary;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.interfacz.Iad;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.manager.BidExecutorCacheManager;
import com.hisavana.common.manager.RequestingAdManager;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingUtil;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.TAdManager;
import hn.i;
import hn.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class DispatcherHandler<T extends Iad> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41942a = "LoadAdManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CloudControlConfig.CodeSeat f41943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f41945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f41946e;

    public DispatcherHandler(CloudControlConfig.CodeSeat codeSeat, i iVar) {
        this.f41943b = codeSeat;
        this.f41944c = codeSeat == null ? -1 : codeSeat.getCodeSeatType().intValue();
        this.f41945d = codeSeat == null ? "" : codeSeat.getCodeSeatId();
        this.f41946e = iVar;
    }

    public static Bundle a(i iVar, Network network, int i11, CloudControlConfig.CodeSeat codeSeat) {
        Bundle bundle = new Bundle();
        bundle.putInt(TrackingKey.REQUEST_TYPE, i11);
        bundle.putInt(TrackingKey.PLATFORM, network != null ? network.getSource().intValue() : -1);
        bundle.putString("app_id", network != null ? network.getApplicationId() : "-1");
        bundle.putString(TrackingKey.CODE_SEAT_ID, network != null ? network.getCodeSeatId() : "-1");
        bundle.putDouble(TrackingKey.BIDDING_PRICE, network != null ? network.getPrice().doubleValue() : -1.0d);
        bundle.putInt("ad_type", network != null ? network.getAdt() : -1);
        bundle.putLong(TrackingKey.REQUEST_TS, System.currentTimeMillis());
        bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
        bundle.putInt(TrackingKey.PRIORITY, iVar.B());
        bundle.putInt(TrackingKey.OPTIMIZE_STATUS, 1);
        bundle.putInt(TrackingKey.PRIORITY_CODE, iVar.A());
        Bundle bundleS = iVar.s();
        if (bundleS == null) {
            if (codeSeat != null) {
                bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, codeSeat.getCodeSeatId());
                bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, codeSeat.getTrafficGroupId());
                bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, codeSeat.getExperimentGroupId());
            }
            bundle.putString(TrackingKey.TRIGGER_ID, TrackingUtil.getTriggerId());
            bundle.putLong(TrackingKey.TRIGGER_TS, System.currentTimeMillis());
            return bundle;
        }
        try {
            bundle.putInt(TrackingKey.REQUEST_TIME, (int) (System.currentTimeMillis() - bundleS.getLong(TrackingKey.TRIGGER_TS)));
        } catch (Exception unused) {
        }
        bundle.putString(TrackingKey.TRIGGER_ID, bundleS.getString(TrackingKey.TRIGGER_ID));
        bundle.putLong(TrackingKey.TRIGGER_TS, bundleS.getLong(TrackingKey.TRIGGER_TS));
        bundle.putInt(TrackingKey.IS_PRE_TRIGGER, bundleS.getInt(TrackingKey.IS_PRE_TRIGGER));
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, bundleS.getString(TrackingKey.CODE_SEAT_ID));
        bundle.putInt(TrackingKey.AD_TRIGGER_STATUS, bundleS.getInt(TrackingKey.AD_TRIGGER_STATUS));
        bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, bundleS.getString(TrackingKey.TRAFFIC_GROUP_ID));
        bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, bundleS.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        bundle.putDouble(TrackingKey.PRICE_COEFFICIENT, network != null ? network.getShowPriceCoefficient().doubleValue() : 0.0d);
        return bundle;
    }

    @NonNull
    public <Y extends ICacheAd> AdCache<Y> b() {
        int i11 = this.f41944c;
        return (i11 < 1 || i11 > 6) ? new AdCache<>() : AdCacheManager.getCache(i11);
    }

    public final T c(@NonNull Context context, @NonNull Network network, int i11, int i12) {
        if (network == null) {
            return null;
        }
        network.setAdt(this.f41944c);
        T t11 = (T) e(network);
        if (t11 == null) {
            IBaseAdSummary iBaseAdSummaryH = o.a().h(network.getSource().intValue());
            if (iBaseAdSummaryH == null) {
                return null;
            }
            int i13 = this.f41944c;
            switch (i13) {
                case 1:
                case 6:
                    BaseNative baseNative = iBaseAdSummaryH.getNative(context, network, i13);
                    if (baseNative != null) {
                        baseNative.setChoicesPosition(this.f41946e.a());
                        baseNative.setAdmobMediaAspectRatio(this.f41946e.g());
                        if (i12 <= 0) {
                            i12 = 60;
                        }
                        baseNative.setTtl(i12);
                        baseNative.setAdCount(i11);
                        baseNative.setAdSource(network.getSource().intValue());
                        baseNative.setContainVulgarContent(this.f41946e.F());
                        baseNative.setAdLoadScenes(this.f41946e.w(), this.f41946e.y(), this.f41946e.u());
                        baseNative.setCurrActivityFullscreen(this.f41946e.G());
                    }
                    return baseNative;
                case 2:
                    BaseBanner banner = iBaseAdSummaryH.getBanner(context, network, this.f41946e.n(), this.f41946e.q());
                    if (banner != null) {
                        if (i12 <= 0) {
                            i12 = 60;
                        }
                        banner.setTtl(i12);
                        banner.setAdSource(network.getSource().intValue());
                        banner.setLoadStatus(0);
                        banner.setHideAdCloseView(this.f41946e.H());
                        banner.setContainVulgarContent(this.f41946e.F());
                        banner.setAdLoadScenes(this.f41946e.w(), this.f41946e.y(), this.f41946e.u());
                        banner.setCurrActivityFullscreen(this.f41946e.G());
                        banner.setCurrActivityFullscreen(this.f41946e.G());
                        banner.setBannerAdWidth(this.f41946e.k());
                        banner.setCloseDirectlyWithoutJumping(this.f41946e.E());
                    }
                    return banner;
                case 3:
                    BaseInterstitial interstitial = iBaseAdSummaryH.getInterstitial(context, network);
                    if (interstitial != null) {
                        if (i12 <= 0) {
                            i12 = 60;
                        }
                        interstitial.setTtl(i12);
                        interstitial.setAdSource(network.getSource().intValue());
                        interstitial.setLoadStatus(0);
                        interstitial.setContainVulgarContent(this.f41946e.F());
                        interstitial.setAdLoadScenes(this.f41946e.w(), this.f41946e.y(), this.f41946e.u());
                        interstitial.setCurrActivityFullscreen(this.f41946e.G());
                    }
                    return interstitial;
                case 4:
                    BaseSplash splash = iBaseAdSummaryH.getSplash(context, network);
                    if (splash != null) {
                        if (i12 <= 0) {
                            i12 = 240;
                        }
                        splash.setTtl(i12);
                        splash.setAdSource(network.getSource().intValue());
                        splash.setOrientation(this.f41946e.C());
                        splash.setSplashMode(this.f41946e.D());
                        splash.setContainVulgarContent(this.f41946e.F());
                        splash.setAdLoadScenes(this.f41946e.w(), this.f41946e.y(), this.f41946e.u());
                        splash.setCurrActivityFullscreen(this.f41946e.G());
                    }
                    return splash;
                case 5:
                    BaseVideo video = iBaseAdSummaryH.getVideo(context, network);
                    if (video != null) {
                        if (i12 <= 0) {
                            i12 = 60;
                        }
                        video.setTtl(i12);
                        video.setAdSource(network.getSource().intValue());
                        video.setLoadStatus(0);
                        video.setContainVulgarContent(this.f41946e.F());
                        video.setAdLoadScenes(this.f41946e.w(), this.f41946e.y(), this.f41946e.u());
                    }
                    return video;
            }
        }
        return t11;
    }

    public T d(Context context, CloudControlConfig.CodeSeat codeSeat, Network network) {
        if (codeSeat == null || network == null || TextUtils.isEmpty(network.getCodeSeatId())) {
            MediaLogUtil.e("LoadAdManager", "createExecuter,network or codeSeat of codeSeatId is empty");
            return null;
        }
        T t11 = (T) RequestingAdManager.getInstance().getRequest(codeSeat.getCodeSeatId(), network.getCodeSeatId());
        if (t11 != null) {
            AdLogUtil.Log().d("LoadAdManager", "*----> exist loading Ad id: " + t11.getPlacementId());
            return t11;
        }
        int iMax = Math.max(1, Math.min(l(), this.f41943b.getAdRequestCount().intValue()));
        T t12 = (T) c(context, network, iMax, codeSeat.getCacheTimeout().intValue());
        if (t12 == null) {
            AdLogUtil.Log().e("LoadAdManager", "create execute:" + network.getSource() + " fail");
            MediaLogUtil.e("LoadAdManager", "create executor,source " + network.getSource() + ",id " + network.getCodeSeatId() + " fail");
            return null;
        }
        t12.setEcpmPrice(network.getPrice().doubleValue());
        t12.setAdUnit(this.f41945d);
        RecordTestInfo.record("add ad to list adSource:" + t12.getAdSource() + ",network codeSeat:" + network.getCodeSeatId() + " request num:" + iMax);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("add ad executor to list,adSource ");
        sb2.append(t12.getAdSource());
        sb2.append(",id ");
        sb2.append(network.getCodeSeatId());
        MediaLogUtil.d("LoadAdManager", sb2.toString());
        return t12;
    }

    public final T e(Network network) {
        if (network == null) {
            return null;
        }
        try {
            if (network.getSource().intValue() == 8) {
                return BidExecutorCacheManager.getInstance().removeData(network.getCodeSeatId());
            }
            return null;
        } catch (Exception e11) {
            AdLogUtil.Log().d("LoadAdManager", Log.getStackTraceString(e11));
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CopyOnWriteArrayList<T> g(Context context, List<Network> list, List<Network> list2, List<Network> list3, boolean z11) {
        Iad iadD;
        List<Network> arrayList = list3 == null ? new ArrayList<>() : list3;
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        n(arrayList);
        if (LogSwitch.isDebug) {
            AdLogUtil.Log().d("LoadAdManager", "*----> loadWaterfallAd ---- netWorks = " + arrayList.toString());
        }
        CopyOnWriteArrayList<T> copyOnWriteArrayList = (CopyOnWriteArrayList<T>) new CopyOnWriteArrayList();
        int iMax = Math.max(1, Math.min(l(), this.f41943b.getAdRequestCount().intValue()));
        if (!list2.isEmpty()) {
            Iterator<Network> it = list2.iterator();
            while (it.hasNext()) {
                Network next = it.next();
                if (i(next, z11)) {
                    Iterator<Network> it2 = it;
                    if (iMax - b().getAdNum(this.f41945d, next.getSource().intValue(), next.getCodeSeatId(), this.f41946e.F()) <= 0) {
                        AdLogUtil.Log().d("LoadAdManager", "*----> exist ad source:" + next.getSource() + " ,network codeSeat :" + next.getCodeSeatId() + ",need number <= 0");
                    } else {
                        Iad iadD2 = d(context, this.f41943b, next);
                        if (iadD2 != null) {
                            copyOnWriteArrayList.add(iadD2);
                        }
                    }
                    it = it2;
                }
            }
        }
        boolean z12 = false;
        for (Network network : arrayList) {
            if (network != null) {
                if (z12) {
                    AdLogUtil.Log().d("LoadAdManager", "*----> exist higher ecpm ad in current waterfall.");
                } else {
                    int adNum = b().getAdNum(this.f41945d, network.getSource().intValue(), network.getCodeSeatId(), this.f41946e.F());
                    z12 = adNum > 0;
                    if (iMax - adNum <= 0) {
                        AdLogUtil.Log().d("LoadAdManager", "*----> exist ad source:" + network.getSource() + " ,network codeSeat :" + network.getCodeSeatId() + ",need number <= 0");
                    } else if (i(network, z11) && (iadD = d(context, this.f41943b, network)) != null) {
                        copyOnWriteArrayList.add(iadD);
                    }
                }
            }
        }
        return copyOnWriteArrayList;
    }

    public void h(CopyOnWriteArrayList<T> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        AdLogUtil.Log().d("LoadAdManager", "sort executer list");
        if (LogSwitch.isDebug) {
            StringBuilder sb2 = new StringBuilder();
            for (T t11 : copyOnWriteArrayList) {
                if (t11 != null && t11.getNetwork() != null) {
                    sb2.append(t11.getNetwork().toString());
                }
            }
            AdLogUtil.Log().d("LoadAdManager", "*before* sort executer list are: " + sb2.toString());
        }
        try {
            ArrayList arrayList = new ArrayList(copyOnWriteArrayList);
            Collections.sort(arrayList, new Comparator<T>() { // from class: com.hisavana.mediation.handler.DispatcherHandler.2
                @Override // java.util.Comparator
                public int compare(T t12, T t13) {
                    if (t12 == null || t13 == null || t12.getNetwork() == null || t13.getNetwork() == null) {
                        return 0;
                    }
                    return -((int) ((t12.getNetwork().getPrice().doubleValue() * 100.0d) - (t13.getNetwork().getPrice().doubleValue() * 100.0d)));
                }
            });
            copyOnWriteArrayList.clear();
            copyOnWriteArrayList.addAll(arrayList);
        } catch (Exception e11) {
            AdLogUtil.Log().e("LoadAdManager", Log.getStackTraceString(e11));
        }
        if (LogSwitch.isDebug) {
            StringBuilder sb3 = new StringBuilder();
            for (T t12 : copyOnWriteArrayList) {
                if (t12 != null && t12.getNetwork() != null) {
                    sb3.append(t12.getNetwork().toString());
                }
            }
            AdLogUtil.Log().d("LoadAdManager", "*after* sort executer list are: " + sb3.toString());
        }
    }

    public final boolean i(Network network, boolean z11) {
        if (network == null) {
            return false;
        }
        if (z11 && network.getSource().intValue() == 5) {
            AdLogUtil.Log().e(ComConstants.IRON_SOURCE_TAG, "IronSource Do not preload  mLoadType = preload ---  network.getSource() = " + network.getSource());
            return false;
        }
        if (!z11 || network.getSource().intValue() != 14 || network.getAdt() != 2) {
            return true;
        }
        AdLogUtil.Log().e("LoadAdManager", "MAX Do not preload");
        return false;
    }

    public boolean j(T t11, int i11, int i12, TInnerAdRequestBody tInnerAdRequestBody) {
        if (t11 == null) {
            return false;
        }
        t11.addRequestBody(tInnerAdRequestBody);
        if (t11.getLoadStatus() != 0) {
            if (t11.getLoadStatus() == 4) {
                AdLogUtil.Log().d("LoadAdManager", "*----> exist loading Ad id: " + t11.getPlacementId() + ",bind context for it");
                t11.setLoadStatus(1);
                Network network = t11.getNetwork();
                if (network != null && b().getAdNum(this.f41945d, network.getSource().intValue(), network.getCodeSeatId(), this.f41946e.F()) > 0 && tInnerAdRequestBody.getAdListener() != null) {
                    tInnerAdRequestBody.getAdListener().onLoad();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ad start load,adSource ");
                sb2.append(t11.getAdSource());
                sb2.append(",id ");
                sb2.append(t11.getNetwork() != null ? t11.getNetwork().getCodeSeatId() : "");
                MediaLogUtil.d("LoadAdManager", sb2.toString());
            }
            return false;
        }
        AdLogUtil.Log().d("LoadAdManager", "*----> loadAd id: " + t11.getPlacementId() + ",EcpmPrice: " + t11.getEcpmPrice() + ",AdSource: " + t11.getAdSource());
        t11.setSupportFlag(this.f41946e.A());
        t11.setTrackingBundle(a(this.f41946e, t11.getNetwork(), i11, this.f41943b));
        t11.setOfflineAd(i11 == 5);
        t11.setRequestType(i11);
        t11.setRequestRound(i12);
        t11.setLoadStatus(1);
        t11.setPreload(i11 == 2);
        t11.loadAd();
        if (LogSwitch.isDebug) {
            RecordTestInfo.LogMsg(ComConstants.transferSourceToStr(t11.getAdSource()), RecordTestInfo.LOG_CODE5);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ad start load,adSource ");
        sb3.append(t11.getAdSource());
        sb3.append(",id ");
        sb3.append(t11.getNetwork() != null ? t11.getNetwork().getCodeSeatId() : "");
        MediaLogUtil.d("LoadAdManager", sb3.toString());
        return true;
    }

    public boolean k(@NonNull List<T> list) {
        for (T t11 : list) {
            if (t11 != null) {
                int loadStatus = t11.getLoadStatus();
                if (loadStatus == 0 || loadStatus == 1) {
                    return false;
                }
                if (loadStatus == 2) {
                    return true;
                }
            }
        }
        return true;
    }

    public final int l() {
        if (this.f41944c == 6) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return 1;
    }

    public final void n(List<Network> list) {
        Collections.sort(list, new Comparator<Network>() { // from class: com.hisavana.mediation.handler.DispatcherHandler.1
            @Override // java.util.Comparator
            public int compare(Network network, Network network2) {
                if (network == null || network2 == null) {
                    return 0;
                }
                int i11 = -((int) ((network.getPrice().doubleValue() * 100.0d) - (network2.getPrice().doubleValue() * 100.0d)));
                if (i11 == 0) {
                    if (DispatcherHandler.this.b().getAdNum(DispatcherHandler.this.f41945d, network.getSource().intValue(), network.getCodeSeatId(), DispatcherHandler.this.f41946e.F()) > 0) {
                        return -1;
                    }
                    if (DispatcherHandler.this.b().getAdNum(DispatcherHandler.this.f41945d, network2.getSource().intValue(), network2.getCodeSeatId(), DispatcherHandler.this.f41946e.F()) > 0) {
                        return 1;
                    }
                }
                return i11;
            }
        });
    }
}
