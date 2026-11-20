package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.decoder.h;
import androidx.media3.decoder.i;
import java.nio.ByteBuffer;
import java.util.List;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@SuppressLint({"UnsafeOptInUsageError"})
final class FfmpegAudioDecoder extends SimpleDecoder<DecoderInputBuffer, i, FfmpegDecoderException> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f67268o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final byte[] f67269p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f67270q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f67271r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f67272s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f67273t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile int f67274u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile int f67275v;

    public FfmpegAudioDecoder(y yVar, int i11, int i12, int i13, boolean z11) throws FfmpegDecoderException {
        super(new DecoderInputBuffer[i11], new i[i12]);
        if (!FfmpegLibrary.d()) {
            throw new FfmpegDecoderException("Failed to load decoder native libraries.");
        }
        z3.a.e(yVar.f9501m);
        String str = (String) z3.a.e(FfmpegLibrary.a(yVar.f9501m));
        this.f67268o = str;
        byte[] bArrA = A(yVar.f9501m, yVar.f9503o);
        this.f67269p = bArrA;
        this.f67270q = z11 ? 4 : 2;
        this.f67271r = z11 ? 131072 : 65536;
        long jFfmpegInitialize = ffmpegInitialize(str, bArrA, z11, yVar.A, yVar.f9514z);
        this.f67272s = jFfmpegInitialize;
        if (jFfmpegInitialize == 0) {
            throw new FfmpegDecoderException("Initialization failed.");
        }
        s(i13);
    }

    @Nullable
    public static byte[] A(String str, List<byte[]> list) {
        if (list.isEmpty()) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "audio/vorbis":
                return C(list);
            case "audio/mp4a-latm":
            case "audio/opus":
                return list.get(0);
            case "audio/alac":
                return x(list);
            default:
                return null;
        }
    }

    public static byte[] C(List<byte[]> list) {
        byte[] bArr = list.get(0);
        byte[] bArr2 = list.get(1);
        byte[] bArr3 = new byte[bArr.length + bArr2.length + 6];
        bArr3[0] = (byte) (bArr.length >> 8);
        bArr3[1] = (byte) (bArr.length & 255);
        System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        bArr3[bArr.length + 2] = 0;
        bArr3[bArr.length + 3] = 0;
        bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
        bArr3[bArr.length + 5] = (byte) (bArr2.length & 255);
        System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
        return bArr3;
    }

    private native int ffmpegDecode(long j11, ByteBuffer byteBuffer, int i11, ByteBuffer byteBuffer2, int i12);

    private native int ffmpegGetChannelCount(long j11);

    private native int ffmpegGetSampleRate(long j11);

    private native long ffmpegInitialize(String str, @Nullable byte[] bArr, boolean z11, int i11, int i12);

    private native void ffmpegRelease(long j11);

    private native long ffmpegReset(long j11, @Nullable byte[] bArr);

    public static byte[] x(List<byte[]> list) {
        byte[] bArr = list.get(0);
        int length = bArr.length + 12;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1634492771);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put(bArr, 0, bArr.length);
        return byteBufferAllocate.array();
    }

    public int B() {
        return this.f67275v;
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public DecoderInputBuffer e() {
        return new DecoderInputBuffer(2, FfmpegLibrary.b());
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.f67268o;
    }

    @Override // androidx.media3.decoder.SimpleDecoder, androidx.media3.decoder.g
    public void release() {
        super.release();
        ffmpegRelease(this.f67272s);
        this.f67272s = 0L;
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public i f() {
        return new i(new h.a() { // from class: io.github.anilbeesetti.nextlib.media3ext.ffdecoder.a
            @Override // androidx.media3.decoder.h.a
            public final void a(h hVar) {
                this.f67284a.p((i) hVar);
            }
        });
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public FfmpegDecoderException g(Throwable th2) {
        return new FfmpegDecoderException("Unexpected decode error", th2);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    @Nullable
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public FfmpegDecoderException h(DecoderInputBuffer decoderInputBuffer, i iVar, boolean z11) {
        if (z11) {
            long jFfmpegReset = ffmpegReset(this.f67272s, this.f67269p);
            this.f67272s = jFfmpegReset;
            if (jFfmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) u0.i(decoderInputBuffer.f9780c);
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferA = iVar.a(decoderInputBuffer.f9782f, this.f67271r);
        int iFfmpegDecode = ffmpegDecode(this.f67272s, byteBuffer, iLimit, byteBufferA, this.f67271r);
        if (iFfmpegDecode == -2) {
            return new FfmpegDecoderException("Error decoding (see logcat).");
        }
        if (iFfmpegDecode == -1) {
            iVar.setFlags(Integer.MIN_VALUE);
            return null;
        }
        if (iFfmpegDecode == 0) {
            iVar.setFlags(Integer.MIN_VALUE);
            return null;
        }
        if (!this.f67273t) {
            this.f67274u = ffmpegGetChannelCount(this.f67272s);
            this.f67275v = ffmpegGetSampleRate(this.f67272s);
            if (this.f67275v == 0 && "alac".equals(this.f67268o)) {
                z3.a.e(this.f67269p);
                c0 c0Var = new c0(this.f67269p);
                c0Var.U(this.f67269p.length - 4);
                this.f67275v = c0Var.L();
            }
            this.f67273t = true;
        }
        byteBufferA.position(0);
        byteBufferA.limit(iFfmpegDecode);
        return null;
    }

    public int y() {
        return this.f67274u;
    }

    public int z() {
        return this.f67270q;
    }
}
