package kotlinx.coroutines;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f69504a = kotlinx.coroutines.internal.d0.f("kotlinx.coroutines.main.delay", false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q0 f69505b = b();

    public static final q0 a() {
        return f69505b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final q0 b() {
        if (!f69504a) {
            return DefaultExecutor.INSTANCE;
        }
        a2 a2VarC = w0.c();
        return (kotlinx.coroutines.internal.t.c(a2VarC) || !(a2VarC instanceof q0)) ? DefaultExecutor.INSTANCE : (q0) a2VarC;
    }
}
