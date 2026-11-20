package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InflaterSource f49193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferedSource f49195c;

    /* JADX INFO: compiled from: source.java */
    public class a extends ForwardingSource {
        public a(Source source) {
            super(source);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            if (f.this.f49194b == 0) {
                return -1L;
            }
            long j12 = super.read(buffer, Math.min(j11, f.this.f49194b));
            if (j12 == -1) {
                return -1L;
            }
            f fVar = f.this;
            fVar.f49194b = (int) (((long) fVar.f49194b) - j12);
            return j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends Inflater {
        public b() {
        }

        @Override // java.util.zip.Inflater
        public int inflate(byte[] bArr, int i11, int i12) throws DataFormatException {
            int iInflate = super.inflate(bArr, i11, i12);
            if (iInflate != 0 || !needsDictionary()) {
                return iInflate;
            }
            setDictionary(i.f49205a);
            return super.inflate(bArr, i11, i12);
        }
    }

    public f(BufferedSource bufferedSource) {
        InflaterSource inflaterSource = new InflaterSource(new a(bufferedSource), new b());
        this.f49193a = inflaterSource;
        this.f49195c = Okio.buffer(inflaterSource);
    }

    public void c() throws IOException {
        this.f49195c.close();
    }

    public final void d() throws IOException {
        if (this.f49194b > 0) {
            this.f49193a.refill();
            if (this.f49194b == 0) {
                return;
            }
            throw new IOException("compressedLimit > 0: " + this.f49194b);
        }
    }

    public final ByteString e() throws IOException {
        return this.f49195c.readByteString(this.f49195c.readInt());
    }

    public List<com.squareup.okhttp.internal.framed.b> f(int i11) throws IOException {
        this.f49194b += i11;
        int i12 = this.f49195c.readInt();
        if (i12 < 0) {
            throw new IOException("numberOfPairs < 0: " + i12);
        }
        if (i12 > 1024) {
            throw new IOException("numberOfPairs > 1024: " + i12);
        }
        ArrayList arrayList = new ArrayList(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            ByteString asciiLowercase = e().toAsciiLowercase();
            ByteString byteStringE = e();
            if (asciiLowercase.size() == 0) {
                throw new IOException("name.size == 0");
            }
            arrayList.add(new com.squareup.okhttp.internal.framed.b(asciiLowercase, byteStringE));
        }
        d();
        return arrayList;
    }
}
