package com.transsion.shorttv;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.pager.PagerLayoutManager;
import com.tn.lib.view.DefaultView;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.l;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.video.ShortTVPlayBean;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.m;
import com.transsion.baselib.utils.DeviceKeyMonitor;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.BaseLoadMoreView;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.MediaSource;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.shorttv.ORExoShortTvPlayer;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.shorttv.episode.ShortTvEpisodeListDialog;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import com.transsion.shorttv.utils.ShortTVFloatManager;
import com.transsion.shorttv.widget.ImmVideoHelper;
import com.transsion.shorttv.widget.ShortTvVideoItemView;
import com.transsion.videofloat.VideoFloatManager;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import rx.i;

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
public abstract class ShortTvBaseListFragment extends BaseFragment<nx.b> implements com.transsion.player.orplayer.e {
    public DeviceKeyMonitor B;
    public com.transsion.player.helper.g C;
    public final b D;
    public long E;
    public PlayError F;
    public final tr.g G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ShortTvEpisodeListDialog f57763a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f57766d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Subject f57768g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f57770i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f57771j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f57772k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PagerLayoutManager f57774m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.transsion.shorttv.widget.c f57775n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g f57776o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.transsion.player.shorttv.b f57777p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ORPlayerView f57778q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f57780s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f57781t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f57782u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f57785x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f57786y;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f57764b = "key_shorttv_float_permission";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f57765c = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f57767f = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f57769h = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f57773l = FragmentViewModelLazyKt.a(this, Reflection.b(ShortTvViewModel.class), new Function0<x0>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<v0.c>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f57779r = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f57783v = "ShortTvListFragment";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f57784w = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f57787z = LazyKt__LazyJVMKt.b(new Function0<com.transsion.player.shorttv.preload.g>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment$videoPreloadHelper$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.player.shorttv.preload.g invoke() {
            Context contextRequireContext = this.this$0.requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            return new com.transsion.player.shorttv.preload.g(contextRequireContext);
        }
    });
    public final Lazy A = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.manager.a invoke() {
            return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.tn.lib.util.networkinfo.g {
        public a() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            com.transsion.player.shorttv.b bVar;
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            Log.e(ShortTvBaseListFragment.this.f57783v, "onConnected");
            ShortTvBaseListFragment.this.c1();
            ShortTvBaseListFragment.this.D0();
            if (ShortTvBaseListFragment.this.F == null || (bVar = ShortTvBaseListFragment.this.f57777p) == null) {
                return;
            }
            bVar.prepare();
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
            Log.e(ShortTvBaseListFragment.this.f57783v, "onDisconnected");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f57789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f57790b;

        public b(Looper looper) {
            super(looper);
            this.f57789a = 1;
            this.f57790b = 300L;
        }

        public final long a() {
            return this.f57790b;
        }

        public final int b() {
            return this.f57789a;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            nx.b mViewBinding;
            ProgressBar progressBar;
            Intrinsics.g(msg, "msg");
            super.handleMessage(msg);
            if (msg.what != this.f57789a || (mViewBinding = ShortTvBaseListFragment.this.getMViewBinding()) == null || (progressBar = mViewBinding.f72176b) == null) {
                return;
            }
            so.c.k(progressBar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements DeviceKeyMonitor.b {
        public c() {
        }

        @Override // com.transsion.baselib.utils.DeviceKeyMonitor.b
        public void V() {
            uo.b.f78622a.c("VideoFloat-pip", "shottv onRecentClick", true);
            ShortTvBaseListFragment.this.m1();
        }

        @Override // com.transsion.baselib.utils.DeviceKeyMonitor.b
        public void h() {
            uo.b.f78622a.c("VideoFloat-pip", "shottv onHomeClick", true);
            ShortTvBaseListFragment.this.m1();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57793a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57793a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57793a;
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
            this.f57793a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements yz.a {
        @Override // yz.a
        public void a(vz.a aVar) {
            ShortTVFloatManager shortTVFloatManager = ShortTVFloatManager.f57884b;
            shortTVFloatManager.m();
            shortTVFloatManager.p(aVar);
        }

        @Override // yz.a
        public boolean b(vz.a aVar) {
            return ShortTVFloatManager.f57884b.o(aVar);
        }

        @Override // yz.a
        public void c(vz.a aVar) {
            yz.a.C0919a.a(this, aVar);
            ShortTVFloatManager.f57884b.n(aVar);
        }
    }

    public ShortTvBaseListFragment() {
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.d(looperMyLooper);
        this.D = new b(looperMyLooper);
        this.G = new tr.g() { // from class: com.transsion.shorttv.ShortTvBaseListFragment$downloadListener$1
            @Override // tr.g
            public void a(DownloadBean bean, DownloadException downloadException) {
                Intrinsics.g(bean, "bean");
            }

            @Override // tr.g
            public void b(DownloadBean bean) {
                Intrinsics.g(bean, "bean");
            }

            @Override // tr.g
            public void c(DownloadBean bean, long j11, long j12) {
                Intrinsics.g(bean, "bean");
            }

            @Override // tr.g
            public void d(DownloadBean bean) {
                Intrinsics.g(bean, "bean");
            }

            @Override // tr.g
            public void e(DownloadBean bean, String str) {
                qx.e eVar;
                List<qx.e> listD;
                Object next;
                Intrinsics.g(bean, "bean");
                if (Intrinsics.b(bean.getSubjectId(), this.f57794a.P0())) {
                    g gVarM0 = this.f57794a.M0();
                    if (gVarM0 == null || (listD = gVarM0.D()) == null) {
                        eVar = null;
                    } else {
                        Iterator<T> it = listD.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            qx.e eVar2 = (qx.e) next;
                            if ((eVar2 instanceof qx.d) && ((qx.d) eVar2).b() == bean.getEp()) {
                                break;
                            }
                        }
                        eVar = (qx.e) next;
                    }
                    qx.d dVar = (qx.d) eVar;
                    if (dVar != null) {
                        ShortTvBaseListFragment shortTvBaseListFragment = this.f57794a;
                        if (qx.f.a(dVar)) {
                            Integer numF = shortTvBaseListFragment.N0().v().f();
                            int iB = dVar.b();
                            if (numF != null && numF.intValue() == iB) {
                                return;
                            }
                            j.d(v.a(shortTvBaseListFragment), null, null, new ShortTvBaseListFragment$downloadListener$1$onDownloadSuccess$2$1(dVar, shortTvBaseListFragment, null), 3, null);
                        }
                    }
                }
            }

            @Override // tr.g
            public void f(DownloadBean bean) {
                Intrinsics.g(bean, "bean");
            }

            @Override // tr.g
            public void g(DownloadBean bean) {
                Intrinsics.g(bean, "bean");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.a I0() {
        return (com.transsnet.downloader.manager.a) this.A.getValue();
    }

    private final View J0(Context context) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        defaultView.setGravity(17);
        defaultView.setDefaultImageViewVisibility(0);
        defaultView.setDefaultImage(com.tn.lib.widget.R$mipmap.ic_no_content);
        String string = context.getString(com.tn.lib.widget.R$string.no_content);
        Intrinsics.f(string, "context.getString(com.tn…dget.R.string.no_content)");
        defaultView.setDescText(string);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.f(string2, "context.getString(com.tr…seui.R.string.retry_text)");
        defaultView.setBtnText(string2);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvBaseListFragment.K0(this.f57849a, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    public static final void K0(ShortTvBaseListFragment this$0, DefaultView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.c1();
        this_apply.setVisibility(8);
    }

    private final vz.a L0() {
        Integer numF = N0().v().f();
        if (numF == null) {
            return null;
        }
        int iIntValue = numF.intValue();
        List<qx.e> listF = N0().F().f();
        if (listF == null || this.f57777p == null || this.f57778q == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        qx.e eVar = null;
        for (qx.e eVar2 : listF) {
            if ((eVar2 instanceof qx.d) && ((qx.d) eVar2).b() == iIntValue) {
                eVar = eVar2;
            }
            arrayList.add(eVar2);
        }
        if (eVar == null) {
            return null;
        }
        ShortTVFloatManager.f57884b.s(arrayList);
        ORPlayerView oRPlayerView = this.f57778q;
        Intrinsics.d(oRPlayerView);
        com.transsion.player.shorttv.b bVar = this.f57777p;
        Intrinsics.d(bVar);
        FloatPlayType floatPlayType = FloatPlayType.SHORT_TV;
        qx.d dVar = (qx.d) eVar;
        String strD = dVar.d();
        if (strD == null) {
            strD = "";
        }
        String str = strD;
        ShortTVItem shortTVItemC = dVar.c();
        vz.a aVar = new vz.a(oRPlayerView, bVar, null, floatPlayType, str, shortTVItemC != null ? shortTVItemC.getSe() : 0, dVar.b(), "", getPageName());
        aVar.G(Integer.valueOf(SubjectType.SHORT_TV.getValue()));
        Subject subject = this.f57768g;
        aVar.x(subject != null ? subject.getOps() : null);
        aVar.y(this.f57784w);
        return aVar;
    }

    private final View Q0(final Context context) {
        String title;
        final NoNetworkBigView noNetworkBigView = new NoNetworkBigView(context);
        so.c.e(noNetworkBigView);
        Subject subjectF = N0().H().f();
        if (subjectF == null || (title = subjectF.getTitle()) == null) {
            title = "";
        }
        noNetworkBigView.showTitle(true, title);
        noNetworkBigView.retry(new Function0<Unit>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment$getNotNetErrorView$1$1
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
                if (com.tn.lib.util.networkinfo.f.f49475a.j(context)) {
                    so.c.g(noNetworkBigView);
                    this.hideLoading();
                    this.c1();
                } else {
                    zp.b.f82110a.d(R$string.base_net_err);
                }
                l.b(this.getPageName());
            }
        });
        noNetworkBigView.goToSetting(new Function0<Unit>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment$getNotNetErrorView$1$2
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
                l.c(this.this$0.getPageName());
            }
        });
        l.a(getPageName());
        return noNetworkBigView;
    }

    private final void X0() {
        g gVar = new g(new ArrayList(), this, false, this.f57767f, this.f57769h, this.f57771j);
        gVar.Q().B(new BaseLoadMoreView());
        gVar.Q().y(false);
        gVar.Q().x(false);
        gVar.Q().C(new f9.f() { // from class: com.transsion.shorttv.d
            @Override // f9.f
            public final void a() {
                ShortTvBaseListFragment.Y0(this.f57822a);
            }
        });
        this.f57776o = gVar;
    }

    public static final void Y0(ShortTvBaseListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.c1();
    }

    public static final void a1(ShortTvBaseListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            VideoFloatManager.f60019a.b().b(activity, this$0.f57767f, this$0.getPageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1() {
        N0().z(this.f57767f, this.f57768g, this.f57779r, this.f57780s, this.f57785x);
    }

    private final void g1(final int i11) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        this.f57765c = true;
        nx.b mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView2 = mViewBinding.f72177c) != null) {
            recyclerView2.scrollToPosition(i11);
        }
        nx.b mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.f72177c) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.shorttv.f
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvBaseListFragment.h1(this.f57872a, i11);
            }
        });
    }

    public static final void h1(ShortTvBaseListFragment this$0, int i11) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Intrinsics.g(this$0, "this$0");
        PagerLayoutManager pagerLayoutManager = this$0.f57774m;
        if (pagerLayoutManager != null) {
            View viewM = pagerLayoutManager.m();
            Log.e(this$0.f57783v, "post   itemView:" + viewM);
            if (viewM != null) {
                Log.e(this$0.f57783v, "post   itemView: 22222");
                com.transsion.shorttv.widget.c cVar = this$0.f57775n;
                if (cVar != null) {
                    cVar.d(i11, true, viewM);
                }
                nx.b mViewBinding = this$0.getMViewBinding();
                if (mViewBinding == null || (recyclerView = mViewBinding.f72177c) == null) {
                    return;
                }
                recyclerView.requestLayout();
                return;
            }
            int childCount = pagerLayoutManager.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = pagerLayoutManager.getChildAt(i12);
                if (childAt != null && pagerLayoutManager.getPosition(childAt) == i11) {
                    com.transsion.shorttv.widget.c cVar2 = this$0.f57775n;
                    if (cVar2 != null) {
                        cVar2.d(i11, true, childAt);
                    }
                    nx.b mViewBinding2 = this$0.getMViewBinding();
                    if (mViewBinding2 != null && (recyclerView2 = mViewBinding2.f72177c) != null) {
                        recyclerView2.requestLayout();
                    }
                    Log.e(this$0.f57783v, "post   itemView: 11111");
                    return;
                }
            }
        }
    }

    private final void initViewModel() {
        N0().F().j(this, new d(new Function1<List<? extends qx.e>, Unit>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends qx.e> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends qx.e> list) {
                h9.f fVarQ;
                g gVarM0;
                h9.f fVarQ2;
                List<qx.e> listD;
                Object next;
                List<? extends qx.e> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    ShortTvBaseListFragment.this.hideLoading();
                    g gVarM1 = ShortTvBaseListFragment.this.M0();
                    if (gVarM1 != null && (listD = gVarM1.D()) != null && listD.size() == 0) {
                        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                            ShortTvBaseListFragment.this.k1();
                            return;
                        } else {
                            ShortTvBaseListFragment.this.o1();
                            return;
                        }
                    }
                    g gVarM2 = ShortTvBaseListFragment.this.M0();
                    if (gVarM2 == null || (fVarQ = gVarM2.Q()) == null || !fVarQ.q() || (gVarM0 = ShortTvBaseListFragment.this.M0()) == null || (fVarQ2 = gVarM0.Q()) == null) {
                        return;
                    }
                    fVarQ2.u();
                    return;
                }
                if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    ShortTvBaseListFragment.this.n1();
                }
                ShortTvInfoEpisodeList shortTvInfoEpisodeListF = ShortTvBaseListFragment.this.N0().x().f();
                List<ShortTVItem> items = shortTvInfoEpisodeListF != null ? shortTvInfoEpisodeListF.getItems() : null;
                List<ShortTVItem> list3 = items;
                if (list3 != null && !list3.isEmpty() && items != null) {
                    ShortTvBaseListFragment shortTvBaseListFragment = ShortTvBaseListFragment.this;
                    for (ShortTVItem shortTVItem : items) {
                        Iterator<T> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            qx.e eVar = (qx.e) next;
                            if ((eVar instanceof qx.d) && ((qx.d) eVar).b() == shortTVItem.getEp()) {
                                break;
                            }
                        }
                        qx.d dVar = (qx.d) next;
                        if (dVar != null) {
                            dVar.h(shortTVItem);
                            dVar.g(shortTVItem.getEp() <= shortTvBaseListFragment.N0().E().b(shortTvBaseListFragment.O0()));
                        }
                    }
                }
                ShortTvBaseListFragment.this.q1(list);
                ShortTvBaseListFragment.this.D0();
            }
        }));
        N0().x().j(this, new d(new Function1<ShortTvInfoEpisodeList, Unit>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShortTvInfoEpisodeList shortTvInfoEpisodeList) {
                invoke2(shortTvInfoEpisodeList);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ShortTvInfoEpisodeList shortTvInfoEpisodeList) {
                ShortTvBaseListFragment.this.hideLoading();
                ShortTvBaseListFragment.this.s1(shortTvInfoEpisodeList);
            }
        }));
        N0().H().j(this, new d(new Function1<Subject, Unit>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment.initViewModel.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Subject subject) {
                invoke2(subject);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Subject subject) {
                ShortTvBaseListFragment.this.hideLoading();
                if (ShortTvBaseListFragment.this.O0() == null && subject == null && !com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    ShortTvBaseListFragment.this.o1();
                } else {
                    ShortTvBaseListFragment.this.j1(subject);
                }
            }
        }));
        N0().v().j(this, new d(new Function1<Integer, Unit>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment.initViewModel.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                ShortTvBaseListFragment shortTvBaseListFragment = ShortTvBaseListFragment.this;
                Intrinsics.f(it, "it");
                shortTvBaseListFragment.f1(it.intValue());
                g gVarM0 = ShortTvBaseListFragment.this.M0();
                qx.d dVarV0 = gVarM0 != null ? gVarM0.V0(it.intValue(), ShortTvBaseListFragment.this.f57782u) : null;
                tp.e eVar = tp.e.f77259a;
                Context contextRequireContext = ShortTvBaseListFragment.this.requireContext();
                Intrinsics.f(contextRequireContext, "requireContext()");
                boolean zA = eVar.a(contextRequireContext);
                if (!qx.f.b(dVarV0)) {
                    int iR0 = ShortTvBaseListFragment.this.R0(it.intValue());
                    g gVarM1 = ShortTvBaseListFragment.this.M0();
                    qx.e eVarO = gVarM1 != null ? gVarM1.O(iR0 + 5) : null;
                    if (eVarO instanceof qx.d) {
                        qx.d dVar = (qx.d) eVarO;
                        if (qx.f.b(dVar)) {
                            ShortTvBaseListFragment.this.E0(dVar.b());
                        }
                    }
                } else if (zA) {
                    ShortTvBaseListFragment.this.D0();
                } else {
                    ShortTvBaseListFragment.this.hideLoading();
                    ShortTvBaseListFragment.this.n1();
                }
                Integer numF = ShortTvBaseListFragment.this.N0().u().f();
                if (numF != null) {
                    ShortTvBaseListFragment shortTvBaseListFragment2 = ShortTvBaseListFragment.this;
                    g gVarM2 = shortTvBaseListFragment2.M0();
                    qx.d dVarV1 = gVarM2 != null ? gVarM2.V0(numF.intValue(), shortTvBaseListFragment2.f57782u) : null;
                    if (dVarV1 != null && zA && dVarV0 != null && dVarV0.e() && dVarV1.a() != 0 && dVarV0.a() == 0) {
                        com.tn.lib.widget.toast.core.h.f50034a.k(R$string.short_tv_watching_online);
                    }
                }
            }
        }));
        N0().K().j(this, new d(new Function1<rx.g, Unit>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment.initViewModel.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(rx.g gVar) {
                invoke2(gVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(rx.g gVar) {
                ShortTvBaseListFragment.this.p1(gVar);
            }
        }));
        N0().J().j(this, new d(new Function1<Boolean, Unit>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment.initViewModel.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ShortTvBaseListFragment shortTvBaseListFragment = ShortTvBaseListFragment.this;
                Intrinsics.f(it, "it");
                shortTvBaseListFragment.f57782u = it.booleanValue();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1() {
        g gVar;
        List<qx.e> listD;
        hideLoading();
        g gVar2 = this.f57776o;
        if (gVar2 == null || (listD = gVar2.D()) == null || !(!listD.isEmpty())) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            View viewJ0 = J0(contextRequireContext);
            if (viewJ0 == null || (gVar = this.f57776o) == null) {
                return;
            }
            gVar.r0(viewJ0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1() {
        g gVar;
        List<qx.e> listD;
        hideLoading();
        g gVar2 = this.f57776o;
        if (gVar2 == null || (listD = gVar2.D()) == null || !(!listD.isEmpty())) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            View viewQ0 = Q0(contextRequireContext);
            if (viewQ0 == null || (gVar = this.f57776o) == null) {
                return;
            }
            gVar.r0(viewQ0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(List<? extends qx.e> list) {
        int i11;
        RecyclerView recyclerView;
        h9.f fVarQ;
        h9.f fVarQ2;
        g gVar;
        h9.f fVarQ3;
        h9.f fVarQ4;
        com.transsion.player.shorttv.b bVar;
        ShortTVItem shortTVItemC;
        MediaSource mediaSource;
        Map<String, MediaSource> mapA;
        g gVar2 = this.f57776o;
        if (gVar2 == null) {
            return;
        }
        List<qx.e> listD = gVar2.D();
        ArrayList<qx.e> arrayList = new ArrayList();
        qx.e eVar = (qx.e) CollectionsKt___CollectionsKt.r0(listD);
        if (eVar == null || !(eVar instanceof qx.d) || ((qx.d) eVar).e()) {
            for (qx.e eVar2 : list) {
                arrayList.add(eVar2);
                if ((eVar2 instanceof qx.d) && !((qx.d) eVar2).e()) {
                    break;
                }
            }
            if (gVar2.D().isEmpty()) {
                gVar2.x0(arrayList);
                int iG0 = G0(arrayList);
                com.transsion.shorttv.widget.c cVar = this.f57775n;
                Integer numValueOf = cVar != null ? Integer.valueOf(cVar.g()) : null;
                Integer numF = N0().v().f();
                if (numF == null || iG0 != numF.intValue()) {
                    N0().O(iG0);
                } else if (iG0 >= 0) {
                    int iW0 = gVar2.W0(iG0, this.f57782u);
                    if (numValueOf == null || numValueOf.intValue() != iW0) {
                        Integer numF2 = N0().v().f();
                        if (numF2 == null) {
                            numF2 = Integer.valueOf(H0());
                        }
                        Intrinsics.f(numF2, "mShortTvViewModel.playin…etDefaultPlayingEpisode()");
                        f1(numF2.intValue());
                    }
                }
                C0();
            } else {
                Integer numF3 = N0().v().f();
                if (numF3 == null) {
                    numF3 = Integer.valueOf(H0());
                }
                Intrinsics.f(numF3, "mShortTvViewModel.playin…etDefaultPlayingEpisode()");
                int iIntValue = numF3.intValue();
                com.transsion.shorttv.widget.c cVar2 = this.f57775n;
                int iG = cVar2 != null ? cVar2.g() : 0;
                Iterator<? extends qx.e> it = arrayList.iterator();
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i12 = -1;
                        break;
                    }
                    qx.e next = it.next();
                    if ((next instanceof qx.d) && ((qx.d) next).b() == iIntValue) {
                        break;
                    } else {
                        i12++;
                    }
                }
                uo.b.a.f(uo.b.f78622a, this.f57783v, "currentPositionInAddList: " + i12 + ", currentPosition: " + iG + ", currentEpisode: " + iIntValue, false, 4, null);
                if (iG >= 0 && i12 >= 0) {
                    listD.set(iG, arrayList.get(i12));
                }
                if (iG < listD.size() - 1) {
                    int i13 = iG + 1;
                    List<qx.e> listSubList = listD.subList(i13, listD.size());
                    int size = listSubList.size();
                    listD.removeAll(listSubList);
                    gVar2.notifyItemRangeRemoved(i13, size);
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                if (i12 >= 0 && i12 < arrayList.size() - 1) {
                    List<? extends qx.e> listSubList2 = arrayList.subList(i12 + 1, arrayList.size());
                    int size2 = listSubList2.size();
                    int i14 = iG + 1;
                    listD.addAll(kotlin.ranges.a.g(listD.size(), i14), listSubList2);
                    gVar2.notifyItemRangeInserted(i14, size2);
                    i11++;
                }
                if (iG > 0) {
                    listD.removeAll(listD.subList(0, iG));
                    gVar2.notifyItemRangeRemoved(0, iG);
                    i11++;
                }
                if (i12 > 0) {
                    List<? extends qx.e> listSubList3 = arrayList.subList(0, i12);
                    if (listSubList3.size() > 0) {
                        listD.addAll(0, listSubList3);
                        gVar2.notifyItemRangeInserted(0, listSubList3.size());
                        i11++;
                    }
                }
                if (i11 > 0) {
                    com.transsion.shorttv.widget.c cVar3 = this.f57775n;
                    if (cVar3 != null) {
                        cVar3.l(i12);
                    }
                    nx.b mViewBinding = getMViewBinding();
                    if (mViewBinding != null && (recyclerView = mViewBinding.f72177c) != null) {
                        recyclerView.requestLayout();
                    }
                }
            }
            com.transsion.shorttv.widget.c cVar4 = this.f57775n;
            if (cVar4 != null) {
                cVar4.i();
            }
            boolean z11 = false;
            for (qx.e eVar3 : arrayList) {
                if ((eVar3 instanceof qx.d) && (shortTVItemC = ((qx.d) eVar3).c()) != null && (mediaSource = shortTVItemC.toMediaSource()) != null) {
                    com.transsion.player.shorttv.b bVar2 = this.f57777p;
                    boolean zContainsKey = (bVar2 == null || (mapA = bVar2.a()) == null) ? false : mapA.containsKey(mediaSource.e());
                    uo.b.a.f(uo.b.f78622a, this.f57783v, "addDataSource----updateData  ep:" + shortTVItemC.getEp() + ",inPlayerList:" + zContainsKey, false, 4, null);
                    if (this.f57765c || !zContainsKey) {
                        com.transsion.player.shorttv.b bVar3 = this.f57777p;
                        if (bVar3 != null && bVar3.addDataSource(mediaSource)) {
                            z11 = true;
                        }
                    }
                }
            }
            if (z11 && (bVar = this.f57777p) != null) {
                bVar.prepare();
            }
            if (list.size() < S0()) {
                g gVar3 = this.f57776o;
                if (gVar3 != null && (fVarQ4 = gVar3.Q()) != null) {
                    fVarQ4.u();
                }
                g gVar4 = this.f57776o;
                h9.f fVarQ5 = gVar4 != null ? gVar4.Q() : null;
                if (fVarQ5 == null) {
                    return;
                }
                fVarQ5.y(true);
                return;
            }
            g gVar5 = this.f57776o;
            h9.f fVarQ6 = gVar5 != null ? gVar5.Q() : null;
            if (fVarQ6 != null) {
                fVarQ6.y(false);
            }
            g gVar6 = this.f57776o;
            if (gVar6 != null && (fVarQ2 = gVar6.Q()) != null && fVarQ2.q() && (gVar = this.f57776o) != null && (fVarQ3 = gVar.Q()) != null) {
                fVarQ3.r();
            }
            g gVar7 = this.f57776o;
            if (gVar7 == null || (fVarQ = gVar7.Q()) == null) {
                return;
            }
            h9.f.t(fVarQ, false, 1, null);
        }
    }

    public final void A0() {
        RecyclerView recyclerView;
        List<qx.e> listF = N0().F().f();
        if (listF == null) {
            listF = kotlin.collections.g.l();
        }
        g gVar = this.f57776o;
        if (gVar == null) {
            return;
        }
        List<qx.e> listD = gVar.D();
        ArrayList arrayList = new ArrayList();
        qx.e eVar = (qx.e) CollectionsKt___CollectionsKt.r0(listD);
        if (eVar == null || !(eVar instanceof qx.d) || ((qx.d) eVar).e()) {
            for (qx.e eVar2 : listF) {
                if (!listD.contains(eVar2)) {
                    arrayList.add(eVar2);
                }
                if ((eVar2 instanceof qx.d) && !((qx.d) eVar2).e()) {
                    break;
                }
            }
            gVar.m(arrayList);
            nx.b mViewBinding = getMViewBinding();
            if (mViewBinding == null || (recyclerView = mViewBinding.f72177c) == null) {
                return;
            }
            recyclerView.requestLayout();
        }
    }

    public final void B0() {
        List<qx.e> listD;
        g gVar = this.f57776o;
        if (gVar == null || (listD = gVar.D()) == null) {
            return;
        }
        Integer numF = N0().v().f();
        if (numF != null) {
            int iIntValue = numF.intValue() + 1;
            g gVar2 = this.f57776o;
            if ((gVar2 != null ? gVar2.V0(iIntValue, this.f57782u) : null) != null) {
                N0().O(iIntValue);
                uo.b.a.f(uo.b.f78622a, this.f57783v, "autoPlayNext  currentEp:" + numF + "  nextEp:" + iIntValue, false, 4, null);
                return;
            }
        }
        com.transsion.shorttv.widget.c cVar = this.f57775n;
        int iG = cVar != null ? cVar.g() : 0;
        int size = listD.size();
        for (int i11 = iG + 1; i11 < size; i11++) {
            qx.e eVar = (qx.e) CollectionsKt___CollectionsKt.h0(listD, i11);
            if (eVar instanceof qx.d) {
                int iB = ((qx.d) eVar).b();
                N0().O(iB);
                uo.b.a.f(uo.b.f78622a, this.f57783v, "autoPlayNext  currentPosition:" + iG + "  nextEp:" + iB, false, 4, null);
                return;
            }
        }
    }

    public final void C0() {
        if (this.f57781t) {
            this.f57781t = false;
        }
    }

    public final boolean D0() {
        Integer numF = N0().v().f();
        if (numF == null) {
            return false;
        }
        int iIntValue = numF.intValue();
        g gVar = this.f57776o;
        qx.d dVarV0 = gVar != null ? gVar.V0(iIntValue, this.f57782u) : null;
        if ((dVarV0 != null ? dVarV0.c() : null) != null && !dVarV0.e()) {
            return false;
        }
        if (!qx.f.b(dVarV0)) {
            return true;
        }
        if (dVarV0 != null && dVarV0.e()) {
            startLoading();
        }
        E0(iIntValue);
        return false;
    }

    public final void E0(int i11) {
        if (N0().F().f() != null) {
            N0().A(this.f57767f, i11);
        }
    }

    public final qx.d F0(int i11, List<? extends qx.e> list) {
        Object next;
        if (i11 <= T0(list)) {
            qx.e eVar = list.get(R0(i11));
            if (eVar instanceof qx.d) {
                qx.d dVar = (qx.d) eVar;
                if (dVar.b() == i11) {
                    return dVar;
                }
            }
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            qx.e eVar2 = (qx.e) next;
            if ((eVar2 instanceof qx.d) && ((qx.d) eVar2).b() == i11) {
                return (qx.d) next;
            }
        }
        next = null;
        return (qx.d) next;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x008b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0099  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c1  */
    public final int G0(List<? extends qx.e> list) {
        qx.d dVar;
        qx.e eVar;
        ShortTVPlayBean shortTVPlayBeanF = N0().t().f();
        Integer numF = N0().v().f();
        if (numF == null) {
            numF = -1;
        }
        int iIntValue = numF.intValue();
        uo.b.a.f(uo.b.f78622a, this.f57783v, "lastEp: " + iIntValue + ", historyItem: " + shortTVPlayBeanF + ", size: " + list.size(), false, 4, null);
        if (iIntValue < 0 || iIntValue >= list.size()) {
            iIntValue = shortTVPlayBeanF != null ? shortTVPlayBeanF.getEp() : H0();
            if (this.f57779r > 0) {
                Object obj = null;
                if (!this.f57785x) {
                    iIntValue = this.f57779r;
                    for (Object obj2 : list) {
                        eVar = (qx.e) obj2;
                        if (!(eVar instanceof qx.d) && ((qx.d) eVar).b() == this.f57779r) {
                            obj = obj2;
                            break;
                        }
                    }
                    dVar = (qx.d) obj;
                    Subject subject = this.f57768g;
                    if (dVar != null || subject == null) {
                        N0().p();
                    } else {
                        N0().S(subject, dVar, this.f57780s);
                    }
                } else if ((shortTVPlayBeanF != null ? Integer.valueOf(shortTVPlayBeanF.getEp()) : null) == null || shortTVPlayBeanF.getEp() == this.f57779r) {
                    iIntValue = this.f57779r;
                    while (r9.hasNext()) {
                        eVar = (qx.e) obj2;
                        if (!(eVar instanceof qx.d)) {
                        }
                    }
                    dVar = (qx.d) obj;
                    Subject subject2 = this.f57768g;
                    if (dVar != null) {
                        N0().p();
                    } else {
                        N0().p();
                    }
                }
            }
        }
        return iIntValue;
    }

    public final int H0() {
        return !this.f57782u ? 1 : 0;
    }

    public final g M0() {
        return this.f57776o;
    }

    public final ShortTvViewModel N0() {
        return (ShortTvViewModel) this.f57773l.getValue();
    }

    public final Subject O0() {
        return this.f57768g;
    }

    public final String P0() {
        return this.f57767f;
    }

    public final int R0(int i11) {
        return (this.f57782u || i11 == 0) ? i11 : i11 - 1;
    }

    public final int S0() {
        if (this.f57782u) {
            Subject subject = this.f57768g;
            return (subject != null ? subject.getTotalEpisode() : 0) + 1;
        }
        Subject subject2 = this.f57768g;
        if (subject2 != null) {
            return subject2.getTotalEpisode();
        }
        return 0;
    }

    public final <E> int T0(List<? extends E> list) {
        if (this.f57782u) {
            return (list != null ? list.size() : 0) + 1;
        }
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final com.transsion.player.shorttv.preload.g U0() {
        return (com.transsion.player.shorttv.preload.g) this.f57787z.getValue();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public nx.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        nx.b bVarC = nx.b.c(inflater);
        Intrinsics.f(bVarC, "inflate(inflater)");
        return bVarC;
    }

    public final void W0(rx.f fVar) {
        View viewF;
        MediaSource mediaSource;
        Map<String, MediaSource> mapA;
        g gVar;
        Integer numF = N0().v().f();
        if (numF == null) {
            numF = 1;
        }
        int iIntValue = numF.intValue();
        List<qx.e> listF = N0().F().f();
        if (listF == null) {
            listF = kotlin.collections.g.l();
        }
        Iterator<T> it = fVar.d().iterator();
        boolean zContainsKey = false;
        qx.d dVar = null;
        boolean z11 = false;
        int i11 = 0;
        while (it.hasNext()) {
            int iIntValue2 = ((Number) it.next()).intValue();
            qx.d dVarF0 = F0(iIntValue2, listF);
            if (dVarF0 != null) {
                dVarF0.g(true);
            }
            g gVar2 = this.f57776o;
            int iW0 = gVar2 != null ? gVar2.W0(iIntValue2, this.f57782u) : -1;
            if (iW0 >= 0 && (gVar = this.f57776o) != null) {
                gVar.notifyItemChanged(iW0, Boolean.TRUE);
            }
            if (iIntValue2 > i11) {
                i11 = iIntValue2;
            }
            if (iIntValue == iIntValue2) {
                dVar = dVarF0;
                z11 = true;
            }
        }
        A0();
        if (D0() && z11 && dVar != null) {
            ShortTVItem shortTVItemC = dVar.c();
            if (shortTVItemC != null && (mediaSource = shortTVItemC.toMediaSource()) != null) {
                com.transsion.player.shorttv.b bVar = this.f57777p;
                if (bVar != null && (mapA = bVar.a()) != null) {
                    zContainsKey = mapA.containsKey(mediaSource.e());
                }
                uo.b.a.f(uo.b.f78622a, this.f57783v, "addDataSource----handleUnlockSuccess  ep:" + dVar.b() + ",inPlayerList:" + zContainsKey, false, 4, null);
                if (this.f57765c || !zContainsKey) {
                    com.transsion.player.shorttv.b bVar2 = this.f57777p;
                    if (bVar2 != null) {
                        bVar2.addDataSource(mediaSource);
                    }
                    com.transsion.player.shorttv.b bVar3 = this.f57777p;
                    if (bVar3 != null) {
                        bVar3.prepare();
                    }
                    com.transsion.player.shorttv.b bVar4 = this.f57777p;
                    if (bVar4 != null) {
                        String strE = mediaSource.e();
                        if (strE == null) {
                            strE = "";
                        }
                        bVar4.seekTo(strE, 0L);
                    }
                }
            }
            com.transsion.shorttv.widget.c cVar = this.f57775n;
            if (cVar == null || (viewF = cVar.f()) == null) {
                return;
            }
            com.transsion.shorttv.widget.c cVar2 = this.f57775n;
            if (cVar2 != null) {
                Intrinsics.e(viewF, "null cannot be cast to non-null type com.transsion.shorttv.widget.ShortTvVideoItemView");
                cVar2.m((ShortTvVideoItemView) viewF, R0(iIntValue), dVar);
            }
        }
        PagerLayoutManager pagerLayoutManager = this.f57774m;
        if (pagerLayoutManager == null) {
            return;
        }
        pagerLayoutManager.o(true);
    }

    public final void Z0() {
        FrameLayout root;
        nx.b mViewBinding = getMViewBinding();
        if (mViewBinding == null || (root = mViewBinding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.shorttv.c
            @Override // java.lang.Runnable
            public final void run() {
                ShortTvBaseListFragment.a1(this.f57821a);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b1() {
        String subjectId;
        String subjectId2;
        ORExoShortTvPlayer oRExoShortTvPlayer;
        ShortTVItem shortTVFirstEp;
        MediaSource mediaSource;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        this.f57778q = new ORPlayerView(fragmentActivityRequireActivity, RenderType.SURFACE_VIEW);
        com.transsion.videofloat.manager.v vVar = com.transsion.videofloat.manager.v.f60111a;
        ShortTVFloatManager shortTVFloatManager = ShortTVFloatManager.f57884b;
        Subject subject = this.f57768g;
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = this.f57767f;
        }
        com.transsion.player.orplayer.f fVarB = vVar.b(shortTVFloatManager.g(subjectId));
        int i11 = 1;
        boolean z11 = fVarB == null;
        this.f57765c = z11;
        uo.b.a aVar = uo.b.f78622a;
        String str = this.f57783v;
        Subject subject2 = this.f57768g;
        if (subject2 == null || (subjectId2 = subject2.getSubjectId()) == null) {
            subjectId2 = this.f57767f;
        }
        uo.b.a.f(aVar, str, "initOrPlayer isNewPlayer:" + z11 + ", mSubjectId:" + subjectId2, false, 4, null);
        com.transsion.player.shorttv.preload.c cVar = null;
        Object[] objArr = 0;
        if (fVarB != null) {
            oRExoShortTvPlayer = fVarB instanceof ORExoShortTvPlayer ? (ORExoShortTvPlayer) fVarB : null;
            if (oRExoShortTvPlayer != null) {
                ORPlayerView oRPlayerView = this.f57778q;
                oRExoShortTvPlayer.setSurfaceView(oRPlayerView != null ? oRPlayerView.getSurface() : null);
            } else {
                oRExoShortTvPlayer = null;
            }
        } else {
            oRExoShortTvPlayer = new ORExoShortTvPlayer(cVar, i11, objArr == true ? 1 : 0);
            ORPlayerView oRPlayerView2 = this.f57778q;
            oRExoShortTvPlayer.setSurfaceView(oRPlayerView2 != null ? oRPlayerView2.getSurface() : null);
        }
        this.f57777p = oRExoShortTvPlayer;
        com.transsion.player.helper.g gVar = this.C;
        if (gVar == null) {
            Intrinsics.y("volumeControl");
            gVar = null;
        }
        gVar.e(this.f57777p);
        VideoFloatManager.a.a(VideoFloatManager.f60019a.b(), false, 1, null);
        com.transsion.player.shorttv.b bVar = this.f57777p;
        if (bVar != null) {
            bVar.addPlayerListener(this);
        }
        Subject subject3 = this.f57768g;
        if (subject3 == null || (shortTVFirstEp = subject3.getShortTVFirstEp()) == null || (mediaSource = shortTVFirstEp.toMediaSource()) == null) {
            return;
        }
        U0().g(mediaSource);
        if (this.f57765c) {
            com.transsion.player.shorttv.b bVar2 = this.f57777p;
            if (bVar2 != null) {
                bVar2.addDataSource(mediaSource);
            }
            com.transsion.player.shorttv.b bVar3 = this.f57777p;
            if (bVar3 != null) {
                bVar3.prepare();
            }
        }
    }

    public final void d1() {
        if (!com.transsion.videofloat.a.f60027a.c(this.f57777p)) {
            if (com.transsion.videofloat.manager.v.f60111a.c(this.f57777p)) {
                uo.b.f78622a.c(this.f57783v, " 播放器在缓存中，这里不能release", true);
                return;
            }
            com.transsion.player.shorttv.b bVar = this.f57777p;
            if (bVar != null) {
                bVar.stop();
            }
            com.transsion.player.shorttv.b bVar2 = this.f57777p;
            if (bVar2 != null) {
                bVar2.release();
            }
        }
        uo.b.a.f(uo.b.f78622a, this.f57783v, "onDestroy  removePlayerListener", false, 4, null);
        com.transsion.player.shorttv.b bVar3 = this.f57777p;
        if (bVar3 != null) {
            bVar3.removePlayerListener(this);
        }
        ImmVideoHelper.f57891d.a().c();
        I0().v(this.G);
        DeviceKeyMonitor deviceKeyMonitor = this.B;
        if (deviceKeyMonitor != null) {
            deviceKeyMonitor.b();
        }
    }

    public final void e1() {
        qx.d dVarV0;
        Integer numF = N0().v().f();
        if (numF == null) {
            return;
        }
        int iIntValue = numF.intValue();
        com.transsion.shorttv.widget.c cVar = this.f57775n;
        long jH = cVar != null ? cVar.h() : 0L;
        g gVar = this.f57776o;
        if (gVar == null || (dVarV0 = gVar.V0(iIntValue, this.f57782u)) == null) {
            return;
        }
        N0().N(N0().H().f(), dVarV0.c(), jH);
    }

    public final void f1(int i11) {
        List<qx.e> listD;
        List<qx.e> listD2;
        int i12 = i11 < 0 ? 1 : i11;
        com.transsion.shorttv.widget.c cVar = this.f57775n;
        if (cVar != null) {
            int iG = cVar.g();
            g gVar = this.f57776o;
            if (gVar == null || (listD = gVar.D()) == null || iG >= listD.size()) {
                return;
            }
            qx.e eVar = listD.get(iG);
            if ((eVar instanceof qx.d) && ((qx.d) eVar).b() == i12) {
                uo.b.a aVar = uo.b.f78622a;
                String str = this.f57783v;
                com.transsion.shorttv.widget.c cVar2 = this.f57775n;
                uo.b.a.f(aVar, str, "scrollToEpisode current:" + (cVar2 != null ? Integer.valueOf(cVar2.g()) : null) + " == " + i12, false, 4, null);
                return;
            }
            g gVar2 = this.f57776o;
            int i13 = -1;
            if (gVar2 != null && (listD2 = gVar2.D()) != null) {
                int i14 = 0;
                for (qx.e eVar2 : listD2) {
                    if ((eVar2 instanceof qx.d) && ((qx.d) eVar2).b() == i11) {
                        i13 = i14;
                        break;
                    }
                    i14++;
                }
            }
            if (i13 >= 0) {
                if (i13 == iG) {
                    return;
                }
                com.transsion.shorttv.widget.c cVar3 = this.f57775n;
                if (cVar3 != null) {
                    cVar3.k(true);
                }
                g1(i13);
                return;
            }
            uo.b.a aVar2 = uo.b.f78622a;
            String str2 = this.f57783v;
            com.transsion.shorttv.widget.c cVar4 = this.f57775n;
            uo.b.a.f(aVar2, str2, "scrollToEpisode current:" + (cVar4 != null ? Integer.valueOf(cVar4.g()) : null) + " == " + i12 + " indexOfEp:" + i13 + " return", false, 4, null);
        }
    }

    public abstract String getPageName();

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        ProgressBar progressBar;
        nx.b mViewBinding = getMViewBinding();
        if (mViewBinding != null && (progressBar = mViewBinding.f72176b) != null) {
            so.c.g(progressBar);
        }
        b bVar = this.D;
        bVar.removeMessages(bVar.b());
    }

    public final void i1(boolean z11) {
        this.f57786y = z11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        if (bundle != null) {
            N0().K().q(null);
        }
        setNetListener(new a());
        initViewModel();
        startLoading();
        c1();
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        com.transsion.player.helper.g.a aVar = com.transsion.player.helper.g.f54361a;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        nx.b mViewBinding = getMViewBinding();
        com.transsion.player.helper.g gVarA = aVar.a(contextRequireContext, mViewBinding != null ? mViewBinding.getRoot() : null);
        this.C = gVarA;
        if (gVarA == null) {
            Intrinsics.y("volumeControl");
            gVarA = null;
        }
        gVarA.g();
        X0();
        b1();
        Z0();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        this.f57774m = new PagerLayoutManager(fragmentActivityRequireActivity);
        com.transsion.shorttv.widget.c cVar = new com.transsion.shorttv.widget.c(this, this.f57776o, this.f57777p, this.f57778q, this.f57774m);
        this.f57775n = cVar;
        PagerLayoutManager pagerLayoutManager = this.f57774m;
        if (pagerLayoutManager != null) {
            pagerLayoutManager.p(cVar);
        }
        nx.b mViewBinding2 = getMViewBinding();
        RecyclerView recyclerView = mViewBinding2 != null ? mViewBinding2.f72177c : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(this.f57774m);
        }
        nx.b mViewBinding3 = getMViewBinding();
        RecyclerView recyclerView2 = mViewBinding3 != null ? mViewBinding3.f72177c : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f57776o);
        }
        ImmVideoHelper immVideoHelperA = ImmVideoHelper.f57891d.a();
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity2, "requireActivity()");
        immVideoHelperA.e(fragmentActivityRequireActivity2);
    }

    public final void j1(Subject subject) {
        this.f57768g = subject;
    }

    public final void l1() {
        if (this.f57763a == null) {
            ShortTvEpisodeListDialog shortTvEpisodeListDialog = new ShortTvEpisodeListDialog();
            shortTvEpisodeListDialog.setArguments(androidx.core.os.c.b(new Pair("hasTrailer", Boolean.valueOf(this.f57782u))));
            this.f57763a = shortTvEpisodeListDialog;
        }
        ShortTvEpisodeListDialog shortTvEpisodeListDialog2 = this.f57763a;
        if (shortTvEpisodeListDialog2 != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            shortTvEpisodeListDialog2.show(childFragmentManager, "immComment");
        }
        com.transsion.shorttv.dot.b bVar = com.transsion.shorttv.dot.b.f57848a;
        Subject subject = this.f57768g;
        com.transsion.shorttv.dot.b.b(bVar, subject != null ? subject.getSubjectId() : null, "dialog_minitv_ep", null, 4, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.E != 0) {
            FirebaseAnalyticsManager.f51235a.o(getPageName(), Long.valueOf(SystemClock.elapsedRealtime() - this.E), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.E = SystemClock.elapsedRealtime();
    }

    public final void m1() {
        final FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        if (!RoomAppMMKV.f51271a.a().getBoolean("k_pip_enable", true)) {
            uo.b.f78622a.c("VideoFloat", "shottv 设置页pip开关被关闭了", true);
            return;
        }
        vz.a aVarL0 = L0();
        if (aVarL0 != null) {
            if (this.f57786y) {
                uo.b.f78622a.c("VideoFloat-pip", "shottv 视频暂停，无需触发画中画", true);
                return;
            }
            VideoPipManager.Companion companion = VideoPipManager.f60024a;
            if (!companion.a().b()) {
                VideoFloatManager.f60019a.b().e(activity, aVarL0, false, false, new Function1<Boolean, Unit>() { // from class: com.transsion.shorttv.ShortTvBaseListFragment$showFloat2Window$1$1
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
                            com.transsion.player.shorttv.b bVar = this.this$0.f57777p;
                            if (bVar != null) {
                                bVar.removePlayerListener(this.this$0);
                            }
                            FragmentActivity fragmentActivity = activity;
                            if (fragmentActivity != null) {
                                fragmentActivity.finish();
                            }
                        }
                    }
                }, new e());
            } else {
                uo.b.f78622a.c("VideoFloat-pip", "shottv 当前可用画中画，使用画中画播放", true);
                companion.a().j(activity, aVarL0, FloatActionType.HOME, false);
            }
        }
    }

    public final void n1() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f57766d > 3500) {
            this.f57766d = jCurrentTimeMillis;
            com.tn.lib.widget.toast.core.h.f50034a.k(com.tn.lib.widget.R$string.no_network_toast);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
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
        com.transsion.player.orplayer.e.a.d(this, mediaSource);
        B0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        HashMap<String, String> mapG;
        String subjectId;
        super.onCreate(bundle);
        m mVar = m.f51277a;
        this.f57784w = mVar.f();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        String str = "";
        if (string == null) {
            string = "";
        }
        this.f57767f = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("item_type") : null;
        if (string2 == null) {
            string2 = "";
        }
        this.f57769h = string2;
        Bundle arguments3 = getArguments();
        this.f57779r = arguments3 != null ? arguments3.getInt("ep", this.f57779r) : this.f57779r;
        Bundle arguments4 = getArguments();
        this.f57780s = arguments4 != null ? arguments4.getLong("ms", this.f57780s) : this.f57780s;
        Bundle arguments5 = getArguments();
        this.f57785x = arguments5 != null ? arguments5.getBoolean("historyFist", this.f57785x) : this.f57785x;
        Bundle arguments6 = getArguments();
        this.f57781t = arguments6 != null ? arguments6.getBoolean(DownloadBaseRunnable.TAG) : false;
        Bundle arguments7 = getArguments();
        this.f57770i = arguments7 != null ? arguments7.getBoolean("from_comment") : false;
        Bundle arguments8 = getArguments();
        this.f57772k = arguments8 != null ? arguments8.getString("rec_ops") : null;
        this.f57771j = Intrinsics.b(mVar.f(), HomeTabType.TAB_CODE_TRENDING);
        Bundle arguments9 = getArguments();
        this.f57768g = (Subject) (arguments9 != null ? arguments9.getSerializable("item_object") : null);
        if (this.f57767f.length() == 0) {
            Subject subject = this.f57768g;
            if (subject != null && (subjectId = subject.getSubjectId()) != null) {
                str = subjectId;
            }
            this.f57767f = str;
        }
        Subject subject2 = this.f57768g;
        if ((subject2 != null ? subject2.getTrailer() : null) != null) {
            this.f57782u = true;
            uo.b.a aVar = uo.b.f78622a;
            String str2 = this.f57783v;
            Subject subject3 = this.f57768g;
            uo.b.a.f(aVar, str2, "Has trailer " + (subject3 != null ? subject3.getTrailer() : null), false, 4, null);
        } else {
            uo.b.a.f(uo.b.f78622a, this.f57783v, "No trailer", false, 4, null);
            this.f57782u = false;
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            mapG.put("subject_id", this.f57767f);
        }
        I0().f(this.G);
        Context context = getContext();
        if (context != null) {
            this.B = new DeviceKeyMonitor(context, new c());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        U0().p();
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        com.transsion.player.orplayer.e.a.f(this, z11);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                com.transsion.player.shorttv.b bVar = this.f57777p;
                if (bVar != null) {
                    bVar.pause();
                }
                logPause();
            } else {
                com.transsion.player.shorttv.b bVar2 = this.f57777p;
                if (bVar2 != null) {
                    bVar2.play();
                }
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        qx.e eVarO;
        List arrayList;
        View viewF;
        String id2;
        List<qx.e> listD;
        List<qx.e> listD2;
        this.f57765c = true;
        Integer numF = N0().v().f();
        if (numF == null) {
            return;
        }
        int iIntValue = numF.intValue();
        g gVar = this.f57776o;
        if (gVar != null) {
            int iW0 = gVar.W0(iIntValue, this.f57782u);
            g gVar2 = this.f57776o;
            if (gVar2 == null || (eVarO = gVar2.O(iW0)) == null || iW0 == -1) {
                return;
            }
            g gVar3 = this.f57776o;
            if (gVar3 == null || (arrayList = gVar3.D()) == null) {
                arrayList = new ArrayList();
            }
            int i11 = iW0 + 1;
            qx.e eVar = (qx.e) CollectionsKt___CollectionsKt.h0(arrayList, i11);
            if (eVar == null) {
                return;
            }
            if (eVar instanceof qx.c) {
                com.transsion.player.shorttv.b bVar = this.f57777p;
                if (bVar != null) {
                    bVar.pause();
                }
                g1(i11);
                return;
            }
            if (eVar instanceof qx.d) {
                uo.b.a aVar = uo.b.f78622a;
                uo.b.a.f(aVar, this.f57783v, "onMediaItemTransition uuid:" + str + " nextItem:" + eVar, false, 4, null);
                qx.d dVar = (qx.d) eVar;
                if (qx.f.b(dVar)) {
                    com.transsion.player.shorttv.b bVar2 = this.f57777p;
                    if (bVar2 != null) {
                        bVar2.pause();
                    }
                    B0();
                    return;
                }
                g gVar4 = this.f57776o;
                if (gVar4 != null) {
                    gVar4.k0(i11);
                }
                g gVar5 = this.f57776o;
                if (gVar5 != null && (listD2 = gVar5.D()) != null) {
                    listD2.set(iW0, eVar);
                }
                g gVar6 = this.f57776o;
                if (gVar6 != null && (listD = gVar6.D()) != null) {
                    listD.add(iW0, eVarO);
                }
                g gVar7 = this.f57776o;
                if (gVar7 != null) {
                    gVar7.notifyItemInserted(iW0);
                }
                com.transsion.shorttv.widget.c cVar = this.f57775n;
                if (cVar == null || (viewF = cVar.f()) == 0) {
                    return;
                }
                if (viewF instanceof com.transsion.shorttv.a) {
                    com.transsion.shorttv.a aVar2 = (com.transsion.shorttv.a) viewF;
                    ShortTVItem shortTVItemC = dVar.c();
                    if (shortTVItemC == null || (id2 = shortTVItemC.getId()) == null) {
                        id2 = "";
                    }
                    aVar2.onMediaItemTransition(id2);
                    aVar2.setData(dVar, this, Integer.valueOf(i11), false, null, null, false, this.f57771j);
                    com.transsion.shorttv.widget.c cVar2 = this.f57775n;
                    if (cVar2 != null) {
                        cVar2.d(i11, false, viewF);
                    }
                    com.transsion.player.shorttv.b bVar3 = this.f57777p;
                    boolean zIsPlaying = bVar3 != null ? bVar3.isPlaying() : false;
                    uo.b.a.f(aVar, this.f57783v, "onMediaItemTransition  isPlaying:" + zIsPlaying, false, 4, null);
                    if (zIsPlaying) {
                        aVar2.onRenderFirstFrame();
                    }
                }
                N0().O(dVar.b());
            }
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.d.l(null, this, null, 5, null);
        e1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean z11) {
        super.onPictureInPictureModeChanged(z11);
        if (z11) {
            FragmentActivity activity = getActivity();
            if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            vz.a aVarL0 = L0();
            if (aVarL0 != null && Build.VERSION.SDK_INT >= 31) {
                VideoPipManager.f60024a.a().c(activity, aVarL0);
            }
        }
        VideoPipManager.f60024a.a().onPipModeChanged(z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        com.transsion.player.orplayer.e.a.p(this, errorInfo, mediaSource);
        this.F = errorInfo;
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        com.transsion.player.orplayer.e.a.u(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.v(this, mediaSource);
        this.F = null;
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        com.transsion.player.orplayer.e.a.z(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.baseui.activity.d.p(null, this, "visible=" + isVisible(), 1, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e.a.A(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
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
        com.transsion.player.orplayer.e.a.E(this, mediaSource);
        r1(false);
        hideLoading();
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.H(this, mediaSource);
        r1(true);
    }

    public final void p1(rx.g gVar) {
        if (this.f57768g != null) {
            if (gVar instanceof i) {
                W0(((i) gVar).a());
                return;
            }
            if (gVar instanceof rx.h) {
                W0(((rx.h) gVar).a());
                return;
            }
            if ((gVar instanceof rx.b) || !(gVar instanceof rx.c)) {
                return;
            }
            tp.e eVar = tp.e.f77259a;
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            if (eVar.a(contextRequireContext)) {
                return;
            }
            zp.b.f82110a.d(R$string.base_net_err);
        }
    }

    public void r1(boolean z11) {
        try {
            Result.Companion companion = Result.Companion;
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                VideoPipManager.Companion companion2 = VideoPipManager.f60024a;
                if (companion2.a().b() && RoomAppMMKV.f51271a.a().getBoolean("k_pip_enable", true)) {
                    VideoPipManager videoPipManagerA = companion2.a();
                    ORPlayerView oRPlayerView = this.f57778q;
                    ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
                    Result.m163constructorimpl(videoPipManagerA.i(activity, true, z11, parent instanceof ViewGroup ? (ViewGroup) parent : null));
                }
            }
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void s1(ShortTvInfoEpisodeList shortTvInfoEpisodeList) {
        g gVar;
        qx.d dVarV0;
        View viewF;
        com.transsion.shorttv.widget.c cVar;
        Object next;
        Map<String, MediaSource> mapA;
        g gVar2;
        List<qx.e> listD;
        List<qx.e> listD2;
        Media video;
        List<ShortTVItem> items = shortTvInfoEpisodeList != null ? shortTvInfoEpisodeList.getItems() : null;
        List<ShortTVItem> list = items;
        if (list == null || list.isEmpty()) {
            return;
        }
        Integer numF = N0().v().f();
        if (numF == null) {
            numF = 0;
        }
        int iIntValue = numF.intValue();
        List<qx.e> listF = N0().F().f();
        if (listF == null) {
            listF = kotlin.collections.g.l();
        }
        boolean z11 = false;
        for (ShortTVItem shortTVItem : items) {
            int iR0 = R0(shortTVItem.getEp());
            qx.e eVar = (qx.e) CollectionsKt___CollectionsKt.h0(listF, iR0);
            if (!(eVar instanceof qx.d) || ((qx.d) eVar).b() != shortTVItem.getEp()) {
                Iterator<T> it = listF.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    qx.e eVar2 = (qx.e) next;
                    if ((eVar2 instanceof qx.d) && ((qx.d) eVar2).b() == shortTVItem.getEp()) {
                        break;
                    }
                }
                eVar = (qx.e) next;
            }
            if (eVar != null && (eVar instanceof qx.d)) {
                qx.d dVar = (qx.d) eVar;
                boolean z12 = dVar.c() == null;
                if (dVar.b() == iIntValue) {
                    ShortTVItem shortTVItemC = dVar.c();
                    if (((shortTVItemC == null || (video = shortTVItemC.getVideo()) == null) ? null : video.getVideoAddress()) == null) {
                        Media video2 = shortTVItem.getVideo();
                        if ((video2 != null ? video2.getVideoAddress() : null) != null) {
                            z11 = true;
                        }
                    }
                }
                shortTVItem.setLockStatus(dVar.e() ? 1 : 0);
                ShortTVItem shortTVItemC2 = dVar.c();
                String id2 = shortTVItemC2 != null ? shortTVItemC2.getId() : null;
                if (id2 != null && id2.length() != 0) {
                    shortTVItem.setId(id2);
                }
                dVar.h(shortTVItem);
                g gVar3 = this.f57776o;
                if (iR0 < (gVar3 != null ? gVar3.getItemCount() : 0)) {
                    g gVar4 = this.f57776o;
                    if (iR0 < ((gVar4 == null || (listD2 = gVar4.D()) == null) ? 0 : listD2.size())) {
                        g gVar5 = this.f57776o;
                        if (gVar5 != null && (listD = gVar5.D()) != null) {
                            listD.set(iR0, eVar);
                        }
                        if (z12 && (gVar2 = this.f57776o) != null) {
                            gVar2.notifyItemChanged(iR0, Integer.valueOf(shortTVItem.getEp()));
                        }
                    }
                }
            }
            MediaSource mediaSource = shortTVItem.toMediaSource();
            if (mediaSource != null) {
                com.transsion.player.shorttv.b bVar = this.f57777p;
                boolean zContainsKey = (bVar == null || (mapA = bVar.a()) == null) ? false : mapA.containsKey(mediaSource.e());
                uo.b.a.f(uo.b.f78622a, this.f57783v, "addDataSource----updateShortTvInfoList  ep:" + shortTVItem.getEp() + ",inPlayerList:" + zContainsKey, false, 4, null);
                if (this.f57765c || !zContainsKey) {
                    com.transsion.player.shorttv.b bVar2 = this.f57777p;
                    if (bVar2 != null) {
                        bVar2.addDataSource(mediaSource);
                    }
                }
            }
        }
        com.transsion.player.shorttv.b bVar3 = this.f57777p;
        if (bVar3 != null) {
            bVar3.prepare();
        }
        if (!z11 || (gVar = this.f57776o) == null || (dVarV0 = gVar.V0(iIntValue, this.f57782u)) == null) {
            return;
        }
        if (qx.f.b(dVarV0)) {
            D0();
            return;
        }
        com.transsion.shorttv.widget.c cVar2 = this.f57775n;
        if (cVar2 == null || (viewF = cVar2.f()) == null || !(viewF instanceof ShortTvVideoItemView) || (cVar = this.f57775n) == null) {
            return;
        }
        cVar.m((ShortTvVideoItemView) viewF, R0(iIntValue), dVarV0);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        b bVar = this.D;
        if (bVar.hasMessages(bVar.b())) {
            return;
        }
        b bVar2 = this.D;
        bVar2.sendEmptyMessageDelayed(bVar2.b(), this.D.a());
    }
}
