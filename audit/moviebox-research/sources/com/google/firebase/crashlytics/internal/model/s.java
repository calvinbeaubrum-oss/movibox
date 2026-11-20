package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class s extends CrashlyticsReport.e.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f40529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f40530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f40531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f40532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f40533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f40534f;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.d.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f40535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f40536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f40537c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f40538d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f40539e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f40540f;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c a() {
            String str = "";
            if (this.f40536b == null) {
                str = " batteryVelocity";
            }
            if (this.f40537c == null) {
                str = str + " proximityOn";
            }
            if (this.f40538d == null) {
                str = str + " orientation";
            }
            if (this.f40539e == null) {
                str = str + " ramUsed";
            }
            if (this.f40540f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new s(this.f40535a, this.f40536b.intValue(), this.f40537c.booleanValue(), this.f40538d.intValue(), this.f40539e.longValue(), this.f40540f.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a b(Double d11) {
            this.f40535a = d11;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a c(int i11) {
            this.f40536b = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a d(long j11) {
            this.f40540f = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a e(int i11) {
            this.f40538d = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a f(boolean z11) {
            this.f40537c = Boolean.valueOf(z11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c.a
        public CrashlyticsReport.e.d.c.a g(long j11) {
            this.f40539e = Long.valueOf(j11);
            return this;
        }
    }

    public s(@Nullable Double d11, int i11, boolean z11, int i12, long j11, long j12) {
        this.f40529a = d11;
        this.f40530b = i11;
        this.f40531c = z11;
        this.f40532d = i12;
        this.f40533e = j11;
        this.f40534f = j12;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    @Nullable
    public Double b() {
        return this.f40529a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public int c() {
        return this.f40530b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public long d() {
        return this.f40534f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public int e() {
        return this.f40532d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.c)) {
            return false;
        }
        CrashlyticsReport.e.d.c cVar = (CrashlyticsReport.e.d.c) obj;
        Double d11 = this.f40529a;
        if (d11 != null ? d11.equals(cVar.b()) : cVar.b() == null) {
            if (this.f40530b == cVar.c() && this.f40531c == cVar.g() && this.f40532d == cVar.e() && this.f40533e == cVar.f() && this.f40534f == cVar.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public long f() {
        return this.f40533e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.c
    public boolean g() {
        return this.f40531c;
    }

    public int hashCode() {
        Double d11 = this.f40529a;
        int iHashCode = ((((((((d11 == null ? 0 : d11.hashCode()) ^ 1000003) * 1000003) ^ this.f40530b) * 1000003) ^ (this.f40531c ? 1231 : 1237)) * 1000003) ^ this.f40532d) * 1000003;
        long j11 = this.f40533e;
        long j12 = this.f40534f;
        return ((iHashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f40529a + ", batteryVelocity=" + this.f40530b + ", proximityOn=" + this.f40531c + ", orientation=" + this.f40532d + ", ramUsed=" + this.f40533e + ", diskUsed=" + this.f40534f + "}";
    }
}
