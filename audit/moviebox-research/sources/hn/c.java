package hn;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.util.RunTimer;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TInnerAdRequestBody;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.interfacz.Iad;
import com.hisavana.common.interfacz.QueryPriceListener;
import com.hisavana.common.interfacz.WrapTAdAllianceListener;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.hisavana.mediation.R$string;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.handler.DispatcherHandler;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class c<T extends Iad, C> {
    public Bundle A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f66550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f66551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RunTimer f66552c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f66554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f66555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f66556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f66557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C f66558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f66559j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f66563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CloudControlConfig.CodeSeat f66564o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f66566q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f66568s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DispatcherHandler<T> f66571v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f66572w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public p<T> f66573x;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CopyOnWriteArrayList<T> f66553d = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f66560k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f66561l = new AtomicInteger();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f66562m = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f66565p = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f66567r = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f66569t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f66570u = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f66574y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AdCache.AdCacheExpiredWatcher f66575z = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements AdCache.AdCacheExpiredWatcher {
        public a() {
        }

        @Override // com.hisavana.common.bean.AdCache.AdCacheExpiredWatcher
        public void onExpired(ICacheAd iCacheAd) {
            AdLogUtil.Log().d("CacheHandler", "ad expired");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1001) {
                AdLogUtil.Log().w("CacheHandler", "receive MSG_REQUEST_NEXT_GROUP_WAITING...");
                c.this.D(true);
            } else if (i11 == 1002) {
                AdLogUtil.Log().w("CacheHandler", "receive MSG_BIDDING_WAITING...");
                c.this.Q(1);
            } else {
                Object obj = message.obj;
                if (obj instanceof Iad) {
                    ((Iad) obj).loadAd();
                }
            }
        }
    }

    /* JADX INFO: renamed from: hn.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0699c implements QueryPriceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f66578a;

        public C0699c(Context context) {
            this.f66578a = context;
        }

        public final void a(List<Network> list) {
            double ecpmPrice;
            if (list == null || list.isEmpty() || c.this.f0()) {
                return;
            }
            AdLogUtil.Log().d("CacheHandler", "--- load ad mode --- ");
            Iterator it = c.this.f66553d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    ecpmPrice = 0.0d;
                    break;
                }
                Iad iad = (Iad) it.next();
                if (iad != null && iad.getLoadStatus() == 0) {
                    ecpmPrice = iad.getEcpmPrice();
                    break;
                }
            }
            AdLogUtil.Log().d("CacheHandler", "checkToLoadWaterfallAd priceThreshold --- ," + ecpmPrice);
            for (Network network : list) {
                Iad iadD = c.this.f66571v.d(this.f66578a, c.this.f66564o, network);
                if (iadD != null) {
                    c.this.f66553d.add(iadD);
                    if (network.getPrice().doubleValue() >= ecpmPrice) {
                        c.this.B(iadD, 1);
                    }
                }
            }
            c.this.f66571v.h(c.this.f66553d);
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceFailed() {
            AdLogUtil.Log().d("CacheHandler", "receive query price failed");
            a(null);
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceSuccess(List<Network> list) {
            AdLogUtil.Log().d("CacheHandler", "CacheHandler --> queryPrice --> receive query price success");
            a(list);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends WrapTAdAllianceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f66580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C f66581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f66582c;

        public d(T t11, int i11) {
            this.f66580a = t11;
            this.f66582c = i11;
        }

        public final String a() {
            int i11 = c.this.f66563n;
            if (i11 == 0) {
                return null;
            }
            if (i11 == 1) {
                return "PROGRESS_REQUEST";
            }
            return i11 == 2 ? "PROGRESS_BIDDING" : "PROGRESS_DISPATCHED";
        }

        public final void b() {
            c.this.f66561l.decrementAndGet();
            T t11 = this.f66580a;
            if (t11 == null) {
                AdLogUtil.Log().d("CacheHandler", "mExecuter is null");
                return;
            }
            t11.setLoadStatus(2);
            c cVar = c.this;
            cVar.f66562m = cVar.f66563n == 1;
            c.this.j(this.f66580a);
            AdLogUtil.Log().d("CacheHandler", "*----> onLoaded(),mProgress = " + a() + ",mFlightingAdCount.get() = " + c.this.f66561l.get() + ",ad fill adSource:" + this.f66580a.getAdSource() + ", ad placementId: " + this.f66580a.getPlacementId());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ad onAdLoaded,adSource ");
            sb2.append(this.f66580a.getAdSource());
            sb2.append(",id ");
            sb2.append(this.f66580a.getPlacementId());
            MediaLogUtil.d("CacheHandler", sb2.toString());
            c.this.i0();
            if (this.f66582c == 5) {
                c.this.p(this.f66581b, 3);
                return;
            }
            AdLogUtil.Log().d("CacheHandler", "onAdLoaded requestCategory " + this.f66582c);
            c cVar2 = c.this;
            AdCache adCacheI = cVar2.I();
            c cVar3 = c.this;
            cVar2.f66550a = adCacheI.getMaxPrice(cVar3.f66559j, cVar3.f66572w.F());
            boolean zA0 = c.this.a0();
            if (c.this.e0()) {
                AdLogUtil.Log().d("CacheHandler", "first ad request successfully, quick fill");
                c.this.F(5);
                if ((c.this.f66570u == 2 || !zA0) && !c.this.f66571v.k(c.this.f66553d)) {
                    c.this.D(this.f66582c == 1);
                    return;
                } else {
                    c.this.k0();
                    return;
                }
            }
            boolean zM0 = c.this.m0();
            AdLogUtil.Log().d("CacheHandler", "onAdLoaded startBiddingIfNeed " + zM0 + " haveFlightingAd " + c.this.f66561l.get());
            if (!zM0 && (c.this.f66570u == 2 || !zA0)) {
                c.this.D(this.f66582c == 1);
            }
            if (c.this.X() && c.this.Z()) {
                c.this.F(4);
            }
        }

        @Override // com.hisavana.common.interfacz.WrapTAdAllianceListener, com.hisavana.common.interfacz.TInnerAdListener
        public void onError(TAdErrorCode tAdErrorCode) {
            c.this.f66561l.decrementAndGet();
            T t11 = this.f66580a;
            if (t11 == null) {
                AdLogUtil.Log().d("CacheHandler", "mExecuter is null");
                return;
            }
            t11.setLoadStatus(3);
            AdLogUtil adLogUtilLog = AdLogUtil.Log();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("*----> request ad fail,error code: ");
            sb2.append(tAdErrorCode != null ? Integer.valueOf(tAdErrorCode.getErrorCode()) : null);
            sb2.append(",adSource:");
            sb2.append(this.f66580a.getAdSource());
            sb2.append(", ad placementId: ");
            sb2.append(this.f66580a.getPlacementId());
            sb2.append(",mFlightingAdCount.get() = ");
            sb2.append(c.this.f66561l.get());
            sb2.append(" progress ");
            sb2.append(c.this.f66563n);
            adLogUtilLog.d("CacheHandler", sb2.toString());
            c.this.i0();
            MediaLogUtil.d("CacheHandler", "ad load Error,source " + this.f66580a.getAdSource() + ",id " + this.f66580a.getPlacementId());
            int i11 = this.f66582c;
            if (i11 != 1) {
                if (i11 != 5) {
                    return;
                }
                c.this.h(TAdErrorCode.ERROR_FILL_FAILED_WITH_NO_AD);
                AdLogUtil.Log().w("CacheHandler", "onError take default ad failed,no ad fill");
                return;
            }
            AdLogUtil.Log().d("CacheHandler", "onError current is load");
            if (!c.this.e0()) {
                if (c.this.m0()) {
                    return;
                }
                if ((!c.this.a0() || c.this.f66570u == 2) && !c.this.D(true) && !c.this.a0() && c.this.X()) {
                    c.this.h(TAdErrorCode.ERROR_FILL_FAILED_WITH_BIDDING_READY);
                    return;
                }
                return;
            }
            if (((!c.this.a0() || c.this.f66570u == 2) && !c.this.f66571v.k(c.this.f66553d) && c.this.D(true)) || c.this.a0()) {
                return;
            }
            if (c.this.Z()) {
                c.this.F(2);
            } else {
                c.this.h(TAdErrorCode.ERROR_FILL_FAILED_WITH_NO_AD);
            }
        }

        @Override // com.hisavana.common.interfacz.TInnerAdListener
        public void onLoad() {
            this.f66581b = this.f66580a;
            b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.hisavana.common.interfacz.WrapTAdAllianceListener
        public void onLoad(List<TAdNativeInfo> list) {
            this.f66581b = list;
            b();
        }

        @Override // com.hisavana.common.interfacz.WrapTAdAllianceListener, com.hisavana.common.interfacz.TInnerAdListener
        public void onNativeFeedShow(int i11, TAdNativeInfo tAdNativeInfo, @NonNull AdditionalInfo additionalInfo) {
            super.onNativeFeedShow(i11, tAdNativeInfo, additionalInfo);
            AdLogUtil.Log().d("CacheHandler", "*----> ad onshow() " + c.this.f66559j);
            if (c.this.a0()) {
                AdLogUtil.Log().d("CacheHandler", "currently have requesting ad,terminate preload flow.");
                return;
            }
            if (!NetStateManager.checkNetworkState()) {
                AdLogUtil.Log().d("CacheHandler", "network is disconnect");
                return;
            }
            if (c.this.f66573x == null) {
                c cVar = c.this;
                cVar.f66573x = new p(cVar.f66564o, cVar.f66572w);
            }
            c.this.f66573x.d(com.cloud.sdk.commonutil.util.f.a());
        }

        @Override // com.hisavana.common.interfacz.TInnerAdListener
        public void onSkipClick() {
            s sVar = c.this.f66551b;
            if (sVar != null) {
                sVar.onSkipClick();
            }
        }

        @Override // com.hisavana.common.interfacz.TInnerAdListener
        public void onTimeReach() {
            s sVar = c.this.f66551b;
            if (sVar != null) {
                sVar.onTimeReach();
            }
        }
    }

    public c(CloudControlConfig.CodeSeat codeSeat, i iVar, s sVar) {
        this.f66566q = -1;
        this.f66568s = 0;
        this.f66564o = codeSeat;
        this.f66572w = iVar;
        iVar.v(0);
        this.f66554e = new q(iVar, codeSeat, false);
        this.f66571v = new DispatcherHandler<>(codeSeat, iVar);
        this.f66557h = new b(Looper.getMainLooper());
        this.f66566q = codeSeat.getCodeSeatType().intValue();
        this.f66551b = sVar;
        this.f66559j = codeSeat.getCodeSeatId();
        I().registerWatcher(this.f66575z);
        this.f66568s = iVar.A();
    }

    public boolean A(int i11) {
        if (this.f66551b == null) {
            return false;
        }
        RecordTestInfo.record("load ad num: " + i11 + " with group");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("load next group,mReqCount ");
        sb2.append(i11);
        MediaLogUtil.d("CacheHandler", sb2.toString());
        int i12 = 0;
        boolean z11 = false;
        for (T t11 : this.f66553d) {
            if (t11 != null) {
                if (o.g(t11)) {
                    if (B(t11, 1)) {
                        i iVar = this.f66572w;
                        iVar.v(iVar.B() + 1);
                        z11 = true;
                    }
                } else if (i12 < i11 && B(t11, 1)) {
                    i iVar2 = this.f66572w;
                    iVar2.v(iVar2.B() + 1);
                    i12++;
                }
            }
        }
        return i12 > 0 || z11;
    }

    public final boolean B(T t11, int i11) {
        if (t11 == null) {
            return false;
        }
        TInnerAdRequestBody tInnerAdRequestBodyA = a(t11, i11);
        int loadStatus = t11.getLoadStatus();
        if (loadStatus == 1 || loadStatus == 3 || loadStatus == 2) {
            return false;
        }
        this.f66561l.addAndGet(1);
        boolean zJ = this.f66571v.j(t11, i11, this.f66567r, tInnerAdRequestBodyA);
        if (zJ) {
            this.f66554e.f(t11.getNetwork(), true);
        }
        return zJ;
    }

    public final boolean D(boolean z11) {
        if (!e0() && this.f66563n >= 2) {
            return false;
        }
        this.f66567r = z11 ? this.f66567r + 1 : this.f66567r;
        boolean zA = A(this.f66570u == 1 ? this.f66560k : 1);
        if (z11 && zA) {
            o0();
        }
        return zA;
    }

    public final void E() {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.f66553d;
        if (copyOnWriteArrayList != null) {
            for (T t11 : copyOnWriteArrayList) {
                if (t11 != null) {
                    t11.stopLoader();
                }
            }
            this.f66553d.clear();
        }
        this.f66551b = null;
        this.f66572w.v(0);
        this.f66567r = 0;
        p0();
        this.f66554e.n();
        I().unRegisterWatcher();
        Handler handler = this.f66557h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f66563n = 3;
        AdLogUtil.Log().d("CacheHandler", "----------------->destroy,mUseCache:" + this.f66558i);
        o(this.f66558i);
        this.f66558i = null;
        p<T> pVar = this.f66573x;
        if (pVar != null) {
            pVar.c();
        }
    }

    public final void F(int i11) {
        if (this.f66563n == 3) {
            return;
        }
        AdLogUtil.Log().w("CacheHandler", "notify load success");
        this.f66563n = 3;
        s sVar = this.f66551b;
        if (sVar != null) {
            sVar.l(i11);
            p0();
            this.f66551b.p();
        }
    }

    public void H(C c11) {
    }

    @NonNull
    public abstract <Y extends ICacheAd> AdCache<Y> I();

    public void J(int i11) {
        if (i11 > 0) {
            this.f66565p = i11;
        }
    }

    public int L() {
        return 0;
    }

    public void M(int i11) {
        this.f66574y = i11;
    }

    public int O() {
        return 1;
    }

    public final void Q(int i11) {
        if (!c0() || e0()) {
            return;
        }
        AdLogUtil.Log().w("CacheHandler", "*----> start bidding...");
        RecordTestInfo.record("start bidding,bidStartTimeType:" + i11);
        MediaLogUtil.d("CacheHandler", "startBidding,bidStartTimeType " + i11 + " BIDDING_DURATION_REACHED:1,HIGH_PRICE_RETURN:2");
        T(i11);
        this.f66563n = 2;
        k0();
        j0();
        this.f66550a = I().getMaxPrice(this.f66559j, this.f66572w.F());
        if (!Z()) {
            if (a0()) {
                AdLogUtil.Log().d("CacheHandler", "startBidding,ad is null but still have ad requesting");
                return;
            } else {
                AdLogUtil.Log().w("CacheHandler", "startBidding failed,no ad fill");
                h(TAdErrorCode.ERROR_FILL_FAILED_WITH_NO_AD);
                return;
            }
        }
        F(this.f66562m ? 1 : 2);
        AdLogUtil.Log().w("CacheHandler", "startBidding finish take bidding ad,and notifyLoadBest and unit id is " + this.f66559j);
        MediaLogUtil.d("CacheHandler", "bidding success,ad fill*****************");
    }

    public double R() {
        return this.f66550a;
    }

    public final void T(int i11) {
        for (T t11 : this.f66553d) {
            if (t11 != null) {
                t11.setTimeOut(true);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString(TrackingKey.TRIGGER_ID, this.A.getString(TrackingKey.TRIGGER_ID));
        bundle.putLong(TrackingKey.TRIGGER_TS, this.A.getLong(TrackingKey.TRIGGER_TS));
        bundle.putInt("ad_type", this.f66566q);
        bundle.putString(TrackingKey.CLD_APP_ID, AdManager.f29117b);
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.A.getString(TrackingKey.CODE_SEAT_ID));
        bundle.putInt(TrackingKey.BID_START_TIME_TYPE, i11);
        bundle.putFloat(TrackingKey.BID_START_DURATION, this.f66556g);
        try {
            bundle.putFloat(TrackingKey.TRIGGER_TO_BID_DURATION, System.currentTimeMillis() - this.A.getLong(TrackingKey.TRIGGER_TS));
        } catch (Exception unused) {
        }
        bundle.putString(TrackingKey.CLD_CONFIGURE_ID, da.a.d().i("cloudControlVersion"));
        bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, this.A.getString(TrackingKey.TRAFFIC_GROUP_ID));
        bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.A.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        TrackingManager.trackingStartBid(bundle);
    }

    public int U() {
        return this.f66568s;
    }

    public final boolean X() {
        s sVar;
        return this.f66563n == 2 && (sVar = this.f66551b) != null && this.f66558i == null && !(sVar.k() == null && this.f66551b.a() == null);
    }

    public boolean Z() {
        AdCache<Y> adCacheI = I();
        if (adCacheI == 0) {
            return false;
        }
        return adCacheI.hasAds(this.f66559j, this.f66572w.F());
    }

    public TInnerAdRequestBody a(T t11, int i11) {
        return new TInnerAdRequestBody.Builder().setAdListener(new d(t11, i11)).build();
    }

    public final boolean a0() {
        return this.f66561l.get() > 0;
    }

    public C c(boolean z11) {
        return this.f66558i;
    }

    public final boolean c0() {
        s sVar;
        return (this.f66563n != 1 || (sVar = this.f66551b) == null || (sVar.k() == null && this.f66551b.a() == null)) ? false : true;
    }

    public final String d(int i11) {
        if (i11 == 0) {
            return "NONE";
        }
        if (i11 == 1) {
            return "LOADING";
        }
        if (i11 != 2) {
            return i11 != 3 ? "" : "FAILED";
        }
        return "SUCCESS";
    }

    public abstract boolean d0();

    public void e() {
        E();
    }

    public boolean e0() {
        return this.f66569t == 2;
    }

    public void f(Bundle bundle) {
        this.A = bundle;
    }

    public final boolean f0() {
        return this.f66563n >= 2;
    }

    public final void g(RunTimer runTimer) {
        this.f66552c = runTimer;
    }

    public final void g0() {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.f66553d;
        if (copyOnWriteArrayList != null && (!copyOnWriteArrayList.isEmpty() || !this.f66554e.q().isEmpty())) {
            A(this.f66560k);
            AdLogUtil.Log().d("CacheHandler", "start WaitForBidding & startWaitForNextGroupRequest");
            n0();
            o0();
            return;
        }
        AdLogUtil.Log().d("CacheHandler", "*----> no ad source can be load.");
        if (!I().hasAds(this.f66559j, this.f66572w.F()) || e0()) {
            h(TAdErrorCode.ERROR_FILL_FAILED_WiTH_EXPIRED);
        } else {
            Q(2);
        }
    }

    public final void h(TAdErrorCode tAdErrorCode) {
        if (this.f66563n == 3) {
            return;
        }
        AdLogUtil.Log().w("CacheHandler", "notify load failed");
        p0();
        this.f66563n = 3;
        y(tAdErrorCode);
    }

    public void h0() {
        z(this.f66558i);
    }

    public void i(TInnerAdRequestBody tInnerAdRequestBody, s sVar) {
        WrapTAdAllianceListener adListener;
        if (tInnerAdRequestBody == null || (adListener = tInnerAdRequestBody.getAdListener()) == null) {
            return;
        }
        adListener.setAdListener(sVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i0() {
        if (LogSwitch.isDebug) {
            StringBuilder sb2 = new StringBuilder();
            int i11 = 0;
            for (T t11 : this.f66553d) {
                if (t11 != 0) {
                    if (t11 instanceof BaseAd) {
                        i11 = ((BaseAd) t11).mBundle.getInt(TrackingKey.RETURN_TIME);
                    } else if (t11 instanceof AdNativeInfo) {
                        i11 = ((AdNativeInfo) t11).getNativeAdWrapper().getAdImpl().mBundle.getInt(TrackingKey.RETURN_TIME);
                    }
                    boolean z11 = t11.getAdSource() == 1;
                    sb2.append(ComConstants.transferSourceToStr(t11.getAdSource()));
                    if (z11 && t11.getNetwork() != null) {
                        sb2.append("-");
                        sb2.append(t11.getNetwork().getMediatorSource());
                    }
                    sb2.append("，");
                    sb2.append(d(t11.getLoadStatus()));
                    sb2.append("，returnTime：");
                    sb2.append(i11);
                    sb2.append("\n");
                }
            }
            AdLogUtil.Log().d("CacheHandler", "--- executer list load status--- : " + sb2.toString());
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg(sb2.toString(), RecordTestInfo.LOG_CODE6);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(T t11) {
        int i11;
        if (t11 == 0 || t11.getNetwork() == null || !AdUtil.isBiddingNetwork(t11.getAdSource())) {
            return;
        }
        AdLogUtil.Log().d("CacheHandler", "replace cloud price use first price，firstprice：" + t11.getEcpmPrice() + "，cloud price：" + t11.getNetwork().getPrice());
        t11.getNetwork().setPrice(Double.valueOf(t11.getEcpmPrice()));
        if (t11 instanceof BaseAd) {
            ((BaseAd) t11).mBundle.putDouble(TrackingKey.BIDDING_PRICE, t11.getEcpmPrice());
        } else if (t11 instanceof AdNativeInfo) {
            ((AdNativeInfo) t11).getNativeAdWrapper().getAdImpl().mBundle.putDouble(TrackingKey.BIDDING_PRICE, t11.getEcpmPrice());
        }
        this.f66571v.h(this.f66553d);
        if (t11.isAdxAd() && ((i11 = this.f66568s) == 1 || i11 == 3)) {
            Q(2);
            return;
        }
        if (t11.isEwAd()) {
            int i12 = this.f66568s;
            if (i12 == 2 || i12 == 3) {
                Q(2);
            }
        }
    }

    public final void j0() {
        Handler handler = this.f66557h;
        if (handler != null) {
            handler.removeMessages(1002);
        }
    }

    public final void k0() {
        AdLogUtil.Log().w("CacheHandler", "removeWaitForNextGroupRequest...");
        Handler handler = this.f66557h;
        if (handler != null) {
            handler.removeMessages(1001);
        }
    }

    public void l0() {
        H(this.f66558i);
    }

    public final boolean m0() {
        boolean zK = this.f66571v.k(this.f66553d);
        AdLogUtil.Log().d("CacheHandler", "startBiddingIfNeed mProgress " + this.f66563n + " isExistReachableTopPrice " + zK);
        if (this.f66563n == 3 || !zK) {
            return false;
        }
        Q(2);
        return true;
    }

    public final void n(@NonNull s sVar) {
        this.f66551b = sVar;
    }

    public final void n0() {
        if (e0() || this.f66557h == null) {
            return;
        }
        AdLogUtil.Log().d("CacheHandler", "startWaitForBidding...");
        this.f66557h.removeMessages(1002);
        this.f66557h.sendEmptyMessageDelayed(1002, this.f66556g);
    }

    public abstract void o(C c11);

    public final void o0() {
        Handler handler;
        if (this.f66570u != 1 || (handler = this.f66557h) == null) {
            return;
        }
        handler.removeMessages(1001);
        this.f66557h.sendEmptyMessageDelayed(1001, this.f66555f);
    }

    public final void p(C c11, int i11) {
        s sVar = this.f66551b;
        if (sVar != null) {
            if (sVar.k() == null && this.f66551b.a() == null) {
                return;
            }
            AdLogUtil.Log().w("CacheHandler", " *----> start take default ad...");
            if (c11 == null) {
                h(TAdErrorCode.ERROR_FILL_FAILED_WITH_NO_AD);
                AdLogUtil.Log().w("CacheHandler", "take default ad failed,no ad fill");
            } else {
                F(i11);
                AdLogUtil.Log().w("CacheHandler", "finish take default ad,and notifyLoadBest ---");
            }
        }
    }

    public void p0() {
        if (this.f66552c != null) {
            AdLogUtil.Log().w("LoadHandler", "stop timer");
            this.f66552c.b();
            this.f66552c = null;
        }
    }

    public boolean q(Context context) {
        this.f66553d.clear();
        this.f66562m = false;
        this.f66561l.set(0);
        boolean z11 = this.f66574y == 2;
        this.f66556g = Math.max((z11 ? this.f66564o.getRealtimeBiddingWaitTime() : this.f66564o.getBiddingWaitTime()).intValue(), 500);
        this.f66555f = Math.max(this.f66564o.getAdRequestTimeInterval().intValue(), 500);
        this.f66560k = this.f66564o.getAdRequestConcurrentCount().intValue() <= 0 ? 1 : this.f66564o.getAdRequestConcurrentCount().intValue();
        this.f66565p = Math.max(1, Math.min(O(), this.f66564o.getAdRequestCount().intValue()));
        this.f66563n = 1;
        this.f66569t = (z11 ? this.f66564o.getRealtimeFillCallbackMode() : this.f66564o.getFillCallbackMode()).intValue();
        this.f66570u = this.f66564o.getRequestIntervalMode().intValue();
        if (LogSwitch.isDebug) {
            String str = String.format(com.cloud.sdk.commonutil.util.f.a().getString(R$string.hisavana_log_msg1), Integer.valueOf(this.f66556g), Integer.valueOf(this.f66555f), Integer.valueOf(this.f66560k), this.f66564o.getAdRequestCount(), this.f66564o.getPreload(), this.f66564o.getAdShowCountLimitDay(), this.f66564o.getAdShowCountLimitHour(), this.f66564o.getAdShowTimeInterval());
            RecordTestInfo.LogMsg(str, RecordTestInfo.LOG_CODE1);
            MediaLogUtil.d("CacheHandler", "prepareForRequest,config " + str);
        }
        if (LogSwitch.isDebug) {
            AdLogUtil.Log().i("CacheHandler", "*----> WaitBiddingTime:" + this.f66556g + ",WaitNextGroupRequestTime:" + this.f66555f + ",ConcurrentReqCount:" + this.f66560k + ",PoolAppendStrategy:" + this.f66564o.getPreloadLogic() + ",adRequestCount:" + this.f66564o.getAdRequestCount() + " ----- codeSeatId = " + this.f66564o.getCodeSeatId());
        }
        if (this.f66564o.getNetworks() == null || this.f66564o.getNetworks().size() == 0) {
            AdLogUtil.Log().w("CacheHandler", "adUnit:" + this.f66559j + " no networks , load/preload/trigger_preload request end");
            MediaLogUtil.e("CacheHandler", "prepareForRequest,networks is empty");
            return false;
        }
        if (e0() && Z()) {
            AdLogUtil.Log().d("CacheHandler", "-------->quick fill success ");
            F(5);
        }
        this.f66554e.l();
        this.f66553d = this.f66571v.g(context, this.f66554e.p(), this.f66554e.o(), this.f66554e.r(), false);
        x(context);
        g0();
        return true;
    }

    public boolean r(CloudControlConfig.CodeSeat codeSeat, Network network) {
        if (network == null || TextUtils.isEmpty(network.getCodeSeatId())) {
            return false;
        }
        return B(this.f66571v.d(com.cloud.sdk.commonutil.util.f.a(), codeSeat, network), 5);
    }

    public void w() {
        E();
    }

    public final void x(Context context) {
        RecordTestInfo.record("fanbidding queryPrice,codeSeatId:" + this.f66559j);
        this.f66554e.d(new C0699c(context));
    }

    public void y(TAdErrorCode tAdErrorCode) {
        s sVar = this.f66551b;
        if (sVar != null) {
            sVar.onError(tAdErrorCode);
        }
    }

    public void z(C c11) {
    }
}
