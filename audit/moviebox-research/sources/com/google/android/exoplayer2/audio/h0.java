package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h0 extends v {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f32877i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f32878j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f32879k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f32880l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f32881m = o0.f35613f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f32882n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f32883o;

    @Override // com.google.android.exoplayer2.audio.v
    public AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f32705c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        this.f32879k = true;
        return (this.f32877i == 0 && this.f32878j == 0) ? AudioProcessor.a.f32702e : aVar;
    }

    @Override // com.google.android.exoplayer2.audio.v
    public void d() {
        if (this.f32879k) {
            this.f32879k = false;
            int i11 = this.f32878j;
            int i12 = this.f32948b.f32706d;
            this.f32881m = new byte[i11 * i12];
            this.f32880l = this.f32877i * i12;
        }
        this.f32882n = 0;
    }

    @Override // com.google.android.exoplayer2.audio.v
    public void e() {
        if (this.f32879k) {
            int i11 = this.f32882n;
            if (i11 > 0) {
                this.f32883o += (long) (i11 / this.f32948b.f32706d);
            }
            this.f32882n = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.v
    public void f() {
        this.f32881m = o0.f35613f;
    }

    @Override // com.google.android.exoplayer2.audio.v, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i11;
        if (super.isEnded() && (i11 = this.f32882n) > 0) {
            g(i11).put(this.f32881m, 0, this.f32882n).flip();
            this.f32882n = 0;
        }
        return super.getOutput();
    }

    public long h() {
        return this.f32883o;
    }

    public void i() {
        this.f32883o = 0L;
    }

    @Override // com.google.android.exoplayer2.audio.v, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return super.isEnded() && this.f32882n == 0;
    }

    public void j(int i11, int i12) {
        this.f32877i = i11;
        this.f32878j = i12;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i11 = iLimit - iPosition;
        if (i11 == 0) {
            return;
        }
        int iMin = Math.min(i11, this.f32880l);
        this.f32883o += (long) (iMin / this.f32948b.f32706d);
        this.f32880l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f32880l > 0) {
            return;
        }
        int i12 = i11 - iMin;
        int length = (this.f32882n + i12) - this.f32881m.length;
        ByteBuffer byteBufferG = g(length);
        int iQ = o0.q(length, 0, this.f32882n);
        byteBufferG.put(this.f32881m, 0, iQ);
        int iQ2 = o0.q(length - iQ, 0, i12);
        byteBuffer.limit(byteBuffer.position() + iQ2);
        byteBufferG.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i13 = i12 - iQ2;
        int i14 = this.f32882n - iQ;
        this.f32882n = i14;
        byte[] bArr = this.f32881m;
        System.arraycopy(bArr, iQ, bArr, 0, i14);
        byteBuffer.get(this.f32881m, this.f32882n, i13);
        this.f32882n += i13;
        byteBufferG.flip();
    }
}
