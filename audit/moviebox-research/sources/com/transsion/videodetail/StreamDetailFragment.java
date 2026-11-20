package com.transsion.videodetail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.alibaba.android.arouter.facade.Postcard;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.activity.BaseMusicFloatActivity;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.image.blurhash.BlurHashHelper;
import com.transsion.bean.GameInfoType;
import com.transsion.commercializationapi.IGameResApi;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.fragment.ResourceDetectorEmptyFragment;
import com.transsion.moviedetail.fragment.RestrictTipsDialog;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.DubsInfo;
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
import com.transsion.player.ui.ORPlayerView;
import com.transsion.publish.api.IPublishApi;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import com.transsion.videodetail.bean.VideoDetailStream;
import com.transsion.videodetail.bean.VideoDetailStreamList;
import com.transsion.videodetail.util.StreamFloatManager;
import com.transsion.videofloat.VideoFloatManager;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsion.wrapperad.view.NativeSlideshowView;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
public final class StreamDetailFragment extends PageStatusFragment<rz.i> implements hv.a {
    public static final a T = new a(null);
    public int A;
    public int B;
    public String C;
    public boolean D;
    public View E;
    public boolean F;
    public long I;
    public Function0<Boolean> K;
    public boolean M;
    public VideoDetailStreamList O;
    public VideoDetailPlayBean Q;
    public rz.j R;
    public boolean S;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public kv.a f59797k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PlayDetailBottomRecHelper f59798l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Subject f59799m;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f59804r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f59805s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f59806t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f59807u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f59808v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f59809w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f59810x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f59811y;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f59800n = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f59801o = FragmentViewModelLazyKt.a(this, Reflection.b(VideoDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$3
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$4
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

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f59802p = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsnet.downloader.viewmodel.e.class), new Function0<x0>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$5
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.StreamDetailFragment$special$$inlined$activityViewModels$default$6
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
    public final Lazy f59803q = LazyKt__LazyJVMKt.b(new Function0<IPublishApi>() { // from class: com.transsion.videodetail.StreamDetailFragment$publishedApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IPublishApi invoke() {
            return (IPublishApi) com.alibaba.android.arouter.launcher.a.d().h(IPublishApi.class);
        }
    });

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f59812z = 1;
    public IFissionProvider G = (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class);
    public final Lazy H = LazyKt__LazyJVMKt.b(new Function0<IMemberApi>() { // from class: com.transsion.videodetail.StreamDetailFragment$memberProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IMemberApi invoke() {
            return (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        }
    });
    public LongVodUiType J = LongVodUiType.MIDDLE;
    public boolean L = true;
    public final d N = new d();
    public final d0<VideoDetailStreamList> P = new d0() { // from class: com.transsion.videodetail.e
        @Override // androidx.lifecycle.d0
        public final void onChanged(Object obj) {
            StreamDetailFragment.w2(this.f59906a, (VideoDetailStreamList) obj);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StreamDetailFragment a() {
            return new StreamDetailFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BubbleTextView bubbleTextView;
            ViewTreeObserver viewTreeObserver;
            rz.i mViewBinding = StreamDetailFragment.this.getMViewBinding();
            if (mViewBinding != null && (bubbleTextView = mViewBinding.f75862b) != null && (viewTreeObserver = bubbleTextView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            rz.i mViewBinding2 = StreamDetailFragment.this.getMViewBinding();
            BubbleTextView bubbleTextView2 = mViewBinding2 != null ? mViewBinding2.f75862b : null;
            if (bubbleTextView2 == null || bubbleTextView2.getMeasuredWidth() == 0) {
                return;
            }
            float measuredWidth = (bubbleTextView2.getMeasuredWidth() / 2) - (f0.a(16.0f) / 2);
            bubbleTextView2.setArrowPosition(measuredWidth);
            uo.b.a.f(uo.b.f78622a, "videoDetail", "activity tip width: " + bubbleTextView2.getMeasuredWidth() + ", arrowPosition: " + measuredWidth, false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends androidx.activity.p {
        public c() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            Function0 function0 = StreamDetailFragment.this.K;
            if (function0 == null || !((Boolean) function0.invoke()).booleanValue()) {
                if (StreamDetailFragment.this.f59797k != null) {
                    kv.a aVar = StreamDetailFragment.this.f59797k;
                    if (aVar != null) {
                        aVar.onBackPressed();
                        return;
                    }
                    return;
                }
                FragmentActivity activity = StreamDetailFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements com.tn.lib.util.networkinfo.g {
        public d() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            StreamDetailFragment.this.P1();
            VideoDetailMediaSource videoDetailMediaSourceF = StreamDetailFragment.this.a2().v().f();
            if (videoDetailMediaSourceF != null) {
                StreamDetailFragment streamDetailFragment = StreamDetailFragment.this;
                VideoDetailStreamList videoDetailStreamListF = streamDetailFragment.a2().u().f();
                if (videoDetailStreamListF != null && videoDetailMediaSourceF.getSe() == videoDetailStreamListF.getSe() && videoDetailMediaSourceF.getEp() == videoDetailStreamListF.getEp()) {
                    return;
                }
                streamDetailFragment.Q1(videoDetailMediaSourceF);
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59816a;

        public e(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59816a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59816a;
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
            this.f59816a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements yz.a {
        @Override // yz.a
        public void a(vz.a aVar) {
            StreamFloatManager streamFloatManager = StreamFloatManager.f60006b;
            streamFloatManager.n();
            streamFloatManager.q(aVar);
        }

        @Override // yz.a
        public boolean b(vz.a aVar) {
            return StreamFloatManager.f60006b.p(aVar);
        }

        @Override // yz.a
        public void c(vz.a aVar) {
            yz.a.C0919a.a(this, aVar);
            StreamFloatManager.f60006b.o(aVar);
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
            StreamDetailFragment.this.L1();
        }

        @Override // kv.a.b
        public boolean b() {
            if (StreamDetailFragment.this.S && com.tn.lib.util.networkinfo.f.f49475a.e()) {
                StreamDetailFragment streamDetailFragment = StreamDetailFragment.this;
                streamDetailFragment.Q1(streamDetailFragment.a2().v().f());
            }
            return StreamDetailFragment.this.S;
        }

        @Override // kv.a.b
        public boolean c(FloatActionType actionType) {
            Intrinsics.g(actionType, "actionType");
            return StreamDetailFragment.this.C2(actionType);
        }

        @Override // kv.a.b
        public void d(lv.a aVar) {
            StreamDetailFragment.this.v2(aVar);
        }

        @Override // kv.a.b
        public void e(LongVodUiType uiType) {
            Intrinsics.g(uiType, "uiType");
            StreamDetailFragment.this.J = uiType;
            StreamDetailFragment.this.u2(uiType);
            PlayDetailBottomRecHelper playDetailBottomRecHelper = StreamDetailFragment.this.f59798l;
            if (playDetailBottomRecHelper != null) {
                playDetailBottomRecHelper.u(uiType != LongVodUiType.MIDDLE);
            }
        }

        @Override // kv.a.b
        public View f() {
            return StreamDetailFragment.this.E;
        }

        @Override // kv.a.b
        public void g(boolean z11) {
            rz.i mViewBinding = StreamDetailFragment.this.getMViewBinding();
            AppCompatImageView appCompatImageView = mViewBinding != null ? mViewBinding.f75870k : null;
            if (appCompatImageView == null) {
                return;
            }
            appCompatImageView.setVisibility(z11 ? 0 : 8);
        }

        @Override // kv.a.b
        public void onCompletion() {
            StreamDetailFragment.this.L1();
        }
    }

    public static final void A2(StreamDetailFragment this$0, Subject this_apply, View view) {
        String url;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        IPublishApi iPublishApiZ1 = this$0.Z1();
        if (iPublishApiZ1 != null) {
            Context context = view.getContext();
            Intrinsics.f(context, "it.context");
            String str = this$0.f59804r;
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
            iPublishApiZ1.k0(context, str, url, title, description == null ? "" : description, 3);
        }
        com.transsion.baselib.helper.a.f51183a.g("subjectdetail", "post", (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
    }

    private final void B2(Subject subject) {
        Cover stills;
        FrameLayout frameLayout;
        uo.b.a.j(uo.b.f78622a, "videoDetail", "展示作品大图或者预告片", false, 4, null);
        if (subject != null) {
            Trailer trailer = subject.getTrailer();
            if ((trailer == null || (stills = trailer.getCover()) == null) && (stills = subject.getStills()) == null) {
                stills = subject.getCover();
            }
            if (stills != null) {
                int iF = com.transsion.core.utils.e.f();
                rz.i mViewBinding = getMViewBinding();
                if (mViewBinding == null || (frameLayout = mViewBinding.f75868i) == null) {
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
                    BlurHashHelper.b(BlurHashHelper.f51391a, thumbnail == null ? "" : thumbnail, 0, 0, new Function1<BitmapDrawable, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment$showCover$1$1$1
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
                            rz.i mViewBinding2 = this.this$0.getMViewBinding();
                            FrameLayout frameLayout2 = mViewBinding2 != null ? mViewBinding2.f75868i : null;
                            if (frameLayout2 == null) {
                                return;
                            }
                            frameLayout2.setBackground(drawable);
                        }
                    }, 6, null);
                    Context context = imageView.getContext();
                    Intrinsics.f(context, "imageView.context");
                    companion.o(context, imageView, strE, (32704 & 8) != 0 ? com.tn.lib.widget.R$color.skeleton : com.tn.lib.widget.R$color.transparent, (32704 & 16) != 0 ? companion.d() : 0, (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean C2(final FloatActionType floatActionType) {
        final FragmentActivity activity;
        ConstraintLayout root;
        Integer subjectType;
        Subject subject = this.f59799m;
        if (((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) != SubjectType.MUSIC.getValue() && (activity = getActivity()) != null && !activity.isDestroyed() && !activity.isFinishing()) {
            FloatActionType floatActionType2 = FloatActionType.ICON;
            if (floatActionType != floatActionType2 && !RoomAppMMKV.f51271a.a().getBoolean("k_pip_enable", true)) {
                uo.b.f78622a.c("VideoFloat", "设置页pip开关被关闭了", true);
                return false;
            }
            final vz.a aVarS1 = S1();
            if (aVarS1 != null) {
                if (floatActionType != floatActionType2 && !aVarS1.e().isPlaying()) {
                    uo.b.f78622a.c("VideoFloat-pip", "stream 视频暂停，无需触发画中画", true);
                    return false;
                }
                if (VideoPipManager.f60024a.a().b()) {
                    kv.a aVar = this.f59797k;
                    if (aVar != null) {
                        aVar.hideBottomController(true);
                    }
                    uo.b.f78622a.c("VideoFloat-pip", "stream 当前可用画中画，使用画中画播放", true);
                    rz.i mViewBinding = getMViewBinding();
                    if (mViewBinding != null && (root = mViewBinding.getRoot()) != null) {
                        root.postDelayed(new Runnable() { // from class: com.transsion.videodetail.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                StreamDetailFragment.D2(activity, aVarS1, floatActionType, this);
                            }
                        }, 1000L);
                    }
                    return true;
                }
                VideoFloatManager.f60019a.b().e(activity, aVarS1, floatActionType == floatActionType2, this.J == LongVodUiType.LAND, new Function1<Boolean, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment$showFloat2Window$1$2
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
                        kv.a aVar2;
                        if (z11 && (aVar2 = this.this$0.f59797k) != null) {
                            aVar2.exitFullScreen();
                        }
                        kv.a aVar3 = this.this$0.f59797k;
                        if (aVar3 != null) {
                            aVar3.setFloatIsShow(z11);
                        }
                        if (z11) {
                            activity.finish();
                        }
                    }
                }, new f());
            }
        }
        return false;
    }

    public static final void D2(FragmentActivity fragmentActivity, vz.a bean, FloatActionType actionType, StreamDetailFragment this$0) {
        Intrinsics.g(bean, "$bean");
        Intrinsics.g(actionType, "$actionType");
        Intrinsics.g(this$0, "this$0");
        VideoPipManager.f60024a.a().j(fragmentActivity, bean, actionType, this$0.J == LongVodUiType.LAND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E2() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        View view = this.E;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.E);
        }
        KeyEvent.Callback callback = this.E;
        ss.a aVar = callback instanceof ss.a ? (ss.a) callback : null;
        if (aVar != null) {
            aVar.setPageStyle("detail");
        }
        rz.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout3 = mViewBinding.f75869j) != null) {
            so.c.k(frameLayout3);
        }
        rz.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (frameLayout2 = mViewBinding2.f75869j) != null) {
            frameLayout2.removeAllViews();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        rz.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (frameLayout = mViewBinding3.f75869j) == null) {
            return;
        }
        frameLayout.addView(this.E, layoutParams);
    }

    private final void F2() {
        LinearLayout root;
        rz.i mViewBinding;
        FrameLayout frameLayout;
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (this.R == null) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
            rz.i mViewBinding2 = getMViewBinding();
            this.R = rz.j.c(layoutInflaterFrom, mViewBinding2 != null ? mViewBinding2.f75868i : null, false);
        }
        rz.j jVar = this.R;
        if (jVar == null || (root = jVar.getRoot()) == null) {
            return;
        }
        if (root.getParent() == null && (mViewBinding = getMViewBinding()) != null && (frameLayout = mViewBinding.f75868i) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.bottomMargin = com.blankj.utilcode.util.i.e(20.0f);
            Unit unit = Unit.f68710a;
            frameLayout.addView(root, layoutParams);
        }
        so.c.k(root);
    }

    private final void H2() {
        Context context;
        List<DubsInfo> listL;
        Integer subjectType;
        if (this.f59797k == null && (context = getContext()) != null) {
            Subject subject = this.f59799m;
            LongVodPageType longVodPageType = ((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) == SubjectType.MUSIC.getValue() ? LongVodPageType.MUSIC : LongVodPageType.STREAM;
            rz.i mViewBinding = getMViewBinding();
            if (mViewBinding != null) {
                LongVodPlayerView longVodPlayerView = new LongVodPlayerView(context);
                String strName = longVodPageType.name();
                Subject subject2 = this.f59799m;
                String str = strName + (subject2 != null ? subject2.getSubjectId() : null);
                FrameLayout frameLayout = mViewBinding.f75867h;
                LinearLayoutCompat linearLayoutCompat = mViewBinding.f75872m.f71219g;
                Subject subject3 = this.f59799m;
                if (subject3 == null || (listL = subject3.getDubs()) == null) {
                    listL = kotlin.collections.g.l();
                }
                longVodPlayerView.init("stream_detail", longVodPageType, str, frameLayout, linearLayoutCompat, listL);
                Subject subject4 = this.f59799m;
                longVodPlayerView.initAdHelper(subject4 != null ? subject4.getGenre() : null);
                longVodPlayerView.setFeedBackVisible(true);
                longVodPlayerView.setAudioSelectCallback(new Function1<DubsInfo, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment$showPlayer$1$playerView$1$1
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
                        Integer numValueOf;
                        List<DubsInfo> dubs;
                        Intrinsics.g(info, "info");
                        uo.b.a.g(uo.b.f78622a, "AudioSelectCallback " + info, false, 2, null);
                        Subject subject5 = this.this$0.f59799m;
                        if (subject5 == null || (dubs = subject5.getDubs()) == null) {
                            numValueOf = null;
                        } else {
                            Iterator<DubsInfo> it = dubs.iterator();
                            int i11 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i11 = -1;
                                    break;
                                } else if (Intrinsics.b(it.next().getLanCode(), info.getLanCode())) {
                                    break;
                                } else {
                                    i11++;
                                }
                            }
                            numValueOf = Integer.valueOf(i11);
                        }
                        if ((numValueOf != null && numValueOf.intValue() == -1) || info.getSubjectId() == null) {
                            uo.b.a.g(uo.b.f78622a, "AudioSelectCallback info can't find in dubs", false, 2, null);
                        } else {
                            this.this$0.W1().z().q(info);
                        }
                    }
                });
                mViewBinding.f75868i.addView(longVodPlayerView);
                this.f59797k = longVodPlayerView;
            }
            Subject subject5 = this.f59799m;
            if (subject5 != null) {
                m2(subject5);
            }
            kv.a aVar = this.f59797k;
            if (aVar != null) {
                aVar.setCallback(new g());
            }
        }
    }

    private final boolean I1() {
        if (this.D) {
            return false;
        }
        return this.G.G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I2() {
        new com.transsion.play.detail.b(this, R$id.subjectDetailLayout, this.f59799m, "stream_detail", this.f59807u, false, false, 96, null);
    }

    private final void J1() {
        BubbleTextView bubbleTextView;
        ViewTreeObserver viewTreeObserver;
        rz.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f75862b) == null || (viewTreeObserver = bubbleTextView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    private final void J2() {
        BubbleTextView bubbleTextView;
        rz.i mViewBinding;
        DownloadView downloadView;
        rz.i mViewBinding2;
        DownloadView downloadView2;
        BubbleTextView bubbleTextView2;
        if (!I1() || (mViewBinding = getMViewBinding()) == null || (downloadView = mViewBinding.f75864d) == null || downloadView.getVisibility() != 0 || (mViewBinding2 = getMViewBinding()) == null || (downloadView2 = mViewBinding2.f75864d) == null || downloadView2.getShowType() != 0) {
            rz.i mViewBinding3 = getMViewBinding();
            if (mViewBinding3 == null || (bubbleTextView = mViewBinding3.f75862b) == null) {
                return;
            }
            so.c.g(bubbleTextView);
            return;
        }
        rz.i mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (bubbleTextView2 = mViewBinding4.f75862b) != null) {
            so.c.k(bubbleTextView2);
        }
        J1();
    }

    private final void K2(int i11) {
        HashMap<String, String> mapG;
        ResourceDetectors resourceDetector;
        rz.i mViewBinding = getMViewBinding();
        DownloadView downloadView = mViewBinding != null ? mViewBinding.f75864d : null;
        if (downloadView != null) {
            downloadView.setVisibility(i11);
        }
        Subject subject = this.f59799m;
        if (subject != null && (resourceDetector = subject.getResourceDetector()) != null) {
            resourceDetector.getResourceId();
            resourceDetector.isMultiResolution();
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            mapG.put(CampaignEx.KEY_SHOW_TYPE, "download_subject");
        }
        J2();
    }

    public static /* synthetic */ void L2(StreamDetailFragment streamDetailFragment, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        streamDetailFragment.K2(i11);
    }

    private final void M1() {
        ResourceDetectors resourceDetector;
        if (getContext() == null) {
            return;
        }
        Subject subject = this.f59799m;
        String str = "";
        if (subject != null && (resourceDetector = subject.getResourceDetector()) != null) {
            String resourceLink = resourceDetector.getResourceLink();
            str = resourceLink != null ? resourceLink : "";
            resourceDetector.getResourceId();
            resourceDetector.isMultiResolution();
        }
        String str2 = str;
        Subject subject2 = this.f59799m;
        if (subject2 != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context context = getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                Subject subject3 = this.f59799m;
                downloadManagerApiA.a2(fragmentActivity, "subjectdetail", (384 & 4) != 0 ? "" : "", subject3 != null ? subject3.getOps() : null, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : this.f59799m, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        VideoDetailMediaSource videoDetailMediaSourceF = a2().v().f();
        int ep2 = (videoDetailMediaSourceF == null || videoDetailMediaSourceF.getSe() != this.f59812z) ? 0 : videoDetailMediaSourceF.getEp();
        DownloadManagerApi downloadManagerApiA2 = DownloadManagerApi.f60274j.a();
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        DownloadManagerApi.S1(downloadManagerApiA2, (FragmentActivity) context2, this.f59799m, "subjectdetail", "", "", str2, String.valueOf(ep2), this.f59807u, null, true, this.f59812z, false, 256, null);
    }

    private final void N1() {
        BubbleTextView bubbleTextView;
        this.D = true;
        rz.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f75862b) == null) {
            return;
        }
        so.c.g(bubbleTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N2(Subject subject) {
        Subject subject2;
        this.f59799m = subject;
        p2(subject != null ? subject.getGenre() : null);
        if (!this.F) {
            j2();
            t2(true);
        }
        Subject subject3 = this.f59799m;
        String ops = subject3 != null ? subject3.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject2 = this.f59799m) != null) {
            subject2.setOps(this.f59805s);
        }
        ResourcesSeasonList resourcesSeasonListF = a2().w().f();
        if (resourcesSeasonListF != null && resourcesSeasonListF.isNoSource()) {
            B2(this.f59799m);
        }
        g2();
        z2();
    }

    private final void O1() {
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

    private final vz.a S1() {
        List<VideoDetailMediaSource> listF;
        String subjectId;
        String averageHueLight;
        String thumbnail;
        String url;
        VideoDetailStreamList videoDetailStreamListF = a2().u().f();
        if (videoDetailStreamListF == null || (listF = a2().q().f()) == null) {
            return null;
        }
        kv.a aVar = this.f59797k;
        com.transsion.player.orplayer.f player = aVar != null ? aVar.getPlayer() : null;
        kv.a aVar2 = this.f59797k;
        ORPlayerView playerView = aVar2 != null ? aVar2.getPlayerView() : null;
        kv.a aVar3 = this.f59797k;
        SimpleSubtitleView subtitleView = aVar3 != null ? aVar3.getSubtitleView() : null;
        kv.a aVar4 = this.f59797k;
        ViewGroup subtitleViewGroup = aVar4 != null ? aVar4.getSubtitleViewGroup() : null;
        if (playerView == null || player == null || this.f59799m == null || subtitleView == null) {
            return null;
        }
        PlayMimeType playMimeTypeV1 = V1((VideoDetailStream) CollectionsKt___CollectionsKt.g0(videoDetailStreamListF.getStreams()));
        Subject subject = this.f59799m;
        Intrinsics.d(subject);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listF.iterator();
        String strA = "";
        while (true) {
            int iIntValue = 1;
            if (!it.hasNext()) {
                break;
            }
            VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) it.next();
            String subjectId2 = subject.getSubjectId();
            if (subjectId2 == null) {
                subjectId2 = "";
            }
            int ep2 = videoDetailMediaSource.getEp();
            int se2 = videoDetailMediaSource.getSe();
            String title = subject.getTitle();
            String str = title == null ? "" : title;
            String str2 = this.C;
            String str3 = str2 == null ? "" : str2;
            List<lv.c> listC2 = c2(videoDetailMediaSource.getStreams());
            Cover cover = subject.getCover();
            String str4 = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
            Cover cover2 = subject.getCover();
            String str5 = (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail;
            Cover cover3 = subject.getCover();
            String str6 = (cover3 == null || (averageHueLight = cover3.getAverageHueLight()) == null) ? "" : averageHueLight;
            Integer durationSeconds = subject.getDurationSeconds();
            int iIntValue2 = durationSeconds != null ? durationSeconds.intValue() : 0;
            Integer subjectType = subject.getSubjectType();
            if (subjectType != null) {
                iIntValue = subjectType.intValue();
            }
            ArrayList arrayList2 = arrayList;
            lv.a aVar5 = new lv.a(subjectId2, playMimeTypeV1, 0L, ep2, se2, str, null, str3, "stream_detail", listC2, str4, str5, str6, iIntValue2, Integer.valueOf(iIntValue), false, subject.getTitle(), subject.getOps(), 32832, null);
            strA = nv.a.f72164a.a(aVar5);
            aVar5.v(this.f59799m);
            arrayList2.add(aVar5);
            arrayList = arrayList2;
        }
        ArrayList arrayList3 = arrayList;
        uo.b.a aVar6 = uo.b.f78622a;
        Subject subject2 = this.f59799m;
        String title2 = subject2 != null ? subject2.getTitle() : null;
        aVar6.c("VideoFloat", "stream-----showFloat, title:" + title2 + ",se:" + videoDetailStreamListF.getSe() + ",ep:" + videoDetailStreamListF.getEp(), true);
        StreamFloatManager.f60006b.s(arrayList3);
        kv.a aVar7 = this.f59797k;
        lv.c playingStream = aVar7 != null ? aVar7.getPlayingStream() : null;
        FloatPlayType floatPlayType = FloatPlayType.STREAM;
        Subject subject3 = this.f59799m;
        String str7 = (subject3 == null || (subjectId = subject3.getSubjectId()) == null) ? "" : subjectId;
        int se3 = videoDetailStreamListF.getSe();
        int ep3 = videoDetailStreamListF.getEp();
        String strC = playingStream != null ? playingStream.c() : null;
        String str8 = strA;
        vz.a aVar8 = new vz.a(playerView, player, subtitleViewGroup, floatPlayType, str7, se3, ep3, strC, "stream_detail");
        aVar8.F(playMimeTypeV1);
        Subject subject4 = this.f59799m;
        aVar8.G(subject4 != null ? subject4.getSubjectType() : null);
        aVar8.z(str8);
        Subject subject5 = this.f59799m;
        aVar8.x(subject5 != null ? subject5.getOps() : null);
        aVar8.y(this.C);
        return aVar8;
    }

    public static final void T1(StreamDetailFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    private final IMemberApi U1() {
        return (IMemberApi) this.H.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MovieDetailViewModel W1() {
        return (MovieDetailViewModel) this.f59800n.getValue();
    }

    private final IPublishApi Z1() {
        return (IPublishApi) this.f59803q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailViewModel a2() {
        return (VideoDetailViewModel) this.f59801o.getValue();
    }

    private final void e2() {
        BubbleTextView bubbleTextView;
        BubbleTextView bubbleTextView2;
        BubbleTextView bubbleTextView3;
        rz.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (bubbleTextView3 = mViewBinding.f75862b) != null) {
            bubbleTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StreamDetailFragment.f2(this.f59908a, view);
                }
            });
        }
        rz.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (bubbleTextView2 = mViewBinding2.f75862b) != null) {
            so.c.k(bubbleTextView2);
        }
        J1();
        rz.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (bubbleTextView = mViewBinding3.f75862b) == null) {
            return;
        }
        so.c.g(bubbleTextView);
    }

    public static final void f2(StreamDetailFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "videoDetail", "Click activity tip", false, 4, null);
        this$0.D = true;
        Intrinsics.f(it, "it");
        so.c.g(it);
    }

    private final void g2() {
        Subject subject = this.f59799m;
        rz.i mViewBinding = getMViewBinding();
        MagicIndicator magicIndicator = mViewBinding != null ? mViewBinding.f75873n : null;
        rz.i mViewBinding2 = getMViewBinding();
        this.f59798l = new PlayDetailBottomRecHelper(this, subject, magicIndicator, mViewBinding2 != null ? mViewBinding2.f75875p : null, "stream_detail", false, false, new Function1<Integer, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment$initBottomRec$1
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
                if (this.this$0.L) {
                    rz.i mViewBinding3 = this.this$0.getMViewBinding();
                    DownloadView downloadView2 = mViewBinding3 != null ? mViewBinding3.f75864d : null;
                    if (downloadView2 != null) {
                        downloadView2.setVisibility(i11 != 1 ? 0 : 8);
                    }
                } else {
                    rz.i mViewBinding4 = this.this$0.getMViewBinding();
                    if (mViewBinding4 != null && (downloadView = mViewBinding4.f75864d) != null) {
                        so.c.g(downloadView);
                    }
                }
                rz.i mViewBinding5 = this.this$0.getMViewBinding();
                AppCompatImageView appCompatImageView = mViewBinding5 != null ? mViewBinding5.f75871l : null;
                if (appCompatImageView == null) {
                    return;
                }
                appCompatImageView.setVisibility(i11 == 1 ? 0 : 8);
            }
        }, 96, null);
    }

    public static final void i2(StreamDetailFragment this$0, View view) {
        ResourceDetectors resourceDetector;
        List<DownloadItem> resolutionList;
        ResourceDetectors resourceDetector2;
        List<DownloadItem> resolutionList2;
        Intrinsics.g(this$0, "this$0");
        Subject subject = this$0.f59799m;
        if (subject != null && (resourceDetector = subject.getResourceDetector()) != null && (resolutionList = resourceDetector.getResolutionList()) != null && (!resolutionList.isEmpty())) {
            Subject subject2 = this$0.f59799m;
            Integer numValueOf = (subject2 == null || (resourceDetector2 = subject2.getResourceDetector()) == null || (resolutionList2 = resourceDetector2.getResolutionList()) == null) ? null : Integer.valueOf(resolutionList2.size());
            Intrinsics.d(numValueOf);
            if (numValueOf.intValue() > 1) {
                Subject subject3 = this$0.f59799m;
                ResourceDetectors resourceDetector3 = subject3 != null ? subject3.getResourceDetector() : null;
                if (resourceDetector3 != null) {
                    resourceDetector3.setType(1);
                }
            }
        }
        this$0.M1();
        this$0.N1();
    }

    private final void j2() {
        String genre;
        SubjectGameInfo gameInfo;
        SubjectGameInfo gameInfo2;
        SubjectGameInfo gameInfo3;
        SubjectGameInfo gameInfo4;
        this.F = true;
        Subject subject = this.f59799m;
        String itemId = null;
        String type = (subject == null || (gameInfo4 = subject.getGameInfo()) == null) ? null : gameInfo4.getType();
        if (type != null && type.length() != 0) {
            Subject subject2 = this.f59799m;
            String itemId2 = (subject2 == null || (gameInfo3 = subject2.getGameInfo()) == null) ? null : gameInfo3.getItemId();
            if (itemId2 != null && itemId2.length() != 0) {
                uo.b.a.f(uo.b.f78622a, "GameResLoader", "stream detail game initGameRes", false, 4, null);
                Context context = getContext();
                if (context == null) {
                    return;
                }
                IGameResApi iGameResApi = (IGameResApi) com.alibaba.android.arouter.launcher.a.d().h(IGameResApi.class);
                Subject subject3 = this.f59799m;
                GameInfoType gameInfoType = (subject3 == null || (gameInfo2 = subject3.getGameInfo()) == null) ? null : gameInfo2.getGameInfoType();
                Intrinsics.d(gameInfoType);
                Subject subject4 = this.f59799m;
                if (subject4 != null && (gameInfo = subject4.getGameInfo()) != null) {
                    itemId = gameInfo.getItemId();
                }
                String str = itemId;
                Intrinsics.d(str);
                iGameResApi.f1(context, "stream_detail", gameInfoType, str, new Function1<View, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment$initGameRes$1
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
                        this.this$0.E = view;
                        if (view != null) {
                            this.this$0.E2();
                            return;
                        }
                        rz.i mViewBinding = this.this$0.getMViewBinding();
                        if (mViewBinding != null && (frameLayout2 = mViewBinding.f75869j) != null) {
                            so.c.g(frameLayout2);
                        }
                        rz.i mViewBinding2 = this.this$0.getMViewBinding();
                        if (mViewBinding2 == null || (frameLayout = mViewBinding2.f75869j) == null) {
                            return;
                        }
                        frameLayout.removeAllViews();
                    }
                });
                return;
            }
        }
        Subject subject5 = this.f59799m;
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

    public static final void k2(StreamDetailFragment this$0, View view) {
        FragmentActivity activity;
        Intrinsics.g(this$0, "this$0");
        if (this$0.f59797k != null) {
            if (this$0.C2(FloatActionType.BACK) || (activity = this$0.getActivity()) == null) {
                return;
            }
            activity.finish();
            return;
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final void m2(Subject subject) {
        String restrictLevel = subject.getRestrictLevel();
        if (restrictLevel == null || restrictLevel.length() == 0 || !RoomAppMMKV.f51271a.a().getBoolean("restrict_tips_dialog_again", true)) {
            return;
        }
        kv.a aVar = this.f59797k;
        if (aVar != null) {
            aVar.onHandlePause();
        }
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sa_restrict_tips", false, 2, null);
        String value = configBeanC != null ? configBeanC.getValue() : null;
        if (value == null || value.length() == 0) {
            value = Utils.a().getString(com.transsion.moviedetail.R$string.movie_detail_restrict_tips);
        }
        final RestrictTipsDialog restrictTipsDialogA = RestrictTipsDialog.f53538j.a(value, "stream_detail", subject.getSubjectId());
        restrictTipsDialogA.k0(this, "RestrictTipsDialog");
        restrictTipsDialogA.x0(new Function1<Boolean, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment$initShowRestrictTips$1$1
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
                    kv.a aVar2 = this.f59797k;
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

    private final void n2() {
        ConstraintLayout root;
        rz.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (root = mViewBinding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.videodetail.c
            @Override // java.lang.Runnable
            public final void run() {
                StreamDetailFragment.o2(this.f59901a);
            }
        });
    }

    public static final void o2(StreamDetailFragment this$0) {
        Subject subject;
        String subjectId;
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (subject = this$0.f59799m) == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        VideoFloatManager.f60019a.b().b(activity, subjectId, "stream_detail");
    }

    public static final void q2(StreamDetailFragment this$0, String str) {
        NativeSlideshowView nativeSlideshowView;
        NativeSlideshowView nativeSlideshowView2;
        NativeSlideshowView nativeSlideshowView3;
        Intrinsics.g(this$0, "this$0");
        rz.i mViewBinding = this$0.getMViewBinding();
        if (mViewBinding != null && (nativeSlideshowView3 = mViewBinding.f75874o) != null) {
            nativeSlideshowView3.setSceneId("StreamingMediaContentScene");
        }
        rz.i mViewBinding2 = this$0.getMViewBinding();
        if (mViewBinding2 != null && (nativeSlideshowView2 = mViewBinding2.f75874o) != null) {
            nativeSlideshowView2.setCtxMap(com.transsion.ad.strategy.b.f50584a.a(str));
        }
        rz.i mViewBinding3 = this$0.getMViewBinding();
        if (mViewBinding3 == null || (nativeSlideshowView = mViewBinding3.f75874o) == null) {
            return;
        }
        nativeSlideshowView.initAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(boolean z11) {
        HashMap<String, String> mapG;
        MovieDetailActivity.f53423s.a("videoDetail start load data ....");
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            String str = this.f59804r;
            if (str == null) {
                str = "";
            }
            mapG.put("subject_id", str);
        }
        Bundle arguments = getArguments();
        this.f59805s = arguments != null ? arguments.getString("ops") : null;
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            if (!z11) {
                K0();
            }
            String str2 = this.f59804r;
            if (str2 != null) {
                W1().q(str2);
                a2().p(str2);
                a2().o(str2);
            }
        }
    }

    public static /* synthetic */ void s2(StreamDetailFragment streamDetailFragment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        streamDetailFragment.r2(z11);
    }

    private final void t2(boolean z11) {
        String genre;
        Subject subject = this.f59799m;
        if (subject == null || (genre = subject.getGenre()) == null) {
            return;
        }
        String lowerCase = genre.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (lowerCase == null || !StringsKt__StringsKt.Q(lowerCase, "game", false, 2, null)) {
            return;
        }
        if (z11) {
            U1().z();
        } else {
            U1().Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2(LongVodUiType longVodUiType) {
        if (this.E == null || longVodUiType != LongVodUiType.MIDDLE) {
            return;
        }
        E2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v2(lv.a aVar) {
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_PLAY").withString("subject_id", this.f59804r);
        Subject subject = this.f59799m;
        if (subject != null && subject.getType() == 3 && aVar != null) {
            postcardWithString.withParcelable("TV_DATA", new FbTvData(aVar.m(), aVar.k(), aVar.d()));
        }
        postcardWithString.navigation();
    }

    public static final void w2(StreamDetailFragment this$0, VideoDetailStreamList videoDetailStreamList) {
        Intrinsics.g(this$0, "this$0");
        uo.b.f78622a.c("videoDetail", "playInfoObserver  playInfo==" + videoDetailStreamList, true);
        this$0.d2();
        if (videoDetailStreamList != null || com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.P1();
        } else {
            this$0.G2();
        }
    }

    private final void z2() {
        rz.i mViewBinding;
        AppCompatImageView appCompatImageView;
        final Subject subject = this.f59799m;
        if (subject == null || (mViewBinding = getMViewBinding()) == null || (appCompatImageView = mViewBinding.f75871l) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StreamDetailFragment.A2(this.f59913a, subject, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        s2(this, false, 1, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        this.C = com.transsion.baselib.report.m.f51277a.f();
        Bundle arguments = getArguments();
        this.f59805s = arguments != null ? arguments.getString("ops") : null;
        Bundle arguments2 = getArguments();
        this.f59804r = arguments2 != null ? arguments2.getString("id") : null;
        Bundle arguments3 = getArguments();
        this.f59808v = arguments3 != null ? arguments3.getBoolean("auto_download") : false;
        Bundle arguments4 = getArguments();
        this.f59809w = arguments4 != null ? arguments4.getBoolean("auto_play") : false;
        Bundle arguments5 = getArguments();
        this.f59810x = arguments5 != null ? arguments5.getString("auto_play_resource_id") : null;
        Bundle arguments6 = getArguments();
        this.f59811y = arguments6 != null ? arguments6.getInt("yy_preload_id") : 0;
        MovieDetailViewModel movieDetailViewModelW1 = W1();
        int i11 = this.f59811y;
        String str = this.f59804r;
        if (str == null) {
            str = "";
        }
        movieDetailViewModelW1.C(i11, str);
        Bundle arguments7 = getArguments();
        this.f59807u = arguments7 != null ? arguments7.getString("module_name") : null;
        Bundle arguments8 = getArguments();
        this.A = arguments8 != null ? arguments8.getInt("season") : 0;
        Bundle arguments9 = getArguments();
        this.B = arguments9 != null ? arguments9.getInt("episode") : 0;
        int i12 = this.A;
        if (i12 <= 0) {
            i12 = 1;
        }
        this.f59812z = i12;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        if (this.f59799m == null) {
            B0();
        }
    }

    public final void G2() {
        kv.a aVar = this.f59797k;
        if (aVar != null) {
            aVar.showNoNetError();
        }
        this.S = true;
    }

    public final void K1() {
        ResourcesSeasonList resourcesSeasonListF = a2().w().f();
        if (resourcesSeasonListF == null) {
            return;
        }
        boolean z11 = false;
        if (resourcesSeasonListF.isSeries()) {
            uo.b.a.f(uo.b.f78622a, "videoDetail", "checkHasNext 是剧集，判断下一集还是完成 ", false, 4, null);
            List<VideoDetailMediaSource> listF = a2().q().f();
            if (listF == null) {
                listF = kotlin.collections.g.l();
            }
            VideoDetailMediaSource videoDetailMediaSourceF = a2().v().f();
            int iIndexOf = videoDetailMediaSourceF != null ? listF.indexOf(videoDetailMediaSourceF) : -1;
            if (iIndexOf >= 0 && iIndexOf < listF.size() - 1) {
                z11 = true;
            }
        }
        kv.a aVar = this.f59797k;
        if (aVar != null) {
            aVar.hasNextEpisode(z11);
        }
    }

    public final void L1() {
        ResourcesSeasonList resourcesSeasonListF = a2().w().f();
        if (resourcesSeasonListF == null) {
            return;
        }
        if (resourcesSeasonListF.isNoSource()) {
            uo.b.a.f(uo.b.f78622a, "videoDetail", "checkPlayNextOrReplay 没有资源", false, 4, null);
            return;
        }
        if (!resourcesSeasonListF.isSeries()) {
            if (resourcesSeasonListF.isMovie()) {
                uo.b.a.f(uo.b.f78622a, "videoDetail", "checkPlayInfo 是电影", false, 4, null);
                kv.a aVar = this.f59797k;
                if (aVar != null) {
                    aVar.showReplay();
                    return;
                }
                return;
            }
            return;
        }
        uo.b.a aVar2 = uo.b.f78622a;
        uo.b.a.f(aVar2, "videoDetail", "checkPlayNextOrReplay 是剧集，判断下一集还是完成 ", false, 4, null);
        List<VideoDetailMediaSource> listF = a2().q().f();
        if (listF == null) {
            return;
        }
        VideoDetailMediaSource videoDetailMediaSourceF = a2().v().f();
        if (videoDetailMediaSourceF == null) {
            a2().z((VideoDetailMediaSource) CollectionsKt___CollectionsKt.g0(listF));
            return;
        }
        int iIndexOf = listF.indexOf(videoDetailMediaSourceF);
        if (iIndexOf >= listF.size() - 1) {
            uo.b.a.f(aVar2, "videoDetail", "checkPlayInfo 是剧集完成播放", false, 4, null);
            kv.a aVar3 = this.f59797k;
            if (aVar3 != null) {
                aVar3.showReplay();
                return;
            }
            return;
        }
        uo.b.a.f(aVar2, "videoDetail", "checkPlayInfo 自动播放下一集，currentIndex：" + iIndexOf, false, 4, null);
        a2().z((VideoDetailMediaSource) CollectionsKt___CollectionsKt.h0(listF, iIndexOf + 1));
    }

    public final void M2() {
        ResourcesSeasonList resourcesSeasonListF = a2().w().f();
        if (resourcesSeasonListF == null || this.f59799m == null) {
            return;
        }
        this.L = !resourcesSeasonListF.isNoSource();
        if (resourcesSeasonListF.isNoSource()) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            ResourceDetectorEmptyFragment resourceDetectorEmptyFragment = new ResourceDetectorEmptyFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.f59799m);
            resourceDetectorEmptyFragment.setArguments(bundle);
            fragmentTransactionBeginTransaction.replace(R$id.resourceDetectorGroup, resourceDetectorEmptyFragment);
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            K2(8);
        } else {
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.f(childFragmentManager2, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction2 = childFragmentManager2.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction2, "beginTransaction()");
            VideoEpisodeFragment videoEpisodeFragment = new VideoEpisodeFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("data_key_resource_detectors", this.f59799m);
            bundle2.putString("ops", this.f59805s);
            bundle2.putBoolean("auto_play", this.f59809w);
            bundle2.putString("auto_play_resource_id", this.f59810x);
            bundle2.putString("module_name", this.f59807u);
            bundle2.putInt("season", this.f59812z);
            videoEpisodeFragment.setArguments(bundle2);
            fragmentTransactionBeginTransaction2.replace(R$id.resourceDetectorGroup, videoEpisodeFragment);
            videoEpisodeFragment.P0(new Function1<DubsInfo, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment$updateSeasons$2$1$1
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
                    Integer numValueOf;
                    List<DubsInfo> dubs;
                    Intrinsics.g(info, "info");
                    uo.b.a.g(uo.b.f78622a, "AudioSelectCallback " + info, false, 2, null);
                    Subject subject = this.this$0.f59799m;
                    if (subject == null || (dubs = subject.getDubs()) == null) {
                        numValueOf = null;
                    } else {
                        Iterator<DubsInfo> it = dubs.iterator();
                        int i11 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i11 = -1;
                                break;
                            } else if (Intrinsics.b(it.next().getLanCode(), info.getLanCode())) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        numValueOf = Integer.valueOf(i11);
                    }
                    if ((numValueOf != null && numValueOf.intValue() == -1) || info.getSubjectId() == null) {
                        uo.b.a.g(uo.b.f78622a, "AudioSelectCallback info can't find in dubs", false, 2, null);
                    } else {
                        this.this$0.W1().z().q(info);
                    }
                }
            });
            fragmentTransactionBeginTransaction2.commitAllowingStateLoss();
            L2(this, 0, 1, null);
        }
        if (!resourcesSeasonListF.isNoSource()) {
            H2();
            return;
        }
        B2(this.f59799m);
        FragmentActivity activity = getActivity();
        BaseMusicFloatActivity baseMusicFloatActivity = activity instanceof BaseMusicFloatActivity ? (BaseMusicFloatActivity) activity : null;
        if (baseMusicFloatActivity != null) {
            baseMusicFloatActivity.showMusicFloating();
        }
    }

    public final void P1() {
        kv.a aVar = this.f59797k;
        if (aVar != null) {
            aVar.removeNoNetError();
        }
        this.S = false;
    }

    public final void Q1(VideoDetailMediaSource videoDetailMediaSource) {
        if (videoDetailMediaSource == null) {
            return;
        }
        VideoDetailStreamList videoDetailStreamListF = a2().u().f();
        if (videoDetailStreamListF != null && videoDetailStreamListF.getSe() == videoDetailMediaSource.getSe() && videoDetailStreamListF.getEp() == videoDetailMediaSource.getEp()) {
            return;
        }
        kv.a aVar = this.f59797k;
        if (aVar != null) {
            aVar.reset();
        }
        F2();
        a2().t(videoDetailMediaSource);
        K1();
    }

    public final com.transsnet.downloader.viewmodel.e R1() {
        return (com.transsnet.downloader.viewmodel.e) this.f59802p.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void V() {
        super.V();
        uo.b.a.f(uo.b.f78622a, "VideoFloat", "onRecentClick onHomeClick", false, 4, null);
        C2(FloatActionType.HOME);
    }

    public final PlayMimeType V1(VideoDetailStream videoDetailStream) {
        String upperCase;
        String format;
        if (videoDetailStream == null || (format = videoDetailStream.getFormat()) == null) {
            upperCase = null;
        } else {
            upperCase = format.toUpperCase(Locale.ROOT);
            Intrinsics.f(upperCase, "toUpperCase(...)");
        }
        PlayMimeType playMimeType = PlayMimeType.DASH;
        if (Intrinsics.b(upperCase, playMimeType.name())) {
            return playMimeType;
        }
        PlayMimeType playMimeType2 = PlayMimeType.HLS;
        return Intrinsics.b(upperCase, playMimeType2.name()) ? playMimeType2 : PlayMimeType.DEFAULT;
    }

    public final VideoDetailMediaSource X1(VideoDetailPlayBean videoDetailPlayBean, List<VideoDetailMediaSource> list) {
        Object obj = null;
        if (videoDetailPlayBean == null) {
            uo.b.a.f(uo.b.f78622a, "videoDetail", "getPlayingItem 无历史记录，se:" + this.A, false, 4, null);
            if (this.A <= 0) {
                return (VideoDetailMediaSource) CollectionsKt___CollectionsKt.g0(list);
            }
            for (Object obj2 : list) {
                VideoDetailMediaSource videoDetailMediaSource = (VideoDetailMediaSource) obj2;
                if (videoDetailMediaSource.getSe() == this.A && videoDetailMediaSource.getEp() == 1) {
                    obj = obj2;
                    break;
                }
            }
            VideoDetailMediaSource videoDetailMediaSource2 = (VideoDetailMediaSource) obj;
            return videoDetailMediaSource2 == null ? (VideoDetailMediaSource) CollectionsKt___CollectionsKt.g0(list) : videoDetailMediaSource2;
        }
        int se2 = videoDetailPlayBean.getSe();
        int i11 = this.A;
        if (se2 == i11 || i11 <= 0) {
            this.f59812z = videoDetailPlayBean.getSe();
            uo.b.a.f(uo.b.f78622a, "videoDetail", "getPlayingItem 有历史记录，不指定季使用历史记录，se:" + videoDetailPlayBean.getSe() + ", ep:" + videoDetailPlayBean.getEp(), false, 4, null);
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
        uo.b.a.f(uo.b.f78622a, "videoDetail", "getPlayingItem 有历史记录，指定季，history se:" + videoDetailPlayBean.getSe() + ", ep:" + videoDetailPlayBean.getEp() + "， target se:" + this.A + ", targetEp:" + this.B, false, 4, null);
        for (Object obj4 : list) {
            VideoDetailMediaSource videoDetailMediaSource5 = (VideoDetailMediaSource) obj4;
            if (videoDetailMediaSource5.getSe() == this.A) {
                int ep2 = videoDetailMediaSource5.getEp();
                int i12 = this.B;
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

    public final int Y1() {
        return this.f59811y;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: b2, reason: merged with bridge method [inline-methods] */
    public rz.i getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        rz.i iVarC = rz.i.c(inflater);
        Intrinsics.f(iVarC, "inflate(inflater)");
        return iVarC;
    }

    public final List<lv.c> c2(List<VideoDetailStream> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (VideoDetailStream videoDetailStream : list) {
                arrayList.add(new lv.c(V1(videoDetailStream), videoDetailStream.getId(), videoDetailStream.getUrl(), videoDetailStream.getResolutions(), videoDetailStream.getSize(), videoDetailStream.getDuration(), videoDetailStream.getSignCookie()));
            }
        }
        return arrayList;
    }

    public final void d2() {
        if (this.f59799m == null) {
            uo.b.a.f(uo.b.f78622a, "videoDetail", "PlayInfoLive  mMovieDetailBean==null", false, 4, null);
            return;
        }
        VideoDetailStreamList videoDetailStreamListF = a2().u().f();
        if (videoDetailStreamListF == null) {
            uo.b.a.f(uo.b.f78622a, "videoDetail", "PlayInfoLive playInfo==null", false, 4, null);
            return;
        }
        VideoDetailMediaSource videoDetailMediaSourceF = a2().v().f();
        if (videoDetailMediaSourceF == null) {
            uo.b.a.f(uo.b.f78622a, "videoDetail", "PlayInfoLive media==null", false, 4, null);
            return;
        }
        if (Intrinsics.b(videoDetailStreamListF, this.O)) {
            uo.b.a.f(uo.b.f78622a, "videoDetail", "PlayInfoLive data:" + videoDetailStreamListF + "  media:" + videoDetailMediaSourceF + "  重复播放数据，不处理", false, 4, null);
            return;
        }
        if (videoDetailMediaSourceF.getEp() == videoDetailStreamListF.getEp() && videoDetailMediaSourceF.getSe() == videoDetailStreamListF.getSe()) {
            this.O = videoDetailStreamListF;
            O1();
            x2(videoDetailStreamListF);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "videoDetail", "PlayInfoLive data:" + videoDetailStreamListF + "  media:" + videoDetailMediaSourceF + "  不相同，不播放", false, 4, null);
    }

    @Override // hv.a
    public void e0(Function0<Boolean> function0) {
        this.K = function0;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void h() {
        super.h();
        uo.b.a.f(uo.b.f78622a, "VideoFloat", "StreamDetail onHomeClick", false, 4, null);
        C2(FloatActionType.HOME);
    }

    public final void h2() {
        DownloadView downloadView;
        DownloadView downloadView2;
        rz.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (downloadView2 = mViewBinding.f75864d) != null) {
            DownloadView.setAttrs$default(downloadView2, null, Float.valueOf(com.transsion.core.utils.e.g(16.0f)), null, 5, null);
        }
        rz.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (downloadView = mViewBinding2.f75864d) == null) {
            return;
        }
        downloadView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StreamDetailFragment.i2(this.f59907a, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        rz.i mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f75870k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StreamDetailFragment.k2(this.f59909a, view);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        MovieDetailViewModel movieDetailViewModelW1 = W1();
        movieDetailViewModelW1.r().j(this, new e(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment$initViewModel$1$1

            /* JADX INFO: renamed from: com.transsion.videodetail.StreamDetailFragment$initViewModel$1$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsion.videodetail.StreamDetailFragment$initViewModel$1$1$1", f = "StreamDetailFragment.kt", l = {282}, m = "invokeSuspend")
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ StreamDetailFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(StreamDetailFragment streamDetailFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = streamDetailFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
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
                HashMap<String, String> mapG3;
                Subject second = pair.getSecond();
                uo.b.f78622a.c("videoDetail", "get movie detail data==" + pair, true);
                if (second == null) {
                    if (Intrinsics.b(pair.getFirst(), "404")) {
                        com.tn.lib.widget.toast.core.h.f50034a.k(com.transsion.moviedetail.R$string.movie_lost_content);
                        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this.this$0), null, null, new AnonymousClass1(this.this$0, null), 3, null);
                    }
                    if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        PageStatusFragment.H0(this.this$0, false, 1, null);
                        return;
                    } else {
                        PageStatusFragment.N0(this.this$0, false, 1, null);
                        return;
                    }
                }
                MovieDetailViewModel movieDetailViewModelW2 = this.this$0.W1();
                String subjectId = second.getSubjectId();
                Integer subjectType = second.getSubjectType();
                Context context = this.this$0.getContext();
                MovieDetailViewModel.i(movieDetailViewModelW2, subjectId, subjectType, 0, context != null && com.transsion.baseui.util.b.a(context), 4, null);
                this.this$0.F0();
                this.this$0.f59806t = true;
                this.this$0.N2(second);
                this.this$0.M2();
                this.this$0.d2();
                this.this$0.I2();
                com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.j(true);
                }
                com.transsion.baselib.report.h logViewConfig2 = this.this$0.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.m(this.this$0.f59805s);
                }
                com.transsion.baselib.report.h logViewConfig3 = this.this$0.getLogViewConfig();
                if (logViewConfig3 != null && (mapG3 = logViewConfig3.g()) != null) {
                    String subjectId2 = second.getSubjectId();
                    if (subjectId2 == null) {
                        subjectId2 = "";
                    }
                    mapG3.put("subject_id", subjectId2);
                }
                com.transsion.baselib.report.h logViewConfig4 = this.this$0.getLogViewConfig();
                if (logViewConfig4 != null && (mapG2 = logViewConfig4.g()) != null) {
                    mapG2.put("has_resource", String.valueOf(second.getHasResource()));
                }
                com.transsion.baselib.report.h logViewConfig5 = this.this$0.getLogViewConfig();
                if (logViewConfig5 == null || (mapG = logViewConfig5.g()) == null) {
                    return;
                }
                mapG.put("module_name", this.this$0.f59807u);
            }
        }));
        movieDetailViewModelW1.u().j(this, new e(new Function1<Integer, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment$initViewModel$1$2
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
                StreamDetailFragment streamDetailFragment = this.this$0;
                Intrinsics.f(season, "season");
                streamDetailFragment.f59812z = season.intValue();
            }
        }));
        a2().w().j(this, new e(new Function1<ResourcesSeasonList, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment.initViewModel.2
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
                StreamDetailFragment.this.M2();
            }
        }));
        a2().q().j(this, new e(new Function1<List<? extends VideoDetailMediaSource>, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment.initViewModel.3
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
                StreamDetailFragment.this.l2();
            }
        }));
        a2().v().j(this, new e(new Function1<VideoDetailMediaSource, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment.initViewModel.4
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
                uo.b.a.s(uo.b.f78622a, "VideoDetailEpisode", "--------PlayingEpisodeMediaLiveDat:observe", false, 4, null);
                StreamDetailFragment.this.Q1(videoDetailMediaSource);
            }
        }));
        W1().z().j(this, new e(new Function1<DubsInfo, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment.initViewModel.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DubsInfo dubsInfo) {
                invoke2(dubsInfo);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DubsInfo dubsInfo) {
                StreamDetailFragment streamDetailFragment = StreamDetailFragment.this;
                kv.a aVar = streamDetailFragment.f59797k;
                streamDetailFragment.I = aVar != null ? aVar.currentPosition() : 0L;
                StreamDetailFragment.this.f59804r = dubsInfo.getSubjectId();
                StreamDetailFragment.this.f59799m = null;
                StreamDetailFragment.this.O = null;
                StreamDetailFragment.this.a2().A();
                MovieDetailViewModel movieDetailViewModelW2 = StreamDetailFragment.this.W1();
                int iY1 = StreamDetailFragment.this.Y1();
                String str = StreamDetailFragment.this.f59804r;
                if (str == null) {
                    str = "";
                }
                movieDetailViewModelW2.C(iY1, str);
                StreamDetailFragment.this.r2(true);
            }
        }));
        R1().c().j(this, new e(new Function1<Boolean, Unit>() { // from class: com.transsion.videodetail.StreamDetailFragment.initViewModel.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isShow) {
                uo.b.a.f(uo.b.f78622a, "videoDetail", "isShowDownloadInterceptDialog --> " + isShow, false, 4, null);
                StreamDetailFragment streamDetailFragment = StreamDetailFragment.this;
                Intrinsics.f(isShow, "isShow");
                streamDetailFragment.M = isShow.booleanValue();
                if (!StreamDetailFragment.this.M) {
                    StreamDetailFragment.this.onResume();
                    return;
                }
                kv.a aVar = StreamDetailFragment.this.f59797k;
                if (aVar != null) {
                    aVar.onViewPause();
                }
            }
        }));
    }

    public final void l2() {
        ResourcesSeasonList resourcesSeasonListF;
        if (this.f59804r == null || (resourcesSeasonListF = a2().w().f()) == null) {
            return;
        }
        Intrinsics.f(resourcesSeasonListF, "videoDetailViewModel.get…iveData().value ?: return");
        if (resourcesSeasonListF.isNoSource()) {
            uo.b.a.f(uo.b.f78622a, "videoDetail", "checkPlayInfo 没有资源", false, 4, null);
            return;
        }
        if (resourcesSeasonListF.isSeries()) {
            uo.b.a.f(uo.b.f78622a, "videoDetail", "checkPlayInfo 是剧集，获取记录决定哪集", false, 4, null);
            List<VideoDetailMediaSource> listF = a2().q().f();
            if (listF == null) {
                return;
            }
            Intrinsics.f(listF, "videoDetailViewModel.get…iveData().value ?: return");
            VideoDetailPlayBean videoDetailPlayBeanF = a2().s().f();
            this.Q = videoDetailPlayBeanF;
            a2().z(X1(videoDetailPlayBeanF, listF));
            return;
        }
        if (resourcesSeasonListF.isMovie()) {
            uo.b.a.f(uo.b.f78622a, "videoDetail", "checkPlayInfo 是电影", false, 4, null);
            List<VideoDetailMediaSource> listF2 = a2().q().f();
            if (listF2 == null) {
                return;
            }
            Intrinsics.f(listF2, "videoDetailViewModel.get…iveData().value ?: return");
            this.Q = a2().s().f();
            a2().z((VideoDetailMediaSource) CollectionsKt___CollectionsKt.g0(listF2));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("stream_detail", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MovieDetailActivity.f53423s.a("videoDetail------- onCreate ------");
        com.tn.lib.util.networkinfo.f.f49475a.l(this.N);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        NativeSlideshowView nativeSlideshowView;
        super.onDestroy();
        rz.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (nativeSlideshowView = mViewBinding.f75874o) == null) {
            return;
        }
        nativeSlideshowView.destroy();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.videofloat.a aVar = com.transsion.videofloat.a.f60027a;
        kv.a aVar2 = this.f59797k;
        if (!aVar.c(aVar2 != null ? aVar2.getPlayer() : null)) {
            a2().u().o(this.P);
        }
        t2(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean z11) {
        kv.a aVar;
        super.onPictureInPictureModeChanged(z11);
        if (z11) {
            FragmentActivity activity = getActivity();
            if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            vz.a aVarS1 = S1();
            if (aVarS1 != null && Build.VERSION.SDK_INT >= 31) {
                uo.b.a.f(uo.b.f78622a, "VideoFloat-pip", "onPictureInPictureModeChanged stream--- updateData==2", false, 4, null);
                VideoPipManager.f60024a.a().c(activity, aVarS1);
            }
        }
        VideoPipManager.f60024a.a().onPipModeChanged(z11);
        kv.a aVar2 = this.f59797k;
        if (aVar2 != null) {
            aVar2.onPipModeChanged(z11);
        }
        if (z11 || (aVar = this.f59797k) == null) {
            return;
        }
        aVar.exitFullScreen();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        uo.b.a.f(uo.b.f78622a, "videoDetail", "onResume isInterceptDialogShow --> " + this.M, false, 4, null);
        if (this.M) {
            return;
        }
        kv.a aVar = this.f59797k;
        if (aVar != null) {
            aVar.onViewResume();
        }
        a2().u().k(this.P);
        t2(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        kv.a aVar;
        super.onStop();
        kv.a aVar2 = this.f59797k;
        if (aVar2 != null) {
            aVar2.onSaveHistory();
        }
        com.transsion.videofloat.a aVar3 = com.transsion.videofloat.a.f60027a;
        kv.a aVar4 = this.f59797k;
        if (aVar3.c(aVar4 != null ? aVar4.getPlayer() : null) || (aVar = this.f59797k) == null) {
            return;
        }
        aVar.onViewPause();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R$layout.default_movie_detail_skeleton_drawing_layout, (ViewGroup) o0(), false);
        ((AppCompatImageView) viewInflate.findViewById(R$id.ivBack)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StreamDetailFragment.T1(this.f59910a, view);
            }
        });
        return viewInflate;
    }

    public final void p2(final String str) {
        NativeSlideshowView nativeSlideshowView;
        rz.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (nativeSlideshowView = mViewBinding.f75874o) == null) {
            return;
        }
        nativeSlideshowView.postDelayed(new Runnable() { // from class: com.transsion.videodetail.j
            @Override // java.lang.Runnable
            public final void run() {
                StreamDetailFragment.q2(this.f59911a, str);
            }
        }, 500L);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        View view;
        rz.i mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (view = mViewBinding.f75879t) == null) ? null : view.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (bVar != null) {
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = com.blankj.utilcode.util.d.c();
        }
        rz.i mViewBinding2 = getMViewBinding();
        View view2 = mViewBinding2 != null ? mViewBinding2.f75879t : null;
        if (view2 != null) {
            view2.setLayoutParams(bVar);
        }
        requireActivity().getOnBackPressedDispatcher().i(this, new c());
        e2();
        h2();
        n2();
    }

    /* JADX WARN: Code duplicated, block: B:114:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x011a  */
    /* JADX WARN: Code duplicated, block: B:49:0x0121  */
    /* JADX WARN: Code duplicated, block: B:51:0x0125  */
    /* JADX WARN: Code duplicated, block: B:52:0x012c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0132  */
    public final void x2(VideoDetailStreamList videoDetailStreamList) {
        List<VideoDetailStream> list;
        long j11;
        VideoDetailPlayBean videoDetailPlayBean;
        VideoDetailPlayBean videoDetailPlayBean2;
        VideoDetailMediaSource videoDetailMediaSourceF;
        int ep2;
        int se2;
        String str;
        Subject subject;
        List<DubsInfo> listL;
        String averageHueLight;
        String thumbnail;
        String url;
        uo.b.a aVar = uo.b.f78622a;
        aVar.c("videoDetail", "playStream   videoDetailStreamList:" + videoDetailStreamList + "  mSubjectId:" + this.f59804r + "  mMovieDetailBean:" + this.f59799m, true);
        List<VideoDetailStream> streams = videoDetailStreamList != null ? videoDetailStreamList.getStreams() : null;
        if (videoDetailStreamList == null || (list = streams) == null || list.isEmpty()) {
            uo.b.a.j(aVar, "videoDetail", "空返回", false, 4, null);
            return;
        }
        VideoDetailMediaSource videoDetailMediaSourceF2 = a2().v().f();
        if (videoDetailMediaSourceF2 != null && videoDetailMediaSourceF2.getEp() == videoDetailStreamList.getEp() && videoDetailMediaSourceF2.getSe() == videoDetailStreamList.getSe()) {
            long progress = this.I;
            if (progress <= 0) {
                VideoDetailPlayBean videoDetailPlayBean3 = this.Q;
                if (videoDetailPlayBean3 != null && videoDetailPlayBean3 != null && videoDetailStreamList.getSe() == videoDetailPlayBean3.getSe() && (videoDetailPlayBean = this.Q) != null && videoDetailStreamList.getEp() == videoDetailPlayBean.getEp() && ((this.A > 0 && (videoDetailPlayBean2 = this.Q) != null && videoDetailPlayBean2.getSe() == this.A) || this.A <= 0)) {
                    a2().l();
                    VideoDetailPlayBean videoDetailPlayBean4 = this.Q;
                    if (videoDetailPlayBean4 != null) {
                        progress = videoDetailPlayBean4.getProgress();
                        uo.b.a.s(aVar, "videoDetail", "playStream， history，seekTo:" + progress + " ", false, 4, null);
                    }
                    PlayMimeType playMimeTypeV1 = V1((VideoDetailStream) CollectionsKt___CollectionsKt.g0(streams));
                    videoDetailMediaSourceF = a2().v().f();
                    if (videoDetailMediaSourceF != null) {
                        ep2 = videoDetailMediaSourceF.getEp();
                    } else {
                        ep2 = 0;
                    }
                    if (videoDetailMediaSourceF != null) {
                        se2 = videoDetailMediaSourceF.getSe();
                    } else {
                        se2 = 0;
                    }
                    str = this.f59804r;
                    if (str != null || (subject = this.f59799m) == null) {
                    }
                    String title = subject.getTitle();
                    String str2 = title == null ? "" : title;
                    String title2 = videoDetailStreamList.getTitle();
                    String str3 = this.C;
                    String str4 = str3 == null ? "" : str3;
                    List<lv.c> listC2 = c2(streams);
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
                    Subject subject2 = this.f59799m;
                    String ops = subject2 != null ? subject2.getOps() : null;
                    Subject subject3 = this.f59799m;
                    lv.a aVar2 = new lv.a(str, playMimeTypeV1, j11, ep2, se2, str2, title2, str4, "stream_detail", listC2, str5, str6, str7, iIntValue, Integer.valueOf(iIntValue2), false, subject3 != null ? subject3.getTitle() : null, ops, 32768, null);
                    aVar2.v(this.f59799m);
                    List<DubsInfo> listA = aVar2.a();
                    Subject subject4 = this.f59799m;
                    if (subject4 == null || (listL = subject4.getDubs()) == null) {
                        listL = kotlin.collections.g.l();
                    }
                    listA.addAll(listL);
                    aVar.c("videoDetail", "playStream  addDataSource:" + aVar2 + "  playerControl:" + this.f59797k, true);
                    H2();
                    kv.a aVar3 = this.f59797k;
                    if (aVar3 != null) {
                        aVar3.setDataSource(aVar2);
                        return;
                    }
                    return;
                }
                j11 = 0;
                PlayMimeType playMimeTypeV2 = V1((VideoDetailStream) CollectionsKt___CollectionsKt.g0(streams));
                videoDetailMediaSourceF = a2().v().f();
                if (videoDetailMediaSourceF != null) {
                    ep2 = videoDetailMediaSourceF.getEp();
                } else {
                    ep2 = 0;
                }
                if (videoDetailMediaSourceF != null) {
                    se2 = videoDetailMediaSourceF.getSe();
                } else {
                    se2 = 0;
                }
                str = this.f59804r;
                if (str != null) {
                }
            }
            this.I = 0L;
            uo.b.a.s(aVar, "videoDetail", "playStream， AudioTrack，seekTo:" + progress + " ", false, 4, null);
            j11 = progress;
            PlayMimeType playMimeTypeV3 = V1((VideoDetailStream) CollectionsKt___CollectionsKt.g0(streams));
            videoDetailMediaSourceF = a2().v().f();
            if (videoDetailMediaSourceF != null) {
                ep2 = videoDetailMediaSourceF.getEp();
            } else {
                ep2 = 0;
            }
            if (videoDetailMediaSourceF != null) {
                se2 = videoDetailMediaSourceF.getSe();
            } else {
                se2 = 0;
            }
            str = this.f59804r;
            if (str != null) {
            }
        }
    }

    public final void y2() {
        kv.a aVar;
        com.transsion.videofloat.a aVar2 = com.transsion.videofloat.a.f60027a;
        kv.a aVar3 = this.f59797k;
        if (!aVar2.c(aVar3 != null ? aVar3.getPlayer() : null) && (aVar = this.f59797k) != null) {
            aVar.release();
        }
        kv.a aVar4 = this.f59797k;
        if (aVar4 != null) {
            aVar4.onPageDestroy();
        }
        com.tn.lib.util.networkinfo.f.f49475a.m(this.N);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean z0() {
        return true;
    }
}
