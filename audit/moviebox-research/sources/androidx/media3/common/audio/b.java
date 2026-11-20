package androidx.media3.common.audio;

import androidx.annotation.CallSuper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioProcessor.a f8920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioProcessor.a f8921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioProcessor.a f8922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioProcessor.a f8923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ByteBuffer f8924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f8925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8926h;

    public b() {
        ByteBuffer byteBuffer = AudioProcessor.f8908a;
        this.f8924f = byteBuffer;
        this.f8925g = byteBuffer;
        AudioProcessor.a aVar = AudioProcessor.a.f8909e;
        this.f8922d = aVar;
        this.f8923e = aVar;
        this.f8920b = aVar;
        this.f8921c = aVar;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        this.f8922d = aVar;
        this.f8923e = c(aVar);
        return isActive() ? this.f8923e : AudioProcessor.a.f8909e;
    }

    public final boolean b() {
        return this.f8925g.hasRemaining();
    }

    public abstract AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException;

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void flush() {
        this.f8925g = AudioProcessor.f8908a;
        this.f8926h = false;
        this.f8920b = this.f8922d;
        this.f8921c = this.f8923e;
        d();
    }

    public final ByteBuffer g(int i11) {
        if (this.f8924f.capacity() < i11) {
            this.f8924f = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        } else {
            this.f8924f.clear();
        }
        ByteBuffer byteBuffer = this.f8924f;
        this.f8925g = byteBuffer;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    @CallSuper
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f8925g;
        this.f8925g = AudioProcessor.f8908a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return this.f8923e != AudioProcessor.a.f8909e;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    @CallSuper
    public boolean isEnded() {
        return this.f8926h && this.f8925g == AudioProcessor.f8908a;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueEndOfStream() {
        this.f8926h = true;
        e();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f8924f = AudioProcessor.f8908a;
        AudioProcessor.a aVar = AudioProcessor.a.f8909e;
        this.f8922d = aVar;
        this.f8923e = aVar;
        this.f8920b = aVar;
        this.f8921c = aVar;
        f();
    }
}
