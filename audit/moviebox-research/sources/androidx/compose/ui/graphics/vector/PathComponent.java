package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.t4;
import androidx.compose.ui.graphics.y0;
import androidx.compose.ui.graphics.z0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class PathComponent extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l1 f4388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f4389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends e> f4390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f4392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f4393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l1 f4394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4395j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4396k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4397l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4398m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f4399n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f4400o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4401p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4402q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4403r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public z1.m f4404s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Path f4405t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Path f4406u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f4407v;

    public PathComponent() {
        super(null);
        this.f4387b = "";
        this.f4389d = 1.0f;
        this.f4390e = k.d();
        this.f4391f = k.a();
        this.f4392g = 1.0f;
        this.f4395j = k.b();
        this.f4396k = k.c();
        this.f4397l = 4.0f;
        this.f4399n = 1.0f;
        this.f4401p = true;
        this.f4402q = true;
        Path pathA = z0.a();
        this.f4405t = pathA;
        this.f4406u = pathA;
        this.f4407v = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<t4>() { // from class: androidx.compose.ui.graphics.vector.PathComponent$pathMeasure$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final t4 invoke() {
                return y0.a();
            }
        });
    }

    @Override // androidx.compose.ui.graphics.vector.i
    public void a(z1.g gVar) {
        if (this.f4401p) {
            v();
        } else if (this.f4403r) {
            w();
        }
        this.f4401p = false;
        this.f4403r = false;
        l1 l1Var = this.f4388c;
        if (l1Var != null) {
            z1.f.g(gVar, this.f4406u, l1Var, this.f4389d, null, null, 0, 56, null);
        }
        l1 l1Var2 = this.f4394i;
        if (l1Var2 != null) {
            z1.m mVar = this.f4404s;
            if (this.f4402q || mVar == null) {
                mVar = new z1.m(this.f4393h, this.f4397l, this.f4395j, this.f4396k, null, 16, null);
                this.f4404s = mVar;
                this.f4402q = false;
            }
            z1.f.g(gVar, this.f4406u, l1Var2, this.f4392g, mVar, null, 0, 48, null);
        }
    }

    public final l1 e() {
        return this.f4388c;
    }

    public final t4 f() {
        return (t4) this.f4407v.getValue();
    }

    public final l1 g() {
        return this.f4394i;
    }

    public final void h(l1 l1Var) {
        this.f4388c = l1Var;
        c();
    }

    public final void i(float f11) {
        this.f4389d = f11;
        c();
    }

    public final void j(String str) {
        this.f4387b = str;
        c();
    }

    public final void k(List<? extends e> list) {
        this.f4390e = list;
        this.f4401p = true;
        c();
    }

    public final void l(int i11) {
        this.f4391f = i11;
        this.f4406u.d(i11);
        c();
    }

    public final void m(l1 l1Var) {
        this.f4394i = l1Var;
        c();
    }

    public final void n(float f11) {
        this.f4392g = f11;
        c();
    }

    public final void o(int i11) {
        this.f4395j = i11;
        this.f4402q = true;
        c();
    }

    public final void p(int i11) {
        this.f4396k = i11;
        this.f4402q = true;
        c();
    }

    public final void q(float f11) {
        this.f4397l = f11;
        this.f4402q = true;
        c();
    }

    public final void r(float f11) {
        this.f4393h = f11;
        this.f4402q = true;
        c();
    }

    public final void s(float f11) {
        this.f4399n = f11;
        this.f4403r = true;
        c();
    }

    public final void t(float f11) {
        this.f4400o = f11;
        this.f4403r = true;
        c();
    }

    public String toString() {
        return this.f4405t.toString();
    }

    public final void u(float f11) {
        this.f4398m = f11;
        this.f4403r = true;
        c();
    }

    public final void v() {
        h.c(this.f4390e, this.f4405t);
        w();
    }

    public final void w() {
        if (this.f4398m == 0.0f && this.f4399n == 1.0f) {
            this.f4406u = this.f4405t;
            return;
        }
        if (Intrinsics.b(this.f4406u, this.f4405t)) {
            this.f4406u = z0.a();
        } else {
            int i11 = this.f4406u.i();
            this.f4406u.rewind();
            this.f4406u.d(i11);
        }
        f().b(this.f4405t, false);
        float length = f().getLength();
        float f11 = this.f4398m;
        float f12 = this.f4400o;
        float f13 = ((f11 + f12) % 1.0f) * length;
        float f14 = ((this.f4399n + f12) % 1.0f) * length;
        if (f13 <= f14) {
            f().a(f13, f14, this.f4406u, true);
        } else {
            f().a(f13, length, this.f4406u, true);
            f().a(0.0f, f14, this.f4406u, true);
        }
    }
}
