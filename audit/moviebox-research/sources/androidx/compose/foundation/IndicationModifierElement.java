package androidx.compose.foundation;

import androidx.compose.ui.node.l0;
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
final class IndicationModifierElement extends l0<a0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1.g f2250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f2251c;

    public IndicationModifierElement(o1.g gVar, b0 b0Var) {
        this.f2250b = gVar;
        this.f2251c = b0Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndicationModifierElement)) {
            return false;
        }
        IndicationModifierElement indicationModifierElement = (IndicationModifierElement) obj;
        return Intrinsics.b(this.f2250b, indicationModifierElement.f2250b) && Intrinsics.b(this.f2251c, indicationModifierElement.f2251c);
    }

    public int hashCode() {
        return (this.f2250b.hashCode() * 31) + this.f2251c.hashCode();
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public a0 a() {
        return new a0(this.f2251c.a(this.f2250b));
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(a0 a0Var) {
        a0Var.N1(this.f2251c.a(this.f2250b));
    }
}
