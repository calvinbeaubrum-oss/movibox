package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.dialog.TransferGuideDialog;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import com.transsnet.downloader.widget.TransferSelectSeriesListView;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;

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
public class TransferMainFragment extends DownloadTabBaseFragment<h00.m0> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f60864l = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransferMainFragment a() {
            TransferMainFragment transferMainFragment = new TransferMainFragment();
            transferMainFragment.setArguments(androidx.core.os.c.a());
            return transferMainFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60865a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60865a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60865a;
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
            this.f60865a.invoke(obj);
        }
    }

    public static final void B0() {
        TransferGuideDialog.a aVar = TransferGuideDialog.f60564g;
        if (aVar.a()) {
            return;
        }
        aVar.b().j0(com.blankj.utilcode.util.a.b(), "TransferGuideDialog");
        aVar.c();
    }

    private final void initViewModel() {
        m0().w().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.downloader.fragment.TransferMainFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String status) {
                TransferBottomToolsView transferBottomToolsView;
                h00.m0 m0Var = (h00.m0) TransferMainFragment.this.getMViewBinding();
                if (m0Var != null && (transferBottomToolsView = m0Var.f65953d) != null) {
                    Intrinsics.f(status, "status");
                    transferBottomToolsView.changeStatus(status);
                }
                if (Intrinsics.b(status, TransferBottomToolsView.STATUS_DEFAULT)) {
                    TransferMainFragment.this.m0().D().q(0);
                }
            }
        }));
        m0().F().j(this, new b(new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.fragment.TransferMainFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer tabIndex) {
                ViewPager2 viewPager2Y0;
                RecyclerView.Adapter adapter;
                ViewPager2 viewPager2Y1 = TransferMainFragment.this.y0();
                int itemCount = (viewPager2Y1 == null || (adapter = viewPager2Y1.getAdapter()) == null) ? 0 : adapter.getItemCount();
                Intrinsics.f(tabIndex, "tabIndex");
                if (itemCount <= tabIndex.intValue() || tabIndex.intValue() < 0 || (viewPager2Y0 = TransferMainFragment.this.y0()) == null) {
                    return;
                }
                viewPager2Y0.setCurrentItem(tabIndex.intValue());
            }
        }));
        m0().y().j(this, new b(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.TransferMainFragment.initViewModel.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean show) {
                h00.m0 m0Var = (h00.m0) TransferMainFragment.this.getMViewBinding();
                TransferSelectSeriesListView transferSelectSeriesListView = m0Var != null ? m0Var.f65954f : null;
                if (transferSelectSeriesListView == null) {
                    return;
                }
                Intrinsics.f(show, "show");
                transferSelectSeriesListView.setVisibility(show.booleanValue() ? 0 : 8);
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: A0 */
    public h00.m0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.m0 m0VarC = h00.m0.c(inflater);
        Intrinsics.f(m0VarC, "inflate(inflater)");
        return m0VarC;
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public Fragment h0(int i11) {
        String str;
        List<String> listK;
        TransferSelectListFragment.a aVar = TransferSelectListFragment.f60871t;
        DownloadTabBaseFragment<T>.a aVarK0 = k0();
        if (aVarK0 == null || (listK = aVarK0.k()) == null || (str = listK.get(i11)) == null) {
            str = "";
        }
        return aVar.a(i11, str);
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public List<String> i0() {
        return m0().H().f();
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment, com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        initViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        TransferBottomToolsView transferBottomToolsView;
        ConstraintLayout constraintLayoutB;
        TransferBottomToolsView transferBottomToolsView2;
        TransferBottomToolsView transferBottomToolsView3;
        Intrinsics.g(view, "view");
        super.initView(view, bundle);
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var != null && (transferBottomToolsView3 = m0Var.f65953d) != null) {
            transferBottomToolsView3.setPageStatus(true);
        }
        h00.m0 m0Var2 = (h00.m0) getMViewBinding();
        if (m0Var2 != null && (transferBottomToolsView2 = m0Var2.f65953d) != null) {
            transferBottomToolsView2.setParentFragment(this);
        }
        h00.m0 m0Var3 = (h00.m0) getMViewBinding();
        if (m0Var3 != null && (constraintLayoutB = m0Var3.getRoot()) != null) {
            constraintLayoutB.post(new Runnable() { // from class: com.transsnet.downloader.fragment.w1
                @Override // java.lang.Runnable
                public final void run() {
                    TransferMainFragment.B0();
                }
            });
        }
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof ut.a) {
            h00.m0 m0Var4 = (h00.m0) getMViewBinding();
            ViewGroup.LayoutParams layoutParams = (m0Var4 == null || (transferBottomToolsView = m0Var4.f65953d) == null) ? null : transferBottomToolsView.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = gs.a.a(((ut.a) activity).u() ? 80 : 56);
            h00.m0 m0Var5 = (h00.m0) getMViewBinding();
            TransferBottomToolsView transferBottomToolsView4 = m0Var5 != null ? m0Var5.f65953d : null;
            if (transferBottomToolsView4 == null) {
                return;
            }
            transferBottomToolsView4.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        TransferBottomToolsView transferBottomToolsView;
        super.onHiddenChanged(z11);
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var == null || (transferBottomToolsView = m0Var.f65953d) == null) {
            return;
        }
        transferBottomToolsView.onPageNotVisible();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        TransferBottomToolsView transferBottomToolsView;
        super.onStop();
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var == null || (transferBottomToolsView = m0Var.f65953d) == null) {
            return;
        }
        transferBottomToolsView.onPageNotVisible();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public MagicIndicator s0() {
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var != null) {
            return m0Var.f65951b;
        }
        return null;
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void t0(int i11) {
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void u0(int i11) {
        m0().G().q(Integer.valueOf(i11));
        androidx.lifecycle.c0<List<DownloadBean>> c0VarB = m0().B(i11);
        m0().D().q(Integer.valueOf(DownloadUtil.f61136a.n(c0VarB != null ? c0VarB.f() : null)));
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void v0(List<String> list) {
        m0().H().q(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public ViewPager2 y0() {
        h00.m0 m0Var = (h00.m0) getMViewBinding();
        if (m0Var != null) {
            return m0Var.f65956h;
        }
        return null;
    }
}
