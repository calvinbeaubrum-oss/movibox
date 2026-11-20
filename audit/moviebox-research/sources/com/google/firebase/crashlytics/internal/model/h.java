package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class h extends CrashlyticsReport.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CrashlyticsReport.e.a.b f40429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f40430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f40431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f40432g;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.a.AbstractC0426a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f40435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CrashlyticsReport.e.a.b f40436d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f40437e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f40438f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f40439g;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0426a
        public CrashlyticsReport.e.a a() {
            String str = "";
            if (this.f40433a == null) {
                str = " identifier";
            }
            if (this.f40434b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new h(this.f40433a, this.f40434b, this.f40435c, this.f40436d, this.f40437e, this.f40438f, this.f40439g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0426a
        public CrashlyticsReport.e.a.AbstractC0426a b(@Nullable String str) {
            this.f40438f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0426a
        public CrashlyticsReport.e.a.AbstractC0426a c(@Nullable String str) {
            this.f40439g = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0426a
        public CrashlyticsReport.e.a.AbstractC0426a d(String str) {
            this.f40435c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0426a
        public CrashlyticsReport.e.a.AbstractC0426a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f40433a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0426a
        public CrashlyticsReport.e.a.AbstractC0426a f(String str) {
            this.f40437e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.AbstractC0426a
        public CrashlyticsReport.e.a.AbstractC0426a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f40434b = str;
            return this;
        }
    }

    public h(String str, String str2, @Nullable String str3, @Nullable CrashlyticsReport.e.a.b bVar, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.f40426a = str;
        this.f40427b = str2;
        this.f40428c = str3;
        this.f40429d = bVar;
        this.f40430e = str4;
        this.f40431f = str5;
        this.f40432g = str6;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    @Nullable
    public String b() {
        return this.f40431f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    @Nullable
    public String c() {
        return this.f40432g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    @Nullable
    public String d() {
        return this.f40428c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    @NonNull
    public String e() {
        return this.f40426a;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.e.a.b bVar;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.a)) {
            return false;
        }
        CrashlyticsReport.e.a aVar = (CrashlyticsReport.e.a) obj;
        if (this.f40426a.equals(aVar.e()) && this.f40427b.equals(aVar.h()) && ((str = this.f40428c) != null ? str.equals(aVar.d()) : aVar.d() == null) && ((bVar = this.f40429d) != null ? bVar.equals(aVar.g()) : aVar.g() == null) && ((str2 = this.f40430e) != null ? str2.equals(aVar.f()) : aVar.f() == null) && ((str3 = this.f40431f) != null ? str3.equals(aVar.b()) : aVar.b() == null)) {
            String str4 = this.f40432g;
            if (str4 == null) {
                if (aVar.c() == null) {
                    return true;
                }
            } else if (str4.equals(aVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    @Nullable
    public String f() {
        return this.f40430e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    @Nullable
    public CrashlyticsReport.e.a.b g() {
        return this.f40429d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a
    @NonNull
    public String h() {
        return this.f40427b;
    }

    public int hashCode() {
        int iHashCode = (((this.f40426a.hashCode() ^ 1000003) * 1000003) ^ this.f40427b.hashCode()) * 1000003;
        String str = this.f40428c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        CrashlyticsReport.e.a.b bVar = this.f40429d;
        int iHashCode3 = (iHashCode2 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        String str2 = this.f40430e;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f40431f;
        int iHashCode5 = (iHashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f40432g;
        return iHashCode5 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.f40426a + ", version=" + this.f40427b + ", displayVersion=" + this.f40428c + ", organization=" + this.f40429d + ", installationUuid=" + this.f40430e + ", developmentPlatform=" + this.f40431f + ", developmentPlatformVersion=" + this.f40432g + "}";
    }
}
