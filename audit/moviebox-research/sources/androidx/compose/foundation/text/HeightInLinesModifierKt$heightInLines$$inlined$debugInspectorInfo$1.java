package androidx.compose.foundation.text;

import androidx.compose.ui.platform.e1;
import androidx.compose.ui.text.e0;
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
public final class HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<e1, Unit> {
    final /* synthetic */ int $maxLines$inlined;
    final /* synthetic */ int $minLines$inlined;
    final /* synthetic */ e0 $textStyle$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1(int i11, int i12, e0 e0Var) {
        super(1);
        this.$minLines$inlined = i11;
        this.$maxLines$inlined = i12;
        this.$textStyle$inlined = e0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
        invoke2(e1Var);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e1 e1Var) {
        e1Var.b("heightInLines");
        e1Var.a().b("minLines", Integer.valueOf(this.$minLines$inlined));
        e1Var.a().b("maxLines", Integer.valueOf(this.$maxLines$inlined));
        e1Var.a().b("textStyle", this.$textStyle$inlined);
    }
}
