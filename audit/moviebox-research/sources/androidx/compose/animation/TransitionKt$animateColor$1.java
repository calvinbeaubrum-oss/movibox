package androidx.compose.animation;

import androidx.compose.animation.core.o0;
import androidx.compose.animation.core.q0;
import androidx.compose.ui.graphics.w1;
import kotlin.Metadata;
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
public final class TransitionKt$animateColor$1 extends Lambda implements Function3<q0.a<Object>, androidx.compose.runtime.i, Integer, o0<w1>> {
    public static final TransitionKt$animateColor$1 INSTANCE = new TransitionKt$animateColor$1();

    public TransitionKt$animateColor$1() {
        super(3);
    }

    public final o0<w1> invoke(q0.a<Object> aVar, androidx.compose.runtime.i iVar, int i11) {
        iVar.R(-1457805428);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1457805428, i11, -1, "androidx.compose.animation.animateColor.<anonymous> (Transition.kt:64)");
        }
        o0<w1> o0VarD = androidx.compose.animation.core.h.d(0.0f, 0.0f, null, 7, null);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return o0VarD;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ o0<w1> invoke(q0.a<Object> aVar, androidx.compose.runtime.i iVar, Integer num) {
        return invoke(aVar, iVar, num.intValue());
    }
}
