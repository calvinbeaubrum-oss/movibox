package androidx.compose.foundation;

import androidx.compose.ui.platform.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1, reason: invalid class name */
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
public final class ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<e1, Unit> {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ Function0 $onClick$inlined;
    final /* synthetic */ String $onClickLabel$inlined;
    final /* synthetic */ Function0 $onDoubleClick$inlined;
    final /* synthetic */ Function0 $onLongClick$inlined;
    final /* synthetic */ String $onLongClickLabel$inlined;
    final /* synthetic */ androidx.compose.ui.semantics.i $role$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1(boolean z11, String str, androidx.compose.ui.semantics.i iVar, Function0 function0, Function0 function1, Function0 function2, String str2) {
        super(1);
        this.$enabled$inlined = z11;
        this.$onClickLabel$inlined = str;
        this.$role$inlined = iVar;
        this.$onClick$inlined = function0;
        this.$onDoubleClick$inlined = function1;
        this.$onLongClick$inlined = function2;
        this.$onLongClickLabel$inlined = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
        invoke2(e1Var);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e1 e1Var) {
        e1Var.b("combinedClickable");
        e1Var.a().b("enabled", Boolean.valueOf(this.$enabled$inlined));
        e1Var.a().b("onClickLabel", this.$onClickLabel$inlined);
        e1Var.a().b("role", this.$role$inlined);
        e1Var.a().b("onClick", this.$onClick$inlined);
        e1Var.a().b("onDoubleClick", this.$onDoubleClick$inlined);
        e1Var.a().b("onLongClick", this.$onLongClick$inlined);
        e1Var.a().b("onLongClickLabel", this.$onLongClickLabel$inlined);
    }
}
