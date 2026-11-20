package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

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
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler() {
        this(System.nanoTime());
    }

    public Throttler(long j11) {
        this.allocatedUntil = j11;
        this.waitByteCount = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        this.maxByteCount = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j11, long j12, long j13, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j12 = throttler.waitByteCount;
        }
        long j14 = j12;
        if ((i11 & 4) != 0) {
            j13 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j11, j14, j13);
    }

    private final long bytesToNanos(long j11) {
        return (j11 * C.NANOS_PER_SECOND) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j11) {
        return (j11 * this.bytesPerSecond) / C.NANOS_PER_SECOND;
    }

    private final void waitNanos(long j11) throws InterruptedException {
        long j12 = j11 / 1000000;
        wait(j12, (int) (j11 - (1000000 * j12)));
    }

    public final long byteCountOrWaitNanos$okio(long j11, long j12) {
        if (this.bytesPerSecond == 0) {
            return j12;
        }
        long jMax = Math.max(this.allocatedUntil - j11, 0L);
        long jNanosToBytes = this.maxByteCount - nanosToBytes(jMax);
        if (jNanosToBytes >= j12) {
            this.allocatedUntil = j11 + jMax + bytesToNanos(j12);
            return j12;
        }
        long j13 = this.waitByteCount;
        if (jNanosToBytes >= j13) {
            this.allocatedUntil = j11 + bytesToNanos(this.maxByteCount);
            return jNanosToBytes;
        }
        long jMin = Math.min(j13, j12);
        long jBytesToNanos = jMax + bytesToNanos(jMin - this.maxByteCount);
        if (jBytesToNanos != 0) {
            return -jBytesToNanos;
        }
        this.allocatedUntil = j11 + bytesToNanos(this.maxByteCount);
        return jMin;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j11) {
        bytesPerSecond$default(this, j11, 0L, 0L, 6, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j11, long j12) {
        bytesPerSecond$default(this, j11, j12, 0L, 4, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j11, long j12, long j13) {
        synchronized (this) {
            try {
                if (!(j11 >= 0)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (!(j12 > 0)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (!(j13 >= j12)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                this.bytesPerSecond = j11;
                this.waitByteCount = j12;
                this.maxByteCount = j13;
                notifyAll();
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Sink sink(final Sink sink) {
        Intrinsics.g(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler.sink.1
            @Override // okio.ForwardingSink, okio.Sink
            public void write(Buffer source, long j11) throws IOException {
                Intrinsics.g(source, "source");
                while (j11 > 0) {
                    try {
                        long jTake$okio = Throttler.this.take$okio(j11);
                        super.write(source, jTake$okio);
                        j11 -= jTake$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        Intrinsics.g(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler.source.1
            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer sink, long j11) throws InterruptedIOException {
                Intrinsics.g(sink, "sink");
                try {
                    return super.read(sink, Throttler.this.take$okio(j11));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long j11) {
        long jByteCountOrWaitNanos$okio;
        if (!(j11 > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            while (true) {
                jByteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j11);
                if (jByteCountOrWaitNanos$okio < 0) {
                    waitNanos(-jByteCountOrWaitNanos$okio);
                }
            }
        }
        return jByteCountOrWaitNanos$okio;
    }
}
