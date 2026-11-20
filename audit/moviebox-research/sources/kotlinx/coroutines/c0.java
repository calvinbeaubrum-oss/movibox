package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final Object f69210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final Function1<Throwable, Unit> f69211b;

    /* JADX WARN: Multi-variable type inference failed */
    public c0(Object obj, Function1<? super Throwable, Unit> function1) {
        this.f69210a = obj;
        this.f69211b = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return Intrinsics.b(this.f69210a, c0Var.f69210a) && Intrinsics.b(this.f69211b, c0Var.f69211b);
    }

    public int hashCode() {
        Object obj = this.f69210a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f69211b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f69210a + ", onCancellation=" + this.f69211b + ')';
    }
}
