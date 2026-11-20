package com.tn.lib.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public final class LoadingAnimView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CustomLottieAnimationView f49557a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingAnimView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingAnimView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        LayoutInflater.from(context).inflate(R$layout.libui_anim_loading, (ViewGroup) this, true);
        this.f49557a = (CustomLottieAnimationView) findViewById(R$id.loading_anim);
    }

    public final void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        CustomLottieAnimationView customLottieAnimationView = this.f49557a;
        if (customLottieAnimationView != null) {
            customLottieAnimationView.addAnimatorListener(animatorListener);
        }
    }

    public final void cancelAnimation() {
        setVisibility(8);
        CustomLottieAnimationView customLottieAnimationView = this.f49557a;
        if (customLottieAnimationView != null) {
            customLottieAnimationView.cancelAnimation();
        }
    }

    public final CustomLottieAnimationView getMLoadingView() {
        return this.f49557a;
    }

    public final void playAnimation() {
        setVisibility(0);
        CustomLottieAnimationView customLottieAnimationView = this.f49557a;
        if (customLottieAnimationView != null) {
            customLottieAnimationView.playAnimation();
        }
    }

    public final void setMLoadingView(CustomLottieAnimationView customLottieAnimationView) {
        this.f49557a = customLottieAnimationView;
    }
}
