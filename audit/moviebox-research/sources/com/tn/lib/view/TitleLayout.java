package com.tn.lib.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$styleable;
import com.tn.lib.widget.TnTextView;
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
public final class TitleLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintLayout f49643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f49644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TnTextView f49645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f49646d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f49647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f49648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f49649h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public TitleLayout(final Context context, AttributeSet attrs) {
        int attributeResourceValue;
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.TitleLayout);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr… R.styleable.TitleLayout)");
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.TitleLayout_titleBackgroundColor, z2.a.getColor(context, R$color.bg_01));
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.TitleLayout_backIconRes, R$mipmap.libui_ic_back_black);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TitleLayout_isShowBack, true);
        int color2 = typedArrayObtainStyledAttributes.getColor(R$styleable.TitleLayout_titleTextColor, z2.a.getColor(context, R$color.text_01));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TitleLayout_titleTextSize, f0.d(16.0f));
        typedArrayObtainStyledAttributes.getString(R$styleable.TitleLayout_titleText);
        typedArrayObtainStyledAttributes.getIndex(R$styleable.TitleLayout_titleText);
        int attributeCount = attrs.getAttributeCount();
        int i11 = 0;
        while (true) {
            if (i11 >= attributeCount) {
                attributeResourceValue = 0;
                break;
            } else {
                if (Intrinsics.b(attrs.getAttributeName(i11), "titleText")) {
                    attributeResourceValue = attrs.getAttributeResourceValue(i11, 0);
                    break;
                }
                i11++;
            }
        }
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TitleLayout_showLine, true);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.TitleLayout_menuRes, R.drawable.ic_menu_add);
        int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.TitleLayout_titleGravity, 0);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(R$layout.libui_layout_title, (ViewGroup) this, true);
        this.f49643a = (ConstraintLayout) findViewById(R$id.cl_titleBar);
        this.f49644b = (ImageView) findViewById(R$id.iv_back);
        this.f49645c = (TnTextView) findViewById(R$id.tv_titleText);
        this.f49646d = (TextView) findViewById(R$id.tv_menu);
        this.f49647f = (ImageView) findViewById(R$id.iv_menu);
        this.f49648g = findViewById(R$id.view_red);
        View viewFindViewById = findViewById(R$id.view_line);
        this.f49649h = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(z12 ? 0 : 8);
        }
        ImageView imageView = this.f49647f;
        if (imageView != null) {
            imageView.setImageResource(resourceId2);
        }
        ConstraintLayout constraintLayout = this.f49643a;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(color);
        }
        ImageView imageView2 = this.f49644b;
        if (imageView2 != null) {
            imageView2.setVisibility(z11 ? 0 : 8);
            imageView2.setImageResource(resourceId);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TitleLayout.c(context, view);
                }
            });
        }
        TnTextView tnTextView = this.f49645c;
        if (tnTextView != null) {
            tnTextView.setTextColor(color2);
            tnTextView.setTextSize(0, dimensionPixelSize);
            tnTextView.setTextById(attributeResourceValue);
            tnTextView.setSelected(true);
            if (integer == 0) {
                ViewGroup.LayoutParams layoutParams = tnTextView.getLayoutParams();
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                bVar.f7319v = 0;
                bVar.setMarginStart(0);
                tnTextView.setLayoutParams(bVar);
                return;
            }
            if (integer != 1) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = tnTextView.getLayoutParams();
            Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
            bVar2.f7317u = -1;
            bVar2.setMarginStart(b(context, 48.0f));
            tnTextView.setLayoutParams(bVar2);
        }
    }

    private final int b(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final void c(Context context, View view) {
        Intrinsics.g(context, "$context");
        ((Activity) context).onBackPressed();
    }

    public final ImageView getRightImageView() {
        return this.f49647f;
    }

    public final TnTextView getTitleView() {
        return this.f49645c;
    }

    public final void goneRightViewLayout() {
        TextView textView = this.f49646d;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f49647f;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public final TitleLayout setBackIcon(int i11) {
        ImageView imageView = this.f49644b;
        if (imageView != null) {
            imageView.setImageResource(i11);
        }
        return this;
    }

    public final TitleLayout setBackVisible(boolean z11) {
        ImageView imageView = this.f49644b;
        if (imageView != null) {
            imageView.setVisibility(z11 ? 0 : 8);
        }
        return this;
    }

    public final TitleLayout setLeftOnclick(View.OnClickListener l11) {
        Intrinsics.g(l11, "l");
        ImageView imageView = this.f49644b;
        if (imageView != null) {
            imageView.setOnClickListener(l11);
        }
        return this;
    }

    public final TitleLayout setRedViewVisible(boolean z11) {
        View view = this.f49648g;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
        return this;
    }

    public final TitleLayout setRightTextSize(float f11) {
        ImageView imageView = this.f49647f;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.f49646d;
        if (textView != null) {
            textView.setTextSize(f11);
        }
        return this;
    }

    public final TitleLayout setRightView(int i11) {
        TextView textView = this.f49646d;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f49647f;
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageResource(i11);
        }
        return this;
    }

    public final TitleLayout setRightView(int i11, View.OnClickListener onClickListener) {
        Intrinsics.g(onClickListener, "onClickListener");
        TextView textView = this.f49646d;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f49647f;
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageResource(i11);
            imageView.setOnClickListener(onClickListener);
        }
        return this;
    }

    public final TitleLayout setRightView(View.OnClickListener onClickListener) {
        Intrinsics.g(onClickListener, "onClickListener");
        TextView textView = this.f49646d;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f49647f;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
        return this;
    }

    public final TitleLayout setRightView(String text) {
        Intrinsics.g(text, "text");
        ImageView imageView = this.f49647f;
        if (imageView != null) {
            TextView textView = this.f49646d;
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(text);
            }
            imageView.setVisibility(8);
        }
        return this;
    }

    public final TitleLayout setRightView(String text, int i11, View.OnClickListener onClickListener) {
        Intrinsics.g(text, "text");
        Intrinsics.g(onClickListener, "onClickListener");
        ImageView imageView = this.f49647f;
        if (imageView != null) {
            TextView textView = this.f49646d;
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(text);
                textView.setTextColor(i11);
                textView.setOnClickListener(onClickListener);
            }
            imageView.setVisibility(8);
        }
        return this;
    }

    public final TitleLayout setRightView(String text, View.OnClickListener onClickListener) {
        Intrinsics.g(text, "text");
        Intrinsics.g(onClickListener, "onClickListener");
        ImageView imageView = this.f49647f;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.f49646d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(text);
            textView.setOnClickListener(onClickListener);
        }
        return this;
    }

    public final TitleLayout setRightViewBackground(int i11) {
        ImageView imageView = this.f49647f;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.f49646d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setBackgroundColor(i11);
        }
        return this;
    }

    public final TitleLayout setRightViewColor(int i11) {
        ImageView imageView = this.f49647f;
        if (imageView != null) {
            TextView textView = this.f49646d;
            if (textView != null) {
                textView.setTextColor(i11);
            }
            imageView.setVisibility(8);
        }
        return this;
    }

    public final TitleLayout setTitleBackgroundColor(int i11) {
        ConstraintLayout constraintLayout = this.f49643a;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(i11);
        }
        return this;
    }

    public final TitleLayout setTitleText(@StringRes int i11) {
        TnTextView tnTextView = this.f49645c;
        if (tnTextView != null) {
            tnTextView.setTextById(i11);
        }
        return this;
    }

    public final TitleLayout setTitleText(String titleText) {
        Intrinsics.g(titleText, "titleText");
        TnTextView tnTextView = this.f49645c;
        if (tnTextView != null) {
            tnTextView.setTextWithString(titleText);
        }
        return this;
    }

    public final TitleLayout setTitleTextColor(int i11) {
        TnTextView tnTextView = this.f49645c;
        if (tnTextView != null) {
            tnTextView.setTextColor(i11);
        }
        return this;
    }

    public final TitleLayout setTitleTextSize(int i11) {
        TnTextView tnTextView = this.f49645c;
        if (tnTextView != null) {
            tnTextView.setTextSize(0, i11);
        }
        return this;
    }

    public final TitleLayout setViewLineVisible(boolean z11) {
        View view = this.f49649h;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
        return this;
    }
}
