package com.transsnet.downloader.adapter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.api.DownloadPageType;
import com.transsnet.downloader.fragment.DownloadPanelFragment;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
@Deprecated
@SourceDebugExtension
public final class DownloadExpandAdapter extends BaseMultiItemQuickAdapter<e9.a, BaseViewHolder> implements h9.j {
    public final int I;
    public final DownloadPanelFragment J;
    public final FrameLayout K;
    public final com.transsion.ad.bidding.nativead.c L;
    public final Function5<Integer, View, DownloadBean, Integer, d0.b, Unit> M;
    public com.transsnet.downloader.manager.e N;
    public final boolean O;
    public final Lazy P;
    public final Lazy Q;
    public final Lazy R;
    public d0.b S;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum LayoutType {
        NO_DONE_LAYOUT(1),
        DONE_LAYOUT(2),
        TITLE_LAYOUT(3),
        HIDE_MORE_LAYOUT(4),
        AD_LAYOUT(5),
        ALL_EP_BTN(6);

        LayoutType(int i11) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0.b {
        public a() {
        }

        @Override // com.transsnet.downloader.adapter.d0.b
        public void a(int i11, int i12) {
            DownloadListManager downloadListManagerA;
            d0.b bVarT0 = DownloadExpandAdapter.this.T0();
            if (bVarT0 != null) {
                bVarT0.a(i11, i12);
            }
            if (i12 == 3) {
                DownloadExpandAdapter.this.notifyItemChanged(i11);
                DownloadExpandAdapter.this.X0(i11);
                return;
            }
            if (i12 != 4) {
                return;
            }
            if (DownloadExpandAdapter.this.I == DownloadPageType.SERIES.ordinal()) {
                DownloadListManager.a aVar = DownloadListManager.f61186m;
                DownloadBean downloadBeanF = aVar.a().z().f();
                if (downloadBeanF != null) {
                    try {
                        List<DownloadBean> seriesList = downloadBeanF.getSeriesList();
                        if (seriesList != null) {
                            seriesList.remove(i11);
                        }
                    } catch (Throwable unused) {
                        downloadListManagerA = DownloadListManager.f61186m.a();
                    }
                }
                downloadListManagerA = aVar.a();
                downloadListManagerA.z().q(downloadBeanF);
            }
            DownloadListManager.a aVar2 = DownloadListManager.f61186m;
            DownloadListManager.x(aVar2.a(), aVar2.a().J(), false, null, 6, null);
        }

        @Override // com.transsnet.downloader.adapter.d0.b
        public void b(int i11, int i12, int i13, boolean z11) {
            d0.b.a.a(this, i11, i12, i13, z11);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadExpandAdapter(int i11, DownloadPanelFragment fragment, FrameLayout frameLayout, com.transsion.ad.bidding.nativead.c cVar, Function5<? super Integer, ? super View, ? super DownloadBean, ? super Integer, ? super d0.b, Unit> popSaveListener) {
        super(null, 1, null);
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(popSaveListener, "popSaveListener");
        this.I = i11;
        this.J = fragment;
        this.K = frameLayout;
        this.L = cVar;
        this.M = popSaveListener;
        this.O = ((double) (((float) com.blankj.utilcode.util.f0.a(120.0f)) / ((float) com.blankj.utilcode.util.d0.e()))) >= 0.35d;
        this.P = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsnet.downloader.adapter.DownloadExpandAdapter$mAudioApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAudioApi invoke() {
                return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
            }
        });
        this.Q = LazyKt__LazyJVMKt.b(new Function0<IFloatingApi>() { // from class: com.transsnet.downloader.adapter.DownloadExpandAdapter$mFloatApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IFloatingApi invoke() {
                return (IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class);
            }
        });
        this.R = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsnet.downloader.adapter.DownloadExpandAdapter$audioDao$2
            @Override // kotlin.jvm.functions.Function0
            public final rr.a invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).D0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rr.a O0() {
        return (rr.a) this.R.getValue();
    }

    private final IAudioApi R0() {
        return (IAudioApi) this.P.getValue();
    }

    private final IFloatingApi S0() {
        return (IFloatingApi) this.Q.getValue();
    }

