package b20;

import androidx.compose.animation.core.r;
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
public final class a implements ClosedFloatingPointRange<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f13935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f13936b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable, Comparable comparable2) {
        return g(((Number) comparable).doubleValue(), ((Number) comparable2).doubleValue());
    }

    public boolean b(double d11) {
        return d11 >= this.f13935a && d11 <= this.f13936b;
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Double f() {
        return Double.valueOf(this.f13936b);
    }

    @Override // kotlin.ranges.ClosedRange
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Double j() {
        return Double.valueOf(this.f13935a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean e(Comparable comparable) {
        return b(((Number) comparable).doubleValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f13935a != aVar.f13935a || this.f13936b != aVar.f13936b) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean g(double d11, double d12) {
        return d11 <= d12;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (r.a(this.f13935a) * 31) + r.a(this.f13936b);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public boolean isEmpty() {
        return this.f13935a > this.f13936b;
    }

    public String toString() {
        return this.f13935a + ".." + this.f13936b;
    }
}
