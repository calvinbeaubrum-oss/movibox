package com.transsion.commercialization.pslink;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.d0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.tn.lib.widget.R$string;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.middle.icon.HiSavanaIconAdManager;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.baselib.report.h;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.commercialization.R$drawable;
import com.transsion.commercialization.R$id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.g;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class PsLinkFragment extends BaseListFragment<RecommendInfo> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f51705v = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f51706p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public zr.b f51708r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<TAdNativeInfo> f51709s;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f51707q = LazyKt__LazyJVMKt.b(new Function0<PsLinkViewModel>() { // from class: com.transsion.commercialization.pslink.PsLinkFragment$mViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PsLinkViewModel invoke() {
            return new PsLinkViewModel();
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f51710t = LazyKt__LazyJVMKt.b(new Function0<HiSavanaIconAdManager>() { // from class: com.transsion.commercialization.pslink.PsLinkFragment$adManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HiSavanaIconAdManager invoke() {
            HiSavanaIconAdManager hiSavanaIconAdManager = new HiSavanaIconAdManager();
            PsLinkFragment psLinkFragment = this.this$0;
            hiSavanaIconAdManager.setSceneId("PsLinkListIconLinearScene");
            hiSavanaIconAdManager.setListener(psLinkFragment.f51711u);
            return hiSavanaIconAdManager;
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PsLinkFragment$adCallBack$1 f51711u = new WrapperAdListener() { // from class: com.transsion.commercialization.pslink.PsLinkFragment$adCallBack$1
        @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
        public void onClicked(int i11) {
            super.onClicked(i11);
            f.f51726a.c(-1, null, "install", 2);
        }

        @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
        public void onError(TAdErrorCode tAdErrorCode) {
            super.onError(tAdErrorCode);
            a.f51724a.b("onError = " + tAdErrorCode);
        }

        @Override // com.transsion.ad.middle.WrapperAdListener
        public void onHiIconAdReady(List<TAdNativeInfo> tAdNativeInfos) {
            Intrinsics.g(tAdNativeInfos, "tAdNativeInfos");
            a.f51724a.a("onIconAdReady size = " + tAdNativeInfos.size());
            PsLinkFragment psLinkFragment = this.this$0;
            Iterator<T> it = tAdNativeInfos.iterator();
            while (it.hasNext()) {
                ((TAdNativeInfo) it.next()).setExt(psLinkFragment.I1());
            }
            this.this$0.J1(tAdNativeInfos);
        }

        @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
        public void onShow(int i11) {
            super.onShow(i11);
        }
    };

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
    public static final class b implements zr.a {
        public b() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            List<RecommendInfo> listD;
            BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW0 = PsLinkFragment.this.W0();
            if (i11 < ((baseQuickAdapterW0 == null || (listD = baseQuickAdapterW0.D()) == null) ? 0 : listD.size())) {
                BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW1 = PsLinkFragment.this.W0();
                RecommendInfo item = baseQuickAdapterW1 != null ? baseQuickAdapterW1.getItem(i11) : null;
                if ((item != null ? item.getTAdNativeInfo() : null) == null) {
                    f.f51726a.i(i11, item, 1);
                } else {
                    f.f51726a.i(i11, item, 2);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends RecyclerView.l {
        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getAdapter() != null) {
                outRect.top = f0.a(12.0f);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f51713a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f51713a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f51713a;
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
            this.f51713a.invoke(obj);
        }
    }

    public static final void F1(PsLinkFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    private final String H1() {
        return wq.a.f79581a.b(I1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String I1() {
        return "PsLinkListIconLinearScene";
    }

    public static final void M1(BaseQuickAdapter adapter, View view, int i11) {
        String str;
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        PsLinkServiceHelper psLinkServiceHelper = PsLinkServiceHelper.f51717a;
        if (psLinkServiceHelper.k()) {
            psLinkServiceHelper.h();
        }
        Object obj = adapter.D().get(i11);
        RecommendInfo recommendInfo = obj instanceof RecommendInfo ? (RecommendInfo) obj : null;
        com.transsion.ad.ps.b bVar = com.transsion.ad.ps.b.f50555a;
        if (bVar.b(recommendInfo != null ? recommendInfo.getPackageName() : null)) {
            if (!bVar.n(recommendInfo != null ? recommendInfo.getPackageName() : null)) {
                bVar.a(recommendInfo, true, "app_center");
            }
            str = "open";
        } else if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
            return;
        } else {
            bVar.a(recommendInfo, true, "app_center");
            str = "install";
        }
        f.f51726a.c(i11, recommendInfo, str, 1);
    }

    private final void O1() {
        if (HiSavanaAdManager.f50400a.f()) {
            this.f51709s = null;
            String strI1 = I1();
            wq.c cVar = wq.c.f79583a;
            if (!cVar.c(strI1) && !cVar.a(strI1)) {
                D1().loadAd();
                return;
            }
            com.transsion.commercialization.pslink.a.f51724a.a(strI1 + " is off");
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    public final RecommendInfo C1(TAdNativeInfo tAdNativeInfo) {
        RecommendInfo recommendInfo = new RecommendInfo(null, null, null, 0, null, null, null, null, null, 0L, null, null, 0, null, 0L, 0, 0, null, null, null, null, null, null, null, 16777215, null);
        recommendInfo.setTAdNativeInfo(tAdNativeInfo);
        recommendInfo.setPlacementId(H1());
        recommendInfo.setSceneId(I1());
        return recommendInfo;
    }

    public final HiSavanaIconAdManager D1() {
        return (HiSavanaIconAdManager) this.f51710t.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        lazyLoadData();
    }

    public final int E1() {
        List<RecommendInfo> listD;
        BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW0 = W0();
        int i11 = -1;
        if (baseQuickAdapterW0 != null && (listD = baseQuickAdapterW0.D()) != null) {
            int i12 = 0;
            for (Object obj : listD) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    g.u();
                }
                if (((RecommendInfo) obj).getTAdNativeInfo() != null) {
                    i11 = i12;
                }
                i12 = i13;
            }
        }
        return i11;
    }

    public final PsLinkViewModel G1() {
        return (PsLinkViewModel) this.f51707q.getValue();
    }

    public final void J1(List<TAdNativeInfo> list) {
        List<RecommendInfo> listD;
        BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW0 = W0();
        List<RecommendInfo> listD2 = baseQuickAdapterW0 != null ? baseQuickAdapterW0.D() : null;
        if (listD2 == null || listD2.isEmpty()) {
            this.f51709s = list;
            return;
        }
        int size = list.size();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            RecommendInfo recommendInfoC1 = C1((TAdNativeInfo) it.next());
            int iE1 = E1();
            int i11 = iE1 + 1 + (size > 5 ? 1 : 2);
            BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW1 = W0();
            int size2 = (baseQuickAdapterW1 == null || (listD = baseQuickAdapterW1.D()) == null) ? 0 : listD.size();
            com.transsion.commercialization.pslink.a.f51724a.a("lastAdPosition = " + iE1 + " size = " + size + " insertPos = " + i11 + " dataCount = " + size2);
            if (i11 < size2) {
                BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW2 = W0();
                if (baseQuickAdapterW2 != null) {
                    baseQuickAdapterW2.j(i11, recommendInfoC1);
                }
            } else {
                BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW3 = W0();
                if (baseQuickAdapterW3 != null) {
                    baseQuickAdapterW3.l(recommendInfoC1);
                }
            }
        }
    }

    public final boolean K1(String str) {
        List<RecommendInfo> listD;
        if (str == null || str.length() == 0) {
            return true;
        }
        BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW0 = W0();
        if (baseQuickAdapterW0 == null || (listD = baseQuickAdapterW0.D()) == null) {
            return false;
        }
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            if (Intrinsics.b(((RecommendInfo) it.next()).getItemID(), str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L1() {
        RecyclerView recyclerView;
        zr.b bVar = new zr.b(0.6f, new b(), false, 4, null);
        bVar.n(2);
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar != null && (recyclerView = aVar.f65251d) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.f51708r = bVar;
    }

    public final void N1(List<RecommendInfo> list) {
        List<TAdNativeInfo> list2 = this.f51709s;
        int i11 = 0;
        int size = list2 != null ? list2.size() : 0;
        int size2 = list.size();
        if (size > 0) {
            if (size <= size2 / 2) {
                List<TAdNativeInfo> list3 = this.f51709s;
                if (list3 != null) {
                    for (Object obj : list3) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            g.u();
                        }
                        RecommendInfo recommendInfoC1 = C1((TAdNativeInfo) obj);
                        int i13 = (i12 * 2) + i11;
                        if (i13 < list.size()) {
                            list.add(i13, recommendInfoC1);
                        } else {
                            list.add(recommendInfoC1);
                        }
                        i11 = i12;
                    }
                }
            } else {
                List<TAdNativeInfo> list4 = this.f51709s;
                if (list4 != null) {
                    for (Object obj2 : list4) {
                        int i14 = i11 + 1;
                        if (i11 < 0) {
                            g.u();
                        }
                        RecommendInfo recommendInfoC2 = C1((TAdNativeInfo) obj2);
                        int i15 = (i11 * 2) + 1;
                        if (i15 < list.size()) {
                            list.add(i15, recommendInfoC2);
                        } else {
                            list.add(recommendInfoC2);
                        }
                        i11 = i14;
                    }
                }
            }
        }
        this.f51709s = null;
    }

    public final void P1() {
        PsLinkViewModel.d(G1(), this.f51706p, false, 0, "app_center_ps_link", null, 22, null);
    }

    public final void Q1(PsLinkDto psLinkDto) {
        List<RecommendInfo> listD;
        List<RecommendInfo> listD2;
        if (psLinkDto == null) {
            com.transsion.commercialization.pslink.a.f51724a.b(j0() + " --> initViewModel() --> psLinkDto is null");
            BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW0 = W0();
            if (baseQuickAdapterW0 == null || (listD2 = baseQuickAdapterW0.D()) == null || !listD2.isEmpty()) {
                m1();
                return;
            } else if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                I0(true);
                return;
            } else {
                PageStatusFragment.N0(this, false, 1, null);
                return;
            }
        }
        h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        List<RecommendInfo> data = psLinkDto.getData();
        if (data == null || data.isEmpty()) {
            BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW1 = W0();
            if (baseQuickAdapterW1 == null || (listD = baseQuickAdapterW1.D()) == null || !listD.isEmpty()) {
                BaseListFragment.l1(this, false, 1, null);
                return;
            } else {
                G0(true);
                return;
            }
        }
        List<RecommendInfo> data2 = psLinkDto.getData();
        if (data2 != null) {
            ArrayList arrayList = new ArrayList();
            for (RecommendInfo recommendInfo : data2) {
                if (!K1(recommendInfo.getItemID())) {
                    arrayList.add(recommendInfo);
                }
            }
            N1(arrayList);
            j1();
            this.f51706p++;
            BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW2 = W0();
            if (baseQuickAdapterW2 != null) {
                baseQuickAdapterW2.m(arrayList);
            }
        }
        List<RecommendInfo> data3 = psLinkDto.getData();
        if (data3 == null || data3.size() < 10) {
            BaseListFragment.l1(this, false, 1, null);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter<RecommendInfo, BaseViewHolder> T0() {
        return new rs.b(this.f51708r, D1());
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        String string = getString(com.transsion.commercialization.R$string.app_center);
        Intrinsics.f(string, "getString(R.string.app_center)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        P1();
        O1();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        super.initListener();
        BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW0 = W0();
        if (baseQuickAdapterW0 != null) {
            baseQuickAdapterW0.i(R$id.tvButton);
        }
        BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW1 = W0();
        if (baseQuickAdapterW1 != null) {
            baseQuickAdapterW1.z0(new f9.b() { // from class: com.transsion.commercialization.pslink.c
                @Override // f9.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    PsLinkFragment.M1(baseQuickAdapter, view, i11);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        G1().e().j(this, new d(new Function1<PsLinkDto, Unit>() { // from class: com.transsion.commercialization.pslink.PsLinkFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PsLinkDto psLinkDto) {
                invoke2(psLinkDto);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PsLinkDto psLinkDto) {
                PsLinkFragment.this.F0();
                PsLinkFragment.this.Q1(psLinkDto);
            }
        }));
        PsLinkServiceHelper.f51717a.h();
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        List<RecommendInfo> listD;
        BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW0 = W0();
        if (baseQuickAdapterW0 != null && (listD = baseQuickAdapterW0.D()) != null && listD.isEmpty()) {
            K0();
        }
        P1();
        O1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public h newLogViewConfig() {
        return new h("app_center", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        List<RecommendInfo> listD;
        super.onDestroy();
        BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW0 = W0();
        if (baseQuickAdapterW0 != null && (listD = baseQuickAdapterW0.D()) != null) {
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                TAdNativeInfo tAdNativeInfo = ((RecommendInfo) it.next()).getTAdNativeInfo();
                if (tAdNativeInfo != null) {
                    tAdNativeInfo.release();
                }
            }
        }
        D1().destroy();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        zr.b bVar = this.f51708r;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.transsion.baseui.fragment.LazyFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        List<RecommendInfo> listD;
        super.onResume();
        BaseQuickAdapter<RecommendInfo, BaseViewHolder> baseQuickAdapterW0 = W0();
        if (baseQuickAdapterW0 == null || (listD = baseQuickAdapterW0.D()) == null || !listD.isEmpty() || com.tn.lib.util.networkinfo.f.f49475a.e()) {
            return;
        }
        M0(false);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        fs.b bVarC = fs.b.c(LayoutInflater.from(getContext()));
        bVarC.f65254b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.pslink.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PsLinkFragment.F1(this.f51725a, view);
            }
        });
        ConstraintLayout root = bVarC.getRoot();
        Intrinsics.f(root, "root");
        return root;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        super.v0();
        U0();
        fs.a aVar = (fs.a) getMViewBinding();
        ConstraintLayout constraintLayout = aVar != null ? aVar.f65249b : null;
        if (constraintLayout != null) {
            constraintLayout.setBackground(b3.h.e(getResources(), R$drawable.ps_link_fragment_movie, null));
        }
        fs.a aVar2 = (fs.a) getMViewBinding();
        if (aVar2 != null && (recyclerView = aVar2.f65251d) != null) {
            recyclerView.addItemDecoration(new c());
        }
        L1();
    }
}
