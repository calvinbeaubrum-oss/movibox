package com.transsion.ad.bidding.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.bidding.banner.BiddingBuyOutBannerView;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.strategy.a;
import com.transsion.ad.strategy.e;
import com.transsion.ad.view.AdTagView;
import com.transsion.ad.view.native_ad.AbsBiddingBuyOutView;
import com.transsion.player.orplayer.f;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class BiddingBuyOutBannerView extends AbsBiddingBuyOutView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f50280k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f50281l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public BiddingBuyOutBannerView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BiddingBuyOutBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
    }

    public /* synthetic */ BiddingBuyOutBannerView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void j(BiddingBuyOutBannerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        a aVar = a.f50582a;
        AdMaterialList adMaterialList = this$0.getAdMaterialList();
        String deeplink = adMaterialList != null ? adMaterialList.getDeeplink() : null;
        AdMaterialList adMaterialList2 = this$0.getAdMaterialList();
        aVar.a(deeplink, adMaterialList2 != null ? adMaterialList2.getH5Link() : null, this$0.getAdPlans());
        this$0.onAdClick();
    }

    public static final void k(BiddingBuyOutBannerView this$0, AppCompatImageView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        f orPlayer = this$0.getOrPlayer();
        if (orPlayer == null || !orPlayer.isMute()) {
            f orPlayer2 = this$0.getOrPlayer();
            if (orPlayer2 != null) {
                orPlayer2.setMute(true);
            }
            this_apply.setImageResource(R$mipmap.ad_volumeoff);
            return;
        }
        f orPlayer3 = this$0.getOrPlayer();
        if (orPlayer3 != null) {
            orPlayer3.setMute(false);
        }
        this_apply.setImageResource(R$mipmap.ad_volumeon);
    }

    private final void setClick(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: kq.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiddingBuyOutBannerView.j(this.f69629a, view2);
                }
            });
        }
    }

    private final void setMute(View view) {
        final AppCompatImageView appCompatImageView;
        if (view == null || (appCompatImageView = (AppCompatImageView) view.findViewById(R$id.mute)) == null) {
            return;
        }
        appCompatImageView.setVisibility(this.f50280k ? 0 : 8);
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: kq.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BiddingBuyOutBannerView.k(this.f69630a, appCompatImageView, view2);
            }
        });
    }

    @Override // com.transsion.ad.view.native_ad.AbsBiddingBuyOutView
    public FrameLayout getMediaContainer() {
        return this.f50281l;
    }

    public final void i() {
        if (getAdPlans() == null) {
            jq.a listener = getListener();
            if (listener != null) {
                listener.f(new TAdErrorCode(101, "adPlans is null"), getAdPlans());
                return;
            }
            return;
        }
        View viewInflate = LayoutInflater.from(Utils.a()).inflate(R$layout.bidding_buy_out_banner_view, (ViewGroup) this, false);
        this.f50281l = (FrameLayout) viewInflate.findViewById(R$id.flAdContainer);
        setClick(viewInflate);
        setMute(viewInflate);
        AdTagView adTagView = (AdTagView) viewInflate.findViewById(R$id.adIcon);
        if (adTagView != null) {
            e.f50608a.a(adTagView);
        }
        showMedia();
        addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.transsion.ad.view.native_ad.AbsBiddingBuyOutView
    public boolean isShowVolumeIcon() {
        return true;
    }

    public final void showAd() {
        i();
    }
}
