package androidx.compose.foundation.relocation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.ui.layout.m;
import androidx.compose.ui.layout.n;
import androidx.compose.ui.node.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import y1.i;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class e {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.compose.foundation.relocation.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.compose.ui.node.f f2833a;

        public a(androidx.compose.ui.node.f fVar) {
            this.f2833a = fVar;
        }

        @Override // androidx.compose.foundation.relocation.a
        public final Object a0(m mVar, Function0<i> function0, Continuation<? super Unit> continuation) {
            View viewA = h.a(this.f2833a);
            long jE = n.e(mVar);
            i iVarInvoke = function0.invoke();
            i iVarQ = iVarInvoke != null ? iVarInvoke.q(jE) : null;
            if (iVarQ != null) {
                viewA.requestRectangleOnScreen(e.c(iVarQ), false);
            }
            return Unit.f68710a;
        }
    }

    public static final androidx.compose.foundation.relocation.a b(androidx.compose.ui.node.f fVar) {
        return new a(fVar);
    }

    public static final Rect c(i iVar) {
        return new Rect((int) iVar.f(), (int) iVar.i(), (int) iVar.g(), (int) iVar.c());
    }
}
