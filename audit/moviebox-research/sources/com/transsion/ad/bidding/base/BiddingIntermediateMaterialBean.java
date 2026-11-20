package com.transsion.ad.bidding.base;

import android.view.View;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.monopoly.model.AdPlans;
import java.io.Serializable;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class BiddingIntermediateMaterialBean implements Serializable {
    private View bannerView;
    private final Double ecpm;
    private final kq.d hiSavanaBannerProvider;
    private final AbsBiddingInterceptHiSavanaAdManager hiSavanaInterceptProvider;
    private boolean isExpend;
    private final TAdNativeInfo nativeInfo;
    private final AdPlans plans;

    public BiddingIntermediateMaterialBean() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    public BiddingIntermediateMaterialBean(Double d11, AdPlans adPlans, TAdNativeInfo tAdNativeInfo, kq.d dVar, View view, AbsBiddingInterceptHiSavanaAdManager absBiddingInterceptHiSavanaAdManager, boolean z11) {
        this.ecpm = d11;
        this.plans = adPlans;
        this.nativeInfo = tAdNativeInfo;
        this.hiSavanaBannerProvider = dVar;
        this.bannerView = view;
        this.hiSavanaInterceptProvider = absBiddingInterceptHiSavanaAdManager;
        this.isExpend = z11;
    }

    public /* synthetic */ BiddingIntermediateMaterialBean(Double d11, AdPlans adPlans, TAdNativeInfo tAdNativeInfo, kq.d dVar, View view, AbsBiddingInterceptHiSavanaAdManager absBiddingInterceptHiSavanaAdManager, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : d11, (i11 & 2) != 0 ? null : adPlans, (i11 & 4) != 0 ? null : tAdNativeInfo, (i11 & 8) != 0 ? null : dVar, (i11 & 16) != 0 ? null : view, (i11 & 32) == 0 ? absBiddingInterceptHiSavanaAdManager : null, (i11 & 64) != 0 ? false : z11);
    }

    public static /* synthetic */ BiddingIntermediateMaterialBean copy$default(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, Double d11, AdPlans adPlans, TAdNativeInfo tAdNativeInfo, kq.d dVar, View view, AbsBiddingInterceptHiSavanaAdManager absBiddingInterceptHiSavanaAdManager, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = biddingIntermediateMaterialBean.ecpm;
        }
        if ((i11 & 2) != 0) {
            adPlans = biddingIntermediateMaterialBean.plans;
        }
        AdPlans adPlans2 = adPlans;
        if ((i11 & 4) != 0) {
            tAdNativeInfo = biddingIntermediateMaterialBean.nativeInfo;
        }
        TAdNativeInfo tAdNativeInfo2 = tAdNativeInfo;
        if ((i11 & 8) != 0) {
            dVar = biddingIntermediateMaterialBean.hiSavanaBannerProvider;
        }
        kq.d dVar2 = dVar;
        if ((i11 & 16) != 0) {
            view = biddingIntermediateMaterialBean.bannerView;
        }
        View view2 = view;
        if ((i11 & 32) != 0) {
            absBiddingInterceptHiSavanaAdManager = biddingIntermediateMaterialBean.hiSavanaInterceptProvider;
        }
        AbsBiddingInterceptHiSavanaAdManager absBiddingInterceptHiSavanaAdManager2 = absBiddingInterceptHiSavanaAdManager;
        if ((i11 & 64) != 0) {
            z11 = biddingIntermediateMaterialBean.isExpend;
        }
        return biddingIntermediateMaterialBean.copy(d11, adPlans2, tAdNativeInfo2, dVar2, view2, absBiddingInterceptHiSavanaAdManager2, z11);
    }

    public final Double component1() {
        return this.ecpm;
    }

    public final AdPlans component2() {
        return this.plans;
    }

    public final TAdNativeInfo component3() {
        return this.nativeInfo;
    }

    public final kq.d component4() {
        return this.hiSavanaBannerProvider;
    }

    public final View component5() {
        return this.bannerView;
    }

    public final AbsBiddingInterceptHiSavanaAdManager component6() {
        return this.hiSavanaInterceptProvider;
    }

    public final boolean component7() {
        return this.isExpend;
    }

    public final BiddingIntermediateMaterialBean copy(Double d11, AdPlans adPlans, TAdNativeInfo tAdNativeInfo, kq.d dVar, View view, AbsBiddingInterceptHiSavanaAdManager absBiddingInterceptHiSavanaAdManager, boolean z11) {
        return new BiddingIntermediateMaterialBean(d11, adPlans, tAdNativeInfo, dVar, view, absBiddingInterceptHiSavanaAdManager, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BiddingIntermediateMaterialBean)) {
            return false;
        }
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) obj;
        return Intrinsics.b(this.ecpm, biddingIntermediateMaterialBean.ecpm) && Intrinsics.b(this.plans, biddingIntermediateMaterialBean.plans) && Intrinsics.b(this.nativeInfo, biddingIntermediateMaterialBean.nativeInfo) && Intrinsics.b(this.hiSavanaBannerProvider, biddingIntermediateMaterialBean.hiSavanaBannerProvider) && Intrinsics.b(this.bannerView, biddingIntermediateMaterialBean.bannerView) && Intrinsics.b(this.hiSavanaInterceptProvider, biddingIntermediateMaterialBean.hiSavanaInterceptProvider) && this.isExpend == biddingIntermediateMaterialBean.isExpend;
    }

    public final View getBannerView() {
        return this.bannerView;
    }

    public final Double getEcpm() {
        return this.ecpm;
    }

    public final kq.d getHiSavanaBannerProvider() {
        return this.hiSavanaBannerProvider;
    }

    public final AbsBiddingInterceptHiSavanaAdManager getHiSavanaInterceptProvider() {
        return this.hiSavanaInterceptProvider;
    }

    public final TAdNativeInfo getNativeInfo() {
        return this.nativeInfo;
    }

    public final AdPlans getPlans() {
        return this.plans;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Double d11 = this.ecpm;
        int iHashCode = (d11 == null ? 0 : d11.hashCode()) * 31;
        AdPlans adPlans = this.plans;
        int iHashCode2 = (iHashCode + (adPlans == null ? 0 : adPlans.hashCode())) * 31;
        TAdNativeInfo tAdNativeInfo = this.nativeInfo;
        int iHashCode3 = (iHashCode2 + (tAdNativeInfo == null ? 0 : tAdNativeInfo.hashCode())) * 31;
        kq.d dVar = this.hiSavanaBannerProvider;
        int iHashCode4 = (iHashCode3 + (dVar == null ? 0 : dVar.hashCode())) * 31;
        View view = this.bannerView;
        int iHashCode5 = (iHashCode4 + (view == null ? 0 : view.hashCode())) * 31;
        AbsBiddingInterceptHiSavanaAdManager absBiddingInterceptHiSavanaAdManager = this.hiSavanaInterceptProvider;
        int iHashCode6 = (iHashCode5 + (absBiddingInterceptHiSavanaAdManager != null ? absBiddingInterceptHiSavanaAdManager.hashCode() : 0)) * 31;
        boolean z11 = this.isExpend;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode6 + r11;
    }

    public final boolean isExpend() {
        return this.isExpend;
    }

    public final void setBannerView(View view) {
        this.bannerView = view;
    }

    public final void setExpend(boolean z11) {
        this.isExpend = z11;
    }

    public String toString() {
        return "BiddingIntermediateMaterialBean(ecpm=" + this.ecpm + ", plans=" + this.plans + ", nativeInfo=" + this.nativeInfo + ", hiSavanaBannerProvider=" + this.hiSavanaBannerProvider + ", bannerView=" + this.bannerView + ", hiSavanaInterceptProvider=" + this.hiSavanaInterceptProvider + ", isExpend=" + this.isExpend + ")";
    }
}
