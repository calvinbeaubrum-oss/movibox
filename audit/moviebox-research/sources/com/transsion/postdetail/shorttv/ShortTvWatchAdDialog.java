package com.transsion.postdetail.shorttv;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.google.android.material.R$id;
import com.hisavana.common.bean.TAdErrorCode;
import com.tn.lib.dialog.BaseDialog;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.R$style;
import com.transsnet.downloader.util.ShortTvMmkv;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class ShortTvWatchAdDialog extends BaseDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f55379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.ad.bidding.video.f f55380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.ad.bidding.interstitial.a f55381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShortTvWatchAdDialog$videoListener$1 f55382d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ShortTvWatchAdDialog$interstitialListener$1 f55383f;

    /* JADX WARN: Type inference failed for: r0v4, types: [com.transsion.postdetail.shorttv.ShortTvWatchAdDialog$videoListener$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.transsion.postdetail.shorttv.ShortTvWatchAdDialog$interstitialListener$1] */
    public ShortTvWatchAdDialog() {
        super(R$layout.dialog_short_tv_unlock_tips);
        this.f55379a = FragmentViewModelLazyKt.a(this, Reflection.b(ShortTvPlayListViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.shorttv.ShortTvWatchAdDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.shorttv.ShortTvWatchAdDialog$special$$inlined$activityViewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f55382d = new jq.a() { // from class: com.transsion.postdetail.shorttv.ShortTvWatchAdDialog$videoListener$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f55385a;

            @Override // jq.a
            public void g(TAdErrorCode tAdErrorCode) {
                super.g(tAdErrorCode);
                this.f55386b.n0();
            }

            @Override // jq.a
            public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                super.h(biddingIntermediateMaterialBean);
                kotlinx.coroutines.j.d(v.a(this.f55386b), null, null, new ShortTvWatchAdDialog$videoListener$1$onBiddingLoad$1(this.f55386b, null), 3, null);
            }

            @Override // jq.a
            public void j(int i11) {
                super.j(i11);
                if (this.f55385a) {
                    this.f55386b.m0().i("ad_success");
                } else {
                    this.f55386b.m0().i("ad_cancel");
                }
                this.f55386b.dismissAllowingStateLoss();
            }

            @Override // jq.a
            public void l(int i11) {
                super.l(i11);
                this.f55385a = true;
            }
        };
        this.f55383f = new jq.a() { // from class: com.transsion.postdetail.shorttv.ShortTvWatchAdDialog$interstitialListener$1
            @Override // jq.a
            public void g(TAdErrorCode tAdErrorCode) {
                super.g(tAdErrorCode);
                this.f55384a.m0().i("ad_load_fail");
                this.f55384a.dismissAllowingStateLoss();
            }

            @Override // jq.a
            public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                super.h(biddingIntermediateMaterialBean);
                kotlinx.coroutines.j.d(v.a(this.f55384a), null, null, new ShortTvWatchAdDialog$interstitialListener$1$onBiddingLoad$1(this.f55384a, null), 3, null);
            }

            @Override // jq.a
            public void j(int i11) {
                super.j(i11);
                this.f55384a.m0().i("ad_success");
                this.f55384a.dismissAllowingStateLoss();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        com.transsion.ad.bidding.interstitial.a aVar = this.f55381c;
        if (aVar != null) {
            aVar.F();
        }
        com.transsion.ad.bidding.interstitial.a aVar2 = new com.transsion.ad.bidding.interstitial.a();
        this.f55381c = aVar2;
        aVar2.m0("ShortTvInterstitialScene");
        com.transsion.ad.bidding.interstitial.a aVar3 = this.f55381c;
        if (aVar3 != null) {
            aVar3.l0(this.f55383f);
        }
        kotlinx.coroutines.j.d(v.a(this), null, null, new ShortTvWatchAdDialog$loadInterstitialAd$1(this, null), 3, null);
    }

    private final void o0() {
        com.transsion.ad.bidding.video.f fVar = this.f55380b;
        if (fVar != null) {
            fVar.F();
        }
        com.transsion.ad.bidding.video.f fVar2 = new com.transsion.ad.bidding.video.f();
        this.f55380b = fVar2;
        fVar2.m0("ShortTvVideoScene");
        com.transsion.ad.bidding.video.f fVar3 = this.f55380b;
        if (fVar3 != null) {
            fVar3.l0(this.f55382d);
        }
        kotlinx.coroutines.j.d(v.a(this), null, null, new ShortTvWatchAdDialog$loadVideoAd$1(this, null), 3, null);
    }

    public static final void p0(ShortTvWatchAdDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        this$0.m0().j();
    }

    public static final void q0(ShortTvWatchAdDialog this$0, View view) {
        String subjectId;
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        tp.e eVar = tp.e.f77259a;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        if (!eVar.a(contextRequireContext)) {
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.player_no_network_tip2);
            return;
        }
        Subject subjectF = this$0.m0().h().f();
        if (subjectF == null || (subjectId = subjectF.getSubjectId()) == null) {
            return;
        }
        o.b(o.f55416a, subjectId, "dialog_minitv_unlock", "1", null, 8, null);
        this$0.o0();
    }

    public final ShortTvPlayListViewModel m0() {
        return (ShortTvPlayListViewModel) this.f55379a.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onCancel(dialog);
        m0().j();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(requireContext(), R$style.BottomDialogTheme);
        bVar.setCanceledOnTouchOutside(false);
        return bVar;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        com.transsion.ad.bidding.video.f fVar = this.f55380b;
        if (fVar != null) {
            fVar.F();
        }
        com.transsion.ad.bidding.interstitial.a aVar = this.f55381c;
        if (aVar != null) {
            aVar.F();
        }
    }

    @Override // com.tn.lib.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        View viewFindViewById;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null || (viewFindViewById = window.findViewById(R$id.design_bottom_sheet)) == null) {
            return;
        }
        viewFindViewById.setBackgroundResource(R.color.transparent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String subjectId;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        view.findViewById(com.transsion.postdetail.R$id.iv_close).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShortTvWatchAdDialog.p0(this.f55417a, view2);
            }
        });
        TextView textView = (TextView) view.findViewById(com.transsion.postdetail.R$id.tv_episode);
        Subject subjectF = m0().h().f();
        int totalEpisode = subjectF != null ? subjectF.getTotalEpisode() : 0;
        ShortTvMmkv shortTvMmkv = ShortTvMmkv.f61142a;
        int iE = shortTvMmkv.e();
        if (subjectF == null || (subjectId = subjectF.getSubjectId()) == null) {
            subjectId = "";
        }
        textView.setText(iE + shortTvMmkv.c(subjectId) >= totalEpisode ? getString(R$string.short_tv_watch_ad_tips, getString(R$string.short_tv_all)) : getString(R$string.short_tv_watch_ad_tips, String.valueOf(shortTvMmkv.e())));
        view.findViewById(com.transsion.postdetail.R$id.tv_unlock).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShortTvWatchAdDialog.q0(this.f55418a, view2);
            }
        });
    }
}
