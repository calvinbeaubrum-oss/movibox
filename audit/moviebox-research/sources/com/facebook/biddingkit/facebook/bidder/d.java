package com.facebook.biddingkit.facebook.bidder;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f32453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32454b;

    public d(String str) {
        this.f32453a = "https://an.facebook.com/placementbid.ortb";
        this.f32454b = "https://www.facebook.com/audiencenetwork/nurl/?partner=${PARTNER_FBID}&app=${APP_FBID}&placement=${PLACEMENT_FBID}&auction=${AUCTION_ID}&clearing_price=${AUCTION_PRICE}&ortb_loss_code=${AUCTION_LOSS}&ab_test_segment=${AB_TEST_SEGMENT}&winner_name=${WINNER_NAME}&winner_type=${WINNER_TYPE}&bundle=${BUNDLE}&phase=${PHASE}&idfa=${IDFA}";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("facebook");
            if (jSONObjectOptJSONObject != null) {
                if (jSONObjectOptJSONObject.has("bid_url")) {
                    this.f32453a = jSONObjectOptJSONObject.getString("bid_url");
                }
                if (jSONObjectOptJSONObject.has("notify_url")) {
                    this.f32454b = jSONObjectOptJSONObject.getString("notify_url");
                }
            }
        } catch (JSONException e11) {
            com.facebook.biddingkit.logging.b.d("FacebookConfig", "Failed to parse configuration.", e11);
        }
    }

    public String a() {
        return this.f32453a;
    }

    public String b() {
        return this.f32454b;
    }
}
