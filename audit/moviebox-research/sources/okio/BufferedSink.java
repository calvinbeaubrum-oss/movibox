package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface BufferedSink extends Sink, WritableByteChannel {
    @Deprecated
    Buffer buffer();

    BufferedSink emit() throws IOException;

    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    Buffer getBuffer();

    OutputStream outputStream();

    BufferedSink write(ByteString byteString) throws IOException;

    BufferedSink write(ByteString byteString, int i11, int i12) throws IOException;

    BufferedSink write(Source source, long j11) throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i11, int i12) throws IOException;

    long writeAll(Source source) throws IOException;

    BufferedSink writeByte(int i11) throws IOException;

    BufferedSink writeDecimalLong(long j11) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long j11) throws IOException;

    BufferedSink writeInt(int i11) throws IOException;

    BufferedSink writeIntLe(int i11) throws IOException;

    BufferedSink writeLong(long j11) throws IOException;

    BufferedSink writeLongLe(long j11) throws IOException;

    BufferedSink writeShort(int i11) throws IOException;

    BufferedSink writeShortLe(int i11) throws IOException;

    BufferedSink writeString(String str, int i11, int i12, Charset charset) throws IOException;

    BufferedSink writeString(String str, Charset charset) throws IOException;

    BufferedSink writeUtf8(String str) throws IOException;

    BufferedSink writeUtf8(String str, int i11, int i12) throws IOException;

    BufferedSink writeUtf8CodePoint(int i11) throws IOException;
}
