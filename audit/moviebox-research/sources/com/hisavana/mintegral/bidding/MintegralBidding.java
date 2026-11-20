package com.hisavana.mintegral.bidding;

import android.content.Context;
import android.os.Looper;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.i;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBidWithNotify;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mintegral.check.ExistsCheck;
import com.hisavana.mintegral.check.MBridgeSDKManager;
import com.mbridge.msdk.mbbid.out.BannerBidRequestParams;
import com.mbridge.msdk.mbbid.out.BidListennning;
import com.mbridge.msdk.mbbid.out.BidLossCode;
import com.mbridge.msdk.mbbid.out.BidManager;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.mbbid.out.SplashBidRequestParams;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MintegralBidding extends BaseQueryPrice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41952c;

    /* JADX INFO: renamed from: com.hisavana.mintegral.bidding.MintegralBidding$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass2 implements BidListennning {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f41956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Network f41957b;

        public AnonymousClass2(long j11, Network network) {
            this.f41956a = j11;
            this.f41957b = network;
        }

        public final /* synthetic */ void c() {
            if (((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener != null) {
                ((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener.onQueryPriceFailed();
            }
        }

        public final /* synthetic */ void d(Network network) {
            if (((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(network);
                ((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener.onQueryPriceSuccess(arrayList);
            }
        }

        @Override // com.mbridge.msdk.mbbid.out.BidListennning
        public void onFailed(String str) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f41956a;
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "*---->mintegral bidding request fail --- : " + this.f41957b.getCodeSeatId() + " | " + str + ",time use:" + jCurrentTimeMillis);
            if (this.f41957b == null) {
                return;
            }
            MintegralBidding.this.trackingBiddingFailed(TAdErrorCode.CODE_REQUEST_BIDDING_FAILED, str);
            Preconditions.d(new Preconditions.a() { // from class: com.hisavana.mintegral.bidding.b
                @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                public final void onRun() {
                    this.f41964a.c();
                }
            });
        }

        @Override // com.mbridge.msdk.mbbid.out.BidListennning
        public void onSuccessed(BidResponsed bidResponsed) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f41956a;
            if (bidResponsed == null || this.f41957b == null) {
                return;
            }
            Double dValueOf = Double.valueOf(0.0d);
            try {
                dValueOf = Double.valueOf(Double.parseDouble(bidResponsed.getPrice()) * 100.0d);
            } catch (Exception unused) {
                AdLogUtil.Log().e(ExistsCheck.MINTEGRAL_TAG, "*----> mintegral bidding success ---,price is:" + dValueOf + ",id:" + this.f41957b.getCodeSeatId() + ",time use:" + jCurrentTimeMillis);
            }
            MintegralBidding.this.trackingBiddingSuccess(dValueOf.doubleValue());
            this.f41957b.setPrice(dValueOf);
            this.f41957b.setBidInfo(new BidWithNotify(bidResponsed));
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "*----> mintegral bidding success ---,price is:" + dValueOf + ",id:" + this.f41957b.getCodeSeatId());
            final Network network = this.f41957b;
            Preconditions.d(new Preconditions.a() { // from class: com.hisavana.mintegral.bidding.a
                @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                public final void onRun() {
                    this.f41962a.d(network);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class BidWithNotify implements IBidWithNotify {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BidResponsed f41959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f41960b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f41961c = System.currentTimeMillis();

        public BidWithNotify(BidResponsed bidResponsed) {
            this.f41959a = bidResponsed;
        }

        public final /* synthetic */ void c() {
            this.f41959a.sendLossNotice(f.a(), BidLossCode.bidPriceNotHighest());
        }

        public final /* synthetic */ void d() {
            this.f41959a.sendWinNotice(f.a());
            this.f41960b = true;
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public String getPayload() {
            if (this.f41959a == null) {
                return "";
            }
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "mintegral getPayload" + this.f41959a.getBidToken());
            return this.f41959a.getBidToken();
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public boolean isExpired() {
            return Math.abs(System.currentTimeMillis() - this.f41961c) > ((long) ComConstants.BID_PRICE_CACHE_TIME);
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public void notifyLoss() {
            if (this.f41960b || this.f41959a == null) {
                return;
            }
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "notify mintegral bidding failed");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                i.f30292a.e(new Runnable() { // from class: com.hisavana.mintegral.bidding.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f41965a.c();
                    }
                });
            } else {
                this.f41959a.sendLossNotice(f.a(), BidLossCode.bidPriceNotHighest());
            }
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public void notifyWin() {
            if (this.f41959a == null) {
                return;
            }
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "notify mintegral bidding win");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                i.f30292a.e(new Runnable() { // from class: com.hisavana.mintegral.bidding.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f41966a.d();
                    }
                });
            } else {
                this.f41959a.sendWinNotice(f.a());
                this.f41960b = true;
            }
        }
    }

    public final void b() {
        int i11;
        int i12 = this.f41950a;
        if (i12 == 1) {
            i11 = 100;
        } else if (i12 != 2) {
            i11 = i12 != 3 ? 50 : 90;
        } else {
            i11 = 250;
        }
        this.f41951b = i11;
        this.f41952c = 320;
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void destroy() {
        this.mQueryPriceListener = null;
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void queryPrice(Context context, final Network network) {
        if (network == null || context == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ExistsCheck.initAdSource(network.getApplicationId(), network.getApplicationKey(), new MBridgeSDKManager.MBridgeSDKInitializeListener() { // from class: com.hisavana.mintegral.bidding.MintegralBidding.1
            @Override // com.hisavana.mintegral.check.MBridgeSDKManager.MBridgeSDKInitializeListener
            public void onInitializeFailure(String str) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "init onError message：" + str);
            }

            @Override // com.hisavana.mintegral.check.MBridgeSDKManager.MBridgeSDKInitializeListener
            public void onInitializeSuccess(String str, String str2) {
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onInitializeSuccess，init time " + jCurrentTimeMillis2);
                MintegralBidding.this.startQueryPrice(network);
            }
        });
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void setBannerSize(int i11) {
        this.f41950a = i11;
    }

    public void startQueryPrice(Network network) {
        BidManager bidManager;
        if (network == null) {
            return;
        }
        int adt = network.getAdt();
        if (adt == 2) {
            b();
            bidManager = new BidManager(new BannerBidRequestParams("", network.getCodeSeatId(), this.f41952c, this.f41951b));
        } else if (adt != 4) {
            bidManager = new BidManager("", network.getCodeSeatId());
        } else {
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "*---->mintegral bidding getOrientation() --- :" + getOrientation());
            bidManager = new BidManager(new SplashBidRequestParams("", network.getCodeSeatId(), true, getOrientation(), 30, 30));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        trackingBiddingStart();
        bidManager.setBidListener(new AnonymousClass2(jCurrentTimeMillis, network));
        bidManager.bid();
    }
}
