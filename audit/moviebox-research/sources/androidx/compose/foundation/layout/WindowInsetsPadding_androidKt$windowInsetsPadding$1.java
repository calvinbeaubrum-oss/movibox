package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class WindowInsetsPadding_androidKt$windowInsetsPadding$1 extends Lambda implements Function3<androidx.compose.ui.f, androidx.compose.runtime.i, Integer, androidx.compose.ui.f> {
    final /* synthetic */ Function1<WindowInsetsHolder, h0> $insetsCalculation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WindowInsetsPadding_androidKt$windowInsetsPadding$1(Function1<? super WindowInsetsHolder, ? extends h0> function1) {
        super(3);
        this.$insetsCalculation = function1;
    }

    public final androidx.compose.ui.f invoke(androidx.compose.ui.f fVar, androidx.compose.runtime.i iVar, int i11) {
        iVar.R(359872873);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(359872873, i11, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:249)");
        }
        WindowInsetsHolder windowInsetsHolderC = WindowInsetsHolder.f2435x.c(iVar, 6);
        boolean zQ = iVar.Q(windowInsetsHolderC);
        Function1<WindowInsetsHolder, h0> function1 = this.$insetsCalculation;
        Object objY = iVar.y();
        if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
            objY = new InsetsPaddingModifier(function1.invoke(windowInsetsHolderC));
            iVar.p(objY);
        }
        InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) objY;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return insetsPaddingModifier;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ androidx.compose.ui.f invoke(androidx.compose.ui.f fVar, androidx.compose.runtime.i iVar, Integer num) {
        return invoke(fVar, iVar, num.intValue());
    }
}
