package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.y;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f10750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaFormat f10751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y f10752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final Surface f10753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final MediaCrypto f10754e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f10755f;

        public a(d dVar, MediaFormat mediaFormat, y yVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i11) {
            this.f10750a = dVar;
            this.f10751b = mediaFormat;
            this.f10752c = yVar;
            this.f10753d = surface;
            this.f10754e = mediaCrypto;
            this.f10755f = i11;
        }

        public static a a(d dVar, MediaFormat mediaFormat, y yVar, @Nullable MediaCrypto mediaCrypto) {
            return new a(dVar, mediaFormat, yVar, null, mediaCrypto, 0);
        }

        public static a b(d dVar, MediaFormat mediaFormat, y yVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto) {
            return new a(dVar, mediaFormat, yVar, surface, mediaCrypto, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        c a(a aVar) throws IOException;
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.mediacodec.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0102c {
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

    void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13);

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
    void m(InterfaceC0102c interfaceC0102c, Handler handler);

    void release();

    void setVideoScalingMode(int i11);
}
