package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.android.datatransport.Priority;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f32620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Priority f32621c;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f32622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f32623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Priority f32624c;

        @Override // com.google.android.datatransport.runtime.o.a
        public o a() {
            String str = "";
            if (this.f32622a == null) {
                str = " backendName";
            }
            if (this.f32624c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f32622a, this.f32623b, this.f32624c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.o.a
        public o.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f32622a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.o.a
        public o.a c(@Nullable byte[] bArr) {
            this.f32623b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.o.a
        public o.a d(Priority priority) {
            if (priority == null) {
                throw new NullPointerException("Null priority");
            }
            this.f32624c = priority;
            return this;
        }
    }

    public d(String str, @Nullable byte[] bArr, Priority priority) {
        this.f32619a = str;
        this.f32620b = bArr;
        this.f32621c = priority;
    }

    @Override // com.google.android.datatransport.runtime.o
    public String b() {
        return this.f32619a;
    }

    @Override // com.google.android.datatransport.runtime.o
    @Nullable
    public byte[] c() {
        return this.f32620b;
    }

    @Override // com.google.android.datatransport.runtime.o
    public Priority d() {
        return this.f32621c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f32619a.equals(oVar.b())) {
            if (Arrays.equals(this.f32620b, oVar instanceof d ? ((d) oVar).f32620b : oVar.c()) && this.f32621c.equals(oVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f32619a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f32620b)) * 1000003) ^ this.f32621c.hashCode();
    }
}
