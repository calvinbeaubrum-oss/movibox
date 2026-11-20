package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
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
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f3484a = new int[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3485b;

    public final void a() {
        this.f3485b = 0;
    }

    public final int b() {
        return this.f3485b;
    }

    public final int c(int i11) {
        int i12 = this.f3485b;
        for (int i13 = 0; i13 < i12; i13++) {
            if (this.f3484a[i13] == i11) {
                return i13;
            }
        }
        return -1;
    }

    public final boolean d() {
        return this.f3485b == 0;
    }

    public final int e() {
        return this.f3484a[this.f3485b - 1];
    }

    public final int f(int i11) {
        return this.f3484a[i11];
    }

    public final int g() {
        return this.f3484a[this.f3485b - 2];
    }

    public final int h(int i11) {
        return this.f3485b > 0 ? e() : i11;
    }

    public final int i() {
        int[] iArr = this.f3484a;
        int i11 = this.f3485b - 1;
        this.f3485b = i11;
        return iArr[i11];
    }

    public final void j(int i11) {
        int i12 = this.f3485b;
        int[] iArr = this.f3484a;
        if (i12 >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f3484a = iArrCopyOf;
        }
        int[] iArr2 = this.f3484a;
        int i13 = this.f3485b;
        this.f3485b = i13 + 1;
        iArr2[i13] = i11;
    }
}
