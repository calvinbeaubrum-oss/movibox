package com.transsion.baseui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.b;
import androidx.dynamicanimation.animation.d;
import com.blankj.utilcode.util.k0;
import com.noober.background.view.BLTextView;
import com.transsion.baseui.R$anim;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.R$layout;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.widget.ResourcesRequestView;
import fs.f;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import so.c;

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
public final class ResourcesRequestView extends FrameLayout implements Animation.AnimationListener {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f51515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Animation f51516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f51517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f51518d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f51519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DrawableCenterTextView f51520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f51521h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            f mViewBinding;
            TextView textView;
            f mViewBinding2;
            TextView textView2;
            DrawableCenterTextView drawableCenterTextView;
            ViewTreeObserver viewTreeObserver;
            f mViewBinding3 = ResourcesRequestView.this.getMViewBinding();
            if (mViewBinding3 != null && (drawableCenterTextView = mViewBinding3.f65283f) != null && (viewTreeObserver = drawableCenterTextView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            f mViewBinding4 = ResourcesRequestView.this.getMViewBinding();
            DrawableCenterTextView drawableCenterTextView2 = mViewBinding4 != null ? mViewBinding4.f65283f : null;
            if (drawableCenterTextView2 == null || drawableCenterTextView2.getMeasuredWidth() == 0) {
                return;
            }
            TextPaint paint = drawableCenterTextView2.getPaint();
            Intrinsics.d(paint);
            float fMeasureText = paint.measureText(drawableCenterTextView2.getText().toString());
            int compoundDrawablePadding = drawableCenterTextView2.getCompoundDrawablePadding();
            Drawable[] compoundDrawables = drawableCenterTextView2.getCompoundDrawables();
            Intrinsics.f(compoundDrawables, "centerTextView.compoundDrawables");
            if (ResourcesRequestView.this.f51521h) {
                Drawable drawable = compoundDrawables[0];
                if (drawable == null || (mViewBinding2 = ResourcesRequestView.this.getMViewBinding()) == null || (textView2 = mViewBinding2.f65284g) == null) {
                    return;
                }
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int i11 = (int) (compoundDrawablePadding + intrinsicWidth + fMeasureText);
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = ((drawableCenterTextView2.getMeasuredWidth() / 2) + (i11 / 2)) - (intrinsicWidth / 3);
                textView2.setLayoutParams(bVar);
                return;
            }
            Drawable drawable2 = compoundDrawables[2];
            if (drawable2 == null || (mViewBinding = ResourcesRequestView.this.getMViewBinding()) == null || (textView = mViewBinding.f65284g) == null) {
                return;
            }
            int intrinsicWidth2 = drawable2.getIntrinsicWidth();
            int i12 = (int) (compoundDrawablePadding + intrinsicWidth2 + fMeasureText);
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
            ((ViewGroup.MarginLayoutParams) bVar2).leftMargin = ((drawableCenterTextView2.getMeasuredWidth() / 2) + (i12 / 2)) - (intrinsicWidth2 / 3);
            textView.setLayoutParams(bVar2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResourcesRequestView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResourcesRequestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourcesRequestView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f51518d = new Handler(Looper.getMainLooper());
        this.f51521h = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 0;
        b();
    }

    public static final void c(ResourcesRequestView this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f51521h) {
            DrawableCenterTextView drawableCenterTextView = this$0.f51520g;
            if (drawableCenterTextView != null) {
                drawableCenterTextView.setCompoundDrawablesWithIntrinsicBounds(R$mipmap.ic_alert, 0, 0, 0);
            }
        } else {
            DrawableCenterTextView drawableCenterTextView2 = this$0.f51520g;
            if (drawableCenterTextView2 != null) {
                drawableCenterTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$mipmap.ic_alert, 0);
            }
        }
        d dVar = this$0.f51517c;
        d dVar2 = null;
        if (dVar == null) {
            Intrinsics.y("springAnimation");
            dVar = null;
        }
        dVar.l(0.0f);
        d dVar3 = this$0.f51517c;
        if (dVar3 == null) {
            Intrinsics.y("springAnimation");
        } else {
            dVar2 = dVar3;
        }
        dVar2.i();
    }

