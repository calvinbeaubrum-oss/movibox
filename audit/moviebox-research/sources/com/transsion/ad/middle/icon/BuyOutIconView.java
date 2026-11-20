package com.transsion.ad.middle.icon;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.ad.strategy.MeasureManager;
import com.transsion.ad.view.AbsBuyOutNativeView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

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
public final class BuyOutIconView extends AbsBuyOutNativeView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.ad.strategy.c f50420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecommendInfo f50421g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public BuyOutIconView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BuyOutIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
    }

    public /* synthetic */ BuyOutIconView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final void e() {
        WrapperAdListener mCallback = getMCallback();
        if (mCallback != null) {
            mCallback.onMbIconShow(this.f50421g);
        }
    }

    public static final void h(BuyOutIconView this$0, String sceneId, RecommendInfo recommendInfo, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(sceneId, "$sceneId");
        this$0.c(sceneId, recommendInfo);
    }

    public static final void i(BuyOutIconView this$0, String sceneId, RecommendInfo recommendInfo, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(sceneId, "$sceneId");
        this$0.c(sceneId, recommendInfo);
    }

    @Override // com.transsion.ad.view.AbsBuyOutNativeView
    public void adShowTime() {
    }

    public final void bindNativeView(RecommendInfo recommendInfo, com.transsion.ad.strategy.c cVar) {
        if (recommendInfo == null || cVar == null) {
            return;
        }
        this.f50421g = recommendInfo;
        this.f50420f = cVar;
        g(getSceneId(), cVar, recommendInfo);
        removeAllViews();
        addView(cVar.f(), new FrameLayout.LayoutParams(-1, -1));
        MeasureManager.f50573a.g(this);
    }

    public final void c(String str, RecommendInfo recommendInfo) {
        d();
        com.transsion.ad.ps.b.f50555a.a(recommendInfo, true, str);
    }

    public final void clickAd() {
        View viewF;
        com.transsion.ad.strategy.c cVar = this.f50420f;
        if (cVar == null || (viewF = cVar.f()) == null) {
            return;
        }
        viewF.performClick();
    }

    public final void d() {
        WrapperAdListener mCallback = getMCallback();
        if (mCallback != null) {
            mCallback.onMbIconClick(this.f50421g);
        }
    }

    public final void destroy() {
        removeAllViews();
        MeasureManager.f50573a.p(this);
        setMCallback(null);
    }

    @Override // com.transsion.ad.view.AbsBuyOutNativeView
    public void display() {
        e();
    }

    public final void f(com.transsion.ad.strategy.c cVar, RecommendInfo recommendInfo) {
        Integer numB;
        if (cVar == null || (numB = cVar.b()) == null) {
            return;
        }
        ImageView imageView = (ImageView) cVar.f().findViewById(numB.intValue());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(getContext()).load2(recommendInfo != null ? recommendInfo.getIconUrl() : null).transform(new yq.a(25)).into(imageView);
    }

    public final void g(final String str, com.transsion.ad.strategy.c cVar, final RecommendInfo recommendInfo) throws InterruptedException {
        View viewF;
        Integer numH;
        ItemDetail detail;
        Integer numC;
        Integer numD;
        ItemDetail detail2;
        Integer numI;
        ItemDetail detail3;
        Context context = getContext();
        String star = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !activity.isDestroyed()) {
            if (cVar != null && (numI = cVar.i()) != null) {
                TextView textView = (TextView) cVar.f().findViewById(numI.intValue());
                if (textView != null) {
                    Intrinsics.f(textView, "findViewById<TextView>(titleId)");
                    textView.setText((recommendInfo == null || (detail3 = recommendInfo.getDetail()) == null) ? null : detail3.getName());
                }
            }
            if (cVar != null && (numD = cVar.d()) != null) {
                TextView textView2 = (TextView) cVar.f().findViewById(numD.intValue());
                if (textView2 != null) {
                    Intrinsics.f(textView2, "findViewById<TextView>(descriptionId)");
                    textView2.setText((recommendInfo == null || (detail2 = recommendInfo.getDetail()) == null) ? null : detail2.getSimpleDescription());
                }
            }
            if (cVar != null && (numC = cVar.c()) != null) {
                TextView textView3 = (TextView) cVar.f().findViewById(numC.intValue());
                if (textView3 != null) {
                    Intrinsics.f(textView3, "findViewById<TextView>(callToActionId)");
                    textView3.setText(recommendInfo != null ? recommendInfo.getButtonText() : null);
                    if (TextUtils.isEmpty(recommendInfo != null ? recommendInfo.getButtonText() : null)) {
                        textView3.setVisibility(8);
                    }
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.icon.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BuyOutIconView.h(this.f50422a, str, recommendInfo, view);
                        }
                    });
                }
            }
            i.b(null, new BuyOutIconView$showData$4(cVar, recommendInfo, null), 1, null);
            if (cVar != null && (numH = cVar.h()) != null) {
                TextView textView4 = (TextView) cVar.f().findViewById(numH.intValue());
                if (textView4 != null) {
                    Intrinsics.f(textView4, "findViewById<TextView>(ratingId)");
                    if (recommendInfo != null && (detail = recommendInfo.getDetail()) != null) {
                        star = detail.getStar();
                    }
                    textView4.setText(star);
                }
            }
            if (cVar != null && (viewF = cVar.f()) != null) {
                viewF.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.icon.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BuyOutIconView.i(this.f50425a, str, recommendInfo, view);
                    }
                });
            }
            j(cVar, recommendInfo);
            f(cVar, recommendInfo);
        }
    }

    public final void j(com.transsion.ad.strategy.c cVar, RecommendInfo recommendInfo) {
        Integer numE;
        if (cVar == null || (numE = cVar.e()) == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) cVar.f().findViewById(numE.intValue());
        if (frameLayout != null) {
            Intrinsics.f(frameLayout, "findViewById<FrameLayout>(iconId)");
            frameLayout.removeAllViews();
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Glide.with(frameLayout.getContext()).load2(recommendInfo != null ? recommendInfo.getIconUrl() : null).into(imageView);
            frameLayout.addView(imageView);
        }
    }
}
