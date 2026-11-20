package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e extends CrashlyticsReport.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kk.e<CrashlyticsReport.d.b> f40396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40397b;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public kk.e<CrashlyticsReport.d.b> f40398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40399b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.a
        public CrashlyticsReport.d a() {
            String str = "";
            if (this.f40398a == null) {
                str = " files";
            }
            if (str.isEmpty()) {
                return new e(this.f40398a, this.f40399b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.a
        public CrashlyticsReport.d.a b(kk.e<CrashlyticsReport.d.b> eVar) {
            if (eVar == null) {
                throw new NullPointerException("Null files");
            }
            this.f40398a = eVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.a
        public CrashlyticsReport.d.a c(String str) {
            this.f40399b = str;
            return this;
        }
    }

    public e(kk.e<CrashlyticsReport.d.b> eVar, @Nullable String str) {
        this.f40396a = eVar;
        this.f40397b = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d
    @NonNull
    public kk.e<CrashlyticsReport.d.b> b() {
        return this.f40396a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d
    @Nullable
    public String c() {
        return this.f40397b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d)) {
            return false;
        }
        CrashlyticsReport.d dVar = (CrashlyticsReport.d) obj;
        if (this.f40396a.equals(dVar.b())) {
            String str = this.f40397b;
            if (str == null) {
                if (dVar.c() == null) {
                    return true;
                }
            } else if (str.equals(dVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f40396a.hashCode() ^ 1000003) * 1000003;
        String str = this.f40397b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f40396a + ", orgId=" + this.f40397b + "}";
    }
}
