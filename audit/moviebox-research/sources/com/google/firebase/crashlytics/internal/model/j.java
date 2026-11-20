package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j extends CrashlyticsReport.e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f40443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f40444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f40445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f40446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f40447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f40448h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f40449i;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f40450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f40452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f40453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f40454e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f40455f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f40456g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f40457h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f40458i;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c a() {
            String str = "";
            if (this.f40450a == null) {
                str = " arch";
            }
            if (this.f40451b == null) {
                str = str + " model";
            }
            if (this.f40452c == null) {
                str = str + " cores";
            }
            if (this.f40453d == null) {
                str = str + " ram";
            }
            if (this.f40454e == null) {
                str = str + " diskSpace";
            }
            if (this.f40455f == null) {
                str = str + " simulator";
            }
            if (this.f40456g == null) {
                str = str + " state";
            }
            if (this.f40457h == null) {
                str = str + " manufacturer";
            }
            if (this.f40458i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new j(this.f40450a.intValue(), this.f40451b, this.f40452c.intValue(), this.f40453d.longValue(), this.f40454e.longValue(), this.f40455f.booleanValue(), this.f40456g.intValue(), this.f40457h, this.f40458i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a b(int i11) {
            this.f40450a = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a c(int i11) {
            this.f40452c = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a d(long j11) {
            this.f40454e = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null manufacturer");
            }
            this.f40457h = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null model");
            }
            this.f40451b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null modelClass");
            }
            this.f40458i = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a h(long j11) {
            this.f40453d = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a i(boolean z11) {
            this.f40455f = Boolean.valueOf(z11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c.a
        public CrashlyticsReport.e.c.a j(int i11) {
            this.f40456g = Integer.valueOf(i11);
            return this;
        }
    }

    public j(int i11, String str, int i12, long j11, long j12, boolean z11, int i13, String str2, String str3) {
        this.f40441a = i11;
        this.f40442b = str;
        this.f40443c = i12;
        this.f40444d = j11;
        this.f40445e = j12;
        this.f40446f = z11;
        this.f40447g = i13;
        this.f40448h = str2;
        this.f40449i = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    @NonNull
    public int b() {
        return this.f40441a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public int c() {
        return this.f40443c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public long d() {
        return this.f40445e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    @NonNull
    public String e() {
        return this.f40448h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.c)) {
            return false;
        }
        CrashlyticsReport.e.c cVar = (CrashlyticsReport.e.c) obj;
        return this.f40441a == cVar.b() && this.f40442b.equals(cVar.f()) && this.f40443c == cVar.c() && this.f40444d == cVar.h() && this.f40445e == cVar.d() && this.f40446f == cVar.j() && this.f40447g == cVar.i() && this.f40448h.equals(cVar.e()) && this.f40449i.equals(cVar.g());
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    @NonNull
    public String f() {
        return this.f40442b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    @NonNull
    public String g() {
        return this.f40449i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public long h() {
        return this.f40444d;
    }

    public int hashCode() {
        int iHashCode = (((((this.f40441a ^ 1000003) * 1000003) ^ this.f40442b.hashCode()) * 1000003) ^ this.f40443c) * 1000003;
        long j11 = this.f40444d;
        int i11 = (iHashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f40445e;
        return ((((((((i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ (this.f40446f ? 1231 : 1237)) * 1000003) ^ this.f40447g) * 1000003) ^ this.f40448h.hashCode()) * 1000003) ^ this.f40449i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public int i() {
        return this.f40447g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.c
    public boolean j() {
        return this.f40446f;
    }

    public String toString() {
        return "Device{arch=" + this.f40441a + ", model=" + this.f40442b + ", cores=" + this.f40443c + ", ram=" + this.f40444d + ", diskSpace=" + this.f40445e + ", simulator=" + this.f40446f + ", state=" + this.f40447g + ", manufacturer=" + this.f40448h + ", modelClass=" + this.f40449i + "}";
    }
}
