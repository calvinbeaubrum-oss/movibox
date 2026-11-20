package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.viewmodel.PostRecommendFragmentViewModel;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
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
public final class PostRecommendFragment extends BaseListFragment<PostSubjectItem> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f55774x = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public zr.b f55775p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public uv.a f55776q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f55777r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f55778s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f55779t = 8;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f55780u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f55781v = LazyKt__LazyJVMKt.b(new Function0<PostRecommendFragmentViewModel>() { // from class: com.transsion.postdetail.ui.fragment.PostRecommendFragment$mViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PostRecommendFragmentViewModel invoke() {
            return new PostRecommendFragmentViewModel();
        }
    });

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BiddingListManager f55782w;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PostRecommendFragment a(String str) {
            PostRecommendFragment postRecommendFragment = new PostRecommendFragment();
            Bundle bundle = new Bundle();
            bundle.putString("post_subject_id", str);
            postRecommendFragment.setArguments(bundle);
            return postRecommendFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements zr.a {
        public b() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            PostRecommendFragment postRecommendFragment = PostRecommendFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                if (postRecommendFragment.W0() instanceof com.transsion.postdetail.ui.adapter.c) {
                    uo.b.a.f(uo.b.f78622a, zr.b.f82141j.a(), "exposure position  " + i11, false, 4, null);
                    uv.a aVar = postRecommendFragment.f55776q;
                    if (aVar != null) {
                        BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapterW0 = postRecommendFragment.W0();
                        Intrinsics.e(baseQuickAdapterW0, "null cannot be cast to non-null type com.transsion.postdetail.ui.adapter.PostRecommendAdapter");
                        aVar.a((com.transsion.postdetail.ui.adapter.c) baseQuickAdapterW0, i11, j11);
                    }
                }
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55784a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55784a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55784a;
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
            this.f55784a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.PostRecommendFragment$initViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 extends Lambda implements Function1<PostSubjectBean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        public static final void b(PostRecommendFragment this$0) {
            Intrinsics.g(this$0, "this$0");
            this$0.j1();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PostSubjectBean postSubjectBean) {
            invoke2(postSubjectBean);
            return Unit.f68710a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PostSubjectBean postSubjectBean) {
            List<PostSubjectItem> items;
            ConstraintLayout root;
            Pager pager;
            Boolean boolValueOf = null;
            if (postSubjectBean != null && (pager = postSubjectBean.getPager()) != null && Intrinsics.b(pager.getHasMore(), Boolean.FALSE)) {
                BaseListFragment.l1(PostRecommendFragment.this, false, 1, null);
            }
            if (postSubjectBean != null && (items = postSubjectBean.getItems()) != null) {
                final PostRecommendFragment postRecommendFragment = PostRecommendFragment.this;
                if (items.isEmpty()) {
                    BaseListFragment.l1(postRecommendFragment, false, 1, null);
                    if (postRecommendFragment.isEmpty()) {
                        PageStatusFragment.H0(postRecommendFragment, false, 1, null);
                        return;
                    }
                    return;
                }
                BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapterW0 = postRecommendFragment.W0();
                if (baseQuickAdapterW0 != null) {
                    baseQuickAdapterW0.m(items);
                }
                fs.a aVar = (fs.a) postRecommendFragment.getMViewBinding();
                if (aVar != null && (root = aVar.getRoot()) != null) {
                    boolValueOf = Boolean.valueOf(root.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.k0
                        @Override // java.lang.Runnable
                        public final void run() {
                            PostRecommendFragment.AnonymousClass1.b(postRecommendFragment);
                        }
                    }, 300L));
                }
                if (boolValueOf != null) {
                    return;
                }
            }
            PostRecommendFragment.this.v1();
            Unit unit = Unit.f68710a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B1() {
        BiddingListManager biddingListManager = new BiddingListManager();
        this.f55782w = biddingListManager;
        fs.a aVar = (fs.a) getMViewBinding();
        biddingListManager.F(aVar != null ? aVar.f65251d : null);
        BiddingListManager biddingListManager2 = this.f55782w;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.lifecycle.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.f55782w;
        if (biddingListManager3 != null) {
            biddingListManager3.G("PostDetailRecommendScene");
        }
        BiddingListManager biddingListManager4 = this.f55782w;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostRecommendFragment$initAd$1
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
                        PostRecommendFragment postRecommendFragment = this.this$0;
                        PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, null, false, null, false, 1073741823, null);
                        postSubjectItem.setNonAdDelegate(current);
                        BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapterW0 = postRecommendFragment.W0();
                        int size = (baseQuickAdapterW0 == null || (listD = baseQuickAdapterW0.D()) == null) ? 0 : listD.size();
                        if (i11 <= size) {
                            BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapterW1 = postRecommendFragment.W0();
                            if (baseQuickAdapterW1 != null) {
                                baseQuickAdapterW1.j(i11, postSubjectItem);
                                return;
                            }
                            return;
                        }
                        BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapterW2 = postRecommendFragment.W0();
                        if (baseQuickAdapterW2 != null) {
                            baseQuickAdapterW2.j(size, postSubjectItem);
                        }
                    }
                }
            });
        }
    }

    public static final void D1(PostRecommendFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        uo.b.a.f(uo.b.f78622a, zr.b.f82141j.a(), "position " + i11, false, 4, null);
        Object item = adapter.getItem(i11);
        if (item instanceof PostSubjectItem) {
            PostSubjectItem postSubjectItem = (PostSubjectItem) item;
            this$0.G1(postSubjectItem);
            uv.a aVar = this$0.f55776q;
            if (aVar != null) {
                aVar.b(i11, postSubjectItem);
            }
        }
    }

    public static final void E1(PostRecommendFragment this$0, BaseQuickAdapter adapter, View view, int i11) throws InterruptedException {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (view.getId() == R$id.llDownload) {
            this$0.z1(adapter, view, i11);
        }
    }

    private final void F1() {
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity != null) {
            Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostRecommendFragment$observeAddToDownload$1
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
                    BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapterW0;
                    List<PostSubjectItem> listD;
                    Intrinsics.g(value, "value");
                    try {
                        BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapterW1 = this.this$0.W0();
                        int i11 = -1;
                        if (baseQuickAdapterW1 != null && (listD = baseQuickAdapterW1.D()) != null) {
                            Iterator<PostSubjectItem> it = listD.iterator();
                            int i12 = 0;
                            while (it.hasNext()) {
                                Subject subject = it.next().getSubject();
                                if (Intrinsics.b(subject != null ? subject.getSubjectId() : null, value.getSubjectId())) {
                                    i11 = i12;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i11 < 0 || (baseQuickAdapterW0 = this.this$0.W0()) == null) {
                            return;
                        }
                        baseQuickAdapterW0.notifyItemChanged(i11 + 1);
                    } catch (Exception unused) {
                        uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                    }
                }
            };
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = AddToDownloadEvent.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.observeEvent(appCompatActivity, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
        }
    }

    private final String getPageName() {
        return "post_detail_recommend";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    public final PostRecommendFragmentViewModel A1() {
        return (PostRecommendFragmentViewModel) this.f55781v.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        A1().d(this.f55780u, this.f55777r, this.f55778s, this.f55779t);
        this.f55778s++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C1() {
        fs.a aVar;
        RecyclerView recyclerView;
        this.f55776q = new uv.a("post_recommend", this.f55780u);
        zr.b bVar = new zr.b(0.6f, new b(), false, 4, null);
        this.f55775p = bVar;
        bVar.n(2);
        zr.b bVar2 = this.f55775p;
        if (bVar2 == null || (aVar = (fs.a) getMViewBinding()) == null || (recyclerView = aVar.f65251d) == null) {
            return;
        }
        recyclerView.addOnScrollListener(bVar2);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        n1();
    }

    public final void G1(PostSubjectItem postSubjectItem) {
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_tips);
            return;
        }
        ((IPostDetailApi) com.alibaba.android.arouter.launcher.a.d().h(IPostDetailApi.class)).f0(postSubjectItem);
        com.alibaba.android.arouter.launcher.a aVarD = com.alibaba.android.arouter.launcher.a.d();
        Media media = postSubjectItem.getMedia();
        Postcard postcardWithString = aVarD.b(Intrinsics.b(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue()) ? "/post/detailVideo" : "/post/detail").withString(WebConstants.PAGE_FROM, getPageName()).withString("id", postSubjectItem.getPostId()).withString("item_type", postSubjectItem.getItemType());
        Media media2 = postSubjectItem.getMedia();
        postcardWithString.withString("media_type", media2 != null ? media2.getMediaType() : null).withBoolean("from_comment", false).navigation();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter<PostSubjectItem, BaseViewHolder> T0() {
        return new com.transsion.postdetail.ui.adapter.c(new ArrayList(), this.f55775p);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void e1() {
        RecyclerView recyclerView;
        super.e1();
        BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapterW0 = W0();
        if (baseQuickAdapterW0 != null) {
            View inflate = LayoutInflater.from(requireActivity()).inflate(R$layout.item_provider_post_recommend_for_you, (ViewGroup) null);
            Intrinsics.f(inflate, "inflate");
            BaseQuickAdapter.q(baseQuickAdapterW0, inflate, 0, 0, 6, null);
            baseQuickAdapterW0.q0(R$layout.item_recommend_empty_layout);
            baseQuickAdapterW0.B0(new f9.d() { // from class: com.transsion.postdetail.ui.fragment.i0
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    PostRecommendFragment.D1(this.f55890a, baseQuickAdapter, view, i11);
                }
            });
            baseQuickAdapterW0.i(R$id.llDownload);
            baseQuickAdapterW0.z0(new f9.b() { // from class: com.transsion.postdetail.ui.fragment.j0
                @Override // f9.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) throws InterruptedException {
                    PostRecommendFragment.E1(this.f55893a, baseQuickAdapter, view, i11);
                }
            });
        }
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar == null || (recyclerView = aVar.f65251d) == null) {
            return;
        }
        recyclerView.addItemDecoration(new ro.g(com.blankj.utilcode.util.f0.a(16.0f), 0, 2, null));
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        B0();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        super.initListener();
        F1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        A1().e().j(this, new c(new AnonymousClass1()));
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Object objM163constructorimpl;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                Result.Companion companion = Result.Companion;
                String string = arguments.getString("post_subject_id");
                if (string == null) {
                    string = "";
                } else {
                    Intrinsics.f(string, "it.getString(POST_SUBJECT_ID) ?: \"\"");
                }
                this.f55780u = string;
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            Result.m162boximpl(objM163constructorimpl);
        }
        C1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.f55782w;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        zr.b bVar = this.f55775p;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        U0();
        b1();
        B1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return true;
    }

    public final void z1(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i11) throws InterruptedException {
        String resourceLink;
        User user;
        Subject subject;
        ResourceDetectors resourceDetector;
        Group group;
        Subject subject2;
        Subject subject3;
        String subjectId;
        Context context;
        Subject subject4;
        Subject subject5;
        ResourceDetectors resourceDetector2;
        Subject subject6;
        Object item = baseQuickAdapter.getItem(i11);
        String nickname = null;
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
        DownloadManagerApi downloadManagerApiA = aVar.a();
        String subjectId2 = (postSubjectItem == null || (subject6 = postSubjectItem.getSubject()) == null) ? null : subject6.getSubjectId();
        String resourceId = (postSubjectItem == null || (subject5 = postSubjectItem.getSubject()) == null || (resourceDetector2 = subject5.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId();
        boolean z11 = false;
        if (postSubjectItem != null && (subject4 = postSubjectItem.getSubject()) != null && subject4.isSeries()) {
            z11 = true;
        }
        if (DownloadManagerApi.n2(downloadManagerApiA, subjectId2, resourceId, z11, false, 8, null)) {
            if (postSubjectItem == null || (subject3 = postSubjectItem.getSubject()) == null || (subjectId = subject3.getSubjectId()) == null || (context = getContext()) == null) {
                return;
            }
            DownloadManagerApi downloadManagerApiA2 = aVar.a();
            Intrinsics.f(context, "this");
            DownloadManagerApi.p2(downloadManagerApiA2, subjectId, context, getPageName(), null, 8, null);
            return;
        }
        if (postSubjectItem != null && (subject2 = postSubjectItem.getSubject()) != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi downloadManagerApiA3 = aVar.a();
                Context context2 = getContext();
                Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context2;
                String pageName = getPageName();
                Group group2 = postSubjectItem.getGroup();
                downloadManagerApiA3.a2(fragmentActivity, pageName, (384 & 4) != 0 ? "" : group2 != null ? group2.getGroupId() : null, postSubjectItem.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : postSubjectItem.getSubject(), (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        DownloadManagerApi downloadManagerApiA4 = aVar.a();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        Subject subject7 = postSubjectItem != null ? postSubjectItem.getSubject() : null;
        String pageName2 = getPageName();
        String groupId = (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getGroupId();
        String ops = postSubjectItem != null ? postSubjectItem.getOps() : null;
        if (postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
            resourceLink = "";
        }
        String str = resourceLink;
        if (postSubjectItem != null && (user = postSubjectItem.getUser()) != null) {
            nickname = user.getNickname();
        }
        downloadManagerApiA4.P1(fragmentActivityRequireActivity, subject7, pageName2, (960 & 8) != 0 ? "" : groupId, ops, str, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : nickname, (960 & 512) != 0 ? false : false);
    }
}
