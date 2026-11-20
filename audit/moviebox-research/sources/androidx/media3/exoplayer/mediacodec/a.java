package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import com.google.common.base.q;
import java.nio.ByteBuffer;
import m4.d0;
import m4.j;
import m4.l;
import z3.j0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f10739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f10740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f10741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10743e;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q<HandlerThread> f10744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q<HandlerThread> f10745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10746c;

        public b(final int i11) {
            this(new q() { // from class: m4.d
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return androidx.media3.exoplayer.mediacodec.a.b.f(i11);
                }
            }, new q() { // from class: m4.e
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return androidx.media3.exoplayer.mediacodec.a.b.g(i11);
                }
            });
        }

        public b(q<HandlerThread> qVar, q<HandlerThread> qVar2) {
            this.f10744a = qVar;
            this.f10745b = qVar2;
            this.f10746c = true;
        }

        public static /* synthetic */ HandlerThread f(int i11) {
            return new HandlerThread(a.r(i11));
        }

        public static /* synthetic */ HandlerThread g(int i11) {
            return new HandlerThread(a.s(i11));
        }

        public static boolean h(y yVar) {
            if (u0.f81838a < 34) {
                return false;
            }
            return f0.s(yVar.f9501m);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [androidx.media3.exoplayer.mediacodec.a$a] */
        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.media3.exoplayer.mediacodec.a] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v4 */
        @Override // androidx.media3.exoplayer.mediacodec.c.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(c.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            l gVar;
            String str = aVar.f10750a.f10756a;
            ?? r11 = 0;
            r11 = 0;
            try {
                j0.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    int i11 = aVar.f10755f;
                    if (this.f10746c && h(aVar.f10752c)) {
                        gVar = new d0(mediaCodecCreateByCodecName);
                        i11 |= 4;
                    } else {
                        gVar = new m4.g(mediaCodecCreateByCodecName, this.f10745b.get2());
                    }
                    a aVar2 = new a(mediaCodecCreateByCodecName, this.f10744a.get2(), gVar);
                    try {
                        j0.c();
                        aVar2.u(aVar.f10751b, aVar.f10753d, aVar.f10754e, i11);
                        return aVar2;
                    } catch (Exception e11) {
                        e = e11;
                        r11 = aVar2;
                        if (r11 != 0) {
                            r11.release();
                        } else if (mediaCodecCreateByCodecName != null) {
                            mediaCodecCreateByCodecName.release();
                        }
                        throw e;
                    }
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
                mediaCodecCreateByCodecName = null;
            }
        }

        public void e(boolean z11) {
            this.f10746c = z11;
        }
    }

    public a(MediaCodec mediaCodec, HandlerThread handlerThread, l lVar) {
        this.f10739a = mediaCodec;
        this.f10740b = new j(handlerThread);
        this.f10741c = lVar;
        this.f10743e = 0;
    }

    public static String r(int i11) {
        return t(i11, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    public static String s(int i11) {
        return t(i11, "ExoPlayer:MediaCodecQueueingThread:");
    }

    public static String t(int i11, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i11 == 1) {
            sb2.append("Audio");
        } else if (i11 == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i11);
            sb2.append(")");
        }
        return sb2.toString();
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f10741c.a(i11, i12, i13, j11, i14);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void b(Bundle bundle) {
        this.f10741c.b(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public MediaFormat c() {
        return this.f10740b.g();
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    @Nullable
    public ByteBuffer d(int i11) {
        return this.f10739a.getInputBuffer(i11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void e(Surface surface) {
        this.f10739a.setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13) {
        this.f10741c.f(i11, i12, cVar, j11, i13);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void flush() {
        this.f10741c.flush();
        this.f10739a.flush();
        this.f10740b.e();
        this.f10739a.start();
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public boolean g() {
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void h(int i11, long j11) {
        this.f10739a.releaseOutputBuffer(i11, j11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public int i() {
        this.f10741c.c();
        return this.f10740b.c();
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public int j(MediaCodec.BufferInfo bufferInfo) {
        this.f10741c.c();
        return this.f10740b.d(bufferInfo);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void k(int i11, boolean z11) {
        this.f10739a.releaseOutputBuffer(i11, z11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    @Nullable
    public ByteBuffer l(int i11) {
        return this.f10739a.getOutputBuffer(i11);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void m(final c.InterfaceC0102c interfaceC0102c, Handler handler) {
        this.f10739a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: m4.c
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
                this.f70750a.v(interfaceC0102c, mediaCodec, j11, j12);
            }
        }, handler);
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void release() {
        try {
            if (this.f10743e == 1) {
                this.f10741c.shutdown();
                this.f10740b.p();
            }
            this.f10743e = 2;
        } finally {
            if (!this.f10742d) {
                this.f10739a.release();
                this.f10742d = true;
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.c
    public void setVideoScalingMode(int i11) {
        this.f10739a.setVideoScalingMode(i11);
    }

    public final void u(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i11) {
        this.f10740b.h(this.f10739a);
        j0.a("configureCodec");
        this.f10739a.configure(mediaFormat, surface, mediaCrypto, i11);
        j0.c();
        this.f10741c.start();
        j0.a("startCodec");
        this.f10739a.start();
        j0.c();
        this.f10743e = 1;
    }

    public final /* synthetic */ void v(c.InterfaceC0102c interfaceC0102c, MediaCodec mediaCodec, long j11, long j12) {
        interfaceC0102c.a(this, j11, j12);
    }
}
