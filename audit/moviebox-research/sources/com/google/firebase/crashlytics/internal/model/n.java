package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class n extends CrashlyticsReport.e.d.a.b.AbstractC0428a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f40490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f40492d;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f40493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f40494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f40495c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f40496d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a
        public CrashlyticsReport.e.d.a.b.AbstractC0428a a() {
            String str = "";
            if (this.f40493a == null) {
                str = " baseAddress";
            }
            if (this.f40494b == null) {
                str = str + " size";
            }
            if (this.f40495c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new n(this.f40493a.longValue(), this.f40494b.longValue(), this.f40495c, this.f40496d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a
        public CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a b(long j11) {
            this.f40493a = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a
        public CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f40495c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a
        public CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a d(long j11) {
            this.f40494b = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a
        public CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a e(@Nullable String str) {
            this.f40496d = str;
            return this;
        }
    }

    public n(long j11, long j12, String str, @Nullable String str2) {
        this.f40489a = j11;
        this.f40490b = j12;
        this.f40491c = str;
        this.f40492d = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0428a
    @NonNull
    public long b() {
        return this.f40489a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0428a
    @NonNull
    public String c() {
        return this.f40491c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0428a
    public long d() {
        return this.f40490b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0428a
    @Nullable
    public String e() {
        return this.f40492d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b.AbstractC0428a)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b.AbstractC0428a abstractC0428a = (CrashlyticsReport.e.d.a.b.AbstractC0428a) obj;
        if (this.f40489a == abstractC0428a.b() && this.f40490b == abstractC0428a.d() && this.f40491c.equals(abstractC0428a.c())) {
            String str = this.f40492d;
            if (str == null) {
                if (abstractC0428a.e() == null) {
                    return true;
                }
            } else if (str.equals(abstractC0428a.e())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j11 = this.f40489a;
        long j12 = this.f40490b;
        int iHashCode = (((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.f40491c.hashCode()) * 1000003;
        String str = this.f40492d;
        return (str == null ? 0 : str.hashCode()) ^ iHashCode;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f40489a + ", size=" + this.f40490b + ", name=" + this.f40491c + ", uuid=" + this.f40492d + "}";
    }
}
