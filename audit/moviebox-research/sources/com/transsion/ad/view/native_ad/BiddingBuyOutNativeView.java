package com.transsion.ad.view.native_ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.transsion.ad.a;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.strategy.e;
import com.transsion.ad.view.AdTagView;
import com.transsion.ad.view.native_ad.BiddingBuyOutNativeView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zq.b;
import zq.d;

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
public final class BiddingBuyOutNativeView extends AbsBiddingBuyOutView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f50673k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f50674l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public BiddingBuyOutNativeView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BiddingBuyOutNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f50674l = true;
    }

    public /* synthetic */ BiddingBuyOutNativeView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void i(BiddingBuyOutNativeView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.onAdClick();
    }

    public static final void j(BiddingBuyOutNativeView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.onAdClick();
    }

    private final void setAdAvatar(d dVar) {
        Integer numG;
        if (dVar == null || (numG = dVar.g()) == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) dVar.h().findViewById(numG.intValue());
        if (frameLayout != null) {
            Intrinsics.f(frameLayout, "findViewById<FrameLayout>(iconId)");
            frameLayout.removeAllViews();
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            AdPlans adPlans = getAdPlans();
            if (TextUtils.isEmpty(adPlans != null ? adPlans.getAdvertiserAvatarPath() : null)) {
                RequestManager requestManagerWith = Glide.with(frameLayout.getContext());
                AdPlans adPlans2 = getAdPlans();
                requestManagerWith.load2(adPlans2 != null ? adPlans2.getAdvertiserAvatar() : null).fitCenter().into(imageView);
            } else {
                RequestManager requestManagerWith2 = Glide.with(frameLayout.getContext());
                AdPlans adPlans3 = getAdPlans();
                requestManagerWith2.load2(adPlans3 != null ? adPlans3.getAdvertiserAvatarPath() : null).fitCenter().into(imageView);
            }
            frameLayout.addView(imageView);
        }
    }

    private final void setCallToAction(d dVar) {
        View viewH;
        Integer numE;
        AdMaterialList adMaterialList;
        if (dVar != null && (numE = dVar.e()) != null) {
            TextView textView = (TextView) dVar.h().findViewById(numE.intValue());
            if (textView != null) {
                Intrinsics.f(textView, "findViewById<TextView>(callToActionId)");
                AdMaterialList adMaterialList2 = getAdMaterialList();
                if (TextUtils.isEmpty(adMaterialList2 != null ? adMaterialList2.getButtonText() : null) && (adMaterialList = getAdMaterialList()) != null) {
                    adMaterialList.setButtonText("GO");
                }
                AdMaterialList adMaterialList3 = getAdMaterialList();
                textView.setText(adMaterialList3 != null ? adMaterialList3.getButtonText() : null);
                textView.setOnClickListener(new View.OnClickListener() { // from class: zq.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BiddingBuyOutNativeView.j(this.f82139a, view);
                    }
                });
            }
        }
        if (dVar == null || (viewH = dVar.h()) == null) {
            return;
        }
        viewH.setOnClickListener(new View.OnClickListener() { // from class: zq.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiddingBuyOutNativeView.i(this.f82140a, view);
            }
        });
    }

    private final void setDescription(d dVar) {
        Integer numF;
        if (dVar == null || (numF = dVar.f()) == null) {
            return;
        }
        TextView textView = (TextView) dVar.h().findViewById(numF.intValue());
        if (textView != null) {
            Intrinsics.f(textView, "findViewById<TextView>(descriptionId)");
            AdMaterialList adMaterialList = getAdMaterialList();
            textView.setText(adMaterialList != null ? adMaterialList.getDesc() : null);
        }
    }

    private final void setTitle(d dVar) {
        Integer numJ;
        if (dVar == null || (numJ = dVar.j()) == null) {
            return;
        }
        TextView textView = (TextView) dVar.h().findViewById(numJ.intValue());
        if (textView != null) {
            Intrinsics.f(textView, "findViewById<TextView>(titleId)");
            AdMaterialList adMaterialList = getAdMaterialList();
            textView.setText(adMaterialList != null ? adMaterialList.getTitle() : null);
        }
    }

    public final void bindNativeView(b bVar) {
        if (getAdPlans() == null || bVar == null) {
            return;
        }
        d dVarG = bVar.g();
        this.f50673k = dVarG;
        this.f50674l = bVar.A();
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && activity.isDestroyed()) {
            a.f50276a.I(getClassTag() + " --> 当前Activity销毁，广告就不需要展示了", false);
            return;
        }
        setTitle(dVarG);
        setDescription(dVarG);
        setCallToAction(dVarG);
        setAdAvatar(dVarG);
        showMedia();
        AdMaterialList adMaterialList = getAdMaterialList();
        if (Intrinsics.b(adMaterialList != null ? adMaterialList.getType() : null, AdMaterialList.NON_AD_TYPE_TEXT)) {
            k(dVarG);
        }
        Integer numC = dVarG.c();
        if (numC != null) {
            AdTagView adTagView = (AdTagView) dVarG.h().findViewById(numC.intValue());
            if (adTagView != null) {
                Intrinsics.f(adTagView, "findViewById<AdTagView>(adTagId)");
                e.f50608a.a(adTagView);
            }
        }
        removeAllViews();
        addView(dVarG.h(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.transsion.ad.view.native_ad.AbsBiddingBuyOutView
    public FrameLayout getMediaContainer() {
        Integer numI;
        View viewH;
        d dVar = this.f50673k;
        if (dVar == null || (numI = dVar.i()) == null) {
            return null;
        }
        int iIntValue = numI.intValue();
        d dVar2 = this.f50673k;
        if (dVar2 == null || (viewH = dVar2.h()) == null) {
            return null;
        }
        return (FrameLayout) viewH.findViewById(iIntValue);
    }

    @Override // com.transsion.ad.view.native_ad.AbsBiddingBuyOutView
    public boolean isShowVolumeIcon() {
        return this.f50674l;
    }

    public final void k(d dVar) {
        Integer numD;
        MbAdImage image;
        MbAdImage image2;
        MbAdImage image3;
        if (dVar == null || (numD = dVar.d()) == null) {
            return;
        }
        ImageView imageView = (ImageView) dVar.h().findViewById(numD.intValue());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        AdMaterialList adMaterialList = getAdMaterialList();
        String path = null;
        if (TextUtils.isEmpty((adMaterialList == null || (image3 = adMaterialList.getImage()) == null) ? null : image3.getPath())) {
            AdMaterialList adMaterialList2 = getAdMaterialList();
            if (adMaterialList2 != null && (image2 = adMaterialList2.getImage()) != null) {
                path = image2.getUrl();
            }
        } else {
            AdMaterialList adMaterialList3 = getAdMaterialList();
            if (adMaterialList3 != null && (image = adMaterialList3.getImage()) != null) {
                path = image.getPath();
            }
        }
        Glide.with(getContext()).load2(path).transform(new yq.a(25)).into(imageView);
    }
}
