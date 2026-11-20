package com.amazonaws.services.s3.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Grant {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Grantee f16015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Permission f16016b;

    public Grant(Grantee grantee, Permission permission) {
        this.f16015a = grantee;
        this.f16016b = permission;
    }

    public Grantee a() {
        return this.f16015a;
    }

    public Permission b() {
        return this.f16016b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Grant grant = (Grant) obj;
        Grantee grantee = this.f16015a;
        if (grantee == null) {
            if (grant.f16015a != null) {
                return false;
            }
        } else if (!grantee.equals(grant.f16015a)) {
            return false;
        }
        return this.f16016b == grant.f16016b;
    }

    public int hashCode() {
        Grantee grantee = this.f16015a;
        int iHashCode = ((grantee == null ? 0 : grantee.hashCode()) + 31) * 31;
        Permission permission = this.f16016b;
        return iHashCode + (permission != null ? permission.hashCode() : 0);
    }

    public String toString() {
        return "Grant [grantee=" + this.f16015a + ", permission=" + this.f16016b + "]";
    }
}
