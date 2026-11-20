package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.e1;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.n2;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class VectorPainter extends Painter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i1 f4420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i1 f4421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VectorComponent f4422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e1 f4423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f4424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public x1 f4425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4426m;

    /* JADX WARN: Multi-variable type inference failed */
    public VectorPainter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public VectorPainter(GroupComponent groupComponent) {
        this.f4420g = u2.c(y1.m.c(y1.m.f81091b.b()), null, 2, null);
        this.f4421h = u2.c(Boolean.FALSE, null, 2, null);
        VectorComponent vectorComponent = new VectorComponent(groupComponent);
        vectorComponent.o(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$vector$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (this.this$0.f4426m == this.this$0.o()) {
                    VectorPainter vectorPainter = this.this$0;
                    vectorPainter.s(vectorPainter.o() + 1);
                }
            }
        });
        this.f4422i = vectorComponent;
        this.f4423j = n2.a(0);
        this.f4424k = 1.0f;
        this.f4426m = -1;
    }

    public /* synthetic */ VectorPainter(GroupComponent groupComponent, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new GroupComponent() : groupComponent);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean a(float f11) {
        this.f4424k = f11;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean b(x1 x1Var) {
        this.f4425l = x1Var;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long h() {
        return p();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public void j(z1.g gVar) {
        VectorComponent vectorComponent = this.f4422i;
        x1 x1VarK = this.f4425l;
        if (x1VarK == null) {
            x1VarK = vectorComponent.k();
        }
        if (n() && gVar.getLayoutDirection() == LayoutDirection.Rtl) {
            long jT0 = gVar.T0();
            z1.d dVarQ0 = gVar.Q0();
            long jI = dVarQ0.i();
            dVarQ0.e().d();
            try {
                dVarQ0.c().e(-1.0f, 1.0f, jT0);
                vectorComponent.i(gVar, this.f4424k, x1VarK);
                dVarQ0.e().k();
                dVarQ0.f(jI);
            } catch (Throwable th2) {
                dVarQ0.e().k();
                dVarQ0.f(jI);
                throw th2;
            }
        } else {
            vectorComponent.i(gVar, this.f4424k, x1VarK);
        }
        this.f4426m = o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean n() {
        return ((Boolean) this.f4421h.getValue()).booleanValue();
    }

    public final int o() {
        return this.f4423j.getIntValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long p() {
        return ((y1.m) this.f4420g.getValue()).m();
    }

    public final void q(boolean z11) {
        this.f4421h.setValue(Boolean.valueOf(z11));
    }

    public final void r(x1 x1Var) {
        this.f4422i.n(x1Var);
    }

    public final void s(int i11) {
        this.f4423j.setIntValue(i11);
    }

    public final void t(String str) {
        this.f4422i.p(str);
    }

    public final void u(long j11) {
        this.f4420g.setValue(y1.m.c(j11));
    }

    public final void v(long j11) {
        this.f4422i.q(j11);
    }
}
