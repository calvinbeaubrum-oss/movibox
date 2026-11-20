package androidx.compose.ui.node;

import java.util.Arrays;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class p0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f5110b = new int[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.compose.runtime.collection.b<T>[] f5111c = new androidx.compose.runtime.collection.b[16];

    public final boolean a() {
        int i11 = this.f5109a;
        return i11 > 0 && this.f5110b[i11 - 1] >= 0;
    }

    public final T b() {
        int i11 = this.f5109a;
        if (i11 <= 0) {
            throw new IllegalStateException("Cannot call pop() on an empty stack. Guard with a call to isNotEmpty()".toString());
        }
        int i12 = i11 - 1;
        int i13 = this.f5110b[i12];
        androidx.compose.runtime.collection.b<T> bVar = this.f5111c[i12];
        Intrinsics.d(bVar);
        if (i13 > 0) {
            int[] iArr = this.f5110b;
            iArr[i12] = iArr[i12] - 1;
        } else if (i13 == 0) {
            this.f5111c[i12] = null;
            this.f5109a--;
        }
        return bVar.q()[i13];
    }

    public final void c(androidx.compose.runtime.collection.b<T> bVar) {
        if (bVar.t()) {
            return;
        }
        int i11 = this.f5109a;
        int[] iArr = this.f5110b;
        if (i11 >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f5110b = iArrCopyOf;
            androidx.compose.runtime.collection.b<T>[] bVarArr = this.f5111c;
            Object[] objArrCopyOf = Arrays.copyOf(bVarArr, bVarArr.length * 2);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f5111c = (androidx.compose.runtime.collection.b[]) objArrCopyOf;
        }
        this.f5110b[i11] = bVar.r() - 1;
        this.f5111c[i11] = bVar;
        this.f5109a++;
    }
}
