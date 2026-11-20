package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class p extends CrashlyticsReport.e.d.a.b.AbstractC0432d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f40509c;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.d.a.b.AbstractC0432d.AbstractC0433a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f40512c;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0432d.AbstractC0433a
        public CrashlyticsReport.e.d.a.b.AbstractC0432d a() {
            String str = "";
            if (this.f40510a == null) {
                str = " name";
            }
            if (this.f40511b == null) {
                str = str + " code";
            }
            if (this.f40512c == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new p(this.f40510a, this.f40511b, this.f40512c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0432d.AbstractC0433a
        public CrashlyticsReport.e.d.a.b.AbstractC0432d.AbstractC0433a b(long j11) {
            this.f40512c = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0432d.AbstractC0433a
        public CrashlyticsReport.e.d.a.b.AbstractC0432d.AbstractC0433a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f40511b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0432d.AbstractC0433a
        public CrashlyticsReport.e.d.a.b.AbstractC0432d.AbstractC0433a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f40510a = str;
            return this;
        }
    }

    public p(String str, String str2, long j11) {
        this.f40507a = str;
        this.f40508b = str2;
        this.f40509c = j11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0432d
    @NonNull
    public long b() {
        return this.f40509c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0432d
    @NonNull
    public String c() {
        return this.f40508b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0432d
    @NonNull
    public String d() {
        return this.f40507a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b.AbstractC0432d)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b.AbstractC0432d abstractC0432d = (CrashlyticsReport.e.d.a.b.AbstractC0432d) obj;
        return this.f40507a.equals(abstractC0432d.d()) && this.f40508b.equals(abstractC0432d.c()) && this.f40509c == abstractC0432d.b();
    }

    public int hashCode() {
        int iHashCode = (((this.f40507a.hashCode() ^ 1000003) * 1000003) ^ this.f40508b.hashCode()) * 1000003;
        long j11 = this.f40509c;
        return iHashCode ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f40507a + ", code=" + this.f40508b + ", address=" + this.f40509c + "}";
    }
}
