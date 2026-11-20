package com.tn.lib.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ToolBar extends ConstraintLayout {
    public static final int CENTER_IN_ALL = 1;
    public static final int CENTER_IN_SPACE = 2;
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TRImageView f49650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f49651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TRImageView f49652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TRImageView f49653d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f49654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f49655g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToolBar(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToolBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        LayoutInflater.from(context).inflate(R$layout.libui_layout_tool_bar, (ViewGroup) this, true);
        this.f49651b = (TextView) findViewById(R$id.tv_title);
        this.f49650a = (TRImageView) findViewById(R$id.iv_back);
        this.f49652c = (TRImageView) findViewById(R$id.iv_right_action1);
        this.f49653d = (TRImageView) findViewById(R$id.iv_right_action2);
        this.f49654f = (TextView) findViewById(R$id.tv_right_action);
        this.f49655g = (FrameLayout) findViewById(R$id.vp_right_action3);
    }

    public static final void h(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static final void i(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static final void j(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static final void k(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static final void m(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final void addRightAction3View(View view) {
        Intrinsics.g(view, "view");
        FrameLayout frameLayout = this.f49655g;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.f49655g;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        FrameLayout frameLayout3 = this.f49655g;
        if (frameLayout3 != null) {
            frameLayout3.addView(view);
        }
        TextView textView = this.f49651b;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        tp.f fVar = tp.f.f77260a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        int iE = fVar.e(context);
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        ((ViewGroup.MarginLayoutParams) bVar).width = iE - fVar.a(context2, 180.0f);
        bVar.f7313s = R$id.iv_back;
        bVar.f7317u = R$id.vp_right_action3;
        bVar.f7315t = -1;
        bVar.f7319v = -1;
        TextView textView2 = this.f49651b;
        if (textView2 == null) {
            return;
        }
        textView2.setLayoutParams(bVar);
    }

    public final TRImageView getIvRightAction1ImageView() {
        return this.f49652c;
    }

    public final TRImageView getIvRightAction2() {
        return this.f49653d;
    }

    public final void n(int i11) {
        TRImageView tRImageView = this.f49653d;
        if (tRImageView != null) {
            tRImageView.setVisibility(i11);
        }
        TextView textView = this.f49651b;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
        bVar.f7315t = 0;
        bVar.f7319v = 0;
        tp.f fVar = tp.f.f77260a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        bVar.setMarginStart(fVar.a(context, 84.0f));
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        bVar.setMarginEnd(fVar.a(context2, 84.0f));
        TextView textView2 = this.f49651b;
        if (textView2 == null) {
            return;
        }
        textView2.setLayoutParams(bVar);
    }

    public final void o(int i11) {
        TRImageView tRImageView = this.f49653d;
        if (tRImageView != null) {
            tRImageView.setVisibility(i11);
        }
        TextView textView = this.f49651b;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
        bVar.f7313s = R$id.iv_back;
        bVar.f7317u = R$id.iv_right_action2;
        bVar.f7315t = -1;
        bVar.f7319v = -1;
        tp.f fVar = tp.f.f77260a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        bVar.setMarginStart(fVar.a(context, 10.0f));
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        bVar.setMarginEnd(fVar.a(context2, 10.0f));
        TextView textView2 = this.f49651b;
        if (textView2 == null) {
            return;
        }
        textView2.setLayoutParams(bVar);
    }

    public final void seTTitleTextSize(float f11) {
        TextView textView = this.f49651b;
        if (textView == null) {
            return;
        }
        textView.setTextSize(f11);
    }

    public final void setIvBackImageBitmap(Bitmap bitmap) {
        TRImageView tRImageView = this.f49650a;
        if (tRImageView != null) {
            tRImageView.setImageBitmap(bitmap);
        }
    }

    public final void setIvBackImageDrawable(Drawable drawable) {
        TRImageView tRImageView = this.f49650a;
        if (tRImageView != null) {
            tRImageView.setImageDrawable(drawable);
        }
    }

    public final void setIvBackImageResource(int i11) {
        TRImageView tRImageView = this.f49650a;
        if (tRImageView != null) {
            tRImageView.setImageResource(i11);
        }
    }

    public final void setIvBackOnClickListener(final View.OnClickListener onClickListener) {
        TRImageView tRImageView = this.f49650a;
        if (tRImageView != null) {
            tRImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar.h(onClickListener, view);
                }
            });
        }
    }

    public final void setIvBackVisible(int i11) {
        TRImageView tRImageView = this.f49650a;
        if (tRImageView == null) {
            return;
        }
        tRImageView.setVisibility(i11);
    }

    public final void setIvRightAction1ImageBitmap(Bitmap bitmap) {
        TRImageView tRImageView = this.f49652c;
        if (tRImageView != null) {
            tRImageView.setImageBitmap(bitmap);
        }
    }

    public final void setIvRightAction1ImageDrawable(Drawable drawable) {
        TRImageView tRImageView = this.f49652c;
        if (tRImageView != null) {
            tRImageView.setImageDrawable(drawable);
        }
    }

    public final void setIvRightAction1ImageResource(int i11) {
        TRImageView tRImageView = this.f49652c;
        if (tRImageView != null) {
            tRImageView.setImageResource(i11);
        }
    }

    public final void setIvRightAction1OnClickListener(final View.OnClickListener onClickListener) {
        TRImageView tRImageView = this.f49652c;
        if (tRImageView != null) {
            tRImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar.i(onClickListener, view);
                }
            });
        }
    }

    public final void setIvRightAction1Visible(int i11) {
        TRImageView tRImageView = this.f49652c;
        if (tRImageView == null) {
            return;
        }
        tRImageView.setVisibility(i11);
    }

    public final void setIvRightAction2ImageBitmap(Bitmap bitmap) {
        TRImageView tRImageView = this.f49653d;
        if (tRImageView != null) {
            tRImageView.setImageBitmap(bitmap);
        }
    }

    public final void setIvRightAction2ImageDrawable(Drawable drawable) {
        TRImageView tRImageView = this.f49653d;
        if (tRImageView != null) {
            tRImageView.setImageDrawable(drawable);
        }
    }

    public final void setIvRightAction2ImageResource(int i11) {
        TRImageView tRImageView = this.f49653d;
        if (tRImageView != null) {
            tRImageView.setImageResource(i11);
        }
    }

    public final void setIvRightAction2OnClickListener(final View.OnClickListener onClickListener) {
        TRImageView tRImageView = this.f49653d;
        if (tRImageView != null) {
            tRImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar.j(onClickListener, view);
                }
            });
        }
    }

    public final void setIvRightAction2Visible(int i11) {
        setIvRightAction2Visible(i11, 1);
    }

    public final void setIvRightAction2Visible(int i11, int i12) {
        if (i12 == 1) {
            n(i11);
        } else {
            o(i11);
        }
    }

    public final void setRightAction3OnClickListener(final View.OnClickListener onClickListener) {
        FrameLayout frameLayout = this.f49655g;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar.k(onClickListener, view);
                }
            });
        }
    }

    public final void setRightAction3Visible(int i11) {
        FrameLayout frameLayout = this.f49655g;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(i11);
    }

    public final void setRightActionText(@StringRes int i11) {
        TextView textView = this.f49654f;
        if (textView != null) {
            textView.setText(i11);
        }
    }

    public final void setRightActionText(CharSequence text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f49654f;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setRightActionTextColor(int i11) {
        TextView textView = this.f49654f;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setRightActionTextSize(float f11) {
        TextView textView = this.f49654f;
        if (textView == null) {
            return;
        }
        textView.setTextSize(f11);
    }

    public final void setRightActionVisible(int i11) {
        TextView textView = this.f49654f;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i11);
    }

    public final void setTitleOnClickListener(final View.OnClickListener onClickListener) {
        TextView textView = this.f49651b;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar.l(onClickListener, view);
                }
            });
        }
    }

    public final void setTitleText(@StringRes int i11) {
        TextView textView = this.f49651b;
        if (textView != null) {
            textView.setText(i11);
        }
    }

    public final void setTitleText(CharSequence text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f49651b;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setTitleTextColor(int i11) {
        TextView textView = this.f49651b;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setTitleVisible(int i11) {
        TextView textView = this.f49651b;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i11);
    }

    public final void setTvRightActionOnClickListener(final View.OnClickListener onClickListener) {
        TextView textView = this.f49654f;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar.m(onClickListener, view);
                }
            });
        }
    }
}
