package fh;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends DecoderInputBuffer {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f64913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f64914k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f64915l;

    public g() {
        super(2);
        this.f64915l = 32;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, com.google.android.exoplayer2.decoder.a
    public void b() {
        super.b();
        this.f64914k = 0;
    }

    public boolean s(DecoderInputBuffer decoderInputBuffer) {
        com.google.android.exoplayer2.util.a.a(!decoderInputBuffer.p());
        com.google.android.exoplayer2.util.a.a(!decoderInputBuffer.e());
        com.google.android.exoplayer2.util.a.a(!decoderInputBuffer.i());
        if (!t(decoderInputBuffer)) {
            return false;
        }
        int i11 = this.f64914k;
        this.f64914k = i11 + 1;
        if (i11 == 0) {
            this.f33032f = decoderInputBuffer.f33032f;
            if (decoderInputBuffer.k()) {
                l(1);
            }
        }
        if (decoderInputBuffer.h()) {
            l(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f33030c;
        if (byteBuffer != null) {
            n(byteBuffer.remaining());
            this.f33030c.put(byteBuffer);
        }
        this.f64913j = decoderInputBuffer.f33032f;
        return true;
    }

    public final boolean t(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!x()) {
            return true;
        }
        if (this.f64914k >= this.f64915l || decoderInputBuffer.h() != h()) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f33030c;
        return byteBuffer2 == null || (byteBuffer = this.f33030c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public long u() {
        return this.f33032f;
    }

    public long v() {
        return this.f64913j;
    }

    public int w() {
        return this.f64914k;
    }

    public boolean x() {
        return this.f64914k > 0;
    }

    public void y(int i11) {
        com.google.android.exoplayer2.util.a.a(i11 > 0);
        this.f64915l = i11;
    }
}
