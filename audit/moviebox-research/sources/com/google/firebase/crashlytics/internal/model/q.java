package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class q extends CrashlyticsReport.e.d.a.b.AbstractC0434e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f40514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> f40515c;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0435a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f40517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> f40518c;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0435a
        public CrashlyticsReport.e.d.a.b.AbstractC0434e a() {
            String str = "";
            if (this.f40516a == null) {
                str = " name";
            }
            if (this.f40517b == null) {
                str = str + " importance";
            }
            if (this.f40518c == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new q(this.f40516a, this.f40517b.intValue(), this.f40518c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0435a
        public CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0435a b(kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> eVar) {
            if (eVar == null) {
                throw new NullPointerException("Null frames");
            }
            this.f40518c = eVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0435a
        public CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0435a c(int i11) {
            this.f40517b = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0435a
        public CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0435a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f40516a = str;
            return this;
        }
    }

    public q(String str, int i11, kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> eVar) {
        this.f40513a = str;
        this.f40514b = i11;
        this.f40515c = eVar;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e
    @NonNull
    public kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> b() {
        return this.f40515c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e
    public int c() {
        return this.f40514b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e
    @NonNull
    public String d() {
        return this.f40513a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b.AbstractC0434e)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b.AbstractC0434e abstractC0434e = (CrashlyticsReport.e.d.a.b.AbstractC0434e) obj;
        return this.f40513a.equals(abstractC0434e.d()) && this.f40514b == abstractC0434e.c() && this.f40515c.equals(abstractC0434e.b());
    }

    public int hashCode() {
        return ((((this.f40513a.hashCode() ^ 1000003) * 1000003) ^ this.f40514b) * 1000003) ^ this.f40515c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f40513a + ", importance=" + this.f40514b + ", frames=" + this.f40515c + "}";
    }
}
