package com.transsion.subtitle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.DefaultView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.SubtitleItem;
import com.transsion.subtitle.R$drawable;
import com.transsion.subtitle.R$string;
import com.transsion.subtitle.VideoSubtitleManager;
import com.transsion.subtitle.bean.SubtitleSearchListBean;
import com.transsion.subtitle.helper.SubtitleSearchHelper;
import com.transsion.subtitle.view.SubtitleDialogLoadMoreView;
import com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class SubtitleSearchResultListFragment extends LazyFragment<wx.b> implements com.transsion.subtitle_download.a, xx.c {
    public static final a F = new a(null);
    public Function1<? super vx.a, Unit> B;
    public Function0<Unit> C;
    public boolean D;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SubtitleDownloadViewModel f58200o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ux.c f58201p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f58203r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public g f58204s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public DownloadBean f58207v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f58208w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SubtitleLanguageMapBean f58209x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public vx.a f58210y;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f58202q = "1";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f58205t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<SubtitleLanguageMapBean> f58206u = new ArrayList();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Map<vx.a, Integer> f58211z = new LinkedHashMap();
    public int A = -1;
    public boolean E = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubtitleSearchResultListFragment a(DownloadBean downloadBean, SubtitleLanguageMapBean subtitleLanguageMapBean, String str, String str2) {
            SubtitleSearchResultListFragment subtitleSearchResultListFragment = new SubtitleSearchResultListFragment();
            subtitleSearchResultListFragment.K1(downloadBean, subtitleLanguageMapBean, str);
            subtitleSearchResultListFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("KEY_PAGE_NAME", str2)));
            return subtitleSearchResultListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends RecyclerView.r {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 != 0 || recyclerView.canScrollVertically(1)) {
                return;
            }
            SubtitleSearchResultListFragment.this.C1();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends DiffUtil.e<vx.a> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(vx.a oldItem, vx.a newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.b().getId(), newItem.b().getId()) && Intrinsics.b(oldItem.b().getUrl(), newItem.b().getUrl()) && oldItem.b().getStatus() == newItem.b().getStatus();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(vx.a oldItem, vx.a newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.b().getUrl(), newItem.b().getUrl());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f58213a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f58213a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f58213a;
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
            this.f58213a.invoke(obj);
        }
    }

    private final void A1() {
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            Q1();
            return;
        }
        SubtitleDownloadViewModel subtitleDownloadViewModel = this.f58200o;
        if (subtitleDownloadViewModel != null) {
            SubtitleDownloadViewModel.s(subtitleDownloadViewModel, this.f58204s, this.f58205t, this.f58206u, this.f58207v, this.f58202q, 0, 32, null);
        }
    }

    private final void B1() {
        SubtitleDownloadViewModel subtitleDownloadViewModel = this.f58200o;
        if (subtitleDownloadViewModel != null) {
            SubtitleDownloadViewModel.s(subtitleDownloadViewModel, this.f58204s, this.f58205t, this.f58206u, this.f58207v, this.f58202q, 0, 32, null);
        }
    }

    public static final void D1(SubtitleSearchResultListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.B1();
    }

    public static final void E1(SubtitleSearchResultListFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        ux.c cVar = this$0.f58201p;
        if (cVar == null || (fVarQ = cVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    public static final void F1(SubtitleSearchResultListFragment this$0, SubtitleDownloadTable dbBean) {
        List<vx.a> listD;
        Object next;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(dbBean, "$dbBean");
        ux.c cVar = this$0.f58201p;
        if (cVar == null || (listD = cVar.D()) == null) {
            return;
        }
        Iterator<T> it = listD.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((vx.a) next).b().getId(), dbBean.getId()));
        vx.a aVar = (vx.a) next;
        if (aVar != null) {
            aVar.h(dbBean);
            uo.b.a aVar2 = uo.b.f78622a;
            String strA = com.transsion.baselib.report.a.f51248a.a();
            DownloadBean downloadBean = this$0.f58207v;
            String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
            aVar2.c(strA, "搜索字幕下载成功，name = " + totalTitleName + ", subtype = " + aVar.b().getType() + ", download subtitleName = " + aVar.b().getSubtitleName() + ", lan = " + aVar.b().getLan() + "~", true);
            ux.c cVar2 = this$0.f58201p;
            Intrinsics.d(cVar2);
            aVar.l(cVar2.D().indexOf(aVar) == this$0.A);
            this$0.R1(aVar);
        }
    }

    public static final void G1(SubtitleSearchResultListFragment this$0, SubtitleDownloadTable dbBean) {
        List<vx.a> listD;
        Object next;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(dbBean, "$dbBean");
        this$0.A = -1;
        this$0.f58210y = null;
        ux.c cVar = this$0.f58201p;
        if (cVar == null || (listD = cVar.D()) == null) {
            return;
        }
        Iterator<T> it = listD.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((vx.a) next).b().getId(), dbBean.getId()));
        vx.a aVar = (vx.a) next;
        if (aVar != null) {
            aVar.h(dbBean);
            uo.b.a aVar2 = uo.b.f78622a;
            String strA = com.transsion.baselib.report.a.f51248a.a();
            DownloadBean downloadBean = this$0.f58207v;
            String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
            aVar2.t(strA, "搜索字幕下载失败TnT，name = " + totalTitleName + ", subtype = " + aVar.b().getType() + ", download subtitleName = " + aVar.b().getSubtitleName() + ", lan = " + aVar.b().getLan() + "~ , url：" + aVar.b().getUrl(), true);
            this$0.R1(aVar);
        }
    }

    private final void H1() {
        this.f58202q = "1";
        ux.c cVar = this.f58201p;
        if (cVar != null) {
            cVar.w0(kotlin.collections.g.l());
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            Q1();
            return;
        }
        P1(true);
        SubtitleDownloadViewModel subtitleDownloadViewModel = this.f58200o;
        if (subtitleDownloadViewModel != null) {
            SubtitleDownloadViewModel.s(subtitleDownloadViewModel, this.f58204s, this.f58205t, this.f58206u, this.f58207v, this.f58202q, 0, 32, null);
        }
    }

    private final void N1() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "ORSubtitle_search", "showEmpty~", false, 4, null);
        P1(false);
        ux.c cVar = this.f58201p;
        if (cVar != null) {
            cVar.r0(p1(context));
        }
    }

    public static /* synthetic */ View r1(SubtitleSearchResultListFragment subtitleSearchResultListFragment, Context context, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return subtitleSearchResultListFragment.q1(context, str, z11);
    }

    public static final void s1(SubtitleSearchResultListFragment this$0, DefaultView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.P1(true);
        this$0.A1();
        this_apply.setVisibility(8);
    }

    public static final void t1(View view) {
        NetworkUtils.w();
    }

    public static final void y1(SubtitleSearchResultListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.C1();
    }

    public static final void z1(SubtitleSearchResultListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        ux.c cVar;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        Intrinsics.e(item, "null cannot be cast to non-null type com.transsion.subtitle.bean.VideoSubtitleBean");
        vx.a aVar = (vx.a) item;
        if (aVar.b().getStatus() == 2) {
            return;
        }
        if (!aVar.d() && this$0.D) {
            zp.b.f82110a.d(R$string.subtitle_is_downloading);
            return;
        }
        if (aVar.f()) {
            return;
        }
        aVar.l(true);
        if (this$0.A == i11) {
            this$0.A = -1;
            this$0.f58210y = null;
            return;
        }
        vx.a aVar2 = this$0.f58210y;
        if (aVar2 != null) {
            aVar2.l(false);
        }
        int i12 = this$0.A;
        if (i12 >= 0 && (cVar = this$0.f58201p) != null) {
            cVar.notifyItemChanged(i12, this$0.f58210y);
        }
        String str = this$0.f58203r;
        if (str == null) {
            str = "";
        }
        aVar.k(str);
        this$0.f58210y = aVar;
        this$0.A = i11;
        ux.c cVar2 = this$0.f58201p;
        if (cVar2 != null) {
            cVar2.notifyItemChanged(i11, aVar);
        }
        uo.b.a aVar3 = uo.b.f78622a;
        uo.b.a.f(aVar3, "ORSubtitle_search", "select item = " + aVar.b().getName() + ", position = " + i11 + "， status:" + aVar.b().getStatus(), false, 4, null);
        if (aVar.d()) {
            Function1<? super vx.a, Unit> function1 = this$0.B;
            if (function1 != null) {
                function1.invoke(aVar);
                return;
            }
            return;
        }
        aVar.b().setStatus(2);
        uo.b.a.o(aVar3, "ORSubtitle_search", new String[]{"itemClick, resourceId:" + aVar.b().getId() + ", name:" + aVar.b().getName() + " index:" + i11 + ", isOpenSubNewApi:" + aVar.e()}, false, 4, null);
        this$0.f58211z.put(aVar, Integer.valueOf(i11));
        this$0.o1(aVar);
    }

    @Override // com.transsion.subtitle_download.a
    public void B(int i11, SubtitleDownloadTable dbBean) {
        Intrinsics.g(dbBean, "dbBean");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C1() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        h9.f fVarQ;
        h9.f fVarQ2;
        if (this.E) {
            return;
        }
        ux.c cVar = this.f58201p;
        if (cVar == null || (fVarQ2 = cVar.Q()) == null || !fVarQ2.q()) {
            if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
                wx.b bVar = (wx.b) getMViewBinding();
                if (bVar == null || (recyclerView = bVar.f79670d) == null) {
                    return;
                }
                recyclerView.postDelayed(new Runnable() { // from class: com.transsion.subtitle.fragment.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        SubtitleSearchResultListFragment.E1(this.f58237a);
                    }
                }, 500L);
                return;
            }
            ux.c cVar2 = this.f58201p;
            if (cVar2 != null && (fVarQ = cVar2.Q()) != null) {
                fVarQ.v();
            }
            wx.b bVar2 = (wx.b) getMViewBinding();
            if (bVar2 == null || (recyclerView2 = bVar2.f79670d) == null) {
                return;
            }
            recyclerView2.postDelayed(new Runnable() { // from class: com.transsion.subtitle.fragment.h
                @Override // java.lang.Runnable
                public final void run() {
                    SubtitleSearchResultListFragment.D1(this.f58236a);
                }
            }, 300L);
        }
    }

    @Override // com.transsion.subtitle_download.a
    public void E(SubtitleDownloadTable subtitleDownloadTable) {
        com.transsion.subtitle_download.a.C0598a.b(this, subtitleDownloadTable);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        P1(true);
        A1();
    }

    public final void I1(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.f58208w = str;
        DownloadBean downloadBean = this.f58207v;
        int se2 = downloadBean != null ? downloadBean.getSe() : 0;
        DownloadBean downloadBean2 = this.f58207v;
        this.f58204s = new g(str, se2, downloadBean2 != null ? downloadBean2.getEp() : 0);
        H1();
    }

    @Override // com.transsion.subtitle_download.a
    public void J(SubtitleDownloadTable subtitleDownloadTable) {
        com.transsion.subtitle_download.a.C0598a.a(this, subtitleDownloadTable);
    }

    public final void J1(boolean z11, int i11) {
        DownloadBean downloadBean;
        SubtitleLanguageMapBean subtitleLanguageMapBean;
        String lan;
        String str = this.f58203r;
        if (str == null || (downloadBean = this.f58207v) == null || (subtitleLanguageMapBean = this.f58209x) == null || (lan = subtitleLanguageMapBean.getLan()) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("result", z11 ? "1" : "0");
        linkedHashMap.put("type", String.valueOf(i11));
        linkedHashMap.put("lan", lan);
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = "";
        }
        linkedHashMap.put("resource_id", resourceId);
        String subjectId = downloadBean.getSubjectId();
        linkedHashMap.put("subject_id", subjectId != null ? subjectId : "");
        if (downloadBean.getEp() > 0) {
            linkedHashMap.put("ep", String.valueOf(downloadBean.getEp()));
        }
        if (downloadBean.getSe() > 0) {
            linkedHashMap.put("se", String.valueOf(downloadBean.getSe()));
        }
        com.transsion.baselib.report.m.f51277a.m(str, "subtitle_search", linkedHashMap);
    }

    public final void K1(DownloadBean downloadBean, SubtitleLanguageMapBean subtitleLanguageMapBean, String str) {
        this.f58207v = downloadBean;
        this.f58208w = str;
        if (subtitleLanguageMapBean != null) {
            this.f58209x = subtitleLanguageMapBean;
            this.f58205t = subtitleLanguageMapBean.getLan();
            this.f58206u.add(subtitleLanguageMapBean);
        }
    }

    public final void L1(Function0<Unit> function0) {
        this.C = function0;
    }

    public final void M1(Function1<? super vx.a, Unit> function1) {
        this.B = function1;
    }

    public final void O1() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "ORSubtitle_search", "showFail~", false, 4, null);
        P1(false);
        ux.c cVar = this.f58201p;
        if (cVar != null) {
            cVar.r0(u1(context));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P1(boolean z11) {
        wx.b bVar = (wx.b) getMViewBinding();
        LinearLayoutCompat linearLayoutCompat = bVar != null ? bVar.f79669c : null;
        if (linearLayoutCompat == null) {
            return;
        }
        linearLayoutCompat.setVisibility(z11 ? 0 : 8);
    }

    public final void Q1() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "ORSubtitle_search", "showNotNet~", false, 4, null);
        P1(false);
        ux.c cVar = this.f58201p;
        if (cVar != null) {
            cVar.r0(v1(context));
        }
    }

    public final void R1(vx.a aVar) {
        int iIndexOf;
        ux.c cVar;
        ux.c cVar2 = this.f58201p;
        if (cVar2 == null || (iIndexOf = cVar2.D().indexOf(aVar)) < 0 || !isAdded() || (cVar = this.f58201p) == null) {
            return;
        }
        cVar.notifyItemChanged(iIndexOf, aVar);
    }

    public final void S1(List<vx.a> list, boolean z11) {
        List<vx.a> listL;
        h9.f fVarQ;
        h9.f fVarQ2;
        ux.c cVar;
        h9.f fVarQ3;
        List<vx.a> listD;
        h9.f fVarQ4;
        h9.f fVarQ5;
        ux.c cVar2;
        h9.f fVarQ6;
        h9.f fVarQ7;
        List<vx.a> listD2;
        if (list.isEmpty()) {
            ux.c cVar3 = this.f58201p;
            if (cVar3 != null && (listD2 = cVar3.D()) != null && listD2.size() == 0) {
                if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    N1();
                } else {
                    Q1();
                }
            }
            ux.c cVar4 = this.f58201p;
            if (cVar4 == null || (fVarQ7 = cVar4.Q()) == null) {
                return;
            }
            h9.f.t(fVarQ7, false, 1, null);
            return;
        }
        ux.c cVar5 = this.f58201p;
        if (cVar5 != null && (listD = cVar5.D()) != null && listD.isEmpty()) {
            ux.c cVar6 = this.f58201p;
            if (cVar6 != null) {
                cVar6.w0(list);
            }
            if (!z11) {
                ux.c cVar7 = this.f58201p;
                if (cVar7 == null || (fVarQ4 = cVar7.Q()) == null) {
                    return;
                }
                h9.f.t(fVarQ4, false, 1, null);
                return;
            }
            ux.c cVar8 = this.f58201p;
            if (cVar8 == null || (fVarQ5 = cVar8.Q()) == null || !fVarQ5.q() || (cVar2 = this.f58201p) == null || (fVarQ6 = cVar2.Q()) == null) {
                return;
            }
            fVarQ6.r();
            return;
        }
        ux.c cVar9 = this.f58201p;
        if (cVar9 == null || (listL = cVar9.D()) == null) {
            listL = kotlin.collections.g.l();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            vx.a aVar = (vx.a) obj;
            List<vx.a> list2 = listL;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (!Intrinsics.b(aVar.b().getUrl(), ((vx.a) it.next()).b().getUrl()));
            }
            arrayList.add(obj);
        }
        if (arrayList.isEmpty()) {
            uo.b.a.f(uo.b.f78622a, "ORSubtitle_search", "全部去重了~", false, 4, null);
            return;
        }
        ux.c cVar10 = this.f58201p;
        if (cVar10 != null) {
            cVar10.m(arrayList);
        }
        if (!z11) {
            ux.c cVar11 = this.f58201p;
            if (cVar11 == null || (fVarQ = cVar11.Q()) == null) {
                return;
            }
            h9.f.t(fVarQ, false, 1, null);
            return;
        }
        ux.c cVar12 = this.f58201p;
        if (cVar12 == null || (fVarQ2 = cVar12.Q()) == null || !fVarQ2.q() || (cVar = this.f58201p) == null || (fVarQ3 = cVar.Q()) == null) {
            return;
        }
        fVarQ3.r();
    }

    @Override // xx.c
    public void T(boolean z11, DownloadBean downloadBean) {
        xx.c.a.a(this, z11, downloadBean);
    }

    @Override // xx.c
    public void b(vx.a bean) {
        ux.c cVar;
        List<vx.a> listD;
        Intrinsics.g(bean, "bean");
        for (Map.Entry<vx.a, Integer> entry : this.f58211z.entrySet()) {
            vx.a key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            if (!Intrinsics.b(bean.b().getId(), key.b().getId())) {
                uo.b.a aVar = uo.b.f78622a;
                uo.b.a.s(aVar, "ORSubtitle_search", "subtitleSelected, resourceId = " + key.b().getId() + ", name = " + key.b().getName(), false, 4, null);
                try {
                    Result.Companion companion = Result.Companion;
                    key.l(false);
                    if (iIntValue < 0) {
                        ux.c cVar2 = this.f58201p;
                        iIntValue = (cVar2 == null || (listD = cVar2.D()) == null) ? -1 : listD.indexOf(key);
                    }
                    uo.b.a.s(aVar, "ORSubtitle_search", "subtitleSelected2, index = " + iIntValue, false, 4, null);
                    if (iIntValue >= 0 && (cVar = this.f58201p) != null) {
                        cVar.notifyItemChanged(iIntValue, key);
                    }
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
            }
        }
    }

    @Override // com.transsion.subtitle_download.a
    public void b0(final SubtitleDownloadTable dbBean) {
        Intrinsics.g(dbBean, "dbBean");
        this.D = false;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.subtitle.fragment.n
                @Override // java.lang.Runnable
                public final void run() {
                    SubtitleSearchResultListFragment.F1(this.f58242a, dbBean);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        String strD;
        c0<vx.a> c0VarJ;
        c0<SubtitleSearchListBean> c0VarM;
        String subtitleResId;
        SubtitleDownloadViewModel subtitleDownloadViewModel = (SubtitleDownloadViewModel) new v0(this).a(SubtitleDownloadViewModel.class);
        DownloadBean downloadBean = this.f58207v;
        if (downloadBean != null && (subtitleResId = downloadBean.getSubtitleResId()) != null) {
            subtitleDownloadViewModel.e(subtitleResId);
        }
        this.f58200o = subtitleDownloadViewModel;
        String str = this.f58208w;
        if (str == null || str.length() == 0) {
            strD = SubtitleSearchHelper.f58255c.a().d(this.f58207v);
        } else {
            strD = this.f58208w;
            Intrinsics.d(strD);
        }
        DownloadBean downloadBean2 = this.f58207v;
        int se2 = downloadBean2 != null ? downloadBean2.getSe() : 0;
        DownloadBean downloadBean3 = this.f58207v;
        this.f58204s = new g(strD, se2, downloadBean3 != null ? downloadBean3.getEp() : 0);
        SubtitleDownloadViewModel subtitleDownloadViewModel2 = this.f58200o;
        if (subtitleDownloadViewModel2 != null && (c0VarM = subtitleDownloadViewModel2.m()) != null) {
            c0VarM.j(this, new d(new Function1<SubtitleSearchListBean, Unit>() { // from class: com.transsion.subtitle.fragment.SubtitleSearchResultListFragment.initViewModel.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SubtitleSearchListBean subtitleSearchListBean) {
                    invoke2(subtitleSearchListBean);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SubtitleSearchListBean subtitleSearchListBean) {
                    String nextPage;
                    Boolean hasMore;
                    h9.f fVarQ;
                    h9.f fVarQ2;
                    ux.c cVar;
                    h9.f fVarQ3;
                    List<vx.a> listD;
                    boolean zBooleanValue = false;
                    SubtitleSearchResultListFragment.this.P1(false);
                    Function0 function0 = SubtitleSearchResultListFragment.this.C;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    SubtitleSearchResultListFragment.this.E = subtitleSearchListBean != null && subtitleSearchListBean.getSearchType() == 2;
                    if (subtitleSearchListBean == null || !subtitleSearchListBean.isRefresh()) {
                        SubtitleSearchResultListFragment.this.J1(false, 2);
                    } else {
                        SubtitleSearchResultListFragment.this.J1(true, subtitleSearchListBean.getSearchType());
                    }
                    if (subtitleSearchListBean != null) {
                        SubtitleSearchResultListFragment subtitleSearchResultListFragment = SubtitleSearchResultListFragment.this;
                        Pager pager = subtitleSearchListBean.getPager();
                        if (pager == null || (nextPage = pager.getNextPage()) == null) {
                            nextPage = "1";
                        }
                        subtitleSearchResultListFragment.f58202q = nextPage;
                        SubtitleSearchResultListFragment subtitleSearchResultListFragment2 = SubtitleSearchResultListFragment.this;
                        List listX1 = subtitleSearchResultListFragment2.x1(subtitleSearchListBean.getItems());
                        Pager pager2 = subtitleSearchListBean.getPager();
                        if (pager2 != null && (hasMore = pager2.getHasMore()) != null) {
                            zBooleanValue = hasMore.booleanValue();
                        }
                        subtitleSearchResultListFragment2.S1(listX1, zBooleanValue);
                        return;
                    }
                    ux.c cVar2 = SubtitleSearchResultListFragment.this.f58201p;
                    if (cVar2 != null && (listD = cVar2.D()) != null && listD.size() == 0) {
                        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                            SubtitleSearchResultListFragment.this.O1();
                            return;
                        } else {
                            SubtitleSearchResultListFragment.this.Q1();
                            return;
                        }
                    }
                    ux.c cVar3 = SubtitleSearchResultListFragment.this.f58201p;
                    if (cVar3 != null && (fVarQ2 = cVar3.Q()) != null && fVarQ2.q() && (cVar = SubtitleSearchResultListFragment.this.f58201p) != null && (fVarQ3 = cVar.Q()) != null) {
                        fVarQ3.u();
                    }
                    ux.c cVar4 = SubtitleSearchResultListFragment.this.f58201p;
                    if (cVar4 == null || (fVarQ = cVar4.Q()) == null) {
                        return;
                    }
                    h9.f.t(fVarQ, false, 1, null);
                }
            }));
        }
        SubtitleDownloadViewModel subtitleDownloadViewModel3 = this.f58200o;
        if (subtitleDownloadViewModel3 == null || (c0VarJ = subtitleDownloadViewModel3.j()) == null) {
            return;
        }
        c0VarJ.j(this, new d(new Function1<vx.a, Unit>() { // from class: com.transsion.subtitle.fragment.SubtitleSearchResultListFragment.initViewModel.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(vx.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(vx.a aVar) {
                if (aVar != null) {
                    String url = aVar.b().getUrl();
                    if (url != null && url.length() != 0) {
                        SubtitleSearchResultListFragment.this.o1(aVar);
                    } else {
                        aVar.b().setStatus(6);
                        SubtitleSearchResultListFragment.this.R1(aVar);
                    }
                }
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        n1();
        P1(true);
        A1();
    }

    @Override // com.transsion.subtitle_download.a
    public void m(Exception e11, final SubtitleDownloadTable dbBean) {
        Intrinsics.g(e11, "e");
        Intrinsics.g(dbBean, "dbBean");
        this.D = false;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.subtitle.fragment.o
                @Override // java.lang.Runnable
                public final void run() {
                    SubtitleSearchResultListFragment.G1(this.f58244a, dbBean);
                }
            });
        }
    }

    public final void n1() {
        VideoSubtitleManager.Companion companion = VideoSubtitleManager.f58109a;
        companion.a().e(this);
        companion.a().i(this);
    }

    public final void o1(vx.a aVar) {
        String url;
        if (aVar.e() && ((url = aVar.b().getUrl()) == null || url.length() == 0)) {
            uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "搜索下载字幕，是opensubtitle 新api，需要先请求才能下载", true);
            SubtitleDownloadViewModel subtitleDownloadViewModel = this.f58200o;
            if (subtitleDownloadViewModel != null) {
                subtitleDownloadViewModel.i(aVar);
                return;
            }
            return;
        }
        this.D = true;
        uo.b.a aVar2 = uo.b.f78622a;
        String strA = com.transsion.baselib.report.a.f51248a.a();
        DownloadBean downloadBean = this.f58207v;
        String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
        aVar2.c(strA, "搜索下载字幕，name = " + totalTitleName + ", subtype = " + aVar.b().getType() + ", download subtitleName = " + aVar.b().getSubtitleName() + ", subResourceId = " + aVar.b().getId() + "~", true);
        aVar.b().setSetImmediately(true);
        VideoSubtitleManager.f58109a.a().f(aVar);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VideoSubtitleManager.Companion companion = VideoSubtitleManager.f58109a;
        companion.a().j(this);
        companion.a().h(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f58203r = arguments.getString("KEY_PAGE_NAME", "");
        }
    }

    public final View p1(Context context) {
        String string = context.getString(R$string.subtitle_no_subtitles_found);
        Intrinsics.f(string, "context.getString(R.stri…title_no_subtitles_found)");
        return r1(this, context, string, false, 4, null);
    }

    public final View q1(Context context, String str, boolean z11) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_DES_BTN);
        defaultView.setDescText(str);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_NO_IMAGE);
        defaultView.setBtnVisibility(0);
        String string = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.f(string, "context.getString(com.tr…seui.R.string.retry_text)");
        defaultView.setBtnText(string);
        defaultView.setTipOperationVisibility(8);
        defaultView.setBtnBg(z2.a.getDrawable(Utils.a(), R$drawable.post_detail_shape_subtitle_empty_btn_bg));
        defaultView.setBtnTextColor(-1);
        defaultView.setBackgroundColor(0);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleSearchResultListFragment.s1(this.f58240a, defaultView, view);
            }
        });
        defaultView.setLeftBtnVisibility(z11 ? 0 : 8);
        String string2 = context.getString(com.tn.lib.widget.R$string.go_to_setting);
        Intrinsics.f(string2, "context.getString(com.tn…t.R.string.go_to_setting)");
        defaultView.setLeftBtnText(string2);
        defaultView.setLeftBtnBg(z2.a.getDrawable(Utils.a(), R$drawable.post_detail_shape_subtitle_empty_btn_bg));
        defaultView.setLeftBtnTextColor(-1);
        defaultView.setLeftBtnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleSearchResultListFragment.t1(view);
            }
        });
        defaultView.setTitleViewVisibility(8);
        int iA = f0.a(16.0f);
        defaultView.setPadding(iA, f0.a(30.0f), iA, 0);
        defaultView.setVisibility(0);
        return defaultView;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final View u1(Context context) {
        String string = context.getString(R$string.subtitle_load_failed);
        Intrinsics.f(string, "context.getString(R.string.subtitle_load_failed)");
        return r1(this, context, string, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        ux.c cVar = new ux.c(true, new ArrayList());
        cVar.Q().B(new SubtitleDialogLoadMoreView());
        cVar.Q().y(true);
        cVar.Q().x(true);
        cVar.Q().D(2);
        cVar.Q().C(new f9.f() { // from class: com.transsion.subtitle.fragment.j
            @Override // f9.f
            public final void a() {
                SubtitleSearchResultListFragment.y1(this.f58238a);
            }
        });
        cVar.o0(new c());
        cVar.B0(new f9.d() { // from class: com.transsion.subtitle.fragment.k
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SubtitleSearchResultListFragment.z1(this.f58239a, baseQuickAdapter, view, i11);
            }
        });
        this.f58201p = cVar;
        wx.b bVar = (wx.b) getMViewBinding();
        if (bVar == null || (recyclerView = bVar.f79670d) == null) {
            return;
        }
        recyclerView.setAdapter(this.f58201p);
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
    }

    public final View v1(Context context) {
        String string = context.getString(com.tn.lib.widget.R$string.no_network_title);
        Intrinsics.f(string, "context.getString(com.tn….string.no_network_title)");
        return q1(context, string, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void w0(View view, Bundle bundle) {
        RecyclerView recyclerView;
        Intrinsics.g(view, "view");
        super.w0(view, bundle);
        wx.b bVar = (wx.b) getMViewBinding();
        if (bVar == null || (recyclerView = bVar.f79670d) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new b());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: w1, reason: merged with bridge method [inline-methods] */
    public wx.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        wx.b bVarC = wx.b.c(inflater);
        Intrinsics.f(bVarC, "inflate(inflater)");
        return bVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:99:0x012f A[PHI: r4
  0x012f: PHI (r4v35 java.lang.String) = (r4v22 java.lang.String), (r4v36 java.lang.String) binds: [B:104:0x013c, B:97:0x012c] A[DONT_GENERATE, DONT_INLINE]] */
    public final List<vx.a> x1(List<SubtitleItem> list) {
        String resourceId;
        String str;
        String resourceId2;
        String str2;
        String name;
        String str3;
        vx.a aVar;
        SubtitleDownloadTable subtitleDownloadTableB;
        vx.a aVar2;
        SubtitleDownloadTable subtitleDownloadTableB2;
        String path;
        c0<Map<String, vx.a>> c0VarK;
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        DownloadBean downloadBean = this.f58207v;
        String subjectId = downloadBean != null ? downloadBean.getSubjectId() : null;
        if (subjectId == null || subjectId.length() == 0) {
            DownloadBean downloadBean2 = this.f58207v;
            if (downloadBean2 != null) {
                resourceId = downloadBean2.getResourceId();
            } else {
                resourceId = null;
            }
        } else {
            DownloadBean downloadBean3 = this.f58207v;
            if (downloadBean3 != null) {
                resourceId = downloadBean3.getSubjectId();
            } else {
                resourceId = null;
            }
        }
        SubtitleDownloadViewModel subtitleDownloadViewModel = this.f58200o;
        Map<String, vx.a> mapF = (subtitleDownloadViewModel == null || (c0VarK = subtitleDownloadViewModel.k()) == null) ? null : c0VarK.f();
        DownloadBean downloadBean4 = this.f58207v;
        boolean z11 = true;
        int i11 = (downloadBean4 == null || !downloadBean4.isStream()) ? 1 : 2;
        for (SubtitleItem subtitleItem : list) {
            String id2 = subtitleItem.getId();
            String str4 = id2 == null ? "" : id2;
            DownloadBean downloadBean5 = this.f58207v;
            if (downloadBean5 == null || (postIdNotNull = downloadBean5.getSubtitleResId()) == null) {
                DownloadBean downloadBean6 = this.f58207v;
                if (downloadBean6 != null) {
                    String postIdNotNull = downloadBean6.getPostIdNotNull();
                    str = postIdNotNull;
                } else {
                    str = "";
                }
            } else {
                str = postIdNotNull;
            }
            DownloadBean downloadBean7 = this.f58207v;
            if (downloadBean7 == null || downloadBean7.isOutside() != z11) {
                DownloadBean downloadBean8 = this.f58207v;
                if (downloadBean8 == null || (resourceId2 = downloadBean8.getPostId()) == null) {
                    DownloadBean downloadBean9 = this.f58207v;
                    if (downloadBean9 != null) {
                        resourceId2 = downloadBean9.getResourceId();
                    } else {
                        str2 = null;
                    }
                }
                str2 = resourceId2;
            } else {
                DownloadBean downloadBean10 = this.f58207v;
                if (downloadBean10 != null) {
                    resourceId2 = downloadBean10.getPostIdNotNull();
                    str2 = resourceId2;
                } else {
                    str2 = null;
                }
            }
            String url = subtitleItem.getUrl();
            String str5 = url == null ? "" : url;
            String str6 = (mapF == null || mapF.containsKey(subtitleItem.getId()) != z11 || (aVar2 = mapF.get(subtitleItem.getId())) == null || (subtitleDownloadTableB2 = aVar2.b()) == null || (path = subtitleDownloadTableB2.getPath()) == null) ? "" : path;
            String lan = subtitleItem.getLan();
            String lanName = subtitleItem.getLanName();
            String str7 = lanName == null ? "" : lanName;
            String name2 = subtitleItem.getName();
            Long size = subtitleItem.getSize();
            Integer episode = subtitleItem.getEpisode();
            int iIntValue = episode != null ? episode.intValue() : 0;
            Integer season = subtitleItem.getSeason();
            int iIntValue2 = season != null ? season.intValue() : 0;
            DownloadBean downloadBean11 = this.f58207v;
            if (downloadBean11 == null || (name = downloadBean11.getSubjectName()) == null) {
                DownloadBean downloadBean12 = this.f58207v;
                name = downloadBean12 != null ? downloadBean12.getName() : null;
                if (name == null) {
                    str3 = "";
                } else {
                    str3 = name;
                }
            } else {
                str3 = name;
            }
            int status = (mapF == null || mapF.containsKey(subtitleItem.getId()) != z11 || (aVar = mapF.get(subtitleItem.getId())) == null || (subtitleDownloadTableB = aVar.b()) == null) ? 0 : subtitleDownloadTableB.getStatus();
            Integer type = subtitleItem.getType();
            Map<String, vx.a> map = mapF;
            vx.a aVar3 = new vx.a(new SubtitleDownloadTable(str4, i11, str, lan, str7, str5, size, null, null, type != null ? type.intValue() : 2, str2, name2, resourceId, iIntValue, iIntValue2, 0, str3, status, null, str6, null, null, 0, 7635328, null));
            if (subtitleItem.isOpenSubNewApi()) {
                aVar3.i(subtitleItem.getFileId());
                aVar3.j(true);
            }
            String id3 = aVar3.b().getId();
            DownloadBean downloadBean13 = this.f58207v;
            aVar3.l(Intrinsics.b(id3, downloadBean13 != null ? downloadBean13.getSubtitleSelectId() : null));
            if (aVar3.f()) {
                this.f58211z.put(aVar3, -1);
            }
            arrayList.add(aVar3);
            mapF = map;
            z11 = true;
        }
        return arrayList;
    }
}
