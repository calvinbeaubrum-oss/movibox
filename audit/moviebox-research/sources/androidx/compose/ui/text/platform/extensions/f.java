package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.text.font.i;
import androidx.compose.ui.text.font.q;
import androidx.compose.ui.text.font.r;
import androidx.compose.ui.text.font.u;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.m;
import androidx.compose.ui.text.style.o;
import androidx.compose.ui.text.y;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import p2.h;
import q2.w;

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
public final class f {
    public static final y a(AndroidTextPaint androidTextPaint, y yVar, Function4<? super i, ? super u, ? super q, ? super r, ? extends Typeface> function4, q2.e eVar, boolean z11) {
        long jG = w.g(yVar.k());
        q2.y.a aVar = q2.y.f74261b;
        if (q2.y.g(jG, aVar.b())) {
            androidTextPaint.setTextSize(eVar.p0(yVar.k()));
        } else if (q2.y.g(jG, aVar.a())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * w.h(yVar.k()));
        }
        if (d(yVar)) {
            i iVarI = yVar.i();
            u uVarN = yVar.n();
            if (uVarN == null) {
                uVarN = u.f5860b.a();
            }
            q qVarL = yVar.l();
            q qVarC = q.c(qVarL != null ? qVarL.i() : q.f5850b.b());
            r rVarM = yVar.m();
            androidTextPaint.setTypeface(function4.invoke(iVarI, uVarN, qVarC, r.b(rVarM != null ? rVarM.j() : r.f5854b.a())));
        }
        if (yVar.p() != null && !Intrinsics.b(yVar.p(), p2.i.f73512c.a())) {
            if (Build.VERSION.SDK_INT >= 24) {
                d.f6020a.b(androidTextPaint, yVar.p());
            } else {
                androidTextPaint.setTextLocale((yVar.p().isEmpty() ? h.f73510b.a() : yVar.p().f(0)).a());
            }
        }
        if (yVar.j() != null && !Intrinsics.b(yVar.j(), "")) {
            androidTextPaint.setFontFeatureSettings(yVar.j());
        }
        if (yVar.u() != null && !Intrinsics.b(yVar.u(), m.f6126c.a())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * yVar.u().b());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + yVar.u().c());
        }
        androidTextPaint.f(yVar.g());
        androidTextPaint.e(yVar.f(), y1.m.f81091b.a(), yVar.c());
        androidTextPaint.h(yVar.r());
        androidTextPaint.i(yVar.s());
        androidTextPaint.g(yVar.h());
        if (q2.y.g(w.g(yVar.o()), aVar.b()) && w.h(yVar.o()) != 0.0f) {
            float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
            float fP0 = eVar.p0(yVar.o());
            if (textSize != 0.0f) {
                androidTextPaint.setLetterSpacing(fP0 / textSize);
            }
        } else if (q2.y.g(w.g(yVar.o()), aVar.a())) {
            androidTextPaint.setLetterSpacing(w.h(yVar.o()));
        }
        return c(yVar.o(), z11, yVar.d(), yVar.e());
    }

    public static final float b(float f11) {
        if (f11 == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f11;
    }

    public static final y c(long j11, boolean z11, long j12, androidx.compose.ui.text.style.a aVar) {
        long jE = j12;
        boolean z12 = false;
        boolean z13 = z11 && q2.y.g(w.g(j11), q2.y.f74261b.b()) && w.h(j11) != 0.0f;
        w1.a aVar2 = w1.f4564b;
        boolean z14 = (w1.m(jE, aVar2.e()) || w1.m(jE, aVar2.d())) ? false : true;
        if (aVar != null) {
            if (!androidx.compose.ui.text.style.a.e(aVar.h(), androidx.compose.ui.text.style.a.f6053b.a())) {
                z12 = true;
            }
        }
        if (!z13 && !z14 && !z12) {
            return null;
        }
        long jA = z13 ? j11 : w.f74257b.a();
        if (!z14) {
            jE = aVar2.e();
        }
        return new y(0L, 0L, null, null, null, null, null, jA, z12 ? aVar : null, null, null, jE, null, null, null, null, 63103, null);
    }

    public static final boolean d(y yVar) {
        return (yVar.i() == null && yVar.l() == null && yVar.n() == null) ? false : true;
    }

    public static final void e(AndroidTextPaint androidTextPaint, o oVar) {
        if (oVar == null) {
            oVar = o.f6134c.a();
        }
        androidTextPaint.setFlags(oVar.c() ? androidTextPaint.getFlags() | 128 : androidTextPaint.getFlags() & (-129));
        int iB = oVar.b();
        o.b.a aVar = o.b.f6139a;
        if (o.b.e(iB, aVar.b())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (o.b.e(iB, aVar.a())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (!o.b.e(iB, aVar.c())) {
            androidTextPaint.getFlags();
        } else {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        }
    }
}
