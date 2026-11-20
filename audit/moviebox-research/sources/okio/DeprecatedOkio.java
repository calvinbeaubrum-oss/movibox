package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: okio.-DeprecatedOkio, reason: invalid class name */
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
@Deprecated
@Metadata
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @Deprecated
    public final Sink appendingSink(File file) {
        Intrinsics.g(file, "file");
        return Okio.appendingSink(file);
    }

    @Deprecated
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @Deprecated
    public final BufferedSink buffer(Sink sink) {
        Intrinsics.g(sink, "sink");
        return Okio.buffer(sink);
    }

    @Deprecated
    public final BufferedSource buffer(Source source) {
        Intrinsics.g(source, "source");
        return Okio.buffer(source);
    }

    @Deprecated
    public final Sink sink(File file) {
        Intrinsics.g(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    @Deprecated
    public final Sink sink(OutputStream outputStream) {
        Intrinsics.g(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @Deprecated
    public final Sink sink(Socket socket) {
        Intrinsics.g(socket, "socket");
        return Okio.sink(socket);
    }

    @Deprecated
    public final Sink sink(Path path, OpenOption... options) {
        Intrinsics.g(path, "path");
        Intrinsics.g(options, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @Deprecated
    public final Source source(File file) {
        Intrinsics.g(file, "file");
        return Okio.source(file);
    }

    @Deprecated
    public final Source source(InputStream inputStream) {
        Intrinsics.g(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @Deprecated
    public final Source source(Socket socket) {
        Intrinsics.g(socket, "socket");
        return Okio.source(socket);
    }

    @Deprecated
    public final Source source(Path path, OpenOption... options) {
        Intrinsics.g(path, "path");
        Intrinsics.g(options, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }
}
