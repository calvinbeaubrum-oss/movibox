package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.f0;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.foundation.t;
import androidx.compose.ui.focus.w;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.s;
import androidx.compose.ui.input.pointer.z;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.node.u0;
import androidx.compose.ui.node.v0;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;

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
public final class ScrollableNode extends DragGestureNode implements u0, androidx.compose.ui.focus.o, e2.e, i1 {
    public g A;
    public final boolean B;
    public final NestedScrollDispatcher C;
    public final l D;
    public final DefaultFlingBehavior E;
    public final ScrollingLogic F;
    public final ScrollableNestedScrollConnection G;
    public final ContentInViewNode H;
    public j I;
    public Function2<? super Float, ? super Float, Boolean> J;
    public Function2<? super y1.g, ? super Continuation<? super y1.g>, ? extends Object> K;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public f0 f2334z;

    public ScrollableNode(o oVar, f0 f0Var, g gVar, Orientation orientation, boolean z11, boolean z12, o1.i iVar, d dVar) {
        super(ScrollableKt.f2328a, z11, iVar, orientation);
        this.f2334z = f0Var;
        this.A = gVar;
        NestedScrollDispatcher nestedScrollDispatcher = new NestedScrollDispatcher();
        this.C = nestedScrollDispatcher;
        this.D = (l) H1(new l(z11));
        DefaultFlingBehavior defaultFlingBehavior = new DefaultFlingBehavior(androidx.compose.animation.j.c(ScrollableKt.f2331d), null, 2, null);
        this.E = defaultFlingBehavior;
        f0 f0Var2 = this.f2334z;
        g gVar2 = this.A;
        ScrollingLogic scrollingLogic = new ScrollingLogic(oVar, f0Var2, gVar2 == null ? defaultFlingBehavior : gVar2, orientation, z12, nestedScrollDispatcher);
        this.F = scrollingLogic;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection = new ScrollableNestedScrollConnection(scrollingLogic, z11);
        this.G = scrollableNestedScrollConnection;
        ContentInViewNode contentInViewNode = (ContentInViewNode) H1(new ContentInViewNode(orientation, scrollingLogic, z12, dVar));
        this.H = contentInViewNode;
        H1(androidx.compose.ui.input.nestedscroll.d.a(scrollableNestedScrollConnection, nestedScrollDispatcher));
        H1(w.a());
        H1(new BringIntoViewResponderNode(contentInViewNode));
        H1(new t(new Function1<androidx.compose.ui.layout.m, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableNode.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.layout.m mVar) {
                invoke2(mVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(androidx.compose.ui.layout.m mVar) {
                ScrollableNode.this.H.b2(mVar);
            }
        }));
    }

    @Override // androidx.compose.ui.focus.o
    public void A0(androidx.compose.ui.focus.m mVar) {
        mVar.r(false);
    }

