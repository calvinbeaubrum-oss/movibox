package io;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f67310a = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);

    public final int a(int i11, int i12, int i13) {
        q.a(i11, i12, i13);
        int i14 = k.f67305e;
        c(i14 + i14);
        int iPosition = this.f67310a.position();
        this.f67310a.position(iPosition + i14 + i14);
        return iPosition;
    }

    public final r b(long j11) {
        ByteBuffer byteBufferC = c(k.f67304d);
        for (int i11 = 0; i11 < k.f67304d; i11++) {
            if (Long.compare(j11 ^ Long.MIN_VALUE, 128 ^ Long.MIN_VALUE) < 0) {
                byteBufferC.put((byte) (j11 & 255));
                break;
            }
            byteBufferC.put((byte) (128 | (127 & j11)));
            j11 >>>= 7;
        }
        return this;
    }

    public final ByteBuffer c(int i11) {
        ByteBuffer byteBuffer = this.f67310a;
        if (byteBuffer.remaining() >= i11) {
            return byteBuffer;
        }
        int iCapacity = byteBuffer.capacity();
        ByteBuffer byteBufferPut = ByteBuffer.allocate(Math.max((iCapacity * 2) + 1, p.a(iCapacity, i11))).order(ByteOrder.LITTLE_ENDIAN).put((ByteBuffer) byteBuffer.flip());
        this.f67310a = byteBufferPut;
        return byteBufferPut;
    }

    public final void d(int i11, int i12) {
        int i13 = k.f67305e;
        int i14 = i12 + i13 + i13;
        int iPosition = this.f67310a.position() - i14;
        if (iPosition == 0) {
            this.f67310a.position(i12);
            return;
        }
        ByteBuffer byteBufferDuplicate = this.f67310a.duplicate();
        byteBufferDuplicate.position(i14).limit(i14 + iPosition);
        this.f67310a.position(i12);
        e(i11, 2).b(iPosition).f67310a.put(byteBufferDuplicate);
    }

    public final r e(int i11, int i12) {
        com.google.common.base.m.d(i11 >= 1 && i11 <= k.f67303c);
        return b(fo.c.a((i11 << k.f67301a) | i12));
    }

    public ByteBuffer f() {
        ByteBuffer byteBufferDuplicate = this.f67310a.duplicate();
        byteBufferDuplicate.flip();
        this.f67310a.clear();
        return byteBufferDuplicate;
    }

    public r g(int i11, boolean z11) {
        c(k.f67304d + 1);
        e(i11, 0).f67310a.put(z11 ? (byte) 1 : (byte) 0);
        return this;
    }

    public r h(int i11, byte[] bArr) {
        return i(i11, bArr, 0, bArr.length);
    }

    public r i(int i11, byte[] bArr, int i12, int i13) {
        return j(i11, ByteBuffer.wrap(bArr, i12, i13));
    }

    public r j(int i11, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return this;
        }
        int i12 = k.f67304d;
        c(byteBuffer.remaining() + i12 + i12);
        e(i11, 2).b(byteBuffer.remaining()).f67310a.put(byteBuffer);
        return this;
    }

    public r k(int i11, double d11) {
        return n(i11, Double.doubleToLongBits(d11));
    }

    public r l(int i11, float f11) {
        return m(i11, Float.floatToIntBits(f11));
    }

    public r m(int i11, int i12) {
        c(k.f67304d + 4);
        e(i11, 5).f67310a.putInt(i12);
        return this;
    }

    public r n(int i11, long j11) {
        c(k.f67304d + 8);
        e(i11, 1).f67310a.putLong(j11);
        return this;
    }

    public r o(int i11, int i12) {
        return t(i11, j.c(i12));
    }

    public r p(int i11, androidx.core.util.a<r> aVar) {
        int iA = a(0, 1, 1);
        aVar.accept(this);
        d(i11, iA);
        return this;
    }

    public r q(int i11, l lVar) {
        int iA = a(0, 1, 1);
        lVar.a(this);
        d(i11, iA);
        return this;
    }

    public r r(int i11, Iterable<? extends l> iterable) {
        Iterator<? extends l> it = iterable.iterator();
        while (it.hasNext()) {
            q(i11, it.next());
        }
        return this;
    }

    public r s(int i11, int i12) {
        return t(i11, fo.c.a(i12));
    }

    public r t(int i11, long j11) {
        int i12 = k.f67304d;
        c(i12 + i12);
        return e(i11, 0).b(j11);
    }

    public r u(int i11, String str) {
        return h(i11, str.getBytes(StandardCharsets.UTF_8));
    }

    public r v(int i11, Pair<String, String> pair) {
        u(1, (String) pair.first).u(2, (String) pair.second).d(i11, a(0, 1, 1));
        return this;
    }
}
