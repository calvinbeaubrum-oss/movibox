package com.mbridge.msdk.thrid.okhttp.internal.cache2;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Source;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    long upstreamPos;
    Thread upstreamReader;
    final Buffer upstreamBuffer = new Buffer();
    final Buffer buffer = new Buffer();

    /* JADX INFO: compiled from: source.java */
    public class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                try {
                    Relay relay = Relay.this;
                    int i11 = relay.sourceCount - 1;
                    relay.sourceCount = i11;
                    if (i11 == 0) {
                        RandomAccessFile randomAccessFile2 = relay.file;
                        relay.file = null;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public long read(Buffer buffer, long j11) throws IOException {
            Relay relay;
            if (this.fileOperator == null) {
                throw new IllegalStateException("closed");
            }
            synchronized (Relay.this) {
                while (true) {
                    try {
                        long j12 = this.sourcePos;
                        Relay relay2 = Relay.this;
                        long j13 = relay2.upstreamPos;
                        if (j12 != j13) {
                            long size = j13 - relay2.buffer.size();
                            long j14 = this.sourcePos;
                            if (j14 < size) {
                                long jMin = Math.min(j11, j13 - j14);
                                this.fileOperator.read(this.sourcePos + 32, buffer, jMin);
                                this.sourcePos += jMin;
                                return jMin;
                            }
                            long jMin2 = Math.min(j11, j13 - j14);
                            Relay.this.buffer.copyTo(buffer, this.sourcePos - size, jMin2);
                            this.sourcePos += jMin2;
                            return jMin2;
                        }
                        if (relay2.complete) {
                            return -1L;
                        }
                        if (relay2.upstreamReader == null) {
                            relay2.upstreamReader = Thread.currentThread();
                            try {
                                Relay relay3 = Relay.this;
                                long j15 = relay3.upstream.read(relay3.upstreamBuffer, relay3.bufferMaxSize);
                                if (j15 == -1) {
                                    Relay.this.commit(j13);
                                    synchronized (Relay.this) {
                                        Relay relay4 = Relay.this;
                                        relay4.upstreamReader = null;
                                        relay4.notifyAll();
                                    }
                                    return -1L;
                                }
                                long jMin3 = Math.min(j15, j11);
                                Relay.this.upstreamBuffer.copyTo(buffer, 0L, jMin3);
                                this.sourcePos += jMin3;
                                this.fileOperator.write(j13 + 32, Relay.this.upstreamBuffer.m157clone(), j15);
                                synchronized (Relay.this) {
                                    try {
                                        Relay relay5 = Relay.this;
                                        relay5.buffer.write(relay5.upstreamBuffer, j15);
                                        long size2 = Relay.this.buffer.size();
                                        Relay relay6 = Relay.this;
                                        if (size2 > relay6.bufferMaxSize) {
                                            Buffer buffer2 = relay6.buffer;
                                            buffer2.skip(buffer2.size() - Relay.this.bufferMaxSize);
                                        }
                                        relay = Relay.this;
                                        relay.upstreamPos += j15;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                synchronized (relay) {
                                    Relay relay7 = Relay.this;
                                    relay7.upstreamReader = null;
                                    relay7.notifyAll();
                                }
                                return jMin3;
                            } catch (Throwable th3) {
                                synchronized (Relay.this) {
                                    Relay relay8 = Relay.this;
                                    relay8.upstreamReader = null;
                                    relay8.notifyAll();
                                    throw th3;
                                }
                            }
                        }
                        this.timeout.waitUntilNotified(relay2);
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j11, ByteString byteString, long j12) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j11;
        this.metadata = byteString;
        this.bufferMaxSize = j12;
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j11) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0L, byteString, j11);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        fileOperator.read(0L, buffer, 32L);
        ByteString byteString = PREFIX_CLEAN;
        if (!buffer.readByteString(byteString.size()).equals(byteString)) {
            throw new IOException("unreadable cache file");
        }
        long j11 = buffer.readLong();
        long j12 = buffer.readLong();
        Buffer buffer2 = new Buffer();
        fileOperator.read(j11 + 32, buffer2, j12);
        return new Relay(randomAccessFile, null, j11, buffer2.readByteString(), 0L);
    }

    private void writeHeader(ByteString byteString, long j11, long j12) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j11);
        buffer.writeLong(j12);
        if (buffer.size() != 32) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.file.getChannel()).write(0L, buffer, 32L);
    }

    private void writeMetadata(long j11) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j11, buffer, this.metadata.size());
    }

    public void commit(long j11) throws IOException {
        writeMetadata(j11);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j11, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    public boolean isClosed() {
        return this.file == null;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            try {
                if (this.file == null) {
                    return null;
                }
                this.sourceCount++;
                return new RelaySource();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
