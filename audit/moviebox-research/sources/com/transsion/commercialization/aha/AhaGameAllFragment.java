package com.transsion.commercialization.aha;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.d0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.report.h;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.bean.AhaGameData;
import com.transsion.bean.AhaGameResponse;
import com.transsion.bean.GameLayoutType;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import os.g;

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
public final class AhaGameAllFragment extends PageStatusFragment<g> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f51605o = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ns.a f51607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public zr.b f51608m;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f51606k = LazyKt__LazyJVMKt.b(new Function0<GameRecommendViewModel>() { // from class: com.transsion.commercialization.aha.AhaGameAllFragment$mViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GameRecommendViewModel invoke() {
            return new GameRecommendViewModel();
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f51609n = LazyKt__LazyJVMKt.b(new Function0<ms.a>() { // from class: com.transsion.commercialization.aha.AhaGameAllFragment$mGameDotHelper$2
        @Override // kotlin.jvm.functions.Function0
        public final ms.a invoke() {
            return new ms.a();
        }
    });

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

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f51611a;

            static {
                int[] iArr = new int[GameLayoutType.values().length];
                try {
                    iArr[GameLayoutType.ITEM_INFO.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[GameLayoutType.PEOPLE_PLAYING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f51611a = iArr;
            }
        }

        public b() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            List<AhaGameAllGames> listD;
            ns.a aVar = AhaGameAllFragment.this.f51607l;
            if (i11 < ((aVar == null || (listD = aVar.D()) == null) ? 0 : listD.size())) {
                ns.a aVar2 = AhaGameAllFragment.this.f51607l;
                AhaGameAllGames item = aVar2 != null ? aVar2.getItem(i11) : null;
                GameLayoutType gameLayoutType = item != null ? item.getGameLayoutType() : null;
                int i12 = gameLayoutType == null ? -1 : a.f51611a[gameLayoutType.ordinal()];
                if (i12 == 1) {
                    AhaGameAllFragment.this.Y0().a(item, i11, j11, item.getGameLayoutType());
                } else {
                    if (i12 != 2) {
                        return;
                    }
                    AhaGameAllFragment.this.Y0().c(item, j11);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f51612a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f51612a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f51612a;
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
            this.f51612a.invoke(obj);
        }
    }

    public static final void X0(AhaGameAllFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    private final void b1() {
        RecyclerView recyclerView;
        zr.b bVar = new zr.b(0.6f, new b(), false, 4, null);
        bVar.n(2);
        g mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f73409b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.f51608m = bVar;
    }

    public static final void c1(ns.a this_apply, AhaGameAllFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (!f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
            return;
        }
        String link = this_apply.getItem(i11).getLink();
        if (link != null) {
            this$0.h1(link);
        }
        AhaGameAllGames item = this_apply.getItem(i11);
        if (item.getGameLayoutType() == GameLayoutType.ITEM_INFO) {
            ms.a aVarY0 = this$0.Y0();
            if (i11 > 2) {
                i11 -= 2;
            }
            aVarY0.b(item, i11, item.getGameLayoutType());
        }
    }

    public static final void d1(AhaGameAllFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f1();
    }

    private final void f1() {
        Z0().h();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        Z0().h();
        K0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        h9.f fVarQ;
        List<AhaGameAllGames> listD;
        ns.a aVar = this.f51607l;
        if (aVar != null && (listD = aVar.D()) != null && listD.size() == 0) {
            B0();
            return;
        }
        ns.a aVar2 = this.f51607l;
        if (aVar2 == null || (fVarQ = aVar2.Q()) == null) {
            return;
        }
        fVarQ.v();
    }

    public final boolean W0(Integer num) {
        List<AhaGameAllGames> listD;
        if (num == null) {
            return true;
        }
        ns.a aVar = this.f51607l;
        if (aVar == null || (listD = aVar.D()) == null) {
            return false;
        }
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            if (Intrinsics.b(num, ((AhaGameAllGames) it.next()).getId())) {
                return true;
            }
        }
        return false;
    }

    public final ms.a Y0() {
        return (ms.a) this.f51609n.getValue();
    }

    public final GameRecommendViewModel Z0() {
        return (GameRecommendViewModel) this.f51606k.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public g getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        g gVarC = g.c(inflater);
        Intrinsics.f(gVarC, "inflate(inflater)");
        return gVarC;
    }

    public final void e1() {
        h9.f fVarQ;
        ns.a aVar;
        h9.f fVarQ2;
        ns.a aVar2 = this.f51607l;
        if (aVar2 == null || (fVarQ = aVar2.Q()) == null || !fVarQ.q() || (aVar = this.f51607l) == null || (fVarQ2 = aVar.Q()) == null) {
            return;
        }
        fVarQ2.r();
    }

    public final void g1(AhaGameResponse ahaGameResponse) {
        h9.f fVarQ;
        List<AhaGameAllGames> listD;
        List<AhaGameAllGames> allGames;
        ns.a aVar;
        h9.f fVarQ2;
        List<AhaGameAllGames> listD2;
        h9.f fVarQ3;
        List<AhaGameAllGames> listD3;
        AhaGameData data;
        List<AhaGameAllGames> allGames2;
        uo.b.f78622a.c(j0(), "ahaGameResponse = " + ((ahaGameResponse == null || (data = ahaGameResponse.getData()) == null || (allGames2 = data.getAllGames()) == null) ? null : Integer.valueOf(allGames2.size())), true);
        if (ahaGameResponse == null) {
            ns.a aVar2 = this.f51607l;
            if (aVar2 == null || (listD3 = aVar2.D()) == null || listD3.size() != 0) {
                ns.a aVar3 = this.f51607l;
                if (aVar3 == null || (fVarQ3 = aVar3.Q()) == null) {
                    return;
                }
                fVarQ3.u();
                return;
            }
            e1();
            if (f.f49475a.e()) {
                PageStatusFragment.J0(this, false, 1, null);
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
        e1();
        AhaGameData data2 = ahaGameResponse.getData();
        List<AhaGameAllGames> allGames3 = data2 != null ? data2.getAllGames() : null;
        if (allGames3 == null || allGames3.isEmpty()) {
            ns.a aVar4 = this.f51607l;
            if (aVar4 != null && (listD = aVar4.D()) != null && listD.size() == 0) {
                G0(true);
                return;
            }
            ns.a aVar5 = this.f51607l;
            if (aVar5 == null || (fVarQ = aVar5.Q()) == null) {
                return;
            }
            h9.f.t(fVarQ, false, 1, null);
            return;
        }
        AhaGameData data3 = ahaGameResponse.getData();
        if (data3 == null || (allGames = data3.getAllGames()) == null) {
            return;
        }
        ns.a aVar6 = this.f51607l;
        if (aVar6 != null && (listD2 = aVar6.D()) != null && listD2.size() == 0) {
            ns.a aVar7 = this.f51607l;
            if (aVar7 != null) {
                aVar7.l(new AhaGameAllGames(null, null, null, null, null, null, null, null, null, getString(com.transsion.commercialization.R$string.game_recommend_tip), GameLayoutType.ITEM_TITLE, null, 2559, null));
            }
            ns.a aVar8 = this.f51607l;
            if (aVar8 != null) {
                GameLayoutType gameLayoutType = GameLayoutType.PEOPLE_PLAYING;
                AhaGameData data4 = ahaGameResponse.getData();
                aVar8.l(new AhaGameAllGames(null, null, null, null, null, null, null, null, null, null, gameLayoutType, data4 != null ? data4.getPeoplePlaying() : null, 1023, null));
            }
            ns.a aVar9 = this.f51607l;
            if (aVar9 != null) {
                aVar9.l(new AhaGameAllGames(null, null, null, null, null, null, null, null, null, getString(com.transsion.commercialization.R$string.all_game), GameLayoutType.ITEM_TITLE, null, 2559, null));
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : allGames) {
            if (!W0(((AhaGameAllGames) obj).getId())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty() && (aVar = this.f51607l) != null && (fVarQ2 = aVar.Q()) != null) {
            h9.f.t(fVarQ2, false, 1, null);
        }
        ns.a aVar10 = this.f51607l;
        if (aVar10 != null) {
            aVar10.m(arrayList);
        }
    }

    public final void h1(String str) {
        Intent intent;
        FragmentActivity activity = getActivity();
        boolean booleanExtra = false;
        if (activity != null && (intent = activity.getIntent()) != null) {
            booleanExtra = intent.getBooleanExtra("fromTask", false);
        }
        com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", str).withString(WebConstants.PAGE_FROM, "game_center").withBoolean("fromTask", booleanExtra).navigation();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        Z0().g().j(this, new c(new Function1<AhaGameResponse, Unit>() { // from class: com.transsion.commercialization.aha.AhaGameAllFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AhaGameResponse ahaGameResponse) {
                invoke2(ahaGameResponse);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AhaGameResponse ahaGameResponse) {
                AhaGameAllFragment.this.F0();
                AhaGameAllFragment.this.g1(ahaGameResponse);
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public h newLogViewConfig() {
        return new h("game_center", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        zr.b bVar = this.f51608m;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        fs.b bVarC = fs.b.c(LayoutInflater.from(getContext()));
        bVarC.f65254b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.aha.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AhaGameAllFragment.X0(this.f51621a, view);
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

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        g mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            TitleLayout titleLayout = mViewBinding.f73410c;
            String string = getString(R$string.game_center);
            Intrinsics.f(string, "getString(com.tn.lib.widget.R.string.game_center)");
            titleLayout.setTitleText(string);
            RecyclerView recyclerView = mViewBinding.f73409b;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.addItemDecoration(new ro.f(f0.a(12.0f), 1));
            b1();
            final ns.a aVar = new ns.a(this.f51608m, Y0());
            aVar.B0(new f9.d() { // from class: com.transsion.commercialization.aha.a
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    AhaGameAllFragment.c1(aVar, this, baseQuickAdapter, view, i11);
                }
            });
            h9.f fVarQ = aVar.Q();
            fVarQ.y(true);
            fVarQ.x(true);
            fVarQ.D(1);
            fVarQ.C(new f9.f() { // from class: com.transsion.commercialization.aha.b
                @Override // f9.f
                public final void a() {
                    AhaGameAllFragment.d1(this.f51620a);
                }
            });
            this.f51607l = aVar;
            recyclerView.setAdapter(aVar);
            ns.a aVar2 = this.f51607l;
            recyclerView.addOnScrollListener(new hs.a(aVar2 != null ? aVar2.Q() : null));
        }
    }
}
