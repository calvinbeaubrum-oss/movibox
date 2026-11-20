package m4;

import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends DecoderInputBuffer {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f70787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f70788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f70789l;

    public k() {
        super(2);
        this.f70789l = 32;
    }

    @Override // androidx.media3.decoder.DecoderInputBuffer, androidx.media3.decoder.a
    public void clear() {
        super.clear();
        this.f70788k = 0;
    }

    public boolean i(DecoderInputBuffer decoderInputBuffer) {
        z3.a.a(!decoderInputBuffer.d());
        z3.a.a(!decoderInputBuffer.hasSupplementalData());
        z3.a.a(!decoderInputBuffer.isEndOfStream());
        if (!j(decoderInputBuffer)) {
            return false;
        }
        int i11 = this.f70788k;
        this.f70788k = i11 + 1;
        if (i11 == 0) {
            this.f9782f = decoderInputBuffer.f9782f;
            if (decoderInputBuffer.isKeyFrame()) {
                setFlags(1);
            }
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f9780c;
        if (byteBuffer != null) {
            b(byteBuffer.remaining());
            this.f9780c.put(byteBuffer);
        }
        this.f70787j = decoderInputBuffer.f9782f;
        return true;
    }

    public final boolean j(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!n()) {
            return true;
        }
        if (this.f70788k >= this.f70789l) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f9780c;
        return byteBuffer2 == null || (byteBuffer = this.f9780c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public long k() {
        return this.f9782f;
    }

    public long l() {
        return this.f70787j;
    }

    public int m() {
        return this.f70788k;
    }

    public boolean n() {
        return this.f70788k > 0;
    }

    public void o(int i11) {
        z3.a.a(i11 > 0);
        this.f70789l = i11;
    }
}
