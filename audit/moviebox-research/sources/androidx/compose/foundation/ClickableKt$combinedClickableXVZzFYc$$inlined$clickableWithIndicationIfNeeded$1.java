package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$clickableWithIndicationIfNeeded$1, reason: invalid class name */
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
public final class ClickableKt$combinedClickableXVZzFYc$$inlined$clickableWithIndicationIfNeeded$1 extends Lambda implements Function3<androidx.compose.ui.f, androidx.compose.runtime.i, Integer, androidx.compose.ui.f> {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ x $indication;
    final /* synthetic */ Function0 $onClick$inlined;
    final /* synthetic */ String $onClickLabel$inlined;
    final /* synthetic */ Function0 $onDoubleClick$inlined;
    final /* synthetic */ Function0 $onLongClick$inlined;
    final /* synthetic */ String $onLongClickLabel$inlined;
    final /* synthetic */ androidx.compose.ui.semantics.i $role$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableKt$combinedClickableXVZzFYc$$inlined$clickableWithIndicationIfNeeded$1(x xVar, boolean z11, String str, androidx.compose.ui.semantics.i iVar, Function0 function0, String str2, Function0 function1, Function0 function2) {
        super(3);
        this.$indication = xVar;
        this.$enabled$inlined = z11;
        this.$onClickLabel$inlined = str;
        this.$role$inlined = iVar;
        this.$onClick$inlined = function0;
        this.$onLongClickLabel$inlined = str2;
        this.$onLongClick$inlined = function1;
        this.$onDoubleClick$inlined = function2;
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
        androidx.compose.ui.f fVarF = IndicationKt.b(androidx.compose.ui.f.f3863a, iVar2, this.$indication).f(new CombinedClickableElement(iVar2, null, this.$enabled$inlined, this.$onClickLabel$inlined, this.$role$inlined, this.$onClick$inlined, this.$onLongClickLabel$inlined, this.$onLongClick$inlined, this.$onDoubleClick$inlined, null));
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
