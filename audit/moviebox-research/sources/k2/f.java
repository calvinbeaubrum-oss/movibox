package k2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import androidx.compose.runtime.k;
import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.m;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ResourceResolutionException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.xmlpull.v1.XmlPullParserException;

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
public final class f {
    public static final g4 a(CharSequence charSequence, Resources resources, int i11) {
        try {
            return d.a(g4.f4143a, resources, i11);
        } catch (Exception e11) {
            throw new ResourceResolutionException("Error attempting to load resource: " + ((Object) charSequence), e11);
        }
    }

    public static final androidx.compose.ui.graphics.vector.c b(Resources.Theme theme, Resources resources, int i11, int i12, androidx.compose.runtime.i iVar, int i13) throws XmlPullParserException, IOException {
        if (k.J()) {
            k.S(21855625, i13, -1, "androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:91)");
        }
        e eVar = (e) iVar.l(AndroidCompositionLocals_androidKt.h());
        e.b bVar = new e.b(theme, i11);
        e.a aVarB = eVar.b(bVar);
        if (aVarB == null) {
            XmlResourceParser xml = resources.getXml(i11);
            if (!Intrinsics.b(b2.c.j(xml).getName(), "vector")) {
                throw new IllegalArgumentException("Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP");
            }
            aVarB = j.a(theme, resources, xml, i12);
            eVar.d(bVar, aVarB);
        }
        androidx.compose.ui.graphics.vector.c cVarB = aVarB.b();
        if (k.J()) {
            k.R();
        }
        return cVarB;
    }

    public static final Painter c(int i11, androidx.compose.runtime.i iVar, int i12) {
        Painter aVar;
        if (k.J()) {
            k.S(473971343, i12, -1, "androidx.compose.ui.res.painterResource (PainterResources.android.kt:57)");
        }
        Context context = (Context) iVar.l(AndroidCompositionLocals_androidKt.g());
        iVar.l(AndroidCompositionLocals_androidKt.f());
        Resources resources = context.getResources();
        TypedValue typedValueB = ((g) iVar.l(AndroidCompositionLocals_androidKt.i())).b(resources, i11);
        CharSequence charSequence = typedValueB.string;
        boolean z11 = true;
        if (charSequence == null || !StringsKt__StringsKt.U(charSequence, ".xml", false, 2, null)) {
            iVar.R(-802884675);
            Object theme = context.getTheme();
            boolean zQ = iVar.Q(charSequence);
            if ((((i12 & 14) ^ 6) <= 4 || !iVar.c(i11)) && (i12 & 6) != 4) {
                z11 = false;
            }
            boolean zQ2 = zQ | z11 | iVar.Q(theme);
            Object objY = iVar.y();
            if (zQ2 || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = a(charSequence, resources, i11);
                iVar.p(objY);
            }
            aVar = new androidx.compose.ui.graphics.painter.a((g4) objY, 0L, 0L, 6, null);
            iVar.L();
        } else {
            iVar.R(-803040357);
            aVar = m.g(b(context.getTheme(), resources, i11, typedValueB.changingConfigurations, iVar, (i12 << 6) & 896), iVar, 0);
            iVar.L();
        }
        if (k.J()) {
            k.R();
        }
        return aVar;
    }
}
