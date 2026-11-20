package com.mbridge.msdk.foundation.tools;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class f {

    /* JADX INFO: compiled from: source.java */
    public static class a extends j {
        public a(int i11, int i12, Object obj, int i13, boolean z11) {
            super(i11, i12, obj, i13, z11);
        }

        @Override // com.mbridge.msdk.foundation.tools.f.b
        public final byte a() {
            return (byte) 7;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f45057a;

        public abstract byte a();
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f45058b;

        public c(int i11, boolean z11) {
            this.f45057a = i11;
            this.f45058b = z11;
        }

        @Override // com.mbridge.msdk.foundation.tools.f.b
        public final byte a() {
            return (byte) 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f45059b;

        public d(int i11, double d11) {
            this.f45057a = i11;
            this.f45059b = d11;
        }

        @Override // com.mbridge.msdk.foundation.tools.f.b
        public final byte a() {
            return (byte) 5;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f45060b;

        public e(int i11, float f11) {
            this.f45057a = i11;
            this.f45060b = f11;
        }

        @Override // com.mbridge.msdk.foundation.tools.f.b
        public final byte a() {
            return (byte) 3;
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.tools.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0495f extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f45061b;

        public C0495f(int i11, int i12) {
            this.f45057a = i11;
            this.f45061b = i12;
        }

        @Override // com.mbridge.msdk.foundation.tools.f.b
        public final byte a() {
            return (byte) 2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f45062b;

        public g(int i11, long j11) {
            this.f45057a = i11;
            this.f45062b = j11;
        }

        @Override // com.mbridge.msdk.foundation.tools.f.b
        public final byte a() {
            return (byte) 4;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h extends j {
        public h(int i11, int i12, Object obj, int i13, boolean z11) {
            super(i11, i12, obj, i13, z11);
        }

        @Override // com.mbridge.msdk.foundation.tools.f.b
        public final byte a() {
            return (byte) 8;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends j {
        public i(int i11, int i12, String str, int i13, boolean z11) {
            super(i11, i12, str, i13, z11);
        }

        @Override // com.mbridge.msdk.foundation.tools.f.b
        public final byte a() {
            return (byte) 6;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class j extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f45063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f45064c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f45065d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f45066e;

        public j(int i11, int i12, Object obj, int i13, boolean z11) {
            this.f45064c = i11;
            this.f45057a = i12;
            this.f45065d = obj;
            this.f45066e = i13;
            this.f45063b = z11;
        }
    }
}
