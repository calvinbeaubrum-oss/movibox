package androidx.compose.runtime;

import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class x<T> implements g3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<r, T> f3745a;

    /* JADX WARN: Multi-variable type inference failed */
    public x(Function1<? super r, ? extends T> function1) {
        this.f3745a = function1;
    }

    @Override // androidx.compose.runtime.g3
    public T a(n1 n1Var) {
        return this.f3745a.invoke(n1Var);
    }

    public final Function1<r, T> b() {
        return this.f3745a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x) && Intrinsics.b(this.f3745a, ((x) obj).f3745a);
    }

    public int hashCode() {
        return this.f3745a.hashCode();
    }

    public String toString() {
        return "ComputedValueHolder(compute=" + this.f3745a + ')';
    }
}
