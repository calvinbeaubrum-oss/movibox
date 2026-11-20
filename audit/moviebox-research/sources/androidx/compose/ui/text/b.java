package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import kotlin.Metadata;
import m2.s1;

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
public final class b {
    public static final CharSequence i(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.u(spannableString, new n2.c(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }

    public static final int j(s1 s1Var, int i11) {
        int iL = s1Var.l();
        for (int i12 = 0; i12 < iL; i12++) {
            if (s1Var.k(i12) > i11) {
                return i12;
            }
        }
        return s1Var.l();
    }

    public static final boolean k(e0 e0Var, boolean z11) {
        if (!z11 || q2.w.e(e0Var.q(), q2.x.c(0)) || q2.w.e(e0Var.q(), q2.w.f74257b.a())) {
            return false;
        }
        int iZ = e0Var.z();
        androidx.compose.ui.text.style.h.a aVar = androidx.compose.ui.text.style.h.f6101b;
        return (androidx.compose.ui.text.style.h.k(iZ, aVar.g()) || androidx.compose.ui.text.style.h.k(e0Var.z(), aVar.f()) || androidx.compose.ui.text.style.h.k(e0Var.z(), aVar.c())) ? false : true;
    }

    public static final int l(int i11) {
        androidx.compose.ui.text.style.h.a aVar = androidx.compose.ui.text.style.h.f6101b;
        if (androidx.compose.ui.text.style.h.k(i11, aVar.d())) {
            return 3;
        }
        if (androidx.compose.ui.text.style.h.k(i11, aVar.e())) {
            return 4;
        }
        if (androidx.compose.ui.text.style.h.k(i11, aVar.a())) {
            return 2;
        }
        return (!androidx.compose.ui.text.style.h.k(i11, aVar.f()) && androidx.compose.ui.text.style.h.k(i11, aVar.b())) ? 1 : 0;
    }

    public static final int m(int i11) {
        androidx.compose.ui.text.style.e.b.a aVar = androidx.compose.ui.text.style.e.b.f6072a;
        if (androidx.compose.ui.text.style.e.b.e(i11, aVar.c())) {
            return 0;
        }
        if (androidx.compose.ui.text.style.e.b.e(i11, aVar.b())) {
            return 1;
        }
        return androidx.compose.ui.text.style.e.b.e(i11, aVar.a()) ? 2 : 0;
    }

    public static final int n(int i11) {
        androidx.compose.ui.text.style.d.a aVar = androidx.compose.ui.text.style.d.f6061b;
        if (androidx.compose.ui.text.style.d.g(i11, aVar.a())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        androidx.compose.ui.text.style.d.g(i11, aVar.b());
        return 0;
    }

    public static final int o(int i11) {
        androidx.compose.ui.text.style.e.c.a aVar = androidx.compose.ui.text.style.e.c.f6077a;
        if (androidx.compose.ui.text.style.e.c.f(i11, aVar.a())) {
            return 0;
        }
        if (androidx.compose.ui.text.style.e.c.f(i11, aVar.b())) {
            return 1;
        }
        if (androidx.compose.ui.text.style.e.c.f(i11, aVar.c())) {
            return 2;
        }
        return androidx.compose.ui.text.style.e.c.f(i11, aVar.d()) ? 3 : 0;
    }

    public static final int p(int i11) {
        androidx.compose.ui.text.style.e.d.a aVar = androidx.compose.ui.text.style.e.d.f6083a;
        return (!androidx.compose.ui.text.style.e.d.d(i11, aVar.a()) && androidx.compose.ui.text.style.e.d.d(i11, aVar.b())) ? 1 : 0;
    }
}