    public static /* synthetic */ void setCount$default(ResourcesRequestView resourcesRequestView, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = true;
        }
        resourcesRequestView.setCount(i11, z11);
    }

    public final void b() {
        DrawableCenterTextView drawableCenterTextView;
        ViewTreeObserver viewTreeObserver;
        Context context;
        int i11;
        View.inflate(getContext(), R$layout.resources_request, this);
        f fVarA = f.a(this);
        this.f51515a = fVarA;
        this.f51520g = fVarA != null ? fVarA.f65283f : null;
        this.f51519f = fVarA != null ? fVarA.f65284g : null;
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.num_text_enter);
        Intrinsics.f(animationLoadAnimation, "loadAnimation(context, R.anim.num_text_enter)");
        this.f51516b = animationLoadAnimation;
        if (animationLoadAnimation == null) {
            Intrinsics.y("showTextAnim");
            animationLoadAnimation = null;
        }
        animationLoadAnimation.setDuration(200L);
        Animation animation = this.f51516b;
        if (animation == null) {
            Intrinsics.y("showTextAnim");
            animation = null;
        }
        animation.setAnimationListener(this);
        TextView textView = this.f51519f;
        if (textView != null) {
            c.h(textView);
        }
        f fVar = this.f51515a;
        d dVar = new d(fVar != null ? fVar.f65284g : null, b.f8238n, 0.0f);
        dVar.n().d(0.75f);
        dVar.n().f(200.0f);
        this.f51517c = dVar;
        TextView textView2 = this.f51519f;
        if (textView2 != null) {
            if (this.f51521h) {
                context = textView2.getContext();
                i11 = R$drawable.bg_num_text_6dp_bottom_right;
            } else {
                context = textView2.getContext();
                i11 = R$drawable.bg_num_text_6dp_bottom_left;
            }
            textView2.setBackground(d1.a.b(context, i11));
        }
        f fVar2 = this.f51515a;
        if (fVar2 == null || (drawableCenterTextView = fVar2.f65283f) == null || (viewTreeObserver = drawableCenterTextView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new a());
    }

    public final void d() {
        BLTextView bLTextView;
        TextView textView;
        f fVar = this.f51515a;
        if (fVar != null && (textView = fVar.f65280b) != null) {
            c.g(textView);
        }
        f fVar2 = this.f51515a;
        if (fVar2 == null || (bLTextView = fVar2.f65281c) == null) {
            return;
        }
        c.k(bLTextView);
    }

    public final DrawableCenterTextView getIvCenterView() {
        return this.f51520g;
    }

    public final f getMViewBinding() {
        return this.f51515a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        d dVar = this.f51517c;
        d dVar2 = null;
        if (dVar == null) {
            Intrinsics.y("springAnimation");
            dVar = null;
        }
        dVar.l(1.0f);
        d dVar3 = this.f51517c;
        if (dVar3 == null) {
            Intrinsics.y("springAnimation");
        } else {
            dVar2 = dVar3;
        }
        dVar2.i();
        this.f51518d.postDelayed(new Runnable() { // from class: is.e
            @Override // java.lang.Runnable
            public final void run() {
                ResourcesRequestView.c(this.f67698a);
            }
        }, 100L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        TextView textView = this.f51519f;
        if (textView != null) {
            c.k(textView);
        }
        k0.b(100L);
        if (this.f51521h) {
            DrawableCenterTextView drawableCenterTextView = this.f51520g;
            if (drawableCenterTextView != null) {
                drawableCenterTextView.setCompoundDrawablesWithIntrinsicBounds(R$mipmap.ic_alert_highlight, 0, 0, 0);
                return;
            }
            return;
        }
        DrawableCenterTextView drawableCenterTextView2 = this.f51520g;
        if (drawableCenterTextView2 != null) {
            drawableCenterTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$mipmap.ic_alert_highlight, 0);
        }
    }

    public final void set(String title) {
        Intrinsics.g(title, "title");
        f fVar = this.f51515a;
        TextView textView = fVar != null ? fVar.f65282d : null;
        if (textView == null) {
            return;
        }
        textView.setText(title);
    }

    public final void setCount(int i11, boolean z11) {
        TextView textView = this.f51519f;
        if (textView != null) {
            textView.setText("+" + i11);
        }
        if (z11) {
            TextView textView2 = this.f51519f;
            if (textView2 != null) {
                Animation animation = this.f51516b;
                if (animation == null) {
                    Intrinsics.y("showTextAnim");
                    animation = null;
                }
                textView2.startAnimation(animation);
            }
            d();
            return;
        }
        if (i11 == 0) {
            TextView textView3 = this.f51519f;
            if (textView3 != null) {
                c.h(textView3);
                return;
            }
            return;
        }
        TextView textView4 = this.f51519f;
        if (textView4 != null) {
            c.k(textView4);
        }
    }

    public final void setGray(boolean z11) {
    }

    public final void setIvCenterView(DrawableCenterTextView drawableCenterTextView) {
        this.f51520g = drawableCenterTextView;
    }

    public final void setMViewBinding(f fVar) {
        this.f51515a = fVar;
    }
}
