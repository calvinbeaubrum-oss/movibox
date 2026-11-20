package com.applovin.impl;

import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f20329b;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        NEUTRAL,
        POSITIVE,
        NEGATIVE
    }

    private l4(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f20328a = jVar;
        this.f20329b = jSONObject;
    }

    public static l4 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        String string = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, CampaignEx.JSON_KEY_TITLE, (JSONObject) null), "key", null);
        if ("TOS".equalsIgnoreCase(string) && jVar.u().i() == null) {
            return null;
        }
        if ("PP".equalsIgnoreCase(string) && jVar.u().h() == null) {
            return null;
        }
        return new l4(jSONObject, jVar);
    }

    public String a() {
        return JsonUtils.getString(this.f20329b, "destination_state_id", null);
    }

    public String b() {
        return JsonUtils.getString(this.f20329b, NotificationCompat.CATEGORY_EVENT, null);
    }

    public a c() {
        String string = JsonUtils.getString(this.f20329b, TtmlNode.TAG_STYLE, null);
        if (TmcEngineFactory.ENGINE_TYPE_DEFAULT.equalsIgnoreCase(string)) {
            return a.POSITIVE;
        }
        return ("destructive".equalsIgnoreCase(string) || "cancel".equalsIgnoreCase(string)) ? a.NEGATIVE : a.NEUTRAL;
    }

    public String d() {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f20329b, CampaignEx.JSON_KEY_TITLE, (JSONObject) null);
        return com.applovin.impl.sdk.j.a(JsonUtils.getString(jSONObject, "key", ""), JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "replacements", null), null));
    }

    public String toString() {
        return "ConsentFlowStateAlertAction{title=" + d() + "destinationStateId=" + a() + "event=" + b() + "}";
    }
}
