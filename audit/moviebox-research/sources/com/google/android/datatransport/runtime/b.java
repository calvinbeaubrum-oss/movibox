package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f32594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f32595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f32596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f32597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f32598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f32599g;

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0355b extends i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f32600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f32601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f32602c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f32603d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f32604e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<String, String> f32605f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f32606g;

        @Override // com.google.android.datatransport.runtime.i.a
        public i d() {
            String str = "";
            if (this.f32600a == null) {
                str = " transportName";
            }
            if (this.f32602c == null) {
                str = str + " encodedPayload";
            }
            if (this.f32603d == null) {
                str = str + " eventMillis";
            }
            if (this.f32604e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f32605f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f32600a, this.f32601b, this.f32602c, this.f32603d.longValue(), this.f32604e.longValue(), this.f32605f, this.f32606g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public Map<String, String> e() {
            Map<String, String> map = this.f32605f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a f(Map<String, String> map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f32605f = map;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a g(Integer num) {
            this.f32601b = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f32602c = hVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a i(long j11) {
            this.f32603d = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a j(Integer num) {
            this.f32606g = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a k(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f32600a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.i.a
        public i.a l(long j11) {
            this.f32604e = Long.valueOf(j11);
            return this;
        }
    }

    public b(String str, @Nullable Integer num, h hVar, long j11, long j12, Map<String, String> map, @Nullable Integer num2) {
        this.f32593a = str;
        this.f32594b = num;
        this.f32595c = hVar;
        this.f32596d = j11;
        this.f32597e = j12;
        this.f32598f = map;
        this.f32599g = num2;
    }

    @Override // com.google.android.datatransport.runtime.i
    public Map<String, String> c() {
        return this.f32598f;
    }

    @Override // com.google.android.datatransport.runtime.i
    @Nullable
    public Integer d() {
        return this.f32594b;
    }

    @Override // com.google.android.datatransport.runtime.i
    public h e() {
        return this.f32595c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f32593a.equals(iVar.k()) && ((num = this.f32594b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f32595c.equals(iVar.e()) && this.f32596d == iVar.f() && this.f32597e == iVar.l() && this.f32598f.equals(iVar.c())) {
            Integer num2 = this.f32599g;
            if (num2 == null) {
                if (iVar.j() == null) {
                    return true;
                }
            } else if (num2.equals(iVar.j())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.i
    public long f() {
        return this.f32596d;
    }

    public int hashCode() {
        int iHashCode = (this.f32593a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f32594b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f32595c.hashCode()) * 1000003;
        long j11 = this.f32596d;
        int i11 = (iHashCode2 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f32597e;
        int iHashCode3 = (((i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ this.f32598f.hashCode()) * 1000003;
        Integer num2 = this.f32599g;
        return iHashCode3 ^ (num2 != null ? num2.hashCode() : 0);
    }

    @Override // com.google.android.datatransport.runtime.i
    @Nullable
    public Integer j() {
        return this.f32599g;
    }

    @Override // com.google.android.datatransport.runtime.i
    public String k() {
        return this.f32593a;
    }

    @Override // com.google.android.datatransport.runtime.i
    public long l() {
        return this.f32597e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f32593a + ", code=" + this.f32594b + ", encodedPayload=" + this.f32595c + ", eventMillis=" + this.f32596d + ", uptimeMillis=" + this.f32597e + ", autoMetadata=" + this.f32598f + ", productId=" + this.f32599g + "}";
    }
}
