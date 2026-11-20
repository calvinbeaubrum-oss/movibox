package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.n1;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.z1;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.k0;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.layout.y;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.node.m;
import androidx.compose.ui.node.n;
import androidx.compose.ui.node.o;
import androidx.compose.ui.node.x;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.q;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.a0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.text.t;
import androidx.compose.ui.text.z;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import z1.l;

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
public final class TextAnnotatedStringNode extends androidx.compose.ui.f.c implements x, n, i1 {
    public Function1<? super a, Unit> A;
    public Map<androidx.compose.ui.layout.a, Integer> B;
    public e C;
    public Function1<? super List<a0>, Boolean> D;
    public a E;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AnnotatedString f2895o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e0 f2896p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.compose.ui.text.font.i.b f2897q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super a0, Unit> f2898r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2899s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2900t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2901u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2902v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List<AnnotatedString.b<t>> f2903w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function1<? super List<y1.i>, Unit> f2904x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public SelectionController f2905y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public z1 f2906z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnnotatedString f2907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AnnotatedString f2908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e f2910d;

        public a(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z11, e eVar) {
            this.f2907a = annotatedString;
            this.f2908b = annotatedString2;
            this.f2909c = z11;
            this.f2910d = eVar;
        }

        public /* synthetic */ a(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z11, e eVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(annotatedString, annotatedString2, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? null : eVar);
        }

        public final e a() {
            return this.f2910d;
        }

        public final AnnotatedString b() {
            return this.f2908b;
        }

        public final boolean c() {
            return this.f2909c;
        }

        public final void d(e eVar) {
            this.f2910d = eVar;
        }

        public final void e(boolean z11) {
            this.f2909c = z11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.b(this.f2907a, aVar.f2907a) && Intrinsics.b(this.f2908b, aVar.f2908b) && this.f2909c == aVar.f2909c && Intrinsics.b(this.f2910d, aVar.f2910d);
        }

        public final void f(AnnotatedString annotatedString) {
            this.f2908b = annotatedString;
        }

        public int hashCode() {
            int iHashCode = ((((this.f2907a.hashCode() * 31) + this.f2908b.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f2909c)) * 31;
            e eVar = this.f2910d;
            return iHashCode + (eVar == null ? 0 : eVar.hashCode());
        }

        public String toString() {
            return "TextSubstitutionValue(original=" + ((Object) this.f2907a) + ", substitution=" + ((Object) this.f2908b) + ", isShowingSubstitution=" + this.f2909c + ", layoutCache=" + this.f2910d + ')';
        }
    }

