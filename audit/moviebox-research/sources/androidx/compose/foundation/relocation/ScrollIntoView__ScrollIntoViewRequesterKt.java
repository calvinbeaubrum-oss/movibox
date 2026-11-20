package androidx.compose.foundation.relocation;

import androidx.compose.ui.layout.m;
import androidx.compose.ui.node.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import q2.u;
import y1.i;
import y1.n;

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
public final /* synthetic */ class ScrollIntoView__ScrollIntoViewRequesterKt {
    public static final Object a(androidx.compose.ui.node.f fVar, final i iVar, Continuation<? super Unit> continuation) {
        Object objA0;
        if (!fVar.getNode().o1()) {
            return Unit.f68710a;
        }
        final m mVarK = g.k(fVar);
        a aVarA = b.a(fVar);
        return (aVarA != null && (objA0 = aVarA.a0(mVarK, new Function0<i>() { // from class: androidx.compose.foundation.relocation.ScrollIntoView__ScrollIntoViewRequesterKt$scrollIntoView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final i invoke() {
                i iVar2 = iVar;
                if (iVar2 != null) {
                    return iVar2;
                }
                m mVar = mVarK;
                if (!mVar.D()) {
                    mVar = null;
                }
                if (mVar != null) {
                    return n.c(u.d(mVar.p()));
                }
                return null;
            }
        }, continuation)) == kotlin.coroutines.intrinsics.a.e()) ? objA0 : Unit.f68710a;
    }

    public static /* synthetic */ Object b(androidx.compose.ui.node.f fVar, i iVar, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            iVar = null;
        }
        return f.a(fVar, iVar, continuation);
    }
}
