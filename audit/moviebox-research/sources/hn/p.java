package hn;

import android.content.Context;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TInnerAdRequestBody;
import com.hisavana.common.interfacz.Iad;
import com.hisavana.common.interfacz.QueryPriceListener;
import com.hisavana.common.interfacz.WrapTAdAllianceListener;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.handler.DispatcherHandler;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class p<T extends Iad> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CloudControlConfig.CodeSeat f66614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f66615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f66616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f66617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q f66618f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DispatcherHandler<T> f66621i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f66613a = "PreloadHandler";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CopyOnWriteArrayList<T> f66619g = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f66620h = new AtomicInteger();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f66622j = 1;

    /* JADX INFO: compiled from: source.java */
    public class a implements QueryPriceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f66623a;

        public a(Context context) {
            this.f66623a = context;
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceFailed() {
            AdLogUtil.Log().d("PreloadHandler", "receive query price failed");
            p.this.e(this.f66623a, null);
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceSuccess(List<Network> list) {
            AdLogUtil.Log().d("PreloadHandler", "CacheHandler --> queryPrice --> receive query price success");
            p.this.e(this.f66623a, list);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends WrapTAdAllianceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f66625a;

        public b(T t11) {
            this.f66625a = t11;
        }

        public final void a() {
            p.this.f66620h.decrementAndGet();
            if (this.f66625a == null) {
                AdLogUtil.Log().d("PreloadHandler", "mExecuter is null");
                return;
            }
            AdLogUtil.Log().d("PreloadHandler", "*----> request ad success, adSource:" + this.f66625a.getAdSource() + ", ad placementId: " + this.f66625a.getPlacementId() + ",mFlightingAdCount.get() = " + p.this.f66620h.get());
            this.f66625a.setLoadStatus(2);
            if (o.g(this.f66625a)) {
                if (this.f66625a.getNetwork() != null) {
                    this.f66625a.getNetwork().setPrice(Double.valueOf(this.f66625a.getEcpmPrice()));
                }
                T t11 = this.f66625a;
                if (t11 instanceof BaseAd) {
                    ((BaseAd) t11).mBundle.putDouble(TrackingKey.BIDDING_PRICE, t11.getEcpmPrice());
                } else if (t11 instanceof AdNativeInfo) {
                    ((AdNativeInfo) t11).getNativeAdWrapper().getAdImpl().mBundle.putDouble(TrackingKey.BIDDING_PRICE, this.f66625a.getEcpmPrice());
                }
                p.this.f66621i.h(p.this.f66619g);
            }
            if (p.this.j() || p.this.f66621i.k(p.this.f66619g)) {
                return;
            }
            p.this.m();
        }

        @Override // com.hisavana.common.interfacz.WrapTAdAllianceListener, com.hisavana.common.interfacz.TInnerAdListener
        public void onError(TAdErrorCode tAdErrorCode) {
            p.this.f66620h.decrementAndGet();
            T t11 = this.f66625a;
            if (t11 == null) {
                AdLogUtil.Log().d("PreloadHandler", "mExecuter is null");
                return;
            }
            t11.setLoadStatus(3);
            AdLogUtil adLogUtilLog = AdLogUtil.Log();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("*----> request ad fail,error code: ");
            sb2.append(tAdErrorCode != null ? Integer.valueOf(tAdErrorCode.getErrorCode()) : null);
            sb2.append(",adSource:");
            sb2.append(this.f66625a.getAdSource());
            sb2.append(", ad placementId: ");
            sb2.append(this.f66625a.getPlacementId());
            sb2.append(",mFlightingAdCount.get() = ");
            sb2.append(p.this.f66620h.get());
            adLogUtilLog.d("PreloadHandler", sb2.toString());
            if (p.this.j() || p.this.f66621i.k(p.this.f66619g)) {
                return;
            }
            p.this.m();
        }

        @Override // com.hisavana.common.interfacz.TInnerAdListener
        public void onLoad() {
            a();
        }

        @Override // com.hisavana.common.interfacz.WrapTAdAllianceListener
        public void onLoad(List<TAdNativeInfo> list) {
            a();
        }
    }

    public p(CloudControlConfig.CodeSeat codeSeat, i iVar) {
        this.f66614b = codeSeat;
        this.f66615c = iVar;
        this.f66616d = codeSeat == null ? "" : codeSeat.getCodeSeatId();
        this.f66617e = codeSeat == null ? -1 : codeSeat.getCodeSeatType().intValue();
        this.f66618f = new q(iVar, codeSeat, true);
        this.f66621i = new DispatcherHandler<>(codeSeat, iVar);
    }

    public TInnerAdRequestBody a(T t11) {
        return new TInnerAdRequestBody.Builder().setAdListener(new b(t11)).build();
    }

    public void c() {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.f66619g;
        if (copyOnWriteArrayList != null) {
            for (T t11 : copyOnWriteArrayList) {
                if (t11 != null) {
                    t11.stopLoader();
                }
            }
            this.f66619g.clear();
        }
        q qVar = this.f66618f;
        if (qVar != null) {
            qVar.n();
        }
    }

    public void d(Context context) {
        if (g(this.f66614b)) {
            this.f66620h.set(0);
            this.f66619g.clear();
            this.f66618f.l();
            i(context);
        }
    }

    public final void e(Context context, List<Network> list) {
        CopyOnWriteArrayList<T> copyOnWriteArrayListG = this.f66621i.g(context, list, this.f66618f.o(), this.f66618f.r(), true);
        this.f66619g = copyOnWriteArrayListG;
        if (copyOnWriteArrayListG == null || copyOnWriteArrayListG.isEmpty()) {
            AdLogUtil.Log().d("PreloadHandler", "*----> no ad source can be preload.");
        } else {
            m();
        }
    }

    public final boolean g(CloudControlConfig.CodeSeat codeSeat) {
        int iIntValue = codeSeat.getPreload().booleanValue() ? codeSeat.getPreloadLogic().intValue() : -1;
        if (iIntValue == -1) {
            AdLogUtil.Log().w("PreloadHandler", "current code seat id is " + this.f66616d + "preload is close...");
            return false;
        }
        AdCache<Y> adCacheB = this.f66621i.b();
        if (iIntValue != 1 || adCacheB == 0 || !adCacheB.hasAds(codeSeat.getCodeSeatId(), this.f66615c.F())) {
            return true;
        }
        AdLogUtil.Log().w("PreloadHandler", "autoAppend & INSUFFICIENT_APPEND,but adunit:" + this.f66616d + " has cached ad, load/preload/trigger_preload request end");
        return false;
    }

    public final void i(Context context) {
        RecordTestInfo.record("fanbidding queryPrice,codeSeatId:" + this.f66616d);
        this.f66618f.d(new a(context));
    }

    public final boolean j() {
        return this.f66620h.get() > 0;
    }

    public final boolean k(T t11) {
        boolean zJ = false;
        if (t11 == null) {
            return false;
        }
        int loadStatus = t11.getLoadStatus();
        AdLogUtil.Log().d("PreloadHandler", "codeSeatId is" + this.f66616d + ":ad source is " + t11.getAdSource() + ", load status is " + loadStatus);
        if (loadStatus != 1 && loadStatus != 3 && loadStatus != 2) {
            TInnerAdRequestBody tInnerAdRequestBodyA = a(t11);
            this.f66620h.addAndGet(1);
            zJ = this.f66621i.j(t11, 2, this.f66622j, tInnerAdRequestBodyA);
            if (zJ) {
                this.f66618f.f(t11.getNetwork(), true);
            }
        }
        return zJ;
    }

    public final void m() {
        RecordTestInfo.record("load ad num: 1 with group");
        int i11 = 0;
        for (T t11 : this.f66619g) {
            if (t11 != null) {
                if (o.g(t11)) {
                    if (k(t11)) {
                        i iVar = this.f66615c;
                        iVar.v(iVar.B() + 1);
                    }
                } else if (i11 == 0 && k(t11)) {
                    i iVar2 = this.f66615c;
                    iVar2.v(iVar2.B() + 1);
                    i11++;
                }
            }
        }
    }
}
