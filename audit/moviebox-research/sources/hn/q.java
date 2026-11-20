package hn;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBaseAdSummary;
import com.hisavana.common.interfacz.QueryPriceListener;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.R$string;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.handler.DispatcherHandler;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class q {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final hn.b f66627o = new hn.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f66629b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f66636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f66637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CloudControlConfig.CodeSeat f66638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f66639l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public i f66640m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AdCache f66641n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public QueryPriceListener f66628a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<BaseQueryPrice> f66630c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f66631d = new AtomicInteger();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Network> f66632e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Network> f66633f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Network> f66634g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Network> f66635h = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f66642a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, boolean z11) {
            super(looper);
            this.f66642a = z11;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 101) {
                return;
            }
            AdLogUtil.Log().d("QueryPriceCenter", "receive MSG_QUERY_TIME_OUT message");
            if (this.f66642a) {
                q.this.j(true);
            } else {
                q.this.k(true, null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements QueryPriceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Network f66644a;

        public b(Network network) {
            this.f66644a = network;
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceFailed() {
            q.this.f66631d.decrementAndGet();
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg(ComConstants.transferSourceToStr(this.f66644a.getSource().intValue()) + " query price failed; ", RecordTestInfo.LOG_CODE9);
            }
            if (q.this.f66636i) {
                q.this.j(false);
            } else {
                q.this.k(false, null);
            }
        }

        @Override // com.hisavana.common.interfacz.QueryPriceListener
        public void onQueryPriceSuccess(List<Network> list) {
            Network network;
            q.this.f66631d.decrementAndGet();
            if (list == null || list.size() <= 0 || list.get(0) == null || (network = list.get(0)) == null) {
                return;
            }
            AdLogUtil.Log().d("QueryPriceCenter", "receive query price result: " + list.toString());
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg(ComConstants.transferSourceToStr(network.getSource().intValue()) + " price" + network.getPrice() + ";", RecordTestInfo.LOG_CODE9);
            }
            if (!q.f66627o.b(network.getCodeSeatId(), network)) {
                AdLogUtil.Log().w("QueryPriceCenter", "add price to price pool failed");
                q.this.f(network, false);
            } else if (q.this.f66636i) {
                q.this.j(false);
            } else {
                q.this.k(false, network.getCodeSeatId());
            }
        }
    }

    public q(i iVar, CloudControlConfig.CodeSeat codeSeat, boolean z11) {
        this.f66636i = false;
        if (codeSeat == null) {
            return;
        }
        this.f66638k = codeSeat;
        this.f66637j = codeSeat.getCodeSeatType();
        this.f66639l = codeSeat.getCodeSeatId();
        this.f66636i = z11;
        this.f66640m = iVar;
        this.f66641n = AdCacheManager.getCache(this.f66637j.intValue());
        this.f66629b = new a(Looper.getMainLooper(), z11);
    }

    public final BaseQueryPrice a(Network network) {
        if (network == null) {
            return null;
        }
        IBaseAdSummary iBaseAdSummaryH = o.a().h(network.getSource().intValue());
        BaseQueryPrice queryPrice = iBaseAdSummaryH != null ? iBaseAdSummaryH.getQueryPrice() : null;
        if (queryPrice != null && this.f66637j.intValue() == 4) {
            queryPrice.setOrientation(this.f66640m.C());
        }
        return queryPrice;
    }

    public final Network b(String str) {
        AdCache adCache = this.f66641n;
        double maxPrice = adCache == null ? 0.0d : adCache.getMaxPrice(str, this.f66640m.F());
        AdLogUtil.Log().d("QueryPriceCenter", "*----> currently max price ad in ad pool is: " + maxPrice);
        Network networkA = f66627o.a(str);
        if (networkA == null) {
            return null;
        }
        AdLogUtil.Log().d("QueryPriceCenter", "*----> get cached, code seat id: +" + networkA.getCodeSeatId() + " price: " + networkA.getPrice());
        if (networkA.getPrice().doubleValue() < maxPrice) {
            return null;
        }
        AdLogUtil.Log().d("QueryPriceCenter", "*----> getQueryPriceWinner --> winner network is: " + networkA);
        return networkA;
    }

    public List<Network> d(QueryPriceListener queryPriceListener) {
        BaseQueryPrice baseQueryPriceA;
        this.f66628a = queryPriceListener;
        if (this.f66632e.isEmpty()) {
            AdLogUtil.Log().d("QueryPriceCenter", "Auciton failed due to query price list is empty");
            QueryPriceListener queryPriceListener2 = this.f66628a;
            if (queryPriceListener2 != null) {
                queryPriceListener2.onQueryPriceFailed();
            }
            return null;
        }
        int i11 = 0;
        for (Network network : this.f66632e) {
            if (network != null && (baseQueryPriceA = a(network)) != null) {
                baseQueryPriceA.setQueryPriceListener(new b(network));
                if (i11 >= 5) {
                    AdLogUtil.Log().d("QueryPriceCenter", "Auciton count exceed the max thrshold: 5");
                    break;
                }
                AdLogUtil.Log().w("QueryPriceCenter", "*----> start query price,network id: " + network.getCodeSeatId());
                network.setAdt(this.f66637j.intValue());
                baseQueryPriceA.setTrackingBundle(DispatcherHandler.a(this.f66640m, network, this.f66636i ? 2 : 1, this.f66638k));
                if (this.f66637j.intValue() == 2) {
                    baseQueryPriceA.setBannerSize(this.f66640m.n());
                }
                RecordTestInfo.record("queryPrice,codeSeatId:" + network.getCodeSeatId());
                baseQueryPriceA.queryPrice(com.cloud.sdk.commonutil.util.f.a(), network);
                this.f66631d.addAndGet(1);
                if (this.f66630c == null) {
                    this.f66630c = new ArrayList();
                }
                this.f66630c.add(baseQueryPriceA);
                i11++;
            }
        }
        AdLogUtil.Log().d("QueryPriceCenter", "QueryPriceCenter --> startQueryPrice --> mDoingQueryCount.get() = " + this.f66631d.get());
        this.f66629b.removeMessages(101);
        this.f66629b.sendEmptyMessageDelayed(101, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        return null;
    }

    public void f(Network network, boolean z11) {
        if (network == null || network.getBidInfo() == null) {
            return;
        }
        if (z11) {
            AdLogUtil.Log().d("QueryPriceCenter", "send auction success to network server!");
            network.getBidInfo().notifyWin();
        } else {
            AdLogUtil.Log().d("QueryPriceCenter", "send auction failed to network server!");
            network.getBidInfo().notifyLoss();
        }
    }

    public final void i(List<Network> list) {
        ArrayList caches;
        Network networkA;
        if (LogSwitch.isDebug) {
            StringBuilder sb2 = new StringBuilder();
            for (Network network : this.f66632e) {
                if (network != null) {
                    sb2.append(ComConstants.transferSourceToStr(network.getSource().intValue()) + "，");
                }
            }
            StringBuilder sb3 = new StringBuilder();
            for (Network network2 : this.f66633f) {
                if (network2 != null) {
                    sb3.append(ComConstants.transferSourceToStr(network2.getSource().intValue()) + " -$ " + network2.getPrice() + "，");
                }
            }
            StringBuilder sb4 = new StringBuilder();
            for (Network network3 : this.f66634g) {
                if (network3 != null) {
                    sb4.append(ComConstants.transferSourceToStr(network3.getSource().intValue()) + " -$ " + network3.getPrice() + "，");
                }
            }
            AdLogUtil.Log().d("QueryPriceCenter", "*----> mQueryPriceNetworkList is: " + ((Object) sb2) + ",\n *----> mWaterfallNetworkList is: " + ((Object) sb3) + ",\n mHistroyPriceList is: " + ((Object) sb4));
            String str = String.format(com.cloud.sdk.commonutil.util.f.a().getString(R$string.hisavana_log_msg2), sb3.toString(), sb2.toString(), sb4.toString());
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg(str, RecordTestInfo.LOG_CODE2);
            }
            StringBuilder sb5 = new StringBuilder();
            for (Network network4 : list) {
                if (network4 != null && o.f(network4, this.f66637j) && (networkA = f66627o.a(network4.getCodeSeatId())) != null) {
                    sb5.append(ComConstants.transferSourceToStr(network4.getSource().intValue()));
                    sb5.append(" price:");
                    sb5.append(networkA.getPrice());
                }
            }
            if (LogSwitch.isDebug) {
                RecordTestInfo.LogMsg(sb5.toString(), RecordTestInfo.LOG_CODE3);
            }
            AdCache adCache = this.f66641n;
            if (adCache == null) {
                caches = null;
            } else {
                String str2 = this.f66639l;
                i iVar = this.f66640m;
                caches = adCache.getCaches(str2, Api.BaseClientBuilder.API_PRIORITY_OTHER, false, iVar != null && iVar.F());
            }
            if (!LogSwitch.isDebug || caches == null || caches.isEmpty()) {
                return;
            }
            RecordTestInfo.LogMsg(RecordTestInfo.getLogMsg(caches), RecordTestInfo.LOG_CODE4);
        }
    }

    public final void j(boolean z11) {
        Network networkB;
        AdLogUtil.Log().e("QueryPriceCenter", "checkToGetWinnerPreload --> 竞价超时时间内 是否还有正在竞价的任务 --> mDoingQueryCount.get() = " + this.f66631d.get() + " ----- timeOut = " + z11 + "----- ispreload = " + this.f66636i);
        if (this.f66628a == null) {
            return;
        }
        if (z11 || this.f66631d.get() <= 0) {
            ArrayList arrayList = new ArrayList();
            for (Network network : this.f66632e) {
                if (network != null && (networkB = b(network.getCodeSeatId())) != null) {
                    AdLogUtil.Log().w("QueryPriceCenter", "*---->checkToGetWinnerPreload ----- winnerNetwork = " + networkB);
                    arrayList.add(networkB);
                }
            }
            AdLogUtil.Log().w("QueryPriceCenter", "*---->end query price,checkToGetWinnerPreload ----- winnerList.size() = " + arrayList.size());
            if (arrayList.isEmpty()) {
                this.f66628a.onQueryPriceFailed();
            } else {
                this.f66628a.onQueryPriceSuccess(arrayList);
            }
            this.f66628a = null;
            this.f66629b.removeMessages(101);
        }
    }

    public final void k(boolean z11, String str) {
        AdLogUtil.Log().e("QueryPriceCenter", "checkToGetWinner --> 竞价超时时间内 是否还有正在竞价的任务 --> mDoingQueryCount.get() = " + this.f66631d.get() + " ----- timeOut = " + z11 + "----- ispreload = " + this.f66636i + "，codeSeatId：" + str);
        if (z11) {
            this.f66628a = null;
        }
        if (this.f66628a == null || TextUtils.isEmpty(str)) {
            return;
        }
        Network networkB = b(str);
        AdLogUtil.Log().w("QueryPriceCenter", "*---->end query price,checkToGetWinner ----- winnerNetworks = " + networkB);
        if (networkB != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(networkB);
            this.f66628a.onQueryPriceSuccess(arrayList);
        } else {
            this.f66628a.onQueryPriceFailed();
        }
        if (this.f66631d.get() <= 0) {
            this.f66629b.removeMessages(101);
        }
    }

    public void l() {
        this.f66632e.clear();
        this.f66633f.clear();
        this.f66634g.clear();
        this.f66635h.clear();
        List<Network> networks = this.f66638k.getNetworks();
        if (networks == null) {
            return;
        }
        for (Network network : networks) {
            if (network != null) {
                if (o.f(network, this.f66637j)) {
                    if (this.f66636i) {
                        this.f66632e.add(network);
                    } else {
                        Network networkB = b(network.getCodeSeatId());
                        if (networkB == null) {
                            if (network.getSource().intValue() == 9) {
                                this.f66641n.removeCodeSeatCache(network.getCodeSeatId());
                            }
                            this.f66632e.add(network);
                        } else {
                            this.f66634g.add(networkB);
                        }
                    }
                } else if (o.e(network)) {
                    this.f66635h.add(network);
                } else {
                    this.f66633f.add(network);
                }
            }
        }
        i(networks);
    }

    public void n() {
        this.f66628a = null;
        List<BaseQueryPrice> list = this.f66630c;
        if (list != null && list.size() > 0) {
            for (BaseQueryPrice baseQueryPrice : this.f66630c) {
                if (baseQueryPrice != null) {
                    baseQueryPrice.destroy();
                }
            }
        }
        this.f66630c = null;
    }

    public List<Network> o() {
        return this.f66635h;
    }

    public List<Network> p() {
        AdLogUtil.Log().d("QueryPriceCenter", "*----> getHistoryPriceList  " + this.f66634g);
        return this.f66634g;
    }

    public List<Network> q() {
        return this.f66632e;
    }

    public List<Network> r() {
        return this.f66633f;
    }
}
