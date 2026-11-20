package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class o extends CrashlyticsReport.e.d.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> f40499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CrashlyticsReport.e.d.a.b.c f40500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f40501e;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.d.a.b.c.AbstractC0431a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> f40504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CrashlyticsReport.e.d.a.b.c f40505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f40506e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0431a
        public CrashlyticsReport.e.d.a.b.c a() {
            String str = "";
            if (this.f40502a == null) {
                str = " type";
            }
            if (this.f40504c == null) {
                str = str + " frames";
            }
            if (this.f40506e == null) {
                str = str + " overflowCount";
            }
            if (str.isEmpty()) {
                return new o(this.f40502a, this.f40503b, this.f40504c, this.f40505d, this.f40506e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0431a
        public CrashlyticsReport.e.d.a.b.c.AbstractC0431a b(CrashlyticsReport.e.d.a.b.c cVar) {
            this.f40505d = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0431a
        public CrashlyticsReport.e.d.a.b.c.AbstractC0431a c(kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> eVar) {
            if (eVar == null) {
                throw new NullPointerException("Null frames");
            }
            this.f40504c = eVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0431a
        public CrashlyticsReport.e.d.a.b.c.AbstractC0431a d(int i11) {
            this.f40506e = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0431a
        public CrashlyticsReport.e.d.a.b.c.AbstractC0431a e(String str) {
            this.f40503b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c.AbstractC0431a
        public CrashlyticsReport.e.d.a.b.c.AbstractC0431a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f40502a = str;
            return this;
        }
    }

    public o(String str, @Nullable String str2, kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> eVar, @Nullable CrashlyticsReport.e.d.a.b.c cVar, int i11) {
        this.f40497a = str;
        this.f40498b = str2;
        this.f40499c = eVar;
        this.f40500d = cVar;
        this.f40501e = i11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c
    @Nullable
    public CrashlyticsReport.e.d.a.b.c b() {
        return this.f40500d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c
    @NonNull
    public kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> c() {
        return this.f40499c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c
    public int d() {
        return this.f40501e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c
    @Nullable
    public String e() {
        return this.f40498b;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.d.a.b.c)) {
            return false;
        }
        CrashlyticsReport.e.d.a.b.c cVar2 = (CrashlyticsReport.e.d.a.b.c) obj;
        return this.f40497a.equals(cVar2.f()) && ((str = this.f40498b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.f40499c.equals(cVar2.c()) && ((cVar = this.f40500d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.f40501e == cVar2.d();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.a.b.c
    @NonNull
    public String f() {
        return this.f40497a;
    }

    public int hashCode() {
        int iHashCode = (this.f40497a.hashCode() ^ 1000003) * 1000003;
        String str = this.f40498b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f40499c.hashCode()) * 1000003;
        CrashlyticsReport.e.d.a.b.c cVar = this.f40500d;
        return ((iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f40501e;
    }

    public String toString() {
        return "Exception{type=" + this.f40497a + ", reason=" + this.f40498b + ", frames=" + this.f40499c + ", causedBy=" + this.f40500d + ", overflowCount=" + this.f40501e + "}";
    }
}
