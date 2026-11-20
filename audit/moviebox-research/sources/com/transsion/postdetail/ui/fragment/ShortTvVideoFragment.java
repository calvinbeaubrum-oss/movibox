package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.config.RenderType;
import com.transsion.player.shorttv.ORExoShortTvPlayer;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.control.SubjectVideoPagerChangeControl;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.postdetail.shorttv.config.Constants;
import com.transsion.postdetail.ui.fragment.preload.VideoImmersiveDataLoader;
import com.transsion.postdetail.ui.view.ImmVideoLoadMoreView;
import com.transsion.postdetail.ui.view.ImmVideoNoNetworkView;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import com.transsion.postdetail.viewmodel.ShortTvDetailViewModel;
import com.transsnet.flow.event.sync.SyncManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
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
public final class ShortTvVideoFragment extends BaseFragment<tv.s> implements su.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f55806v = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f55809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f55810d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f55811f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f55814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f55815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PagerLayoutManager f55816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SubjectVideoPagerChangeControl f55817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.transsion.postdetail.ui.adapter.g f55818m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.transsion.player.orplayer.f f55819n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ORPlayerView f55820o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f55821p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f55822q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f55823r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f55824s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f55825t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public BiddingListManager f55826u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f55807a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f55808b = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f55812g = "1";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f55813h = 5;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTvVideoFragment a(Context context, String str, String str2, Integer num, boolean z11, boolean z12, String str3, boolean z13) {
            String string;
            Intrinsics.g(context, "context");
            ShortTvVideoFragment shortTvVideoFragment = new ShortTvVideoFragment();
            shortTvVideoFragment.R0(context);
            ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
            immVideoRequestEntity.setPage("1");
            immVideoRequestEntity.setPerPage(5);
            immVideoRequestEntity.setSessionId(fp.b.f65208a.h());
            Uri uriA = com.transsion.baselib.report.o.f51281a.a();
            if (uriA == null || (string = uriA.toString()) == null) {
                string = "";
            }
            immVideoRequestEntity.setDeepLink(string);
            immVideoRequestEntity.setUserPrefer("");
            immVideoRequestEntity.setLatest_events(new ds.a(ds.b.f63534a.e()));
            immVideoRequestEntity.setPostId("0");
            immVideoRequestEntity.setTabId(num != null ? num.intValue() : 0);
            immVideoRequestEntity.setImmersiveRecType(1);
            shortTvVideoFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("id", str), TuplesKt.a("item_type", str2), TuplesKt.a("tab_id", num), TuplesKt.a("video_load_more", Boolean.valueOf(z11)), TuplesKt.a("from_comment", Boolean.valueOf(z12)), TuplesKt.a("rec_ops", str3), TuplesKt.a("attach_to_main", Boolean.valueOf(z13)), TuplesKt.a("yy_preload_id", Integer.valueOf(lu.e.f70544a.c(new VideoImmersiveDataLoader(immVideoRequestEntity))))));
            return shortTvVideoFragment;
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
            FragmentActivity activity = ShortTvVideoFragment.this.getActivity();
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
            if (ShortTvVideoFragment.this.C0().d().f() == null) {
                ShortTvVideoFragment.this.O0();
                return;
            }
            com.transsion.postdetail.ui.adapter.g gVar = ShortTvVideoFragment.this.f55818m;
            if (((gVar == null || (fVarQ = gVar.Q()) == null) ? null : fVarQ.i()) == LoadMoreStatus.Fail) {
                ShortTvVideoFragment.this.P0();
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
        public final /* synthetic */ Function1 f55829a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55829a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55829a;
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
            this.f55829a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$onDestroy$1", f = "ShortTvVideoFragment.kt", l = {}, m = "invokeSuspend")
    public static final class C20161 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        int label;

        public C20161(Continuation<? super C20161> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ShortTvVideoFragment.this.new C20161(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C20161) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            com.transsion.player.orplayer.f fVar = ShortTvVideoFragment.this.f55819n;
            if (fVar != null) {
                fVar.stop();
            }
            com.transsion.player.orplayer.f fVar2 = ShortTvVideoFragment.this.f55819n;
            if (fVar2 != null) {
                fVar2.release();
            }
            return Unit.f68710a;
        }
    }

    public ShortTvVideoFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f55815j = FragmentViewModelLazyKt.a(this, Reflection.b(ShortTvDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$special$$inlined$viewModels$default$2
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
        }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$special$$inlined$viewModels$default$3
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
        this.f55822q = true;
        this.f55824s = -1;
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
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvVideoFragment.B0(this.f55941a, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    public static final void B0(ShortTvVideoFragment this$0, DefaultView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.O0();
        this_apply.setVisibility(8);
    }

    private final void F0() {
    }

    private final void G0() {
        BiddingListManager biddingListManager = new BiddingListManager();
        this.f55826u = biddingListManager;
        tv.s mViewBinding = getMViewBinding();
        biddingListManager.F(mViewBinding != null ? mViewBinding.f77925d : null);
        BiddingListManager biddingListManager2 = this.f55826u;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.lifecycle.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.f55826u;
        if (biddingListManager3 != null) {
            biddingListManager3.G("VideoForYouListScene");
        }
        BiddingListManager biddingListManager4 = this.f55826u;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$initAd$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.transsion.ad.bidding.nativead.c cVar) {
                    invoke(num.intValue(), cVar);
                    return Unit.f68710a;
                }

                public final void invoke(int i11, com.transsion.ad.bidding.nativead.c current) {
                    List<Subject> listD;
                    Intrinsics.g(current, "current");
                    if (current != null) {
                        ShortTvVideoFragment shortTvVideoFragment = this.this$0;
                        Subject subject = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
                        subject.setNonAdDelegate(current);
                        com.transsion.postdetail.ui.adapter.g gVar = shortTvVideoFragment.f55818m;
                        int size = (gVar == null || (listD = gVar.D()) == null) ? 0 : listD.size();
                        if (i11 <= size) {
                            com.transsion.postdetail.ui.adapter.g gVar2 = shortTvVideoFragment.f55818m;
                            if (gVar2 != null) {
                                gVar2.j(i11, subject);
                                return;
                            }
                            return;
                        }
                        com.transsion.postdetail.ui.adapter.g gVar3 = shortTvVideoFragment.f55818m;
                        if (gVar3 != null) {
                            gVar3.j(size, subject);
                        }
                    }
                }
            });
        }
    }

    private final void H0() {
        com.transsion.postdetail.ui.adapter.g gVar = new com.transsion.postdetail.ui.adapter.g(new ArrayList(), this, this.f55807a, this.f55808b, this.f55823r);
        gVar.Q().y(this.f55814i);
        if (this.f55814i) {
            gVar.Q().B(new ImmVideoLoadMoreView());
            gVar.Q().y(true);
            gVar.Q().x(true);
            gVar.Q().D(2);
            gVar.Q().C(new f9.f() { // from class: com.transsion.postdetail.ui.fragment.y0
                @Override // f9.f
                public final void a() {
                    ShortTvVideoFragment.I0(this.f55947a);
                }
            });
        }
        this.f55818m = gVar;
    }

    public static final void I0(final ShortTvVideoFragment this$0) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            tv.s mViewBinding = this$0.getMViewBinding();
            if (mViewBinding == null || (recyclerView = mViewBinding.f77925d) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.b1
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvVideoFragment.K0(this.f55863a);
                }
            }, 500L);
            return;
        }
        if (this$0.f55822q) {
            this$0.f55822q = false;
            this$0.P0();
            return;
        }
        tv.s mViewBinding2 = this$0.getMViewBinding();
        if (mViewBinding2 == null || (recyclerView2 = mViewBinding2.f77925d) == null) {
            return;
        }
        recyclerView2.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.a1
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvVideoFragment.J0(this.f55860a);
            }
        }, 500L);
    }

    public static final void J0(ShortTvVideoFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.P0();
    }

    public static final void K0(ShortTvVideoFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        this$0.f55821p = false;
        com.transsion.postdetail.ui.adapter.g gVar = this$0.f55818m;
        if (gVar == null || (fVarQ = gVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    public static final void M0(ShortTvVideoFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0() {
        z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0() {
        O0();
    }

    private final void S0(final int i11) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List<Subject> listD;
        com.transsion.postdetail.ui.adapter.g gVar = this.f55818m;
        if (((gVar == null || (listD = gVar.D()) == null) ? 0 : listD.size()) <= i11) {
            return;
        }
        tv.s mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView2 = mViewBinding.f77925d) != null) {
            recyclerView2.scrollToPosition(i11);
        }
        tv.s mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.f77925d) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.x0
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvVideoFragment.T0(this.f55944a, i11);
            }
        });
    }

    public static final void T0(ShortTvVideoFragment this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        PagerLayoutManager pagerLayoutManager = this$0.f55816k;
        if (pagerLayoutManager != null) {
            View viewM = pagerLayoutManager.m();
            if (viewM != null) {
                uo.b.a.o(uo.b.f78622a, "ShortTvImmVideoPlayer", new String[]{"initView2， scrollToPosition ：" + i11}, false, 4, null);
                SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this$0.f55817l;
                if (subjectVideoPagerChangeControl != null) {
                    subjectVideoPagerChangeControl.d(i11, true, viewM);
                    return;
                }
                return;
            }
            int childCount = pagerLayoutManager.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = pagerLayoutManager.getChildAt(i12);
                if (childAt != null && pagerLayoutManager.getPosition(childAt) == i11) {
                    uo.b.a.o(uo.b.f78622a, "ShortTvImmVideoPlayer", new String[]{"initView， scrollToPosition ：" + i11}, false, 4, null);
                    SubjectVideoPagerChangeControl subjectVideoPagerChangeControl2 = this$0.f55817l;
                    if (subjectVideoPagerChangeControl2 != null) {
                        subjectVideoPagerChangeControl2.d(i11, true, childAt);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0() {
        com.transsion.postdetail.ui.adapter.g gVar;
        List<Subject> listD;
        F0();
        com.transsion.postdetail.ui.adapter.g gVar2 = this.f55818m;
        if (gVar2 == null || (listD = gVar2.D()) == null || !(!listD.isEmpty())) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            View viewA0 = A0(contextRequireContext);
            if (viewA0 == null || (gVar = this.f55818m) == null) {
                return;
            }
            gVar.r0(viewA0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0() {
        com.transsion.postdetail.ui.adapter.g gVar;
        List<Subject> listD;
        F0();
        com.transsion.postdetail.ui.adapter.g gVar2 = this.f55818m;
        if (gVar2 == null || (listD = gVar2.D()) == null || !(!listD.isEmpty())) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            View viewD0 = D0(contextRequireContext);
            if (viewD0 == null || (gVar = this.f55818m) == null) {
                return;
            }
            gVar.r0(viewD0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initPlayer() {
        com.transsion.player.orplayer.f fVarA;
        Constants constants = Constants.f55400a;
        int i11 = 1;
        if (constants.a()) {
            fVarA = new ORExoShortTvPlayer(null, i11, 0 == true ? 1 : 0);
            fVarA.setLooping(true);
            fVarA.prepare();
            fVarA.play();
        } else {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            fVarA = new com.transsion.player.orplayer.f.a(contextRequireContext).b(new iv.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, true, false, false, false, null, 126975, null)).a();
        }
        this.f55819n = fVarA;
        if (constants.a()) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            ORPlayerView oRPlayerView = new ORPlayerView(fragmentActivityRequireActivity, RenderType.SURFACE_VIEW);
            this.f55820o = oRPlayerView;
            com.transsion.player.orplayer.f fVar = this.f55819n;
            if (fVar != null) {
                fVar.setSurfaceView(oRPlayerView.getSurface());
            }
        } else {
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity2, "requireActivity()");
            ORPlayerView oRPlayerView2 = new ORPlayerView(fragmentActivityRequireActivity2, RenderType.TEXTURE_VIEW);
            this.f55820o = oRPlayerView2;
            com.transsion.player.orplayer.f fVar2 = this.f55819n;
            if (fVar2 != null) {
                fVar2.setTextureView(oRPlayerView2.getTextureView());
            }
        }
        com.transsion.player.orplayer.f fVar3 = this.f55819n;
        if (fVar3 != null) {
            fVar3.setLooping(true);
        }
    }

    private final void initViewModel() {
        C0().d().j(this, new d(new Function1<ShortTVRespData, Unit>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShortTVRespData shortTVRespData) {
                invoke2(shortTVRespData);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ShortTVRespData shortTVRespData) {
                h9.f fVarQ;
                com.transsion.postdetail.ui.adapter.g gVar;
                h9.f fVarQ2;
                List<Subject> listD;
                ShortTvVideoFragment.this.f55821p = false;
                if (shortTVRespData != null) {
                    ShortTvVideoFragment.this.X0(shortTVRespData);
                    return;
                }
                com.transsion.postdetail.ui.adapter.g gVar2 = ShortTvVideoFragment.this.f55818m;
                if (gVar2 != null && (listD = gVar2.D()) != null && listD.size() == 0) {
                    if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        ShortTvVideoFragment.this.U0();
                        return;
                    } else {
                        ShortTvVideoFragment.this.V0();
                        return;
                    }
                }
                com.transsion.postdetail.ui.adapter.g gVar3 = ShortTvVideoFragment.this.f55818m;
                if (gVar3 == null || (fVarQ = gVar3.Q()) == null || !fVarQ.q() || (gVar = ShortTvVideoFragment.this.f55818m) == null || (fVarQ2 = gVar.Q()) == null) {
                    return;
                }
                fVarQ2.u();
            }
        }));
        C0().b().j(this, new d(new Function1<String, Unit>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment.initViewModel.2
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
                    FragmentActivity activity = ShortTvVideoFragment.this.getActivity();
                    aVar.e(activity != null ? activity.getString(com.transsion.postdetail.R$string.delete_post_failed) : null);
                } else {
                    SyncManager.f61414a.a().c(ShortTvVideoFragment.this.f55807a);
                    FragmentActivity activity2 = ShortTvVideoFragment.this.getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                    }
                }
            }
        }));
        if (this.f55823r) {
            ShortTvImmVideoHelper.f55051k.a().l().j(this, new d(new Function1<List<? extends Subject>, Unit>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment.initViewModel.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends Subject> list) {
                    invoke2(list);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends Subject> list) {
                    List<? extends Subject> list2 = list;
                    if (list2 != null && !list2.isEmpty()) {
                        ShortTvVideoFragment.this.X0(new ShortTVRespData(CollectionsKt___CollectionsKt.M0(list2), null, false));
                    } else {
                        ShortTvVideoFragment.this.W0();
                        ShortTvVideoFragment.this.O0();
                    }
                }
            }));
        }
    }

    public final ShortTvDetailViewModel C0() {
        return (ShortTvDetailViewModel) this.f55815j.getValue();
    }

    public final View D0(Context context) {
        final ImmVideoNoNetworkView immVideoNoNetworkView = new ImmVideoNoNetworkView(context);
        so.c.e(immVideoNoNetworkView);
        immVideoNoNetworkView.retry(new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$getNotNetErrorView$1$1
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
                this.W0();
                this.O0();
                com.tn.lib.view.l.b("shorttv_detail_video");
            }
        });
        immVideoNoNetworkView.goToSetting(new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.ShortTvVideoFragment$getNotNetErrorView$1$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tn.lib.view.l.c("shorttv_detail_video");
            }
        });
        com.tn.lib.view.l.a("shorttv_detail_video");
        return immVideoNoNetworkView;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public tv.s getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tv.s sVarC = tv.s.c(inflater);
        Intrinsics.f(sVarC, "inflate(inflater)");
        return sVarC;
    }

    public final void L0() {
        AppCompatImageView appCompatImageView;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView2;
        ConstraintLayout constraintLayout;
        tv.s mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (constraintLayout = mViewBinding.f77926f) == null) ? null : constraintLayout.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = com.blankj.utilcode.util.d.c();
        if (this.f55807a.length() == 0) {
            tv.s mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (appCompatImageView2 = mViewBinding2.f77923b) == null) {
                return;
            }
            so.c.g(appCompatImageView2);
            return;
        }
        tv.s mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (tnTextView = mViewBinding3.f77927g) != null) {
            so.c.g(tnTextView);
        }
        tv.s mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView = mViewBinding4.f77923b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTvVideoFragment.M0(this.f55948a, view);
                }
            });
        }
        requireActivity().getOnBackPressedDispatcher().i(this, new b());
    }

    public final void N0() {
    }

    public final void Q0() {
        C0().g().j(this, new d(new ShortTvVideoFragment$observeRemoveVideo$1(this)));
    }

    public final void R0(Context context) {
        ShortTvImmVideoHelper.f55051k.a().s(context);
    }

    public final void X0(ShortTVRespData shortTVRespData) {
        String nextPage;
        com.transsion.postdetail.ui.adapter.g gVar;
        h9.f fVarQ;
        h9.f fVarQ2;
        com.transsion.postdetail.ui.adapter.g gVar2;
        h9.f fVarQ3;
        String url;
        Media video;
        F0();
        Pager pager = shortTVRespData.getPager();
        if (pager == null || (nextPage = pager.getNextPage()) == null) {
            nextPage = "1";
        }
        this.f55812g = nextPage;
        List<Subject> items = shortTVRespData.getItems();
        if (items != null) {
            Iterator<Subject> it = items.iterator();
            while (it.hasNext()) {
                Subject next = it.next();
                ShortTVItem shortTVFirstEp = next.getShortTVFirstEp();
                if (((shortTVFirstEp == null || (video = shortTVFirstEp.getVideo()) == null) ? null : video.getVideoAddress()) != null) {
                    ShortTVItem shortTVFirstEp2 = next.getShortTVFirstEp();
                    Media video2 = shortTVFirstEp2 != null ? shortTVFirstEp2.getVideo() : null;
                    Intrinsics.d(video2);
                    Video videoAddress = video2.getVideoAddress();
                    if (videoAddress == null || (url = videoAddress.getUrl()) == null || url.length() != 0) {
                    }
                }
                it.remove();
            }
            com.transsion.postdetail.ui.adapter.g gVar3 = this.f55818m;
            List<Subject> listD = gVar3 != null ? gVar3.D() : null;
            ArrayList arrayList = new ArrayList();
            if (listD == null || !(!listD.isEmpty())) {
                arrayList.addAll(items);
            } else {
                Iterator<Subject> it2 = items.iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.f55817l;
            if (subjectVideoPagerChangeControl != null) {
                subjectVideoPagerChangeControl.e(arrayList);
            }
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl2 = this.f55817l;
            if (subjectVideoPagerChangeControl2 != null) {
                subjectVideoPagerChangeControl2.m();
            }
            if (this.f55823r) {
                ShortTvImmVideoHelper shortTvImmVideoHelperA = ShortTvImmVideoHelper.f55051k.a();
                com.transsion.postdetail.ui.adapter.g gVar4 = this.f55818m;
                shortTvImmVideoHelperA.w(gVar4 != null ? gVar4.D() : null);
            }
        }
        com.transsion.postdetail.ui.adapter.g gVar5 = this.f55818m;
        if (gVar5 != null && (fVarQ2 = gVar5.Q()) != null && fVarQ2.q() && (gVar2 = this.f55818m) != null && (fVarQ3 = gVar2.Q()) != null) {
            fVarQ3.r();
        }
        Pager pager2 = shortTVRespData.getPager();
        if (pager2 != null && Intrinsics.b(pager2.getHasMore(), Boolean.FALSE) && (gVar = this.f55818m) != null && (fVarQ = gVar.Q()) != null) {
            h9.f.t(fVarQ, false, 1, null);
        }
        int i11 = this.f55824s;
        if (i11 >= 0) {
            S0(i11);
            this.f55824s = -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0030  */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        List<Subject> listI;
        String nextPage;
        Intrinsics.g(view, "view");
        setNetListener(new c());
        initViewModel();
        ShortTVRespData shortTVRespDataF = C0().f();
        if (shortTVRespDataF == null) {
            listI = ShortTvImmVideoHelper.f55051k.a().i();
        } else {
            Pager pager = shortTVRespDataF.getPager();
            if (pager == null || (nextPage = pager.getNextPage()) == null) {
                nextPage = "1";
            }
            this.f55812g = nextPage;
            listI = shortTVRespDataF.getItems();
            if (listI == null) {
                listI = ShortTvImmVideoHelper.f55051k.a().i();
            }
        }
        if (!listI.isEmpty()) {
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.f55817l;
            if (subjectVideoPagerChangeControl != null) {
                subjectVideoPagerChangeControl.e(listI);
                return;
            }
            return;
        }
        if (this.f55823r) {
            ShortTvImmVideoHelper.f55051k.a().q();
        } else {
            W0();
            O0();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        RecyclerView recyclerView;
        Intrinsics.g(view, "view");
        int i11 = bundle != null ? bundle.getInt("CURRENT_INDEX") : -1;
        this.f55824s = i11;
        uo.b.a.o(uo.b.f78622a, "ShortTvImmVideoPlayer", new String[]{"initView， savedCurrentIndex ：" + i11}, false, 4, null);
        G0();
        N0();
        H0();
        initPlayer();
        L0();
        Q0();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        this.f55816k = new PagerLayoutManager(fragmentActivityRequireActivity);
        SubjectVideoPagerChangeControl aVar = Constants.f55400a.a() ? new com.transsion.postdetail.control.a(this, this.f55818m, this.f55819n, this.f55820o, this.f55816k) : new SubjectVideoPagerChangeControl(this, this.f55818m, this.f55819n, this.f55820o, this.f55816k);
        this.f55817l = aVar;
        PagerLayoutManager pagerLayoutManager = this.f55816k;
        if (pagerLayoutManager != null) {
            pagerLayoutManager.p(aVar);
        }
        tv.s mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f77925d) != null) {
            recyclerView.setLayoutManager(this.f55816k);
            recyclerView.setAdapter(this.f55818m);
            recyclerView.setHasFixedSize(true);
        }
        ShortTvImmVideoHelper shortTvImmVideoHelperA = ShortTvImmVideoHelper.f55051k.a();
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity2, "requireActivity()");
        shortTvImmVideoHelperA.n(fragmentActivityRequireActivity2);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.f55825t != 0) {
            FirebaseAnalyticsManager.f51235a.o("shorttv_detail_video", Long.valueOf(SystemClock.elapsedRealtime() - this.f55825t), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.f55825t = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("shorttv_detail_video", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "";
        }
        this.f55807a = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("item_type") : null;
        this.f55808b = string2 != null ? string2 : "";
        Bundle arguments3 = getArguments();
        this.f55809c = arguments3 != null ? arguments3.getInt("tab_id") : 0;
        Bundle arguments4 = getArguments();
        this.f55814i = arguments4 != null ? arguments4.getBoolean("video_load_more", true) : true;
        Bundle arguments5 = getArguments();
        this.f55810d = arguments5 != null ? arguments5.getBoolean("from_comment") : false;
        Bundle arguments6 = getArguments();
        this.f55811f = arguments6 != null ? arguments6.getString("rec_ops") : null;
        Bundle arguments7 = getArguments();
        this.f55823r = arguments7 != null ? arguments7.getBoolean("attach_to_main") : false;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG2 = logViewConfig.g()) != null) {
            mapG2.put("base_post_id", this.f55807a);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG = logViewConfig2.g()) != null) {
            mapG.put("attach_to_main", this.f55823r ? "0" : "1");
        }
        ShortTvDetailViewModel shortTvDetailViewModelC0 = C0();
        if (shortTvDetailViewModelC0 != null) {
            Bundle arguments8 = getArguments();
            shortTvDetailViewModelC0.h(arguments8 != null ? Integer.valueOf(arguments8.getInt("yy_preload_id")) : null);
        }
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).w(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.b()), null, null, new C20161(null), 3, null);
        ShortTvImmVideoHelper.f55051k.a().h();
        BiddingListManager biddingListManager = this.f55826u;
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
                com.transsion.player.orplayer.f fVar = this.f55819n;
                if (fVar != null) {
                    fVar.pause();
                }
                logPause();
            } else {
                com.transsion.player.orplayer.f fVar2 = this.f55819n;
                if (fVar2 != null) {
                    fVar2.play();
                }
                logResume();
            }
            SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.f55817l;
            if (subjectVideoPagerChangeControl != null) {
                subjectVideoPagerChangeControl.n(z11);
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // su.e
    public void onMemberStateChange() {
        uo.b.a.f(uo.b.f78622a, "co_mem", "VideoFragment --> onMemberStateChange() --> refresh list", false, 4, null);
        com.transsion.postdetail.ui.adapter.g gVar = this.f55818m;
        if (gVar != null) {
            gVar.w0(null);
        }
        O0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
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
        SubjectVideoPagerChangeControl subjectVideoPagerChangeControl = this.f55817l;
        outState.putInt("CURRENT_INDEX", subjectVideoPagerChangeControl != null ? subjectVideoPagerChangeControl.g() : 0);
    }

    public final void z0() {
        if (this.f55821p) {
            return;
        }
        this.f55821p = true;
        C0().c(this.f55807a, this.f55809c, this.f55812g, this.f55813h, 1);
    }
}
