package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.d1;
import androidx.compose.ui.node.e1;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class PointerHoverIconModifierNode extends androidx.compose.ui.f.c implements m1, e1, androidx.compose.ui.node.d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f4636o = "androidx.compose.ui.input.pointer.PointerHoverIcon";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public u f4637p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4638q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4639r;

    public PointerHoverIconModifierNode(u uVar, boolean z11) {
        this.f4637p = uVar;
        this.f4638q = z11;
    }

    private final w Q1() {
        return (w) androidx.compose.ui.node.e.a(this, CompositionLocalsKt.h());
    }

    private final void S1() {
        this.f4639r = true;
        M1();
    }

    private final void T1() {
        if (this.f4639r) {
            this.f4639r = false;
            if (o1()) {
                K1();
            }
        }
    }

    @Override // androidx.compose.ui.node.e1
    public void D0() {
        T1();
    }

    public final void I1() {
        w wVarQ1 = Q1();
        if (wVarQ1 != null) {
            wVarQ1.a(null);
        }
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void J0() {
        d1.b(this);
    }

    public final void J1() {
        u uVar;
        PointerHoverIconModifierNode pointerHoverIconModifierNodeO1 = O1();
        if (pointerHoverIconModifierNodeO1 == null || (uVar = pointerHoverIconModifierNodeO1.f4637p) == null) {
            uVar = this.f4637p;
        }
        w wVarQ1 = Q1();
        if (wVarQ1 != null) {
            wVarQ1.a(uVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K1() {
        Unit unit;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        n1.d(this, new Function1<PointerHoverIconModifierNode, Boolean>() { // from class: androidx.compose.ui.input.pointer.PointerHoverIconModifierNode$displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
                if (objectRef.element == null && pointerHoverIconModifierNode.f4639r) {
                    objectRef.element = pointerHoverIconModifierNode;
                } else if (objectRef.element != null && pointerHoverIconModifierNode.P1() && pointerHoverIconModifierNode.f4639r) {
                    objectRef.element = pointerHoverIconModifierNode;
                }
                return Boolean.TRUE;
            }
        });
        PointerHoverIconModifierNode pointerHoverIconModifierNode = (PointerHoverIconModifierNode) objectRef.element;
        if (pointerHoverIconModifierNode != null) {
            pointerHoverIconModifierNode.J1();
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            I1();
        }
    }

    public final void L1() {
        PointerHoverIconModifierNode pointerHoverIconModifierNodeN1;
        if (this.f4639r) {
            if (this.f4638q || (pointerHoverIconModifierNodeN1 = N1()) == null) {
                pointerHoverIconModifierNodeN1 = this;
            }
            pointerHoverIconModifierNodeN1.J1();
        }
    }

    public final void M1() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (!this.f4638q) {
            n1.f(this, new Function1<PointerHoverIconModifierNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.input.pointer.PointerHoverIconModifierNode$displayIconIfDescendantsDoNotHavePriority$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final TraversableNode$Companion$TraverseDescendantsAction invoke(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
                    if (!pointerHoverIconModifierNode.f4639r) {
                        return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                    }
                    booleanRef.element = false;
                    return TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal;
                }
            });
        }
        if (booleanRef.element) {
            J1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PointerHoverIconModifierNode N1() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        n1.f(this, new Function1<PointerHoverIconModifierNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.input.pointer.PointerHoverIconModifierNode$findDescendantNodeWithCursorInBounds$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode$Companion$TraverseDescendantsAction invoke(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
                TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                if (!pointerHoverIconModifierNode.f4639r) {
                    return traversableNode$Companion$TraverseDescendantsAction;
                }
                objectRef.element = pointerHoverIconModifierNode;
                return pointerHoverIconModifierNode.P1() ? TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal : traversableNode$Companion$TraverseDescendantsAction;
            }
        });
        return (PointerHoverIconModifierNode) objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PointerHoverIconModifierNode O1() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        n1.d(this, new Function1<PointerHoverIconModifierNode, Boolean>() { // from class: androidx.compose.ui.input.pointer.PointerHoverIconModifierNode$findOverridingAncestorNode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
                if (pointerHoverIconModifierNode.P1() && pointerHoverIconModifierNode.f4639r) {
                    objectRef.element = pointerHoverIconModifierNode;
                }
                return Boolean.TRUE;
            }
        });
        return (PointerHoverIconModifierNode) objectRef.element;
    }

    public final boolean P1() {
        return this.f4638q;
    }

    @Override // androidx.compose.ui.node.m1
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public String I() {
        return this.f4636o;
    }

    @Override // androidx.compose.ui.node.e1
    public void T(q qVar, PointerEventPass pointerEventPass, long j11) {
        if (pointerEventPass == PointerEventPass.Main) {
            int iF = qVar.f();
            s.a aVar = s.f4737a;
            if (s.i(iF, aVar.a())) {
                S1();
            } else if (s.i(qVar.f(), aVar.b())) {
                T1();
            }
        }
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean U0() {
        return d1.d(this);
    }

    public final void U1(u uVar) {
        if (Intrinsics.b(this.f4637p, uVar)) {
            return;
        }
        this.f4637p = uVar;
        if (this.f4639r) {
            M1();
        }
    }

    public final void V1(boolean z11) {
        if (this.f4638q != z11) {
            this.f4638q = z11;
            if (z11) {
                if (this.f4639r) {
                    J1();
                }
            } else if (this.f4639r) {
                L1();
            }
        }
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void X0() {
        d1.c(this);
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean Y() {
        return d1.a(this);
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        T1();
        super.s1();
    }
}
