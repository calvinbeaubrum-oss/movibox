package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final /* synthetic */ class s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v2<androidx.compose.runtime.internal.d> f3564a = new v2<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v2<androidx.compose.runtime.collection.b<a0>> f3565b = new v2<>();

    public static final androidx.compose.runtime.collection.b<a0> b() {
        v2<androidx.compose.runtime.collection.b<a0>> v2Var = f3565b;
        androidx.compose.runtime.collection.b<a0> bVarA = v2Var.a();
        if (bVarA != null) {
            return bVarA;
        }
        androidx.compose.runtime.collection.b<a0> bVar = new androidx.compose.runtime.collection.b<>(new a0[0], 0);
        v2Var.b(bVar);
        return bVar;
    }

    public static final <T> a3<T> c(q2<T> q2Var, Function0<? extends T> function0) {
        return new DerivedSnapshotState(function0, q2Var);
    }

    public static final <T> a3<T> d(Function0<? extends T> function0) {
        return new DerivedSnapshotState(function0, null);
    }
}
