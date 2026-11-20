package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.ShortTvMmkv;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public class DownloadReDetectorShortTVADFragment extends DownloadReDetectorBaseFragment<h00.f0> {
    public static final a A = new a(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.transsion.ad.bidding.video.f f60757w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.transsion.ad.bidding.interstitial.a f60758x;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f60756v = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.report.b>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVADFragment$shortTVReporter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.report.b invoke() {
            return new com.transsnet.downloader.report.b();
        }
    });

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final DownloadReDetectorShortTVADFragment$videoListener$1 f60759y = new jq.a() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVADFragment$videoListener$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f60762a;

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            this.f60763b.w1();
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this.f60763b), null, null, new DownloadReDetectorShortTVADFragment$videoListener$1$onBiddingLoad$1(this.f60763b, null), 3, null);
        }

        @Override // jq.a
        public void j(int i11) {
            super.j(i11);
            if (this.f60762a) {
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this.f60763b.Y0();
                if (downloadResourcesDetectorViewModelY0 != null) {
                    downloadResourcesDetectorViewModelY0.I("ad_success");
                }
            } else {
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = this.f60763b.Y0();
                if (downloadResourcesDetectorViewModelY1 != null) {
                    downloadResourcesDetectorViewModelY1.I("ad_cancel");
                }
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = this.f60763b.Y0();
            androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY2 != null ? downloadResourcesDetectorViewModelY2.o() : null;
            if (c0VarO == null) {
                return;
            }
            c0VarO.q(5);
        }

        @Override // jq.a
        public void l(int i11) {
            super.l(i11);
            this.f60762a = true;
        }
    };

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final DownloadReDetectorShortTVADFragment$interstitialListener$1 f60760z = new jq.a() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVADFragment$interstitialListener$1
        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this.f60761a.Y0();
            if (downloadResourcesDetectorViewModelY0 != null) {
                downloadResourcesDetectorViewModelY0.I("ad_load_fail");
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = this.f60761a.Y0();
            androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.o() : null;
            if (c0VarO == null) {
                return;
            }
            c0VarO.q(5);
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.h(biddingIntermediateMaterialBean);
            kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this.f60761a), null, null, new DownloadReDetectorShortTVADFragment$interstitialListener$1$onBiddingLoad$1(this.f60761a, null), 3, null);
        }

        @Override // jq.a
        public void j(int i11) {
            super.j(i11);
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this.f60761a.Y0();
            if (downloadResourcesDetectorViewModelY0 != null) {
                downloadResourcesDetectorViewModelY0.I("ad_success");
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = this.f60761a.Y0();
            androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.o() : null;
            if (c0VarO == null) {
                return;
            }
            c0VarO.q(5);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorShortTVADFragment a() {
            return new DownloadReDetectorShortTVADFragment();
        }
    }

    public static final void u1(DownloadReDetectorShortTVADFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this$0.Y0();
        androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.o() : null;
        if (c0VarO == null) {
            return;
        }
        c0VarO.q(5);
    }

    public static final void v1(DownloadReDetectorShortTVADFragment this$0, View view) {
        androidx.lifecycle.c0<String> c0VarG;
        String strF;
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this$0.Y0();
        if (downloadResourcesDetectorViewModelY0 != null && (c0VarG = downloadResourcesDetectorViewModelY0.G()) != null && (strF = c0VarG.f()) != null) {
            com.transsnet.downloader.report.b.b(this$0.s1(), strF, "dialog_minitv_download_unlock", "1", null, 8, null);
        }
        this$0.x1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.transsion.ad.bidding.video.f fVar = this.f60757w;
        if (fVar != null) {
            fVar.F();
        }
        com.transsion.ad.bidding.interstitial.a aVar = this.f60758x;
        if (aVar != null) {
            aVar.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (z11) {
            return;
        }
        y1();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
    }

    public final com.transsnet.downloader.report.b s1() {
        return (com.transsnet.downloader.report.b) this.f60756v.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: t1, reason: merged with bridge method [inline-methods] */
    public h00.f0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.f0 f0VarC = h00.f0.c(inflater);
        Intrinsics.f(f0VarC, "inflate(inflater)");
        return f0VarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        y1();
        h00.f0 f0Var = (h00.f0) getMViewBinding();
        if (f0Var != null && (appCompatImageView = f0Var.f65843c) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.s0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVADFragment.u1(this.f60958a, view);
                }
            });
        }
        h00.f0 f0Var2 = (h00.f0) getMViewBinding();
        if (f0Var2 == null || (appCompatTextView = f0Var2.f65845f) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorShortTVADFragment.v1(this.f60961a, view);
            }
        });
    }

    public final void w1() {
        com.transsion.ad.bidding.interstitial.a aVar = this.f60758x;
        if (aVar != null) {
            aVar.F();
        }
        com.transsion.ad.bidding.interstitial.a aVar2 = new com.transsion.ad.bidding.interstitial.a();
        this.f60758x = aVar2;
        aVar2.m0("ShortTvInterstitialScene");
        com.transsion.ad.bidding.interstitial.a aVar3 = this.f60758x;
        if (aVar3 != null) {
            aVar3.l0(this.f60760z);
        }
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new DownloadReDetectorShortTVADFragment$loadInterstitialAd$1(this, null), 3, null);
    }

    public final void x1() {
        com.transsion.ad.bidding.video.f fVar = this.f60757w;
        if (fVar != null) {
            fVar.F();
        }
        com.transsion.ad.bidding.video.f fVar2 = new com.transsion.ad.bidding.video.f();
        this.f60757w = fVar2;
        fVar2.m0("ShortTvVideoScene");
        com.transsion.ad.bidding.video.f fVar3 = this.f60757w;
        if (fVar3 != null) {
            fVar3.l0(this.f60759y);
        }
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new DownloadReDetectorShortTVADFragment$loadVideoAd$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1() {
        androidx.lifecycle.c0<String> c0VarC;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        String strF = (downloadResourcesDetectorViewModelY0 == null || (c0VarC = downloadResourcesDetectorViewModelY0.C()) == null) ? null : c0VarC.f();
        if (strF == null || strF.length() == 0) {
            strF = String.valueOf(ShortTvMmkv.f61142a.e());
        }
        h00.f0 f0Var = (h00.f0) getMViewBinding();
        AppCompatTextView appCompatTextView = f0Var != null ? f0Var.f65844d : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(Utils.a().getString(R$string.download_short_tv_watch_ad_ep, strF));
    }
}
