package com.transsion.home.category.fragment;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.google.android.material.appbar.AppBarLayout;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.bean.CategoryBean;
import com.transsion.home.category.CategoryActivity;
import com.transsion.home.viewmodel.CategoryViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.CategoryItemBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class CategoryFragment extends PageStatusFragment<lt.h> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f52339r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f52340s = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CategoryViewModel f52341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public kt.e f52342l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f52343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f52344n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public nt.b f52345o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f52346p = LazyKt__LazyJVMKt.b(new Function0<com.transsion.home.utils.b>() { // from class: com.transsion.home.category.fragment.CategoryFragment$categoryDotHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.home.utils.b invoke() {
            return new com.transsion.home.utils.b();
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public BiddingListManager f52347q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Fragment a(String str, String str2) {
            Bundle bundleA = androidx.core.os.c.a();
            bundleA.putString("category_type", str);
            if (str2 == null) {
                str2 = "1";
            }
            bundleA.putString("showType", str2);
            CategoryFragment categoryFragment = new CategoryFragment();
            categoryFragment.setArguments(bundleA);
            return categoryFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements nt.a {
        public b() {
        }

        @Override // nt.a
        public void a(int i11, long j11, View view) {
            Subject subject;
            Boolean hasResource;
            Subject subject2;
            Subject subject3;
            List<CategoryItemBean> listD;
            kt.e eVar = CategoryFragment.this.f52342l;
            if (i11 >= ((eVar == null || (listD = eVar.D()) == null) ? 0 : listD.size())) {
                return;
            }
            kt.e eVar2 = CategoryFragment.this.f52342l;
            CategoryItemBean item = eVar2 != null ? eVar2.getItem(i11) : null;
            CategoryFragment.this.d1().a(CategoryFragment.this.getPageName(), (item == null || (subject3 = item.getSubject()) == null) ? null : subject3.getSubjectId(), (item == null || (subject2 = item.getSubject()) == null) ? null : subject2.getOps(), Integer.valueOf(i11), item != null ? item.getItemType() : null, (item == null || (subject = item.getSubject()) == null || (hasResource = subject.getHasResource()) == null) ? false : hasResource.booleanValue(), CategoryFragment.this.f52343m);
        }
    }

    private final void b1(boolean z11) {
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            if (activity instanceof CategoryActivity) {
                ((CategoryActivity) activity).M(z11);
            }
        }
    }

    private final void f1(Subject subject) {
        if (subject == null) {
            return;
        }
        com.alibaba.android.arouter.launcher.a.d().b("/playvideo/detail").withString("id", subject.getSubjectId()).withInt("season", subject.getSeason()).withString("ops", g.a(subject, this.f52343m)).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPageName() {
        return "category";
    }

    private final void h1() {
        BiddingListManager biddingListManager = new BiddingListManager();
        lt.h mViewBinding = getMViewBinding();
        biddingListManager.F(mViewBinding != null ? mViewBinding.f70445f : null);
        biddingListManager.A(v.a(this));
        biddingListManager.G("PlayListScene");
        biddingListManager.z(new Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit>() { // from class: com.transsion.home.category.fragment.CategoryFragment$initAd$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.transsion.ad.bidding.nativead.c cVar) {
                invoke(num.intValue(), cVar);
                return Unit.f68710a;
            }

            public final void invoke(int i11, com.transsion.ad.bidding.nativead.c current) {
                List<CategoryItemBean> listD;
                Intrinsics.g(current, "current");
                if (current != null) {
                    CategoryFragment categoryFragment = this.this$0;
                    CategoryItemBean categoryItemBean = new CategoryItemBean(null, null, new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null), 3, null);
                    Subject subject = categoryItemBean.getSubject();
                    if (subject != null) {
                        subject.setNonAdDelegate(current);
                    }
                    kt.e eVar = categoryFragment.f52342l;
                    if (i11 < ((eVar == null || (listD = eVar.D()) == null) ? 0 : listD.size())) {
                        kt.e eVar2 = categoryFragment.f52342l;
                        if (eVar2 != null) {
                            eVar2.j(i11, categoryItemBean);
                            return;
                        }
                        return;
                    }
                    kt.e eVar3 = categoryFragment.f52342l;
                    if (eVar3 != null) {
                        eVar3.l(categoryItemBean);
                    }
                }
            }
        });
        this.f52347q = biddingListManager;
    }

    public static final void i1(CategoryFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void j1(final CategoryFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.p1();
            return;
        }
        zp.b.f82110a.d(R$string.no_network_toast);
        lt.h mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f70445f) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.category.fragment.f
            @Override // java.lang.Runnable
            public final void run() {
                CategoryFragment.k1(this.f52370a);
            }
        }, 300L);
    }

    public static final void k1(CategoryFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        kt.e eVar = this$0.f52342l;
        if (eVar == null || (fVarQ = eVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    public static final void l1(CategoryFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof CategoryItemBean) {
            this$0.g1((CategoryItemBean) item, i11);
        }
    }

    public static final void m1(CategoryFragment this$0, BaseQuickAdapter adapter, View view, int i11) throws InterruptedException {
        List<CategoryItemBean> listD;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        kt.e eVar = this$0.f52342l;
        CategoryItemBean categoryItemBean = (eVar == null || (listD = eVar.D()) == null) ? null : (CategoryItemBean) CollectionsKt___CollectionsKt.h0(listD, i11);
        if (categoryItemBean == null || view.getId() != R$id.ll_download) {
            return;
        }
        this$0.c1(categoryItemBean, i11);
    }

    public static final void n1(CategoryFragment this$0, lt.h this_apply, AppBarLayout appBarLayout, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        if (this$0.getContext() == null) {
            return;
        }
        if (Math.abs(i11) >= appBarLayout.getTotalScrollRange()) {
            this_apply.f70446g.setBackgroundColor(z2.a.getColor(this$0.requireContext(), R$color.bg_01));
            this_apply.f70443c.setImageTintList(ColorStateList.valueOf(z2.a.getColor(this$0.requireContext(), R$color.btn_back)));
            AppCompatTextView tvTitle = this_apply.f70447h;
            Intrinsics.f(tvTitle, "tvTitle");
            so.c.k(tvTitle);
            AppCompatTextView tvTitleExpand = this_apply.f70448i;
            Intrinsics.f(tvTitleExpand, "tvTitleExpand");
            so.c.g(tvTitleExpand);
            this$0.b1(true);
            return;
        }
        this_apply.f70446g.setBackgroundColor(z2.a.getColor(this$0.requireContext(), R$color.transparent));
        this_apply.f70443c.setImageTintList(ColorStateList.valueOf(z2.a.getColor(this$0.requireContext(), R$color.common_white)));
        AppCompatTextView tvTitle2 = this_apply.f70447h;
        Intrinsics.f(tvTitle2, "tvTitle");
        so.c.g(tvTitle2);
        AppCompatTextView tvTitleExpand2 = this_apply.f70448i;
        Intrinsics.f(tvTitleExpand2, "tvTitleExpand");
        so.c.k(tvTitleExpand2);
        this$0.b1(false);
    }

    private final void o1() {
        CategoryViewModel categoryViewModel = this.f52341k;
        if (categoryViewModel == null) {
            Intrinsics.y("viewModel");
            categoryViewModel = null;
        }
        String str = this.f52343m;
        if (str == null) {
            str = "Nollywood";
        }
        categoryViewModel.f(str);
    }

    private final void p1() {
        o1();
    }

    private final void q1() {
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.home.category.fragment.CategoryFragment$observeAddToDownload$1
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
                kt.e eVar;
                List<CategoryItemBean> listD;
                Intrinsics.g(value, "value");
                try {
                    kt.e eVar2 = this.this$0.f52342l;
                    int i11 = -1;
                    if (eVar2 != null && (listD = eVar2.D()) != null) {
                        Iterator<CategoryItemBean> it = listD.iterator();
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
                    if (i11 < 0 || (eVar = this.this$0.f52342l) == null) {
                        return;
                    }
                    eVar.notifyItemChanged(i11);
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    private final void reload() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            B0();
        } else {
            K0();
            O0();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            K0();
            o1();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        List<CategoryItemBean> listD;
        kt.e eVar = this.f52342l;
        if (eVar != null && (listD = eVar.D()) != null && listD.size() == 0) {
            reload();
            return;
        }
        kt.e eVar2 = this.f52342l;
        if (eVar2 == null || eVar2.Q().i() != LoadMoreStatus.Fail) {
            return;
        }
        eVar2.Q().v();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0054  */
    /* JADX WARN: Code duplicated, block: B:14:0x005e  */
    /* JADX WARN: Code duplicated, block: B:15:0x0066  */
    /* JADX WARN: Code duplicated, block: B:17:0x006e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0074  */
    /* JADX WARN: Code duplicated, block: B:23:0x0084  */
    /* JADX WARN: Code duplicated, block: B:28:0x0091  */
    /* JADX WARN: Code duplicated, block: B:31:0x009c  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e4  */
    public final void c1(CategoryItemBean categoryItemBean, int i11) throws InterruptedException {
        DownloadManagerApi.a aVar;
        DownloadManagerApi downloadManagerApiA;
        String subjectId;
        String resourceId;
        boolean z11;
        String resourceLink;
        Subject subject;
        String str;
        ResourceDetectors resourceDetector;
        String subjectId2;
        ResourceDetectors resourceDetector2;
        Boolean hasResource;
        Context context = getContext();
        if (context != null) {
            Subject subject2 = categoryItemBean.getSubject();
            if (subject2 != null) {
                Integer subjectType = subject2.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    DownloadManagerApi downloadManagerApiA2 = DownloadManagerApi.f60274j.a();
                    Context context2 = getContext();
                    Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    downloadManagerApiA2.a2((FragmentActivity) context2, "playlist", (384 & 4) != 0 ? "" : "", g.a(subject2, this.f52343m), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : subject2, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                    str = "download_subject";
                    subject = subject2;
                } else if (com.transsion.baselib.utils.m.f51320a.b()) {
                    f1(subject2);
                    subject = subject2;
                    str = "play_subject";
                } else {
                    aVar = DownloadManagerApi.f60274j;
                    downloadManagerApiA = aVar.a();
                    if (subject2 != null) {
                        subjectId = subject2.getSubjectId();
                    } else {
                        subjectId = null;
                    }
                    if (subject2 != null || (resourceDetector2 = subject2.getResourceDetector()) == null) {
                        resourceId = null;
                    } else {
                        resourceId = resourceDetector2.getResourceId();
                    }
                    if (subject2 == null && subject2.isSeries()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (DownloadManagerApi.n2(downloadManagerApiA, subjectId, resourceId, z11, false, 8, null)) {
                        if (subject2 == null && (subjectId2 = subject2.getSubjectId()) != null) {
                            DownloadManagerApi.p2(aVar.a(), subjectId2, context, "playlist", null, 8, null);
                        }
                        str = "play_subject";
                        subject = subject2;
                    } else {
                        DownloadManagerApi downloadManagerApiA3 = aVar.a();
                        FragmentActivity fragmentActivityRequireActivity = requireActivity();
                        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
                        String strA = g.a(subject2, this.f52343m);
                        if (subject2 != null || (resourceDetector = subject2.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
                            resourceLink = "";
                        }
                        subject = subject2;
                        downloadManagerApiA3.P1(fragmentActivityRequireActivity, subject2, "playlist", (960 & 8) != 0 ? "" : null, strA, resourceLink, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : null, (960 & 512) != 0 ? false : false);
                        str = "download_subject";
                    }
                }
            } else if (com.transsion.baselib.utils.m.f51320a.b()) {
                f1(subject2);
                subject = subject2;
                str = "play_subject";
            } else {
                aVar = DownloadManagerApi.f60274j;
                downloadManagerApiA = aVar.a();
                if (subject2 != null) {
                    subjectId = subject2.getSubjectId();
                } else {
                    subjectId = null;
                }
                if (subject2 != null) {
                    resourceId = null;
                } else {
                    resourceId = null;
                }
                if (subject2 == null) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                if (DownloadManagerApi.n2(downloadManagerApiA, subjectId, resourceId, z11, false, 8, null)) {
                    if (subject2 == null) {
                    }
                    str = "play_subject";
                    subject = subject2;
                } else {
                    DownloadManagerApi downloadManagerApiA4 = aVar.a();
                    FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
                    Intrinsics.f(fragmentActivityRequireActivity2, "requireActivity()");
                    String strA2 = g.a(subject2, this.f52343m);
                    if (subject2 != null) {
                        resourceLink = "";
                    } else {
                        resourceLink = "";
                    }
                    subject = subject2;
                    downloadManagerApiA4.P1(fragmentActivityRequireActivity2, subject2, "playlist", (960 & 8) != 0 ? "" : null, strA2, resourceLink, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : null, (960 & 512) != 0 ? false : false);
                    str = "download_subject";
                }
            }
            d1().c("playlist", str, subject != null ? subject.getSubjectId() : null, subject != null ? subject.getOps() : null, Integer.valueOf(i11), categoryItemBean.getItemType(), (subject == null || (hasResource = subject.getHasResource()) == null) ? false : hasResource.booleanValue(), this.f52343m);
        }
    }

    public final com.transsion.home.utils.b d1() {
        return (com.transsion.home.utils.b) this.f52346p.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public lt.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        lt.h hVarC = lt.h.c(inflater);
        Intrinsics.f(hVarC, "inflate(inflater)");
        return hVarC;
    }

    public final void g1(CategoryItemBean categoryItemBean, int i11) {
        Integer subjectType;
        Boolean hasResource;
        Subject subject = categoryItemBean.getSubject();
        if (subject == null || !subject.isShortTV()) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
            Subject subject2 = categoryItemBean.getSubject();
            Postcard postcardWithInt = postcardB.withInt("subject_type", (subject2 == null || (subjectType = subject2.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
            Subject subject3 = categoryItemBean.getSubject();
            Postcard postcardWithString = postcardWithInt.withString("id", subject3 != null ? subject3.getSubjectId() : null);
            Subject subject4 = categoryItemBean.getSubject();
            postcardWithString.withInt("season", subject4 != null ? subject4.getSeason() : 0).withString("ops", g.a(categoryItemBean.getSubject(), this.f52343m)).navigation();
        } else {
            DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
            Context context = getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            downloadManagerApiA.a2((FragmentActivity) context, getPageName(), (384 & 4) != 0 ? "" : "", g.a(categoryItemBean.getSubject(), this.f52343m), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : categoryItemBean.getSubject(), (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
        }
        com.transsion.home.utils.b bVarD1 = d1();
        String pageName = getPageName();
        Subject subject5 = categoryItemBean.getSubject();
        String subjectId = subject5 != null ? subject5.getSubjectId() : null;
        Subject subject6 = categoryItemBean.getSubject();
        String ops = subject6 != null ? subject6.getOps() : null;
        Integer numValueOf = Integer.valueOf(i11);
        String itemType = categoryItemBean.getItemType();
        Subject subject7 = categoryItemBean.getSubject();
        bVarD1.b(pageName, subjectId, ops, numValueOf, itemType, (subject7 == null || (hasResource = subject7.getHasResource()) == null) ? false : hasResource.booleanValue(), this.f52343m);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        CategoryViewModel categoryViewModel = (CategoryViewModel) new v0(this).a(CategoryViewModel.class);
        this.f52341k = categoryViewModel;
        if (categoryViewModel == null) {
            Intrinsics.y("viewModel");
            categoryViewModel = null;
        }
        categoryViewModel.g().j(this, new g.a(new Function1<BaseDto<CategoryBean>, Unit>() { // from class: com.transsion.home.category.fragment.CategoryFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseDto<CategoryBean> baseDto) {
                invoke2(baseDto);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseDto<CategoryBean> baseDto) {
                List<CategoryItemBean> listD;
                HashMap<String, String> mapG;
                Pager pager;
                kt.e eVar;
                h9.f fVarQ;
                h9.f fVarQ2;
                kt.e eVar2;
                h9.f fVarQ3;
                CategoryBean data;
                List<CategoryItemBean> list;
                uo.b.a.f(uo.b.f78622a, "CategoryFragment", "return code=" + (baseDto != null ? baseDto.getCode() : null) + " size=" + ((baseDto == null || (data = baseDto.getData()) == null || (list = data.getList()) == null) ? null : Integer.valueOf(list.size())), false, 4, null);
                if (baseDto == null) {
                    return;
                }
                CategoryFragment.this.F0();
                kt.e eVar3 = CategoryFragment.this.f52342l;
                if (eVar3 != null && (fVarQ2 = eVar3.Q()) != null && fVarQ2.q() && (eVar2 = CategoryFragment.this.f52342l) != null && (fVarQ3 = eVar2.Q()) != null) {
                    fVarQ3.r();
                }
                if (Intrinsics.b(baseDto.getCode(), "0")) {
                    CategoryBean data2 = baseDto.getData();
                    if (data2 != null && (pager = data2.getPager()) != null && Intrinsics.b(pager.getHasMore(), Boolean.FALSE) && (eVar = CategoryFragment.this.f52342l) != null && (fVarQ = eVar.Q()) != null) {
                        h9.f.t(fVarQ, false, 1, null);
                    }
                    CategoryFragment.this.r1(baseDto.getData());
                    com.transsion.baselib.report.h logViewConfig = CategoryFragment.this.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    com.transsion.baselib.report.h logViewConfig2 = CategoryFragment.this.getLogViewConfig();
                    if (logViewConfig2 != null) {
                        CategoryBean data3 = baseDto.getData();
                        logViewConfig2.m(data3 != null ? data3.getOps() : null);
                    }
                } else {
                    kt.e eVar4 = CategoryFragment.this.f52342l;
                    if (eVar4 != null && (listD = eVar4.D()) != null && listD.size() == 0) {
                        PageStatusFragment.H0(CategoryFragment.this, false, 1, null);
                    }
                }
                com.transsion.baselib.report.h logViewConfig3 = CategoryFragment.this.getLogViewConfig();
                if (logViewConfig3 == null || (mapG = logViewConfig3.g()) == null) {
                    return;
                }
                mapG.put("category_type", CategoryFragment.this.f52343m);
            }
        }));
        q1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.f52347q;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        CategoryViewModel categoryViewModel = this.f52341k;
        if (categoryViewModel == null) {
            Intrinsics.y("viewModel");
            categoryViewModel = null;
        }
        categoryViewModel.k(1);
        CategoryViewModel categoryViewModel2 = this.f52341k;
        if (categoryViewModel2 == null) {
            Intrinsics.y("viewModel");
            categoryViewModel2 = null;
        }
        categoryViewModel2.g().q(null);
        super.onDestroyView();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        nt.b bVar = this.f52345o;
        if (bVar != null) {
            bVar.e();
        }
    }

    public final void r1(CategoryBean categoryBean) {
        lt.h mViewBinding;
        List<CategoryItemBean> listD;
        String url;
        Subject subject;
        Cover cover;
        String thumbnail;
        Subject subject2;
        Cover cover2;
        List<CategoryItemBean> listD2;
        kt.e eVar;
        if (categoryBean == null || (mViewBinding = getMViewBinding()) == null) {
            return;
        }
        mViewBinding.f70447h.setText(categoryBean.getDesc());
        mViewBinding.f70448i.setText(categoryBean.getDesc());
        List<CategoryItemBean> list = categoryBean.getList();
        if (list != null && (eVar = this.f52342l) != null) {
            eVar.m(list);
        }
        kt.e eVar2 = this.f52342l;
        if (eVar2 == null || (listD = eVar2.D()) == null || !(!listD.isEmpty())) {
            return;
        }
        kt.e eVar3 = this.f52342l;
        CategoryItemBean categoryItemBean = (eVar3 == null || (listD2 = eVar3.D()) == null) ? null : listD2.get(0);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        AppCompatImageView ivCover = mViewBinding.f70444d;
        Intrinsics.f(ivCover, "ivCover");
        if (categoryItemBean == null || (subject2 = categoryItemBean.getSubject()) == null || (cover2 = subject2.getCover()) == null || (url = cover2.getUrl()) == null) {
            url = "";
        }
        companion.q(contextRequireContext, ivCover, url, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (categoryItemBean == null || (subject = categoryItemBean.getSubject()) == null || (cover = subject.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        Toolbar toolbar;
        lt.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (toolbar = mViewBinding.f70446g) != null) {
            so.c.e(toolbar);
        }
        C0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void w0(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        Bundle arguments = getArguments();
        this.f52343m = arguments != null ? arguments.getString("category_type") : null;
        Bundle arguments2 = getArguments();
        this.f52344n = arguments2 != null ? arguments2.getString("showType") : null;
        ArrayList arrayList = new ArrayList();
        final lt.h mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f70443c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.category.fragment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CategoryFragment.i1(this.f52364a, view2);
                }
            });
            RecyclerView recyclerView = mViewBinding.f70445f;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            nt.b bVar = new nt.b(0.6f, new b(), false, 4, null);
            bVar.l(2);
            recyclerView.addOnScrollListener(bVar);
            this.f52345o = bVar;
            kt.e eVar = new kt.e(arrayList, getPageName(), this.f52345o, this.f52344n);
            eVar.Q().y(true);
            eVar.Q().x(true);
            eVar.Q().C(new f9.f() { // from class: com.transsion.home.category.fragment.b
                @Override // f9.f
                public final void a() {
                    CategoryFragment.j1(this.f52365a);
                }
            });
            eVar.B0(new f9.d() { // from class: com.transsion.home.category.fragment.c
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                    CategoryFragment.l1(this.f52366a, baseQuickAdapter, view2, i11);
                }
            });
            eVar.i(R$id.ll_download);
            eVar.z0(new f9.b() { // from class: com.transsion.home.category.fragment.d
                @Override // f9.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) throws InterruptedException {
                    CategoryFragment.m1(this.f52367a, baseQuickAdapter, view2, i11);
                }
            });
            this.f52342l = eVar;
            recyclerView.setAdapter(eVar);
            mViewBinding.f70442b.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.home.category.fragment.e
                @Override // com.google.android.material.appbar.AppBarLayout.b
                public final void a(AppBarLayout appBarLayout, int i11) {
                    CategoryFragment.n1(this.f52368a, mViewBinding, appBarLayout, i11);
                }
            });
        }
        h1();
    }
}
