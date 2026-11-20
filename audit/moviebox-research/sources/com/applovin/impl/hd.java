package com.applovin.impl;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface hd {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kd f19471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaFormat f19472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f9 f19473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Surface f19474d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final MediaCrypto f19475e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f19476f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f19477g;

        private a(kd kdVar, MediaFormat mediaFormat, f9 f9Var, Surface surface, MediaCrypto mediaCrypto, int i11, boolean z11) {
            this.f19471a = kdVar;
            this.f19472b = mediaFormat;
            this.f19473c = f9Var;
            this.f19474d = surface;
            this.f19475e = mediaCrypto;
            this.f19476f = i11;
            this.f19477g = z11;
        }

        public static a a(kd kdVar, MediaFormat mediaFormat, f9 f9Var, MediaCrypto mediaCrypto) {
            return new a(kdVar, mediaFormat, f9Var, null, mediaCrypto, 0, false);
        }

        public static a a(kd kdVar, MediaFormat mediaFormat, f9 f9Var, Surface surface, MediaCrypto mediaCrypto) {
            return new a(kdVar, mediaFormat, f9Var, surface, mediaCrypto, 0, false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19478a = new ul.c();

        hd a(a aVar);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(hd hdVar, long j11, long j12);
    }

    int a(MediaCodec.BufferInfo bufferInfo);

    ByteBuffer a(int i11);

    void a();

    void a(int i11, int i12, int i13, long j11, int i14);

    void a(int i11, int i12, a5 a5Var, long j11, int i13);

    void a(int i11, long j11);

    void a(int i11, boolean z11);

    void a(Bundle bundle);

    void a(Surface surface);

    void a(c cVar, Handler handler);

    ByteBuffer b(int i11);

    void b();

    void c(int i11);

    boolean c();

    int d();

    MediaFormat e();
}
