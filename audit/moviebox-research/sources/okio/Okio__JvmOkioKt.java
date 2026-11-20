package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

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
final /* synthetic */ class Okio__JvmOkioKt {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    public static final Sink appendingSink(File appendingSink) throws FileNotFoundException {
        Intrinsics.g(appendingSink, "$this$appendingSink");
        return Okio.sink(new FileOutputStream(appendingSink, true));
    }

    public static final CipherSink cipherSink(Sink cipherSink, Cipher cipher) {
        Intrinsics.g(cipherSink, "$this$cipherSink");
        Intrinsics.g(cipher, "cipher");
        return new CipherSink(Okio.buffer(cipherSink), cipher);
    }

    public static final CipherSource cipherSource(Source cipherSource, Cipher cipher) {
        Intrinsics.g(cipherSource, "$this$cipherSource");
        Intrinsics.g(cipher, "cipher");
        return new CipherSource(Okio.buffer(cipherSource), cipher);
    }

    public static final HashingSink hashingSink(Sink hashingSink, MessageDigest digest) {
        Intrinsics.g(hashingSink, "$this$hashingSink");
        Intrinsics.g(digest, "digest");
        return new HashingSink(hashingSink, digest);
    }

    public static final HashingSink hashingSink(Sink hashingSink, Mac mac) {
        Intrinsics.g(hashingSink, "$this$hashingSink");
        Intrinsics.g(mac, "mac");
        return new HashingSink(hashingSink, mac);
    }

    public static final HashingSource hashingSource(Source hashingSource, MessageDigest digest) {
        Intrinsics.g(hashingSource, "$this$hashingSource");
        Intrinsics.g(digest, "digest");
        return new HashingSource(hashingSource, digest);
    }

    public static final HashingSource hashingSource(Source hashingSource, Mac mac) {
        Intrinsics.g(hashingSource, "$this$hashingSource");
        Intrinsics.g(mac, "mac");
        return new HashingSource(hashingSource, mac);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError isAndroidGetsocknameError) {
        String message;
        Intrinsics.g(isAndroidGetsocknameError, "$this$isAndroidGetsocknameError");
        return (isAndroidGetsocknameError.getCause() == null || (message = isAndroidGetsocknameError.getMessage()) == null || !StringsKt__StringsKt.Q(message, "getsockname failed", false, 2, null)) ? false : true;
    }

    @JvmOverloads
    public static final Sink sink(File file) throws FileNotFoundException {
        return sink$default(file, false, 1, null);
    }

    @JvmOverloads
    public static final Sink sink(File sink, boolean z11) throws FileNotFoundException {
        Intrinsics.g(sink, "$this$sink");
        return Okio.sink(new FileOutputStream(sink, z11));
    }

    public static final Sink sink(OutputStream sink) {
        Intrinsics.g(sink, "$this$sink");
        return new OutputStreamSink(sink, new Timeout());
    }

    public static final Sink sink(Socket sink) throws IOException {
        Intrinsics.g(sink, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(sink);
        OutputStream outputStream = sink.getOutputStream();
        Intrinsics.f(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    @IgnoreJRERequirement
    public static final Sink sink(Path sink, OpenOption... options) throws IOException {
        Intrinsics.g(sink, "$this$sink");
        Intrinsics.g(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(sink, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.f(outputStreamNewOutputStream, "Files.newOutputStream(this, *options)");
        return Okio.sink(outputStreamNewOutputStream);
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z11, int i11, Object obj) throws FileNotFoundException {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return Okio.sink(file, z11);
    }

    public static final Source source(File source) throws FileNotFoundException {
        Intrinsics.g(source, "$this$source");
        return Okio.source(new FileInputStream(source));
    }

    public static final Source source(InputStream source) {
        Intrinsics.g(source, "$this$source");
        return new InputStreamSource(source, new Timeout());
    }

    public static final Source source(Socket source) throws IOException {
        Intrinsics.g(source, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(source);
        InputStream inputStream = source.getInputStream();
        Intrinsics.f(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    @IgnoreJRERequirement
    public static final Source source(Path source, OpenOption... options) throws IOException {
        Intrinsics.g(source, "$this$source");
        Intrinsics.g(options, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(source, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.f(inputStreamNewInputStream, "Files.newInputStream(this, *options)");
        return Okio.source(inputStreamNewInputStream);
    }
}
