package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.transsion.edcation.R$drawable;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class a {
    public static final String a(Subject subject) {
        if (subject == null) {
            return null;
        }
        Integer durationSeconds = subject.getDurationSeconds();
        return c(durationSeconds != null ? durationSeconds.intValue() : 0);
    }

    public static final SpannableStringBuilder b(Context context, Subject subject) {
        Intrinsics.g(context, "context");
        if (subject == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Drawable drawable = z2.a.getDrawable(context, R$drawable.ic_education_time);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        Intrinsics.d(drawable);
        is.a aVar = new is.a(drawable, 2);
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.setSpan(aVar, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
        Integer durationSeconds = subject.getDurationSeconds();
        spannableStringBuilder.append((CharSequence) (c(durationSeconds != null ? durationSeconds.intValue() : 0) + " • "));
        Drawable drawable2 = z2.a.getDrawable(context, R$drawable.ic_education_student);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        Intrinsics.d(drawable2);
        is.a aVar2 = new is.a(drawable2, 2);
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.setSpan(aVar2, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
        spannableStringBuilder.append((CharSequence) (subject.getViewers() + " students"));
        return spannableStringBuilder;
    }

    public static final String c(int i11) {
        int i12 = (i11 / 60) / 60;
        int i13 = (i11 % 3600) / 60;
        if (i12 <= 0) {
            return i13 + "m";
        }
        return i12 + "h " + i13 + "m";
    }
}
