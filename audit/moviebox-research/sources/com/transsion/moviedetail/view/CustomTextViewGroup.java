package com.transsion.moviedetail.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$color;
import com.transsion.moviedetail.R$styleable;
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
public final class CustomTextViewGroup extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatTextView f53796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f53797b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTextViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        setOrientation(0);
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f0.a(1.0f), -1);
        layoutParams.setMarginStart(f0.a(4.0f));
        layoutParams.setMarginEnd(f0.a(4.0f));
        layoutParams.topMargin = f0.a(3.0f);
        layoutParams.bottomMargin = f0.a(3.0f);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(z2.a.getColor(context, R$color.white_20));
        this.f53797b = view;
        addView(view);
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
        appCompatTextView.setIncludeFontPadding(false);
        appCompatTextView.setMaxLines(1);
        appCompatTextView.setTextColor(z2.a.getColor(context, R$color.white_60));
        appCompatTextView.setTextSize(12.0f);
        appCompatTextView.setTypeface(so.a.d(context));
        this.f53796a = appCompatTextView;
        addView(appCompatTextView);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.CustomTextViewGroup);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…able.CustomTextViewGroup)");
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.CustomTextViewGroup_text);
        typedArrayObtainStyledAttributes.recycle();
        setText(string == null ? "" : string);
        requestLayout();
    }

    public final void setText(String text) {
        Intrinsics.g(text, "text");
        this.f53796a.setText(text);
        int i11 = text.length() == 0 ? 8 : 0;
        this.f53796a.setVisibility(i11);
        this.f53797b.setVisibility(i11);
        requestLayout();
    }
}
