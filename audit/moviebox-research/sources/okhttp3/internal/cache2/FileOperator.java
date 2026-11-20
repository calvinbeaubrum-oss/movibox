package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        Intrinsics.g(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j11, Buffer sink, long j12) throws IOException {
        Intrinsics.g(sink, "sink");
        if (j12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j12 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j11, j12, sink);
            j11 += jTransferTo;
            j12 -= jTransferTo;
        }
    }

    public final void write(long j11, Buffer source, long j12) throws IOException {
        Intrinsics.g(source, "source");
        if (j12 < 0 || j12 > source.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j13 = j11;
        long j14 = j12;
        while (j14 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(source, j13, j14);
            j13 += jTransferFrom;
            j14 -= jTransferFrom;
        }
    }
}
