package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.t;
import androidx.compose.ui.text.u;
import androidx.emoji2.text.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import n2.j;
import q2.w;
import q2.y;

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
public final class e {
    public static final int a(long j11) {
        long jG = w.g(j11);
        y.a aVar = y.f74261b;
        if (y.g(jG, aVar.b())) {
            return 0;
        }
        return y.g(jG, aVar.a()) ? 1 : 2;
    }

    public static final int b(int i11) {
        u.a aVar = u.f6150a;
        if (u.i(i11, aVar.a())) {
            return 0;
        }
        if (u.i(i11, aVar.g())) {
            return 1;
        }
        if (u.i(i11, aVar.b())) {
            return 2;
        }
        if (u.i(i11, aVar.c())) {
            return 3;
        }
        if (u.i(i11, aVar.f())) {
            return 4;
        }
        if (u.i(i11, aVar.d())) {
            return 5;
        }
        if (u.i(i11, aVar.e())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }

    public static final void c(Spannable spannable, t tVar, int i11, int i12, q2.e eVar) {
        for (Object obj : spannable.getSpans(i11, i12, i.class)) {
            spannable.removeSpan((i) obj);
        }
        SpannableExtensions_androidKt.u(spannable, new j(w.h(tVar.c()), a(tVar.c()), w.h(tVar.a()), a(tVar.a()), eVar.M0() * eVar.getDensity(), b(tVar.b())), i11, i12);
    }

    public static final void d(Spannable spannable, List<AnnotatedString.b<t>> list, q2.e eVar) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            AnnotatedString.b<t> bVar = list.get(i11);
            c(spannable, bVar.a(), bVar.b(), bVar.c(), eVar);
        }
    }
}
