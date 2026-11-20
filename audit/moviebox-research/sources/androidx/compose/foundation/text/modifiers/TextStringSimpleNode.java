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
import androidx.compose.ui.text.a0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.k;
import androidx.compose.ui.text.l;
import androidx.compose.ui.text.style.p;
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
import q2.t;

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
public final class TextStringSimpleNode extends androidx.compose.ui.f.c implements x, n, i1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f2919o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e0 f2920p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.compose.ui.text.font.i.b f2921q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2922r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2923s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2924t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2925u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public z1 f2926v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map<androidx.compose.ui.layout.a, Integer> f2927w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public f f2928x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function1<? super List<a0>, Boolean> f2929y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f2930z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2933c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f2934d;

        public a(String str, String str2, boolean z11, f fVar) {
            this.f2931a = str;
            this.f2932b = str2;
            this.f2933c = z11;
            this.f2934d = fVar;
        }

        public /* synthetic */ a(String str, String str2, boolean z11, f fVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? null : fVar);
        }

        public final f a() {
            return this.f2934d;
        }

        public final String b() {
            return this.f2932b;
        }

        public final boolean c() {
            return this.f2933c;
        }

        public final void d(f fVar) {
            this.f2934d = fVar;
        }

        public final void e(boolean z11) {
            this.f2933c = z11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.b(this.f2931a, aVar.f2931a) && Intrinsics.b(this.f2932b, aVar.f2932b) && this.f2933c == aVar.f2933c && Intrinsics.b(this.f2934d, aVar.f2934d);
        }

        public final void f(String str) {
            this.f2932b = str;
        }

        public int hashCode() {
            int iHashCode = ((((this.f2931a.hashCode() * 31) + this.f2932b.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f2933c)) * 31;
            f fVar = this.f2934d;
            return iHashCode + (fVar == null ? 0 : fVar.hashCode());
        }

        public String toString() {
            return "TextSubstitution(layoutCache=" + this.f2934d + ", isShowingSubstitution=" + this.f2933c + ')';
        }
    }

    public TextStringSimpleNode(String str, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, int i11, boolean z11, int i12, int i13, z1 z1Var) {
        this.f2919o = str;
        this.f2920p = e0Var;
        this.f2921q = bVar;
        this.f2922r = i11;
        this.f2923s = z11;
        this.f2924t = i12;
        this.f2925u = i13;
        this.f2926v = z1Var;
    }

    public /* synthetic */ TextStringSimpleNode(String str, e0 e0Var, androidx.compose.ui.text.font.i.b bVar, int i11, boolean z11, int i12, int i13, z1 z1Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, e0Var, bVar, i11, z11, i12, i13, z1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1() {
        j1.b(this);
        androidx.compose.ui.node.a0.b(this);
        o.a(this);
    }

    @Override // androidx.compose.ui.node.n
    public void A(z1.c cVar) {
        if (o1()) {
            f fVarR1 = R1(cVar);
            l lVarE = fVarR1.e();
            if (lVarE == null) {
                throw new IllegalArgumentException(("no paragraph (layoutCache=" + this.f2928x + ", textSubstitution=" + this.f2930z + ')').toString());
            }
            o1 o1VarE = cVar.Q0().e();
            boolean zB = fVarR1.b();
            if (zB) {
                float fG = t.g(fVarR1.c());
                float f11 = t.f(fVarR1.c());
                o1VarE.d();
                n1.d(o1VarE, 0.0f, 0.0f, fG, f11, 0, 16, null);
            }
            try {
                androidx.compose.ui.text.style.i iVarA = this.f2920p.A();
                if (iVarA == null) {
                    iVarA = androidx.compose.ui.text.style.i.f6110b.b();
                }
                androidx.compose.ui.text.style.i iVar = iVarA;
                b5 b5VarX = this.f2920p.x();
                if (b5VarX == null) {
                    b5VarX = b5.f3990d.a();
                }
                b5 b5Var = b5VarX;
                z1.h hVarI = this.f2920p.i();
                if (hVarI == null) {
                    hVarI = z1.l.f81716a;
                }
                z1.h hVar = hVarI;
                l1 l1VarG = this.f2920p.g();
                if (l1VarG != null) {
                    k.b(lVarE, o1VarE, l1VarG, this.f2920p.d(), b5Var, iVar, hVar, 0, 64, null);
                } else {
                    z1 z1Var = this.f2926v;
                    long jA = z1Var != null ? z1Var.a() : w1.f4564b.e();
                    if (jA == 16) {
                        jA = this.f2920p.h() != 16 ? this.f2920p.h() : w1.f4564b.a();
                    }
                    k.a(lVarE, o1VarE, jA, b5Var, iVar, hVar, 0, 32, null);
                }
            } finally {
                if (zB) {
                    o1VarE.k();
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.x
    public w C(y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        f fVarR1 = R1(yVar);
        boolean zG = fVarR1.g(j11, yVar.getLayoutDirection());
        fVarR1.d();
        l lVarE = fVarR1.e();
        Intrinsics.d(lVarE);
        long jC = fVarR1.c();
        if (zG) {
            androidx.compose.ui.node.a0.a(this);
            Map<androidx.compose.ui.layout.a, Integer> linkedHashMap = this.f2927w;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>(2);
            }
            linkedHashMap.put(AlignmentLineKt.a(), Integer.valueOf(Math.round(lVarE.f())));
            linkedHashMap.put(AlignmentLineKt.b(), Integer.valueOf(Math.round(lVarE.o())));
            this.f2927w = linkedHashMap;
        }
        final k0 k0VarL = tVar.L(q2.b.f74225b.b(t.g(jC), t.g(jC), t.f(jC), t.f(jC)));
        int iG = t.g(jC);
        int iF = t.f(jC);
        Map<androidx.compose.ui.layout.a, Integer> map = this.f2927w;
        Intrinsics.d(map);
        return yVar.y0(iG, iF, map, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$measure$1
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

    public final void O1() {
        this.f2930z = null;
    }

    public final void P1(boolean z11, boolean z12, boolean z13) {
        if (z12 || z13) {
            Q1().m(this.f2919o, this.f2920p, this.f2921q, this.f2922r, this.f2923s, this.f2924t, this.f2925u);
        }
        if (o1()) {
            if (z12 || (z11 && this.f2929y != null)) {
                j1.b(this);
            }
            if (z12 || z13) {
                androidx.compose.ui.node.a0.b(this);
                o.a(this);
            }
            if (z11) {
                o.a(this);
            }
        }
    }

    public final f Q1() {
        if (this.f2928x == null) {
            this.f2928x = new f(this.f2919o, this.f2920p, this.f2921q, this.f2922r, this.f2923s, this.f2924t, this.f2925u, null);
        }
        f fVar = this.f2928x;
        Intrinsics.d(fVar);
        return fVar;
    }

    public final f R1(q2.e eVar) {
        f fVarA;
        a aVar = this.f2930z;
        if (aVar != null && aVar.c() && (fVarA = aVar.a()) != null) {
            fVarA.j(eVar);
            return fVarA;
        }
        f fVarQ1 = Q1();
        fVarQ1.j(eVar);
        return fVarQ1;
    }

    public final boolean T1(String str) {
        Unit unit;
        a aVar = this.f2930z;
        if (aVar == null) {
            a aVar2 = new a(this.f2919o, str, false, null, 12, null);
            f fVar = new f(str, this.f2920p, this.f2921q, this.f2922r, this.f2923s, this.f2924t, this.f2925u, null);
            fVar.j(Q1().a());
            aVar2.d(fVar);
            this.f2930z = aVar2;
            return true;
        }
        if (Intrinsics.b(str, aVar.b())) {
            return false;
        }
        aVar.f(str);
        f fVarA = aVar.a();
        if (fVarA != null) {
            fVarA.m(str, this.f2920p, this.f2921q, this.f2922r, this.f2923s, this.f2924t, this.f2925u);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        return unit != null;
    }

    public final boolean U1(z1 z1Var, e0 e0Var) {
        boolean z11 = !Intrinsics.b(z1Var, this.f2926v);
        this.f2926v = z1Var;
        return z11 || !e0Var.F(this.f2920p);
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean V() {
        return h1.a(this);
    }

    public final boolean V1(e0 e0Var, int i11, int i12, boolean z11, androidx.compose.ui.text.font.i.b bVar, int i13) {
        boolean z12 = !this.f2920p.G(e0Var);
        this.f2920p = e0Var;
        if (this.f2925u != i11) {
            this.f2925u = i11;
            z12 = true;
        }
        if (this.f2924t != i12) {
            this.f2924t = i12;
            z12 = true;
        }
        if (this.f2923s != z11) {
            this.f2923s = z11;
            z12 = true;
        }
        if (!Intrinsics.b(this.f2921q, bVar)) {
            this.f2921q = bVar;
            z12 = true;
        }
        if (p.e(this.f2922r, i13)) {
            return z12;
        }
        this.f2922r = i13;
        return true;
    }

    @Override // androidx.compose.ui.node.i1
    public void W0(q qVar) {
        Function1 function1 = this.f2929y;
        if (function1 == null) {
            function1 = new Function1<List<a0>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(List<a0> list) {
                    f fVarQ1 = this.this$0.Q1();
                    e0 e0Var = this.this$0.f2920p;
                    z1 z1Var = this.this$0.f2926v;
                    a0 a0VarL = fVarQ1.l(e0Var.J((16777214 & 1) != 0 ? w1.f4564b.e() : z1Var != null ? z1Var.a() : w1.f4564b.e(), (16777214 & 2) != 0 ? q2.w.f74257b.a() : 0L, (16777214 & 4) != 0 ? null : null, (16777214 & 8) != 0 ? null : null, (16777214 & 16) != 0 ? null : null, (16777214 & 32) != 0 ? null : null, (16777214 & 64) != 0 ? null : null, (16777214 & 128) != 0 ? q2.w.f74257b.a() : 0L, (16777214 & 256) != 0 ? null : null, (16777214 & 512) != 0 ? null : null, (16777214 & 1024) != 0 ? null : null, (16777214 & 2048) != 0 ? w1.f4564b.e() : 0L, (16777214 & 4096) != 0 ? null : null, (16777214 & 8192) != 0 ? null : null, (16777214 & 16384) != 0 ? null : null, (16777214 & 32768) != 0 ? androidx.compose.ui.text.style.h.f6101b.g() : 0, (16777214 & 65536) != 0 ? androidx.compose.ui.text.style.j.f6115b.f() : 0, (16777214 & 131072) != 0 ? q2.w.f74257b.a() : 0L, (16777214 & 262144) != 0 ? null : null, (16777214 & 524288) != 0 ? null : null, (16777214 & 1048576) != 0 ? androidx.compose.ui.text.style.e.f6066b.b() : 0, (16777214 & 2097152) != 0 ? androidx.compose.ui.text.style.d.f6061b.c() : 0, (16777214 & 4194304) != 0 ? null : null, (16777214 & 8388608) != 0 ? null : null));
                    if (a0VarL != null) {
                        list.add(a0VarL);
                    } else {
                        a0VarL = null;
                    }
                    return Boolean.valueOf(a0VarL != null);
                }
            };
            this.f2929y = function1;
        }
        SemanticsPropertiesKt.E(qVar, new AnnotatedString(this.f2919o, null, null, 6, null));
        a aVar = this.f2930z;
        if (aVar != null) {
            SemanticsPropertiesKt.D(qVar, aVar.c());
            SemanticsPropertiesKt.F(qVar, new AnnotatedString(aVar.b(), null, null, 6, null));
        }
        SemanticsPropertiesKt.H(qVar, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AnnotatedString annotatedString) {
                this.this$0.T1(annotatedString.i());
                this.this$0.S1();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.M(qVar, null, new Function1<Boolean, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$3
            {
                super(1);
            }

            public final Boolean invoke(boolean z11) {
                if (this.this$0.f2930z == null) {
                    return Boolean.FALSE;
                }
                TextStringSimpleNode.a aVar2 = this.this$0.f2930z;
                if (aVar2 != null) {
                    aVar2.e(z11);
                }
                this.this$0.S1();
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, 1, null);
        SemanticsPropertiesKt.d(qVar, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                this.this$0.O1();
                this.this$0.S1();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.j(qVar, null, function1, 1, null);
    }

    public final boolean W1(String str) {
        if (Intrinsics.b(this.f2919o, str)) {
            return false;
        }
        this.f2919o = str;
        O1();
        return true;
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean Z0() {
        return h1.b(this);
    }
}
