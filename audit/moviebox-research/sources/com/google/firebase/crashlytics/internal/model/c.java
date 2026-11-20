package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends CrashlyticsReport.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f40378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f40379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f40380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f40381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f40382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f40383h;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.a.AbstractC0425a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f40384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f40386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f40387d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f40388e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f40389f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Long f40390g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f40391h;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0425a
        public CrashlyticsReport.a a() {
            String str = "";
            if (this.f40384a == null) {
                str = " pid";
            }
            if (this.f40385b == null) {
                str = str + " processName";
            }
            if (this.f40386c == null) {
                str = str + " reasonCode";
            }
            if (this.f40387d == null) {
                str = str + " importance";
            }
            if (this.f40388e == null) {
                str = str + " pss";
            }
            if (this.f40389f == null) {
                str = str + " rss";
            }
            if (this.f40390g == null) {
                str = str + " timestamp";
            }
            if (str.isEmpty()) {
                return new c(this.f40384a.intValue(), this.f40385b, this.f40386c.intValue(), this.f40387d.intValue(), this.f40388e.longValue(), this.f40389f.longValue(), this.f40390g.longValue(), this.f40391h);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0425a
        public CrashlyticsReport.a.AbstractC0425a b(int i11) {
            this.f40387d = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0425a
        public CrashlyticsReport.a.AbstractC0425a c(int i11) {
            this.f40384a = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0425a
        public CrashlyticsReport.a.AbstractC0425a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f40385b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0425a
        public CrashlyticsReport.a.AbstractC0425a e(long j11) {
            this.f40388e = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0425a
        public CrashlyticsReport.a.AbstractC0425a f(int i11) {
            this.f40386c = Integer.valueOf(i11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0425a
        public CrashlyticsReport.a.AbstractC0425a g(long j11) {
            this.f40389f = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0425a
        public CrashlyticsReport.a.AbstractC0425a h(long j11) {
            this.f40390g = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a.AbstractC0425a
        public CrashlyticsReport.a.AbstractC0425a i(@Nullable String str) {
            this.f40391h = str;
            return this;
        }
    }

    public c(int i11, String str, int i12, int i13, long j11, long j12, long j13, @Nullable String str2) {
        this.f40376a = i11;
        this.f40377b = str;
        this.f40378c = i12;
        this.f40379d = i13;
        this.f40380e = j11;
        this.f40381f = j12;
        this.f40382g = j13;
        this.f40383h = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    @NonNull
    public int b() {
        return this.f40379d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    @NonNull
    public int c() {
        return this.f40376a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    @NonNull
    public String d() {
        return this.f40377b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    @NonNull
    public long e() {
        return this.f40380e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.a)) {
            return false;
        }
        CrashlyticsReport.a aVar = (CrashlyticsReport.a) obj;
        if (this.f40376a == aVar.c() && this.f40377b.equals(aVar.d()) && this.f40378c == aVar.f() && this.f40379d == aVar.b() && this.f40380e == aVar.e() && this.f40381f == aVar.g() && this.f40382g == aVar.h()) {
            String str = this.f40383h;
            if (str == null) {
                if (aVar.i() == null) {
                    return true;
                }
            } else if (str.equals(aVar.i())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    @NonNull
    public int f() {
        return this.f40378c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    @NonNull
    public long g() {
        return this.f40381f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    @NonNull
    public long h() {
        return this.f40382g;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f40376a ^ 1000003) * 1000003) ^ this.f40377b.hashCode()) * 1000003) ^ this.f40378c) * 1000003) ^ this.f40379d) * 1000003;
        long j11 = this.f40380e;
        int i11 = (iHashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f40381f;
        int i12 = (i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        long j13 = this.f40382g;
        int i13 = (i12 ^ ((int) (j13 ^ (j13 >>> 32)))) * 1000003;
        String str = this.f40383h;
        return i13 ^ (str == null ? 0 : str.hashCode());
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.a
    @Nullable
    public String i() {
        return this.f40383h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f40376a + ", processName=" + this.f40377b + ", reasonCode=" + this.f40378c + ", importance=" + this.f40379d + ", pss=" + this.f40380e + ", rss=" + this.f40381f + ", timestamp=" + this.f40382g + ", traceFile=" + this.f40383h + "}";
    }
}
