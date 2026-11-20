package com.transsion.search.fragment.hot;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.postdetail.shorttv.widget.ShortTVHistoryView;
import com.transsion.search.R$id;
import com.transsion.search.R$string;
import com.transsion.search.SearchManager;
import com.transsion.search.bean.HotRankItem;
import com.transsion.search.bean.HotSearchKeyWord;
import com.transsion.search.bean.HotSubjectEntity;
import com.transsion.search.fragment.BaseSearchMainFragment;
import com.transsion.search.fragment.SearchSubjectFragment;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsion.search.widget.LinesFlexBoxLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

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
public final class SearchHotFragment extends BaseSearchMainFragment<bx.c> implements TRDialogListener {
    public static final a Companion = new a(null);
    public static final String PAGE_NAME = "search_hot_subject";
    private ex.f everyOneSearchAdapter;
    private boolean expand;
    private String hotSearchWord;
    private List<String> mHistoryList = new ArrayList();
    private HotSubjectEntity mHotSubjectEntity;
    private ex.d mSearchHistoryAdapter;
    private SearchViewModel mSearchViewModel;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchHotFragment a(String str) {
            SearchHotFragment searchHotFragment = new SearchHotFragment();
            searchHotFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("hot_search_word", str)));
            return searchHotFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ViewPager2.PageTransformer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f57522a;

        public b(int i11) {
            this.f57522a = i11;
        }

        public /* synthetic */ b(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? gs.a.a(38) : i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
        public void transformPage(View page, float f11) {
            Intrinsics.g(page, "page");
            if (f11 < -1.0f) {
                page.setTranslationX(0.0f);
                return;
            }
            if (f11 <= 0.0f) {
                page.setTranslationX(0.0f);
            } else if (f11 <= 1.0f) {
                page.setTranslationX(-(this.f57522a * f11));
            } else {
                page.setTranslationX(-(this.f57522a * (f11 - 1)));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends com.transsion.baseui.util.f {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f57524g;

        public c(int i11) {
            this.f57524g = i11;
        }

        @Override // com.transsion.baseui.util.f
        public void c(View view) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.transsion.baseui.util.f
        public void d(View view) {
            MagicIndicator magicIndicator;
            ViewPager2 viewPager2;
            bx.c cVar = (bx.c) SearchHotFragment.this.getMViewBinding();
            if (cVar != null && (viewPager2 = cVar.f14456n) != null) {
                viewPager2.setCurrentItem(this.f57524g, false);
            }
            bx.c cVar2 = (bx.c) SearchHotFragment.this.getMViewBinding();
            if (cVar2 == null || (magicIndicator = cVar2.f14453k) == null) {
                return;
            }
            magicIndicator.onPageScrolled(this.f57524g, 0.0f, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends h20.a {
        public d() {
        }

        @Override // h20.a
        public int a() {
            List<HotRankItem> hot;
            HotSubjectEntity hotSubjectEntity = SearchHotFragment.this.mHotSubjectEntity;
            if (hotSubjectEntity == null || (hot = hotSubjectEntity.getHot()) == null) {
                return 0;
            }
            return hot.size();
        }

        @Override // h20.a
        public h20.c b(Context context) {
            Intrinsics.g(context, "context");
            return SearchHotFragment.this.getIndicatorView(context);
        }

        @Override // h20.a
        public h20.d c(Context context, int i11) {
            String name;
            List<HotRankItem> hot;
            HotRankItem hotRankItem;
            Intrinsics.g(context, "context");
            HotSubjectEntity hotSubjectEntity = SearchHotFragment.this.mHotSubjectEntity;
            if (hotSubjectEntity == null || (hot = hotSubjectEntity.getHot()) == null || (hotRankItem = hot.get(i11)) == null || (name = hotRankItem.getName()) == null) {
                name = "";
            }
            return SearchHotFragment.this.getIndicatorText(context, i11, name);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends FragmentStateAdapter {
        public e() {
            super(SearchHotFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            List<HotRankItem> hot;
            HotSubjectEntity hotSubjectEntity = SearchHotFragment.this.mHotSubjectEntity;
            HotRankItem hotRankItem = (hotSubjectEntity == null || (hot = hotSubjectEntity.getHot()) == null) ? null : hot.get(i11);
            if (hotRankItem != null) {
                hotRankItem.setIndex(i11);
            }
            return SearchRankPagerFragment.f57530b.a(hotRankItem);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<HotRankItem> hot;
            HotSubjectEntity hotSubjectEntity = SearchHotFragment.this.mHotSubjectEntity;
            if (hotSubjectEntity == null || (hot = hotSubjectEntity.getHot()) == null) {
                return 0;
            }
            return hot.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends ViewPager2.OnPageChangeCallback {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i11);
            bx.c cVar = (bx.c) SearchHotFragment.this.getMViewBinding();
            if (cVar == null || (magicIndicator = cVar.f14453k) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i11, f11, i12);
            bx.c cVar = (bx.c) SearchHotFragment.this.getMViewBinding();
            if (cVar == null || (magicIndicator = cVar.f14453k) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i11, f11, i12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            MagicIndicator magicIndicator;
            super.onPageSelected(i11);
            Fragment fragmentFindFragmentByTag = SearchHotFragment.this.getChildFragmentManager().findFragmentByTag("f" + i11);
            if (fragmentFindFragmentByTag instanceof SearchRankPagerFragment) {
                ((SearchRankPagerFragment) fragmentFindFragmentByTag).h0();
            }
            bx.c cVar = (bx.c) SearchHotFragment.this.getMViewBinding();
            if (cVar == null || (magicIndicator = cVar.f14453k) == null) {
                return;
            }
            magicIndicator.onPageSelected(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements xw.a {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final void c(List list, SearchHotFragment this$0) {
            Intrinsics.g(list, "$list");
            Intrinsics.g(this$0, "this$0");
            ArrayList arrayList = new ArrayList();
            List list2 = list;
            arrayList.addAll(list2);
            m.U(arrayList);
            this$0.mHistoryList = arrayList;
            this$0.showHistoryList();
            bx.c cVar = (bx.c) this$0.getMViewBinding();
            ConstraintLayout constraintLayout = cVar != null ? cVar.f14447d : null;
            if (constraintLayout == null) {
                return;
            }
            constraintLayout.setVisibility(list2.isEmpty() ^ true ? 0 : 8);
        }

        @Override // xw.a
        public void a(final List<String> list) {
            Intrinsics.g(list, "list");
            FragmentActivity activity = SearchHotFragment.this.getActivity();
            if (activity != null) {
                final SearchHotFragment searchHotFragment = SearchHotFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.transsion.search.fragment.hot.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchHotFragment.g.c(list, searchHotFragment);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57529a;

        public h(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57529a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57529a;
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
            this.f57529a.invoke(obj);
        }
    }

    private final void clearTipsDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.search_clear_title);
            Intrinsics.f(string, "getString(R.string.search_clear_title)");
            TRDialog.a aVarK = aVar.k(string);
            String string2 = getString(R$string.search_clear_des);
            Intrinsics.f(string2, "getString(R.string.search_clear_des)");
            TRDialog.a aVarG = aVarK.g(string2);
            String string3 = getString(R$string.search_clear_cancel);
            Intrinsics.f(string3, "getString(R.string.search_clear_cancel)");
            TRDialog.a aVarE = aVarG.e(string3);
            String string4 = getString(R$string.search_clear_clear);
            Intrinsics.f(string4, "getString(R.string.search_clear_clear)");
            aVarE.j(string4).h(R$drawable.libui_sub_btn2_normal).f(this).a().m0(this, "clear_tips");
        } catch (Exception e11) {
            uo.b.a.g(uo.b.f78622a, "e " + e11.getLocalizedMessage(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NotifyDataSetChanged"})
    public final void expandHistoryLine(final boolean z11) {
        RecyclerView recyclerView;
        bx.c cVar = (bx.c) getMViewBinding();
        if (cVar == null || (recyclerView = cVar.f14448f) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.search.fragment.hot.b
            @Override // java.lang.Runnable
            public final void run() {
                SearchHotFragment.expandHistoryLine$lambda$7(this.f57533a, z11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void expandHistoryLine$lambda$7(SearchHotFragment this$0, boolean z11) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Intrinsics.g(this$0, "this$0");
        bx.c cVar = (bx.c) this$0.getMViewBinding();
        RecyclerView.m layoutManager = null;
        if (((cVar == null || (recyclerView2 = cVar.f14448f) == null) ? null : recyclerView2.getLayoutManager()) instanceof LinesFlexBoxLayoutManager) {
            bx.c cVar2 = (bx.c) this$0.getMViewBinding();
            if (cVar2 != null && (recyclerView = cVar2.f14448f) != null) {
                layoutManager = recyclerView.getLayoutManager();
            }
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type com.transsion.search.widget.LinesFlexBoxLayoutManager");
            LinesFlexBoxLayoutManager linesFlexBoxLayoutManager = (LinesFlexBoxLayoutManager) layoutManager;
            int iA0 = linesFlexBoxLayoutManager.a0();
            if (iA0 <= 0) {
                return;
            }
            boolean z12 = true;
            linesFlexBoxLayoutManager.e0(z11 ? 2 : 1);
            int iC0 = linesFlexBoxLayoutManager.c0((!z11 || iA0 <= 1) ? 0 : 1) - 1;
            ex.d dVar = this$0.mSearchHistoryAdapter;
            if (dVar != null) {
                if (!z11 && iA0 <= 1) {
                    z12 = false;
                }
                dVar.a1(z12, z11, iC0);
            }
            ex.d dVar2 = this$0.mSearchHistoryAdapter;
            if (dVar2 != null) {
                dVar2.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h20.d getIndicatorText(Context context, int i11, String str) {
        CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context, 17, f0.a(10.0f));
        customPagerTitleView.setSelectTextSize(16.0f);
        customPagerTitleView.setText(str);
        customPagerTitleView.setOnClickListener(new c(i11));
        return customPagerTitleView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h20.c getIndicatorView(Context context) {
        GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context);
        gradientLinePagerIndicator.setMode(1);
        gradientLinePagerIndicator.setLineHeight(f0.a(2.0f));
        gradientLinePagerIndicator.setLineWidth(f0.a(30.0f));
        gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        int color = z2.a.getColor(context, R$color.white);
        gradientLinePagerIndicator.setColors(color, color, color);
        return gradientLinePagerIndicator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initEveryoneSearch() {
        RecyclerView recyclerView;
        Bundle arguments = getArguments();
        this.hotSearchWord = arguments != null ? arguments.getString("hot_search_word") : null;
        ex.f fVar = new ex.f(0, 1, null);
        fVar.i(R$id.tv_keyword);
        fVar.z0(new f9.b() { // from class: com.transsion.search.fragment.hot.e
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SearchHotFragment.initEveryoneSearch$lambda$16$lambda$15(this.f57537a, baseQuickAdapter, view, i11);
            }
        });
        this.everyOneSearchAdapter = fVar;
        bx.c cVar = (bx.c) getMViewBinding();
        if (cVar == null || (recyclerView = cVar.f14445b) == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        LinesFlexBoxLayoutManager linesFlexBoxLayoutManager = new LinesFlexBoxLayoutManager(contextRequireContext);
        linesFlexBoxLayoutManager.P(0);
        linesFlexBoxLayoutManager.Q(1);
        linesFlexBoxLayoutManager.R(0);
        linesFlexBoxLayoutManager.e0(2);
        recyclerView.setLayoutManager(linesFlexBoxLayoutManager);
        recyclerView.setAdapter(this.everyOneSearchAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEveryoneSearch$lambda$16$lambda$15(final SearchHotFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Object objM163constructorimpl;
        HotSearchKeyWord item;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Fragment parentFragment = this$0.getParentFragment();
        if (parentFragment instanceof SearchSubjectFragment) {
            try {
                Result.Companion companion = Result.Companion;
                ex.f fVar = this$0.everyOneSearchAdapter;
                objM163constructorimpl = Result.m163constructorimpl((fVar == null || (item = fVar.getItem(i11)) == null) ? null : item.getTitle());
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            String str = (String) (Result.m169isFailureimpl(objM163constructorimpl) ? null : objM163constructorimpl);
            if (str == null) {
                return;
            }
            ((SearchSubjectFragment) parentFragment).z0(str, "hot", new Function1<String, Unit>() { // from class: com.transsion.search.fragment.hot.SearchHotFragment$initEveryoneSearch$1$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.g(it, "it");
                    ex.d dVar = this.this$0.mSearchHistoryAdapter;
                    if (dVar != null) {
                        dVar.l(new ex.a(1, it));
                    }
                }
            });
            jx.b.f68176a.h(str, i11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initHistory() {
        TextView textView;
        bx.c cVar = (bx.c) getMViewBinding();
        if (cVar != null && (textView = cVar.f14459q) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.hot.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHotFragment.initHistory$lambda$4(this.f57535a, view);
                }
            });
        }
        ex.d dVar = new ex.d();
        this.mSearchHistoryAdapter = dVar;
        dVar.i(R$id.search_history_text);
        ex.d dVar2 = this.mSearchHistoryAdapter;
        if (dVar2 != null) {
            dVar2.z0(new f9.b() { // from class: com.transsion.search.fragment.hot.d
                @Override // f9.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    SearchHotFragment.initHistory$lambda$6(this.f57536a, baseQuickAdapter, view, i11);
                }
            });
        }
        loadHistoryData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHistory$lambda$4(SearchHotFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.clearTipsDialog();
        Context context = view.getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
        if (KeyboardUtils.g((Activity) context)) {
            Context context2 = view.getContext();
            Intrinsics.e(context2, "null cannot be cast to non-null type android.app.Activity");
            KeyboardUtils.d((Activity) context2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHistory$lambda$6(final SearchHotFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Object objM163constructorimpl;
        ex.a item;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Fragment parentFragment = this$0.getParentFragment();
        if (parentFragment instanceof SearchSubjectFragment) {
            try {
                Result.Companion companion = Result.Companion;
                ex.d dVar = this$0.mSearchHistoryAdapter;
                objM163constructorimpl = Result.m163constructorimpl((dVar == null || (item = dVar.getItem(i11)) == null) ? null : item.a());
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            String str = (String) (Result.m169isFailureimpl(objM163constructorimpl) ? null : objM163constructorimpl);
            if (str == null) {
                return;
            }
            ((SearchSubjectFragment) parentFragment).z0(str, ShortTVHistoryView.TYPE_HISTORY, new Function1<String, Unit>() { // from class: com.transsion.search.fragment.hot.SearchHotFragment$initHistory$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.g(it, "it");
                    ex.d dVar2 = this.this$0.mSearchHistoryAdapter;
                    if (dVar2 != null) {
                        dVar2.l(new ex.a(1, it));
                    }
                }
            });
            jx.b.f68176a.f(str, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void initHotWordWithData(HotSubjectEntity hotSubjectEntity) {
        ConstraintLayout constraintLayout;
        List<HotSearchKeyWord> everyoneSearch;
        RecyclerView recyclerView;
        List<HotSearchKeyWord> everyoneSearch2;
        bx.c cVar = (bx.c) getMViewBinding();
        if (cVar == null || (constraintLayout = cVar.f14449g) == null) {
            return;
        }
        if (hotSubjectEntity == null || (everyoneSearch = hotSubjectEntity.getEveryoneSearch()) == null || everyoneSearch.size() <= 0) {
            so.c.g(constraintLayout);
            return;
        }
        so.c.k(constraintLayout);
        final ArrayList arrayList = new ArrayList();
        if (hotSubjectEntity != null && (everyoneSearch2 = hotSubjectEntity.getEveryoneSearch()) != null) {
            for (HotSearchKeyWord hotSearchKeyWord : everyoneSearch2) {
                if (!Intrinsics.b(hotSearchKeyWord.getTitle(), this.hotSearchWord)) {
                    arrayList.add(hotSearchKeyWord);
                }
            }
        }
        ex.f fVar = this.everyOneSearchAdapter;
        if (fVar != null) {
            fVar.w0(arrayList);
        }
        bx.c cVar2 = (bx.c) getMViewBinding();
        if (cVar2 == null || (recyclerView = cVar2.f14445b) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.search.fragment.hot.g
            @Override // java.lang.Runnable
            public final void run() {
                SearchHotFragment.initHotWordWithData$lambda$13$lambda$12(this.f57539a, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initHotWordWithData$lambda$13$lambda$12(SearchHotFragment this$0, List hotSearchList) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(hotSearchList, "$hotSearchList");
        bx.c cVar = (bx.c) this$0.getMViewBinding();
        RecyclerView.m layoutManager = (cVar == null || (recyclerView = cVar.f14445b) == null) ? null : recyclerView.getLayoutManager();
        if (layoutManager instanceof LinesFlexBoxLayoutManager) {
            int iB0 = ((LinesFlexBoxLayoutManager) layoutManager).b0();
            for (int i11 = 0; i11 < iB0; i11++) {
                if (i11 < hotSearchList.size()) {
                    jx.b.f68176a.g(((HotSearchKeyWord) hotSearchList.get(i11)).getTitle(), i11);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void initRankWithData(HotSubjectEntity hotSubjectEntity) {
        RelativeLayout relativeLayout;
        ViewPager2 viewPager2;
        RecyclerView.Adapter adapter;
        MagicIndicator magicIndicator;
        f20.a navigator;
        RelativeLayout relativeLayout2;
        List<HotRankItem> hot = hotSubjectEntity != null ? hotSubjectEntity.getHot() : null;
        if (hot == null || hot.isEmpty()) {
            bx.c cVar = (bx.c) getMViewBinding();
            if (cVar == null || (relativeLayout = cVar.f14455m) == null) {
                return;
            }
            so.c.h(relativeLayout);
            return;
        }
        bx.c cVar2 = (bx.c) getMViewBinding();
        if (cVar2 != null && (relativeLayout2 = cVar2.f14455m) != null) {
            so.c.k(relativeLayout2);
        }
        this.mHotSubjectEntity = hotSubjectEntity;
        bx.c cVar3 = (bx.c) getMViewBinding();
        if (cVar3 != null && (magicIndicator = cVar3.f14453k) != null && (navigator = magicIndicator.getNavigator()) != null) {
            navigator.notifyDataSetChanged();
        }
        bx.c cVar4 = (bx.c) getMViewBinding();
        if (cVar4 == null || (viewPager2 = cVar4.f14456n) == null || (adapter = viewPager2.getAdapter()) == null) {
            return;
        }
        adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$1(SearchHotFragment this$0, NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(nestedScrollView, "<anonymous parameter 0>");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || !KeyboardUtils.g(activity)) {
            return;
        }
        bx.c cVar = (bx.c) this$0.getMViewBinding();
        com.transsion.publish.view.m.a(cVar != null ? cVar.f14457o : null);
    }

    private final void initViewModel() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        SearchViewModel searchViewModel = (SearchViewModel) new v0(fragmentActivityRequireActivity).a(SearchViewModel.class);
        searchViewModel.i().j(this, new h(new Function1<HotSubjectEntity, Unit>() { // from class: com.transsion.search.fragment.hot.SearchHotFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HotSubjectEntity hotSubjectEntity) {
                invoke2(hotSubjectEntity);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HotSubjectEntity hotSubjectEntity) {
                bx.c cVar = (bx.c) this.this$0.getMViewBinding();
                ProgressBar progressBar = cVar != null ? cVar.f14446c : null;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                bx.c cVar2 = (bx.c) this.this$0.getMViewBinding();
                View view = cVar2 != null ? cVar2.f14452j : null;
                if (view != null) {
                    view.setVisibility(0);
                }
                com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.j(true);
                }
                this.this$0.initHotWordWithData(hotSubjectEntity);
                this.this$0.initRankWithData(hotSubjectEntity);
            }
        }));
        this.mSearchViewModel = searchViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initViewPager() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager3;
        ViewPager2 viewPager4;
        bx.c cVar = (bx.c) getMViewBinding();
        Object[] objArr = 0;
        MagicIndicator magicIndicator = cVar != null ? cVar.f14453k : null;
        if (magicIndicator != null) {
            CommonNavigator commonNavigator = new CommonNavigator(requireContext());
            commonNavigator.setAdapter(new d());
            magicIndicator.setNavigator(commonNavigator);
        }
        bx.c cVar2 = (bx.c) getMViewBinding();
        ViewPager2 viewPager5 = cVar2 != null ? cVar2.f14456n : null;
        if (viewPager5 != null) {
            viewPager5.setAdapter(new e());
        }
        bx.c cVar3 = (bx.c) getMViewBinding();
        if (cVar3 != null && (viewPager4 = cVar3.f14456n) != null) {
            viewPager4.setLayerType(2, null);
        }
        bx.c cVar4 = (bx.c) getMViewBinding();
        int i11 = 1;
        if (cVar4 != null && (viewPager3 = cVar4.f14456n) != null) {
            viewPager3.setPageTransformer(new b(0, i11, objArr == true ? 1 : 0));
        }
        bx.c cVar5 = (bx.c) getMViewBinding();
        ViewPager2 viewPager6 = cVar5 != null ? cVar5.f14456n : null;
        if (viewPager6 != null) {
            viewPager6.setOffscreenPageLimit(1);
        }
        bx.c cVar6 = (bx.c) getMViewBinding();
        if (cVar6 == null || (viewPager2 = cVar6.f14456n) == null) {
            return;
        }
        viewPager2.registerOnPageChangeCallback(new f());
    }

    private final void loadHistoryData() {
        SearchManager.f57422f.a().k(3, new g());
        if (getParentFragment() instanceof SearchSubjectFragment) {
            Fragment parentFragment = getParentFragment();
            Intrinsics.e(parentFragment, "null cannot be cast to non-null type com.transsion.search.fragment.SearchSubjectFragment");
            ((SearchSubjectFragment) parentFragment).M0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showHistoryList() {
        RecyclerView recyclerView;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        ex.d dVar = this.mSearchHistoryAdapter;
        if (dVar != null) {
            dVar.Z0(new Function0<Unit>() { // from class: com.transsion.search.fragment.hot.SearchHotFragment.showHistoryList.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SearchHotFragment searchHotFragment = SearchHotFragment.this;
                    searchHotFragment.expand = !searchHotFragment.expand;
                    SearchHotFragment searchHotFragment2 = SearchHotFragment.this;
                    searchHotFragment2.expandHistoryLine(searchHotFragment2.expand);
                    bx.c cVar = (bx.c) SearchHotFragment.this.getMViewBinding();
                    com.transsion.publish.view.m.a(cVar != null ? cVar.f14448f : null);
                }
            });
        }
        bx.c cVar = (bx.c) getMViewBinding();
        RecyclerView recyclerView2 = cVar != null ? cVar.f14448f : null;
        if (recyclerView2 != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            LinesFlexBoxLayoutManager linesFlexBoxLayoutManager = new LinesFlexBoxLayoutManager(contextRequireContext);
            linesFlexBoxLayoutManager.P(0);
            linesFlexBoxLayoutManager.Q(1);
            linesFlexBoxLayoutManager.R(0);
            linesFlexBoxLayoutManager.e0(this.expand ? 2 : 1);
            recyclerView2.setLayoutManager(linesFlexBoxLayoutManager);
        }
        bx.c cVar2 = (bx.c) getMViewBinding();
        RecyclerView recyclerView3 = cVar2 != null ? cVar2.f14448f : null;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.mSearchHistoryAdapter);
        }
        bx.c cVar3 = (bx.c) getMViewBinding();
        RecyclerView recyclerView4 = cVar3 != null ? cVar3.f14448f : null;
        if (recyclerView4 != null) {
            recyclerView4.setItemAnimator(null);
        }
        List<String> list = this.mHistoryList;
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ex.a(1, (String) it.next()));
        }
        List listM0 = CollectionsKt___CollectionsKt.M0(arrayList);
        ex.d dVar2 = this.mSearchHistoryAdapter;
        if (dVar2 != null) {
            dVar2.x0(listM0);
        }
        bx.c cVar4 = (bx.c) getMViewBinding();
        if (cVar4 == null || (recyclerView = cVar4.f14448f) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.search.fragment.hot.f
            @Override // java.lang.Runnable
            public final void run() {
                SearchHotFragment.showHistoryList$lambda$10(this.f57538a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showHistoryList$lambda$10(SearchHotFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.expandHistoryLine(this$0.expand);
    }

    public final void addHistoryWord(String keyword) {
        Intrinsics.g(keyword, "keyword");
        if (this.mHistoryList.contains(keyword)) {
            return;
        }
        SearchManager.f57422f.a().e(keyword);
        this.mHistoryList.add(0, keyword);
        if (this.mHistoryList.size() > 10) {
            List<String> list = this.mHistoryList;
            list.remove(list.size() - 1);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public bx.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        bx.c cVarC = bx.c.c(inflater);
        Intrinsics.f(cVarC, "inflate(inflater)");
        return cVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        NestedScrollView nestedScrollView;
        Intrinsics.g(view, "view");
        initViewModel();
        initHistory();
        initEveryoneSearch();
        initViewPager();
        bx.c cVar = (bx.c) getMViewBinding();
        if (cVar == null || (nestedScrollView = cVar.f14457o) == null) {
            return;
        }
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.d() { // from class: com.transsion.search.fragment.hot.a
            @Override // androidx.core.widget.NestedScrollView.d
            public final void a(NestedScrollView nestedScrollView2, int i11, int i12, int i13, int i14) {
                SearchHotFragment.initView$lambda$1(this.f57532a, nestedScrollView2, i11, i12, i13, i14);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        SearchViewModel searchViewModel = this.mSearchViewModel;
        if (searchViewModel != null) {
            searchViewModel.h();
        }
        bx.c cVar = (bx.c) getMViewBinding();
        ProgressBar progressBar = cVar != null ? cVar.f14446c : null;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        bx.c cVar2 = (bx.c) getMViewBinding();
        View view = cVar2 != null ? cVar2.f14452j : null;
        if (view == null) {
            return;
        }
        view.setVisibility(4);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        com.transsion.baselib.report.h hVar = new com.transsion.baselib.report.h(PAGE_NAME, false, 2, null);
        hVar.k(true);
        return hVar;
    }

    public final void onConnected() {
        if (this.mHotSubjectEntity == null) {
            lazyLoadData();
        }
    }

    @Override // com.transsion.search.fragment.BaseSearchMainFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (z11) {
            return;
        }
        loadHistoryData();
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        RecyclerView recyclerView;
        Intrinsics.g(dialog, "dialog");
        if (TextUtils.equals(dialog.getTag(), "clear_tips")) {
            SearchManager.f57422f.a().h();
            this.mHistoryList.clear();
            bx.c cVar = (bx.c) getMViewBinding();
            RecyclerView.m layoutManager = null;
            ConstraintLayout constraintLayout = cVar != null ? cVar.f14447d : null;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            ex.d dVar = this.mSearchHistoryAdapter;
            if (dVar != null) {
                dVar.x0(new ArrayList());
            }
            bx.c cVar2 = (bx.c) getMViewBinding();
            if (cVar2 != null && (recyclerView = cVar2.f14448f) != null) {
                layoutManager = recyclerView.getLayoutManager();
            }
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type com.transsion.search.widget.LinesFlexBoxLayoutManager");
            ((LinesFlexBoxLayoutManager) layoutManager).d0();
            expandHistoryLine(false);
            jx.b.f68176a.c();
        }
    }
}
