package com.transsion.moviedetailapi.helper;

import android.content.res.Resources;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.transsion.moviedetailapi.R$string;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f53896a = new a();

    public static /* synthetic */ void d(a aVar, SpannableStringBuilder spannableStringBuilder, String str, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = R$color.white_60;
        }
        aVar.c(spannableStringBuilder, str, i11);
    }

    public final void a(int i11, SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.append(" ");
        int iD = kotlin.ranges.a.d(spannableStringBuilder.length() - 1, 0);
        spannableStringBuilder.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(Utils.a(), i11, 2) : new ImageSpan(Utils.a(), i11, 1), iD, iD + 1, 17);
    }

    public final void b(SpannableStringBuilder span) {
        Intrinsics.g(span, "span");
        int length = span.length();
        span.append(" I ");
        span.setSpan(new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_20)), length, length + 3, 17);
    }

    public final void c(SpannableStringBuilder spannableStringBuilder, String str, int i11) {
        if (str == null) {
            return;
        }
        int length = spannableStringBuilder.length();
        int length2 = str.length();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Utils.a().getResources().getColor(i11)), length, length2 + length, 17);
    }

    public final SpannableString e(Subject subject) {
        String strSubstring;
        int iIndexOf;
        List listD0;
        Intrinsics.g(subject, "subject");
        StringBuilder sb2 = new StringBuilder();
        String releaseDate = subject.getReleaseDate();
        String str = null;
        if (releaseDate != null) {
            strSubstring = releaseDate.substring(0, 4);
            Intrinsics.f(strSubstring, "substring(...)");
        } else {
            strSubstring = null;
        }
        String genre = subject.getGenre();
        if (genre != null && (listD0 = StringsKt__StringsKt.D0(genre, new char[]{','}, false, 0, 6, null)) != null) {
            str = (String) CollectionsKt___CollectionsKt.g0(listD0);
        }
        if (strSubstring != null && strSubstring.length() != 0) {
            sb2.append(" | ");
            sb2.append(strSubstring);
        }
        if (str != null) {
            sb2.append(" | ");
            sb2.append(str);
        }
        SpannableString spannableString = new SpannableString(sb2);
        if (strSubstring != null && strSubstring.length() != 0) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_20));
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_60));
            spannableString.setSpan(foregroundColorSpan, 0, 3, 17);
            spannableString.setSpan(foregroundColorSpan2, 3, strSubstring.length() + 3, 17);
        }
        if (str != null && (iIndexOf = sb2.indexOf(str)) >= 3) {
            ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_20));
            ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_60));
            spannableString.setSpan(foregroundColorSpan3, iIndexOf - 3, iIndexOf, 17);
            spannableString.setSpan(foregroundColorSpan4, iIndexOf, sb2.length(), 17);
        }
        return spannableString;
    }

    public final SpannableStringBuilder f(Subject subject) {
        String strSubstring;
        List<String> listD0;
        Intrinsics.g(subject, "subject");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        a(com.transsion.moviedetailapi.a.a(subject.getSubjectType()), spannableStringBuilder);
        b(spannableStringBuilder);
        a(R$drawable.ic_category_star, spannableStringBuilder);
        c(spannableStringBuilder, subject.getImdbRate(), R$color.yellow_light_60);
        b(spannableStringBuilder);
        String releaseDate = subject.getReleaseDate();
        if (releaseDate != null) {
            strSubstring = releaseDate.substring(0, 4);
            Intrinsics.f(strSubstring, "substring(...)");
        } else {
            strSubstring = null;
        }
        d(this, spannableStringBuilder, strSubstring, 0, 4, null);
        String genre = subject.getGenre();
        if (genre != null && (listD0 = StringsKt__StringsKt.D0(genre, new char[]{','}, false, 0, 6, null)) != null) {
            for (String str : listD0) {
                a aVar = f53896a;
                aVar.b(spannableStringBuilder);
                d(aVar, spannableStringBuilder, str, 0, 4, null);
            }
        }
        return spannableStringBuilder;
    }

    public final String g(Integer num) {
        Resources resources = Utils.a().getResources();
        int value = SubjectType.TV.getValue();
        if (num != null && num.intValue() == value) {
            String string = resources.getString(R$string.subject_tv);
            Intrinsics.f(string, "resources.getString(R.string.subject_tv)");
            return string;
        }
        int value2 = SubjectType.AUDIO.getValue();
        if (num == null || num.intValue() != value2) {
            int value3 = SubjectType.MUSIC.getValue();
            if (num == null || num.intValue() != value3) {
                int value4 = SubjectType.EDUCATION.getValue();
                if (num != null && num.intValue() == value4) {
                    String string2 = resources.getString(R$string.subject_education);
                    Intrinsics.f(string2, "resources.getString(R.string.subject_education)");
                    return string2;
                }
                String string3 = resources.getString(R$string.subject_movie);
                Intrinsics.f(string3, "resources.getString(R.string.subject_movie)");
                return string3;
            }
        }
        String string4 = resources.getString(R$string.subject_music);
        Intrinsics.f(string4, "resources.getString(R.string.subject_music)");
        return string4;
    }
}