    @Override // e2.e
    public boolean B0(KeyEvent keyEvent) {
        long jA;
        if (Y1()) {
            long jA2 = e2.d.a(keyEvent);
            e2.a.C0656a c0656a = e2.a.f63630b;
            if ((e2.a.p(jA2, c0656a.j()) || e2.a.p(e2.d.a(keyEvent), c0656a.k())) && e2.c.e(e2.d.b(keyEvent), e2.c.f63782a.a()) && !e2.d.c(keyEvent)) {
                if (this.F.p()) {
                    int iF = q2.t.f(this.H.X1());
                    jA = y1.h.a(0.0f, e2.a.p(e2.d.a(keyEvent), c0656a.k()) ? iF : -iF);
                } else {
                    int iG = q2.t.g(this.H.X1());
                    jA = y1.h.a(e2.a.p(e2.d.a(keyEvent), c0656a.k()) ? iG : -iG, 0.0f);
                }
                kotlinx.coroutines.j.d(h1(), null, null, new ScrollableNode$onKeyEvent$1(this, jA, null), 3, null);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode, androidx.compose.ui.node.e1
    public void T(androidx.compose.ui.input.pointer.q qVar, PointerEventPass pointerEventPass, long j11) {
        List<z> listC = qVar.c();
        int size = listC.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (X1().invoke(listC.get(i11)).booleanValue()) {
                super.T(qVar, pointerEventPass, j11);
                break;
            }
        }
        if (pointerEventPass == PointerEventPass.Main && s.i(qVar.f(), s.f4737a.f())) {
            m2(qVar, j11);
        }
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean V() {
        return h1.a(this);
    }

    @Override // androidx.compose.ui.node.i1
    public void W0(androidx.compose.ui.semantics.q qVar) {
        if (Y1() && (this.J == null || this.K == null)) {
            n2();
        }
        Function2<? super Float, ? super Float, Boolean> function2 = this.J;
        if (function2 != null) {
            SemanticsPropertiesKt.q(qVar, null, function2, 1, null);
        }
        Function2<? super y1.g, ? super Continuation<? super y1.g>, ? extends Object> function3 = this.K;
        if (function3 != null) {
            SemanticsPropertiesKt.r(qVar, function3);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object W1(Function2<? super Function1<? super e.b, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ScrollingLogic scrollingLogic = this.F;
        Object objV = scrollingLogic.v(MutatePriority.UserInput, new ScrollableNode$drag$2$1(function2, scrollingLogic, null), continuation);
        return objV == kotlin.coroutines.intrinsics.a.e() ? objV : Unit.f68710a;
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean Z0() {
        return h1.b(this);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void a2(long j11) {
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void b2(long j11) {
        kotlinx.coroutines.j.d(this.C.e(), null, null, new ScrollableNode$onDragStopped$1(this, j11, null), 3, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean f2() {
        return this.F.w();
    }

    @Override // androidx.compose.ui.node.u0
    public void g0() {
        p2();
    }

    public final void l2() {
        this.J = null;
        this.K = null;
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return this.B;
    }

    public final void m2(androidx.compose.ui.input.pointer.q qVar, long j11) {
        List<z> listC = qVar.c();
        int size = listC.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!(!listC.get(i11).p())) {
                return;
            }
        }
        j jVar = this.I;
        Intrinsics.d(jVar);
        kotlinx.coroutines.j.d(h1(), null, null, new ScrollableNode$processMouseWheelEvent$2$1(this, jVar.a(androidx.compose.ui.node.g.i(this), qVar, j11), null), 3, null);
        List<z> listC2 = qVar.c();
        int size2 = listC2.size();
        for (int i12 = 0; i12 < size2; i12++) {
            listC2.get(i12).a();
        }
    }

    public final void n2() {
        this.J = new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1", f = "Scrollable.kt", l = {522}, m = "invokeSuspend")
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ float $x;
                final /* synthetic */ float $y;
                int label;
                final /* synthetic */ ScrollableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ScrollableNode scrollableNode, float f11, float f12, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = scrollableNode;
                    this.$x = f11;
                    this.$y = f12;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$x, this.$y, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objE = kotlin.coroutines.intrinsics.a.e();
                    int i11 = this.label;
                    if (i11 == 0) {
                        ResultKt.b(obj);
                        ScrollingLogic scrollingLogic = this.this$0.F;
                        long jA = y1.h.a(this.$x, this.$y);
                        this.label = 1;
                        if (ScrollableKt.g(scrollingLogic, jA, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f68710a;
                }
            }

            {
                super(2);
            }

            public final Boolean invoke(float f11, float f12) {
                kotlinx.coroutines.j.d(this.this$0.h1(), null, null, new AnonymousClass1(this.this$0, f11, f12, null), 3, null);
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Float f11, Float f12) {
                return invoke(f11.floatValue(), f12.floatValue());
            }
        };
        this.K = new ScrollableNode$setScrollSemanticsActions$2(this, null);
    }

    public final void o2(o oVar, Orientation orientation, f0 f0Var, boolean z11, boolean z12, g gVar, o1.i iVar, d dVar) {
        boolean z13;
        if (Y1() != z11) {
            this.G.a(z11);
            this.D.I1(z11);
            z13 = true;
        } else {
            z13 = false;
        }
        boolean zC = this.F.C(oVar, orientation, f0Var, z12, gVar == null ? this.E : gVar, this.C);
        this.H.e2(orientation, z12, dVar);
        this.f2334z = f0Var;
        this.A = gVar;
        h2(ScrollableKt.f2328a, z11, iVar, this.F.p() ? Orientation.Vertical : Orientation.Horizontal, zC);
        if (z13) {
            l2();
            j1.b(this);
        }
    }

    public final void p2() {
        v0.a(this, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableNode$updateDefaultFlingBehavior$1
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
                this.this$0.E.d(androidx.compose.animation.j.c((q2.e) androidx.compose.ui.node.e.a(this.this$0, CompositionLocalsKt.c())));
            }
        });
    }

    @Override // androidx.compose.ui.f.c
    public void r1() {
        p2();
        this.I = b.a(this);
    }

    @Override // e2.e
    public boolean t0(KeyEvent keyEvent) {
        return false;
    }
}
