package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class v extends CrashlyticsReport.e.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40551a;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40552a;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.f.a
        public CrashlyticsReport.e.f a() {
            String str = "";
            if (this.f40552a == null) {
                str = " identifier";
            }
            if (str.isEmpty()) {
                return new v(this.f40552a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.f.a
        public CrashlyticsReport.e.f.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f40552a = str;
            return this;
        }
    }

    public v(String str) {
        this.f40551a = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.f
    @NonNull
    public String b() {
        return this.f40551a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.e.f) {
            return this.f40551a.equals(((CrashlyticsReport.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f40551a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f40551a + "}";
    }
}
