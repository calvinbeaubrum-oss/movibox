package okio;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
final /* synthetic */ class Okio__OkioKt {
    @JvmName
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final BufferedSink buffer(Sink buffer) {
        Intrinsics.g(buffer, "$this$buffer");
        return new RealBufferedSink(buffer);
    }

    public static final BufferedSource buffer(Source buffer) {
        Intrinsics.g(buffer, "$this$buffer");
        return new RealBufferedSource(buffer);
    }

    public static final <T extends Closeable, R> R use(T t11, Function1<? super T, ? extends R> block) throws Throwable {
        R rInvoke;
        Intrinsics.g(block, "block");
        Throwable th2 = null;
        try {
            rInvoke = block.invoke(t11);
        } catch (Throwable th3) {
            th2 = th3;
            rInvoke = null;
        }
        if (t11 != null) {
            try {
                t11.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                } else {
                    v10.b.a(th2, th4);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
        Intrinsics.d(rInvoke);
        return rInvoke;
    }
}
