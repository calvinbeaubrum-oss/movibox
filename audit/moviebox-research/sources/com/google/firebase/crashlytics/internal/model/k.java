package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class k extends CrashlyticsReport.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CrashlyticsReport.e.d.a f40461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CrashlyticsReport.e.d.c f40462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CrashlyticsReport.e.d.AbstractC0438d f40463e;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f40464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CrashlyticsReport.e.d.a f40466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CrashlyticsReport.e.d.c f40467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CrashlyticsReport.e.d.AbstractC0438d f40468e;

        public b() {
        }

        public b(CrashlyticsReport.e.d dVar) {
            this.f40464a = Long.valueOf(dVar.e());
            this.f40465b = dVar.f();
            this.f40466c = dVar.b();
            this.f40467d = dVar.c();
            this.f40468e = dVar.d();
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d a() {
            String str = "";
            if (this.f40464a == null) {
                str = " timestamp";
            }
            if (this.f40465b == null) {
                str = str + " type";
            }
            if (this.f40466c == null) {
                str = str + " app";
            }
            if (this.f40467d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new k(this.f40464a.longValue(), this.f40465b, this.f40466c, this.f40467d, this.f40468e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b b(CrashlyticsReport.e.d.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f40466c = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b c(CrashlyticsReport.e.d.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null device");
            }
            this.f40467d = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b d(CrashlyticsReport.e.d.AbstractC0438d abstractC0438d) {
            this.f40468e = abstractC0438d;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b e(long j11) {
            this.f40464a = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.b
        public CrashlyticsReport.e.d.b f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f40465b = str;
            return this;
        }
    }

    public k(long j11, String str, CrashlyticsReport.e.d.a aVar, CrashlyticsReport.e.d.c cVar, @Nullable CrashlyticsReport.e.d.AbstractC0438d abstractC0438d) {
        this.f40459a = j11;
        this.f40460b = str;
        this.f40461c = aVar;
        this.f40462d = cVar;
        this.f40463e = abstractC0438d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    @NonNull
    public CrashlyticsReport.e.d.a b() {
        return this.f40461c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    @NonNull
    public CrashlyticsReport.e.d.c c() {
        return this.f40462d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    @Nullable
    public CrashlyticsReport.e.d.AbstractC0438d d() {
        return this.f40463e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    public long e() {
        return this.f40459a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d)) {
            return false;
        }
        CrashlyticsReport.e.d dVar = (CrashlyticsReport.e.d) obj;
        if (this.f40459a == dVar.e() && this.f40460b.equals(dVar.f()) && this.f40461c.equals(dVar.b()) && this.f40462d.equals(dVar.c())) {
            CrashlyticsReport.e.d.AbstractC0438d abstractC0438d = this.f40463e;
            if (abstractC0438d == null) {
                if (dVar.d() == null) {
                    return true;
                }
            } else if (abstractC0438d.equals(dVar.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    @NonNull
    public String f() {
        return this.f40460b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d
    public CrashlyticsReport.e.d.b g() {
        return new b(this);
    }

    public int hashCode() {
        long j11 = this.f40459a;
        int iHashCode = (((((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.f40460b.hashCode()) * 1000003) ^ this.f40461c.hashCode()) * 1000003) ^ this.f40462d.hashCode()) * 1000003;
        CrashlyticsReport.e.d.AbstractC0438d abstractC0438d = this.f40463e;
        return (abstractC0438d == null ? 0 : abstractC0438d.hashCode()) ^ iHashCode;
    }

    public String toString() {
        return "Event{timestamp=" + this.f40459a + ", type=" + this.f40460b + ", app=" + this.f40461c + ", device=" + this.f40462d + ", log=" + this.f40463e + "}";
    }
}
