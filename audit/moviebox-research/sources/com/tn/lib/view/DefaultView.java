package com.tn.lib.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import com.tn.lib.widget.R$color;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DefaultView extends LinearLayoutCompat {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TRImageView f49508q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f49509r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f49510s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f49511t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f49512u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LinearLayout f49513v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f49514w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LinearLayoutCompat f49515x;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum DefaultViewStyle {
        STYLE_ALL,
        STYLE_NO_BTN,
        STYLE_IMAGE_DESC_TIP,
        STYLE_IMAGE_DESC_BTN,
        STYLE_NO_IMAGE,
        STYLE_TITLE_DESC_TIP,
        STYLE_DESC_TIP,
        STYLE_DESC14SP_TIP,
        STYLE_TIP,
        STYLE_IMAGE_DES,
        STYLE_DES,
        STYLE_DES_BTN
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum ModelStyle {
        MODEL_STYLE_NIGHT,
        MODEL_STYLE_WHITE
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49516a;

        static {
            int[] iArr = new int[DefaultViewStyle.values().length];
            try {
                iArr[DefaultViewStyle.STYLE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_NO_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_IMAGE_DESC_TIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_IMAGE_DESC_BTN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_NO_IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_TITLE_DESC_TIP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_DESC_TIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_DESC14SP_TIP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_TIP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_IMAGE_DES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_DES.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[DefaultViewStyle.STYLE_DES_BTN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            f49516a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultView(Context context) {
        this(context, ModelStyle.MODEL_STYLE_WHITE);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultView(Context context, AttributeSet attributeSet, int i11, ModelStyle modelStyle) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        Intrinsics.g(modelStyle, "modelStyle");
        setOrientation(1);
        setGravity(49);
        tp.f fVar = tp.f.f77260a;
        int iA = fVar.a(context, 26.0f);
        setPadding(iA, fVar.a(context, 116.0f), iA, 0);
        LayoutInflater.from(context).inflate(R$layout.libui_layout_default_view, (ViewGroup) this, true);
        this.f49508q = (TRImageView) findViewById(R$id.iv_default_image);
        this.f49509r = (TextView) findViewById(R$id.tv_default_title);
        this.f49510s = (TextView) findViewById(R$id.tv_desc);
        this.f49511t = (TextView) findViewById(R$id.btn_left);
        this.f49512u = (TextView) findViewById(R$id.btn_right);
        this.f49513v = (LinearLayout) findViewById(R$id.ll_btn);
        this.f49514w = (TextView) findViewById(R$id.tv_tip_operation);
        this.f49515x = (LinearLayoutCompat) findViewById(R$id.ll_tip);
        TextView textView = this.f49511t;
        if (textView != null) {
            so.c.g(textView);
        }
        if (modelStyle == ModelStyle.MODEL_STYLE_NIGHT) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            TextView textView2 = this.f49509r;
            Intrinsics.d(textView2);
            textView2.setTextColor(z2.a.getColor(getContext(), R$color.base_color_999999));
            TextView textView3 = this.f49510s;
            Intrinsics.d(textView3);
            textView3.setTextColor(z2.a.getColor(getContext(), R$color.base_color_999999));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultView(Context context, AttributeSet attributeSet, ModelStyle modelStyle) {
        this(context, attributeSet, 0, modelStyle);
        Intrinsics.g(context, "context");
        Intrinsics.g(modelStyle, "modelStyle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultView(Context context, ModelStyle modelStyle) {
        this(context, null, modelStyle);
        Intrinsics.g(context, "context");
        Intrinsics.g(modelStyle, "modelStyle");
    }

    public static /* synthetic */ void B(DefaultView defaultView, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        if ((i11 & 4) != 0) {
            z13 = true;
        }
        if ((i11 & 8) != 0) {
            z14 = true;
        }
        if ((i11 & 16) != 0) {
            z15 = true;
        }
        defaultView.A(z11, z12, z13, z14, z15);
    }

    public static final void x(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static final void y(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static final void z(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final void A(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        setDefaultImageViewVisibility(z11 ? 0 : 8);
        setTitleViewVisibility(z12 ? 0 : 8);
        setBtnLayoutVisibility(z13 ? 0 : 8);
        setDescViewVisibility(z14 ? 0 : 8);
        setTipOperationVisibility(z15 ? 0 : 8);
    }

    public final void setBtnBg(Drawable drawable) {
        TextView textView = this.f49512u;
        if (textView == null) {
            return;
        }
        textView.setBackground(drawable);
    }

    public final void setBtnClickListener(final View.OnClickListener onClickListener) {
        TextView textView = this.f49512u;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefaultView.x(onClickListener, view);
                }
            });
        }
    }

    public final void setBtnLayoutVisibility(int i11) {
        LinearLayout linearLayout = this.f49513v;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(i11);
    }

    public final void setBtnText(CharSequence text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f49512u;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setBtnTextColor(int i11) {
        TextView textView = this.f49512u;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setBtnVisibility(int i11) {
        TextView textView = this.f49512u;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i11);
    }

    public final void setDefaultImage(int i11) {
        TRImageView tRImageView = this.f49508q;
        if (tRImageView != null) {
            tRImageView.setImageResource(i11);
        }
    }

    public final void setDefaultImageViewVisibility(int i11) {
        TRImageView tRImageView = this.f49508q;
        if (tRImageView == null) {
            return;
        }
        tRImageView.setVisibility(i11);
    }

    public final void setDescText(CharSequence text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f49510s;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setDescTextColor(int i11) {
        TextView textView = this.f49510s;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setDescTextSize(float f11) {
        TextView textView = this.f49510s;
        if (textView == null) {
            return;
        }
        textView.setTextSize(f11);
    }

    public final void setDescViewVisibility(int i11) {
        TextView textView = this.f49510s;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i11);
    }

    public final void setLeftBtnBg(Drawable drawable) {
        TextView textView = this.f49511t;
        if (textView == null) {
            return;
        }
        textView.setBackground(drawable);
    }

    public final void setLeftBtnClickListener(final View.OnClickListener onClickListener) {
        TextView textView = this.f49511t;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefaultView.y(onClickListener, view);
                }
            });
        }
    }

    public final void setLeftBtnText(CharSequence text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f49511t;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setLeftBtnTextColor(int i11) {
        TextView textView = this.f49511t;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setLeftBtnVisibility(int i11) {
        TextView textView = this.f49511t;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i11);
    }

    public final void setStyle(DefaultViewStyle style) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.g(style, "style");
        switch (a.f49516a[style.ordinal()]) {
            case 1:
                B(this, false, false, false, false, false, 31, null);
                break;
            case 2:
                B(this, false, false, false, false, false, 27, null);
                TextView textView = this.f49510s;
                layoutParams = textView != null ? textView.getLayoutParams() : null;
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) layoutParams;
                tp.f fVar = tp.f.f77260a;
                Context context = getContext();
                Intrinsics.f(context, "context");
                ((LinearLayout.LayoutParams) aVar).bottomMargin = fVar.a(context, 16.0f);
                TextView textView2 = this.f49510s;
                if (textView2 != null) {
                    textView2.setLayoutParams(aVar);
                    break;
                }
                break;
            case 3:
                B(this, false, false, false, false, false, 25, null);
                TextView textView3 = this.f49510s;
                if (textView3 != null) {
                    textView3.setTextColor(z2.a.getColor(getContext(), R$color.cl33));
                }
                TextView textView4 = this.f49510s;
                layoutParams = textView4 != null ? textView4.getLayoutParams() : null;
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
                LinearLayoutCompat.a aVar2 = (LinearLayoutCompat.a) layoutParams;
                tp.f fVar2 = tp.f.f77260a;
                Context context2 = getContext();
                Intrinsics.f(context2, "context");
                ((LinearLayout.LayoutParams) aVar2).bottomMargin = fVar2.a(context2, 16.0f);
                TextView textView5 = this.f49510s;
                if (textView5 != null) {
                    textView5.setLayoutParams(aVar2);
                    break;
                }
                break;
            case 4:
                B(this, false, false, false, false, false, 13, null);
                TextView textView6 = this.f49510s;
                if (textView6 != null) {
                    textView6.setTextSize(14.0f);
                    break;
                }
                break;
            case 5:
                B(this, false, false, false, false, false, 30, null);
                break;
            case 6:
                B(this, false, false, false, false, false, 26, null);
                TextView textView7 = this.f49510s;
                layoutParams = textView7 != null ? textView7.getLayoutParams() : null;
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
                LinearLayoutCompat.a aVar3 = (LinearLayoutCompat.a) layoutParams;
                tp.f fVar3 = tp.f.f77260a;
                Context context3 = getContext();
                Intrinsics.f(context3, "context");
                ((LinearLayout.LayoutParams) aVar3).bottomMargin = fVar3.a(context3, 16.0f);
                TextView textView8 = this.f49510s;
                if (textView8 != null) {
                    textView8.setLayoutParams(aVar3);
                    break;
                }
                break;
            case 7:
                B(this, false, false, false, false, false, 24, null);
                TextView textView9 = this.f49510s;
                if (textView9 != null) {
                    textView9.setTextColor(z2.a.getColor(getContext(), R$color.cl33));
                }
                TextView textView10 = this.f49510s;
                layoutParams = textView10 != null ? textView10.getLayoutParams() : null;
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
                LinearLayoutCompat.a aVar4 = (LinearLayoutCompat.a) layoutParams;
                tp.f fVar4 = tp.f.f77260a;
                Context context4 = getContext();
                Intrinsics.f(context4, "context");
                ((LinearLayout.LayoutParams) aVar4).bottomMargin = fVar4.a(context4, 16.0f);
                TextView textView11 = this.f49510s;
                if (textView11 != null) {
                    textView11.setLayoutParams(aVar4);
                    break;
                }
                break;
            case 8:
                B(this, false, false, false, false, false, 24, null);
                TextView textView12 = this.f49510s;
                if (textView12 != null) {
                    textView12.setTextSize(14.0f);
                }
                TextView textView13 = this.f49510s;
                layoutParams = textView13 != null ? textView13.getLayoutParams() : null;
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
                LinearLayoutCompat.a aVar5 = (LinearLayoutCompat.a) layoutParams;
                tp.f fVar5 = tp.f.f77260a;
                Context context5 = getContext();
                Intrinsics.f(context5, "context");
                ((LinearLayout.LayoutParams) aVar5).bottomMargin = fVar5.a(context5, 16.0f);
                TextView textView14 = this.f49510s;
                if (textView14 != null) {
                    textView14.setLayoutParams(aVar5);
                    break;
                }
                break;
            case 9:
                B(this, false, false, false, false, false, 16, null);
                break;
            case 10:
                B(this, false, false, false, false, false, 9, null);
                TextView textView15 = this.f49510s;
                if (textView15 != null) {
                    textView15.setTextSize(14.0f);
                    break;
                }
                break;
            case 11:
                B(this, false, false, false, false, false, 8, null);
                TextView textView16 = this.f49510s;
                if (textView16 != null) {
                    textView16.setTextSize(14.0f);
                    break;
                }
                break;
            case 12:
                B(this, false, false, false, false, false, 12, null);
                TextView textView17 = this.f49510s;
                if (textView17 != null) {
                    textView17.setTextSize(14.0f);
                }
                TextView textView18 = this.f49510s;
                layoutParams = textView18 != null ? textView18.getLayoutParams() : null;
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
                LinearLayoutCompat.a aVar6 = (LinearLayoutCompat.a) layoutParams;
                tp.f fVar6 = tp.f.f77260a;
                Context context6 = getContext();
                Intrinsics.f(context6, "context");
                ((LinearLayout.LayoutParams) aVar6).bottomMargin = fVar6.a(context6, 16.0f);
                TextView textView19 = this.f49510s;
                if (textView19 != null) {
                    textView19.setLayoutParams(aVar6);
                    break;
                }
                break;
        }
    }

    public final void setTipOperationClickListener(final View.OnClickListener onClickListener) {
        LinearLayoutCompat linearLayoutCompat = this.f49515x;
        if (linearLayoutCompat != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefaultView.z(onClickListener, view);
                }
            });
        }
    }

    public final void setTipOperationText(CharSequence text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f49514w;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setTipOperationVisibility(int i11) {
        LinearLayoutCompat linearLayoutCompat = this.f49515x;
        if (linearLayoutCompat == null) {
            return;
        }
        linearLayoutCompat.setVisibility(i11);
    }

    public final void setTipTextColor(int i11) {
        TextView textView = this.f49514w;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setTitleText(CharSequence text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f49509r;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setTitleTextColor(int i11) {
        TextView textView = this.f49509r;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setTitleViewVisibility(int i11) {
        TextView textView = this.f49509r;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i11);
    }
}
