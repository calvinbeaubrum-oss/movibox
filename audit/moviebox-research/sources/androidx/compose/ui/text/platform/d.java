package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.t;
import androidx.compose.ui.text.v;
import androidx.compose.ui.text.x;
import androidx.compose.ui.text.y;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

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
public final class d {
    public static final androidx.compose.ui.text.o a(String str, e0 e0Var, List<AnnotatedString.b<y>> list, List<AnnotatedString.b<t>> list2, q2.e eVar, androidx.compose.ui.text.font.i.b bVar) {
        return new AndroidParagraphIntrinsics(str, e0Var, list, list2, bVar, eVar);
    }

    public static final boolean c(e0 e0Var) {
        v vVarA;
        x xVarW = e0Var.w();
        androidx.compose.ui.text.e eVarD = (xVarW == null || (vVarA = xVarW.a()) == null) ? null : androidx.compose.ui.text.e.d(vVarA.a());
        return !(eVarD == null ? false : androidx.compose.ui.text.e.g(eVarD.j(), androidx.compose.ui.text.e.f5769b.c()));
    }

    public static final int d(int i11, p2.i iVar) {
        Locale localeA;
        androidx.compose.ui.text.style.j.a aVar = androidx.compose.ui.text.style.j.f6115b;
        if (androidx.compose.ui.text.style.j.j(i11, aVar.b())) {
            return 2;
        }
        if (!androidx.compose.ui.text.style.j.j(i11, aVar.c())) {
            if (androidx.compose.ui.text.style.j.j(i11, aVar.d())) {
                return 0;
            }
            if (androidx.compose.ui.text.style.j.j(i11, aVar.e())) {
                return 1;
            }
            if (!androidx.compose.ui.text.style.j.j(i11, aVar.a()) && !androidx.compose.ui.text.style.j.j(i11, aVar.f())) {
                throw new IllegalStateException("Invalid TextDirection.".toString());
            }
            if (iVar == null || (localeA = iVar.f(0).a()) == null) {
                localeA = Locale.getDefault();
            }
            int iA = androidx.core.text.v.a(localeA);
            if (iA == 0 || iA != 1) {
                return 2;
            }
        }
        return 3;
    }
}
