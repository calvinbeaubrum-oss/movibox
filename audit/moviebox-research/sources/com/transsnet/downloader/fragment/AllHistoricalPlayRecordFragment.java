package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import com.transsnet.downloader.dialog.DownloadConfirmDialog;
import com.transsnet.downloader.dialog.DownloadMoreDialog;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

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
public class AllHistoricalPlayRecordFragment extends PageStatusFragment<h00.t> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.transsnet.downloader.adapter.a f60606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f60607l = FragmentViewModelLazyKt.a(this, Reflection.b(HistoricalPlayRecordViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f60608m = FragmentViewModelLazyKt.a(this, Reflection.b(DownloadViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$special$$inlined$activityViewModels$default$3
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$special$$inlined$activityViewModels$default$4
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

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f60609n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f60610o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public BiddingListManager f60611p;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60612a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60612a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60612a;
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
            this.f60612a.invoke(obj);
        }
    }

    private final void j1() {
        BiddingListManager biddingListManager = new BiddingListManager();
        h00.t mViewBinding = getMViewBinding();
        biddingListManager.F(mViewBinding != null ? mViewBinding.f66027b : null);
        biddingListManager.A(androidx.lifecycle.v.a(this));
        biddingListManager.G("ALLHistoricalPlayRecordScene");
        biddingListManager.z(new Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$initAd$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.transsion.ad.bidding.nativead.c cVar) {
                invoke(num.intValue(), cVar);
                return Unit.f68710a;
            }

            public final void invoke(int i11, com.transsion.ad.bidding.nativead.c wrapperNativeManager) {
                List<T> listD;
                Intrinsics.g(wrapperNativeManager, "wrapperNativeManager");
                if (wrapperNativeManager != null) {
                    AllHistoricalPlayRecordFragment allHistoricalPlayRecordFragment = this.this$0;
                    HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity = new HistoricalPlayRecordMultipleEntity(3, null, null, wrapperNativeManager, 6, null);
                    com.transsnet.downloader.adapter.a aVarG1 = allHistoricalPlayRecordFragment.g1();
                    int size = (aVarG1 == null || (listD = aVarG1.D()) == 0) ? 0 : listD.size();
                    if (i11 <= size) {
                        com.transsnet.downloader.adapter.a aVarG2 = allHistoricalPlayRecordFragment.g1();
                        if (aVarG2 != null) {
                            aVarG2.j(i11, historicalPlayRecordMultipleEntity);
                            return;
                        }
                        return;
                    }
                    com.transsnet.downloader.adapter.a aVarG3 = allHistoricalPlayRecordFragment.g1();
                    if (aVarG3 != null) {
                        aVarG3.j(size, historicalPlayRecordMultipleEntity);
                    }
                }
            }
        });
        this.f60611p = biddingListManager;
    }

    public static final void k1(final AllHistoricalPlayRecordFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.v1(true, new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$initListener$1$1$1$1
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
                HistoricalPlayRecordViewModel historicalPlayRecordViewModelH1 = this.this$0.h1();
                final AllHistoricalPlayRecordFragment allHistoricalPlayRecordFragment = this.this$0;
                historicalPlayRecordViewModelH1.q(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$initListener$1$1$1$1.1
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
                        allHistoricalPlayRecordFragment.b1();
                    }
                });
            }
        });
    }

    public static final void m1(AllHistoricalPlayRecordFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.r1(adapter, view, i11);
    }

    public static final void n1(AllHistoricalPlayRecordFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.r1(adapter, view, i11);
    }

    public static final void o1(AllHistoricalPlayRecordFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        HistoricalPlayRecordViewModel.I(this$0.h1(), false, false, 3, null);
    }

    public static final void t1(AllHistoricalPlayRecordFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.e1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        HistoricalPlayRecordViewModel.I(h1(), false, false, 3, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b1() {
        List<T> listD;
        try {
            Result.Companion companion = Result.Companion;
            com.transsnet.downloader.adapter.a aVar = this.f60606k;
            if (aVar != null && (listD = aVar.D()) != 0) {
                listD.clear();
            }
            com.transsnet.downloader.adapter.a aVar2 = this.f60606k;
            Unit unit = null;
            if (aVar2 != null) {
                aVar2.w0(null);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                com.transsnet.downloader.adapter.a aVar3 = this.f60606k;
                if (aVar3 != null) {
                    aVar3.r0(l0(false));
                }
                activity.setResult(-1);
                zp.b.a aVar4 = zp.b.f82110a;
                Context context = getContext();
                aVar4.e(context != null ? context.getString(R$string.download_watch_history_cleared) : null);
                unit = Unit.f68710a;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void c1(String str) {
        Iterable iterableD;
        Collection collectionD;
        FragmentActivity activity;
        if (getActivity() != null && (activity = getActivity()) != null) {
            activity.setResult(-1);
        }
        zp.b.a aVar = zp.b.f82110a;
        Context context = getContext();
        aVar.e(context != null ? context.getString(R$string.download_delete_success) : null);
        com.transsnet.downloader.adapter.a aVar2 = this.f60606k;
        if (aVar2 == null || (iterableD = aVar2.D()) == null) {
            return;
        }
        int i11 = 0;
        HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity = null;
        int i12 = 0;
        int i13 = 0;
        for (Object obj : iterableD) {
            int i14 = i12 + 1;
            if (i12 < 0) {
                kotlin.collections.g.u();
            }
            HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity2 = (HistoricalPlayRecordMultipleEntity) obj;
            if (TextUtils.equals(historicalPlayRecordMultipleEntity2.getTitle(), str)) {
                i11++;
                i13 = i12;
                historicalPlayRecordMultipleEntity = historicalPlayRecordMultipleEntity2;
            }
            i12 = i14;
        }
        if (i11 == 1) {
            com.transsnet.downloader.adapter.a aVar3 = this.f60606k;
            if (aVar3 != null && (collectionD = aVar3.D()) != null) {
                TypeIntrinsics.a(collectionD).remove(historicalPlayRecordMultipleEntity);
            }
            com.transsnet.downloader.adapter.a aVar4 = this.f60606k;
            if (aVar4 != null) {
                aVar4.notifyItemRemoved(i13);
            }
        }
    }

    public final void d1(int i11) {
        List<T> listD;
        List<T> listD2;
        List<T> listD3;
        HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity;
        List<T> listD4;
        com.transsnet.downloader.adapter.a aVar = this.f60606k;
        if (i11 >= ((aVar == null || (listD4 = aVar.D()) == 0) ? 0 : listD4.size())) {
            return;
        }
        com.transsnet.downloader.adapter.a aVar2 = this.f60606k;
        String title = (aVar2 == null || (listD3 = aVar2.D()) == 0 || (historicalPlayRecordMultipleEntity = (HistoricalPlayRecordMultipleEntity) listD3.get(i11)) == null) ? null : historicalPlayRecordMultipleEntity.getTitle();
        com.transsnet.downloader.adapter.a aVar3 = this.f60606k;
        if (aVar3 != null && (listD2 = aVar3.D()) != 0) {
        }
        com.transsnet.downloader.adapter.a aVar4 = this.f60606k;
        if (aVar4 != null) {
            aVar4.notifyItemRemoved(i11);
        }
        com.transsnet.downloader.adapter.a aVar5 = this.f60606k;
        if (aVar5 == null || (listD = aVar5.D()) == 0 || listD.size() != 1) {
            c1(title);
        } else {
            b1();
        }
    }

    public void e1() {
        h1().A();
    }

    public final DownloadViewModel f1() {
        return (DownloadViewModel) this.f60608m.getValue();
    }

    public final com.transsnet.downloader.adapter.a g1() {
        return this.f60606k;
    }

    public String getPageName() {
        return "all_historical_page";
    }

    public final HistoricalPlayRecordViewModel h1() {
        return (HistoricalPlayRecordViewModel) this.f60607l.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
    public h00.t getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.t tVarC = h00.t.c(inflater);
        Intrinsics.f(tVarC, "inflate(inflater)");
        return tVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        TitleLayout titleLayout;
        h00.t mViewBinding = getMViewBinding();
        if (mViewBinding == null || (titleLayout = mViewBinding.f66029d) == null) {
            return;
        }
        titleLayout.setRightView(R$mipmap.ic_history_clear);
        ImageView rightImageView = titleLayout.getRightImageView();
        if (rightImageView != null) {
            w1(false);
            rightImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AllHistoricalPlayRecordFragment.k1(this.f60882a, view);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        if (this instanceof LocalFileBaseFragment) {
            h1().w().j(this, new a(new Function1<List<HistoricalPlayRecordMultipleEntity>, Unit>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment.initViewModel.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<HistoricalPlayRecordMultipleEntity> list) {
                    invoke2(list);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<HistoricalPlayRecordMultipleEntity> list) {
                    SwipeRefreshLayout swipeRefreshLayout;
                    h00.t mViewBinding = AllHistoricalPlayRecordFragment.this.getMViewBinding();
                    if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f66028c) != null && swipeRefreshLayout.isRefreshing()) {
                        h00.t mViewBinding2 = AllHistoricalPlayRecordFragment.this.getMViewBinding();
                        SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f66028c : null;
                        if (swipeRefreshLayout2 != null) {
                            swipeRefreshLayout2.setRefreshing(false);
                        }
                    }
                    if (AllHistoricalPlayRecordFragment.this.q1()) {
                        AllHistoricalPlayRecordFragment.this.F0();
                        com.transsnet.downloader.adapter.a aVarG1 = AllHistoricalPlayRecordFragment.this.g1();
                        if (aVarG1 != null) {
                            AllHistoricalPlayRecordFragment allHistoricalPlayRecordFragment = AllHistoricalPlayRecordFragment.this;
                            if (list.isEmpty()) {
                                if (aVarG1.D().isEmpty()) {
                                    aVarG1.w0(null);
                                    aVarG1.r0(allHistoricalPlayRecordFragment.l0(false));
                                }
                                h9.f.t(aVarG1.Q(), false, 1, null);
                            } else {
                                aVarG1.w0(list);
                                aVarG1.Q().r();
                            }
                            allHistoricalPlayRecordFragment.h1().J();
                        }
                    }
                }
            }));
        } else {
            h1().v().j(this, new a(new Function1<List<HistoricalPlayRecordMultipleEntity>, Unit>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment.initViewModel.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<HistoricalPlayRecordMultipleEntity> list) {
                    invoke2(list);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<HistoricalPlayRecordMultipleEntity> it) {
                    SwipeRefreshLayout swipeRefreshLayout;
                    h00.t mViewBinding = AllHistoricalPlayRecordFragment.this.getMViewBinding();
                    if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f66028c) != null && swipeRefreshLayout.isRefreshing()) {
                        h00.t mViewBinding2 = AllHistoricalPlayRecordFragment.this.getMViewBinding();
                        SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f66028c : null;
                        if (swipeRefreshLayout2 != null) {
                            swipeRefreshLayout2.setRefreshing(false);
                        }
                    }
                    if (AllHistoricalPlayRecordFragment.this.q1()) {
                        AllHistoricalPlayRecordFragment.this.F0();
                        com.transsnet.downloader.adapter.a aVarG1 = AllHistoricalPlayRecordFragment.this.g1();
                        if (aVarG1 != null) {
                            AllHistoricalPlayRecordFragment allHistoricalPlayRecordFragment = AllHistoricalPlayRecordFragment.this;
                            allHistoricalPlayRecordFragment.w1(true);
                            if (it.isEmpty()) {
                                if (aVarG1.D().isEmpty()) {
                                    allHistoricalPlayRecordFragment.w1(false);
                                    aVarG1.w0(null);
                                    aVarG1.r0(allHistoricalPlayRecordFragment.l0(false));
                                }
                                h9.f.t(aVarG1.Q(), false, 1, null);
                            } else if (allHistoricalPlayRecordFragment.f60610o) {
                                aVarG1.w0(it);
                                aVarG1.Q().r();
                            } else {
                                ArrayList arrayList = new ArrayList();
                                List<T> listD = aVarG1.D();
                                Intrinsics.f(it, "it");
                                for (HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity : it) {
                                    if (!listD.contains(historicalPlayRecordMultipleEntity)) {
                                        arrayList.add(historicalPlayRecordMultipleEntity);
                                    }
                                }
                                aVarG1.m(arrayList);
                                aVarG1.Q().r();
                            }
                            allHistoricalPlayRecordFragment.f60610o = false;
                            allHistoricalPlayRecordFragment.h1().J();
                        }
                    }
                }
            }));
            l1();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        String string = getString(R$string.download_no_historical_tips);
        Intrinsics.f(string, "getString(R.string.download_no_historical_tips)");
        return string;
    }

    public final void l1() {
        Function1<f00.d, Unit> function1 = new Function1<f00.d, Unit>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$initVideoObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f00.d dVar) {
                invoke2(dVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f00.d it) {
                Intrinsics.g(it, "it");
                try {
                    this.this$0.f60610o = true;
                    HistoricalPlayRecordViewModel.I(this.this$0.h1(), false, true, 1, null);
                    this.this$0.F0();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = f00.d.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.f60611p;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        SwipeRefreshLayout swipeRefreshLayout;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        h00.t mViewBinding = getMViewBinding();
        if (mViewBinding == null || (swipeRefreshLayout = mViewBinding.f66028c) == null) {
            return;
        }
        if (!(this instanceof LocalFileBaseFragment)) {
            swipeRefreshLayout.setEnabled(false);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(z2.a.getColor(activity, R$color.bg_01));
            swipeRefreshLayout.setColorSchemeColors(z2.a.getColor(activity, R$color.main_gradient_center), z2.a.getColor(activity, R$color.main_gradient_start));
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsnet.downloader.fragment.e
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                AllHistoricalPlayRecordFragment.t1(this.f60910a);
            }
        });
    }

    public boolean p1() {
        return false;
    }

    public final boolean q1() {
        if ((this instanceof LocalFileFragment) || (this instanceof LocalFileSingleTabFragment)) {
            return com.transsnet.downloader.viewmodel.c.f61276a.a();
        }
        return true;
    }

    public final void r1(final BaseQuickAdapter<?, ?> adapter, View view, final int i11) {
        HistoricalPlayRecordBean historical;
        VideoDetailPlayBean streamVideo;
        HistoricalPlayRecordBean historical2;
        VideoDetailPlayBean streamVideo2;
        Integer subjectType;
        DownloadBean video;
        String id2;
        VideoDetailPlayBean streamVideo3;
        HistoricalPlayRecordBean historical3;
        VideoDetailPlayBean streamVideo4;
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (i11 >= adapter.D().size()) {
            return;
        }
        if (view.getId() == R$id.ivTopRightCornerPoint) {
            v1(false, new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$onItemClick$1
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
                    if (i11 >= adapter.D().size()) {
                        return;
                    }
                    HistoricalPlayRecordViewModel historicalPlayRecordViewModelH1 = this.h1();
                    Object obj = adapter.D().get(i11);
                    HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity = obj instanceof HistoricalPlayRecordMultipleEntity ? (HistoricalPlayRecordMultipleEntity) obj : null;
                    final AllHistoricalPlayRecordFragment allHistoricalPlayRecordFragment = this;
                    final int i12 = i11;
                    historicalPlayRecordViewModelH1.p(historicalPlayRecordMultipleEntity, new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$onItemClick$1.1
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
                            allHistoricalPlayRecordFragment.d1(i12);
                        }
                    });
                }
            });
            return;
        }
        if (view.getId() == R$id.historyRoot) {
            Object obj = adapter.D().get(i11);
            String subjectId = null;
            HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity = obj instanceof HistoricalPlayRecordMultipleEntity ? (HistoricalPlayRecordMultipleEntity) obj : null;
            String downloadFilePath = (historicalPlayRecordMultipleEntity == null || (historical3 = historicalPlayRecordMultipleEntity.getHistorical()) == null || (streamVideo4 = historical3.getStreamVideo()) == null) ? null : streamVideo4.getDownloadFilePath();
            com.transsnet.downloader.viewmodel.c cVar = com.transsnet.downloader.viewmodel.c.f61276a;
            boolean zR = cVar.r(downloadFilePath);
            if ((downloadFilePath == null || downloadFilePath.length() == 0 || !zR) && (historicalPlayRecordMultipleEntity == null || historicalPlayRecordMultipleEntity.getType() != 2)) {
                Postcard postcardWithInt = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail").withInt("subject_type", (historicalPlayRecordMultipleEntity == null || (historical2 = historicalPlayRecordMultipleEntity.getHistorical()) == null || (streamVideo2 = historical2.getStreamVideo()) == null || (subjectType = streamVideo2.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
                if (historicalPlayRecordMultipleEntity != null && (historical = historicalPlayRecordMultipleEntity.getHistorical()) != null && (streamVideo = historical.getStreamVideo()) != null) {
                    subjectId = streamVideo.getSubjectId();
                }
                postcardWithInt.withString("id", subjectId).withString("module_name", getClass().getSimpleName()).navigation();
                return;
            }
            if (historicalPlayRecordMultipleEntity.getType() != 2) {
                HistoricalPlayRecordBean historical4 = historicalPlayRecordMultipleEntity.getHistorical();
                if (historical4 == null || (streamVideo3 = historical4.getStreamVideo()) == null || (id2 = streamVideo3.getId()) == null) {
                    id2 = "";
                }
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
                downloadManagerApiA.j2(fragmentActivityRequireActivity, id2, getPageName());
                return;
            }
            HistoricalPlayRecordBean historical5 = historicalPlayRecordMultipleEntity.getHistorical();
            if (historical5 != null && ((historical5.getType() == 2 || historical5.getType() == 6 || historical5.getType() == 5) && (video = historical5.getVideo()) != null && video.getFileType() == 2)) {
                DownloadBean video2 = historical5.getVideo();
                if (!cVar.r(video2 != null ? video2.getPath() : null)) {
                    HistoricalPlayRecordBean historical6 = historicalPlayRecordMultipleEntity.getHistorical();
                    if (historical6 != null) {
                        historical6.setLocalFileDelete(Boolean.TRUE);
                    }
                    com.transsnet.downloader.adapter.a aVar = this.f60606k;
                    if (aVar != null) {
                        aVar.notifyItemChanged(i11);
                        return;
                    }
                    return;
                }
            }
            HistoricalPlayRecordBean historical7 = historicalPlayRecordMultipleEntity.getHistorical();
            if (historical7 == null || !Intrinsics.b(historical7.isLocalFileDelete(), Boolean.TRUE)) {
                h1().L(historicalPlayRecordMultipleEntity, requireActivity(), getPageName());
            } else {
                zp.b.f82110a.e(getString(R$string.download_no_local_file_tips));
            }
        }
    }

    public void s1(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, int i11, final int i12) {
        DownloadMoreDialog downloadMoreDialogA = DownloadMoreDialog.f60517i.a(kotlin.collections.g.q(new Pair(Utils.a().getString(R$string.download_transfer_tips), "transfer_file_2_mb")));
        downloadMoreDialogA.s0(new Function3<Integer, String, String, Unit>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$onItemMoreClick$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
                invoke(num.intValue(), str, str2);
                return Unit.f68710a;
            }

            public final void invoke(int i13, String str, String str2) {
                Intrinsics.g(str, "<anonymous parameter 1>");
                if (Intrinsics.b(str2, "transfer_file_2_mb")) {
                    this.this$0.f1().k().q(1);
                    if (i12 >= 0) {
                        this.this$0.f1().F().q(Integer.valueOf(i12));
                    }
                }
            }
        });
        downloadMoreDialogA.k0(this, "DownloadMoreDialog");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final void u1(com.transsnet.downloader.adapter.a aVar) {
        this.f60606k = aVar;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        h00.t mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f66027b) != null) {
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
            com.transsnet.downloader.adapter.a aVar = new com.transsnet.downloader.adapter.a(p1());
            aVar.B0(new f9.d() { // from class: com.transsnet.downloader.fragment.b
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    AllHistoricalPlayRecordFragment.m1(this.f60896a, baseQuickAdapter, view, i11);
                }
            });
            aVar.i(R$id.ivTopRightCornerPoint);
            aVar.z0(new f9.b() { // from class: com.transsnet.downloader.fragment.c
                @Override // f9.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    AllHistoricalPlayRecordFragment.n1(this.f60901a, baseQuickAdapter, view, i11);
                }
            });
            if (!(this instanceof LocalFileFragment)) {
                aVar.Q().C(new f9.f() { // from class: com.transsnet.downloader.fragment.d
                    @Override // f9.f
                    public final void a() {
                        AllHistoricalPlayRecordFragment.o1(this.f60905a);
                    }
                });
            }
            this.f60606k = aVar;
            recyclerView.setAdapter(aVar);
        }
        j1();
    }

    public final void v1(boolean z11, final Function0<Unit> function0) {
        DownloadConfirmDialog downloadConfirmDialogA = DownloadConfirmDialog.f60505j.a(getString(R$string.cancel), getString(R$string.confirm), requireContext().getString(z11 ? R$string.clear_all_history_tips : R$string.clear_history_tips), null);
        downloadConfirmDialogA.r0(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment$showClearDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z12) {
                if (z12) {
                    function0.invoke();
                }
            }
        });
        downloadConfirmDialogA.j0(getContext(), "confirm_Dialog");
    }

    public final void w1(boolean z11) {
        TitleLayout titleLayout;
        h00.t mViewBinding = getMViewBinding();
        ImageView rightImageView = (mViewBinding == null || (titleLayout = mViewBinding.f66029d) == null) ? null : titleLayout.getRightImageView();
        if (rightImageView == null) {
            return;
        }
        rightImageView.setVisibility(z11 ? 0 : 8);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }
}
