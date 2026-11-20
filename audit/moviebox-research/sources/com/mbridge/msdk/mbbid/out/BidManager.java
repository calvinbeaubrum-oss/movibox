package com.mbridge.msdk.mbbid.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbbid.common.a.b;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BidManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f45445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BidListennning f45446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f45447c;

    public <T extends CommonBidRequestParams> BidManager(T t11) {
        this(t11 == null ? "" : t11.getmPlacementId(), t11 == null ? "" : t11.getmUnitId(), t11 != null ? t11.getmFloorPrice() : "");
        if (!(t11 instanceof BannerBidRequestParams)) {
            if (t11 instanceof AdvancedNativeBidRequestParams) {
                AdvancedNativeBidRequestParams advancedNativeBidRequestParams = (AdvancedNativeBidRequestParams) t11;
                this.f45445a.a(advancedNativeBidRequestParams.getHeight());
                this.f45445a.b(advancedNativeBidRequestParams.getWidth());
                this.f45445a.b(298);
                return;
            }
            return;
        }
        BannerBidRequestParams bannerBidRequestParams = (BannerBidRequestParams) t11;
        this.f45445a.a(bannerBidRequestParams.getHeight());
        this.f45445a.b(bannerBidRequestParams.getWidth());
        this.f45445a.b(296);
        if (t11 instanceof SplashBidRequestParams) {
            SplashBidRequestParams splashBidRequestParams = (SplashBidRequestParams) t11;
            this.f45445a.a(splashBidRequestParams.a());
            this.f45445a.a(splashBidRequestParams.getOrientation());
            this.f45445a.b(297);
        }
    }

    public BidManager(String str, String str2) {
        this(str, str2, "0");
    }

    public BidManager(String str, String str2, String str3) {
        this.f45447c = false;
        this.f45445a = new b(str, str2, str3);
    }

    public static String getBuyerUid(Context context) {
        if (com.mbridge.msdk.f.b.a()) {
            try {
                c.c(true);
            } catch (Throwable th2) {
                ad.b("BidManager", th2.getMessage());
            }
        }
        return com.mbridge.msdk.mbbid.common.b.a(context, "");
    }

    public static String getBuyerUid(Context context, String str) {
        if (com.mbridge.msdk.f.b.a()) {
            try {
                c.c(true);
            } catch (Throwable th2) {
                ad.b("BidManager", th2.getMessage());
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return com.mbridge.msdk.mbbid.common.b.a(context, str);
    }

    public static String getBuyerUid(Context context, Map<String, String> map) {
        if (com.mbridge.msdk.f.b.a()) {
            try {
                c.c(true);
            } catch (Throwable th2) {
                ad.b("BidManager", th2.getMessage());
            }
        }
        return com.mbridge.msdk.mbbid.common.b.a(context, map);
    }

    public void bid() {
        b bVar = this.f45445a;
        if (bVar != null) {
            bVar.b(this.f45447c);
            return;
        }
        BidListennning bidListennning = this.f45446b;
        if (bidListennning != null) {
            bidListennning.onFailed("you need init the class :BidManager");
        }
    }

    public void setBidListener(BidListennning bidListennning) {
        this.f45446b = bidListennning;
        b bVar = this.f45445a;
        if (bVar != null) {
            bVar.a(bidListennning);
        }
    }

    public void setRewardPlus(boolean z11) {
        this.f45447c = z11;
    }
}
