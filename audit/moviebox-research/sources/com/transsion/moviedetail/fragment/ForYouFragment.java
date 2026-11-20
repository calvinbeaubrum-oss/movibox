package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.adapter.ForYouAdapter;
import com.transsion.moviedetail.adapter.ForYouEduAdapter;
import com.transsion.moviedetail.view.ForYouLoadMoreView;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
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
public final class ForYouFragment extends PageStatusFragment<tu.f> implements qz.a {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f53462z = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zr.b f53463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f53464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f53465m;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public BaseQuickAdapter<Subject, BaseViewHolder> f53470r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f53471s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f53472t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f53473u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f53474v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f53475w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f53476x;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HashSet<String> f53466n = new HashSet<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f53467o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f53468p = 30;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f53469q = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.ForYouFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.moviedetail.fragment.ForYouFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f53477y = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ForYouFragment a(String str, Integer num, String str2, String str3, boolean z11, boolean z12) {
            ForYouFragment forYouFragment = new ForYouFragment();
            Bundle bundle = new Bundle();
            bundle.putString("subjectId", str);
            bundle.putString("ops", str2);
            bundle.putString("page_name", str3);
            bundle.putBoolean("isLocalVideo", z11);
            bundle.putBoolean("isOutsideVideo", z12);
            if (num != null) {
                bundle.putInt("subjectType", num.intValue());
            }
            forYouFragment.setArguments(bundle);
            return forYouFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView f53478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function2<Integer, Long, Unit> f53479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseArray<Long> f53480c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f53481d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f53482e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f53483f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<? extends Subject> f53484g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f53485h;

        /* JADX WARN: Multi-variable type inference failed */
        public b(RecyclerView recyclerView, Function2<? super Integer, ? super Long, Unit> callback) {
            Intrinsics.g(recyclerView, "recyclerView");
            Intrinsics.g(callback, "callback");
            this.f53478a = recyclerView;
            this.f53479b = callback;
            this.f53480c = new SparseArray<>();
            this.f53481d = -1;
            this.f53482e = -1;
            this.f53483f = 3;
            List<? extends Subject> listEmptyList = Collections.emptyList();
            Intrinsics.f(listEmptyList, "emptyList()");
            this.f53484g = listEmptyList;
            this.f53485h = com.blankj.utilcode.util.i.e(40.0f);
        }

        public final void a() {
            IntIterator intIteratorA = androidx.core.util.k.a(this.f53480c);
            while (intIteratorA.hasNext()) {
                b(intIteratorA.next().intValue());
            }
            this.f53480c.clear();
        }

        public final void b(int i11) {
            uo.b.a.o(uo.b.f78622a, "Foryou", new String[]{"reportItemView line:" + i11}, false, 4, null);
            Long l11 = this.f53480c.get(i11);
            if (l11 != null) {
                long jLongValue = l11.longValue();
                if (jLongValue > 0) {
                    int i12 = this.f53483f;
                    int i13 = i12 * (i11 + 1);
                    for (int i14 = i12 * i11; i14 < i13; i14++) {
                        this.f53479b.invoke(Integer.valueOf(i14), Long.valueOf(SystemClock.elapsedRealtime() - jLongValue));
                    }
                }
            }
        }

        public final void c() {
            d(this.f53481d, this.f53482e);
        }

