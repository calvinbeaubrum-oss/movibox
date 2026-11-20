package androidx.media3.common.audio;

import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<AudioProcessor> f8914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AudioProcessor> f8915b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer[] f8916c = new ByteBuffer[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioProcessor.a f8917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioProcessor.a f8918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8919f;

    public a(ImmutableList<AudioProcessor> immutableList) {
        this.f8914a = immutableList;
        AudioProcessor.a aVar = AudioProcessor.a.f8909e;
        this.f8917d = aVar;
        this.f8918e = aVar;
        this.f8919f = false;
    }

    public AudioProcessor.a a(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.equals(AudioProcessor.a.f8909e)) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        for (int i11 = 0; i11 < this.f8914a.size(); i11++) {
            AudioProcessor audioProcessor = this.f8914a.get(i11);
            AudioProcessor.a aVarA = audioProcessor.a(aVar);
            if (audioProcessor.isActive()) {
                z3.a.g(!aVarA.equals(AudioProcessor.a.f8909e));
                aVar = aVarA;
            }
        }
        this.f8918e = aVar;
        return aVar;
    }

    public void b() {
        this.f8915b.clear();
        this.f8917d = this.f8918e;
        this.f8919f = false;
        for (int i11 = 0; i11 < this.f8914a.size(); i11++) {
            AudioProcessor audioProcessor = this.f8914a.get(i11);
            audioProcessor.flush();
            if (audioProcessor.isActive()) {
                this.f8915b.add(audioProcessor);
            }
        }
        this.f8916c = new ByteBuffer[this.f8915b.size()];
        for (int i12 = 0; i12 <= c(); i12++) {
            this.f8916c[i12] = this.f8915b.get(i12).getOutput();
        }
    }

    public final int c() {
        return this.f8916c.length - 1;
    }

    public ByteBuffer d() {
        if (!f()) {
            return AudioProcessor.f8908a;
        }
        ByteBuffer byteBuffer = this.f8916c[c()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        g(AudioProcessor.f8908a);
        return this.f8916c[c()];
    }

    public boolean e() {
        return this.f8919f && this.f8915b.get(c()).isEnded() && !this.f8916c[c()].hasRemaining();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f8914a.size() != aVar.f8914a.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f8914a.size(); i11++) {
            if (this.f8914a.get(i11) != aVar.f8914a.get(i11)) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return !this.f8915b.isEmpty();
    }

    public final void g(ByteBuffer byteBuffer) {
        boolean z11;
        do {
            z11 = false;
            for (int i11 = 0; i11 <= c(); i11++) {
                if (!this.f8916c[i11].hasRemaining()) {
                    AudioProcessor audioProcessor = this.f8915b.get(i11);
                    if (!audioProcessor.isEnded()) {
                        ByteBuffer byteBuffer2 = i11 > 0 ? this.f8916c[i11 - 1] : byteBuffer.hasRemaining() ? byteBuffer : AudioProcessor.f8908a;
                        long jRemaining = byteBuffer2.remaining();
                        audioProcessor.queueInput(byteBuffer2);
                        this.f8916c[i11] = audioProcessor.getOutput();
                        z11 |= jRemaining - ((long) byteBuffer2.remaining()) > 0 || this.f8916c[i11].hasRemaining();
                    } else if (!this.f8916c[i11].hasRemaining() && i11 < c()) {
                        this.f8915b.get(i11 + 1).queueEndOfStream();
                    }
                }
            }
        } while (z11);
    }

    public void h() {
        if (!f() || this.f8919f) {
            return;
        }
        this.f8919f = true;
        this.f8915b.get(0).queueEndOfStream();
    }

    public int hashCode() {
        return this.f8914a.hashCode();
    }

    public void i(ByteBuffer byteBuffer) {
        if (!f() || this.f8919f) {
            return;
        }
        g(byteBuffer);
    }

    public void j() {
        for (int i11 = 0; i11 < this.f8914a.size(); i11++) {
            AudioProcessor audioProcessor = this.f8914a.get(i11);
            audioProcessor.flush();
            audioProcessor.reset();
        }
        this.f8916c = new ByteBuffer[0];
        AudioProcessor.a aVar = AudioProcessor.a.f8909e;
        this.f8917d = aVar;
        this.f8918e = aVar;
        this.f8919f = false;
    }
}
