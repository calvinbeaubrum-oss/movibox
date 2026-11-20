package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.m1;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface c {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f33547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaFormat f33548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final m1 f33549c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final Surface f33550d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final MediaCrypto f33551e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f33552f;

        public a(d dVar, MediaFormat mediaFormat, m1 m1Var, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i11) {
            this.f33547a = dVar;
            this.f33548b = mediaFormat;
            this.f33549c = m1Var;
            this.f33550d = surface;
            this.f33551e = mediaCrypto;
            this.f33552f = i11;
        }

        public static a a(d dVar, MediaFormat mediaFormat, m1 m1Var, @Nullable MediaCrypto mediaCrypto) {
            return new a(dVar, mediaFormat, m1Var, null, mediaCrypto, 0);
        }

        public static a b(d dVar, MediaFormat mediaFormat, m1 m1Var, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto) {
            return new a(dVar, mediaFormat, m1Var, surface, mediaCrypto, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        c a(a aVar) throws IOException;
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.mediacodec.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0362c {
        void a(c cVar, long j11, long j12);
    }

    void a(int i11, int i12, int i13, long j11, int i14);

    @RequiresApi(19)
    void b(Bundle bundle);

    MediaFormat c();

    @Nullable
    ByteBuffer d(int i11);

    @RequiresApi(23)
    void e(Surface surface);

    void f(int i11, int i12, com.google.android.exoplayer2.decoder.c cVar, long j11, int i13);

    void flush();

    boolean g();

    @RequiresApi(21)
    void h(int i11, long j11);

    int i();

    int j(MediaCodec.BufferInfo bufferInfo);

    void k(int i11, boolean z11);

    @Nullable
    ByteBuffer l(int i11);

    @RequiresApi(23)
    void m(InterfaceC0362c interfaceC0362c, Handler handler);

    void release();

    void setVideoScalingMode(int i11);
}
