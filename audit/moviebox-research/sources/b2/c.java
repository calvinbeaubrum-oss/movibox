package b2;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.f5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.s4;
import androidx.compose.ui.graphics.vector.e;
import androidx.compose.ui.graphics.vector.g;
import androidx.compose.ui.graphics.vector.k;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
import b3.d;
import com.mbridge.msdk.MBridgeConstans;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import q2.i;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13934a = 0;

    public static final androidx.compose.ui.graphics.vector.c.a a(a aVar, Resources resources, Resources.Theme theme, AttributeSet attributeSet) throws XmlPullParserException {
        long jE;
        int iZ;
        ColorStateList colorStateListE;
        b bVar = b.f13908a;
        TypedArray typedArrayK = aVar.k(resources, theme, attributeSet, bVar.F());
        boolean zD = aVar.d(typedArrayK, "autoMirrored", bVar.a(), false);
        float fG = aVar.g(typedArrayK, "viewportWidth", bVar.H(), 0.0f);
        float fG2 = aVar.g(typedArrayK, "viewportHeight", bVar.G(), 0.0f);
        if (fG <= 0.0f) {
            throw new XmlPullParserException(typedArrayK.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
        }
        if (fG2 <= 0.0f) {
            throw new XmlPullParserException(typedArrayK.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
        }
        float fA = aVar.a(typedArrayK, bVar.I(), 0.0f);
        float fA2 = aVar.a(typedArrayK, bVar.n(), 0.0f);
        if (typedArrayK.hasValue(bVar.D())) {
            TypedValue typedValue = new TypedValue();
            typedArrayK.getValue(bVar.D(), typedValue);
            jE = (typedValue.type == 2 || (colorStateListE = aVar.e(typedArrayK, theme, "tint", bVar.D())) == null) ? w1.f4564b.e() : y1.b(colorStateListE.getDefaultColor());
        } else {
            jE = w1.f4564b.e();
        }
        long j11 = jE;
        int iC = aVar.c(typedArrayK, bVar.E(), -1);
        if (iC == -1) {
            iZ = e1.f4102a.z();
        } else if (iC == 3) {
            iZ = e1.f4102a.B();
        } else if (iC == 5) {
            iZ = e1.f4102a.z();
        } else if (iC != 9) {
            switch (iC) {
                case 14:
                    iZ = e1.f4102a.q();
                    break;
                case 15:
                    iZ = e1.f4102a.v();
                    break;
                case 16:
                    iZ = e1.f4102a.t();
                    break;
                default:
                    iZ = e1.f4102a.z();
                    break;
            }
        } else {
            iZ = e1.f4102a.y();
        }
        int i11 = iZ;
        float fH = i.h(fA / resources.getDisplayMetrics().density);
        float fH2 = i.h(fA2 / resources.getDisplayMetrics().density);
        typedArrayK.recycle();
        return new androidx.compose.ui.graphics.vector.c.a(null, fH, fH2, fG, fG2, j11, i11, zD, 1, null);
    }

    public static final int b(int i11, int i12) {
        if (i11 == 0) {
            return e5.f4128a.a();
        }
        if (i11 != 1) {
            return i11 != 2 ? i12 : e5.f4128a.c();
        }
        return e5.f4128a.b();
    }

    public static final int c(int i11, int i12) {
        if (i11 == 0) {
            return f5.f4136a.b();
        }
        if (i11 != 1) {
            return i11 != 2 ? i12 : f5.f4136a.a();
        }
        return f5.f4136a.c();
    }

    public static final boolean d(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getEventType() != 1) {
            return xmlPullParser.getDepth() < 1 && xmlPullParser.getEventType() == 3;
        }
        return true;
    }

    public static final l1 e(d dVar) {
        if (!dVar.l()) {
            return null;
        }
        Shader shaderF = dVar.f();
        return shaderF != null ? m1.a(shaderF) : new d5(y1.b(dVar.e()), null);
    }

    public static final void f(a aVar, Resources resources, Resources.Theme theme, AttributeSet attributeSet, androidx.compose.ui.graphics.vector.c.a aVar2) {
        b bVar = b.f13908a;
        TypedArray typedArrayK = aVar.k(resources, theme, attributeSet, bVar.b());
        String strI = aVar.i(typedArrayK, bVar.c());
        if (strI == null) {
            strI = "";
        }
        String str = strI;
        String strI2 = aVar.i(typedArrayK, bVar.d());
        List listD = strI2 == null ? k.d() : g.b(aVar.f13907c, strI2, null, 2, null);
        typedArrayK.recycle();
        aVar2.a((254 & 1) != 0 ? "" : str, (254 & 2) != 0 ? 0.0f : 0.0f, (254 & 4) != 0 ? 0.0f : 0.0f, (254 & 8) != 0 ? 0.0f : 0.0f, (254 & 16) != 0 ? 1.0f : 0.0f, (254 & 32) == 0 ? 0.0f : 1.0f, (254 & 64) != 0 ? 0.0f : 0.0f, (254 & 128) == 0 ? 0.0f : 0.0f, (254 & 256) != 0 ? k.d() : listD);
    }

    public static final int g(a aVar, Resources resources, AttributeSet attributeSet, Resources.Theme theme, androidx.compose.ui.graphics.vector.c.a aVar2, int i11) throws XmlPullParserException {
        int eventType = aVar.j().getEventType();
        if (eventType != 2) {
            if (eventType != 3 || !Intrinsics.b("group", aVar.j().getName())) {
                return i11;
            }
            int i12 = i11 + 1;
            for (int i13 = 0; i13 < i12; i13++) {
                aVar2.f();
            }
            return 0;
        }
        String name = aVar.j().getName();
        if (name == null) {
            return i11;
        }
        int iHashCode = name.hashCode();
        if (iHashCode == -1649314686) {
            if (!name.equals("clip-path")) {
                return i11;
            }
            f(aVar, resources, theme, attributeSet, aVar2);
            return i11 + 1;
        }
        if (iHashCode == 3433509) {
            if (!name.equals(MBridgeConstans.DYNAMIC_VIEW_WX_PATH)) {
                return i11;
            }
            i(aVar, resources, theme, attributeSet, aVar2);
            return i11;
        }
        if (iHashCode != 98629247 || !name.equals("group")) {
            return i11;
        }
        h(aVar, resources, theme, attributeSet, aVar2);
        return i11;
    }

    public static final void h(a aVar, Resources resources, Resources.Theme theme, AttributeSet attributeSet, androidx.compose.ui.graphics.vector.c.a aVar2) {
        b bVar = b.f13908a;
        TypedArray typedArrayK = aVar.k(resources, theme, attributeSet, bVar.e());
        float fG = aVar.g(typedArrayK, "rotation", bVar.i(), 0.0f);
        float fB = aVar.b(typedArrayK, bVar.g(), 0.0f);
        float fB2 = aVar.b(typedArrayK, bVar.h(), 0.0f);
        float fG2 = aVar.g(typedArrayK, "scaleX", bVar.j(), 1.0f);
        float fG3 = aVar.g(typedArrayK, "scaleY", bVar.k(), 1.0f);
        float fG4 = aVar.g(typedArrayK, "translateX", bVar.l(), 0.0f);
        float fG5 = aVar.g(typedArrayK, "translateY", bVar.m(), 0.0f);
        String strI = aVar.i(typedArrayK, bVar.f());
        if (strI == null) {
            strI = "";
        }
        typedArrayK.recycle();
        aVar2.a(strI, fG, fB, fB2, fG2, fG3, fG4, fG5, k.d());
    }

    public static final void i(a aVar, Resources resources, Resources.Theme theme, AttributeSet attributeSet, androidx.compose.ui.graphics.vector.c.a aVar2) throws IllegalArgumentException {
        b bVar = b.f13908a;
        TypedArray typedArrayK = aVar.k(resources, theme, attributeSet, bVar.o());
        if (!b3.k.j(aVar.j(), "pathData")) {
            throw new IllegalArgumentException("No path data available");
        }
        String strI = aVar.i(typedArrayK, bVar.r());
        if (strI == null) {
            strI = "";
        }
        String str = strI;
        String strI2 = aVar.i(typedArrayK, bVar.s());
        List<? extends e> listD = strI2 == null ? k.d() : g.b(aVar.f13907c, strI2, null, 2, null);
        d dVarF = aVar.f(typedArrayK, theme, "fillColor", bVar.q(), 0);
        float fG = aVar.g(typedArrayK, "fillAlpha", bVar.p(), 1.0f);
        int iB = b(aVar.h(typedArrayK, "strokeLineCap", bVar.v(), -1), e5.f4128a.a());
        int iC = c(aVar.h(typedArrayK, "strokeLineJoin", bVar.w(), -1), f5.f4136a.a());
        float fG2 = aVar.g(typedArrayK, "strokeMiterLimit", bVar.x(), 1.0f);
        d dVarF2 = aVar.f(typedArrayK, theme, "strokeColor", bVar.u(), 0);
        float fG3 = aVar.g(typedArrayK, "strokeAlpha", bVar.t(), 1.0f);
        float fG4 = aVar.g(typedArrayK, "strokeWidth", bVar.y(), 1.0f);
        float fG5 = aVar.g(typedArrayK, "trimPathEnd", bVar.z(), 1.0f);
        float fG6 = aVar.g(typedArrayK, "trimPathOffset", bVar.B(), 0.0f);
        float fG7 = aVar.g(typedArrayK, "trimPathStart", bVar.C(), 0.0f);
        int iH = aVar.h(typedArrayK, "fillType", bVar.A(), f13934a);
        typedArrayK.recycle();
        l1 l1VarE = e(dVarF);
        l1 l1VarE2 = e(dVarF2);
        s4.a aVar3 = s4.f4342a;
        aVar2.c(listD, iH == 0 ? aVar3.b() : aVar3.a(), str, l1VarE, fG, l1VarE2, fG3, fG4, iB, iC, fG2, fG7, fG5, fG6);
    }

    public static final XmlPullParser j(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next = xmlPullParser.next();
        while (next != 2 && next != 1) {
            next = xmlPullParser.next();
        }
        if (next == 2) {
            return xmlPullParser;
        }
        throw new XmlPullParserException("No start tag found");
    }
}
