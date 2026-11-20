package com.transsion.transfer.androidasync;

import android.annotation.TargetApi;
import android.os.Looper;
import com.transsion.transfer.androidasync.util.ArrayDeque;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@TargetApi(9)
public class ByteBufferList {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PriorityQueue<ByteBuffer> f58475d = new PriorityQueue<>(8, new Reclaimer());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f58476e = 1048576;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f58477f = 262144;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f58478g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f58479h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f58480i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ByteBuffer f58481j = ByteBuffer.allocate(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayDeque<ByteBuffer> f58482a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteOrder f58483b = ByteOrder.BIG_ENDIAN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f58484c = 0;

    /* JADX INFO: compiled from: source.java */
    public static class Reclaimer implements Comparator<ByteBuffer> {
        @Override // java.util.Comparator
        public int compare(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            if (byteBuffer.capacity() == byteBuffer2.capacity()) {
                return 0;
            }
            return byteBuffer.capacity() > byteBuffer2.capacity() ? 1 : -1;
        }
    }

    public ByteBufferList() {
    }

    public ByteBufferList(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
    }

    public ByteBufferList(ByteBuffer... byteBufferArr) {
        b(byteBufferArr);
    }

    public static void A(ByteBuffer byteBuffer) {
        PriorityQueue<ByteBuffer> priorityQueueP;
        if (byteBuffer == null || byteBuffer.isDirect() || byteBuffer.arrayOffset() != 0 || byteBuffer.array().length != byteBuffer.capacity() || byteBuffer.capacity() < 8192 || byteBuffer.capacity() > f58477f || (priorityQueueP = p()) == null) {
            return;
        }
        synchronized (f58480i) {
            while (f58478g > f58476e && priorityQueueP.size() > 0 && priorityQueueP.peek().capacity() < byteBuffer.capacity()) {
                try {
                    f58478g -= priorityQueueP.remove().capacity();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (f58478g > f58476e) {
                return;
            }
            byteBuffer.position(0);
            byteBuffer.limit(byteBuffer.capacity());
            f58478g += byteBuffer.capacity();
            priorityQueueP.add(byteBuffer);
            f58479h = Math.max(f58479h, byteBuffer.capacity());
        }
    }

    public static PriorityQueue<ByteBuffer> p() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null || Thread.currentThread() != mainLooper.getThread()) {
            return f58475d;
        }
        return null;
    }

    public static ByteBuffer t(int i11) {
        PriorityQueue<ByteBuffer> priorityQueueP;
        ByteBuffer byteBufferRemove;
        if (i11 <= f58479h && (priorityQueueP = p()) != null) {
            synchronized (f58480i) {
                do {
                    try {
                        if (priorityQueueP.size() > 0) {
                            byteBufferRemove = priorityQueueP.remove();
                            if (priorityQueueP.size() == 0) {
                                f58479h = 0;
                            }
                            f58478g -= byteBufferRemove.capacity();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                } while (byteBufferRemove.capacity() < i11);
                return byteBufferRemove;
            }
        }
        return ByteBuffer.allocate(Math.max(8192, i11));
    }

    public void B() {
        while (this.f58482a.size() > 0) {
            A(this.f58482a.remove());
        }
        this.f58484c = 0;
    }

    public int C() {
        return this.f58484c;
    }

    public ByteBuffer D() {
        ByteBuffer byteBufferRemove = this.f58482a.remove();
        this.f58484c -= byteBufferRemove.remaining();
        return byteBufferRemove;
    }

    public int E() {
        return this.f58482a.size();
    }

    public void F() {
        x(0);
    }

    public ByteBufferList a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            A(byteBuffer);
            return this;
        }
        d(byteBuffer.remaining());
        if (this.f58482a.size() > 0) {
            ByteBuffer last = this.f58482a.getLast();
            if (last.capacity() - last.limit() >= byteBuffer.remaining()) {
                last.mark();
                last.position(last.limit());
                last.limit(last.capacity());
                last.put(byteBuffer);
                last.limit(last.position());
                last.reset();
                A(byteBuffer);
                F();
                return this;
            }
        }
        this.f58482a.add(byteBuffer);
        F();
        return this;
    }

    public ByteBufferList b(ByteBuffer... byteBufferArr) {
        for (ByteBuffer byteBuffer : byteBufferArr) {
            a(byteBuffer);
        }
        return this;
    }

    public void c(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            A(byteBuffer);
            return;
        }
        d(byteBuffer.remaining());
        if (this.f58482a.size() > 0) {
            ByteBuffer first = this.f58482a.getFirst();
            if (first.position() >= byteBuffer.remaining()) {
                first.position(first.position() - byteBuffer.remaining());
                first.mark();
                first.put(byteBuffer);
                first.reset();
                A(byteBuffer);
                return;
            }
        }
        this.f58482a.addFirst(byteBuffer);
    }

    public final void d(int i11) {
        if (C() >= 0) {
            this.f58484c += i11;
        }
    }

    public byte e() {
        byte b11 = x(1).get();
        this.f58484c--;
        return b11;
    }

    public void f(ByteBufferList byteBufferList) {
        g(byteBufferList, C());
    }

