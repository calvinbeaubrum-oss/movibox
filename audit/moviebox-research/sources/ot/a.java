package ot;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import java.util.Locale;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {
    public static final GradientDrawable a(String startColor, String endColor, GradientDrawable.Orientation orientation) {
        Intrinsics.g(startColor, "startColor");
        Intrinsics.g(endColor, "endColor");
        Intrinsics.g(orientation, "orientation");
        return b(new int[]{Color.parseColor(startColor), Color.parseColor(endColor)}, orientation);
    }

    public static final GradientDrawable b(int[] colors, GradientDrawable.Orientation orientation) {
        Intrinsics.g(colors, "colors");
        Intrinsics.g(orientation, "orientation");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(colors);
        gradientDrawable.setOrientation(orientation);
        return gradientDrawable;
    }

    public static /* synthetic */ GradientDrawable c(String str, String str2, GradientDrawable.Orientation orientation, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        }
        return a(str, str2, orientation);
    }

    public static final int d() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? GravityCompat.END : GravityCompat.START;
    }
}
