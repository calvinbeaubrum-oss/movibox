package com.transsion.player.exo;

import androidx.annotation.Nullable;
import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f54301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f54302c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f54303d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f54304e = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AudioProcessor.a f54305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AudioProcessor.a f54306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioProcessor.a f54307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AudioProcessor.a f54308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f54309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public d f54310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ByteBuffer f54311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ShortBuffer f54312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ByteBuffer f54313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f54314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f54315p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f54316q;

    public e() {
        AudioProcessor.a aVar = AudioProcessor.a.f8909e;
        this.f54305f = aVar;
        this.f54306g = aVar;
        this.f54307h = aVar;
        this.f54308i = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f8908a;
        this.f54311l = byteBuffer;
        this.f54312m = byteBuffer.asShortBuffer();
        this.f54313n = byteBuffer;
        this.f54301b = -1;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f8912c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i11 = this.f54301b;
        if (i11 == -1) {
            i11 = aVar.f8910a;
        }
        this.f54305f = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i11, aVar.f8911b, 2);
        this.f54306g = aVar2;
        this.f54309j = true;
        return aVar2;
    }

    public float b(float f11) {
        if (this.f54304e != f11) {
            this.f54304e = f11;
            this.f54309j = true;
            d dVar = this.f54310k;
            if (dVar != null) {
                dVar.w(f11);
            }
        }
        return f11;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f54305f;
            this.f54307h = aVar;
            AudioProcessor.a aVar2 = this.f54306g;
            this.f54308i = aVar2;
            if (this.f54309j) {
                this.f54310k = new d(aVar.f8910a, aVar.f8911b, this.f54302c, this.f54303d, this.f54304e, aVar2.f8910a);
            } else {
                d dVar = this.f54310k;
                if (dVar != null) {
                    dVar.i();
                }
            }
        }
        this.f54313n = AudioProcessor.f8908a;
        this.f54314o = 0L;
        this.f54315p = 0L;
        this.f54316q = false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f54313n;
        this.f54313n = AudioProcessor.f8908a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return this.f54306g.f8910a != -1 && (Math.abs(this.f54302c - 1.0f) >= 0.01f || Math.abs(this.f54303d - 1.0f) >= 0.01f || Math.abs(this.f54304e) >= 0.01f || this.f54306g.f8910a != this.f54305f.f8910a);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isEnded() {
        d dVar;
        return this.f54316q && ((dVar = this.f54310k) == null || dVar.k() == 0);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueEndOfStream() {
        d dVar = this.f54310k;
        if (dVar != null) {
            dVar.r();
        }
        this.f54316q = true;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        d dVar = (d) z3.a.e(this.f54310k);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f54314o += (long) iRemaining;
            dVar.s(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int iK = dVar.k();
        if (iK > 0) {
            if (this.f54311l.capacity() < iK) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iK).order(ByteOrder.nativeOrder());
                this.f54311l = byteBufferOrder;
                this.f54312m = byteBufferOrder.asShortBuffer();
            } else {
                this.f54311l.clear();
                this.f54312m.clear();
            }
            dVar.j(this.f54312m);
            this.f54315p += (long) iK;
            this.f54311l.limit(iK);
            this.f54313n = this.f54311l;
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void reset() {
        this.f54302c = 1.0f;
        this.f54303d = 1.0f;
        this.f54304e = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.f8909e;
        this.f54305f = aVar;
        this.f54306g = aVar;
        this.f54307h = aVar;
        this.f54308i = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f8908a;
        this.f54311l = byteBuffer;
        this.f54312m = byteBuffer.asShortBuffer();
        this.f54313n = byteBuffer;
        this.f54301b = -1;
        this.f54309j = false;
        this.f54310k = null;
        this.f54314o = 0L;
        this.f54315p = 0L;
        this.f54316q = false;
    }
}
