package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.o0;
import androidx.compose.ui.input.pointer.q0;
import androidx.compose.ui.node.d1;
import androidx.compose.ui.node.e1;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;

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
public abstract class AbstractClickableNode extends androidx.compose.ui.node.i implements e1, e2.e, androidx.compose.ui.focus.d, i1, m1 {
    public static final a I = new a(null);
    public static final int J = 8;
    public androidx.compose.ui.node.f A;
    public o1.k.b B;
    public o1.d C;
    public final Map<e2.a, o1.k.b> D;
    public long E;
    public o1.i F;
    public boolean G;
    public final Object H;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public o1.i f2168q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b0 f2169r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f2170s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public androidx.compose.ui.semantics.i f2171t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2172u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function0<Unit> f2173v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f2174w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final q f2175x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final FocusableNode f2176y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public q0 f2177z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AbstractClickableNode(o1.i iVar, b0 b0Var, boolean z11, String str, androidx.compose.ui.semantics.i iVar2, Function0<Unit> function0) {
        this.f2168q = iVar;
        this.f2169r = b0Var;
        this.f2170s = str;
        this.f2171t = iVar2;
        this.f2172u = z11;
        this.f2173v = function0;
        this.f2175x = new q();
        this.f2176y = new FocusableNode(this.f2168q);
        this.D = new LinkedHashMap();
        this.E = y1.g.f81070b.c();
        this.F = this.f2168q;
        this.G = e2();
        this.H = I;
    }

