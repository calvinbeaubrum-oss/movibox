package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class u extends CrashlyticsReport.e.AbstractC0439e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f40546d;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.e.AbstractC0439e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f40547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f40549c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f40550d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0439e.a
        public CrashlyticsReport.e.AbstractC0439e a() {
            String str = "";
            if (this.f40547a == null) {
                str = " platform";
            }
            if (this.f40548b == null) {
                str = str + " version";
            }
            if (this.f40549c == null) {
                str = str + " buildVersion";
            }
            if (this.f40550d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new u(this.f40547a.intValue(), this.f40548b, this.f40549c, this.f40550d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0439e.a
        public CrashlyticsReport.e.AbstractC0439e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f40549c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0439e.a
        public CrashlyticsReport.e.AbstractC0439e.a c(boolean z11) {
            this.f40550d = Boolean.valueOf(z11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0439e.a
        public CrashlyticsReport.e.AbstractC0439e.a d(int i11) {
            this.f40547a = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0439e.a
        public CrashlyticsReport.e.AbstractC0439e.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f40548b = str;
            return this;
        }
    }

    public u(int i11, String str, String str2, boolean z11) {
        this.f40543a = i11;
        this.f40544b = str;
        this.f40545c = str2;
        this.f40546d = z11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0439e
    @NonNull
    public String b() {
        return this.f40545c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0439e
    public int c() {
        return this.f40543a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0439e
    @NonNull
    public String d() {
        return this.f40544b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.e.AbstractC0439e
    public boolean e() {
        return this.f40546d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.e.AbstractC0439e)) {
            return false;
        }
        CrashlyticsReport.e.AbstractC0439e abstractC0439e = (CrashlyticsReport.e.AbstractC0439e) obj;
        return this.f40543a == abstractC0439e.c() && this.f40544b.equals(abstractC0439e.d()) && this.f40545c.equals(abstractC0439e.b()) && this.f40546d == abstractC0439e.e();
    }

    public int hashCode() {
        return ((((((this.f40543a ^ 1000003) * 1000003) ^ this.f40544b.hashCode()) * 1000003) ^ this.f40545c.hashCode()) * 1000003) ^ (this.f40546d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f40543a + ", version=" + this.f40544b + ", buildVersion=" + this.f40545c + ", jailbroken=" + this.f40546d + "}";
    }
}
