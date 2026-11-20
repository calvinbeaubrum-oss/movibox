package com.transsnet.downloader.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.AdvRecyclerView;
import com.tn.lib.view.NoNetworkSmallView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.room.api.IAudioApi;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.adapter.DownloadExpandAdapter;
import com.transsnet.downloader.api.DownloadPageType;
import com.transsnet.downloader.bean.MovieRecBean;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.popup.PopupManager;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel;
import com.transsnet.downloader.widget.DownloadPanelForYouFootView;
import com.transsnet.downloader.widget.DownloadResLoadMoreView;
import com.transsnet.downloader.widget.DownloadTransferLaterTipsView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import com.transsnet.flow.event.sync.event.LocalVideoEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadPanelFragment extends BaseFragment<h00.y> implements su.e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f60654w = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DownloadExpandAdapter f60655a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.transsnet.downloader.adapter.e0 f60660g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f60662i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f60664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<DownloadBean> f60665l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f60667n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DownloadPanelForYouFootView f60669p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.transsion.ad.bidding.nativead.c f60670q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.transsion.ad.bidding.nativead.c f60671r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f60672s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f60656b = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$audioApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IAudioApi invoke() {
            return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f60657c = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.manager.a invoke() {
            return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f60658d = FragmentViewModelLazyKt.a(this, Reflection.b(DownloadViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.x0 invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.v0.c invoke() {
            androidx.lifecycle.v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f60659f = FragmentViewModelLazyKt.a(this, Reflection.b(HistoricalPlayRecordViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.x0 invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$special$$inlined$activityViewModels$default$4
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.v0.c invoke() {
            androidx.lifecycle.v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f60661h = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.report.a>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$downloadReport$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.report.a invoke() {
            return new com.transsnet.downloader.report.a();
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f60663j = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f60666m = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f60668o = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final zr.b f60673t = new zr.b(0.4f, new d(), false, 4, null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f60674u = new b();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f60675v = new c();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.transsion.player.orplayer.e {
        public b() {
        }

        public final DownloadBean a(String str) {
            List<T> listD;
            DownloadExpandAdapter downloadExpandAdapter = DownloadPanelFragment.this.f60655a;
            int size = (downloadExpandAdapter == null || (listD = downloadExpandAdapter.D()) == 0) ? 0 : listD.size();
            for (int i11 = 0; i11 < size; i11++) {
                DownloadExpandAdapter downloadExpandAdapter2 = DownloadPanelFragment.this.f60655a;
                Intrinsics.d(downloadExpandAdapter2);
                e9.a aVar = (e9.a) downloadExpandAdapter2.D().get(i11);
                if (aVar instanceof DownloadBean) {
                    DownloadBean downloadBean = (DownloadBean) aVar;
                    if (Intrinsics.b(downloadBean.getUrl(), str)) {
                        return downloadBean;
                    }
                }
            }
            return null;
        }

        @Override // com.transsion.player.orplayer.e
        public void initPlayer() {
            com.transsion.player.orplayer.e.a.a(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.b(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onBufferedPosition(long j11, MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onCompletion(MediaSource mediaSource) {
            DownloadBean downloadBeanA;
            com.transsion.player.orplayer.e.a.d(this, mediaSource);
            if ((mediaSource != null ? mediaSource.j() : null) == null || (downloadBeanA = a(mediaSource.j())) == null) {
                return;
            }
            uo.b.a.s(uo.b.f78622a, "audioPlay", "---onCompletion, to play, name = " + downloadBeanA.getName(), false, 4, null);
            downloadBeanA.setAudioStatus(6);
            com.transsion.player.orplayer.e audioListener = downloadBeanA.getAudioListener();
            if (audioListener != null) {
                audioListener.onCompletion(mediaSource);
            }
        }

        @Override // com.transsion.player.orplayer.e
        public void onFocusChange(boolean z11) {
            com.transsion.player.orplayer.e.a.f(this, z11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onIsPlayingChanged(boolean z11) {
            com.transsion.player.orplayer.e.a.g(this, z11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingBegin(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.h(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingEnd(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.j(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoopingStart() {
            com.transsion.player.orplayer.e.a.n(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onMediaItemTransition(String str) {
            com.transsion.player.orplayer.e.a.o(this, str);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayError(PlayError playError, MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.p(this, playError, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayerRelease(MediaSource mediaSource) {
            DownloadBean downloadBeanA;
            com.transsion.player.orplayer.e.a.d(this, mediaSource);
            if ((mediaSource != null ? mediaSource.j() : null) == null || (downloadBeanA = a(mediaSource.j())) == null) {
                return;
            }
            uo.b.a.s(uo.b.f78622a, "audioPlay", "---onPlayerRelease, top, name = " + downloadBeanA.getName(), false, 4, null);
            downloadBeanA.setAudioStatus(4);
            com.transsion.player.orplayer.e audioListener = downloadBeanA.getAudioListener();
            if (audioListener != null) {
                audioListener.onVideoPause(mediaSource);
            }
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayerReset() {
            com.transsion.player.orplayer.e.a.u(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPrepare(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.v(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onProgress(long j11, MediaSource mediaSource) {
            DownloadBean downloadBeanA;
            com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
            if ((mediaSource != null ? mediaSource.j() : null) == null || (downloadBeanA = a(mediaSource.j())) == null) {
                return;
            }
            downloadBeanA.setAudioStatus(3);
            com.transsion.player.orplayer.e audioListener = downloadBeanA.getAudioListener();
            if (audioListener != null) {
                audioListener.onProgress(j11, mediaSource);
            }
        }

        @Override // com.transsion.player.orplayer.e
        public void onRenderFirstFrame() {
            com.transsion.player.orplayer.e.a.z(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onSetDataSource() {
            com.transsion.player.orplayer.e.a.A(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksAudioBitrateChange(int i11) {
            com.transsion.player.orplayer.e.a.B(this, i11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksChange(ov.c cVar) {
            com.transsion.player.orplayer.e.a.C(this, cVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksVideoBitrateChange(int i11) {
            com.transsion.player.orplayer.e.a.D(this, i11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoPause(MediaSource mediaSource) {
            DownloadBean downloadBeanA;
            com.transsion.player.orplayer.e.a.E(this, mediaSource);
            if ((mediaSource != null ? mediaSource.j() : null) == null || (downloadBeanA = a(mediaSource.j())) == null) {
                return;
            }
            uo.b.a.f(uo.b.f78622a, "audioPlay", "---onVideoPause, to play, name = " + downloadBeanA.getName(), false, 4, null);
            downloadBeanA.setAudioStatus(4);
            com.transsion.player.orplayer.e audioListener = downloadBeanA.getAudioListener();
            if (audioListener != null) {
                audioListener.onVideoPause(mediaSource);
            }
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoSizeChanged(int i11, int i12) {
            com.transsion.player.orplayer.e.a.G(this, i11, i12);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoStart(MediaSource mediaSource) {
            DownloadBean downloadBeanA;
            com.transsion.player.orplayer.e.a.H(this, mediaSource);
            if ((mediaSource != null ? mediaSource.j() : null) == null || (downloadBeanA = a(mediaSource.j())) == null) {
                return;
            }
            uo.b.a.f(uo.b.f78622a, "audioPlay", "---onVideoStart, to play, name = " + downloadBeanA.getName(), false, 4, null);
            downloadBeanA.setAudioStatus(3);
            com.transsion.player.orplayer.e audioListener = downloadBeanA.getAudioListener();
            if (audioListener != null) {
                audioListener.onVideoStart(mediaSource);
            }
        }

        @Override // com.transsion.player.orplayer.e
        public void setOnSeekCompleteListener() {
            com.transsion.player.orplayer.e.a.J(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends g00.d {
        public c() {
        }

        @Override // g00.d
        public void h(DownloadBean bean, int i11) {
            Intrinsics.g(bean, "bean");
            if (i11 == 5) {
                uo.b.f78622a.h(DownloadBaseRunnable.TAG, "onRefresh,getList status=" + i11 + ",bean=" + bean.getName() + " subjectId=" + bean.getSubjectId() + ",resourceId=" + bean.getResourceId(), true);
                DownloadListManager.a aVar = DownloadListManager.f61186m;
                aVar.a().w(aVar.a().J(), true, DownloadPanelFragment.this.Q0());
                DownloadPanelFragment.this.T0().A();
                return;
            }
            Integer numValueOf = DownloadListManager.f61186m.a().r().get(bean.getResourceId());
            if (numValueOf == null || numValueOf.intValue() < 0) {
                numValueOf = Integer.valueOf(DownloadPanelFragment.this.U0(bean.getResourceId()));
            }
            if (numValueOf.intValue() >= 0) {
                DownloadExpandAdapter downloadExpandAdapter = DownloadPanelFragment.this.f60655a;
                if (downloadExpandAdapter != null) {
                    downloadExpandAdapter.notifyItemChanged(numValueOf.intValue(), bean);
                    return;
                }
                return;
            }
            uo.b.f78622a.h(DownloadBaseRunnable.TAG, "onRefresh position=" + numValueOf + ",status=" + i11 + ",bean=" + bean.getName() + " subjectId=" + bean.getSubjectId() + ",resourceId=" + bean.getResourceId(), true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements zr.a {
        public d() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            List<Subject> listD;
            com.transsnet.downloader.adapter.e0 e0Var = DownloadPanelFragment.this.f60660g;
            Subject subject = (e0Var == null || (listD = e0Var.D()) == null) ? null : (Subject) CollectionsKt___CollectionsKt.h0(listD, i11);
            if (subject != null) {
                DownloadPanelFragment.this.R0().a(DownloadPanelFragment.this.getPageName(), subject, i11, j11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends DiffUtil.e<e9.a> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(e9.a oldItem, e9.a newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            if (!(oldItem instanceof DownloadBean) || !(newItem instanceof DownloadBean)) {
                return false;
            }
            DownloadBean downloadBean = (DownloadBean) oldItem;
            DownloadBean downloadBean2 = (DownloadBean) newItem;
            return downloadBean.getStatus() == downloadBean2.getStatus() && downloadBean.getProgress() == downloadBean2.getProgress();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(e9.a oldItem, e9.a newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            if ((oldItem instanceof DownloadBean) && (newItem instanceof DownloadBean)) {
                return Intrinsics.b(((DownloadBean) oldItem).getResourceId(), ((DownloadBean) newItem).getResourceId());
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class f implements com.transsnet.downloader.adapter.d0.b {
        public f() {
        }

        @Override // com.transsnet.downloader.adapter.d0.b
        public void a(int i11, int i12) {
            DownloadTransferLaterTipsView downloadTransferLaterTipsView;
            if (i12 == 4 || i12 == 5) {
                c();
                return;
            }
            if (i12 == 6 && DownloadPanelFragment.this.f60666m) {
                RoomAppMMKV.f51271a.a().putBoolean("download_transfer_later_guide", false);
                h00.y mViewBinding = DownloadPanelFragment.this.getMViewBinding();
                if (mViewBinding != null && (downloadTransferLaterTipsView = mViewBinding.f66099d) != null) {
                    downloadTransferLaterTipsView.setVisibility(0);
                    downloadTransferLaterTipsView.startCountdown();
                }
                DownloadPanelFragment.this.f60666m = false;
            }
        }

        @Override // com.transsnet.downloader.adapter.d0.b
        public void b(int i11, int i12, int i13, boolean z11) {
            com.transsnet.downloader.adapter.d0.b.a.a(this, i11, i12, i13, z11);
        }

        public final void c() {
            Fragment parentFragment = DownloadPanelFragment.this.getParentFragment();
            FileManagerFragment fileManagerFragment = parentFragment instanceof FileManagerFragment ? (FileManagerFragment) parentFragment : null;
            if (fileManagerFragment != null) {
                fileManagerFragment.M0();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements AdvRecyclerView.a {
        public g() {
        }

        @Override // com.tn.lib.view.AdvRecyclerView.a
        public void a() {
            DownloadPanelFragment.this.m1();
        }

        @Override // com.tn.lib.view.AdvRecyclerView.a
        public void b() {
            DownloadPanelFragment.this.m1();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h implements com.tn.lib.util.networkinfo.g {
        public h() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            DownloadPanelFragment.this.b1();
            DownloadPanelFragment.this.w1();
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
            DownloadPanelFragment.this.z1();
            DownloadPanelFragment.this.a1();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class i implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60682a;

        public i(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60682a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60682a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f60682a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.DownloadPanelFragment$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadPanelFragment$initData$1", f = "DownloadPanelFragment.kt", l = {211}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: com.transsnet.downloader.fragment.DownloadPanelFragment$initData$1$a */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends jq.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DownloadPanelFragment f60684a;

            public a(DownloadPanelFragment downloadPanelFragment) {
                this.f60684a = downloadPanelFragment;
            }

            @Override // jq.a
            public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                super.h(biddingIntermediateMaterialBean);
                DownloadListManager.a aVar = DownloadListManager.f61186m;
                DownloadListManager.x(aVar.a(), aVar.a().J(), false, this.f60684a.V0(), 2, null);
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadPanelFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.transsion.ad.bidding.nativead.c cVar;
            DownloadPanelFragment downloadPanelFragment;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                DownloadPanelFragment downloadPanelFragment2 = DownloadPanelFragment.this;
                cVar = new com.transsion.ad.bidding.nativead.c();
                DownloadPanelFragment downloadPanelFragment3 = DownloadPanelFragment.this;
                cVar.m0("DownloadTvListScene");
                cVar.l0(new a(downloadPanelFragment3));
                this.L$0 = cVar;
                this.L$1 = downloadPanelFragment2;
                this.label = 1;
                if (cVar.T(this) == objE) {
                    return objE;
                }
                downloadPanelFragment = downloadPanelFragment2;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                downloadPanelFragment = (DownloadPanelFragment) this.L$1;
                cVar = (com.transsion.ad.bidding.nativead.c) this.L$0;
                ResultKt.b(obj);
            }
            downloadPanelFragment.q1(cVar);
            return Unit.f68710a;
        }
    }

    private final void A1() {
        AdvRecyclerView advRecyclerView;
        h00.y mViewBinding = getMViewBinding();
        if (mViewBinding != null && (advRecyclerView = mViewBinding.f66097b) != null) {
            advRecyclerView.showEmpty();
            Unit unit = Unit.f68710a;
        }
        g1();
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            b1();
            w1();
        } else {
            z1();
        }
        DownloadPageType.DOWNLOAD.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(List<DownloadBean> list, boolean z11) {
        List<DownloadBean> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            A1();
            return;
        }
        s1();
        DownloadPageType.DOWNLOAD.ordinal();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        DownloadExpandAdapter downloadExpandAdapter = this.f60655a;
        if (downloadExpandAdapter != null) {
            downloadExpandAdapter.W0(list);
        }
        if (this.f60672s) {
            return;
        }
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new DownloadPanelFragment$updateList$1(this, null), 3, null);
    }

    public static /* synthetic */ void C1(DownloadPanelFragment downloadPanelFragment, List list, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        downloadPanelFragment.B1(list, z11);
    }

    private final void L0() {
        DownloadExpandAdapter downloadExpandAdapter = this.f60655a;
        if (downloadExpandAdapter != null) {
            downloadExpandAdapter.L0();
        }
        List<DownloadBean> list = this.f60665l;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((DownloadBean) it.next()).setWrapNativeManager(null);
            }
        }
    }

    private final void M0() {
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        DownloadListManager.x(aVar.a(), aVar.a().J(), false, this.f60670q, 2, null);
    }

    private final IAudioApi O0() {
        return (IAudioApi) this.f60656b.getValue();
    }

    private final com.transsnet.downloader.manager.a P0() {
        return (com.transsnet.downloader.manager.a) this.f60657c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DownloadViewModel S0() {
        return (DownloadViewModel) this.f60658d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HistoricalPlayRecordViewModel T0() {
        return (HistoricalPlayRecordViewModel) this.f60659f.getValue();
    }

    private final void X0(Subject subject) {
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context context = getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                downloadManagerApiA.a2((FragmentActivity) context, getPageName(), (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
        Integer subjectType2 = subject.getSubjectType();
        postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("id", subject.getSubjectId()).withString("ops", subject.getOps()).navigation();
    }

    private final void c1() {
        AdvRecyclerView advRecyclerView;
        AdvRecyclerView advRecyclerView2;
        h00.y mViewBinding;
        AdvRecyclerView advRecyclerView3;
        if (this.f60662i != DownloadPageType.SERIES.ordinal() && (mViewBinding = getMViewBinding()) != null && (advRecyclerView3 = mViewBinding.f66097b) != null) {
            advRecyclerView3.resetEmptyView(R$layout.layout_download_empty_default);
        }
        h00.y mViewBinding2 = getMViewBinding();
        RecyclerView recyclerView = (mViewBinding2 == null || (advRecyclerView2 = mViewBinding2.f66097b) == null) ? null : advRecyclerView2.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
        }
        int i11 = this.f60662i;
        h00.y mViewBinding3 = getMViewBinding();
        final DownloadExpandAdapter downloadExpandAdapter = new DownloadExpandAdapter(i11, this, mViewBinding3 != null ? mViewBinding3.f66097b : null, this.f60670q, new Function5<Integer, View, DownloadBean, Integer, com.transsnet.downloader.adapter.d0.b, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$initAdapter$1

            /* JADX INFO: compiled from: source.java */
            @Metadata
            public static final class a implements com.transsnet.downloader.adapter.d0.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.transsnet.downloader.adapter.d0.b f60683a;

                public a(com.transsnet.downloader.adapter.d0.b bVar) {
                    this.f60683a = bVar;
                }

                @Override // com.transsnet.downloader.adapter.d0.b
                public void a(int i11, int i12) {
                    com.transsnet.downloader.adapter.d0.b bVar = this.f60683a;
                    if (bVar != null) {
                        bVar.a(i11, i12);
                    }
                }

                @Override // com.transsnet.downloader.adapter.d0.b
                public void b(int i11, int i12, int i13, boolean z11) {
                    com.transsnet.downloader.adapter.d0.b.a.a(this, i11, i12, i13, z11);
                }
            }

            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, View view, DownloadBean downloadBean, Integer num2, com.transsnet.downloader.adapter.d0.b bVar) {
                invoke(num.intValue(), view, downloadBean, num2.intValue(), bVar);
                return Unit.f68710a;
            }

            public final void invoke(int i12, View view, DownloadBean bean, int i13, com.transsnet.downloader.adapter.d0.b bVar) {
                Intrinsics.g(view, "view");
                Intrinsics.g(bean, "bean");
                PopupManager popupManager = new PopupManager(i12, bean);
                final DownloadPanelFragment downloadPanelFragment = this.this$0;
                popupManager.z(view, i13);
                popupManager.v(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$initAdapter$1$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (downloadPanelFragment.f60662i == DownloadPageType.DOWNLOAD.ordinal()) {
                            downloadPanelFragment.S0().k().q(1);
                            downloadPanelFragment.S0().F().q(0);
                            return;
                        }
                        com.transsnet.downloader.popup.b bVar2 = new com.transsnet.downloader.popup.b(1, 0);
                        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                        String name = com.transsnet.downloader.popup.b.class.getName();
                        Intrinsics.f(name, "T::class.java.name");
                        flowEventBus.postEvent(name, bVar2, 0L);
                        FragmentActivity activity = downloadPanelFragment.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                });
                popupManager.u(new a(bVar));
            }
        });
        if (this.f60662i == DownloadPageType.DOWNLOAD.ordinal()) {
            downloadExpandAdapter.Q().B(new DownloadResLoadMoreView());
            downloadExpandAdapter.Q().y(true);
            downloadExpandAdapter.Q().x(true);
            downloadExpandAdapter.Q().D(4);
            downloadExpandAdapter.Q().C(new f9.f() { // from class: com.transsnet.downloader.fragment.r
                @Override // f9.f
                public final void a() {
                    DownloadPanelFragment.d1(downloadExpandAdapter, this);
                }
            });
        }
        downloadExpandAdapter.o0(new e());
        downloadExpandAdapter.V0(new f());
        downloadExpandAdapter.i(R$id.v_all_ep_btn);
        downloadExpandAdapter.z0(new f9.b() { // from class: com.transsnet.downloader.fragment.s
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                DownloadPanelFragment.e1(this.f60957a, baseQuickAdapter, view, i12);
            }
        });
        this.f60655a = downloadExpandAdapter;
        if (recyclerView != null) {
            recyclerView.setAdapter(downloadExpandAdapter);
        }
        h00.y mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (advRecyclerView = mViewBinding4.f66097b) == null) {
            return;
        }
        advRecyclerView.setOnStateClickListener(new g());
    }

    public static final void d1(DownloadExpandAdapter this_apply, DownloadPanelFragment this$0) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this_apply.Q().s(true);
        } else {
            this_apply.Q().v();
            this$0.n1();
        }
    }

    public static final void e1(DownloadPanelFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (view.getId() == R$id.v_all_ep_btn) {
            this$0.r1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPageName() {
        int i11 = this.f60662i;
        DownloadPageType downloadPageType = DownloadPageType.SERIES;
        return i11 == downloadPageType.ordinal() ? downloadPageType.getPageName() : DownloadPageType.DOWNLOAD.getPageName();
    }

    public static final void h1(DownloadPanelFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S0().k().q(1);
        this$0.S0().F().q(0);
    }

    private final void initViewModel() {
        androidx.lifecycle.c0<BaseDto<MovieRecBean>> c0VarS;
        this.f60670q = new com.transsion.ad.bidding.nativead.c();
        int i11 = this.f60662i;
        if (i11 == DownloadPageType.DOWNLOAD.ordinal()) {
            DownloadListManager.a aVar = DownloadListManager.f61186m;
            List<DownloadBean> listF = aVar.a().q().f();
            this.f60664k = !(listF == null || listF.isEmpty());
            aVar.a().q().j(this, new i(new Function1<List<DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment.initViewModel.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<DownloadBean> list) {
                    invoke2(list);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<DownloadBean> list) {
                    SwipeRefreshLayout swipeRefreshLayout;
                    h00.y mViewBinding = DownloadPanelFragment.this.getMViewBinding();
                    if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f66098c) != null && swipeRefreshLayout.isRefreshing()) {
                        h00.y mViewBinding2 = DownloadPanelFragment.this.getMViewBinding();
                        SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f66098c : null;
                        if (swipeRefreshLayout2 != null) {
                            swipeRefreshLayout2.setRefreshing(false);
                        }
                    }
                    if (DownloadPanelFragment.this.f60664k) {
                        DownloadPanelFragment.this.f60664k = false;
                    } else {
                        DownloadPanelFragment.C1(DownloadPanelFragment.this, list, false, 2, null);
                    }
                }
            }));
        } else if (i11 == DownloadPageType.SERIES.ordinal()) {
            DownloadListManager.f61186m.a().z().j(this, new i(new Function1<DownloadBean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment.initViewModel.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                    invoke2(downloadBean);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DownloadBean downloadBean) {
                    SwipeRefreshLayout swipeRefreshLayout;
                    h00.y mViewBinding = DownloadPanelFragment.this.getMViewBinding();
                    if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f66098c) != null && swipeRefreshLayout.isRefreshing()) {
                        h00.y mViewBinding2 = DownloadPanelFragment.this.getMViewBinding();
                        SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f66098c : null;
                        if (swipeRefreshLayout2 != null) {
                            swipeRefreshLayout2.setRefreshing(false);
                        }
                    }
                    if (downloadBean != null) {
                        DownloadPanelFragment downloadPanelFragment = DownloadPanelFragment.this;
                        uo.b.a.f(uo.b.f78622a, "LocalVideo", "updateSeries fragment, size = " + downloadBean.getSeriesList().size(), false, 4, null);
                        downloadPanelFragment.l1(downloadBean.getSeriesList());
                        downloadPanelFragment.f1(downloadBean);
                        downloadPanelFragment.B1(downloadBean.getSeriesList(), false);
                    }
                }
            }));
        }
        DownloadViewModel downloadViewModelS0 = S0();
        if (downloadViewModelS0 == null || (c0VarS = downloadViewModelS0.s()) == null) {
            return;
        }
        c0VarS.j(this, new i(new Function1<BaseDto<MovieRecBean>, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment.initViewModel.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseDto<MovieRecBean> baseDto) {
                invoke2(baseDto);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseDto<MovieRecBean> baseDto) {
                if (!Intrinsics.b(baseDto.getCode(), "0") || baseDto.getData() == null) {
                    DownloadPanelFragment.this.Z0();
                } else {
                    DownloadPanelFragment.this.v1(baseDto.getData());
                }
            }
        }));
    }

    private final void j1() {
        Function1<LocalVideoEvent, Unit> function1 = new Function1<LocalVideoEvent, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$initVideoObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocalVideoEvent localVideoEvent) {
                invoke2(localVideoEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LocalVideoEvent value) {
                List<T> listD;
                Intrinsics.g(value, "value");
                try {
                    uo.b.a.f(uo.b.f78622a, "LocalVideo-d", "observeEvent resourceId:" + value.getResourceId() + ",readProgress: " + value.getReadProgress() + ", isSeries: " + value.isSeries(), false, 4, null);
                    DownloadExpandAdapter downloadExpandAdapter = this.this$0.f60655a;
                    int i11 = -1;
                    if (downloadExpandAdapter != null && (listD = downloadExpandAdapter.D()) != 0) {
                        int i12 = 0;
                        for (T t11 : listD) {
                            if ((t11 instanceof DownloadBean) && Intrinsics.b(((DownloadBean) t11).getResourceId(), value.getResourceId())) {
                                i11 = i12;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (value.isSeries() && this.this$0.f60662i == DownloadPageType.DOWNLOAD.ordinal() && i11 < 0) {
                        DownloadListManager.a aVar = DownloadListManager.f61186m;
                        DownloadListManager.x(aVar.a(), aVar.a().J(), false, this.this$0.Q0(), 2, null);
                        return;
                    }
                    if (i11 >= 0) {
                        DownloadExpandAdapter downloadExpandAdapter2 = this.this$0.f60655a;
                        if (i11 < (downloadExpandAdapter2 != null ? downloadExpandAdapter2.getItemCount() : 0)) {
                            DownloadExpandAdapter downloadExpandAdapter3 = this.this$0.f60655a;
                            Intrinsics.d(downloadExpandAdapter3);
                            Object obj = downloadExpandAdapter3.D().get(i11);
                            Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
                            DownloadBean downloadBean = (DownloadBean) obj;
                            uo.b.a.f(uo.b.f78622a, "LocalVideo-d", "observeEvent index:" + i11 + ", " + downloadBean.getTotalTitleName(), false, 4, null);
                            if (value.getReadProgress() >= 0) {
                                downloadBean.setReadProgress(value.getReadProgress());
                            }
                            if (value.getDuration() >= 0) {
                                downloadBean.setDuration(Long.valueOf(value.getDuration()));
                            }
                            if (value.getRefreshItemAll()) {
                                DownloadExpandAdapter downloadExpandAdapter4 = this.this$0.f60655a;
                                if (downloadExpandAdapter4 != null) {
                                    downloadExpandAdapter4.notifyItemChanged(i11);
                                    return;
                                }
                                return;
                            }
                            DownloadExpandAdapter downloadExpandAdapter5 = this.this$0.f60655a;
                            if (downloadExpandAdapter5 != null) {
                                downloadExpandAdapter5.notifyItemChanged(i11, downloadBean);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LocalVideoEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, kotlinx.coroutines.w0.c().q(), false, function1);
        if (this.f60662i == DownloadPageType.DOWNLOAD.ordinal()) {
            Function1<DownloadRefreshEvent, Unit> function2 = new Function1<DownloadRefreshEvent, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$initVideoObserve$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DownloadRefreshEvent downloadRefreshEvent) {
                    invoke2(downloadRefreshEvent);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DownloadRefreshEvent value) {
                    DownloadExpandAdapter downloadExpandAdapter;
                    DownloadExpandAdapter downloadExpandAdapter2;
                    List<T> listD;
                    Intrinsics.g(value, "value");
                    String resourceId = value.getResourceId();
                    if (resourceId == null || resourceId.length() == 0) {
                        DownloadListManager.a aVar = DownloadListManager.f61186m;
                        DownloadListManager.x(aVar.a(), aVar.a().J(), false, this.this$0.Q0(), 2, null);
                        return;
                    }
                    String subjectId = value.getSubjectId();
                    int i11 = -1;
                    if (subjectId != null && subjectId.length() != 0 && (downloadExpandAdapter2 = this.this$0.f60655a) != null && (listD = downloadExpandAdapter2.D()) != 0) {
                        int i12 = 0;
                        for (T t11 : listD) {
                            if ((t11 instanceof DownloadBean) && Intrinsics.b(((DownloadBean) t11).getSubjectId(), value.getSubjectId())) {
                                i11 = i12;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i11 >= 0) {
                        DownloadExpandAdapter downloadExpandAdapter3 = this.this$0.f60655a;
                        if (downloadExpandAdapter3 != null) {
                            downloadExpandAdapter3.notifyItemChanged(i11);
                            return;
                        }
                        return;
                    }
                    Integer num = DownloadListManager.f61186m.a().r().get(value.getResourceId());
                    if (num == null || num.intValue() < 0 || (downloadExpandAdapter = this.this$0.f60655a) == null) {
                        return;
                    }
                    downloadExpandAdapter.notifyItemChanged(num.intValue());
                }
            };
            FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name2 = DownloadRefreshEvent.class.getName();
            Intrinsics.f(name2, "T::class.java.name");
            flowEventBus2.observeEvent(this, name2, state, kotlinx.coroutines.w0.c().q(), false, function2);
            Function1<AddToDownloadEvent, Unit> function3 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$initVideoObserve$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AddToDownloadEvent addToDownloadEvent) {
                    invoke2(addToDownloadEvent);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AddToDownloadEvent value) {
                    AdvRecyclerView advRecyclerView;
                    Intrinsics.g(value, "value");
                    h00.y mViewBinding = this.this$0.getMViewBinding();
                    if (mViewBinding != null && (advRecyclerView = mViewBinding.f66097b) != null && advRecyclerView.isShowEmpty() && this.this$0.isVisible() && value.getAdd()) {
                        this.this$0.lazyLoadData();
                    }
                }
            };
            FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name3 = AddToDownloadEvent.class.getName();
            Intrinsics.f(name3, "T::class.java.name");
            flowEventBus3.observeEvent(this, name3, state, kotlinx.coroutines.w0.c().q(), false, function3);
        }
        Function1<j00.a, Unit> function4 = new Function1<j00.a, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$initVideoObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(j00.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(j00.a it) {
                Intrinsics.g(it, "it");
                DownloadExpandAdapter downloadExpandAdapter = this.this$0.f60655a;
                if (downloadExpandAdapter != null) {
                    downloadExpandAdapter.notifyItemChanged(0);
                }
            }
        };
        FlowEventBus flowEventBus4 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name4 = j00.a.class.getName();
        Intrinsics.f(name4, "T::class.java.name");
        flowEventBus4.observeEvent(this, name4, state, kotlinx.coroutines.w0.c().q(), false, function4);
    }

    public static final void k1(DownloadPanelFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        if (this.f60662i != DownloadPageType.DOWNLOAD.ordinal()) {
            DownloadPageType.SERIES.ordinal();
        } else {
            startLoading();
            DownloadListManager.x(DownloadListManager.f61186m.a(), false, false, this.f60670q, 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        if (this.f60662i == DownloadPageType.DOWNLOAD.ordinal()) {
            S0().r(this.f60668o, 9);
        }
    }

    private final void r1() {
        e9.a aVar;
        List<T> listD;
        DownloadExpandAdapter downloadExpandAdapter = this.f60655a;
        if (downloadExpandAdapter != null) {
            if (downloadExpandAdapter == null || (listD = downloadExpandAdapter.D()) == 0 || !listD.isEmpty()) {
                DownloadExpandAdapter downloadExpandAdapter2 = this.f60655a;
                Intrinsics.d(downloadExpandAdapter2);
                Iterator it = downloadExpandAdapter2.D().iterator();
                while (true) {
                    aVar = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    e9.a aVar2 = (e9.a) it.next();
                    DownloadBean downloadBean = aVar2 instanceof DownloadBean ? (DownloadBean) aVar2 : null;
                    String subjectId = downloadBean != null ? downloadBean.getSubjectId() : null;
                    if (subjectId != null && subjectId.length() > 0) {
                        aVar = aVar2;
                        break;
                    }
                }
                if (aVar == null) {
                    zp.b.f82110a.e(Utils.a().getString(R$string.no_error_content));
                    return;
                }
                Subject subject = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
                DownloadBean downloadBean2 = (DownloadBean) aVar;
                subject.setSubjectId(downloadBean2.getSubjectId());
                subject.setOps(downloadBean2.getOps());
                subject.setTitle(downloadBean2.getSubjectName());
                subject.setSubjectType(Integer.valueOf(DownloadBean.Companion.a(Integer.valueOf(downloadBean2.getType()))));
                if (downloadBean2.isShotTV()) {
                    DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                    Context context = getContext();
                    Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    downloadManagerApiA.a2((FragmentActivity) context, getPageName(), (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                    return;
                }
                DownloadManagerApi downloadManagerApiA2 = DownloadManagerApi.f60274j.a();
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
                String pageName = DownloadPageType.SERIES.getPageName();
                String groupId = downloadBean2.getGroupId();
                String ops = downloadBean2.getOps();
                String sourceUrl = downloadBean2.getSourceUrl();
                if (sourceUrl == null) {
                    sourceUrl = "";
                }
                downloadManagerApiA2.P1(fragmentActivityRequireActivity, subject, pageName, (960 & 8) != 0 ? "" : groupId, ops, sourceUrl, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : null, (960 & 512) != 0 ? false : false);
            }
        }
    }

    private final void t1(MovieRecBean movieRecBean) {
        List<Subject> items;
        DownloadPanelForYouFootView downloadPanelForYouFootView;
        AdvRecyclerView advRecyclerView;
        final List<Subject> items2;
        Pager pager;
        String nextPage;
        Integer numL;
        h9.f fVarQ;
        DownloadExpandAdapter downloadExpandAdapter = this.f60655a;
        int iIntValue = 1;
        if (downloadExpandAdapter != null && (fVarQ = downloadExpandAdapter.Q()) != null) {
            fVarQ.s(true);
        }
        DownloadExpandAdapter downloadExpandAdapter2 = this.f60655a;
        RecyclerView recyclerView = null;
        h9.f fVarQ2 = downloadExpandAdapter2 != null ? downloadExpandAdapter2.Q() : null;
        if (fVarQ2 != null) {
            fVarQ2.y(false);
        }
        DownloadExpandAdapter downloadExpandAdapter3 = this.f60655a;
        h9.f fVarQ3 = downloadExpandAdapter3 != null ? downloadExpandAdapter3.Q() : null;
        if (fVarQ3 != null) {
            fVarQ3.x(false);
        }
        if (movieRecBean != null && (pager = movieRecBean.getPager()) != null && (nextPage = pager.getNextPage()) != null && (numL = kotlin.text.k.l(nextPage)) != null) {
            iIntValue = numL.intValue();
        }
        this.f60668o = iIntValue;
        if (this.f60669p != null) {
            if (movieRecBean == null || (items = movieRecBean.getItems()) == null || (downloadPanelForYouFootView = this.f60669p) == null) {
                return;
            }
            downloadPanelForYouFootView.setData(items);
            return;
        }
        Context context = getContext();
        if (context != null) {
            DownloadPanelForYouFootView downloadPanelForYouFootView2 = new DownloadPanelForYouFootView(context);
            if (movieRecBean != null && (items2 = movieRecBean.getItems()) != null) {
                DownloadExpandAdapter downloadExpandAdapter4 = this.f60655a;
                if (downloadExpandAdapter4 != null) {
                    BaseQuickAdapter.o(downloadExpandAdapter4, downloadPanelForYouFootView2, 0, 0, 6, null);
                }
                downloadPanelForYouFootView2.post(new Runnable() { // from class: com.transsnet.downloader.fragment.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        DownloadPanelFragment.u1(this.f60975a, items2);
                    }
                });
            }
            downloadPanelForYouFootView2.setRefreshClickCallback(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$showFootMovieRec$1$1$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.n1();
                }
            });
            h00.y mViewBinding = getMViewBinding();
            if (mViewBinding != null && (advRecyclerView = mViewBinding.f66097b) != null) {
                recyclerView = advRecyclerView.getRecyclerView();
            }
            downloadPanelForYouFootView2.initBrowseReport(recyclerView);
            this.f60669p = downloadPanelForYouFootView2;
        }
    }

    public static final void u1(DownloadPanelFragment this$0, List data) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(data, "$data");
        DownloadPanelForYouFootView downloadPanelForYouFootView = this$0.f60669p;
        if (downloadPanelForYouFootView != null) {
            downloadPanelForYouFootView.setData(data);
        }
    }

    public static final void x1(DownloadPanelFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            this$0.X0(subject);
            this$0.R0().b(this$0.getPageName(), subject, i11);
        }
    }

    public static final void y1(DownloadPanelFragment this$0, com.transsnet.downloader.adapter.e0 this_apply, BaseQuickAdapter adapter, View view, int i11) throws InterruptedException {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        Object item = adapter.getItem(i11);
        Subject subject = item instanceof Subject ? (Subject) item : null;
        if (view.getId() == R$id.download) {
            this$0.N0(subject, this_apply.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1() {
        AdvRecyclerView advRecyclerView;
        h00.y mViewBinding;
        AdvRecyclerView advRecyclerView2;
        View viewObtainEmptyView;
        h00.y mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (advRecyclerView = mViewBinding2.f66097b) == null || !advRecyclerView.isShowEmpty() || (mViewBinding = getMViewBinding()) == null || (advRecyclerView2 = mViewBinding.f66097b) == null || (viewObtainEmptyView = advRecyclerView2.obtainEmptyView()) == null) {
            return;
        }
        final NoNetworkSmallView noNetworkSmallView = (NoNetworkSmallView) viewObtainEmptyView.findViewById(R$id.no_network_view);
        if (noNetworkSmallView != null) {
            Intrinsics.f(noNetworkSmallView, "findViewById<NoNetworkSm…ew>(R.id.no_network_view)");
            if (so.c.i(noNetworkSmallView)) {
                return;
            }
            so.c.k(noNetworkSmallView);
            noNetworkSmallView.retry(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$showNoNetworkView$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        so.c.g(noNetworkSmallView);
                    }
                    com.tn.lib.view.l.b(this.getPageName());
                }
            });
            noNetworkSmallView.goToSetting(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadPanelFragment$showNoNetworkView$1$1$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tn.lib.view.l.c(this.this$0.getPageName());
                }
            });
        }
        com.tn.lib.view.l.a(getPageName());
    }

    public final void N0(Subject subject, Context context) throws InterruptedException {
        String resourceLink;
        if (subject == null) {
            return;
        }
        Integer subjectType = subject.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        String str = "download_subject";
        if (subjectType != null && subjectType.intValue() == value) {
            DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
            Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            downloadManagerApiA.a2((FragmentActivity) context, getPageName(), (384 & 4) != 0 ? "" : "", null, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
            R0().c(getPageName(), subject, "download_subject");
            return;
        }
        if (com.transsion.baselib.utils.m.f51320a.b()) {
            X0(subject);
            R0().c(getPageName(), subject, "play_subject");
            return;
        }
        DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
        DownloadManagerApi downloadManagerApiA2 = aVar.a();
        String subjectId = subject.getSubjectId();
        ResourceDetectors resourceDetector = subject.getResourceDetector();
        if (DownloadManagerApi.n2(downloadManagerApiA2, subjectId, resourceDetector != null ? resourceDetector.getResourceId() : null, subject.isSeries(), false, 8, null)) {
            String subjectId2 = subject.getSubjectId();
            if (subjectId2 != null) {
                DownloadManagerApi.p2(aVar.a(), subjectId2, context, getPageName(), null, 8, null);
            }
            str = "play_subject";
        } else {
            DownloadManagerApi downloadManagerApiA3 = aVar.a();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            String pageName = getPageName();
            String ops = subject.getOps();
            ResourceDetectors resourceDetector2 = subject.getResourceDetector();
            if (resourceDetector2 == null || (resourceLink = resourceDetector2.getResourceLink()) == null) {
                resourceLink = "";
            }
            downloadManagerApiA3.P1(fragmentActivityRequireActivity, subject, pageName, (960 & 8) != 0 ? "" : null, ops, resourceLink, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : null, (960 & 512) != 0 ? false : false);
        }
        R0().c(getPageName(), subject, str);
    }

    public final com.transsion.ad.bidding.nativead.c Q0() {
        return this.f60670q;
    }

    public final com.transsnet.downloader.report.a R0() {
        return (com.transsnet.downloader.report.a) this.f60661h.getValue();
    }

    public final int U0(String str) {
        List<T> listD;
        DownloadExpandAdapter downloadExpandAdapter = this.f60655a;
        int size = (downloadExpandAdapter == null || (listD = downloadExpandAdapter.D()) == 0) ? 0 : listD.size();
        for (int i11 = 0; i11 < size; i11++) {
            DownloadExpandAdapter downloadExpandAdapter2 = this.f60655a;
            Intrinsics.d(downloadExpandAdapter2);
            e9.a aVar = (e9.a) downloadExpandAdapter2.D().get(i11);
            if ((aVar instanceof DownloadBean) && Intrinsics.b(((DownloadBean) aVar).getResourceId(), str)) {
                return i11;
            }
        }
        return -1;
    }

    public final com.transsion.ad.bidding.nativead.c V0() {
        return this.f60671r;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public h00.y getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.y yVarC = h00.y.c(inflater);
        Intrinsics.f(yVarC, "inflate(inflater)");
        return yVarC;
    }

    public final boolean Y0() {
        com.transsnet.downloader.adapter.e0 e0Var = this.f60660g;
        return e0Var != null && e0Var.getItemCount() > 0;
    }

    public final void Z0() {
        AdvRecyclerView advRecyclerView;
        h00.y mViewBinding;
        AdvRecyclerView advRecyclerView2;
        View viewObtainEmptyView;
        LinearLayoutCompat linearLayoutCompat;
        h9.f fVarQ;
        DownloadExpandAdapter downloadExpandAdapter = this.f60655a;
        if (downloadExpandAdapter != null && (fVarQ = downloadExpandAdapter.Q()) != null) {
            fVarQ.s(true);
        }
        DownloadExpandAdapter downloadExpandAdapter2 = this.f60655a;
        h9.f fVarQ2 = downloadExpandAdapter2 != null ? downloadExpandAdapter2.Q() : null;
        if (fVarQ2 != null) {
            fVarQ2.y(false);
        }
        DownloadExpandAdapter downloadExpandAdapter3 = this.f60655a;
        h9.f fVarQ3 = downloadExpandAdapter3 != null ? downloadExpandAdapter3.Q() : null;
        if (fVarQ3 != null) {
            fVarQ3.x(false);
        }
        h00.y mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (advRecyclerView = mViewBinding2.f66097b) == null || !advRecyclerView.isShowEmpty() || (mViewBinding = getMViewBinding()) == null || (advRecyclerView2 = mViewBinding.f66097b) == null || (viewObtainEmptyView = advRecyclerView2.obtainEmptyView()) == null || (linearLayoutCompat = (LinearLayoutCompat) viewObtainEmptyView.findViewById(R$id.ll_movie_rec)) == null) {
            return;
        }
        Intrinsics.f(linearLayoutCompat, "findViewById<LinearLayou…ompat>(R.id.ll_movie_rec)");
        so.c.g(linearLayoutCompat);
    }

    public final void a1() {
        AdvRecyclerView advRecyclerView;
        h00.y mViewBinding;
        AdvRecyclerView advRecyclerView2;
        View viewObtainEmptyView;
        RecyclerView recyclerView;
        h00.y mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (advRecyclerView = mViewBinding2.f66097b) == null || !advRecyclerView.isShowEmpty() || (mViewBinding = getMViewBinding()) == null || (advRecyclerView2 = mViewBinding.f66097b) == null || (viewObtainEmptyView = advRecyclerView2.obtainEmptyView()) == null || (recyclerView = (RecyclerView) viewObtainEmptyView.findViewById(R$id.movie_rec_list)) == null) {
            return;
        }
        Intrinsics.f(recyclerView, "findViewById<RecyclerView>(R.id.movie_rec_list)");
        so.c.g(recyclerView);
    }

    public final void b1() {
        AdvRecyclerView advRecyclerView;
        h00.y mViewBinding;
        AdvRecyclerView advRecyclerView2;
        View viewObtainEmptyView;
        NoNetworkSmallView noNetworkSmallView;
        h00.y mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (advRecyclerView = mViewBinding2.f66097b) == null || !advRecyclerView.isShowEmpty() || (mViewBinding = getMViewBinding()) == null || (advRecyclerView2 = mViewBinding.f66097b) == null || (viewObtainEmptyView = advRecyclerView2.obtainEmptyView()) == null || (noNetworkSmallView = (NoNetworkSmallView) viewObtainEmptyView.findViewById(R$id.no_network_view)) == null) {
            return;
        }
        Intrinsics.f(noNetworkSmallView, "findViewById<NoNetworkSm…ew>(R.id.no_network_view)");
        so.c.g(noNetworkSmallView);
    }

    public final void f1(DownloadBean downloadBean) {
        Object next;
        if (downloadBean.getSeriesList().isEmpty()) {
            return;
        }
        Iterator<T> it = downloadBean.getSeriesList().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((DownloadBean) next).getStatus() != 14);
        if (((DownloadBean) next) != null) {
            if (downloadBean.getSeriesList().size() == 1) {
                downloadBean.getSeriesList().clear();
            }
        } else if (downloadBean.getTotalEpisode() > downloadBean.getSeriesList().size()) {
            DownloadBean downloadBean2 = new DownloadBean("allEp", "allEp", downloadBean.getType() == 1 ? Utils.a().getResources().getString(com.transsnet.downloader.R$string.download_series_all_chapters) : Utils.a().getResources().getString(com.transsnet.downloader.R$string.download_series_all_episodes), "", 0L, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
            downloadBean2.setStatus(14);
            downloadBean.getSeriesList().add(downloadBean2);
        }
    }

    public final void g1() {
        AdvRecyclerView advRecyclerView;
        TextView textView;
        h00.y mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f66097b) == null || (textView = (TextView) advRecyclerView.findViewById(R$id.tv_transfer)) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadPanelFragment.h1(this.f60969a, view);
            }
        });
    }

    public final void i1() {
        setNetListener(new h());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        initViewModel();
        c1();
        j1();
        i1();
        this.f60666m = RoomAppMMKV.f51271a.a().getBoolean("download_transfer_later_guide", true);
        if (this.f60662i == DownloadPageType.DOWNLOAD.ordinal() || this.f60662i != DownloadPageType.SERIES.ordinal()) {
            return;
        }
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        SwipeRefreshLayout swipeRefreshLayout;
        Intrinsics.g(view, "view");
        IAudioApi iAudioApiO0 = O0();
        if (iAudioApiO0 != null) {
            iAudioApiO0.addPlayerListener(this.f60674u);
        }
        if (this.f60662i == DownloadPageType.DOWNLOAD.ordinal()) {
            P0().f(this.f60675v);
        }
        h00.y mViewBinding = getMViewBinding();
        if (mViewBinding == null || (swipeRefreshLayout = mViewBinding.f66098c) == null) {
            return;
        }
        if (this.f60662i == DownloadPageType.SERIES.ordinal()) {
            swipeRefreshLayout.setEnabled(false);
        }
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(z2.a.getColor(swipeRefreshLayout.getContext(), R$color.bg_01));
        swipeRefreshLayout.setColorSchemeColors(z2.a.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_center), z2.a.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_start));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsnet.downloader.fragment.q
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                DownloadPanelFragment.k1(this.f60950a);
            }
        });
    }

    public final void l1(List<DownloadBean> list) {
        if (list.isEmpty()) {
            return;
        }
        boolean z11 = false;
        boolean z12 = false;
        for (DownloadBean downloadBean : list) {
            if (!z11 && downloadBean.getStatus() < 10) {
                z11 = true;
            }
            if (downloadBean.getAdProvide() != null || downloadBean.getWrapNativeManager() != null) {
                z12 = true;
            }
        }
        if (!z11) {
            list.clear();
            return;
        }
        if (z12) {
            return;
        }
        DownloadBean downloadBean2 = new DownloadBean("ad", "ad", "ad", "", 0L, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
        downloadBean2.setStatus(13);
        downloadBean2.setWrapNativeManager(this.f60671r);
        int iF = wq.a.f(wq.a.f79581a, "DownloadTvListScene", 0, 2, null);
        com.transsion.ad.a.h(com.transsion.ad.a.f50276a, "DownloadPanelFragment --> 电视剧列表准备插入广告 --> adPosition = " + iF, false, 2, null);
        if (iF >= list.size()) {
            list.add(downloadBean2);
        } else {
            list.add(iF, downloadBean2);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        m1();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    public final void o1() {
        if (Build.VERSION.SDK_INT < 23 || !this.f60667n) {
            return;
        }
        this.f60667n = false;
        DownloadExpandAdapter downloadExpandAdapter = this.f60655a;
        if (downloadExpandAdapter != null) {
            downloadExpandAdapter.notifyItemChanged(0);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        DownloadPanelForYouFootView downloadPanelForYouFootView = this.f60669p;
        if (downloadPanelForYouFootView != null) {
            downloadPanelForYouFootView.configChange();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f60662i = arguments != null ? arguments.getInt("extra_page_type") : 0;
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).w(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        com.transsion.ad.bidding.nativead.c cVar;
        IAudioApi iAudioApiO0 = O0();
        if (iAudioApiO0 != null) {
            iAudioApiO0.removePlayerListener(this.f60674u);
        }
        super.onDestroy();
        if (this.f60662i == DownloadPageType.DOWNLOAD.ordinal()) {
            com.transsion.ad.bidding.nativead.c cVar2 = this.f60670q;
            if (cVar2 != null) {
                cVar2.F();
            }
            P0().v(this.f60675v);
        } else if (this.f60662i == DownloadPageType.SERIES.ordinal() && (cVar = this.f60671r) != null) {
            cVar.F();
        }
        L0();
        this.f60672s = false;
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).V0(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (!z11) {
            p1();
        }
        if (isResumed() && z11) {
            this.f60673t.f();
        }
        if (isResumed()) {
            if (z11) {
                logPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // su.e
    public void onMemberStateChange() {
        com.transsion.ad.bidding.nativead.c cVar = this.f60670q;
        if (cVar != null) {
            cVar.F();
        }
        this.f60670q = null;
        DownloadListManager.x(DownloadListManager.f61186m.a(), false, false, null, 3, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f60673t.f();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DownloadPanelForYouFootView downloadPanelForYouFootView = this.f60669p;
        if (downloadPanelForYouFootView != null) {
            downloadPanelForYouFootView.onPageResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (isVisible()) {
            if (this.f60663j) {
                this.f60663j = false;
            } else if (this.f60662i == DownloadPageType.DOWNLOAD.ordinal()) {
                DownloadListManager.a aVar = DownloadListManager.f61186m;
                DownloadListManager.x(aVar.a(), aVar.a().J(), false, this.f60670q, 2, null);
            }
        }
    }

    public final void p1() {
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        DownloadListManager.x(aVar.a(), aVar.a().J(), false, this.f60670q, 2, null);
    }

    public final void q1(com.transsion.ad.bidding.nativead.c cVar) {
        this.f60671r = cVar;
    }

    public final void s1() {
        AdvRecyclerView advRecyclerView;
        h00.y mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f66097b) == null) {
            return;
        }
        advRecyclerView.showData();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        AdvRecyclerView advRecyclerView;
        h00.y mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f66097b) == null) {
            return;
        }
        advRecyclerView.showProgress();
    }

    public final void v1(MovieRecBean movieRecBean) {
        AdvRecyclerView advRecyclerView;
        if (this.f60662i != DownloadPageType.DOWNLOAD.ordinal()) {
            return;
        }
        h00.y mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f66097b) == null || !advRecyclerView.isShowEmpty()) {
            t1(movieRecBean);
            return;
        }
        com.transsnet.downloader.adapter.e0 e0Var = this.f60660g;
        if (e0Var != null) {
            e0Var.w0(movieRecBean != null ? movieRecBean.getItems() : null);
        }
    }

    public final void w1() {
        AdvRecyclerView advRecyclerView;
        AdvRecyclerView advRecyclerView2;
        View viewObtainEmptyView;
        RecyclerView recyclerView;
        if (this.f60662i != DownloadPageType.DOWNLOAD.ordinal()) {
            return;
        }
        h00.y mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f66097b) == null || !advRecyclerView.isShowEmpty()) {
            n1();
            return;
        }
        h00.y mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (advRecyclerView2 = mViewBinding2.f66097b) == null || (viewObtainEmptyView = advRecyclerView2.obtainEmptyView()) == null || (recyclerView = (RecyclerView) viewObtainEmptyView.findViewById(R$id.movie_rec_list)) == null) {
            return;
        }
        Intrinsics.f(recyclerView, "findViewById<RecyclerView>(R.id.movie_rec_list)");
        so.c.k(recyclerView);
        if (Y0()) {
            return;
        }
        DownloadViewModel downloadViewModelS0 = S0();
        if (downloadViewModelS0 != null) {
            downloadViewModelS0.r(1, 9);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        final com.transsnet.downloader.adapter.e0 e0Var = new com.transsnet.downloader.adapter.e0(new ArrayList());
        e0Var.B0(new f9.d() { // from class: com.transsnet.downloader.fragment.t
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadPanelFragment.x1(this.f60960a, baseQuickAdapter, view, i11);
            }
        });
        e0Var.i(R$id.download);
        e0Var.z0(new f9.b() { // from class: com.transsnet.downloader.fragment.u
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) throws InterruptedException {
                DownloadPanelFragment.y1(this.f60963a, e0Var, baseQuickAdapter, view, i11);
            }
        });
        this.f60660g = e0Var;
        recyclerView.setAdapter(e0Var);
        recyclerView.addOnScrollListener(this.f60673t);
    }
}
