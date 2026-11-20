package com.facebook.biddingkit.facebook.bidder;

import androidx.annotation.Nullable;
import com.facebook.biddingkit.bridge.BiddingKit;
import com.facebook.biddingkit.gen.FBAdBidAuctionType;
import com.facebook.biddingkit.gen.FacebookAdBidFormat;
import com.facebook.biddingkit.http.util.HttpStatusCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import sf.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class FacebookBidder implements sf.d, sf.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f32421d = "FACEBOOK_BIDDER";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f32422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, FacebookNotifier> f32423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f32424c;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f32425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f32426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public FacebookAdBidFormat f32427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f32428d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f32429e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f32430f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public FBAdBidAuctionType f32431g = FBAdBidAuctionType.FIRST_PRICE;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f32432h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f32433i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f32434j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f32435k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        public String f32436l;

        public a(String str, String str2, @Nullable FacebookAdBidFormat facebookAdBidFormat, String str3) {
            this.f32425a = str;
            this.f32426b = str2;
            this.f32427c = facebookAdBidFormat;
            this.f32429e = str3;
            this.f32433i = str;
        }

        public sf.c b() {
            this.f32434j = true;
            return new FacebookBidder(this);
        }

        @Nullable
        public FacebookAdBidFormat c() {
            return this.f32427c;
        }

        public String d() {
            return this.f32425a;
        }

        public String e() {
            return this.f32428d;
        }

        public FBAdBidAuctionType f() {
            return this.f32431g;
        }

        public String g() {
            return this.f32429e;
        }

        public String h() {
            return this.f32434j ? "standalone" : "auction";
        }

        public boolean i() {
            return this.f32432h;
        }

        public String j() {
            return "FB Ad Impression";
        }

        public boolean k() {
            return this.f32435k;
        }

        public boolean l() {
            return xf.c.d(BiddingKit.a());
        }

        public String m() {
            return this.f32426b;
        }

        public String n() {
            String str = this.f32433i;
            return str != null ? str : this.f32425a;
        }

        public boolean o() {
            return this.f32430f;
        }

        public int p() {
            return 1000;
        }

        public a q(String str) {
            this.f32428d = str;
            return this;
        }

        public a r(boolean z11) {
            this.f32430f = z11;
            return this;
        }
    }

    public FacebookBidder(a aVar) {
        this.f32422a = aVar;
        this.f32423b = Collections.synchronizedMap(new HashMap());
        this.f32424c = new d(BiddingKit.b());
    }

    public static e e(String str) {
        return new FacebookNotifier(str, new d(BiddingKit.b()));
    }

    public static void h(sf.a aVar, com.facebook.biddingkit.facebook.bidder.a aVar2) {
        if (aVar2 == null) {
            aVar.b("Failed to get a bid");
            return;
        }
        if (aVar2.c() == HttpStatusCode.SUCCESS) {
            aVar.a(aVar2);
            return;
        }
        aVar.b("Failed to get a bid with " + aVar2.c() + " http status code");
    }

    @Override // sf.d
    public void a(String str, @Nullable yf.a aVar, String str2) {
        if (aVar == null) {
            com.facebook.biddingkit.logging.b.c("FacebookBidder", "Received null waterfall to notify in bidder winner");
            return;
        }
        FacebookNotifier facebookNotifier = this.f32423b.get(str2);
        if (facebookNotifier != null) {
            facebookNotifier.a(str, aVar);
        } else {
            com.facebook.biddingkit.logging.b.d("FacebookBidder", "Facebook Bidder did not get to initialize notifier", new Throwable());
        }
    }

    @Override // sf.c
    public void b(final sf.a aVar) {
        xf.a.f80479b.execute(new Runnable() { // from class: com.facebook.biddingkit.facebook.bidder.FacebookBidder.1
            @Override // java.lang.Runnable
            public void run() {
                FacebookBidder.this.f32422a.q(xf.b.a());
                com.facebook.biddingkit.facebook.bidder.a aVarF = FacebookBidder.this.f();
                if (aVarF != null) {
                    FacebookBidder facebookBidder = FacebookBidder.this;
                    FacebookNotifier facebookNotifier = new FacebookNotifier(facebookBidder.f32422a, facebookBidder.f32424c);
                    facebookNotifier.l(aVarF);
                    aVarF.d(facebookNotifier);
                }
                FacebookBidder.h(aVar, aVarF);
            }
        });
    }

    public final com.facebook.biddingkit.facebook.bidder.a f() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return b.a(vf.b.b(this.f32422a.f32436l != null ? this.f32422a.f32436l : this.f32424c.a(), this.f32422a.p(), g(jCurrentTimeMillis).toString()), jCurrentTimeMillis);
    }

    public final JSONObject g(long j11) {
        return c.d(this.f32422a, j11);
    }
}
