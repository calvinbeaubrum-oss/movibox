package androidx.compose.material;

import androidx.compose.ui.platform.e1;
import androidx.compose.ui.platform.o2;
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
public final class DraggableAnchorsElement$inspectableProperties$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<e1, Unit> {
    final /* synthetic */ DraggableAnchorsElement this$0;

    public DraggableAnchorsElement$inspectableProperties$$inlined$debugInspectorInfo$1(DraggableAnchorsElement draggableAnchorsElement) {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
        invoke2(e1Var);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e1 e1Var) {
        o2 o2VarA = e1Var.a();
        DraggableAnchorsElement.r(null);
        o2VarA.b("state", null);
        e1Var.a().b("anchors", DraggableAnchorsElement.p(null));
        e1Var.a().b("orientation", DraggableAnchorsElement.q(null));
    }
}
