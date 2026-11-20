package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class LineReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LineReader f68854a = new LineReader();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f68855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f68856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ByteBuffer f68857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CharBuffer f68858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final StringBuilder f68859f;

    static {
        byte[] bArr = new byte[32];
        f68855b = bArr;
        char[] cArr = new char[32];
        f68856c = cArr;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Intrinsics.f(byteBufferWrap, "wrap(...)");
        f68857d = byteBufferWrap;
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr);
        Intrinsics.f(charBufferWrap, "wrap(...)");
        f68858e = charBufferWrap;
        f68859f = new StringBuilder();
    }

    private LineReader() {
    }
}
