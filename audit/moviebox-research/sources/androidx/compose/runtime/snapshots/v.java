package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.h3;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;

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
public final class v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f3707b = new int[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h3<T>[] f3708c = new h3[16];

    public final boolean a(T t11) {
        int iB;
        int i11 = this.f3706a;
        int iC = androidx.compose.runtime.b.c(t11);
        if (i11 > 0) {
            iB = b(t11, iC);
            if (iB >= 0) {
                return false;
            }
        } else {
            iB = -1;
        }
        int i12 = -(iB + 1);
        h3<T>[] h3VarArr = this.f3708c;
        int length = h3VarArr.length;
        if (i11 == length) {
            int i13 = length * 2;
            h3<T>[] h3VarArr2 = new h3[i13];
            int[] iArr = new int[i13];
            int i14 = i12 + 1;
            ArraysKt___ArraysJvmKt.l(h3VarArr, h3VarArr2, i14, i12, i11);
            ArraysKt___ArraysJvmKt.p(this.f3708c, h3VarArr2, 0, 0, i12, 6, null);
            ArraysKt___ArraysJvmKt.j(this.f3707b, iArr, i14, i12, i11);
            ArraysKt___ArraysJvmKt.o(this.f3707b, iArr, 0, 0, i12, 6, null);
            this.f3708c = h3VarArr2;
            this.f3707b = iArr;
        } else {
            int i15 = i12 + 1;
            ArraysKt___ArraysJvmKt.l(h3VarArr, h3VarArr, i15, i12, i11);
            int[] iArr2 = this.f3707b;
            ArraysKt___ArraysJvmKt.j(iArr2, iArr2, i15, i12, i11);
        }
        this.f3708c[i12] = new h3<>(t11);
        this.f3707b[i12] = iC;
        this.f3706a++;
        return true;
    }

    public final int b(T t11, int i11) {
        int i12 = this.f3706a - 1;
        int i13 = 0;
        while (i13 <= i12) {
            int i14 = (i13 + i12) >>> 1;
            int i15 = this.f3707b[i14];
            if (i15 < i11) {
                i13 = i14 + 1;
            } else {
                if (i15 <= i11) {
                    h3<T> h3Var = this.f3708c[i14];
                    return t11 == (h3Var != null ? h3Var.get() : null) ? i14 : c(i14, t11, i11);
                }
                i12 = i14 - 1;
            }
        }
        return -(i13 + 1);
    }

    public final int c(int i11, T t11, int i12) {
        int i13 = i11 - 1;
        while (true) {
            if (-1 >= i13 || this.f3707b[i13] != i12) {
                break;
            }
            h3<T> h3Var = this.f3708c[i13];
            if ((h3Var != null ? h3Var.get() : null) == t11) {
                return i13;
            }
            i13--;
        }
        int i14 = i11 + 1;
        int i15 = this.f3706a;
        while (i14 < i15) {
            if (this.f3707b[i14] != i12) {
                return -(i14 + 1);
            }
            h3<T> h3Var2 = this.f3708c[i14];
            if ((h3Var2 != null ? h3Var2.get() : null) == t11) {
                return i14;
            }
            i14++;
        }
        i14 = this.f3706a;
        return -(i14 + 1);
    }

    public final int[] d() {
        return this.f3707b;
    }

    public final int e() {
        return this.f3706a;
    }

    public final h3<T>[] f() {
        return this.f3708c;
    }

    public final void g(int i11) {
        this.f3706a = i11;
    }
}
