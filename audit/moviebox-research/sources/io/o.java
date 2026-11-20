package io;

import android.os.Build;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f67308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f67309b;

    public o(ByteBuffer byteBuffer) {
        ByteOrder byteOrderOrder = byteBuffer.order();
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.f67308a = byteOrderOrder != byteOrder ? byteBuffer.slice().order(byteOrder) : byteBuffer;
        this.f67309b = -1;
    }

    public final long a() {
        int i11 = this.f67308a.get() & 255;
        if (i11 < 128) {
            return i11;
        }
        long j11 = ((long) i11) & 127;
        int i12 = 1;
        while (true) {
            int i13 = k.f67304d;
            if (i12 >= i13) {
                break;
            }
            int i14 = this.f67308a.get() & 255;
            j11 |= (((long) i14) & 127) << (i12 * 7);
            if (i14 < 128) {
                if (i12 == i13 - 1 && i14 >= 2) {
                    break;
                }
                return j11;
            }
            i12++;
        }
        throw new IllegalStateException("malformed varint");
    }

    public boolean b() {
        return this.f67308a.hasRemaining();
    }

    public void c() {
        int i11 = this.f67309b;
        if (i11 == 0) {
            a();
            return;
        }
        if (i11 == 1) {
            j();
        } else if (i11 == 2) {
            f();
        } else {
            if (i11 != 5) {
                throw new IllegalStateException();
            }
            i();
        }
    }

    public boolean d() {
        return p() != 0;
    }

    public byte[] e() {
        ByteBuffer byteBufferF = f();
        byte[] bArr = new byte[byteBufferF.remaining()];
        byteBufferF.get(bArr);
        return bArr;
    }

    public ByteBuffer f() {
        ByteBuffer byteBufferSlice;
        com.google.common.base.m.v(this.f67309b == 2);
        int iA = -1;
        this.f67309b = -1;
        long jA = a();
        try {
            iA = n.a(jA);
        } catch (ArithmeticException unused) {
        }
        com.google.common.base.m.y(iA >= 0, "malformed length: %d", jA);
        if (Build.VERSION.SDK_INT >= 34) {
            ByteBuffer byteBuffer = this.f67308a;
            byteBufferSlice = byteBuffer.slice(byteBuffer.position(), iA);
        } else {
            ByteBuffer byteBufferDuplicate = this.f67308a.duplicate();
            byteBufferSlice = ((ByteBuffer) byteBufferDuplicate.limit(byteBufferDuplicate.position() + iA)).slice();
        }
        ByteBuffer byteBuffer2 = this.f67308a;
        byteBuffer2.position(byteBufferSlice.remaining() + byteBuffer2.position());
        return byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
    }

    public double g() {
        return Double.longBitsToDouble(j());
    }

    public float h() {
        return Float.intBitsToFloat(i());
    }

    public int i() {
        com.google.common.base.m.v(this.f67309b == 5);
        this.f67309b = -1;
        return this.f67308a.getInt();
    }

    public long j() {
        com.google.common.base.m.v(this.f67309b == 1);
        this.f67309b = -1;
        return this.f67308a.getLong();
    }

    public int k() {
        return j.a(p());
    }

    public <M extends l> M l(M m11) {
        return (M) m11.b(new o(f()));
    }

    public <M extends l> List<M> m(List<M> list, List<M> list2, M m11) {
        List arrayList = list;
        if (list2 == list) {
            arrayList = new ArrayList(1);
        }
        arrayList.add(l(m11));
        return (List<M>) arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0026  */
    public int n() {
        boolean z11;
        long jA = a();
        int i11 = (int) (((long) k.f67302b) & jA);
        int i12 = (int) (jA >>> k.f67301a);
        if (Long.compare(jA ^ Long.MIN_VALUE, fo.c.a(-1) ^ Long.MIN_VALUE) <= 0 && i11 >= 0 && i11 <= 5) {
            z11 = i12 >= 1 && i12 <= k.f67303c;
        }
        com.google.common.base.m.y(z11, "malformed key: %s", jA);
        this.f67309b = i11;
        return i12;
    }

    public int o() {
        return (int) (p() & 4294967295L);
    }

    public long p() {
        com.google.common.base.m.v(this.f67309b == 0);
        this.f67309b = -1;
        return a();
    }

    public String q() {
        return StandardCharsets.UTF_8.decode(f()).toString();
    }

    public Pair<String, String> r() {
        o oVar = new o(f());
        String strQ = "";
        String strQ2 = "";
        while (oVar.b()) {
            int iN = oVar.n();
            if (iN == 1) {
                strQ = oVar.q();
            } else {
                if (iN != 2) {
                    throw new IllegalStateException("unexpected tag");
                }
                strQ2 = oVar.q();
            }
        }
        return new Pair<>(strQ, strQ2);
    }
}
