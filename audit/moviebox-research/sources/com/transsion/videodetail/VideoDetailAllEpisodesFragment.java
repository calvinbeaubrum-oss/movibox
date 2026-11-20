package com.transsion.videodetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.moviedetail.fragment.VideoDetailSeasonsSelectFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.play.detail.fragment.BaseBottomDialogFragment;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

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
public final class VideoDetailAllEpisodesFragment extends BaseBottomDialogFragment<rz.b> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Subject f59836l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ResourcesSeasonList f59838n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public pz.b f59839o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f59842r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f59843s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function1<? super VideoDetailMediaSource, Unit> f59844t;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f59837m = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f59840p = FragmentViewModelLazyKt.a(this, Reflection.b(VideoDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f59841q = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$special$$inlined$activityViewModels$default$3
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$special$$inlined$activityViewModels$default$4
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59845a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59845a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59845a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59845a.invoke(obj);
        }
    }

    private final MovieDetailViewModel e1() {
        return (MovieDetailViewModel) this.f59841q.getValue();
    }

    public static final void i1(VideoDetailAllEpisodesFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.R0(true);
    }

    public static final void j1(VideoDetailAllEpisodesFragment this$0, pz.b this_apply, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        if (this$0.f59842r == 0 || System.currentTimeMillis() - this$0.f59842r > 1000) {
            this$0.f59842r = System.currentTimeMillis();
            VideoDetailMediaSource videoDetailMediaSourceO = this_apply.O(i11);
            Function1<? super VideoDetailMediaSource, Unit> function1 = this$0.f59844t;
            if (function1 != null) {
                function1.invoke(videoDetailMediaSourceO);
            }
            BaseBottomDialogFragment.S0(this$0, false, 1, null);
        }
    }

    public static final void k1(final VideoDetailAllEpisodesFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Integer seNum = this$0.f59843s;
        if (seNum == null) {
            Subject subject = this$0.f59836l;
            seNum = subject != null ? subject.getSeNum() : null;
        }
        if (seNum != null) {
            seNum.intValue();
            VideoDetailSeasonsSelectFragment.a aVar = VideoDetailSeasonsSelectFragment.f53627r;
            ResourcesSeasonList resourcesSeasonList = this$0.f59838n;
            Subject subject2 = this$0.f59836l;
            VideoDetailSeasonsSelectFragment videoDetailSeasonsSelectFragmentA = aVar.a(resourcesSeasonList, subject2 != null ? subject2.getSubjectType() : null);
            videoDetailSeasonsSelectFragmentA.d1(this$0.f59837m);
            videoDetailSeasonsSelectFragmentA.T0(this$0, R$id.fl_season_container);
            videoDetailSeasonsSelectFragmentA.c1(new Function1<Integer, Unit>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$initViewData$1$4$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(int i11) {
                    this.this$0.f59837m = i11;
                    VideoDetailAllEpisodesFragment videoDetailAllEpisodesFragment = this.this$0;
                    videoDetailAllEpisodesFragment.l1(videoDetailAllEpisodesFragment.f59837m);
                    this.this$0.p1();
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final VideoDetailViewModel f1() {
        return (VideoDetailViewModel) this.f59840p.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public rz.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        rz.b bVarC = rz.b.c(inflater);
        Intrinsics.f(bVarC, "inflate(inflater)");
        return bVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h1() {
        ProgressBar progressBar;
        uo.b.a.f(uo.b.f78622a, "VideoDetailEpisode", "initFirstData,--------", false, 4, null);
        rz.b bVar = (rz.b) getMViewBinding();
        if (bVar != null && (progressBar = bVar.f75779f) != null) {
            so.c.g(progressBar);
        }
        pz.b bVar2 = this.f59839o;
        if (bVar2 != null) {
            bVar2.w0(com.transsion.videodetail.util.a.f60010a.a(f1(), this.f59837m));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    public final void l1(int i11) {
        this.f59837m = i11;
        e1().u().q(Integer.valueOf(i11));
        pz.b bVar = this.f59839o;
        if (bVar != null) {
            bVar.w0(com.transsion.videodetail.util.a.f60010a.a(f1(), i11));
        }
    }

    public final void m1(Subject mSubject, int i11, ResourcesSeasonList resourcesSeasonList) {
        Intrinsics.g(mSubject, "mSubject");
        this.f59836l = mSubject;
        this.f59837m = i11;
        this.f59838n = resourcesSeasonList;
    }

    public final void n1(Function1<? super VideoDetailMediaSource, Unit> function1) {
        this.f59844t = function1;
    }

    public final void o1(VideoDetailMediaSource videoDetailMediaSource) {
        List<ResourcesSeason> seasons;
        pz.b bVar = this.f59839o;
        if (bVar != null) {
            bVar.I0(videoDetailMediaSource);
        }
        uo.b.a.f(uo.b.f78622a, "VideoDetailEpisode", "setPlayingItem,--------, se:" + (videoDetailMediaSource != null ? Integer.valueOf(videoDetailMediaSource.getSe()) : null) + ", ep:" + (videoDetailMediaSource != null ? Integer.valueOf(videoDetailMediaSource.getEp()) : null), false, 4, null);
        ResourcesSeasonList resourcesSeasonListF = f1().w().f();
        int i11 = 0;
        if (resourcesSeasonListF != null && (seasons = resourcesSeasonListF.getSeasons()) != null) {
            int i12 = 0;
            for (ResourcesSeason resourcesSeason : seasons) {
                if (videoDetailMediaSource != null && resourcesSeason.getSe() == videoDetailMediaSource.getSe()) {
                    if (i12 <= 0) {
                        break;
                    }
                    this.f59837m = videoDetailMediaSource != null ? videoDetailMediaSource.getSe() : 1;
                    break;
                }
                i12++;
            }
        }
        Map<String, List<VideoDetailMediaSource>> mapF = f1().r().f();
        if (mapF != null) {
            for (Map.Entry<String, List<VideoDetailMediaSource>> entry : mapF.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    IntRange intRange = new IntRange(((VideoDetailMediaSource) CollectionsKt___CollectionsKt.e0(entry.getValue())).getEp(), ((VideoDetailMediaSource) CollectionsKt___CollectionsKt.q0(entry.getValue())).getEp());
                    Integer numValueOf = videoDetailMediaSource != null ? Integer.valueOf(videoDetailMediaSource.getEp()) : null;
                    if (numValueOf != null && intRange.v(numValueOf.intValue())) {
                        uo.b.a.f(uo.b.f78622a, "VideoDetailEpisode", "setPlayingItem,index:" + i11 + ", EpTabTitle:" + ((Object) entry.getKey()), false, 4, null);
                    }
                }
                i11++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p1() {
        AppCompatTextView appCompatTextView;
        Subject subject = this.f59836l;
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.EDUCATION.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                rz.b bVar = (rz.b) getMViewBinding();
                BLTextView bLTextView = bVar != null ? bVar.f75782i : null;
                if (bLTextView != null) {
                    Context context = getContext();
                    bLTextView.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_unit_index, com.transsion.moviedetailapi.helper.b.a(this.f59837m)) : null);
                }
                rz.b bVar2 = (rz.b) getMViewBinding();
                appCompatTextView = bVar2 != null ? bVar2.f75781h : null;
                if (appCompatTextView == null) {
                    return;
                }
                appCompatTextView.setText(Utils.a().getString(com.transsnet.downloader.R$string.download_series_all_lessons));
                return;
            }
        }
        rz.b bVar3 = (rz.b) getMViewBinding();
        BLTextView bLTextView2 = bVar3 != null ? bVar3.f75782i : null;
        if (bLTextView2 != null) {
            Context context2 = getContext();
            bLTextView2.setText(context2 != null ? context2.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, com.transsion.moviedetailapi.helper.b.a(this.f59837m)) : null);
        }
        rz.b bVar4 = (rz.b) getMViewBinding();
        appCompatTextView = bVar4 != null ? bVar4.f75781h : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(Utils.a().getString(com.transsnet.downloader.R$string.download_series_all_episodes));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        rz.b bVar = (rz.b) getMViewBinding();
        if (bVar != null) {
            bVar.f75778d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoDetailAllEpisodesFragment.i1(this.f59998a, view);
                }
            });
            BLTextView bLTextView = bVar.f75782i;
            Context context = getContext();
            bLTextView.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, com.transsion.moviedetailapi.helper.b.a(this.f59837m)) : null);
            RecyclerView recyclerView = bVar.f75780g;
            int iA = f0.a(4.0f);
            recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 6));
            int i11 = iA * 2;
            recyclerView.addItemDecoration(new ro.b(iA, iA, i11, i11));
            final pz.b bVar2 = new pz.b(SubjectType.TV.getValue(), false, R$layout.item_video_detail_episode);
            bVar2.B0(new f9.d() { // from class: com.transsion.videodetail.q
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    VideoDetailAllEpisodesFragment.j1(this.f59999a, bVar2, baseQuickAdapter, view, i12);
                }
            });
            this.f59839o = bVar2;
            bVar.f75780g.setAdapter(bVar2);
            h1();
            bVar.f75782i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoDetailAllEpisodesFragment.k1(this.f60001a, view);
                }
            });
        }
        f1().w().j(this, new a(new Function1<ResourcesSeasonList, Unit>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$initViewData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResourcesSeasonList resourcesSeasonList) {
                invoke2(resourcesSeasonList);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ResourcesSeasonList resourcesSeasonList) {
                AppCompatTextView appCompatTextView;
                BLTextView bLTextView2;
                AppCompatTextView appCompatTextView2;
                BLTextView bLTextView3;
                List<ResourcesSeason> seasons;
                this.this$0.f59843s = (resourcesSeasonList == null || (seasons = resourcesSeasonList.getSeasons()) == null) ? 1 : Integer.valueOf(seasons.size());
                Integer num = this.this$0.f59843s;
                if (num != null && num.intValue() == 1) {
                    rz.b bVar3 = (rz.b) this.this$0.getMViewBinding();
                    if (bVar3 != null && (bLTextView3 = bVar3.f75782i) != null) {
                        so.c.h(bLTextView3);
                    }
                    rz.b bVar4 = (rz.b) this.this$0.getMViewBinding();
                    if (bVar4 != null && (appCompatTextView2 = bVar4.f75781h) != null) {
                        so.c.k(appCompatTextView2);
                    }
                } else {
                    rz.b bVar5 = (rz.b) this.this$0.getMViewBinding();
                    if (bVar5 != null && (bLTextView2 = bVar5.f75782i) != null) {
                        so.c.k(bLTextView2);
                    }
                    rz.b bVar6 = (rz.b) this.this$0.getMViewBinding();
                    if (bVar6 != null && (appCompatTextView = bVar6.f75781h) != null) {
                        so.c.h(appCompatTextView);
                    }
                }
                this.this$0.p1();
            }
        }));
        f1().v().j(this, new a(new Function1<VideoDetailMediaSource, Unit>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$initViewData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VideoDetailMediaSource videoDetailMediaSource) {
                invoke2(videoDetailMediaSource);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VideoDetailMediaSource videoDetailMediaSource) {
                this.this$0.o1(videoDetailMediaSource);
            }
        }));
        e1().u().j(this, new a(new Function1<Integer, Unit>() { // from class: com.transsion.videodetail.VideoDetailAllEpisodesFragment$initViewData$4
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
                this.this$0.p1();
            }
        }));
    }
}
