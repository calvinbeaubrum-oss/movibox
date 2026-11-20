package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.r2;
import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.p4;
import androidx.compose.ui.graphics.t0;
import androidx.compose.ui.graphics.y1;
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
public final class AndroidTextPaint extends TextPaint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o4 f6011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.compose.ui.text.style.i f6012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b5 f6014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l1 f6015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a3<? extends Shader> f6016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y1.m f6017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z1.h f6018h;

    public AndroidTextPaint(int i11, float f11) {
        super(i11);
        ((TextPaint) this).density = f11;
        this.f6012b = androidx.compose.ui.text.style.i.f6110b.b();
        this.f6013c = z1.g.f81712v8.a();
        this.f6014d = b5.f3990d.a();
    }

    public final void a() {
        this.f6016f = null;
        this.f6015e = null;
        this.f6017g = null;
        setShader(null);
    }

    public final int b() {
        return this.f6013c;
    }

    public final o4 c() {
        o4 o4Var = this.f6011a;
        if (o4Var != null) {
            return o4Var;
        }
        o4 o4VarB = t0.b(this);
        this.f6011a = o4VarB;
        return o4VarB;
    }

    public final void d(int i11) {
        if (e1.E(i11, this.f6013c)) {
            return;
        }
        c().o(i11);
        this.f6013c = i11;
    }

    public final void e(final l1 l1Var, final long j11, float f11) {
        y1.m mVar;
        if (l1Var == null) {
            a();
            return;
        }
        if (l1Var instanceof d5) {
            f(androidx.compose.ui.text.style.k.b(((d5) l1Var).b(), f11));
            return;
        }
        if (l1Var instanceof a5) {
            if ((!Intrinsics.b(this.f6015e, l1Var) || (mVar = this.f6017g) == null || !y1.m.f(mVar.m(), j11)) && j11 != 9205357640488583168L) {
                this.f6015e = l1Var;
                this.f6017g = y1.m.c(j11);
                this.f6016f = r2.c(new Function0<Shader>() { // from class: androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Shader invoke() {
                        return ((a5) l1Var).b(j11);
                    }
                });
            }
            o4 o4VarC = c();
            a3<? extends Shader> a3Var = this.f6016f;
            o4VarC.y(a3Var != null ? a3Var.getValue() : null);
            f.a(this, f11);
        }
    }

    public final void f(long j11) {
        if (j11 != 16) {
            setColor(y1.j(j11));
            a();
        }
    }

    public final void g(z1.h hVar) {
        if (hVar == null || Intrinsics.b(this.f6018h, hVar)) {
            return;
        }
        this.f6018h = hVar;
        if (Intrinsics.b(hVar, z1.l.f81716a)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (hVar instanceof z1.m) {
            c().D(p4.f4317a.b());
            z1.m mVar = (z1.m) hVar;
            c().setStrokeWidth(mVar.f());
            c().B(mVar.d());
            c().s(mVar.c());
            c().n(mVar.b());
            c().r(mVar.e());
        }
    }

    public final void h(b5 b5Var) {
        if (b5Var == null || Intrinsics.b(this.f6014d, b5Var)) {
            return;
        }
        this.f6014d = b5Var;
        if (Intrinsics.b(b5Var, b5.f3990d.a())) {
            clearShadowLayer();
        } else {
            setShadowLayer(androidx.compose.ui.text.platform.extensions.f.b(this.f6014d.b()), y1.g.m(this.f6014d.d()), y1.g.n(this.f6014d.d()), y1.j(this.f6014d.c()));
        }
    }

    public final void i(androidx.compose.ui.text.style.i iVar) {
        if (iVar == null || Intrinsics.b(this.f6012b, iVar)) {
            return;
        }
        this.f6012b = iVar;
        androidx.compose.ui.text.style.i.a aVar = androidx.compose.ui.text.style.i.f6110b;
        setUnderlineText(iVar.d(aVar.c()));
        setStrikeThruText(this.f6012b.d(aVar.a()));
    }
}
