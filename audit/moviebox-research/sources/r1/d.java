package r1;

import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.a2;
import androidx.compose.runtime.b2;
import androidx.compose.runtime.c2;
import androidx.compose.runtime.j2;
import androidx.compose.runtime.k1;
import androidx.compose.runtime.m2;
import androidx.compose.runtime.w1;
import androidx.compose.runtime.x0;
import androidx.compose.runtime.y0;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f75038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f75039b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f75040c = new a();

        public a() {
            super(1, 0, 2, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            m2Var.D(eVar.b(q.a(0)));
        }

        @Override // r1.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "distance" : super.e(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a0 extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a0 f75041c = new a0();

        /* JADX WARN: Illegal instructions before constructor call */
        public a0() {
            int i11 = 1;
            super(0, i11, i11, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            a2Var.a((Function0) eVar.a(t.a(0)));
        }

        @Override // r1.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "effect" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f75042c = new b();

        public b() {
            super(0, 2, 1, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(0));
            Object objA = eVar.a(t.a(1));
            if (objA instanceof c2) {
                a2Var.c(((c2) objA).b());
            }
            m2Var.G(cVar, objA);
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return "anchor";
            }
            return t.b(i11, t.a(1)) ? AppMeasurementSdk.ConditionalUserProperty.VALUE : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b0 extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b0 f75043c = new b0();

        /* JADX WARN: Illegal instructions before constructor call */
        public b0() {
            int i11 = 0;
            super(i11, i11, 3, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            m2Var.Z0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class c extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f75044c = new c();

        public c() {
            super(0, 2, 1, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.internal.d dVar = (androidx.compose.runtime.internal.d) eVar.a(t.a(1));
            int iA = dVar != null ? dVar.a() : 0;
            r1.a aVar = (r1.a) eVar.a(t.a(0));
            if (iA > 0) {
                fVar = new k1(fVar, iA);
            }
            aVar.b(fVar, m2Var, a2Var);
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return "changes";
            }
            return t.b(i11, t.a(1)) ? "effectiveNodeIndex" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class c0 extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c0 f75045c = new c0();

        public c0() {
            super(1, 0, 2, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            int iB = eVar.b(q.a(0));
            int iG0 = m2Var.g0();
            int iE0 = m2Var.e0();
            int iG1 = m2Var.g1(iE0);
            int iF1 = m2Var.f1(iE0);
            for (int iMax = Math.max(iG1, iF1 - iB); iMax < iF1; iMax++) {
                Object obj = m2Var.f3490c[m2Var.R(iMax)];
                if (obj instanceof c2) {
                    a2Var.e(((c2) obj).b(), iG0 - iMax, -1, -1);
                } else if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).x();
                }
            }
            m2Var.n1(iB);
        }

        @Override // r1.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "count" : super.e(i11);
        }
    }

    /* JADX INFO: renamed from: r1.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class C0823d extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0823d f75046c = new C0823d();

        public C0823d() {
            super(0, 2, 1, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            int iA = ((androidx.compose.runtime.internal.d) eVar.a(t.a(0))).a();
            List list = (List) eVar.a(t.a(1));
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Object obj = list.get(i11);
                Intrinsics.e(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
                int i12 = iA + i11;
                fVar.f(i12, obj);
                fVar.d(i12, obj);
            }
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return "effectiveNodeIndex";
            }
            return t.b(i11, t.a(1)) ? "nodes" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class d0 extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d0 f75047c = new d0();

        public d0() {
            super(1, 2, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            int iF;
            int iG0;
            Object objA = eVar.a(t.a(0));
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(1));
            int iB = eVar.b(q.a(0));
            if (objA instanceof c2) {
                a2Var.c(((c2) objA).b());
            }
            int iF2 = m2Var.F(cVar);
            Object objU0 = m2Var.U0(iF2, iB, objA);
            if (!(objU0 instanceof c2)) {
                if (objU0 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) objU0).x();
                    return;
                }
                return;
            }
            int iG1 = m2Var.g0() - m2Var.d1(iF2, iB);
            c2 c2Var = (c2) objU0;
            androidx.compose.runtime.c cVarA = c2Var.a();
            if (cVarA == null || !cVarA.b()) {
                iF = -1;
                iG0 = -1;
            } else {
                iF = m2Var.F(cVarA);
                iG0 = m2Var.g0() - m2Var.e1(iF);
            }
            a2Var.e(c2Var.b(), iG1, iF, iG0);
        }

        @Override // r1.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "groupSlotIndex" : super.e(i11);
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return AppMeasurementSdk.ConditionalUserProperty.VALUE;
            }
            return t.b(i11, t.a(1)) ? "anchor" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class e extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f75048c = new e();

        public e() {
            super(0, 4, 1, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            y0 y0Var = (y0) eVar.a(t.a(2));
            y0 y0Var2 = (y0) eVar.a(t.a(3));
            androidx.compose.runtime.m mVar = (androidx.compose.runtime.m) eVar.a(t.a(1));
            x0 x0VarN = (x0) eVar.a(t.a(0));
            if (x0VarN == null && (x0VarN = mVar.n(y0Var)) == null) {
                androidx.compose.runtime.k.t("Could not resolve state for movable content");
                throw new KotlinNothingValueException();
            }
            List<androidx.compose.runtime.c> listA0 = m2Var.A0(1, x0VarN.a(), 2);
            RecomposeScopeImpl.a aVar = RecomposeScopeImpl.f3302h;
            androidx.compose.runtime.y yVarB = y0Var2.b();
            Intrinsics.e(yVarB, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeOwner");
            aVar.a(m2Var, listA0, (w1) yVarB);
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return "resolvedState";
            }
            if (t.b(i11, t.a(1))) {
                return "resolvedCompositionContext";
            }
            if (t.b(i11, t.a(2))) {
                return "from";
            }
            return t.b(i11, t.a(3)) ? "to" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class e0 extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e0 f75049c = new e0();

        /* JADX WARN: Illegal instructions before constructor call */
        public e0() {
            int i11 = 1;
            super(0, i11, i11, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            m2Var.r1(eVar.a(t.a(0)));
        }

        @Override // r1.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "data" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f75050c = new f();

        /* JADX WARN: Illegal instructions before constructor call */
        public f() {
            int i11 = 0;
            super(i11, i11, 3, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.k.u(m2Var, a2Var);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class f0 extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f0 f75051c = new f0();

        public f0() {
            super(0, 2, 1, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            ((Function2) eVar.a(t.a(1))).invoke(fVar.a(), eVar.a(t.a(0)));
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return AppMeasurementSdk.ConditionalUserProperty.VALUE;
            }
            return t.b(i11, t.a(1)) ? "block" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class g extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f75052c = new g();

        public g() {
            super(0, 2, 1, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.internal.d dVar = (androidx.compose.runtime.internal.d) eVar.a(t.a(0));
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(1));
            Intrinsics.e(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            dVar.b(r1.f.e(m2Var, cVar, fVar));
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return "effectiveNodeIndexOut";
            }
            return t.b(i11, t.a(1)) ? "anchor" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class g0 extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g0 f75053c = new g0();

        /* JADX WARN: Illegal instructions before constructor call */
        public g0() {
            int i11 = 1;
            super(i11, i11, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            Object objA = eVar.a(t.a(0));
            int iB = eVar.b(q.a(0));
            if (objA instanceof c2) {
                a2Var.c(((c2) objA).b());
            }
            Object objV0 = m2Var.V0(iB, objA);
            if (objV0 instanceof c2) {
                a2Var.e(((c2) objV0).b(), m2Var.g0() - m2Var.d1(m2Var.c0(), iB), -1, -1);
            } else if (objV0 instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) objV0).x();
            }
        }

        @Override // r1.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "groupSlotIndex" : super.e(i11);
        }

        @Override // r1.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? AppMeasurementSdk.ConditionalUserProperty.VALUE : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class h extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f75054c = new h();

        /* JADX WARN: Illegal instructions before constructor call */
        public h() {
            int i11 = 1;
            super(0, i11, i11, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            Intrinsics.e(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            for (Object obj : (Object[]) eVar.a(t.a(0))) {
                fVar.g(obj);
            }
        }

        @Override // r1.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "nodes" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class h0 extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h0 f75055c = new h0();

        public h0() {
            super(1, 0, 2, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            int iB = eVar.b(q.a(0));
            for (int i11 = 0; i11 < iB; i11++) {
                fVar.i();
            }
        }

        @Override // r1.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "count" : super.e(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class i extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f75056c = new i();

        public i() {
            super(0, 2, 1, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            ((Function1) eVar.a(t.a(0))).invoke((androidx.compose.runtime.l) eVar.a(t.a(1)));
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return "anchor";
            }
            return t.b(i11, t.a(1)) ? "composition" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class i0 extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i0 f75057c = new i0();

        /* JADX WARN: Illegal instructions before constructor call */
        public i0() {
            int i11 = 0;
            super(i11, i11, 3, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            Object objA = fVar.a();
            Intrinsics.e(objA, "null cannot be cast to non-null type androidx.compose.runtime.ComposeNodeLifecycleCallback");
            ((androidx.compose.runtime.h) objA).onReuse();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class j extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final j f75058c = new j();

        /* JADX WARN: Illegal instructions before constructor call */
        public j() {
            int i11 = 0;
            super(i11, i11, 3, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            m2Var.T();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class k extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final k f75059c = new k();

        /* JADX WARN: Illegal instructions before constructor call */
        public k() {
            int i11 = 0;
            super(i11, i11, 3, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            Intrinsics.e(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            r1.f.f(m2Var, fVar, 0);
            m2Var.T();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class l extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final l f75060c = new l();

        /* JADX WARN: Illegal instructions before constructor call */
        public l() {
            int i11 = 1;
            super(0, i11, i11, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            m2Var.W((androidx.compose.runtime.c) eVar.a(t.a(0)));
        }

        @Override // r1.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "anchor" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class m extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final m f75061c = new m();

        /* JADX WARN: Illegal instructions before constructor call */
        public m() {
            int i11 = 0;
            super(i11, i11, 3, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            m2Var.V(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class n extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final n f75062c = new n();

        public n() {
            super(1, 2, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            Object objInvoke = ((Function0) eVar.a(t.a(0))).invoke();
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(1));
            int iB = eVar.b(q.a(0));
            Intrinsics.e(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            m2Var.v1(cVar, objInvoke);
            fVar.d(iB, objInvoke);
            fVar.g(objInvoke);
        }

        @Override // r1.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "insertIndex" : super.e(i11);
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return "factory";
            }
            return t.b(i11, t.a(1)) ? "groupAnchor" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class o extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final o f75063c = new o();

        public o() {
            super(0, 2, 1, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            j2 j2Var = (j2) eVar.a(t.a(1));
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(0));
            m2Var.I();
            m2Var.x0(j2Var, cVar.d(j2Var), false);
            m2Var.U();
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return "anchor";
            }
            return t.b(i11, t.a(1)) ? "from" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class p extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final p f75064c = new p();

        public p() {
            super(0, 3, 1, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            j2 j2Var = (j2) eVar.a(t.a(1));
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(0));
            r1.c cVar2 = (r1.c) eVar.a(t.a(2));
            m2 m2VarE = j2Var.E();
            try {
                cVar2.d(fVar, m2VarE, a2Var);
                Unit unit = Unit.f68710a;
                m2VarE.L(true);
                m2Var.I();
                m2Var.x0(j2Var, cVar.d(j2Var), false);
                m2Var.U();
            } catch (Throwable th2) {
                m2VarE.L(false);
                throw th2;
            }
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return "anchor";
            }
            if (t.b(i11, t.a(1))) {
                return "from";
            }
            return t.b(i11, t.a(2)) ? "fixups" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    public static final class q {
        public static int a(int i11) {
            return i11;
        }

        public static final boolean b(int i11, int i12) {
            return i11 == i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class r extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final r f75065c = new r();

        public r() {
            super(1, 0, 2, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            m2Var.y0(eVar.b(q.a(0)));
        }

        @Override // r1.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "offset" : super.e(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class s extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final s f75066c = new s();

        public s() {
            super(3, 0, 2, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            fVar.c(eVar.b(q.a(0)), eVar.b(q.a(1)), eVar.b(q.a(2)));
        }

        @Override // r1.d
        public String e(int i11) {
            if (q.b(i11, q.a(0))) {
                return "from";
            }
            if (q.b(i11, q.a(1))) {
                return "to";
            }
            return q.b(i11, q.a(2)) ? "count" : super.e(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @JvmInline
    public static final class t<T> {
        public static <T> int a(int i11) {
            return i11;
        }

        public static final boolean b(int i11, int i12) {
            return i11 == i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class u extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final u f75067c = new u();

        /* JADX WARN: Illegal instructions before constructor call */
        public u() {
            int i11 = 1;
            super(i11, i11, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(0));
            int iB = eVar.b(q.a(0));
            fVar.i();
            Intrinsics.e(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            fVar.f(iB, m2Var.E0(cVar));
        }

        @Override // r1.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "insertIndex" : super.e(i11);
        }

        @Override // r1.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "groupAnchor" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class v extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final v f75068c = new v();

        public v() {
            super(0, 3, 1, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            r1.f.g((androidx.compose.runtime.y) eVar.a(t.a(0)), (androidx.compose.runtime.m) eVar.a(t.a(1)), (y0) eVar.a(t.a(2)), m2Var);
        }

        @Override // r1.d
        public String f(int i11) {
            if (t.b(i11, t.a(0))) {
                return "composition";
            }
            if (t.b(i11, t.a(1))) {
                return "parentCompositionContext";
            }
            return t.b(i11, t.a(2)) ? "reference" : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class w extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w f75069c = new w();

        /* JADX WARN: Illegal instructions before constructor call */
        public w() {
            int i11 = 1;
            super(0, i11, i11, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            a2Var.c((b2) eVar.a(t.a(0)));
        }

        @Override // r1.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? AppMeasurementSdk.ConditionalUserProperty.VALUE : super.f(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class x extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final x f75070c = new x();

        /* JADX WARN: Illegal instructions before constructor call */
        public x() {
            int i11 = 0;
            super(i11, i11, 3, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.k.M(m2Var, a2Var);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class y extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final y f75071c = new y();

        /* JADX WARN: Illegal instructions before constructor call */
        public y() {
            int i11 = 2;
            super(i11, 0, i11, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            fVar.b(eVar.b(q.a(0)), eVar.b(q.a(1)));
        }

        @Override // r1.d
        public String e(int i11) {
            if (q.b(i11, q.a(0))) {
                return "removeIndex";
            }
            return q.b(i11, q.a(1)) ? "count" : super.e(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class z extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final z f75072c = new z();

        /* JADX WARN: Illegal instructions before constructor call */
        public z() {
            int i11 = 0;
            super(i11, i11, 3, null);
        }

        @Override // r1.d
        public void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
            m2Var.R0();
        }
    }

    public d(int i11, int i12) {
        this.f75038a = i11;
        this.f75039b = i12;
    }

    public /* synthetic */ d(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12, null);
    }

    public /* synthetic */ d(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12);
    }

    public abstract void a(r1.e eVar, androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var);

    public final int b() {
        return this.f75038a;
    }

    public final String c() {
        String strE = Reflection.b(getClass()).e();
        return strE == null ? "" : strE;
    }

    public final int d() {
        return this.f75039b;
    }

    public String e(int i11) {
        return "IntParameter(" + i11 + ')';
    }

    public String f(int i11) {
        return "ObjectParameter(" + i11 + ')';
    }

    public String toString() {
        return c();
    }
}
