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
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f5139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5140b;

    public t(int i11) {
        this.f5139a = new int[i11];
    }

    public final boolean a(int i11, int i12) {
        int[] iArr = this.f5139a;
        int i13 = iArr[i11];
        int i14 = iArr[i12];
        if (i13 >= i14) {
            return i13 == i14 && iArr[i11 + 1] <= iArr[i12 + 1];
        }
        return true;
    }

    public final int b(int i11) {
        return this.f5139a[i11];
    }

    public final int c() {
        return this.f5140b;
    }

    public final boolean d() {
        return this.f5140b != 0;
    }

    public final int e(int i11, int i12, int i13) {
        int i14 = i11 - i13;
        while (i11 < i12) {
            if (a(i11, i12)) {
                i14 += i13;
                k(i14, i11);
            }
            i11 += i13;
        }
        int i15 = i14 + i13;
        k(i15, i12);
        return i15;
    }

    public final int f() {
        int[] iArr = this.f5139a;
        int i11 = this.f5140b - 1;
        this.f5140b = i11;
        return iArr[i11];
    }

    public final void g(int i11, int i12, int i13) {
        int i14 = this.f5140b;
        int i15 = i14 + 3;
        int[] iArr = this.f5139a;
        if (i15 >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f5139a = iArrCopyOf;
        }
        int[] iArr2 = this.f5139a;
        iArr2[i14] = i11 + i13;
        iArr2[i14 + 1] = i12 + i13;
        iArr2[i14 + 2] = i13;
        this.f5140b = i15;
    }

    public final void h(int i11, int i12, int i13, int i14) {
        int i15 = this.f5140b;
        int i16 = i15 + 4;
        int[] iArr = this.f5139a;
        if (i16 >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f5139a = iArrCopyOf;
        }
        int[] iArr2 = this.f5139a;
        iArr2[i15] = i11;
        iArr2[i15 + 1] = i12;
        iArr2[i15 + 2] = i13;
        iArr2[i15 + 3] = i14;
        this.f5140b = i16;
    }

    public final void i(int i11, int i12, int i13) {
        if (i11 < i12) {
            int iE = e(i11, i12, i13);
            i(i11, iE - i13, i13);
            i(iE + i13, i12, i13);
        }
    }

    public final void j() {
        int i11 = this.f5140b;
        if (!(i11 % 3 == 0)) {
            h2.a.b("Array size not a multiple of 3");
        }
        if (i11 > 3) {
            i(0, i11 - 3, 3);
        }
    }

    public final void k(int i11, int i12) {
        int[] iArr = this.f5139a;
        o0.i(iArr, i11, i12);
        o0.i(iArr, i11 + 1, i12 + 1);
        o0.i(iArr, i11 + 2, i12 + 2);
    }
}
