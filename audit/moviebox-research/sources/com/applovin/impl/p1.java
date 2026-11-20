package com.applovin.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f21632a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f21633e = new a(-1, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f21637d;

        public a(int i11, int i12, int i13) {
            this.f21634a = i11;
            this.f21635b = i12;
            this.f21636c = i13;
            this.f21637d = xp.g(i13) ? xp.b(i13, i12) : -1;
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f21634a + ", channelCount=" + this.f21635b + ", encoding=" + this.f21636c + ']';
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends Exception {
        public b(a aVar) {
            super("Unhandled format: " + aVar);
        }
    }

    a a(a aVar);

    void a(ByteBuffer byteBuffer);

    void b();

    boolean c();

    ByteBuffer d();

    void e();

    boolean f();

    void reset();
}
