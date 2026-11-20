package androidx.compose.ui.draganddrop;

import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class DragAndDropNode extends androidx.compose.ui.f.c implements m1, d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f3815s = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f3816t = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<b, f> f3817o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Object f3818p = a.C0053a.f3821a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f3819q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f f3820r;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: androidx.compose.ui.draganddrop.DragAndDropNode$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0053a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0053a f3821a = new C0053a();
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DragAndDropNode(Function1<? super b, ? extends f> function1) {
        this.f3817o = function1;
    }

    @Override // androidx.compose.ui.draganddrop.f
    public void G(b bVar) {
        f fVar = this.f3820r;
        if (fVar != null) {
            fVar.G(bVar);
            return;
        }
        d dVar = this.f3819q;
        if (dVar != null) {
            dVar.G(bVar);
        }
    }

    @Override // androidx.compose.ui.draganddrop.f
    public void H(final b bVar) {
        m1 m1Var;
        d dVar;
        d dVar2 = this.f3819q;
        if (dVar2 == null || !e.d(dVar2, h.a(bVar))) {
            if (getNode().o1()) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                n1.f(this, new Function1<DragAndDropNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public final TraversableNode$Companion$TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                        DragAndDropNode dragAndDropNode2 = dragAndDropNode;
                        if (!androidx.compose.ui.node.g.n(this).getDragAndDropManager().a(dragAndDropNode2) || !e.d(dragAndDropNode2, h.a(bVar))) {
                            return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                        }
                        objectRef.element = dragAndDropNode;
                        return TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal;
                    }
                });
                m1Var = (m1) objectRef.element;
            } else {
                m1Var = null;
            }
            dVar = (d) m1Var;
        } else {
            dVar = dVar2;
        }
        if (dVar != null && dVar2 == null) {
            e.e(dVar, bVar);
            f fVar = this.f3820r;
            if (fVar != null) {
                fVar.S(bVar);
            }
        } else if (dVar == null && dVar2 != null) {
            f fVar2 = this.f3820r;
            if (fVar2 != null) {
                e.e(fVar2, bVar);
            }
            dVar2.S(bVar);
        } else if (!Intrinsics.b(dVar, dVar2)) {
            if (dVar != null) {
                e.e(dVar, bVar);
            }
            if (dVar2 != null) {
                dVar2.S(bVar);
            }
        } else if (dVar != null) {
            dVar.H(bVar);
        } else {
            f fVar3 = this.f3820r;
            if (fVar3 != null) {
                fVar3.H(bVar);
            }
        }
        this.f3819q = dVar;
    }

    public boolean H1(final b bVar) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        e.f(this, new Function1<DragAndDropNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$acceptDragAndDropTransfer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode$Companion$TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                if (!dragAndDropNode.o1()) {
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
                if (!(dragAndDropNode.f3820r == null)) {
                    h2.a.b("DragAndDropTarget self reference must be null at the start of a drag and drop session");
                }
                dragAndDropNode.f3820r = (f) dragAndDropNode.f3817o.invoke(bVar);
                boolean z11 = dragAndDropNode.f3820r != null;
                if (z11) {
                    androidx.compose.ui.node.g.n(this).getDragAndDropManager().b(dragAndDropNode);
                }
                Ref.BooleanRef booleanRef2 = booleanRef;
                booleanRef2.element = booleanRef2.element || z11;
                return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
            }
        });
        return booleanRef.element;
    }

    @Override // androidx.compose.ui.node.m1
    public Object I() {
        return this.f3818p;
    }

    @Override // androidx.compose.ui.draganddrop.f
    public void S(b bVar) {
        f fVar = this.f3820r;
        if (fVar != null) {
            fVar.S(bVar);
        }
        d dVar = this.f3819q;
        if (dVar != null) {
            dVar.S(bVar);
        }
        this.f3819q = null;
    }

    @Override // androidx.compose.ui.draganddrop.f
    public void b1(final b bVar) {
        e.f(this, new Function1<DragAndDropNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$onEnded$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode$Companion$TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                if (!dragAndDropNode.getNode().o1()) {
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
                f fVar = dragAndDropNode.f3820r;
                if (fVar != null) {
                    fVar.b1(bVar);
                }
                dragAndDropNode.f3820r = null;
                dragAndDropNode.f3819q = null;
                return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
            }
        });
    }

    @Override // androidx.compose.ui.draganddrop.f
    public void h0(b bVar) {
        f fVar = this.f3820r;
        if (fVar != null) {
            fVar.h0(bVar);
            return;
        }
        d dVar = this.f3819q;
        if (dVar != null) {
            dVar.h0(bVar);
        }
    }

    @Override // androidx.compose.ui.draganddrop.f
    public boolean s0(b bVar) {
        d dVar = this.f3819q;
        if (dVar != null) {
            return dVar.s0(bVar);
        }
        f fVar = this.f3820r;
        if (fVar != null) {
            return fVar.s0(bVar);
        }
        return false;
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        this.f3820r = null;
        this.f3819q = null;
    }
}
