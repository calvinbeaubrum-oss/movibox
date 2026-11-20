package kotlinx.coroutines;

import kotlin.Metadata;
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
public final class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o2 f69509a = new o2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<c1> f69510b = kotlinx.coroutines.internal.i0.a(new kotlinx.coroutines.internal.c0("ThreadLocalEventLoop"));

    public final c1 a() {
        return f69510b.get();
    }

    public final c1 b() {
        ThreadLocal<c1> threadLocal = f69510b;
        c1 c1Var = threadLocal.get();
        if (c1Var != null) {
            return c1Var;
        }
        c1 c1VarA = e1.a();
        threadLocal.set(c1VarA);
        return c1VarA;
    }

    public final void c() {
        f69510b.set(null);
    }

    public final void d(c1 c1Var) {
        f69510b.set(c1Var);
    }
}
