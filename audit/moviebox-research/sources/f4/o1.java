package f4;

import androidx.annotation.Nullable;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.decoder.DecoderInputBuffer;
import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f64571d = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.FS, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, -128, -69, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f64572e = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, Ascii.VT, -103, 87, 83, 1, Ascii.DLE, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f64573a = AudioProcessor.f8908a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f64575c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f64574b = 2;

    public void a(DecoderInputBuffer decoderInputBuffer, List<byte[]> list) {
        z3.a.e(decoderInputBuffer.f9780c);
        if (decoderInputBuffer.f9780c.limit() - decoderInputBuffer.f9780c.position() == 0) {
            return;
        }
        this.f64573a = b(decoderInputBuffer.f9780c, (this.f64574b == 2 && (list.size() == 1 || list.size() == 3)) ? list.get(0) : null);
        decoderInputBuffer.clear();
        decoderInputBuffer.b(this.f64573a.remaining());
        decoderInputBuffer.f9780c.put(this.f64573a);
        decoderInputBuffer.c();
    }

    public final ByteBuffer b(ByteBuffer byteBuffer, @Nullable byte[] bArr) {
        int i11;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i12 = iLimit - iPosition;
        int i13 = (i12 + 255) / 255;
        int length = i13 + 27 + i12;
        if (this.f64574b == 2) {
            int length2 = bArr != null ? bArr.length + 28 : f64571d.length;
            length += f64572e.length + length2;
            i11 = length2;
        } else {
            i11 = 0;
        }
        ByteBuffer byteBufferC = c(length);
        if (this.f64574b == 2) {
            if (bArr != null) {
                e(byteBufferC, bArr);
            } else {
                byteBufferC.put(f64571d);
            }
            byteBufferC.put(f64572e);
        }
        int iJ = this.f64575c + u4.k0.j(byteBuffer);
        this.f64575c = iJ;
        f(byteBufferC, iJ, this.f64574b, i13, false);
        for (int i14 = 0; i14 < i13; i14++) {
            if (i12 >= 255) {
                byteBufferC.put((byte) -1);
                i12 -= 255;
            } else {
                byteBufferC.put((byte) i12);
                i12 = 0;
            }
        }
        while (iPosition < iLimit) {
            byteBufferC.put(byteBuffer.get(iPosition));
            iPosition++;
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferC.flip();
        if (this.f64574b == 2) {
            byte[] bArrArray = byteBufferC.array();
            int iArrayOffset = byteBufferC.arrayOffset() + i11;
            byte[] bArr2 = f64572e;
            byteBufferC.putInt(i11 + bArr2.length + 22, z3.u0.x(bArrArray, iArrayOffset + bArr2.length, byteBufferC.limit() - byteBufferC.position(), 0));
        } else {
            byteBufferC.putInt(22, z3.u0.x(byteBufferC.array(), byteBufferC.arrayOffset(), byteBufferC.limit() - byteBufferC.position(), 0));
        }
        this.f64574b++;
        return byteBufferC;
    }

    public final ByteBuffer c(int i11) {
        if (this.f64573a.capacity() < i11) {
            this.f64573a = ByteBuffer.allocate(i11).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f64573a.clear();
        }
        return this.f64573a;
    }

    public void d() {
        this.f64573a = AudioProcessor.f8908a;
        this.f64575c = 0;
        this.f64574b = 2;
    }

    public final void e(ByteBuffer byteBuffer, byte[] bArr) {
        f(byteBuffer, 0L, 0, 1, true);
        byteBuffer.put(com.google.common.primitives.g.a(bArr.length));
        byteBuffer.put(bArr);
        byteBuffer.putInt(22, z3.u0.x(byteBuffer.array(), byteBuffer.arrayOffset(), bArr.length + 28, 0));
        byteBuffer.position(bArr.length + 28);
    }

    public final void f(ByteBuffer byteBuffer, long j11, int i11, int i12, boolean z11) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(z11 ? (byte) 2 : (byte) 0);
        byteBuffer.putLong(j11);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i11);
        byteBuffer.putInt(0);
        byteBuffer.put(com.google.common.primitives.g.a(i12));
    }
}
