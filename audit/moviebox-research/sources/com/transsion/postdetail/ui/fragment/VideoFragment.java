package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.tn.lib.pager.PagerLayoutManager;
import com.tn.lib.view.DefaultView;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.TnTextView;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.config.RenderType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.control.VideoPagerChangeControl;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.fragment.preload.VideoDataLoader;
import com.transsion.postdetail.ui.fragment.preload.VideoImmersiveDataLoaderV2;
import com.transsion.postdetail.ui.view.ImmVideoLoadMoreView;
import com.transsion.postdetail.ui.view.ImmVideoNoNetworkView;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.room.api.IAudioApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.sync.SyncManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
public final class VideoFragment extends BaseFragment<tv.o> implements su.e {
    public static final a A = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f55832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f55833d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f55834f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f55837i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f55839k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f55840l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f55841m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PagerLayoutManager f55842n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VideoPagerChangeControl f55843o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.transsion.postdetail.ui.adapter.b f55844p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.transsion.player.orplayer.f f55845q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ORPlayerView f55846r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f55847s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f55848t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f55849u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f55850v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f55851w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<String> f55852x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f55853y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public BiddingListManager f55854z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f55830a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f55831b = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f55835g = "1";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f55836h = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f55838j = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoFragment a(String str, String str2, Integer num, boolean z11, boolean z12, String str3, boolean z13, String str4, String str5, boolean z14) {
            int iC;
            VideoFragment videoFragment = new VideoFragment();
            if (str == null || str.length() == 0) {
                iC = lu.e.f70544a.c(new VideoImmersiveDataLoaderV2("0", "1", 5));
            } else {
                iC = lu.e.f70544a.c(new VideoDataLoader(str));
            }
            videoFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("id", str), TuplesKt.a("item_type", str2), TuplesKt.a("tab_id", num), TuplesKt.a("video_load_more", Boolean.valueOf(z11)), TuplesKt.a("from_comment", Boolean.valueOf(z12)), TuplesKt.a("rec_ops", str3), TuplesKt.a("attach_to_main", Boolean.valueOf(z13)), TuplesKt.a("yy_preload_id", Integer.valueOf(iC)), TuplesKt.a("comment_id", str4), TuplesKt.a(WebConstants.PAGE_FROM, str5), TuplesKt.a("need_back_to_room", Boolean.valueOf(z14))));
            return videoFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends androidx.activity.p {
        public b() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            if (VideoFragment.this.f55850v) {
                rw.e.b(rw.e.f75743a, null, null, 3, null);
            }
            FragmentActivity activity = VideoFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.tn.lib.util.networkinfo.g {
        public c() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            h9.f fVarQ;
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            if (VideoFragment.this.D0().l().f() == null) {
                VideoFragment.this.Q0();
                return;
            }
            com.transsion.postdetail.ui.adapter.b bVar = VideoFragment.this.f55844p;
            if (((bVar == null || (fVarQ = bVar.Q()) == null) ? null : fVarQ.i()) == LoadMoreStatus.Fail) {
                VideoFragment.this.R0();
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55857a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55857a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55857a;
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
            this.f55857a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.VideoFragment$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.VideoFragment$onDestroy$1", f = "VideoFragment.kt", l = {}, m = "invokeSuspend")
    public static final class C20171 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        int label;

        public C20171(Continuation<? super C20171> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VideoFragment.this.new C20171(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C20171) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            com.transsion.player.orplayer.f fVar = VideoFragment.this.f55845q;
            if (fVar != null) {
                fVar.stop();
            }
            com.transsion.player.orplayer.f fVar2 = VideoFragment.this.f55845q;
            if (fVar2 != null) {
                fVar2.release();
            }
            return Unit.f68710a;
        }
    }

    public VideoFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f55840l = FragmentViewModelLazyKt.a(this, Reflection.b(PostDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final androidx.lifecycle.x0 invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final androidx.lifecycle.v0.c invoke() {
                Object objInvoke = function0.invoke();
                androidx.lifecycle.m mVar = objInvoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) objInvoke : null;
                androidx.lifecycle.v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f55841m = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment$mAudioApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAudioApi invoke() {
                return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
            }
        });
        this.f55848t = true;
        this.f55851w = -1;
        this.f55852x = kotlin.collections.f.e(PostItemType.SUBJECT.getValue());
    }

    private final View A0(Context context) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        defaultView.setGravity(17);
        defaultView.setDefaultImageViewVisibility(0);
        defaultView.setDefaultImage(R$mipmap.ic_no_content);
        String string = context.getString(R$string.no_content);
        Intrinsics.f(string, "context.getString(com.tn…dget.R.string.no_content)");
        defaultView.setDescText(string);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.f(string2, "context.getString(com.tr…seui.R.string.retry_text)");
        defaultView.setBtnText(string2);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFragment.B0(this.f55870a, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    public static final void B0(VideoFragment this$0, DefaultView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.Q0();
        this_apply.setVisibility(8);
    }

    private final IAudioApi C0() {
        Object value = this.f55841m.getValue();
        Intrinsics.f(value, "<get-mAudioApi>(...)");
        return (IAudioApi) value;
    }

    private final View E0(Context context) {
        final ImmVideoNoNetworkView immVideoNoNetworkView = new ImmVideoNoNetworkView(context);
        so.c.e(immVideoNoNetworkView);
        immVideoNoNetworkView.retry(new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment$getNotNetErrorView$1$1
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
                so.c.g(immVideoNoNetworkView);
                this.Z0();
                this.Q0();
                com.tn.lib.view.l.b("postdetail_video");
            }
        });
        immVideoNoNetworkView.goToSetting(new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment$getNotNetErrorView$1$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tn.lib.view.l.c("postdetail_video");
            }
        });
        com.tn.lib.view.l.a("postdetail_video");
        return immVideoNoNetworkView;
    }

    private final void G0() {
        ProgressBar progressBar;
        tv.o mViewBinding = getMViewBinding();
        if (mViewBinding == null || (progressBar = mViewBinding.f77878c) == null) {
            return;
        }
        so.c.g(progressBar);
    }

    private final void H0() {
        BiddingListManager biddingListManager = new BiddingListManager();
        this.f55854z = biddingListManager;
        tv.o mViewBinding = getMViewBinding();
        biddingListManager.F(mViewBinding != null ? mViewBinding.f77879d : null);
        BiddingListManager biddingListManager2 = this.f55854z;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.lifecycle.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.f55854z;
        if (biddingListManager3 != null) {
            biddingListManager3.G("VideoForYouListScene");
        }
        BiddingListManager biddingListManager4 = this.f55854z;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment$initAd$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.transsion.ad.bidding.nativead.c cVar) {
                    invoke(num.intValue(), cVar);
                    return Unit.f68710a;
                }

                public final void invoke(int i11, com.transsion.ad.bidding.nativead.c current) {
                    List<PostSubjectItem> listD;
                    Intrinsics.g(current, "current");
                    if (current != null) {
                        VideoFragment videoFragment = this.this$0;
                        PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, null, false, null, false, 1073741823, null);
                        postSubjectItem.setNonAdDelegate(current);
                        com.transsion.postdetail.ui.adapter.b bVar = videoFragment.f55844p;
                        int size = (bVar == null || (listD = bVar.D()) == null) ? 0 : listD.size();
                        if (i11 <= size) {
                            com.transsion.postdetail.ui.adapter.b bVar2 = videoFragment.f55844p;
                            if (bVar2 != null) {
                                bVar2.j(i11, postSubjectItem);
                                return;
                            }
                            return;
                        }
                        com.transsion.postdetail.ui.adapter.b bVar3 = videoFragment.f55844p;
                        if (bVar3 != null) {
                            bVar3.j(size, postSubjectItem);
                        }
                    }
                }
            });
        }
    }

    private final void I0() {
        com.transsion.postdetail.ui.adapter.b bVar = new com.transsion.postdetail.ui.adapter.b(new ArrayList(), this, this.f55837i, this.f55830a, this.f55831b, this.f55849u, this.f55838j);
        bVar.Q().y(this.f55837i);
        if (this.f55837i) {
            bVar.Q().B(new ImmVideoLoadMoreView());
            bVar.Q().y(true);
            bVar.Q().x(true);
            bVar.Q().D(2);
            bVar.Q().C(new f9.f() { // from class: com.transsion.postdetail.ui.fragment.e1
                @Override // f9.f
                public final void a() {
                    VideoFragment.J0(this.f55877a);
                }
            });
        }
        this.f55844p = bVar;
    }

    public static final void J0(final VideoFragment this$0) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            tv.o mViewBinding = this$0.getMViewBinding();
            if (mViewBinding == null || (recyclerView = mViewBinding.f77879d) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.i1
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFragment.L0(this.f55891a);
                }
            }, 500L);
            return;
        }
        if (this$0.f55848t) {
            this$0.f55848t = false;
            this$0.R0();
            return;
        }
        tv.o mViewBinding2 = this$0.getMViewBinding();
        if (mViewBinding2 == null || (recyclerView2 = mViewBinding2.f77879d) == null) {
            return;
        }
        recyclerView2.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.h1
            @Override // java.lang.Runnable
            public final void run() {
                VideoFragment.K0(this.f55888a);
            }
        }, 500L);
    }

    public static final void K0(VideoFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.R0();
    }

    public static final void L0(VideoFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        this$0.f55847s = false;
        com.transsion.postdetail.ui.adapter.b bVar = this$0.f55844p;
        if (bVar == null || (fVarQ = bVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    private final void M0() {
        C0().pause();
    }

    private final void N0() {
        AppCompatImageView appCompatImageView;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView2;
        ConstraintLayout constraintLayout;
        tv.o mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (constraintLayout = mViewBinding.f77880f) == null) ? null : constraintLayout.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = com.blankj.utilcode.util.d.c();
        if (this.f55830a.length() == 0) {
            tv.o mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (appCompatImageView2 = mViewBinding2.f77877b) == null) {
                return;
            }
            so.c.g(appCompatImageView2);
            return;
        }
        tv.o mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (tnTextView = mViewBinding3.f77881g) != null) {
            so.c.g(tnTextView);
        }
        tv.o mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView = mViewBinding4.f77877b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.f1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFragment.O0(this.f55881a, view);
                }
            });
        }
        requireActivity().getOnBackPressedDispatcher().i(this, new b());
    }

    public static final void O0(VideoFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f55850v) {
            rw.e.b(rw.e.f75743a, null, null, 3, null);
        }
        this$0.requireActivity().finish();
    }

    private final void P0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0() {
        z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0() {
        Q0();
    }

    private final void S0() {
        HashMap<String, String> mapG;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        long jH = jElapsedRealtime - (logViewConfig != null ? logViewConfig.h() : 0L);
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null || (mapG = logViewConfig2.g()) == null) {
            return;
        }
        mapG.put("post_duration", String.valueOf(jH));
    }

    private final void T0() {
        D0().s().j(this, new d(new VideoFragment$observeRemoveVideo$1(this)));
    }

    private final void U0(final int i11) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List<PostSubjectItem> listD;
        com.transsion.postdetail.ui.adapter.b bVar = this.f55844p;
        if (((bVar == null || (listD = bVar.D()) == null) ? 0 : listD.size()) <= i11) {
            return;
        }
        tv.o mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView2 = mViewBinding.f77879d) != null) {
            recyclerView2.scrollToPosition(i11);
        }
        tv.o mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.f77879d) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.g1
            @Override // java.lang.Runnable
            public final void run() {
                VideoFragment.V0(this.f55884a, i11);
            }
        });
    }

    public static final void V0(VideoFragment this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        PagerLayoutManager pagerLayoutManager = this$0.f55842n;
        if (pagerLayoutManager != null) {
            View viewM = pagerLayoutManager.m();
            if (viewM != null) {
                uo.b.a.o(uo.b.f78622a, "ImmVideoPlayer", new String[]{"initView2， scrollToPosition ：" + i11}, false, 4, null);
                VideoPagerChangeControl videoPagerChangeControl = this$0.f55843o;
                if (videoPagerChangeControl != null) {
                    videoPagerChangeControl.d(i11, true, viewM);
                    return;
                }
                return;
            }
            int childCount = pagerLayoutManager.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = pagerLayoutManager.getChildAt(i12);
                if (childAt != null && pagerLayoutManager.getPosition(childAt) == i11) {
                    uo.b.a.o(uo.b.f78622a, "ImmVideoPlayer", new String[]{"initView， scrollToPosition ：" + i11}, false, 4, null);
                    VideoPagerChangeControl videoPagerChangeControl2 = this$0.f55843o;
                    if (videoPagerChangeControl2 != null) {
                        videoPagerChangeControl2.d(i11, true, childAt);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private final void W0(PostSubjectItem postSubjectItem) {
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        String mediaType;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.m(postSubjectItem.getRec_ops());
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG3 = logViewConfig3.g()) != null) {
            Media media = postSubjectItem.getMedia();
            if (media == null || (mediaType = media.getMediaType()) == null) {
                mediaType = "";
            }
            mapG3.put("post_media_type", mediaType);
        }
        com.transsion.baselib.report.h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (mapG2 = logViewConfig4.g()) != null) {
            Subject subject = postSubjectItem.getSubject();
            mapG2.put("subject_id", subject != null ? subject.getSubjectId() : null);
        }
        com.transsion.baselib.report.h logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 == null || (mapG = logViewConfig5.g()) == null) {
            return;
        }
        Subject subject2 = postSubjectItem.getSubject();
        mapG.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0() {
        com.transsion.postdetail.ui.adapter.b bVar;
        List<PostSubjectItem> listD;
        G0();
        com.transsion.postdetail.ui.adapter.b bVar2 = this.f55844p;
        if (bVar2 == null || (listD = bVar2.D()) == null || !(!listD.isEmpty())) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            View viewA0 = A0(contextRequireContext);
            if (viewA0 == null || (bVar = this.f55844p) == null) {
                return;
            }
            bVar.r0(viewA0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0() {
        com.transsion.postdetail.ui.adapter.b bVar;
        TnTextView tnTextView;
        List<PostSubjectItem> listD;
        G0();
        com.transsion.postdetail.ui.adapter.b bVar2 = this.f55844p;
        if (bVar2 == null || (listD = bVar2.D()) == null || !(!listD.isEmpty())) {
            tv.o mViewBinding = getMViewBinding();
            if (mViewBinding != null && (tnTextView = mViewBinding.f77881g) != null) {
                so.c.g(tnTextView);
            }
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            View viewE0 = E0(contextRequireContext);
            if (viewE0 == null || (bVar = this.f55844p) == null) {
                return;
            }
            bVar.r0(viewE0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0() {
        ProgressBar progressBar;
        tv.o mViewBinding = getMViewBinding();
        if (mViewBinding == null || (progressBar = mViewBinding.f77878c) == null) {
            return;
        }
        so.c.k(progressBar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(PostSubjectBean postSubjectBean) {
        String nextPage;
        com.transsion.postdetail.ui.adapter.b bVar;
        h9.f fVarQ;
        h9.f fVarQ2;
        com.transsion.postdetail.ui.adapter.b bVar2;
        h9.f fVarQ3;
        G0();
        Pager pager = postSubjectBean.getPager();
        if (pager == null || (nextPage = pager.getNextPage()) == null) {
            nextPage = "1";
        }
        this.f55835g = nextPage;
        List<PostSubjectItem> items = postSubjectBean.getItems();
        if (items != null) {
            Iterator<PostSubjectItem> it = items.iterator();
            while (it.hasNext()) {
                PostSubjectItem next = it.next();
                Media media = next.getMedia();
                if ((media != null ? media.getVideo() : null) != null) {
                    Media media2 = next.getMedia();
                    List<Video> video = media2 != null ? media2.getVideo() : null;
                    Intrinsics.d(video);
                    if (video.isEmpty()) {
                    }
                }
                it.remove();
            }
            com.transsion.postdetail.ui.adapter.b bVar3 = this.f55844p;
            List<PostSubjectItem> listD = bVar3 != null ? bVar3.D() : null;
            ArrayList arrayList = new ArrayList();
            if (listD == null || !(!listD.isEmpty())) {
                arrayList.addAll(items);
            } else {
                PostSubjectItem postSubjectItem = (PostSubjectItem) CollectionsKt___CollectionsKt.g0(listD);
                if (postSubjectItem != null) {
                    W0(postSubjectItem);
                }
                for (PostSubjectItem postSubjectItem2 : items) {
                    if (listD.contains(postSubjectItem2)) {
                        Subject subject = postSubjectItem2.getSubject();
                        if (subject != null) {
                            Integer subjectType = subject.getSubjectType();
                            int value = SubjectType.SHORT_TV.getValue();
                            if (subjectType != null && subjectType.intValue() == value) {
                            }
                        }
                        uo.b.a.f(uo.b.f78622a, "ImmVideoList", "find same item title..." + postSubjectItem2.getTitle() + " id  " + postSubjectItem2.getPostId(), false, 4, null);
                    }
                    arrayList.add(postSubjectItem2);
                }
            }
            com.transsion.postdetail.ui.adapter.b bVar4 = this.f55844p;
            if (bVar4 != null) {
                bVar4.m(arrayList);
            }
            VideoPagerChangeControl videoPagerChangeControl = this.f55843o;
            if (videoPagerChangeControl != null) {
                videoPagerChangeControl.i();
            }
            if (this.f55849u) {
                ImmVideoHelper immVideoHelperA = ImmVideoHelper.f55024g.a();
                com.transsion.postdetail.ui.adapter.b bVar5 = this.f55844p;
                immVideoHelperA.n(bVar5 != null ? bVar5.D() : null);
            }
        }
        com.transsion.postdetail.ui.adapter.b bVar6 = this.f55844p;
        if (bVar6 != null && (fVarQ2 = bVar6.Q()) != null && fVarQ2.q() && (bVar2 = this.f55844p) != null && (fVarQ3 = bVar2.Q()) != null) {
            fVarQ3.r();
        }
        Pager pager2 = postSubjectBean.getPager();
        if (pager2 != null && Intrinsics.b(pager2.getHasMore(), Boolean.FALSE) && (bVar = this.f55844p) != null && (fVarQ = bVar.Q()) != null) {
            h9.f.t(fVarQ, false, 1, null);
        }
        int i11 = this.f55851w;
        if (i11 >= 0) {
            U0(i11);
            this.f55851w = -1;
        }
    }

    private final void initPlayer() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        this.f55845q = new com.transsion.player.orplayer.f.a(contextRequireContext).b(new iv.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, true, false, false, false, null, 126975, null)).a();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        ORPlayerView oRPlayerView = new ORPlayerView(fragmentActivityRequireActivity, RenderType.TEXTURE_VIEW);
        this.f55846r = oRPlayerView;
        com.transsion.player.orplayer.f fVar = this.f55845q;
        if (fVar != null) {
            fVar.setTextureView(oRPlayerView.getTextureView());
        }
        com.transsion.player.orplayer.f fVar2 = this.f55845q;
        if (fVar2 != null) {
            fVar2.setLooping(true);
        }
    }

    private final void initViewModel() {
        D0().l().j(this, new d(new Function1<PostSubjectBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PostSubjectBean postSubjectBean) {
                invoke2(postSubjectBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PostSubjectBean postSubjectBean) {
                h9.f fVarQ;
                com.transsion.postdetail.ui.adapter.b bVar;
                h9.f fVarQ2;
                List<PostSubjectItem> listD;
                VideoFragment.this.f55847s = false;
                if (postSubjectBean != null) {
                    com.transsion.baselib.report.h logViewConfig = VideoFragment.this.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    VideoFragment.this.a1(postSubjectBean);
                    return;
                }
                com.transsion.postdetail.ui.adapter.b bVar2 = VideoFragment.this.f55844p;
                if (bVar2 != null && (listD = bVar2.D()) != null && listD.size() == 0) {
                    if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        VideoFragment.this.X0();
                        return;
                    } else {
                        VideoFragment.this.Y0();
                        return;
                    }
                }
                com.transsion.postdetail.ui.adapter.b bVar3 = VideoFragment.this.f55844p;
                if (bVar3 == null || (fVarQ = bVar3.Q()) == null || !fVarQ.q() || (bVar = VideoFragment.this.f55844p) == null || (fVarQ2 = bVar.Q()) == null) {
                    return;
                }
                fVarQ2.u();
            }
        }));
        D0().j().j(this, new d(new Function1<String, Unit>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (!TextUtils.equals("0", str)) {
                    zp.b.a aVar = zp.b.f82110a;
                    FragmentActivity activity = VideoFragment.this.getActivity();
                    aVar.e(activity != null ? activity.getString(com.transsion.postdetail.R$string.delete_post_failed) : null);
                } else {
                    SyncManager.f61414a.a().c(VideoFragment.this.f55830a);
                    FragmentActivity activity2 = VideoFragment.this.getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                    }
                }
            }
        }));
        if (this.f55849u) {
            ImmVideoHelper.f55024g.a().g().j(this, new d(new Function1<List<? extends PostSubjectItem>, Unit>() { // from class: com.transsion.postdetail.ui.fragment.VideoFragment.initViewModel.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends PostSubjectItem> list) {
                    invoke2((List<PostSubjectItem>) list);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<PostSubjectItem> list) {
                    List<PostSubjectItem> list2 = list;
                    if (list2 == null || list2.isEmpty()) {
                        VideoFragment.this.Z0();
                        VideoFragment.this.Q0();
                        return;
                    }
                    uo.b.a.f(uo.b.f78622a, "postdetail_video", "get cache " + list.get(0).getTitle(), false, 4, null);
                    VideoFragment.this.a1(new PostSubjectBean(CollectionsKt___CollectionsKt.M0(list), null, null, null));
                }
            }));
        }
    }

    private final void z0() {
        if (this.f55847s) {
            return;
        }
        this.f55847s = true;
        PostDetailViewModel postDetailViewModelD0 = D0();
        String str = this.f55830a;
        postDetailViewModelD0.k(str, this.f55832c, this.f55835g, this.f55836h, this.f55837i, (this.f55849u && (str == null || str.length() == 0)) ? 1 : 0);
    }

    public final PostDetailViewModel D0() {
        return (PostDetailViewModel) this.f55840l.getValue();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public tv.o getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tv.o oVarC = tv.o.c(inflater);
        Intrinsics.f(oVarC, "inflate(inflater)");
        return oVarC;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0030  */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        List<PostSubjectItem> listE;
        String nextPage;
        Intrinsics.g(view, "view");
        setNetListener(new c());
        initViewModel();
        PostSubjectBean postSubjectBeanR = D0().r();
        if (postSubjectBeanR == null) {
            listE = ImmVideoHelper.f55024g.a().e();
        } else {
            Pager pager = postSubjectBeanR.getPager();
            if (pager == null || (nextPage = pager.getNextPage()) == null) {
                nextPage = "1";
            }
            this.f55835g = nextPage;
            listE = postSubjectBeanR.getItems();
            if (listE == null) {
                listE = ImmVideoHelper.f55024g.a().e();
            }
        }
        if (listE.isEmpty()) {
            if (this.f55849u) {
                ImmVideoHelper.f55024g.a().l();
                return;
            } else {
                Z0();
                Q0();
                return;
            }
        }
        PostSubjectItem postSubjectItem = (PostSubjectItem) CollectionsKt___CollectionsKt.g0(listE);
        if (postSubjectItem != null) {
            W0(postSubjectItem);
        }
        com.transsion.postdetail.ui.adapter.b bVar = this.f55844p;
        if (bVar != null) {
            bVar.m(listE);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        HashMap<String, String> mapG;
        Intrinsics.g(view, "view");
        int i11 = bundle != null ? bundle.getInt("CURRENT_INDEX") : -1;
        this.f55851w = i11;
        uo.b.a.o(uo.b.f78622a, "ImmVideoPlayer", new String[]{"initView， savedCurrentIndex ：" + i11}, false, 4, null);
        H0();
        P0();
        I0();
        initPlayer();
        N0();
        M0();
        T0();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        this.f55842n = new PagerLayoutManager(fragmentActivityRequireActivity);
        VideoPagerChangeControl videoPagerChangeControl = new VideoPagerChangeControl(this, this.f55833d, this.f55844p, this.f55845q, this.f55846r, this.f55842n, this.f55839k);
        this.f55843o = videoPagerChangeControl;
        PagerLayoutManager pagerLayoutManager = this.f55842n;
        if (pagerLayoutManager != null) {
            pagerLayoutManager.p(videoPagerChangeControl);
        }
        tv.o mViewBinding = getMViewBinding();
        RecyclerView recyclerView = mViewBinding != null ? mViewBinding.f77879d : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(this.f55842n);
        }
        tv.o mViewBinding2 = getMViewBinding();
        RecyclerView recyclerView2 = mViewBinding2 != null ? mViewBinding2.f77879d : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f55844p);
        }
        ImmVideoHelper immVideoHelperA = ImmVideoHelper.f55024g.a();
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity2, "requireActivity()");
        immVideoHelperA.i(fragmentActivityRequireActivity2);
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.put(WebConstants.PAGE_FROM, this.f55839k);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.f55853y != 0) {
            FirebaseAnalyticsManager.f51235a.o("postdetail_video", Long.valueOf(SystemClock.elapsedRealtime() - this.f55853y), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.f55853y = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("postdetail_video", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "";
        }
        this.f55830a = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("comment_id") : null;
        if (string2 == null) {
            string2 = "";
        }
        this.f55838j = string2;
        Bundle arguments3 = getArguments();
        String string3 = arguments3 != null ? arguments3.getString("item_type") : null;
        this.f55831b = string3 != null ? string3 : "";
        Bundle arguments4 = getArguments();
        this.f55832c = arguments4 != null ? arguments4.getInt("tab_id") : 0;
        Bundle arguments5 = getArguments();
        this.f55837i = arguments5 != null ? arguments5.getBoolean("video_load_more", true) : true;
        Bundle arguments6 = getArguments();
        this.f55833d = arguments6 != null ? arguments6.getBoolean("from_comment") : false;
        Bundle arguments7 = getArguments();
        this.f55834f = arguments7 != null ? arguments7.getString("rec_ops") : null;
        Bundle arguments8 = getArguments();
        this.f55849u = arguments8 != null ? arguments8.getBoolean("attach_to_main") : false;
        Bundle arguments9 = getArguments();
        this.f55839k = arguments9 != null ? arguments9.getString(WebConstants.PAGE_FROM) : null;
        Bundle arguments10 = getArguments();
        this.f55850v = arguments10 != null ? arguments10.getBoolean("need_back_to_room") : false;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG3 = logViewConfig.g()) != null) {
            mapG3.put("base_post_id", this.f55830a);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG2 = logViewConfig2.g()) != null) {
            mapG2.put("post_id", this.f55830a);
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG = logViewConfig3.g()) != null) {
            mapG.put("attach_to_main", this.f55849u ? "0" : "1");
        }
        PostDetailViewModel postDetailViewModelD0 = D0();
        if (postDetailViewModelD0 != null) {
            Bundle arguments11 = getArguments();
            postDetailViewModelD0.u(arguments11 != null ? Integer.valueOf(arguments11.getInt("yy_preload_id")) : null);
        }
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).w(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.b()), null, null, new C20171(null), 3, null);
        ImmVideoHelper.f55024g.a().d();
        BiddingListManager biddingListManager = this.f55854z;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).V0(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                com.transsion.player.orplayer.f fVar = this.f55845q;
                if (fVar != null) {
                    fVar.pause();
                }
                logPause();
            } else {
                com.transsion.player.orplayer.f fVar2 = this.f55845q;
                if (fVar2 != null) {
                    fVar2.play();
                }
                logResume();
            }
            VideoPagerChangeControl videoPagerChangeControl = this.f55843o;
            if (videoPagerChangeControl != null) {
                videoPagerChangeControl.j(z11);
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // su.e
    public void onMemberStateChange() {
        uo.b.a.f(uo.b.f78622a, "co_mem", "VideoFragment --> onMemberStateChange() --> refresh list", false, 4, null);
        com.transsion.postdetail.ui.adapter.b bVar = this.f55844p;
        if (bVar != null) {
            bVar.w0(null);
        }
        Q0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        S0();
        super.onPause();
        com.transsion.baseui.activity.d.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.baseui.activity.d.p(null, this, "visible=" + isVisible(), 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        VideoPagerChangeControl videoPagerChangeControl = this.f55843o;
        outState.putInt("CURRENT_INDEX", videoPagerChangeControl != null ? videoPagerChangeControl.f() : 0);
    }
}
