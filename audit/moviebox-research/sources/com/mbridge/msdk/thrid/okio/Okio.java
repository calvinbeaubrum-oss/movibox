package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Okio {
    static final Logger logger = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new Sink() { // from class: com.mbridge.msdk.thrid.okio.Okio.3
            @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // com.mbridge.msdk.thrid.okio.Sink
            public Timeout timeout() {
                return Timeout.NONE;
            }

            @Override // com.mbridge.msdk.thrid.okio.Sink
            public void write(Buffer buffer, long j11) throws IOException {
                buffer.skip(j11);
            }
        };
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    private static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (timeout != null) {
            return new Sink() { // from class: com.mbridge.msdk.thrid.okio.Okio.1
                @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                @Override // com.mbridge.msdk.thrid.okio.Sink
                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                @Override // com.mbridge.msdk.thrid.okio.Sink
                public void write(Buffer buffer, long j11) throws IOException {
                    Util.checkOffsetAndCount(buffer.size, 0L, j11);
                    while (j11 > 0) {
                        timeout.throwIfReached();
                        Segment segment = buffer.head;
                        int iMin = (int) Math.min(j11, segment.limit - segment.pos);
                        outputStream.write(segment.data, segment.pos, iMin);
                        int i11 = segment.pos + iMin;
                        segment.pos = i11;
                        long j12 = iMin;
                        j11 -= j12;
                        buffer.size -= j12;
                        if (i11 == segment.limit) {
                            buffer.head = segment.pop();
                            SegmentPool.recycle(segment);
                        }
                    }
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static Sink sink(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        AsyncTimeout asyncTimeoutTimeout = timeout(socket);
        return asyncTimeoutTimeout.sink(sink(socket.getOutputStream(), asyncTimeoutTimeout));
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    private static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (timeout != null) {
            return new Source() { // from class: com.mbridge.msdk.thrid.okio.Okio.2
                @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                @Override // com.mbridge.msdk.thrid.okio.Source
                public long read(Buffer buffer, long j11) throws IOException {
                    if (j11 < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j11);
                    }
                    if (j11 == 0) {
                        return 0L;
                    }
                    try {
                        timeout.throwIfReached();
                        Segment segmentWritableSegment = buffer.writableSegment(1);
                        int i11 = inputStream.read(segmentWritableSegment.data, segmentWritableSegment.limit, (int) Math.min(j11, 8192 - segmentWritableSegment.limit));
                        if (i11 == -1) {
                            return -1L;
                        }
                        segmentWritableSegment.limit += i11;
                        long j12 = i11;
                        buffer.size += j12;
                        return j12;
                    } catch (AssertionError e11) {
                        if (Okio.isAndroidGetsocknameError(e11)) {
                            throw new IOException(e11);
                        }
                        throw e11;
                    }
                }

                @Override // com.mbridge.msdk.thrid.okio.Source
                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static Source source(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        AsyncTimeout asyncTimeoutTimeout = timeout(socket);
        return asyncTimeoutTimeout.source(source(socket.getInputStream(), asyncTimeoutTimeout));
    }

    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    private static AsyncTimeout timeout(final Socket socket) {
        return new AsyncTimeout() { // from class: com.mbridge.msdk.thrid.okio.Okio.4
            @Override // com.mbridge.msdk.thrid.okio.AsyncTimeout
            public IOException newTimeoutException(@Nullable IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.mbridge.msdk.thrid.okio.AsyncTimeout
            public void timedOut() {
                try {
                    socket.close();
                } catch (AssertionError e11) {
                    if (!Okio.isAndroidGetsocknameError(e11)) {
                        throw e11;
                    }
                    Okio.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e11);
                } catch (Exception e12) {
                    Okio.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e12);
                }
            }
        };
    }
}
