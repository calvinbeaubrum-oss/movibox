package com.transsion.postdetail.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.postdetail.R$anim;
import com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
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
public final class LocalVideoMiddleSeriesListFragment extends BaseFragment<tv.k> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f55711j = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.postdetail.ui.adapter.a f55714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LocalVideoDetailViewModel f55715d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DownloadBean f55718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super DownloadBean, ? super Integer, Unit> f55719i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55712a = "LocalVideoMiddleSeriesListFragment";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f55713b = com.blankj.utilcode.util.f0.a(280.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f55716f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f55717g = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalVideoMiddleSeriesListFragment a() {
            return new LocalVideoMiddleSeriesListFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends DiffUtil.e<DownloadBean> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(DownloadBean oldItem, DownloadBean newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getResourceId(), newItem.getResourceId()) && oldItem.getStatus() == newItem.getStatus() && oldItem.getProgress() == newItem.getProgress() && Intrinsics.b(oldItem.getUpdateTimeStamp(), newItem.getUpdateTimeStamp());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(DownloadBean oldItem, DownloadBean newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getResourceId(), newItem.getResourceId());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55720a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55720a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55720a;
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
            this.f55720a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(List<? extends DownloadBean> list) {
        List<DownloadBean> listL;
        ArrayList arrayList;
        List<DownloadBean> listD;
        List<DownloadBean> listD2;
        com.transsion.postdetail.ui.adapter.a aVar = this.f55714c;
        if (aVar != null && (listD2 = aVar.D()) != null && listD2.isEmpty()) {
            com.transsion.postdetail.ui.adapter.a aVar2 = this.f55714c;
            if (aVar2 != null) {
                aVar2.w0(list);
                return;
            }
            return;
        }
        com.transsion.postdetail.ui.adapter.a aVar3 = this.f55714c;
        if (aVar3 == null || (listL = aVar3.D()) == null) {
            listL = kotlin.collections.g.l();
        }
        Integer numValueOf = null;
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj : list) {
                if (!listL.contains((DownloadBean) obj)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            uo.b.a.f(uo.b.f78622a, this.f55712a, "全部去重了~", false, 4, null);
            return;
        }
        com.transsion.postdetail.ui.adapter.a aVar4 = this.f55714c;
        if (aVar4 != null) {
            aVar4.m(arrayList);
        }
        uo.b.a aVar5 = uo.b.f78622a;
        String str = this.f55712a;
        com.transsion.postdetail.ui.adapter.a aVar6 = this.f55714c;
        if (aVar6 != null && (listD = aVar6.D()) != null) {
            numValueOf = Integer.valueOf(listD.size());
        }
        uo.b.a.f(aVar5, str, "3--fragment, on get series from net, totalSize = " + numValueOf, false, 4, null);
    }

    private final void o0() {
        com.transsion.postdetail.ui.adapter.a aVar = new com.transsion.postdetail.ui.adapter.a(new ArrayList(), true);
        aVar.B0(new f9.d() { // from class: com.transsion.postdetail.ui.fragment.u
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                LocalVideoMiddleSeriesListFragment.p0(this.f55933a, baseQuickAdapter, view, i11);
            }
        });
        aVar.o0(new b());
        this.f55714c = aVar;
    }

    public static final void p0(LocalVideoMiddleSeriesListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || adapter.D().isEmpty()) {
            return;
        }
        Object obj = adapter.D().get(i11);
        Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
        DownloadBean downloadBean = (DownloadBean) obj;
        uo.b.a aVar = uo.b.f78622a;
        String str = this$0.f55712a;
        DownloadBean downloadBean2 = this$0.f55718h;
        Integer numValueOf = downloadBean2 != null ? Integer.valueOf(downloadBean2.getEpse()) : null;
        DownloadBean downloadBean3 = this$0.f55718h;
        String resourceId = downloadBean3 != null ? downloadBean3.getResourceId() : null;
        uo.b.a.f(aVar, str, "item click, current epse = " + numValueOf + ",resourceId=" + resourceId + ",  click epse = " + downloadBean.getEpse() + ",resourceId=" + downloadBean.getResourceId(), false, 4, null);
        String resourceId2 = downloadBean.getResourceId();
        DownloadBean downloadBean4 = this$0.f55718h;
        if (Intrinsics.b(resourceId2, downloadBean4 != null ? downloadBean4.getResourceId() : null)) {
            return;
        }
        if (downloadBean.getCanPlay()) {
            this$0.f55718h = downloadBean;
        }
        Function2<? super DownloadBean, ? super Integer, Unit> function2 = this$0.f55719i;
        if (function2 != null) {
            function2.invoke(downloadBean, Integer.valueOf(i11));
        }
    }

    private final void q0() {
        RecyclerView recyclerView;
        tv.k mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f77812c) == null) {
            return;
        }
        int iA = com.blankj.utilcode.util.f0.a(4.0f);
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
        int i11 = iA * 2;
        int i12 = iA * 3;
        recyclerView.addItemDecoration(new ro.a(i11, i11, i12, i12));
        recyclerView.setAdapter(this.f55714c);
    }

    public static final void r0(LocalVideoMiddleSeriesListFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        u0(this$0, false, 1, null);
    }

    public static /* synthetic */ void u0(LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        localVideoMiddleSeriesListFragment.t0(z11);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        androidx.lifecycle.c0<DownloadBean> c0VarD;
        androidx.lifecycle.c0<DownloadBean> c0VarE;
        androidx.lifecycle.c0<List<DownloadBean>> c0VarH;
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            LocalVideoDetailViewModel localVideoDetailViewModel = (LocalVideoDetailViewModel) new androidx.lifecycle.v0(activity, new androidx.lifecycle.v0.d()).a(LocalVideoDetailViewModel.class);
            this.f55715d = localVideoDetailViewModel;
            if (localVideoDetailViewModel != null && (c0VarH = localVideoDetailViewModel.h()) != null) {
                c0VarH.j(activity, new c(new Function1<List<? extends DownloadBean>, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoMiddleSeriesListFragment$initData$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends DownloadBean> list) {
                        invoke2(list);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<? extends DownloadBean> list) {
                        uo.b.a.f(uo.b.f78622a, this.this$0.f55712a, "2--fragment, on get series from local, size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
                        this.this$0.A0(list);
                        DownloadBean downloadBean = this.this$0.f55718h;
                        if (downloadBean != null) {
                            this.this$0.v0(downloadBean);
                        }
                    }
                }));
            }
            LocalVideoDetailViewModel localVideoDetailViewModel2 = this.f55715d;
            if (localVideoDetailViewModel2 != null && (c0VarE = localVideoDetailViewModel2.e()) != null) {
                c0VarE.j(activity, new c(new Function1<DownloadBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoMiddleSeriesListFragment$initData$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                        invoke2(downloadBean);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DownloadBean downloadBean) {
                        com.transsion.postdetail.ui.adapter.a aVar;
                        List<DownloadBean> listD;
                        List<DownloadBean> listD2;
                        int size = 0;
                        if (downloadBean != null) {
                            downloadBean.setPlaying(false);
                        }
                        com.transsion.postdetail.ui.adapter.a aVar2 = this.this$0.f55714c;
                        int i11 = -1;
                        if (aVar2 != null && (listD2 = aVar2.D()) != null) {
                            Iterator<DownloadBean> it = listD2.iterator();
                            int i12 = 0;
                            while (it.hasNext()) {
                                if (Intrinsics.b(it.next().getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                                    i11 = i12;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i11 >= 0) {
                            com.transsion.postdetail.ui.adapter.a aVar3 = this.this$0.f55714c;
                            if (aVar3 != null && (listD = aVar3.D()) != null) {
                                size = listD.size();
                            }
                            if (i11 >= size || (aVar = this.this$0.f55714c) == null) {
                                return;
                            }
                            aVar.notifyItemChanged(i11, Boolean.FALSE);
                        }
                    }
                }));
            }
            LocalVideoDetailViewModel localVideoDetailViewModel3 = this.f55715d;
            if (localVideoDetailViewModel3 == null || (c0VarD = localVideoDetailViewModel3.d()) == null) {
                return;
            }
            c0VarD.j(activity, new c(new Function1<DownloadBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoMiddleSeriesListFragment$initData$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                    invoke2(downloadBean);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DownloadBean downloadBean) {
                    com.transsion.postdetail.ui.adapter.a aVar;
                    List<DownloadBean> listD;
                    List<DownloadBean> listD2;
                    if (downloadBean != null) {
                        downloadBean.setPlaying(true);
                    }
                    com.transsion.postdetail.ui.adapter.a aVar2 = this.this$0.f55714c;
                    int i11 = -1;
                    int size = 0;
                    if (aVar2 != null && (listD2 = aVar2.D()) != null) {
                        Iterator<DownloadBean> it = listD2.iterator();
                        int i12 = 0;
                        while (it.hasNext()) {
                            if (Intrinsics.b(it.next().getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                                i11 = i12;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i11 >= 0) {
                        com.transsion.postdetail.ui.adapter.a aVar3 = this.this$0.f55714c;
                        if (aVar3 != null && (listD = aVar3.D()) != null) {
                            size = listD.size();
                        }
                        if (i11 >= size || (aVar = this.this$0.f55714c) == null) {
                            return;
                        }
                        aVar.notifyItemChanged(i11, Boolean.TRUE);
                    }
                }
            }));
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        AppCompatImageView appCompatImageView;
        Intrinsics.g(view, "view");
        o0();
        q0();
        tv.k mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatImageView = mViewBinding.f77811b) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LocalVideoMiddleSeriesListFragment.r0(this.f55931a, view2);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public tv.k getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tv.k kVarC = tv.k.c(inflater);
        Intrinsics.f(kVarC, "inflate(inflater)");
        return kVarC;
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i11, boolean z11, int i12) {
        return z11 ? AnimationUtils.loadAnimation(getActivity(), R$anim.enter_bottom_menu) : AnimationUtils.loadAnimation(getActivity(), R$anim.exit_bottom_menu);
    }

    public final boolean s0() {
        return this.f55716f;
    }

    public final void t0(boolean z11) {
        if (!this.f55716f || z11) {
            this.f55716f = true;
            try {
                FragmentManager parentFragmentManager = getParentFragmentManager();
                parentFragmentManager.popBackStack();
                FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
                Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
                fragmentTransactionBeginTransaction.remove(this);
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            } catch (Throwable unused) {
            }
        }
    }

    public final void v0(DownloadBean downloadBean) {
        List<DownloadBean> listD;
        List<DownloadBean> listD2;
        com.transsion.postdetail.ui.adapter.a aVar = this.f55714c;
        int i11 = -1;
        int size = 0;
        if (aVar != null && (listD2 = aVar.D()) != null) {
            Iterator<DownloadBean> it = listD2.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                if (Intrinsics.b(it.next().getResourceId(), downloadBean.getResourceId())) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
        }
        if (i11 > 0) {
            com.transsion.postdetail.ui.adapter.a aVar2 = this.f55714c;
            if (aVar2 != null && (listD = aVar2.D()) != null) {
                size = listD.size();
            }
            if (i11 < size) {
                w0(i11);
            }
        }
    }

    public final void w0(int i11) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        uo.b.a.s(uo.b.f78622a, this.f55712a, "seriesScrollToPosition = " + i11, false, 4, null);
        if (i11 < 0) {
            return;
        }
        try {
            tv.k mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView2 = mViewBinding.f77812c) != null) {
                recyclerView2.scrollToPosition(i11);
            }
            tv.k mViewBinding2 = getMViewBinding();
            RecyclerView.m layoutManager = (mViewBinding2 == null || (recyclerView = mViewBinding2.f77812c) == null) ? null : recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                ((GridLayoutManager) layoutManager).scrollToPositionWithOffset(i11, this.f55713b);
            }
        } catch (Throwable unused) {
        }
    }

    public final void x0(DownloadBean downloadBean, String pageFrom) {
        Intrinsics.g(pageFrom, "pageFrom");
        this.f55718h = downloadBean;
        this.f55717g = pageFrom;
    }

    public final void y0(Function2<? super DownloadBean, ? super Integer, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f55719i = callback;
    }

    public final void z0(Fragment fragment, int i11) {
        Intrinsics.g(fragment, "fragment");
        if (this.f55716f) {
            this.f55716f = false;
            try {
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                Intrinsics.f(childFragmentManager, "fragment.childFragmentManager");
                FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
                Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
                fragmentTransactionBeginTransaction.replace(i11, this, "LocalVideoMiddleSeriesList");
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            } catch (Throwable unused) {
            }
        }
    }
}
