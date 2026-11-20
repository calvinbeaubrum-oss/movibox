package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.R$styleable;
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
public final class CornerTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CornerTextView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CornerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CornerTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CornerTextView);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…styleable.CornerTextView)");
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CornerTextView_rectangleShape, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z11) {
            setBackgroundResource(R$drawable.bg_corner_tips_rectangle_2);
            setTextColor(z2.a.getColor(getContext(), R$color.white_80));
            setTextSize(2, 11.0f);
            int iA = f0.a(6.0f);
            int iA2 = f0.a(2.0f);
            setPadding(iA, iA2, iA, iA2);
        } else {
            setBackgroundResource(R$drawable.bg_corner_tips_4);
            setTextColor(z2.a.getColor(getContext(), R$color.text_01));
            setTextSize(2, 12.0f);
            int iA3 = f0.a(4.0f);
            setPadding(iA3, iA3 / 2, iA3, iA3);
        }
        Context context = getContext();
        Intrinsics.f(context, "context");
        setTypeface(so.a.c(context));
        setMaxLines(1);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence == null || charSequence.length() == 0) {
            so.c.h(this);
        } else {
            so.c.k(this);
        }
        super.setText(charSequence, bufferType);
    }

    public final void setTextWithType(CharSequence charSequence, Integer num) {
        if (charSequence != null && charSequence.length() != 0 && num != null && num.intValue() == 6) {
            Context context = getContext();
            Intrinsics.f(context, "context");
            setTypeface(so.a.a(context));
            setBackgroundResource(R$drawable.bg_music_corner_tips_4);
            setCompoundDrawablesWithIntrinsicBounds(z2.a.getDrawable(getContext(), R$drawable.ic_hot_white), (Drawable) null, (Drawable) null, (Drawable) null);
            setGravity(16);
        }
        setText(charSequence);
    }
}
