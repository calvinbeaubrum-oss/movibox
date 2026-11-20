package b20;

import kotlin.Metadata;
import kotlin.ranges.ClosedFloatingPointRange;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class b implements ClosedFloatingPointRange<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f13938b;

    public b(float f11, float f12) {
        this.f13937a = f11;
        this.f13938b = f12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable, Comparable comparable2) {
        return g(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    public boolean b(float f11) {
        return f11 >= this.f13937a && f11 <= this.f13938b;
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float f() {
        return Float.valueOf(this.f13938b);
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Float j() {
        return Float.valueOf(this.f13937a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean e(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (this.f13937a != bVar.f13937a || this.f13938b != bVar.f13938b) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean g(float f11, float f12) {
        return f11 <= f12;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f13937a) * 31) + Float.floatToIntBits(this.f13938b);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public boolean isEmpty() {
        return this.f13937a > this.f13938b;
    }

    public String toString() {
        return this.f13937a + ".." + this.f13938b;
    }
}
