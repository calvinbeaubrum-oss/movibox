package com.google.android.exoplayer2.audio;

import androidx.annotation.CallSuper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class v implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioProcessor.a f32948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioProcessor.a f32949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioProcessor.a f32950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioProcessor.a f32951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ByteBuffer f32952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f32953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f32954h;

    public v() {
        ByteBuffer byteBuffer = AudioProcessor.f32701a;
        this.f32952f = byteBuffer;
        this.f32953g = byteBuffer;
        AudioProcessor.a aVar = AudioProcessor.a.f32702e;
        this.f32950d = aVar;
        this.f32951e = aVar;
        this.f32948b = aVar;
        this.f32949c = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        this.f32950d = aVar;
        this.f32951e = c(aVar);
        return isActive() ? this.f32951e : AudioProcessor.a.f32702e;
    }

    public final boolean b() {
        return this.f32953g.hasRemaining();
    }

    public abstract AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException;

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.f32953g = AudioProcessor.f32701a;
        this.f32954h = false;
        this.f32948b = this.f32950d;
        this.f32949c = this.f32951e;
        d();
    }

    public final ByteBuffer g(int i11) {
        if (this.f32952f.capacity() < i11) {
            this.f32952f = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        } else {
            this.f32952f.clear();
        }
        ByteBuffer byteBuffer = this.f32952f;
        this.f32953g = byteBuffer;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f32953g;
        this.f32953g = AudioProcessor.f32701a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f32951e != AudioProcessor.a.f32702e;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public boolean isEnded() {
        return this.f32954h && this.f32953g == AudioProcessor.f32701a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void queueEndOfStream() {
        this.f32954h = true;
        e();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f32952f = AudioProcessor.f32701a;
        AudioProcessor.a aVar = AudioProcessor.a.f32702e;
        this.f32950d = aVar;
        this.f32951e = aVar;
        this.f32948b = aVar;
        this.f32949c = aVar;
        f();
    }
}
