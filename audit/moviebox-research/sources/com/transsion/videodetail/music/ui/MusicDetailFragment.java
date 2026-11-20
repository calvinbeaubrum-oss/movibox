package com.transsion.videodetail.music.ui;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.p;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.image.blurhash.BlurHashHelper;
import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.bean.GameInfoType;
import com.transsion.commercializationapi.IGameResApi;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.fragment.ResourceDetectorEmptyFragment;
import com.transsion.moviedetail.fragment.RestrictTipsDialog;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectGameInfo;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.play.detail.PlayDetailBottomRecHelper;
import com.transsion.player.longvideo.constants.LongVodPageType;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.player.p006enum.PlayMimeType;
import com.transsion.publish.api.IPublishApi;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
import com.transsion.videodetail.VideoDetailViewModel;
import com.transsion.videodetail.VideoEpisodeFragment;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import com.transsion.videodetail.bean.VideoDetailStream;
import com.transsion.videodetail.bean.VideoDetailStreamList;
import com.transsion.videodetail.music.bean.MusicLikedMultiItemEntity;
import com.transsion.videodetail.music.bean.MusicLoopEnum;
import com.transsion.videodetail.music.bean.MusicStateEnum;
import com.transsion.videodetail.music.data.MusicLikedFragmentViewModel;
import com.transsion.videodetail.music.widget.MusicDetailListOperateView;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;
import net.lucode.hackware.magicindicator.MagicIndicator;

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
public final class MusicDetailFragment extends PageStatusFragment<rz.f> implements RoomActivityLifecycleCallbacks.a, hv.a {
    public static final a W = new a(null);
    public int A;
    public int B;
    public int C;
    public String D;
    public boolean E;
    public boolean F;
    public IFissionProvider G;
    public final Lazy H;
    public final Lazy I;
    public long J;
    public VideoDetailPlayBean K;
    public boolean L;
    public boolean M;
    public DownloadBean N;
    public Function0<Boolean> O;
    public final e P;
    public VideoDetailStreamList Q;
    public rz.j R;
    public boolean S;
    public View T;
    public boolean U;
    public final d0<VideoDetailStreamList> V;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f59930k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public kv.a f59931l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PlayDetailBottomRecHelper f59932m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Subject f59933n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f59934o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f59935p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f59936q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f59937r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f59938s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f59939t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f59940u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f59941v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f59942w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f59943x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f59944y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f59945z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MusicDetailFragment a() {
            return new MusicDetailFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f59946a;

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
            f59946a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BubbleTextView bubbleTextView;
            ViewTreeObserver viewTreeObserver;
            rz.f mViewBinding = MusicDetailFragment.this.getMViewBinding();
            if (mViewBinding != null && (bubbleTextView = mViewBinding.f75808b) != null && (viewTreeObserver = bubbleTextView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            rz.f mViewBinding2 = MusicDetailFragment.this.getMViewBinding();
            BubbleTextView bubbleTextView2 = mViewBinding2 != null ? mViewBinding2.f75808b : null;
            if (bubbleTextView2 == null || bubbleTextView2.getMeasuredWidth() == 0) {
                return;
            }
            float measuredWidth = (bubbleTextView2.getMeasuredWidth() / 2) - (f0.a(16.0f) / 2);
            bubbleTextView2.setArrowPosition(measuredWidth);
            uo.b.a.f(uo.b.f78622a, "MusicDetailFragment", "activity tip width: " + bubbleTextView2.getMeasuredWidth() + ", arrowPosition: " + measuredWidth, false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends p {
        public d() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            Function0 function0 = MusicDetailFragment.this.O;
            if (function0 == null || !((Boolean) function0.invoke()).booleanValue()) {
                if (MusicDetailFragment.this.f59931l != null) {
                    kv.a aVar = MusicDetailFragment.this.f59931l;
                    if (aVar != null) {
                        aVar.onBackPressed();
                        return;
                    }
                    return;
                }
                FragmentActivity activity = MusicDetailFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements com.tn.lib.util.networkinfo.g {
        public e() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            MusicDetailFragment.this.K1();
            VideoDetailMediaSource videoDetailMediaSourceF = MusicDetailFragment.this.U1().v().f();
            if (videoDetailMediaSourceF != null) {
                MusicDetailFragment musicDetailFragment = MusicDetailFragment.this;
                VideoDetailStreamList videoDetailStreamListF = musicDetailFragment.U1().u().f();
                if (videoDetailStreamListF != null && videoDetailMediaSourceF.getSe() == videoDetailStreamListF.getSe() && videoDetailMediaSourceF.getEp() == videoDetailStreamListF.getEp()) {
                    return;
                }
                musicDetailFragment.L1(videoDetailMediaSourceF);
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59950a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59950a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59950a;
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
            this.f59950a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class g implements kv.a.b {
        public g() {
        }

        @Override // kv.a.b
        public void a() {
            MusicDetailFragment.this.G1();
        }

        @Override // kv.a.b
        public boolean b() {
            if (MusicDetailFragment.this.S && com.tn.lib.util.networkinfo.f.f49475a.e()) {
                MusicDetailFragment musicDetailFragment = MusicDetailFragment.this;
                musicDetailFragment.L1(musicDetailFragment.U1().v().f());
            }
            return MusicDetailFragment.this.S;
        }

        @Override // kv.a.b
        public boolean c(FloatActionType actionType) {
            Intrinsics.g(actionType, "actionType");
            return false;
        }

        @Override // kv.a.b
        public void d(lv.a aVar) {
            MusicDetailFragment.this.p2(aVar);
        }

        @Override // kv.a.b
        public void e(LongVodUiType uiType) {
            MusicDetailListOperateView musicDetailListOperateView;
            Intrinsics.g(uiType, "uiType");
            MusicDetailFragment.this.o2(uiType);
            rz.f mViewBinding = MusicDetailFragment.this.getMViewBinding();
            if (mViewBinding != null && (musicDetailListOperateView = mViewBinding.f75821p) != null) {
                musicDetailListOperateView.setState(MusicStateEnum.CLOSE);
            }
            PlayDetailBottomRecHelper playDetailBottomRecHelper = MusicDetailFragment.this.f59932m;
            if (playDetailBottomRecHelper != null) {
                playDetailBottomRecHelper.u(uiType != LongVodUiType.MIDDLE);
            }
        }

        @Override // kv.a.b
        public View f() {
            return MusicDetailFragment.this.T;
        }

        @Override // kv.a.b
        public void g(boolean z11) {
            rz.f mViewBinding = MusicDetailFragment.this.getMViewBinding();
            AppCompatImageView appCompatImageView = mViewBinding != null ? mViewBinding.f75817l : null;
            if (appCompatImageView == null) {
                return;
            }
            appCompatImageView.setVisibility(z11 ? 0 : 8);
        }

        @Override // kv.a.b
        public void onCompletion() {
            MusicDetailFragment.this.G1();
        }
    }

    public MusicDetailFragment() {
        String string = UUID.randomUUID().toString();
        Intrinsics.f(string, "randomUUID().toString()");
        this.f59930k = string;
        this.f59934o = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<v0.c>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$special$$inlined$activityViewModels$default$2
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
        this.f59935p = FragmentViewModelLazyKt.a(this, Reflection.b(VideoDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$special$$inlined$activityViewModels$default$3
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
        }, new Function0<v0.c>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$special$$inlined$activityViewModels$default$4
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
        this.f59936q = LazyKt__LazyJVMKt.b(new Function0<MusicLikedFragmentViewModel>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$mViewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MusicLikedFragmentViewModel invoke() {
                return new MusicLikedFragmentViewModel();
            }
        });
        this.f59937r = LazyKt__LazyJVMKt.b(new Function0<tr.c>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$downloadDao$2
            @Override // kotlin.jvm.functions.Function0
            public final tr.c invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).E0();
            }
        });
        this.A = 1;
        this.G = (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class);
        this.H = LazyKt__LazyJVMKt.b(new Function0<IMemberApi>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$memberProvider$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IMemberApi invoke() {
                return (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
            }
        });
        this.I = LazyKt__LazyJVMKt.b(new Function0<IPublishApi>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$publishedApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IPublishApi invoke() {
                return (IPublishApi) com.alibaba.android.arouter.launcher.a.d().h(IPublishApi.class);
            }
        });
        this.P = new e();
        this.V = new d0() { // from class: com.transsion.videodetail.music.ui.e
            @Override // androidx.lifecycle.d0
            public final void onChanged(Object obj) {
                MusicDetailFragment.s2(this.f59977a, (VideoDetailStreamList) obj);
            }
        };
    }

    public static final void A2(MusicDetailFragment this$0, Subject this_apply, View view) {
        String url;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        IPublishApi iPublishApiT1 = this$0.T1();
        if (iPublishApiT1 != null) {
            Context context = view.getContext();
            Intrinsics.f(context, "it.context");
            String str = this$0.f59938s;
            if (str == null) {
                str = "";
            }
            Cover cover = this_apply.getCover();
            if (cover == null || (url = cover.getUrl()) == null) {
                url = "";
            }
            String title = this_apply.getTitle();
            if (title == null) {
                title = "";
            }
            String description = this_apply.getDescription();
            iPublishApiT1.k0(context, str, url, title, description == null ? "" : description, 3);
        }
        com.transsion.baselib.helper.a.f51183a.g("subjectdetail", "post", (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
    }

    private final void B2(Subject subject) {
        Cover stills;
        FrameLayout frameLayout;
        if (subject != null) {
            Trailer trailer = subject.getTrailer();
            if ((trailer == null || (stills = trailer.getCover()) == null) && (stills = subject.getStills()) == null) {
                stills = subject.getCover();
            }
            if (stills != null) {
                int iF = com.transsion.core.utils.e.f();
                rz.f mViewBinding = getMViewBinding();
                if (mViewBinding == null || (frameLayout = mViewBinding.f75815j) == null) {
                    return;
                }
                Intrinsics.f(frameLayout, "mViewBinding?.flPlayer ?: return");
                if (frameLayout.getChildCount() == 0) {
                    ImageView imageView = new ImageView(frameLayout.getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    frameLayout.addView(imageView, new FrameLayout.LayoutParams(iF, (iF * 9) / 16));
                    ImageHelper.Companion companion = ImageHelper.f51371a;
                    String url = stills.getUrl();
                    String strE = companion.e(url == null ? "" : url, (124 & 2) != 0 ? 0 : iF, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0);
                    String thumbnail = stills.getThumbnail();
                    BlurHashHelper.b(BlurHashHelper.f51391a, thumbnail == null ? "" : thumbnail, 0, 0, new Function1<BitmapDrawable, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$showCover$1$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(BitmapDrawable bitmapDrawable) {
                            invoke2(bitmapDrawable);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(BitmapDrawable drawable) {
                            Intrinsics.g(drawable, "drawable");
                            rz.f mViewBinding2 = this.this$0.getMViewBinding();
                            FrameLayout frameLayout2 = mViewBinding2 != null ? mViewBinding2.f75815j : null;
                            if (frameLayout2 == null) {
                                return;
                            }
                            frameLayout2.setBackground(drawable);
                        }
                    }, 6, null);
                    Context context = imageView.getContext();
                    Intrinsics.f(context, "imageView.context");
                    companion.o(context, imageView, strE, (32704 & 8) != 0 ? R$color.skeleton : R$color.transparent, (32704 & 16) != 0 ? companion.d() : 0, (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
                }
            }
        }
    }

    private final boolean D1() {
        if (this.F) {
            return false;
        }
        return this.G.G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final void D2() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        View view = this.T;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.T);
        }
        KeyEvent.Callback callback = this.T;
        ss.a aVar = callback instanceof ss.a ? (ss.a) callback : null;
        if (aVar != null) {
            aVar.setPageStyle("detail");
        }
        rz.f mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout3 = mViewBinding.f75816k) != null) {
            so.c.k(frameLayout3);
        }
        rz.f mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (frameLayout2 = mViewBinding2.f75816k) != null) {
            frameLayout2.removeAllViews();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        rz.f mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (frameLayout = mViewBinding3.f75816k) == null) {
            return;
        }
        frameLayout.addView(this.T, layoutParams);
    }

    private final void E1() {
        BubbleTextView bubbleTextView;
        ViewTreeObserver viewTreeObserver;
        rz.f mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f75808b) == null || (viewTreeObserver = bubbleTextView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new c());
    }

    private final void E2(Subject subject) {
    }

    @Deprecated
    private final void F1() {
        ResourcesSeasonList resourcesSeasonListF = U1().w().f();
        if (resourcesSeasonListF == null) {
            return;
        }
        boolean z11 = false;
        if (resourcesSeasonListF.isSeries()) {
            uo.b.a.f(uo.b.f78622a, "MusicDetailFragment", "checkPlayNextOrReplay 是剧集，判断下一集还是完成 ", false, 4, null);
            List<VideoDetailMediaSource> listF = U1().q().f();
            if (listF == null) {
                listF = kotlin.collections.g.l();
            }
            VideoDetailMediaSource videoDetailMediaSourceF = U1().v().f();
            int iIndexOf = videoDetailMediaSourceF != null ? listF.indexOf(videoDetailMediaSourceF) : -1;
            if (iIndexOf >= 0 && iIndexOf < listF.size() - 1) {
                z11 = true;
            }
        }
        kv.a aVar = this.f59931l;
        if (aVar != null) {
            aVar.hasNextEpisode(z11);
        }
    }

    private final void F2() {
        LinearLayout root;
        rz.f mViewBinding;
        FrameLayout frameLayout;
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (this.R == null) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
            rz.f mViewBinding2 = getMViewBinding();
            this.R = rz.j.c(layoutInflaterFrom, mViewBinding2 != null ? mViewBinding2.f75815j : null, false);
        }
        rz.j jVar = this.R;
        if (jVar == null || (root = jVar.getRoot()) == null) {
            return;
        }
        if (root.getParent() == null && (mViewBinding = getMViewBinding()) != null && (frameLayout = mViewBinding.f75815j) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.bottomMargin = com.blankj.utilcode.util.i.e(20.0f);
            Unit unit = Unit.f68710a;
            frameLayout.addView(root, layoutParams);
        }
        so.c.k(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1() {
        MusicDetailListOperateView musicDetailListOperateView;
        MusicDetailLikedFragment musicDetailLikedFragment;
        MusicLikedMultiItemEntity musicLikedMultiItemEntityZ0;
        MusicLikedDbBean musicLikedDbBean;
        MusicDetailListOperateView musicDetailListOperateView2;
        MusicDetailLikedFragment musicDetailLikedFragment2;
        int i11 = b.f59946a[sz.c.f76641a.b().ordinal()];
        if (i11 == 1) {
            kv.a aVar = this.f59931l;
            if (aVar != null) {
                aVar.showReplay();
                return;
            }
            return;
        }
        if (i11 != 2) {
            if (i11 != 3) {
                return;
            }
            sz.a.f76638a.a(j0() + " --> checkPlayNextOrReplay() --> playerControl?.replay()");
            kv.a aVar2 = this.f59931l;
            if (aVar2 != null) {
                aVar2.replay();
                return;
            }
            return;
        }
        rz.f mViewBinding = getMViewBinding();
        String subjectId = null;
        String strD1 = (mViewBinding == null || (musicDetailListOperateView2 = mViewBinding.f75821p) == null || (musicDetailLikedFragment2 = musicDetailListOperateView2.getMusicDetailLikedFragment()) == null) ? null : musicDetailLikedFragment2.d1();
        if (TextUtils.isEmpty(strD1)) {
            rz.f mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (musicDetailListOperateView = mViewBinding2.f75821p) != null && (musicDetailLikedFragment = musicDetailListOperateView.getMusicDetailLikedFragment()) != null && (musicLikedMultiItemEntityZ0 = musicDetailLikedFragment.Z0()) != null && (musicLikedDbBean = musicLikedMultiItemEntityZ0.getMusicLikedDbBean()) != null) {
                subjectId = musicLikedDbBean.getSubjectId();
            }
            strD1 = subjectId;
        }
        t2(strD1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2(final Subject subject) {
        O1().A(subject.getSubjectId(), new Function1<String, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$showMusicPlayLayout$1
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
                    this.this$0.w2(subject);
                } else {
                    this.this$0.r2(subject.getSubjectId());
                }
            }
        });
    }

    private final void H1() throws InterruptedException {
        String str;
        boolean z11;
        String subjectId;
        ResourceDetectors resourceDetector;
        if (getContext() == null) {
            return;
        }
        Subject subject = this.f59933n;
        String str2 = "";
        int ep2 = 0;
        if (subject == null || (resourceDetector = subject.getResourceDetector()) == null) {
            str = "";
            z11 = false;
        } else {
            String resourceLink = resourceDetector.getResourceLink();
            if (resourceLink == null) {
                resourceLink = "";
            }
            String resourceId = resourceDetector.getResourceId();
            str2 = resourceId != null ? resourceId : "";
            z11 = resourceDetector.isMultiResolution();
            str = resourceLink;
        }
        DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
        DownloadManagerApi downloadManagerApiA = aVar.a();
        Subject subject2 = this.f59933n;
        String subjectId2 = subject2 != null ? subject2.getSubjectId() : null;
        Subject subject3 = this.f59933n;
        if (downloadManagerApiA.m2(subjectId2, str2, subject3 != null && subject3.isSeries(), z11)) {
            Subject subject4 = this.f59933n;
            if (subject4 == null || (subjectId = subject4.getSubjectId()) == null) {
                return;
            }
            DownloadManagerApi downloadManagerApiA2 = aVar.a();
            Context context = getContext();
            Intrinsics.d(context);
            DownloadManagerApi.p2(downloadManagerApiA2, subjectId, context, "music_stream_detail", null, 8, null);
            return;
        }
        Subject subject5 = this.f59933n;
        if (subject5 != null) {
            Integer subjectType = subject5.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi downloadManagerApiA3 = aVar.a();
                Context context2 = getContext();
                Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context2;
                Subject subject6 = this.f59933n;
                downloadManagerApiA3.a2(fragmentActivity, "music_stream_detail", (384 & 4) != 0 ? "" : "", subject6 != null ? subject6.getOps() : null, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : this.f59933n, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        VideoDetailMediaSource videoDetailMediaSourceF = U1().v().f();
        if (videoDetailMediaSourceF != null && videoDetailMediaSourceF.getSe() == this.A) {
            ep2 = videoDetailMediaSourceF.getEp();
        }
        DownloadManagerApi downloadManagerApiA4 = aVar.a();
        Context context3 = getContext();
        Intrinsics.e(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        DownloadManagerApi.S1(downloadManagerApiA4, (FragmentActivity) context3, this.f59933n, "music_stream_detail", "", "", str, String.valueOf(ep2), this.f59941v, null, false, this.A, false, 768, null);
    }

    private final void H2() {
        kv.a aVar = this.f59931l;
        if (aVar != null) {
            aVar.showNoNetError();
        }
        this.S = true;
    }

    private final void I1() {
        BubbleTextView bubbleTextView;
        this.F = true;
        rz.f mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f75808b) == null) {
            return;
        }
        so.c.g(bubbleTextView);
    }

    private final void J1() {
        LinearLayout root;
        ViewParent parent;
        rz.j jVar = this.R;
        if (jVar == null || (root = jVar.getRoot()) == null || (parent = root.getParent()) == null) {
            return;
        }
        Intrinsics.f(parent, "parent");
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(root);
        }
    }

    private final void J2() {
        Context context;
        Integer subjectType;
        if (this.f59931l == null && (context = getContext()) != null) {
            Subject subject = this.f59933n;
            LongVodPageType longVodPageType = ((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) == SubjectType.MUSIC.getValue() ? LongVodPageType.MUSIC : LongVodPageType.MUSIC;
            rz.f mViewBinding = getMViewBinding();
            if (mViewBinding != null) {
                LongVodPlayerView longVodPlayerView = new LongVodPlayerView(context);
                String strName = longVodPageType.name();
                Subject subject2 = this.f59933n;
                kv.a.C0746a.a(longVodPlayerView, "music_stream_detail", longVodPageType, strName + (subject2 != null ? subject2.getSubjectId() : null), mViewBinding.f75813h, mViewBinding.f75819n.f71219g, null, 32, null);
                longVodPlayerView.setFeedBackVisible(true);
                longVodPlayerView.setFragmentId(this.f59930k);
                mViewBinding.f75815j.addView(longVodPlayerView);
                longVodPlayerView.setMusicLikedFragment(this.L);
                this.f59931l = longVodPlayerView;
            }
            Subject subject3 = this.f59933n;
            if (subject3 != null) {
                j2(subject3);
            }
            kv.a aVar = this.f59931l;
            if (aVar != null) {
                aVar.setCallback(new g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        kv.a aVar = this.f59931l;
        if (aVar != null) {
            aVar.removeNoNetError();
        }
        this.S = false;
    }

    private final void K2(Subject subject) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final void L1(VideoDetailMediaSource videoDetailMediaSource) {
        if (videoDetailMediaSource == null) {
            return;
        }
        VideoDetailStreamList videoDetailStreamListF = U1().u().f();
        if (videoDetailStreamListF != null && videoDetailStreamListF.getSe() == videoDetailMediaSource.getSe() && videoDetailStreamListF.getEp() == videoDetailMediaSource.getEp()) {
            return;
        }
        kv.a aVar = this.f59931l;
        if (aVar != null) {
            aVar.reset();
        }
        F2();
        U1().t(videoDetailMediaSource);
        F1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final tr.c M1() {
        return (tr.c) this.f59937r.getValue();
    }

    public static /* synthetic */ void M2(MusicDetailFragment musicDetailFragment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        musicDetailFragment.L2(z11);
    }

    public static final void N1(MusicDetailFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    private final void N2() {
        BubbleTextView bubbleTextView;
        rz.f mViewBinding;
        DownloadView downloadView;
        rz.f mViewBinding2;
        DownloadView downloadView2;
        BubbleTextView bubbleTextView2;
        if (!D1() || (mViewBinding = getMViewBinding()) == null || (downloadView = mViewBinding.f75810d) == null || downloadView.getVisibility() != 0 || (mViewBinding2 = getMViewBinding()) == null || (downloadView2 = mViewBinding2.f75810d) == null || downloadView2.getShowType() != 0) {
            rz.f mViewBinding3 = getMViewBinding();
            if (mViewBinding3 == null || (bubbleTextView = mViewBinding3.f75808b) == null) {
                return;
            }
            so.c.g(bubbleTextView);
            return;
        }
        rz.f mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (bubbleTextView2 = mViewBinding4.f75808b) != null) {
            so.c.k(bubbleTextView2);
        }
        E1();
    }

    private final MusicLikedFragmentViewModel O1() {
        return (MusicLikedFragmentViewModel) this.f59936q.getValue();
    }

    private final void O2(int i11) {
        String str;
        boolean z11;
        String str2;
        HashMap<String, String> mapG;
        DownloadView downloadView;
        DownloadView downloadView2;
        ResourceDetectors resourceDetector;
        rz.f mViewBinding = getMViewBinding();
        DownloadView downloadView3 = mViewBinding != null ? mViewBinding.f75810d : null;
        if (downloadView3 != null) {
            downloadView3.setVisibility(i11);
        }
        Subject subject = this.f59933n;
        if (subject == null || (resourceDetector = subject.getResourceDetector()) == null) {
            str = "";
            z11 = false;
        } else {
            String resourceId = resourceDetector.getResourceId();
            String str3 = resourceId != null ? resourceId : "";
            z11 = resourceDetector.isMultiResolution();
            str = str3;
        }
        rz.f mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (downloadView2 = mViewBinding2.f75810d) != null) {
            String str4 = this.f59938s;
            Subject subject2 = this.f59933n;
            DownloadView.setShowType$default(downloadView2, str4, str, subject2 != null ? Boolean.valueOf(subject2.isSeries()) : null, z11, 0, 16, null);
        }
        rz.f mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (downloadView = mViewBinding3.f75810d) == null || downloadView.getShowType() != 1) {
            str2 = "download_subject";
        } else {
            rz.f mViewBinding4 = getMViewBinding();
            DownloadView downloadView4 = mViewBinding4 != null ? mViewBinding4.f75810d : null;
            if (downloadView4 != null) {
                downloadView4.setVisibility(8);
            }
            str2 = "play_subject";
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            mapG.put(CampaignEx.KEY_SHOW_TYPE, str2);
        }
        N2();
    }

    private final IMemberApi P1() {
        return (IMemberApi) this.H.getValue();
    }

    public static /* synthetic */ void P2(MusicDetailFragment musicDetailFragment, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        musicDetailFragment.O2(i11);
    }

    private final PlayMimeType Q1(VideoDetailStream videoDetailStream) {
        String upperCase = videoDetailStream.getFormat().toUpperCase(Locale.ROOT);
        Intrinsics.f(upperCase, "toUpperCase(...)");
        PlayMimeType playMimeType = PlayMimeType.DASH;
        if (Intrinsics.b(upperCase, playMimeType.name())) {
            return playMimeType;
        }
        PlayMimeType playMimeType2 = PlayMimeType.HLS;
        return Intrinsics.b(upperCase, playMimeType2.name()) ? playMimeType2 : PlayMimeType.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q2() {
        ResourcesSeasonList resourcesSeasonListF = U1().w().f();
        if (resourcesSeasonListF == null || this.f59933n == null) {
            return;
        }
        if (resourcesSeasonListF.isNoSource()) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            ResourceDetectorEmptyFragment resourceDetectorEmptyFragment = new ResourceDetectorEmptyFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.f59933n);
            resourceDetectorEmptyFragment.setArguments(bundle);
            fragmentTransactionBeginTransaction.replace(R$id.resourceDetectorGroup, resourceDetectorEmptyFragment);
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            O2(8);
            return;
        }
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.f(childFragmentManager2, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction2 = childFragmentManager2.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction2, "beginTransaction()");
        VideoEpisodeFragment videoEpisodeFragment = new VideoEpisodeFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("data_key_resource_detectors", this.f59933n);
        bundle2.putString("ops", this.f59939t);
        bundle2.putBoolean("auto_play", this.f59943x);
        bundle2.putString("auto_play_resource_id", this.f59944y);
        bundle2.putString("module_name", this.f59941v);
        bundle2.putInt("season", this.A);
        videoEpisodeFragment.setArguments(bundle2);
        fragmentTransactionBeginTransaction2.replace(R$id.resourceDetectorGroup, videoEpisodeFragment);
        fragmentTransactionBeginTransaction2.commitAllowingStateLoss();
        P2(this, 0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MovieDetailViewModel R1() {
        return (MovieDetailViewModel) this.f59934o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R2(Subject subject) {
        Subject subject2;
        this.f59933n = subject;
        String ops = subject != null ? subject.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject2 = this.f59933n) != null) {
            subject2.setOps(this.f59939t);
        }
        ResourcesSeasonList resourcesSeasonListF = U1().w().f();
        if (resourcesSeasonListF == null || !resourcesSeasonListF.isNoSource()) {
            J2();
        } else {
            B2(this.f59933n);
        }
        M2(this, false, 1, null);
        if (!this.U) {
            f2();
            n2(true);
        }
        E2(this.f59933n);
        K2(this.f59933n);
        z2();
        c2();
        Q2();
    }

    private final VideoDetailMediaSource S1(VideoDetailPlayBean videoDetailPlayBean, List<VideoDetailMediaSource> list) {
        Object obj = null;
        if (videoDetailPlayBean == null) {
            uo.b.a.f(uo.b.f78622a, "MusicDetailFragment", "getPlayingItem 无历史记录，se:" + this.B, false, 4, null);
            if (this.B <= 0) {
                return (VideoDetailMediaSource) CollectionsKt___CollectionsKt.g0(list);
            }
            for (Object obj2 : list) {
                VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) obj2;
                if (videoDetailMediaSource.getSe() == this.B && videoDetailMediaSource.getEp() == 1) {
                    obj = obj2;
                    break;
                }
            }
            VideoDetailMediaSource videoDetailMediaSource2 = (VideoDetailMediaSource) obj;
            return videoDetailMediaSource2 == null ? (VideoDetailMediaSource) CollectionsKt___CollectionsKt.g0(list) : videoDetailMediaSource2;
        }
        int se2 = videoDetailPlayBean.getSe();
        int i11 = this.B;
        if (se2 == i11 || i11 <= 0) {
            this.A = videoDetailPlayBean.getSe();
            uo.b.a.f(uo.b.f78622a, "MusicDetailFragment", "getPlayingItem 有历史记录，不指定季使用历史记录，se:" + videoDetailPlayBean.getSe() + ", ep:" + videoDetailPlayBean.getEp(), false, 4, null);
            for (Object obj3 : list) {
                VideoDetailMediaSource videoDetailMediaSource3 = (VideoDetailMediaSource) obj3;
                if (videoDetailMediaSource3.getSe() == videoDetailPlayBean.getSe() && videoDetailMediaSource3.getEp() == videoDetailPlayBean.getEp()) {
                    obj = obj3;
                    break;
                }
            }
            VideoDetailMediaSource videoDetailMediaSource4 = (VideoDetailMediaSource) obj;
            return videoDetailMediaSource4 == null ? (VideoDetailMediaSource) CollectionsKt___CollectionsKt.g0(list) : videoDetailMediaSource4;
        }
        uo.b.a.f(uo.b.f78622a, "MusicDetailFragment", "getPlayingItem 有历史记录，指定季，history se:" + videoDetailPlayBean.getSe() + ", ep:" + videoDetailPlayBean.getEp() + "， target se:" + this.B + ", targetEp:" + this.C, false, 4, null);
        for (Object obj4 : list) {
            VideoDetailMediaSource videoDetailMediaSource5 = (VideoDetailMediaSource) obj4;
            if (videoDetailMediaSource5.getSe() == this.B) {
                int ep2 = videoDetailMediaSource5.getEp();
                int i12 = this.C;
                if (i12 <= 0) {
                    i12 = 1;
                }
                if (ep2 == i12) {
                    obj = obj4;
                    break;
                }
            }
        }
        VideoDetailMediaSource videoDetailMediaSource6 = (VideoDetailMediaSource) obj;
        return videoDetailMediaSource6 == null ? (VideoDetailMediaSource) CollectionsKt___CollectionsKt.g0(list) : videoDetailMediaSource6;
    }

    private final IPublishApi T1() {
        return (IPublishApi) this.I.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailViewModel U1() {
        return (VideoDetailViewModel) this.f59935p.getValue();
    }

    private final List<lv.c> W1(DownloadBean downloadBean) {
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

    private final List<lv.c> X1(Trailer trailer) {
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

    private final List<lv.c> Y1(List<VideoDetailStream> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (VideoDetailStream videoDetailStream : list) {
                arrayList.add(new lv.c(Q1(videoDetailStream), videoDetailStream.getId(), videoDetailStream.getUrl(), videoDetailStream.getResolutions(), videoDetailStream.getSize(), videoDetailStream.getDuration(), videoDetailStream.getSignCookie()));
            }
        }
        return arrayList;
    }

    @Deprecated
    private final void Z1() {
        VideoDetailStreamList videoDetailStreamListF;
        VideoDetailMediaSource videoDetailMediaSourceF;
        if (this.f59933n == null || (videoDetailStreamListF = U1().u().f()) == null || (videoDetailMediaSourceF = U1().v().f()) == null || Intrinsics.b(videoDetailStreamListF, this.Q) || videoDetailMediaSourceF.getEp() != videoDetailStreamListF.getEp() || videoDetailMediaSourceF.getSe() != videoDetailStreamListF.getSe()) {
            return;
        }
        this.Q = videoDetailStreamListF;
        J1();
        v2(videoDetailStreamListF);
    }

    private final void a2() {
        BubbleTextView bubbleTextView;
        BubbleTextView bubbleTextView2;
        BubbleTextView bubbleTextView3;
        rz.f mViewBinding = getMViewBinding();
        if (mViewBinding != null && (bubbleTextView3 = mViewBinding.f75808b) != null) {
            bubbleTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.ui.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MusicDetailFragment.b2(this.f59980a, view);
                }
            });
        }
        rz.f mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (bubbleTextView2 = mViewBinding2.f75808b) != null) {
            so.c.k(bubbleTextView2);
        }
        E1();
        rz.f mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (bubbleTextView = mViewBinding3.f75808b) == null) {
            return;
        }
        so.c.g(bubbleTextView);
    }

    public static final void b2(MusicDetailFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "MusicDetailFragment", "Click activity tip", false, 4, null);
        this$0.F = true;
        Intrinsics.f(it, "it");
        so.c.g(it);
    }

