package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.b0;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import o1.i;

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
public final class ToggleableNode extends ClickableNode {
    public boolean K;
    public Function1<? super Boolean, Unit> L;
    public final Function0<Unit> M;

    public ToggleableNode(final boolean z11, i iVar, b0 b0Var, boolean z12, androidx.compose.ui.semantics.i iVar2, final Function1<? super Boolean, Unit> function1) {
        super(iVar, b0Var, z12, null, iVar2, new Function0<Unit>() { // from class: androidx.compose.foundation.selection.ToggleableNode.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function1.invoke(Boolean.valueOf(!z11));
            }
        }, null);
        this.K = z11;
        this.L = function1;
        this.M = new Function0<Unit>() { // from class: androidx.compose.foundation.selection.ToggleableNode$_onClick$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.L.invoke(Boolean.valueOf(!this.this$0.K));
            }
        };
    }

    public /* synthetic */ ToggleableNode(boolean z11, i iVar, b0 b0Var, boolean z12, androidx.compose.ui.semantics.i iVar2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, iVar, b0Var, z12, iVar2, function1);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void T1(q qVar) {
        SemanticsPropertiesKt.I(qVar, l2.a.a(this.K));
    }

    public final void k2(boolean z11, i iVar, b0 b0Var, boolean z12, androidx.compose.ui.semantics.i iVar2, Function1<? super Boolean, Unit> function1) {
        if (this.K != z11) {
            this.K = z11;
            j1.b(this);
        }
        this.L = function1;
        super.h2(iVar, b0Var, z12, null, iVar2, this.M);
    }
}
