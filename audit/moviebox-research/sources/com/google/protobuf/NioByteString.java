package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    /* JADX INFO: compiled from: source.java */
    public class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f41184a;

        public a() {
            this.f41184a = NioByteString.this.buffer.slice();
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f41184a.remaining();
        }

        @Override // java.io.InputStream
        public void mark(int i11) {
            this.f41184a.mark();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f41184a.hasRemaining()) {
                return this.f41184a.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) throws IOException {
            if (!this.f41184a.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i12, this.f41184a.remaining());
            this.f41184a.get(bArr, i11, iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            try {
                this.f41184a.reset();
            } catch (InvalidMarkException e11) {
                throw new IOException(e11);
            }
        }
    }

    public NioByteString(ByteBuffer byteBuffer) {
        y.b(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    public final ByteBuffer a(int i11, int i12) {
        if (i11 < this.buffer.position() || i12 > this.buffer.limit() || i11 > i12) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i11), Integer.valueOf(i12)));
        }
        ByteBuffer byteBufferSlice = this.buffer.slice();
        byteBufferSlice.position(i11 - this.buffer.position());
        byteBufferSlice.limit(i12 - this.buffer.position());
        return byteBufferSlice;
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i11) {
        try {
            return this.buffer.get(i11);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw e11;
        } catch (IndexOutOfBoundsException e12) {
            throw new ArrayIndexOutOfBoundsException(e12.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
        ByteBuffer byteBufferSlice = this.buffer.slice();
        byteBufferSlice.position(i11);
        byteBufferSlice.get(bArr, i12, i13);
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
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        return obj instanceof RopeByteString ? obj.equals(this) : this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString.LeafByteString
    public boolean equalsRange(ByteString byteString, int i11, int i12) {
        return substring(0, i12).equals(byteString.substring(i11, i12 + i11));
    }

    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int i11) {
        return byteAt(i11);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.r(this.buffer);
    }

    @Override // com.google.protobuf.ByteString
    public j newCodedInput() {
        return j.i(this.buffer, true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new a();
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i11, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + this.buffer.get(i14);
        }
        return i11;
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i11, int i12, int i13) {
        return Utf8.u(i11, this.buffer, i12, i13 + i12);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i11, int i12) {
        try {
            return new NioByteString(a(i11, i12));
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw e11;
        } catch (IndexOutOfBoundsException e12) {
            throw new ArrayIndexOutOfBoundsException(e12.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public String toStringInternal(Charset charset) {
        byte[] byteArray;
        int length;
        int iArrayOffset;
        if (this.buffer.hasArray()) {
            byteArray = this.buffer.array();
            iArrayOffset = this.buffer.arrayOffset() + this.buffer.position();
            length = this.buffer.remaining();
        } else {
            byteArray = toByteArray();
            length = byteArray.length;
            iArrayOffset = 0;
        }
        return new String(byteArray, iArrayOffset, length, charset);
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(i iVar) throws IOException {
        iVar.a(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException {
        if (!this.buffer.hasArray()) {
            h.g(a(i11, i12 + i11), outputStream);
        } else {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i11, i12);
        }
    }
}
