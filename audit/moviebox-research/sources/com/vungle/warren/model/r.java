package com.vungle.warren.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f62233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f62234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f62235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f62236d;

    public r(long j11, String str, String str2, String str3) {
        this.f62233a = j11;
        this.f62234b = str;
        this.f62235c = str2;
        this.f62236d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f62233a != rVar.f62233a) {
            return false;
        }
        String str = this.f62234b;
        if (str == null ? rVar.f62234b != null : !str.equals(rVar.f62234b)) {
            return false;
        }
        String str2 = this.f62235c;
        if (str2 == null ? rVar.f62235c != null : !str2.equals(rVar.f62235c)) {
            return false;
        }
        String str3 = this.f62236d;
        String str4 = rVar.f62236d;
        if (str3 != null) {
            return str3.equals(str4);
        }
        return str4 == null;
    }

    public int hashCode() {
        long j11 = this.f62233a;
        int i11 = ((int) (j11 ^ (j11 >>> 32))) * 31;
        String str = this.f62234b;
        int iHashCode = (i11 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f62235c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f62236d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }
}