    public void g(ByteBufferList byteBufferList, int i11) {
        if (C() < i11) {
            throw new IllegalArgumentException("length");
        }
        int i12 = 0;
        while (i12 < i11) {
            ByteBuffer byteBufferRemove = this.f58482a.remove();
            int iRemaining = byteBufferRemove.remaining();
            if (iRemaining == 0) {
                A(byteBufferRemove);
            } else {
                int i13 = iRemaining + i12;
                if (i13 > i11) {
                    int i14 = i11 - i12;
                    ByteBuffer byteBufferT = t(i14);
                    byteBufferT.limit(i14);
                    byteBufferRemove.get(byteBufferT.array(), 0, i14);
                    byteBufferList.a(byteBufferT);
                    this.f58482a.addFirst(byteBufferRemove);
                    break;
                }
                byteBufferList.a(byteBufferRemove);
                i12 = i13;
            }
        }
        this.f58484c -= i11;
    }

    public void h(byte[] bArr) {
        i(bArr, 0, bArr.length);
    }

    public void i(byte[] bArr, int i11, int i12) {
        if (C() < i12) {
            throw new IllegalArgumentException("length");
        }
        int i13 = i12;
        while (i13 > 0) {
            ByteBuffer byteBufferPeek = this.f58482a.peek();
            int iMin = Math.min(byteBufferPeek.remaining(), i13);
            if (bArr != null) {
                byteBufferPeek.get(bArr, i11, iMin);
            } else {
                byteBufferPeek.position(byteBufferPeek.position() + iMin);
            }
            i13 -= iMin;
            i11 += iMin;
            if (byteBufferPeek.remaining() == 0) {
                this.f58482a.remove();
                A(byteBufferPeek);
            }
        }
        this.f58484c -= i12;
    }

    public ByteBuffer j() {
        if (C() == 0) {
            return f58481j;
        }
        x(C());
        return D();
    }

    public ByteBuffer[] k() {
        ByteBuffer[] byteBufferArr = (ByteBuffer[]) this.f58482a.toArray(new ByteBuffer[this.f58482a.size()]);
        this.f58482a.clear();
        this.f58484c = 0;
        return byteBufferArr;
    }

    public byte[] l() {
        byte[] bArr = new byte[C()];
        h(bArr);
        return bArr;
    }

    public char m() {
        char c11 = (char) x(1).get();
        this.f58484c--;
        return c11;
    }

    public int n() {
        int i11 = x(4).getInt();
        this.f58484c -= 4;
        return i11;
    }

    public long o() {
        long j11 = x(8).getLong();
        this.f58484c -= 8;
        return j11;
    }

    public short q() {
        short s11 = x(2).getShort();
        this.f58484c -= 2;
        return s11;
    }

    public boolean r() {
        return C() > 0;
    }

    public boolean s() {
        return this.f58484c == 0;
    }

    public ByteBufferList u(ByteOrder byteOrder) {
        this.f58483b = byteOrder;
        return this;
    }

    public String v() {
        return w(null);
    }

    public String w(Charset charset) {
        byte[] bArrArray;
        int iRemaining;
        int i11;
        if (charset == null) {
            charset = com.transsion.transfer.androidasync.util.d.f58876b;
        }
        StringBuilder sb2 = new StringBuilder();
        for (ByteBuffer byteBuffer : this.f58482a) {
            if (byteBuffer.isDirect()) {
                bArrArray = new byte[byteBuffer.remaining()];
                iRemaining = byteBuffer.remaining();
                byteBuffer.get(bArrArray);
                i11 = 0;
            } else {
                bArrArray = byteBuffer.array();
                int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                iRemaining = byteBuffer.remaining();
                i11 = iArrayOffset;
            }
            sb2.append(new String(bArrArray, i11, iRemaining, charset));
        }
        return sb2.toString();
    }

    public final ByteBuffer x(int i11) {
        ByteBuffer byteBufferRemove;
        if (C() < i11) {
            throw new IllegalArgumentException("count : " + C() + "/" + i11);
        }
        ByteBuffer byteBufferPeek = this.f58482a.peek();
        while (byteBufferPeek != null && !byteBufferPeek.hasRemaining()) {
            A(this.f58482a.remove());
            byteBufferPeek = this.f58482a.peek();
        }
        if (byteBufferPeek == null) {
            return f58481j;
        }
        if (byteBufferPeek.remaining() >= i11) {
            return byteBufferPeek.order(this.f58483b);
        }
        ByteBuffer byteBufferT = t(i11);
        byteBufferT.limit(i11);
        byte[] bArrArray = byteBufferT.array();
        int i12 = 0;
        loop1: while (true) {
            byteBufferRemove = null;
            do {
                if (i12 >= i11) {
                    break loop1;
                }
                byteBufferRemove = this.f58482a.remove();
                int iMin = Math.min(i11 - i12, byteBufferRemove.remaining());
                byteBufferRemove.get(bArrArray, i12, iMin);
                i12 += iMin;
            } while (byteBufferRemove.remaining() != 0);
            A(byteBufferRemove);
        }
        if (byteBufferRemove != null && byteBufferRemove.remaining() > 0) {
            this.f58482a.addFirst(byteBufferRemove);
        }
        this.f58482a.addFirst(byteBufferT);
        return byteBufferT.order(this.f58483b);
    }

    public String y() {
        return z(null);
    }

    public String z(Charset charset) {
        String strW = w(charset);
        B();
        return strW;
    }
}
