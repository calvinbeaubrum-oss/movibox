package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel;
import com.transsnet.downloader.widget.FileManagerTabTitleView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
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
public abstract class DownloadTabBaseFragment<T extends n6.a> extends BaseFragment<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f60780a = "DownloadTab_" + getClass().getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f60781b = FragmentViewModelLazyKt.a(this, Reflection.b(HistoricalPlayRecordViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.DownloadTabBaseFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.x0 invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadTabBaseFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.v0.c invoke() {
            androidx.lifecycle.v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f60782c = FragmentViewModelLazyKt.a(this, Reflection.b(DownloadViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.DownloadTabBaseFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.x0 invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadTabBaseFragment$special$$inlined$activityViewModels$default$4
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.v0.c invoke() {
            androidx.lifecycle.v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f60783d = kotlin.collections.g.q(com.blankj.utilcode.util.c.a(), Utils.a().getString(R$string.downloading_Local_files), Utils.a().getString(R$string.download_transfer_tab_received));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f60784f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FragmentStateAdapter f60785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ORCommonNavigator f60786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DownloadTabBaseFragment<T>.a f60787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f60788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FileManagerTabTitleView f60789k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a extends ks.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewPager2 f60790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f60791c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f60792d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ DownloadTabBaseFragment<T> f60793e;

        public a(DownloadTabBaseFragment downloadTabBaseFragment, ViewPager2 viewPager2, List<String> defList) {
            Intrinsics.g(defList, "defList");
            this.f60793e = downloadTabBaseFragment;
            this.f60790b = viewPager2;
            this.f60791c = defList;
            ArrayList arrayList = new ArrayList();
            this.f60792d = arrayList;
            arrayList.addAll(defList);
        }

        private final LinearLayout.LayoutParams j(int i11, List<String> list) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int iA = gs.a.a(4);
            int i12 = 0;
            if (i11 != 0) {
                int i13 = i11 == list.size() + (-1) ? iA * 2 : 0;
                layoutParams.setMarginStart(i12 + iA);
                layoutParams.setMarginEnd(iA + i13);
                return layoutParams;
            }
            i12 = iA * 2;
            layoutParams.setMarginStart(i12 + iA);
            layoutParams.setMarginEnd(iA + i13);
            return layoutParams;
        }

        public static final void l(int i11, DownloadTabBaseFragment this$0, a this$1, View view) {
            FileManagerTabTitleView fileManagerTabTitleViewO0;
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(this$1, "this$1");
            if (i11 == 2 && (fileManagerTabTitleViewO0 = this$0.o0()) != null) {
                fileManagerTabTitleViewO0.setDotVisibility(false);
            }
            ViewPager2 viewPager2 = this$1.f60790b;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(i11, true);
            }
        }

        @Override // h20.a
        public int a() {
            return this.f60792d.size();
        }

        @Override // h20.a
        public h20.c b(Context context) {
            Intrinsics.g(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setColors(0, 0, 0);
            return linePagerIndicator;
        }

        @Override // h20.a
        public h20.d c(Context context, final int i11) {
            Intrinsics.g(context, "context");
            FileManagerTabTitleView fileManagerTabTitleView = new FileManagerTabTitleView(context);
            final DownloadTabBaseFragment<T> downloadTabBaseFragment = this.f60793e;
            if ((downloadTabBaseFragment instanceof FileManagerFragment) && i11 == 2) {
                downloadTabBaseFragment.w0(fileManagerTabTitleView);
            }
            fileManagerTabTitleView.setTitle(this.f60792d.get(i11));
            fileManagerTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.h1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadTabBaseFragment.a.l(i11, downloadTabBaseFragment, this, view);
                }
            });
            return fileManagerTabTitleView;
        }

        @Override // ks.a
        public LinearLayout.LayoutParams h(Context context, int i11) {
            Intrinsics.g(context, "context");
            return j(i11, this.f60792d);
        }

        public final List<String> k() {
            return this.f60792d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadTabBaseFragment<T> f60794a;

        public b(DownloadTabBaseFragment<T> downloadTabBaseFragment) {
            this.f60794a = downloadTabBaseFragment;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
            this.f60794a.t0(i11);
            MagicIndicator magicIndicatorS0 = this.f60794a.s0();
            if (magicIndicatorS0 != null) {
                magicIndicatorS0.onPageScrollStateChanged(i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
            MagicIndicator magicIndicatorS0 = this.f60794a.s0();
            if (magicIndicatorS0 != null) {
                magicIndicatorS0.onPageScrolled(i11, f11, i12);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            FileManagerTabTitleView fileManagerTabTitleViewO0;
            super.onPageSelected(i11);
            MagicIndicator magicIndicatorS0 = this.f60794a.s0();
            if (magicIndicatorS0 != null) {
                magicIndicatorS0.onPageSelected(i11);
            }
            this.f60794a.x0(i11);
            this.f60794a.u0(i11);
            if (i11 != 2 || (fileManagerTabTitleViewO0 = this.f60794a.o0()) == null) {
                return;
            }
            fileManagerTabTitleViewO0.setDotVisibility(false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends FragmentStateAdapter {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ DownloadTabBaseFragment<T> f60795i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ List<String> f60796j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DownloadTabBaseFragment<T> downloadTabBaseFragment, List<String> list) {
            super(downloadTabBaseFragment);
            this.f60795i = downloadTabBaseFragment;
            this.f60796j = list;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            return this.f60795i.h0(i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f60796j.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60797a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60797a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60797a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f60797a.invoke(obj);
        }
    }

    private final void g0() {
        ViewPager2 viewPager2Y0 = y0();
        if (viewPager2Y0 != null) {
            viewPager2Y0.registerOnPageChangeCallback(new b(this));
        }
        ViewPager2 viewPager2Y1 = y0();
        if (viewPager2Y1 != null) {
            viewPager2Y1.setCurrentItem(this.f60788j, false);
        }
    }

    private final void initViewModel() {
        if (this instanceof FileManagerFragment) {
            m0().z().j(this, new d(new Function1<Boolean, Unit>(this) { // from class: com.transsnet.downloader.fragment.DownloadTabBaseFragment.initViewModel.1
                final /* synthetic */ DownloadTabBaseFragment<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean isFinish) {
                    FileManagerTabTitleView fileManagerTabTitleViewO0;
                    Intrinsics.f(isFinish, "isFinish");
                    if (!isFinish.booleanValue() || (fileManagerTabTitleViewO0 = this.this$0.o0()) == null) {
                        return;
                    }
                    fileManagerTabTitleViewO0.setDotVisibility(true);
                }
            }));
        }
    }

    private final void r0(List<String> list) {
        this.f60785g = new c(this, list);
        ViewPager2 viewPager2Y0 = y0();
        if (viewPager2Y0 != null) {
            viewPager2Y0.setAdapter(this.f60785g);
        }
        g0();
    }

    public abstract Fragment h0(int i11);

    public abstract List<String> i0();

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        initViewModel();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        List<String> listI0;
        Intrinsics.g(view, "view");
        List<String> listI1 = i0();
        if (listI1 == null || !(!listI1.isEmpty())) {
            v0(this.f60783d);
            listI0 = this.f60783d;
        } else {
            listI0 = i0();
            Intrinsics.d(listI0);
        }
        r0(listI0);
        q0(listI0);
    }

    public final ORCommonNavigator j0() {
        return this.f60786h;
    }

    public final DownloadTabBaseFragment<T>.a k0() {
        return this.f60787i;
    }

    public final List<String> l0() {
        return this.f60783d;
    }

    public final DownloadViewModel m0() {
        return (DownloadViewModel) this.f60782c.getValue();
    }

    public final HistoricalPlayRecordViewModel n0() {
        return (HistoricalPlayRecordViewModel) this.f60781b.getValue();
    }

    public final FileManagerTabTitleView o0() {
        return this.f60789k;
    }

    public final String p0() {
        return this.f60780a;
    }

    public final void q0(List<String> list) {
        ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(requireContext());
        oRCommonNavigator.setFollowTouch(true);
        uo.b.a.f(uo.b.f78622a, this.f60780a, "init tabList：" + list, false, 4, null);
        DownloadTabBaseFragment<T>.a aVar = new a(this, y0(), list);
        this.f60787i = aVar;
        oRCommonNavigator.setAdapter(aVar);
        this.f60786h = oRCommonNavigator;
        MagicIndicator magicIndicatorS0 = s0();
        if (magicIndicatorS0 == null) {
            return;
        }
        magicIndicatorS0.setNavigator(this.f60786h);
    }

    public abstract MagicIndicator s0();

    public abstract void t0(int i11);

    public abstract void u0(int i11);

    public abstract void v0(List<String> list);

    public final void w0(FileManagerTabTitleView fileManagerTabTitleView) {
        this.f60789k = fileManagerTabTitleView;
    }

    public final void x0(int i11) {
        this.f60788j = i11;
    }

    public abstract ViewPager2 y0();
}