    public final void L0() {
        for (e9.a aVar : D()) {
            if (aVar instanceof DownloadBean) {
                ((DownloadBean) aVar).setWrapNativeManager(null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, e9.a item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        if (holder instanceof d0) {
            ((d0) holder).d(holder.getBindingAdapterPosition(), item);
            d0 d0Var = (d0) holder;
            d0Var.a(holder.getBindingAdapterPosition(), item);
            d0Var.c(new a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, e9.a item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if ((obj instanceof DownloadBean) && (holder instanceof d0)) {
            ((d0) holder).a(holder.getBindingAdapterPosition(), (e9.a) obj);
        }
    }

    public final List<e9.a> P0(List<? extends DownloadBean> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadBean downloadBean : list) {
                downloadBean.setItemType(Q0(downloadBean));
                arrayList.add(downloadBean);
            }
        }
        return arrayList;
    }

    public final int Q0(DownloadBean downloadBean) {
        LayoutType layoutType = LayoutType.NO_DONE_LAYOUT;
        int iOrdinal = layoutType.ordinal();
        switch (downloadBean.getStatus()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
                return layoutType.ordinal();
            case 5:
            case 10:
                return LayoutType.DONE_LAYOUT.ordinal();
            case 8:
            case 9:
            default:
                return iOrdinal;
            case 11:
                return LayoutType.TITLE_LAYOUT.ordinal();
            case 12:
                return LayoutType.HIDE_MORE_LAYOUT.ordinal();
            case 13:
                return LayoutType.AD_LAYOUT.ordinal();
            case 14:
                return LayoutType.ALL_EP_BTN.ordinal();
        }
    }

    public final d0.b T0() {
        return this.S;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewRecycled(holder);
    }

    public final void V0(d0.b listener) {
        Intrinsics.g(listener, "listener");
        this.S = listener;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void W0(List<? extends DownloadBean> list) {
        x0(P0(list));
    }

    public final void X0(int i11) {
        IFloatingApi iFloatingApiS0;
        e9.a aVar = (e9.a) getItem(i11);
        if (aVar instanceof DownloadBean) {
            IAudioApi iAudioApiR0 = R0();
            if (iAudioApiR0 != null && iAudioApiR0.u(((DownloadBean) aVar).getUrl()) && (iFloatingApiS0 = S0()) != null) {
                String name = ((DownloadBean) aVar).getName();
                if (name == null) {
                    name = "";
                }
                iFloatingApiS0.p0(name);
            }
            kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new DownloadExpandAdapter$upDateAudioName$1(aVar, this, null), 3, null);
        }
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g0 */
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        if (i11 == LayoutType.NO_DONE_LAYOUT.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.adapter_downloading_item, parent, false);
            Intrinsics.f(view, "view");
            int i12 = this.I;
            DownloadPageType downloadPageType = DownloadPageType.SERIES;
            return new DownloadingHolder(view, i12 == downloadPageType.ordinal() ? downloadPageType.getPageName() : DownloadPageType.DOWNLOAD.getPageName(), this.O ? 11.0f : 12.0f);
        }
        if (i11 == LayoutType.DONE_LAYOUT.ordinal()) {
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R$layout.adapter_downloaded_item, parent, false);
            Intrinsics.f(view2, "view");
            int i13 = this.I;
            DownloadPageType downloadPageType2 = DownloadPageType.SERIES;
            return new DownloadedHolder(view2, i13 == downloadPageType2.ordinal() ? downloadPageType2.getPageName() : DownloadPageType.DOWNLOAD.getPageName(), this.O ? 11.0f : 12.0f, this.M);
        }
        if (i11 == LayoutType.TITLE_LAYOUT.ordinal()) {
            View view3 = LayoutInflater.from(parent.getContext()).inflate(R$layout.adapter_download_item_header, parent, false);
            Intrinsics.f(view3, "view");
            return new DownTitleHolder(view3, this.J);
        }
        if (i11 == LayoutType.HIDE_MORE_LAYOUT.ordinal()) {
            View view4 = LayoutInflater.from(parent.getContext()).inflate(R$layout.adapter_download_item_hide_more, parent, false);
            Intrinsics.f(view4, "view");
            return new DownHideMoreHolder(view4, this.L);
        }
        if (i11 == LayoutType.AD_LAYOUT.ordinal()) {
            View view5 = LayoutInflater.from(parent.getContext()).inflate(R$layout.adapter_download_item_ad, parent, false);
            Intrinsics.f(view5, "view");
            return new DownloadAdHolder(view5);
        }
        if (i11 != LayoutType.ALL_EP_BTN.ordinal()) {
            return super.onCreateViewHolder(parent, i11);
        }
        View view6 = LayoutInflater.from(parent.getContext()).inflate(R$layout.adapter_download_item_all_ep, parent, false);
        Intrinsics.f(view6, "view");
        DownloadAllEpBtnHolder downloadAllEpBtnHolder = new DownloadAllEpBtnHolder(view6);
        r(downloadAllEpBtnHolder, i11);
        return downloadAllEpBtnHolder;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (this.K != null && this.I == DownloadPageType.DOWNLOAD.ordinal() && (holder instanceof DownloadingHolder)) {
            if (this.N == null) {
                this.N = new com.transsnet.downloader.manager.e();
            }
            com.transsnet.downloader.manager.e eVar = this.N;
            if (eVar != null) {
                eVar.d(this.K, holder, 3000L);
            }
        }
    }
}
