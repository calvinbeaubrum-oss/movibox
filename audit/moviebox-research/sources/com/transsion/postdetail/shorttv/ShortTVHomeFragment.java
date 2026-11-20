package com.transsion.postdetail.shorttv;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.shorttv.widget.ShortTVTabTitleView;
import com.transsion.postdetail.ui.fragment.ShortTvVideoFragment;
import com.transsion.postdetail.ui.fragment.VideoFragment;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import tv.r;

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
public final class ShortTVHomeFragment extends BaseFragment<r> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f55341m = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55342a = ShortTVHomeFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer[] f55343b = {Integer.valueOf(R$string.discover), Integer.valueOf(R$string.title_for_you)};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, ShortTVTabTitleView> f55344c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommonNavigator f55345d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f55346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f55347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FragmentStateAdapter f55348h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ShortTVDiscoverFragment f55349i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f55350j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f55351k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f55352l;

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
    public static final class b extends h20.a {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends com.transsion.baseui.util.f {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ ShortTVHomeFragment f55354f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ int f55355g;

            public a(ShortTVHomeFragment shortTVHomeFragment, int i11) {
                this.f55354f = shortTVHomeFragment;
                this.f55355g = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                ViewPager2 viewPager2;
                r mViewBinding = this.f55354f.getMViewBinding();
                if (mViewBinding != null && (viewPager2 = mViewBinding.f77915c) != null) {
                    viewPager2.setCurrentItem(this.f55355g, false);
                }
                if (this.f55355g == 0) {
                    this.f55354f.f55347g = 0;
                    ShortTVDiscoverFragment shortTVDiscoverFragment = this.f55354f.f55349i;
                    if (shortTVDiscoverFragment != null) {
                        shortTVDiscoverFragment.V1(false);
                    }
                }
            }
        }

        public b() {
        }

        @Override // h20.a
        public int a() {
            return ShortTVHomeFragment.this.f55343b.length;
        }

        @Override // h20.a
        public h20.c b(Context context) {
            Intrinsics.g(context, "context");
            Context contextRequireContext = ShortTVHomeFragment.this.requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(contextRequireContext);
            ShortTVHomeFragment shortTVHomeFragment = ShortTVHomeFragment.this;
            gradientLinePagerIndicator.setMode(2);
            gradientLinePagerIndicator.setLineHeight(com.blankj.utilcode.util.i.e(3.0f));
            gradientLinePagerIndicator.setLineWidth(com.blankj.utilcode.util.i.e(24.0f));
            gradientLinePagerIndicator.setRoundRadius(com.blankj.utilcode.util.i.e(1.5f));
            gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            gradientLinePagerIndicator.setColors(z2.a.getColor(shortTVHomeFragment.requireContext(), R$color.brand_gradient_start), z2.a.getColor(shortTVHomeFragment.requireContext(), R$color.brand_gradient_center), z2.a.getColor(shortTVHomeFragment.requireContext(), R$color.brand_gradient_end));
            return gradientLinePagerIndicator;
        }

        @Override // h20.a
        public h20.d c(Context context, int i11) {
            Intrinsics.g(context, "context");
            ShortTVTabTitleView shortTVTabTitleView = new ShortTVTabTitleView(context);
            ShortTVHomeFragment shortTVHomeFragment = ShortTVHomeFragment.this;
            shortTVTabTitleView.setTextById(shortTVHomeFragment.f55343b[i11].intValue());
            shortTVTabTitleView.setOnClickListener(new a(shortTVHomeFragment, i11));
            shortTVHomeFragment.f55344c.put(Integer.valueOf(i11), shortTVTabTitleView);
            return shortTVTabTitleView;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends ViewPager2.OnPageChangeCallback {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i11);
            r mViewBinding = ShortTVHomeFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f77914b) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i11, f11, i12);
            r mViewBinding = ShortTVHomeFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f77914b) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i11, f11, i12);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            ShortTVDiscoverFragment shortTVDiscoverFragment;
            MagicIndicator magicIndicator;
            super.onPageSelected(i11);
            r mViewBinding = ShortTVHomeFragment.this.getMViewBinding();
            if (mViewBinding != null && (magicIndicator = mViewBinding.f77914b) != null) {
                magicIndicator.onPageSelected(i11);
            }
            if ((ShortTVHomeFragment.this.f55347g == 0 || i11 == 0) && (shortTVDiscoverFragment = ShortTVHomeFragment.this.f55349i) != null) {
                shortTVDiscoverFragment.V1(i11 != 0);
            }
            ShortTVHomeFragment.this.v0(true);
            ShortTVHomeFragment.this.x0(true);
            ShortTVHomeFragment.this.f55347g = i11;
            ShortTVHomeFragment shortTVHomeFragment = ShortTVHomeFragment.this;
            shortTVHomeFragment.w0(shortTVHomeFragment.f55352l);
        }
    }

    public static final void B0(ShortTVHomeFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            Result.Companion companion = Result.Companion;
            if (this$0.isAdded() && this$0.getContext() != null) {
                this$0.w0(this$0.f55352l);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    private final void initViewPager() {
        this.f55348h = new FragmentStateAdapter() { // from class: com.transsion.postdetail.shorttv.ShortTVHomeFragment.initViewPager.1
            {
                super(ShortTVHomeFragment.this);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            public Fragment createFragment(int i11) {
                uo.b.a aVar = uo.b.f78622a;
                String TAG = ShortTVHomeFragment.this.f55342a;
                Intrinsics.f(TAG, "TAG");
                uo.b.a.f(aVar, TAG, "createFragment, position:" + i11, false, 4, null);
                if (i11 != 0) {
                    return ShortTVHomeFragment.this.z0();
                }
                ShortTVDiscoverFragment shortTVDiscoverFragment = new ShortTVDiscoverFragment();
                final ShortTVHomeFragment shortTVHomeFragment = ShortTVHomeFragment.this;
                shortTVHomeFragment.f55349i = shortTVDiscoverFragment;
                ShortTVDiscoverFragment shortTVDiscoverFragment2 = shortTVHomeFragment.f55349i;
                if (shortTVDiscoverFragment2 == null) {
                    return shortTVDiscoverFragment;
                }
                shortTVDiscoverFragment2.f2(new Function1<Boolean, Unit>() { // from class: com.transsion.postdetail.shorttv.ShortTVHomeFragment$initViewPager$1$createFragment$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z11) {
                        shortTVHomeFragment.f55350j = Integer.valueOf(R$color.text_01);
                        shortTVHomeFragment.f55351k = Integer.valueOf(com.transsion.postdetail.R$color.short_tv_top_title_gray_color);
                    }
                });
                return shortTVDiscoverFragment;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return ShortTVHomeFragment.this.f55343b.length;
            }
        };
        r mViewBinding = getMViewBinding();
        ViewPager2 viewPager2 = mViewBinding != null ? mViewBinding.f77915c : null;
        if (viewPager2 != null) {
            viewPager2.setAdapter(this.f55348h);
        }
        u0();
        new Handler().postDelayed(new Runnable() { // from class: com.transsion.postdetail.shorttv.m
            @Override // java.lang.Runnable
            public final void run() {
                ShortTVHomeFragment.B0(this.f55413a);
            }
        }, 10L);
    }

    private final void u0() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager3;
        CommonNavigator commonNavigator = new CommonNavigator(requireContext());
        commonNavigator.setFollowTouch(true);
        commonNavigator.setAdapter(new b());
        this.f55345d = commonNavigator;
        r mViewBinding = getMViewBinding();
        MagicIndicator magicIndicator = mViewBinding != null ? mViewBinding.f77914b : null;
        if (magicIndicator != null) {
            magicIndicator.setNavigator(this.f55345d);
        }
        r mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (viewPager3 = mViewBinding2.f77915c) != null) {
            viewPager3.registerOnPageChangeCallback(new c());
        }
        r mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (viewPager2 = mViewBinding3.f77915c) == null) {
            return;
        }
        viewPager2.setCurrentItem(this.f55347g, false);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public r getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        r rVarC = r.c(inflater);
        Intrinsics.f(rVarC, "inflate(inflater)");
        return rVarC;
    }

    public final boolean C0() {
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("shorts_tab_in_for_you", true);
        String value = configBeanB != null ? configBeanB.getValue() : null;
        if (value == null) {
            return false;
        }
        return Intrinsics.b(value, "true");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean, int] */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        MagicIndicator magicIndicator;
        Intrinsics.g(view, "view");
        r mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (magicIndicator = mViewBinding.f77914b) == null) ? null : magicIndicator.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = com.blankj.utilcode.util.d.c();
        ?? C0 = C0();
        this.f55346f = C0;
        int i11 = C0;
        if (bundle != 0) {
            i11 = bundle.getInt("CURRENT_TAB", C0);
        }
        this.f55347g = i11;
        this.f55352l = bundle != 0 ? bundle.getBoolean("IS_BANNER", true) : true;
        initViewPager();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("CURRENT_TAB", this.f55347g);
        outState.putBoolean("IS_BANNER", this.f55352l);
    }

    public final void v0(boolean z11) {
        if (isVisible()) {
            j00.d dVar = new j00.d(z11);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = j00.d.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, dVar, 0L);
        }
    }

    public final void w0(boolean z11) {
        this.f55352l = z11;
        y0(this.f55347g, z11);
    }

    public final void x0(boolean z11) {
        ImmersionBar immersionBarWith = ImmersionBar.with(this);
        boolean z12 = false;
        if (!z11 && !com.transsion.baselib.utils.o.f51321a.a()) {
            z12 = true;
        }
        immersionBarWith.statusBarDarkFont(z12);
        immersionBarWith.init();
    }

    public final void y0(int i11, boolean z11) {
        LinearLayout linearLayout;
        Context contextRequireContext = requireContext();
        Integer num = this.f55350j;
        int color = z2.a.getColor(contextRequireContext, num != null ? num.intValue() : R$color.text_01);
        Context contextRequireContext2 = requireContext();
        Integer num2 = this.f55351k;
        int color2 = z2.a.getColor(contextRequireContext2, num2 != null ? num2.intValue() : com.transsion.postdetail.R$color.short_tv_top_title_gray_color);
        int color3 = z2.a.getColor(requireContext(), R$color.white);
        int color4 = z2.a.getColor(requireContext(), R$color.white_60);
        CommonNavigator commonNavigator = this.f55345d;
        if (commonNavigator != null) {
            LinearLayout linearLayout2 = (LinearLayout) commonNavigator.findViewById(R$id.title_container);
            View childAt = linearLayout2.getChildAt(0);
            View childAt2 = linearLayout2.getChildAt(1);
            if (i11 != 0) {
                if (i11 == 1) {
                    if (childAt instanceof ShortTVTabTitleView) {
                        ShortTVTabTitleView shortTVTabTitleView = (ShortTVTabTitleView) childAt;
                        shortTVTabTitleView.setNormalColor(color4);
                        shortTVTabTitleView.setTextColor(color4);
                    }
                    if (childAt2 instanceof ShortTVTabTitleView) {
                        ShortTVTabTitleView shortTVTabTitleView2 = (ShortTVTabTitleView) childAt2;
                        shortTVTabTitleView2.setSelectedColor(color3);
                        shortTVTabTitleView2.setTextColor(color3);
                    }
                }
            } else if (z11) {
                if (childAt instanceof ShortTVTabTitleView) {
                    ShortTVTabTitleView shortTVTabTitleView3 = (ShortTVTabTitleView) childAt;
                    shortTVTabTitleView3.setSelectedColor(color3);
                    shortTVTabTitleView3.setTextColor(color3);
                }
                if (childAt2 instanceof ShortTVTabTitleView) {
                    ShortTVTabTitleView shortTVTabTitleView4 = (ShortTVTabTitleView) childAt2;
                    shortTVTabTitleView4.setNormalColor(color4);
                    shortTVTabTitleView4.setTextColor(color4);
                }
            } else {
                if (childAt instanceof ShortTVTabTitleView) {
                    ShortTVTabTitleView shortTVTabTitleView5 = (ShortTVTabTitleView) childAt;
                    shortTVTabTitleView5.setSelectedColor(color);
                    shortTVTabTitleView5.setTextColor(color);
                }
                if (childAt2 instanceof ShortTVTabTitleView) {
                    ShortTVTabTitleView shortTVTabTitleView6 = (ShortTVTabTitleView) childAt2;
                    shortTVTabTitleView6.setNormalColor(color2);
                    shortTVTabTitleView6.setTextColor(color2);
                }
            }
            for (View view : kotlin.collections.g.o(childAt, childAt2)) {
                ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                view.setLayoutParams(layoutParams2);
            }
        }
        CommonNavigator commonNavigator2 = this.f55345d;
        if (commonNavigator2 == null || (linearLayout = (LinearLayout) commonNavigator2.findViewById(R$id.indicator_container)) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            int childCount = linearLayout.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt3 = linearLayout.getChildAt(i12);
                GradientLinePagerIndicator gradientLinePagerIndicator = childAt3 instanceof GradientLinePagerIndicator ? (GradientLinePagerIndicator) childAt3 : null;
                if (z11 || this.f55347g != 0) {
                    if (gradientLinePagerIndicator != null) {
                        gradientLinePagerIndicator.setColors(color3, color3, color3);
                    }
                } else if (gradientLinePagerIndicator != null) {
                    gradientLinePagerIndicator.setColors(z2.a.getColor(requireContext(), R$color.brand_gradient_start), z2.a.getColor(requireContext(), R$color.brand_gradient_center), z2.a.getColor(requireContext(), R$color.brand_gradient_end));
                }
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final Fragment z0() {
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_for_you_mode", true);
        String value = configBeanB != null ? configBeanB.getValue() : null;
        if (value != null && value.length() != 0 && !Intrinsics.b(value, "1")) {
            return VideoFragment.A.a(null, null, null, true, (64 & 16) != 0, (64 & 32) != 0 ? "" : null, (64 & 64) != 0 ? false : true, (64 & 128) != 0 ? "" : null, (64 & 256) != 0 ? null : null, (64 & 512) != 0 ? false : false);
        }
        ShortTvVideoFragment.a aVar = ShortTvVideoFragment.f55806v;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        return aVar.a(contextRequireContext, null, null, null, true, (64 & 32) != 0, (64 & 64) != 0 ? "" : null, (64 & 128) != 0 ? false : true);
    }
}
