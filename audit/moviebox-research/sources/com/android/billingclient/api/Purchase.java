package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class Purchase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f16304c;

    public Purchase(@NonNull String str, @NonNull String str2) throws JSONException {
        this.f16302a = str;
        this.f16303b = str2;
        this.f16304c = new JSONObject(str);
    }

    @Nullable
    public a a() {
        JSONObject jSONObject = this.f16304c;
        String strOptString = jSONObject.optString("obfuscatedAccountId");
        String strOptString2 = jSONObject.optString("obfuscatedProfileId");
        if (strOptString == null && strOptString2 == null) {
            return null;
        }
        return new a(strOptString, strOptString2);
    }

    @Nullable
    public String b() {
        String strOptString = this.f16304c.optString("orderId");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    @NonNull
    public String c() {
        return this.f16302a;
    }

    @NonNull
    public List<String> d() {
        return i();
    }

    public int e() {
        return this.f16304c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.f16302a, purchase.c()) && TextUtils.equals(this.f16303b, purchase.h());
    }

    public long f() {
        return this.f16304c.optLong("purchaseTime");
    }

    @NonNull
    public String g() {
        JSONObject jSONObject = this.f16304c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    @NonNull
    public String h() {
        return this.f16303b;
    }

    public int hashCode() {
        return this.f16302a.hashCode();
    }

    public final ArrayList i() {
        ArrayList arrayList = new ArrayList();
        if (this.f16304c.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = this.f16304c.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i11));
                }
            }
        } else if (this.f16304c.has("productId")) {
            arrayList.add(this.f16304c.optString("productId"));
        }
        return arrayList;
    }

    @NonNull
    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f16302a));
    }
}
