package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.noober.background.view.BLTextView;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.adapter.ResourceDetectorAloneAdapter;
import com.transsion.moviedetail.adapter.ResourceDetectorCollectionAdapter;
import com.transsion.moviedetail.adapter.ResourceDetectorMultiResolutionAdapter;
import com.transsion.moviedetail.view.WatchModeTipsView;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.api.IStreamDetailService;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.util.DownloadUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class ResourceDetectorFragment extends PageStatusFragment<tu.l> {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f53517y = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f53518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Subject f53519l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f53521n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f53522o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f53523p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ResourceDetectorCollectionAdapter f53525r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f53528u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f53529v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f53531x;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f53520m = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Map<Integer, List<DownloadItem>> f53524q = new LinkedHashMap();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f53526s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f53527t = 480;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f53530w = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.player.longvideo.helper.w.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment$special$$inlined$activityViewModels$default$3
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment$special$$inlined$activityViewModels$default$4
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
    public static final class b implements su.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f53533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DownloadItem f53534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List<ResourceDetectors> f53535d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ResourceDetectorMultiResolutionAdapter f53536e;

        public b(int i11, DownloadItem downloadItem, List<ResourceDetectors> list, ResourceDetectorMultiResolutionAdapter resourceDetectorMultiResolutionAdapter) {
            this.f53533b = i11;
            this.f53534c = downloadItem;
            this.f53535d = list;
            this.f53536e = resourceDetectorMultiResolutionAdapter;
        }

        @Override // su.a
        public void a(MemberCheckResult memberCheckResult) {
            su.a.C0841a.f(this, memberCheckResult);
        }

        @Override // su.a
        public void b(MemberCheckResult memberCheckResult) {
            su.a.C0841a.d(this, memberCheckResult);
        }

        @Override // su.a
        public void c(MemberCheckResult memberCheckResult) {
            su.a.C0841a.e(this, memberCheckResult);
        }

        @Override // su.a
        public void d() throws InterruptedException {
            su.a.C0841a.c(this);
            if (!ResourceDetectorFragment.this.isAdded() || ResourceDetectorFragment.this.isDetached()) {
                return;
            }
            ResourceDetectorFragment.this.R1(this.f53533b, this.f53534c, this.f53535d.get(0).getTotalEpisode());
        }

        @Override // su.a
        public void e(MemberCheckResult memberCheckResult) {
            su.a.C0841a.a(this, memberCheckResult);
        }

        @Override // su.a
        public void onFail(String errorMsg) throws InterruptedException {
            String resourceId;
            Context context;
            Intrinsics.g(errorMsg, "errorMsg");
            su.a.C0841a.b(this, errorMsg);
            uo.b.a.f(uo.b.f78622a, "co_mem", "ResourceDetectorFragment --> immediateShowList() --> 单集多分辨率 --> " + errorMsg, false, 4, null);
            if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                zp.b.f82110a.d(R$string.no_network_toast);
            }
            if (!ResourceDetectorFragment.this.isAdded() || ResourceDetectorFragment.this.isDetached()) {
                return;
            }
            DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
            DownloadManagerApi downloadManagerApiA = aVar.a();
            String resourceId2 = this.f53534c.getResourceId();
            Subject subjectH0 = this.f53536e.H0();
            if (!DownloadManagerApi.n2(downloadManagerApiA, null, resourceId2, subjectH0 != null ? subjectH0.isSeries() : false, false, 8, null) || (resourceId = this.f53534c.getResourceId()) == null || (context = this.f53536e.getContext()) == null) {
                return;
            }
            aVar.a().o2(null, context, "subjectdetail", resourceId);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53537a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53537a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53537a;
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
            this.f53537a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends RecyclerView.l {
        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            int itemCount = adapter != null ? adapter.getItemCount() : 0;
            if (childAdapterPosition == 0) {
                outRect.left = 0;
                outRect.right = gs.a.a(4);
            } else if (childAdapterPosition == itemCount - 1) {
                outRect.left = gs.a.a(4);
                outRect.right = 0;
            } else {
                outRect.left = gs.a.a(4);
                outRect.right = gs.a.a(4);
            }
        }
    }

    public static final void B1(ResourceDetectorMultiResolutionAdapter this_apply, ResourceDetectorFragment this$0, List it, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(it, "$it");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        DownloadItem downloadItem = this_apply.D().get(i11);
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).i(downloadItem.getResolution(), this$0.new b(i11, downloadItem, it, this_apply));
    }

    public static final void C1(ResourceDetectorFragment this$0, BaseQuickAdapter adapter, View view, int i11) throws InterruptedException {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.Q1(i11);
    }

    public static final void E1(final ResourceDetectorFragment this$0, View view) {
        String subjectId;
        Fragment parentFragment;
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "VideoEpisodeFragment", "tvLanguage click then switch audio track", false, 4, null);
        Subject subject = this$0.f53519l;
        if (subject == null || (subjectId = subject.getSubjectId()) == null || (parentFragment = this$0.getParentFragment()) == null) {
            return;
        }
        IStreamDetailService iStreamDetailService = (IStreamDetailService) com.alibaba.android.arouter.launcher.a.d().h(IStreamDetailService.class);
        Intrinsics.f(parentFragment, "parentFragment");
        iStreamDetailService.K0(parentFragment, R$id.fl_bottom_dialog_container, subjectId, new Function1<DubsInfo, Unit>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment$initListener$4$1$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DubsInfo dubsInfo) {
                invoke2(dubsInfo);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DubsInfo info) {
                Intrinsics.g(info, "info");
                this.this$0.N1(info);
            }
        });
    }

    public static final void F1(ResourceDetectorFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = this$0.f53519l;
        postcardWithString.withString("subject_id", subject != null ? subject.getSubjectId() : null).navigation();
    }

    public static final void G1(ResourceDetectorFragment this$0, View view) {
        List<ResourceDetectors> resourceDetectors;
        String title;
        Intrinsics.g(this$0, "this$0");
        Subject subject = this$0.f53519l;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null || !(!resourceDetectors.isEmpty())) {
            return;
        }
        ResourceDetectors resourceDetectors2 = resourceDetectors.get(0);
        ResourceDetectorDialogFragment.a aVar = ResourceDetectorDialogFragment.f53509f;
        Subject subject2 = this$0.f53519l;
        if (subject2 == null || (title = subject2.getTitle()) == null) {
            title = "";
        }
        ResourceDetectorDialogFragment resourceDetectorDialogFragmentA = aVar.a(title, resourceDetectors2);
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        resourceDetectorDialogFragmentA.show(childFragmentManager, "ResourceDetectorFragment --> ");
    }

    public static final void H1(ResourceDetectorFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = this$0.f53519l;
        postcardWithString.withString("subject_id", subject != null ? subject.getSubjectId() : null).navigation();
    }

    public static final void I1(ResourceDetectorFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.T1();
    }

    public static final void K1(View view) {
        zp.b.f82110a.d(com.transsion.moviedetail.R$string.movie_detail_res_loading);
    }

    public static final void P1(ResourcesSeasonList resourcesSeasonList, final ResourceDetectorFragment this$0, final List seasons, final BLTextView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(seasons, "$seasons");
        Intrinsics.g(this_apply, "$this_apply");
        VideoDetailSeasonsSelectFragment.a aVar = VideoDetailSeasonsSelectFragment.f53627r;
        Subject subject = this$0.f53519l;
        VideoDetailSeasonsSelectFragment videoDetailSeasonsSelectFragmentA = aVar.a(resourcesSeasonList, subject != null ? subject.getSubjectType() : null);
        videoDetailSeasonsSelectFragmentA.d1(this$0.f53526s);
        Fragment parentFragment = this$0.getParentFragment();
        if (parentFragment != null) {
            videoDetailSeasonsSelectFragmentA.T0(parentFragment, R$id.fl_bottom_dialog_container);
        }
        videoDetailSeasonsSelectFragmentA.c1(new Function1<Integer, Unit>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment$onGetSeason$1$1$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                Object next;
                Iterator<T> it = seasons.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (((ResourcesSeason) next).getSe() != i11);
                ResourcesSeason resourcesSeason = (ResourcesSeason) next;
                if (resourcesSeason == null) {
                    return;
                }
                this$0.f53526s = resourcesSeason.getSe();
                tu.l mViewBinding = this$0.getMViewBinding();
                BLTextView bLTextView = mViewBinding != null ? mViewBinding.f77532g : null;
                if (bLTextView != null) {
                    Context context = this_apply.getContext();
                    bLTextView.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, String.valueOf(this$0.f53526s)) : null);
                }
                this$0.x1().u().q(Integer.valueOf(this$0.f53526s));
                this$0.S1(com.transsion.baseui.util.l.a(resourcesSeason.getSe()));
                if (this$0.f53524q.containsKey(Integer.valueOf(resourcesSeason.getSe()))) {
                    uo.b.a.f(uo.b.f78622a, "ResourceDetectorFragment --> ", "se:" + this$0.f53526s + " 已有缓存, 直接设数据", false, 4, null);
                    List list = (List) this$0.f53524q.get(Integer.valueOf(resourcesSeason.getSe()));
                    if (list != null) {
                        this$0.U1(list, Integer.valueOf(resourcesSeason.getMaxEp()));
                        return;
                    }
                    return;
                }
                this$0.W1();
                int iK = DownloadUtil.f61136a.k(seasons, this$0.f53526s);
                if (iK <= 0) {
                    iK = this$0.f53527t;
                }
                int i12 = iK;
                uo.b.f78622a.c("ResourceDetectorFragment --> ", "se:" + this$0.f53526s + " 无缓存，请求数据, resolution:" + i12, true);
                MovieDetailViewModel movieDetailViewModelX1 = this$0.x1();
                Subject subject2 = this$0.f53519l;
                movieDetailViewModelX1.l(subject2 != null ? subject2.getSubjectId() : null, resourcesSeason.getSe(), 1, 3, i12);
            }
        });
    }

    public static final void V1(Ref.ObjectRef list, ResourceDetectorFragment this$0, Integer num, BaseQuickAdapter adapter, View view, int i11) throws InterruptedException {
        Intrinsics.g(list, "$list");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (((List) list.element).size() > i11) {
            this$0.R1(i11, (DownloadItem) ((List) list.element).get(i11), num);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1() {
        FrameLayout frameLayout;
        tu.l mViewBinding = getMViewBinding();
        if (mViewBinding == null || (frameLayout = mViewBinding.f77533h) == null) {
            return;
        }
        so.c.k(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        FrameLayout frameLayout;
        tu.l mViewBinding = getMViewBinding();
        if (mViewBinding == null || (frameLayout = mViewBinding.f77533h) == null) {
            return;
        }
        so.c.g(frameLayout);
    }

    public static final void v1(ResourceDetectorFragment this$0) throws InterruptedException {
        Context cxt;
        Intrinsics.g(this$0, "this$0");
        String str = this$0.f53523p;
        if (str == null || (cxt = this$0.getContext()) == null) {
            return;
        }
        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
        Intrinsics.f(cxt, "cxt");
        downloadManagerApiA.o2(null, cxt, "subjectdetail", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MovieDetailViewModel x1() {
        return (MovieDetailViewModel) this.f53520m.getValue();
    }

    public final void A1() {
        final List<ResourceDetectors> resourceDetectors;
        tu.l mViewBinding;
        RecyclerView recyclerView;
        Subject subject = this.f53519l;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null || resourceDetectors.isEmpty() || (mViewBinding = getMViewBinding()) == null || (recyclerView = mViewBinding.f77537l) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(new ro.h(com.blankj.utilcode.util.f0.a(8.0f)));
        if (resourceDetectors.get(0).isMultiResolution()) {
            final ResourceDetectorMultiResolutionAdapter resourceDetectorMultiResolutionAdapter = new ResourceDetectorMultiResolutionAdapter(this.f53519l, resourceDetectors.get(0).getResolutionList());
            resourceDetectorMultiResolutionAdapter.i(R$id.itemRoot);
            resourceDetectorMultiResolutionAdapter.z0(new f9.b() { // from class: com.transsion.moviedetail.fragment.c0
                @Override // f9.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    ResourceDetectorFragment.B1(resourceDetectorMultiResolutionAdapter, this, resourceDetectors, baseQuickAdapter, view, i11);
                }
            });
            recyclerView.setAdapter(resourceDetectorMultiResolutionAdapter);
            return;
        }
        ResourceDetectorAloneAdapter resourceDetectorAloneAdapter = new ResourceDetectorAloneAdapter(this.f53519l, resourceDetectors);
        resourceDetectorAloneAdapter.i(R$id.itemRoot);
        resourceDetectorAloneAdapter.z0(new f9.b() { // from class: com.transsion.moviedetail.fragment.t
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) throws InterruptedException {
                ResourceDetectorFragment.C1(this.f53678a, baseQuickAdapter, view, i11);
            }
        });
        recyclerView.setAdapter(resourceDetectorAloneAdapter);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.f53519l = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.f53521n = arguments2 != null ? arguments2.getString("ops") : null;
        Bundle arguments3 = getArguments();
        this.f53522o = arguments3 != null ? arguments3.getBoolean("auto_play") : false;
        Bundle arguments4 = getArguments();
        this.f53523p = arguments4 != null ? arguments4.getString("auto_play_resource_id") : null;
        Bundle arguments5 = getArguments();
        this.f53518k = arguments5 != null ? arguments5.getString("module_name") : null;
        Bundle arguments6 = getArguments();
        int i11 = arguments6 != null ? arguments6.getInt("season") : 1;
        this.f53526s = i11;
        if (i11 <= 0) {
            this.f53526s = 1;
        }
    }

    public final void D1(List<DubsInfo> list) {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final void J1() {
        FrameLayout frameLayout;
        tu.l mViewBinding = getMViewBinding();
        if (mViewBinding == null || (frameLayout = mViewBinding.f77533h) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResourceDetectorFragment.K1(view);
            }
        });
    }

    public final void L1() {
        List<ResourcesSeason> seasons;
        if (this.f53529v && this.f53528u && this.f53526s > 1) {
            tu.l mViewBinding = getMViewBinding();
            BLTextView bLTextView = mViewBinding != null ? mViewBinding.f77532g : null;
            if (bLTextView != null) {
                Context context = getContext();
                bLTextView.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, String.valueOf(this.f53526s)) : null);
            }
            ResourcesSeasonList resourcesSeasonListF = x1().v().f();
            if (resourcesSeasonListF == null || (seasons = resourcesSeasonListF.getSeasons()) == null) {
                return;
            }
            int iK = DownloadUtil.f61136a.k(seasons, this.f53526s);
            if (iK <= 0) {
                iK = this.f53527t;
            }
            int i11 = iK;
            uo.b.f78622a.c("ResourceDetectorFragment --> ", "initOtherSe se:" + this.f53526s + " resolution:" + i11, true);
            MovieDetailViewModel movieDetailViewModelX1 = x1();
            Subject subject = this.f53519l;
            movieDetailViewModelX1.l(subject != null ? subject.getSubjectId() : null, this.f53526s, 1, 3, i11);
        }
    }

    public final boolean M1() {
        List<ResourceDetectors> resourceDetectors;
        Subject subject = this.f53519l;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null || !(!resourceDetectors.isEmpty())) {
            return false;
        }
        return resourceDetectors.get(0).isCollection();
    }

    public final void N1(DubsInfo dubsInfo) {
        x1().z().q(dubsInfo);
    }

    public final void O1(final ResourcesSeasonList resourcesSeasonList, final List<ResourcesSeason> list) {
        BLTextView bLTextView;
        tu.l mViewBinding;
        final BLTextView onGetSeason$lambda$16$lambda$15;
        if (list == null || list.size() <= 1) {
            tu.l mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (bLTextView = mViewBinding2.f77532g) == null) {
                return;
            }
            so.c.g(bLTextView);
            return;
        }
        if (list == null || (mViewBinding = getMViewBinding()) == null || (onGetSeason$lambda$16$lambda$15 = mViewBinding.f77532g) == null) {
            return;
        }
        Intrinsics.f(onGetSeason$lambda$16$lambda$15, "onGetSeason$lambda$16$lambda$15");
        so.c.k(onGetSeason$lambda$16$lambda$15);
        onGetSeason$lambda$16$lambda$15.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResourceDetectorFragment.P1(resourcesSeasonList, this, list, onGetSeason$lambda$16$lambda$15, view);
            }
        });
    }

    public final void Q1(int i11) throws InterruptedException {
        String str;
        boolean z11;
        List<ResourceDetectors> resourceDetectors;
        String subjectId;
        Context cxt;
        List<ResourceDetectors> resourceDetectors2;
        String resourceLink;
        Subject subject = this.f53519l;
        String str2 = "";
        if (subject == null || (resourceDetectors2 = subject.getResourceDetectors()) == null) {
            str = "";
            z11 = false;
        } else {
            if (!resourceDetectors2.isEmpty()) {
                resourceLink = resourceDetectors2.get(0).getResourceLink();
                if (resourceLink == null) {
                    resourceLink = "";
                }
                String resourceId = resourceDetectors2.get(0).getResourceId();
                str2 = resourceId != null ? resourceId : "";
                z11 = resourceDetectors2.get(0).isMultiResolution();
                str = resourceLink;
            } else {
                resourceLink = "";
            }
            str = resourceLink;
        }
        DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
        DownloadManagerApi downloadManagerApiA = aVar.a();
        Subject subject2 = this.f53519l;
        String subjectId2 = subject2 != null ? subject2.getSubjectId() : null;
        Subject subject3 = this.f53519l;
        if (downloadManagerApiA.m2(subjectId2, str2, subject3 != null ? subject3.isSeries() : false, z11)) {
            Subject subject4 = this.f53519l;
            if (subject4 == null || (subjectId = subject4.getSubjectId()) == null || (cxt = getContext()) == null) {
                return;
            }
            DownloadManagerApi downloadManagerApiA2 = aVar.a();
            Intrinsics.f(cxt, "cxt");
            DownloadManagerApi.p2(downloadManagerApiA2, subjectId, cxt, "subjectdetail", null, 8, null);
            return;
        }
        Subject subject5 = this.f53519l;
        if (subject5 == null || (resourceDetectors = subject5.getResourceDetectors()) == null || !(!resourceDetectors.isEmpty())) {
            return;
        }
        ResourceDetectors resourceDetectors3 = resourceDetectors.get(0);
        if (resourceDetectors3 == null || !resourceDetectors3.isMultiResolution()) {
            DownloadManagerApi downloadManagerApiA3 = aVar.a();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            DownloadManagerApi.S1(downloadManagerApiA3, fragmentActivityRequireActivity, this.f53519l, "subjectdetail", null, this.f53521n, str, null, this.f53518k, null, false, this.f53526s, false, 840, null);
            return;
        }
        List<DownloadItem> resolutionList = resourceDetectors3.getResolutionList();
        DownloadItem downloadItem = resolutionList != null ? resolutionList.get(i11) : null;
        if (downloadItem != null) {
            w1(downloadItem, 1, 1, i11);
        }
    }

    public final void R1(int i11, DownloadItem downloadItem, Integer num) throws InterruptedException {
        List<ResourceDetectors> resourceDetectors;
        Context cxt;
        DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
        DownloadManagerApi downloadManagerApiA = aVar.a();
        String resourceId = downloadItem.getResourceId();
        Subject subject = this.f53519l;
        if (DownloadManagerApi.n2(downloadManagerApiA, null, resourceId, subject != null ? subject.isSeries() : false, false, 8, null)) {
            String resourceId2 = downloadItem.getResourceId();
            if (resourceId2 == null || (cxt = getContext()) == null) {
                return;
            }
            DownloadManagerApi downloadManagerApiA2 = aVar.a();
            Intrinsics.f(cxt, "cxt");
            downloadManagerApiA2.o2(null, cxt, "subjectdetail", resourceId2);
            return;
        }
        Subject subject2 = this.f53519l;
        if (subject2 == null || (resourceDetectors = subject2.getResourceDetectors()) == null || !(!resourceDetectors.isEmpty())) {
            return;
        }
        ResourceDetectors resourceDetectors2 = resourceDetectors.get(0);
        if (resourceDetectors2 == null || !resourceDetectors2.isMultiResolution()) {
            w1(downloadItem, num, 0, i11);
            return;
        }
        List<DownloadItem> resolutionList = resourceDetectors2.getResolutionList();
        DownloadItem downloadItem2 = resolutionList != null ? resolutionList.get(i11) : null;
        if (downloadItem2 != null) {
            w1(downloadItem2, num, 1, i11);
        }
    }

    public final void S1(String str) {
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", "season_tab");
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, str);
        Unit unit = Unit.f68710a;
        mVar.m("subjectdetail", "click", linkedHashMap);
    }

    public final void T1() {
        List<ResourceDetectors> resourceDetectors;
        String resourceLink;
        Subject subject = this.f53519l;
        String str = "";
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && (!resourceDetectors.isEmpty()) && (resourceLink = resourceDetectors.get(0).getResourceLink()) != null) {
            str = resourceLink;
        }
        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        DownloadManagerApi.S1(downloadManagerApiA, fragmentActivityRequireActivity, this.f53519l, "subjectdetail", null, this.f53521n, str, null, this.f53518k, null, false, this.f53526s, false, 840, null);
    }

    /* JADX WARN: Type inference failed for: r10v9, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.ArrayList] */
    public final void U1(List<DownloadItem> list, final Integer num) {
        RecyclerView recyclerView;
        String title;
        BLTextView bLTextView;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        Context context = getContext();
        int i11 = (context == null || !com.transsion.baseui.util.b.a(context)) ? 3 : 6;
        if (list.size() > i11) {
            objectRef.element = list.subList(0, i11);
            tu.l mViewBinding = getMViewBinding();
            if (mViewBinding != null && (bLTextView = mViewBinding.f77539n) != null) {
                so.c.k(bLTextView);
            }
        } else {
            ((List) objectRef.element).addAll(list);
        }
        try {
            Result.Companion companion = Result.Companion;
            ResourceDetectorCollectionAdapter resourceDetectorCollectionAdapter = this.f53525r;
            if (resourceDetectorCollectionAdapter != null) {
                if (resourceDetectorCollectionAdapter != null) {
                    resourceDetectorCollectionAdapter.w0((Collection) objectRef.element);
                    return;
                }
                return;
            }
            tu.l mViewBinding2 = getMViewBinding();
            RecyclerView recyclerView2 = null;
            if (mViewBinding2 != null && (recyclerView = mViewBinding2.f77537l) != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), i11));
                recyclerView.addItemDecoration(new d());
                Subject subject = this.f53519l;
                if (subject == null || (title = subject.getTitle()) == null) {
                    title = "";
                }
                Subject subject2 = this.f53519l;
                String str = (subject2 != null ? subject2.getDuration() : null);
                List list2 = (List) objectRef.element;
                Subject subject3 = this.f53519l;
                ResourceDetectorCollectionAdapter resourceDetectorCollectionAdapter2 = new ResourceDetectorCollectionAdapter(title, str, list2, subject3 != null ? subject3.getSubjectType() : null);
                this.f53525r = resourceDetectorCollectionAdapter2;
                resourceDetectorCollectionAdapter2.i(R$id.itemRoot);
                resourceDetectorCollectionAdapter2.z0(new f9.b() { // from class: com.transsion.moviedetail.fragment.s
                    @Override // f9.b
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) throws InterruptedException {
                        ResourceDetectorFragment.V1(objectRef, this, num, baseQuickAdapter, view, i12);
                    }
                });
                recyclerView.setAdapter(resourceDetectorCollectionAdapter2);
                tu.l mViewBinding3 = getMViewBinding();
                RecyclerView recyclerView3 = mViewBinding3 != null ? mViewBinding3.f77537l : null;
                if (recyclerView3 != null) {
                    recyclerView3.setItemAnimator(null);
                }
                recyclerView2 = recyclerView;
            }
            Result.m163constructorimpl(recyclerView2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        BLTextView bLTextView;
        BLTextView bLTextView2;
        AppCompatImageView appCompatImageView2;
        AppCompatTextView appCompatTextView;
        tu.l mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatTextView = mViewBinding.f77529c) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorFragment.G1(this.f53686a, view);
                }
            });
        }
        tu.l mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView2 = mViewBinding2.f77528b) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorFragment.H1(this.f53688a, view);
                }
            });
        }
        tu.l mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (bLTextView2 = mViewBinding3.f77539n) != null) {
            bLTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorFragment.I1(this.f53690a, view);
                }
            });
        }
        tu.l mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (bLTextView = mViewBinding4.f77538m) != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorFragment.E1(this.f53692a, view);
                }
            });
        }
        tu.l mViewBinding5 = getMViewBinding();
        if (mViewBinding5 == null || (appCompatImageView = mViewBinding5.f77528b) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResourceDetectorFragment.F1(this.f53634a, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        Subject subject;
        BLTextView bLTextView;
        x1().v().j(this, new c(new Function1<ResourcesSeasonList, Unit>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResourcesSeasonList resourcesSeasonList) {
                invoke2(resourcesSeasonList);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ResourcesSeasonList resourcesSeasonList) {
                ResourceDetectorFragment.this.f53529v = true;
                ResourceDetectorFragment.this.O1(resourcesSeasonList, resourcesSeasonList != null ? resourcesSeasonList.getSeasons() : null);
                ResourceDetectorFragment.this.L1();
            }
        }));
        x1().m().j(this, new c(new Function1<DownloadListBean, Unit>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadListBean downloadListBean) {
                invoke2(downloadListBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadListBean downloadListBean) {
                List<DownloadItem> items;
                Integer resolution;
                MovieDetailActivity.f53423s.a("获取到数据之后展示数据");
                ResourceDetectorFragment.this.f53528u = true;
                if (ResourceDetectorFragment.this.M1()) {
                    ResourceDetectorFragment.this.f53527t = (downloadListBean == null || (resolution = downloadListBean.getResolution()) == null) ? 480 : resolution.intValue();
                    if (downloadListBean != null && (items = downloadListBean.getItems()) != null) {
                        ResourceDetectorFragment resourceDetectorFragment = ResourceDetectorFragment.this;
                        if (true ^ items.isEmpty()) {
                            resourceDetectorFragment.f53524q.put(Integer.valueOf(resourceDetectorFragment.f53526s), items);
                            resourceDetectorFragment.U1(items, downloadListBean.getTotalEpisode());
                        }
                    }
                    ResourceDetectorFragment.this.L1();
                }
            }
        }));
        x1().k().j(this, new c(new Function1<DownloadListBean, Unit>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment.initViewModel.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadListBean downloadListBean) {
                invoke2(downloadListBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadListBean downloadListBean) {
                List<DownloadItem> items;
                Integer resolution;
                ResourceDetectorFragment.this.hideLoading();
                MovieDetailActivity.f53423s.a("获取到数据之后展示数据");
                if (ResourceDetectorFragment.this.M1()) {
                    ResourceDetectorFragment.this.f53527t = (downloadListBean == null || (resolution = downloadListBean.getResolution()) == null) ? 480 : resolution.intValue();
                    if (downloadListBean == null || (items = downloadListBean.getItems()) == null) {
                        return;
                    }
                    ResourceDetectorFragment resourceDetectorFragment = ResourceDetectorFragment.this;
                    if (!items.isEmpty()) {
                        resourceDetectorFragment.f53524q.put(Integer.valueOf(resourceDetectorFragment.f53526s), items);
                        resourceDetectorFragment.U1(items, downloadListBean.getTotalEpisode());
                    }
                }
            }
        }));
        x1().u().j(this, new c(new Function1<Integer, Unit>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment.initViewModel.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                Subject subject2 = ResourceDetectorFragment.this.f53519l;
                if (subject2 != null && subject2.isTvType()) {
                    tu.l mViewBinding = ResourceDetectorFragment.this.getMViewBinding();
                    BLTextView bLTextView2 = mViewBinding != null ? mViewBinding.f77532g : null;
                    if (bLTextView2 == null) {
                        return;
                    }
                    Context context = ResourceDetectorFragment.this.getContext();
                    bLTextView2.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, com.transsion.moviedetailapi.helper.b.a(ResourceDetectorFragment.this.f53526s)) : null);
                    return;
                }
                Subject subject3 = ResourceDetectorFragment.this.f53519l;
                if (subject3 == null || !subject3.isEduType()) {
                    return;
                }
                tu.l mViewBinding2 = ResourceDetectorFragment.this.getMViewBinding();
                BLTextView bLTextView3 = mViewBinding2 != null ? mViewBinding2.f77532g : null;
                if (bLTextView3 == null) {
                    return;
                }
                Context context2 = ResourceDetectorFragment.this.getContext();
                bLTextView3.setText(context2 != null ? context2.getString(com.transsnet.downloader.R$string.download_video_detail_unit_index, com.transsion.moviedetailapi.helper.b.a(ResourceDetectorFragment.this.f53526s)) : null);
            }
        }));
        x1().u().q(Integer.valueOf(this.f53526s));
        Subject subject2 = this.f53519l;
        if ((subject2 == null || !subject2.isMovieType()) && ((subject = this.f53519l) == null || !subject.isTvType())) {
            tu.l mViewBinding = getMViewBinding();
            if (mViewBinding != null && (bLTextView = mViewBinding.f77538m) != null) {
                so.c.g(bLTextView);
            }
        } else {
            tu.l mViewBinding2 = getMViewBinding();
            BLTextView bLTextView2 = mViewBinding2 != null ? mViewBinding2.f77538m : null;
            if (bLTextView2 != null) {
                bLTextView2.setVisibility(this.f53531x ? 0 : 8);
            }
        }
        y1().d().j(this, new c(new Function1<Pair<? extends String, ? extends String>, Unit>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment.initViewModel.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends String> pair) {
                invoke2((Pair<String, String>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, String> pair) {
                uo.b.a aVar = uo.b.f78622a;
                uo.b.a.f(aVar, "ResourceDetectorFragment --> ", "字幕选择了, name:" + ((Object) pair.getFirst()) + ", " + ((Object) pair.getSecond()), false, 4, null);
                if (ResourceDetectorFragment.this.f53531x) {
                    uo.b.a.f(aVar, "ResourceDetectorFragment --> ", "字幕选择了, 是多配音，不展示字幕", false, 4, null);
                    return;
                }
                tu.l mViewBinding3 = ResourceDetectorFragment.this.getMViewBinding();
                BLTextView bLTextView3 = mViewBinding3 != null ? mViewBinding3.f77538m : null;
                if (bLTextView3 == null) {
                    return;
                }
                bLTextView3.setText(pair.getFirst());
            }
        }));
        y1().c().j(this, new c(new Function1<List<vx.a>, Unit>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorFragment.initViewModel.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<vx.a> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<vx.a> list) {
                BLTextView bLTextView3;
                BLTextView bLTextView4;
                List<vx.a> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    tu.l mViewBinding3 = ResourceDetectorFragment.this.getMViewBinding();
                    if (mViewBinding3 == null || (bLTextView3 = mViewBinding3.f77538m) == null) {
                        return;
                    }
                    so.c.g(bLTextView3);
                    return;
                }
                tu.l mViewBinding4 = ResourceDetectorFragment.this.getMViewBinding();
                if (mViewBinding4 == null || (bLTextView4 = mViewBinding4.f77538m) == null) {
                    return;
                }
                so.c.k(bLTextView4);
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final void u1() {
        RecyclerView recyclerView;
        if (this.f53522o) {
            this.f53522o = false;
            tu.l mViewBinding = getMViewBinding();
            if (mViewBinding == null || (recyclerView = mViewBinding.f77537l) == null) {
                return;
            }
            recyclerView.post(new Runnable() { // from class: com.transsion.moviedetail.fragment.b0
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    ResourceDetectorFragment.v1(this.f53637a);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        WatchModeTipsView watchModeTipsView;
        ResourceDetectors resourceDetectors;
        Object next;
        List<DubsInfo> dubs;
        if (M1()) {
            MovieDetailViewModel movieDetailViewModelX1 = x1();
            Subject subject = this.f53519l;
            movieDetailViewModelX1.n(subject != null ? subject.getSubjectId() : null);
        } else {
            A1();
        }
        u1();
        J1();
        Subject subject2 = this.f53519l;
        if (subject2 != null && (dubs = subject2.getDubs()) != null) {
            D1(dubs);
        }
        Subject subject3 = this.f53519l;
        if (subject3 != null) {
            String subjectId = subject3.getSubjectId();
            List<DubsInfo> dubs2 = subject3.getDubs();
            this.f53531x = dubs2 != null && (dubs2.isEmpty() ^ true) && dubs2.size() > 1;
            if (dubs2 != null) {
                Iterator<T> it = dubs2.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.b(((DubsInfo) next).getSubjectId(), subjectId));
                DubsInfo dubsInfo = (DubsInfo) next;
                if (dubsInfo != null) {
                    dubsInfo.setSelected(true);
                    tu.l mViewBinding = getMViewBinding();
                    BLTextView bLTextView = mViewBinding != null ? mViewBinding.f77538m : null;
                    if (bLTextView != null) {
                        bLTextView.setText(dubsInfo.getLanName());
                    }
                }
            }
            List<ResourceDetectors> resourceDetectors2 = subject3.getResourceDetectors();
            if (resourceDetectors2 != null && (resourceDetectors = (ResourceDetectors) CollectionsKt___CollectionsKt.g0(resourceDetectors2)) != null) {
                tu.l mViewBinding2 = getMViewBinding();
                AppCompatTextView appCompatTextView = mViewBinding2 != null ? mViewBinding2.f77530d : null;
                if (appCompatTextView != null) {
                    appCompatTextView.setText(resourceDetectors.getUploadBy());
                }
            }
        }
        tu.l mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (watchModeTipsView = mViewBinding3.f77536k) == null) {
            return;
        }
        watchModeTipsView.checkShow();
    }

    public final void w1(DownloadItem downloadItem, Integer num, int i11, int i12) {
        String uploadBy;
        String sourceUrl;
        String str;
        String resourceId;
        List<ResourceDetectors> resourceDetectors;
        String resourceLink;
        Integer subjectType;
        Integer resolution;
        Integer epse;
        Cover cover;
        String name;
        String resourceId2;
        String url;
        try {
            Result.Companion companion = Result.Companion;
            String str2 = (downloadItem == null || (url = downloadItem.getUrl()) == null) ? "" : url;
            String str3 = (downloadItem == null || (resourceId2 = downloadItem.getResourceId()) == null) ? "" : resourceId2;
            String str4 = (downloadItem == null || (name = downloadItem.getName()) == null) ? "" : name;
            Subject subject = this.f53519l;
            DownloadBean downloadBean = new DownloadBean(str2, str3, str4, (subject == null || (cover = subject.getCover()) == null) ? null : cover.getUrl(), downloadItem != null ? downloadItem.getSize() : null, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
            if (downloadItem == null || (uploadBy = downloadItem.getUploadBy()) == null) {
                uploadBy = "";
            }
            downloadBean.setUploadBy(uploadBy);
            if (downloadItem == null || (sourceUrl = downloadItem.getSourceUrl()) == null) {
                sourceUrl = "";
            }
            downloadBean.setSourceUrl(sourceUrl);
            downloadBean.setPostId(downloadItem != null ? downloadItem.getPostId() : null);
            downloadBean.setEpse((downloadItem == null || (epse = downloadItem.getEpse()) == null) ? 0 : epse.intValue());
            downloadBean.setEp(downloadItem != null ? downloadItem.getEp() : 0);
            downloadBean.setSe(downloadItem != null ? downloadItem.getSe() : 0);
            downloadBean.setResolution((downloadItem == null || (resolution = downloadItem.getResolution()) == null) ? 0 : resolution.intValue());
            downloadBean.setRequireMemberType(downloadItem != null ? downloadItem.getRequireMemberType() : null);
            downloadBean.setMultiresolution(i11);
            Subject subject2 = this.f53519l;
            downloadBean.setSubjectId(subject2 != null ? subject2.getSubjectId() : null);
            Subject subject3 = this.f53519l;
            downloadBean.setSubjectName(subject3 != null ? subject3.getTitle() : null);
            downloadBean.setResourcePosition(i12 + 1);
            DownloadBean.a aVar = DownloadBean.Companion;
            Subject subject4 = this.f53519l;
            downloadBean.setType(aVar.c(subject4 != null ? subject4.getSubjectType() : null));
            Subject subject5 = this.f53519l;
            downloadBean.setSubjectType((subject5 == null || (subjectType = subject5.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
            downloadBean.setTotalEpisode(num != null ? num.intValue() : 1);
            Subject subject6 = this.f53519l;
            if (subject6 == null || (resourceDetectors = subject6.getResourceDetectors()) == null) {
                str = "";
            } else {
                if (!(true ^ resourceDetectors.isEmpty()) || (resourceLink = resourceDetectors.get(0).getResourceLink()) == null) {
                    resourceLink = "";
                }
                str = resourceLink;
            }
            DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            DownloadManagerApi.S1(downloadManagerApiA, fragmentActivityRequireActivity, this.f53519l, "subjectdetail", null, this.f53521n, str, (downloadItem == null || (resourceId = downloadItem.getResourceId()) == null) ? "" : resourceId, this.f53518k, null, false, this.f53526s, false, 776, null);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }

    public final com.transsion.player.longvideo.helper.w y1() {
        return (com.transsion.player.longvideo.helper.w) this.f53530w.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: z1, reason: merged with bridge method [inline-methods] */
    public tu.l getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.l lVarC = tu.l.c(inflater);
        Intrinsics.f(lVarC, "inflate(inflater)");
        return lVarC;
    }
}
