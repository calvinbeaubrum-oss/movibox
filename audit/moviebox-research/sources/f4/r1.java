package f4;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r1 extends androidx.media3.common.audio.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f64599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f64600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f64601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f64602l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f64603m = z3.u0.f81843f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f64604n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f64605o;

    @Override // androidx.media3.common.audio.b
    public AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f8912c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        this.f64601k = true;
        return (this.f64599i == 0 && this.f64600j == 0) ? AudioProcessor.a.f8909e : aVar;
    }

    @Override // androidx.media3.common.audio.b
    public void d() {
        if (this.f64601k) {
            this.f64601k = false;
            int i11 = this.f64600j;
            int i12 = this.f8920b.f8913d;
            this.f64603m = new byte[i11 * i12];
            this.f64602l = this.f64599i * i12;
        }
        this.f64604n = 0;
    }

    @Override // androidx.media3.common.audio.b
    public void e() {
        if (this.f64601k) {
            int i11 = this.f64604n;
            if (i11 > 0) {
                this.f64605o += (long) (i11 / this.f8920b.f8913d);
            }
            this.f64604n = 0;
        }
    }

    @Override // androidx.media3.common.audio.b
    public void f() {
        this.f64603m = z3.u0.f81843f;
    }

    @Override // androidx.media3.common.audio.b, androidx.media3.common.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i11;
        if (super.isEnded() && (i11 = this.f64604n) > 0) {
            g(i11).put(this.f64603m, 0, this.f64604n).flip();
            this.f64604n = 0;
        }
        return super.getOutput();
    }

    public long h() {
        return this.f64605o;
    }

    public void i() {
        this.f64605o = 0L;
    }

    @Override // androidx.media3.common.audio.b, androidx.media3.common.audio.AudioProcessor
    public boolean isEnded() {
        return super.isEnded() && this.f64604n == 0;
    }

    public void j(int i11, int i12) {
        this.f64599i = i11;
        this.f64600j = i12;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i11 = iLimit - iPosition;
        if (i11 == 0) {
            return;
        }
        int iMin = Math.min(i11, this.f64602l);
        this.f64605o += (long) (iMin / this.f8920b.f8913d);
        this.f64602l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f64602l > 0) {
            return;
        }
        int i12 = i11 - iMin;
        int length = (this.f64604n + i12) - this.f64603m.length;
        ByteBuffer byteBufferG = g(length);
        int iP = z3.u0.p(length, 0, this.f64604n);
        byteBufferG.put(this.f64603m, 0, iP);
        int iP2 = z3.u0.p(length - iP, 0, i12);
        byteBuffer.limit(byteBuffer.position() + iP2);
        byteBufferG.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i13 = i12 - iP2;
        int i14 = this.f64604n - iP;
        this.f64604n = i14;
        byte[] bArr = this.f64603m;
        System.arraycopy(bArr, iP, bArr, 0, i14);
        byteBuffer.get(this.f64603m, this.f64604n, i13);
        this.f64604n += i13;
        byteBufferG.flip();
    }
}
