package com.transsion.ad.view.native_ad;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.TAdNativeView;
import com.hisavana.mediation.ad.TNativeAd;
import com.hisavana.mediation.ad.ViewBinder;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider;
import com.transsion.ad.bidding.nativead.c;
import com.transsion.ad.monopoly.model.AdPlans;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
public final class NativeWrapperAdView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BiddingBuyOutNativeView f50675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TAdNativeView f50676b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public NativeWrapperAdView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeWrapperAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
    }

    public /* synthetic */ NativeWrapperAdView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final String getClassTag() {
        String simpleName = NativeWrapperAdView.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(c cVar, b bVar) {
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP;
        AdPlans plans = 0;
        plans = 0;
        if (this.f50675a == null) {
            Context context = getContext();
            Intrinsics.f(context, "context");
            BiddingBuyOutNativeView biddingBuyOutNativeView = new BiddingBuyOutNativeView(context, plans, 2, plans);
            this.f50675a = biddingBuyOutNativeView;
            addView(biddingBuyOutNativeView);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView2 = this.f50675a;
        if (biddingBuyOutNativeView2 != null) {
            if (cVar != null && (biddingIntermediateMaterialBeanP = cVar.P()) != null) {
                plans = biddingIntermediateMaterialBeanP.getPlans();
            }
            biddingBuyOutNativeView2.setAdPlans(plans);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView3 = this.f50675a;
        if (biddingBuyOutNativeView3 != null) {
            biddingBuyOutNativeView3.bindNativeView(bVar);
        }
        BiddingBuyOutNativeView biddingBuyOutNativeView4 = this.f50675a;
        if (biddingBuyOutNativeView4 != null) {
            biddingBuyOutNativeView4.setListener(cVar);
        }
        if (cVar != null) {
            cVar.o0(this.f50675a);
        }
    }

    public final void b(c cVar, b bVar) {
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP;
        if (this.f50676b == null) {
            TAdNativeView tAdNativeView = new TAdNativeView(getContext());
            this.f50676b = tAdNativeView;
            addView(tAdNativeView);
        }
        if (cVar != null) {
            cVar.p0(this.f50676b);
        }
        try {
            Result.Companion companion = Result.Companion;
            TAdNativeInfo nativeInfo = (cVar == null || (biddingIntermediateMaterialBeanP = cVar.P()) == null) ? null : biddingIntermediateMaterialBeanP.getNativeInfo();
            if (this.f50676b != null && bVar != null && nativeInfo != null) {
                d dVarG = bVar.g();
                BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP2 = cVar.P();
                ViewBinder viewBinderQ = bVar.q(dVarG, biddingIntermediateMaterialBeanP2 != null ? biddingIntermediateMaterialBeanP2.getNativeInfo() : null);
                BiddingHiSavanaNativeProvider biddingHiSavanaNativeProviderB = BiddingHiSavanaNativeProvider.f50344g.b(cVar.Q());
                TNativeAd tNativeAdE = biddingHiSavanaNativeProviderB != null ? biddingHiSavanaNativeProviderB.e() : null;
                if (tNativeAdE != null) {
                    TAdNativeView tAdNativeView2 = this.f50676b;
                    Intrinsics.d(tAdNativeView2);
                    tNativeAdE.bindNativeView(tAdNativeView2, nativeInfo, viewBinderQ);
                }
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void bindNativeView(c cVar, b bVar) {
        if (cVar == null || bVar == null) {
            return;
        }
        if (c(cVar)) {
            b(cVar, bVar);
            BiddingBuyOutNativeView biddingBuyOutNativeView = this.f50675a;
            if (biddingBuyOutNativeView != null) {
                biddingBuyOutNativeView.setVisibility(8);
            }
            TAdNativeView tAdNativeView = this.f50676b;
            if (tAdNativeView == null) {
                return;
            }
            tAdNativeView.setVisibility(0);
            return;
        }
        a(cVar, bVar);
        BiddingBuyOutNativeView biddingBuyOutNativeView2 = this.f50675a;
        if (biddingBuyOutNativeView2 != null) {
            biddingBuyOutNativeView2.setVisibility(0);
        }
        TAdNativeView tAdNativeView2 = this.f50676b;
        if (tAdNativeView2 == null) {
            return;
        }
        tAdNativeView2.setVisibility(8);
    }

    public final boolean c(c cVar) {
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP;
        return ((cVar == null || (biddingIntermediateMaterialBeanP = cVar.P()) == null) ? null : biddingIntermediateMaterialBeanP.getNativeInfo()) != null;
    }
}
