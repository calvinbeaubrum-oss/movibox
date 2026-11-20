package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f33062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f33063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f33064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f33065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f33066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f33067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f33068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f33069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f33070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f33071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f33072k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f33073l;

    public void a(long j11) {
        b(j11, 1);
    }

    public final void b(long j11, int i11) {
        this.f33072k += j11;
        this.f33073l += i11;
    }

    public synchronized void c() {
    }

    public String toString() {
        return o0.C("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f33062a), Integer.valueOf(this.f33063b), Integer.valueOf(this.f33064c), Integer.valueOf(this.f33065d), Integer.valueOf(this.f33066e), Integer.valueOf(this.f33067f), Integer.valueOf(this.f33068g), Integer.valueOf(this.f33069h), Integer.valueOf(this.f33070i), Integer.valueOf(this.f33071j), Long.valueOf(this.f33072k), Integer.valueOf(this.f33073l));
    }
}
