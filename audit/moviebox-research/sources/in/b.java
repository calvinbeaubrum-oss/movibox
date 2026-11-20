package in;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import ca.d;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.RunTimer;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.NativeAdWrapper;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.interfacz.Iad;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.tracking.TrackingUtil;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.CloudControlConfigSync;
import com.hisavana.mediation.config.TAdManager;
import hn.h;
import hn.i;
import hn.m;
import hn.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import w9.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b<T extends Iad> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f67233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f67234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RunTimer f67235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public hn.c f67236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f67237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f67238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CloudControlConfig.CodeSeat f67239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s f67240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f67241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f67242j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f67243k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f67244l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f67245m;
    public int mFillSource;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashMap<String, String> f67246n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f67247o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f67248p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f67249q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f67250r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f67251s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Map<String, Object> f67252t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f67253u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f67254v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RunTimer.a f67255w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f67256x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f67257y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Bundle f67258z;

    /* JADX INFO: compiled from: source.java */
    public class a implements RunTimer.a {
        public a() {
        }

        @Override // com.cloud.sdk.commonutil.util.RunTimer.a
        public void isTimeOut() {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> Load ad is time out ");
            b.this.clearCurrentAd();
            s sVar = b.this.f67240h;
            if (sVar != null) {
                sVar.onError(TAdErrorCode.ERROR_FILL_FAILED_WITH_MEDIATION_TIME_OUT);
            }
        }
    }

    /* JADX INFO: renamed from: in.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0711b implements Preconditions.a {
        public C0711b() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            b.this.o();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Preconditions.a {
        public c() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            b.this.s();
        }
    }

    public b() {
        this.f67233a = "";
        this.f67234b = null;
        this.f67237e = false;
        this.f67238f = false;
        this.f67242j = 60000;
        this.f67243k = 0;
        this.f67244l = 0L;
        this.f67245m = false;
        this.f67246n = new LinkedHashMap<>();
        this.f67254v = 1;
        this.f67255w = new a();
    }

    public b(@NonNull Context context) {
        this.f67233a = "";
        this.f67234b = null;
        this.f67237e = false;
        this.f67238f = false;
        this.f67242j = 60000;
        this.f67243k = 0;
        this.f67244l = 0L;
        this.f67245m = false;
        this.f67246n = new LinkedHashMap<>();
        this.f67254v = 1;
        this.f67255w = new a();
        this.f67234b = context.getApplicationContext();
        b();
    }

    public b(@NonNull Context context, String str) {
        this.f67233a = "";
        this.f67234b = null;
        this.f67237e = false;
        this.f67238f = false;
        this.f67242j = 60000;
        this.f67243k = 0;
        this.f67244l = 0L;
        this.f67245m = false;
        this.f67246n = new LinkedHashMap<>();
        this.f67254v = 1;
        this.f67255w = new a();
        this.f67233a = str;
        this.f67234b = context.getApplicationContext();
        b();
    }

    public abstract hn.c a(CloudControlConfig.CodeSeat codeSeat);

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f67246n.get(str);
    }

    public final void a() {
        if (this.f67258z == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(TrackingKey.REQUEST_TYPE, 1);
        bundle.putString(TrackingKey.TRIGGER_ID, this.f67258z.getString(TrackingKey.TRIGGER_ID));
        bundle.putLong(TrackingKey.TRIGGER_TS, this.f67258z.getLong(TrackingKey.TRIGGER_TS));
        bundle.putInt("ad_type", this.f67258z.getInt("ad_type"));
        bundle.putString(TrackingKey.CLD_APP_ID, this.f67258z.getString(TrackingKey.CLD_APP_ID));
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f67258z.getString(TrackingKey.CLD_CODE_SEAT_ID));
        bundle.putString("app_id", this.f67258z.getString("app_id"));
        bundle.putString(TrackingKey.CODE_SEAT_ID, this.f67258z.getString(TrackingKey.CODE_SEAT_ID));
        bundle.putInt(TrackingKey.IS_RETREATAD, this.f67258z.getInt(TrackingKey.IS_RETREATAD));
        bundle.putString(TrackingKey.CLD_CONFIGURE_ID, da.a.d().i("cloudControlVersion"));
        bundle.putInt(TrackingKey.IS_PRELOAD, this.f67258z.getInt(TrackingKey.IS_PRELOAD));
        bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, this.f67258z.getString(TrackingKey.TRAFFIC_GROUP_ID));
        bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.f67258z.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        TrackingManager.trackingAdCancel(bundle);
    }

    public final void a(Bundle bundle, double d11) {
        ArrayList<ICacheAd> caches;
        NativeAdWrapper nativeAdWrapper;
        StringBuilder sb2 = new StringBuilder();
        hn.c cVar = this.f67236d;
        String strSubstring = "";
        int i11 = 0;
        if (cVar != null && (caches = cVar.I().getCaches(this.f67233a, 100, false, this.f67249q)) != null) {
            int i12 = 0;
            for (ICacheAd iCacheAd : caches) {
                if (iCacheAd.getEcpmPrice() < d11) {
                    i12++;
                    if (iCacheAd.getAdSource() == 0) {
                        if (iCacheAd instanceof BaseAd) {
                            sb2.append(((BaseAd) iCacheAd).mBundle.get(TrackingKey.REQUEST_ID));
                        } else if ((iCacheAd instanceof AdNativeInfo) && (nativeAdWrapper = ((AdNativeInfo) iCacheAd).getNativeAdWrapper()) != null && nativeAdWrapper.getAdImpl() != null) {
                            sb2.append(nativeAdWrapper.getAdImpl().mBundle.get(TrackingKey.REQUEST_ID));
                        }
                        sb2.append(",");
                    }
                }
            }
            if (sb2.toString().length() > 1) {
                strSubstring = sb2.substring(0, sb2.length() - 1);
                AdLogUtil.Log().d("TBaseAd", "bidding_platform_str" + strSubstring);
            }
            i11 = i12;
        }
        if (bundle != null) {
            bundle.putString(TrackingKey.BIDDING_FAIL_PLATFORM, strSubstring);
            bundle.putInt(TrackingKey.VALID_CACHE_MATERIAL_CNT, i11);
        }
    }

    public void a(TAdErrorCode tAdErrorCode) {
        s sVar = this.f67240h;
        if (sVar != null) {
            sVar.onError(tAdErrorCode);
        }
    }

    public void a(TAdNativeInfo tAdNativeInfo) {
        if (this.f67240h == null) {
            return;
        }
        AdditionalInfo additionalInfoF = f();
        Network network = tAdNativeInfo != null ? tAdNativeInfo.getNetwork() : i();
        if (network != null) {
            additionalInfoF.setSource(network.getSource());
            additionalInfoF.setApplicationId(network.getApplicationId());
            additionalInfoF.setApplicationKey(network.getApplicationKey());
            additionalInfoF.setCodeSeatId(network.getCodeSeatId());
            additionalInfoF.setMediatorSource(network.getMediatorSource());
        }
        this.f67240h.s(additionalInfoF);
    }

    public final void a(String str, String str2, int i11) {
        Bundle bundle = new Bundle();
        bundle.putString(TrackingKey.SCENE_ID, str2);
        bundle.putString(TrackingKey.SCENE_TOKEN, str);
        bundle.putInt(TrackingKey.IS_OFFLINE, !NetStateManager.checkNetworkState() ? 1 : 0);
        if (this.f67239g == null) {
            this.f67239g = h.a(this.f67233a);
        }
        CloudControlConfig.CodeSeat codeSeat = this.f67239g;
        if (codeSeat == null) {
            bundle.putInt(TrackingKey.CACHE_STATUS, 1);
        } else {
            AdCache cache = AdCacheManager.getCache(codeSeat.getCodeSeatType().intValue());
            if (cache != null) {
                if (cache.hasAds(this.f67233a, this.f67249q)) {
                    bundle.putInt(TrackingKey.CACHE_STATUS, 0);
                } else {
                    bundle.putInt(TrackingKey.CACHE_STATUS, this.f67237e ? 2 : 1);
                }
            }
        }
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f67233a);
        bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
        bundle.putLong("ts", System.currentTimeMillis());
        bundle.putInt(TrackingKey.AD_COUNT, i11);
        TrackingManager.trackEnterScene(bundle);
    }

    public final void a(boolean z11, int i11) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f67244l < 1000) {
            AdLogUtil.Log().e("TBaseAd", "isReady interval time is not fit");
            return;
        }
        this.f67244l = jCurrentTimeMillis;
        Bundle bundle = new Bundle();
        if (z11) {
            i11 = this.f67238f ? 1 : 2;
        }
        bundle.putInt("is_ready_status", i11);
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f67233a);
        bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
        bundle.putLong("ts", System.currentTimeMillis());
        TrackingManager.trackIsReady(bundle);
    }

    public abstract boolean a(int i11);

    public TAdErrorCode b(CloudControlConfig.CodeSeat codeSeat) {
        if (codeSeat == null) {
            return TAdErrorCode.ERROR_AD_UNIT_CONFIG_EMPTY;
        }
        if (!codeSeat.getCloudControlEnable().booleanValue()) {
            return TAdErrorCode.ERROR_CLOUD_AD_SEAT_IS_CLOSED;
        }
        this.f67247o = codeSeat.getCodeSeatType().intValue();
        if (!a(codeSeat.getCodeSeatType().intValue())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> code seat type does not match request type");
            MediaLogUtil.e("TBaseAd", "code seat type does not match request type ---> " + codeSeat.getCodeSeatType());
            return TAdErrorCode.ERROR_AD_TYPE_LOAD_INCONSISTENCY;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jC = y.c(jCurrentTimeMillis);
        long jB = y.b(jCurrentTimeMillis);
        if (codeSeat.getAdShowCountLimitDay().intValue() == 0 || (codeSeat.getAdShowCountLimitDay().intValue() != -1 && jC == codeSeat.getTodayZeroClock() && codeSeat.getTodayShowTimes() >= codeSeat.getAdShowCountLimitDay().intValue())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad show times can not exceed day show max");
            MediaLogUtil.e("TBaseAd", "ad show times reach the limit of day,day showTimes " + codeSeat.getAdShowCountLimitDay());
            return TAdErrorCode.ERROR_AD_SHOW_TIMES_OUT_OF_DAY;
        }
        if (codeSeat.getAdShowCountLimitHour().intValue() == 0 || (codeSeat.getAdShowCountLimitHour().intValue() != -1 && jB == codeSeat.getCurrentHourZeroClock() && codeSeat.getCurrentHourShowTimes() >= codeSeat.getAdShowCountLimitHour().intValue())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad display has reached the limit of hours");
            MediaLogUtil.e("TBaseAd", "ad display has reached the limit of hour,hour showTimes " + codeSeat.getAdShowCountLimitHour());
            return TAdErrorCode.ERROR_AD_SHOW_TIMES_OUT_OF_HOUR;
        }
        long lastShowTime = jCurrentTimeMillis - codeSeat.getLastShowTime();
        if (lastShowTime <= 0) {
            lastShowTime = -lastShowTime;
        }
        if (codeSeat.getAdShowTimeInterval().intValue() == -1000 || lastShowTime > codeSeat.getAdShowTimeInterval().intValue()) {
            return null;
        }
        AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad display did not reach the interval");
        MediaLogUtil.e("TBaseAd", "ad display did not reach the interval,time " + codeSeat.getAdShowTimeInterval());
        return TAdErrorCode.ERROR_AD_SHOW_NOT_IN_INTERVAL;
    }

    public void b() {
        if (this.f67240h == null) {
            this.f67240h = new s(this);
        }
    }

    public final void b(int i11) {
        this.f67241i = false;
        this.f67254v = i11;
        Preconditions.d(new Preconditions.a() { // from class: in.a
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                this.f67232a.k();
            }
        });
    }

    public void b(TAdErrorCode tAdErrorCode) {
        s sVar = this.f67240h;
        if (sVar != null) {
            sVar.onShowError(tAdErrorCode);
        }
    }

    public final void b(boolean z11, int i11) {
        int[] validAndInvalidAdNum;
        this.f67256x = TrackingUtil.getTriggerId();
        Bundle bundle = new Bundle();
        this.f67258z = bundle;
        bundle.putString(TrackingKey.TRIGGER_ID, this.f67256x);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f67257y = jCurrentTimeMillis;
        this.f67258z.putLong(TrackingKey.TRIGGER_TS, jCurrentTimeMillis);
        CloudControlConfig.CodeSeat codeSeat = this.f67239g;
        if (codeSeat != null) {
            this.f67258z.putInt("ad_type", codeSeat.getCodeSeatType().intValue());
            AdCache cache = AdCacheManager.getCache(this.f67239g.getCodeSeatType().intValue());
            if (cache != null && (validAndInvalidAdNum = cache.getValidAndInvalidAdNum(this.f67233a)) != null && validAndInvalidAdNum.length >= 2) {
                int i12 = validAndInvalidAdNum[0];
                int i13 = validAndInvalidAdNum[1];
                this.f67258z.putInt(TrackingKey.CACHE_VALID_ADS, i12);
                this.f67258z.putInt(TrackingKey.CACHE_EXPIRE_ADS, i13);
            }
            this.f67258z.putInt(TrackingKey.MULTI_COUNT, this.f67239g.getAdRequestConcurrentCount().intValue());
            this.f67258z.putInt(TrackingKey.BIDDING_DURATION, (this.f67254v == 2 ? this.f67239g.getRealtimeBiddingWaitTime() : this.f67239g.getBiddingWaitTime()).intValue());
            this.f67258z.putString(TrackingKey.TRAFFIC_GROUP_ID, this.f67239g.getTrafficGroupId());
            this.f67258z.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.f67239g.getExperimentGroupId());
            this.f67258z.putInt(TrackingKey.REQUEST_NUM, this.f67239g.getCodeSeatType().intValue() == 6 ? this.f67239g.getAdRequestCount().intValue() : 1);
        }
        this.f67258z.putString("app_id", TAdManager.getAppId());
        this.f67258z.putString(TrackingKey.CODE_SEAT_ID, this.f67233a);
        this.f67258z.putInt(TrackingKey.IS_PRE_TRIGGER, z11 ? 1 : 0);
        this.f67258z.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
        this.f67258z.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f67233a);
        this.f67258z.putInt(TrackingKey.AD_TRIGGER_STATUS, i11);
        this.f67258z.putInt(TrackingKey.PRIORITY_CODE, this.f67243k);
        this.f67258z.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.f67249q ? 1 : 0);
        this.f67258z.putInt(TrackingKey.TRIGGER_MODE, this.f67254v);
        TrackingManager.trackingADTrigger(this.f67258z);
    }

    public int c(CloudControlConfig.CodeSeat codeSeat) {
        int i11 = 0;
        if (codeSeat == null) {
            return 0;
        }
        int iIntValue = codeSeat.getAdxShowRate().intValue();
        int iIntValue2 = codeSeat.getEwShowRate().intValue();
        Random random = new Random(System.currentTimeMillis());
        int iAbs = Math.abs(random.nextInt() % 100);
        int iAbs2 = Math.abs(random.nextInt() % 100);
        if (iAbs < iIntValue && iAbs2 < iIntValue2) {
            i11 = 3;
        } else if (iAbs < iIntValue) {
            i11 = 1;
        } else if (iAbs2 < iIntValue2) {
            i11 = 2;
        }
        AdLogUtil.Log().d("TBaseAd", "Traffic support config: adxShowRate " + iIntValue + " ewShowRate " + iIntValue2 + ",current random result is: " + i11);
        return i11;
    }

    public void c(TAdErrorCode tAdErrorCode) {
        if (this.f67240h != null) {
            AdditionalInfo additionalInfoF = f();
            if (tAdErrorCode != null) {
                additionalInfoF.setErrorCode(tAdErrorCode);
            }
            this.f67240h.d(tAdErrorCode, additionalInfoF);
        }
    }

    public abstract boolean c();

    public void clearCurrentAd() {
        if (this.f67237e && this.f67236d != null) {
            a();
        }
        stopTimer();
        hn.c cVar = this.f67236d;
        if (cVar != null) {
            cVar.e();
        }
        setIsShowing(false);
        if (this.f67237e) {
            AdLogUtil.Log().d(ComConstants.AD_FLOW, "cancel request ad ");
        }
    }

    public i d() {
        i iVar = new i();
        iVar.c(this.f67258z);
        iVar.t(this.f67243k);
        iVar.j(this.f67249q);
        iVar.d(this.f67250r);
        iVar.i(this.f67251s);
        iVar.e(this.f67252t);
        iVar.m(this.f67253u);
        return iVar;
    }

    public void d(TAdErrorCode tAdErrorCode) {
        if (this.f67240h != null) {
            AdditionalInfo additionalInfoF = f();
            if (tAdErrorCode != null) {
                additionalInfoF.setErrorCode(tAdErrorCode);
            }
            this.f67240h.n(tAdErrorCode, additionalInfoF);
        }
    }

    public void destroy() {
        Preconditions.d(new C0711b());
    }

    public int e() {
        return this.f67247o;
    }

    public String enterScene(String str, int i11) {
        Preconditions.a();
        String strN = DeviceUtil.n();
        a(strN, str, i11);
        if (this.f67246n.size() >= 24) {
            Iterator<String> it = this.f67246n.keySet().iterator();
            if (it.hasNext()) {
                this.f67246n.remove(it.next());
            }
        }
        this.f67246n.put(strN, str);
        return strN;
    }

    public final AdditionalInfo f() {
        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setPlacementId(this.f67233a);
        additionalInfo.setMcc(d.d());
        additionalInfo.setTriggerId(this.f67256x);
        CloudControlConfig.CodeSeat codeSeat = this.f67239g;
        if (codeSeat != null) {
            additionalInfo.setTrafficGroupId(codeSeat.getTrafficGroupId());
            additionalInfo.setExperimentGroupId(this.f67239g.getExperimentGroupId());
        }
        additionalInfo.setSdkVersion(d.l());
        return additionalInfo;
    }

    public final hn.c g() {
        CloudControlConfig.CodeSeat codeSeat;
        if (this.f67240h == null || (codeSeat = this.f67239g) == null) {
            return null;
        }
        if (this.f67236d == null) {
            this.f67236d = a(codeSeat);
        }
        return this.f67236d;
    }

    public int getSupportFlag() {
        return this.f67243k;
    }

    public final Network h() {
        CloudControlConfig.CodeSeat codeSeat = this.f67239g;
        if (codeSeat == null || codeSeat.getNetworks() == null) {
            return null;
        }
        for (Network network : this.f67239g.getNetworks()) {
            if (network != null && network.getSource().intValue() == 0) {
                return network;
            }
        }
        return null;
    }

    public boolean hasAd() {
        if (this.f67245m) {
            a(false, 3);
            AdLogUtil.Log().d("TBaseAd", "current object is destroyed");
            return false;
        }
        if (TextUtils.isEmpty(this.f67233a)) {
            a(false, 4);
            AdLogUtil.Log().d("TBaseAd", "isReady,mAdUnit is null");
            return false;
        }
        if (this.f67239g == null) {
            this.f67239g = h.a(this.f67233a);
        }
        CloudControlConfig.CodeSeat codeSeat = this.f67239g;
        if (codeSeat == null) {
            a(false, 5);
            AdLogUtil.Log().d("TBaseAd", "isReady,mCodeSeatConfig is null");
            return false;
        }
        AdCache cache = AdCacheManager.getCache(codeSeat.getCodeSeatType().intValue());
        if (cache == null) {
            a(false, 6);
            AdLogUtil.Log().d("TBaseAd", "isReady,no ad cache");
            return false;
        }
        boolean zHasAds = cache.hasAds(this.f67233a, this.f67249q);
        AdLogUtil.Log().d("TBaseAd", "isReady key " + this.f67233a + " hasAd " + zHasAds);
        a(zHasAds, 0);
        return zHasAds;
    }

    public final Network i() {
        ICacheAd cache;
        hn.c cVar = this.f67236d;
        if (cVar == null || (cache = cVar.I().getCache(this.f67233a, false, 0, this.f67249q)) == null) {
            return null;
        }
        return cache.getNetwork();
    }

    public boolean isLoaded() {
        return this.f67238f;
    }

    public final void j() {
        CloudControlConfig.CodeSeat codeSeat;
        if (this.f67240h == null || (codeSeat = this.f67239g) == null) {
            this.f67236d = null;
            return;
        }
        hn.c cVarA = a(codeSeat);
        this.f67236d = cVarA;
        if (cVarA != null) {
            cVarA.n(this.f67240h);
            this.f67236d.g(this.f67235c);
            this.f67236d.M(this.f67254v);
        }
    }

    public final void k() {
        this.f67239g = h.a(this.f67233a);
        b(false, !NetStateManager.checkNetworkState() ? 1 : 0);
        m();
        if (this.f67248p && !c()) {
            a(TAdErrorCode.ERROR_CODE_AD_IS_SHOWING);
            return;
        }
        this.f67238f = false;
        clearCurrentAd();
        this.f67237e = true;
        if (this.f67245m) {
            this.f67237e = false;
            a(TAdErrorCode.ERROR_CURRENT_OBJECT_IS_DESTROYED);
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd -->current object haved been destroyed");
            MediaLogUtil.e("TBaseAd", "current object haved been destroyed");
            return;
        }
        if (TextUtils.isEmpty(TAdManager.getAppId())) {
            this.f67237e = false;
            a(TAdErrorCode.ERROR_INVALID_APP_ID);
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> Network request is invalid, the appId or appToken must be valid ----- Current app id is:" + TAdManager.getAppId());
            MediaLogUtil.e("TBaseAd", "loadAdInternal,appId is empty");
            return;
        }
        CloudControlConfig.CodeSeat codeSeat = this.f67239g;
        if (codeSeat == null) {
            MediaLogUtil.e("TBaseAd", "loadAdInternal,config is null；codeSeatId = " + this.f67233a);
            this.f67237e = false;
            CloudControlConfigSync.b(6);
            int iE = da.a.d().e(ComConstants.Pref.CLOUD_CONFIG_ERROR_CODE);
            if (iE != 0) {
                a(ComConstants.transferCloudErrorCode(iE));
                return;
            } else {
                a(TAdErrorCode.ERROR_AD_UNIT_CONFIG_EMPTY);
                return;
            }
        }
        this.f67247o = codeSeat.getCodeSeatType().intValue();
        if (Boolean.FALSE.equals(this.f67239g.getCloudControlEnable())) {
            MediaLogUtil.e("TBaseAd", "loadAdInternal,config is closed");
            this.f67237e = false;
            a(TAdErrorCode.ERROR_CLOUD_AD_SEAT_IS_CLOSED);
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> current ad unit is close ");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jC = y.c(jCurrentTimeMillis);
        long jB = y.b(jCurrentTimeMillis);
        if (this.f67239g.getAdShowCountLimitDay().intValue() == 0 || (this.f67239g.getAdShowCountLimitDay().intValue() != -1 && jC == this.f67239g.getTodayZeroClock() && this.f67239g.getTodayShowTimes() >= this.f67239g.getAdShowCountLimitDay().intValue())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad show times can not exceed day show max");
            MediaLogUtil.e("TBaseAd", "ad show times reach the limit of day,day showTimes " + this.f67239g.getAdShowCountLimitDay());
            this.f67237e = false;
            a(TAdErrorCode.ERROR_AD_SHOW_TIMES_OUT_OF_DAY);
            return;
        }
        if (this.f67239g.getAdShowCountLimitHour().intValue() == 0 || (this.f67239g.getAdShowCountLimitHour().intValue() != -1 && jB == this.f67239g.getCurrentHourZeroClock() && this.f67239g.getCurrentHourShowTimes() >= this.f67239g.getAdShowCountLimitHour().intValue())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad display has reached the limit of hours");
            MediaLogUtil.e("TBaseAd", "ad display has reached the limit of hour,hour showTimes " + this.f67239g.getAdShowCountLimitHour());
            this.f67237e = false;
            a(TAdErrorCode.ERROR_AD_SHOW_TIMES_OUT_OF_HOUR);
            return;
        }
        long lastShowTime = jCurrentTimeMillis - this.f67239g.getLastShowTime();
        if (lastShowTime <= 0) {
            lastShowTime = -lastShowTime;
        }
        if (this.f67239g.getAdShowTimeInterval().intValue() != -1000 && lastShowTime <= this.f67239g.getAdShowTimeInterval().intValue()) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad display did not reach the interval");
            MediaLogUtil.e("TBaseAd", "ad display did not reach the interval,time " + this.f67239g.getAdShowTimeInterval());
            this.f67237e = false;
            a(TAdErrorCode.ERROR_AD_SHOW_NOT_IN_INTERVAL);
            return;
        }
        this.f67243k = c(this.f67239g);
        j();
        if (!a(e())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> code seat type does not match request type");
            MediaLogUtil.e("TBaseAd", "code seat type does not match request type ---> " + this.f67239g.getCodeSeatType());
            this.f67237e = false;
            a(TAdErrorCode.ERROR_AD_TYPE_LOAD_INCONSISTENCY);
            return;
        }
        this.f67239g = m.a(this.f67239g);
        if (NetStateManager.checkNetworkState()) {
            p();
            r();
            return;
        }
        AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> net error ");
        MediaLogUtil.e("TBaseAd", "net error");
        this.f67237e = false;
        Network networkH = h();
        hn.c cVarG = g();
        if (networkH == null || cVarG == null || !cVarG.d0()) {
            a(TAdErrorCode.ERROR_FILL_FAILED_WITH_NETWORK_EXCEPTION);
            return;
        }
        cVarG.f(this.f67258z);
        cVarG.J(this.f67239g.getAdRequestCount().intValue());
        if (cVarG.r(this.f67239g, networkH)) {
            return;
        }
        a(TAdErrorCode.ERROR_FILL_FAILED_WITH_NETWORK_EXCEPTION);
    }

    public void l() {
        if (this.f67240h == null) {
            return;
        }
        AdditionalInfo additionalInfoF = f();
        Network networkI = i();
        if (networkI != null) {
            additionalInfoF.setSource(networkI.getSource());
            additionalInfoF.setApplicationId(networkI.getApplicationId());
            additionalInfoF.setApplicationKey(networkI.getApplicationKey());
            additionalInfoF.setCodeSeatId(networkI.getCodeSeatId());
            additionalInfoF.setECPM(networkI.getPrice());
            additionalInfoF.setPrecision(AdUtil.isWaterFall(networkI.getSource().intValue()) ? "estimated" : "exact");
            additionalInfoF.setCurrency("USD");
            additionalInfoF.setBidding(Boolean.valueOf(AdUtil.isBiddingNetwork(networkI.getSource().intValue())));
            additionalInfoF.setMediatorSource(networkI.getMediatorSource());
        }
        this.f67240h.c(additionalInfoF);
    }

    public final void loadAd() {
        b(1);
    }

    public final void m() {
        if (this.f67240h != null) {
            this.f67240h.q(f());
        }
    }

    public void n() {
        a((TAdNativeInfo) null);
    }

    public final void o() {
        s sVar = this.f67240h;
        if (sVar != null) {
            sVar.h(null);
            this.f67240h.g(null);
            this.f67240h.i(null);
        }
        this.f67240h = null;
        this.f67239g = null;
        RecordTestInfo.destroy();
        setIsShowing(false);
        clearCurrentAd();
        hn.c cVar = this.f67236d;
        if (cVar != null) {
            cVar.w();
            this.f67236d = null;
        }
        if (this.f67237e) {
            trackingAdLoaded(TAdErrorCode.CODE_CURRENT_OBJECT_IS_DESTROYED, TAdErrorCode.ERROR_CURRENT_OBJECT_IS_DESTROYED.getErrorMessage(), -1);
        }
        this.f67237e = false;
        this.f67245m = true;
    }

    public final void p() {
        CloudControlConfig.CodeSeat codeSeat = this.f67239g;
        if (codeSeat != null) {
            this.f67242j = codeSeat.getAdRequestTimeout().intValue() * 1000;
        }
        if (this.f67242j > 0) {
            if (this.f67235c == null) {
                this.f67235c = new RunTimer();
            }
            this.f67235c.b();
            this.f67235c.e(this.f67255w);
            this.f67235c.d(this.f67242j);
            this.f67235c.c();
        }
    }

    public void pause() {
        hn.c cVar = this.f67236d;
        if (cVar != null) {
            cVar.h0();
        }
    }

    public final void preload() {
        loadAd();
    }

    public void q() {
    }

    public final void r() {
        if (this.f67239g == null) {
            MediaLogUtil.e("TBaseAd", "startLoadMediation codeSeat is null");
            a(TAdErrorCode.ERROR_AD_UNIT_CONFIG_EMPTY);
            return;
        }
        AdLogUtil.Log().i(ComConstants.AD_FLOW, "*----> TBaseAd - current cloudConfig is " + this.f67239g.toString());
        List<Network> networks = this.f67239g.getNetworks();
        if (networks == null || networks.isEmpty()) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad is empty ");
            MediaLogUtil.e("TBaseAd", "startLoadMediation,network is empty");
            a(TAdErrorCode.ERROR_AD_SOURCE_LIST_IS_EMPTY);
            return;
        }
        hn.c cVarG = g();
        if (cVarG != null) {
            cVarG.f(this.f67258z);
            if (cVarG.q(this.f67234b)) {
                return;
            }
            MediaLogUtil.e("TBaseAd", "prepare for request failed");
            a(TAdErrorCode.ERROR_PREPARE_REQUEST_FAILED);
        }
    }

    public void resume() {
        hn.c cVar = this.f67236d;
        if (cVar != null) {
            cVar.l0();
        }
    }

    public final void s() {
        RunTimer runTimer = this.f67235c;
        if (runTimer != null) {
            runTimer.b();
            this.f67235c = null;
        }
    }

    public void setAdLoadScenes(String str, String str2, Map<String, Object> map) {
        this.f67250r = str;
        this.f67251s = str2;
        this.f67252t = map;
    }

    public void setCodeSeatType(int i11) {
        this.f67247o = i11;
    }

    public void setContainVulgarContent(boolean z11) {
        this.f67249q = z11;
    }

    public void setCurrActivityFullscreen(boolean z11) {
        this.f67253u = z11;
    }

    public void setIsShowing(boolean z11) {
        this.f67248p = z11;
    }

    public void setLoaded(boolean z11) {
        this.f67238f = z11;
    }

    public void setLoading(boolean z11) {
        this.f67237e = z11;
    }

    public void setRequestBody(TAdRequestBody tAdRequestBody) {
        if (tAdRequestBody == null) {
            return;
        }
        b();
        this.f67242j = tAdRequestBody.getScheduleTime();
        s sVar = this.f67240h;
        if (sVar != null) {
            sVar.h(tAdRequestBody.getAdListener());
            this.f67240h.i(tAdRequestBody.getAdditionalListener());
        }
    }

    public void stopTimer() {
        Preconditions.d(new c());
    }

    public void t() {
        if (this.f67240h != null) {
            if (NetStateManager.checkNetworkState()) {
                TAdErrorCode tAdErrorCode = TAdErrorCode.ERROR_TRIGGER_SHOW_ONLINE_NO_AD;
                trackingTriggerShowError(tAdErrorCode);
                this.f67240h.onShowError(tAdErrorCode);
            } else {
                TAdErrorCode tAdErrorCode2 = TAdErrorCode.ERROR_RIGGER_SHOW_OFFLINE_NO_AD;
                trackingTriggerShowError(tAdErrorCode2);
                this.f67240h.onShowError(tAdErrorCode2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00d1 A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:3:0x0024, B:5:0x0028, B:9:0x0037, B:11:0x0068, B:13:0x006c, B:18:0x0088, B:20:0x0094, B:26:0x00b1, B:28:0x00d1, B:30:0x00d7, B:32:0x00f8, B:35:0x0101, B:42:0x0195, B:39:0x018d, B:43:0x01a4, B:48:0x01c2, B:52:0x01fd, B:54:0x021c, B:55:0x0225, B:57:0x0229, B:58:0x023f, B:60:0x0248, B:61:0x0274, B:65:0x0280, B:69:0x028e, B:68:0x028a, B:64:0x027c, B:51:0x01f9, B:47:0x01be, B:21:0x009a, B:23:0x009e), top: B:73:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00d6  */
    public void trackingAdLoaded(int i11, String str, int i12) {
        double d11;
        Bundle bundle;
        Network network;
        Object obj;
        try {
            if (this.f67258z == null) {
                AdLogUtil.Log().w(ComConstants.AD_FLOW, "mBundle is null");
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(TrackingKey.TRIGGER_ID, this.f67258z.getString(TrackingKey.TRIGGER_ID));
            bundle2.putLong(TrackingKey.TRIGGER_TS, this.f67258z.getLong(TrackingKey.TRIGGER_TS));
            bundle2.putInt("ad_type", this.f67258z.getInt("ad_type"));
            bundle2.putInt(TrackingKey.AD_TRIGGER_STATUS, this.f67258z.getInt(TrackingKey.AD_TRIGGER_STATUS));
            hn.c cVar = this.f67236d;
            ICacheAd cache = (cVar == null || this.f67239g == null) ? null : cVar.I().getCache(this.f67239g.getCodeSeatId(), false, this.f67243k, this.f67249q);
            if (cache != null) {
                double ecpmPrice = cache.getEcpmPrice();
                Network network2 = cache.getNetwork();
                if (cache instanceof BaseAd) {
                    bundle = ((BaseAd) cache).mBundle;
                } else {
                    if (cache instanceof AdNativeInfo) {
                        bundle = ((AdNativeInfo) cache).getNativeAdWrapper().getAdImpl().mBundle;
                    } else {
                        bundle = null;
                    }
                    AdLogUtil adLogUtilLog = AdLogUtil.Log();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("trackingAdLoaded --> isNative = ");
                    sb2.append(cache instanceof AdNativeInfo);
                    sb2.append(" 设置标识符 contextBundle.PLATFORM=");
                    if (bundle != null) {
                        obj = bundle.get(TrackingKey.PLATFORM);
                    } else {
                        obj = null;
                    }
                    sb2.append(obj);
                    adLogUtilLog.d("TBaseAd", sb2.toString());
                    bundle2.putInt(TrackingKey.IS_OFFLINE_AD, cache.isOfflineAd() ? 1 : 0);
                    network = network2;
                    d11 = ecpmPrice;
                }
                AdLogUtil adLogUtilLog2 = AdLogUtil.Log();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("trackingAdLoaded --> isNative = ");
                sb3.append(cache instanceof AdNativeInfo);
                sb3.append(" 设置标识符 contextBundle.PLATFORM=");
                if (bundle != null) {
                    obj = bundle.get(TrackingKey.PLATFORM);
                } else {
                    obj = null;
                }
                sb3.append(obj);
                adLogUtilLog2.d("TBaseAd", sb3.toString());
                bundle2.putInt(TrackingKey.IS_OFFLINE_AD, cache.isOfflineAd() ? 1 : 0);
                network = network2;
                d11 = ecpmPrice;
            } else {
                d11 = 0.0d;
                bundle = null;
                network = null;
            }
            a(bundle2, d11);
            if (bundle != null) {
                bundle2.putInt(TrackingKey.IS_PRE_TRIGGER, bundle.getInt(TrackingKey.IS_PRE_TRIGGER));
                bundle2.putInt(TrackingKey.REQUEST_TYPE, bundle.getInt(TrackingKey.REQUEST_TYPE));
                bundle2.putInt(TrackingKey.PLATFORM, bundle.getInt(TrackingKey.PLATFORM));
                bundle2.putString("app_id", bundle.getString("app_id"));
                bundle2.putString(TrackingKey.CODE_SEAT_ID, bundle.getString(TrackingKey.CODE_SEAT_ID));
                bundle2.putDouble(TrackingKey.BIDDING_PRICE, bundle.getDouble(TrackingKey.BIDDING_PRICE));
                bundle2.putInt(TrackingKey.PRIORITY, bundle.getInt(TrackingKey.PRIORITY));
                bundle2.putInt(TrackingKey.AD_COUNT, bundle.getInt(TrackingKey.AD_COUNT));
                bundle2.putInt(TrackingKey.IS_RETREATAD, bundle.getInt(TrackingKey.IS_RETREATAD));
                bundle2.putString(TrackingKey.REQUEST_ID, bundle.getString(TrackingKey.REQUEST_ID));
                RecordTestInfo.record("adTrackingFilling code_seat_id:" + bundle.getString(TrackingKey.CODE_SEAT_ID) + ",platform:" + bundle.getInt(TrackingKey.PLATFORM) + ",bidding_price:" + bundle.getDouble(TrackingKey.BIDDING_PRICE));
                bundle2.putInt(TrackingKey.REQUEST_NUM, bundle.getInt(TrackingKey.REQUEST_NUM));
                int i13 = 1;
                if (bundle.getInt(TrackingKey.AD_TRIGGER_STATUS) == 1) {
                    i13 = 3;
                } else if (cache.isOfflineAd()) {
                    i13 = 2;
                }
                bundle2.putInt(TrackingKey.FILLING_AD_TYPE, i13);
                bundle.putInt(TrackingKey.FILLING_AD_TYPE, i13);
                bundle2.putInt(TrackingKey.IS_PRELOAD, bundle.getInt(TrackingKey.IS_PRELOAD));
            }
            RecordTestInfo.record("adTrackingFilling");
            bundle2.putString(TrackingKey.CLD_APP_ID, this.f67258z.getString("app_id"));
            CloudControlConfig.CodeSeat codeSeat = this.f67239g;
            String experimentGroupId = "";
            bundle2.putString(TrackingKey.CLD_CODE_SEAT_ID, codeSeat == null ? "" : codeSeat.getCodeSeatId());
            int iL = 0;
            bundle2.putInt(TrackingKey.IS_TIMEOUT, 0);
            bundle2.putInt(TrackingKey.ERROR_CODE, i11);
            bundle2.putString(TrackingKey.ERROR_MESSAGE, TAdErrorCode.simpleErrorMessage(str));
            bundle2.putInt(TrackingKey.FILLING_SOURCE, i12);
            bundle2.putLong(TrackingKey.FILLING_TS, System.currentTimeMillis());
            bundle2.putInt(TrackingKey.INSTALL_FACEBOOK, ComConstants.isFbAppExist ? 1 : 0);
            hn.c cVar2 = this.f67236d;
            if (cVar2 != null) {
                iL = cVar2.L();
            }
            bundle2.putInt(TrackingKey.FILTER_COUNT, iL);
            bundle2.putInt(TrackingKey.OPTIMIZE_STATUS, this.f67258z.getInt(TrackingKey.OPTIMIZE_STATUS));
            bundle2.putInt(TrackingKey.PRIORITY_CODE, this.f67258z.getInt(TrackingKey.PRIORITY_CODE));
            hn.c cVar3 = this.f67236d;
            if (cVar3 != null) {
                bundle2.putDouble(TrackingKey.MAX_PRICE, cVar3.R());
            }
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg("fill result code : " + i11, RecordTestInfo.LOG_CODE7);
            }
            bundle2.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.f67249q ? 1 : 0);
            if (network != null) {
                bundle2.putDouble(TrackingKey.BIDDING_PRICE, network.getPrice().doubleValue());
                bundle2.putDouble(TrackingKey.PRICE_COEFFICIENT, network.getShowPriceCoefficient().doubleValue());
                bundle2.putInt(TrackingKey.PLATFORM, network.getSource().intValue());
                bundle2.putString(TrackingKey.MEDIATOR_SOURCE, network.getMediatorSource());
            }
            CloudControlConfig.CodeSeat codeSeat2 = this.f67239g;
            bundle2.putString(TrackingKey.TRAFFIC_GROUP_ID, codeSeat2 == null ? "" : codeSeat2.getTrafficGroupId());
            CloudControlConfig.CodeSeat codeSeat3 = this.f67239g;
            if (codeSeat3 != null) {
                experimentGroupId = codeSeat3.getExperimentGroupId();
            }
            bundle2.putString(TrackingKey.EXPERIMENT_GROUP_ID, experimentGroupId);
            TrackingManager.trackingAdLoaded(bundle2);
        } catch (Exception e11) {
            AdLogUtil.Log().e(Log.getStackTraceString(e11));
        }
    }

    public void trackingTriggerShowError(TAdErrorCode tAdErrorCode) {
        Bundle bundle = new Bundle();
        try {
            Bundle bundle2 = this.f67258z;
            if (bundle2 != null) {
                bundle.putString(TrackingKey.TRIGGER_ID, bundle2.getString(TrackingKey.TRIGGER_ID));
                bundle.putLong(TrackingKey.TRIGGER_TS, this.f67258z.getLong(TrackingKey.TRIGGER_TS));
                bundle.putDouble(TrackingKey.BIDDING_PRICE, this.f67258z.getDouble(TrackingKey.BIDDING_PRICE));
                bundle.putInt(TrackingKey.PLATFORM, this.f67258z.getInt(TrackingKey.PLATFORM));
            } else {
                bundle.putString(TrackingKey.TRIGGER_ID, TrackingUtil.getTriggerId());
                bundle.putLong(TrackingKey.TRIGGER_TS, System.currentTimeMillis());
            }
            if (this.f67239g == null) {
                this.f67239g = h.a(this.f67233a);
            }
            bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
            bundle.putString("app_id", TAdManager.getAppId());
            bundle.putString(TrackingKey.CODE_SEAT_ID, this.f67233a);
            bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f67233a);
            bundle.putInt("ad_type", e());
            CloudControlConfig.CodeSeat codeSeat = this.f67239g;
            if (codeSeat != null) {
                bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, codeSeat.getTrafficGroupId());
                bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.f67239g.getExperimentGroupId());
            }
            if (tAdErrorCode != null) {
                bundle.putString(TrackingKey.ERROR_CODE, String.valueOf(tAdErrorCode.getErrorCode()));
                bundle.putString(TrackingKey.ERROR_MESSAGE, TAdErrorCode.simpleErrorMessage(tAdErrorCode.getErrorMessage()));
            }
            bundle.putInt(TrackingKey.IS_OFFLINE, !NetStateManager.checkNetworkState() ? 1 : 0);
            Network networkI = i();
            if (networkI != null) {
                bundle.putString(TrackingKey.MEDIATOR_SOURCE, networkI.getMediatorSource());
            }
            TrackingManager.trackingTriggerShow(bundle);
        } catch (Exception e11) {
            AdLogUtil.Log().e(ComConstants.AD_FLOW, Log.getStackTraceString(e11));
        }
    }
}
