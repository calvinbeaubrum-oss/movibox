package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class r2 {
    public static final androidx.compose.runtime.collection.b<a0> a() {
        return s2.b();
    }

    public static final <T> a3<T> b(q2<T> q2Var, Function0<? extends T> function0) {
        return s2.c(q2Var, function0);
    }

    public static final <T> a3<T> c(Function0<? extends T> function0) {
        return s2.d(function0);
    }

    public static final <T> SnapshotStateList<T> d() {
        return u2.a();
    }

    public static final <T> i1<T> e(T t11, q2<T> q2Var) {
        return u2.b(t11, q2Var);
    }

    public static final <T> q2<T> g() {
        return t2.a();
    }

    public static final <T> q2<T> h() {
        return t2.b();
    }

    public static final <T> a3<T> i(T t11, i iVar, int i11) {
        return u2.d(t11, iVar, i11);
    }

    public static final <T> q2<T> j() {
        return t2.c();
    }
}
