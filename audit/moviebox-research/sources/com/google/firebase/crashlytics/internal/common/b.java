package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CrashlyticsReport f40185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f40187c;

    public b(CrashlyticsReport crashlyticsReport, String str, File file) {
        if (crashlyticsReport == null) {
            throw new NullPointerException("Null report");
        }
        this.f40185a = crashlyticsReport;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f40186b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.f40187c = file;
    }

    @Override // com.google.firebase.crashlytics.internal.common.j
    public CrashlyticsReport b() {
        return this.f40185a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.j
    public File c() {
        return this.f40187c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.j
    public String d() {
        return this.f40186b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f40185a.equals(jVar.b()) && this.f40186b.equals(jVar.d()) && this.f40187c.equals(jVar.c());
    }

    public int hashCode() {
        return ((((this.f40185a.hashCode() ^ 1000003) * 1000003) ^ this.f40186b.hashCode()) * 1000003) ^ this.f40187c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f40185a + ", sessionId=" + this.f40186b + ", reportFile=" + this.f40187c + "}";
    }
}
