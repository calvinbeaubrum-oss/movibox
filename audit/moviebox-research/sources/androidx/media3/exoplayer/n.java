package androidx.media3.exoplayer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f10782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10783l;

    public void a(long j11) {
        b(j11, 1);
    }

    public final void b(long j11, int i11) {
        this.f10782k += j11;
        this.f10783l += i11;
    }

    public synchronized void c() {
    }

    public String toString() {
        return z3.u0.G("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f10772a), Integer.valueOf(this.f10773b), Integer.valueOf(this.f10774c), Integer.valueOf(this.f10775d), Integer.valueOf(this.f10776e), Integer.valueOf(this.f10777f), Integer.valueOf(this.f10778g), Integer.valueOf(this.f10779h), Integer.valueOf(this.f10780i), Integer.valueOf(this.f10781j), Long.valueOf(this.f10782k), Integer.valueOf(this.f10783l));
    }
}
