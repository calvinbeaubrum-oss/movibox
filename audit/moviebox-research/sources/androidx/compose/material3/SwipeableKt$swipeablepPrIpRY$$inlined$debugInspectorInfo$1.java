package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.platform.e1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: renamed from: androidx.compose.material3.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1, reason: invalid class name */
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
public final class SwipeableKt$swipeablepPrIpRY$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<e1, Unit> {
    final /* synthetic */ Map $anchors$inlined;
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ o1.i $interactionSource$inlined;
    final /* synthetic */ Orientation $orientation$inlined;
    final /* synthetic */ g $resistance$inlined;
    final /* synthetic */ boolean $reverseDirection$inlined;
    final /* synthetic */ i $state$inlined;
    final /* synthetic */ Function2 $thresholds$inlined;
    final /* synthetic */ float $velocityThreshold$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableKt$swipeablepPrIpRY$$inlined$debugInspectorInfo$1(i iVar, Map map, Orientation orientation, boolean z11, boolean z12, o1.i iVar2, Function2 function2, g gVar, float f11) {
        super(1);
        this.$anchors$inlined = map;
        this.$orientation$inlined = orientation;
        this.$enabled$inlined = z11;
        this.$reverseDirection$inlined = z12;
        this.$interactionSource$inlined = iVar2;
        this.$thresholds$inlined = function2;
        this.$velocityThreshold$inlined = f11;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
        invoke2(e1Var);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e1 e1Var) {
        Intrinsics.g(e1Var, "$this$null");
        e1Var.b("swipeable");
        e1Var.a().b("state", null);
        e1Var.a().b("anchors", this.$anchors$inlined);
        e1Var.a().b("orientation", this.$orientation$inlined);
        e1Var.a().b("enabled", Boolean.valueOf(this.$enabled$inlined));
        e1Var.a().b("reverseDirection", Boolean.valueOf(this.$reverseDirection$inlined));
        e1Var.a().b("interactionSource", this.$interactionSource$inlined);
        e1Var.a().b("thresholds", this.$thresholds$inlined);
        e1Var.a().b("resistance", null);
        e1Var.a().b("velocityThreshold", q2.i.c(this.$velocityThreshold$inlined));
    }
}
