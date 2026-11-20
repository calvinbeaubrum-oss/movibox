package com.bytedance.sdk.openadsdk.core.Tf.pFF;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends zY implements Comparable<sc> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public long f28221sc;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Tf.pFF.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0291sc {
        private final long pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final String f28222sc;
        private zY.EnumC0292zY zY = zY.EnumC0292zY.TRACKING_URL;
        private boolean We = false;

        public C0291sc(String str, long j11) {
            this.f28222sc = str;
            this.pFF = j11;
        }

        public sc sc() {
            return new sc(this.pFF, this.f28222sc, this.zY, Boolean.valueOf(this.We));
        }
    }

    public sc(long j11, String str, zY.EnumC0292zY enumC0292zY, Boolean bool) {
        super(str, enumC0292zY, bool);
        this.f28221sc = j11;
    }

    public static int sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 3) {
            try {
                return (int) ((Integer.parseInt(strArrSplit[0]) * 3600000) + (Integer.parseInt(strArrSplit[1]) * 60000) + (Float.parseFloat(strArrSplit[2]) * 1000.0f));
            } catch (Throwable unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public int compareTo(sc scVar) {
        if (scVar == null) {
            return 1;
        }
        long j11 = this.f28221sc;
        long j12 = scVar.f28221sc;
        if (j11 > j12) {
            return 1;
        }
        return j11 < j12 ? -1 : 0;
    }

    public JSONObject sc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AppLovinEventTypes.USER_VIEWED_CONTENT, zY());
        jSONObject.put("trackingMilliseconds", this.f28221sc);
        return jSONObject;
    }

    public boolean sc(long j11) {
        return this.f28221sc <= j11 && !ExN();
    }
}
