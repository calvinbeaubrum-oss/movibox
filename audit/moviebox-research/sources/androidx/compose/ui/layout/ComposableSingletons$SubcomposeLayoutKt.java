package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

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
public final class ComposableSingletons$SubcomposeLayoutKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$SubcomposeLayoutKt f4789a = new ComposableSingletons$SubcomposeLayoutKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function2<androidx.compose.runtime.i, Integer, Unit> f4790b = androidx.compose.runtime.internal.b.c(-1741544742, false, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.layout.ComposableSingletons$SubcomposeLayoutKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar, Integer num) {
            invoke(iVar, num.intValue());
            return Unit.f68710a;
        }

        public final void invoke(androidx.compose.runtime.i iVar, int i11) {
            if ((i11 & 3) == 2 && iVar.h()) {
                iVar.H();
                return;
            }
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-1741544742, i11, -1, "androidx.compose.ui.layout.ComposableSingletons$SubcomposeLayoutKt.lambda-1.<anonymous> (SubcomposeLayout.kt:473)");
            }
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
    });

    public final Function2<androidx.compose.runtime.i, Integer, Unit> a() {
        return f4790b;
    }
}
