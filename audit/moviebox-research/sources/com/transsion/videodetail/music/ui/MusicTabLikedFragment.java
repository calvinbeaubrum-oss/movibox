package com.transsion.videodetail.music.ui;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.player.MediaSource;
import com.transsion.player.longvideo.constants.LongVodPageType;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.player.p006enum.PlayMimeType;
import com.transsion.videodetail.R$drawable;
import com.transsion.videodetail.R$string;
import com.transsion.videodetail.music.bean.MusicLikedMultiItemEntity;
import com.transsion.videodetail.music.bean.MusicLikedUITypeEnum;
import com.transsion.videodetail.music.bean.MusicLoopEnum;
import com.transsion.videodetail.music.widget.MusicLikedListEmptyView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class MusicTabLikedFragment extends BaseMusicLikedFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function0<Unit> f59956r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public kv.a f59958t;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f59957s = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.music.ui.MusicTabLikedFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.music.ui.MusicTabLikedFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f59959u = LazyKt__LazyJVMKt.b(new Function0<tr.c>() { // from class: com.transsion.videodetail.music.ui.MusicTabLikedFragment$downloadDao$2
        @Override // kotlin.jvm.functions.Function0
        public final tr.c invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).E0();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f59960a;

        static {
            int[] iArr = new int[MusicLoopEnum.values().length];
            try {
                iArr[MusicLoopEnum.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MusicLoopEnum.LIST_LOOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MusicLoopEnum.SINGLE_LOOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f59960a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59961a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59961a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59961a;
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
            this.f59961a.invoke(obj);
        }
    }

    public static final void J1(MusicTabLikedFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f59956r;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void K1(MusicTabLikedFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.L1();
    }

    public final tr.c F1() {
        return (tr.c) this.f59959u.getValue();
    }

    public final MovieDetailViewModel G1() {
        return (MovieDetailViewModel) this.f59957s.getValue();
    }

    public final List<lv.c> H1(DownloadBean downloadBean) {
        String string;
        String string2;
        ArrayList arrayList = new ArrayList();
        PlayMimeType playMimeType = PlayMimeType.DEFAULT;
        String resourceId = downloadBean.getResourceId();
        String str = resourceId == null ? "" : resourceId;
        String path = downloadBean.getPath();
        String str2 = path == null ? "" : path;
        Long size = downloadBean.getSize();
        String str3 = (size == null || (string2 = size.toString()) == null) ? "" : string2;
        Long duration = downloadBean.getDuration();
        if (duration == null || (string = duration.toString()) == null) {
            string = "";
        }
        arrayList.add(new lv.c(playMimeType, str, str2, "", str3, string, ""));
        return arrayList;
    }

    public final List<lv.c> I1(Trailer trailer) {
        String string;
        Integer duration;
        Long size;
        String string2;
        String url;
        String videoId;
        ArrayList arrayList = new ArrayList();
        PlayMimeType playMimeType = PlayMimeType.DEFAULT;
        PreVideoAddress videoAddress = trailer.getVideoAddress();
        String str = (videoAddress == null || (videoId = videoAddress.getVideoId()) == null) ? "" : videoId;
        PreVideoAddress videoAddress2 = trailer.getVideoAddress();
        String str2 = (videoAddress2 == null || (url = videoAddress2.getUrl()) == null) ? "" : url;
        PreVideoAddress videoAddress3 = trailer.getVideoAddress();
        String str3 = (videoAddress3 == null || (size = videoAddress3.getSize()) == null || (string2 = size.toString()) == null) ? "" : string2;
        PreVideoAddress videoAddress4 = trailer.getVideoAddress();
        if (videoAddress4 == null || (duration = videoAddress4.getDuration()) == null || (string = duration.toString()) == null) {
            string = "";
        }
        arrayList.add(new lv.c(playMimeType, str, str2, "", str3, string, ""));
        return arrayList;
    }

    public final void L1() {
        List<MusicLikedMultiItemEntity> listD;
        MusicLikedDbBean musicLikedDbBean;
        MusicLikedDbBean musicLikedDbBean2;
        com.transsion.player.orplayer.f fVarB = TnPlayerManager.f54684a.b();
        String path = null;
        if (fVarB != null && fVarB.isPlaying()) {
            sz.a.f76638a.a(j0() + " --> onPlayAllClick() --> 若已在播放当前列表 --> 打开详情页");
            MusicLikedMultiItemEntity musicLikedMultiItemEntityW0 = W0();
            if (musicLikedMultiItemEntityW0 == null) {
                musicLikedMultiItemEntityW0 = Z0();
            }
            String subjectId = (musicLikedMultiItemEntityW0 == null || (musicLikedDbBean2 = musicLikedMultiItemEntityW0.getMusicLikedDbBean()) == null) ? null : musicLikedDbBean2.getSubjectId();
            if (musicLikedMultiItemEntityW0 != null && (musicLikedDbBean = musicLikedMultiItemEntityW0.getMusicLikedDbBean()) != null) {
                path = musicLikedDbBean.getPath();
            }
            n1(subjectId, path, false);
            return;
        }
        final MediaItem mediaItemO = MusicFloatManager.f51403i.b().o();
        if (mediaItemO != null) {
            c1().A(mediaItemO.getSubjectId(), new Function1<String, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicTabLikedFragment$onPlayAllClick$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String path2) {
                    Intrinsics.g(path2, "path");
                    sz.a.f76638a.a(this.this$0.j0() + " --> onPlayAllClick() --> 继续播放 --> subjectId = " + mediaItemO.getSubjectId() + " --> path = " + path2);
                    this.this$0.n1(mediaItemO.getSubjectId(), path2, false);
                }
            });
            return;
        }
        tz.a aVarB1 = b1();
        if (aVarB1 == null || (listD = aVarB1.D()) == null) {
            return;
        }
        for (MusicLikedMultiItemEntity musicLikedMultiItemEntity : listD) {
            if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                MusicLikedDbBean musicLikedDbBean3 = musicLikedMultiItemEntity.getMusicLikedDbBean();
                String subjectId2 = musicLikedDbBean3 != null ? musicLikedDbBean3.getSubjectId() : null;
                MusicLikedDbBean musicLikedDbBean4 = musicLikedMultiItemEntity.getMusicLikedDbBean();
                n1(subjectId2, musicLikedDbBean4 != null ? musicLikedDbBean4.getPath() : null, false);
                sz.a aVar = sz.a.f76638a;
                String strJ0 = j0();
                MusicLikedDbBean musicLikedDbBean5 = musicLikedMultiItemEntity.getMusicLikedDbBean();
                String subjectId3 = musicLikedDbBean5 != null ? musicLikedDbBean5.getSubjectId() : null;
                MusicLikedDbBean musicLikedDbBean6 = musicLikedMultiItemEntity.getMusicLikedDbBean();
                aVar.a(strJ0 + " --> onPlayAllClick() --> 有网络默认播放第一个 --> subjectId = " + subjectId3 + " --> path = " + (musicLikedDbBean6 != null ? musicLikedDbBean6.getPath() : null));
                return;
            }
            if (musicLikedMultiItemEntity.isDownloaded()) {
                MusicLikedDbBean musicLikedDbBean7 = musicLikedMultiItemEntity.getMusicLikedDbBean();
                String subjectId4 = musicLikedDbBean7 != null ? musicLikedDbBean7.getSubjectId() : null;
                MusicLikedDbBean musicLikedDbBean8 = musicLikedMultiItemEntity.getMusicLikedDbBean();
                n1(subjectId4, musicLikedDbBean8 != null ? musicLikedDbBean8.getPath() : null, false);
                sz.a aVar2 = sz.a.f76638a;
                String strJ1 = j0();
                MusicLikedDbBean musicLikedDbBean9 = musicLikedMultiItemEntity.getMusicLikedDbBean();
                String subjectId5 = musicLikedDbBean9 != null ? musicLikedDbBean9.getSubjectId() : null;
                MusicLikedDbBean musicLikedDbBean10 = musicLikedMultiItemEntity.getMusicLikedDbBean();
                aVar2.a(strJ1 + " --> onPlayAllClick() --> 无网络情况默认播放第一个已下载的Music --> subjectId = " + subjectId5 + " --> path = " + (musicLikedDbBean10 != null ? musicLikedDbBean10.getPath() : null));
                return;
            }
        }
    }

    public final void M1(final String str) {
        if (str != null) {
            c1().A(str, new Function1<String, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicTabLikedFragment$play$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String path) {
                    Intrinsics.g(path, "path");
                    if (!TextUtils.isEmpty(path)) {
                        this.this$0.N1(str);
                        return;
                    }
                    if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        this.this$0.G1().C(0, str);
                        this.this$0.G1().q(str);
                        return;
                    }
                    sz.a.f76638a.b(this.this$0.j0() + " --> playNext() --> 当前无网络、无下载 --> 失败 / 继续切换下一首");
                    this.this$0.O1(str);
                }
            });
        }
    }

    public final void N1(String str) {
        kotlinx.coroutines.j.d(v.a(this), null, null, new MusicTabLikedFragment$playDownloadMusic$1(this, str, null), 3, null);
    }

    public final void O1(String str) {
        Unit unit;
        String strE1 = e1(str);
        if (strE1 != null) {
            M1(strE1);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            sz.a.f76638a.b(j0() + " --> onCompletion() --> 内存处理 --> 列表循环 --> 加载失败");
        }
    }

    public final void P1(DownloadBean downloadBean) {
        U1(null);
        String subjectId = downloadBean.getSubjectId();
        String str = subjectId == null ? "" : subjectId;
        PlayMimeType playMimeType = PlayMimeType.DEFAULT;
        String subjectName = downloadBean.getSubjectName();
        String str2 = subjectName == null ? "" : subjectName;
        String pageName = getPageName();
        List<lv.c> listH1 = H1(downloadBean);
        String cover = downloadBean.getCover();
        String str3 = cover == null ? "" : cover;
        String thumbnail = downloadBean.getThumbnail();
        String str4 = thumbnail == null ? "" : thumbnail;
        lv.a aVar = new lv.a(str, playMimeType, 0L, 0, 0, str2, null, "", pageName, listH1, str3, str4, "", 0, Integer.valueOf(downloadBean.getSubjectType()), false, downloadBean.getTitleName(), downloadBean.getOps(), 32832, null);
        aVar.v(null);
        sz.a.f76638a.a(j0() + " --> playOfflineMusic() --> 播放本地文件 --> addDataSource = " + aVar + "  --> playerControl = " + this.f59958t);
        kv.a aVar2 = this.f59958t;
        if (aVar2 != null) {
            aVar2.setDataSource(aVar);
        }
    }

    public final void Q1(Subject subject) {
        Integer durationSeconds = subject.getDurationSeconds();
        Integer numValueOf = Integer.valueOf(durationSeconds != null ? durationSeconds.intValue() : 0);
        ResourceDetectors resourceDetector = subject.getResourceDetector();
        PreVideoAddress preVideoAddress = new PreVideoAddress(0, null, numValueOf, 0, 0, 0L, 0, resourceDetector != null ? resourceDetector.getDownloadUrl() : null, "", 0);
        Cover stills = subject.getStills();
        if (stills == null) {
            stills = subject.getCover();
        }
        Trailer trailer = new Trailer(SubjectType.MUSIC.getValue(), preVideoAddress, stills, null, null, 24, null);
        trailer.setSubjectId(subject.getSubjectId());
        trailer.setMusicName(subject.getTitle());
        R1(subject, trailer);
    }

    public final void R1(Subject subject, Trailer trailer) {
        String averageHueLight;
        String thumbnail;
        String url;
        String subjectId = subject.getSubjectId();
        String str = subjectId == null ? "" : subjectId;
        PlayMimeType playMimeType = PlayMimeType.DEFAULT;
        String title = subject.getTitle();
        String str2 = title == null ? "" : title;
        String pageName = getPageName();
        List<lv.c> listI1 = I1(trailer);
        Cover cover = trailer.getCover();
        String str3 = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
        Cover cover2 = trailer.getCover();
        String str4 = (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail;
        Cover cover3 = subject.getCover();
        String str5 = (cover3 == null || (averageHueLight = cover3.getAverageHueLight()) == null) ? "" : averageHueLight;
        Integer durationSeconds = subject.getDurationSeconds();
        int iIntValue = durationSeconds != null ? durationSeconds.intValue() : 0;
        Integer subjectType = subject.getSubjectType();
        lv.a aVar = new lv.a(str, playMimeType, 0L, 0, 0, str2, null, "", pageName, listI1, str3, str4, str5, iIntValue, Integer.valueOf(subjectType != null ? subjectType.intValue() : 1), false, subject.getTitle(), subject.getOps(), 32832, null);
        aVar.v(subject);
        sz.a.f76638a.a(j0() + " --> playTrailer() --> 当前有网络，没有下载资源 --> 播放流媒体数据 --> addDataSource = " + aVar + " -->  playerControl = " + this.f59958t);
        kv.a aVar2 = this.f59958t;
        if (aVar2 != null) {
            aVar2.setDataSource(aVar);
        }
    }

    public final void S1(Function0<Unit> function0) {
        this.f59956r = function0;
    }

    public final void T1(final Subject subject) {
        c1().A(subject.getSubjectId(), new Function1<String, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicTabLikedFragment$showMusicPlayLayout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String path) {
                Intrinsics.g(path, "path");
                if (TextUtils.isEmpty(path)) {
                    this.this$0.Q1(subject);
                } else {
                    this.this$0.N1(subject.getSubjectId());
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U1(Subject subject) {
        Context context;
        Integer subjectType;
        if (this.f59958t == null && (context = getContext()) != null) {
            LongVodPageType longVodPageType = ((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) == SubjectType.MUSIC.getValue() ? LongVodPageType.MUSIC : LongVodPageType.MUSIC;
            if (((rz.e) getMViewBinding()) != null) {
                LongVodPlayerView longVodPlayerView = new LongVodPlayerView(context);
                kv.a.C0746a.a(longVodPlayerView, getPageName(), longVodPageType, longVodPageType.name() + (subject != null ? subject.getSubjectId() : null), null, null, null, 32, null);
                longVodPlayerView.setFeedBackVisible(true);
                longVodPlayerView.setMusicLikedFragment(true);
                this.f59958t = longVodPlayerView;
            }
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public MusicLikedUITypeEnum f1() {
        return MusicLikedUITypeEnum.MUSIC_TAB;
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public String getPageName() {
        return "music_tab_liked_fragment";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatTextView appCompatTextView;
        MusicLikedListEmptyView musicLikedListEmptyView;
        View exploreNowView;
        super.initListener();
        rz.e eVar = (rz.e) getMViewBinding();
        if (eVar != null && (musicLikedListEmptyView = eVar.f75800b) != null && (exploreNowView = musicLikedListEmptyView.getExploreNowView()) != null) {
            exploreNowView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.ui.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MusicTabLikedFragment.J1(this.f59984a, view);
                }
            });
        }
        rz.e eVar2 = (rz.e) getMViewBinding();
        if (eVar2 == null || (appCompatTextView = eVar2.f75804g) == null) {
            return;
        }
        uz.a.f78665a.a(appCompatTextView, "  " + getResources().getString(R$string.music_play_all), z2.a.getDrawable(Utils.a(), R$drawable.music_pause));
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.ui.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MusicTabLikedFragment.K1(this.f59985a, view);
            }
        });
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        G1().r().j(this, new b(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicTabLikedFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Subject> pair) {
                invoke2((Pair<String, ? extends Subject>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, ? extends Subject> pair) {
                sz.a.f76638a.a(MusicTabLikedFragment.this.j0() + " --> initViewModel() --> showPlayer(it.second)");
                Subject second = pair.getSecond();
                if (second != null) {
                    MusicTabLikedFragment musicTabLikedFragment = MusicTabLikedFragment.this;
                    musicTabLikedFragment.U1(second);
                    musicTabLikedFragment.T1(second);
                }
            }
        }));
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void l1() {
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void m1(BaseQuickAdapter<?, ?> adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void n1(String str, String str2, boolean z11) {
        r1(getPageName(), z11);
        if (TextUtils.isEmpty(str)) {
            zp.b.f82110a.d(com.tn.lib.widget.R$string.error_load_failed);
        } else if (com.tn.lib.util.networkinfo.f.f49475a.e() || !TextUtils.isEmpty(str2)) {
            com.alibaba.android.arouter.launcher.a.d().b("/playvideo/music_detail").withString("id", str).withBoolean("is_music_liked_fragment", true).navigation();
        } else {
            zp.b.f82110a.d(R$string.music_no_network);
            MusicFloatManager.f51403i.b().l();
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void o1(MediaSource mediaSource) {
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        MediaItem mediaItemH;
        MediaItem mediaItemH2;
        super.onCompletion(mediaSource);
        if (sz.b.f76639a.a()) {
            sz.a.f76638a.b(j0() + " --> onCompletion() --> 详情页处理");
            return;
        }
        int i11 = a.f59960a[sz.c.f76641a.b().ordinal()];
        if (i11 == 1) {
            sz.a.f76638a.a(j0() + " --> onCompletion() --> Tab 内存处理 --> MusicLoopEnum.NORMAL --> 播放结束");
            return;
        }
        String subjectId = null;
        if (i11 == 2) {
            sz.a.f76638a.a(j0() + " --> onCompletion() --> Tab 内存处理 --> MusicLoopEnum.LIST_LOOP --> 列表循环");
            if (mediaSource != null && (mediaItemH = mediaSource.h()) != null) {
                subjectId = mediaItemH.getSubjectId();
            }
            O1(subjectId);
            return;
        }
        if (i11 != 3) {
            return;
        }
        sz.a.f76638a.a(j0() + " --> onCompletion() --> Tab 内存处理 --> MusicLoopEnum.SINGLE_LOOP --> 单曲循环");
        if (mediaSource != null && (mediaItemH2 = mediaSource.h()) != null) {
            subjectId = mediaItemH2.getSubjectId();
        }
        M1(subjectId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        View view;
        super.v0();
        rz.e eVar = (rz.e) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (eVar == null || (view = eVar.f75806i) == null) ? null : view.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).height = com.blankj.utilcode.util.d.c() + f0.a(52.0f) + f0.a(30.0f);
    }
}
