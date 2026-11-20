package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class w extends v {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public int[] f32955i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public int[] f32956j;

    @Override // com.google.android.exoplayer2.audio.v
    public AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f32955i;
        if (iArr == null) {
            return AudioProcessor.a.f32702e;
        }
        if (aVar.f32705c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        boolean z11 = aVar.f32704b != iArr.length;
        int i11 = 0;
        while (i11 < iArr.length) {
            int i12 = iArr[i11];
            if (i12 >= aVar.f32704b) {
                throw new AudioProcessor.UnhandledAudioFormatException(aVar);
            }
            z11 |= i12 != i11;
            i11++;
        }
        return z11 ? new AudioProcessor.a(aVar.f32703a, iArr.length, 2) : AudioProcessor.a.f32702e;
    }

    @Override // com.google.android.exoplayer2.audio.v
    public void d() {
        this.f32956j = this.f32955i;
    }

    @Override // com.google.android.exoplayer2.audio.v
    public void f() {
        this.f32956j = null;
        this.f32955i = null;
    }

    public void h(@Nullable int[] iArr) {
        this.f32955i = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) com.google.android.exoplayer2.util.a.e(this.f32956j);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferG = g(((iLimit - iPosition) / this.f32948b.f32706d) * this.f32949c.f32706d);
        while (iPosition < iLimit) {
            for (int i11 : iArr) {
                byteBufferG.putShort(byteBuffer.getShort((i11 * 2) + iPosition));
            }
            iPosition += this.f32948b.f32706d;
        }
        byteBuffer.position(iLimit);
        byteBufferG.flip();
    }
}
