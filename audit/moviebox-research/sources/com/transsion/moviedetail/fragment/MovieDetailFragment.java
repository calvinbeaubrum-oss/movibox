package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.bean.GameInfoType;
import com.transsion.commercializationapi.IGameResApi;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
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
import com.transsion.push.bean.MsgStyle;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsion.videofloat.VideoFloatManager;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.manager.DownloadStatusIconManager;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.util.ArrayList;
import java.util.HashMap;
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
import net.lucode.hackware.magicindicator.MagicIndicator;
import org.mvel2.ast.ASTNode;

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
public final class MovieDetailFragment extends PageStatusFragment<tu.h> implements hv.a {
    public static final a N = new a(null);
    public boolean A;
    public String C;
    public kv.a D;
    public boolean E;
    public View F;
    public boolean G;
    public long J;
    public Function0<Boolean> L;
    public Fragment M;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DownloadView f53489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PlayDetailBottomRecHelper f53490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Subject f53491m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f53495q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f53497s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f53498t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f53499u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f53500v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f53501w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f53502x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public g00.e f53503y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f53504z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f53492n = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f53493o = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsnet.downloader.viewmodel.e.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$3
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$special$$inlined$activityViewModels$default$4
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

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f53494p = LazyKt__LazyJVMKt.b(new Function0<IPublishApi>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$publishedApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IPublishApi invoke() {
            return (IPublishApi) com.alibaba.android.arouter.launcher.a.d().h(IPublishApi.class);
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f53496r = SubjectType.MOVIE.getValue();
    public int B = 1;
    public IFissionProvider H = (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class);
    public final Lazy I = LazyKt__LazyJVMKt.b(new Function0<IMemberApi>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$memberProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IMemberApi invoke() {
            return (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        }
    });
    public LongVodUiType K = LongVodUiType.MIDDLE;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MovieDetailFragment a() {
            return new MovieDetailFragment();
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
            tu.h mViewBinding = MovieDetailFragment.this.getMViewBinding();
            if (mViewBinding != null && (bubbleTextView = mViewBinding.f77483b) != null && (viewTreeObserver = bubbleTextView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            tu.h mViewBinding2 = MovieDetailFragment.this.getMViewBinding();
            BubbleTextView bubbleTextView2 = mViewBinding2 != null ? mViewBinding2.f77483b : null;
            if (bubbleTextView2 == null || bubbleTextView2.getMeasuredWidth() == 0) {
                return;
            }
            float measuredWidth = (bubbleTextView2.getMeasuredWidth() / 2) - (com.blankj.utilcode.util.f0.a(16.0f) / 2);
            bubbleTextView2.setArrowPosition(measuredWidth);
            uo.b.a.f(uo.b.f78622a, "movie_detail_fragment -->", "activity tip width: " + bubbleTextView2.getMeasuredWidth() + ", arrowPosition: " + measuredWidth, false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements g00.e {
        @Override // g00.e
        public void a(int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends androidx.activity.p {
        public d() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            Function0 function0 = MovieDetailFragment.this.L;
            if (function0 == null || !((Boolean) function0.invoke()).booleanValue()) {
                if (MovieDetailFragment.this.D != null) {
                    kv.a aVar = MovieDetailFragment.this.D;
                    if (aVar != null) {
                        aVar.onBackPressed();
                        return;
                    }
                    return;
                }
                FragmentActivity activity = MovieDetailFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53507a;

        public e(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53507a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53507a;
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
            this.f53507a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements yz.a {
        @Override // yz.a
        public void a(vz.a aVar) {
        }

        @Override // yz.a
        public boolean b(vz.a aVar) {
            return false;
        }

        @Override // yz.a
        public void c(vz.a aVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("oneroom://com.community.oneroom?type=/movie/detail&id=" + (aVar != null ? aVar.q() : null)));
            intent.setFlags(ASTNode.DEOP);
            Utils.a().startActivity(intent);
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
        }

        @Override // kv.a.b
        public boolean b() {
            return false;
        }

        @Override // kv.a.b
        public boolean c(FloatActionType actionType) {
            Intrinsics.g(actionType, "actionType");
            return MovieDetailFragment.this.g2(actionType);
        }

        @Override // kv.a.b
        public void d(lv.a aVar) {
            MovieDetailFragment.this.a2(aVar);
        }

        @Override // kv.a.b
        public void e(LongVodUiType uiType) {
            Intrinsics.g(uiType, "uiType");
            MovieDetailFragment.this.K = uiType;
            MovieDetailFragment.this.Z1(uiType);
            PlayDetailBottomRecHelper playDetailBottomRecHelper = MovieDetailFragment.this.f53490l;
            if (playDetailBottomRecHelper != null) {
                playDetailBottomRecHelper.u(uiType != LongVodUiType.MIDDLE);
            }
        }

        @Override // kv.a.b
        public View f() {
            return MovieDetailFragment.this.F;
        }

        @Override // kv.a.b
        public void g(boolean z11) {
            tu.h mViewBinding = MovieDetailFragment.this.getMViewBinding();
            AppCompatImageView appCompatImageView = mViewBinding != null ? mViewBinding.f77491k : null;
            if (appCompatImageView == null) {
                return;
            }
            appCompatImageView.setVisibility(z11 ? 0 : 8);
        }

        @Override // kv.a.b
        public void onCompletion() {
        }
    }

    public static final void A1(MovieDetailFragment this$0, View view) {
        ResourceDetectors resourceDetector;
        List<DownloadItem> resolutionList;
        ResourceDetectors resourceDetector2;
        List<DownloadItem> resolutionList2;
        Intrinsics.g(this$0, "this$0");
        Subject subject = this$0.f53491m;
        if (subject != null && (resourceDetector = subject.getResourceDetector()) != null && (resolutionList = resourceDetector.getResolutionList()) != null && (!resolutionList.isEmpty())) {
            Subject subject2 = this$0.f53491m;
            Integer numValueOf = (subject2 == null || (resourceDetector2 = subject2.getResourceDetector()) == null || (resolutionList2 = resourceDetector2.getResolutionList()) == null) ? null : Integer.valueOf(resolutionList2.size());
            Intrinsics.d(numValueOf);
            if (numValueOf.intValue() > 1) {
                Subject subject3 = this$0.f53491m;
                ResourceDetectors resourceDetector3 = subject3 != null ? subject3.getResourceDetector() : null;
                if (resourceDetector3 != null) {
                    resourceDetector3.setType(1);
                }
            }
        }
        this$0.C1();
    }

    public static final void F1(MovieDetailFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MovieDetailViewModel H1() {
        return (MovieDetailViewModel) this.f53492n.getValue();
    }

    private final List<lv.c> L1(Trailer trailer) {
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

    public static final void N1(MovieDetailFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "movie_detail_fragment -->", "Click activity tip", false, 4, null);
        this$0.E = true;
        Intrinsics.f(it, "it");
        so.c.g(it);
    }

    private final void P1() {
        this.f53503y = new c();
        DownloadStatusIconManager.a aVar = DownloadStatusIconManager.f61047h;
        DownloadStatusIconManager downloadStatusIconManagerA = aVar.a();
        g00.e eVar = this.f53503y;
        Intrinsics.e(eVar, "null cannot be cast to non-null type com.transsnet.downloader.callback.OnDownloadIconStatusListener");
        downloadStatusIconManagerA.m(eVar);
        aVar.a().o();
    }

    public static final void R1(MovieDetailFragment this$0, View view) {
        FragmentActivity activity;
        Intrinsics.g(this$0, "this$0");
        if (this$0.D != null) {
            if (this$0.g2(FloatActionType.BACK) || (activity = this$0.getActivity()) == null) {
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

    public static final void V1(MovieDetailFragment this$0) {
        Subject subject;
        String subjectId;
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (subject = this$0.f53491m) == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        VideoFloatManager.f60019a.b().b(activity, subjectId, "subjectdetail");
    }

    private final void X1() {
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$observeAddToDownload$1
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
                Intrinsics.g(value, "value");
                try {
                    if (TextUtils.equals(value.getSubjectId(), this.this$0.f53495q) && this.this$0.f53489k != null) {
                        MovieDetailFragment.m2(this.this$0, 0, 1, null);
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    public static final void e2(MovieDetailFragment this$0, Subject this_apply, View view) {
        String url;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        IPublishApi iPublishApiJ1 = this$0.J1();
        if (iPublishApiJ1 != null) {
            Context context = view.getContext();
            Intrinsics.f(context, "it.context");
            String str = this$0.f53495q;
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
            iPublishApiJ1.k0(context, str, url, title, description == null ? "" : description, 3);
        }
        com.transsion.baselib.helper.a.f51183a.g("subjectdetail", "post", (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g2(FloatActionType floatActionType) {
        final FragmentActivity activity;
        Integer subjectType;
        Subject subject = this.f53491m;
        if (((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) != SubjectType.MUSIC.getValue() && (activity = getActivity()) != null && !activity.isDestroyed() && !activity.isFinishing()) {
            FloatActionType floatActionType2 = FloatActionType.ICON;
            if (floatActionType != floatActionType2 && !RoomAppMMKV.f51271a.a().getBoolean("k_pip_enable", true)) {
                uo.b.f78622a.c("VideoFloat", "设置页pip开关被关闭了", true);
                return false;
            }
            vz.a aVarE1 = E1();
            if (aVarE1 != null) {
                if (floatActionType != floatActionType2 && !aVarE1.e().isPlaying()) {
                    uo.b.f78622a.c("VideoFloat-pip", "movie 视频暂停，无需触发画中画", true);
                    return false;
                }
                VideoPipManager.Companion companion = VideoPipManager.f60024a;
                if (companion.a().b()) {
                    uo.b.f78622a.c("VideoFloat-pip", "movie 当前可用画中画，使用画中画播放", true);
                    companion.a().j(activity, aVarE1, floatActionType, this.K == LongVodUiType.LAND);
                    return true;
                }
                VideoFloatManager.f60019a.b().e(activity, aVarE1, floatActionType == floatActionType2, this.K == LongVodUiType.LAND, new Function1<Boolean, Unit>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$showFloat2Window$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z11) {
                        FragmentActivity fragmentActivity;
                        if (!z11 || (fragmentActivity = activity) == null) {
                            return;
                        }
                        fragmentActivity.finish();
                    }
                }, new f());
            }
        }
        return false;
    }

    public static /* synthetic */ void m2(MovieDetailFragment movieDetailFragment, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        movieDetailFragment.l2(i11);
    }

    public static final void o2(MovieDetailFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baselib.report.m.f51277a.x(MsgStyle.SOURCE_PUSH);
        this$0.C1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        HashMap<String, String> mapG;
        MovieDetailActivity.f53423s.a("movie_detail_fragment --> start load data ....");
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            String str = this.f53495q;
            if (str == null) {
                str = "";
            }
            mapG.put("subject_id", str);
        }
        Bundle arguments = getArguments();
        this.f53497s = arguments != null ? arguments.getString("ops") : null;
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            K0();
            String str2 = this.f53495q;
            if (str2 != null) {
                H1().q(str2);
            }
        }
    }

    public final void B1() {
        BubbleTextView bubbleTextView;
        ViewTreeObserver viewTreeObserver;
        tu.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f77483b) == null || (viewTreeObserver = bubbleTextView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    public final void C1() {
        List<ResourceDetectors> resourceDetectors;
        if (getContext() == null) {
            return;
        }
        D1();
        Subject subject = this.f53491m;
        String str = "";
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && (!resourceDetectors.isEmpty())) {
            String resourceLink = resourceDetectors.get(0).getResourceLink();
            str = resourceLink != null ? resourceLink : "";
            resourceDetectors.get(0).getResourceId();
            resourceDetectors.get(0).isMultiResolution();
        }
        String str2 = str;
        Subject subject2 = this.f53491m;
        if (subject2 != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context context = getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                Subject subject3 = this.f53491m;
                downloadManagerApiA.a2(fragmentActivity, "subjectdetail", (384 & 4) != 0 ? "" : "", subject3 != null ? subject3.getOps() : null, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : this.f53491m, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        DownloadManagerApi downloadManagerApiA2 = DownloadManagerApi.f60274j.a();
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        DownloadManagerApi.S1(downloadManagerApiA2, (FragmentActivity) context2, this.f53491m, "subjectdetail", "", "", str2, null, this.f53499u, null, false, this.B, false, 832, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        this.C = com.transsion.baselib.report.m.f51277a.f();
        Bundle arguments = getArguments();
        this.f53497s = arguments != null ? arguments.getString("ops") : null;
        Bundle arguments2 = getArguments();
        this.f53495q = arguments2 != null ? arguments2.getString("id") : null;
        Bundle arguments3 = getArguments();
        this.f53496r = arguments3 != null ? arguments3.getInt("subject_type", this.f53496r) : this.f53496r;
        Bundle arguments4 = getArguments();
        this.f53500v = arguments4 != null ? arguments4.getBoolean("auto_download") : false;
        Bundle arguments5 = getArguments();
        this.f53501w = arguments5 != null ? arguments5.getBoolean("auto_play") : false;
        Bundle arguments6 = getArguments();
        this.f53502x = arguments6 != null ? arguments6.getString("auto_play_resource_id") : null;
        Bundle arguments7 = getArguments();
        this.f53504z = arguments7 != null ? arguments7.getInt("yy_preload_id") : 0;
        MovieDetailViewModel movieDetailViewModelH1 = H1();
        int i11 = this.f53504z;
        String str = this.f53495q;
        if (str == null) {
            str = "";
        }
        movieDetailViewModelH1.C(i11, str);
        Bundle arguments8 = getArguments();
        this.f53499u = arguments8 != null ? arguments8.getString("module_name") : null;
        Bundle arguments9 = getArguments();
        this.B = arguments9 != null ? arguments9.getInt("season") : 1;
    }

    public final void D1() {
        BubbleTextView bubbleTextView;
        this.E = true;
        tu.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f77483b) == null) {
            return;
        }
        so.c.g(bubbleTextView);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        if (this.f53491m == null) {
            B0();
        }
    }

    public final vz.a E1() {
        String subjectId;
        kv.a aVar = this.D;
        com.transsion.player.orplayer.f player = aVar != null ? aVar.getPlayer() : null;
        kv.a aVar2 = this.D;
        ORPlayerView playerView = aVar2 != null ? aVar2.getPlayerView() : null;
        if (playerView == null || player == null) {
            return null;
        }
        uo.b.a aVar3 = uo.b.f78622a;
        Subject subject = this.f53491m;
        aVar3.c("VideoFloat", "trailer--showFloat, title:" + (subject != null ? subject.getTitle() : null), true);
        FloatPlayType floatPlayType = FloatPlayType.TRAILER;
        Subject subject2 = this.f53491m;
        if (subject2 == null || (subjectId = subject2.getSubjectId()) == null) {
            subjectId = "";
        }
        return new vz.a(playerView, player, null, floatPlayType, subjectId, 0, 0, "", "subjectdetail");
    }

    public final IMemberApi G1() {
        return (IMemberApi) this.I.getValue();
    }

    public final int I1() {
        return this.f53504z;
    }

    public final IPublishApi J1() {
        return (IPublishApi) this.f53494p.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public tu.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.h hVarC = tu.h.c(inflater);
        Intrinsics.f(hVarC, "inflate(inflater)");
        return hVarC;
    }

    public final void M1() {
        BubbleTextView bubbleTextView;
        tu.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f77483b) == null) {
            return;
        }
        bubbleTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieDetailFragment.N1(this.f53651a, view);
            }
        });
    }

    public final void O1() {
        Subject subject = this.f53491m;
        tu.h mViewBinding = getMViewBinding();
        MagicIndicator magicIndicator = mViewBinding != null ? mViewBinding.f77494n : null;
        tu.h mViewBinding2 = getMViewBinding();
        this.f53490l = new PlayDetailBottomRecHelper(this, subject, magicIndicator, mViewBinding2 != null ? mViewBinding2.f77495o : null, "subjectdetail", false, false, new Function1<Integer, Unit>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$initBottomRec$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                tu.h mViewBinding3 = this.this$0.getMViewBinding();
                DownloadView downloadView = mViewBinding3 != null ? mViewBinding3.f77485d : null;
                if (downloadView != null) {
                    downloadView.setVisibility(i11 != 1 ? 0 : 8);
                }
                tu.h mViewBinding4 = this.this$0.getMViewBinding();
                AppCompatImageView appCompatImageView = mViewBinding4 != null ? mViewBinding4.f77492l : null;
                if (appCompatImageView == null) {
                    return;
                }
                appCompatImageView.setVisibility(i11 == 1 ? 0 : 8);
            }
        }, 96, null);
    }

    public final void Q1() {
        String genre;
        SubjectGameInfo gameInfo;
        SubjectGameInfo gameInfo2;
        SubjectGameInfo gameInfo3;
        SubjectGameInfo gameInfo4;
        this.G = true;
        Subject subject = this.f53491m;
        String itemId = null;
        String type = (subject == null || (gameInfo4 = subject.getGameInfo()) == null) ? null : gameInfo4.getType();
        if (type != null && type.length() != 0) {
            Subject subject2 = this.f53491m;
            String itemId2 = (subject2 == null || (gameInfo3 = subject2.getGameInfo()) == null) ? null : gameInfo3.getItemId();
            if (itemId2 != null && itemId2.length() != 0) {
                uo.b.a.f(uo.b.f78622a, "GameResLoader", "sub detail game initGameRes", false, 4, null);
                Context context = getContext();
                if (context == null) {
                    return;
                }
                IGameResApi iGameResApi = (IGameResApi) com.alibaba.android.arouter.launcher.a.d().h(IGameResApi.class);
                Subject subject3 = this.f53491m;
                GameInfoType gameInfoType = (subject3 == null || (gameInfo2 = subject3.getGameInfo()) == null) ? null : gameInfo2.getGameInfoType();
                Intrinsics.d(gameInfoType);
                Subject subject4 = this.f53491m;
                if (subject4 != null && (gameInfo = subject4.getGameInfo()) != null) {
                    itemId = gameInfo.getItemId();
                }
                String str = itemId;
                Intrinsics.d(str);
                iGameResApi.f1(context, "subjectdetail", gameInfoType, str, new Function1<View, Unit>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$initGameRes$1
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
                        this.this$0.F = view;
                        if (view != null) {
                            this.this$0.h2();
                            return;
                        }
                        tu.h mViewBinding = this.this$0.getMViewBinding();
                        if (mViewBinding != null && (frameLayout2 = mViewBinding.f77490j) != null) {
                            so.c.g(frameLayout2);
                        }
                        tu.h mViewBinding2 = this.this$0.getMViewBinding();
                        if (mViewBinding2 == null || (frameLayout = mViewBinding2.f77490j) == null) {
                            return;
                        }
                        frameLayout.removeAllViews();
                    }
                });
                return;
            }
        }
        Subject subject5 = this.f53491m;
        if (subject5 == null || (genre = subject5.getGenre()) == null) {
            return;
        }
        String lowerCase = genre.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (lowerCase == null || !StringsKt__StringsKt.Q(lowerCase, "game", false, 2, null)) {
            return;
        }
        uo.b.a.j(uo.b.f78622a, "GameResLoader", "sub detail,  game is null", false, 4, null);
    }

    public final void S1() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        if (W1()) {
            ResourceDetectorFragment resourceDetectorFragment = new ResourceDetectorFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.f53491m);
            bundle.putString("ops", this.f53497s);
            bundle.putBoolean("auto_play", this.f53501w);
            bundle.putString("auto_play_resource_id", this.f53502x);
            bundle.putString("module_name", this.f53499u);
            bundle.putInt("season", this.B);
            resourceDetectorFragment.setArguments(bundle);
            fragmentTransactionBeginTransaction.replace(R$id.resourceDetectorGroup, resourceDetectorFragment);
        } else {
            ResourceDetectorEmptyFragment resourceDetectorEmptyFragment = new ResourceDetectorEmptyFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("data_key_resource_detectors", this.f53491m);
            resourceDetectorEmptyFragment.setArguments(bundle2);
            fragmentTransactionBeginTransaction.replace(R$id.resourceDetectorGroup, resourceDetectorEmptyFragment);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public final void T1(Subject subject) {
        String restrictLevel = subject.getRestrictLevel();
        if (restrictLevel == null || restrictLevel.length() == 0 || !RoomAppMMKV.f51271a.a().getBoolean("restrict_tips_dialog_again", true)) {
            return;
        }
        kv.a aVar = this.D;
        if (aVar != null) {
            aVar.onHandlePause();
        }
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sa_restrict_tips", false, 2, null);
        String value = configBeanC != null ? configBeanC.getValue() : null;
        if (value == null || value.length() == 0) {
            value = Utils.a().getString(R$string.movie_detail_restrict_tips);
        }
        final RestrictTipsDialog restrictTipsDialogA = RestrictTipsDialog.f53538j.a(value, "subjectdetail", subject.getSubjectId());
        restrictTipsDialogA.k0(this, "RestrictTipsDialog");
        restrictTipsDialogA.x0(new Function1<Boolean, Unit>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$initShowRestrictTips$1$1
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
                    kv.a aVar2 = this.D;
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

    public final void U1() {
        ConstraintLayout constraintLayoutB;
        tu.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayoutB = mViewBinding.getRoot()) == null) {
            return;
        }
        constraintLayoutB.post(new Runnable() { // from class: com.transsion.moviedetail.fragment.g
            @Override // java.lang.Runnable
            public final void run() {
                MovieDetailFragment.V1(this.f53648a);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void V() {
        super.V();
        uo.b.a.f(uo.b.f78622a, "VideoFloat", "onRecentClick onHomeClick", false, 4, null);
        g2(FloatActionType.HOME);
    }

    public final boolean W1() {
        Boolean hasResource;
        Subject subject = this.f53491m;
        if (subject == null || (hasResource = subject.getHasResource()) == null) {
            return false;
        }
        return hasResource.booleanValue();
    }

    public final void Y1(boolean z11) {
        String genre;
        Subject subject = this.f53491m;
        if (subject == null || (genre = subject.getGenre()) == null) {
            return;
        }
        String lowerCase = genre.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        if (lowerCase == null || !StringsKt__StringsKt.Q(lowerCase, "game", false, 2, null)) {
            return;
        }
        if (z11) {
            G1().z();
        } else {
            G1().Y();
        }
    }

    public final void Z1(LongVodUiType longVodUiType) {
        if (this.F == null || longVodUiType != LongVodUiType.MIDDLE) {
            return;
        }
        h2();
    }

    public final void a2(lv.a aVar) {
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_PLAY").withString("subject_id", this.f53495q);
        Subject subject = this.f53491m;
        if (subject != null && subject.getType() == 3 && aVar != null) {
            postcardWithString.withParcelable("TV_DATA", new FbTvData(aVar.m(), aVar.k(), aVar.d()));
        }
        postcardWithString.navigation();
    }

    public final void b2(Trailer trailer) {
        Subject subject;
        String averageHueLight;
        String thumbnail;
        String url;
        i2();
        String str = this.f53495q;
        if (str == null || (subject = this.f53491m) == null) {
            return;
        }
        PlayMimeType playMimeType = PlayMimeType.DEFAULT;
        long j11 = this.J;
        String title = subject.getTitle();
        String str2 = title == null ? "" : title;
        String str3 = this.C;
        String str4 = str3 == null ? "" : str3;
        List<lv.c> listL1 = L1(trailer);
        Cover cover = trailer.getCover();
        String str5 = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
        Cover cover2 = trailer.getCover();
        String str6 = (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail;
        Cover cover3 = subject.getCover();
        String str7 = (cover3 == null || (averageHueLight = cover3.getAverageHueLight()) == null) ? "" : averageHueLight;
        Integer durationSeconds = subject.getDurationSeconds();
        int iIntValue = durationSeconds != null ? durationSeconds.intValue() : 0;
        Integer subjectType = subject.getSubjectType();
        lv.a aVar = new lv.a(str, playMimeType, j11, 0, 0, str2, null, str4, "subjectdetail", listL1, str5, str6, str7, iIntValue, Integer.valueOf(subjectType != null ? subjectType.intValue() : 1), false, subject.getTitle(), subject.getOps(), 32832, null);
        aVar.v(this.f53491m);
        uo.b.f78622a.c("movie_detail_fragment -->", "playTrailer  addDataSource:" + aVar + "  playerControl:" + this.D, true);
        kv.a aVar2 = this.D;
        if (aVar2 != null) {
            aVar2.setDataSource(aVar);
        }
    }

    public final void c2() {
        kv.a aVar;
        com.transsion.videofloat.a aVar2 = com.transsion.videofloat.a.f60027a;
        kv.a aVar3 = this.D;
        if (!aVar2.c(aVar3 != null ? aVar3.getPlayer() : null) && (aVar = this.D) != null) {
            aVar.release();
        }
        kv.a aVar4 = this.D;
        if (aVar4 != null) {
            aVar4.onPageDestroy();
        }
    }

    public final void d2() {
        tu.h mViewBinding;
        AppCompatImageView appCompatImageView;
        final Subject subject = this.f53491m;
        if (subject == null || (mViewBinding = getMViewBinding()) == null || (appCompatImageView = mViewBinding.f77492l) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieDetailFragment.e2(this.f53658a, subject, view);
            }
        });
    }

    @Override // hv.a
    public void e0(Function0<Boolean> function0) {
        this.L = function0;
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0176  */
    /* JADX WARN: Code duplicated, block: B:70:0x0180  */
    /* JADX WARN: Code duplicated, block: B:74:0x0192  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:83:0x01be  */
    /* JADX WARN: Code duplicated, block: B:86:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:89:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    public final void f2(Subject subject) {
        StillsFragment stillsFragmentA;
        List<DownloadItem> items;
        int iF;
        Cover cover;
        String url;
        tu.h mViewBinding;
        ViewGroup.LayoutParams bVar;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        if (this.M != null || subject == null) {
            return;
        }
        ResourceDetectors resourceDetector = subject.getResourceDetector();
        String downloadUrl = resourceDetector != null ? resourceDetector.getDownloadUrl() : null;
        Integer subjectType = subject.getSubjectType();
        SubjectType subjectType2 = SubjectType.MUSIC;
        int value = subjectType2.getValue();
        if (subjectType == null || subjectType.intValue() != value || downloadUrl == null || downloadUrl.length() == 0) {
            Integer subjectType3 = subject.getSubjectType();
            SubjectType subjectType4 = SubjectType.EDUCATION;
            int value2 = subjectType4.getValue();
            if (subjectType3 == null || subjectType3.intValue() != value2) {
                Trailer trailer = subject.getTrailer();
                if (trailer != null) {
                    b2(trailer);
                    return;
                }
                Cover stills = subject.getStills();
                if (stills == null) {
                    stills = subject.getCover();
                }
                if (stills != null) {
                    stillsFragmentA = StillsFragment.f53548a.a(stills);
                }
            } else if (this.A) {
                DownloadListBean downloadListBeanF = H1().m().f();
                DownloadItem downloadItem = (downloadListBeanF == null || (items = downloadListBeanF.getItems()) == null) ? null : (DownloadItem) CollectionsKt___CollectionsKt.g0(items);
                if (downloadItem != null) {
                    Trailer trailer2 = new Trailer(0, null, null, null, null, 31, null);
                    Cover stills2 = subject.getStills();
                    if (stills2 == null) {
                        stills2 = subject.getCover();
                    }
                    trailer2.setCover(stills2);
                    trailer2.setSubjectType(subjectType4.getValue());
                    trailer2.setSubjectId(subject.getSubjectId());
                    Long duration = downloadItem.getDuration();
                    trailer2.setVideoAddress(new PreVideoAddress(0, null, duration != null ? Integer.valueOf((int) duration.longValue()) : null, 0, 0, downloadItem.getSize(), 0, downloadItem.getUrl(), null, 0));
                    b2(trailer2);
                    return;
                }
                Trailer trailer3 = subject.getTrailer();
                if (trailer3 != null) {
                    b2(trailer3);
                    return;
                }
                Cover stills3 = subject.getStills();
                if (stills3 == null) {
                    stills3 = subject.getCover();
                }
                if (stills3 != null) {
                    stillsFragmentA = StillsFragment.f53548a.a(stills3);
                }
            }
            if (stillsFragmentA != null) {
                this.M = stillsFragmentA;
                if (getMViewBinding() != null) {
                    iF = com.transsion.core.utils.e.f();
                    ImageHelper.Companion companion = ImageHelper.f51371a;
                    cover = subject.getCover();
                    if (cover != null || (url = cover.getUrl()) == null) {
                        url = "";
                    }
                    companion.e(url, (124 & 2) != 0 ? 0 : iF, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0);
                    mViewBinding = getMViewBinding();
                    if (mViewBinding != null || (frameLayout2 = mViewBinding.f77489i) == null) {
                        bVar = null;
                    } else {
                        bVar = frameLayout2.getLayoutParams();
                    }
                    if (bVar == null) {
                        bVar = new ConstraintLayout.b(iF, (iF * 9) / 16);
                    } else {
                        bVar.height = (iF * 9) / 16;
                    }
                    tu.h mViewBinding2 = getMViewBinding();
                    frameLayout = mViewBinding2 != null ? mViewBinding2.f77489i : null;
                    if (frameLayout != null) {
                        frameLayout.setLayoutParams(bVar);
                    }
                    FragmentManager childFragmentManager = getChildFragmentManager();
                    Intrinsics.f(childFragmentManager, "childFragmentManager");
                    FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
                    Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
                    int i11 = R$id.fl_player;
                    Fragment fragment = this.M;
                    Intrinsics.d(fragment);
                    fragmentTransactionBeginTransaction.replace(i11, fragment);
                    fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                }
            }
        }
        Integer durationSeconds = subject.getDurationSeconds();
        PreVideoAddress preVideoAddress = new PreVideoAddress(0, null, Integer.valueOf(durationSeconds != null ? durationSeconds.intValue() : 0), 0, 0, 0L, 0, downloadUrl, "", 0);
        Cover stills4 = subject.getStills();
        if (stills4 == null) {
            stills4 = subject.getCover();
        }
        Trailer trailer4 = new Trailer(subjectType2.getValue(), preVideoAddress, stills4, null, null, 24, null);
        trailer4.setSubjectId(subject.getSubjectId());
        trailer4.setMusicName(subject.getTitle());
        b2(trailer4);
        stillsFragmentA = null;
        if (stillsFragmentA != null) {
            this.M = stillsFragmentA;
            if (getMViewBinding() != null) {
                iF = com.transsion.core.utils.e.f();
                ImageHelper.Companion companion2 = ImageHelper.f51371a;
                cover = subject.getCover();
                if (cover != null) {
                    url = "";
                } else {
                    url = "";
                }
                companion2.e(url, (124 & 2) != 0 ? 0 : iF, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0);
                mViewBinding = getMViewBinding();
                if (mViewBinding != null) {
                    bVar = null;
                } else {
                    bVar = null;
                }
                if (bVar == null) {
                    bVar = new ConstraintLayout.b(iF, (iF * 9) / 16);
                } else {
                    bVar.height = (iF * 9) / 16;
                }
                tu.h mViewBinding3 = getMViewBinding();
                if (mViewBinding3 != null) {
                }
                if (frameLayout != null) {
                    frameLayout.setLayoutParams(bVar);
                }
                FragmentManager childFragmentManager2 = getChildFragmentManager();
                Intrinsics.f(childFragmentManager2, "childFragmentManager");
                FragmentTransaction fragmentTransactionBeginTransaction2 = childFragmentManager2.beginTransaction();
                Intrinsics.f(fragmentTransactionBeginTransaction2, "beginTransaction()");
                int i12 = R$id.fl_player;
                Fragment fragment2 = this.M;
                Intrinsics.d(fragment2);
                fragmentTransactionBeginTransaction2.replace(i12, fragment2);
                fragmentTransactionBeginTransaction2.commitAllowingStateLoss();
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void h() {
        super.h();
        uo.b.a.f(uo.b.f78622a, "VideoFloat", "StreamDetail onHomeClick", false, 4, null);
        g2(FloatActionType.HOME);
    }

    public final void h2() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        View view = this.F;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.F);
        }
        KeyEvent.Callback callback = this.F;
        ss.a aVar = callback instanceof ss.a ? (ss.a) callback : null;
        if (aVar != null) {
            aVar.setPageStyle("detail");
        }
        tu.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout3 = mViewBinding.f77490j) != null) {
            so.c.k(frameLayout3);
        }
        tu.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (frameLayout2 = mViewBinding2.f77490j) != null) {
            frameLayout2.removeAllViews();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        tu.h mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (frameLayout = mViewBinding3.f77490j) == null) {
            return;
        }
        frameLayout.addView(this.F, layoutParams);
    }

    public final void i2() {
        Context context;
        Integer subjectType;
        if (this.D == null && (context = getContext()) != null) {
            Subject subject = this.f53491m;
            LongVodPageType longVodPageType = ((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()) == SubjectType.MUSIC.getValue() ? LongVodPageType.MUSIC : LongVodPageType.TRAILER;
            tu.h mViewBinding = getMViewBinding();
            if (mViewBinding != null) {
                LongVodPlayerView longVodPlayerView = new LongVodPlayerView(context);
                String strName = longVodPageType.name();
                Subject subject2 = this.f53491m;
                kv.a.C0746a.a(longVodPlayerView, "subjectdetail", longVodPageType, strName + (subject2 != null ? subject2.getSubjectId() : null), mViewBinding.f77488h, mViewBinding.f77493m.f71219g, null, 32, null);
                Subject subject3 = this.f53491m;
                longVodPlayerView.initAdHelper(subject3 != null ? subject3.getGenre() : null);
                longVodPlayerView.setFeedBackVisible(true);
                this.D = longVodPlayerView;
                mViewBinding.f77489i.addView(longVodPlayerView);
            }
            Subject subject4 = this.f53491m;
            if (subject4 != null) {
                T1(subject4);
            }
            kv.a aVar = this.D;
            if (aVar != null) {
                aVar.setCallback(new g());
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        tu.h mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f77491k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MovieDetailFragment.R1(this.f53650a, view);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        MovieDetailViewModel movieDetailViewModelH1 = H1();
        movieDetailViewModelH1.r().j(this, new e(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$initViewModel$1$1

            /* JADX INFO: renamed from: com.transsion.moviedetail.fragment.MovieDetailFragment$initViewModel$1$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsion.moviedetail.fragment.MovieDetailFragment$initViewModel$1$1$1", f = "MovieDetailFragment.kt", l = {251}, m = "invokeSuspend")
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ MovieDetailFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(MovieDetailFragment movieDetailFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = movieDetailFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objE = kotlin.coroutines.intrinsics.a.e();
                    int i11 = this.label;
                    if (i11 == 0) {
                        ResultKt.b(obj);
                        this.label = 1;
                        if (kotlinx.coroutines.r0.a(1500L, this) == objE) {
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
                MovieDetailActivity.f53423s.a("movie_detail_fragment --> get movie detail data --> it = " + second);
                if (second == null) {
                    if (Intrinsics.b(pair.getFirst(), "404")) {
                        com.tn.lib.widget.toast.core.h.f50034a.k(R$string.movie_lost_content);
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
                MovieDetailViewModel movieDetailViewModelH2 = this.this$0.H1();
                String subjectId = second.getSubjectId();
                Integer subjectType = second.getSubjectType();
                Context context = this.this$0.getContext();
                MovieDetailViewModel.i(movieDetailViewModelH2, subjectId, subjectType, 0, context != null && com.transsion.baseui.util.b.a(context), 4, null);
                MovieDetailFragment movieDetailFragment = this.this$0;
                Integer subjectType2 = second.getSubjectType();
                movieDetailFragment.f53496r = subjectType2 != null ? subjectType2.intValue() : this.this$0.f53496r;
                this.this$0.F0();
                this.this$0.f53498t = true;
                this.this$0.n2(second);
                this.this$0.j2();
                com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.j(true);
                }
                com.transsion.baselib.report.h logViewConfig2 = this.this$0.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.m(this.this$0.f53497s);
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
                mapG.put("module_name", this.this$0.f53499u);
            }
        }));
        movieDetailViewModelH1.m().j(this, new e(new Function1<DownloadListBean, Unit>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$initViewModel$1$2
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
                this.this$0.A = true;
                Subject subject = this.this$0.f53491m;
                if (subject != null) {
                    Integer subjectType = subject.getSubjectType();
                    int value = SubjectType.EDUCATION.getValue();
                    if (subjectType != null && subjectType.intValue() == value) {
                        MovieDetailFragment movieDetailFragment = this.this$0;
                        movieDetailFragment.f2(movieDetailFragment.f53491m);
                    }
                }
            }
        }));
        movieDetailViewModelH1.u().j(this, new e(new Function1<Integer, Unit>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$initViewModel$1$3
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
                MovieDetailFragment movieDetailFragment = this.this$0;
                Intrinsics.f(season, "season");
                movieDetailFragment.B = season.intValue();
            }
        }));
        movieDetailViewModelH1.z().j(this, new e(new Function1<DubsInfo, Unit>() { // from class: com.transsion.moviedetail.fragment.MovieDetailFragment$initViewModel$1$4
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
                MovieDetailFragment movieDetailFragment = this.this$0;
                kv.a aVar = movieDetailFragment.D;
                movieDetailFragment.J = aVar != null ? aVar.currentPosition() : 0L;
                this.this$0.f53495q = dubsInfo.getSubjectId();
                this.this$0.f53491m = null;
                MovieDetailViewModel movieDetailViewModelH2 = this.this$0.H1();
                int iI1 = this.this$0.I1();
                String str = this.this$0.f53495q;
                if (str == null) {
                    str = "";
                }
                movieDetailViewModelH2.C(iI1, str);
                this.this$0.B0();
            }
        }));
    }

    public final void j2() {
        new com.transsion.play.detail.b(this, R$id.subjectDetailLayout, this.f53491m, "subjectdetail", this.f53499u, false, false, 96, null);
    }

    public final void k2() {
        BubbleTextView bubbleTextView;
        DownloadView downloadView;
        DownloadView downloadView2;
        BubbleTextView bubbleTextView2;
        if (y1() && (downloadView = this.f53489k) != null && downloadView.getVisibility() == 0 && (downloadView2 = this.f53489k) != null && downloadView2.getShowType() == 0) {
            tu.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (bubbleTextView2 = mViewBinding.f77483b) != null) {
                so.c.k(bubbleTextView2);
            }
            B1();
            return;
        }
        tu.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (bubbleTextView = mViewBinding2.f77483b) == null) {
            return;
        }
        so.c.g(bubbleTextView);
    }

    public final void l2(int i11) {
        HashMap<String, String> mapG;
        ResourceDetectors resourceDetector;
        List<ResourceDetectors> resourceDetectors;
        DownloadView downloadView = this.f53489k;
        if (downloadView != null) {
            downloadView.setVisibility(i11);
        }
        Subject subject = this.f53491m;
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && (!resourceDetectors.isEmpty())) {
            resourceDetectors.get(0).getResourceId();
            resourceDetectors.get(0).isMultiResolution();
        }
        Subject subject2 = this.f53491m;
        if (subject2 != null && (resourceDetector = subject2.getResourceDetector()) != null) {
            resourceDetector.getResourceId();
            resourceDetector.isMultiResolution();
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            mapG.put(CampaignEx.KEY_SHOW_TYPE, "download_subject");
        }
        k2();
    }

    public final void n2(Subject subject) {
        Subject subject2;
        this.f53491m = subject;
        if (!this.G) {
            Q1();
            Y1(true);
        }
        Subject subject3 = this.f53491m;
        String ops = subject3 != null ? subject3.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject2 = this.f53491m) != null) {
            subject2.setOps(this.f53497s);
        }
        f2(this.f53491m);
        O1();
        S1();
        if (this.f53489k == null) {
            z1();
            m2(this, 0, 1, null);
        }
        if (this.f53500v) {
            this.f53500v = false;
            DownloadView downloadView = this.f53489k;
            if (downloadView != null) {
                downloadView.post(new Runnable() { // from class: com.transsion.moviedetail.fragment.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        MovieDetailFragment.o2(this.f53654a);
                    }
                });
            }
        }
        d2();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("subjectdetail", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MovieDetailActivity.f53423s.a("movie_detail_fragment -->------- onCreate ------");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        g00.e eVar = this.f53503y;
        if (eVar != null) {
            DownloadStatusIconManager.f61047h.a().r(eVar);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.videofloat.a aVar = com.transsion.videofloat.a.f60027a;
        kv.a aVar2 = this.D;
        aVar.c(aVar2 != null ? aVar2.getPlayer() : null);
        Y1(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean z11) {
        super.onPictureInPictureModeChanged(z11);
        if (z11) {
            FragmentActivity activity = getActivity();
            if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            vz.a aVarE1 = E1();
            if (aVarE1 != null && Build.VERSION.SDK_INT >= 31) {
                VideoPipManager.f60024a.a().c(activity, aVarE1);
            }
        }
        VideoPipManager.f60024a.a().onPipModeChanged(z11);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        kv.a aVar = this.D;
        if (aVar != null) {
            aVar.onViewResume();
        }
        Y1(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        kv.a aVar;
        super.onStop();
        com.transsion.videofloat.a aVar2 = com.transsion.videofloat.a.f60027a;
        kv.a aVar3 = this.D;
        if (aVar2.c(aVar3 != null ? aVar3.getPlayer() : null) || (aVar = this.D) == null) {
            return;
        }
        aVar.onViewPause();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R$layout.default_movie_detail_skeleton_drawing_layout_2, (ViewGroup) o0(), false);
        ((AppCompatImageView) viewInflate.findViewById(R$id.ivBack)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieDetailFragment.F1(this.f53646a, view);
            }
        });
        return viewInflate;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        View view;
        tu.h mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (view = mViewBinding.f77499s) == null) ? null : view.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (bVar != null) {
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = com.blankj.utilcode.util.d.c();
        }
        tu.h mViewBinding2 = getMViewBinding();
        View view2 = mViewBinding2 != null ? mViewBinding2.f77499s : null;
        if (view2 != null) {
            view2.setLayoutParams(bVar);
        }
        requireActivity().getOnBackPressedDispatcher().i(this, new d());
        P1();
        X1();
        M1();
        U1();
    }

    public final boolean y1() {
        if (this.E) {
            return false;
        }
        return this.H.G0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean z0() {
        return true;
    }

    public final void z1() {
        if (W1()) {
            tu.h mViewBinding = getMViewBinding();
            DownloadView downloadView = mViewBinding != null ? mViewBinding.f77485d : null;
            this.f53489k = downloadView;
            if (downloadView != null) {
                downloadView.setPageFrom("subjectdetail");
            }
            DownloadView downloadView2 = this.f53489k;
            if (downloadView2 != null) {
                DownloadView.setAttrs$default(downloadView2, null, Float.valueOf(com.transsion.core.utils.e.g(16.0f)), null, 5, null);
            }
            DownloadView downloadView3 = this.f53489k;
            if (downloadView3 != null) {
                downloadView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MovieDetailFragment.A1(this.f53656a, view);
                    }
                });
            }
        }
    }
}
