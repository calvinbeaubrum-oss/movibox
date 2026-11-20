package androidx.compose.foundation;

import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x4;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.e1;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class BackgroundKt {
    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, final long j11, final c5 c5Var) {
        return fVar.f(new BackgroundElement(j11, null, 1.0f, c5Var, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.BackgroundKt$background-bw27NRU$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                invoke2(e1Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e1 e1Var) {
                e1Var.b("background");
                e1Var.c(w1.g(j11));
                e1Var.a().b(TtmlNode.ATTR_TTS_COLOR, w1.g(j11));
                e1Var.a().b("shape", c5Var);
            }
        } : InspectableValueKt.a(), 2, null));
    }

    public static /* synthetic */ androidx.compose.ui.f b(androidx.compose.ui.f fVar, long j11, c5 c5Var, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c5Var = x4.a();
        }
        return a(fVar, j11, c5Var);
    }
}
