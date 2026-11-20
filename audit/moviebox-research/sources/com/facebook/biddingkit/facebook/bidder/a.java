package com.facebook.biddingkit.facebook.bidder;

import com.facebook.biddingkit.http.util.HttpStatusCode;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import org.json.JSONObject;
import uf.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements tf.a, tf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f32445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f32447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f32448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f32449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HttpStatusCode f32450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FacebookNotifier f32451g;

    public a(e eVar) {
        this.f32446b = "";
        this.f32447c = "";
        this.f32448d = "";
        this.f32449e = "";
        this.f32450f = HttpStatusCode.UNKNOWN;
        try {
            this.f32450f = HttpStatusCode.getValue(eVar.c());
            JSONObject jSONObject = new JSONObject(eVar.a());
            JSONObject jSONObject2 = jSONObject.getJSONArray("seatbid").getJSONObject(0).getJSONArray(BidResponsed.KEY_BID_ID).getJSONObject(0);
            this.f32449e = jSONObject2.getString("lurl");
            this.f32446b = jSONObject2.getString("adm");
            this.f32445a = jSONObject2.getDouble(BidResponsed.KEY_PRICE) * 100.0d;
            this.f32447c = new JSONObject(this.f32446b).getString("resolved_placement_id");
            this.f32448d = jSONObject.getString(BidResponsed.KEY_CUR);
        } catch (Exception e11) {
            com.facebook.biddingkit.logging.b.d("FacebookBid", "Failed to parse response body", e11);
        }
    }

    public String a() {
        return "FACEBOOK_BIDDER";
    }

    public String b() {
        return this.f32449e;
    }

    public HttpStatusCode c() {
        return this.f32450f;
    }

    public void d(FacebookNotifier facebookNotifier) {
        this.f32451g = facebookNotifier;
    }

    @Override // tf.a
    public String getPayload() {
        return this.f32446b;
    }

    @Override // tf.a
    public double getPrice() {
        return this.f32445a;
    }

    @Override // tf.b
    public void notifyLoss() {
        FacebookNotifier facebookNotifier = this.f32451g;
        if (facebookNotifier != null) {
            facebookNotifier.j("", "OTHER", Double.valueOf(0.0d), true);
        }
    }

    @Override // tf.b
    public void notifyWin() {
        FacebookNotifier facebookNotifier = this.f32451g;
        if (facebookNotifier != null) {
            facebookNotifier.j("", a(), Double.valueOf(getPrice()), true);
        }
    }
}
