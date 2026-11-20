package androidx.compose.foundation;

import androidx.compose.ui.focus.FocusRequesterModifierNodeKt;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
public final class FocusableNode extends androidx.compose.ui.node.i implements androidx.compose.ui.focus.d, i1, androidx.compose.ui.node.p, androidx.compose.ui.focus.t {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f2237q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public androidx.compose.ui.focus.u f2238r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final FocusableInteractionNode f2239s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final FocusablePinnableContainerNode f2240t = (FocusablePinnableContainerNode) H1(new FocusablePinnableContainerNode());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s f2241u = (s) H1(new s());

    public FocusableNode(o1.i iVar) {
        this.f2239s = (FocusableInteractionNode) H1(new FocusableInteractionNode(iVar));
        H1(androidx.compose.ui.focus.w.a());
    }

    @Override // androidx.compose.ui.focus.d
    public void D(androidx.compose.ui.focus.u uVar) {
        if (Intrinsics.b(this.f2238r, uVar)) {
            return;
        }
        boolean zIsFocused = uVar.isFocused();
        if (zIsFocused) {
            kotlinx.coroutines.j.d(h1(), null, null, new FocusableNode$onFocusEvent$1(this, null), 3, null);
        }
        if (o1()) {
            j1.b(this);
        }
        this.f2239s.J1(zIsFocused);
        this.f2241u.J1(zIsFocused);
        this.f2240t.I1(zIsFocused);
        this.f2238r = uVar;
    }

    public final void N1(o1.i iVar) {
        this.f2239s.K1(iVar);
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean V() {
        return h1.a(this);
    }

    @Override // androidx.compose.ui.node.i1
    public void W0(androidx.compose.ui.semantics.q qVar) {
        androidx.compose.ui.focus.u uVar = this.f2238r;
        boolean z11 = false;
        if (uVar != null && uVar.isFocused()) {
            z11 = true;
        }
        SemanticsPropertiesKt.w(qVar, z11);
        SemanticsPropertiesKt.o(qVar, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.FocusableNode$applySemantics$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(FocusRequesterModifierNodeKt.a(this.this$0));
            }
        }, 1, null);
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean Z0() {
        return h1.b(this);
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return this.f2237q;
    }

    @Override // androidx.compose.ui.node.p
    public void x(androidx.compose.ui.layout.m mVar) {
        this.f2241u.x(mVar);
    }
}
