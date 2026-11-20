package androidx.collection;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class j0<E> extends ObjectList<E> {
    public j0() {
        this(0, 1, null);
    }

    public j0(int i11) {
        super(i11, null);
    }

    public /* synthetic */ j0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 16 : i11);
    }

    public final boolean e(E e11) {
        g(this.f1896b + 1);
        Object[] objArr = this.f1895a;
        int i11 = this.f1896b;
        objArr[i11] = e11;
        this.f1896b = i11 + 1;
        return true;
    }

    public final void f() {
        ArraysKt___ArraysJvmKt.u(this.f1895a, null, 0, this.f1896b);
        this.f1896b = 0;
    }

    public final void g(int i11) {
        Object[] objArr = this.f1895a;
        if (objArr.length < i11) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, Math.max(i11, (objArr.length * 3) / 2));
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f1895a = objArrCopyOf;
        }
    }
}
