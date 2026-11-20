package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.t0;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import y1.i;
import y1.j;
import y1.m;
import y1.n;
import z1.g;

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
public abstract class Painter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o4 f4320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x1 f4322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f4323d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayoutDirection f4324e = LayoutDirection.Ltr;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<g, Unit> f4325f = new Function1<g, Unit>() { // from class: androidx.compose.ui.graphics.painter.Painter$drawLambda$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(g gVar) {
            invoke2(gVar);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(g gVar) {
            this.this$0.j(gVar);
        }
    };

    public abstract boolean a(float f11);

    public abstract boolean b(x1 x1Var);

    public boolean c(LayoutDirection layoutDirection) {
        return false;
    }

    public final void d(float f11) {
        if (this.f4323d == f11) {
            return;
        }
        if (!a(f11)) {
            if (f11 == 1.0f) {
                o4 o4Var = this.f4320a;
                if (o4Var != null) {
                    o4Var.setAlpha(f11);
                }
                this.f4321b = false;
            } else {
                i().setAlpha(f11);
                this.f4321b = true;
            }
        }
        this.f4323d = f11;
    }

    public final void e(x1 x1Var) {
        if (Intrinsics.b(this.f4322c, x1Var)) {
            return;
        }
        if (!b(x1Var)) {
            if (x1Var == null) {
                o4 o4Var = this.f4320a;
                if (o4Var != null) {
                    o4Var.A(null);
                }
                this.f4321b = false;
            } else {
                i().A(x1Var);
                this.f4321b = true;
            }
        }
        this.f4322c = x1Var;
    }

    public final void f(LayoutDirection layoutDirection) {
        if (this.f4324e != layoutDirection) {
            c(layoutDirection);
            this.f4324e = layoutDirection;
        }
    }

    public final void g(g gVar, long j11, float f11, x1 x1Var) {
        d(f11);
        e(x1Var);
        f(gVar.getLayoutDirection());
        float fI = m.i(gVar.i()) - m.i(j11);
        float fG = m.g(gVar.i()) - m.g(j11);
        gVar.Q0().c().f(0.0f, 0.0f, fI, fG);
        if (f11 > 0.0f) {
            try {
                if (m.i(j11) > 0.0f && m.g(j11) > 0.0f) {
                    if (this.f4321b) {
                        i iVarA = j.a(y1.g.f81070b.c(), n.a(m.i(j11), m.g(j11)));
                        o1 o1VarE = gVar.Q0().e();
                        try {
                            o1VarE.j(iVarA, i());
                            j(gVar);
                            o1VarE.k();
                        } catch (Throwable th2) {
                            o1VarE.k();
                            throw th2;
                        }
                    } else {
                        j(gVar);
                    }
                }
            } catch (Throwable th3) {
                gVar.Q0().c().f(-0.0f, -0.0f, -fI, -fG);
                throw th3;
            }
        }
        gVar.Q0().c().f(-0.0f, -0.0f, -fI, -fG);
    }

    public abstract long h();

    public final o4 i() {
        o4 o4Var = this.f4320a;
        if (o4Var != null) {
            return o4Var;
        }
        o4 o4VarA = t0.a();
        this.f4320a = o4VarA;
        return o4VarA;
    }

    public abstract void j(g gVar);
}
