package com.transsion.room.fragment;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.room.view.RoomHomeTabTitleView;
import com.transsion.room.viewmodel.RoomDetailViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import n6.a;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

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
public abstract class RoomBaseFragment<T extends n6.a> extends LazyFragment<T> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ORCommonNavigator f57131p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RoomBaseFragment<T>.a f57132q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FragmentStateAdapter f57133r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f57134s;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f57130o = FragmentViewModelLazyKt.a(this, Reflection.b(RoomDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.room.fragment.RoomBaseFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<v0.c>() { // from class: com.transsion.room.fragment.RoomBaseFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f57135t = LazyKt__LazyJVMKt.b(new Function0<IPostDetailApi>() { // from class: com.transsion.room.fragment.RoomBaseFragment$mPostDetailApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IPostDetailApi invoke() {
            return (IPostDetailApi) com.alibaba.android.arouter.launcher.a.d().h(IPostDetailApi.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a extends ks.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewPager2 f57136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f57137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RoomBaseFragment<T> f57138d;

        public a(RoomBaseFragment roomBaseFragment, ViewPager2 viewPager2, List<String> tabList) {
            Intrinsics.g(tabList, "tabList");
            this.f57138d = roomBaseFragment;
            this.f57136b = viewPager2;
            this.f57137c = tabList;
        }

        public static final void k(a this$0, int i11, View view) {
            Intrinsics.g(this$0, "this$0");
            ViewPager2 viewPager2 = this$0.f57136b;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(i11, true);
            }
        }

        @Override // h20.a
        public int a() {
            return this.f57137c.size();
        }

        @Override // h20.a
        public h20.c b(Context context) {
            Intrinsics.g(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(2);
            linePagerIndicator.setLineHeight(com.blankj.utilcode.util.i.e(2.0f));
            linePagerIndicator.setLineWidth(com.blankj.utilcode.util.i.e(57.0f));
            linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            linePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            linePagerIndicator.setColors(-1, -1, -1);
            return linePagerIndicator;
        }

        @Override // h20.a
        public h20.d c(Context context, final int i11) {
            Intrinsics.g(context, "context");
            RoomHomeTabTitleView roomHomeTabTitleView = new RoomHomeTabTitleView(context);
            roomHomeTabTitleView.setText(this.f57137c.get(i11));
            roomHomeTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomBaseFragment.a.k(this.f57241a, i11, view);
                }
            });
            return roomHomeTabTitleView;
        }

        @Override // ks.a
        public LinearLayout.LayoutParams h(Context context, int i11) {
            Intrinsics.g(context, "context");
            return j(i11, this.f57137c);
        }

        public final LinearLayout.LayoutParams j(int i11, List<String> list) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.setMarginStart(gs.a.a(12));
            layoutParams.setMarginEnd(gs.a.a(12));
            return layoutParams;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomBaseFragment<T> f57139a;

        public b(RoomBaseFragment<T> roomBaseFragment) {
            this.f57139a = roomBaseFragment;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
            MagicIndicator magicIndicatorX0 = this.f57139a.X0();
            if (magicIndicatorX0 != null) {
                magicIndicatorX0.onPageScrollStateChanged(i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
            MagicIndicator magicIndicatorX0 = this.f57139a.X0();
            if (magicIndicatorX0 != null) {
                magicIndicatorX0.onPageScrolled(i11, f11, i12);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            MagicIndicator magicIndicatorX0 = this.f57139a.X0();
            if (magicIndicatorX0 != null) {
                magicIndicatorX0.onPageSelected(i11);
            }
            this.f57139a.Y0(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends FragmentStateAdapter {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ RoomBaseFragment<T> f57140i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RoomBaseFragment<T> roomBaseFragment) {
            super(roomBaseFragment);
            this.f57140i = roomBaseFragment;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            return this.f57140i.S0(i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f57140i.Z0().size();
        }
    }

    private final void R0() {
        ViewPager2 viewPager2A1 = a1();
        if (viewPager2A1 != null) {
            viewPager2A1.registerOnPageChangeCallback(new b(this));
        }
        ViewPager2 viewPager2A2 = a1();
        if (viewPager2A2 != null) {
            viewPager2A2.setCurrentItem(this.f57134s, false);
        }
    }

    private final void initViewPager() {
        this.f57133r = new c(this);
        ViewPager2 viewPager2A1 = a1();
        if (viewPager2A1 != null) {
            viewPager2A1.setAdapter(this.f57133r);
        }
        R0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    public abstract Fragment S0(int i11);

    public final RoomDetailViewModel T0() {
        return (RoomDetailViewModel) this.f57130o.getValue();
    }

    public final IPostDetailApi U0() {
        return (IPostDetailApi) this.f57135t.getValue();
    }

    public final int V0() {
        return this.f57134s;
    }

    public final void W0() {
        ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(requireContext());
        oRCommonNavigator.setFollowTouch(true);
        RoomBaseFragment<T>.a aVar = new a(this, a1(), Z0());
        this.f57132q = aVar;
        oRCommonNavigator.setAdapter(aVar);
        this.f57131p = oRCommonNavigator;
        MagicIndicator magicIndicatorX0 = X0();
        if (magicIndicatorX0 == null) {
            return;
        }
        magicIndicatorX0.setNavigator(this.f57131p);
    }

    public abstract MagicIndicator X0();

    public final void Y0(int i11) {
        this.f57134s = i11;
    }

    public abstract List<String> Z0();

    public abstract ViewPager2 a1();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        initViewPager();
        W0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }
}
