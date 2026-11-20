package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.z0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class GroupComponent extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f4369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<i> f4370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends e> f4373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f4375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super i, Unit> f4376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<i, Unit> f4377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f4378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4379l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4380m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f4381n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f4382o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f4383p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f4384q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f4385r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f4386s;

    public GroupComponent() {
        super(null);
        this.f4370c = new ArrayList();
        this.f4371d = true;
        this.f4372e = w1.f4564b.e();
        this.f4373f = k.d();
        this.f4374g = true;
        this.f4377j = new Function1<i, Unit>() { // from class: androidx.compose.ui.graphics.vector.GroupComponent$wrappedListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(i iVar) {
                invoke2(iVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i iVar) {
                this.this$0.n(iVar);
                Function1<i, Unit> function1B = this.this$0.b();
                if (function1B != null) {
                    function1B.invoke(iVar);
                }
            }
        };
        this.f4378k = "";
        this.f4382o = 1.0f;
        this.f4383p = 1.0f;
        this.f4386s = true;
    }

    @Override // androidx.compose.ui.graphics.vector.i
    public void a(z1.g gVar) {
        if (this.f4386s) {
            y();
            this.f4386s = false;
        }
        if (this.f4374g) {
            x();
            this.f4374g = false;
        }
        z1.d dVarQ0 = gVar.Q0();
        long jI = dVarQ0.i();
        dVarQ0.e().d();
        try {
            z1.j jVarC = dVarQ0.c();
            float[] fArr = this.f4369b;
            if (fArr != null) {
                jVarC.d(k4.a(fArr).r());
            }
            Path path = this.f4375h;
            if (h() && path != null) {
                z1.i.a(jVarC, path, 0, 2, null);
            }
            List<i> list = this.f4370c;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                list.get(i11).a(gVar);
            }
        } finally {
            dVarQ0.e().k();
            dVarQ0.f(jI);
        }
    }

    @Override // androidx.compose.ui.graphics.vector.i
    public Function1<i, Unit> b() {
        return this.f4376i;
    }

    @Override // androidx.compose.ui.graphics.vector.i
    public void d(Function1<? super i, Unit> function1) {
        this.f4376i = function1;
    }

    public final int f() {
        return this.f4370c.size();
    }

    public final long g() {
        return this.f4372e;
    }

    public final boolean h() {
        return !this.f4373f.isEmpty();
    }

    public final void i(int i11, i iVar) {
        if (i11 < f()) {
            this.f4370c.set(i11, iVar);
        } else {
            this.f4370c.add(iVar);
        }
        n(iVar);
        iVar.d(this.f4377j);
        c();
    }

    public final boolean j() {
        return this.f4371d;
    }

    public final void k() {
        this.f4371d = false;
        this.f4372e = w1.f4564b.e();
    }

    public final void l(l1 l1Var) {
        if (this.f4371d && l1Var != null) {
            if (l1Var instanceof d5) {
                m(((d5) l1Var).b());
            } else {
                k();
            }
        }
    }

    public final void m(long j11) {
        if (this.f4371d && j11 != 16) {
            long j12 = this.f4372e;
            if (j12 == 16) {
                this.f4372e = j11;
            } else {
                if (k.e(j12, j11)) {
                    return;
                }
                k();
            }
        }
    }

    public final void n(i iVar) {
        if (iVar instanceof PathComponent) {
            PathComponent pathComponent = (PathComponent) iVar;
            l(pathComponent.e());
            l(pathComponent.g());
        } else if (iVar instanceof GroupComponent) {
            GroupComponent groupComponent = (GroupComponent) iVar;
            if (groupComponent.f4371d && this.f4371d) {
                m(groupComponent.f4372e);
            } else {
                k();
            }
        }
    }

    public final void o(List<? extends e> list) {
        this.f4373f = list;
        this.f4374g = true;
        c();
    }

    public final void p(String str) {
        this.f4378k = str;
        c();
    }

    public final void q(float f11) {
        this.f4380m = f11;
        this.f4386s = true;
        c();
    }

    public final void r(float f11) {
        this.f4381n = f11;
        this.f4386s = true;
        c();
    }

    public final void s(float f11) {
        this.f4379l = f11;
        this.f4386s = true;
        c();
    }

    public final void t(float f11) {
        this.f4382o = f11;
        this.f4386s = true;
        c();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("VGroup: ");
        sb2.append(this.f4378k);
        List<i> list = this.f4370c;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = list.get(i11);
            sb2.append("\t");
            sb2.append(iVar.toString());
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public final void u(float f11) {
        this.f4383p = f11;
        this.f4386s = true;
        c();
    }

    public final void v(float f11) {
        this.f4384q = f11;
        this.f4386s = true;
        c();
    }

    public final void w(float f11) {
        this.f4385r = f11;
        this.f4386s = true;
        c();
    }

    public final void x() {
        if (h()) {
            Path pathA = this.f4375h;
            if (pathA == null) {
                pathA = z0.a();
                this.f4375h = pathA;
            }
            h.c(this.f4373f, pathA);
        }
    }

    public final void y() {
        float[] fArrC = this.f4369b;
        if (fArrC == null) {
            fArrC = k4.c(null, 1, null);
            this.f4369b = fArrC;
        } else {
            k4.h(fArrC);
        }
        k4.q(fArrC, this.f4380m + this.f4384q, this.f4381n + this.f4385r, 0.0f, 4, null);
        k4.k(fArrC, this.f4379l);
        k4.l(fArrC, this.f4382o, this.f4383p, 1.0f);
        k4.q(fArrC, -this.f4380m, -this.f4381n, 0.0f, 4, null);
    }
}
