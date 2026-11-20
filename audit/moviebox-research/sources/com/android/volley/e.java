package com.android.volley;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16503b;

    public e(String str, String str2) {
        this.f16502a = str;
        this.f16503b = str2;
    }

    public final String a() {
        return this.f16502a;
    }

    public final String b() {
        return this.f16503b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return TextUtils.equals(this.f16502a, eVar.f16502a) && TextUtils.equals(this.f16503b, eVar.f16503b);
    }

    public int hashCode() {
        return (this.f16502a.hashCode() * 31) + this.f16503b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f16502a + ",value=" + this.f16503b + "]";
    }
}
