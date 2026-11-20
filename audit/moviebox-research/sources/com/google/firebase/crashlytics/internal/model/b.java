package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends CrashlyticsReport {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f40362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f40363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f40364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f40365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CrashlyticsReport.e f40366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CrashlyticsReport.d f40367i;

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0441b extends CrashlyticsReport.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f40370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f40371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f40372e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f40373f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CrashlyticsReport.e f40374g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CrashlyticsReport.d f40375h;

        public C0441b() {
        }

        public C0441b(CrashlyticsReport crashlyticsReport) {
            this.f40368a = crashlyticsReport.i();
            this.f40369b = crashlyticsReport.e();
            this.f40370c = Integer.valueOf(crashlyticsReport.h());
            this.f40371d = crashlyticsReport.f();
            this.f40372e = crashlyticsReport.c();
            this.f40373f = crashlyticsReport.d();
            this.f40374g = crashlyticsReport.j();
            this.f40375h = crashlyticsReport.g();
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport a() {
            String str = "";
            if (this.f40368a == null) {
                str = " sdkVersion";
            }
            if (this.f40369b == null) {
                str = str + " gmpAppId";
            }
            if (this.f40370c == null) {
                str = str + " platform";
            }
            if (this.f40371d == null) {
                str = str + " installationUuid";
            }
            if (this.f40372e == null) {
                str = str + " buildVersion";
            }
            if (this.f40373f == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new b(this.f40368a, this.f40369b, this.f40370c.intValue(), this.f40371d, this.f40372e, this.f40373f, this.f40374g, this.f40375h);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f40372e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b c(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f40373f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b d(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f40369b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f40371d = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b f(CrashlyticsReport.d dVar) {
            this.f40375h = dVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b g(int i11) {
            this.f40370c = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.f40368a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.b
        public CrashlyticsReport.b i(CrashlyticsReport.e eVar) {
            this.f40374g = eVar;
            return this;
        }
    }

    public b(String str, String str2, int i11, String str3, String str4, String str5, @Nullable CrashlyticsReport.e eVar, @Nullable CrashlyticsReport.d dVar) {
        this.f40360b = str;
        this.f40361c = str2;
        this.f40362d = i11;
        this.f40363e = str3;
        this.f40364f = str4;
        this.f40365g = str5;
        this.f40366h = eVar;
        this.f40367i = dVar;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String c() {
        return this.f40364f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String d() {
        return this.f40365g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String e() {
        return this.f40361c;
    }

    public boolean equals(Object obj) {
        CrashlyticsReport.e eVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.f40360b.equals(crashlyticsReport.i()) && this.f40361c.equals(crashlyticsReport.e()) && this.f40362d == crashlyticsReport.h() && this.f40363e.equals(crashlyticsReport.f()) && this.f40364f.equals(crashlyticsReport.c()) && this.f40365g.equals(crashlyticsReport.d()) && ((eVar = this.f40366h) != null ? eVar.equals(crashlyticsReport.j()) : crashlyticsReport.j() == null)) {
            CrashlyticsReport.d dVar = this.f40367i;
            if (dVar == null) {
                if (crashlyticsReport.g() == null) {
                    return true;
                }
            } else if (dVar.equals(crashlyticsReport.g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String f() {
        return this.f40363e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @Nullable
    public CrashlyticsReport.d g() {
        return this.f40367i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public int h() {
        return this.f40362d;
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.f40360b.hashCode() ^ 1000003) * 1000003) ^ this.f40361c.hashCode()) * 1000003) ^ this.f40362d) * 1000003) ^ this.f40363e.hashCode()) * 1000003) ^ this.f40364f.hashCode()) * 1000003) ^ this.f40365g.hashCode()) * 1000003;
        CrashlyticsReport.e eVar = this.f40366h;
        int iHashCode2 = (iHashCode ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        CrashlyticsReport.d dVar = this.f40367i;
        return iHashCode2 ^ (dVar != null ? dVar.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String i() {
        return this.f40360b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @Nullable
    public CrashlyticsReport.e j() {
        return this.f40366h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public CrashlyticsReport.b k() {
        return new C0441b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f40360b + ", gmpAppId=" + this.f40361c + ", platform=" + this.f40362d + ", installationUuid=" + this.f40363e + ", buildVersion=" + this.f40364f + ", displayVersion=" + this.f40365g + ", session=" + this.f40366h + ", ndkPayload=" + this.f40367i + "}";
    }
}
