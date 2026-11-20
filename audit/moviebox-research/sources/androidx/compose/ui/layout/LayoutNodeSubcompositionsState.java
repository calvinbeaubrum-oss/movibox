package androidx.compose.ui.layout;

import androidx.compose.runtime.d2;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import androidx.compose.ui.platform.e3;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class LayoutNodeSubcompositionsState implements androidx.compose.runtime.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutNode f4791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.compose.runtime.m f4792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t0 f4793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4794d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4795f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4805p;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<LayoutNode, a> f4796g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<Object, LayoutNode> f4797h = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f4798i = new c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f4799j = new b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<Object, LayoutNode> f4800k = new HashMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final t0.a f4801l = new t0.a(null, 1, null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Object, SubcomposeLayoutState.a> f4802m = new LinkedHashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<Object> f4803n = new androidx.compose.runtime.collection.b<>(new Object[16], 0);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f4806q = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f4807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> f4808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d2 f4809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f4811e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public i1<Boolean> f4812f;

        public a(Object obj, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2, d2 d2Var) {
            this.f4807a = obj;
            this.f4808b = function2;
            this.f4809c = d2Var;
            this.f4812f = u2.c(Boolean.TRUE, null, 2, null);
        }

        public /* synthetic */ a(Object obj, Function2 function2, d2 d2Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i11 & 4) != 0 ? null : d2Var);
        }

        public final boolean a() {
            return this.f4812f.getValue().booleanValue();
        }

        public final d2 b() {
            return this.f4809c;
        }

        public final Function2<androidx.compose.runtime.i, Integer, Unit> c() {
            return this.f4808b;
        }

        public final boolean d() {
            return this.f4810d;
        }

        public final boolean e() {
            return this.f4811e;
        }

        public final Object f() {
            return this.f4807a;
        }

        public final void g(boolean z11) {
            this.f4812f.setValue(Boolean.valueOf(z11));
        }

        public final void h(i1<Boolean> i1Var) {
            this.f4812f = i1Var;
        }

        public final void i(d2 d2Var) {
            this.f4809c = d2Var;
        }

        public final void j(Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
            this.f4808b = function2;
        }

        public final void k(boolean z11) {
            this.f4810d = z11;
        }

        public final void l(boolean z11) {
            this.f4811e = z11;
        }

        public final void m(Object obj) {
            this.f4807a = obj;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class b implements s0, y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f4813a;

        public b() {
            this.f4813a = LayoutNodeSubcompositionsState.this.f4798i;
        }

        @Override // q2.e
        public float H0(float f11) {
            return this.f4813a.H0(f11);
        }

        @Override // androidx.compose.ui.layout.s0
        public List<t> J(Object obj, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f4797h.get(obj);
            List<t> listD = layoutNode != null ? layoutNode.D() : null;
            return listD != null ? listD : LayoutNodeSubcompositionsState.this.C(obj, function2);
        }

        @Override // q2.n
        public long M(float f11) {
            return this.f4813a.M(f11);
        }

        @Override // q2.n
        public float M0() {
            return this.f4813a.M0();
        }

        @Override // q2.e
        public float N0(float f11) {
            return this.f4813a.N0(f11);
        }

        @Override // q2.n
        public float O(long j11) {
            return this.f4813a.O(j11);
        }

        @Override // androidx.compose.ui.layout.y
        public w S0(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super o0, Unit> function1, Function1<? super k0.a, Unit> function2) {
            return this.f4813a.S0(i11, i12, map, function1, function2);
        }

        @Override // q2.e
        public long V0(long j11) {
            return this.f4813a.V0(j11);
        }

        @Override // q2.e
        public long X(float f11) {
            return this.f4813a.X(f11);
        }

        @Override // androidx.compose.ui.layout.k
        public boolean d0() {
            return this.f4813a.d0();
        }

        @Override // q2.e
        public float getDensity() {
            return this.f4813a.getDensity();
        }

        @Override // androidx.compose.ui.layout.k
        public LayoutDirection getLayoutDirection() {
            return this.f4813a.getLayoutDirection();
        }

        @Override // q2.e
        public int k0(float f11) {
            return this.f4813a.k0(f11);
        }

        @Override // q2.e
        public float p0(long j11) {
            return this.f4813a.p0(j11);
        }

        @Override // androidx.compose.ui.layout.y
        public w y0(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super k0.a, Unit> function1) {
            return this.f4813a.y0(i11, i12, map, function1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class c implements s0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LayoutDirection f4815a = LayoutDirection.Rtl;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f4816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f4817c;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements w {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f4819a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f4820b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Map<androidx.compose.ui.layout.a, Integer> f4821c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function1<o0, Unit> f4822d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ c f4823e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ LayoutNodeSubcompositionsState f4824f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Function1<k0.a, Unit> f4825g;

            /* JADX WARN: Multi-variable type inference failed */
            public a(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super o0, Unit> function1, c cVar, LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, Function1<? super k0.a, Unit> function2) {
                this.f4819a = i11;
                this.f4820b = i12;
                this.f4821c = map;
                this.f4822d = function1;
                this.f4823e = cVar;
                this.f4824f = layoutNodeSubcompositionsState;
                this.f4825g = function2;
            }

            @Override // androidx.compose.ui.layout.w
            public int getHeight() {
                return this.f4820b;
            }

            @Override // androidx.compose.ui.layout.w
            public int getWidth() {
                return this.f4819a;
            }

            @Override // androidx.compose.ui.layout.w
            public Map<androidx.compose.ui.layout.a, Integer> l() {
                return this.f4821c;
            }

            @Override // androidx.compose.ui.layout.w
            public void m() {
                androidx.compose.ui.node.j0 j0VarT1;
                if (!this.f4823e.d0() || (j0VarT1 = this.f4824f.f4791a.M().T1()) == null) {
                    this.f4825g.invoke(this.f4824f.f4791a.M().b1());
                } else {
                    this.f4825g.invoke(j0VarT1.b1());
                }
            }

            @Override // androidx.compose.ui.layout.w
            public Function1<o0, Unit> n() {
                return this.f4822d;
            }
        }

        public c() {
        }

        @Override // q2.e
        public /* synthetic */ float H0(float f11) {
            return q2.d.b(this, f11);
        }

        @Override // androidx.compose.ui.layout.s0
        public List<t> J(Object obj, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
            return LayoutNodeSubcompositionsState.this.H(obj, function2);
        }

        @Override // q2.n
        public /* synthetic */ long M(float f11) {
            return q2.m.b(this, f11);
        }

        @Override // q2.n
        public float M0() {
            return this.f4817c;
        }

        @Override // q2.e
        public /* synthetic */ float N0(float f11) {
            return q2.d.d(this, f11);
        }

        @Override // q2.n
        public /* synthetic */ float O(long j11) {
            return q2.m.a(this, j11);
        }

        @Override // androidx.compose.ui.layout.y
        public w S0(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super o0, Unit> function1, Function1<? super k0.a, Unit> function2) {
            if (!((i11 & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & i12) == 0)) {
                h2.a.b("Size(" + i11 + " x " + i12 + ") is out of range. Each dimension must be between 0 and 16777215.");
            }
            return new a(i11, i12, map, function1, this, LayoutNodeSubcompositionsState.this, function2);
        }

        @Override // q2.e
        public /* synthetic */ long V0(long j11) {
            return q2.d.e(this, j11);
        }

        @Override // q2.e
        public /* synthetic */ long X(float f11) {
            return q2.d.f(this, f11);
        }

        @Override // androidx.compose.ui.layout.k
        public boolean d0() {
            return LayoutNodeSubcompositionsState.this.f4791a.R() == LayoutNode.LayoutState.LookaheadLayingOut || LayoutNodeSubcompositionsState.this.f4791a.R() == LayoutNode.LayoutState.LookaheadMeasuring;
        }

        @Override // q2.e
        public float getDensity() {
            return this.f4816b;
        }

        @Override // androidx.compose.ui.layout.k
        public LayoutDirection getLayoutDirection() {
            return this.f4815a;
        }

        public void k(float f11) {
            this.f4816b = f11;
        }

        @Override // q2.e
        public /* synthetic */ int k0(float f11) {
            return q2.d.a(this, f11);
        }

        public void l(float f11) {
            this.f4817c = f11;
        }

        public void m(LayoutDirection layoutDirection) {
            this.f4815a = layoutDirection;
        }

        @Override // q2.e
        public /* synthetic */ float p0(long j11) {
            return q2.d.c(this, j11);
        }

        @Override // androidx.compose.ui.layout.y
        public /* synthetic */ w y0(int i11, int i12, Map map, Function1 function1) {
            return x.a(this, i11, i12, map, function1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class d extends LayoutNode.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function2<s0, q2.b, w> f4827c;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        @SourceDebugExtension
        public static final class a implements w {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w f4828a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LayoutNodeSubcompositionsState f4829b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f4830c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ w f4831d;

            public a(w wVar, LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i11, w wVar2) {
                this.f4829b = layoutNodeSubcompositionsState;
                this.f4830c = i11;
                this.f4831d = wVar2;
                this.f4828a = wVar;
            }

            @Override // androidx.compose.ui.layout.w
            public int getHeight() {
                return this.f4828a.getHeight();
            }

            @Override // androidx.compose.ui.layout.w
            public int getWidth() {
                return this.f4828a.getWidth();
            }

            @Override // androidx.compose.ui.layout.w
            public Map<androidx.compose.ui.layout.a, Integer> l() {
                return this.f4828a.l();
            }

            @Override // androidx.compose.ui.layout.w
            public void m() {
                this.f4829b.f4795f = this.f4830c;
                this.f4831d.m();
                this.f4829b.v();
            }

            @Override // androidx.compose.ui.layout.w
            public Function1<o0, Unit> n() {
                return this.f4828a.n();
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        @SourceDebugExtension
        public static final class b implements w {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w f4832a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LayoutNodeSubcompositionsState f4833b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f4834c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ w f4835d;

            public b(w wVar, LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i11, w wVar2) {
                this.f4833b = layoutNodeSubcompositionsState;
                this.f4834c = i11;
                this.f4835d = wVar2;
                this.f4832a = wVar;
            }

            @Override // androidx.compose.ui.layout.w
            public int getHeight() {
                return this.f4832a.getHeight();
            }

            @Override // androidx.compose.ui.layout.w
            public int getWidth() {
                return this.f4832a.getWidth();
            }

            @Override // androidx.compose.ui.layout.w
            public Map<androidx.compose.ui.layout.a, Integer> l() {
                return this.f4832a.l();
            }

            @Override // androidx.compose.ui.layout.w
            public void m() {
                this.f4833b.f4794d = this.f4834c;
                this.f4835d.m();
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.f4833b;
                layoutNodeSubcompositionsState.u(layoutNodeSubcompositionsState.f4794d);
            }

            @Override // androidx.compose.ui.layout.w
            public Function1<o0, Unit> n() {
                return this.f4832a.n();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Function2<? super s0, ? super q2.b, ? extends w> function2, String str) {
            super(str);
            this.f4827c = function2;
        }

        @Override // androidx.compose.ui.layout.u
        public w c(y yVar, List<? extends t> list, long j11) {
            LayoutNodeSubcompositionsState.this.f4798i.m(yVar.getLayoutDirection());
            LayoutNodeSubcompositionsState.this.f4798i.k(yVar.getDensity());
            LayoutNodeSubcompositionsState.this.f4798i.l(yVar.M0());
            if (yVar.d0() || LayoutNodeSubcompositionsState.this.f4791a.V() == null) {
                LayoutNodeSubcompositionsState.this.f4794d = 0;
                w wVarInvoke = this.f4827c.invoke(LayoutNodeSubcompositionsState.this.f4798i, q2.b.a(j11));
                return new b(wVarInvoke, LayoutNodeSubcompositionsState.this, LayoutNodeSubcompositionsState.this.f4794d, wVarInvoke);
            }
            LayoutNodeSubcompositionsState.this.f4795f = 0;
            w wVarInvoke2 = this.f4827c.invoke(LayoutNodeSubcompositionsState.this.f4799j, q2.b.a(j11));
            return new a(wVarInvoke2, LayoutNodeSubcompositionsState.this, LayoutNodeSubcompositionsState.this.f4795f, wVarInvoke2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements SubcomposeLayoutState.a {
        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public /* synthetic */ void a(Object obj, Function1 function1) {
            r0.c(this, obj, function1);
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public /* synthetic */ int b() {
            return r0.a(this);
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public /* synthetic */ void c(int i11, long j11) {
            r0.b(this, i11, j11);
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public void dispose() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class f implements SubcomposeLayoutState.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f4837b;

        public f(Object obj) {
            this.f4837b = obj;
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public void a(Object obj, Function1<? super m1, ? extends TraversableNode$Companion$TraverseDescendantsAction> function1) {
            androidx.compose.ui.node.q0 q0VarE0;
            androidx.compose.ui.f.c cVarK;
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f4800k.get(this.f4837b);
            if (layoutNode == null || (q0VarE0 = layoutNode.e0()) == null || (cVarK = q0VarE0.k()) == null) {
                return;
            }
            n1.e(cVarK, obj, function1);
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public int b() {
            List<LayoutNode> listE;
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f4800k.get(this.f4837b);
            if (layoutNode == null || (listE = layoutNode.E()) == null) {
                return 0;
            }
            return listE.size();
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public void c(int i11, long j11) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f4800k.get(this.f4837b);
            if (layoutNode == null || !layoutNode.D0()) {
                return;
            }
            int size = layoutNode.E().size();
            if (i11 < 0 || i11 >= size) {
                throw new IndexOutOfBoundsException("Index (" + i11 + ") is out of bound of [0, " + size + ')');
            }
            if (!(!layoutNode.k())) {
                throw new IllegalArgumentException("Pre-measure called on node that is not placed".toString());
            }
            LayoutNode layoutNode2 = LayoutNodeSubcompositionsState.this.f4791a;
            layoutNode2.f4947o = true;
            androidx.compose.ui.node.f0.b(layoutNode).mo62measureAndLayout0kLqBqw(layoutNode.E().get(i11), j11);
            layoutNode2.f4947o = false;
        }

        @Override // androidx.compose.ui.layout.SubcomposeLayoutState.a
        public void dispose() {
            LayoutNodeSubcompositionsState.this.y();
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.f4800k.remove(this.f4837b);
            if (layoutNode != null) {
                if (LayoutNodeSubcompositionsState.this.f4805p <= 0) {
                    throw new IllegalStateException("No pre-composed items to dispose".toString());
                }
                int iIndexOf = LayoutNodeSubcompositionsState.this.f4791a.J().indexOf(layoutNode);
                if (iIndexOf < LayoutNodeSubcompositionsState.this.f4791a.J().size() - LayoutNodeSubcompositionsState.this.f4805p) {
                    throw new IllegalStateException("Item is not in pre-composed item range".toString());
                }
                LayoutNodeSubcompositionsState.this.f4804o++;
                LayoutNodeSubcompositionsState.this.f4805p--;
                int size = (LayoutNodeSubcompositionsState.this.f4791a.J().size() - LayoutNodeSubcompositionsState.this.f4805p) - LayoutNodeSubcompositionsState.this.f4804o;
                LayoutNodeSubcompositionsState.this.A(iIndexOf, size, 1);
                LayoutNodeSubcompositionsState.this.u(size);
            }
        }
    }

    public LayoutNodeSubcompositionsState(LayoutNode layoutNode, t0 t0Var) {
        this.f4791a = layoutNode;
        this.f4793c = t0Var;
    }

    public static /* synthetic */ void B(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i13 = 1;
        }
        layoutNodeSubcompositionsState.A(i11, i12, i13);
    }

    public final void A(int i11, int i12, int i13) {
        LayoutNode layoutNode = this.f4791a;
        layoutNode.f4947o = true;
        this.f4791a.P0(i11, i12, i13);
        layoutNode.f4947o = false;
    }

    public final List<t> C(Object obj, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        if (this.f4803n.r() < this.f4795f) {
            throw new IllegalArgumentException("Error: currentPostLookaheadIndex cannot be greater than the size of thepostLookaheadComposedSlotIds list.".toString());
        }
        int iR = this.f4803n.r();
        int i11 = this.f4795f;
        if (iR == i11) {
            this.f4803n.b(obj);
        } else {
            this.f4803n.C(i11, obj);
        }
        this.f4795f++;
        if (!this.f4800k.containsKey(obj)) {
            this.f4802m.put(obj, D(obj, function2));
            if (this.f4791a.R() == LayoutNode.LayoutState.LayingOut) {
                this.f4791a.a1(true);
            } else {
                LayoutNode.d1(this.f4791a, true, false, false, 6, null);
            }
        }
        LayoutNode layoutNode = this.f4800k.get(obj);
        if (layoutNode == null) {
            return kotlin.collections.g.l();
        }
        List<LayoutNodeLayoutDelegate.MeasurePassDelegate> listW0 = layoutNode.X().W0();
        int size = listW0.size();
        for (int i12 = 0; i12 < size; i12++) {
            listW0.get(i12).h1();
        }
        return listW0;
    }

    public final SubcomposeLayoutState.a D(Object obj, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        if (!this.f4791a.D0()) {
            return new e();
        }
        y();
        if (!this.f4797h.containsKey(obj)) {
            this.f4802m.remove(obj);
            HashMap<Object, LayoutNode> map = this.f4800k;
            LayoutNode layoutNodeL = map.get(obj);
            if (layoutNodeL == null) {
                layoutNodeL = L(obj);
                if (layoutNodeL != null) {
                    A(this.f4791a.J().indexOf(layoutNodeL), this.f4791a.J().size(), 1);
                    this.f4805p++;
                } else {
                    layoutNodeL = s(this.f4791a.J().size());
                    this.f4805p++;
                }
                map.put(obj, layoutNodeL);
            }
            J(layoutNodeL, obj, function2);
        }
        return new f(obj);
    }

    public final void E(LayoutNode layoutNode) {
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegateX = layoutNode.X();
        LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
        measurePassDelegateX.t1(usageByParent);
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegateU = layoutNode.U();
        if (lookaheadPassDelegateU != null) {
            lookaheadPassDelegateU.m1(usageByParent);
        }
    }

    public final void F(androidx.compose.runtime.m mVar) {
        this.f4792b = mVar;
    }

    public final void G(t0 t0Var) {
        if (this.f4793c != t0Var) {
            this.f4793c = t0Var;
            z(false);
            LayoutNode.h1(this.f4791a, false, false, false, 7, null);
        }
    }

    public final List<t> H(Object obj, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        y();
        LayoutNode.LayoutState layoutStateR = this.f4791a.R();
        LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.Measuring;
        if (!(layoutStateR == layoutState || layoutStateR == LayoutNode.LayoutState.LayingOut || layoutStateR == LayoutNode.LayoutState.LookaheadMeasuring || layoutStateR == LayoutNode.LayoutState.LookaheadLayingOut)) {
            h2.a.b("subcompose can only be used inside the measure or layout blocks");
        }
        HashMap<Object, LayoutNode> map = this.f4797h;
        LayoutNode layoutNodeRemove = map.get(obj);
        if (layoutNodeRemove == null) {
            layoutNodeRemove = this.f4800k.remove(obj);
            if (layoutNodeRemove != null) {
                if (!(this.f4805p > 0)) {
                    h2.a.b("Check failed.");
                }
                this.f4805p--;
            } else {
                LayoutNode layoutNodeL = L(obj);
                if (layoutNodeL == null) {
                    layoutNodeL = s(this.f4794d);
                }
                layoutNodeRemove = layoutNodeL;
            }
            map.put(obj, layoutNodeRemove);
        }
        LayoutNode layoutNode = layoutNodeRemove;
        if (CollectionsKt___CollectionsKt.h0(this.f4791a.J(), this.f4794d) != layoutNode) {
            int iIndexOf = this.f4791a.J().indexOf(layoutNode);
            int i11 = this.f4794d;
            if (iIndexOf < i11) {
                throw new IllegalArgumentException(("Key \"" + obj + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.").toString());
            }
            if (i11 != iIndexOf) {
                B(this, iIndexOf, i11, 0, 4, null);
            }
        }
        this.f4794d++;
        J(layoutNode, obj, function2);
        return (layoutStateR == layoutState || layoutStateR == LayoutNode.LayoutState.LayingOut) ? layoutNode.D() : layoutNode.C();
    }

    public final void I(LayoutNode layoutNode, final a aVar) {
        androidx.compose.runtime.snapshots.j.a aVar2 = androidx.compose.runtime.snapshots.j.f3684e;
        androidx.compose.runtime.snapshots.j jVarD = aVar2.d();
        Function1<Object, Unit> function1H = jVarD != null ? jVarD.h() : null;
        androidx.compose.runtime.snapshots.j jVarF = aVar2.f(jVarD);
        try {
            LayoutNode layoutNode2 = this.f4791a;
            layoutNode2.f4947o = true;
            final Function2<androidx.compose.runtime.i, Integer, Unit> function2C = aVar.c();
            d2 d2VarB = aVar.b();
            androidx.compose.runtime.m mVar = this.f4792b;
            if (mVar == null) {
                throw new IllegalStateException("parent composition reference not set".toString());
            }
            aVar.i(K(d2VarB, layoutNode, aVar.e(), mVar, androidx.compose.runtime.internal.b.c(-1750409193, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$3$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar, Integer num) {
                    invoke(iVar, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar, int i11) {
                    if ((i11 & 3) == 2 && iVar.h()) {
                        iVar.H();
                        return;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-1750409193, i11, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:493)");
                    }
                    boolean zA = aVar.a();
                    Function2<androidx.compose.runtime.i, Integer, Unit> function2 = function2C;
                    iVar.F(207, Boolean.valueOf(zA));
                    boolean zA2 = iVar.a(zA);
                    iVar.R(-869707859);
                    if (zA) {
                        function2.invoke(iVar, 0);
                    } else {
                        iVar.f(zA2);
                    }
                    iVar.L();
                    iVar.w();
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                }
            })));
            aVar.l(false);
            layoutNode2.f4947o = false;
            Unit unit = Unit.f68710a;
            aVar2.m(jVarD, jVarF, function1H);
        } catch (Throwable th2) {
            aVar2.m(jVarD, jVarF, function1H);
            throw th2;
        }
    }

    public final void J(LayoutNode layoutNode, Object obj, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        HashMap<LayoutNode, a> map = this.f4796g;
        a aVar = map.get(layoutNode);
        if (aVar == null) {
            aVar = new a(obj, ComposableSingletons$SubcomposeLayoutKt.f4789a.a(), null, 4, null);
            map.put(layoutNode, aVar);
        }
        a aVar2 = aVar;
        d2 d2VarB = aVar2.b();
        boolean zR = d2VarB != null ? d2VarB.r() : true;
        if (aVar2.c() != function2 || zR || aVar2.d()) {
            aVar2.j(function2);
            I(layoutNode, aVar2);
            aVar2.k(false);
        }
    }

    public final d2 K(d2 d2Var, LayoutNode layoutNode, boolean z11, androidx.compose.runtime.m mVar, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        if (d2Var == null || d2Var.isDisposed()) {
            d2Var = e3.a(layoutNode, mVar);
        }
        if (z11) {
            d2Var.p(function2);
        } else {
            d2Var.d(function2);
        }
        return d2Var;
    }

    public final LayoutNode L(Object obj) {
        int i11;
        if (this.f4804o == 0) {
            return null;
        }
        int size = this.f4791a.J().size() - this.f4805p;
        int i12 = size - this.f4804o;
        int i13 = size - 1;
        int i14 = i13;
        while (true) {
            if (i14 < i12) {
                i11 = -1;
                break;
            }
            if (Intrinsics.b(x(i14), obj)) {
                i11 = i14;
                break;
            }
            i14--;
        }
        if (i11 == -1) {
            while (true) {
                if (i13 < i12) {
                    i14 = i13;
                    break;
                }
                a aVar = this.f4796g.get(this.f4791a.J().get(i13));
                Intrinsics.d(aVar);
                a aVar2 = aVar;
                if (aVar2.f() == SubcomposeLayoutKt.f4843a || this.f4793c.b(obj, aVar2.f())) {
                    aVar2.m(obj);
                    i14 = i13;
                    i11 = i14;
                    break;
                }
                i13--;
            }
        }
        if (i11 == -1) {
            return null;
        }
        if (i14 != i12) {
            A(i14, i12, 1);
        }
        this.f4804o--;
        LayoutNode layoutNode = this.f4791a.J().get(i12);
        a aVar3 = this.f4796g.get(layoutNode);
        Intrinsics.d(aVar3);
        a aVar4 = aVar3;
        aVar4.h(u2.c(Boolean.TRUE, null, 2, null));
        aVar4.l(true);
        aVar4.k(true);
        return layoutNode;
    }

    @Override // androidx.compose.runtime.h
    public void onDeactivate() {
        z(true);
    }

    @Override // androidx.compose.runtime.h
    public void onRelease() {
        t();
    }

    @Override // androidx.compose.runtime.h
    public void onReuse() {
        z(false);
    }

    public final u r(Function2<? super s0, ? super q2.b, ? extends w> function2) {
        return new d(function2, this.f4806q);
    }

    public final LayoutNode s(int i11) {
        LayoutNode layoutNode = new LayoutNode(true, 0, 2, null);
        LayoutNode layoutNode2 = this.f4791a;
        layoutNode2.f4947o = true;
        this.f4791a.u0(i11, layoutNode);
        layoutNode2.f4947o = false;
        return layoutNode;
    }

    public final void t() {
        LayoutNode layoutNode = this.f4791a;
        layoutNode.f4947o = true;
        Iterator<T> it = this.f4796g.values().iterator();
        while (it.hasNext()) {
            d2 d2VarB = ((a) it.next()).b();
            if (d2VarB != null) {
                d2VarB.dispose();
            }
        }
        this.f4791a.X0();
        layoutNode.f4947o = false;
        this.f4796g.clear();
        this.f4797h.clear();
        this.f4805p = 0;
        this.f4804o = 0;
        this.f4800k.clear();
        y();
    }

    public final void u(int i11) {
        this.f4804o = 0;
        int size = (this.f4791a.J().size() - this.f4805p) - 1;
        if (i11 <= size) {
            this.f4801l.clear();
            if (i11 <= size) {
                int i12 = i11;
                while (true) {
                    this.f4801l.add(x(i12));
                    if (i12 == size) {
                        break;
                    } else {
                        i12++;
                    }
                }
            }
            this.f4793c.a(this.f4801l);
            androidx.compose.runtime.snapshots.j.a aVar = androidx.compose.runtime.snapshots.j.f3684e;
            androidx.compose.runtime.snapshots.j jVarD = aVar.d();
            Function1<Object, Unit> function1H = jVarD != null ? jVarD.h() : null;
            androidx.compose.runtime.snapshots.j jVarF = aVar.f(jVarD);
            boolean z11 = false;
            while (size >= i11) {
                try {
                    LayoutNode layoutNode = this.f4791a.J().get(size);
                    a aVar2 = this.f4796g.get(layoutNode);
                    Intrinsics.d(aVar2);
                    a aVar3 = aVar2;
                    Object objF = aVar3.f();
                    if (this.f4801l.contains(objF)) {
                        this.f4804o++;
                        if (aVar3.a()) {
                            E(layoutNode);
                            aVar3.g(false);
                            z11 = true;
                        }
                    } else {
                        LayoutNode layoutNode2 = this.f4791a;
                        layoutNode2.f4947o = true;
                        this.f4796g.remove(layoutNode);
                        d2 d2VarB = aVar3.b();
                        if (d2VarB != null) {
                            d2VarB.dispose();
                        }
                        this.f4791a.Y0(size, 1);
                        layoutNode2.f4947o = false;
                    }
                    this.f4797h.remove(objF);
                    size--;
                } catch (Throwable th2) {
                    aVar.m(jVarD, jVarF, function1H);
                    throw th2;
                }
            }
            Unit unit = Unit.f68710a;
            aVar.m(jVarD, jVarF, function1H);
            if (z11) {
                androidx.compose.runtime.snapshots.j.f3684e.n();
            }
        }
        y();
    }

    public final void v() {
        kotlin.collections.k.F(this.f4802m.entrySet(), new Function1<Map.Entry<Object, SubcomposeLayoutState.a>, Boolean>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$disposeUnusedSlotsInPostLookahead$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Map.Entry<Object, SubcomposeLayoutState.a> entry) {
                boolean z11;
                Object key = entry.getKey();
                SubcomposeLayoutState.a value = entry.getValue();
                int iS = this.this$0.f4803n.s(key);
                if (iS < 0 || iS >= this.this$0.f4795f) {
                    value.dispose();
                    z11 = true;
                } else {
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            }
        });
    }

    public final void w() {
        if (this.f4804o != this.f4791a.J().size()) {
            Iterator<Map.Entry<LayoutNode, a>> it = this.f4796g.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().k(true);
            }
            if (this.f4791a.Y()) {
                return;
            }
            LayoutNode.h1(this.f4791a, false, false, false, 7, null);
        }
    }

    public final Object x(int i11) {
        a aVar = this.f4796g.get(this.f4791a.J().get(i11));
        Intrinsics.d(aVar);
        return aVar.f();
    }

    public final void y() {
        int size = this.f4791a.J().size();
        if (this.f4796g.size() != size) {
            throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.f4796g.size() + ") and the children count on the SubcomposeLayout (" + size + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
        }
        if ((size - this.f4804o) - this.f4805p >= 0) {
            if (this.f4800k.size() == this.f4805p) {
                return;
            }
            throw new IllegalArgumentException(("Incorrect state. Precomposed children " + this.f4805p + ". Map size " + this.f4800k.size()).toString());
        }
        throw new IllegalArgumentException(("Incorrect state. Total children " + size + ". Reusable children " + this.f4804o + ". Precomposed children " + this.f4805p).toString());
    }

    public final void z(boolean z11) {
        this.f4805p = 0;
        this.f4800k.clear();
        int size = this.f4791a.J().size();
        if (this.f4804o != size) {
            this.f4804o = size;
            androidx.compose.runtime.snapshots.j.a aVar = androidx.compose.runtime.snapshots.j.f3684e;
            androidx.compose.runtime.snapshots.j jVarD = aVar.d();
            Function1<Object, Unit> function1H = jVarD != null ? jVarD.h() : null;
            androidx.compose.runtime.snapshots.j jVarF = aVar.f(jVarD);
            for (int i11 = 0; i11 < size; i11++) {
                try {
                    LayoutNode layoutNode = this.f4791a.J().get(i11);
                    a aVar2 = this.f4796g.get(layoutNode);
                    if (aVar2 != null && aVar2.a()) {
                        E(layoutNode);
                        if (z11) {
                            d2 d2VarB = aVar2.b();
                            if (d2VarB != null) {
                                d2VarB.deactivate();
                            }
                            aVar2.h(u2.c(Boolean.FALSE, null, 2, null));
                        } else {
                            aVar2.g(false);
                        }
                        aVar2.m(SubcomposeLayoutKt.f4843a);
                    }
                } catch (Throwable th2) {
                    aVar.m(jVarD, jVarF, function1H);
                    throw th2;
                }
            }
            Unit unit = Unit.f68710a;
            aVar.m(jVarD, jVarF, function1H);
            this.f4797h.clear();
        }
        y();
    }
}
