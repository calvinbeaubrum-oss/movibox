package f2;

import androidx.compose.ui.input.pointer.y;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f64529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f64530b = new long[2];

    public final boolean a(long j11) {
        if (d(j11)) {
            return false;
        }
        k(this.f64529a, j11);
        return true;
    }

    public final boolean b(long j11) {
        return a(j11);
    }

    public final void c() {
        this.f64529a = 0;
    }

    public final boolean d(long j11) {
        int i11 = this.f64529a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.f64530b[i12] == j11) {
                return true;
            }
        }
        return false;
    }

    public final long e(int i11) {
        return y.b(this.f64530b[i11]);
    }

    public final int f() {
        return this.f64529a;
    }

    public final boolean g() {
        return this.f64529a == 0;
    }

    public final boolean h(long j11) {
        int i11 = this.f64529a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (j11 == e(i12)) {
                j(i12);
                return true;
            }
        }
        return false;
    }

    public final boolean i(long j11) {
        return h(j11);
    }

    public final boolean j(int i11) {
        int i12 = this.f64529a;
        if (i11 >= i12) {
            return false;
        }
        int i13 = i12 - 1;
        while (i11 < i13) {
            long[] jArr = this.f64530b;
            int i14 = i11 + 1;
            jArr[i11] = jArr[i14];
            i11 = i14;
        }
        this.f64529a--;
        return true;
    }

    public final void k(int i11, long j11) {
        long[] jArr = this.f64530b;
        if (i11 >= jArr.length) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(i11 + 1, jArr.length * 2));
            Intrinsics.f(jArrCopyOf, "copyOf(this, newSize)");
            this.f64530b = jArrCopyOf;
        }
        this.f64530b[i11] = j11;
        if (i11 >= this.f64529a) {
            this.f64529a = i11 + 1;
        }
    }
}
