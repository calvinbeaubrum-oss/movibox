package com.transsion.home.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.h;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.util.f;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.home.R$mipmap;
import com.transsion.home.R$string;
import com.transsion.home.activity.MovieFilterActivity;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.fragment.tab.MovieFragment;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import h20.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
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
/* JADX INFO: loaded from: classes7.dex */
@Route(path = "/home/movieFilter")
@Metadata
@SourceDebugExtension
public final class MovieFilterActivity extends BaseActivity<lt.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "tabId")
    @JvmField
    public int f51984a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Autowired(name = "filterType")
    @JvmField
    public String f51987d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = "showViewPager")
    @JvmField
    public boolean f51985b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Autowired(name = "tabCode")
    @JvmField
    public String f51986c = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<HomeTabItem> f51988f = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends FragmentStateAdapter {
        public a() {
            super(MovieFilterActivity.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            MovieFilterActivity movieFilterActivity = MovieFilterActivity.this;
            int i12 = movieFilterActivity.f51984a;
            Integer tabId = ((HomeTabItem) movieFilterActivity.f51988f.get(i11)).getTabId();
            String str = (tabId != null && i12 == tabId.intValue()) ? MovieFilterActivity.this.f51987d : null;
            MovieFragment.a aVar = MovieFragment.A;
            Integer tabId2 = ((HomeTabItem) MovieFilterActivity.this.f51988f.get(i11)).getTabId();
            return aVar.a(tabId2 != null ? tabId2.intValue() : 2, true, str, ((HomeTabItem) MovieFilterActivity.this.f51988f.get(i11)).getTabCode());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MovieFilterActivity.this.f51988f.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
            ((lt.b) MovieFilterActivity.this.getMViewBinding()).f70387b.onPageScrollStateChanged(i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
            ((lt.b) MovieFilterActivity.this.getMViewBinding()).f70387b.onPageScrolled(i11, f11, i12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            ((lt.b) MovieFilterActivity.this.getMViewBinding()).f70387b.onPageSelected(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends h20.a {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends f {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ MovieFilterActivity f51992f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ int f51993g;

            public a(MovieFilterActivity movieFilterActivity, int i11) {
                this.f51992f = movieFilterActivity;
                this.f51993g = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                ((lt.b) this.f51992f.getMViewBinding()).f70389d.setCurrentItem(this.f51993g, false);
                ((lt.b) this.f51992f.getMViewBinding()).f70387b.onPageScrolled(this.f51993g, 0.0f, 0);
            }
        }

        public c() {
        }

        @Override // h20.a
        public int a() {
            return MovieFilterActivity.this.f51988f.size();
        }

        @Override // h20.a
        public h20.c b(Context context) {
            GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(MovieFilterActivity.this);
            MovieFilterActivity movieFilterActivity = MovieFilterActivity.this;
            gradientLinePagerIndicator.setMode(2);
            gradientLinePagerIndicator.setLineHeight(com.transsion.usercenter.setting.labelsfeedback.a.b(3));
            gradientLinePagerIndicator.setLineWidth(com.transsion.usercenter.setting.labelsfeedback.a.b(24));
            gradientLinePagerIndicator.setRoundRadius(com.transsion.usercenter.setting.labelsfeedback.a.a(1.5f));
            gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            int color = z2.a.getColor(movieFilterActivity, R$color.white);
            gradientLinePagerIndicator.setColors(color, color, color);
            return gradientLinePagerIndicator;
        }

        @Override // h20.a
        public d c(Context context, int i11) {
            CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(MovieFilterActivity.this, 17, com.transsion.usercenter.setting.labelsfeedback.a.b(12));
            MovieFilterActivity movieFilterActivity = MovieFilterActivity.this;
            customPagerTitleView.setText(((HomeTabItem) movieFilterActivity.f51988f.get(i11)).getName());
            customPagerTitleView.setOnClickListener(new a(movieFilterActivity, i11));
            return customPagerTitleView;
        }
    }

    public static final void U(MovieFilterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        es.b bVar = (es.b) es.a.f64348a.a(es.b.class);
        if (bVar != null) {
            bVar.c("", this$0);
        }
    }

    public static final void V(MovieFilterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.a0();
        this$0.finish();
    }

    private final void Z() {
        HashMap map = new HashMap();
        map.put("event_type", "back_browse");
        map.put("tabId", String.valueOf(this.f51984a));
        com.transsion.baselib.helper.a.f51183a.d(getPageName(), map);
    }

    private final void a0() {
        HashMap map = new HashMap();
        map.put("event_type", "back_click");
        map.put("tabId", String.valueOf(this.f51984a));
        com.transsion.baselib.helper.a.f51183a.e(getPageName(), map);
    }

    public final int R(int i11) {
        int size = this.f51988f.size();
        for (int i12 = 0; i12 < size; i12++) {
            Integer tabId = this.f51988f.get(i12).getTabId();
            if (tabId != null && tabId.intValue() == i11) {
                return i12;
            }
        }
        return 0;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public lt.b getViewBinding() {
        lt.b bVarC = lt.b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T() {
        List<HomeTabItem> homeTabs;
        PreloadTrendingData.a aVar = PreloadTrendingData.f52790o;
        AppTab appTabF = aVar.a().x().f();
        if (appTabF == null) {
            appTabF = aVar.a().w().f();
        }
        this.f51988f.clear();
        if (!this.f51985b || !Y(Integer.valueOf(this.f51984a))) {
            this.f51988f.add(new HomeTabItem("", Integer.valueOf(this.f51984a), "", "", this.f51986c, null, null, null, 224, null));
            MagicIndicator magicIndicator = ((lt.b) getMViewBinding()).f70387b;
            Intrinsics.f(magicIndicator, "mViewBinding.magicIndicator");
            so.c.g(magicIndicator);
            return;
        }
        if (appTabF == null || (homeTabs = appTabF.getHomeTabs()) == null) {
            return;
        }
        for (HomeTabItem homeTabItem : homeTabs) {
            if (Intrinsics.b(homeTabItem != null ? homeTabItem.getType() : null, HomeTabType.SUB_OPERATION.getValue()) && Y(homeTabItem.getTabId())) {
                this.f51988f.add(homeTabItem);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W() {
        ((lt.b) getMViewBinding()).f70389d.setAdapter(new a());
        ((lt.b) getMViewBinding()).f70389d.registerOnPageChangeCallback(new b());
        b0(this.f51984a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X() {
        MagicIndicator magicIndicator = ((lt.b) getMViewBinding()).f70387b;
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new c());
        magicIndicator.setNavigator(commonNavigator);
    }

    public final boolean Y(Integer num) {
        int value = HomeTabId.Movie.getValue();
        if (num == null || num.intValue() != value) {
            int value2 = HomeTabId.TVShow.getValue();
            if (num == null || num.intValue() != value2) {
                int value3 = HomeTabId.Animation.getValue();
                if (num == null || num.intValue() != value3) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b0(int i11) {
        ((lt.b) getMViewBinding()).f70389d.setCurrentItem(R(i11), false);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "movie_filter_page";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        TitleLayout titleLayout = ((lt.b) getMViewBinding()).f70388c;
        titleLayout.setRightView(R$mipmap.ic_search_movie, new View.OnClickListener() { // from class: ht.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieFilterActivity.U(this.f66786a, view);
            }
        });
        titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: ht.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieFilterActivity.V(this.f66787a, view);
            }
        });
        Z();
        String string = getString(R$string.filter);
        Intrinsics.f(string, "getString(R.string.filter)");
        titleLayout.setTitleText(string);
        tp.f fVar = tp.f.f77260a;
        Context context = titleLayout.getContext();
        Intrinsics.f(context, "context");
        titleLayout.setPadding(0, fVar.d(context), 0, 0);
        T();
        X();
        W();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public h newLogViewConfig() {
        h hVar = new h(getPageName(), false, 2, null);
        hVar.k(true);
        return hVar;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void retryLoadData() {
    }
}
