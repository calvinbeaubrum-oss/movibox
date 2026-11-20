package com.transsion.search.fragment.result;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.f0;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baseui.R$string;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.baseui.widget.DrawableCenterTextView;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.publish.model.PostEntity;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SearchList;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.bean.TabItem;
import com.transsion.search.fragment.BaseSearchMainFragment;
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
public final class SearchResultFragment extends BaseSearchMainFragment<bx.g> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f57543h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f57544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f57545b = LazyKt__LazyJVMKt.b(new Function0<SearchResultViewModel>() { // from class: com.transsion.search.fragment.result.SearchResultFragment$viewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SearchResultViewModel invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            return (SearchResultViewModel) new v0(fragmentActivityRequireActivity).a(SearchResultViewModel.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SearchResultEntity f57546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ResourcesRequestView f57547d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f57548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f57549g;

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
    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagicIndicator f57550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SearchResultFragment f57551b;

        public b(MagicIndicator magicIndicator, SearchResultFragment searchResultFragment) {
            this.f57550a = magicIndicator;
            this.f57551b = searchResultFragment;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            this.f57550a.onPageScrollStateChanged(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            this.f57550a.onPageScrolled(i11, f11, i12);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            List<TabItem> tabs;
            TabItem tabItem;
            this.f57550a.onPageSelected(i11);
            jx.b.a aVar = jx.b.f68176a;
            String str = this.f57551b.f57544a;
            SearchResultEntity searchResultEntity = this.f57551b.f57546c;
            aVar.s(str, (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null || (tabItem = tabs.get(i11)) == null) ? null : tabItem.getTabId());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends com.transsion.baseui.util.f {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f57553g;

        public c(int i11) {
            this.f57553g = i11;
        }

        @Override // com.transsion.baseui.util.f
        public void c(View view) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.transsion.baseui.util.f
        public void d(View view) {
            ViewPager2 viewPager2;
            bx.g gVar = (bx.g) SearchResultFragment.this.getMViewBinding();
            if (gVar == null || (viewPager2 = gVar.f14487g) == null) {
                return;
            }
            viewPager2.setCurrentItem(this.f57553g, false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends h20.a {
        public d() {
        }

        @Override // h20.a
        public int a() {
            List<TabItem> tabs;
            SearchResultEntity searchResultEntity = SearchResultFragment.this.f57546c;
            if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) {
                return 0;
            }
            return tabs.size();
        }

        @Override // h20.a
        public h20.c b(Context context) {
            Intrinsics.g(context, "context");
            return SearchResultFragment.this.getIndicatorView(context);
        }

        @Override // h20.a
        public h20.d c(Context context, int i11) {
            List<TabItem> tabs;
            TabItem tabItem;
            Intrinsics.g(context, "context");
            SearchResultFragment searchResultFragment = SearchResultFragment.this;
            SearchResultEntity searchResultEntity = searchResultFragment.f57546c;
            return searchResultFragment.getIndicatorText(context, i11, (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null || (tabItem = tabs.get(i11)) == null) ? null : tabItem.getName());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends FragmentStateAdapter {
        public e() {
            super(SearchResultFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            List<TabItem> tabs;
            SearchResultFragment searchResultFragment = SearchResultFragment.this;
            SearchResultEntity searchResultEntity = searchResultFragment.f57546c;
            return searchResultFragment.u0((searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) ? null : tabs.get(i11));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<TabItem> tabs;
            SearchResultEntity searchResultEntity = SearchResultFragment.this.f57546c;
            if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) {
                return 0;
            }
            return tabs.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57556a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57556a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57556a;
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
            this.f57556a.invoke(obj);
        }
    }

    public static final void A0(SearchResultFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        String str = this$0.f57544a;
        if (str == null) {
            str = "";
        }
        this$0.B0(str, this$0.f57549g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initViewPager() {
        bx.g gVar = (bx.g) getMViewBinding();
        MagicIndicator magicIndicator = gVar != null ? gVar.f14484c : null;
        if (magicIndicator != null) {
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            commonNavigator.setAdapter(new d());
            magicIndicator.setNavigator(commonNavigator);
        }
        bx.g gVar2 = (bx.g) getMViewBinding();
        ViewPager2 viewPager2 = gVar2 != null ? gVar2.f14487g : null;
        if (viewPager2 == null) {
            return;
        }
        viewPager2.setAdapter(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final View y0() {
        DrawableCenterTextView drawableCenterTextView;
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i11 = R$layout.view_search_no_network;
            bx.g gVar = (bx.g) getMViewBinding();
            View view = layoutInflater.inflate(i11, (ViewGroup) (gVar != null ? gVar.f14483b : null), false);
            TextView textView = (TextView) view.findViewById(R$id.tv_empty_tips);
            ImageView imageView = (ImageView) view.findViewById(R$id.iv_tips);
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R$id.tv_retry);
            textView.setText(R$string.base_net_err);
            imageView.setImageResource(R$mipmap.ic_no_network);
            appCompatTextView.setVisibility(0);
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchResultFragment.A0(this.f57585a, view2);
                }
            });
            Intrinsics.f(view, "view");
            return view;
        }
        LayoutInflater layoutInflater2 = getLayoutInflater();
        int i12 = R$layout.view_search_empty;
        bx.g gVar2 = (bx.g) getMViewBinding();
        View view2 = layoutInflater2.inflate(i12, (ViewGroup) (gVar2 != null ? gVar2.f14483b : null), false);
        final ResourcesRequestView resourcesRequestView = (ResourcesRequestView) view2.findViewById(R$id.resources_request);
        this.f57547d = resourcesRequestView;
        final String str = this.f57544a;
        if (str == null) {
            str = "";
        }
        if (str.length() > 10) {
            String strSubstring = str.substring(0, 10);
            Intrinsics.f(strSubstring, "substring(...)");
            str = strSubstring + "...";
        }
        String string = getString(com.transsion.search.R$string.search_value_no_result, this.f57544a);
        Intrinsics.f(string, "getString(R.string.searc…value_no_result, keyword)");
        resourcesRequestView.set(string);
        resourcesRequestView.setGray(true);
        w0().l(str, true);
        this.f57548f = null;
        fs.f mViewBinding = resourcesRequestView.getMViewBinding();
        if (mViewBinding != null && (drawableCenterTextView = mViewBinding.f65283f) != null) {
            drawableCenterTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SearchResultFragment.z0(this.f57582a, str, resourcesRequestView, view3);
                }
            });
        }
        Intrinsics.f(view2, "view");
        return view2;
    }

    public static final void z0(SearchResultFragment this$0, String splitKeyword, ResourcesRequestView requestView, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(splitKeyword, "$splitKeyword");
        lw.c.f70578a.c(this$0, NoticePermissionFrom.DETAIL_NO_RES);
        SearchResultViewModel.m(this$0.w0(), splitKeyword, false, 2, null);
        Integer num = this$0.f57548f;
        if (num != null) {
            Intrinsics.d(num);
            this$0.f57548f = Integer.valueOf(num.intValue() + 1);
            Intrinsics.f(requestView, "requestView");
            Integer num2 = this$0.f57548f;
            Intrinsics.d(num2);
            ResourcesRequestView.setCount$default(requestView, num2.intValue(), false, 2, null);
        }
    }

    public final void B0(String keyword, String str) {
        Intrinsics.g(keyword, "keyword");
        this.f57544a = keyword;
        startLoading();
        this.f57546c = null;
        initViewPager();
        this.f57549g = str;
        w0().p(1);
        SearchResultViewModel.o(w0(), keyword, null, false, 6, null);
    }

    public final h20.d getIndicatorText(Context context, int i11, String str) {
        CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context, 17, f0.a(12.0f));
        customPagerTitleView.setSelectTextSize(16.0f);
        customPagerTitleView.setText(str);
        customPagerTitleView.setOnClickListener(new c(i11));
        return customPagerTitleView;
    }

    public final h20.c getIndicatorView(Context context) {
        GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context);
        gradientLinePagerIndicator.setMode(1);
        gradientLinePagerIndicator.setLineHeight(f0.a(2.0f));
        gradientLinePagerIndicator.setLineWidth(f0.a(24.0f));
        gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        int color = z2.a.getColor(context, R$color.white);
        gradientLinePagerIndicator.setColors(color, color, color);
        return gradientLinePagerIndicator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        bx.g gVar = (bx.g) getMViewBinding();
        ProgressBar progressBar = gVar != null ? gVar.f14486f : null;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
        bx.g gVar2 = (bx.g) getMViewBinding();
        ViewPager2 viewPager2 = gVar2 != null ? gVar2.f14487g : null;
        if (viewPager2 != null) {
            viewPager2.setVisibility(0);
        }
        bx.g gVar3 = (bx.g) getMViewBinding();
        MagicIndicator magicIndicator = gVar3 != null ? gVar3.f14484c : null;
        if (magicIndicator != null) {
            magicIndicator.setVisibility(0);
        }
        bx.g gVar4 = (bx.g) getMViewBinding();
        View view = gVar4 != null ? gVar4.f14485d : null;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    @SuppressLint({"NotifyDataSetChanged"})
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        initViewPager();
        w0().j().j(getViewLifecycleOwner(), new f(new Function1<SearchResultEntity, Unit>() { // from class: com.transsion.search.fragment.result.SearchResultFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchResultEntity searchResultEntity) {
                invoke2(searchResultEntity);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SearchResultEntity searchResultEntity) {
                FrameLayout frameLayout;
                FrameLayout frameLayout2;
                List<TabItem> tabs;
                List<SearchList> results;
                ViewPager2 viewPager2;
                RecyclerView.Adapter adapter;
                MagicIndicator magicIndicator;
                f20.a navigator;
                SearchResultFragment.this.hideLoading();
                if (searchResultEntity != null && (tabs = searchResultEntity.getTabs()) != null && !tabs.isEmpty() && (results = searchResultEntity.getResults()) != null && !results.isEmpty()) {
                    SearchResultFragment.this.f57546c = searchResultEntity;
                    bx.g gVar = (bx.g) SearchResultFragment.this.getMViewBinding();
                    if (gVar != null && (magicIndicator = gVar.f14484c) != null && (navigator = magicIndicator.getNavigator()) != null) {
                        navigator.notifyDataSetChanged();
                    }
                    bx.g gVar2 = (bx.g) SearchResultFragment.this.getMViewBinding();
                    if (gVar2 == null || (viewPager2 = gVar2.f14487g) == null || (adapter = viewPager2.getAdapter()) == null) {
                        return;
                    }
                    adapter.notifyDataSetChanged();
                    return;
                }
                bx.g gVar3 = (bx.g) SearchResultFragment.this.getMViewBinding();
                if (gVar3 != null && (frameLayout2 = gVar3.f14483b) != null) {
                    frameLayout2.removeAllViews();
                }
                bx.g gVar4 = (bx.g) SearchResultFragment.this.getMViewBinding();
                if (gVar4 != null && (frameLayout = gVar4.f14483b) != null) {
                    frameLayout.addView(SearchResultFragment.this.y0());
                }
                bx.g gVar5 = (bx.g) SearchResultFragment.this.getMViewBinding();
                View view2 = gVar5 != null ? gVar5.f14485d : null;
                if (view2 != null) {
                    view2.setVisibility(4);
                }
                bx.g gVar6 = (bx.g) SearchResultFragment.this.getMViewBinding();
                FrameLayout frameLayout3 = gVar6 != null ? gVar6.f14483b : null;
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(0);
                }
                if ((searchResultEntity != null ? searchResultEntity.getPager() : null) != null) {
                    List<SearchList> results2 = searchResultEntity.getResults();
                    if (results2 == null || results2.isEmpty()) {
                        jx.b.f68176a.i(SearchResultFragment.this.f57544a, SearchResultFragment.this.f57549g);
                    }
                }
            }
        }));
        w0().h().j(this, new f(new Function1<PostEntity, Unit>() { // from class: com.transsion.search.fragment.result.SearchResultFragment.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PostEntity postEntity) {
                invoke2(postEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PostEntity postEntity) {
                uo.b.a.g(uo.b.f78622a, "Post request succeed " + postEntity + ", " + (postEntity != null ? postEntity.getCount() : null), false, 2, null);
                if (postEntity == null || SearchResultFragment.this.f57548f != null) {
                    return;
                }
                SearchResultFragment searchResultFragment = SearchResultFragment.this;
                int count = postEntity.getCount();
                if (count == null) {
                    count = 0;
                }
                searchResultFragment.f57548f = count;
                ResourcesRequestView resourcesRequestView = SearchResultFragment.this.f57547d;
                if (resourcesRequestView != null) {
                    Integer count2 = postEntity.getCount();
                    resourcesRequestView.setCount(count2 != null ? count2.intValue() : 0, false);
                }
            }
        }));
        bx.g gVar = (bx.g) getMViewBinding();
        if (gVar != null) {
            MagicIndicator magicIndicator = gVar.f14484c;
            Intrinsics.f(magicIndicator, "it.searchResultMagicIndicator");
            ViewPager2 viewPager2 = gVar.f14487g;
            Intrinsics.f(viewPager2, "it.searchResultViewPager");
            t0(magicIndicator, viewPager2);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        com.transsion.baselib.report.h hVar = new com.transsion.baselib.report.h("searchresult", false, 2, null);
        hVar.k(true);
        return hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        bx.g gVar = (bx.g) getMViewBinding();
        ProgressBar progressBar = gVar != null ? gVar.f14486f : null;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        bx.g gVar2 = (bx.g) getMViewBinding();
        ViewPager2 viewPager2 = gVar2 != null ? gVar2.f14487g : null;
        if (viewPager2 != null) {
            viewPager2.setVisibility(4);
        }
        bx.g gVar3 = (bx.g) getMViewBinding();
        MagicIndicator magicIndicator = gVar3 != null ? gVar3.f14484c : null;
        if (magicIndicator != null) {
            magicIndicator.setVisibility(4);
        }
        bx.g gVar4 = (bx.g) getMViewBinding();
        View view = gVar4 != null ? gVar4.f14485d : null;
        if (view != null) {
            view.setVisibility(4);
        }
        bx.g gVar5 = (bx.g) getMViewBinding();
        FrameLayout frameLayout = gVar5 != null ? gVar5.f14483b : null;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(4);
    }

    public final void t0(MagicIndicator magicIndicator, ViewPager2 viewPager2) {
        viewPager2.registerOnPageChangeCallback(new b(magicIndicator, this));
    }

    public final Fragment u0(TabItem tabItem) {
        String tabId = tabItem != null ? tabItem.getTabId() : null;
        SearchResultEntity searchResultEntity = this.f57546c;
        return SearchResultTabFragment.f57557n.a(this.f57544a, tabItem, Intrinsics.b(tabId, searchResultEntity != null ? searchResultEntity.getTabId() : null) ? this.f57546c : null, this.f57549g);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public bx.g getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        bx.g gVarC = bx.g.c(inflater);
        Intrinsics.f(gVarC, "inflate(inflater)");
        return gVarC;
    }

    public final SearchResultViewModel w0() {
        return (SearchResultViewModel) this.f57545b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x0(String id2) {
        Integer numValueOf;
        ViewPager2 viewPager2;
        List<TabItem> tabs;
        Intrinsics.g(id2, "id");
        SearchResultEntity searchResultEntity = this.f57546c;
        if (searchResultEntity == null || (tabs = searchResultEntity.getTabs()) == null) {
            numValueOf = null;
        } else {
            Iterator<TabItem> it = tabs.iterator();
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                } else if (Intrinsics.b(it.next().getTabId(), id2)) {
                    break;
                } else {
                    i11++;
                }
            }
            numValueOf = Integer.valueOf(i11);
        }
        bx.g gVar = (bx.g) getMViewBinding();
        if (gVar == null || (viewPager2 = gVar.f14487g) == null) {
            return;
        }
        viewPager2.setCurrentItem(numValueOf != null ? numValueOf.intValue() : 0, false);
    }
}
