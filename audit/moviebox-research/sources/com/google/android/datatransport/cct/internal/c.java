package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import eg.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends ComplianceData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f32562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComplianceData.ProductIdOrigin f32563b;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends ComplianceData.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k f32564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ComplianceData.ProductIdOrigin f32565b;

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.a
        public ComplianceData a() {
            return new c(this.f32564a, this.f32565b);
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.a
        public ComplianceData.a b(@Nullable k kVar) {
            this.f32564a = kVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.a
        public ComplianceData.a c(@Nullable ComplianceData.ProductIdOrigin productIdOrigin) {
            this.f32565b = productIdOrigin;
            return this;
        }
    }

    public c(@Nullable k kVar, @Nullable ComplianceData.ProductIdOrigin productIdOrigin) {
        this.f32562a = kVar;
        this.f32563b = productIdOrigin;
    }

    @Override // com.google.android.datatransport.cct.internal.ComplianceData
    @Nullable
    public k b() {
        return this.f32562a;
    }

    @Override // com.google.android.datatransport.cct.internal.ComplianceData
    @Nullable
    public ComplianceData.ProductIdOrigin c() {
        return this.f32563b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComplianceData)) {
            return false;
        }
        ComplianceData complianceData = (ComplianceData) obj;
        k kVar = this.f32562a;
        if (kVar != null ? kVar.equals(complianceData.b()) : complianceData.b() == null) {
            ComplianceData.ProductIdOrigin productIdOrigin = this.f32563b;
            if (productIdOrigin == null) {
                if (complianceData.c() == null) {
                    return true;
                }
            } else if (productIdOrigin.equals(complianceData.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        k kVar = this.f32562a;
        int iHashCode = ((kVar == null ? 0 : kVar.hashCode()) ^ 1000003) * 1000003;
        ComplianceData.ProductIdOrigin productIdOrigin = this.f32563b;
        return iHashCode ^ (productIdOrigin != null ? productIdOrigin.hashCode() : 0);
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f32562a + ", productIdOrigin=" + this.f32563b + "}";
    }
}
