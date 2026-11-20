package com.squareup.okhttp.internal.framed;

import com.google.android.gms.common.api.Api;
import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okhttp3.internal.http2.Settings;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements Variant {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f49205a;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements FrameReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedSource f49206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f49207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f f49208c;

        public a(BufferedSource bufferedSource, boolean z11) {
            this.f49206a = bufferedSource;
            this.f49208c = new f(bufferedSource);
            this.f49207b = z11;
        }

        public static IOException a(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        public final void b(FrameReader.Handler handler, int i11, int i12) throws IOException {
            if (i12 != 8) {
                throw a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i12));
            }
            int i13 = this.f49206a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i14 = this.f49206a.readInt();
            ErrorCode errorCodeFromSpdyGoAway = ErrorCode.fromSpdyGoAway(i14);
            if (errorCodeFromSpdyGoAway == null) {
                throw a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i14));
            }
            handler.goAway(i13, errorCodeFromSpdyGoAway, ByteString.EMPTY);
        }

        public final void c(FrameReader.Handler handler, int i11, int i12) throws IOException {
            handler.headers(false, false, this.f49206a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER, -1, this.f49208c.f(i12 - 4), HeadersMode.SPDY_HEADERS);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f49208c.c();
        }

        public final void d(FrameReader.Handler handler, int i11, int i12) throws IOException {
            if (i12 != 4) {
                throw a("TYPE_PING length: %d != 4", Integer.valueOf(i12));
            }
            int i13 = this.f49206a.readInt();
            handler.ping(this.f49207b == ((i13 & 1) == 1), i13, 0);
        }

        public final void e(FrameReader.Handler handler, int i11, int i12) throws IOException {
            if (i12 != 8) {
                throw a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i12));
            }
            int i13 = this.f49206a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i14 = this.f49206a.readInt();
            ErrorCode errorCodeFromSpdy3Rst = ErrorCode.fromSpdy3Rst(i14);
            if (errorCodeFromSpdy3Rst == null) {
                throw a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i14));
            }
            handler.rstStream(i13, errorCodeFromSpdy3Rst);
        }

        public final void g(FrameReader.Handler handler, int i11, int i12) throws IOException {
            int i13 = this.f49206a.readInt();
            if (i12 != (i13 * 8) + 4) {
                throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i12), Integer.valueOf(i13));
            }
            h hVar = new h();
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = this.f49206a.readInt();
                hVar.l(i15 & 16777215, ((-16777216) & i15) >>> 24, this.f49206a.readInt());
            }
            handler.settings((i11 & 1) != 0, hVar);
        }

        public final void h(FrameReader.Handler handler, int i11, int i12) throws IOException {
            handler.headers(false, (i11 & 1) != 0, this.f49206a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER, -1, this.f49208c.f(i12 - 4), HeadersMode.SPDY_REPLY);
        }

        public final void i(FrameReader.Handler handler, int i11, int i12) throws IOException {
            int i13 = this.f49206a.readInt();
            int i14 = this.f49206a.readInt();
            int i15 = i13 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i16 = i14 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f49206a.readShort();
            handler.headers((i11 & 2) != 0, (i11 & 1) != 0, i15, i16, this.f49208c.f(i12 - 10), HeadersMode.SPDY_SYN_STREAM);
        }

        public final void j(FrameReader.Handler handler, int i11, int i12) throws IOException {
            if (i12 != 8) {
                throw a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i12));
            }
            int i13 = this.f49206a.readInt();
            int i14 = this.f49206a.readInt();
            int i15 = i13 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            long j11 = i14 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (j11 == 0) {
                throw a("windowSizeIncrement was 0", Long.valueOf(j11));
            }
            handler.windowUpdate(i15, j11);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public boolean nextFrame(FrameReader.Handler handler) throws IOException {
            try {
                int i11 = this.f49206a.readInt();
                int i12 = this.f49206a.readInt();
                int i13 = ((-16777216) & i12) >>> 24;
                int i14 = i12 & 16777215;
                if (!((Integer.MIN_VALUE & i11) != 0)) {
                    handler.data((i13 & 1) != 0, i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER, this.f49206a, i14);
                    return true;
                }
                int i15 = (2147418112 & i11) >>> 16;
                int i16 = i11 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
                if (i15 != 3) {
                    throw new ProtocolException("version != 3: " + i15);
                }
                switch (i16) {
                    case 1:
                        i(handler, i13, i14);
                        return true;
                    case 2:
                        h(handler, i13, i14);
                        return true;
                    case 3:
                        e(handler, i13, i14);
                        return true;
                    case 4:
                        g(handler, i13, i14);
                        return true;
                    case 5:
                    default:
                        this.f49206a.skip(i14);
                        return true;
                    case 6:
                        d(handler, i13, i14);
                        return true;
                    case 7:
                        b(handler, i13, i14);
                        return true;
                    case 8:
                        c(handler, i13, i14);
                        return true;
                    case 9:
                        j(handler, i13, i14);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public void readConnectionPreface() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements FrameWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedSink f49209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Buffer f49210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BufferedSink f49211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f49212d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f49213f;

        public b(BufferedSink bufferedSink, boolean z11) {
            this.f49209a = bufferedSink;
            this.f49212d = z11;
            Deflater deflater = new Deflater();
            deflater.setDictionary(i.f49205a);
            Buffer buffer = new Buffer();
            this.f49210b = buffer;
            this.f49211c = Okio.buffer(new DeflaterSink((Sink) buffer, deflater));
        }

        public void a(int i11, int i12, Buffer buffer, int i13) throws IOException {
            if (this.f49213f) {
                throw new IOException("closed");
            }
            long j11 = i13;
            if (j11 > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i13);
            }
            this.f49209a.writeInt(i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f49209a.writeInt(((i12 & 255) << 24) | (16777215 & i13));
            if (i13 > 0) {
                this.f49209a.write(buffer, j11);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public void ackSettings(h hVar) {
        }

        public final void b(List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
            this.f49211c.writeInt(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                ByteString byteString = list.get(i11).f49151a;
                this.f49211c.writeInt(byteString.size());
                this.f49211c.write(byteString);
                ByteString byteString2 = list.get(i11).f49152b;
                this.f49211c.writeInt(byteString2.size());
                this.f49211c.write(byteString2);
            }
            this.f49211c.flush();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f49213f = true;
            com.squareup.okhttp.internal.g.b(this.f49209a, this.f49211c);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void connectionPreface() {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void data(boolean z11, int i11, Buffer buffer, int i12) throws IOException {
            a(i11, z11 ? 1 : 0, buffer, i12);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void flush() throws IOException {
            if (this.f49213f) {
                throw new IOException("closed");
            }
            this.f49209a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void goAway(int i11, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.f49213f) {
                throw new IOException("closed");
            }
            if (errorCode.spdyGoAwayCode == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
            this.f49209a.writeInt(-2147287033);
            this.f49209a.writeInt(8);
            this.f49209a.writeInt(i11);
            this.f49209a.writeInt(errorCode.spdyGoAwayCode);
            this.f49209a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void headers(int i11, List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
            if (this.f49213f) {
                throw new IOException("closed");
            }
            b(list);
            int size = (int) (this.f49210b.size() + 4);
            this.f49209a.writeInt(-2147287032);
            this.f49209a.writeInt(size & 16777215);
            this.f49209a.writeInt(i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f49209a.writeAll(this.f49210b);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public int maxDataLength() {
            return 16383;
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void ping(boolean z11, int i11, int i12) throws IOException {
            if (this.f49213f) {
                throw new IOException("closed");
            }
            if (z11 != (this.f49212d != ((i11 & 1) == 1))) {
                throw new IllegalArgumentException("payload != reply");
            }
            this.f49209a.writeInt(-2147287034);
            this.f49209a.writeInt(4);
            this.f49209a.writeInt(i11);
            this.f49209a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public void pushPromise(int i11, int i12, List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void rstStream(int i11, ErrorCode errorCode) throws IOException {
            if (this.f49213f) {
                throw new IOException("closed");
            }
            if (errorCode.spdyRstCode == -1) {
                throw new IllegalArgumentException();
            }
            this.f49209a.writeInt(-2147287037);
            this.f49209a.writeInt(8);
            this.f49209a.writeInt(i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f49209a.writeInt(errorCode.spdyRstCode);
            this.f49209a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void settings(h hVar) throws IOException {
            try {
                if (this.f49213f) {
                    throw new IOException("closed");
                }
                int iM = hVar.m();
                this.f49209a.writeInt(-2147287036);
                this.f49209a.writeInt(((iM * 8) + 4) & 16777215);
                this.f49209a.writeInt(iM);
                for (int i11 = 0; i11 <= 10; i11++) {
                    if (hVar.i(i11)) {
                        this.f49209a.writeInt(((hVar.b(i11) & 255) << 24) | (i11 & 16777215));
                        this.f49209a.writeInt(hVar.c(i11));
                    }
                }
                this.f49209a.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synReply(boolean z11, int i11, List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
            if (this.f49213f) {
                throw new IOException("closed");
            }
            b(list);
            int size = (int) (this.f49210b.size() + 4);
            this.f49209a.writeInt(-2147287038);
            this.f49209a.writeInt((((z11 ? 1 : 0) & 255) << 24) | (size & 16777215));
            this.f49209a.writeInt(i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f49209a.writeAll(this.f49210b);
            this.f49209a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synStream(boolean z11, boolean z12, int i11, int i12, List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
            if (this.f49213f) {
                throw new IOException("closed");
            }
            b(list);
            int size = (int) (this.f49210b.size() + 10);
            int i13 = (z11 ? 1 : 0) | (z12 ? 2 : 0);
            this.f49209a.writeInt(-2147287039);
            this.f49209a.writeInt(((i13 & 255) << 24) | (size & 16777215));
            this.f49209a.writeInt(i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f49209a.writeInt(Integer.MAX_VALUE & i12);
            this.f49209a.writeShort(0);
            this.f49209a.writeAll(this.f49210b);
            this.f49209a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void windowUpdate(int i11, long j11) throws IOException {
            if (this.f49213f) {
                throw new IOException("closed");
            }
            if (j11 == 0 || j11 > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j11);
            }
            this.f49209a.writeInt(-2147287031);
            this.f49209a.writeInt(8);
            this.f49209a.writeInt(i11);
            this.f49209a.writeInt((int) j11);
            this.f49209a.flush();
        }
    }

    static {
        try {
            f49205a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(com.squareup.okhttp.internal.g.f49216c.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public Protocol getProtocol() {
        return Protocol.SPDY_3;
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameReader newReader(BufferedSource bufferedSource, boolean z11) {
        return new a(bufferedSource, z11);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameWriter newWriter(BufferedSink bufferedSink, boolean z11) {
        return new b(bufferedSink, z11);
    }
}
