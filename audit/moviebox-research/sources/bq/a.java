package bq;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
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
public final class a implements aq.c<TextView> {
    @Override // aq.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setId(R.id.message);
        textView.setGravity(g(context));
        textView.setTextColor(f(context));
        textView.setTextSize(0, h(context));
        int iD = d(context);
        int iJ = j(context);
        textView.setPaddingRelative(iD, iJ, iD, iJ);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setBackground(c(context));
        textView.setZ(i(context));
        textView.setMaxLines(e(context));
        return textView;
    }

    public final Drawable c(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-2013265920);
        Intrinsics.d(context);
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        return gradientDrawable;
    }

    public final int d(Context context) {
        Intrinsics.d(context);
        return (int) TypedValue.applyDimension(1, 24.0f, context.getResources().getDisplayMetrics());
    }

    public final int e(Context context) {
        return 5;
    }

    public final int f(Context context) {
        return -285212673;
    }

    public final int g(Context context) {
        return 17;
    }

    @Override // aq.c
    public int getGravity() {
        return aq.c.a.a(this);
    }

    @Override // aq.c
    public float getHorizontalMargin() {
        return aq.c.a.b(this);
    }

    @Override // aq.c
    public float getVerticalMargin() {
        return aq.c.a.c(this);
    }

    @Override // aq.c
    public int getXOffset() {
        return aq.c.a.d(this);
    }

    @Override // aq.c
    public int getYOffset() {
        return aq.c.a.e(this);
    }

    public final float h(Context context) {
        Intrinsics.d(context);
        return TypedValue.applyDimension(2, 14.0f, context.getResources().getDisplayMetrics());
    }

    public final float i(Context context) {
        Intrinsics.d(context);
        return TypedValue.applyDimension(1, 3.0f, context.getResources().getDisplayMetrics());
    }

    public final int j(Context context) {
        Intrinsics.d(context);
        return (int) TypedValue.applyDimension(1, 16.0f, context.getResources().getDisplayMetrics());
    }
}
