package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3547a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w<o> f3548b = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements w<o> {
    }

    public static final l a(f<?> fVar, m mVar) {
        return new o(mVar, fVar, null, 4, null);
    }

    public static final d2 b(f<?> fVar, m mVar) {
        return new o(mVar, fVar, null, 4, null);
    }

    public static final void f(androidx.collection.b0 b0Var, int i11, int i12) {
        int iA = b0Var.a(i11);
        b0Var.l(i11, b0Var.a(i12));
        b0Var.l(i12, iA);
    }

    public static final <T> void g(List<T> list, int i11, int i12) {
        T t11 = list.get(i11);
        list.set(i11, list.get(i12));
        list.set(i12, t11);
    }
}
