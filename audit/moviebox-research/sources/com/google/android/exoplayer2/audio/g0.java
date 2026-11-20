package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g0 implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f32860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f32861c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f32862d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioProcessor.a f32863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AudioProcessor.a f32864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AudioProcessor.a f32865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioProcessor.a f32866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f32867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public f0 f32868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ByteBuffer f32869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ShortBuffer f32870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ByteBuffer f32871m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f32872n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f32873o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f32874p;

    public g0() {
        AudioProcessor.a aVar = AudioProcessor.a.f32702e;
        this.f32863e = aVar;
        this.f32864f = aVar;
        this.f32865g = aVar;
        this.f32866h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f32701a;
        this.f32869k = byteBuffer;
        this.f32870l = byteBuffer.asShortBuffer();
        this.f32871m = byteBuffer;
        this.f32860b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f32705c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i11 = this.f32860b;
        if (i11 == -1) {
            i11 = aVar.f32703a;
        }
        this.f32863e = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i11, aVar.f32704b, 2);
        this.f32864f = aVar2;
        this.f32867i = true;
        return aVar2;
    }

    public long b(long j11) {
        if (this.f32873o < 1024) {
            return (long) (((double) this.f32861c) * j11);
        }
        long jL = this.f32872n - ((long) ((f0) com.google.android.exoplayer2.util.a.e(this.f32868j)).l());
        int i11 = this.f32866h.f32703a;
        int i12 = this.f32865g.f32703a;
        return i11 == i12 ? o0.O0(j11, jL, this.f32873o) : o0.O0(j11, jL * ((long) i11), this.f32873o * ((long) i12));
    }

    public void c(float f11) {
        if (this.f32862d != f11) {
            this.f32862d = f11;
            this.f32867i = true;
        }
    }

    public void d(float f11) {
        if (this.f32861c != f11) {
            this.f32861c = f11;
            this.f32867i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f32863e;
            this.f32865g = aVar;
            AudioProcessor.a aVar2 = this.f32864f;
            this.f32866h = aVar2;
            if (this.f32867i) {
                this.f32868j = new f0(aVar.f32703a, aVar.f32704b, this.f32861c, this.f32862d, aVar2.f32703a);
            } else {
                f0 f0Var = this.f32868j;
                if (f0Var != null) {
                    f0Var.i();
                }
            }
        }
        this.f32871m = AudioProcessor.f32701a;
        this.f32872n = 0L;
        this.f32873o = 0L;
        this.f32874p = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int iK;
        f0 f0Var = this.f32868j;
        if (f0Var != null && (iK = f0Var.k()) > 0) {
            if (this.f32869k.capacity() < iK) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iK).order(ByteOrder.nativeOrder());
                this.f32869k = byteBufferOrder;
                this.f32870l = byteBufferOrder.asShortBuffer();
            } else {
                this.f32869k.clear();
                this.f32870l.clear();
            }
            f0Var.j(this.f32870l);
            this.f32873o += (long) iK;
            this.f32869k.limit(iK);
            this.f32871m = this.f32869k;
        }
        ByteBuffer byteBuffer = this.f32871m;
        this.f32871m = AudioProcessor.f32701a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f32864f.f32703a != -1 && (Math.abs(this.f32861c - 1.0f) >= 1.0E-4f || Math.abs(this.f32862d - 1.0f) >= 1.0E-4f || this.f32864f.f32703a != this.f32863e.f32703a);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        f0 f0Var;
        return this.f32874p && ((f0Var = this.f32868j) == null || f0Var.k() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        f0 f0Var = this.f32868j;
        if (f0Var != null) {
            f0Var.s();
        }
        this.f32874p = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            f0 f0Var = (f0) com.google.android.exoplayer2.util.a.e(this.f32868j);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f32872n += (long) iRemaining;
            f0Var.t(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.f32861c = 1.0f;
        this.f32862d = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.f32702e;
        this.f32863e = aVar;
        this.f32864f = aVar;
        this.f32865g = aVar;
        this.f32866h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f32701a;
        this.f32869k = byteBuffer;
        this.f32870l = byteBuffer.asShortBuffer();
        this.f32871m = byteBuffer;
        this.f32860b = -1;
        this.f32867i = false;
        this.f32868j = null;
        this.f32872n = 0L;
        this.f32873o = 0L;
        this.f32874p = false;
    }
}