    private final void c2() {
        Subject subject = this.f59933n;
        rz.f mViewBinding = getMViewBinding();
        MagicIndicator magicIndicator = mViewBinding != null ? mViewBinding.f75820o : null;
        rz.f mViewBinding2 = getMViewBinding();
        this.f59932m = new PlayDetailBottomRecHelper(this, subject, magicIndicator, mViewBinding2 != null ? mViewBinding2.f75822q : null, "music_stream_detail", false, false, new Function1<Integer, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$initBottomRec$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                DownloadView downloadView;
                DownloadView downloadView2;
                rz.f mViewBinding3 = this.this$0.getMViewBinding();
                if (mViewBinding3 == null || (downloadView = mViewBinding3.f75810d) == null || downloadView.getShowType() != 1) {
                    rz.f mViewBinding4 = this.this$0.getMViewBinding();
                    DownloadView downloadView3 = mViewBinding4 != null ? mViewBinding4.f75810d : null;
                    if (downloadView3 != null) {
                        downloadView3.setVisibility(i11 != 1 ? 0 : 8);
                    }
                } else {
                    rz.f mViewBinding5 = this.this$0.getMViewBinding();
                    if (mViewBinding5 != null && (downloadView2 = mViewBinding5.f75810d) != null) {
                        so.c.g(downloadView2);
                    }
                }
                rz.f mViewBinding6 = this.this$0.getMViewBinding();
                AppCompatImageView appCompatImageView = mViewBinding6 != null ? mViewBinding6.f75818m : null;
                if (appCompatImageView == null) {
                    return;
                }
                appCompatImageView.setVisibility(i11 == 1 ? 0 : 8);
            }
        }, 96, null);
    }

    private final void d2() {
        DownloadView downloadView;
        DownloadView downloadView2;
        rz.f mViewBinding = getMViewBinding();
        if (mViewBinding != null && (downloadView2 = mViewBinding.f75810d) != null) {
            DownloadView.setAttrs$default(downloadView2, null, Float.valueOf(com.transsion.core.utils.e.g(16.0f)), null, 5, null);
        }
        rz.f mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (downloadView = mViewBinding2.f75810d) == null) {
            return;
        }
        downloadView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws InterruptedException {
                MusicDetailFragment.e2(this.f59978a, view);
            }
        });
    }

    public static final void e2(MusicDetailFragment this$0, View view) throws InterruptedException {
        ResourceDetectors resourceDetector;
        List<DownloadItem> resolutionList;
        ResourceDetectors resourceDetector2;
        List<DownloadItem> resolutionList2;
        Intrinsics.g(this$0, "this$0");
        Subject subject = this$0.f59933n;
        if (subject != null && (resourceDetector = subject.getResourceDetector()) != null && (resolutionList = resourceDetector.getResolutionList()) != null && (!resolutionList.isEmpty())) {
            Subject subject2 = this$0.f59933n;
            Integer numValueOf = (subject2 == null || (resourceDetector2 = subject2.getResourceDetector()) == null || (resolutionList2 = resourceDetector2.getResolutionList()) == null) ? null : Integer.valueOf(resolutionList2.size());
            Intrinsics.d(numValueOf);
            if (numValueOf.intValue() > 1) {
                Subject subject3 = this$0.f59933n;
                ResourceDetectors resourceDetector3 = subject3 != null ? subject3.getResourceDetector() : null;
                if (resourceDetector3 != null) {
                    resourceDetector3.setType(1);
                }
            }
        }
        this$0.H1();
        this$0.I1();
    }

    @Deprecated
    private final void f2() {
        String genre;
        SubjectGameInfo gameInfo;
        SubjectGameInfo gameInfo2;
        SubjectGameInfo gameInfo3;
        SubjectGameInfo gameInfo4;
        this.U = true;
        Subject subject = this.f59933n;
        String itemId = null;
        String type = (subject == null || (gameInfo4 = subject.getGameInfo()) == null) ? null : gameInfo4.getType();
        if (type != null && type.length() != 0) {
            Subject subject2 = this.f59933n;
            String itemId2 = (subject2 == null || (gameInfo3 = subject2.getGameInfo()) == null) ? null : gameInfo3.getItemId();
            if (itemId2 != null && itemId2.length() != 0) {
                uo.b.a.f(uo.b.f78622a, "GameResLoader", "stream detail game initGameRes", false, 4, null);
                Context context = getContext();
                if (context == null) {
                    return;
                }
                IGameResApi iGameResApi = (IGameResApi) com.alibaba.android.arouter.launcher.a.d().h(IGameResApi.class);
                Subject subject3 = this.f59933n;
                GameInfoType gameInfoType = (subject3 == null || (gameInfo2 = subject3.getGameInfo()) == null) ? null : gameInfo2.getGameInfoType();
                Intrinsics.d(gameInfoType);
                Subject subject4 = this.f59933n;
                if (subject4 != null && (gameInfo = subject4.getGameInfo()) != null) {
                    itemId = gameInfo.getItemId();
                }
                String str = itemId;
                Intrinsics.d(str);
                iGameResApi.f1(context, "music_stream_detail", gameInfoType, str, new Function1<View, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$initGameRes$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        FrameLayout frameLayout;
                        FrameLayout frameLayout2;
                        this.this$0.T = view;
                        if (view != null) {
                            this.this$0.D2();
                            return;
                        }
                        rz.f mViewBinding = this.this$0.getMViewBinding();
                        if (mViewBinding != null && (frameLayout2 = mViewBinding.f75816k) != null) {
                            so.c.g(frameLayout2);
                        }
                        rz.f mViewBinding2 = this.this$0.getMViewBinding();
                        if (mViewBinding2 == null || (frameLayout = mViewBinding2.f75816k) == null) {
                            return;
                        }
                        frameLayout.removeAllViews();
                    }
                });
                return;
            }
        }
        Subject subject5 = this.f59933n;
        if (subject5 == null || (genre = subject5.getGenre()) == null) {
            return;
        }
        String lowerCase = genre.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (lowerCase == null || !StringsKt__StringsKt.Q(lowerCase, "game", false, 2, null)) {
            return;
        }
        uo.b.a.j(uo.b.f78622a, "GameResLoader", "stream detail,  game is null", false, 4, null);
    }

    public static final void g2(MusicDetailFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final void i2() {
        ResourcesSeasonList resourcesSeasonListF;
        if (this.f59938s == null || (resourcesSeasonListF = U1().w().f()) == null) {
            return;
        }
        Intrinsics.f(resourcesSeasonListF, "videoDetailViewModel.get…iveData().value ?: return");
        if (resourcesSeasonListF.isNoSource()) {
            sz.a.f76638a.a(j0() + " --> initPlayInfo() --> checkPlayInfo --> 没有资源");
            return;
        }
        if (resourcesSeasonListF.isSeries()) {
            sz.a.f76638a.a(j0() + " --> initPlayInfo() --> checkPlayInfo --> 是剧集，获取记录决定哪集");
            List<VideoDetailMediaSource> listF = U1().q().f();
            if (listF == null) {
                return;
            }
            Intrinsics.f(listF, "videoDetailViewModel.get…iveData().value ?: return");
            U1().z(S1(this.K, listF));
            return;
        }
        if (!resourcesSeasonListF.isMovie()) {
            sz.a.f76638a.a(j0() + " --> initPlayInfo() --> checkPlayInfo --> 是什么呢。。。");
            return;
        }
        sz.a.f76638a.a(j0() + " --> initPlayInfo() --> checkPlayInfo --> 是电影");
        List<VideoDetailMediaSource> listF2 = U1().q().f();
        if (listF2 == null) {
            return;
        }
        Intrinsics.f(listF2, "videoDetailViewModel.get…iveData().value ?: return");
        U1().z((VideoDetailMediaSource) CollectionsKt___CollectionsKt.g0(listF2));
    }

    private final void j2(Subject subject) {
        String restrictLevel = subject.getRestrictLevel();
        if (restrictLevel == null || restrictLevel.length() == 0 || !RoomAppMMKV.f51271a.a().getBoolean("restrict_tips_dialog_again", true)) {
            return;
        }
        kv.a aVar = this.f59931l;
        if (aVar != null) {
            aVar.onHandlePause();
        }
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sa_restrict_tips", false, 2, null);
        String value = configBeanC != null ? configBeanC.getValue() : null;
        if (value == null || value.length() == 0) {
            value = Utils.a().getString(R$string.movie_detail_restrict_tips);
        }
        final RestrictTipsDialog restrictTipsDialogA = RestrictTipsDialog.f53538j.a(value, "music_stream_detail", subject.getSubjectId());
        restrictTipsDialogA.k0(this, "RestrictTipsDialog");
        restrictTipsDialogA.x0(new Function1<Boolean, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$initShowRestrictTips$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                if (z11) {
                    kv.a aVar2 = this.f59931l;
                    if (aVar2 != null) {
                        aVar2.onHandlePlay();
                        return;
                    }
                    return;
                }
                FragmentActivity activity = restrictTipsDialogA.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
    }

    public static /* synthetic */ void l2(MusicDetailFragment musicDetailFragment, String str, boolean z11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        musicDetailFragment.k2(str, z11, str2);
    }

    public static final void m2(MusicDetailFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        Object systemService = Utils.a().getSystemService("keyguard");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        if (((KeyguardManager) systemService).isKeyguardLocked()) {
            return;
        }
        sz.a.f76638a.a(this$0.j0() + " --> onBackgroundStatusChange() --> 2Background~~");
        this$0.C2(false);
    }

    @Deprecated
    private final void n2(boolean z11) {
        String genre;
        Subject subject = this.f59933n;
        if (subject == null || (genre = subject.getGenre()) == null) {
            return;
        }
        String lowerCase = genre.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (lowerCase == null || !StringsKt__StringsKt.Q(lowerCase, "game", false, 2, null)) {
            return;
        }
        if (z11) {
            P1().z();
        } else {
            P1().Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final void o2(LongVodUiType longVodUiType) {
        if (this.T == null || longVodUiType != LongVodUiType.MIDDLE) {
            return;
        }
        D2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p2(lv.a aVar) {
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_PLAY").withString("subject_id", this.f59938s);
        Subject subject = this.f59933n;
        if (subject != null && subject.getType() == 3 && aVar != null) {
            postcardWithString.withParcelable("TV_DATA", new FbTvData(aVar.m(), aVar.k(), aVar.d()));
        }
        postcardWithString.navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(String str) {
        kotlinx.coroutines.j.d(v.a(this), null, null, new MusicDetailFragment$playDownloadMusic$1(this, str, null), 3, null);
    }

    public static final void s2(MusicDetailFragment this$0, VideoDetailStreamList videoDetailStreamList) {
        Intrinsics.g(this$0, "this$0");
        uo.b.f78622a.c("MusicDetailFragment", "playInfoObserver  playInfo==" + videoDetailStreamList, true);
        this$0.Z1();
        if (videoDetailStreamList != null || com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.K1();
        } else {
            this$0.H2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t2(String str) {
        sz.a.f76638a.b(j0() + " --> playNext() --> subjectId = " + str);
        if (TextUtils.isEmpty(str)) {
            zp.b.f82110a.d(com.tn.lib.widget.R$string.error_load_failed);
            return;
        }
        this.f59938s = str;
        this.f59933n = null;
        this.Q = null;
        U1().A();
        MovieDetailViewModel movieDetailViewModelR1 = R1();
        int i11 = this.f59945z;
        String str2 = this.f59938s;
        if (str2 == null) {
            str2 = "";
        }
        movieDetailViewModelR1.C(i11, str2);
        k2(this.f59938s, true, "playNext()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2(DownloadBean downloadBean) {
        this.N = downloadBean;
        J2();
        String str = this.f59938s;
        if (str != null) {
            PlayMimeType playMimeType = PlayMimeType.DEFAULT;
            String subjectName = downloadBean.getSubjectName();
            String str2 = subjectName == null ? "" : subjectName;
            String str3 = this.D;
            String str4 = str3 == null ? "" : str3;
            List<lv.c> listW1 = W1(downloadBean);
            String cover = downloadBean.getCover();
            String str5 = cover == null ? "" : cover;
            String thumbnail = downloadBean.getThumbnail();
            String str6 = thumbnail == null ? "" : thumbnail;
            lv.a aVar = new lv.a(str, playMimeType, 0L, 0, 0, str2, null, str4, "music_stream_detail", listW1, str5, str6, "", 0, Integer.valueOf(downloadBean.getSubjectType()), false, downloadBean.getTitleName(), downloadBean.getOps(), 32832, null);
            aVar.v(this.f59933n);
            sz.a.f76638a.a(j0() + " --> playOfflineMusic() --> 播放本地文件 --> addDataSource = " + aVar + " -->  playerControl = " + this.f59931l);
            kv.a aVar2 = this.f59931l;
            if (aVar2 != null) {
                aVar2.setDataSource(aVar);
            }
        }
    }

    @Deprecated
    private final void v2(VideoDetailStreamList videoDetailStreamList) {
        List<VideoDetailStream> list;
        VideoDetailPlayBean videoDetailPlayBean;
        VideoDetailPlayBean videoDetailPlayBean2;
        Subject subject;
        List<DubsInfo> dubs;
        String averageHueLight;
        String thumbnail;
        String url;
        sz.a aVar = sz.a.f76638a;
        aVar.a(j0() + " --> playStream() --> videoDetailStreamList = " + videoDetailStreamList + " --> mMovieDetailBean = " + this.f59933n);
        List<VideoDetailStream> streams = videoDetailStreamList != null ? videoDetailStreamList.getStreams() : null;
        if (videoDetailStreamList == null || (list = streams) == null || list.isEmpty()) {
            aVar.b(j0() + " --> playStream() --> 空返回 --> videoDetailStreamList = " + videoDetailStreamList + " --> videoDetailStream = " + streams);
            return;
        }
        VideoDetailMediaSource videoDetailMediaSourceF = U1().v().f();
        if (videoDetailMediaSourceF != null && videoDetailMediaSourceF.getEp() == videoDetailStreamList.getEp() && videoDetailMediaSourceF.getSe() == videoDetailStreamList.getSe()) {
            if (this.J > 0) {
                aVar.a(j0() + " --> playStream() --> 播放历史进度 --> AudioTrack -- seekTo = 0");
            } else {
                VideoDetailPlayBean videoDetailPlayBean3 = this.K;
                if (videoDetailPlayBean3 != null && videoDetailPlayBean3 != null && videoDetailStreamList.getSe() == videoDetailPlayBean3.getSe() && (videoDetailPlayBean = this.K) != null && videoDetailStreamList.getEp() == videoDetailPlayBean.getEp() && ((this.B > 0 && (videoDetailPlayBean2 = this.K) != null && videoDetailPlayBean2.getSe() == this.B) || this.B <= 0)) {
                    U1().l();
                }
            }
            PlayMimeType playMimeTypeQ1 = Q1((VideoDetailStream) CollectionsKt___CollectionsKt.e0(streams));
            VideoDetailMediaSource videoDetailMediaSourceF2 = U1().v().f();
            int ep2 = videoDetailMediaSourceF2 != null ? videoDetailMediaSourceF2.getEp() : 0;
            int se2 = videoDetailMediaSourceF2 != null ? videoDetailMediaSourceF2.getSe() : 0;
            String str = this.f59938s;
            if (str == null || (subject = this.f59933n) == null) {
                return;
            }
            String title = subject.getTitle();
            String str2 = title == null ? "" : title;
            String title2 = videoDetailStreamList.getTitle();
            String str3 = this.D;
            String str4 = str3 == null ? "" : str3;
            List<lv.c> listY1 = Y1(streams);
            Cover cover = subject.getCover();
            String str5 = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
            Cover cover2 = subject.getCover();
            String str6 = (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail;
            Cover cover3 = subject.getCover();
            String str7 = (cover3 == null || (averageHueLight = cover3.getAverageHueLight()) == null) ? "" : averageHueLight;
            Integer durationSeconds = subject.getDurationSeconds();
            int iIntValue = durationSeconds != null ? durationSeconds.intValue() : 0;
            Integer subjectType = subject.getSubjectType();
            int iIntValue2 = subjectType != null ? subjectType.intValue() : 1;
            Subject subject2 = this.f59933n;
            String ops = subject2 != null ? subject2.getOps() : null;
            Subject subject3 = this.f59933n;
            lv.a aVar2 = new lv.a(str, playMimeTypeQ1, 0L, ep2, se2, str2, title2, str4, "music_stream_detail", listY1, str5, str6, str7, iIntValue, Integer.valueOf(iIntValue2), false, subject3 != null ? subject3.getTitle() : null, ops, 32768, null);
            aVar2.v(this.f59933n);
            Subject subject4 = this.f59933n;
            if (subject4 != null && (dubs = subject4.getDubs()) != null) {
                aVar2.a().addAll(dubs);
            }
            J2();
            aVar.a(j0() + " --> playStream() --> playerControl?.setDataSource(playBean)");
            kv.a aVar3 = this.f59931l;
            if (aVar3 != null) {
                aVar3.setDataSource(aVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2(Subject subject) {
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
        x2(trailer);
    }

    private final void x2(Trailer trailer) {
        Subject subject;
        String averageHueLight;
        String thumbnail;
        String url;
        J2();
        String str = this.f59938s;
        if (str == null || (subject = this.f59933n) == null) {
            return;
        }
        PlayMimeType playMimeType = PlayMimeType.DEFAULT;
        String title = subject.getTitle();
        String str2 = title == null ? "" : title;
        String str3 = this.D;
        String str4 = str3 == null ? "" : str3;
        List<lv.c> listX1 = X1(trailer);
        Cover cover = trailer.getCover();
        String str5 = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
        Cover cover2 = trailer.getCover();
        String str6 = (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail;
        Cover cover3 = subject.getCover();
        String str7 = (cover3 == null || (averageHueLight = cover3.getAverageHueLight()) == null) ? "" : averageHueLight;
        Integer durationSeconds = subject.getDurationSeconds();
        int iIntValue = durationSeconds != null ? durationSeconds.intValue() : 0;
        Integer subjectType = subject.getSubjectType();
        lv.a aVar = new lv.a(str, playMimeType, 0L, 0, 0, str2, null, str4, "music_stream_detail", listX1, str5, str6, str7, iIntValue, Integer.valueOf(subjectType != null ? subjectType.intValue() : 1), false, subject.getTitle(), subject.getOps(), 32832, null);
        aVar.v(this.f59933n);
        sz.a.f76638a.a(j0() + " --> playTrailer() --> 当前有网络，没有下载资源 --> 播放流媒体数据 --> addDataSource = " + aVar + " -->  playerControl = " + this.f59931l);
        kv.a aVar2 = this.f59931l;
        if (aVar2 != null) {
            aVar2.setDataSource(aVar);
        }
    }

    private final void z2() {
        rz.f mViewBinding;
        AppCompatImageView appCompatImageView;
        final Subject subject = this.f59933n;
        if (subject == null || (mViewBinding = getMViewBinding()) == null || (appCompatImageView = mViewBinding.f75818m) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.ui.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MusicDetailFragment.A2(this.f59982a, subject, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        super.B0();
        l2(this, this.f59938s, false, "loadDefaultData()", 2, null);
        I2();
    }

    public final void C2(boolean z11) {
        Integer subjectType;
        Subject subject = this.f59933n;
        if (subject == null || (subjectType = subject.getSubjectType()) == null) {
            SubjectType.MOVIE.getValue();
        } else {
            subjectType.intValue();
        }
        SubjectType.MUSIC.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        HashMap<String, String> mapG;
        this.D = com.transsion.baselib.report.m.f51277a.f();
        Bundle arguments = getArguments();
        this.f59939t = arguments != null ? arguments.getString("ops") : null;
        Bundle arguments2 = getArguments();
        this.f59938s = arguments2 != null ? arguments2.getString("id") : null;
        Bundle arguments3 = getArguments();
        boolean z11 = false;
        this.f59942w = arguments3 != null ? arguments3.getBoolean("auto_download") : false;
        Bundle arguments4 = getArguments();
        this.f59943x = arguments4 != null ? arguments4.getBoolean("auto_play") : false;
        Bundle arguments5 = getArguments();
        this.f59944y = arguments5 != null ? arguments5.getString("auto_play_resource_id") : null;
        Bundle arguments6 = getArguments();
        this.f59945z = arguments6 != null ? arguments6.getInt("yy_preload_id") : 0;
        MovieDetailViewModel movieDetailViewModelR1 = R1();
        int i11 = this.f59945z;
        String str = this.f59938s;
        if (str == null) {
            str = "";
        }
        movieDetailViewModelR1.C(i11, str);
        Bundle arguments7 = getArguments();
        this.f59941v = arguments7 != null ? arguments7.getString("module_name") : null;
        Bundle arguments8 = getArguments();
        this.B = arguments8 != null ? arguments8.getInt("season") : 0;
        Bundle arguments9 = getArguments();
        this.C = arguments9 != null ? arguments9.getInt("episode") : 0;
        int i12 = this.B;
        if (i12 <= 0) {
            i12 = 1;
        }
        this.A = i12;
        Bundle arguments10 = getArguments();
        this.L = arguments10 != null && arguments10.getBoolean("is_music_liked_fragment");
        Bundle arguments11 = getArguments();
        if (arguments11 != null && arguments11.getBoolean("is_music_float_view_click")) {
            z11 = true;
        }
        this.M = z11;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            String str2 = this.f59938s;
            mapG.put("subject_id", str2 != null ? str2 : "");
        }
        O1().B(this.f59938s, new Function1<Boolean, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$receiveArguments$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z12) {
                FragmentActivity activity;
                if (com.tn.lib.util.networkinfo.f.f49475a.e() || !this.this$0.M || z12 || (activity = this.this$0.getActivity()) == null) {
                    return;
                }
                activity.finish();
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        if (this.f59933n == null) {
            kotlinx.coroutines.j.d(v.a(this), null, null, new MusicDetailFragment$retryLoadData$1(this, null), 3, null);
        }
    }

    public final void I2() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            return;
        }
        O1().B(this.f59938s, new Function1<Boolean, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$showNoNetworkLayout$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                sz.a.f76638a.a(this.this$0.j0() + " --> showNoNetworkLayout() --> 当前无网络且是收藏Music");
                this.this$0.L2(true);
            }
        });
    }

    public final void L2(boolean z11) {
        new com.transsion.play.detail.b(this, R$id.subjectDetailLayout, this.f59933n, "music_stream_detail", this.f59941v, false, false, 96, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public rz.f getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        rz.f fVarC = rz.f.c(inflater);
        Intrinsics.f(fVarC, "inflate(inflater)");
        return fVarC;
    }

    @Override // hv.a
    public void e0(Function0<Boolean> function0) {
        this.O = function0;
    }

    public final void h2() {
        sz.a.f76638a.c(j0() + " --> initMusicLikedOperate() --> isMusicLikedFragment = " + this.L);
        if (this.L) {
            if (this.M) {
                O1().B(this.f59938s, new Function1<Boolean, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$initMusicLikedOperate$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z11) {
                        if (z11) {
                            this.this$0.q2();
                            sz.b.f76639a.b(true);
                            return;
                        }
                        rz.f mViewBinding = this.this$0.getMViewBinding();
                        MusicDetailListOperateView musicDetailListOperateView = mViewBinding != null ? mViewBinding.f75821p : null;
                        if (musicDetailListOperateView == null) {
                            return;
                        }
                        musicDetailListOperateView.setVisibility(8);
                    }
                });
                return;
            } else {
                q2();
                sz.b.f76639a.b(true);
                return;
            }
        }
        rz.f mViewBinding = getMViewBinding();
        MusicDetailListOperateView musicDetailListOperateView = mViewBinding != null ? mViewBinding.f75821p : null;
        if (musicDetailListOperateView == null) {
            return;
        }
        musicDetailListOperateView.setVisibility(8);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        RoomActivityLifecycleCallbacks.f51239a.b(this);
        requireActivity().getOnBackPressedDispatcher().i(this, new d());
        rz.f mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f75817l.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.ui.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MusicDetailFragment.g2(this.f59979a, view);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        R1().r().j(this, new f(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment.initViewModel.1

            /* JADX INFO: renamed from: com.transsion.videodetail.music.ui.MusicDetailFragment$initViewModel$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsion.videodetail.music.ui.MusicDetailFragment$initViewModel$1$1", f = "MusicDetailFragment.kt", l = {315}, m = "invokeSuspend")
            public static final class C06151 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ MusicDetailFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C06151(MusicDetailFragment musicDetailFragment, Continuation<? super C06151> continuation) {
                    super(2, continuation);
                    this.this$0 = musicDetailFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C06151(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((C06151) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objE = kotlin.coroutines.intrinsics.a.e();
                    int i11 = this.label;
                    if (i11 == 0) {
                        ResultKt.b(obj);
                        this.label = 1;
                        if (r0.a(1500L, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    FragmentActivity activity = this.this$0.getActivity();
                    if (activity != null) {
                        activity.onBackPressed();
                    }
                    return Unit.f68710a;
                }
            }

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
                HashMap<String, String> mapG;
                HashMap<String, String> mapG2;
                Subject second = pair.getSecond();
                rz.f mViewBinding = MusicDetailFragment.this.getMViewBinding();
                CoordinatorLayout coordinatorLayout = mViewBinding != null ? mViewBinding.f75811f : null;
                if (coordinatorLayout != null) {
                    coordinatorLayout.setVisibility(0);
                }
                if (second == null) {
                    if (Intrinsics.b(pair.getFirst(), "404")) {
                        com.tn.lib.widget.toast.core.h.f50034a.k(R$string.movie_lost_content);
                        kotlinx.coroutines.j.d(v.a(MusicDetailFragment.this), null, null, new C06151(MusicDetailFragment.this, null), 3, null);
                    }
                    if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        PageStatusFragment.H0(MusicDetailFragment.this, false, 1, null);
                        return;
                    } else {
                        PageStatusFragment.N0(MusicDetailFragment.this, false, 1, null);
                        return;
                    }
                }
                sz.a.f76638a.a(MusicDetailFragment.this.j0() + " --> initDetailViewModel() --> 获取到数据 --> subjectId = " + second.getSubjectId() + " --> 刷新UI");
                MovieDetailViewModel movieDetailViewModelR1 = MusicDetailFragment.this.R1();
                String subjectId = second.getSubjectId();
                Integer subjectType = second.getSubjectType();
                Context context = MusicDetailFragment.this.getContext();
                MovieDetailViewModel.i(movieDetailViewModelR1, subjectId, subjectType, 0, context != null && com.transsion.baseui.util.b.a(context), 4, null);
                MusicDetailFragment.this.F0();
                MusicDetailFragment.this.f59940u = true;
                MusicDetailFragment.this.R2(second);
                MusicDetailFragment.this.G2(second);
                com.transsion.baselib.report.h logViewConfig = MusicDetailFragment.this.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.j(true);
                }
                com.transsion.baselib.report.h logViewConfig2 = MusicDetailFragment.this.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.m(MusicDetailFragment.this.f59939t);
                }
                com.transsion.baselib.report.h logViewConfig3 = MusicDetailFragment.this.getLogViewConfig();
                if (logViewConfig3 != null && (mapG2 = logViewConfig3.g()) != null) {
                    String subjectId2 = second.getSubjectId();
                    if (subjectId2 == null) {
                        subjectId2 = "";
                    }
                    mapG2.put("subject_id", subjectId2);
                }
                com.transsion.baselib.report.h logViewConfig4 = MusicDetailFragment.this.getLogViewConfig();
                if (logViewConfig4 == null || (mapG = logViewConfig4.g()) == null) {
                    return;
                }
                mapG.put("has_resource", String.valueOf(second.getHasResource()));
            }
        }));
        R1().u().j(this, new f(new Function1<Integer, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$initViewModel$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer season) {
                MusicDetailFragment musicDetailFragment = this.this$0;
                Intrinsics.f(season, "season");
                musicDetailFragment.A = season.intValue();
            }
        }));
        U1().w().j(this, new f(new Function1<ResourcesSeasonList, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment.initViewModel.3
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
                MusicDetailFragment.this.Q2();
            }
        }));
        U1().q().j(this, new f(new Function1<List<? extends VideoDetailMediaSource>, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment.initViewModel.4
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
                MusicDetailFragment.this.i2();
            }
        }));
    }

    public final void k2(final String str, boolean z11, String str2) {
        sz.a.f76638a.a(j0() + " --> loadData() --> isAudioTracksChange = " + z11 + " --> subjectId = " + str + " --> from = " + str2 + " --> 开始加载数据");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            O1().A(str, new Function1<String, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$loadData$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                    invoke2(str3);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String path) {
                    Intrinsics.g(path, "path");
                    if (!TextUtils.isEmpty(path)) {
                        rz.f mViewBinding = this.this$0.getMViewBinding();
                        CoordinatorLayout coordinatorLayout = mViewBinding != null ? mViewBinding.f75811f : null;
                        if (coordinatorLayout != null) {
                            coordinatorLayout.setVisibility(8);
                        }
                        this.this$0.r2(str);
                        return;
                    }
                    sz.a.f76638a.b(this.this$0.j0() + " --> loadData() --> 无网络 无下载 --> 加载失败，这种情况需要前置拦截");
                }
            });
            return;
        }
        if (!z11) {
            K0();
        }
        if (str != null) {
            R1().q(str);
            U1().p(str);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("music_stream_detail", false, 2, null);
    }

    @Override // com.transsion.baselib.report.RoomActivityLifecycleCallbacks.a
    public void onBackgroundStatusChange(boolean z11) {
        rz.f mViewBinding;
        FrameLayout frameLayout;
        if (!z11 || (mViewBinding = getMViewBinding()) == null || (frameLayout = mViewBinding.f75815j) == null) {
            return;
        }
        frameLayout.postDelayed(new Runnable() { // from class: com.transsion.videodetail.music.ui.i
            @Override // java.lang.Runnable
            public final void run() {
                MusicDetailFragment.m2(this.f59981a);
            }
        }, 500L);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        sz.a.f76638a.a(j0() + " --> onCreate() --> 音乐详情页");
        com.tn.lib.util.networkinfo.f.f49475a.l(this.P);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        kv.a aVar;
        super.onDestroy();
        MusicFloatManager.a aVar2 = MusicFloatManager.f51403i;
        aVar2.b().u().remove(this.f59930k);
        if (!this.E && aVar2.b().u().isEmpty() && (aVar = this.f59931l) != null) {
            aVar.release();
        }
        kv.a aVar3 = this.f59931l;
        if (aVar3 != null) {
            aVar3.onPageDestroy();
        }
        com.tn.lib.util.networkinfo.f.f49475a.m(this.P);
        RoomActivityLifecycleCallbacks.f51239a.k(this);
        if (this.L) {
            sz.b.f76639a.b(false);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        kv.a aVar;
        super.onPause();
        if (this.E || (aVar = this.f59931l) == null) {
            return;
        }
        aVar.onViewPause();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        kv.a aVar = this.f59931l;
        if (aVar != null) {
            aVar.onViewResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        y2();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R$layout.default_movie_detail_skeleton_drawing_layout, (ViewGroup) o0(), false);
        ((AppCompatImageView) viewInflate.findViewById(R$id.ivBack)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MusicDetailFragment.N1(this.f59976a, view);
            }
        });
        return viewInflate;
    }

    public final void q2() {
        MusicDetailListOperateView musicDetailListOperateView;
        rz.f mViewBinding = getMViewBinding();
        if (mViewBinding == null || (musicDetailListOperateView = mViewBinding.f75821p) == null) {
            return;
        }
        musicDetailListOperateView.setVisibility(0);
        String str = this.f59938s;
        rz.f mViewBinding2 = getMViewBinding();
        FrameLayout frameLayout = mViewBinding2 != null ? mViewBinding2.f75814i : null;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        musicDetailListOperateView.setContainer(str, frameLayout, childFragmentManager, R$id.flMusicContainer, new Function2<String, String, Unit>() { // from class: com.transsion.videodetail.music.ui.MusicDetailFragment$openOperateView$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str2, String str3) {
                invoke2(str2, str3);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str2, String str3) {
                sz.a.f76638a.a(this.this$0.j0() + " --> setContainer() --> onItemCLick{} --> subjectId = " + str2 + " --> path = " + str3 + " --> 重置数据，重新加载");
                if (TextUtils.isEmpty(str2)) {
                    zp.b.f82110a.d(com.tn.lib.widget.R$string.error_load_failed);
                } else if (com.tn.lib.util.networkinfo.f.f49475a.e() || !TextUtils.isEmpty(str3)) {
                    this.this$0.t2(str2);
                } else {
                    zp.b.f82110a.d(com.transsion.videodetail.R$string.music_no_network);
                }
            }
        });
        musicDetailListOperateView.setState(MusicStateEnum.OPEN);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        View view;
        rz.f mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (view = mViewBinding.f75827v) == null) ? null : view.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (bVar != null) {
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = com.blankj.utilcode.util.d.c();
        }
        rz.f mViewBinding2 = getMViewBinding();
        View view2 = mViewBinding2 != null ? mViewBinding2.f75827v : null;
        if (view2 != null) {
            view2.setLayoutParams(bVar);
        }
        a2();
        d2();
        h2();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    public final void y2() {
        com.transsion.player.orplayer.f player;
        if (this.N == null) {
            return;
        }
        kv.a aVar = this.f59931l;
        long currentPosition = (aVar == null || (player = aVar.getPlayer()) == null) ? 0L : player.getCurrentPosition();
        if (currentPosition > 0) {
            kotlinx.coroutines.j.d(v.a(this), null, null, new MusicDetailFragment$saveDownloadHistory$1(this, currentPosition, null), 3, null);
        }
    }
}
