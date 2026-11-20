package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SkuDetails {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f16306b;

    @NonNull
    public String a() {
        return this.f16306b.optString("productId");
    }

    @NonNull
    public String b() {
        return this.f16306b.optString("type");
    }

    public int c() {
        return this.f16306b.optInt(CampaignEx.JSON_KEY_OFFER_TYPE);
    }

    @NonNull
    public String d() {
        return this.f16306b.optString("offer_id");
    }

    @NonNull
    public String e() {
        String strOptString = this.f16306b.optString("offerIdToken");
        return strOptString.isEmpty() ? this.f16306b.optString("offer_id_token") : strOptString;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.f16305a, ((SkuDetails) obj).f16305a);
        }
        return false;
    }

    @NonNull
    public final String f() {
        return this.f16306b.optString("packageName");
    }

    @NonNull
    public String g() {
        return this.f16306b.optString("serializedDocid");
    }

    public final String h() {
        return this.f16306b.optString("skuDetailsToken");
    }

    public int hashCode() {
        return this.f16305a.hashCode();
    }

    @NonNull
    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.f16305a));
    }
}
