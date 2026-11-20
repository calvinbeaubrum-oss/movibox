package androidx.compose.material3;

import androidx.compose.ui.platform.e1;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
public final class SwipeableV2Kt$swipeAnchors$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<e1, Unit> {
    final /* synthetic */ a $anchorChangeHandler$inlined;
    final /* synthetic */ Function2 $calculateAnchor$inlined;
    final /* synthetic */ Set $possibleValues$inlined;
    final /* synthetic */ j $state$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableV2Kt$swipeAnchors$$inlined$debugInspectorInfo$1(j jVar, Set set, a aVar, Function2 function2) {
        super(1);
        this.$possibleValues$inlined = set;
        this.$calculateAnchor$inlined = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
        invoke2(e1Var);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e1 e1Var) {
        Intrinsics.g(e1Var, "$this$null");
        e1Var.b("swipeAnchors");
        e1Var.a().b("state", null);
        e1Var.a().b("possibleValues", this.$possibleValues$inlined);
        e1Var.a().b("anchorChangeHandler", null);
        e1Var.a().b("calculateAnchor", this.$calculateAnchor$inlined);
    }
}
