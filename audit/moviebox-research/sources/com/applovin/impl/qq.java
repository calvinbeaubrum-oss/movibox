package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f21975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f21978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f21979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f21980j;

    public qq(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        jVar.J();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.J().d("VideoButtonProperties", "Updating video button properties with JSON = " + JsonUtils.maybeConvertToIndentedString(jSONObject));
        }
        this.f21971a = JsonUtils.getInt(jSONObject, "width", 64);
        this.f21972b = JsonUtils.getInt(jSONObject, "height", 7);
        this.f21973c = JsonUtils.getInt(jSONObject, "margin", 20);
        this.f21974d = JsonUtils.getInt(jSONObject, "gravity", 85);
        this.f21975e = JsonUtils.getBoolean(jSONObject, "tap_to_fade", Boolean.FALSE).booleanValue();
        this.f21976f = JsonUtils.getInt(jSONObject, "tap_to_fade_duration_milliseconds", 500);
        this.f21977g = JsonUtils.getInt(jSONObject, "fade_in_duration_milliseconds", 500);
        this.f21978h = JsonUtils.getInt(jSONObject, "fade_out_duration_milliseconds", 500);
        this.f21979i = JsonUtils.getFloat(jSONObject, "fade_in_delay_seconds", 1.0f);
        this.f21980j = JsonUtils.getFloat(jSONObject, "fade_out_delay_seconds", 6.0f);
    }

    public float a() {
        return this.f21979i;
    }

    public long b() {
        return this.f21977g;
    }

    public float c() {
        return this.f21980j;
    }

    public long d() {
        return this.f21978h;
    }

    public int e() {
        return this.f21974d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        qq qqVar = (qq) obj;
        return this.f21971a == qqVar.f21971a && this.f21972b == qqVar.f21972b && this.f21973c == qqVar.f21973c && this.f21974d == qqVar.f21974d && this.f21975e == qqVar.f21975e && this.f21976f == qqVar.f21976f && this.f21977g == qqVar.f21977g && this.f21978h == qqVar.f21978h && Float.compare(qqVar.f21979i, this.f21979i) == 0 && Float.compare(qqVar.f21980j, this.f21980j) == 0;
    }

    public int f() {
        return this.f21972b;
    }

    public int g() {
        return this.f21973c;
    }

    public long h() {
        return this.f21976f;
    }

    public int hashCode() {
        int i11 = ((((((((((((((this.f21971a * 31) + this.f21972b) * 31) + this.f21973c) * 31) + this.f21974d) * 31) + (this.f21975e ? 1 : 0)) * 31) + this.f21976f) * 31) + this.f21977g) * 31) + this.f21978h) * 31;
        float f11 = this.f21979i;
        int iFloatToIntBits = (i11 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
        float f12 = this.f21980j;
        return iFloatToIntBits + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0);
    }

    public int i() {
        return this.f21971a;
    }

    public boolean j() {
        return this.f21975e;
    }

    public String toString() {
        return "VideoButtonProperties{widthPercentOfScreen=" + this.f21971a + ", heightPercentOfScreen=" + this.f21972b + ", margin=" + this.f21973c + ", gravity=" + this.f21974d + ", tapToFade=" + this.f21975e + ", tapToFadeDurationMillis=" + this.f21976f + ", fadeInDurationMillis=" + this.f21977g + ", fadeOutDurationMillis=" + this.f21978h + ", fadeInDelay=" + this.f21979i + ", fadeOutDelay=" + this.f21980j + '}';
    }
}
