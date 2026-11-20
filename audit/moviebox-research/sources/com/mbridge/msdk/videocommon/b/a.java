package com.mbridge.msdk.videocommon.b;

import com.transsion.push.PushConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f48446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f48447b;

    private a(String str, String str2) {
        this.f48446a = str;
        this.f48447b = str2;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new a(jSONObject.optString(PushConstants.PROVIDER_FIELD_APP_ID), jSONObject.optString("placementId"));
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
