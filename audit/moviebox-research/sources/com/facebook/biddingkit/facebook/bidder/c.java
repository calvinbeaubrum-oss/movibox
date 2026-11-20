package com.facebook.biddingkit.facebook.bidder;

import android.util.Base64;
import com.facebook.biddingkit.gen.FacebookAdBidFormat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f32452a = false;

    public static String a(String str, long j11) {
        if (f32452a) {
            return null;
        }
        return new StringBuilder(Base64.encodeToString(("V1_" + str + "_" + j11).getBytes(), 3)).reverse().toString();
    }

    public static JSONObject b(FacebookAdBidFormat facebookAdBidFormat) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("h", facebookAdBidFormat.getHeight()).put("w", facebookAdBidFormat.getWidth()).put("linearity", facebookAdBidFormat.getLinearity());
        if (!facebookAdBidFormat.getVideoType().isEmpty()) {
            jSONObjectPut.put("ext", new JSONObject().put("videotype", facebookAdBidFormat.getVideoType()));
        }
        return jSONObjectPut;
    }

    public static JSONArray c(FacebookBidder.a aVar) throws JSONException {
        FacebookAdBidFormat facebookAdBidFormatC = aVar.c();
        return new JSONArray().put(new JSONObject().put("id", aVar.j()).put("tagid", aVar.m()).put("instl", facebookAdBidFormatC.getInstl()).put(facebookAdBidFormatC.getFormatLabel(), b(facebookAdBidFormatC)));
    }

    public static JSONObject d(FacebookBidder.a aVar, long j11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", aVar.e());
            jSONObject.put("imp", c(aVar));
            jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, new JSONObject().put("publisher", new JSONObject().put("id", aVar.d())));
            jSONObject.put("device", new JSONObject().put("lmt", aVar.l() ? 1 : 0));
            jSONObject.put("regs", new JSONObject().put("coppa", aVar.i() ? 1 : 0));
            jSONObject.put("at", aVar.f().getValue());
            jSONObject.put("tmax", aVar.p());
            jSONObject.put("test", aVar.o() ? 1 : 0);
            jSONObject.put("ext", new JSONObject().put("platformid", aVar.n()).put("bidding_kit_version", e()).put("bidding_kit_source", aVar.h()).put("limited_data_use", aVar.k() ? 1 : 0).putOpt("id", a(aVar.d(), j11)).putOpt(CampaignEx.JSON_KEY_TIMESTAMP, f32452a ? null : Long.valueOf(j11)));
            jSONObject.put("user", new JSONObject().put("buyeruid", aVar.g()));
        } catch (JSONException e11) {
            com.facebook.biddingkit.logging.b.d("FacebookBidderPayloadBuilder", "Creating Facebook Bidder Payload failed", e11);
        }
        com.facebook.biddingkit.logging.b.a("FacebookBidderPayloadBuilder", "Bid request for Facebook: " + jSONObject.toString());
        return jSONObject;
    }

    public static String e() {
        return f32452a ? "" : "0.5.1";
    }
}
