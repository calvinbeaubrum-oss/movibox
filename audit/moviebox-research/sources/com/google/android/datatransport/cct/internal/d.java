package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends NetworkConnectionInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkConnectionInfo.NetworkType f32566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NetworkConnectionInfo.MobileSubtype f32567b;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends NetworkConnectionInfo.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NetworkConnectionInfo.NetworkType f32568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NetworkConnectionInfo.MobileSubtype f32569b;

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo a() {
            return new d(this.f32568a, this.f32569b);
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo.a b(@Nullable NetworkConnectionInfo.MobileSubtype mobileSubtype) {
            this.f32569b = mobileSubtype;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo.a c(@Nullable NetworkConnectionInfo.NetworkType networkType) {
            this.f32568a = networkType;
            return this;
        }
    }

    public d(@Nullable NetworkConnectionInfo.NetworkType networkType, @Nullable NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.f32566a = networkType;
        this.f32567b = mobileSubtype;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    @Nullable
    public NetworkConnectionInfo.MobileSubtype b() {
        return this.f32567b;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    @Nullable
    public NetworkConnectionInfo.NetworkType c() {
        return this.f32566a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.NetworkType networkType = this.f32566a;
        if (networkType != null ? networkType.equals(networkConnectionInfo.c()) : networkConnectionInfo.c() == null) {
            NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f32567b;
            if (mobileSubtype == null) {
                if (networkConnectionInfo.b() == null) {
                    return true;
                }
            } else if (mobileSubtype.equals(networkConnectionInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        NetworkConnectionInfo.NetworkType networkType = this.f32566a;
        int iHashCode = ((networkType == null ? 0 : networkType.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f32567b;
        return iHashCode ^ (mobileSubtype != null ? mobileSubtype.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f32566a + ", mobileSubtype=" + this.f32567b + "}";
    }
}
