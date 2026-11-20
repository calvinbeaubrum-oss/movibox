package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.m1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class SubcomposeLayoutState {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4844f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t0 f4845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutNodeSubcompositionsState f4846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<LayoutNode, SubcomposeLayoutState, Unit> f4847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<LayoutNode, androidx.compose.runtime.m, Unit> f4848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<LayoutNode, Function2<? super s0, ? super q2.b, ? extends w>, Unit> f4849e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(Object obj, Function1<? super m1, ? extends TraversableNode$Companion$TraverseDescendantsAction> function1);

        int b();

        void c(int i11, long j11);

        void dispose();
    }

    public SubcomposeLayoutState() {
        this(b0.f4852a);
    }

    public SubcomposeLayoutState(t0 t0Var) {
        this.f4845a = t0Var;
        this.f4847c = new Function2<LayoutNode, SubcomposeLayoutState, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
                invoke2(layoutNode, subcomposeLayoutState);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
                SubcomposeLayoutState subcomposeLayoutState2 = this.this$0;
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsStateK0 = layoutNode.k0();
                if (layoutNodeSubcompositionsStateK0 == null) {
                    layoutNodeSubcompositionsStateK0 = new LayoutNodeSubcompositionsState(layoutNode, this.this$0.f4845a);
                    layoutNode.t1(layoutNodeSubcompositionsStateK0);
                }
                subcomposeLayoutState2.f4846b = layoutNodeSubcompositionsStateK0;
                this.this$0.h().y();
                this.this$0.h().G(this.this$0.f4845a);
            }
        };
        this.f4848d = new Function2<LayoutNode, androidx.compose.runtime.m, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setCompositionContext$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, androidx.compose.runtime.m mVar) {
                invoke2(layoutNode, mVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, androidx.compose.runtime.m mVar) {
                this.this$0.h().F(mVar);
            }
        };
        this.f4849e = new Function2<LayoutNode, Function2<? super s0, ? super q2.b, ? extends w>, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setMeasurePolicy$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Function2<? super s0, ? super q2.b, ? extends w> function2) {
                invoke2(layoutNode, function2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, Function2<? super s0, ? super q2.b, ? extends w> function2) {
                layoutNode.g(this.this$0.h().r(function2));
            }
        };
    }

    public final void d() {
        h().w();
    }

    public final Function2<LayoutNode, androidx.compose.runtime.m, Unit> e() {
        return this.f4848d;
    }

    public final Function2<LayoutNode, Function2<? super s0, ? super q2.b, ? extends w>, Unit> f() {
        return this.f4849e;
    }

    public final Function2<LayoutNode, SubcomposeLayoutState, Unit> g() {
        return this.f4847c;
    }

    public final LayoutNodeSubcompositionsState h() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.f4846b;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout".toString());
    }

    public final a i(Object obj, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        return h().D(obj, function2);
    }
}