        public final void d(int i11, int i12) {
            if (i11 < 0 || i12 < 0) {
                return;
            }
            this.f53481d = i11;
            this.f53482e = i12;
            uo.b.a.o(uo.b.f78622a, "Foryou", new String[]{"scrollWithLine startLine:" + i11 + ", endLine:" + i12}, false, 4, null);
            ArrayList arrayList = new ArrayList();
            IntIterator intIteratorA = androidx.core.util.k.a(this.f53480c);
            while (intIteratorA.hasNext()) {
                int iIntValue = intIteratorA.next().intValue();
                int i13 = this.f53481d;
                if (iIntValue >= this.f53482e || i13 > iIntValue) {
                    b(iIntValue);
                    arrayList.add(Integer.valueOf(iIntValue));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f53480c.remove(((Number) it.next()).intValue());
            }
            int i14 = this.f53482e;
            for (int i15 = this.f53481d; i15 < i14; i15++) {
                if (this.f53480c.get(i15) == null) {
                    this.f53480c.put(i15, Long.valueOf(SystemClock.elapsedRealtime()));
                }
            }
        }

        public final void e(List<? extends Subject> list) {
            a();
            if (list == null) {
                list = Collections.emptyList();
                Intrinsics.f(list, "emptyList()");
            }
            this.f53484g = list;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements zr.a {
        public c() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            ForYouFragment forYouFragment = ForYouFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                forYouFragment.n1(i11, j11);
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53487a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53487a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53487a;
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
            this.f53487a.invoke(obj);
        }
    }

    private final void X0() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ImageView imageView = this.f53464l;
        if (imageView == null || (viewPropertyAnimatorAnimate = imageView.animate()) == null) {
            return;
        }
        viewPropertyAnimatorAnimate.cancel();
    }

    public static final void Y0(ForYouFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.E0();
    }

    public static final void a1(ForYouFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.E0();
    }

    private final MovieDetailViewModel b1() {
        return (MovieDetailViewModel) this.f53469q.getValue();
    }

    private final void g1() {
        Integer num = this.f53473u;
        int value = SubjectType.EDUCATION.getValue();
        if (num != null && num.intValue() == value) {
            kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new ForYouFragment$initData$1(this, null), 3, null);
        }
    }

    private final void h1() {
        RecyclerView recyclerView;
        zr.b bVar = new zr.b(0.6f, new c(), false, 4, null);
        bVar.n(2);
        tu.f mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f77479b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.f53463k = bVar;
    }

    public static final void i1(ForYouFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.k1();
    }

    public static final void j1(ForYouFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Subject item;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter2 = this$0.f53470r;
        if (baseQuickAdapter2 == null || (item = baseQuickAdapter2.getItem(i11)) == null) {
            return;
        }
        this$0.f1(item);
        this$0.o1(i11, item);
    }

    private final void l1() {
        zr.b bVar = this.f53463k;
        if (bVar != null) {
            bVar.f();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        com.transsion.postdetail.helper.a.f55063a.p(m1(), "for_you", jElapsedRealtime - (logViewConfig != null ? logViewConfig.h() : 0L), getLogViewConfig());
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0052  */
    private final void lazyLoadData() {
        boolean z11;
        if (getParentFragment() != null) {
            b1().o().j(this, new d(new Function1<List<? extends Subject>, Unit>() { // from class: com.transsion.moviedetail.fragment.ForYouFragment$lazyLoadData$1$1$1
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
                    this.this$0.p1(list);
                }
            }));
            if (this.f53474v) {
                if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter = this.f53470r;
                    if (baseQuickAdapter != null) {
                        baseQuickAdapter.r0(r0(false));
                        return;
                    }
                    return;
                }
                MovieDetailViewModel movieDetailViewModelB1 = b1();
                boolean z12 = this.f53475w;
                String str = this.f53472t;
                Integer num = this.f53473u;
                Context context = getContext();
                if (context != null) {
                    Intrinsics.f(context, "context");
                    z11 = com.transsion.baseui.util.b.a(context);
                }
                movieDetailViewModelB1.g(z12, str, num, 0, z11);
            }
        }
    }

    private final String m1() {
        String str = this.f53471s;
        return str == null ? "" : str;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        lazyLoadData();
    }

    public final BaseQuickAdapter<Subject, BaseViewHolder> Z0() {
        Integer num = this.f53473u;
        return (num != null && num.intValue() == SubjectType.EDUCATION.getValue()) ? new ForYouEduAdapter(new ArrayList()) : new ForYouAdapter(new ArrayList(), this.f53473u);
    }

