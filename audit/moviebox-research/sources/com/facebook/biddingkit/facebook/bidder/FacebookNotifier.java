package com.facebook.biddingkit.facebook.bidder;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.biddingkit.bidders.LossCode;
import com.facebook.biddingkit.bridge.BiddingKit;
import com.facebook.biddingkit.http.util.HttpStatusCode;
import java.util.HashMap;
import java.util.Map;
import sf.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class FacebookNotifier implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.facebook.biddingkit.facebook.bidder.a f32438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FacebookBidder.a f32439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f32440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f32441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f32442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f32443g;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32444a;

        static {
            int[] iArr = new int[HttpStatusCode.values().length];
            f32444a = iArr;
            try {
                iArr[HttpStatusCode.NO_BID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32444a[HttpStatusCode.BAD_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32444a[HttpStatusCode.TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public FacebookNotifier(FacebookBidder.a aVar, d dVar) {
        this.f32437a = 2000;
        this.f32442f = "";
        this.f32443g = "";
        this.f32439c = aVar;
        this.f32440d = dVar;
    }

    public FacebookNotifier(String str, d dVar) {
        this(new FacebookBidder.a("", "", null, "").q(str), dVar);
        this.f32441e = true;
    }

    public static Double c(yf.b bVar, yf.b bVar2) {
        if (bVar == null) {
            return Double.valueOf(0.0d);
        }
        if (FacebookBidder.f32421d.equals(bVar.b())) {
            return Double.valueOf(bVar2 != null ? bVar2.a() : 0.0d);
        }
        return Double.valueOf(bVar.a());
    }

    public static String e(yf.b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.b();
    }

    @Override // sf.e
    public void a(String str, yf.a aVar) {
        yf.b[] bVarArrB = xf.c.b(aVar);
        j(str, e(bVarArrB[0]), c(bVarArrB[0], bVarArrB[1]), false);
    }

    public final String d() {
        com.facebook.biddingkit.facebook.bidder.a aVar = this.f32438b;
        return (aVar == null || TextUtils.isEmpty(aVar.b())) ? this.f32440d.b() : this.f32438b.b();
    }

    public String f() {
        return TextUtils.isEmpty(this.f32443g) ? xf.c.c(BiddingKit.a()) : this.f32443g;
    }

    public LossCode g(String str) {
        if (this.f32441e) {
            return LossCode.DID_NOT_PARTICIPATE;
        }
        com.facebook.biddingkit.facebook.bidder.a aVar = this.f32438b;
        if (aVar != null) {
            int i11 = a.f32444a[aVar.c().ordinal()];
            if (i11 == 1 || i11 == 2) {
                return LossCode.NO_BID;
            }
            if (i11 == 3) {
                return LossCode.TIMEOUT;
            }
        }
        if (FacebookBidder.f32421d.equals(str)) {
            return LossCode.WIN;
        }
        return this.f32438b == null ? LossCode.TIMEOUT : LossCode.OUTBID;
    }

    public String h() {
        return TextUtils.isEmpty(this.f32442f) ? BiddingKit.a().getPackageName() : this.f32442f;
    }

    public final int i() {
        return 2000;
    }

    public void j(String str, @Nullable String str2, Double d11, boolean z11) {
        uf.e eVarA = vf.b.a(k(z11, str, str2, d11), i());
        if (z11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Facebook display winner notified with http status ");
            sb2.append(eVarA != null ? String.valueOf(eVarA.c()) : "null");
            com.facebook.biddingkit.logging.b.a("FacebookNotifier", sb2.toString());
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Facebook bidder winner notified with http status ");
        sb3.append(eVarA != null ? String.valueOf(eVarA.c()) : "null");
        com.facebook.biddingkit.logging.b.a("FacebookNotifier", sb3.toString());
    }

    @SuppressLint({"CatchGeneralException"})
    public String k(boolean z11, String str, @Nullable String str2, Double d11) {
        String strD = d();
        try {
            String[] strArrSplit = this.f32439c.m().split("_", 2);
            for (Map.Entry<String, String> entry : new HashMap<String, String>(strArrSplit.length >= 2 ? strArrSplit[1] : "", str, str2, d11, z11) { // from class: com.facebook.biddingkit.facebook.bidder.FacebookNotifier.1
                final /* synthetic */ Double val$cpmCents;
                final /* synthetic */ String val$entryName;
                final /* synthetic */ boolean val$isDisplay;
                final /* synthetic */ String val$placementFbid;
                final /* synthetic */ String val$segment;

                {
                    this.val$placementFbid = str;
                    this.val$segment = str;
                    this.val$entryName = str2;
                    this.val$cpmCents = d11;
                    this.val$isDisplay = z11;
                    put("${PARTNER_FBID}", FacebookNotifier.this.f32439c.d());
                    put("${APP_FBID}", FacebookNotifier.this.f32439c.d());
                    put("${PLACEMENT_FBID}", str);
                    put("${BUNDLE}", FacebookNotifier.this.h());
                    put("${IDFA}", FacebookNotifier.this.f());
                    put("${AUCTION_ID}", FacebookNotifier.this.f32439c.e());
                    put("${AB_TEST_SEGMENT}", str);
                    put("${AUCTION_LOSS}", FacebookNotifier.this.g(str2).getStringValue());
                    put("${AUCTION_PRICE}", Double.toString(d11.doubleValue() / 100.0d));
                    put("${WINNER_NAME}", str2 == null ? "" : str2);
                    put("${WINNER_TYPE}", tf.c.a(str2) ? "bidding" : "waterfall");
                    put("${PHASE}", z11 ? "display" : "auction");
                }
            }.entrySet()) {
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                strD = strD.replace(entry.getKey(), value);
            }
        } catch (Throwable th2) {
            com.facebook.biddingkit.logging.b.d("FacebookNotifier", "Failed processing the Url", th2);
        }
        return strD;
    }

    public void l(com.facebook.biddingkit.facebook.bidder.a aVar) {
        this.f32438b = aVar;
    }
}
