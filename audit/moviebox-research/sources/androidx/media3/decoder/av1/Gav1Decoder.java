package androidx.media3.decoder.av1;

import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.decoder.h;
import d4.b;
import java.nio.ByteBuffer;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class Gav1Decoder extends SimpleDecoder<DecoderInputBuffer, VideoDecoderOutputBuffer, Gav1DecoderException> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f9800o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile int f9801p;

    public Gav1Decoder(int i11, int i12, int i13, int i14) throws Gav1DecoderException {
        super(new DecoderInputBuffer[i11], new VideoDecoderOutputBuffer[i12]);
        if (!b.a()) {
            throw new Gav1DecoderException("Failed to load decoder native library.");
        }
        if (i14 == 0 && (i14 = gav1GetThreads()) <= 0) {
            i14 = Runtime.getRuntime().availableProcessors();
        }
        long jGav1Init = gav1Init(i14);
        this.f9800o = jGav1Init;
        if (jGav1Init != 0 && gav1CheckError(jGav1Init) != 0) {
            s(i13);
            return;
        }
        throw new Gav1DecoderException("Failed to initialize decoder. Error: " + gav1GetErrorMessage(jGav1Init));
    }

    private native int gav1CheckError(long j11);

    private native void gav1Close(long j11);

    private native int gav1Decode(long j11, ByteBuffer byteBuffer, int i11);

    private native String gav1GetErrorMessage(long j11);

    private native int gav1GetFrame(long j11, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z11);

    private native int gav1GetThreads();

    private native long gav1Init(int i11);

    private native void gav1ReleaseFrame(long j11, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    private native int gav1RenderFrame(long j11, Surface surface, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    @Override // androidx.media3.decoder.SimpleDecoder
    public DecoderInputBuffer e() {
        return new DecoderInputBuffer(2);
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "libgav1";
    }

    @Override // androidx.media3.decoder.SimpleDecoder, androidx.media3.decoder.g
    public void release() {
        super.release();
        gav1Close(this.f9800o);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public VideoDecoderOutputBuffer f() {
        return new VideoDecoderOutputBuffer(new h.a() { // from class: d4.a
            @Override // androidx.media3.decoder.h.a
            public final void a(h hVar) {
                this.f62927a.w((VideoDecoderOutputBuffer) hVar);
            }
        });
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Gav1DecoderException g(Throwable th2) {
        return new Gav1DecoderException("Unexpected decode error", th2);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    @Nullable
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Gav1DecoderException h(DecoderInputBuffer decoderInputBuffer, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z11) {
        ByteBuffer byteBuffer = (ByteBuffer) u0.i(decoderInputBuffer.f9780c);
        if (gav1Decode(this.f9800o, byteBuffer, byteBuffer.limit()) == 0) {
            return new Gav1DecoderException("gav1Decode error: " + gav1GetErrorMessage(this.f9800o));
        }
        boolean z12 = !l(decoderInputBuffer.f9782f);
        if (!z12) {
            videoDecoderOutputBuffer.init(decoderInputBuffer.f9782f, this.f9801p, null);
        }
        int iGav1GetFrame = gav1GetFrame(this.f9800o, videoDecoderOutputBuffer, z12);
        if (iGav1GetFrame == 0) {
            return new Gav1DecoderException("gav1GetFrame error: " + gav1GetErrorMessage(this.f9800o));
        }
        if (iGav1GetFrame == 2) {
            videoDecoderOutputBuffer.shouldBeSkipped = true;
        }
        if (!z12) {
            videoDecoderOutputBuffer.format = decoderInputBuffer.f9778a;
        }
        return null;
    }

    public void w(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        if (videoDecoderOutputBuffer.mode == 1 && !videoDecoderOutputBuffer.shouldBeSkipped) {
            gav1ReleaseFrame(this.f9800o, videoDecoderOutputBuffer);
        }
        super.p(videoDecoderOutputBuffer);
    }

    public void x(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws Gav1DecoderException {
        if (videoDecoderOutputBuffer.mode != 1) {
            throw new Gav1DecoderException("Invalid output mode.");
        }
        if (gav1RenderFrame(this.f9800o, surface, videoDecoderOutputBuffer) != 0) {
            return;
        }
        throw new Gav1DecoderException("Buffer render error: " + gav1GetErrorMessage(this.f9800o));
    }

    public void y(int i11) {
        this.f9801p = i11;
    }
}
