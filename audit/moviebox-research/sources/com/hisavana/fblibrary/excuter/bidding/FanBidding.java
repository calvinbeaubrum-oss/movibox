package com.hisavana.fblibrary.excuter.bidding;

import android.content.Context;
import android.os.Looper;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.i;
import com.facebook.ads.AdSettings;
import com.facebook.biddingkit.facebook.bidder.FacebookBidder;
import com.facebook.biddingkit.gen.FacebookAdBidFormat;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBidWithNotify;
import com.hisavana.common.interfacz.QueryPriceListener;
import com.hisavana.common.utils.AdLogUtil;
import java.util.ArrayList;
import sf.c;
import tf.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FanBidding extends BaseQueryPrice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41795a;

    /* JADX INFO: compiled from: source.java */
    public static class BidWithNotify implements IBidWithNotify {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f41796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f41797b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f41798c = System.currentTimeMillis();

        public BidWithNotify(b bVar) {
            this.f41796a = bVar;
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public String getPayload() {
            b bVar = this.f41796a;
            if (bVar != null) {
                return bVar.getPayload();
            }
            return null;
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public boolean isExpired() {
            return Math.abs(System.currentTimeMillis() - this.f41798c) > ((long) ComConstants.BID_PRICE_CACHE_TIME);
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public void notifyLoss() {
            if (this.f41797b) {
                return;
            }
            AdLogUtil.Log().d("FanBidding", "notify fan bidding failed");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                i.f30292a.e(new Runnable() { // from class: com.hisavana.fblibrary.excuter.bidding.FanBidding.BidWithNotify.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BidWithNotify.this.f41796a != null) {
                            BidWithNotify.this.f41796a.notifyLoss();
                        }
                    }
                });
                return;
            }
            b bVar = this.f41796a;
            if (bVar != null) {
                bVar.notifyLoss();
            }
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public void notifyWin() {
            AdLogUtil.Log().d("FanBidding", "notify fan bidding win");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                i.f30292a.e(new Runnable() { // from class: com.hisavana.fblibrary.excuter.bidding.FanBidding.BidWithNotify.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BidWithNotify.this.f41796a != null) {
                            BidWithNotify.this.f41796a.notifyWin();
                        }
                        BidWithNotify.this.f41797b = true;
                    }
                });
                return;
            }
            b bVar = this.f41796a;
            if (bVar != null) {
                bVar.notifyWin();
                this.f41797b = true;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements sf.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Network f41799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f41800b;

        /* JADX INFO: renamed from: com.hisavana.fblibrary.excuter.bidding.FanBidding$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0462a implements Preconditions.a {
            public C0462a() {
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                if (((BaseQueryPrice) FanBidding.this).mQueryPriceListener != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(a.this.f41799a);
                    ((BaseQueryPrice) FanBidding.this).mQueryPriceListener.onQueryPriceSuccess(arrayList);
                }
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b implements Preconditions.a {
            public b() {
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                if (((BaseQueryPrice) FanBidding.this).mQueryPriceListener != null) {
                    ((BaseQueryPrice) FanBidding.this).mQueryPriceListener.onQueryPriceFailed();
                }
            }
        }

        public a(Network network, long j11) {
            this.f41799a = network;
            this.f41800b = j11;
        }

        @Override // sf.a
        public void a(tf.b bVar) {
            if (bVar == null || this.f41799a == null) {
                return;
            }
            double price = bVar.getPrice();
            FanBidding.this.trackingBiddingSuccess(price);
            this.f41799a.setPrice(Double.valueOf(price));
            this.f41799a.setBidInfo(new BidWithNotify(bVar));
            AdLogUtil.Log().d("FanBidding", "*----> fan bidding success ---,price is:" + price + ",id:" + this.f41799a.getCodeSeatId());
            Preconditions.d(new C0462a());
        }

        @Override // sf.a
        public void b(String str) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f41800b;
            AdLogUtil.Log().d("FanBidding", "*----> bidding request fail --- :" + str + ",time use:" + jCurrentTimeMillis);
            if (this.f41799a == null) {
                return;
            }
            FanBidding.this.trackingBiddingFailed(TAdErrorCode.CODE_REQUEST_BIDDING_FAILED, str);
            Preconditions.d(new b());
        }
    }

    public final FacebookAdBidFormat a(int i11) {
        if (i11 == 0) {
            return FacebookAdBidFormat.BANNER_HEIGHT_50;
        }
        if (i11 == 3 || i11 == 1) {
            return FacebookAdBidFormat.BANNER_HEIGHT_90;
        }
        if (i11 == 2) {
            return FacebookAdBidFormat.BANNER_HEIGHT_250;
        }
        return null;
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void destroy() {
        this.mQueryPriceListener = null;
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void queryPrice(Context context, Network network) {
        FacebookAdBidFormat facebookAdBidFormatA;
        if (network == null) {
            return;
        }
        boolean zIsTestMode = AdSettings.isTestMode(context);
        AdLogUtil.Log().w("FanBidding", "*----> start fan real time bidding...,is test mode:" + zIsTestMode);
        AdSettings.setTestMode(zIsTestMode);
        int adt = network.getAdt();
        if (adt == 1) {
            facebookAdBidFormatA = FacebookAdBidFormat.NATIVE;
        } else if (adt == 2) {
            facebookAdBidFormatA = a(this.f41795a);
        } else if (adt == 3) {
            facebookAdBidFormatA = FacebookAdBidFormat.INTERSTITIAL;
        } else if (adt == 5) {
            facebookAdBidFormatA = FacebookAdBidFormat.REWARDED_VIDEO;
        } else {
            if (adt != 10) {
                network.setPrice(Double.valueOf(0.0d));
                QueryPriceListener queryPriceListener = this.mQueryPriceListener;
                if (queryPriceListener != null) {
                    queryPriceListener.onQueryPriceFailed();
                    return;
                }
                return;
            }
            facebookAdBidFormatA = FacebookAdBidFormat.NATIVE_BANNER;
        }
        AdLogUtil.Log().d("FanBidding", "fbtoken is : " + ComConstants.fbBidToken);
        c cVarB = new FacebookBidder.a(network.getApplicationId(), network.getCodeSeatId(), facebookAdBidFormatA, ComConstants.fbBidToken).r(zIsTestMode).b();
        long jCurrentTimeMillis = System.currentTimeMillis();
        trackingBiddingStart();
        cVarB.b(new a(network, jCurrentTimeMillis));
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void setBannerSize(int i11) {
        this.f41795a = i11;
    }
}
