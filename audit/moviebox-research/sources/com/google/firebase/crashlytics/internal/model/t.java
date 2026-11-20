package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class t extends CrashlyticsReport.e.d.AbstractC0438d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40541a;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.d.AbstractC0438d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40542a;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0438d.a
        public CrashlyticsReport.e.d.AbstractC0438d a() {
            String str = "";
            if (this.f40542a == null) {
                str = " content";
            }
            if (str.isEmpty()) {
                return new t(this.f40542a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0438d.a
        public CrashlyticsReport.e.d.AbstractC0438d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.f40542a = str;
            return this;
        }
    }

    public t(String str) {
        this.f40541a = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.d.AbstractC0438d
    @NonNull
    public String b() {
        return this.f40541a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.e.d.AbstractC0438d) {
            return this.f40541a.equals(((CrashlyticsReport.e.d.AbstractC0438d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f40541a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f40541a + "}";
    }
}
