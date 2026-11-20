package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Api.BaseClientBuilder.API_PRIORITY_OTHER};
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* JADX INFO: compiled from: source.java */
    public class a extends ByteString.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f41187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteString.e f41188b = b();

        public a() {
            this.f41187a = new c(RopeByteString.this, null);
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [com.google.protobuf.ByteString$e] */
        public final ByteString.e b() {
            if (this.f41187a.hasNext()) {
                return this.f41187a.next().iterator2();
            }
            return null;
        }

        @Override // com.google.protobuf.ByteString.e
        public byte e() {
            ByteString.e eVar = this.f41188b;
            if (eVar == null) {
                throw new NoSuchElementException();
            }
            byte bE = eVar.e();
            if (!this.f41188b.hasNext()) {
                this.f41188b = b();
            }
            return bE;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41188b != null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque<ByteString> f41190a;

        public b() {
            this.f41190a = new ArrayDeque<>();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public final ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString byteStringPop = this.f41190a.pop();
            while (!this.f41190a.isEmpty()) {
                byteStringPop = new RopeByteString(this.f41190a.pop(), byteStringPop, null);
            }
            return byteStringPop;
        }

        public final void c(ByteString byteString) {
            if (byteString.isBalanced()) {
                e(byteString);
                return;
            }
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                c(ropeByteString.left);
                c(ropeByteString.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        public final int d(int i11) {
            int iBinarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i11);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        public final void e(ByteString byteString) {
            a aVar;
            int iD = d(byteString.size());
            int iMinLength = RopeByteString.minLength(iD + 1);
            if (this.f41190a.isEmpty() || this.f41190a.peek().size() >= iMinLength) {
                this.f41190a.push(byteString);
                return;
            }
            int iMinLength2 = RopeByteString.minLength(iD);
            ByteString byteStringPop = this.f41190a.pop();
            while (true) {
                aVar = null;
                if (this.f41190a.isEmpty() || this.f41190a.peek().size() >= iMinLength2) {
                    break;
                } else {
                    byteStringPop = new RopeByteString(this.f41190a.pop(), byteStringPop, aVar);
                }
            }
            RopeByteString ropeByteString = new RopeByteString(byteStringPop, byteString, aVar);
            while (!this.f41190a.isEmpty()) {
                if (this.f41190a.peek().size() >= RopeByteString.minLength(d(ropeByteString.size()) + 1)) {
                    break;
                } else {
                    ropeByteString = new RopeByteString(this.f41190a.pop(), ropeByteString, aVar);
                }
            }
            this.f41190a.push(ropeByteString);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements Iterator<ByteString.LeafByteString> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque<RopeByteString> f41191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteString.LeafByteString f41192b;

        public c(ByteString byteString) {
            if (!(byteString instanceof RopeByteString)) {
                this.f41191a = null;
                this.f41192b = (ByteString.LeafByteString) byteString;
                return;
            }
            RopeByteString ropeByteString = (RopeByteString) byteString;
            ArrayDeque<RopeByteString> arrayDeque = new ArrayDeque<>(ropeByteString.getTreeDepth());
            this.f41191a = arrayDeque;
            arrayDeque.push(ropeByteString);
            this.f41192b = a(ropeByteString.left);
        }

        public /* synthetic */ c(ByteString byteString, a aVar) {
            this(byteString);
        }

        public final ByteString.LeafByteString a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f41191a.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        public final ByteString.LeafByteString b() {
            ByteString.LeafByteString leafByteStringA;
            do {
                ArrayDeque<RopeByteString> arrayDeque = this.f41191a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                leafByteStringA = a(this.f41191a.pop().right);
            } while (leafByteStringA.isEmpty());
            return leafByteStringA;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.f41192b;
            if (leafByteString == null) {
                throw new NoSuchElementException();
            }
            this.f41192b = b();
            return leafByteString;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41192b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f41193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteString.LeafByteString f41194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f41196d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f41197f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f41198g;

        public d() {
            c();
        }

        public final void a() {
            if (this.f41194b != null) {
                int i11 = this.f41196d;
                int i12 = this.f41195c;
                if (i11 == i12) {
                    this.f41197f += i12;
                    this.f41196d = 0;
                    if (!this.f41193a.hasNext()) {
                        this.f41194b = null;
                        this.f41195c = 0;
                    } else {
                        ByteString.LeafByteString next = this.f41193a.next();
                        this.f41194b = next;
                        this.f41195c = next.size();
                    }
                }
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return b();
        }

        public final int b() {
            return RopeByteString.this.size() - (this.f41197f + this.f41196d);
        }

        public final void c() {
            c cVar = new c(RopeByteString.this, null);
            this.f41193a = cVar;
            ByteString.LeafByteString next = cVar.next();
            this.f41194b = next;
            this.f41195c = next.size();
            this.f41196d = 0;
            this.f41197f = 0;
        }

        public final int d(byte[] bArr, int i11, int i12) {
            int i13 = i12;
            while (i13 > 0) {
                a();
                if (this.f41194b == null) {
                    break;
                }
                int iMin = Math.min(this.f41195c - this.f41196d, i13);
                if (bArr != null) {
                    this.f41194b.copyTo(bArr, this.f41196d, i11, iMin);
                    i11 += iMin;
                }
                this.f41196d += iMin;
                i13 -= iMin;
            }
            return i12 - i13;
        }

        @Override // java.io.InputStream
        public void mark(int i11) {
            this.f41198g = this.f41197f + this.f41196d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            a();
            ByteString.LeafByteString leafByteString = this.f41194b;
            if (leafByteString == null) {
                return -1;
            }
            int i11 = this.f41196d;
            this.f41196d = i11 + 1;
            return leafByteString.byteAt(i11) & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) {
            bArr.getClass();
            if (i11 < 0 || i12 < 0 || i12 > bArr.length - i11) {
                throw new IndexOutOfBoundsException();
            }
            int iD = d(bArr, i11, i12);
            if (iD != 0) {
                return iD;
            }
            if (i12 > 0 || b() == 0) {
                return -1;
            }
            return iD;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            c();
            d(null, 0, this.f41198g);
        }

        @Override // java.io.InputStream
        public long skip(long j11) {
            if (j11 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j11 > 2147483647L) {
                j11 = 2147483647L;
            }
            return d(null, 0, (int) j11);
        }
    }

    public RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    public /* synthetic */ RopeByteString(ByteString byteString, ByteString byteString2, a aVar) {
        this(byteString, byteString2);
    }

    public static ByteString a(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.wrap(bArr);
    }

    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return a(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, a(ropeByteString.right, byteString2));
            }
            if (ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        return size >= minLength(Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1) ? new RopeByteString(byteString, byteString2) : new b(null).b(byteString, byteString2);
    }

    public static int minLength(int i11) {
        int[] iArr = minLengthByDepth;
        return i11 >= iArr.length ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iArr[i11];
    }

    public static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this, null);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    public final boolean b(ByteString byteString) {
        ByteString.LeafByteString next;
        a aVar = null;
        c cVar = new c(this, aVar);
        ByteString.LeafByteString next2 = cVar.next();
        c cVar2 = new c(byteString, aVar);
        ByteString.LeafByteString next3 = cVar2.next();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int size = next2.size() - i11;
            int size2 = next3.size() - i12;
            int iMin = Math.min(size, size2);
            if (!(i11 == 0 ? next2.equalsRange(next3, i12, iMin) : next3.equalsRange(next2, i11, iMin))) {
                return false;
            }
            i13 += iMin;
            int i14 = this.totalLength;
            if (i13 >= i14) {
                if (i13 == i14) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                next = cVar.next();
                i11 = 0;
            } else {
                i11 += iMin;
            }
            if (iMin == size2) {
                next2 = next2;
                next2 = next;
                next3 = cVar2.next();
                i12 = 0;
            } else {
                next2 = next2;
                next2 = next;
                i12 += iMin;
            }
        }
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i11) {
        ByteString.checkIndex(i11, this.totalLength);
        return internalByteAt(i11);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
        int i14 = i11 + i13;
        int i15 = this.leftLength;
        if (i14 <= i15) {
            this.left.copyToInternal(bArr, i11, i12, i13);
        } else {
            if (i11 >= i15) {
                this.right.copyToInternal(bArr, i11 - i15, i12, i13);
                return;
            }
            int i16 = i15 - i11;
            this.left.copyToInternal(bArr, i11, i12, i16);
            this.right.copyToInternal(bArr, 0, i12 + i16, i13 - i16);
        }
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int iPeekCachedHashCode = peekCachedHashCode();
        int iPeekCachedHashCode2 = byteString.peekCachedHashCode();
        if (iPeekCachedHashCode == 0 || iPeekCachedHashCode2 == 0 || iPeekCachedHashCode == iPeekCachedHashCode2) {
            return b(byteString);
        }
        return false;
    }

    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int i11) {
        int i12 = this.leftLength;
        return i11 < i12 ? this.left.internalByteAt(i11) : this.right.internalByteAt(i11 - i12);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isBalanced() {
        return this.totalLength >= minLength(this.treeDepth);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int iPartialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        return byteString.partialIsValidUtf8(iPartialIsValidUtf8, 0, byteString.size()) == 0;
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new a();
    }

    @Override // com.google.protobuf.ByteString
    public j newCodedInput() {
        return j.h(asReadOnlyByteBufferList(), true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new d();
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i11, int i12, int i13) {
        int i14 = i12 + i13;
        int i15 = this.leftLength;
        if (i14 <= i15) {
            return this.left.partialHash(i11, i12, i13);
        }
        if (i12 >= i15) {
            return this.right.partialHash(i11, i12 - i15, i13);
        }
        int i16 = i15 - i12;
        return this.right.partialHash(this.left.partialHash(i11, i12, i16), 0, i13 - i16);
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i11, int i12, int i13) {
        int i14 = i12 + i13;
        int i15 = this.leftLength;
        if (i14 <= i15) {
            return this.left.partialIsValidUtf8(i11, i12, i13);
        }
        if (i12 >= i15) {
            return this.right.partialIsValidUtf8(i11, i12 - i15, i13);
        }
        int i16 = i15 - i12;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i11, i12, i16), 0, i13 - i16);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i11, int i12) {
        int iCheckRange = ByteString.checkRange(i11, i12, this.totalLength);
        if (iCheckRange == 0) {
            return ByteString.EMPTY;
        }
        if (iCheckRange == this.totalLength) {
            return this;
        }
        int i13 = this.leftLength;
        if (i12 <= i13) {
            return this.left.substring(i11, i12);
        }
        return i11 >= i13 ? this.right.substring(i11 - i13, i12 - i13) : new RopeByteString(this.left.substring(i11), this.right.substring(0, i12 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    public String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    public Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(i iVar) throws IOException {
        this.left.writeTo(iVar);
        this.right.writeTo(iVar);
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    @Override // com.google.protobuf.ByteString
    public void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException {
        int i13 = i11 + i12;
        int i14 = this.leftLength;
        if (i13 <= i14) {
            this.left.writeToInternal(outputStream, i11, i12);
        } else {
            if (i11 >= i14) {
                this.right.writeToInternal(outputStream, i11 - i14, i12);
                return;
            }
            int i15 = i14 - i11;
            this.left.writeToInternal(outputStream, i11, i15);
            this.right.writeToInternal(outputStream, 0, i12 - i15);
        }
    }

    @Override // com.google.protobuf.ByteString
    public void writeToReverse(i iVar) throws IOException {
        this.right.writeToReverse(iVar);
        this.left.writeToReverse(iVar);
    }
}
