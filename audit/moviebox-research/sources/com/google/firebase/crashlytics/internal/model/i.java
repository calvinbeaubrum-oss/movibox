package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i extends CrashlyticsReport.e.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40440a;

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.a.b
    @NonNull
    public String a() {
        return this.f40440a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.e.a.b) {
            return this.f40440a.equals(((CrashlyticsReport.e.a.b) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f40440a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Organization{clsId=" + this.f40440a + "}";
    }
}
