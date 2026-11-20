package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Relay {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;

    @JvmField
    public static final ByteString PREFIX_CLEAN;

    @JvmField
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private Source upstream;
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Relay edit(File file, Source upstream, ByteString metadata, long j11) throws IOException {
            Intrinsics.g(file, "file");
            Intrinsics.g(upstream, "upstream");
            Intrinsics.g(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, j11, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            Intrinsics.g(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.f(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer buffer = new Buffer();
            fileOperator.read(0L, buffer, 32L);
            ByteString byteString = Relay.PREFIX_CLEAN;
            if (!Intrinsics.b(buffer.readByteString(byteString.size()), byteString)) {
                throw new IOException("unreadable cache file");
            }
            long j11 = buffer.readLong();
            long j12 = buffer.readLong();
            Buffer buffer2 = new Buffer();
            fileOperator.read(j11 + 32, buffer2, j12);
            return new Relay(randomAccessFile, null, j11, buffer2.readByteString(), 0L, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            Intrinsics.d(file);
            FileChannel channel = file.getChannel();
            Intrinsics.f(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                try {
                    Relay relay = Relay.this;
                    relay.setSourceCount(relay.getSourceCount() - 1);
                    if (Relay.this.getSourceCount() == 0) {
                        RandomAccessFile file = Relay.this.getFile();
                        Relay.this.setFile(null);
                        randomAccessFile = file;
                    }
                    Unit unit = Unit.f68710a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // okio.Source
        public long read(Buffer sink, long j11) throws IOException {
            Intrinsics.g(sink, "sink");
            char c11 = 1;
            if (!(this.fileOperator != null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            synchronized (Relay.this) {
                while (true) {
                    if (this.sourcePos == Relay.this.getUpstreamPos()) {
                        if (!Relay.this.getComplete()) {
                            if (Relay.this.getUpstreamReader() == null) {
                                Relay.this.setUpstreamReader(Thread.currentThread());
                                break;
                            }
                            this.timeout.waitUntilNotified(Relay.this);
                        } else {
                            return -1L;
                        }
                    } else {
                        long upstreamPos = Relay.this.getUpstreamPos() - Relay.this.getBuffer().size();
                        if (this.sourcePos < upstreamPos) {
                            c11 = 2;
                            break;
                        }
                        long jMin = Math.min(j11, Relay.this.getUpstreamPos() - this.sourcePos);
                        Relay.this.getBuffer().copyTo(sink, this.sourcePos - upstreamPos, jMin);
                        this.sourcePos += jMin;
                        return jMin;
                    }
                }
                if (c11 == 2) {
                    long jMin2 = Math.min(j11, Relay.this.getUpstreamPos() - this.sourcePos);
                    FileOperator fileOperator = this.fileOperator;
                    Intrinsics.d(fileOperator);
                    fileOperator.read(this.sourcePos + 32, sink, jMin2);
                    this.sourcePos += jMin2;
                    return jMin2;
                }
                try {
                    Source upstream = Relay.this.getUpstream();
                    Intrinsics.d(upstream);
                    long j12 = upstream.read(Relay.this.getUpstreamBuffer(), Relay.this.getBufferMaxSize());
                    if (j12 == -1) {
                        Relay relay = Relay.this;
                        relay.commit(relay.getUpstreamPos());
                        synchronized (Relay.this) {
                            Relay.this.setUpstreamReader(null);
                            Relay relay2 = Relay.this;
                            if (relay2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            relay2.notifyAll();
                            Unit unit = Unit.f68710a;
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j12, j11);
                    Relay.this.getUpstreamBuffer().copyTo(sink, 0L, jMin3);
                    this.sourcePos += jMin3;
                    FileOperator fileOperator2 = this.fileOperator;
                    Intrinsics.d(fileOperator2);
                    fileOperator2.write(Relay.this.getUpstreamPos() + 32, Relay.this.getUpstreamBuffer().clone(), j12);
                    synchronized (Relay.this) {
                        try {
                            Relay.this.getBuffer().write(Relay.this.getUpstreamBuffer(), j12);
                            if (Relay.this.getBuffer().size() > Relay.this.getBufferMaxSize()) {
                                Relay.this.getBuffer().skip(Relay.this.getBuffer().size() - Relay.this.getBufferMaxSize());
                            }
                            Relay relay3 = Relay.this;
                            relay3.setUpstreamPos(relay3.getUpstreamPos() + j12);
                            Unit unit2 = Unit.f68710a;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    synchronized (Relay.this) {
                        Relay.this.setUpstreamReader(null);
                        Relay relay4 = Relay.this;
                        if (relay4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        relay4.notifyAll();
                    }
                    return jMin3;
                } catch (Throwable th3) {
                    synchronized (Relay.this) {
                        try {
                            Relay.this.setUpstreamReader(null);
                            Relay relay5 = Relay.this;
                            if (relay5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            relay5.notifyAll();
                            Unit unit3 = Unit.f68710a;
                            throw th3;
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        PREFIX_CLEAN = companion.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = companion.encodeUtf8("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j11, ByteString byteString, long j12) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j11;
        this.metadata = byteString;
        this.bufferMaxSize = j12;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j11, ByteString byteString, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(randomAccessFile, source, j11, byteString, j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j11, long j12) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j11);
        buffer.writeLong(j12);
        if (!(buffer.size() == 32)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.d(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.f(channel, "file!!.channel");
        new FileOperator(channel).write(0L, buffer, 32L);
    }

    private final void writeMetadata(long j11) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.d(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.f(channel, "file!!.channel");
        new FileOperator(channel).write(32 + j11, buffer, this.metadata.size());
    }

    public final void commit(long j11) throws IOException {
        writeMetadata(j11);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.d(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j11, this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        Intrinsics.d(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            Unit unit = Unit.f68710a;
        }
        Source source = this.upstream;
        if (source != null) {
            Util.closeQuietly(source);
        }
        this.upstream = null;
    }

    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final Source getUpstream() {
        return this.upstream;
    }

    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z11) {
        this.complete = z11;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i11) {
        this.sourceCount = i11;
    }

    public final void setUpstream(Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j11) {
        this.upstreamPos = j11;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }
}
