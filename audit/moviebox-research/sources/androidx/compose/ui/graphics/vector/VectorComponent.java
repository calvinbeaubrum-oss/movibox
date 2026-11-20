package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.h4;
import androidx.compose.ui.graphics.x1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.u;

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
public final class VectorComponent extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GroupComponent f4408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f4411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f4412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i1 f4413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x1 f4414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i1 f4415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f4417k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f4418l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<z1.g, Unit> f4419m;

    public VectorComponent(GroupComponent groupComponent) {
        super(null);
        this.f4408b = groupComponent;
        groupComponent.d(new Function1<i, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent.1
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
                VectorComponent.this.h();
            }
        });
        this.f4409c = "";
        this.f4410d = true;
        this.f4411e = new a();
        this.f4412f = new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$invalidateCallback$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        this.f4413g = u2.c(null, null, 2, null);
        y1.m.a aVar = y1.m.f81091b;
        this.f4415i = u2.c(y1.m.c(aVar.b()), null, 2, null);
        this.f4416j = aVar.a();
        this.f4417k = 1.0f;
        this.f4418l = 1.0f;
        this.f4419m = new Function1<z1.g, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$drawVectorBlock$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(z1.g gVar) {
                invoke2(gVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(z1.g gVar) {
                GroupComponent groupComponentL = this.this$0.l();
                VectorComponent vectorComponent = this.this$0;
                float f11 = vectorComponent.f4417k;
                float f12 = vectorComponent.f4418l;
                long jC = y1.g.f81070b.c();
                z1.d dVarQ0 = gVar.Q0();
                long jI = dVarQ0.i();
                dVarQ0.e().d();
                try {
                    dVarQ0.c().e(f11, f12, jC);
                    groupComponentL.a(gVar);
                } finally {
                    dVarQ0.e().k();
                    dVarQ0.f(jI);
                }
            }
        };
    }

    @Override // androidx.compose.ui.graphics.vector.i
    public void a(z1.g gVar) {
        i(gVar, 1.0f, null);
    }

    public final void h() {
        this.f4410d = true;
        this.f4412f.invoke();
    }

    public final void i(z1.g gVar, float f11, x1 x1Var) {
        int iA = (this.f4408b.j() && this.f4408b.g() != 16 && k.f(k()) && k.f(x1Var)) ? h4.f4148b.a() : h4.f4148b.b();
        if (this.f4410d || !y1.m.f(this.f4416j, gVar.i()) || !h4.i(iA, j())) {
            this.f4414h = h4.i(iA, h4.f4148b.a()) ? x1.a.b(x1.f4581b, this.f4408b.g(), 0, 2, null) : null;
            this.f4417k = y1.m.i(gVar.i()) / y1.m.i(m());
            this.f4418l = y1.m.g(gVar.i()) / y1.m.g(m());
            this.f4411e.b(iA, u.a((int) Math.ceil(y1.m.i(gVar.i())), (int) Math.ceil(y1.m.g(gVar.i()))), gVar, gVar.getLayoutDirection(), this.f4419m);
            this.f4410d = false;
            this.f4416j = gVar.i();
        }
        if (x1Var == null) {
            x1Var = k() != null ? k() : this.f4414h;
        }
        this.f4411e.c(gVar, f11, x1Var);
    }

    public final int j() {
        g4 g4VarD = this.f4411e.d();
        return g4VarD != null ? g4VarD.b() : h4.f4148b.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final x1 k() {
        return (x1) this.f4413g.getValue();
    }

    public final GroupComponent l() {
        return this.f4408b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long m() {
        return ((y1.m) this.f4415i.getValue()).m();
    }

    public final void n(x1 x1Var) {
        this.f4413g.setValue(x1Var);
    }

    public final void o(Function0<Unit> function0) {
        this.f4412f = function0;
    }

    public final void p(String str) {
        this.f4409c = str;
    }

    public final void q(long j11) {
        this.f4415i.setValue(y1.m.c(j11));
    }

    public String toString() {
        String str = "Params: \tname: " + this.f4409c + "\n\tviewportWidth: " + y1.m.i(m()) + "\n\tviewportHeight: " + y1.m.g(m()) + "\n";
        Intrinsics.f(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }
}
