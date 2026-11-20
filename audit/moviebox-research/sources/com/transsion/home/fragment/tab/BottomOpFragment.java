package com.transsion.home.fragment.tab;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.applovin.sdk.AppLovinEventTypes;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.commercializationapi.IPsLinkApi;
import com.transsion.home.R$id;
import com.transsion.home.adapter.MusicViewPagerAdapter;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.web.api.WebConstants;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
@Metadata
public final class BottomOpFragment extends BaseFragment<lt.g> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f52473c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f52474d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f52475a = HomeTabId.MusicOperate.getValue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f52476b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BottomOpFragment a(int i11, String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i11);
            bundle.putString(WebConstants.TAB_CODE, str);
            BottomOpFragment bottomOpFragment = new BottomOpFragment();
            bottomOpFragment.setArguments(bundle);
            return bottomOpFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        public static final void b(BottomOpFragment this$0, int i11) {
            MagicIndicator magicIndicator;
            Intrinsics.g(this$0, "this$0");
            lt.g mViewBinding = this$0.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f70437i) == null) {
                return;
            }
            magicIndicator.onPageSelected(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i11);
            lt.g mViewBinding = BottomOpFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f70437i) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i11, f11, i12);
            lt.g mViewBinding = BottomOpFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f70437i) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i11, f11, i12);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int i11) {
            View view;
            MagicIndicator magicIndicator;
            super.onPageSelected(i11);
            lt.g mViewBinding = BottomOpFragment.this.getMViewBinding();
            if (mViewBinding != null && (magicIndicator = mViewBinding.f70437i) != null) {
                final BottomOpFragment bottomOpFragment = BottomOpFragment.this;
                magicIndicator.post(new Runnable() { // from class: com.transsion.home.fragment.tab.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        BottomOpFragment.b.b(bottomOpFragment, i11);
                    }
                });
            }
            if (i11 == 0) {
                lt.g mViewBinding2 = BottomOpFragment.this.getMViewBinding();
                view = mViewBinding2 != null ? mViewBinding2.f70439k : null;
                if (view == null) {
                    return;
                }
                view.setVisibility(8);
                return;
            }
            lt.g mViewBinding3 = BottomOpFragment.this.getMViewBinding();
            view = mViewBinding3 != null ? mViewBinding3.f70439k : null;
            if (view == null) {
                return;
            }
            view.setVisibility(0);
        }
    }

    private final void k0() {
        FrameLayout frameLayout;
        lt.g mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout = mViewBinding.f70431b) != null) {
            so.c.h(frameLayout);
        }
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(new com.transsion.home.adapter.b(getMViewBinding()));
        lt.g mViewBinding2 = getMViewBinding();
        MagicIndicator magicIndicator = mViewBinding2 != null ? mViewBinding2.f70437i : null;
        if (magicIndicator == null) {
            return;
        }
        magicIndicator.setNavigator(commonNavigator);
    }

    public static final void m0(BottomOpFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        es.b bVar = (es.b) es.a.f64348a.a(es.b.class);
        if (bVar != null) {
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            bVar.c("", contextRequireContext);
        }
        this$0.q0();
    }

    public static final void n0(BottomOpFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.alibaba.android.arouter.launcher.a.d().b("/commercial/playstore").navigation();
        this$0.p0();
    }

    private final void o0() {
        ViewPager2 viewPager2;
        lt.g mViewBinding = getMViewBinding();
        MusicViewPagerAdapter musicViewPagerAdapter = new MusicViewPagerAdapter(mViewBinding != null ? mViewBinding.f70440l : null, this.f52475a, this.f52476b, this);
        lt.g mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null) {
            mViewBinding2.f70440l.setAdapter(musicViewPagerAdapter);
        }
        lt.g mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (viewPager2 = mViewBinding3.f70440l) == null) {
            return;
        }
        viewPager2.registerOnPageChangeCallback(new b());
    }

    public final int i0() {
        int iA = com.blankj.utilcode.util.f0.a(56.0f) + com.blankj.utilcode.util.d.c();
        return this.f52475a == HomeTabId.MusicOperate.getValue() ? iA + com.blankj.utilcode.util.f0.a(22.0f) : iA;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        lt.g mViewBinding;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        TnTextView tnTextView;
        ConstraintLayout constraintLayout;
        Intrinsics.g(view, "view");
        Bundle arguments = getArguments();
        this.f52475a = arguments != null ? arguments.getInt("tab_id") : this.f52475a;
        Bundle arguments2 = getArguments();
        ViewGroup.LayoutParams layoutParams = null;
        this.f52476b = arguments2 != null ? arguments2.getString(WebConstants.TAB_CODE) : null;
        if (this.f52475a == HomeTabId.MusicOperate.getValue()) {
            o0();
            k0();
        } else {
            l0();
        }
        lt.g mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (constraintLayout = mViewBinding2.f70435g) != null) {
            layoutParams = constraintLayout.getLayoutParams();
        }
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).topMargin = com.blankj.utilcode.util.d.c();
        lt.g mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (tnTextView = mViewBinding3.f70436h) != null) {
            tnTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.tab.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BottomOpFragment.m0(this.f52588a, view2);
                }
            });
        }
        lt.g mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView2 = mViewBinding4.f70433d) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.tab.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BottomOpFragment.n0(this.f52590a, view2);
                }
            });
        }
        IPsLinkApi iPsLinkApi = (IPsLinkApi) com.alibaba.android.arouter.launcher.a.d().h(IPsLinkApi.class);
        if ((iPsLinkApi != null && iPsLinkApi.T0() && !com.transsion.home.utils.a.f52667a.a()) || (mViewBinding = getMViewBinding()) == null || (appCompatImageView = mViewBinding.f70433d) == null) {
            return;
        }
        so.c.g(appCompatImageView);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public lt.g getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        lt.g gVarC = lt.g.c(inflater);
        Intrinsics.f(gVarC, "inflate(inflater)");
        return gVarC;
    }

    public final void l0() {
        View view;
        MagicIndicator magicIndicator;
        ViewPager2 viewPager2;
        lt.g mViewBinding = getMViewBinding();
        if (mViewBinding != null && (viewPager2 = mViewBinding.f70440l) != null) {
            so.c.h(viewPager2);
        }
        lt.g mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (magicIndicator = mViewBinding2.f70437i) != null) {
            so.c.h(magicIndicator);
        }
        lt.g mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (view = mViewBinding3.f70439k) != null) {
            so.c.h(view);
        }
        Bundle arguments = getArguments();
        getChildFragmentManager().beginTransaction().replace(R$id.bottom_op_container, SubTabFragment.f52541r.b(this.f52475a, arguments != null ? arguments.getString(WebConstants.TAB_CODE) : null)).commit();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        String str = this.f52476b;
        if (str == null) {
            str = "BottomOpFragment: " + this.f52475a;
        }
        return new com.transsion.baselib.report.h(str, false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public final void p0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "app_center");
        com.transsion.baselib.helper.a.f51183a.h(SubTabFragment.f52541r.a(this.f52475a), linkedHashMap);
    }

    public final void q0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", AppLovinEventTypes.USER_EXECUTED_SEARCH);
        linkedHashMap.put("hot_search_word", "");
        com.transsion.baselib.helper.a.f51183a.h(SubTabFragment.f52541r.a(this.f52475a), linkedHashMap);
    }
}
