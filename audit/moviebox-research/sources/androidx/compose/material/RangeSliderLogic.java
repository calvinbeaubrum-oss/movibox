package androidx.compose.material;

import androidx.compose.runtime.a3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

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
public final class RangeSliderLogic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1.i f3040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1.i f3041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a3<Float> f3042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a3<Float> f3043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a3<Function2<Boolean, Float, Unit>> f3044e;

    /* JADX WARN: Multi-variable type inference failed */
    public RangeSliderLogic(o1.i iVar, o1.i iVar2, a3<Float> a3Var, a3<Float> a3Var2, a3<? extends Function2<? super Boolean, ? super Float, Unit>> a3Var3) {
        this.f3040a = iVar;
        this.f3041b = iVar2;
        this.f3042c = a3Var;
        this.f3043d = a3Var2;
        this.f3044e = a3Var3;
    }

    public final o1.i a(boolean z11) {
        return z11 ? this.f3040a : this.f3041b;
    }

    public final void b(boolean z11, float f11, o1.f fVar, k0 k0Var) {
        this.f3044e.getValue().invoke(Boolean.valueOf(z11), Float.valueOf(f11 - (z11 ? this.f3042c : this.f3043d).getValue().floatValue()));
        kotlinx.coroutines.j.d(k0Var, null, null, new RangeSliderLogic$captureThumb$1(this, z11, fVar, null), 3, null);
    }

    public final int c(float f11) {
        return Float.compare(Math.abs(this.f3042c.getValue().floatValue() - f11), Math.abs(this.f3043d.getValue().floatValue() - f11));
    }
}
