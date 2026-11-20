package com.bytedance.sdk.openadsdk.core.Tf;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH {
    private final String We;
    private final URL pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f28215sc;
    private final String zY;

    private WH(String str, String str2, String str3, String str4) throws MalformedURLException {
        this.f28215sc = str2;
        this.pFF = new URL(str);
        this.zY = str3;
        this.We = str4;
    }

    public static WH sc(String str, String str2, String str3, String str4, String str5) {
        if (CampaignEx.KEY_OMID.equalsIgnoreCase(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new WH(str2, str3, str4, str5);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static WH sc(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("apiFramework");
            String strOptString2 = jSONObject.optString("javascriptResourceUrl");
            if (CampaignEx.KEY_OMID.equalsIgnoreCase(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                return new WH(strOptString2, jSONObject.optString("vendorKey"), jSONObject.optString("verificationParameters"), jSONObject.optString("verificationNotExecuted"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Set<WH> sc(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            return hashSet;
        }
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                hashSet.add(sc(jSONArray.getJSONObject(i11)));
            } catch (Throwable unused) {
            }
        }
        return hashSet;
    }

    private boolean sc(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public JSONObject We() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apiFramework", CampaignEx.KEY_OMID);
            jSONObject.put("javascriptResourceUrl", this.pFF.toString());
            if (!TextUtils.isEmpty(this.f28215sc)) {
                jSONObject.put("vendorKey", this.f28215sc);
            }
            if (!TextUtils.isEmpty(this.zY)) {
                jSONObject.put("verificationParameters", this.zY);
            }
            if (!TextUtils.isEmpty(this.We)) {
                jSONObject.put("verificationNotExecuted", this.We);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WH)) {
            return false;
        }
        WH wh2 = (WH) obj;
        if (sc(this.f28215sc, wh2.f28215sc) && sc(this.pFF, wh2.pFF) && sc(this.zY, wh2.zY)) {
            return sc(this.We, wh2.We);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f28215sc;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.pFF.hashCode()) * 31;
        String str2 = this.zY;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.We;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String pFF() {
        return this.zY;
    }

    public String sc() {
        return this.f28215sc;
    }

    public URL zY() {
        return this.pFF;
    }
}
