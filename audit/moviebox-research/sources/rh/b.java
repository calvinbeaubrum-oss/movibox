package rh;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f75390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f75391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f75392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f75393d;

    public b(String str, String str2, int i11, int i12) {
        this.f75390a = str;
        this.f75391b = str2;
        this.f75392c = i11;
        this.f75393d = i12;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f75392c == bVar.f75392c && this.f75393d == bVar.f75393d && com.google.common.base.j.a(this.f75390a, bVar.f75390a) && com.google.common.base.j.a(this.f75391b, bVar.f75391b);
    }

    public int hashCode() {
        return com.google.common.base.j.b(this.f75390a, this.f75391b, Integer.valueOf(this.f75392c), Integer.valueOf(this.f75393d));
    }
}
