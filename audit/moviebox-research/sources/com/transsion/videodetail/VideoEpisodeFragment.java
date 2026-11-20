package com.transsion.videodetail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetail.fragment.ResourceDetectorDialogFragment;
import com.transsion.moviedetail.fragment.VideoDetailSeasonsSelectFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
public final class VideoEpisodeFragment extends BaseFragment<rz.d> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f59876p = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public pz.b f59879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Subject f59880d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f59881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f59882g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f59884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super DubsInfo, Unit> f59885j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59877a = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59878b = FragmentViewModelLazyKt.a(this, Reflection.b(VideoDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$3
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$4
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

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f59883h = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.player.longvideo.helper.w.class), new Function0<x0>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$5
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$special$$inlined$activityViewModels$default$6
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

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f59886k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f59887l = "1-50";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f59888m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f59889n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f59890o = (d0.e() / 2) - f0.a(88.0f);

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
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59891a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59891a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59891a;
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
            this.f59891a.invoke(obj);
        }
    }

    private final MovieDetailViewModel A0() {
        return (MovieDetailViewModel) this.f59877a.getValue();
    }

    private final com.transsion.player.longvideo.helper.w B0() {
        return (com.transsion.player.longvideo.helper.w) this.f59883h.getValue();
    }

    private final VideoDetailViewModel C0() {
        return (VideoDetailViewModel) this.f59878b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    public final void E0(ResourcesSeasonList resourcesSeasonList) {
        int se2;
        List<ResourcesSeason> seasons;
        List<ResourcesSeason> seasons2;
        if (resourcesSeasonList == null || (seasons2 = resourcesSeasonList.getSeasons()) == null || !seasons2.isEmpty()) {
            if (resourcesSeasonList == null || (seasons = resourcesSeasonList.getSeasons()) == null) {
                se2 = this.f59886k;
            } else {
                Iterator<T> it = seasons.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                Object next = it.next();
                if (it.hasNext()) {
                    int se3 = ((ResourcesSeason) next).getSe();
                    do {
                        Object next2 = it.next();
                        int se4 = ((ResourcesSeason) next2).getSe();
                        if (se3 > se4) {
                            next = next2;
                            se3 = se4;
                        }
                    } while (it.hasNext());
                }
                ResourcesSeason resourcesSeason = (ResourcesSeason) next;
                if (resourcesSeason != null) {
                    se2 = resourcesSeason.getSe();
                } else {
                    se2 = this.f59886k;
                }
            }
            if (this.f59886k < se2) {
                this.f59886k = se2;
            }
        }
    }

    public static final void G0(VideoEpisodeFragment this$0, pz.b this_apply, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        if (this$0.f59881f == 0 || System.currentTimeMillis() - this$0.f59881f > 1000) {
            this$0.f59881f = System.currentTimeMillis();
            this$0.C0().z(this_apply.O(i11));
        }
    }

    public static final void H0(final VideoEpisodeFragment this$0, View view) {
        String subjectId;
        Fragment parentFragment;
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "VideoEpisodeFragment", "innerTvTitle click then switch audio track", false, 4, null);
        Subject subject = this$0.f59880d;
        if (subject == null || (subjectId = subject.getSubjectId()) == null || (parentFragment = this$0.getParentFragment()) == null) {
            return;
        }
        VideoDetailAudioTrackSelectDialog videoDetailAudioTrackSelectDialog = new VideoDetailAudioTrackSelectDialog();
        videoDetailAudioTrackSelectDialog.e1(subjectId);
        Intrinsics.f(parentFragment, "parentFragment");
        videoDetailAudioTrackSelectDialog.T0(parentFragment, R$id.fl_bottom_dialog_container);
        videoDetailAudioTrackSelectDialog.d1(new Function1<DubsInfo, Unit>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$initView$4$1$1$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DubsInfo dubsInfo) {
                invoke2(dubsInfo);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DubsInfo it) {
                Intrinsics.g(it, "it");
                Function1 function1 = this.this$0.f59885j;
                if (function1 != null) {
                    function1.invoke(it);
                }
            }
        });
    }

    public static final void I0(final VideoEpisodeFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Fragment parentFragment = this$0.getParentFragment();
        if (parentFragment != null) {
            VideoDetailSeasonsSelectFragment.a aVar = VideoDetailSeasonsSelectFragment.f53627r;
            ResourcesSeasonList resourcesSeasonListF = this$0.C0().w().f();
            Subject subject = this$0.f59880d;
            VideoDetailSeasonsSelectFragment videoDetailSeasonsSelectFragmentA = aVar.a(resourcesSeasonListF, subject != null ? subject.getSubjectType() : null);
            videoDetailSeasonsSelectFragmentA.d1(this$0.f59886k);
            videoDetailSeasonsSelectFragmentA.T0(parentFragment, R$id.fl_bottom_dialog_container);
            videoDetailSeasonsSelectFragmentA.c1(new Function1<Integer, Unit>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$initView$5$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(int i11) {
                    this.this$0.f59886k = i11;
                    VideoEpisodeFragment videoEpisodeFragment = this.this$0;
                    videoEpisodeFragment.N0(videoEpisodeFragment.f59886k);
                    rz.d mViewBinding = this.this$0.getMViewBinding();
                    BLTextView bLTextView = mViewBinding != null ? mViewBinding.f75794g : null;
                    if (bLTextView == null) {
                        return;
                    }
                    Context context = this.this$0.getContext();
                    bLTextView.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, com.transsion.moviedetailapi.helper.b.a(this.this$0.f59886k)) : null);
                }
            });
        }
    }

    public static final void J0(final VideoEpisodeFragment this$0, View view) {
        Fragment parentFragment;
        Intrinsics.g(this$0, "this$0");
        Subject subject = this$0.f59880d;
        if (subject == null || (parentFragment = this$0.getParentFragment()) == null) {
            return;
        }
        VideoDetailAllEpisodesFragment videoDetailAllEpisodesFragment = new VideoDetailAllEpisodesFragment();
        videoDetailAllEpisodesFragment.m1(subject, this$0.f59886k, this$0.C0().w().f());
        Intrinsics.f(parentFragment, "parentFragment");
        videoDetailAllEpisodesFragment.T0(parentFragment, R$id.fl_bottom_dialog_container);
        videoDetailAllEpisodesFragment.n1(new Function1<VideoDetailMediaSource, Unit>() { // from class: com.transsion.videodetail.VideoEpisodeFragment$initView$1$1$1$1$1
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
                if (this.this$0.f59881f == 0 || System.currentTimeMillis() - this.this$0.f59881f > 1000) {
                    this.this$0.f59881f = System.currentTimeMillis();
                    this.this$0.M0(videoDetailMediaSource);
                }
            }
        });
    }

    public static final void K0(VideoEpisodeFragment this$0, View view) {
        List<ResourceDetectors> resourceDetectors;
        ResourceDetectors resourceDetectors2;
        String title;
        Intrinsics.g(this$0, "this$0");
        Subject subject = this$0.f59880d;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null || (resourceDetectors2 = (ResourceDetectors) CollectionsKt___CollectionsKt.g0(resourceDetectors)) == null) {
            return;
        }
        ResourceDetectorDialogFragment.a aVar = ResourceDetectorDialogFragment.f53509f;
        Subject subject2 = this$0.f59880d;
        if (subject2 == null || (title = subject2.getTitle()) == null) {
            title = "";
        }
        ResourceDetectorDialogFragment resourceDetectorDialogFragmentA = aVar.a(title, resourceDetectors2);
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        resourceDetectorDialogFragmentA.show(childFragmentManager, "ResourceDetectorFragment --> ");
    }

    public static final void L0(VideoEpisodeFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = this$0.f59880d;
        postcardWithString.withString("subject_id", subject != null ? subject.getSubjectId() : null).navigation();
    }

    private final void O0(int i11) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (i11 < 0) {
            return;
        }
        try {
            rz.d mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView2 = mViewBinding.f75796i) != null) {
                recyclerView2.scrollToPosition(i11);
            }
            rz.d mViewBinding2 = getMViewBinding();
            RecyclerView.m layoutManager = (mViewBinding2 == null || (recyclerView = mViewBinding2.f75796i) == null) ? null : recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int i12 = this.f59890o;
                if (i12 <= 0) {
                    i12 = 0;
                }
                linearLayoutManager.scrollToPositionWithOffset(i11, i12);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(VideoDetailMediaSource videoDetailMediaSource) {
        List<ResourcesSeason> seasons;
        pz.b bVar = this.f59879c;
        if (bVar != null) {
            bVar.I0(videoDetailMediaSource);
        }
        uo.b.a.f(uo.b.f78622a, "VideoDetailEpisode", "setPlayingItem,--------, se:" + (videoDetailMediaSource != null ? Integer.valueOf(videoDetailMediaSource.getSe()) : null) + ", ep:" + (videoDetailMediaSource != null ? Integer.valueOf(videoDetailMediaSource.getEp()) : null), false, 4, null);
        int i11 = 0;
        if (this.f59888m) {
            ResourcesSeasonList resourcesSeasonListF = C0().w().f();
            if (resourcesSeasonListF == null || (seasons = resourcesSeasonListF.getSeasons()) == null) {
                return;
            }
            for (ResourcesSeason resourcesSeason : seasons) {
                if (videoDetailMediaSource != null && resourcesSeason.getSe() == videoDetailMediaSource.getSe()) {
                    if (i11 > 0) {
                        int se2 = videoDetailMediaSource != null ? videoDetailMediaSource.getSe() : 1;
                        this.f59886k = se2;
                        N0(se2);
                        return;
                    }
                    return;
                }
                i11++;
            }
            return;
        }
        Map<String, List<VideoDetailMediaSource>> mapF = C0().r().f();
        if (mapF != null) {
            for (Map.Entry<String, List<VideoDetailMediaSource>> entry : mapF.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    IntRange intRange = new IntRange(((VideoDetailMediaSource) CollectionsKt___CollectionsKt.e0(entry.getValue())).getEp(), ((VideoDetailMediaSource) CollectionsKt___CollectionsKt.q0(entry.getValue())).getEp());
                    Integer numValueOf = videoDetailMediaSource != null ? Integer.valueOf(videoDetailMediaSource.getEp()) : null;
                    if (numValueOf != null && intRange.v(numValueOf.intValue())) {
                        String key = entry.getKey();
                        this.f59887l = key;
                        uo.b.a.f(uo.b.f78622a, "VideoDetailEpisode", "setPlayingItem,index:" + i11 + ", EpTabTitle:" + key, false, 4, null);
                    }
                }
                i11++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(List<VideoDetailMediaSource> list) {
        Subject subject;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List<VideoDetailMediaSource> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        if (list.size() > 1 && (subject = this.f59880d) != null && subject.isMovieType()) {
            rz.d mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView2 = mViewBinding.f75796i) != null && recyclerView2.getItemDecorationCount() > 0) {
                try {
                    Result.Companion companion = Result.Companion;
                    recyclerView2.removeItemDecorationAt(0);
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
            }
            rz.d mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (recyclerView = mViewBinding2.f75796i) != null) {
                recyclerView.addItemDecoration(new ro.d(8.0f, 0.0f, 12.0f, list.size() > 6 ? 12.0f : 0.0f, 2, null));
            }
        }
        rz.d mViewBinding3 = getMViewBinding();
        BLTextView bLTextView = mViewBinding3 != null ? mViewBinding3.f75798k : null;
        if (bLTextView != null) {
            bLTextView.setVisibility(list.size() > 6 ? 0 : 8);
        }
        VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) CollectionsKt___CollectionsKt.g0(list);
        if (videoDetailMediaSource != null && videoDetailMediaSource.getSe() == 0 && videoDetailMediaSource.getEp() == 0) {
            Subject subject2 = this.f59880d;
            videoDetailMediaSource.setName(subject2 != null ? subject2.getTitle() : null);
        }
        pz.b bVar = this.f59879c;
        if (bVar != null) {
            bVar.w0(com.transsion.videodetail.util.a.f60010a.a(C0(), this.f59886k));
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public rz.d getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        rz.d dVarC = rz.d.c(inflater);
        Intrinsics.f(dVarC, "inflate(inflater)");
        return dVarC;
    }

    public final void F0(boolean z11) {
        RecyclerView recyclerView;
        Integer subjectType;
        rz.d mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f75796i) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addItemDecoration(new ro.d(8.0f, 0.0f, z11 ? 0.0f : 4.0f, 12.0f, 2, null));
        Subject subject = this.f59880d;
        final pz.b bVar = new pz.b((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue(), z11, R$layout.item_video_detail_episode);
        bVar.B0(new f9.d() { // from class: com.transsion.videodetail.b0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                VideoEpisodeFragment.G0(this.f59893a, bVar, baseQuickAdapter, view, i11);
            }
        });
        this.f59879c = bVar;
        recyclerView.setAdapter(bVar);
    }

    public final void M0(VideoDetailMediaSource videoDetailMediaSource) {
        List<VideoDetailMediaSource> listD;
        C0().z(videoDetailMediaSource);
        pz.b bVar = this.f59879c;
        int i11 = -1;
        if (bVar != null && (listD = bVar.D()) != null) {
            int i12 = 0;
            for (VideoDetailMediaSource videoDetailMediaSource2 : listD) {
                if (videoDetailMediaSource != null && videoDetailMediaSource2.getSe() == videoDetailMediaSource.getSe() && videoDetailMediaSource2.getEp() == videoDetailMediaSource.getEp()) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
        }
        if (i11 >= 0) {
            pz.b bVar2 = this.f59879c;
            if (i11 < (bVar2 != null ? bVar2.getItemCount() : 0)) {
                O0(i11);
            }
        }
    }

    public final void N0(int i11) {
        this.f59886k = i11;
        A0().u().q(Integer.valueOf(i11));
        pz.b bVar = this.f59879c;
        if (bVar != null) {
            bVar.w0(com.transsion.videodetail.util.a.f60010a.a(C0(), i11));
        }
    }

    public final void P0(Function1<? super DubsInfo, Unit> function1) {
        this.f59885j = function1;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Subject subject;
        BLTextView bLTextView;
        Object next;
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        C0().w().j(this, new b(new Function1<ResourcesSeasonList, Unit>() { // from class: com.transsion.videodetail.VideoEpisodeFragment.initData.1
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
                Subject subject2;
                VideoEpisodeFragment.this.E0(resourcesSeasonList);
                VideoEpisodeFragment.this.hideLoading();
                VideoEpisodeFragment videoEpisodeFragment = VideoEpisodeFragment.this;
                Subject subject3 = videoEpisodeFragment.f59880d;
                boolean z11 = true;
                if ((subject3 == null || !subject3.isTvType()) && ((subject2 = VideoEpisodeFragment.this.f59880d) == null || !subject2.isEduType())) {
                    z11 = false;
                }
                videoEpisodeFragment.F0(z11);
            }
        }));
        C0().q().j(this, new b(new Function1<List<? extends VideoDetailMediaSource>, Unit>() { // from class: com.transsion.videodetail.VideoEpisodeFragment.initData.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends VideoDetailMediaSource> list) {
                invoke2((List<VideoDetailMediaSource>) list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<VideoDetailMediaSource> list) {
                VideoEpisodeFragment.this.R0(list);
            }
        }));
        C0().v().j(this, new b(new Function1<VideoDetailMediaSource, Unit>() { // from class: com.transsion.videodetail.VideoEpisodeFragment.initData.3
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
                VideoEpisodeFragment.this.Q0(videoDetailMediaSource);
            }
        }));
        A0().u().j(this, new b(new Function1<Integer, Unit>() { // from class: com.transsion.videodetail.VideoEpisodeFragment.initData.4
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
                Subject subject2 = VideoEpisodeFragment.this.f59880d;
                if (subject2 != null && subject2.isTvType()) {
                    rz.d mViewBinding = VideoEpisodeFragment.this.getMViewBinding();
                    BLTextView bLTextView2 = mViewBinding != null ? mViewBinding.f75794g : null;
                    if (bLTextView2 == null) {
                        return;
                    }
                    Context context = VideoEpisodeFragment.this.getContext();
                    bLTextView2.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, com.transsion.moviedetailapi.helper.b.a(VideoEpisodeFragment.this.f59886k)) : null);
                    return;
                }
                Subject subject3 = VideoEpisodeFragment.this.f59880d;
                if (subject3 == null || !subject3.isEduType()) {
                    return;
                }
                rz.d mViewBinding2 = VideoEpisodeFragment.this.getMViewBinding();
                BLTextView bLTextView3 = mViewBinding2 != null ? mViewBinding2.f75794g : null;
                if (bLTextView3 == null) {
                    return;
                }
                Context context2 = VideoEpisodeFragment.this.getContext();
                bLTextView3.setText(context2 != null ? context2.getString(com.transsnet.downloader.R$string.download_video_detail_unit_index, com.transsion.moviedetailapi.helper.b.a(VideoEpisodeFragment.this.f59886k)) : null);
            }
        }));
        C0().w().j(this, new b(new Function1<ResourcesSeasonList, Unit>() { // from class: com.transsion.videodetail.VideoEpisodeFragment.initData.5
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
                BLTextView bLTextView2;
                BLTextView bLTextView3;
                BLTextView bLTextView4;
                List<ResourcesSeason> seasons;
                int size = (resourcesSeasonList == null || (seasons = resourcesSeasonList.getSeasons()) == null) ? 1 : seasons.size();
                VideoEpisodeFragment.this.f59889n = size;
                rz.d mViewBinding = VideoEpisodeFragment.this.getMViewBinding();
                if (mViewBinding == null || (bLTextView2 = mViewBinding.f75794g) == null || bLTextView2.getVisibility() != 0) {
                    return;
                }
                if (size == 1) {
                    rz.d mViewBinding2 = VideoEpisodeFragment.this.getMViewBinding();
                    if (mViewBinding2 == null || (bLTextView4 = mViewBinding2.f75794g) == null) {
                        return;
                    }
                    so.c.g(bLTextView4);
                    return;
                }
                rz.d mViewBinding3 = VideoEpisodeFragment.this.getMViewBinding();
                if (mViewBinding3 == null || (bLTextView3 = mViewBinding3.f75794g) == null) {
                    return;
                }
                so.c.k(bLTextView3);
            }
        }));
        Subject subject2 = this.f59880d;
        if (subject2 != null) {
            String subjectId = subject2.getSubjectId();
            List<DubsInfo> dubs = subject2.getDubs();
            this.f59884i = dubs != null && (dubs.isEmpty() ^ true) && dubs.size() > 1;
            if (dubs != null) {
                Iterator<T> it = dubs.iterator();
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
                    rz.d mViewBinding = getMViewBinding();
                    BLTextView bLTextView2 = mViewBinding != null ? mViewBinding.f75797j : null;
                    if (bLTextView2 != null) {
                        bLTextView2.setText(dubsInfo.getLanName());
                    }
                }
            }
        }
        Subject subject3 = this.f59880d;
        if ((subject3 == null || !subject3.isMovieType()) && ((subject = this.f59880d) == null || !subject.isTvType())) {
            rz.d mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (bLTextView = mViewBinding2.f75797j) != null) {
                so.c.g(bLTextView);
            }
        } else {
            rz.d mViewBinding3 = getMViewBinding();
            BLTextView bLTextView3 = mViewBinding3 != null ? mViewBinding3.f75797j : null;
            if (bLTextView3 != null) {
                bLTextView3.setVisibility(this.f59884i ? 0 : 8);
            }
        }
        B0().d().j(this, new b(new Function1<Pair<? extends String, ? extends String>, Unit>() { // from class: com.transsion.videodetail.VideoEpisodeFragment.initData.7
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
                uo.b.a.f(aVar, "VideoDetailEpisode", "字幕选择了, name:" + ((Object) pair.getFirst()) + ", " + ((Object) pair.getSecond()), false, 4, null);
                if (VideoEpisodeFragment.this.f59884i) {
                    uo.b.a.f(aVar, "VideoDetailEpisode", "字幕选择了, 是多配音，不展示字幕", false, 4, null);
                    return;
                }
                if (Intrinsics.b(pair.getFirst(), BucketVersioningConfiguration.OFF)) {
                    uo.b.a.f(aVar, "VideoDetailEpisode", "关闭了字幕，文案不更改", false, 4, null);
                    return;
                }
                rz.d mViewBinding4 = VideoEpisodeFragment.this.getMViewBinding();
                BLTextView bLTextView4 = mViewBinding4 != null ? mViewBinding4.f75797j : null;
                if (bLTextView4 == null) {
                    return;
                }
                bLTextView4.setText(pair.getFirst());
            }
        }));
        B0().c().j(this, new b(new Function1<List<vx.a>, Unit>() { // from class: com.transsion.videodetail.VideoEpisodeFragment.initData.8
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
                BLTextView bLTextView4;
                BLTextView bLTextView5;
                List<vx.a> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    rz.d mViewBinding4 = VideoEpisodeFragment.this.getMViewBinding();
                    if (mViewBinding4 == null || (bLTextView4 = mViewBinding4.f75797j) == null) {
                        return;
                    }
                    so.c.g(bLTextView4);
                    return;
                }
                rz.d mViewBinding5 = VideoEpisodeFragment.this.getMViewBinding();
                if (mViewBinding5 == null || (bLTextView5 = mViewBinding5.f75797j) == null) {
                    return;
                }
                so.c.k(bLTextView5);
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        BLTextView bLTextView;
        BLTextView bLTextView2;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        List<ResourceDetectors> resourceDetectors;
        ResourceDetectors resourceDetectors2;
        BLTextView bLTextView3;
        Intrinsics.g(view, "view");
        rz.d mViewBinding = getMViewBinding();
        if (mViewBinding != null && (bLTextView3 = mViewBinding.f75798k) != null) {
            bLTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VideoEpisodeFragment.J0(this.f60013a, view2);
                }
            });
        }
        Subject subject = this.f59880d;
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && (resourceDetectors2 = (ResourceDetectors) CollectionsKt___CollectionsKt.g0(resourceDetectors)) != null) {
            rz.d mViewBinding2 = getMViewBinding();
            AppCompatTextView appCompatTextView3 = mViewBinding2 != null ? mViewBinding2.f75792d : null;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setText(resourceDetectors2.getUploadBy());
            }
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.transsion.videodetail.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoEpisodeFragment.K0(this.f60014a, view2);
            }
        };
        rz.d mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (appCompatTextView2 = mViewBinding3.f75791c) != null) {
            appCompatTextView2.setOnClickListener(onClickListener);
        }
        rz.d mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatTextView = mViewBinding4.f75792d) != null) {
            appCompatTextView.setOnClickListener(onClickListener);
        }
        rz.d mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (appCompatImageView = mViewBinding5.f75790b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VideoEpisodeFragment.L0(this.f60015a, view2);
                }
            });
        }
        rz.d mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (bLTextView2 = mViewBinding6.f75797j) != null) {
            bLTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VideoEpisodeFragment.H0(this.f60016a, view2);
                }
            });
        }
        rz.d mViewBinding7 = getMViewBinding();
        if (mViewBinding7 != null && (bLTextView = mViewBinding7.f75794g) != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VideoEpisodeFragment.I0(this.f59892a, view2);
                }
            });
        }
        rz.d mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null) {
            Subject subject2 = this.f59880d;
            if (subject2 != null && subject2.isTvType()) {
                BLTextView ivSeasons = mViewBinding8.f75794g;
                Intrinsics.f(ivSeasons, "ivSeasons");
                so.c.k(ivSeasons);
                BLTextView bLTextView4 = mViewBinding8.f75794g;
                Context context = getContext();
                bLTextView4.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, com.transsion.moviedetailapi.helper.b.a(this.f59886k)) : null);
                return;
            }
            Subject subject3 = this.f59880d;
            if (subject3 == null || !subject3.isEduType()) {
                BLTextView ivSeasons2 = mViewBinding8.f75794g;
                Intrinsics.f(ivSeasons2, "ivSeasons");
                so.c.g(ivSeasons2);
            } else {
                BLTextView ivSeasons3 = mViewBinding8.f75794g;
                Intrinsics.f(ivSeasons3, "ivSeasons");
                so.c.k(ivSeasons3);
                BLTextView bLTextView5 = mViewBinding8.f75794g;
                Context context2 = getContext();
                bLTextView5.setText(context2 != null ? context2.getString(com.transsnet.downloader.R$string.download_video_detail_unit_index, com.transsion.moviedetailapi.helper.b.a(this.f59886k)) : null);
            }
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.f59880d = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.f59882g = arguments2 != null ? arguments2.getString("module_name") : null;
        Bundle arguments3 = getArguments();
        this.f59886k = arguments3 != null ? arguments3.getInt("season") : 1;
    }
}
