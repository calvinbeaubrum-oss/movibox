package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f extends CrashlyticsReport.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f40401b;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends CrashlyticsReport.d.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f40403b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b.a
        public CrashlyticsReport.d.b a() {
            String str = "";
            if (this.f40402a == null) {
                str = " filename";
            }
            if (this.f40403b == null) {
                str = str + " contents";
            }
            if (str.isEmpty()) {
                return new f(this.f40402a, this.f40403b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b.a
        public CrashlyticsReport.d.b.a b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f40403b = bArr;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b.a
        public CrashlyticsReport.d.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.f40402a = str;
            return this;
        }
    }

    public f(String str, byte[] bArr) {
        this.f40400a = str;
        this.f40401b = bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b
    @NonNull
    public byte[] b() {
        return this.f40401b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b
    @NonNull
    public String c() {
        return this.f40400a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.b)) {
            return false;
        }
        CrashlyticsReport.d.b bVar = (CrashlyticsReport.d.b) obj;
        if (this.f40400a.equals(bVar.c())) {
            if (Arrays.equals(this.f40401b, bVar instanceof f ? ((f) bVar).f40401b : bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f40400a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f40401b);
    }

    public String toString() {
        return "File{filename=" + this.f40400a + ", contents=" + Arrays.toString(this.f40401b) + "}";
    }
}