    public final int c1() {
        Integer num = this.f53473u;
        int value = SubjectType.MUSIC.getValue();
        if (num == null || num.intValue() != value) {
            Integer num2 = this.f53473u;
            int value2 = SubjectType.EDUCATION.getValue();
            if (num2 == null || num2.intValue() != value2) {
                return 6;
            }
        }
        return 4;
    }

    public final int d1() {
        Integer numL;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_for_you_request_count", true);
        String value = configBeanB != null ? configBeanB.getValue() : null;
        if (value == null || value.length() == 0 || (numL = kotlin.text.k.l(value)) == null) {
            return 30;
        }
        return numL.intValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public tu.f getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.f fVarC = tu.f.c(inflater);
        Intrinsics.f(fVarC, "inflate(inflater)");
        return fVarC;
    }

    public final void f1(Subject subject) {
        Integer subjectType = subject.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
            Integer subjectType2 = subject.getSubjectType();
            postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("ops", subject.getOps()).withString("id", subject.getSubjectId()).navigation();
        } else {
            DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
            Context context = getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            downloadManagerApiA.a2((FragmentActivity) context, "subjectdetail", (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        h1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    public final void k1() {
        boolean z11 = false;
        if (this.f53474v) {
            MovieDetailViewModel movieDetailViewModelB1 = b1();
            boolean z12 = this.f53475w;
            String str = this.f53472t;
            Integer num = this.f53473u;
            int i11 = this.f53467o + 1;
            this.f53467o = i11;
            Context context = getContext();
            movieDetailViewModelB1.g(z12, str, num, i11, context != null && com.transsion.baseui.util.b.a(context));
            return;
        }
        MovieDetailViewModel movieDetailViewModelB2 = b1();
        String str2 = this.f53472t;
        Integer num2 = this.f53473u;
        int i12 = this.f53467o + 1;
        this.f53467o = i12;
        Context context2 = getContext();
        if (context2 != null && com.transsion.baseui.util.b.a(context2)) {
            z11 = true;
        }
        movieDetailViewModelB2.h(str2, num2, i12, z11);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View l0(boolean z11) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_state_view, (ViewGroup) null);
        tu.x xVarA = tu.x.a(viewInflate);
        Intrinsics.f(xVarA, "bind(this)");
        xVarA.f77650b.setImageResource(R$mipmap.ic_no_content);
        xVarA.f77651c.setText(viewInflate.getResources().getString(R$string.no_content));
        xVarA.f77652d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForYouFragment.Y0(this.f53642a, view);
            }
        });
        Intrinsics.f(viewInflate, "from(context).inflate(R.…)\n            }\n        }");
        return viewInflate;
    }

    public final void n1(int i11, long j11) {
        Subject item;
        uo.b.a.f(uo.b.f78622a, "Foryou", "reportBrowseEvent position:" + i11 + ", duration:" + j11 + " ", false, 4, null);
        BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter = this.f53470r;
        if (baseQuickAdapter == null || (item = baseQuickAdapter.getItem(i11)) == null || (!this.f53466n.add(item.getSubjectId()))) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("item_type", "subject");
        linkedHashMap.put("opt_type", "");
        String subjectId = item.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        linkedHashMap.put("group_id", "");
        String ops = item.getOps();
        if (ops == null) {
            ops = "";
        }
        linkedHashMap.put("ops", ops);
        Boolean hasResource = item.getHasResource();
        linkedHashMap.put("has_resource", String.valueOf(hasResource != null ? hasResource.booleanValue() : false));
        linkedHashMap.put(WebConstants.FIELD_DEEPLINK, "");
        linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
        linkedHashMap.put("cover", "");
        linkedHashMap.put("browse_duration", String.valueOf(j11));
        linkedHashMap.put("builtin", "0");
        linkedHashMap.put("tab_name", "for_you");
        com.transsion.baselib.helper.a.f51183a.d("subjectdetail", linkedHashMap);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(m1(), false, 2, null);
    }

    @Override // qz.a
    public void o(boolean z11) {
        if (isAdded() && !isHidden() && isResumed()) {
            if (!z11) {
                logResume();
            } else {
                logPause();
                l1();
            }
        }
    }

    public final void o1(int i11, Subject subject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "subject");
        linkedHashMap.put("item_type", "subject");
        linkedHashMap.put("opt_type", "");
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        String ops = subject.getOps();
        linkedHashMap.put("ops", ops != null ? ops : "");
        Boolean hasResource = subject.getHasResource();
        linkedHashMap.put("has_resource", String.valueOf(hasResource != null ? hasResource.booleanValue() : false));
        linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
        linkedHashMap.put("builtin", "0");
        linkedHashMap.put("tab_name", "for_you");
        com.transsion.baselib.helper.a.f51183a.e("subjectdetail", linkedHashMap);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        X0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
                l1();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        l1();
        b bVar = this.f53465m;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        b bVar = this.f53465m;
        if (bVar != null) {
            bVar.c();
        }
        if (this.f53477y) {
            this.f53477y = false;
            lazyLoadData();
        }
    }

    public final void p1(List<? extends Subject> list) {
        List<Subject> listD;
        BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter;
        h9.f fVarQ;
        List<Subject> listL;
        h9.f fVarQ2;
        h9.f fVarQ3;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        List<? extends Subject> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            uo.b.a.f(uo.b.f78622a, "MovieDetailViewModel", "ForYouFragment 没有更多数据了，加载更多结束", false, 4, null);
            BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter2 = this.f53470r;
            if (baseQuickAdapter2 != null && (fVarQ = baseQuickAdapter2.Q()) != null) {
                fVarQ.s(false);
            }
            BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter3 = this.f53470r;
            if (baseQuickAdapter3 != null && (listD = baseQuickAdapter3.D()) != null && listD.isEmpty() && (baseQuickAdapter = this.f53470r) != null) {
                baseQuickAdapter.r0(l0(false));
            }
        } else {
            BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter4 = this.f53470r;
            if (baseQuickAdapter4 == null || (listL = baseQuickAdapter4.D()) == null) {
                listL = kotlin.collections.g.l();
            }
            List<Subject> list3 = listL;
            ArrayList arrayList = new ArrayList(kotlin.collections.h.v(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((Subject) it.next()).getSubjectId());
            }
            Set setO0 = CollectionsKt___CollectionsKt.O0(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (!setO0.contains(((Subject) obj).getSubjectId())) {
                    arrayList2.add(obj);
                }
            }
            BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter5 = this.f53470r;
            int itemCount = baseQuickAdapter5 != null ? baseQuickAdapter5.getItemCount() : 0;
            if (arrayList2.isEmpty() || itemCount >= this.f53468p) {
                uo.b.a.f(uo.b.f78622a, "MovieDetailViewModel", "ForYouFragment 全部去重或超出最大上限，加载更多结束 totalCount:" + itemCount, false, 4, null);
                BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter6 = this.f53470r;
                if (baseQuickAdapter6 != null && (fVarQ2 = baseQuickAdapter6.Q()) != null) {
                    fVarQ2.s(false);
                }
            } else {
                uo.b.a.f(uo.b.f78622a, "MovieDetailViewModel", "ForYouFragment count: " + (itemCount + arrayList2.size()), false, 4, null);
                BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter7 = this.f53470r;
                if (baseQuickAdapter7 != null && (fVarQ3 = baseQuickAdapter7.Q()) != null) {
                    fVarQ3.r();
                }
                BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter8 = this.f53470r;
                if (baseQuickAdapter8 != null) {
                    baseQuickAdapter8.m(CollectionsKt___CollectionsKt.M0(list2));
                }
                b bVar = this.f53465m;
                if (bVar != null) {
                    bVar.e(list);
                }
            }
        }
        X0();
        this.f53476x = false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View r0(boolean z11) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_state_view, (ViewGroup) null);
        tu.x xVarA = tu.x.a(viewInflate);
        Intrinsics.f(xVarA, "bind(this)");
        xVarA.f77652d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForYouFragment.a1(this.f53644a, view);
            }
        });
        Intrinsics.f(viewInflate, "from(context).inflate(R.…)\n            }\n        }");
        return viewInflate;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00f4  */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        HashMap<String, String> mapG;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        int i11;
        com.transsion.baselib.report.h logViewConfig;
        HashMap<String, String> mapG2;
        Bundle arguments = getArguments();
        this.f53472t = arguments != null ? arguments.getString("subjectId") : null;
        Bundle arguments2 = getArguments();
        this.f53471s = arguments2 != null ? arguments2.getString("page_name") : null;
        Bundle arguments3 = getArguments();
        this.f53473u = arguments3 != null ? Integer.valueOf(arguments3.getInt("subjectType")) : null;
        Bundle arguments4 = getArguments();
        boolean z11 = false;
        this.f53474v = arguments4 != null ? arguments4.getBoolean("isLocalVideo") : false;
        Bundle arguments5 = getArguments();
        this.f53475w = arguments5 != null ? arguments5.getBoolean("isOutsideVideo") : false;
        this.f53468p = d1();
        String str = this.f53472t;
        if (str != null && (logViewConfig = getLogViewConfig()) != null && (mapG2 = logViewConfig.g()) != null) {
            mapG2.put("subject_id", str);
        }
        BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapterZ0 = Z0();
        h9.f fVarQ = baseQuickAdapterZ0.Q();
        fVarQ.B(new ForYouLoadMoreView());
        fVarQ.y(true);
        fVarQ.x(true);
        fVarQ.D(c1());
        fVarQ.C(new f9.f() { // from class: com.transsion.moviedetail.fragment.b
            @Override // f9.f
            public final void a() {
                ForYouFragment.i1(this.f53636a);
            }
        });
        baseQuickAdapterZ0.B0(new f9.d() { // from class: com.transsion.moviedetail.fragment.c
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                ForYouFragment.j1(this.f53638a, baseQuickAdapter, view, i12);
            }
        });
        this.f53470r = baseQuickAdapterZ0;
        tu.f mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView2 = mViewBinding.f77479b) != null) {
            recyclerView2.addItemDecoration(new ro.a(gs.a.a(8), gs.a.a(8), gs.a.a(12), gs.a.a(this.f53474v ? 12 : 50)));
            Integer num = this.f53473u;
            int value = SubjectType.MUSIC.getValue();
            if (num != null && num.intValue() == value) {
                z11 = true;
            } else {
                Integer num2 = this.f53473u;
                int value2 = SubjectType.EDUCATION.getValue();
                if (num2 != null && num2.intValue() == value2) {
                    z11 = true;
                }
            }
            Context context = recyclerView2.getContext();
            if (z11) {
                i11 = 2;
            } else {
                Context context2 = recyclerView2.getContext();
                Intrinsics.f(context2, "context");
                i11 = com.transsion.baseui.util.b.a(context2) ? 4 : 3;
            }
            recyclerView2.setLayoutManager(new NpaGridLayoutManager(context, i11));
            recyclerView2.setAdapter(this.f53470r);
        }
        tu.f mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (recyclerView = mViewBinding2.f77479b) != null) {
            this.f53465m = new b(recyclerView, new Function2<Integer, Long, Unit>() { // from class: com.transsion.moviedetail.fragment.ForYouFragment$initViewData$4$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num3, Long l11) {
                    invoke(num3.intValue(), l11.longValue());
                    return Unit.f68710a;
                }

                public final void invoke(int i12, long j11) {
                    try {
                        this.this$0.n1(i12, j11);
                    } catch (Exception unused) {
                    }
                }
            });
        }
        g1();
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null || (mapG = logViewConfig2.g()) == null) {
            return;
        }
        mapG.put("subpage_name", "for_you");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }
}
