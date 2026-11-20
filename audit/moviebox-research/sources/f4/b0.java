package f4;

import androidx.annotation.Nullable;
import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends androidx.media3.common.audio.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public int[] f64551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public int[] f64552j;

    @Override // androidx.media3.common.audio.b
    public AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f64551i;
        if (iArr == null) {
            return AudioProcessor.a.f8909e;
        }
        if (aVar.f8912c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        boolean z11 = aVar.f8911b != iArr.length;
        int i11 = 0;
        while (i11 < iArr.length) {
            int i12 = iArr[i11];
            if (i12 >= aVar.f8911b) {
                throw new AudioProcessor.UnhandledAudioFormatException(aVar);
            }
            z11 |= i12 != i11;
            i11++;
        }
        return z11 ? new AudioProcessor.a(aVar.f8910a, iArr.length, 2) : AudioProcessor.a.f8909e;
    }

    @Override // androidx.media3.common.audio.b
    public void d() {
        this.f64552j = this.f64551i;
    }

    @Override // androidx.media3.common.audio.b
    public void f() {
        this.f64552j = null;
        this.f64551i = null;
    }

    public void h(@Nullable int[] iArr) {
        this.f64551i = iArr;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) z3.a.e(this.f64552j);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferG = g(((iLimit - iPosition) / this.f8920b.f8913d) * this.f8921c.f8913d);
        while (iPosition < iLimit) {
            for (int i11 : iArr) {
                byteBufferG.putShort(byteBuffer.getShort((i11 * 2) + iPosition));
            }
            iPosition += this.f8920b.f8913d;
        }
        byteBuffer.position(iLimit);
        byteBufferG.flip();
    }
}
