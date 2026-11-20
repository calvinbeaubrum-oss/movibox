package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Source;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final BufferedSource source;

    /* JADX INFO: compiled from: source.java */
    public static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        private void readContinuationHeader() throws IOException {
            int i11 = this.streamId;
            int medium = Http2Reader.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            byte b11 = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            Logger logger = Http2Reader.logger;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(true, this.streamId, this.length, b11, this.flags));
            }
            int i12 = this.source.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.streamId = i12;
            if (b11 != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(b11));
            }
            if (i12 != i11) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            while (true) {
                int i11 = this.left;
                if (i11 != 0) {
                    long j12 = this.source.read(buffer, Math.min(j11, i11));
                    if (j12 == -1) {
                        return -1L;
                    }
                    this.left = (int) (((long) this.left) - j12);
                    return j12;
                }
                this.source.skip(this.padding);
                this.padding = (short) 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface Handler {
        void ackSettings();

        void alternateService(int i11, String str, ByteString byteString, String str2, int i12, long j11);

        void data(boolean z11, int i11, BufferedSource bufferedSource, int i12) throws IOException;

        void goAway(int i11, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z11, int i11, int i12, List<Header> list);

        void ping(boolean z11, int i11, int i12);

        void priority(int i11, int i12, int i13, boolean z11);

        void pushPromise(int i11, int i12, List<Header> list) throws IOException;

        void rstStream(int i11, ErrorCode errorCode);

        void settings(boolean z11, Settings settings);

        void windowUpdate(int i11, long j11);
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z11) {
        this.source = bufferedSource;
        this.client = z11;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(4096, continuationSource);
    }

    public static int lengthWithoutPadding(int i11, byte b11, short s11) throws IOException {
        if ((b11 & 8) != 0) {
            i11--;
        }
        if (s11 <= i11) {
            return (short) (i11 - s11);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s11), Integer.valueOf(i11));
    }

    private void readData(Handler handler, int i11, byte b11, int i12) throws IOException {
        if (i12 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z11 = (b11 & 1) != 0;
        if ((b11 & 32) != 0) {
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s11 = (b11 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.data(z11, i12, this.source, lengthWithoutPadding(i11, b11, s11));
        this.source.skip(s11);
    }

    private void readGoAway(Handler handler, int i11, byte b11, int i12) throws IOException {
        if (i11 < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i11));
        }
        if (i12 != 0) {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i13 = this.source.readInt();
        int i14 = this.source.readInt();
        int i15 = i11 - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i14);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i14));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i15 > 0) {
            byteString = this.source.readByteString(i15);
        }
        handler.goAway(i13, errorCodeFromHttp2, byteString);
    }

    private List<Header> readHeaderBlock(int i11, short s11, byte b11, int i12) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i11;
        continuationSource.length = i11;
        continuationSource.padding = s11;
        continuationSource.flags = b11;
        continuationSource.streamId = i12;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readHeaders(Handler handler, int i11, byte b11, int i12) throws IOException {
        if (i12 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z11 = (b11 & 1) != 0;
        short s11 = (b11 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        if ((b11 & 32) != 0) {
            readPriority(handler, i12);
            i11 -= 5;
        }
        handler.headers(z11, i12, -1, readHeaderBlock(lengthWithoutPadding(i11, b11, s11), s11, b11, i12));
    }

    public static int readMedium(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private void readPing(Handler handler, int i11, byte b11, int i12) throws IOException {
        if (i11 != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i11));
        }
        if (i12 != 0) {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.ping((b11 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private void readPriority(Handler handler, int i11) throws IOException {
        int i12 = this.source.readInt();
        handler.priority(i11, i12 & Api.BaseClientBuilder.API_PRIORITY_OTHER, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & i12) != 0);
    }

    private void readPriority(Handler handler, int i11, byte b11, int i12) throws IOException {
        if (i11 != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i11));
        }
        if (i12 == 0) {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        readPriority(handler, i12);
    }

    private void readPushPromise(Handler handler, int i11, byte b11, int i12) throws IOException {
        if (i12 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s11 = (b11 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.pushPromise(i12, this.source.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER, readHeaderBlock(lengthWithoutPadding(i11 - 4, b11, s11), s11, b11, i12));
    }

    private void readRstStream(Handler handler, int i11, byte b11, int i12) throws IOException {
        if (i11 != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i11));
        }
        if (i12 == 0) {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i13 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i13);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i13));
        }
        handler.rstStream(i12, errorCodeFromHttp2);
    }

    private void readSettings(Handler handler, int i11, byte b11, int i12) throws IOException {
        if (i12 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b11 & 1) != 0) {
            if (i11 != 0) {
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
            return;
        }
        if (i11 % 6 != 0) {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i11));
        }
        Settings settings = new Settings();
        for (int i13 = 0; i13 < i11; i13 += 6) {
            int i14 = this.source.readShort() & 65535;
            int i15 = this.source.readInt();
            if (i14 == 2) {
                if (i15 != 0 && i15 != 1) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (i14 == 3) {
                i14 = 4;
            } else if (i14 != 4) {
                if (i14 == 5 && (i15 < 16384 || i15 > 16777215)) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i15));
                }
            } else {
                if (i15 < 0) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                i14 = 7;
            }
            settings.set(i14, i15);
        }
        handler.settings(false, settings);
    }

    private void readWindowUpdate(Handler handler, int i11, byte b11, int i12) throws IOException {
        if (i11 != 4) {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i11));
        }
        long j11 = ((long) this.source.readInt()) & 2147483647L;
        if (j11 == 0) {
            throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(j11));
        }
        handler.windowUpdate(i12, j11);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public boolean nextFrame(boolean z11, Handler handler) throws IOException {
        try {
            this.source.require(9L);
            int medium = readMedium(this.source);
            if (medium < 0 || medium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(medium));
            }
            byte b11 = (byte) (this.source.readByte() & 255);
            if (z11 && b11 != 4) {
                throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(b11));
            }
            byte b12 = (byte) (this.source.readByte() & 255);
            int i11 = this.source.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.frameLog(true, i11, medium, b11, b12));
            }
            switch (b11) {
                case 0:
                    readData(handler, medium, b12, i11);
                    return true;
                case 1:
                    readHeaders(handler, medium, b12, i11);
                    return true;
                case 2:
                    readPriority(handler, medium, b12, i11);
                    return true;
                case 3:
                    readRstStream(handler, medium, b12, i11);
                    return true;
                case 4:
                    readSettings(handler, medium, b12, i11);
                    return true;
                case 5:
                    readPushPromise(handler, medium, b12, i11);
                    return true;
                case 6:
                    readPing(handler, medium, b12, i11);
                    return true;
                case 7:
                    readGoAway(handler, medium, b12, i11);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, b12, i11);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        BufferedSource bufferedSource = this.source;
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString byteString2 = bufferedSource.readByteString(byteString.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format("<< CONNECTION %s", byteString2.hex()));
        }
        if (!byteString.equals(byteString2)) {
            throw Http2.ioException("Expected a connection header but was %s", byteString2.utf8());
        }
    }
}
