package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class ComposerImpl implements i {
    public int B;
    public int C;
    public boolean D;
    public final c E;
    public final z2<RecomposeScopeImpl> F;
    public boolean G;
    public boolean H;
    public i2 I;
    public j2 J;
    public m2 K;
    public boolean L;
    public n1 M;
    public r1.a N;
    public final r1.b O;
    public androidx.compose.runtime.c P;
    public r1.c Q;
    public boolean R;
    public int S;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f<?> f3239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f3240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j2 f3241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<b2> f3242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r1.a f3243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r1.a f3244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y f3245h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Pending f3247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3249l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3250m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f3252o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.collection.a0 f3253p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3254q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3255r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3256s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.compose.runtime.collection.a<n1> f3260w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3261x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3263z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z2<Pending> f3246i = new z2<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m0 f3251n = new m0();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<o0> f3257t = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final m0 f3258u = new m0();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public n1 f3259v = androidx.compose.runtime.internal.f.a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final m0 f3262y = new m0();
    public int A = -1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements e2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f3264a;

        public a(b bVar) {
            this.f3264a = bVar;
        }

        public final b a() {
            return this.f3264a;
        }

        @Override // androidx.compose.runtime.b2
        public void onAbandoned() {
            this.f3264a.u();
        }

        @Override // androidx.compose.runtime.b2
        public void onForgotten() {
            this.f3264a.u();
        }

        @Override // androidx.compose.runtime.b2
        public void onRemembered() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f3267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final u f3268d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set<Set<w1.a>> f3269e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Set<ComposerImpl> f3270f = new LinkedHashSet();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final i1 f3271g = r2.e(androidx.compose.runtime.internal.f.a(), r2.h());

        public b(int i11, boolean z11, boolean z12, u uVar) {
            this.f3265a = i11;
            this.f3266b = z11;
            this.f3267c = z12;
            this.f3268d = uVar;
        }

        @Override // androidx.compose.runtime.m
        public void a(y yVar, Function2<? super i, ? super Integer, Unit> function2) {
            ComposerImpl.this.f3240c.a(yVar, function2);
        }

        @Override // androidx.compose.runtime.m
        public void b(y0 y0Var) {
            ComposerImpl.this.f3240c.b(y0Var);
        }

        @Override // androidx.compose.runtime.m
        public void c() {
            ComposerImpl.this.B--;
        }

        @Override // androidx.compose.runtime.m
        public boolean d() {
            return ComposerImpl.this.f3240c.d();
        }

        @Override // androidx.compose.runtime.m
        public boolean e() {
            return this.f3266b;
        }

        @Override // androidx.compose.runtime.m
        public boolean f() {
            return this.f3267c;
        }

        @Override // androidx.compose.runtime.m
        public n1 g() {
            return w();
        }

        @Override // androidx.compose.runtime.m
        public int h() {
            return this.f3265a;
        }

        @Override // androidx.compose.runtime.m
        public CoroutineContext i() {
            return ComposerImpl.this.f3240c.i();
        }

        @Override // androidx.compose.runtime.m
        public u j() {
            return this.f3268d;
        }

        @Override // androidx.compose.runtime.m
        public void k(y0 y0Var) {
            ComposerImpl.this.f3240c.k(y0Var);
        }

        @Override // androidx.compose.runtime.m
        public void l(y yVar) {
            ComposerImpl.this.f3240c.l(ComposerImpl.this.B0());
            ComposerImpl.this.f3240c.l(yVar);
        }

        @Override // androidx.compose.runtime.m
        public void m(y0 y0Var, x0 x0Var) {
            ComposerImpl.this.f3240c.m(y0Var, x0Var);
        }

        @Override // androidx.compose.runtime.m
        public x0 n(y0 y0Var) {
            return ComposerImpl.this.f3240c.n(y0Var);
        }

        @Override // androidx.compose.runtime.m
        public void o(Set<w1.a> set) {
            Set hashSet = this.f3269e;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.f3269e = hashSet;
            }
            hashSet.add(set);
        }

        @Override // androidx.compose.runtime.m
        public void p(i iVar) {
            Intrinsics.e(iVar, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
            super.p((ComposerImpl) iVar);
            this.f3270f.add(iVar);
        }

        @Override // androidx.compose.runtime.m
        public void q(y yVar) {
            ComposerImpl.this.f3240c.q(yVar);
        }

        @Override // androidx.compose.runtime.m
        public void r() {
            ComposerImpl.this.B++;
        }

        @Override // androidx.compose.runtime.m
        public void s(i iVar) {
            Set<Set<w1.a>> set = this.f3269e;
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    Set set2 = (Set) it.next();
                    Intrinsics.e(iVar, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                    set2.remove(((ComposerImpl) iVar).f3241d);
                }
            }
            TypeIntrinsics.a(this.f3270f).remove(iVar);
        }

        @Override // androidx.compose.runtime.m
        public void t(y yVar) {
            ComposerImpl.this.f3240c.t(yVar);
        }

        public final void u() {
            if (!this.f3270f.isEmpty()) {
                Set<Set<w1.a>> set = this.f3269e;
                if (set != null) {
                    for (ComposerImpl composerImpl : this.f3270f) {
                        Iterator<Set<w1.a>> it = set.iterator();
                        while (it.hasNext()) {
                            it.next().remove(composerImpl.f3241d);
                        }
                    }
                }
                this.f3270f.clear();
            }
        }

        public final Set<ComposerImpl> v() {
            return this.f3270f;
        }

        public final n1 w() {
            return (n1) this.f3271g.getValue();
        }

        public final void x(n1 n1Var) {
            this.f3271g.setValue(n1Var);
        }

        public final void y(n1 n1Var) {
            x(n1Var);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements a0 {
        public c() {
        }

        @Override // androidx.compose.runtime.a0
        public void a(z<?> zVar) {
            ComposerImpl.this.B--;
        }

        @Override // androidx.compose.runtime.a0
        public void b(z<?> zVar) {
            ComposerImpl.this.B++;
        }
    }

    public ComposerImpl(f<?> fVar, m mVar, j2 j2Var, Set<b2> set, r1.a aVar, r1.a aVar2, y yVar) {
        this.f3239b = fVar;
        this.f3240c = mVar;
        this.f3241d = j2Var;
        this.f3242e = set;
        this.f3243f = aVar;
        this.f3244g = aVar2;
        this.f3245h = yVar;
        this.D = mVar.f() || mVar.d();
        this.E = new c();
        this.F = new z2<>();
        i2 i2VarD = j2Var.D();
        i2VarD.d();
        this.I = i2VarD;
        j2 j2Var2 = new j2();
        if (mVar.f()) {
            j2Var2.j();
        }
        if (mVar.d()) {
            j2Var2.i();
        }
        this.J = j2Var2;
        m2 m2VarE = j2Var2.E();
        m2VarE.L(true);
        this.K = m2VarE;
        this.O = new r1.b(this, this.f3243f);
        i2 i2VarD2 = this.J.D();
        try {
            androidx.compose.runtime.c cVarA = i2VarD2.a(0);
            i2VarD2.d();
            this.P = cVarA;
            this.Q = new r1.c();
        } catch (Throwable th2) {
            i2VarD2.d();
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object U0(ComposerImpl composerImpl, y yVar, y yVar2, Integer num, List list, Function0 function0, int i11, Object obj) {
        y yVar3 = (i11 & 1) != 0 ? null : yVar;
        y yVar4 = (i11 & 2) != 0 ? null : yVar2;
        Integer num2 = (i11 & 4) != 0 ? null : num;
        if ((i11 & 8) != 0) {
            list = kotlin.collections.g.l();
        }
        return composerImpl.T0(yVar3, yVar4, num2, list, function0);
    }

    public static final int d1(ComposerImpl composerImpl, int i11, boolean z11, int i12) {
        i2 i2Var = composerImpl.I;
        if (!i2Var.F(i11)) {
            if (!i2Var.e(i11)) {
                if (i2Var.J(i11)) {
                    return 1;
                }
                return i2Var.N(i11);
            }
            int iE = i2Var.E(i11) + i11;
            int iD1 = 0;
            for (int iE2 = i11 + 1; iE2 < iE; iE2 += i2Var.E(iE2)) {
                boolean zJ = i2Var.J(iE2);
                if (zJ) {
                    composerImpl.O.i();
                    composerImpl.O.w(i2Var.L(iE2));
                }
                iD1 += d1(composerImpl, iE2, zJ || z11, zJ ? 0 : i12 + iD1);
                if (zJ) {
                    composerImpl.O.i();
                    composerImpl.O.A();
                }
            }
            if (i2Var.J(i11)) {
                return 1;
            }
            return iD1;
        }
        int iC = i2Var.C(i11);
        Object objD = i2Var.D(i11);
        if (iC != 126665345 || !(objD instanceof w0)) {
            if (iC != 206 || !Intrinsics.b(objD, k.F())) {
                if (i2Var.J(i11)) {
                    return 1;
                }
                return i2Var.N(i11);
            }
            Object objB = i2Var.B(i11, 0);
            a aVar = objB instanceof a ? (a) objB : null;
            if (aVar != null) {
                for (ComposerImpl composerImpl2 : aVar.a().v()) {
                    composerImpl2.b1();
                    composerImpl.f3240c.q(composerImpl2.B0());
                }
            }
            return i2Var.N(i11);
        }
        w0 w0Var = (w0) objD;
        Object objB2 = i2Var.B(i11, 0);
        androidx.compose.runtime.c cVarA = i2Var.a(i11);
        List listW = k.w(composerImpl.f3257t, i11, i2Var.E(i11) + i11);
        ArrayList arrayList = new ArrayList(listW.size());
        int size = listW.size();
        for (int i13 = 0; i13 < size; i13++) {
            o0 o0Var = (o0) listW.get(i13);
            arrayList.add(TuplesKt.a(o0Var.c(), o0Var.a()));
        }
        y0 y0Var = new y0(w0Var, objB2, composerImpl.B0(), composerImpl.f3241d, cVarA, arrayList, composerImpl.m0(i11));
        composerImpl.f3240c.b(y0Var);
        composerImpl.O.L();
        composerImpl.O.N(composerImpl.B0(), composerImpl.f3240c, y0Var);
        if (!z11) {
            return i2Var.N(i11);
        }
        composerImpl.O.j(i12, i11);
        return 0;
    }

    @Override // androidx.compose.runtime.i
    public boolean A(Object obj) {
        if (M0() == obj) {
            return false;
        }
        u1(obj);
        return true;
    }

    public final boolean A0() {
        return this.B > 0;
    }

    @Override // androidx.compose.runtime.i
    public void B() {
        i1(-127, null, k0.f3470a.a(), null);
    }

    public y B0() {
        return this.f3245h;
    }

    @Override // androidx.compose.runtime.i
    public void C(int i11, Object obj) {
        i1(i11, obj, k0.f3470a.a(), null);
    }

    public final RecomposeScopeImpl C0() {
        z2<RecomposeScopeImpl> z2Var = this.F;
        if (this.B == 0 && z2Var.d()) {
            return z2Var.e();
        }
        return null;
    }

    @Override // androidx.compose.runtime.i
    public void D() {
        i1(125, null, k0.f3470a.c(), null);
        this.f3256s = true;
    }

    public final r1.a D0() {
        return this.N;
    }

    @Override // androidx.compose.runtime.i
    public void E(t1<?> t1Var) {
        g3<?> g3Var;
        n1 n1VarL0 = l0();
        k1(201, k.D());
        Object objY = y();
        if (Intrinsics.b(objY, i.f3413a.a())) {
            g3Var = null;
        } else {
            Intrinsics.e(objY, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            g3Var = (g3) objY;
        }
        q<?> qVarB = t1Var.b();
        Intrinsics.e(qVarB, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.e(t1Var, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        g3<?> g3VarB = qVarB.b(t1Var, g3Var);
        boolean z11 = true;
        boolean z12 = !Intrinsics.b(g3VarB, g3Var);
        if (z12) {
            p(g3VarB);
        }
        boolean z13 = false;
        if (e()) {
            if (t1Var.a() || !t.a(n1VarL0, qVarB)) {
                n1VarL0 = n1VarL0.b(qVarB, g3VarB);
            }
            this.L = true;
        } else {
            i2 i2Var = this.I;
            Object objZ = i2Var.z(i2Var.k());
            Intrinsics.e(objZ, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            n1 n1Var = (n1) objZ;
            n1VarL0 = ((!h() || z12) && (t1Var.a() || !t.a(n1VarL0, qVarB))) ? n1VarL0.b(qVarB, g3VarB) : n1Var;
            if (!this.f3263z && n1Var == n1VarL0) {
                z11 = false;
            }
            z13 = z11;
        }
        if (z13 && !e()) {
            Y0(n1VarL0);
        }
        this.f3262y.j(k.p(this.f3261x));
        this.f3261x = z13;
        this.M = n1VarL0;
        i1(202, k.A(), k0.f3470a.a(), n1VarL0);
    }

    public final Object E0(i2 i2Var) {
        return i2Var.L(i2Var.u());
    }

    @Override // androidx.compose.runtime.i
    public void F(int i11, Object obj) {
        if (!e() && this.I.n() == i11 && !Intrinsics.b(this.I.l(), obj) && this.A < 0) {
            this.A = this.I.k();
            this.f3263z = true;
        }
        i1(i11, null, k0.f3470a.a(), obj);
    }

    public final i2 F0() {
        return this.I;
    }

    @Override // androidx.compose.runtime.i
    public <T> void G(Function0<? extends T> function0) {
        w1();
        if (!e()) {
            k.s("createNode() can only be called when inserting");
        }
        int iE = this.f3251n.e();
        m2 m2Var = this.K;
        androidx.compose.runtime.c cVarE = m2Var.E(m2Var.e0());
        this.f3249l++;
        this.Q.b(function0, iE, cVarE);
    }

    public final int G0(i2 i2Var, int i11) {
        Object objZ;
        if (!i2Var.G(i11)) {
            int iC = i2Var.C(i11);
            if (iC == 207 && (objZ = i2Var.z(i11)) != null && !Intrinsics.b(objZ, i.f3413a.a())) {
                iC = objZ.hashCode();
            }
            return iC;
        }
        Object objD = i2Var.D(i11);
        if (objD == null) {
            return 0;
        }
        if (objD instanceof Enum) {
            return ((Enum) objD).ordinal();
        }
        if (objD instanceof w0) {
            return 126665345;
        }
        return objD.hashCode();
    }

    @Override // androidx.compose.runtime.i
    public void H() {
        if (!(this.f3249l == 0)) {
            k.s("No nodes can be emitted before calling skipAndEndGroup");
        }
        RecomposeScopeImpl recomposeScopeImplC0 = C0();
        if (recomposeScopeImplC0 != null) {
            recomposeScopeImplC0.z();
        }
        if (this.f3257t.isEmpty()) {
            h1();
        } else {
            V0();
        }
    }

    public final void H0(List<Pair<y0, y0>> list) throws Throwable {
        r1.b bVar;
        r1.a aVar;
        j2 j2VarG;
        androidx.compose.runtime.c cVarA;
        i2 i2Var;
        int[] iArr;
        r1.a aVar2;
        j2 j2VarA;
        i2 i2Var2;
        r1.b bVar2 = this.O;
        r1.a aVar3 = this.f3244g;
        r1.a aVarO = bVar2.o();
        try {
            bVar2.T(aVar3);
            this.O.R();
            int size = list.size();
            int i11 = 0;
            int i12 = 0;
            while (i12 < size) {
                try {
                    Pair<y0, y0> pair = list.get(i12);
                    final y0 y0VarComponent1 = pair.component1();
                    y0 y0VarComponent2 = pair.component2();
                    androidx.compose.runtime.c cVarA2 = y0VarComponent1.a();
                    int iE = y0VarComponent1.g().e(cVarA2);
                    androidx.compose.runtime.internal.d dVar = new androidx.compose.runtime.internal.d(i11, 1, null);
                    this.O.e(dVar, cVarA2);
                    if (y0VarComponent2 == null) {
                        if (Intrinsics.b(y0VarComponent1.g(), this.J)) {
                            k0();
                        }
                        final i2 i2VarD = y0VarComponent1.g().D();
                        try {
                            i2VarD.Q(iE);
                            this.O.z(iE);
                            final r1.a aVar4 = new r1.a();
                            i2Var2 = i2VarD;
                            try {
                                U0(this, null, null, null, null, new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        r1.b bVar3 = this.this$0.O;
                                        r1.a aVar5 = aVar4;
                                        ComposerImpl composerImpl = this.this$0;
                                        i2 i2Var3 = i2VarD;
                                        y0 y0Var = y0VarComponent1;
                                        r1.a aVarO2 = bVar3.o();
                                        try {
                                            bVar3.T(aVar5);
                                            i2 i2VarF0 = composerImpl.F0();
                                            int[] iArr2 = composerImpl.f3252o;
                                            androidx.compose.runtime.collection.a aVar6 = composerImpl.f3260w;
                                            composerImpl.f3252o = null;
                                            composerImpl.f3260w = null;
                                            try {
                                                composerImpl.e1(i2Var3);
                                                r1.b bVar4 = composerImpl.O;
                                                boolean zP = bVar4.p();
                                                try {
                                                    bVar4.U(false);
                                                    composerImpl.K0(y0Var.c(), y0Var.e(), y0Var.f(), true);
                                                    bVar4.U(zP);
                                                    Unit unit = Unit.f68710a;
                                                    composerImpl.e1(i2VarF0);
                                                    composerImpl.f3252o = iArr2;
                                                    composerImpl.f3260w = aVar6;
                                                    bVar3.T(aVarO2);
                                                } catch (Throwable th2) {
                                                    bVar4.U(zP);
                                                    throw th2;
                                                }
                                            } catch (Throwable th3) {
                                                composerImpl.e1(i2VarF0);
                                                composerImpl.f3252o = iArr2;
                                                composerImpl.f3260w = aVar6;
                                                throw th3;
                                            }
                                        } catch (Throwable th4) {
                                            bVar3.T(aVarO2);
                                            throw th4;
                                        }
                                    }
                                }, 15, null);
                                this.O.s(aVar4, dVar);
                                Unit unit = Unit.f68710a;
                                i2Var2.d();
                            } catch (Throwable th2) {
                                th = th2;
                                i2Var2.d();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i2Var2 = i2VarD;
                        }
                    } else {
                        x0 x0VarN = this.f3240c.n(y0VarComponent2);
                        if (x0VarN == null || (j2VarG = x0VarN.a()) == null) {
                            j2VarG = y0VarComponent2.g();
                        }
                        if (x0VarN == null || (j2VarA = x0VarN.a()) == null || (cVarA = j2VarA.a(0)) == null) {
                            cVarA = y0VarComponent2.a();
                        }
                        List<? extends Object> listQ = k.q(j2VarG, cVarA);
                        if (!listQ.isEmpty()) {
                            this.O.b(listQ, dVar);
                            if (Intrinsics.b(y0VarComponent1.g(), this.f3241d)) {
                                int iE2 = this.f3241d.e(cVarA2);
                                q1(iE2, v1(iE2) + listQ.size());
                            }
                        }
                        this.O.c(x0VarN, this.f3240c, y0VarComponent2, y0VarComponent1);
                        i2 i2VarD2 = j2VarG.D();
                        try {
                            i2 i2VarF0 = F0();
                            int[] iArr2 = this.f3252o;
                            androidx.compose.runtime.collection.a aVar5 = this.f3260w;
                            this.f3252o = null;
                            this.f3260w = null;
                            try {
                                e1(i2VarD2);
                                int iE3 = j2VarG.e(cVarA);
                                i2VarD2.Q(iE3);
                                this.O.z(iE3);
                                r1.a aVar6 = new r1.a();
                                r1.b bVar3 = this.O;
                                r1.a aVarO2 = bVar3.o();
                                try {
                                    bVar3.T(aVar6);
                                    r1.b bVar4 = this.O;
                                    try {
                                        boolean zP = bVar4.p();
                                        try {
                                            bVar4.U(false);
                                            y yVarB = y0VarComponent2.b();
                                            y yVarB2 = y0VarComponent1.b();
                                            Integer numValueOf = Integer.valueOf(i2VarD2.k());
                                            aVar2 = aVarO2;
                                            i2Var = i2VarD2;
                                            iArr = iArr2;
                                            i2VarF0 = i2VarF0;
                                            try {
                                                T0(yVarB, yVarB2, numValueOf, y0VarComponent2.d(), new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                        this.this$0.K0(y0VarComponent1.c(), y0VarComponent1.e(), y0VarComponent1.f(), true);
                                                    }
                                                });
                                                try {
                                                    bVar4.U(zP);
                                                    try {
                                                        bVar3.T(aVar2);
                                                        this.O.s(aVar6, dVar);
                                                        Unit unit2 = Unit.f68710a;
                                                        try {
                                                            e1(i2VarF0);
                                                            this.f3252o = iArr;
                                                            this.f3260w = aVar5;
                                                            i2Var.d();
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            i2Var.d();
                                                            throw th;
                                                        }
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        aVar5 = aVar5;
                                                        e1(i2VarF0);
                                                        this.f3252o = iArr;
                                                        this.f3260w = aVar5;
                                                        throw th;
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    aVar5 = aVar5;
                                                    try {
                                                        bVar3.T(aVar2);
                                                        throw th;
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        e1(i2VarF0);
                                                        this.f3252o = iArr;
                                                        this.f3260w = aVar5;
                                                        throw th;
                                                    }
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                aVar5 = aVar5;
                                                try {
                                                    bVar4.U(zP);
                                                    throw th;
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    bVar3.T(aVar2);
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th10) {
                                            th = th10;
                                            aVar5 = aVar5;
                                            i2VarF0 = i2VarF0;
                                            i2Var = i2VarD2;
                                            aVar2 = aVarO2;
                                            iArr = iArr2;
                                        }
                                    } catch (Throwable th11) {
                                        th = th11;
                                        i2Var = i2VarD2;
                                        aVar2 = aVarO2;
                                        iArr = iArr2;
                                        bVar3.T(aVar2);
                                        throw th;
                                    }
                                } catch (Throwable th12) {
                                    th = th12;
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                aVar5 = aVar5;
                                i2VarF0 = i2VarF0;
                                i2Var = i2VarD2;
                                iArr = iArr2;
                            }
                        } catch (Throwable th14) {
                            th = th14;
                            i2Var = i2VarD2;
                        }
                    }
                    try {
                        this.O.W();
                        i12++;
                        bVar2 = bVar2;
                        size = size;
                        aVarO = aVarO;
                        i11 = 0;
                    } catch (Throwable th15) {
                        th = th15;
                        bVar = bVar2;
                        aVar = aVarO;
                        bVar.T(aVar);
                        throw th;
                    }
                } catch (Throwable th16) {
                    th = th16;
                    bVar2 = bVar2;
                    aVarO = aVarO;
                }
            }
            r1.b bVar5 = bVar2;
            r1.a aVar7 = aVarO;
            this.O.h();
            this.O.z(0);
            bVar5.T(aVar7);
        } catch (Throwable th17) {
            th = th17;
            bVar = bVar2;
            aVar = aVarO;
        }
    }

    @Override // androidx.compose.runtime.i
    public void I() {
        s0();
        s0();
        this.f3261x = k.o(this.f3262y.i());
        this.M = null;
    }

    public void I0(List<Pair<y0, y0>> list) {
        try {
            H0(list);
            g0();
        } catch (Throwable th2) {
            T();
            throw th2;
        }
    }

    @Override // androidx.compose.runtime.i
    public boolean J() {
        if (!h() || this.f3261x) {
            return true;
        }
        RecomposeScopeImpl recomposeScopeImplC0 = C0();
        return recomposeScopeImplC0 != null && recomposeScopeImplC0.l();
    }

    public final int J0(int i11) {
        return (-2) - i11;
    }

    @Override // androidx.compose.runtime.i
    public void K(u1 u1Var) {
        RecomposeScopeImpl recomposeScopeImpl = u1Var instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) u1Var : null;
        if (recomposeScopeImpl == null) {
            return;
        }
        recomposeScopeImpl.H(true);
    }

    public final void K0(final w0<Object> w0Var, n1 n1Var, final Object obj, boolean z11) {
        C(126665345, w0Var);
        t1(obj);
        int iM = M();
        try {
            this.S = 126665345;
            boolean z12 = false;
            if (e()) {
                m2.v0(this.K, 0, 1, null);
            }
            if (!e() && !Intrinsics.b(this.I.l(), n1Var)) {
                z12 = true;
            }
            if (z12) {
                Y0(n1Var);
            }
            i1(202, k.A(), k0.f3470a.a(), n1Var);
            this.M = null;
            if (!e() || z11) {
                boolean z13 = this.f3261x;
                this.f3261x = z12;
                androidx.compose.runtime.b.d(this, androidx.compose.runtime.internal.b.c(316014703, true, new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(i iVar, Integer num) {
                        invoke(iVar, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(i iVar, int i11) {
                        if ((i11 & 3) == 2 && iVar.h()) {
                            iVar.H();
                            return;
                        }
                        if (k.J()) {
                            k.S(316014703, i11, -1, "androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.<anonymous> (Composer.kt:3293)");
                        }
                        w0Var.a().invoke(obj, iVar, 0);
                        if (k.J()) {
                            k.R();
                        }
                    }
                }));
                this.f3261x = z13;
            } else {
                this.L = true;
                m2 m2Var = this.K;
                this.f3240c.k(new y0(w0Var, obj, B0(), this.J, m2Var.E(m2Var.H0(m2Var.e0())), kotlin.collections.g.l(), l0()));
            }
        } finally {
            s0();
            this.M = null;
            this.S = iM;
            O();
        }
    }

    @Override // androidx.compose.runtime.i
    public void L() {
        s0();
    }

    public final boolean L0() {
        return this.G;
    }

    @Override // androidx.compose.runtime.i
    public int M() {
        return this.S;
    }

    @PublishedApi
    public final Object M0() {
        if (e()) {
            x1();
            return i.f3413a.a();
        }
        Object objK = this.I.K();
        return (!this.f3263z || (objK instanceof e2)) ? objK : i.f3413a.a();
    }

    @Override // androidx.compose.runtime.i
    public m N() {
        k1(206, k.F());
        if (e()) {
            m2.v0(this.K, 0, 1, null);
        }
        Object objM0 = M0();
        a aVar = objM0 instanceof a ? (a) objM0 : null;
        if (aVar == null) {
            int iM = M();
            boolean z11 = this.f3254q;
            boolean z12 = this.D;
            y yVarB0 = B0();
            o oVar = yVarB0 instanceof o ? (o) yVarB0 : null;
            aVar = new a(new b(iM, z11, z12, oVar != null ? oVar.E() : null));
            u1(aVar);
        }
        aVar.a().y(l0());
        s0();
        return aVar.a();
    }

    @PublishedApi
    public final Object N0() {
        if (e()) {
            x1();
            return i.f3413a.a();
        }
        Object objK = this.I.K();
        if (!this.f3263z || (objK instanceof e2)) {
            return objK instanceof c2 ? ((c2) objK).b() : objK;
        }
        return i.f3413a.a();
    }

    @Override // androidx.compose.runtime.i
    public void O() {
        s0();
    }

    public final Object O0(i2 i2Var, int i11) {
        return i2Var.L(i11);
    }

    @Override // androidx.compose.runtime.i
    public void P() {
        s0();
    }

    public final int P0(int i11, int i12, int i13, int i14) {
        int iP = this.I.P(i12);
        while (iP != i13 && !this.I.J(iP)) {
            iP = this.I.P(iP);
        }
        if (this.I.J(iP)) {
            i14 = 0;
        }
        if (iP == i12) {
            return i14;
        }
        int iV1 = (v1(iP) - this.I.N(i12)) + i14;
        loop1: while (i14 < iV1 && iP != i11) {
            iP++;
            while (iP < i11) {
                int iE = this.I.E(iP) + iP;
                if (i11 >= iE) {
                    i14 += this.I.J(iP) ? 1 : v1(iP);
                    iP = iE;
                }
            }
            break loop1;
        }
        return i14;
    }

    @Override // androidx.compose.runtime.i
    public boolean Q(Object obj) {
        if (Intrinsics.b(M0(), obj)) {
            return false;
        }
        u1(obj);
        return true;
    }

    public final void Q0(Function0<Unit> function0) {
        if (!(!this.G)) {
            k.s("Preparing a composition while composing is not supported");
        }
        this.G = true;
        try {
            function0.invoke();
        } finally {
            this.G = false;
        }
    }

    @Override // androidx.compose.runtime.i
    public void R(int i11) {
        if (this.f3247j != null) {
            i1(i11, null, k0.f3470a.a(), null);
            return;
        }
        x1();
        this.S = this.f3250m ^ Integer.rotateLeft(Integer.rotateLeft(M(), 3) ^ i11, 3);
        this.f3250m++;
        i2 i2Var = this.I;
        if (e()) {
            i2Var.c();
            this.K.k1(i11, i.f3413a.a());
            w0(false, null);
            return;
        }
        if (i2Var.n() == i11 && !i2Var.s()) {
            i2Var.U();
            w0(false, null);
            return;
        }
        if (!i2Var.H()) {
            int i12 = this.f3248k;
            int iK = i2Var.k();
            W0();
            this.O.Q(i12, i2Var.S());
            k.P(this.f3257t, iK, i2Var.k());
        }
        i2Var.c();
        this.R = true;
        this.M = null;
        v0();
        m2 m2Var = this.K;
        m2Var.I();
        int iC0 = m2Var.c0();
        m2Var.k1(i11, i.f3413a.a());
        this.P = m2Var.E(iC0);
        w0(false, null);
    }

    public final int R0(int i11) {
        int iP = this.I.P(i11) + 1;
        int i12 = 0;
        while (iP < i11) {
            if (!this.I.G(iP)) {
                i12++;
            }
            iP += this.I.E(iP);
        }
        return i12;
    }

    @Override // androidx.compose.runtime.i
    public void S(t1<?>[] t1VarArr) {
        n1 n1VarS1;
        n1 n1VarL0 = l0();
        k1(201, k.D());
        boolean z11 = true;
        boolean z12 = false;
        if (e()) {
            n1VarS1 = s1(n1VarL0, t.d(t1VarArr, n1VarL0, null, 4, null));
            this.L = true;
        } else {
            Object objA = this.I.A(0);
            Intrinsics.e(objA, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            n1 n1Var = (n1) objA;
            Object objA2 = this.I.A(1);
            Intrinsics.e(objA2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            n1 n1Var2 = (n1) objA2;
            n1 n1VarC = t.c(t1VarArr, n1VarL0, n1Var2);
            if (h() && !this.f3263z && Intrinsics.b(n1Var2, n1VarC)) {
                g1();
                n1VarS1 = n1Var;
            } else {
                n1VarS1 = s1(n1VarL0, n1VarC);
                if (!this.f3263z && Intrinsics.b(n1VarS1, n1Var)) {
                    z11 = false;
                }
                z12 = z11;
            }
        }
        if (z12 && !e()) {
            Y0(n1VarS1);
        }
        this.f3262y.j(k.p(this.f3261x));
        this.f3261x = z12;
        this.M = n1VarS1;
        i1(202, k.A(), k0.f3470a.a(), n1VarS1);
    }

    public final boolean S0(androidx.compose.runtime.collection.e<RecomposeScopeImpl, Object> eVar) {
        if (!this.f3243f.c()) {
            k.s("Expected applyChanges() to have been called");
        }
        if (eVar.e() <= 0 && !(!this.f3257t.isEmpty()) && !this.f3255r) {
            return false;
        }
        p0(eVar, null);
        return this.f3243f.d();
    }

    public final void T() {
        g0();
        this.f3246i.a();
        this.f3251n.a();
        this.f3258u.a();
        this.f3262y.a();
        this.f3260w = null;
        this.Q.a();
        this.S = 0;
        this.B = 0;
        this.f3256s = false;
        this.R = false;
        this.f3263z = false;
        this.G = false;
        this.f3255r = false;
        this.A = -1;
        if (!this.I.i()) {
            this.I.d();
        }
        if (this.K.Z()) {
            return;
        }
        z0();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003f A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0005, B:5:0x0010, B:7:0x0022, B:11:0x002c, B:10:0x0028, B:14:0x0033, B:16:0x0039, B:18:0x003f), top: B:23:0x0005 }] */
    public final <R> R T0(y yVar, y yVar2, Integer num, List<? extends Pair<RecomposeScopeImpl, ? extends Object>> list, Function0<? extends R> function0) {
        R rInvoke;
        boolean z11 = this.G;
        int i11 = this.f3248k;
        try {
            this.G = true;
            this.f3248k = 0;
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                Pair<RecomposeScopeImpl, ? extends Object> pair = list.get(i12);
                RecomposeScopeImpl recomposeScopeImplComponent1 = pair.component1();
                Object objComponent2 = pair.component2();
                if (objComponent2 != null) {
                    o1(recomposeScopeImplComponent1, objComponent2);
                } else {
                    o1(recomposeScopeImplComponent1, null);
                }
            }
            if (yVar == null) {
                rInvoke = function0.invoke();
            } else {
                rInvoke = (R) yVar.g(yVar2, num != null ? num.intValue() : -1, function0);
                if (rInvoke == null) {
                    rInvoke = function0.invoke();
                }
            }
            return rInvoke;
        } finally {
            this.G = z11;
            this.f3248k = i11;
        }
    }

    public final void V0() {
        boolean z11 = this.G;
        this.G = true;
        int iU = this.I.u();
        int iE = this.I.E(iU) + iU;
        int i11 = this.f3248k;
        int iM = M();
        int i12 = this.f3249l;
        int i13 = this.f3250m;
        o0 o0VarZ = k.z(this.f3257t, this.I.k(), iE);
        boolean z12 = false;
        int i14 = iU;
        while (o0VarZ != null) {
            int iB = o0VarZ.b();
            k.O(this.f3257t, iB);
            if (o0VarZ.d()) {
                this.I.Q(iB);
                int iK = this.I.k();
                Z0(i14, iK, iU);
                this.f3248k = P0(iB, iK, iU, i11);
                this.f3250m = R0(iK);
                int iP = this.I.P(iK);
                this.S = j0(iP, R0(iP), iU, iM);
                this.M = null;
                o0VarZ.c().g(this);
                this.M = null;
                this.I.R(iU);
                i14 = iK;
                z12 = true;
            } else {
                this.F.h(o0VarZ.c());
                o0VarZ.c().y();
                this.F.g();
            }
            o0VarZ = k.z(this.f3257t, this.I.k(), iE);
        }
        if (z12) {
            Z0(i14, iU, iU);
            this.I.T();
            int iV1 = v1(iU);
            this.f3248k = i11 + iV1;
            this.f3249l = i12 + iV1;
            this.f3250m = i13;
        } else {
            h1();
        }
        this.S = iM;
        this.G = z11;
    }

    public final void W0() {
        c1(this.I.k());
        this.O.P();
    }

    public final void X0(androidx.compose.runtime.c cVar) {
        if (this.Q.e()) {
            this.O.t(cVar, this.J);
        } else {
            this.O.u(cVar, this.J, this.Q);
            this.Q = new r1.c();
        }
    }

    public final void Y0(n1 n1Var) {
        androidx.compose.runtime.collection.a<n1> aVar = this.f3260w;
        if (aVar == null) {
            aVar = new androidx.compose.runtime.collection.a<>(0, 1, null);
            this.f3260w = aVar;
        }
        aVar.b(this.I.k(), n1Var);
    }

    public final void Z0(int i11, int i12, int i13) {
        i2 i2Var = this.I;
        int iL = k.L(i2Var, i11, i12, i13);
        while (i11 > 0 && i11 != iL) {
            if (i2Var.J(i11)) {
                this.O.A();
            }
            i11 = i2Var.P(i11);
        }
        q0(i12, iL);
    }

    @Override // androidx.compose.runtime.i
    public boolean a(boolean z11) {
        Object objM0 = M0();
        if ((objM0 instanceof Boolean) && z11 == ((Boolean) objM0).booleanValue()) {
            return false;
        }
        u1(Boolean.valueOf(z11));
        return true;
    }

    public final androidx.compose.runtime.c a1() {
        int i11;
        int i12;
        if (e()) {
            if (!k.I(this.K)) {
                return null;
            }
            int iC0 = this.K.c0() - 1;
            int iH0 = this.K.H0(iC0);
            while (true) {
                int i13 = iH0;
                i12 = iC0;
                iC0 = i13;
                if (iC0 == this.K.e0() || iC0 < 0) {
                    break;
                }
                iH0 = this.K.H0(iC0);
            }
            return this.K.E(i12);
        }
        if (!k.H(this.I)) {
            return null;
        }
        int iK = this.I.k() - 1;
        int iP = this.I.P(iK);
        while (true) {
            int i14 = iP;
            i11 = iK;
            iK = i14;
            if (iK == this.I.u() || iK < 0) {
                break;
            }
            iP = this.I.P(iK);
        }
        return this.I.a(i11);
    }

    @Override // androidx.compose.runtime.i
    public boolean b(float f11) {
        Object objM0 = M0();
        if ((objM0 instanceof Float) && f11 == ((Number) objM0).floatValue()) {
            return false;
        }
        u1(Float.valueOf(f11));
        return true;
    }

    public final void b1() {
        if (this.f3241d.r()) {
            r1.a aVar = new r1.a();
            this.N = aVar;
            i2 i2VarD = this.f3241d.D();
            try {
                this.I = i2VarD;
                r1.b bVar = this.O;
                r1.a aVarO = bVar.o();
                try {
                    bVar.T(aVar);
                    c1(0);
                    this.O.M();
                    bVar.T(aVarO);
                    Unit unit = Unit.f68710a;
                    i2VarD.d();
                } catch (Throwable th2) {
                    bVar.T(aVarO);
                    throw th2;
                }
            } catch (Throwable th3) {
                i2VarD.d();
                throw th3;
            }
        }
    }

    @Override // androidx.compose.runtime.i
    public boolean c(int i11) {
        Object objM0 = M0();
        if ((objM0 instanceof Integer) && i11 == ((Number) objM0).intValue()) {
            return false;
        }
        u1(Integer.valueOf(i11));
        return true;
    }

    public final void c1(int i11) {
        d1(this, i11, false, 0);
        this.O.i();
    }

    @Override // androidx.compose.runtime.i
    public boolean d(long j11) {
        Object objM0 = M0();
        if ((objM0 instanceof Long) && j11 == ((Number) objM0).longValue()) {
            return false;
        }
        u1(Long.valueOf(j11));
        return true;
    }

    @Override // androidx.compose.runtime.i
    public boolean e() {
        return this.R;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0069  */
    public final void e0() {
        RecomposeScopeImpl recomposeScopeImpl;
        boolean z11;
        if (e()) {
            y yVarB0 = B0();
            Intrinsics.e(yVarB0, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl((o) yVarB0);
            this.F.h(recomposeScopeImpl2);
            u1(recomposeScopeImpl2);
            recomposeScopeImpl2.I(this.C);
            return;
        }
        o0 o0VarO = k.O(this.f3257t, this.I.u());
        Object objK = this.I.K();
        if (Intrinsics.b(objK, i.f3413a.a())) {
            y yVarB1 = B0();
            Intrinsics.e(yVarB1, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            recomposeScopeImpl = new RecomposeScopeImpl((o) yVarB1);
            u1(recomposeScopeImpl);
        } else {
            Intrinsics.e(objK, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
            recomposeScopeImpl = (RecomposeScopeImpl) objK;
        }
        if (o0VarO == null) {
            boolean zM = recomposeScopeImpl.m();
            if (zM) {
                recomposeScopeImpl.D(false);
            }
            z11 = zM;
        }
        recomposeScopeImpl.E(z11);
        this.F.h(recomposeScopeImpl);
        recomposeScopeImpl.I(this.C);
    }

    public final void e1(i2 i2Var) {
        this.I = i2Var;
    }

    @Override // androidx.compose.runtime.i
    public void f(boolean z11) {
        if (!(this.f3249l == 0)) {
            k.s("No nodes can be emitted before calling dactivateToEndGroup");
        }
        if (e()) {
            return;
        }
        if (!z11) {
            h1();
            return;
        }
        int iK = this.I.k();
        int iJ = this.I.j();
        this.O.d();
        k.P(this.f3257t, iK, iJ);
        this.I.T();
    }

    public final void f0() {
        this.f3260w = null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0086  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d0  */
    public void f1() {
        int iRotateLeft;
        int iHashCode;
        int iRotateRight;
        if (this.f3257t.isEmpty()) {
            g1();
            return;
        }
        i2 i2Var = this.I;
        int iN = i2Var.n();
        Object objO = i2Var.o();
        Object objL = i2Var.l();
        int i11 = this.f3250m;
        if (objO == null) {
            if (objL == null || iN != 207 || Intrinsics.b(objL, i.f3413a.a())) {
                iRotateLeft = Integer.rotateLeft(Integer.rotateLeft(M(), 3) ^ iN, 3) ^ i11;
            } else {
                this.S = Integer.rotateLeft(objL.hashCode() ^ Integer.rotateLeft(M(), 3), 3) ^ i11;
            }
            l1(i2Var.I(), null);
            V0();
            i2Var.g();
            if (objO != null) {
                if (objO instanceof Enum) {
                    iHashCode = ((Enum) objO).ordinal();
                } else {
                    iHashCode = objO.hashCode();
                }
                iRotateRight = iHashCode ^ Integer.rotateRight(M(), 3);
            } else {
                if (objL == null && iN == 207 && !Intrinsics.b(objL, i.f3413a.a())) {
                    this.S = Integer.rotateRight(objL.hashCode() ^ Integer.rotateRight(M() ^ i11, 3), 3);
                    return;
                }
                iRotateRight = Integer.rotateRight(M() ^ i11, 3) ^ iN;
            }
            this.S = Integer.rotateRight(iRotateRight, 3);
        }
        iRotateLeft = Integer.rotateLeft((objO instanceof Enum ? ((Enum) objO).ordinal() : objO.hashCode()) ^ Integer.rotateLeft(M(), 3), 3);
        this.S = iRotateLeft;
        l1(i2Var.I(), null);
        V0();
        i2Var.g();
        if (objO != null) {
            if (objL == null) {
            }
            iRotateRight = Integer.rotateRight(M() ^ i11, 3) ^ iN;
        } else {
            if (objO instanceof Enum) {
                iHashCode = ((Enum) objO).ordinal();
            } else {
                iHashCode = objO.hashCode();
            }
            iRotateRight = iHashCode ^ Integer.rotateRight(M(), 3);
        }
        this.S = Integer.rotateRight(iRotateRight, 3);
    }

    @Override // androidx.compose.runtime.i
    public i g(int i11) {
        R(i11);
        e0();
        return this;
    }

    public final void g0() {
        this.f3247j = null;
        this.f3248k = 0;
        this.f3249l = 0;
        this.S = 0;
        this.f3256s = false;
        this.O.S();
        this.F.a();
        h0();
    }

    public final void g1() {
        this.f3249l += this.I.S();
    }

    @Override // androidx.compose.runtime.i
    public boolean h() {
        RecomposeScopeImpl recomposeScopeImplC0;
        return (e() || this.f3263z || this.f3261x || (recomposeScopeImplC0 = C0()) == null || recomposeScopeImplC0.n() || this.f3255r) ? false : true;
    }

    public final void h0() {
        this.f3252o = null;
        this.f3253p = null;
    }

    public final void h1() {
        this.f3249l = this.I.v();
        this.I.T();
    }

    @Override // androidx.compose.runtime.i
    public f<?> i() {
        return this.f3239b;
    }

    public final void i0(androidx.compose.runtime.collection.e<RecomposeScopeImpl, Object> eVar, Function2<? super i, ? super Integer, Unit> function2) {
        if (!this.f3243f.c()) {
            k.s("Expected applyChanges() to have been called");
        }
        p0(eVar, function2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0068  */
    /* JADX WARN: Code duplicated, block: B:22:0x0076  */
    /* JADX WARN: Code duplicated, block: B:23:0x0078  */
    /* JADX WARN: Code duplicated, block: B:26:0x0081  */
    /* JADX WARN: Code duplicated, block: B:28:0x008e  */
    /* JADX WARN: Code duplicated, block: B:29:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x009c  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:58:0x010d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0120  */
    /* JADX WARN: Code duplicated, block: B:68:0x0161  */
    /* JADX WARN: Code duplicated, block: B:70:0x017a  */
    /* JADX WARN: Code duplicated, block: B:71:0x0186 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0188  */
    /* JADX WARN: Code duplicated, block: B:74:0x018c  */
    /* JADX WARN: Code duplicated, block: B:76:0x0196  */
    /* JADX WARN: Code duplicated, block: B:78:0x019a  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d7  */
    public final void i1(int i11, Object obj, int i12, Object obj2) {
        int iRotateLeft;
        k0.a aVar;
        boolean z11;
        Pending pending;
        boolean z12;
        Pending pending2;
        int iC0;
        Pending pending3;
        Object objA = obj;
        x1();
        int i13 = this.f3250m;
        if (objA == null) {
            if (obj2 == null || i11 != 207 || Intrinsics.b(obj2, i.f3413a.a())) {
                iRotateLeft = i13 ^ Integer.rotateLeft(Integer.rotateLeft(M(), 3) ^ i11, 3);
            } else {
                this.S = i13 ^ Integer.rotateLeft(obj2.hashCode() ^ Integer.rotateLeft(M(), 3), 3);
            }
            if (objA == null) {
                this.f3250m++;
            }
            aVar = k0.f3470a;
            if (i12 != aVar.a()) {
                z11 = true;
            } else {
                z11 = false;
            }
            pending = null;
            if (e()) {
                this.I.c();
                iC0 = this.K.c0();
                if (z11) {
                    this.K.m1(i11, i.f3413a.a());
                } else if (obj2 != null) {
                    m2 m2Var = this.K;
                    if (objA == null) {
                        objA = i.f3413a.a();
                    }
                    m2Var.i1(i11, objA, obj2);
                } else {
                    m2 m2Var2 = this.K;
                    if (objA == null) {
                        objA = i.f3413a.a();
                    }
                    m2Var2.k1(i11, objA);
                }
                pending3 = this.f3247j;
                if (pending3 != null) {
                    q0 q0Var = new q0(i11, -1, J0(iC0), -1, 0);
                    pending3.i(q0Var, this.f3248k - pending3.e());
                    pending3.h(q0Var);
                }
                w0(z11, null);
                return;
            }
            if (i12 != aVar.b() && this.f3263z) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (this.f3247j == null) {
                int iN = this.I.n();
                if (z12 && iN == i11 && Intrinsics.b(obj, this.I.o())) {
                    l1(z11, obj2);
                } else {
                    this.f3247j = new Pending(this.I.h(), this.f3248k);
                }
            }
            pending2 = this.f3247j;
            if (pending2 != null) {
                q0 q0VarD = pending2.d(i11, obj);
                if (!z12 || q0VarD == null) {
                    this.I.c();
                    this.R = true;
                    this.M = null;
                    v0();
                    this.K.I();
                    int iC1 = this.K.c0();
                    if (z11) {
                        this.K.m1(i11, i.f3413a.a());
                    } else if (obj2 != null) {
                        m2 m2Var3 = this.K;
                        if (objA == null) {
                            objA = i.f3413a.a();
                        }
                        m2Var3.i1(i11, objA, obj2);
                    } else {
                        m2 m2Var4 = this.K;
                        if (objA == null) {
                            objA = i.f3413a.a();
                        }
                        m2Var4.k1(i11, objA);
                    }
                    this.P = this.K.E(iC1);
                    q0 q0Var2 = new q0(i11, -1, J0(iC1), -1, 0);
                    pending2.i(q0Var2, this.f3248k - pending2.e());
                    pending2.h(q0Var2);
                    pending = new Pending(new ArrayList(), z11 ? 0 : this.f3248k);
                } else {
                    pending2.h(q0VarD);
                    int iB = q0VarD.b();
                    this.f3248k = pending2.g(q0VarD) + pending2.e();
                    int iM = pending2.m(q0VarD);
                    int iA = iM - pending2.a();
                    pending2.k(iM, pending2.a());
                    this.O.y(iB);
                    this.I.Q(iB);
                    if (iA > 0) {
                        this.O.v(iA);
                    }
                    l1(z11, obj2);
                }
            }
            w0(z11, pending);
        }
        iRotateLeft = Integer.rotateLeft((objA instanceof Enum ? ((Enum) objA).ordinal() : obj.hashCode()) ^ Integer.rotateLeft(M(), 3), 3);
        this.S = iRotateLeft;
        if (objA == null) {
            this.f3250m++;
        }
        aVar = k0.f3470a;
        if (i12 != aVar.a()) {
            z11 = true;
        } else {
            z11 = false;
        }
        pending = null;
        if (e()) {
            this.I.c();
            iC0 = this.K.c0();
            if (z11) {
                this.K.m1(i11, i.f3413a.a());
            } else if (obj2 != null) {
                m2 m2Var5 = this.K;
                if (objA == null) {
                    objA = i.f3413a.a();
                }
                m2Var5.i1(i11, objA, obj2);
            } else {
                m2 m2Var6 = this.K;
                if (objA == null) {
                    objA = i.f3413a.a();
                }
                m2Var6.k1(i11, objA);
            }
            pending3 = this.f3247j;
            if (pending3 != null) {
                q0 q0Var3 = new q0(i11, -1, J0(iC0), -1, 0);
                pending3.i(q0Var3, this.f3248k - pending3.e());
                pending3.h(q0Var3);
            }
            w0(z11, null);
            return;
        }
        if (i12 != aVar.b()) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (this.f3247j == null) {
            int iN2 = this.I.n();
            if (z12) {
                this.f3247j = new Pending(this.I.h(), this.f3248k);
            } else {
                this.f3247j = new Pending(this.I.h(), this.f3248k);
            }
        }
        pending2 = this.f3247j;
        if (pending2 != null) {
            q0 q0VarD2 = pending2.d(i11, obj);
            if (z12) {
                this.I.c();
                this.R = true;
                this.M = null;
                v0();
                this.K.I();
                int iC2 = this.K.c0();
                if (z11) {
                    this.K.m1(i11, i.f3413a.a());
                } else if (obj2 != null) {
                    m2 m2Var7 = this.K;
                    if (objA == null) {
                        objA = i.f3413a.a();
                    }
                    m2Var7.i1(i11, objA, obj2);
                } else {
                    m2 m2Var8 = this.K;
                    if (objA == null) {
                        objA = i.f3413a.a();
                    }
                    m2Var8.k1(i11, objA);
                }
                this.P = this.K.E(iC2);
                q0 q0Var4 = new q0(i11, -1, J0(iC2), -1, 0);
                pending2.i(q0Var4, this.f3248k - pending2.e());
                pending2.h(q0Var4);
                pending = new Pending(new ArrayList(), z11 ? 0 : this.f3248k);
            } else {
                this.I.c();
                this.R = true;
                this.M = null;
                v0();
                this.K.I();
                int iC3 = this.K.c0();
                if (z11) {
                    this.K.m1(i11, i.f3413a.a());
                } else if (obj2 != null) {
                    m2 m2Var9 = this.K;
                    if (objA == null) {
                        objA = i.f3413a.a();
                    }
                    m2Var9.i1(i11, objA, obj2);
                } else {
                    m2 m2Var10 = this.K;
                    if (objA == null) {
                        objA = i.f3413a.a();
                    }
                    m2Var10.k1(i11, objA);
                }
                this.P = this.K.E(iC3);
                q0 q0Var5 = new q0(i11, -1, J0(iC3), -1, 0);
                pending2.i(q0Var5, this.f3248k - pending2.e());
                pending2.h(q0Var5);
                pending = new Pending(new ArrayList(), z11 ? 0 : this.f3248k);
            }
        }
        w0(z11, pending);
    }

    @Override // androidx.compose.runtime.i
    public g2 j() {
        androidx.compose.runtime.c cVarA;
        Function1<l, Unit> function1H;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl recomposeScopeImplG = this.F.d() ? this.F.g() : null;
        if (recomposeScopeImplG != null) {
            recomposeScopeImplG.E(false);
        }
        if (recomposeScopeImplG != null && (function1H = recomposeScopeImplG.h(this.C)) != null) {
            this.O.f(function1H, B0());
        }
        if (recomposeScopeImplG != null && !recomposeScopeImplG.p() && (recomposeScopeImplG.q() || this.f3254q)) {
            if (recomposeScopeImplG.i() == null) {
                if (e()) {
                    m2 m2Var = this.K;
                    cVarA = m2Var.E(m2Var.e0());
                } else {
                    i2 i2Var = this.I;
                    cVarA = i2Var.a(i2Var.u());
                }
                recomposeScopeImplG.A(cVarA);
            }
            recomposeScopeImplG.C(false);
            recomposeScopeImpl = recomposeScopeImplG;
        }
        r0(false);
        return recomposeScopeImpl;
    }

    public final int j0(int i11, int i12, int i13, int i14) {
        if (i11 == i13) {
            return i14;
        }
        int iG0 = G0(this.I, i11);
        if (iG0 == 126665345) {
            return iG0;
        }
        int iP = this.I.P(i11);
        if (iP != i13) {
            i14 = j0(iP, R0(iP), i13, i14);
        }
        if (this.I.G(i11)) {
            i12 = 0;
        }
        return Integer.rotateLeft(Integer.rotateLeft(i14, 3) ^ iG0, 3) ^ i12;
    }

    public final void j1(int i11) {
        i1(i11, null, k0.f3470a.a(), null);
    }

    @Override // androidx.compose.runtime.i
    public <V, T> void k(V v11, Function2<? super T, ? super V, Unit> function2) {
        if (e()) {
            this.Q.f(v11, function2);
        } else {
            this.O.a0(v11, function2);
        }
    }

    public final void k0() {
        k.Q(this.K.Z());
        z0();
    }

    public final void k1(int i11, Object obj) {
        i1(i11, obj, k0.f3470a.a(), null);
    }

    @Override // androidx.compose.runtime.i
    public <T> T l(q<T> qVar) {
        return (T) t.b(l0(), qVar);
    }

    public final n1 l0() {
        n1 n1Var = this.M;
        return n1Var != null ? n1Var : m0(this.I.u());
    }

    public final void l1(boolean z11, Object obj) {
        if (z11) {
            this.I.V();
            return;
        }
        if (obj != null && this.I.l() != obj) {
            this.O.Z(obj);
        }
        this.I.U();
    }

    @Override // androidx.compose.runtime.i
    public CoroutineContext m() {
        return this.f3240c.i();
    }

    public final n1 m0(int i11) {
        n1 n1VarA;
        if (e() && this.L) {
            int iE0 = this.K.e0();
            while (iE0 > 0) {
                if (this.K.k0(iE0) == 202 && Intrinsics.b(this.K.l0(iE0), k.A())) {
                    Object objI0 = this.K.i0(iE0);
                    Intrinsics.e(objI0, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    n1 n1Var = (n1) objI0;
                    this.M = n1Var;
                    return n1Var;
                }
                iE0 = this.K.H0(iE0);
            }
        }
        if (this.I.x() > 0) {
            while (i11 > 0) {
                if (this.I.C(i11) == 202 && Intrinsics.b(this.I.D(i11), k.A())) {
                    androidx.compose.runtime.collection.a<n1> aVar = this.f3260w;
                    if (aVar == null || (n1VarA = aVar.a(i11)) == null) {
                        Object objZ = this.I.z(i11);
                        Intrinsics.e(objZ, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        n1VarA = (n1) objZ;
                    }
                    this.M = n1VarA;
                    return n1VarA;
                }
                i11 = this.I.P(i11);
            }
        }
        n1 n1Var2 = this.f3259v;
        this.M = n1Var2;
        return n1Var2;
    }

    public final void m1() {
        this.A = 100;
        this.f3263z = true;
    }

    @Override // androidx.compose.runtime.i
    public s n() {
        return l0();
    }

    public final void n0() {
        this.F.a();
        this.f3257t.clear();
        this.f3243f.a();
        this.f3260w = null;
    }

    public final void n1() {
        this.f3250m = 0;
        this.I = this.f3241d.D();
        j1(100);
        this.f3240c.r();
        this.f3259v = this.f3240c.g();
        this.f3262y.j(k.p(this.f3261x));
        this.f3261x = Q(this.f3259v);
        this.M = null;
        if (!this.f3254q) {
            this.f3254q = this.f3240c.e();
        }
        if (!this.D) {
            this.D = this.f3240c.f();
        }
        Set<w1.a> set = (Set) t.b(this.f3259v, InspectionTablesKt.a());
        if (set != null) {
            set.add(this.f3241d);
            this.f3240c.o(set);
        }
        j1(this.f3240c.h());
    }

    @Override // androidx.compose.runtime.i
    public void o() {
        w1();
        if (!(!e())) {
            k.s("useNode() called while inserting");
        }
        Object objE0 = E0(this.I);
        this.O.w(objE0);
        if (this.f3263z && (objE0 instanceof h)) {
            this.O.c0(objE0);
        }
    }

    public final void o0() {
        Object objA = e3.f3371a.a("Compose:Composer.dispose");
        try {
            this.f3240c.s(this);
            n0();
            i().clear();
            this.H = true;
            Unit unit = Unit.f68710a;
        } finally {
            e3.f3371a.b(objA);
        }
    }

    public final boolean o1(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        androidx.compose.runtime.c cVarI = recomposeScopeImpl.i();
        if (cVarI == null) {
            return false;
        }
        int iD = cVarI.d(this.I.y());
        if (!this.G || iD < this.I.k()) {
            return false;
        }
        k.G(this.f3257t, iD, recomposeScopeImpl, obj);
        return true;
    }

    @Override // androidx.compose.runtime.i
    public void p(Object obj) {
        p1(obj);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0094  */
    public final void p0(androidx.compose.runtime.collection.e<RecomposeScopeImpl, Object> eVar, Function2<? super i, ? super Integer, Unit> function2) {
        long[] jArr;
        if (!(!this.G)) {
            k.s("Reentrant composition is not supported");
        }
        Object objA = e3.f3371a.a("Compose:recompose");
        try {
            this.C = SnapshotKt.H().f();
            this.f3260w = null;
            androidx.collection.l0<Object, Object> l0VarD = eVar.d();
            Object[] objArr = l0VarD.f1983b;
            Object[] objArr2 = l0VarD.f1984c;
            long[] jArr2 = l0VarD.f1982a;
            int length = jArr2.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr2[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        int i13 = 0;
                        while (i13 < i12) {
                            if ((j11 & 255) < 128) {
                                int i14 = (i11 << 3) + i13;
                                Object obj = objArr[i14];
                                Object obj2 = objArr2[i14];
                                Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                                androidx.compose.runtime.c cVarI = ((RecomposeScopeImpl) obj).i();
                                if (cVarI != null) {
                                    int iA = cVarI.a();
                                    List<o0> list = this.f3257t;
                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                                    if (obj2 == f2.f3409a) {
                                        obj2 = null;
                                    }
                                    list.add(new o0(recomposeScopeImpl, iA, obj2));
                                }
                            }
                            j11 >>= 8;
                            i13++;
                            jArr2 = jArr2;
                        }
                        jArr = jArr2;
                        if (i12 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr2;
                    }
                    if (i11 == length) {
                        break;
                    }
                    i11++;
                    jArr2 = jArr;
                }
            }
            kotlin.collections.j.z(this.f3257t, k.f3469g);
            this.f3248k = 0;
            this.G = true;
            try {
                n1();
                Object objM0 = M0();
                if (objM0 != function2 && function2 != null) {
                    u1(function2);
                }
                c cVar = this.E;
                androidx.compose.runtime.collection.b<a0> bVarA = r2.a();
                try {
                    bVarA.b(cVar);
                    if (function2 != null) {
                        k1(200, k.B());
                        androidx.compose.runtime.b.d(this, function2);
                        s0();
                    } else if ((!this.f3255r && !this.f3261x) || objM0 == null || Intrinsics.b(objM0, i.f3413a.a())) {
                        f1();
                    } else {
                        k1(200, k.B());
                        androidx.compose.runtime.b.d(this, (Function2) TypeIntrinsics.e(objM0, 2));
                        s0();
                    }
                    bVarA.z(bVarA.r() - 1);
                    u0();
                    this.G = false;
                    this.f3257t.clear();
                    k0();
                    Unit unit = Unit.f68710a;
                    e3.f3371a.b(objA);
                } catch (Throwable th2) {
                    bVarA.z(bVarA.r() - 1);
                    throw th2;
                }
            } catch (Throwable th3) {
                this.G = false;
                this.f3257t.clear();
                T();
                k0();
                throw th3;
            }
        } catch (Throwable th4) {
            e3.f3371a.b(objA);
            throw th4;
        }
    }

    @PublishedApi
    public final void p1(Object obj) {
        if (obj instanceof b2) {
            if (e()) {
                this.O.O((b2) obj);
            }
            this.f3242e.add(obj);
            obj = new c2((b2) obj, a1());
        }
        u1(obj);
    }

    @Override // androidx.compose.runtime.i
    public void q() {
        s0();
        s0();
        this.f3261x = k.o(this.f3262y.i());
        this.M = null;
    }

    public final void q0(int i11, int i12) {
        if (i11 <= 0 || i11 == i12) {
            return;
        }
        q0(this.I.P(i11), i12);
        if (this.I.J(i11)) {
            this.O.w(O0(this.I, i11));
        }
    }

    public final void q1(int i11, int i12) {
        if (v1(i11) != i12) {
            if (i11 < 0) {
                androidx.collection.a0 a0Var = this.f3253p;
                if (a0Var == null) {
                    a0Var = new androidx.collection.a0(0, 1, null);
                    this.f3253p = a0Var;
                }
                a0Var.q(i11, i12);
                return;
            }
            int[] iArr = this.f3252o;
            if (iArr == null) {
                iArr = new int[this.I.x()];
                ArraysKt___ArraysJvmKt.v(iArr, -1, 0, 0, 6, null);
                this.f3252o = iArr;
            }
            iArr[i11] = i12;
        }
    }

    @Override // androidx.compose.runtime.i
    public void r() {
        r0(true);
    }

    public final void r0(boolean z11) {
        int iOrdinal;
        Set set;
        int iOrdinal2;
        int iG = this.f3251n.g() - 1;
        if (e()) {
            int iE0 = this.K.e0();
            int iK0 = this.K.k0(iE0);
            Object objL0 = this.K.l0(iE0);
            Object objI0 = this.K.i0(iE0);
            if (objL0 != null) {
                iOrdinal2 = (objL0 instanceof Enum ? ((Enum) objL0).ordinal() : objL0.hashCode()) ^ Integer.rotateRight(M(), 3);
            } else if (objI0 == null || iK0 != 207 || Intrinsics.b(objI0, i.f3413a.a())) {
                iOrdinal2 = Integer.rotateRight(iG ^ M(), 3) ^ iK0;
            } else {
                this.S = Integer.rotateRight(Integer.rotateRight(iG ^ M(), 3) ^ objI0.hashCode(), 3);
            }
            this.S = Integer.rotateRight(iOrdinal2, 3);
        } else {
            int iU = this.I.u();
            int iC = this.I.C(iU);
            Object objD = this.I.D(iU);
            Object objZ = this.I.z(iU);
            if (objD != null) {
                iOrdinal = (objD instanceof Enum ? ((Enum) objD).ordinal() : objD.hashCode()) ^ Integer.rotateRight(M(), 3);
            } else if (objZ == null || iC != 207 || Intrinsics.b(objZ, i.f3413a.a())) {
                iOrdinal = Integer.rotateRight(iG ^ M(), 3) ^ iC;
            } else {
                this.S = Integer.rotateRight(Integer.rotateRight(iG ^ M(), 3) ^ objZ.hashCode(), 3);
            }
            this.S = Integer.rotateRight(iOrdinal, 3);
        }
        int i11 = this.f3249l;
        Pending pending = this.f3247j;
        if (pending != null && pending.b().size() > 0) {
            List<q0> listB = pending.b();
            List<q0> listF = pending.f();
            Set setE = androidx.compose.runtime.snapshots.a.e(listF);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = listF.size();
            int size2 = listB.size();
            int i12 = 0;
            int i13 = 0;
            int iO = 0;
            while (i12 < size2) {
                q0 q0Var = listB.get(i12);
                if (setE.contains(q0Var)) {
                    set = setE;
                    if (!linkedHashSet.contains(q0Var)) {
                        if (i13 < size) {
                            q0 q0Var2 = listF.get(i13);
                            if (q0Var2 != q0Var) {
                                int iG2 = pending.g(q0Var2);
                                linkedHashSet.add(q0Var2);
                                if (iG2 != iO) {
                                    int iO2 = pending.o(q0Var2);
                                    this.O.x(pending.e() + iG2, iO + pending.e(), iO2);
                                    pending.j(iG2, iO, iO2);
                                }
                            } else {
                                i12++;
                            }
                            i13++;
                            iO += pending.o(q0Var2);
                            setE = set;
                            listF = listF;
                        }
                    }
                    setE = set;
                } else {
                    this.O.Q(pending.g(q0Var) + pending.e(), q0Var.c());
                    pending.n(q0Var.b(), 0);
                    this.O.y(q0Var.b());
                    this.I.Q(q0Var.b());
                    W0();
                    this.I.S();
                    set = setE;
                    k.P(this.f3257t, q0Var.b(), q0Var.b() + this.I.E(q0Var.b()));
                }
                i12++;
                setE = set;
            }
            this.O.i();
            if (listB.size() > 0) {
                this.O.y(this.I.m());
                this.I.T();
            }
        }
        int i14 = this.f3248k;
        while (!this.I.H()) {
            int iK = this.I.k();
            W0();
            this.O.Q(i14, this.I.S());
            k.P(this.f3257t, iK, this.I.k());
        }
        boolean zE = e();
        if (zE) {
            if (z11) {
                this.Q.c();
                i11 = 1;
            }
            this.I.f();
            int iE1 = this.K.e0();
            this.K.T();
            if (!this.I.t()) {
                int iJ0 = J0(iE1);
                this.K.U();
                this.K.L(true);
                X0(this.P);
                this.R = false;
                if (!this.f3241d.isEmpty()) {
                    q1(iJ0, 0);
                    r1(iJ0, i11);
                }
            }
        } else {
            if (z11) {
                this.O.A();
            }
            int iW = this.I.w();
            if (iW > 0) {
                this.O.X(iW);
            }
            this.O.g();
            int iU2 = this.I.u();
            if (i11 != v1(iU2)) {
                r1(iU2, i11);
            }
            if (z11) {
                i11 = 1;
            }
            this.I.g();
            this.O.i();
        }
        x0(i11, zE);
    }

    public final void r1(int i11, int i12) {
        int iV1 = v1(i11);
        if (iV1 != i12) {
            int i13 = i12 - iV1;
            int iB = this.f3246i.b() - 1;
            while (i11 != -1) {
                int iV2 = v1(i11) + i13;
                q1(i11, iV2);
                for (int i14 = iB; -1 < i14; i14--) {
                    Pending pendingF = this.f3246i.f(i14);
                    if (pendingF != null && pendingF.n(i11, iV2)) {
                        iB = i14 - 1;
                        break;
                    }
                }
                if (i11 < 0) {
                    i11 = this.I.u();
                } else if (this.I.J(i11)) {
                    return;
                } else {
                    i11 = this.I.P(i11);
                }
            }
        }
    }

    @Override // androidx.compose.runtime.i
    public void s() {
        s0();
        RecomposeScopeImpl recomposeScopeImplC0 = C0();
        if (recomposeScopeImplC0 == null || !recomposeScopeImplC0.q()) {
            return;
        }
        recomposeScopeImplC0.B(true);
    }

    public final void s0() {
        r0(false);
    }

    public final n1 s1(n1 n1Var, n1 n1Var2) {
        n1.a aVarQ = n1Var.q();
        aVarQ.putAll(n1Var2);
        n1 n1VarBuild = aVarQ.build();
        k1(204, k.E());
        t1(n1VarBuild);
        t1(n1Var2);
        s0();
        return n1VarBuild;
    }

    @Override // androidx.compose.runtime.i
    public void t(Function0<Unit> function0) {
        this.O.V(function0);
    }

    public final void t0() {
        if (!(!this.G && this.A == 100)) {
            o1.a("Cannot disable reuse from root if it was caused by other groups");
        }
        this.A = -1;
        this.f3263z = false;
    }

    public final void t1(Object obj) {
        M0();
        u1(obj);
    }

    @Override // androidx.compose.runtime.i
    public void u() {
        this.f3254q = true;
        this.D = true;
        this.f3241d.j();
        this.J.j();
        this.K.y1();
    }

    public final void u0() {
        s0();
        this.f3240c.c();
        s0();
        this.O.k();
        y0();
        this.I.d();
        this.f3255r = false;
        this.f3261x = k.o(this.f3262y.i());
    }

    @PublishedApi
    public final void u1(Object obj) {
        if (e()) {
            this.K.p1(obj);
            return;
        }
        if (!this.I.r()) {
            r1.b bVar = this.O;
            i2 i2Var = this.I;
            bVar.a(i2Var.a(i2Var.u()), obj);
            return;
        }
        int iQ = this.I.q() - 1;
        if (!this.O.q()) {
            this.O.b0(obj, iQ);
            return;
        }
        r1.b bVar2 = this.O;
        i2 i2Var2 = this.I;
        bVar2.Y(obj, i2Var2.a(i2Var2.u()), iQ);
    }

    @Override // androidx.compose.runtime.i
    public u1 v() {
        return C0();
    }

    public final void v0() {
        if (this.K.Z()) {
            m2 m2VarE = this.J.E();
            this.K = m2VarE;
            m2VarE.Z0();
            this.L = false;
            this.M = null;
        }
    }

    public final int v1(int i11) {
        int i12;
        if (i11 >= 0) {
            int[] iArr = this.f3252o;
            return (iArr == null || (i12 = iArr[i11]) < 0) ? this.I.N(i11) : i12;
        }
        androidx.collection.a0 a0Var = this.f3253p;
        if (a0Var == null || !a0Var.a(i11)) {
            return 0;
        }
        return a0Var.c(i11);
    }

    @Override // androidx.compose.runtime.i
    public void w() {
        if (this.f3263z && this.I.u() == this.A) {
            this.A = -1;
            this.f3263z = false;
        }
        r0(false);
    }

    public final void w0(boolean z11, Pending pending) {
        this.f3246i.h(this.f3247j);
        this.f3247j = pending;
        this.f3251n.j(this.f3249l);
        this.f3251n.j(this.f3250m);
        this.f3251n.j(this.f3248k);
        if (z11) {
            this.f3248k = 0;
        }
        this.f3249l = 0;
        this.f3250m = 0;
    }

    public final void w1() {
        if (!this.f3256s) {
            k.s("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.f3256s = false;
    }

    @Override // androidx.compose.runtime.i
    public void x(int i11) {
        i1(i11, null, k0.f3470a.a(), null);
    }

    public final void x0(int i11, boolean z11) {
        Pending pendingG = this.f3246i.g();
        if (pendingG != null && !z11) {
            pendingG.l(pendingG.a() + 1);
        }
        this.f3247j = pendingG;
        this.f3248k = this.f3251n.i() + i11;
        this.f3250m = this.f3251n.i();
        this.f3249l = this.f3251n.i() + i11;
    }

    public final void x1() {
        if (!this.f3256s) {
            return;
        }
        k.s("A call to createNode(), emitNode() or useNode() expected");
    }

    @Override // androidx.compose.runtime.i
    public Object y() {
        return N0();
    }

    public final void y0() {
        this.O.n();
        if (!this.f3246i.c()) {
            k.s("Start/end imbalance");
        }
        g0();
    }

    @Override // androidx.compose.runtime.i
    public w1.a z() {
        return this.f3241d;
    }

    public final void z0() {
        j2 j2Var = new j2();
        if (this.D) {
            j2Var.j();
        }
        if (this.f3240c.d()) {
            j2Var.i();
        }
        this.J = j2Var;
        m2 m2VarE = j2Var.E();
        m2VarE.L(true);
        this.K = m2VarE;
    }
}
