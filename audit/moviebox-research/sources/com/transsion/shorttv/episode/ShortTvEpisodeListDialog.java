package com.transsion.shorttv.episode;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.i;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.R$id;
import com.google.android.material.tabs.TabLayout;
import com.tn.lib.dialog.BaseDialog;
import com.tn.lib.widget.toast.core.h;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv.R$style;
import com.transsion.shorttv.ShortTvViewModel;
import com.transsnet.downloader.util.ShortTvMmkv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import rx.g;

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
public final class ShortTvEpisodeListDialog extends BaseDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nx.a f57851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f57852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Subject f57853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GridLayoutManager f57854d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f57855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f57856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f57857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f57858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f57859j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f9.d f57860k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f57861l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f57862m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements TabLayout.OnTabSelectedListener {
        public a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            nx.a aVar = ShortTvEpisodeListDialog.this.f57851a;
            if (aVar != null) {
                ShortTvEpisodeListDialog shortTvEpisodeListDialog = ShortTvEpisodeListDialog.this;
                if (tab != null && tab.isSelected() && aVar.f72170f.getScrollState() == 0) {
                    int selectedTabPosition = aVar.f72171g.getSelectedTabPosition() * 25;
                    GridLayoutManager gridLayoutManager = shortTvEpisodeListDialog.f57854d;
                    if (gridLayoutManager != null) {
                        int iFindFirstCompletelyVisibleItemPosition = ((selectedTabPosition - gridLayoutManager.findFirstCompletelyVisibleItemPosition()) / 5) * shortTvEpisodeListDialog.f57858i;
                        if (aVar.f72170f.canScrollVertically(iFindFirstCompletelyVisibleItemPosition)) {
                            aVar.f72170f.scrollBy(0, iFindFirstCompletelyVisibleItemPosition);
                        }
                    }
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57864a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57864a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57864a;
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
            this.f57864a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f57865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f57866b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ nx.a f57868d;

        public c(nx.a aVar) {
            this.f57868d = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            GridLayoutManager gridLayoutManager = ShortTvEpisodeListDialog.this.f57854d;
            if (gridLayoutManager != null) {
                nx.a aVar = this.f57868d;
                ShortTvEpisodeListDialog shortTvEpisodeListDialog = ShortTvEpisodeListDialog.this;
                int iFindFirstCompletelyVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
                if (iFindFirstCompletelyVisibleItemPosition != this.f57865a) {
                    this.f57865a = iFindFirstCompletelyVisibleItemPosition;
                    int i12 = iFindFirstCompletelyVisibleItemPosition / 25;
                    if (i12 != this.f57866b) {
                        aVar.f72171g.removeOnTabSelectedListener((TabLayout.OnTabSelectedListener) shortTvEpisodeListDialog.f57862m);
                        TabLayout.Tab tabAt = aVar.f72171g.getTabAt(i12);
                        if (tabAt != null) {
                            tabAt.select();
                        }
                        aVar.f72171g.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) shortTvEpisodeListDialog.f57862m);
                        this.f57866b = i12;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.transsion.shorttv.episode.ShortTvEpisodeListDialog$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class AnonymousClass2 extends Lambda implements Function1<Subject, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        public static final void b(ShortTvEpisodeListDialog this$0, View view) {
            Integer currentEp;
            Object next;
            Intrinsics.g(this$0, "this$0");
            view.setSelected(!view.isSelected());
            ShortTvMmkv.f61142a.i(view.isSelected());
            zp.b.f82110a.d(view.isSelected() ? R$string.short_tv_auto_unlock_on : R$string.short_tv_auto_unlock_off);
            if (!view.isSelected() || (currentEp = this$0.u0().v().f()) == null) {
                return;
            }
            Iterator<T> it = this$0.s0().D().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((qx.d) next).b() != currentEp.intValue());
            qx.d dVar = (qx.d) next;
            if (dVar == null || dVar.e()) {
                return;
            }
            String strD = dVar.d();
            Subject subject = this$0.f57853c;
            rx.f fVar = new rx.f(strD, subject != null ? Integer.valueOf(subject.getTotalEpisode()) : null, null, 4, null);
            Set<Integer> setD = fVar.d();
            Intrinsics.f(currentEp, "currentEp");
            setD.add(currentEp);
            ShortTvViewModel shortTvViewModelU0 = this$0.u0();
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            shortTvViewModelU0.Q(contextRequireContext, fVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subject subject) {
            invoke2(subject);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subject subject) {
            AppCompatTextView appCompatTextView;
            ShortTvEpisodeListDialog.this.f57853c = subject;
            nx.a aVar = ShortTvEpisodeListDialog.this.f57851a;
            AppCompatTextView appCompatTextView2 = aVar != null ? aVar.f72173i : null;
            if (appCompatTextView2 != null) {
                Subject subject2 = ShortTvEpisodeListDialog.this.f57853c;
                appCompatTextView2.setText(subject2 != null ? subject2.getTitle() : null);
            }
            nx.a aVar2 = ShortTvEpisodeListDialog.this.f57851a;
            if (aVar2 == null || (appCompatTextView = aVar2.f72172h) == null) {
                return;
            }
            final ShortTvEpisodeListDialog shortTvEpisodeListDialog = ShortTvEpisodeListDialog.this;
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.episode.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTvEpisodeListDialog.AnonymousClass2.b(shortTvEpisodeListDialog, view);
                }
            });
        }
    }

