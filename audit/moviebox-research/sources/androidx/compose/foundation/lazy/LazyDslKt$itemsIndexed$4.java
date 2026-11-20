package androidx.compose.foundation.lazy;

import java.util.List;
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
public final class LazyDslKt$itemsIndexed$4 extends Lambda implements Function4<b, Integer, androidx.compose.runtime.i, Integer, Unit> {
    final /* synthetic */ Function5<b, Integer, Object, androidx.compose.runtime.i, Integer, Unit> $itemContent;
    final /* synthetic */ List<Object> $items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyDslKt$itemsIndexed$4(Function5<? super b, ? super Integer, Object, ? super androidx.compose.runtime.i, ? super Integer, Unit> function5, List<Object> list) {
        super(4);
        this.$itemContent = function5;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(b bVar, Integer num, androidx.compose.runtime.i iVar, Integer num2) {
        invoke(bVar, num.intValue(), iVar, num2.intValue());
        return Unit.f68710a;
    }

    public final void invoke(b bVar, int i11, androidx.compose.runtime.i iVar, int i12) {
        int i13;
        if ((i12 & 6) == 0) {
            i13 = (iVar.Q(bVar) ? 4 : 2) | i12;
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
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1091073711, i13, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
        }
        this.$itemContent.invoke(bVar, Integer.valueOf(i11), this.$items.get(i11), iVar, Integer.valueOf((i13 & 14) | (i13 & 112)));
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
    }
}
