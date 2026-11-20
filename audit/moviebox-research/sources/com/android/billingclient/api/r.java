package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzaf;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f16424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f16428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f16429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f16430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f16431i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f16432j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final String f16433k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final List f16434l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final List f16435m;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f16437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f16438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f16439d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f16440e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final zzaf f16441f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public final Long f16442g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final z0 f16443h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public final c1 f16444i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public final a1 f16445j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public final b1 f16446k;

        public a(JSONObject jSONObject) throws JSONException {
            this.f16436a = jSONObject.optString("formattedPrice");
            this.f16437b = jSONObject.optLong("priceAmountMicros");
            this.f16438c = jSONObject.optString("priceCurrencyCode");
            this.f16439d = jSONObject.optString("offerIdToken");
            this.f16440e = jSONObject.optString("offerId");
            jSONObject.optInt("offerType");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i11));
                }
            }
            this.f16441f = zzaf.zzj(arrayList);
            this.f16442g = jSONObject.has("fullPriceMicros") ? Long.valueOf(jSONObject.optLong("fullPriceMicros")) : null;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
            this.f16443h = jSONObjectOptJSONObject == null ? null : new z0(jSONObjectOptJSONObject);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
            this.f16444i = jSONObjectOptJSONObject2 == null ? null : new c1(jSONObjectOptJSONObject2);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
            this.f16445j = jSONObjectOptJSONObject3 == null ? null : new a1(jSONObjectOptJSONObject3);
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("preorderDetails");
            this.f16446k = jSONObjectOptJSONObject4 != null ? new b1(jSONObjectOptJSONObject4) : null;
        }

        @NonNull
        public final String a() {
            return this.f16439d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f16448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f16449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f16450d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f16451e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f16452f;

        public b(JSONObject jSONObject) {
            this.f16450d = jSONObject.optString("billingPeriod");
            this.f16449c = jSONObject.optString("priceCurrencyCode");
            this.f16447a = jSONObject.optString("formattedPrice");
            this.f16448b = jSONObject.optLong("priceAmountMicros");
            this.f16452f = jSONObject.optInt("recurrenceMode");
            this.f16451e = jSONObject.optInt("billingCycleCount");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f16453a;

        public c(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new b(jSONObjectOptJSONObject));
                    }
                }
            }
            this.f16453a = arrayList;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f16455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f16456c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f16457d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f16458e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final y0 f16459f;

        public d(JSONObject jSONObject) throws JSONException {
            this.f16454a = jSONObject.optString("basePlanId");
            String strOptString = jSONObject.optString("offerId");
            this.f16455b = true == strOptString.isEmpty() ? null : strOptString;
            this.f16456c = jSONObject.getString("offerIdToken");
            this.f16457d = new c(jSONObject.getJSONArray("pricingPhases"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.f16459f = jSONObjectOptJSONObject != null ? new y0(jSONObjectOptJSONObject) : null;
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            if (jSONArrayOptJSONArray != null) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i11));
                }
            }
            this.f16458e = arrayList;
        }

        @NonNull
        public String a() {
            return this.f16456c;
        }
    }

    public r(String str) throws JSONException {
        this.f16423a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f16424b = jSONObject;
        String strOptString = jSONObject.optString("productId");
        this.f16425c = strOptString;
        String strOptString2 = jSONObject.optString("type");
        this.f16426d = strOptString2;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(strOptString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f16427e = jSONObject.optString(CampaignEx.JSON_KEY_TITLE);
        this.f16428f = jSONObject.optString("name");
        this.f16429g = jSONObject.optString(TrackingKey.DESCRIPTION);
        this.f16431i = jSONObject.optString("packageDisplayName");
        this.f16432j = jSONObject.optString("iconUrl");
        this.f16430h = jSONObject.optString("skuDetailsToken");
        this.f16433k = jSONObject.optString("serializedDocid");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                arrayList.add(new d(jSONArrayOptJSONArray.getJSONObject(i11)));
            }
            this.f16434l = arrayList;
        } else {
            this.f16434l = (strOptString2.equals("subs") || strOptString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject jSONObjectOptJSONObject = this.f16424b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray jSONArrayOptJSONArray2 = this.f16424b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i12 = 0; i12 < jSONArrayOptJSONArray2.length(); i12++) {
                arrayList2.add(new a(jSONArrayOptJSONArray2.getJSONObject(i12)));
            }
            this.f16435m = arrayList2;
            return;
        }
        if (jSONObjectOptJSONObject == null) {
            this.f16435m = null;
        } else {
            arrayList2.add(new a(jSONObjectOptJSONObject));
            this.f16435m = arrayList2;
        }
    }

    @Nullable
    public a a() {
        List list = this.f16435m;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (a) this.f16435m.get(0);
    }

    @NonNull
    public String b() {
        return this.f16425c;
    }

    @NonNull
    public String c() {
        return this.f16426d;
    }

    @Nullable
    public List<d> d() {
        return this.f16434l;
    }

    @NonNull
    public final String e() {
        return this.f16424b.optString("packageName");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            return TextUtils.equals(this.f16423a, ((r) obj).f16423a);
        }
        return false;
    }

    public final String f() {
        return this.f16430h;
    }

    @Nullable
    public String g() {
        return this.f16433k;
    }

    public int hashCode() {
        return this.f16423a.hashCode();
    }

    @NonNull
    public String toString() {
        List list = this.f16434l;
        return "ProductDetails{jsonString='" + this.f16423a + "', parsedJson=" + this.f16424b.toString() + ", productId='" + this.f16425c + "', productType='" + this.f16426d + "', title='" + this.f16427e + "', productDetailsToken='" + this.f16430h + "', subscriptionOfferDetails=" + String.valueOf(list) + "}";
    }
}
