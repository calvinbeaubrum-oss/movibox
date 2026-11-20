package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class ClickableKt$clickableWithIndicationIfNeeded$1 extends Lambda implements Function3<androidx.compose.ui.f, androidx.compose.runtime.i, Integer, androidx.compose.ui.f> {
    final /* synthetic */ Function2<o1.i, b0, androidx.compose.ui.f> $createClickable;
    final /* synthetic */ x $indication;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ClickableKt$clickableWithIndicationIfNeeded$1(x xVar, Function2<? super o1.i, ? super b0, ? extends androidx.compose.ui.f> function2) {
        super(3);
        this.$indication = xVar;
        this.$createClickable = function2;
    }

    public final androidx.compose.ui.f invoke(androidx.compose.ui.f fVar, androidx.compose.runtime.i iVar, int i11) {
        iVar.R(-1525724089);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1525724089, i11, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:375)");
        }
        Object objY = iVar.y();
        if (objY == androidx.compose.runtime.i.f3413a.a()) {
            objY = o1.h.a();
            iVar.p(objY);
        }
        o1.i iVar2 = (o1.i) objY;
        androidx.compose.ui.f fVarF = IndicationKt.b(androidx.compose.ui.f.f3863a, iVar2, this.$indication).f(this.$createClickable.invoke(iVar2, null));
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return fVarF;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ androidx.compose.ui.f invoke(androidx.compose.ui.f fVar, androidx.compose.runtime.i iVar, Integer num) {
        return invoke(fVar, iVar, num.intValue());
    }
}
