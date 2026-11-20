package com.transsion.search.fragment.values;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import bx.l;
import com.alibaba.android.arouter.facade.Postcard;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.report.h;
import com.transsion.baselib.utils.m;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.AccurateSubject;
import com.transsion.search.bean.Count;
import com.transsion.search.bean.Pager;
import com.transsion.search.bean.SearchSubject;
import com.transsion.search.bean.SearchWorkEntity;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsion.search.widget.AccurateSubjectView;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;

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
public final class SearchValuesTypeFragment extends LazyFragment<l> {
    public static final a B = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SearchViewModel f57618o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ix.a f57621r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Count f57624u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SearchWorkEntity f57625v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AccurateSubject f57627x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f57628y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f57629z;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f57619p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f57620q = 12;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f57622s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f57623t = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<SearchSubject> f57626w = new ArrayList();
    public final pp.a A = new pp.a();

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
    public static final class b implements pp.a.b {
        public b() {
        }

        @Override // pp.a.b
        public int a() {
            List<SearchSubject> listD;
            ix.a aVar = SearchValuesTypeFragment.this.f57621r;
            if (aVar == null || (listD = aVar.D()) == null) {
                return 0;
            }
            return listD.size();
        }

        @Override // pp.a.b
        public void onItemViewVisible(boolean z11, int i11) {
            List<SearchSubject> listD;
            if (z11) {
                ix.a aVar = SearchValuesTypeFragment.this.f57621r;
                SearchSubject searchSubject = (aVar == null || (listD = aVar.D()) == null) ? null : (SearchSubject) CollectionsKt___CollectionsKt.h0(listD, i11);
                SearchValuesFragment.f57605t.d("", searchSubject != null ? searchSubject.getSubjectId() : null, "", searchSubject != null ? searchSubject.getOps() : null, i11, 3);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57631a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57631a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57631a;
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
            this.f57631a.invoke(obj);
        }
    }

    public static final void b1(SearchValuesTypeFragment this$0, AccurateSubject accurateSubject, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.o1(accurateSubject.getSubject(), 0, 4);
    }

    private final String d1() {
        String strW0;
        Fragment parentFragment = getParentFragment();
        SearchValuesFragment searchValuesFragment = parentFragment instanceof SearchValuesFragment ? (SearchValuesFragment) parentFragment : null;
        return (searchValuesFragment == null || (strW0 = searchValuesFragment.W0()) == null) ? "" : strW0;
    }

