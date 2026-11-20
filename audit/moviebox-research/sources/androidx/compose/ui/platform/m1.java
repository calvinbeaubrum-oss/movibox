package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.q4;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5503a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Outline f5504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m4 f5505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f5506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f5507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f5510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y1.k f5511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f5512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f5513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5514l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5515m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Path f5516n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f5517o;

    public m1() {
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.f5504b = outline;
        this.f5513k = y1.g.f81070b.c();
        this.f5514l = y1.m.f81091b.b();
    }

    public final void a(androidx.compose.ui.graphics.o1 o1Var) {
        Path pathD = d();
        if (pathD != null) {
            androidx.compose.ui.graphics.n1.c(o1Var, pathD, 0, 2, null);
            return;
        }
        float f11 = this.f5512j;
        if (f11 <= 0.0f) {
            androidx.compose.ui.graphics.n1.d(o1Var, y1.g.m(this.f5513k), y1.g.n(this.f5513k), y1.g.m(this.f5513k) + y1.m.i(this.f5514l), y1.g.n(this.f5513k) + y1.m.g(this.f5514l), 0, 16, null);
            return;
        }
        Path pathA = this.f5510h;
        y1.k kVar = this.f5511i;
        if (pathA == null || !g(kVar, this.f5513k, this.f5514l, f11)) {
            y1.k kVarC = y1.l.c(y1.g.m(this.f5513k), y1.g.n(this.f5513k), y1.g.m(this.f5513k) + y1.m.i(this.f5514l), y1.g.n(this.f5513k) + y1.m.g(this.f5514l), y1.b.b(this.f5512j, 0.0f, 2, null));
            if (pathA == null) {
                pathA = androidx.compose.ui.graphics.z0.a();
            } else {
                pathA.reset();
            }
            q4.b(pathA, kVarC, null, 2, null);
            this.f5511i = kVarC;
            this.f5510h = pathA;
        }
        androidx.compose.ui.graphics.n1.c(o1Var, pathA, 0, 2, null);
    }

    public final Outline b() {
        i();
        if (this.f5515m && this.f5503a) {
            return this.f5504b;
        }
        return null;
    }

    public final boolean c() {
        return this.f5508f;
    }

    public final Path d() {
        i();
        return this.f5507e;
    }

    public final boolean e() {
        return !this.f5509g;
    }

    public final boolean f(long j11) {
        m4 m4Var;
        if (this.f5515m && (m4Var = this.f5505c) != null) {
            return j2.b(m4Var, y1.g.m(j11), y1.g.n(j11), this.f5516n, this.f5517o);
        }
        return true;
    }

    public final boolean g(y1.k kVar, long j11, long j12, float f11) {
        return kVar != null && y1.l.e(kVar) && kVar.e() == y1.g.m(j11) && kVar.g() == y1.g.n(j11) && kVar.f() == y1.g.m(j11) + y1.m.i(j12) && kVar.a() == y1.g.n(j11) + y1.m.g(j12) && y1.a.d(kVar.h()) == f11;
    }

    public final boolean h(m4 m4Var, float f11, boolean z11, float f12, long j11) {
        this.f5504b.setAlpha(f11);
        boolean z12 = !Intrinsics.b(this.f5505c, m4Var);
        if (z12) {
            this.f5505c = m4Var;
            this.f5508f = true;
        }
        this.f5514l = j11;
        boolean z13 = m4Var != null && (z11 || f12 > 0.0f);
        if (this.f5515m != z13) {
            this.f5515m = z13;
            this.f5508f = true;
        }
        return z12;
    }

    public final void i() {
        if (this.f5508f) {
            this.f5513k = y1.g.f81070b.c();
            this.f5512j = 0.0f;
            this.f5507e = null;
            this.f5508f = false;
            this.f5509g = false;
            m4 m4Var = this.f5505c;
            if (m4Var == null || !this.f5515m || y1.m.i(this.f5514l) <= 0.0f || y1.m.g(this.f5514l) <= 0.0f) {
                this.f5504b.setEmpty();
                return;
            }
            this.f5503a = true;
            if (m4Var instanceof m4.b) {
                k(((m4.b) m4Var).b());
            } else if (m4Var instanceof m4.c) {
                l(((m4.c) m4Var).b());
            } else if (m4Var instanceof m4.a) {
                j(((m4.a) m4Var).b());
            }
        }
    }

    public final void j(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.a()) {
            Outline outline = this.f5504b;
            if (!(path instanceof androidx.compose.ui.graphics.u0)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            outline.setConvexPath(((androidx.compose.ui.graphics.u0) path).o());
            this.f5509g = !this.f5504b.canClip();
        } else {
            this.f5503a = false;
            this.f5504b.setEmpty();
            this.f5509g = true;
        }
        this.f5507e = path;
    }

    public final void k(y1.i iVar) {
        this.f5513k = y1.h.a(iVar.f(), iVar.i());
        this.f5514l = y1.n.a(iVar.k(), iVar.e());
        this.f5504b.setRect(Math.round(iVar.f()), Math.round(iVar.i()), Math.round(iVar.g()), Math.round(iVar.c()));
    }

    public final void l(y1.k kVar) {
        float fD = y1.a.d(kVar.h());
        this.f5513k = y1.h.a(kVar.e(), kVar.g());
        this.f5514l = y1.n.a(kVar.j(), kVar.d());
        if (y1.l.e(kVar)) {
            this.f5504b.setRoundRect(Math.round(kVar.e()), Math.round(kVar.g()), Math.round(kVar.f()), Math.round(kVar.a()), fD);
            this.f5512j = fD;
            return;
        }
        Path pathA = this.f5506d;
        if (pathA == null) {
            pathA = androidx.compose.ui.graphics.z0.a();
            this.f5506d = pathA;
        }
        pathA.reset();
        q4.b(pathA, kVar, null, 2, null);
        j(pathA);
    }
}
