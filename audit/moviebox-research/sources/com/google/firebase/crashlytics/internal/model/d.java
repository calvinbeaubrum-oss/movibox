package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends CrashlyticsReport.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40393b;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40395b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.c.a
        public CrashlyticsReport.c a() {
            String str = "";
            if (this.f40394a == null) {
                str = " key";
            }
            if (this.f40395b == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new d(this.f40394a, this.f40395b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.c.a
        public CrashlyticsReport.c.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f40394a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.c.a
        public CrashlyticsReport.c.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.f40395b = str;
            return this;
        }
    }

    public d(String str, String str2) {
        this.f40392a = str;
        this.f40393b = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.c
    @NonNull
    public String b() {
        return this.f40392a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.c
    @NonNull
    public String c() {
        return this.f40393b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.c)) {
            return false;
        }
        CrashlyticsReport.c cVar = (CrashlyticsReport.c) obj;
        return this.f40392a.equals(cVar.b()) && this.f40393b.equals(cVar.c());
    }

    public int hashCode() {
        return ((this.f40392a.hashCode() ^ 1000003) * 1000003) ^ this.f40393b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f40392a + ", value=" + this.f40393b + "}";
    }
}