    public TextAnnotatedStringNode(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, Function1<? super a0, Unit> function1, int i11, boolean z11, int i12, int i13, List<AnnotatedString.b<t>> list, Function1<? super List<y1.i>, Unit> function2, SelectionController selectionController, z1 z1Var, Function1<? super a, Unit> function3) {
        this.f2895o = annotatedString;
        this.f2896p = e0Var;
        this.f2897q = bVar;
        this.f2898r = function1;
        this.f2899s = i11;
        this.f2900t = z11;
        this.f2901u = i12;
        this.f2902v = i13;
        this.f2903w = list;
        this.f2904x = function2;
        this.f2905y = selectionController;
        this.f2906z = z1Var;
        this.A = function3;
    }

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, Function1 function1, int i11, boolean z11, int i12, int i13, List list, Function1 function2, SelectionController selectionController, z1 z1Var, Function1 function3, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, e0Var, bVar, function1, i11, z11, i12, i13, list, function2, selectionController, z1Var, function3);
    }

    @Override // androidx.compose.ui.node.n
    public void A(z1.c cVar) {
        List<AnnotatedString.b<t>> list;
        if (o1()) {
            SelectionController selectionController = this.f2905y;
            if (selectionController != null) {
                selectionController.b(cVar);
            }
            o1 o1VarE = cVar.Q0().e();
            a0 a0VarC = R1(cVar).c();
            MultiParagraph multiParagraphV = a0VarC.v();
            boolean z11 = a0VarC.i() && !p.e(this.f2899s, p.f6143a.c());
            if (z11) {
                y1.i iVarA = y1.j.a(y1.g.f81070b.c(), y1.n.a(q2.t.g(a0VarC.y()), q2.t.f(a0VarC.y())));
                o1VarE.d();
                n1.e(o1VarE, iVarA, 0, 2, null);
            }
            try {
                androidx.compose.ui.text.style.i iVarA2 = this.f2896p.A();
                if (iVarA2 == null) {
                    iVarA2 = androidx.compose.ui.text.style.i.f6110b.b();
                }
                androidx.compose.ui.text.style.i iVar = iVarA2;
                b5 b5VarX = this.f2896p.x();
                if (b5VarX == null) {
                    b5VarX = b5.f3990d.a();
                }
                b5 b5Var = b5VarX;
                z1.h hVarI = this.f2896p.i();
                if (hVarI == null) {
                    hVarI = l.f81716a;
                }
                z1.h hVar = hVarI;
                l1 l1VarG = this.f2896p.g();
                if (l1VarG != null) {
                    multiParagraphV.z(o1VarE, l1VarG, (64 & 4) != 0 ? Float.NaN : this.f2896p.d(), (64 & 8) != 0 ? null : b5Var, (64 & 16) != 0 ? null : iVar, (64 & 32) != 0 ? null : hVar, (64 & 64) != 0 ? z1.g.f81712v8.a() : 0);
                } else {
                    z1 z1Var = this.f2906z;
                    long jA = z1Var != null ? z1Var.a() : w1.f4564b.e();
                    if (jA == 16) {
                        jA = this.f2896p.h() != 16 ? this.f2896p.h() : w1.f4564b.a();
                    }
                    multiParagraphV.x(o1VarE, (32 & 2) != 0 ? w1.f4564b.e() : jA, (32 & 4) != 0 ? null : b5Var, (32 & 8) != 0 ? null : iVar, (32 & 16) == 0 ? hVar : null, (32 & 32) != 0 ? z1.g.f81712v8.a() : 0);
                }
                if (z11) {
                    o1VarE.k();
                }
                a aVar = this.E;
                if (((aVar == null || !aVar.c()) && j.a(this.f2895o)) || !((list = this.f2903w) == null || list.isEmpty())) {
                    cVar.a1();
                }
            } catch (Throwable th2) {
                if (z11) {
                    o1VarE.k();
                }
                throw th2;
            }
        }
    }

    @Override // androidx.compose.ui.node.x
    public w C(y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        e eVarR1 = R1(yVar);
        boolean zE = eVarR1.e(j11, yVar.getLayoutDirection());
        a0 a0VarC = eVarR1.c();
        a0VarC.v().i().b();
        if (zE) {
            androidx.compose.ui.node.a0.a(this);
            Function1<? super a0, Unit> function1 = this.f2898r;
            if (function1 != null) {
                function1.invoke(a0VarC);
            }
            SelectionController selectionController = this.f2905y;
            if (selectionController != null) {
                selectionController.e(a0VarC);
            }
            Map<androidx.compose.ui.layout.a, Integer> linkedHashMap = this.B;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>(2);
            }
            linkedHashMap.put(AlignmentLineKt.a(), Integer.valueOf(Math.round(a0VarC.h())));
            linkedHashMap.put(AlignmentLineKt.b(), Integer.valueOf(Math.round(a0VarC.j())));
            this.B = linkedHashMap;
        }
        Function1<? super List<y1.i>, Unit> function2 = this.f2904x;
        if (function2 != null) {
            function2.invoke(a0VarC.x());
        }
        final k0 k0VarL = tVar.L(q2.b.f74225b.b(q2.t.g(a0VarC.y()), q2.t.g(a0VarC.y()), q2.t.f(a0VarC.y()), q2.t.f(a0VarC.y())));
        int iG = q2.t.g(a0VarC.y());
        int iF = q2.t.f(a0VarC.y());
        Map<androidx.compose.ui.layout.a, Integer> map = this.B;
        Intrinsics.d(map);
        return yVar.y0(iG, iF, map, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(k0.a aVar) {
                k0.a.h(aVar, k0VarL, 0, 0, 0.0f, 4, null);
            }
        });
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void F0() {
        m.a(this);
    }

    public final void N1() {
        this.E = null;
    }

    public final void O1(boolean z11, boolean z12, boolean z13, boolean z14) {
        if (z12 || z13 || z14) {
            Q1().k(this.f2895o, this.f2896p, this.f2897q, this.f2899s, this.f2900t, this.f2901u, this.f2902v, this.f2903w);
        }
        if (o1()) {
            if (z12 || (z11 && this.D != null)) {
                j1.b(this);
            }
            if (z12 || z13 || z14) {
                androidx.compose.ui.node.a0.b(this);
                o.a(this);
            }
            if (z11) {
                o.a(this);
            }
        }
    }

    public final void P1(z1.c cVar) {
        A(cVar);
    }

    public final e Q1() {
        if (this.C == null) {
            this.C = new e(this.f2895o, this.f2896p, this.f2897q, this.f2899s, this.f2900t, this.f2901u, this.f2902v, this.f2903w, null);
        }
        e eVar = this.C;
        Intrinsics.d(eVar);
        return eVar;
    }

    public final e R1(q2.e eVar) {
        e eVarA;
        a aVar = this.E;
        if (aVar != null && aVar.c() && (eVarA = aVar.a()) != null) {
            eVarA.h(eVar);
            return eVarA;
        }
        e eVarQ1 = Q1();
        eVarQ1.h(eVar);
        return eVarQ1;
    }

    public final a S1() {
        return this.E;
    }

    public final void T1() {
        j1.b(this);
        androidx.compose.ui.node.a0.b(this);
        o.a(this);
    }

    public final w U1(y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        return C(yVar, tVar, j11);
    }

    @Override // androidx.compose.ui.node.i1
    public boolean V() {
        return true;
    }

    public final boolean V1(AnnotatedString annotatedString) {
        Unit unit;
        a aVar = this.E;
        if (aVar == null) {
            a aVar2 = new a(this.f2895o, annotatedString, false, null, 12, null);
            e eVar = new e(annotatedString, this.f2896p, this.f2897q, this.f2899s, this.f2900t, this.f2901u, this.f2902v, this.f2903w, null);
            eVar.h(Q1().a());
            aVar2.d(eVar);
            this.E = aVar2;
            return true;
        }
        if (Intrinsics.b(annotatedString, aVar.b())) {
            return false;
        }
        aVar.f(annotatedString);
        e eVarA = aVar.a();
        if (eVarA != null) {
            eVarA.k(annotatedString, this.f2896p, this.f2897q, this.f2899s, this.f2900t, this.f2901u, this.f2902v, this.f2903w);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        return unit != null;
    }

    @Override // androidx.compose.ui.node.i1
    public void W0(q qVar) {
        Function1 function1 = this.D;
        if (function1 == null) {
            function1 = new Function1<List<a0>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1
                {
                    super(1);
                }

                /* JADX WARN: Code duplicated, block: B:11:0x00b8  */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(List<a0> list) {
                    a0 a0VarB;
                    a0 a0VarB2 = this.this$0.Q1().b();
                    if (a0VarB2 != null) {
                        AnnotatedString annotatedStringJ = a0VarB2.k().j();
                        e0 e0Var = this.this$0.f2896p;
                        z1 z1Var = this.this$0.f2906z;
                        a0VarB = a0.b(a0VarB2, new z(annotatedStringJ, e0Var.J((16777214 & 1) != 0 ? w1.f4564b.e() : z1Var != null ? z1Var.a() : w1.f4564b.e(), (16777214 & 2) != 0 ? q2.w.f74257b.a() : 0L, (16777214 & 4) != 0 ? null : null, (16777214 & 8) != 0 ? null : null, (16777214 & 16) != 0 ? null : null, (16777214 & 32) != 0 ? null : null, (16777214 & 64) != 0 ? null : null, (16777214 & 128) != 0 ? q2.w.f74257b.a() : 0L, (16777214 & 256) != 0 ? null : null, (16777214 & 512) != 0 ? null : null, (16777214 & 1024) != 0 ? null : null, (16777214 & 2048) != 0 ? w1.f4564b.e() : 0L, (16777214 & 4096) != 0 ? null : null, (16777214 & 8192) != 0 ? null : null, (16777214 & 16384) != 0 ? null : null, (16777214 & 32768) != 0 ? androidx.compose.ui.text.style.h.f6101b.g() : 0, (16777214 & 65536) != 0 ? androidx.compose.ui.text.style.j.f6115b.f() : 0, (16777214 & 131072) != 0 ? q2.w.f74257b.a() : 0L, (16777214 & 262144) != 0 ? null : null, (16777214 & 524288) != 0 ? null : null, (16777214 & 1048576) != 0 ? androidx.compose.ui.text.style.e.f6066b.b() : 0, (16777214 & 2097152) != 0 ? androidx.compose.ui.text.style.d.f6061b.c() : 0, (16777214 & 4194304) != 0 ? null : null, (16777214 & 8388608) != 0 ? null : null), a0VarB2.k().g(), a0VarB2.k().e(), a0VarB2.k().h(), a0VarB2.k().f(), a0VarB2.k().b(), a0VarB2.k().d(), a0VarB2.k().c(), a0VarB2.k().a(), (DefaultConstructorMarker) null), 0L, 2, null);
                        if (a0VarB != null) {
                            list.add(a0VarB);
                        } else {
                            a0VarB = null;
                        }
                    } else {
                        a0VarB = null;
                    }
                    return Boolean.valueOf(a0VarB != null);
                }
            };
            this.D = function1;
        }
        SemanticsPropertiesKt.E(qVar, this.f2895o);
        a aVar = this.E;
        if (aVar != null) {
            SemanticsPropertiesKt.F(qVar, aVar.b());
            SemanticsPropertiesKt.D(qVar, aVar.c());
        }
        SemanticsPropertiesKt.H(qVar, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AnnotatedString annotatedString) {
                this.this$0.V1(annotatedString);
                this.this$0.T1();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.M(qVar, null, new Function1<Boolean, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$3
            {
                super(1);
            }

            public final Boolean invoke(boolean z11) {
                if (this.this$0.S1() == null) {
                    return Boolean.FALSE;
                }
                Function1 function2 = this.this$0.A;
                if (function2 != null) {
                    TextAnnotatedStringNode.a aVarS1 = this.this$0.S1();
                    Intrinsics.d(aVarS1);
                    function2.invoke(aVarS1);
                }
                TextAnnotatedStringNode.a aVarS2 = this.this$0.S1();
                if (aVarS2 != null) {
                    aVarS2.e(z11);
                }
                this.this$0.T1();
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, 1, null);
        SemanticsPropertiesKt.d(qVar, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                this.this$0.N1();
                this.this$0.T1();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.j(qVar, null, function1, 1, null);
    }

    public final boolean W1(Function1<? super a0, Unit> function1, Function1<? super List<y1.i>, Unit> function2, SelectionController selectionController, Function1<? super a, Unit> function3) {
        boolean z11;
        if (this.f2898r != function1) {
            this.f2898r = function1;
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.f2904x != function2) {
            this.f2904x = function2;
            z11 = true;
        }
        if (!Intrinsics.b(this.f2905y, selectionController)) {
            this.f2905y = selectionController;
            z11 = true;
        }
        if (this.A == function3) {
            return z11;
        }
        this.A = function3;
        return true;
    }

    public final boolean X1(z1 z1Var, e0 e0Var) {
        boolean z11 = !Intrinsics.b(z1Var, this.f2906z);
        this.f2906z = z1Var;
        return z11 || !e0Var.F(this.f2896p);
    }

    public final boolean Y1(e0 e0Var, List<AnnotatedString.b<t>> list, int i11, int i12, boolean z11, androidx.compose.ui.text.font.i.b bVar, int i13) {
        boolean z12 = !this.f2896p.G(e0Var);
        this.f2896p = e0Var;
        if (!Intrinsics.b(this.f2903w, list)) {
            this.f2903w = list;
            z12 = true;
        }
        if (this.f2902v != i11) {
            this.f2902v = i11;
            z12 = true;
        }
        if (this.f2901u != i12) {
            this.f2901u = i12;
            z12 = true;
        }
        if (this.f2900t != z11) {
            this.f2900t = z11;
            z12 = true;
        }
        if (!Intrinsics.b(this.f2897q, bVar)) {
            this.f2897q = bVar;
            z12 = true;
        }
        if (p.e(this.f2899s, i13)) {
            return z12;
        }
        this.f2899s = i13;
        return true;
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean Z0() {
        return h1.b(this);
    }

    public final boolean Z1(AnnotatedString annotatedString) {
        boolean z11 = true;
        boolean z12 = !Intrinsics.b(this.f2895o.i(), annotatedString.i());
        boolean z13 = !Intrinsics.b(this.f2895o.g(), annotatedString.g());
        boolean z14 = !Intrinsics.b(this.f2895o.e(), annotatedString.e());
        boolean z15 = !this.f2895o.l(annotatedString);
        if (!z12 && !z13 && !z14 && !z15) {
            z11 = false;
        }
        if (z11) {
            this.f2895o = annotatedString;
        }
        if (z12) {
            N1();
        }
        return z11;
    }
}
