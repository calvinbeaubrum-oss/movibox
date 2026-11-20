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
public final class TransitionKt$animateSize$1 extends Lambda implements Function3<q0.a<Object>, androidx.compose.runtime.i, Integer, o0<y1.m>> {
    public static final TransitionKt$animateSize$1 INSTANCE = new TransitionKt$animateSize$1();

    public TransitionKt$animateSize$1() {
        super(3);
    }

    public final o0<y1.m> invoke(q0.a<Object> aVar, androidx.compose.runtime.i iVar, int i11) {
        iVar.R(-1607152761);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1607152761, i11, -1, "androidx.compose.animation.core.animateSize.<anonymous> (Transition.kt:2056)");
        }
        o0<y1.m> o0VarD = h.d(0.0f, 0.0f, y1.m.c(g1.d(y1.m.f81091b)), 3, null);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return o0VarD;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ o0<y1.m> invoke(q0.a<Object> aVar, androidx.compose.runtime.i iVar, Integer num) {
        return invoke(aVar, iVar, num.intValue());
    }
}
