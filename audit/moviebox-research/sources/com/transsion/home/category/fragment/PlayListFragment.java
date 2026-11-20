package com.transsion.home.category.fragment;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.google.android.material.appbar.AppBarLayout;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.bean.PlayListResp;
import com.transsion.home.category.PlayListActivity;
import com.transsion.home.category.adapter.PlayListAdapter;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.home.viewmodel.PlayListViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PlayListType;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;
import org.json.JSONException;
import org.json.JSONObject;

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
public final class PlayListFragment extends PageStatusFragment<lt.m> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f52349v = new a(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f52350w = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PlayListViewModel f52351k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f52352l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f52353m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f52354n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f52355o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f52356p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public nt.b f52357q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PlayListAdapter f52358r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public kt.b f52359s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f52360t = LazyKt__LazyJVMKt.b(new Function0<com.transsion.home.utils.d>() { // from class: com.transsion.home.category.fragment.PlayListFragment$mPlayListDotHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.home.utils.d invoke() {
            return new com.transsion.home.utils.d();
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public BiddingListManager f52361u;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayListFragment a(String str, String str2, String str3, String str4, int i11) {
            PlayListFragment playListFragment = new PlayListFragment();
            playListFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("label", str), TuplesKt.a("category", str2), TuplesKt.a("recType", str3), TuplesKt.a("topIds", str4), TuplesKt.a("tabId", Integer.valueOf(i11))));
            return playListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements nt.a {
        public b() {
        }

        @Override // nt.a
        public void a(int i11, long j11, View view) {
            Boolean hasResource;
            List<Subject> listD;
            List<Staff> listD2;
            int size = 0;
            if (!PlayListFragment.this.y1()) {
                PlayListAdapter playListAdapter = PlayListFragment.this.f52358r;
                if (i11 >= ((playListAdapter == null || (listD = playListAdapter.D()) == null) ? 0 : listD.size())) {
                    return;
                }
                PlayListAdapter playListAdapter2 = PlayListFragment.this.f52358r;
                Subject item = playListAdapter2 != null ? playListAdapter2.getItem(i11) : null;
                PlayListFragment.this.k1().d("playlist", item != null ? item.getSubjectId() : null, item != null ? item.getOps() : null, Integer.valueOf(i11), (item == null || (hasResource = item.getHasResource()) == null) ? false : hasResource.booleanValue(), PlayListFragment.this.f52353m, PlayListFragment.this.f52354n, PlayListFragment.this.f52352l);
                return;
            }
            kt.b bVar = PlayListFragment.this.f52359s;
            if (bVar != null && (listD2 = bVar.D()) != null) {
                size = listD2.size();
            }
            if (i11 >= size) {
                return;
            }
            kt.b bVar2 = PlayListFragment.this.f52359s;
            Staff item2 = bVar2 != null ? bVar2.getItem(i11) : null;
            PlayListFragment.this.k1().b("playlist", item2 != null ? item2.getStaffId() : null, item2 != null ? item2.getOps() : null, Integer.valueOf(i11), PlayListFragment.this.f52353m, PlayListFragment.this.f52354n, PlayListFragment.this.f52352l);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52363a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52363a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52363a;
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
            this.f52363a.invoke(obj);
        }
    }

    private final void A1() {
        z1();
    }

    private final void B1() {
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.home.category.fragment.PlayListFragment$observeAddToDownload$1
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
                PlayListAdapter playListAdapter;
                List<Subject> listD;
                Intrinsics.g(value, "value");
                try {
                    PlayListAdapter playListAdapter2 = this.this$0.f52358r;
                    int i11 = -1;
                    if (playListAdapter2 != null && (listD = playListAdapter2.D()) != null) {
                        Iterator<Subject> it = listD.iterator();
                        int i12 = 0;
                        while (it.hasNext()) {
                            if (Intrinsics.b(it.next().getSubjectId(), value.getSubjectId())) {
                                i11 = i12;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i11 < 0 || (playListAdapter = this.this$0.f52358r) == null) {
                        return;
                    }
                    playListAdapter.notifyItemChanged(i11);
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

    private final void i1(boolean z11) {
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            if (activity instanceof PlayListActivity) {
                ((PlayListActivity) activity).M(z11);
            }
        }
    }

    private final void m1() {
        Map<String, Object> mapA = com.transsion.ad.strategy.b.f50584a.a("");
        String str = this.f52353m;
        if (str != null) {
            mapA.put("category", str);
        }
        BiddingListManager biddingListManager = new BiddingListManager();
        lt.m mViewBinding = getMViewBinding();
        biddingListManager.F(mViewBinding != null ? mViewBinding.f70480f : null);
        biddingListManager.A(v.a(this));
        biddingListManager.G("PlayListScene");
        biddingListManager.B(mapA);
        biddingListManager.z(new Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit>() { // from class: com.transsion.home.category.fragment.PlayListFragment$initAd$2$1
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
                List<Staff> listD2;
                Intrinsics.g(current, "current");
                if (current != null) {
                    PlayListFragment playListFragment = this.this$0;
                    int size = 0;
                    if (playListFragment.y1()) {
                        Staff staff = new Staff();
                        staff.setNonAdDelegate(current);
                        kt.b bVar = playListFragment.f52359s;
                        if (bVar != null && (listD2 = bVar.D()) != null) {
                            size = listD2.size();
                        }
                        if (i11 < size) {
                            kt.b bVar2 = playListFragment.f52359s;
                            if (bVar2 != null) {
                                bVar2.j(i11, staff);
                                return;
                            }
                            return;
                        }
                        kt.b bVar3 = playListFragment.f52359s;
                        if (bVar3 != null) {
                            bVar3.l(staff);
                            return;
                        }
                        return;
                    }
                    Subject subject = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
                    subject.setNonAdDelegate(current);
                    PlayListAdapter playListAdapter = playListFragment.f52358r;
                    if (playListAdapter != null && (listD = playListAdapter.D()) != null) {
                        size = listD.size();
                    }
                    if (i11 < size) {
                        PlayListAdapter playListAdapter2 = playListFragment.f52358r;
                        if (playListAdapter2 != null) {
                            playListAdapter2.j(i11, subject);
                            return;
                        }
                        return;
                    }
                    PlayListAdapter playListAdapter3 = playListFragment.f52358r;
                    if (playListAdapter3 != null) {
                        playListAdapter3.l(subject);
                    }
                }
            }
        });
        this.f52361u = biddingListManager;
    }

    public static final void o1(PlayListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof Staff) {
            Staff staff = (Staff) item;
            com.alibaba.android.arouter.launcher.a.d().b("/movie/staff").withString("id", staff.getStaffId()).withSerializable("staff", (Serializable) item).navigation();
            this$0.k1().c("playlist", staff.getStaffId(), staff.getOps(), Integer.valueOf(i11), this$0.f52353m, this$0.f52354n, this$0.f52352l);
        }
    }

    public static final void p1(final PlayListFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.A1();
            return;
        }
        zp.b.f82110a.d(R$string.no_network);
        lt.m mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f70480f) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.category.fragment.o
            @Override // java.lang.Runnable
            public final void run() {
                PlayListFragment.q1(this.f52380a);
            }
        }, 300L);
    }

    public static final void q1(PlayListFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        kt.b bVar = this$0.f52359s;
        if (bVar == null || (fVarQ = bVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    private final void reload() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            B0();
        } else {
            K0();
            O0();
        }
    }

    public static final void s1(final PlayListFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.A1();
            return;
        }
        zp.b.f82110a.d(R$string.no_network);
        lt.m mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f70480f) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.category.fragment.p
            @Override // java.lang.Runnable
            public final void run() {
                PlayListFragment.t1(this.f52381a);
            }
        }, 300L);
    }

    public static final void t1(PlayListFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        PlayListAdapter playListAdapter = this$0.f52358r;
        if (playListAdapter == null || (fVarQ = playListAdapter.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    public static final void u1(PlayListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            HomeUtilsKt.b(subject, "play_list_page");
            com.transsion.home.utils.d dVarK1 = this$0.k1();
            String subjectId = subject.getSubjectId();
            String ops = subject.getOps();
            Integer numValueOf = Integer.valueOf(i11);
            Boolean hasResource = subject.getHasResource();
            dVarK1.e("playlist", subjectId, ops, numValueOf, hasResource != null ? hasResource.booleanValue() : false, this$0.f52353m, this$0.f52354n, this$0.f52352l);
        }
    }

    public static final void v1(PlayListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        Object item = adapter.getItem(i11);
        Subject subject = item instanceof Subject ? (Subject) item : null;
        if (view.getId() == R$id.ll_download) {
            this$0.j1(subject, i11);
        }
    }

    public static final void w1(PlayListFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void x1(PlayListFragment this$0, lt.m this_apply, AppBarLayout appBarLayout, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        if (this$0.getContext() == null) {
            return;
        }
        if (Math.abs(i11) >= appBarLayout.getTotalScrollRange()) {
            this_apply.f70481g.setBackgroundColor(z2.a.getColor(this$0.requireContext(), R$color.bg_01));
            this_apply.f70478c.setImageTintList(ColorStateList.valueOf(z2.a.getColor(this$0.requireContext(), R$color.btn_back)));
            AppCompatTextView tvTitle = this_apply.f70482h;
            Intrinsics.f(tvTitle, "tvTitle");
            so.c.k(tvTitle);
            AppCompatTextView tvTitleExpand = this_apply.f70483i;
            Intrinsics.f(tvTitleExpand, "tvTitleExpand");
            so.c.g(tvTitleExpand);
            this$0.i1(true);
            return;
        }
        this_apply.f70481g.setBackgroundColor(z2.a.getColor(this$0.requireContext(), R$color.transparent));
        this_apply.f70478c.setImageTintList(ColorStateList.valueOf(z2.a.getColor(this$0.requireContext(), R$color.common_white)));
        AppCompatTextView tvTitle2 = this_apply.f70482h;
        Intrinsics.f(tvTitle2, "tvTitle");
        so.c.g(tvTitle2);
        AppCompatTextView tvTitleExpand2 = this_apply.f70483i;
        Intrinsics.f(tvTitleExpand2, "tvTitleExpand");
        so.c.k(tvTitleExpand2);
        this$0.i1(false);
    }

    private final void z1() {
        PlayListViewModel playListViewModel = this.f52351k;
        if (playListViewModel == null) {
            Intrinsics.y("viewModel");
            playListViewModel = null;
        }
        PlayListViewModel playListViewModel2 = playListViewModel;
        String str = this.f52352l;
        if (str == null) {
            str = "";
        }
        String str2 = this.f52353m;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.f52354n;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.f52355o;
        if (str4 == null) {
            str4 = "";
        }
        playListViewModel2.e(str, str2, str3, str4, this.f52356p);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            K0();
            z1();
        }
    }

    public final void C1(PlayListResp playListResp) throws JSONException {
        List<Subject> subjects;
        List<Staff> staffs;
        String ops = playListResp != null ? playListResp.getOps() : null;
        JSONObject jSONObject = (ops == null || ops.length() == 0) ? new JSONObject() : new JSONObject(ops);
        jSONObject.put("rec_type", this.f52354n);
        jSONObject.put("label", this.f52352l);
        String string = jSONObject.toString();
        if (playListResp != null && (staffs = playListResp.getStaffs()) != null) {
            for (Staff staff : staffs) {
                String ops2 = staff.getOps();
                if (ops2 == null || ops2.length() == 0) {
                    staff.setOps(string);
                }
            }
        }
        if (playListResp == null || (subjects = playListResp.getSubjects()) == null) {
            return;
        }
        for (Subject subject : subjects) {
            String ops3 = subject.getOps();
            if (ops3 == null || ops3.length() == 0) {
                subject.setOps(string);
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        HashMap<String, String> mapG;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f52352l = arguments.getString("label");
            this.f52353m = arguments.getString("category");
            this.f52354n = arguments.getString("recType");
            this.f52355o = arguments.getString("topIds");
            this.f52356p = arguments.getInt("tabId", 0);
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.put("label", this.f52352l);
        mapG.put("category", this.f52353m);
        mapG.put("rec_type", this.f52354n);
    }

    public final void D1(PlayListResp playListResp) {
        lt.m mViewBinding;
        List<Subject> listD;
        Cover cover;
        String thumbnail;
        Cover cover2;
        String url;
        List<Subject> listD2;
        List<Subject> listD3;
        PlayListAdapter playListAdapter;
        List<Staff> listD4;
        String avatarUrl;
        List<Staff> listD5;
        kt.b bVar;
        if (getContext() == null || (mViewBinding = getMViewBinding()) == null) {
            return;
        }
        String title = playListResp.getTitle();
        if (title != null && title.length() > 0) {
            mViewBinding.f70482h.setText(playListResp.getTitle());
            mViewBinding.f70483i.setText(playListResp.getTitle());
        }
        Subject subject = null;
        staff = null;
        Staff staff = null;
        subject = null;
        if (y1()) {
            List<Staff> staffs = playListResp.getStaffs();
            if (staffs != null && (bVar = this.f52359s) != null) {
                bVar.m(staffs);
            }
            kt.b bVar2 = this.f52359s;
            if (bVar2 == null || (listD4 = bVar2.D()) == null || !(!listD4.isEmpty())) {
                return;
            }
            kt.b bVar3 = this.f52359s;
            if (bVar3 != null && (listD5 = bVar3.D()) != null) {
                staff = listD5.get(0);
            }
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            AppCompatImageView ivCover = mViewBinding.f70479d;
            Intrinsics.f(ivCover, "ivCover");
            companion.r(contextRequireContext, ivCover, (staff == null || (avatarUrl = staff.getAvatarUrl()) == null) ? "" : avatarUrl, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            return;
        }
        List<Subject> subjects = playListResp.getSubjects();
        if (subjects != null) {
            Boolean showRank = playListResp.getShowRank();
            PlayListAdapter playListAdapter2 = this.f52358r;
            if (playListAdapter2 != null && (listD3 = playListAdapter2.D()) != null && listD3.isEmpty() && showRank != null && (playListAdapter = this.f52358r) != null) {
                playListAdapter.W0(showRank.booleanValue());
            }
            PlayListAdapter playListAdapter3 = this.f52358r;
            if (playListAdapter3 != null) {
                playListAdapter3.m(subjects);
            }
        }
        PlayListAdapter playListAdapter4 = this.f52358r;
        if (playListAdapter4 == null || (listD = playListAdapter4.D()) == null || !(!listD.isEmpty())) {
            return;
        }
        PlayListAdapter playListAdapter5 = this.f52358r;
        if (playListAdapter5 != null && (listD2 = playListAdapter5.D()) != null) {
            subject = listD2.get(0);
        }
        ImageHelper.Companion companion2 = ImageHelper.f51371a;
        Context contextRequireContext2 = requireContext();
        Intrinsics.f(contextRequireContext2, "requireContext()");
        AppCompatImageView ivCover2 = mViewBinding.f70479d;
        Intrinsics.f(ivCover2, "ivCover");
        companion2.q(contextRequireContext2, ivCover2, (subject == null || (cover2 = subject.getCover()) == null || (url = cover2.getUrl()) == null) ? "" : url, (8120 & 8) != 0 ? companion2.d() : 0, (8120 & 16) != 0 ? companion2.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (subject == null || (cover = subject.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        List<Subject> listD;
        List<Staff> listD2;
        if (y1()) {
            kt.b bVar = this.f52359s;
            if (bVar != null && (listD2 = bVar.D()) != null && listD2.size() == 0) {
                reload();
                return;
            }
            kt.b bVar2 = this.f52359s;
            if (bVar2 == null || bVar2.Q().i() != LoadMoreStatus.Fail) {
                return;
            }
            bVar2.Q().v();
            return;
        }
        PlayListAdapter playListAdapter = this.f52358r;
        if (playListAdapter != null && (listD = playListAdapter.D()) != null && listD.size() == 0) {
            reload();
            return;
        }
        PlayListAdapter playListAdapter2 = this.f52358r;
        if (playListAdapter2 == null || playListAdapter2.Q().i() != LoadMoreStatus.Fail) {
            return;
        }
        playListAdapter2.Q().v();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        B1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        PlayListViewModel playListViewModel = (PlayListViewModel) new v0(this).a(PlayListViewModel.class);
        this.f52351k = playListViewModel;
        PlayListViewModel playListViewModel2 = null;
        if (playListViewModel == null) {
            Intrinsics.y("viewModel");
            playListViewModel = null;
        }
        playListViewModel.g(1);
        PlayListViewModel playListViewModel3 = this.f52351k;
        if (playListViewModel3 == null) {
            Intrinsics.y("viewModel");
        } else {
            playListViewModel2 = playListViewModel3;
        }
        playListViewModel2.f().j(this, new c(new Function1<PlayListResp, Unit>() { // from class: com.transsion.home.category.fragment.PlayListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayListResp playListResp) throws JSONException {
                invoke2(playListResp);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayListResp playListResp) throws JSONException {
                List<Subject> listD;
                List<Subject> listD2;
                PlayListAdapter playListAdapter;
                h9.f fVarQ;
                h9.f fVarQ2;
                PlayListAdapter playListAdapter2;
                h9.f fVarQ3;
                List<Staff> listD3;
                List<Staff> listD4;
                kt.b bVar;
                h9.f fVarQ4;
                h9.f fVarQ5;
                kt.b bVar2;
                h9.f fVarQ6;
                PlayListFragment.this.F0();
                PlayListFragment.this.C1(playListResp);
                if (PlayListFragment.this.y1()) {
                    kt.b bVar3 = PlayListFragment.this.f52359s;
                    if (bVar3 != null && (fVarQ5 = bVar3.Q()) != null && fVarQ5.q() && (bVar2 = PlayListFragment.this.f52359s) != null && (fVarQ6 = bVar2.Q()) != null) {
                        fVarQ6.r();
                    }
                    if (playListResp == null) {
                        kt.b bVar4 = PlayListFragment.this.f52359s;
                        if (bVar4 == null || (listD3 = bVar4.D()) == null || listD3.size() != 0) {
                            return;
                        }
                        PageStatusFragment.H0(PlayListFragment.this, false, 1, null);
                        return;
                    }
                    List<Staff> staffs = playListResp.getStaffs();
                    int size = staffs != null ? staffs.size() : 0;
                    if (size < 4 && (bVar = PlayListFragment.this.f52359s) != null && (fVarQ4 = bVar.Q()) != null) {
                        h9.f.t(fVarQ4, false, 1, null);
                    }
                    kt.b bVar5 = PlayListFragment.this.f52359s;
                    if (bVar5 == null || (listD4 = bVar5.D()) == null || listD4.size() != 0 || size != 0) {
                        PlayListFragment.this.D1(playListResp);
                    } else {
                        PageStatusFragment.H0(PlayListFragment.this, false, 1, null);
                    }
                    com.transsion.baselib.report.h logViewConfig = PlayListFragment.this.getLogViewConfig();
                    if (logViewConfig == null) {
                        return;
                    }
                    logViewConfig.j(true);
                    return;
                }
                PlayListAdapter playListAdapter3 = PlayListFragment.this.f52358r;
                if (playListAdapter3 != null && (fVarQ2 = playListAdapter3.Q()) != null && fVarQ2.q() && (playListAdapter2 = PlayListFragment.this.f52358r) != null && (fVarQ3 = playListAdapter2.Q()) != null) {
                    fVarQ3.r();
                }
                if (playListResp == null) {
                    PlayListAdapter playListAdapter4 = PlayListFragment.this.f52358r;
                    if (playListAdapter4 == null || (listD = playListAdapter4.D()) == null || listD.size() != 0) {
                        return;
                    }
                    PageStatusFragment.H0(PlayListFragment.this, false, 1, null);
                    return;
                }
                List<Subject> subjects = playListResp.getSubjects();
                int size2 = subjects != null ? subjects.size() : 0;
                if (size2 < 4 && (playListAdapter = PlayListFragment.this.f52358r) != null && (fVarQ = playListAdapter.Q()) != null) {
                    h9.f.t(fVarQ, false, 1, null);
                }
                PlayListAdapter playListAdapter5 = PlayListFragment.this.f52358r;
                if (playListAdapter5 == null || (listD2 = playListAdapter5.D()) == null || listD2.size() != 0 || size2 != 0) {
                    PlayListFragment.this.D1(playListResp);
                } else {
                    PageStatusFragment.H0(PlayListFragment.this, false, 1, null);
                }
                com.transsion.baselib.report.h logViewConfig2 = PlayListFragment.this.getLogViewConfig();
                if (logViewConfig2 == null) {
                    return;
                }
                logViewConfig2.j(true);
            }
        }));
    }

    public final void j1(Subject subject, int i11) {
        Boolean hasResource;
        if (getContext() != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            k1().a("playlist", HomeUtilsKt.c(subject, "playlist", contextRequireContext, "play_list_page"), subject != null ? subject.getSubjectId() : null, subject != null ? subject.getOps() : null, Integer.valueOf(i11), (subject == null || (hasResource = subject.getHasResource()) == null) ? false : hasResource.booleanValue(), this.f52353m, this.f52354n, this.f52352l);
        }
    }

    public final com.transsion.home.utils.d k1() {
        return (com.transsion.home.utils.d) this.f52360t.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public lt.m getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        lt.m mVarC = lt.m.c(inflater);
        Intrinsics.f(mVarC, "inflate(inflater)");
        return mVarC;
    }

    public final kt.b n1() {
        kt.b bVar = new kt.b(new ArrayList(), this.f52357q);
        bVar.Q().y(true);
        bVar.Q().x(true);
        bVar.Q().C(new f9.f() { // from class: com.transsion.home.category.fragment.j
            @Override // f9.f
            public final void a() {
                PlayListFragment.p1(this.f52375a);
            }
        });
        bVar.B0(new f9.d() { // from class: com.transsion.home.category.fragment.k
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                PlayListFragment.o1(this.f52376a, baseQuickAdapter, view, i11);
            }
        });
        this.f52359s = bVar;
        return bVar;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("playlist", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.f52361u;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    public final PlayListAdapter r1() {
        PlayListAdapter playListAdapter = new PlayListAdapter(new ArrayList(), this.f52357q);
        playListAdapter.Q().y(true);
        playListAdapter.Q().x(true);
        playListAdapter.Q().C(new f9.f() { // from class: com.transsion.home.category.fragment.l
            @Override // f9.f
            public final void a() {
                PlayListFragment.s1(this.f52377a);
            }
        });
        playListAdapter.B0(new f9.d() { // from class: com.transsion.home.category.fragment.m
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                PlayListFragment.u1(this.f52378a, baseQuickAdapter, view, i11);
            }
        });
        playListAdapter.i(R$id.ll_download);
        playListAdapter.z0(new f9.b() { // from class: com.transsion.home.category.fragment.n
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                PlayListFragment.v1(this.f52379a, baseQuickAdapter, view, i11);
            }
        });
        this.f52358r = playListAdapter;
        return playListAdapter;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        Toolbar toolbar;
        lt.m mViewBinding = getMViewBinding();
        if (mViewBinding != null && (toolbar = mViewBinding.f70481g) != null) {
            so.c.e(toolbar);
        }
        C0();
        m1();
        final lt.m mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null) {
            mViewBinding2.f70478c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.category.fragment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayListFragment.w1(this.f52372a, view);
                }
            });
            RecyclerView recyclerView = mViewBinding2.f70480f;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            nt.b bVar = new nt.b(0.6f, new b(), false, 4, null);
            bVar.l(2);
            recyclerView.addOnScrollListener(bVar);
            this.f52357q = bVar;
            recyclerView.setAdapter(y1() ? n1() : r1());
            mViewBinding2.f70477b.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.home.category.fragment.i
                @Override // com.google.android.material.appbar.AppBarLayout.b
                public final void a(AppBarLayout appBarLayout, int i11) {
                    PlayListFragment.x1(this.f52373a, mViewBinding2, appBarLayout, i11);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return true;
    }

    public final boolean y1() {
        return Intrinsics.b(this.f52353m, PlayListType.CAST.getValue());
    }
}