    public static final void h1(SearchValuesTypeFragment this$0, BaseQuickAdapter adapter, View view, int i11) throws InterruptedException {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (view.getId() != R$id.llDownload || com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        Object obj = adapter.D().get(i11);
        this$0.c1(obj instanceof Subject ? (Subject) obj : null);
    }

    public static final void i1(SearchValuesTypeFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.k1();
    }

    public static final void j1(SearchValuesTypeFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<SearchSubject> listD;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        ix.a aVar = this$0.f57621r;
        p1(this$0, (aVar == null || (listD = aVar.D()) == null) ? null : listD.get(i11), i11, 0, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k1() {
        RecyclerView recyclerView;
        Integer subjectType;
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
            l lVar = (l) getMViewBinding();
            if (lVar == null || (recyclerView = lVar.f14511b) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: com.transsion.search.fragment.values.f
                @Override // java.lang.Runnable
                public final void run() {
                    SearchValuesTypeFragment.l1(this.f57638a);
                }
            }, 300L);
            return;
        }
        SearchViewModel searchViewModel = this.f57618o;
        if (searchViewModel != null) {
            int i11 = this.f57619p;
            int i12 = this.f57620q;
            String strD1 = d1();
            Count count = this.f57624u;
            searchViewModel.v(i11, i12, strD1, (count == null || (subjectType = count.getSubjectType()) == null) ? 0 : subjectType.intValue());
        }
    }

    public static final void l1(SearchValuesTypeFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        ix.a aVar = this$0.f57621r;
        if (aVar == null || (fVarQ = aVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    private final void n1() {
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.search.fragment.values.SearchValuesTypeFragment$observeAddToDownload$1
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
                ix.a aVar;
                List<SearchSubject> listD;
                Intrinsics.g(value, "value");
                try {
                    ix.a aVar2 = this.this$0.f57621r;
                    int i11 = -1;
                    if (aVar2 != null && (listD = aVar2.D()) != null) {
                        Iterator<SearchSubject> it = listD.iterator();
                        int i12 = 0;
                        while (it.hasNext()) {
                            if (Intrinsics.b(it.next().getSubjectId(), value.getSubjectId())) {
                                i11 = i12;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i11 < 0 || (aVar = this.this$0.f57621r) == null) {
                        return;
                    }
                    ix.a aVar3 = this.this$0.f57621r;
                    aVar.notifyItemChanged(i11 + (aVar3 != null ? aVar3.K() : 0));
                } catch (Exception unused) {
                    uo.b.a.f(uo.b.f78622a, AppLovinEventTypes.USER_EXECUTED_SEARCH, " callback change data fail", false, 4, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public static /* synthetic */ void p1(SearchValuesTypeFragment searchValuesTypeFragment, SearchSubject searchSubject, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i12 = 3;
        }
        searchValuesTypeFragment.o1(searchSubject, i11, i12);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        Integer subjectType;
        super.D0();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("extend_value_keyword");
            if (string == null) {
                string = "";
            } else {
                Intrinsics.f(string, "getString(EXTEND_VALUE_KEYWORD) ?: \"\"");
            }
            this.f57622s = string;
            Serializable serializable = arguments.getSerializable("extend_value_count");
            this.f57624u = serializable instanceof Count ? (Count) serializable : null;
            this.f57623t = arguments.getInt("extend_value_type");
        }
        SearchWorkEntity searchWorkEntity = this.f57625v;
        if (searchWorkEntity != null) {
            Count count = this.f57624u;
            if (count != null && (subjectType = count.getSubjectType()) != null && subjectType.intValue() == 0) {
                List<SearchSubject> items = searchWorkEntity.getItems();
                if (!items.isEmpty()) {
                    Iterator<T> it = items.iterator();
                    while (it.hasNext()) {
                        this.f57626w.add((SearchSubject) it.next());
                    }
                }
            }
            this.f57627x = searchWorkEntity.getAccurateSubject();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        List<SearchSubject> listD;
        ix.a aVar = this.f57621r;
        if (aVar == null || (listD = aVar.D()) == null || !listD.isEmpty()) {
            k1();
        } else {
            uo.b.a.f(uo.b.f78622a, AppLovinEventTypes.USER_EXECUTED_SEARCH, "SearchValuesTypeFragment --> retryLoadData() --> 重新连接网络的时候 加载数据", false, 4, null);
            lazyLoadData();
        }
    }

    public final void a1() {
        SearchWorkEntity searchWorkEntity = this.f57625v;
        final AccurateSubject accurateSubject = searchWorkEntity != null ? searchWorkEntity.getAccurateSubject() : null;
        if (accurateSubject != null) {
            Context context = getContext();
            AccurateSubjectView accurateSubjectView = context != null ? new AccurateSubjectView(context) : null;
            if (accurateSubjectView != null) {
                ix.a aVar = this.f57621r;
                if (aVar != null) {
                    BaseQuickAdapter.q(aVar, accurateSubjectView, 0, 0, 6, null);
                }
                accurateSubjectView.setData(accurateSubject);
                accurateSubjectView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.values.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchValuesTypeFragment.b1(this.f57639a, accurateSubject, view);
                    }
                });
            }
        }
    }

    public final void c1(Subject subject) throws InterruptedException {
        String str;
        boolean z11;
        List<ResourceDetectors> resourceDetectors;
        String resourceLink;
        String subjectId;
        Context itt;
        List<ResourceDetectors> resourceDetectors2;
        String resourceId;
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context context = getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                h logViewConfig = getLogViewConfig();
                downloadManagerApiA.a2(fragmentActivity, logViewConfig != null ? logViewConfig.f() : null, (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        if (m.f51320a.b()) {
            f1(subject);
            return;
        }
        String str2 = "";
        if (subject == null || (resourceDetectors2 = subject.getResourceDetectors()) == null) {
            str = "";
            z11 = false;
        } else {
            if (!resourceDetectors2.isEmpty()) {
                resourceId = resourceDetectors2.get(0).getResourceId();
                if (resourceId == null) {
                    resourceId = "";
                }
                Integer type = resourceDetectors2.get(0).getType();
                boolean z12 = (type != null && type.intValue() == 1) || resourceDetectors2.get(0).isMultiResolution();
                z11 = z12;
                str = resourceId;
            } else {
                resourceId = "";
            }
            z11 = z12;
            str = resourceId;
        }
        DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
        if (DownloadManagerApi.n2(aVar.a(), subject != null ? subject.getSubjectId() : null, str, z11, false, 8, null)) {
            if (subject == null || (subjectId = subject.getSubjectId()) == null || (itt = getContext()) == null) {
                return;
            }
            DownloadManagerApi downloadManagerApiA2 = aVar.a();
            Intrinsics.f(itt, "itt");
            h logViewConfig2 = getLogViewConfig();
            DownloadManagerApi.p2(downloadManagerApiA2, subjectId, itt, logViewConfig2 != null ? logViewConfig2.f() : null, null, 8, null);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && (true ^ resourceDetectors.isEmpty()) && (resourceLink = resourceDetectors.get(0).getResourceLink()) != null) {
                str2 = resourceLink;
            }
            String str3 = str2;
            DownloadManagerApi downloadManagerApiA3 = aVar.a();
            Context context2 = getContext();
            Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentActivity fragmentActivity2 = (FragmentActivity) context2;
            h logViewConfig3 = getLogViewConfig();
            downloadManagerApiA3.P1(fragmentActivity2, subject, logViewConfig3 != null ? logViewConfig3.f() : null, (960 & 8) != 0 ? "" : "", subject != null ? subject.getOps() : null, str3, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : "download_subject", (960 & 256) != 0 ? null : null, (960 & 512) != 0 ? false : false);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public l getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        l lVarC = l.c(inflater);
        Intrinsics.f(lVarC, "inflate(inflater)");
        return lVarC;
    }

    public final void f1(Subject subject) {
        if (subject == null) {
            return;
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/playvideo/detail");
        Integer subjectType = subject.getSubjectType();
        postcardB.withInt("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).withString("id", subject.getSubjectId()).withString("ops", subject.getOps()).navigation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g1() {
        RecyclerView recyclerView;
        l lVar = (l) getMViewBinding();
        if (lVar == null || (recyclerView = lVar.f14511b) == null) {
            return;
        }
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
        Context context = recyclerView.getContext();
        Intrinsics.f(context, "context");
        ix.a aVar = new ix.a(context);
        aVar.Q().C(new f9.f() { // from class: com.transsion.search.fragment.values.c
            @Override // f9.f
            public final void a() {
                SearchValuesTypeFragment.i1(this.f57635a);
            }
        });
        aVar.B0(new f9.d() { // from class: com.transsion.search.fragment.values.d
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SearchValuesTypeFragment.j1(this.f57636a, baseQuickAdapter, view, i11);
            }
        });
        aVar.i(R$id.llDownload);
        aVar.z0(new f9.b() { // from class: com.transsion.search.fragment.values.e
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) throws InterruptedException {
                SearchValuesTypeFragment.h1(this.f57637a, baseQuickAdapter, view, i11);
            }
        });
        this.f57621r = aVar;
        recyclerView.setAdapter(aVar);
        recyclerView.addItemDecoration(new ro.b(f0.a(4.0f), f0.a(4.0f), f0.a(16.0f), f0.a(16.0f)));
        this.A.n(recyclerView, new b());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        SearchViewModel searchViewModel = (SearchViewModel) new v0(this).a(SearchViewModel.class);
        searchViewModel.o().j(getViewLifecycleOwner(), new c(new Function1<SearchWorkEntity, Unit>() { // from class: com.transsion.search.fragment.values.SearchValuesTypeFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchWorkEntity searchWorkEntity) {
                invoke2(searchWorkEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SearchWorkEntity searchWorkEntity) {
                h9.f fVarQ;
                this.this$0.f57629z = false;
                this.this$0.F0();
                if (searchWorkEntity == null) {
                    ix.a aVar = this.this$0.f57621r;
                    if (aVar == null || (fVarQ = aVar.Q()) == null) {
                        return;
                    }
                    fVarQ.u();
                    return;
                }
                Integer subjectType = searchWorkEntity.getSubjectType();
                Count count = this.this$0.f57624u;
                if (Intrinsics.b(subjectType, count != null ? count.getSubjectType() : null)) {
                    this.this$0.q1(searchWorkEntity);
                }
            }
        }));
        this.f57618o = searchViewModel;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View l0(boolean z11) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        StateView stateView = new StateView(contextRequireContext);
        stateView.showData(2, u0(), A0(), t0(), k0());
        return stateView;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        Integer subjectType;
        Integer subjectType2;
        Count count = this.f57624u;
        if (count != null && (subjectType2 = count.getSubjectType()) != null && subjectType2.intValue() == 0) {
            this.f57619p = 2;
            ix.a aVar = this.f57621r;
            if (aVar != null) {
                aVar.w0(this.f57626w);
            }
            a1();
            return;
        }
        uo.b.a aVar2 = uo.b.f78622a;
        int i11 = this.f57619p;
        int i12 = this.f57620q;
        String strD1 = d1();
        Count count2 = this.f57624u;
        uo.b.a.f(aVar2, AppLovinEventTypes.USER_EXECUTED_SEARCH, "SearchValuesTypeFragment --> loadDefaultData() -->  page = " + i11 + " -- perPage = " + i12 + " -- mKeyWord = " + strD1 + " -- mCount?.subjectType = " + (count2 != null ? count2.getSubjectType() : null), false, 4, null);
        if (m1()) {
            return;
        }
        K0();
        if (this.f57629z) {
            uo.b.a.j(aVar2, AppLovinEventTypes.USER_EXECUTED_SEARCH, "SearchValuesTypeFragment --> loadDefaultData() --> isLoading == true", false, 4, null);
            return;
        }
        this.f57629z = true;
        SearchViewModel searchViewModel = this.f57618o;
        if (searchViewModel != null) {
            int i13 = this.f57619p;
            int i14 = this.f57620q;
            String strD2 = d1();
            Count count3 = this.f57624u;
            searchViewModel.v(i13, i14, strD2, (count3 == null || (subjectType = count3.getSubjectType()) == null) ? 0 : subjectType.intValue());
        }
    }

    public final boolean m1() {
        ix.a aVar;
        List<SearchSubject> listD;
        if (com.tn.lib.util.networkinfo.f.f49475a.e() || (aVar = this.f57621r) == null || (listD = aVar.D()) == null || !listD.isEmpty()) {
            return false;
        }
        PageStatusFragment.N0(this, false, 1, null);
        return true;
    }

    public final void o1(SearchSubject searchSubject, int i11, int i12) {
        String deeplink;
        Uri uriD;
        if (searchSubject != null) {
            if (i11 >= 0) {
                SearchValuesFragment.a aVar = SearchValuesFragment.f57605t;
                aVar.b("", searchSubject.getSubjectId(), "", searchSubject.getOps(), i11, i12, aVar.a(), (128 & 128) != 0 ? null : null);
            }
            if (searchSubject.getViewType() == 1) {
                VerticalRank verticalRank = searchSubject.getVerticalRank();
                if (verticalRank == null || (deeplink = verticalRank.getDeeplink()) == null || (uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(deeplink))) == null) {
                    return;
                }
                com.alibaba.android.arouter.launcher.a.d().a(uriD).navigation();
                return;
            }
            if (this.f57623t != 3) {
                cw.a aVar2 = new cw.a();
                aVar2.o(3);
                aVar2.n(1);
                aVar2.s(searchSubject);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = cw.a.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, aVar2, 0L);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            Integer subjectType = searchSubject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value) {
                Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
                Integer subjectType2 = searchSubject.getSubjectType();
                postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("id", searchSubject.getSubjectId()).withString("ops", searchSubject.getOps()).navigation();
            } else {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context context = getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                h logViewConfig = getLogViewConfig();
                downloadManagerApiA.a2(fragmentActivity, logViewConfig != null ? logViewConfig.f() : null, (384 & 4) != 0 ? "" : "", searchSubject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : searchSubject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.A.d();
        ix.a aVar = this.f57621r;
        if (aVar != null) {
            aVar.w0(null);
        }
        this.f57629z = false;
        this.f57619p = 1;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ix.a aVar;
        List<SearchSubject> listD;
        super.onResume();
        if (m1() || (aVar = this.f57621r) == null || (listD = aVar.D()) == null || !listD.isEmpty() || this.f57619p != 1) {
            return;
        }
        E0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        if (this.f57628y == null) {
            this.f57628y = LayoutInflater.from(requireContext()).inflate(R$layout.loading_search_values_type_fragment_layout, (ViewGroup) o0(), false);
        }
        return this.f57628y;
    }

    public final void q1(SearchWorkEntity searchWorkEntity) {
        ix.a aVar;
        List<SearchSubject> listD;
        h9.f fVarQ;
        ix.a aVar2;
        h9.f fVarQ2;
        ix.a aVar3;
        h9.f fVarQ3;
        Pager pager;
        Pager pager2;
        Pager pager3;
        h9.f fVarQ4;
        ix.a aVar4 = this.f57621r;
        if (aVar4 != null && (fVarQ4 = aVar4.Q()) != null) {
            fVarQ4.r();
        }
        this.f57619p = (searchWorkEntity == null || (pager3 = searchWorkEntity.getPager()) == null) ? 1 : pager3.getNextPage();
        this.f57620q = (searchWorkEntity == null || (pager2 = searchWorkEntity.getPager()) == null) ? 10 : pager2.getPerPage();
        List<SearchSubject> items = searchWorkEntity != null ? searchWorkEntity.getItems() : null;
        boolean hasMore = (searchWorkEntity == null || (pager = searchWorkEntity.getPager()) == null) ? false : pager.getHasMore();
        List<SearchSubject> list = items;
        if ((list == null || list.isEmpty()) && (aVar = this.f57621r) != null && (listD = aVar.D()) != null && listD.isEmpty()) {
            PageStatusFragment.H0(this, false, 1, null);
        }
        if (list == null || list.isEmpty()) {
            ix.a aVar5 = this.f57621r;
            if (aVar5 != null && (fVarQ = aVar5.Q()) != null) {
                fVarQ.s(false);
            }
        } else {
            ix.a aVar6 = this.f57621r;
            if (aVar6 != null) {
                aVar6.m(list);
            }
        }
        if (!hasMore && (aVar3 = this.f57621r) != null && (fVarQ3 = aVar3.Q()) != null) {
            fVarQ3.s(false);
        }
        if (searchWorkEntity != null || (aVar2 = this.f57621r) == null || (fVarQ2 = aVar2.Q()) == null) {
            return;
        }
        fVarQ2.u();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public int u0() {
        return 3;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        g1();
        n1();
    }
}
