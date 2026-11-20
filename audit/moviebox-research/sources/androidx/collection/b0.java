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
public final class b0 extends l {
    public b0(int i11) {
        super(i11, null);
    }

    public /* synthetic */ b0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 16 : i11);
    }

    public final boolean f(int i11) {
        h(this.f1943b + 1);
        int[] iArr = this.f1942a;
        int i12 = this.f1943b;
        iArr[i12] = i11;
        this.f1943b = i12 + 1;
        return true;
    }

    public final boolean g(int i11, int[] elements) {
        int i12;
        Intrinsics.g(elements, "elements");
        if (i11 < 0 || i11 > (i12 = this.f1943b)) {
            throw new IndexOutOfBoundsException("Index " + i11 + " must be in 0.." + this.f1943b);
        }
        if (elements.length == 0) {
            return false;
        }
        h(i12 + elements.length);
        int[] iArr = this.f1942a;
        int i13 = this.f1943b;
        if (i11 != i13) {
            ArraysKt___ArraysJvmKt.j(iArr, iArr, elements.length + i11, i11, i13);
        }
        ArraysKt___ArraysJvmKt.o(elements, iArr, i11, 0, 0, 12, null);
        this.f1943b += elements.length;
        return true;
    }

    public final void h(int i11) {
        int[] iArr = this.f1942a;
        if (iArr.length < i11) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, Math.max(i11, (iArr.length * 3) / 2));
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f1942a = iArrCopyOf;
        }
    }

    public final void i(int[] elements) {
        Intrinsics.g(elements, "elements");
        g(this.f1943b, elements);
    }

    public final boolean j(int i11) {
        int iC = c(i11);
        if (iC < 0) {
            return false;
        }
        k(iC);
        return true;
    }

    public final int k(int i11) {
        int i12;
        if (i11 < 0 || i11 >= (i12 = this.f1943b)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Index ");
            sb2.append(i11);
            sb2.append(" must be in 0..");
            sb2.append(this.f1943b - 1);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        int[] iArr = this.f1942a;
        int i13 = iArr[i11];
        if (i11 != i12 - 1) {
            ArraysKt___ArraysJvmKt.j(iArr, iArr, i11, i11 + 1, i12);
        }
        this.f1943b--;
        return i13;
    }

    public final int l(int i11, int i12) {
        if (i11 >= 0 && i11 < this.f1943b) {
            int[] iArr = this.f1942a;
            int i13 = iArr[i11];
            iArr[i11] = i12;
            return i13;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("set index ");
        sb2.append(i11);
        sb2.append(" must be between 0 .. ");
        sb2.append(this.f1943b - 1);
        throw new IndexOutOfBoundsException(sb2.toString());
    }
}
