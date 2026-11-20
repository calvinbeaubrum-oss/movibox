package androidx.compose.foundation;

import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.n4;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x4;
import androidx.compose.ui.node.u0;
import androidx.compose.ui.node.v0;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.ws.WebSocketProtocol;

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
public final class BackgroundNode extends androidx.compose.ui.f.c implements androidx.compose.ui.node.n, u0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f2191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l1 f2192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f2193q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c5 f2194r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f2195s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LayoutDirection f2196t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public m4 f2197u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c5 f2198v;

    public BackgroundNode(long j11, l1 l1Var, float f11, c5 c5Var) {
        this.f2191o = j11;
        this.f2192p = l1Var;
        this.f2193q = f11;
        this.f2194r = c5Var;
        this.f2195s = y1.m.f81091b.a();
    }

    public /* synthetic */ BackgroundNode(long j11, l1 l1Var, float f11, c5 c5Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, l1Var, f11, c5Var);
    }

    @Override // androidx.compose.ui.node.n
    public void A(z1.c cVar) {
        if (this.f2194r == x4.a()) {
            I1(cVar);
        } else {
            H1(cVar);
        }
        cVar.a1();
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void F0() {
        androidx.compose.ui.node.m.a(this);
    }

    public final void H1(z1.c cVar) {
        m4 m4VarJ1 = J1(cVar);
        if (!w1.m(this.f2191o, w1.f4564b.e())) {
            n4.c(cVar, m4VarJ1, this.f2191o, (60 & 4) != 0 ? 1.0f : 0.0f, (60 & 8) != 0 ? z1.l.f81716a : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? z1.g.f81712v8.a() : 0);
        }
        l1 l1Var = this.f2192p;
        if (l1Var != null) {
            n4.b(cVar, m4VarJ1, l1Var, this.f2193q, null, null, 0, 56, null);
        }
    }

    public final void I1(z1.c cVar) {
        if (!w1.m(this.f2191o, w1.f4564b.e())) {
            z1.f.j(cVar, this.f2191o, 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        }
        l1 l1Var = this.f2192p;
        if (l1Var != null) {
            z1.f.i(cVar, l1Var, 0L, 0L, this.f2193q, null, null, 0, 118, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, androidx.compose.ui.graphics.m4, java.lang.Object] */
    public final m4 J1(final z1.c cVar) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (y1.m.f(cVar.i(), this.f2195s) && cVar.getLayoutDirection() == this.f2196t && Intrinsics.b(this.f2198v, this.f2194r)) {
            ?? r11 = this.f2197u;
            Intrinsics.d(r11);
            objectRef.element = r11;
        } else {
            v0.a(this, new Function0<Unit>() { // from class: androidx.compose.foundation.BackgroundNode$getOutline$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.compose.ui.graphics.m4] */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    objectRef.element = this.K1().a(cVar.i(), cVar.getLayoutDirection(), cVar);
                }
            });
        }
        this.f2197u = (m4) objectRef.element;
        this.f2195s = cVar.i();
        this.f2196t = cVar.getLayoutDirection();
        this.f2198v = this.f2194r;
        T t11 = objectRef.element;
        Intrinsics.d(t11);
        return (m4) t11;
    }

    public final void K0(c5 c5Var) {
        this.f2194r = c5Var;
    }

    public final c5 K1() {
        return this.f2194r;
    }

    public final void L1(l1 l1Var) {
        this.f2192p = l1Var;
    }

    public final void M1(long j11) {
        this.f2191o = j11;
    }

    @Override // androidx.compose.ui.node.u0
    public void g0() {
        this.f2195s = y1.m.f81091b.a();
        this.f2196t = null;
        this.f2197u = null;
        this.f2198v = null;
        androidx.compose.ui.node.o.a(this);
    }

    public final void setAlpha(float f11) {
        this.f2193q = f11;
    }
}
