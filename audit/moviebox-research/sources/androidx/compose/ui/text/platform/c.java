package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.font.u;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.t;
import androidx.compose.ui.text.v;
import androidx.compose.ui.text.x;
import androidx.compose.ui.text.y;
import androidx.emoji2.text.EmojiCompat;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6019a = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends CharacterStyle {
        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [androidx.emoji2.text.EmojiCompat] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public static final CharSequence a(String str, float f11, e0 e0Var, List<AnnotatedString.b<y>> list, List<AnnotatedString.b<t>> list2, q2.e eVar, Function4<? super androidx.compose.ui.text.font.i, ? super u, ? super androidx.compose.ui.text.font.q, ? super androidx.compose.ui.text.font.r, ? extends Typeface> function4, boolean z11) {
        CharSequence charSequenceS;
        v vVarA;
        if (z11 && EmojiCompat.i()) {
            x xVarW = e0Var.w();
            androidx.compose.ui.text.e eVarD = (xVarW == null || (vVarA = xVarW.a()) == null) ? null : androidx.compose.ui.text.e.d(vVarA.a());
            charSequenceS = EmojiCompat.c().s(str, 0, str.length(), Api.BaseClientBuilder.API_PRIORITY_OTHER, eVarD == null ? 0 : androidx.compose.ui.text.e.g(eVarD.j(), androidx.compose.ui.text.e.f5769b.a()));
            Intrinsics.d(charSequenceS);
        } else {
            charSequenceS = str;
        }
        if (list.isEmpty() && list2.isEmpty() && Intrinsics.b(e0Var.D(), androidx.compose.ui.text.style.n.f6130c.a()) && q2.x.d(e0Var.s())) {
            return charSequenceS;
        }
        Spannable spannableString = charSequenceS instanceof Spannable ? (Spannable) charSequenceS : new SpannableString(charSequenceS);
        if (Intrinsics.b(e0Var.A(), androidx.compose.ui.text.style.i.f6110b.c())) {
            SpannableExtensions_androidKt.u(spannableString, f6019a, 0, str.length());
        }
        if (b(e0Var) && e0Var.t() == null) {
            SpannableExtensions_androidKt.r(spannableString, e0Var.s(), f11, eVar);
        } else {
            androidx.compose.ui.text.style.g gVarT = e0Var.t();
            if (gVarT == null) {
                gVarT = androidx.compose.ui.text.style.g.f6087c.a();
            }
            SpannableExtensions_androidKt.q(spannableString, e0Var.s(), f11, eVar, gVarT);
        }
        SpannableExtensions_androidKt.y(spannableString, e0Var.D(), f11, eVar);
        SpannableExtensions_androidKt.w(spannableString, e0Var, list, eVar, function4);
        androidx.compose.ui.text.platform.extensions.e.d(spannableString, list2, eVar);
        return spannableString;
    }

    public static final boolean b(e0 e0Var) {
        v vVarA;
        x xVarW = e0Var.w();
        if (xVarW == null || (vVarA = xVarW.a()) == null) {
            return false;
        }
        return vVarA.b();
    }
}
