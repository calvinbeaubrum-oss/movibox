package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new LiteralByteString(y.f41437c);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    private static final d byteArrayCopier;
    private int hash = 0;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public BoundedByteString(byte[] bArr, int i11, int i12) {
            super(bArr);
            ByteString.checkRange(i11, i11 + i12, bArr.length);
            this.bytesOffset = i11;
            this.bytesLength = i12;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte byteAt(int i11) {
            ByteString.checkIndex(i11, size());
            return this.bytes[this.bytesOffset + i11];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i11, bArr, i12, i13);
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte internalByteAt(int i11) {
            return this.bytes[this.bytesOffset + i11];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        public Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class LeafByteString extends ByteString {
        public abstract boolean equalsRange(ByteString byteString, int i11, int i12);

        @Override // com.google.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator2();
        }

        @Override // com.google.protobuf.ByteString
        public void writeToReverse(i iVar) throws IOException {
            writeTo(iVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int i11) {
            return this.bytes[i11];
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
            System.arraycopy(this.bytes, i11, bArr, i12, i13);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int iPeekCachedHashCode = peekCachedHashCode();
            int iPeekCachedHashCode2 = literalByteString.peekCachedHashCode();
            if (iPeekCachedHashCode == 0 || iPeekCachedHashCode2 == 0 || iPeekCachedHashCode == iPeekCachedHashCode2) {
                return equalsRange(literalByteString, 0, size());
            }
            return false;
        }

        @Override // com.google.protobuf.ByteString.LeafByteString
        public final boolean equalsRange(ByteString byteString, int i11, int i12) {
            if (i12 > byteString.size()) {
                throw new IllegalArgumentException("Length too large: " + i12 + size());
            }
            int i13 = i11 + i12;
            if (i13 > byteString.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i11 + ", " + i12 + ", " + byteString.size());
            }
            if (!(byteString instanceof LiteralByteString)) {
                return byteString.substring(i11, i13).equals(substring(0, i12));
            }
            LiteralByteString literalByteString = (LiteralByteString) byteString;
            byte[] bArr = this.bytes;
            byte[] bArr2 = literalByteString.bytes;
            int offsetIntoBytes = getOffsetIntoBytes() + i12;
            int offsetIntoBytes2 = getOffsetIntoBytes();
            int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i11;
            while (offsetIntoBytes2 < offsetIntoBytes) {
                if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                    return false;
                }
                offsetIntoBytes2++;
                offsetIntoBytes3++;
            }
            return true;
        }

        public int getOffsetIntoBytes() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public byte internalByteAt(int i11) {
            return this.bytes[i11];
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.t(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        @Override // com.google.protobuf.ByteString
        public final j newCodedInput() {
            return j.l(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final int partialHash(int i11, int i12, int i13) {
            return y.i(i11, this.bytes, getOffsetIntoBytes() + i12, i13);
        }

        @Override // com.google.protobuf.ByteString
        public final int partialIsValidUtf8(int i11, int i12, int i13) {
            int offsetIntoBytes = getOffsetIntoBytes() + i12;
            return Utf8.v(i11, this.bytes, offsetIntoBytes, i13 + offsetIntoBytes);
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int i11, int i12) {
            int iCheckRange = ByteString.checkRange(i11, i12, size());
            return iCheckRange == 0 ? ByteString.EMPTY : new BoundedByteString(this.bytes, getOffsetIntoBytes() + i11, iCheckRange);
        }

        @Override // com.google.protobuf.ByteString
        public final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(i iVar) throws IOException {
            iVar.b(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // com.google.protobuf.ByteString
        public final void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + i11, i12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41143a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41144b;

        public a() {
            this.f41144b = ByteString.this.size();
        }

        @Override // com.google.protobuf.ByteString.e
        public byte e() {
            int i11 = this.f41143a;
            if (i11 >= this.f41144b) {
                throw new NoSuchElementException();
            }
            this.f41143a = i11 + 1;
            return ByteString.this.internalByteAt(i11);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41143a < this.f41144b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class b implements e {
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(e());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class c implements d {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.google.protobuf.ByteString.d
        public byte[] a(byte[] bArr, int i11, int i12) {
            return Arrays.copyOfRange(bArr, i11, i12 + i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public interface d {
        byte[] a(byte[] bArr, int i11, int i12);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public interface e extends Iterator<Byte> {
        byte e();
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CodedOutputStream f41146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f41147b;

        public f(int i11) {
            byte[] bArr = new byte[i11];
            this.f41147b = bArr;
            this.f41146a = CodedOutputStream.e0(bArr);
        }

        public /* synthetic */ f(int i11, a aVar) {
            this(i11);
        }

        public ByteString a() {
            this.f41146a.d();
            return new LiteralByteString(this.f41147b);
        }

        public CodedOutputStream b() {
            return this.f41146a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class g extends OutputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final byte[] f41148g = new byte[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<ByteString> f41150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f41152d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f41153f;

        public g(int i11) {
            if (i11 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.f41149a = i11;
            this.f41150b = new ArrayList<>();
            this.f41152d = new byte[i11];
        }

        public final void a(int i11) {
            this.f41150b.add(new LiteralByteString(this.f41152d));
            int length = this.f41151c + this.f41152d.length;
            this.f41151c = length;
            this.f41152d = new byte[Math.max(this.f41149a, Math.max(i11, length >>> 1))];
            this.f41153f = 0;
        }

        public synchronized int b() {
            return this.f41151c + this.f41153f;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i11) {
            try {
                if (this.f41153f == this.f41152d.length) {
                    a(1);
                }
                byte[] bArr = this.f41152d;
                int i12 = this.f41153f;
                this.f41153f = i12 + 1;
                bArr[i12] = (byte) i11;
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i11, int i12) {
            try {
                byte[] bArr2 = this.f41152d;
                int length = bArr2.length;
                int i13 = this.f41153f;
                if (i12 <= length - i13) {
                    System.arraycopy(bArr, i11, bArr2, i13, i12);
                    this.f41153f += i12;
                } else {
                    int length2 = bArr2.length - i13;
                    System.arraycopy(bArr, i11, bArr2, i13, length2);
                    int i14 = i12 - length2;
                    a(i14);
                    System.arraycopy(bArr, i11 + length2, this.f41152d, 0, i14);
                    this.f41153f = i14;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class h implements d {
        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        @Override // com.google.protobuf.ByteString.d
        public byte[] a(byte[] bArr, int i11, int i12) {
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            return bArr2;
        }
    }

    static {
        a aVar = null;
        byteArrayCopier = com.google.protobuf.d.c() ? new h(aVar) : new c(aVar);
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() { // from class: com.google.protobuf.ByteString.2
            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.protobuf.ByteString$e, java.util.Iterator] */
            /* JADX WARN: Type inference failed for: r1v0, types: [com.google.protobuf.ByteString$e, java.util.Iterator] */
            @Override // java.util.Comparator
            public int compare(ByteString byteString, ByteString byteString2) {
                ?? Iterator2 = byteString.iterator2();
                ?? Iterator3 = byteString2.iterator2();
                while (Iterator2.hasNext() && Iterator3.hasNext()) {
                    int iCompare = Integer.compare(ByteString.toInt(Iterator2.e()), ByteString.toInt(Iterator3.e()));
                    if (iCompare != 0) {
                        return iCompare;
                    }
                }
                return Integer.compare(byteString.size(), byteString2.size());
            }
        };
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i11) {
        if (i11 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i11)));
        }
        if (i11 == 1) {
            return it.next();
        }
        int i12 = i11 >>> 1;
        return balancedConcat(it, i12).concat(balancedConcat(it, i11 - i12));
    }

    public static void checkIndex(int i11, int i12) {
        if (((i12 - (i11 + 1)) | i11) < 0) {
            if (i11 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i11);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i11 + ", " + i12);
        }
    }

    public static int checkRange(int i11, int i12, int i13) {
        int i14 = i12 - i11;
        if ((i11 | i12 | i14 | (i13 - i12)) >= 0) {
            return i14;
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i11 + " < 0");
        }
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i11 + ", " + i12);
        }
        throw new IndexOutOfBoundsException("End index: " + i12 + " >= " + i13);
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            Iterator<ByteString> it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? EMPTY : balancedConcat(iterable.iterator(), size);
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i11) {
        checkRange(0, i11, byteBuffer.remaining());
        byte[] bArr = new byte[i11];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString copyFrom(byte[] bArr, int i11, int i12) {
        checkRange(i11, i11 + i12, bArr.length);
        return new LiteralByteString(byteArrayCopier.a(bArr, i11, i12));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(y.f41435a));
    }

    public static f newCodedBuilder(int i11) {
        return new f(i11, null);
    }

    public static g newOutput() {
        return new g(128);
    }

    public static g newOutput(int i11) {
        return new g(i11);
    }

    private static ByteString readChunk(InputStream inputStream, int i11) throws IOException {
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (i12 < i11) {
            int i13 = inputStream.read(bArr, i12, i11 - i12);
            if (i13 == -1) {
                break;
            }
            i12 += i13;
        }
        if (i12 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i12);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    public static ByteString readFrom(InputStream inputStream, int i11) throws IOException {
        return readFrom(inputStream, i11, i11);
    }

    public static ByteString readFrom(InputStream inputStream, int i11, int i12) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString chunk = readChunk(inputStream, i11);
            if (chunk == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(chunk);
            i11 = Math.min(i11 * 2, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int toInt(byte b11) {
        return b11 & 255;
    }

    private String truncateAndEscapeForDisplay() {
        if (size() <= 50) {
            return g1.a(this);
        }
        return g1.a(substring(0, 47)) + "...";
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public static ByteString wrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public static ByteString wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public static ByteString wrap(byte[] bArr, int i11, int i12) {
        return new BoundedByteString(bArr, i11, i12);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i11);

    public final ByteString concat(ByteString byteString) {
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - size() >= byteString.size()) {
            return RopeByteString.concatenate(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i11) {
        copyTo(bArr, 0, i11, size());
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i11, int i12, int i13) {
        checkRange(i11, i11 + i13, size());
        checkRange(i12, i12 + i13, bArr.length);
        if (i13 > 0) {
            copyToInternal(bArr, i11, i12, i13);
        }
    }

    public abstract void copyToInternal(byte[] bArr, int i11, int i12, int i13);

    public final boolean endsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString);
    }

    public abstract boolean equals(Object obj);

    public abstract int getTreeDepth();

    public final int hashCode() {
        int iPartialHash = this.hash;
        if (iPartialHash == 0) {
            int size = size();
            iPartialHash = partialHash(size, 0, size);
            if (iPartialHash == 0) {
                iPartialHash = 1;
            }
            this.hash = iPartialHash;
        }
        return iPartialHash;
    }

    public abstract byte internalByteAt(int i11);

    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Byte> iterator2() {
        return new a();
    }

    public abstract j newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int i11, int i12, int i13);

    public abstract int partialIsValidUtf8(int i11, int i12, int i13);

    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(0, byteString.size()).equals(byteString);
    }

    public final ByteString substring(int i11) {
        return substring(i11, size());
    }

    public abstract ByteString substring(int i11, int i12);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return y.f41437c;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay());
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e11) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e11);
            throw unsupportedEncodingException;
        }
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    public abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(y.f41435a);
    }

    public abstract void writeTo(i iVar) throws IOException;

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public final void writeTo(OutputStream outputStream, int i11, int i12) throws IOException {
        checkRange(i11, i11 + i12, size());
        if (i12 > 0) {
            writeToInternal(outputStream, i11, i12);
        }
    }

    public abstract void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException;

    public abstract void writeToReverse(i iVar) throws IOException;
}
