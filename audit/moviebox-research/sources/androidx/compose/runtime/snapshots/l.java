package androidx.compose.runtime.snapshots;

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
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f3693b = new int[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f3694c = new int[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f3695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3696e;

    public l() {
        int[] iArr = new int[16];
        int i11 = 0;
        while (i11 < 16) {
            int i12 = i11 + 1;
            iArr[i11] = i12;
            i11 = i12;
        }
        this.f3695d = iArr;
    }

    public final int a(int i11) {
        c(this.f3692a + 1);
        int i12 = this.f3692a;
        this.f3692a = i12 + 1;
        int iB = b();
        this.f3693b[i12] = i11;
        this.f3694c[i12] = iB;
        this.f3695d[iB] = i12;
        h(i12);
        return iB;
    }

    public final int b() {
        int length = this.f3695d.length;
        if (this.f3696e >= length) {
            int i11 = length * 2;
            int[] iArr = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 + 1;
                iArr[i12] = i13;
                i12 = i13;
            }
            ArraysKt___ArraysJvmKt.o(this.f3695d, iArr, 0, 0, 0, 14, null);
            this.f3695d = iArr;
        }
        int i14 = this.f3696e;
        this.f3696e = this.f3695d[i14];
        return i14;
    }

    public final void c(int i11) {
        int[] iArr = this.f3693b;
        int length = iArr.length;
        if (i11 <= length) {
            return;
        }
        int i12 = length * 2;
        int[] iArr2 = new int[i12];
        int[] iArr3 = new int[i12];
        ArraysKt___ArraysJvmKt.o(iArr, iArr2, 0, 0, 0, 14, null);
        ArraysKt___ArraysJvmKt.o(this.f3694c, iArr3, 0, 0, 0, 14, null);
        this.f3693b = iArr2;
        this.f3694c = iArr3;
    }

    public final void d(int i11) {
        this.f3695d[i11] = this.f3696e;
        this.f3696e = i11;
    }

    public final int e(int i11) {
        return this.f3692a > 0 ? this.f3693b[0] : i11;
    }

    public final void f(int i11) {
        int i12 = this.f3695d[i11];
        i(i12, this.f3692a - 1);
        this.f3692a--;
        h(i12);
        g(i12);
        d(i11);
    }

    public final void g(int i11) {
        int i12;
        int[] iArr = this.f3693b;
        int i13 = this.f3692a >> 1;
        while (i11 < i13) {
            int i14 = (i11 + 1) << 1;
            int i15 = i14 - 1;
            if (i14 >= this.f3692a || (i12 = iArr[i14]) >= iArr[i15]) {
                if (iArr[i15] >= iArr[i11]) {
                    return;
                }
                i(i15, i11);
                i11 = i15;
            } else {
                if (i12 >= iArr[i11]) {
                    return;
                }
                i(i14, i11);
                i11 = i14;
            }
        }
    }

    public final void h(int i11) {
        int[] iArr = this.f3693b;
        int i12 = iArr[i11];
        while (i11 > 0) {
            int i13 = ((i11 + 1) >> 1) - 1;
            if (iArr[i13] <= i12) {
                return;
            }
            i(i13, i11);
            i11 = i13;
        }
    }

    public final void i(int i11, int i12) {
        int[] iArr = this.f3693b;
        int[] iArr2 = this.f3694c;
        int[] iArr3 = this.f3695d;
        int i13 = iArr[i11];
        iArr[i11] = iArr[i12];
        iArr[i12] = i13;
        int i14 = iArr2[i11];
        iArr2[i11] = iArr2[i12];
        iArr2[i12] = i14;
        iArr3[iArr2[i11]] = i11;
        iArr3[iArr2[i12]] = i12;
    }
}
