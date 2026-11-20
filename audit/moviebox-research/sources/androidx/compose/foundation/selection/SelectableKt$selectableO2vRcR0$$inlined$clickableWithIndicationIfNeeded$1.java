package androidx.compose.foundation.selection;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.x;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.ui.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import o1.h;

/* JADX INFO: renamed from: androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1, reason: invalid class name */
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
public final class SelectableKt$selectableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1 extends Lambda implements Function3<f, i, Integer, f> {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ x $indication;
    final /* synthetic */ Function0 $onClick$inlined;
    final /* synthetic */ androidx.compose.ui.semantics.i $role$inlined;
    final /* synthetic */ boolean $selected$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectableKt$selectableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(x xVar, boolean z11, boolean z12, androidx.compose.ui.semantics.i iVar, Function0 function0) {
        super(3);
        this.$indication = xVar;
        this.$selected$inlined = z11;
        this.$enabled$inlined = z12;
        this.$role$inlined = iVar;
        this.$onClick$inlined = function0;
    }

    public final f invoke(f fVar, i iVar, int i11) {
        iVar.R(-1525724089);
        if (k.J()) {
            k.S(-1525724089, i11, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:375)");
        }
        Object objY = iVar.y();
        if (objY == i.f3413a.a()) {
            objY = h.a();
            iVar.p(objY);
        }
        o1.i iVar2 = (o1.i) objY;
        f fVarF = IndicationKt.b(f.f3863a, iVar2, this.$indication).f(new SelectableElement(this.$selected$inlined, iVar2, null, this.$enabled$inlined, this.$role$inlined, this.$onClick$inlined, null));
        if (k.J()) {
            k.R();
        }
        iVar.L();
        return fVarF;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ f invoke(f fVar, i iVar, Integer num) {
        return invoke(fVar, iVar, num.intValue());
    }
}
