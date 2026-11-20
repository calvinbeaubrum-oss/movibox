package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.b0;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class a extends ClickableNode {
    public boolean K;

    public a(boolean z11, i iVar, b0 b0Var, boolean z12, androidx.compose.ui.semantics.i iVar2, Function0<Unit> function0) {
        super(iVar, b0Var, z12, null, iVar2, function0, null);
        this.K = z11;
    }

    public /* synthetic */ a(boolean z11, i iVar, b0 b0Var, boolean z12, androidx.compose.ui.semantics.i iVar2, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, iVar, b0Var, z12, iVar2, function0);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void T1(q qVar) {
        SemanticsPropertiesKt.C(qVar, this.K);
    }

    public final void i2(boolean z11, i iVar, b0 b0Var, boolean z12, androidx.compose.ui.semantics.i iVar2, Function0<Unit> function0) {
        if (this.K != z11) {
            this.K = z11;
            j1.b(this);
        }
        super.h2(iVar, b0Var, z12, null, iVar2, function0);
    }
}
