package com.tn.lib.view;

import android.content.Context;
import android.text.TextUtils;
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
public final class ToolBar2 extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f49656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f49657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f49658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f49659d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f49660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f49661g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToolBar2(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToolBar2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolBar2(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        LayoutInflater.from(context).inflate(R$layout.libui_layout_tool_bar2, (ViewGroup) this, true);
        this.f49657b = (TextView) findViewById(R$id.tv_title);
        this.f49656a = (TextView) findViewById(R$id.tv_back);
        this.f49658c = (TextView) findViewById(R$id.tv_right_action1);
        this.f49659d = (TextView) findViewById(R$id.tv_right_action2);
        this.f49660f = (FrameLayout) findViewById(R$id.vp_right_action3);
        this.f49661g = findViewById(R$id.view_line);
    }

    public static final void g(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
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

    public final void addRightAction3View(View view) {
        Intrinsics.g(view, "view");
        FrameLayout frameLayout = this.f49660f;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.f49660f;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        FrameLayout frameLayout3 = this.f49660f;
        if (frameLayout3 != null) {
            frameLayout3.addView(view);
        }
        TextView textView = this.f49657b;
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
        TextView textView2 = this.f49657b;
        if (textView2 == null) {
            return;
        }
        textView2.setLayoutParams(bVar);
    }

    public final TextView getRightAction1() {
        return this.f49658c;
    }

    public final TextView getRightAction2() {
        return this.f49659d;
    }

    public final void seTTitleTextSize(float f11) {
        TextView textView = this.f49657b;
        if (textView == null) {
            return;
        }
        textView.setTextSize(f11);
    }

    public final void setBackColor(int i11) {
        TextView textView = this.f49656a;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setBackOnClickListener(final View.OnClickListener onClickListener) {
        TextView textView = this.f49656a;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar2.g(onClickListener, view);
                }
            });
        }
    }

    public final void setBackVisible(int i11) {
        TextView textView = this.f49656a;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i11);
    }

    public final void setLineColor(int i11) {
        View view = this.f49661g;
        if (view != null) {
            view.setBackgroundColor(i11);
        }
    }

    public final void setLineVisible(int i11) {
        View view = this.f49661g;
        if (view == null) {
            return;
        }
        view.setVisibility(i11);
    }

    public final void setRightAction1OnClickListener(final View.OnClickListener onClickListener) {
        TextView textView = this.f49658c;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar2.h(onClickListener, view);
                }
            });
        }
    }

    public final void setRightAction1Text(CharSequence text) {
        Intrinsics.g(text, "text");
        if (TextUtils.isEmpty(text)) {
            return;
        }
        TextView textView = this.f49658c;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.f49658c;
        if (textView2 != null) {
            textView2.setText(text);
        }
    }

    public final void setRightAction1TextColor(int i11) {
    }

    public final void setRightAction1Visible(int i11) {
        TextView textView = this.f49658c;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i11);
    }

    public final void setRightAction2OnClickListener(final View.OnClickListener onClickListener) {
        TextView textView = this.f49659d;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar2.i(onClickListener, view);
                }
            });
        }
    }

    public final void setRightAction2Text(CharSequence text) {
        Intrinsics.g(text, "text");
        if (TextUtils.isEmpty(text)) {
            return;
        }
        TextView textView = this.f49659d;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.f49659d;
        if (textView2 != null) {
            textView2.setText(text);
        }
    }

    public final void setRightAction2Visible(int i11) {
        TextView textView = this.f49659d;
        if (textView != null) {
            textView.setVisibility(i11);
        }
        TextView textView2 = this.f49657b;
        ViewGroup.LayoutParams layoutParams = textView2 != null ? textView2.getLayoutParams() : null;
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        tp.f fVar = tp.f.f77260a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        int iE = fVar.e(context);
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        ((ViewGroup.MarginLayoutParams) bVar).width = iE - fVar.a(context2, 140.0f);
        bVar.f7313s = R$id.tv_back;
        bVar.f7317u = R$id.tv_right_action2;
        bVar.f7315t = -1;
        bVar.f7319v = -1;
        TextView textView3 = this.f49657b;
        if (textView3 == null) {
            return;
        }
        textView3.setLayoutParams(bVar);
    }

    public final void setRightAction3OnClickListener(final View.OnClickListener onClickListener) {
        FrameLayout frameLayout = this.f49660f;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar2.j(onClickListener, view);
                }
            });
        }
    }

    public final void setRightAction3Visible(int i11) {
        FrameLayout frameLayout = this.f49660f;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(i11);
    }

    public final void setTitleOnClickListener(final View.OnClickListener onClickListener) {
        TextView textView = this.f49657b;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolBar2.k(onClickListener, view);
                }
            });
        }
    }

    public final void setTitleText(@StringRes int i11) {
        TextView textView = this.f49657b;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.f49657b;
        if (textView2 != null) {
            textView2.setText(i11);
        }
    }

    public final void setTitleText(CharSequence text) {
        Intrinsics.g(text, "text");
        if (TextUtils.isEmpty(text)) {
            return;
        }
        setTitleVisible(0);
        TextView textView = this.f49657b;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setTitleTextColor(int i11) {
        TextView textView = this.f49657b;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setTitleVisible(int i11) {
        TextView textView = this.f49657b;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i11);
    }
}
