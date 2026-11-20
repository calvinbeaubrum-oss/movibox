package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class l extends CrashlyticsReport.e.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CrashlyticsReport.e.d.a.b f40469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kk.e<CrashlyticsReport.c> f40470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kk.e<CrashlyticsReport.c> f40471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f40472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f40473e;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.d.a.AbstractC0427a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CrashlyticsReport.e.d.a.b f40474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public kk.e<CrashlyticsReport.c> f40475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public kk.e<CrashlyticsReport.c> f40476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f40477d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f40478e;

        public b() {
        }

        public b(CrashlyticsReport.e.d.a aVar) {
            this.f40474a = aVar.d();
            this.f40475b = aVar.c();
            this.f40476c = aVar.e();
            this.f40477d = aVar.b();
            this.f40478e = Integer.valueOf(aVar.f());
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0427a
        public CrashlyticsReport.e.d.a a() {
            String str = "";
            if (this.f40474a == null) {
                str = " execution";
            }
            if (this.f40478e == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new l(this.f40474a, this.f40475b, this.f40476c, this.f40477d, this.f40478e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0427a
        public CrashlyticsReport.e.d.a.AbstractC0427a b(@Nullable Boolean bool) {
            this.f40477d = bool;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0427a
        public CrashlyticsReport.e.d.a.AbstractC0427a c(kk.e<CrashlyticsReport.c> eVar) {
            this.f40475b = eVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0427a
        public CrashlyticsReport.e.d.a.AbstractC0427a d(CrashlyticsReport.e.d.a.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null execution");
            }
            this.f40474a = bVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0427a
        public CrashlyticsReport.e.d.a.AbstractC0427a e(kk.e<CrashlyticsReport.c> eVar) {
            this.f40476c = eVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.AbstractC0427a
        public CrashlyticsReport.e.d.a.AbstractC0427a f(int i11) {
            this.f40478e = Integer.valueOf(i11);
            return this;
        }
    }

    public l(CrashlyticsReport.e.d.a.b bVar, @Nullable kk.e<CrashlyticsReport.c> eVar, @Nullable kk.e<CrashlyticsReport.c> eVar2, @Nullable Boolean bool, int i11) {
        this.f40469a = bVar;
        this.f40470b = eVar;
        this.f40471c = eVar2;
        this.f40472d = bool;
        this.f40473e = i11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    @Nullable
    public Boolean b() {
        return this.f40472d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    @Nullable
    public kk.e<CrashlyticsReport.c> c() {
        return this.f40470b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    @NonNull
    public CrashlyticsReport.e.d.a.b d() {
        return this.f40469a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    @Nullable
    public kk.e<CrashlyticsReport.c> e() {
        return this.f40471c;
    }

    public boolean equals(Object obj) {
        kk.e<CrashlyticsReport.c> eVar;
        kk.e<CrashlyticsReport.c> eVar2;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a)) {
            return false;
        }
        CrashlyticsReport.e.d.a aVar = (CrashlyticsReport.e.d.a) obj;
        return this.f40469a.equals(aVar.d()) && ((eVar = this.f40470b) != null ? eVar.equals(aVar.c()) : aVar.c() == null) && ((eVar2 = this.f40471c) != null ? eVar2.equals(aVar.e()) : aVar.e() == null) && ((bool = this.f40472d) != null ? bool.equals(aVar.b()) : aVar.b() == null) && this.f40473e == aVar.f();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    public int f() {
        return this.f40473e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a
    public CrashlyticsReport.e.d.a.AbstractC0427a g() {
        return new b(this);
    }

    public int hashCode() {
        int iHashCode = (this.f40469a.hashCode() ^ 1000003) * 1000003;
        kk.e<CrashlyticsReport.c> eVar = this.f40470b;
        int iHashCode2 = (iHashCode ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        kk.e<CrashlyticsReport.c> eVar2 = this.f40471c;
        int iHashCode3 = (iHashCode2 ^ (eVar2 == null ? 0 : eVar2.hashCode())) * 1000003;
        Boolean bool = this.f40472d;
        return ((iHashCode3 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.f40473e;
    }

    public String toString() {
        return "Application{execution=" + this.f40469a + ", customAttributes=" + this.f40470b + ", internalKeys=" + this.f40471c + ", background=" + this.f40472d + ", uiOrientation=" + this.f40473e + "}";
    }
}