    public ShortTvEpisodeListDialog() {
        super(R$layout.short_tv_dialog_episode_list);
        this.f57852b = FragmentViewModelLazyKt.a(this, Reflection.b(ShortTvViewModel.class), new Function0<x0>() { // from class: com.transsion.shorttv.episode.ShortTvEpisodeListDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.shorttv.episode.ShortTvEpisodeListDialog$special$$inlined$activityViewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f57855f = LazyKt__LazyJVMKt.b(new Function0<com.transsion.shorttv.episode.b>() { // from class: com.transsion.shorttv.episode.ShortTvEpisodeListDialog$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return this.this$0.u0().y().e();
            }
        });
        this.f57858i = (com.blankj.utilcode.util.d0.e() - i.e(24.0f)) / 5;
        this.f57859j = "unlockDialog";
        this.f57860k = new f9.d() { // from class: com.transsion.shorttv.episode.e
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTvEpisodeListDialog.x0(this.f57870a, baseQuickAdapter, view, i11);
            }
        };
        this.f57862m = new a();
    }

    private final void A0() {
        String subjectId;
        nx.a aVar = this.f57851a;
        if (aVar != null) {
            AppCompatTextView appCompatTextView = aVar.f72172h;
            Intrinsics.f(appCompatTextView, "viewBinding.tvAutoUnlock");
            so.c.k(appCompatTextView);
            int iV0 = (v0() + 24) / 25;
            Subject subject = this.f57853c;
            if (subject == null || (subjectId = subject.getSubjectId()) == null) {
                subjectId = "";
            }
            Integer numF = u0().v().f();
            if (numF == null) {
                numF = 1;
            }
            Intrinsics.f(numF, "shortTvPlayListViewModel…yingEpLiveData.value ?: 1");
            int iIntValue = numF.intValue();
            for (int i11 = 0; i11 < iV0; i11++) {
                int iT0 = (i11 * 25) + t0();
                String str = iT0 + "-" + kotlin.ranges.a.g(iT0 + 24, w0());
                aVar.f72171g.setTabTextColors(-1, u0().y().f());
                TabLayout tabLayout = aVar.f72171g;
                TabLayout.Tab text = tabLayout.newTab().setText(str);
                text.view.setLongClickable(false);
                if (Build.VERSION.SDK_INT >= 26) {
                    text.view.setTooltipText(null);
                }
                tabLayout.addTab(text);
            }
            if (iV0 <= 1) {
                aVar.f72171g.setVisibility(8);
                aVar.f72174j.setVisibility(8);
            } else {
                aVar.f72171g.setVisibility(0);
                aVar.f72174j.setVisibility(0);
            }
            RecyclerView recyclerView = aVar.f72170f;
            Intrinsics.f(recyclerView, "viewBinding.rv");
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = this.f57858i * 5;
            recyclerView.setLayoutParams(bVar);
            aVar.f72171g.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this.f57862m);
            aVar.f72170f.addOnScrollListener(new c(aVar));
            int iE = i.e(12.0f);
            aVar.f72170f.setPadding(iE, 0, iE, 0);
            RecyclerView recyclerView2 = aVar.f72170f;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5, 1, false);
            this.f57854d = gridLayoutManager;
            recyclerView2.setLayoutManager(gridLayoutManager);
            j.d(v.a(this), null, null, new ShortTvEpisodeListDialog$showAllEpisodes$1$5(this, subjectId, iIntValue, null), 3, null);
        }
    }

    private final int v0() {
        if (this.f57856g) {
            Subject subject = this.f57853c;
            return (subject != null ? subject.getTotalEpisode() : 0) + 1;
        }
        Subject subject2 = this.f57853c;
        if (subject2 != null) {
            return subject2.getTotalEpisode();
        }
        return 0;
    }

    public static final void x0(ShortTvEpisodeListDialog this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        if (this$0.f57857h == 0 || System.currentTimeMillis() - this$0.f57857h > 1000) {
            this$0.f57857h = System.currentTimeMillis();
            List<qx.d> listD = this$0.s0().D();
            if (i11 < listD.size()) {
                qx.d dVar = listD.get(i11);
                if (dVar.e()) {
                    this$0.z0(dVar);
                    return;
                }
                if (i11 > 0) {
                    int i12 = i11 - 1;
                    qx.d dVar2 = listD.get(i12);
                    if (dVar2.e()) {
                        tp.e eVar = tp.e.f77259a;
                        Context contextRequireContext = this$0.requireContext();
                        Intrinsics.f(contextRequireContext, "requireContext()");
                        if (!eVar.a(contextRequireContext)) {
                            h.f50034a.k(R$string.player_no_network_tip2);
                            return;
                        } else {
                            this$0.u0().y().c(this$0, this$0.f57853c, dVar, dVar.b(), dVar.b());
                            this$0.dismiss();
                            return;
                        }
                    }
                    int iB = dVar2.b();
                    while (-1 < i12) {
                        qx.d dVar3 = listD.get(i12);
                        if (dVar3.e()) {
                            break;
                        }
                        iB = dVar3.b();
                        i12--;
                    }
                    this$0.u0().y().c(this$0, this$0.f57853c, dVar, iB, dVar.b());
                    this$0.dismiss();
                }
            }
        }
    }

    public static final void y0(ShortTvEpisodeListDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public final void B0(List<qx.d> list) {
        ProgressBar progressBar;
        nx.a aVar = this.f57851a;
        if (aVar != null) {
            AppCompatTextView appCompatTextView = aVar.f72172h;
            Intrinsics.f(appCompatTextView, "viewBinding.tvAutoUnlock");
            so.c.g(appCompatTextView);
            Integer numF = u0().v().f();
            if (numF == null) {
                numF = 1;
            }
            Intrinsics.f(numF, "shortTvPlayListViewModel…yingEpLiveData.value ?: 1");
            int iIntValue = numF.intValue();
            TabLayout tabLayout = aVar.f72171g;
            Intrinsics.f(tabLayout, "viewBinding.tab");
            so.c.g(tabLayout);
            View view = aVar.f72174j;
            Intrinsics.f(view, "viewBinding.viewLine");
            so.c.g(view);
            RecyclerView recyclerView = aVar.f72170f;
            Intrinsics.f(recyclerView, "viewBinding.rv");
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = this.f57858i * 5;
            recyclerView.setLayoutParams(bVar);
            int iE = i.e(12.0f);
            aVar.f72170f.setPadding(iE, 0, iE, 0);
            RecyclerView recyclerView2 = aVar.f72170f;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5, 1, false);
            this.f57854d = gridLayoutManager;
            recyclerView2.setLayoutManager(gridLayoutManager);
            nx.a aVar2 = this.f57851a;
            RecyclerView recyclerView3 = aVar2 != null ? aVar2.f72170f : null;
            if (recyclerView3 != null) {
                com.transsion.shorttv.episode.b bVarS0 = s0();
                bVarS0.x0(CollectionsKt___CollectionsKt.M0(list));
                bVarS0.B0(this.f57860k);
                bVarS0.I0(iIntValue);
                recyclerView3.setAdapter(bVarS0);
            }
        }
        nx.a aVar3 = this.f57851a;
        if (aVar3 == null || (progressBar = aVar3.f72169d) == null) {
            return;
        }
        so.c.g(progressBar);
    }

    public final void C0(List<qx.d> list) {
        if (list.size() == v0()) {
            A0();
        } else {
            B0(list);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(requireContext(), R$style.ShortTvBottomDialogTheme);
        bVar.o().U0(3);
        bVar.o().T0(true);
        return bVar;
    }

    @Override // com.tn.lib.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.getAttributes().gravity = 80;
            window.getAttributes().height = -2;
            View viewFindViewById = window.findViewById(R$id.design_bottom_sheet);
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundResource(R.color.transparent);
            }
        }
        nx.a aVar = this.f57851a;
        AppCompatTextView appCompatTextView = aVar != null ? aVar.f72172h : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setSelected(ShortTvMmkv.f61142a.f());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f57856g = arguments != null ? arguments.getBoolean("hasTrailer") : this.f57856g;
        nx.a aVarA = nx.a.a(view);
        aVarA.f72168c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.episode.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShortTvEpisodeListDialog.y0(this.f57869a, view2);
            }
        });
        ProgressBar pbLoading = aVarA.f72169d;
        Intrinsics.f(pbLoading, "pbLoading");
        so.c.k(pbLoading);
        FrameLayout flAuto = aVarA.f72167b;
        Intrinsics.f(flAuto, "flAuto");
        flAuto.setVisibility(u0().y().b() ? 0 : 8);
        this.f57851a = aVarA;
        this.f57853c = u0().H().f();
        u0().H().j(getViewLifecycleOwner(), new b(new AnonymousClass2()));
        u0().F().j(this, new b(new Function1<List<? extends qx.e>, Unit>() { // from class: com.transsion.shorttv.episode.ShortTvEpisodeListDialog.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends qx.e> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends qx.e> list) {
                List listL;
                ShortTvEpisodeListDialog shortTvEpisodeListDialog = ShortTvEpisodeListDialog.this;
                if (list != null) {
                    listL = new ArrayList();
                    for (Object obj : list) {
                        if (obj instanceof qx.d) {
                            listL.add(obj);
                        }
                    }
                } else {
                    listL = kotlin.collections.g.l();
                }
                shortTvEpisodeListDialog.C0(listL);
            }
        }));
        u0().v().j(this, new b(new Function1<Integer, Unit>() { // from class: com.transsion.shorttv.episode.ShortTvEpisodeListDialog.onViewCreated.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                com.transsion.shorttv.episode.b bVarS0 = ShortTvEpisodeListDialog.this.s0();
                Intrinsics.f(it, "it");
                bVarS0.I0(it.intValue());
            }
        }));
        this.f57861l = u0().K().f();
        u0().K().j(this, new b(new Function1<g, Unit>() { // from class: com.transsion.shorttv.episode.ShortTvEpisodeListDialog.onViewCreated.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(g gVar) {
                invoke2(gVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(g gVar) {
                com.transsion.shorttv.episode.b bVarS0;
                if (!(gVar instanceof rx.i) || (bVarS0 = ShortTvEpisodeListDialog.this.s0()) == null) {
                    return;
                }
                bVarS0.notifyDataSetChanged();
            }
        }));
    }

    public final com.transsion.shorttv.episode.b s0() {
        return (com.transsion.shorttv.episode.b) this.f57855f.getValue();
    }

    public final int t0() {
        return !this.f57856g ? 1 : 0;
    }

    public final ShortTvViewModel u0() {
        return (ShortTvViewModel) this.f57852b.getValue();
    }

    public final int w0() {
        Subject subject = this.f57853c;
        if (subject != null) {
            return subject.getTotalEpisode();
        }
        return 0;
    }

    public final void z0(qx.d item) {
        Intrinsics.g(item, "item");
        u0().O(item.b());
        dismissAllowingStateLoss();
    }
}
