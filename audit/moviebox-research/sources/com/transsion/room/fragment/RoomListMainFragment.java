package com.transsion.room.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.room.R$string;
import com.transsion.room.view.RoomListMainTabTitleView;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator;

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
public final class RoomListMainFragment extends BaseFragment<sw.n> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f57219g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentStateAdapter f57220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ORCommonNavigator f57221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f57222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f57223d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer[] f57224f = {Integer.valueOf(R$string.Your_rooms), Integer.valueOf(R$string.Room_list)};

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomListMainFragment a(boolean z11, int i11) {
            RoomListMainFragment roomListMainFragment = new RoomListMainFragment();
            roomListMainFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("is_select_room", Boolean.valueOf(z11)), TuplesKt.a("index", Integer.valueOf(i11))));
            return roomListMainFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ks.a {
        public b() {
        }

        public static final void j(RoomListMainFragment this$0, int i11, View view) {
            ViewPager2 viewPager2;
            Intrinsics.g(this$0, "this$0");
            sw.n mViewBinding = this$0.getMViewBinding();
            if (mViewBinding == null || (viewPager2 = mViewBinding.f76566g) == null) {
                return;
            }
            viewPager2.setCurrentItem(i11, true);
        }

        @Override // h20.a
        public int a() {
            return RoomListMainFragment.this.f57224f.length;
        }

        @Override // h20.a
        public h20.c b(Context context) {
            Intrinsics.g(context, "context");
            WrapPagerIndicator wrapPagerIndicator = new WrapPagerIndicator(context);
            int iA = com.blankj.utilcode.util.f0.a(3.0f);
            wrapPagerIndicator.setRoundRadius(iA * 2.0f);
            int i11 = -iA;
            wrapPagerIndicator.setVerticalPadding(i11);
            wrapPagerIndicator.setHorizontalPadding(i11);
            wrapPagerIndicator.setFillColor(z2.a.getColor(context, R$color.bg_01));
            return wrapPagerIndicator;
        }

        @Override // h20.a
        public h20.d c(Context context, final int i11) {
            Intrinsics.g(context, "context");
            RoomListMainTabTitleView roomListMainTabTitleView = new RoomListMainTabTitleView(context);
            final RoomListMainFragment roomListMainFragment = RoomListMainFragment.this;
            roomListMainTabTitleView.setTextById(roomListMainFragment.f57224f[i11].intValue());
            roomListMainTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomListMainFragment.b.j(roomListMainFragment, i11, view);
                }
            });
            return roomListMainTabTitleView;
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
            sw.n mViewBinding = RoomListMainFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f76565f) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i11, f11, i12);
            sw.n mViewBinding = RoomListMainFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f76565f) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i11, f11, i12);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            MagicIndicator magicIndicator;
            super.onPageSelected(i11);
            sw.n mViewBinding = RoomListMainFragment.this.getMViewBinding();
            if (mViewBinding != null && (magicIndicator = mViewBinding.f76565f) != null) {
                magicIndicator.onPageSelected(i11);
            }
            RoomListMainFragment.this.f57222c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends FragmentStateAdapter {
        public d() {
            super(RoomListMainFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            return i11 == 0 ? RoomMyListFragment.C.a(RoomListMainFragment.this.f57223d, null) : RoomFilterListFragment.f57175t.a(RoomListMainFragment.this.f57223d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RoomListMainFragment.this.f57224f.length;
        }
    }

    private final void initViewPager() {
        this.f57220a = new d();
        sw.n mViewBinding = getMViewBinding();
        ViewPager2 viewPager2 = mViewBinding != null ? mViewBinding.f76566g : null;
        if (viewPager2 != null) {
            viewPager2.setAdapter(this.f57220a);
        }
        k0();
    }

    private final void k0() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager3;
        ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(requireContext());
        oRCommonNavigator.setAdapter(new b());
        this.f57221b = oRCommonNavigator;
        sw.n mViewBinding = getMViewBinding();
        MagicIndicator magicIndicator = mViewBinding != null ? mViewBinding.f76565f : null;
        if (magicIndicator != null) {
            magicIndicator.setNavigator(this.f57221b);
        }
        sw.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (viewPager3 = mViewBinding2.f76566g) != null) {
            viewPager3.registerOnPageChangeCallback(new c());
        }
        sw.n mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (viewPager2 = mViewBinding3.f76566g) == null) {
            return;
        }
        viewPager2.setCurrentItem(this.f57222c, false);
    }

    public static final void m0(RoomListMainFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        AppCompatImageView appCompatImageView;
        ImageView imageView;
        Intrinsics.g(view, "view");
        sw.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (imageView = mViewBinding.f76564d) != null) {
            so.c.e(imageView);
        }
        sw.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView = mViewBinding2.f76563c) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RoomListMainFragment.m0(this.f57264a, view2);
                }
            });
        }
        initViewPager();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public sw.n getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        sw.n nVarC = sw.n.c(inflater);
        Intrinsics.f(nVarC, "inflate(inflater)");
        return nVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f57222c = arguments != null ? arguments.getInt("index") : 0;
        Bundle arguments2 = getArguments();
        this.f57223d = arguments2 != null ? arguments2.getBoolean("is_select_room") : false;
        ImmersionBar.with(this).statusBarDarkFont(!com.transsion.baselib.utils.o.f51321a.a()).init();
    }
}
