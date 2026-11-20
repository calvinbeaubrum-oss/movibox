package d4;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.y;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.decoder.av1.Gav1Decoder;
import androidx.media3.decoder.av1.Gav1DecoderException;
import androidx.media3.exoplayer.o;
import androidx.media3.exoplayer.video.f0;
import androidx.media3.exoplayer.video.h;
import androidx.media3.exoplayer.x2;
import z3.j0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends h {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f62929d0 = ((u0.k(1280, 64) * u0.k(720, 64)) * 6144) / 2;
    public final int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f62930a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final int f62931b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Nullable
    public Gav1Decoder f62932c0;

    public c(long j11, @Nullable Handler handler, @Nullable f0 f0Var, int i11) {
        this(j11, handler, f0Var, i11, 0, 4, 4);
    }

    public c(long j11, @Nullable Handler handler, @Nullable f0 f0Var, int i11, int i12, int i13, int i14) {
        super(j11, handler, f0Var, i11);
        this.f62931b0 = i12;
        this.Z = i13;
        this.f62930a0 = i14;
    }

    @Override // androidx.media3.exoplayer.video.h
    public o N(String str, y yVar, y yVar2) {
        return new o(str, yVar, yVar2, 3, 0);
    }

    @Override // androidx.media3.exoplayer.y2
    public final int a(y yVar) {
        if ("video/av01".equalsIgnoreCase(yVar.f9501m) && b.a()) {
            return yVar.I != 0 ? x2.a(2) : x2.b(4, 16, 0);
        }
        return x2.a(0);
    }

    @Override // androidx.media3.exoplayer.w2, androidx.media3.exoplayer.y2
    public String getName() {
        return "Libgav1VideoRenderer";
    }

    @Override // androidx.media3.exoplayer.video.h
    public void n0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws Gav1DecoderException {
        Gav1Decoder gav1Decoder = this.f62932c0;
        if (gav1Decoder == null) {
            throw new Gav1DecoderException("Failed to render output buffer to surface: decoder is not initialized.");
        }
        gav1Decoder.x(videoDecoderOutputBuffer, surface);
        videoDecoderOutputBuffer.release();
    }

    @Override // androidx.media3.exoplayer.video.h
    public void p0(int i11) {
        Gav1Decoder gav1Decoder = this.f62932c0;
        if (gav1Decoder != null) {
            gav1Decoder.y(i11);
        }
    }

    @Override // androidx.media3.exoplayer.video.h
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public final Gav1Decoder O(y yVar, @Nullable androidx.media3.decoder.b bVar) throws Gav1DecoderException {
        j0.a("createGav1Decoder");
        int i11 = yVar.f9502n;
        if (i11 == -1) {
            i11 = f62929d0;
        }
        Gav1Decoder gav1Decoder = new Gav1Decoder(this.Z, this.f62930a0, i11, this.f62931b0);
        this.f62932c0 = gav1Decoder;
        j0.c();
        return gav1Decoder;
    }
}
