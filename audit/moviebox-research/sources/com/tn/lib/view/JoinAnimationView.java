package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
import com.tn.lib.widget.R$mipmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class JoinAnimationView extends FrameLayout {
    public static final int BUTTON_STATE_JOINED = 3;
    public static final int BUTTON_STATE_JOIN_ING = 2;
    public static final int BUTTON_STATE_NOT_TO_JOIN = 1;
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f49551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f49552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f49553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintLayout f49554d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f49555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49556g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        this.f49551a = new Function0<Unit>() { // from class: com.tn.lib.view.JoinAnimationView$changeListener$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.setVisibility(8);
            }
        };
        this.f49555f = new Runnable() { // from class: com.tn.lib.view.i
            @Override // java.lang.Runnable
            public final void run() {
                JoinAnimationView.e(this.f49891a);
            }
        };
        this.f49556g = 1;
        c();
    }

    public static final void e(JoinAnimationView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f49551a.invoke();
    }

    public static final void f(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R$layout.view_join_in_layout, this);
        this.f49552b = (TextView) findViewById(R$id.tvTitle);
        this.f49553c = (ImageView) findViewById(R$id.ivLoading);
        this.f49554d = (ConstraintLayout) findViewById(R$id.rootView);
    }

    public final void d(int i11) {
        CenterInside centerInside = new CenterInside();
        RequestBuilder requestBuilderOptionalTransform = Glide.with(getContext().getApplicationContext()).load2(Integer.valueOf(i11)).optionalTransform(centerInside).optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(centerInside));
        ImageView imageView = this.f49553c;
        Intrinsics.d(imageView);
        requestBuilderOptionalTransform.into(imageView);
    }

    public final int getCurrentState() {
        return this.f49556g;
    }

    public final void setChangeListener(Function0<Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f49551a = listener;
    }

    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i11, int i12, int i13, int i14) {
        TextView textView = this.f49552b;
        if (textView != null) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i11, i12, i13, i14);
        }
    }

    public final void setCurrentState(int i11) {
        this.f49556g = i11;
    }

    public final void setJoinBackgroundResource(int i11) {
        ConstraintLayout constraintLayout = this.f49554d;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundResource(i11);
        }
    }

    public final void setJoinWH(int i11, int i12) {
        ConstraintLayout constraintLayout = this.f49554d;
        ViewGroup.LayoutParams layoutParams = constraintLayout != null ? constraintLayout.getLayoutParams() : null;
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.width = i11;
        }
        if (layoutParams2 != null) {
            layoutParams2.height = i12;
        }
        ConstraintLayout constraintLayout2 = this.f49554d;
        if (constraintLayout2 == null) {
            return;
        }
        constraintLayout2.setLayoutParams(layoutParams2);
    }

    public final void setTextColor(int i11) {
        TextView textView = this.f49552b;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public final void setTextSize(float f11) {
        TextView textView = this.f49552b;
        if (textView == null) {
            return;
        }
        textView.setTextSize(f11);
    }

    public final void setTitle(String title) {
        Intrinsics.g(title, "title");
        TextView textView = this.f49552b;
        if (textView == null) {
            return;
        }
        textView.setText(title);
    }

    public final void upDateState(int i11) {
        final Function0<Unit> function0 = this.f49551a;
        removeCallbacks(new Runnable() { // from class: com.tn.lib.view.h
            @Override // java.lang.Runnable
            public final void run() {
                JoinAnimationView.f(function0);
            }
        });
        this.f49556g = i11;
        if (i11 == 1) {
            TextView textView = this.f49552b;
            if (textView != null) {
                textView.setVisibility(0);
            }
            ImageView imageView = this.f49553c;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(4);
            return;
        }
        if (i11 != 2) {
            if (i11 != 3) {
                return;
            }
            postDelayed(this.f49555f, 1000L);
            d(R$mipmap.join_right);
            return;
        }
        ImageView imageView2 = this.f49553c;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        TextView textView2 = this.f49552b;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        d(R$mipmap.loading_2_red);
    }
}
