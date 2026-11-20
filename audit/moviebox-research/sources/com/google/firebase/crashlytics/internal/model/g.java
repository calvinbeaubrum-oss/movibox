package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g extends CrashlyticsReport.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f40406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f40407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f40408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CrashlyticsReport.e.a f40409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CrashlyticsReport.e.f f40410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CrashlyticsReport.e.AbstractC0439e f40411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CrashlyticsReport.e.c f40412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final kk.e<CrashlyticsReport.e.d> f40413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f40414k;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f40417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f40418d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f40419e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CrashlyticsReport.e.a f40420f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CrashlyticsReport.e.f f40421g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CrashlyticsReport.e.AbstractC0439e f40422h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CrashlyticsReport.e.c f40423i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public kk.e<CrashlyticsReport.e.d> f40424j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f40425k;

        public b() {
        }

        public b(CrashlyticsReport.e eVar) {
            this.f40415a = eVar.f();
            this.f40416b = eVar.h();
            this.f40417c = Long.valueOf(eVar.k());
            this.f40418d = eVar.d();
            this.f40419e = Boolean.valueOf(eVar.m());
            this.f40420f = eVar.b();
            this.f40421g = eVar.l();
            this.f40422h = eVar.j();
            this.f40423i = eVar.c();
            this.f40424j = eVar.e();
            this.f40425k = Integer.valueOf(eVar.g());
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e a() {
            String str = "";
            if (this.f40415a == null) {
                str = " generator";
            }
            if (this.f40416b == null) {
                str = str + " identifier";
            }
            if (this.f40417c == null) {
                str = str + " startedAt";
            }
            if (this.f40419e == null) {
                str = str + " crashed";
            }
            if (this.f40420f == null) {
                str = str + " app";
            }
            if (this.f40425k == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new g(this.f40415a, this.f40416b, this.f40417c.longValue(), this.f40418d, this.f40419e.booleanValue(), this.f40420f, this.f40421g, this.f40422h, this.f40423i, this.f40424j, this.f40425k.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b b(CrashlyticsReport.e.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f40420f = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b c(boolean z11) {
            this.f40419e = Boolean.valueOf(z11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b d(CrashlyticsReport.e.c cVar) {
            this.f40423i = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b e(Long l11) {
            this.f40418d = l11;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b f(kk.e<CrashlyticsReport.e.d> eVar) {
            this.f40424j = eVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b g(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.f40415a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b h(int i11) {
            this.f40425k = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b i(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f40416b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b k(CrashlyticsReport.e.AbstractC0439e abstractC0439e) {
            this.f40422h = abstractC0439e;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b l(long j11) {
            this.f40417c = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.b
        public CrashlyticsReport.e.b m(CrashlyticsReport.e.f fVar) {
            this.f40421g = fVar;
            return this;
        }
    }

    public g(String str, String str2, long j11, @Nullable Long l11, boolean z11, CrashlyticsReport.e.a aVar, @Nullable CrashlyticsReport.e.f fVar, @Nullable CrashlyticsReport.e.AbstractC0439e abstractC0439e, @Nullable CrashlyticsReport.e.c cVar, @Nullable kk.e<CrashlyticsReport.e.d> eVar, int i11) {
        this.f40404a = str;
        this.f40405b = str2;
        this.f40406c = j11;
        this.f40407d = l11;
        this.f40408e = z11;
        this.f40409f = aVar;
        this.f40410g = fVar;
        this.f40411h = abstractC0439e;
        this.f40412i = cVar;
        this.f40413j = eVar;
        this.f40414k = i11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    @NonNull
    public CrashlyticsReport.e.a b() {
        return this.f40409f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    @Nullable
    public CrashlyticsReport.e.c c() {
        return this.f40412i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    @Nullable
    public Long d() {
        return this.f40407d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    @Nullable
    public kk.e<CrashlyticsReport.e.d> e() {
        return this.f40413j;
    }

    public boolean equals(Object obj) {
        Long l11;
        CrashlyticsReport.e.f fVar;
        CrashlyticsReport.e.AbstractC0439e abstractC0439e;
        CrashlyticsReport.e.c cVar;
        kk.e<CrashlyticsReport.e.d> eVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e)) {
            return false;
        }
        CrashlyticsReport.e eVar2 = (CrashlyticsReport.e) obj;
        return this.f40404a.equals(eVar2.f()) && this.f40405b.equals(eVar2.h()) && this.f40406c == eVar2.k() && ((l11 = this.f40407d) != null ? l11.equals(eVar2.d()) : eVar2.d() == null) && this.f40408e == eVar2.m() && this.f40409f.equals(eVar2.b()) && ((fVar = this.f40410g) != null ? fVar.equals(eVar2.l()) : eVar2.l() == null) && ((abstractC0439e = this.f40411h) != null ? abstractC0439e.equals(eVar2.j()) : eVar2.j() == null) && ((cVar = this.f40412i) != null ? cVar.equals(eVar2.c()) : eVar2.c() == null) && ((eVar = this.f40413j) != null ? eVar.equals(eVar2.e()) : eVar2.e() == null) && this.f40414k == eVar2.g();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    @NonNull
    public String f() {
        return this.f40404a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public int g() {
        return this.f40414k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    @NonNull
    public String h() {
        return this.f40405b;
    }

    public int hashCode() {
        int iHashCode = (((this.f40404a.hashCode() ^ 1000003) * 1000003) ^ this.f40405b.hashCode()) * 1000003;
        long j11 = this.f40406c;
        int i11 = (iHashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        Long l11 = this.f40407d;
        int iHashCode2 = (((((i11 ^ (l11 == null ? 0 : l11.hashCode())) * 1000003) ^ (this.f40408e ? 1231 : 1237)) * 1000003) ^ this.f40409f.hashCode()) * 1000003;
        CrashlyticsReport.e.f fVar = this.f40410g;
        int iHashCode3 = (iHashCode2 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        CrashlyticsReport.e.AbstractC0439e abstractC0439e = this.f40411h;
        int iHashCode4 = (iHashCode3 ^ (abstractC0439e == null ? 0 : abstractC0439e.hashCode())) * 1000003;
        CrashlyticsReport.e.c cVar = this.f40412i;
        int iHashCode5 = (iHashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        kk.e<CrashlyticsReport.e.d> eVar = this.f40413j;
        return ((iHashCode5 ^ (eVar != null ? eVar.hashCode() : 0)) * 1000003) ^ this.f40414k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    @Nullable
    public CrashlyticsReport.e.AbstractC0439e j() {
        return this.f40411h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public long k() {
        return this.f40406c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    @Nullable
    public CrashlyticsReport.e.f l() {
        return this.f40410g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public boolean m() {
        return this.f40408e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e
    public CrashlyticsReport.e.b n() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f40404a + ", identifier=" + this.f40405b + ", startedAt=" + this.f40406c + ", endedAt=" + this.f40407d + ", crashed=" + this.f40408e + ", app=" + this.f40409f + ", user=" + this.f40410g + ", os=" + this.f40411h + ", device=" + this.f40412i + ", events=" + this.f40413j + ", generatorType=" + this.f40414k + "}";
    }
}
