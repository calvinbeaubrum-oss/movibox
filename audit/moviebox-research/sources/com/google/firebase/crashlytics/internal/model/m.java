package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m extends CrashlyticsReport.e.d.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e> f40479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CrashlyticsReport.e.d.a.b.c f40480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CrashlyticsReport.a f40481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CrashlyticsReport.e.d.a.b.AbstractC0432d f40482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kk.e<CrashlyticsReport.e.d.a.b.AbstractC0428a> f40483e;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.d.a.b.AbstractC0430b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e> f40484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CrashlyticsReport.e.d.a.b.c f40485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CrashlyticsReport.a f40486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CrashlyticsReport.e.d.a.b.AbstractC0432d f40487d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public kk.e<CrashlyticsReport.e.d.a.b.AbstractC0428a> f40488e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0430b
        public CrashlyticsReport.e.d.a.b a() {
            String str = "";
            if (this.f40487d == null) {
                str = " signal";
            }
            if (this.f40488e == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new m(this.f40484a, this.f40485b, this.f40486c, this.f40487d, this.f40488e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0430b
        public CrashlyticsReport.e.d.a.b.AbstractC0430b b(CrashlyticsReport.a aVar) {
            this.f40486c = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0430b
        public CrashlyticsReport.e.d.a.b.AbstractC0430b c(kk.e<CrashlyticsReport.e.d.a.b.AbstractC0428a> eVar) {
            if (eVar == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f40488e = eVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0430b
        public CrashlyticsReport.e.d.a.b.AbstractC0430b d(CrashlyticsReport.e.d.a.b.c cVar) {
            this.f40485b = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0430b
        public CrashlyticsReport.e.d.a.b.AbstractC0430b e(CrashlyticsReport.e.d.a.b.AbstractC0432d abstractC0432d) {
            if (abstractC0432d == null) {
                throw new NullPointerException("Null signal");
            }
            this.f40487d = abstractC0432d;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.AbstractC0430b
        public CrashlyticsReport.e.d.a.b.AbstractC0430b f(kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e> eVar) {
            this.f40484a = eVar;
            return this;
        }
    }

    public m(@Nullable kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e> eVar, @Nullable CrashlyticsReport.e.d.a.b.c cVar, @Nullable CrashlyticsReport.a aVar, CrashlyticsReport.e.d.a.b.AbstractC0432d abstractC0432d, kk.e<CrashlyticsReport.e.d.a.b.AbstractC0428a> eVar2) {
        this.f40479a = eVar;
        this.f40480b = cVar;
        this.f40481c = aVar;
        this.f40482d = abstractC0432d;
        this.f40483e = eVar2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b
    @Nullable
    public CrashlyticsReport.a b() {
        return this.f40481c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b
    @NonNull
    public kk.e<CrashlyticsReport.e.d.a.b.AbstractC0428a> c() {
        return this.f40483e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b
    @Nullable
    public CrashlyticsReport.e.d.a.b.c d() {
        return this.f40480b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b
    @NonNull
    public CrashlyticsReport.e.d.a.b.AbstractC0432d e() {
        return this.f40482d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b bVar = (CrashlyticsReport.e.d.a.b) obj;
        kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e> eVar = this.f40479a;
        if (eVar != null ? eVar.equals(bVar.f()) : bVar.f() == null) {
            CrashlyticsReport.e.d.a.b.c cVar = this.f40480b;
            if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                CrashlyticsReport.a aVar = this.f40481c;
                if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                    if (this.f40482d.equals(bVar.e()) && this.f40483e.equals(bVar.c())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b
    @Nullable
    public kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e> f() {
        return this.f40479a;
    }

    public int hashCode() {
        kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e> eVar = this.f40479a;
        int iHashCode = ((eVar == null ? 0 : eVar.hashCode()) ^ 1000003) * 1000003;
        CrashlyticsReport.e.d.a.b.c cVar = this.f40480b;
        int iHashCode2 = (iHashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        CrashlyticsReport.a aVar = this.f40481c;
        return ((((iHashCode2 ^ (aVar != null ? aVar.hashCode() : 0)) * 1000003) ^ this.f40482d.hashCode()) * 1000003) ^ this.f40483e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f40479a + ", exception=" + this.f40480b + ", appExitInfo=" + this.f40481c + ", signal=" + this.f40482d + ", binaries=" + this.f40483e + "}";
    }
}
