package androidx.compose.animation.core;

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
public final class TransitionKt$animateOffset$1 extends Lambda implements Function3<q0.a<Object>, androidx.compose.runtime.i, Integer, o0<y1.g>> {
    public static final TransitionKt$animateOffset$1 INSTANCE = new TransitionKt$animateOffset$1();

    public TransitionKt$animateOffset$1() {
        super(3);
    }

    public final o0<y1.g> invoke(q0.a<Object> aVar, androidx.compose.runtime.i iVar, int i11) {
        iVar.R(1623385561);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1623385561, i11, -1, "androidx.compose.animation.core.animateOffset.<anonymous> (Transition.kt:2025)");
        }
        o0<y1.g> o0VarD = h.d(0.0f, 0.0f, y1.g.d(g1.c(y1.g.f81070b)), 3, null);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return o0VarD;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ o0<y1.g> invoke(q0.a<Object> aVar, androidx.compose.runtime.i iVar, Integer num) {
        return invoke(aVar, iVar, num.intValue());
    }
}
