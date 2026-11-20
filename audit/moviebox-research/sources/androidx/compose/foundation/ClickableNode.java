package androidx.compose.foundation;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public class ClickableNode extends AbstractClickableNode {
    public ClickableNode(o1.i iVar, b0 b0Var, boolean z11, String str, androidx.compose.ui.semantics.i iVar2, Function0<Unit> function0) {
        super(iVar, b0Var, z11, str, iVar2, function0, null);
    }

    public /* synthetic */ ClickableNode(o1.i iVar, b0 b0Var, boolean z11, String str, androidx.compose.ui.semantics.i iVar2, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, b0Var, z11, str, iVar2, function0);
    }

    public static /* synthetic */ Object g2(final ClickableNode clickableNode, androidx.compose.ui.input.pointer.h0 h0Var, Continuation<? super Unit> continuation) {
        Object objH = TapGestureDetectorKt.h(h0Var, new ClickableNode$clickPointerInput$2(clickableNode, null), new Function1<y1.g, Unit>() { // from class: androidx.compose.foundation.ClickableNode$clickPointerInput$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y1.g gVar) {
                m13invokek4lQ0M(gVar.v());
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m13invokek4lQ0M(long j11) {
                if (this.this$0.Z1()) {
                    this.this$0.a2().invoke();
                }
            }
        }, continuation);
        return objH == kotlin.coroutines.intrinsics.a.e() ? objH : Unit.f68710a;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public Object U1(androidx.compose.ui.input.pointer.h0 h0Var, Continuation<? super Unit> continuation) {
        return g2(this, h0Var, continuation);
    }

    public final void h2(o1.i iVar, b0 b0Var, boolean z11, String str, androidx.compose.ui.semantics.i iVar2, Function0<Unit> function0) {
        f2(iVar, b0Var, z11, str, iVar2, function0);
    }
}
