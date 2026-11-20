package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
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
public final class TipBar extends LinearLayoutCompat {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TRImageView f49640q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f49641r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f49642s;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TipBar(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TipBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        LayoutInflater.from(context).inflate(R$layout.libui_layout_tip_bar, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setGravity(16);
        setMinimumHeight(tp.f.f77260a.a(context, 42.0f));
        this.f49640q = (TRImageView) findViewById(R$id.iv_close);
        this.f49641r = (TextView) findViewById(R$id.tv_tip);
        this.f49642s = (TextView) findViewById(R$id.tv_get_more);
        TRImageView tRImageView = this.f49640q;
        if (tRImageView != null) {
            tRImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TipBar.v(this.f49934a, view);
                }
            });
        }
    }

    public static final void v(TipBar this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.setVisibility(8);
    }

    public final void setCloseListener(View.OnClickListener onClickListener) {
        TRImageView tRImageView = this.f49640q;
        if (tRImageView != null) {
            tRImageView.setOnClickListener(onClickListener);
        }
    }

    public final void setCloseVisible(int i11) {
        ViewGroup.LayoutParams layoutParams;
        TRImageView tRImageView = this.f49640q;
        if (tRImageView != null) {
            tRImageView.setVisibility(i11);
        }
        if (i11 == 0) {
            TextView textView = this.f49641r;
            layoutParams = textView != null ? textView.getLayoutParams() : null;
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
            LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) layoutParams;
            aVar.setMarginStart(0);
            TextView textView2 = this.f49641r;
            if (textView2 == null) {
                return;
            }
            textView2.setLayoutParams(aVar);
            return;
        }
        if (i11 != 8) {
            return;
        }
        TextView textView3 = this.f49641r;
        layoutParams = textView3 != null ? textView3.getLayoutParams() : null;
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
        LinearLayoutCompat.a aVar2 = (LinearLayoutCompat.a) layoutParams;
        tp.f fVar = tp.f.f77260a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        aVar2.setMarginStart(fVar.a(context, 16.0f));
        TextView textView4 = this.f49641r;
        if (textView4 == null) {
            return;
        }
        textView4.setLayoutParams(aVar2);
    }

    public final void setRightActionListener(View.OnClickListener onClickListener) {
        TextView textView = this.f49642s;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public final void setRightActionText(String text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f49642s;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setRightActionTextColor(int i11) {
        TextView textView = this.f49642s;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setTip(String text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f49641r;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setTipColor(int i11) {
        TextView textView = this.f49641r;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }
}
