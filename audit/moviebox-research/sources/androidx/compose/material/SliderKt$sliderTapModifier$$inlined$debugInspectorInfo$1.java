package androidx.compose.material;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.i1;
import androidx.compose.ui.platform.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
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
public final class SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<e1, Unit> {
    final /* synthetic */ androidx.compose.foundation.gestures.f $draggableState$inlined;
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ a3 $gestureEndAction$inlined;
    final /* synthetic */ o1.i $interactionSource$inlined;
    final /* synthetic */ boolean $isRtl$inlined;
    final /* synthetic */ float $maxPx$inlined;
    final /* synthetic */ i1 $pressOffset$inlined;
    final /* synthetic */ a3 $rawOffset$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1(androidx.compose.foundation.gestures.f fVar, o1.i iVar, float f11, boolean z11, a3 a3Var, a3 a3Var2, i1 i1Var, boolean z12) {
        super(1);
        this.$interactionSource$inlined = iVar;
        this.$maxPx$inlined = f11;
        this.$isRtl$inlined = z11;
        this.$rawOffset$inlined = a3Var;
        this.$gestureEndAction$inlined = a3Var2;
        this.$pressOffset$inlined = i1Var;
        this.$enabled$inlined = z12;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
        invoke2(e1Var);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e1 e1Var) {
        e1Var.b("sliderTapModifier");
        e1Var.a().b("draggableState", null);
        e1Var.a().b("interactionSource", this.$interactionSource$inlined);
        e1Var.a().b("maxPx", Float.valueOf(this.$maxPx$inlined));
        e1Var.a().b("isRtl", Boolean.valueOf(this.$isRtl$inlined));
        e1Var.a().b("rawOffset", this.$rawOffset$inlined);
        e1Var.a().b("gestureEndAction", this.$gestureEndAction$inlined);
        e1Var.a().b("pressOffset", this.$pressOffset$inlined);
        e1Var.a().b("enabled", Boolean.valueOf(this.$enabled$inlined));
    }
}