    public /* synthetic */ AbstractClickableNode(o1.i iVar, b0 b0Var, boolean z11, String str, androidx.compose.ui.semantics.i iVar2, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, b0Var, z11, str, iVar2, function0);
    }

    @Override // e2.e
    public final boolean B0(KeyEvent keyEvent) {
        c2();
        if (this.f2172u && f.f(keyEvent)) {
            if (this.D.containsKey(e2.a.m(e2.d.a(keyEvent)))) {
                return false;
            }
            o1.k.b bVar = new o1.k.b(this.E, null);
            this.D.put(e2.a.m(e2.d.a(keyEvent)), bVar);
            if (this.f2168q != null) {
                kotlinx.coroutines.j.d(h1(), null, null, new AbstractClickableNode$onKeyEvent$1(this, bVar, null), 3, null);
            }
        } else {
            if (!this.f2172u || !f.b(keyEvent)) {
                return false;
            }
            o1.k.b bVarRemove = this.D.remove(e2.a.m(e2.d.a(keyEvent)));
            if (bVarRemove != null && this.f2168q != null) {
                kotlinx.coroutines.j.d(h1(), null, null, new AbstractClickableNode$onKeyEvent$2$1(this, bVarRemove, null), 3, null);
            }
            this.f2173v.invoke();
        }
        return true;
    }

    @Override // androidx.compose.ui.focus.d
    public final void D(androidx.compose.ui.focus.u uVar) {
        if (uVar.isFocused()) {
            c2();
        }
        if (this.f2172u) {
            this.f2176y.D(uVar);
        }
    }

    @Override // androidx.compose.ui.node.e1
    public final void D0() {
        o1.d dVar;
        o1.i iVar = this.f2168q;
        if (iVar != null && (dVar = this.C) != null) {
            iVar.a(new o1.e(dVar));
        }
        this.C = null;
        q0 q0Var = this.f2177z;
        if (q0Var != null) {
            q0Var.D0();
        }
    }

    @Override // androidx.compose.ui.node.m1
    public Object I() {
        return this.H;
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void J0() {
        d1.b(this);
    }

    @Override // androidx.compose.ui.node.e1
    public final void T(androidx.compose.ui.input.pointer.q qVar, PointerEventPass pointerEventPass, long j11) {
        long jB = q2.u.b(j11);
        this.E = y1.h.a(q2.p.h(jB), q2.p.i(jB));
        c2();
        if (this.f2172u && pointerEventPass == PointerEventPass.Main) {
            int iF = qVar.f();
            androidx.compose.ui.input.pointer.s.a aVar = androidx.compose.ui.input.pointer.s.f4737a;
            if (androidx.compose.ui.input.pointer.s.i(iF, aVar.a())) {
                kotlinx.coroutines.j.d(h1(), null, null, new AbstractClickableNode$onPointerEvent$1(this, null), 3, null);
            } else if (androidx.compose.ui.input.pointer.s.i(iF, aVar.b())) {
                kotlinx.coroutines.j.d(h1(), null, null, new AbstractClickableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
        if (this.f2177z == null) {
            this.f2177z = (q0) H1(o0.a(new AbstractClickableNode$onPointerEvent$3(this, null)));
        }
        q0 q0Var = this.f2177z;
        if (q0Var != null) {
            q0Var.T(qVar, pointerEventPass, j11);
        }
    }

    public void T1(androidx.compose.ui.semantics.q qVar) {
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean U0() {
        return d1.d(this);
    }

    public abstract Object U1(androidx.compose.ui.input.pointer.h0 h0Var, Continuation<? super Unit> continuation);

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean V() {
        return h1.a(this);
    }

    public final boolean V1() {
        return ClickableKt.e(this) || f.c(this);
    }

    @Override // androidx.compose.ui.node.i1
    public final void W0(androidx.compose.ui.semantics.q qVar) {
        androidx.compose.ui.semantics.i iVar = this.f2171t;
        if (iVar != null) {
            Intrinsics.d(iVar);
            SemanticsPropertiesKt.B(qVar, iVar.n());
        }
        SemanticsPropertiesKt.l(qVar, this.f2170s, new Function0<Boolean>() { // from class: androidx.compose.foundation.AbstractClickableNode$applySemantics$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                this.this$0.a2().invoke();
                return Boolean.TRUE;
            }
        });
        if (this.f2172u) {
            this.f2176y.W0(qVar);
        } else {
            SemanticsPropertiesKt.f(qVar);
        }
        T1(qVar);
    }

    public final void W1() {
        o1.i iVar = this.f2168q;
        if (iVar != null) {
            o1.k.b bVar = this.B;
            if (bVar != null) {
                iVar.a(new o1.k.a(bVar));
            }
            o1.d dVar = this.C;
            if (dVar != null) {
                iVar.a(new o1.e(dVar));
            }
            Iterator<T> it = this.D.values().iterator();
            while (it.hasNext()) {
                iVar.a(new o1.k.a((o1.k.b) it.next()));
            }
        }
        this.B = null;
        this.C = null;
        this.D.clear();
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ void X0() {
        d1.c(this);
    }

    public final void X1() {
        if (this.C == null) {
            o1.d dVar = new o1.d();
            o1.i iVar = this.f2168q;
            if (iVar != null) {
                kotlinx.coroutines.j.d(h1(), null, null, new AbstractClickableNode$emitHoverEnter$1$1(iVar, dVar, null), 3, null);
            }
            this.C = dVar;
        }
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean Y() {
        return d1.a(this);
    }

    public final void Y1() {
        o1.d dVar = this.C;
        if (dVar != null) {
            o1.e eVar = new o1.e(dVar);
            o1.i iVar = this.f2168q;
            if (iVar != null) {
                kotlinx.coroutines.j.d(h1(), null, null, new AbstractClickableNode$emitHoverExit$1$1$1(iVar, eVar, null), 3, null);
            }
            this.C = null;
        }
    }

    @Override // androidx.compose.ui.node.i1
    public final boolean Z0() {
        return true;
    }

    public final boolean Z1() {
        return this.f2172u;
    }

    public final Function0<Unit> a2() {
        return this.f2173v;
    }

    public final Object b2(androidx.compose.foundation.gestures.i iVar, long j11, Continuation<? super Unit> continuation) {
        Object objE;
        o1.i iVar2 = this.f2168q;
        return (iVar2 == null || (objE = l0.e(new AbstractClickableNode$handlePressInteraction$2$1(iVar, j11, iVar2, this, null), continuation)) != kotlin.coroutines.intrinsics.a.e()) ? Unit.f68710a : objE;
    }

    public final void c2() {
        b0 b0Var;
        if (this.A == null && (b0Var = this.f2169r) != null) {
            if (this.f2168q == null) {
                this.f2168q = o1.h.a();
            }
            this.f2176y.N1(this.f2168q);
            o1.i iVar = this.f2168q;
            Intrinsics.d(iVar);
            androidx.compose.ui.node.f fVarA = b0Var.a(iVar);
            H1(fVarA);
            this.A = fVarA;
        }
    }

    public final Unit d2() {
        q0 q0Var = this.f2177z;
        if (q0Var == null) {
            return null;
        }
        q0Var.r0();
        return Unit.f68710a;
    }

    public final boolean e2() {
        return this.F == null && this.f2169r != null;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0073 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0075  */
    /* JADX WARN: Code duplicated, block: B:32:0x0079  */
    /* JADX WARN: Code duplicated, block: B:34:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x007f  */
    public final void f2(o1.i iVar, b0 b0Var, boolean z11, String str, androidx.compose.ui.semantics.i iVar2, Function0<Unit> function0) {
        boolean z12;
        androidx.compose.ui.node.f fVar;
        boolean z13 = true;
        if (Intrinsics.b(this.F, iVar)) {
            z12 = false;
        } else {
            W1();
            this.F = iVar;
            this.f2168q = iVar;
            z12 = true;
        }
        if (Intrinsics.b(this.f2169r, b0Var)) {
            z13 = z12;
        } else {
            this.f2169r = b0Var;
        }
        if (this.f2172u != z11) {
            if (z11) {
                H1(this.f2175x);
                H1(this.f2176y);
            } else {
                K1(this.f2175x);
                K1(this.f2176y);
                W1();
            }
            j1.b(this);
            this.f2172u = z11;
        }
        if (!Intrinsics.b(this.f2170s, str)) {
            this.f2170s = str;
            j1.b(this);
        }
        if (!Intrinsics.b(this.f2171t, iVar2)) {
            this.f2171t = iVar2;
            j1.b(this);
        }
        this.f2173v = function0;
        if (this.G != e2()) {
            boolean zE2 = e2();
            this.G = zE2;
            if (!zE2 && this.A == null) {
                fVar = this.A;
                if (fVar == null) {
                    if (fVar != null) {
                        K1(fVar);
                    }
                    this.A = null;
                    c2();
                } else {
                    if (fVar != null) {
                        K1(fVar);
                    }
                    this.A = null;
                    c2();
                }
            } else if (z13) {
                fVar = this.A;
                if (fVar == null || !this.G) {
                    if (fVar != null) {
                        K1(fVar);
                    }
                    this.A = null;
                    c2();
                }
            }
        } else if (z13) {
            fVar = this.A;
            if (fVar == null) {
                if (fVar != null) {
                    K1(fVar);
                }
                this.A = null;
                c2();
            } else {
                if (fVar != null) {
                    K1(fVar);
                }
                this.A = null;
                c2();
            }
        }
        this.f2176y.N1(this.f2168q);
    }

    @Override // androidx.compose.ui.f.c
    public final boolean m1() {
        return this.f2174w;
    }

    @Override // androidx.compose.ui.f.c
    public final void r1() {
        if (!this.G) {
            c2();
        }
        if (this.f2172u) {
            H1(this.f2175x);
            H1(this.f2176y);
        }
    }

    @Override // androidx.compose.ui.f.c
    public final void s1() {
        W1();
        if (this.F == null) {
            this.f2168q = null;
        }
        androidx.compose.ui.node.f fVar = this.A;
        if (fVar != null) {
            K1(fVar);
        }
        this.A = null;
    }

    @Override // e2.e
    public final boolean t0(KeyEvent keyEvent) {
        return false;
    }
}
