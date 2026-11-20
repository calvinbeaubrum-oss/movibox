package com.mbridge.msdk.foundation.same.net.d;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f44577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f44578b;

    public b(String str, String str2) {
        this.f44577a = str;
        this.f44578b = str2;
    }

    public final String a() {
        return this.f44577a;
    }

    public final String b() {
        return this.f44578b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.f44577a, bVar.f44577a) && TextUtils.equals(this.f44578b, bVar.f44578b);
    }

    public final int hashCode() {
        return (this.f44577a.hashCode() * 31) + this.f44578b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.f44577a + ",value=" + this.f44578b + "]";
    }
}
