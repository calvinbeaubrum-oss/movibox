package com.squareup.okhttp.internal.framed;

import com.google.android.gms.common.api.Api;
import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements Variant {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f49165a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f49166b = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: compiled from: source.java */
    public static final class a implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedSource f49167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f49168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte f49169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f49170d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f49171f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public short f49172g;

        public a(BufferedSource bufferedSource) {
            this.f49167a = bufferedSource;
        }

        public final void a() throws IOException {
            int i11 = this.f49170d;
            int iK = d.k(this.f49167a);
            this.f49171f = iK;
            this.f49168b = iK;
            byte b11 = (byte) (this.f49167a.readByte() & 255);
            this.f49169c = (byte) (this.f49167a.readByte() & 255);
            if (d.f49165a.isLoggable(Level.FINE)) {
                d.f49165a.fine(b.b(true, this.f49170d, this.f49168b, b11, this.f49169c));
            }
            int i12 = this.f49167a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f49170d = i12;
            if (b11 != 9) {
                throw d.i("%s != TYPE_CONTINUATION", Byte.valueOf(b11));
            }
            if (i12 != i11) {
                throw d.i("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            while (true) {
                int i11 = this.f49171f;
                if (i11 != 0) {
                    long j12 = this.f49167a.read(buffer, Math.min(j11, i11));
                    if (j12 == -1) {
                        return -1L;
                    }
                    this.f49171f = (int) (((long) this.f49171f) - j12);
                    return j12;
                }
                this.f49167a.skip(this.f49172g);
                this.f49172g = (short) 0;
                if ((this.f49169c & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f49167a.timeout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f49173a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f49174b = new String[64];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f49175c = new String[256];

        static {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                String[] strArr = f49175c;
                if (i12 >= strArr.length) {
                    break;
                }
                strArr[i12] = String.format("%8s", Integer.toBinaryString(i12)).replace(' ', '0');
                i12++;
            }
            String[] strArr2 = f49174b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            int i13 = iArr[0];
            strArr2[i13 | 8] = strArr2[i13] + "|PADDED";
            strArr2[4] = "END_HEADERS";
            strArr2[32] = "PRIORITY";
            strArr2[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i14 = 0; i14 < 3; i14++) {
                int i15 = iArr2[i14];
                int i16 = iArr[0];
                String[] strArr3 = f49174b;
                int i17 = i16 | i15;
                strArr3[i17] = strArr3[i16] + '|' + strArr3[i15];
                strArr3[i17 | 8] = strArr3[i16] + '|' + strArr3[i15] + "|PADDED";
            }
            while (true) {
                String[] strArr4 = f49174b;
                if (i11 >= strArr4.length) {
                    return;
                }
                if (strArr4[i11] == null) {
                    strArr4[i11] = f49175c[i11];
                }
                i11++;
            }
        }

        public static String a(byte b11, byte b12) {
            if (b12 == 0) {
                return "";
            }
            if (b11 != 2 && b11 != 3) {
                if (b11 == 4 || b11 == 6) {
                    return b12 == 1 ? "ACK" : f49175c[b12];
                }
                if (b11 != 7 && b11 != 8) {
                    String[] strArr = f49174b;
                    String str = b12 < strArr.length ? strArr[b12] : f49175c[b12];
                    if (b11 != 5 || (b12 & 4) == 0) {
                        return (b11 != 0 || (b12 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                    }
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f49175c[b12];
        }

        public static String b(boolean z11, int i11, int i12, byte b11, byte b12) {
            String[] strArr = f49173a;
            String str = b11 < strArr.length ? strArr[b11] : String.format("0x%02x", Byte.valueOf(b11));
            String strA = a(b11, b12);
            Object[] objArr = new Object[5];
            objArr[0] = z11 ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i11);
            objArr[2] = Integer.valueOf(i12);
            objArr[3] = str;
            objArr[4] = strA;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements FrameReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedSource f49176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f49177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f49178c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.squareup.okhttp.internal.framed.c.a f49179d;

        public c(BufferedSource bufferedSource, int i11, boolean z11) {
            this.f49176a = bufferedSource;
            this.f49178c = z11;
            a aVar = new a(bufferedSource);
            this.f49177b = aVar;
            this.f49179d = new com.squareup.okhttp.internal.framed.c.a(i11, aVar);
        }

        public final void a(FrameReader.Handler handler, int i11, byte b11, int i12) throws IOException {
            boolean z11 = (b11 & 1) != 0;
            if ((b11 & 32) != 0) {
                throw d.i("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short s11 = (b11 & 8) != 0 ? (short) (this.f49176a.readByte() & 255) : (short) 0;
            handler.data(z11, i12, this.f49176a, d.j(i11, b11, s11));
            this.f49176a.skip(s11);
        }

        public final void b(FrameReader.Handler handler, int i11, byte b11, int i12) throws IOException {
            if (i11 < 8) {
                throw d.i("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i11));
            }
            if (i12 != 0) {
                throw d.i("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int i13 = this.f49176a.readInt();
            int i14 = this.f49176a.readInt();
            int i15 = i11 - 8;
            ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i14);
            if (errorCodeFromHttp2 == null) {
                throw d.i("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i14));
            }
            ByteString byteString = ByteString.EMPTY;
            if (i15 > 0) {
                byteString = this.f49176a.readByteString(i15);
            }
            handler.goAway(i13, errorCodeFromHttp2, byteString);
        }

        public final List<com.squareup.okhttp.internal.framed.b> c(int i11, short s11, byte b11, int i12) throws IOException {
            a aVar = this.f49177b;
            aVar.f49171f = i11;
            aVar.f49168b = i11;
            aVar.f49172g = s11;
            aVar.f49169c = b11;
            aVar.f49170d = i12;
            this.f49179d.l();
            return this.f49179d.e();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f49176a.close();
        }

        public final void d(FrameReader.Handler handler, int i11, byte b11, int i12) throws IOException {
            if (i12 == 0) {
                throw d.i("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z11 = (b11 & 1) != 0;
            short s11 = (b11 & 8) != 0 ? (short) (this.f49176a.readByte() & 255) : (short) 0;
            if ((b11 & 32) != 0) {
                g(handler, i12);
                i11 -= 5;
            }
            handler.headers(false, z11, i12, -1, c(d.j(i11, b11, s11), s11, b11, i12), HeadersMode.HTTP_20_HEADERS);
        }

        public final void e(FrameReader.Handler handler, int i11, byte b11, int i12) throws IOException {
            if (i11 != 8) {
                throw d.i("TYPE_PING length != 8: %s", Integer.valueOf(i11));
            }
            if (i12 != 0) {
                throw d.i("TYPE_PING streamId != 0", new Object[0]);
            }
            handler.ping((b11 & 1) != 0, this.f49176a.readInt(), this.f49176a.readInt());
        }

        public final void g(FrameReader.Handler handler, int i11) throws IOException {
            int i12 = this.f49176a.readInt();
            handler.priority(i11, i12 & Api.BaseClientBuilder.API_PRIORITY_OTHER, (this.f49176a.readByte() & 255) + 1, (Integer.MIN_VALUE & i12) != 0);
        }

        public final void h(FrameReader.Handler handler, int i11, byte b11, int i12) throws IOException {
            if (i11 != 5) {
                throw d.i("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i11));
            }
            if (i12 == 0) {
                throw d.i("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            g(handler, i12);
        }

        public final void i(FrameReader.Handler handler, int i11, byte b11, int i12) throws IOException {
            if (i12 == 0) {
                throw d.i("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short s11 = (b11 & 8) != 0 ? (short) (this.f49176a.readByte() & 255) : (short) 0;
            handler.pushPromise(i12, this.f49176a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER, c(d.j(i11 - 4, b11, s11), s11, b11, i12));
        }

        public final void j(FrameReader.Handler handler, int i11, byte b11, int i12) throws IOException {
            if (i11 != 4) {
                throw d.i("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i11));
            }
            if (i12 == 0) {
                throw d.i("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int i13 = this.f49176a.readInt();
            ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i13);
            if (errorCodeFromHttp2 == null) {
                throw d.i("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i13));
            }
            handler.rstStream(i12, errorCodeFromHttp2);
        }

        public final void k(FrameReader.Handler handler, int i11, byte b11, int i12) throws IOException {
            if (i12 != 0) {
                throw d.i("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b11 & 1) != 0) {
                if (i11 != 0) {
                    throw d.i("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                handler.ackSettings();
                return;
            }
            if (i11 % 6 != 0) {
                throw d.i("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i11));
            }
            h hVar = new h();
            for (int i13 = 0; i13 < i11; i13 += 6) {
                short s11 = this.f49176a.readShort();
                int i14 = this.f49176a.readInt();
                switch (s11) {
                    case 1:
                    case 6:
                        break;
                    case 2:
                        if (i14 != 0 && i14 != 1) {
                            throw d.i("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        break;
                        break;
                    case 3:
                        s11 = 4;
                        break;
                    case 4:
                        if (i14 < 0) {
                            throw d.i("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        s11 = 7;
                        break;
                        break;
                    case 5:
                        if (i14 < 16384 || i14 > 16777215) {
                            throw d.i("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i14));
                        }
                        break;
                        break;
                    default:
                        throw d.i("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(s11));
                }
                hVar.l(s11, 0, i14);
            }
            handler.settings(false, hVar);
            if (hVar.d() >= 0) {
                this.f49179d.g(hVar.d());
            }
        }

        public final void l(FrameReader.Handler handler, int i11, byte b11, int i12) throws IOException {
            if (i11 != 4) {
                throw d.i("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i11));
            }
            long j11 = ((long) this.f49176a.readInt()) & 2147483647L;
            if (j11 == 0) {
                throw d.i("windowSizeIncrement was 0", Long.valueOf(j11));
            }
            handler.windowUpdate(i12, j11);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public boolean nextFrame(FrameReader.Handler handler) throws IOException {
            try {
                this.f49176a.require(9L);
                int iK = d.k(this.f49176a);
                if (iK < 0 || iK > 16384) {
                    throw d.i("FRAME_SIZE_ERROR: %s", Integer.valueOf(iK));
                }
                byte b11 = (byte) (this.f49176a.readByte() & 255);
                byte b12 = (byte) (this.f49176a.readByte() & 255);
                int i11 = this.f49176a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (d.f49165a.isLoggable(Level.FINE)) {
                    d.f49165a.fine(b.b(true, i11, iK, b11, b12));
                }
                switch (b11) {
                    case 0:
                        a(handler, iK, b12, i11);
                        return true;
                    case 1:
                        d(handler, iK, b12, i11);
                        return true;
                    case 2:
                        h(handler, iK, b12, i11);
                        return true;
                    case 3:
                        j(handler, iK, b12, i11);
                        return true;
                    case 4:
                        k(handler, iK, b12, i11);
                        return true;
                    case 5:
                        i(handler, iK, b12, i11);
                        return true;
                    case 6:
                        e(handler, iK, b12, i11);
                        return true;
                    case 7:
                        b(handler, iK, b12, i11);
                        return true;
                    case 8:
                        l(handler, iK, b12, i11);
                        return true;
                    default:
                        this.f49176a.skip(iK);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public void readConnectionPreface() throws IOException {
            if (this.f49178c) {
                return;
            }
            ByteString byteString = this.f49176a.readByteString(d.f49166b.size());
            if (d.f49165a.isLoggable(Level.FINE)) {
                d.f49165a.fine(String.format("<< CONNECTION %s", byteString.hex()));
            }
            if (!d.f49166b.equals(byteString)) {
                throw d.i("Expected a connection header but was %s", byteString.utf8());
            }
        }
    }

    /* JADX INFO: renamed from: com.squareup.okhttp.internal.framed.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0535d implements FrameWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedSink f49180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f49181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Buffer f49182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.squareup.okhttp.internal.framed.c.b f49183d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f49184f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f49185g;

        public C0535d(BufferedSink bufferedSink, boolean z11) {
            this.f49180a = bufferedSink;
            this.f49181b = z11;
            Buffer buffer = new Buffer();
            this.f49182c = buffer;
            this.f49183d = new com.squareup.okhttp.internal.framed.c.b(buffer);
            this.f49184f = 16384;
        }

        public void a(int i11, byte b11, Buffer buffer, int i12) throws IOException {
            b(i11, i12, (byte) 0, b11);
            if (i12 > 0) {
                this.f49180a.write(buffer, i12);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void ackSettings(h hVar) throws IOException {
            if (this.f49185g) {
                throw new IOException("closed");
            }
            this.f49184f = hVar.g(this.f49184f);
            b(0, 0, (byte) 4, (byte) 1);
            this.f49180a.flush();
        }

        public void b(int i11, int i12, byte b11, byte b12) throws IOException {
            if (d.f49165a.isLoggable(Level.FINE)) {
                d.f49165a.fine(b.b(false, i11, i12, b11, b12));
            }
            int i13 = this.f49184f;
            if (i12 > i13) {
                throw d.h("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i13), Integer.valueOf(i12));
            }
            if ((Integer.MIN_VALUE & i11) != 0) {
                throw d.h("reserved bit set: %s", Integer.valueOf(i11));
            }
            d.l(this.f49180a, i12);
            this.f49180a.writeByte(b11 & 255);
            this.f49180a.writeByte(b12 & 255);
            this.f49180a.writeInt(i11 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }

        public void c(boolean z11, int i11, List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
            if (this.f49185g) {
                throw new IOException("closed");
            }
            this.f49183d.b(list);
            long size = this.f49182c.size();
            int iMin = (int) Math.min(this.f49184f, size);
            long j11 = iMin;
            byte b11 = size == j11 ? (byte) 4 : (byte) 0;
            if (z11) {
                b11 = (byte) (b11 | 1);
            }
            b(i11, iMin, (byte) 1, b11);
            this.f49180a.write(this.f49182c, j11);
            if (size > j11) {
                d(i11, size - j11);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f49185g = true;
            this.f49180a.close();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void connectionPreface() throws IOException {
            try {
                if (this.f49185g) {
                    throw new IOException("closed");
                }
                if (this.f49181b) {
                    if (d.f49165a.isLoggable(Level.FINE)) {
                        d.f49165a.fine(String.format(">> CONNECTION %s", d.f49166b.hex()));
                    }
                    this.f49180a.write(d.f49166b.toByteArray());
                    this.f49180a.flush();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }

        public final void d(int i11, long j11) throws IOException {
            while (j11 > 0) {
                int iMin = (int) Math.min(this.f49184f, j11);
                long j12 = iMin;
                j11 -= j12;
                b(i11, iMin, (byte) 9, j11 == 0 ? (byte) 4 : (byte) 0);
                this.f49180a.write(this.f49182c, j12);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void data(boolean z11, int i11, Buffer buffer, int i12) throws IOException {
            if (this.f49185g) {
                throw new IOException("closed");
            }
            a(i11, z11 ? (byte) 1 : (byte) 0, buffer, i12);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void flush() throws IOException {
            if (this.f49185g) {
                throw new IOException("closed");
            }
            this.f49180a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void goAway(int i11, ErrorCode errorCode, byte[] bArr) throws IOException {
            try {
                if (this.f49185g) {
                    throw new IOException("closed");
                }
                if (errorCode.httpCode == -1) {
                    throw d.h("errorCode.httpCode == -1", new Object[0]);
                }
                b(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f49180a.writeInt(i11);
                this.f49180a.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.f49180a.write(bArr);
                }
                this.f49180a.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void headers(int i11, List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
            if (this.f49185g) {
                throw new IOException("closed");
            }
            c(false, i11, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public int maxDataLength() {
            return this.f49184f;
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void ping(boolean z11, int i11, int i12) throws IOException {
            if (this.f49185g) {
                throw new IOException("closed");
            }
            b(0, 8, (byte) 6, z11 ? (byte) 1 : (byte) 0);
            this.f49180a.writeInt(i11);
            this.f49180a.writeInt(i12);
            this.f49180a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void pushPromise(int i11, int i12, List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
            if (this.f49185g) {
                throw new IOException("closed");
            }
            this.f49183d.b(list);
            long size = this.f49182c.size();
            int iMin = (int) Math.min(this.f49184f - 4, size);
            long j11 = iMin;
            b(i11, iMin + 4, (byte) 5, size == j11 ? (byte) 4 : (byte) 0);
            this.f49180a.writeInt(i12 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f49180a.write(this.f49182c, j11);
            if (size > j11) {
                d(i11, size - j11);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void rstStream(int i11, ErrorCode errorCode) throws IOException {
            if (this.f49185g) {
                throw new IOException("closed");
            }
            if (errorCode.httpCode == -1) {
                throw new IllegalArgumentException();
            }
            b(i11, 4, (byte) 3, (byte) 0);
            this.f49180a.writeInt(errorCode.httpCode);
            this.f49180a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void settings(h hVar) throws IOException {
            int i11;
            try {
                if (this.f49185g) {
                    throw new IOException("closed");
                }
                int i12 = 0;
                b(0, hVar.m() * 6, (byte) 4, (byte) 0);
                while (i12 < 10) {
                    if (hVar.i(i12)) {
                        if (i12 == 4) {
                            i11 = 3;
                        } else {
                            i11 = i12 == 7 ? 4 : i12;
                        }
                        this.f49180a.writeShort(i11);
                        this.f49180a.writeInt(hVar.c(i12));
                    }
                    i12++;
                }
                this.f49180a.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synReply(boolean z11, int i11, List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
            if (this.f49185g) {
                throw new IOException("closed");
            }
            c(z11, i11, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synStream(boolean z11, boolean z12, int i11, int i12, List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
            try {
                if (z12) {
                    throw new UnsupportedOperationException();
                }
                if (this.f49185g) {
                    throw new IOException("closed");
                }
                c(z11, i11, list);
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void windowUpdate(int i11, long j11) throws IOException {
            if (this.f49185g) {
                throw new IOException("closed");
            }
            if (j11 == 0 || j11 > 2147483647L) {
                throw d.h("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j11));
            }
            b(i11, 4, (byte) 8, (byte) 0);
            this.f49180a.writeInt((int) j11);
            this.f49180a.flush();
        }
    }

    public static IllegalArgumentException h(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static IOException i(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    public static int j(int i11, byte b11, short s11) throws IOException {
        if ((b11 & 8) != 0) {
            i11--;
        }
        if (s11 <= i11) {
            return (short) (i11 - s11);
        }
        throw i("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s11), Integer.valueOf(i11));
    }

    public static int k(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    public static void l(BufferedSink bufferedSink, int i11) throws IOException {
        bufferedSink.writeByte((i11 >>> 16) & 255);
        bufferedSink.writeByte((i11 >>> 8) & 255);
        bufferedSink.writeByte(i11 & 255);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameReader newReader(BufferedSource bufferedSource, boolean z11) {
        return new c(bufferedSource, 4096, z11);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameWriter newWriter(BufferedSink bufferedSink, boolean z11) {
        return new C0535d(bufferedSink, z11);
    }
}
