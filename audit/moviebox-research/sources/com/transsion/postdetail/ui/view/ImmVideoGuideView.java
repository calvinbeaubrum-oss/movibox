package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tn.lib.view.CustomLottieAnimationView;
import com.transsion.baseui.R$color;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
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
public final class ImmVideoGuideView extends LinearLayout {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LottieAnimationView f55968a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImmVideoGuideView a(ViewGroup parentView) {
            Intrinsics.g(parentView, "parentView");
            Context context = parentView.getContext();
            Intrinsics.f(context, "parentView.context");
            ImmVideoGuideView immVideoGuideView = new ImmVideoGuideView(context);
            parentView.addView(immVideoGuideView, new ViewGroup.LayoutParams(-1, -1));
            return immVideoGuideView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmVideoGuideView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmVideoGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmVideoGuideView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        a();
    }

    public final void a() {
        setBackgroundColor(z2.a.getColor(getContext(), R$color.base_black_30_p));
        setGravity(17);
        setOrientation(1);
        View.inflate(getContext(), R$layout.layout_post_imm_video_guide, this);
        View viewFindViewById = findViewById(R$id.lav_guide);
        CustomLottieAnimationView customLottieAnimationView = (CustomLottieAnimationView) viewFindViewById;
        customLottieAnimationView.setRepeatCount(-1);
        customLottieAnimationView.playAnimation();
        this.f55968a = (LottieAnimationView) viewFindViewById;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        LottieAnimationView lottieAnimationView;
        super.onAttachedToWindow();
        LottieAnimationView lottieAnimationView2 = this.f55968a;
        Boolean boolValueOf = lottieAnimationView2 != null ? Boolean.valueOf(lottieAnimationView2.isAnimating()) : null;
        Intrinsics.d(boolValueOf);
        if (boolValueOf.booleanValue() || (lottieAnimationView = this.f55968a) == null) {
            return;
        }
        lottieAnimationView.playAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LottieAnimationView lottieAnimationView = this.f55968a;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.g(event, "event");
        if (event.getAction() != 0) {
            return super.onTouchEvent(event);
        }
        removeGuide();
        return true;
    }

    public final void removeGuide() {
        if (getParent() != null) {
            ViewParent parent = getParent();
            Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
        LottieAnimationView lottieAnimationView = this.f55968a;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
    }
}
