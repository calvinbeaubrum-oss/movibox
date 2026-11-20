package com.mbridge.msdk.e.a;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f43795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f43796b;

    public i(String str, String str2) {
        this.f43795a = str;
        this.f43796b = str2;
    }

    public final String a() {
        return this.f43795a;
    }

    public final String b() {
        return this.f43796b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return TextUtils.equals(this.f43795a, iVar.f43795a) && TextUtils.equals(this.f43796b, iVar.f43796b);
    }

    public final int hashCode() {
        return (this.f43795a.hashCode() * 31) + this.f43796b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.f43795a + ",value=" + this.f43796b + "]";
    }
}
