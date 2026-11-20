package com.applovin.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f23994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23995b;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f24000a;

        a(String str) {
            this.f24000a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f24000a;
        }
    }

    public w(String str, com.applovin.impl.sdk.j jVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f23995b = str;
        this.f23994a = jVar;
    }

    private String a(sj sjVar) {
        for (String str : this.f23994a.c(sjVar)) {
            if (this.f23995b.startsWith(str)) {
                return str;
            }
        }
        return null;
    }

    public JSONObject a() {
        if (c() != a.AD_RESPONSE_JSON) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f23995b.substring(d().length()), 0), "UTF-8"));
                this.f23994a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f23994a.J().a("AdToken", "Decoded token into ad response: " + jSONObject);
                }
                return jSONObject;
            } catch (JSONException e11) {
                this.f23994a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f23994a.J().a("AdToken", "Unable to decode token '" + this.f23995b + "' into JSON", e11);
                }
                this.f23994a.E().a("AdToken", "decodeFullAdResponseStr", e11);
                return null;
            }
        } catch (UnsupportedEncodingException e12) {
            this.f23994a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f23994a.J().a("AdToken", "Unable to process ad response from token '" + this.f23995b + "'", e12);
            }
            this.f23994a.E().a("AdToken", "decodeFullAdResponse", e12);
            return null;
        }
    }

    public String b() {
        return this.f23995b;
    }

    public a c() {
        if (a(sj.T0) != null) {
            return a.REGULAR;
        }
        return a(sj.U0) != null ? a.AD_RESPONSE_JSON : a.UNSPECIFIED;
    }

    public String d() {
        String strA = a(sj.T0);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String strA2 = a(sj.U0);
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        return strA2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        String str = this.f23995b;
        String str2 = ((w) obj).f23995b;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        String str = this.f23995b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AdToken{id=" + StringUtils.prefixToIndex(32, this.f23995b) + ", type=" + c() + '}';
    }
}
