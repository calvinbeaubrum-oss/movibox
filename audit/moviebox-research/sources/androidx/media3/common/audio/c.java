package androidx.media3.common.audio;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f8928c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f8929d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioProcessor.a f8930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AudioProcessor.a f8931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AudioProcessor.a f8932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioProcessor.a f8933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public x3.b f8935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ByteBuffer f8936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ShortBuffer f8937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ByteBuffer f8938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f8939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f8940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f8941p;

    public c() {
        AudioProcessor.a aVar = AudioProcessor.a.f8909e;
        this.f8930e = aVar;
        this.f8931f = aVar;
        this.f8932g = aVar;
        this.f8933h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f8908a;
        this.f8936k = byteBuffer;
        this.f8937l = byteBuffer.asShortBuffer();
        this.f8938m = byteBuffer;
        this.f8927b = -1;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f8912c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i11 = this.f8927b;
        if (i11 == -1) {
            i11 = aVar.f8910a;
        }
        this.f8930e = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i11, aVar.f8911b, 2);
        this.f8931f = aVar2;
        this.f8934i = true;
        return aVar2;
    }

    public final long b(long j11) {
        if (this.f8940o < 1024) {
            return (long) (((double) this.f8928c) * j11);
        }
        long jL = this.f8939n - ((long) ((x3.b) z3.a.e(this.f8935j)).l());
        int i11 = this.f8933h.f8910a;
        int i12 = this.f8932g.f8910a;
        return i11 == i12 ? u0.f1(j11, jL, this.f8940o) : u0.f1(j11, jL * ((long) i11), this.f8940o * ((long) i12));
    }

    public final void c(float f11) {
        if (this.f8929d != f11) {
            this.f8929d = f11;
            this.f8934i = true;
        }
    }

    public final void d(float f11) {
        if (this.f8928c != f11) {
            this.f8928c = f11;
            this.f8934i = true;
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f8930e;
            this.f8932g = aVar;
            AudioProcessor.a aVar2 = this.f8931f;
            this.f8933h = aVar2;
            if (this.f8934i) {
                this.f8935j = new x3.b(aVar.f8910a, aVar.f8911b, this.f8928c, this.f8929d, aVar2.f8910a);
            } else {
                x3.b bVar = this.f8935j;
                if (bVar != null) {
                    bVar.i();
                }
            }
        }
        this.f8938m = AudioProcessor.f8908a;
        this.f8939n = 0L;
        this.f8940o = 0L;
        this.f8941p = false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final ByteBuffer getOutput() {
        int iK;
        x3.b bVar = this.f8935j;
        if (bVar != null && (iK = bVar.k()) > 0) {
            if (this.f8936k.capacity() < iK) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iK).order(ByteOrder.nativeOrder());
                this.f8936k = byteBufferOrder;
                this.f8937l = byteBufferOrder.asShortBuffer();
            } else {
                this.f8936k.clear();
                this.f8937l.clear();
            }
            bVar.j(this.f8937l);
            this.f8940o += (long) iK;
            this.f8936k.limit(iK);
            this.f8938m = this.f8936k;
        }
        ByteBuffer byteBuffer = this.f8938m;
        this.f8938m = AudioProcessor.f8908a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final boolean isActive() {
        return this.f8931f.f8910a != -1 && (Math.abs(this.f8928c - 1.0f) >= 1.0E-4f || Math.abs(this.f8929d - 1.0f) >= 1.0E-4f || this.f8931f.f8910a != this.f8930e.f8910a);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final boolean isEnded() {
        x3.b bVar;
        return this.f8941p && ((bVar = this.f8935j) == null || bVar.k() == 0);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueEndOfStream() {
        x3.b bVar = this.f8935j;
        if (bVar != null) {
            bVar.s();
        }
        this.f8941p = true;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            x3.b bVar = (x3.b) z3.a.e(this.f8935j);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f8939n += (long) iRemaining;
            bVar.t(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void reset() {
        this.f8928c = 1.0f;
        this.f8929d = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.f8909e;
        this.f8930e = aVar;
        this.f8931f = aVar;
        this.f8932g = aVar;
        this.f8933h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f8908a;
        this.f8936k = byteBuffer;
        this.f8937l = byteBuffer.asShortBuffer();
        this.f8938m = byteBuffer;
        this.f8927b = -1;
        this.f8934i = false;
        this.f8935j = null;
        this.f8939n = 0L;
        this.f8940o = 0L;
        this.f8941p = false;
    }
}
