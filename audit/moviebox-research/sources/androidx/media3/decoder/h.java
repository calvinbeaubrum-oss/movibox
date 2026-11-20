package androidx.media3.decoder;

import androidx.annotation.CallSuper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends androidx.media3.decoder.a {
    public boolean shouldBeSkipped;
    public int skippedOutputBufferCount;
    public long timeUs;

    /* JADX INFO: compiled from: source.java */
    public interface a<S extends h> {
        void a(S s11);
    }

    @Override // androidx.media3.decoder.a
    @CallSuper
    public void clear() {
        super.clear();
        this.timeUs = 0L;
        this.skippedOutputBufferCount = 0;
        this.shouldBeSkipped = false;
    }

    public abstract void release();
}
