package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.graphics.k4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
public final class i1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<T, Matrix, Unit> f5487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Matrix f5488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Matrix f5489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f5490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f5491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5492f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5493g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5494h = true;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(Function2<? super T, ? super Matrix, Unit> function2) {
        this.f5487a = function2;
    }

    public final float[] a(T t11) {
        float[] fArrC = this.f5491e;
        if (fArrC == null) {
            fArrC = k4.c(null, 1, null);
            this.f5491e = fArrC;
        }
        if (this.f5493g) {
            this.f5494h = g1.a(b(t11), fArrC);
            this.f5493g = false;
        }
        if (this.f5494h) {
            return fArrC;
        }
        return null;
    }

    public final float[] b(T t11) {
        float[] fArrC = this.f5490d;
        if (fArrC == null) {
            fArrC = k4.c(null, 1, null);
            this.f5490d = fArrC;
        }
        if (!this.f5492f) {
            return fArrC;
        }
        Matrix matrix = this.f5488b;
        if (matrix == null) {
            matrix = new Matrix();
            this.f5488b = matrix;
        }
        this.f5487a.invoke(t11, matrix);
        Matrix matrix2 = this.f5489c;
        if (matrix2 == null || !Intrinsics.b(matrix, matrix2)) {
            androidx.compose.ui.graphics.r0.b(fArrC, matrix);
            this.f5488b = matrix2;
            this.f5489c = matrix;
        }
        this.f5492f = false;
        return fArrC;
    }

    public final void c() {
        this.f5492f = true;
        this.f5493g = true;
    }
}
