package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface r1 {

    /* JADX INFO: compiled from: source.java */
    public static final class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f9 f22013a;

        public a(String str, f9 f9Var) {
            super(str);
            this.f22013a = f9Var;
        }

        public a(Throwable th2, f9 f9Var) {
            super(th2);
            this.f22013a = f9Var;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f22015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f9 f22016c;

        public b(int i11, int i12, int i13, int i14, f9 f9Var, boolean z11, Exception exc) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AudioTrack init failed ");
            sb2.append(i11);
            sb2.append(" ");
            sb2.append("Config(");
            sb2.append(i12);
            sb2.append(", ");
            sb2.append(i13);
            sb2.append(", ");
            sb2.append(i14);
            sb2.append(")");
            sb2.append(z11 ? " (recoverable)" : "");
            super(sb2.toString(), exc);
            this.f22014a = i11;
            this.f22015b = z11;
            this.f22016c = f9Var;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a();

        void a(int i11, long j11, long j12);

        void a(long j11);

        void a(Exception exc);

        void a(boolean z11);

        void b();

        void b(long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f22017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f22018b;

        public d(long j11, long j12) {
            super("Unexpected audio track timestamp discontinuity: expected " + j12 + ", got " + j11);
            this.f22017a = j11;
            this.f22018b = j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f22020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f9 f22021c;

        public e(int i11, f9 f9Var, boolean z11) {
            super("AudioTrack write failed: " + i11);
            this.f22020b = z11;
            this.f22019a = i11;
            this.f22021c = f9Var;
        }
    }

    long a(boolean z11);

    ph a();

    void a(float f11);

    void a(int i11);

    void a(f9 f9Var, int i11, int[] iArr);

    void a(l1 l1Var);

    void a(ph phVar);

    void a(c cVar);

    void a(v1 v1Var);

    boolean a(f9 f9Var);

    boolean a(ByteBuffer byteBuffer, long j11, int i11);

    int b(f9 f9Var);

    void b();

    void b(boolean z11);

    boolean c();

    void d();

    void e();

    void f();

    boolean g();

    void h();

    void i();

    void j();

    void pause();

    void reset();
}
