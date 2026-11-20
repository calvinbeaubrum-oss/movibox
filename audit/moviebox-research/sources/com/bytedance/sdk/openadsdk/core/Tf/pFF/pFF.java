package com.bytedance.sdk.openadsdk.core.Tf.pFF;

import com.applovin.sdk.AppLovinEventTypes;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends zY implements Comparable<pFF> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final float f28219sc;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private final float pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final String f28220sc;
        private zY.EnumC0292zY zY = zY.EnumC0292zY.TRACKING_URL;
        private boolean We = false;

        public sc(String str, float f11) {
            this.f28220sc = str;
            this.pFF = f11;
        }

        public pFF sc() {
            return new pFF(this.pFF, this.f28220sc, this.zY, Boolean.valueOf(this.We));
        }
    }

    private pFF(float f11, String str, zY.EnumC0292zY enumC0292zY, Boolean bool) {
        super(str, enumC0292zY, bool);
        this.f28219sc = f11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Tf.pFF.zY
    public void j_() {
        super.j_();
    }

    public JSONObject pFF() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AppLovinEventTypes.USER_VIEWED_CONTENT, zY());
        jSONObject.put("trackingFraction", this.f28219sc);
        return jSONObject;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public int compareTo(pFF pff) {
        if (pff == null) {
            return 1;
        }
        float f11 = this.f28219sc;
        float f12 = pff.f28219sc;
        if (f11 > f12) {
            return 1;
        }
        return f11 < f12 ? -1 : 0;
    }

    public boolean sc(float f11) {
        return this.f28219sc <= f11 && !ExN();
    }
}
