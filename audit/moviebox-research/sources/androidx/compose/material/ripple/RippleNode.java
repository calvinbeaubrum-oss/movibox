package androidx.compose.material.ripple;

import androidx.collection.j0;
import androidx.compose.ui.graphics.z1;
import androidx.compose.ui.node.n;
import androidx.compose.ui.node.o;
import androidx.compose.ui.node.v;
import androidx.compose.ui.node.w;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import q2.u;
import y1.m;

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
@SourceDebugExtension
public abstract class RippleNode extends androidx.compose.ui.f.c implements androidx.compose.ui.node.d, n, w {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final o1.g f3148o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f3149p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f3150q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final z1 f3151r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function0<c> f3152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f3153t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public StateLayer f3154u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f3155v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f3156w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3157x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j0<o1.k> f3158y;

    public RippleNode(o1.g gVar, boolean z11, float f11, z1 z1Var, Function0<c> function0) {
        this.f3148o = gVar;
        this.f3149p = z11;
        this.f3150q = f11;
        this.f3151r = z1Var;
        this.f3152s = function0;
        this.f3156w = m.f81091b.b();
        this.f3158y = new j0<>(0, 1, null);
    }

    public /* synthetic */ RippleNode(o1.g gVar, boolean z11, float f11, z1 z1Var, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, z11, f11, z1Var, function0);
    }

    @Override // androidx.compose.ui.node.n
    public void A(z1.c cVar) {
        cVar.a1();
        StateLayer stateLayer = this.f3154u;
        if (stateLayer != null) {
            stateLayer.b(cVar, this.f3155v, Q1());
        }
        N1(cVar);
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void F0() {
        androidx.compose.ui.node.m.a(this);
    }

    public abstract void M1(o1.k.b bVar, long j11, float f11);

    public abstract void N1(z1.g gVar);

    public final boolean O1() {
        return this.f3149p;
    }

    public final Function0<c> P1() {
        return this.f3152s;
    }

    public final long Q1() {
        return this.f3151r.a();
    }

    public final long R1() {
        return this.f3156w;
    }

    public final void S1(o1.k kVar) {
        if (kVar instanceof o1.k.b) {
            M1((o1.k.b) kVar, this.f3156w, this.f3155v);
        } else if (kVar instanceof o1.k.c) {
            T1(((o1.k.c) kVar).a());
        } else if (kVar instanceof o1.k.a) {
            T1(((o1.k.a) kVar).a());
        }
    }

    public abstract void T1(o1.k.b bVar);

    public final void U1(o1.f fVar, k0 k0Var) {
        StateLayer stateLayer = this.f3154u;
        if (stateLayer == null) {
            stateLayer = new StateLayer(this.f3149p, this.f3152s);
            o.a(this);
            this.f3154u = stateLayer;
        }
        stateLayer.c(fVar, k0Var);
    }

    @Override // androidx.compose.ui.node.w
    public void l(long j11) {
        this.f3157x = true;
        q2.e eVarI = androidx.compose.ui.node.g.i(this);
        this.f3156w = u.d(j11);
        this.f3155v = Float.isNaN(this.f3150q) ? d.a(eVarI, this.f3149p, this.f3156w) : eVarI.N0(this.f3150q);
        j0<o1.k> j0Var = this.f3158y;
        Object[] objArr = j0Var.f1895a;
        int i11 = j0Var.f1896b;
        for (int i12 = 0; i12 < i11; i12++) {
            S1((o1.k) objArr[i12]);
        }
        this.f3158y.f();
    }

    @Override // androidx.compose.ui.node.w
    public /* synthetic */ void m(androidx.compose.ui.layout.m mVar) {
        v.a(this, mVar);
    }

    @Override // androidx.compose.ui.f.c
    public final boolean m1() {
        return this.f3153t;
    }

    @Override // androidx.compose.ui.f.c
    public void r1() {
        kotlinx.coroutines.j.d(h1(), null, null, new RippleNode$onAttach$1(this, null), 3, null);
    }
}
