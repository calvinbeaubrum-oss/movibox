package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
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
public final class LazyStaggeredGridDslKt$itemsIndexed$10 extends Lambda implements Function4<a, Integer, i, Integer, Unit> {
    final /* synthetic */ Function5<a, Integer, Object, i, Integer, Unit> $itemContent;
    final /* synthetic */ Object[] $items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridDslKt$itemsIndexed$10(Function5<? super a, ? super Integer, Object, ? super i, ? super Integer, Unit> function5, Object[] objArr) {
        super(4);
        this.$itemContent = function5;
        this.$items = objArr;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(a aVar, Integer num, i iVar, Integer num2) {
        invoke(aVar, num.intValue(), iVar, num2.intValue());
        return Unit.f68710a;
    }

    public final void invoke(a aVar, int i11, i iVar, int i12) {
        int i13;
        if ((i12 & 6) == 0) {
            i13 = (iVar.Q(aVar) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 48) == 0) {
            i13 |= iVar.c(i11) ? 32 : 16;
        }
        if ((i13 & 147) == 146 && iVar.h()) {
            iVar.H();
            return;
        }
        if (k.J()) {
            k.S(-804487775, i13, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:465)");
        }
        this.$itemContent.invoke(aVar, Integer.valueOf(i11), this.$items[i11], iVar, Integer.valueOf((i13 & 14) | (i13 & 112)));
        if (k.J()) {
            k.R();
        }
    }
}
