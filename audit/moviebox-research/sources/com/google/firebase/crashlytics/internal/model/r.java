package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class r extends CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f40522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f40523e;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f40524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f40526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f40527d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f40528e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a
        public CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b a() {
            String str = "";
            if (this.f40524a == null) {
                str = " pc";
            }
            if (this.f40525b == null) {
                str = str + " symbol";
            }
            if (this.f40527d == null) {
                str = str + " offset";
            }
            if (this.f40528e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new r(this.f40524a.longValue(), this.f40525b, this.f40526c, this.f40527d.longValue(), this.f40528e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a
        public CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a b(String str) {
            this.f40526c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a
        public CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a c(int i11) {
            this.f40528e = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a
        public CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a d(long j11) {
            this.f40527d = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a
        public CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a e(long j11) {
            this.f40524a = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a
        public CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.f40525b = str;
            return this;
        }
    }

    public r(long j11, String str, @Nullable String str2, long j12, int i11) {
        this.f40519a = j11;
        this.f40520b = str;
        this.f40521c = str2;
        this.f40522d = j12;
        this.f40523e = i11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b
    @Nullable
    public String b() {
        return this.f40521c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b
    public int c() {
        return this.f40523e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b
    public long d() {
        return this.f40522d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b
    public long e() {
        return this.f40519a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b abstractC0436b = (CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b) obj;
        return this.f40519a == abstractC0436b.e() && this.f40520b.equals(abstractC0436b.f()) && ((str = this.f40521c) != null ? str.equals(abstractC0436b.b()) : abstractC0436b.b() == null) && this.f40522d == abstractC0436b.d() && this.f40523e == abstractC0436b.c();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b
    @NonNull
    public String f() {
        return this.f40520b;
    }

    public int hashCode() {
        long j11 = this.f40519a;
        int iHashCode = (((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.f40520b.hashCode()) * 1000003;
        String str = this.f40521c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j12 = this.f40522d;
        return this.f40523e ^ ((iHashCode2 ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.f40519a + ", symbol=" + this.f40520b + ", file=" + this.f40521c + ", offset=" + this.f40522d + ", importance=" + this.f40523e + "}";
    }
}
