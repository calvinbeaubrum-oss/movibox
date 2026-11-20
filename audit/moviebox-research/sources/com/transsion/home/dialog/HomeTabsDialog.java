package com.transsion.home.dialog;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$style;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.dialog.HomeTabsDialog;
import f9.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mt.c;

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
public final class HomeTabsDialog extends BaseDialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f52382f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f52383g = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f52384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super HomeTabItem, Unit> f52385d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void o0(HomeTabsDialog this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        this$0.dismissAllowingStateLoss();
        Object obj = adapter.D().get(i11);
        Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.home.bean.HomeTabItem");
        HomeTabItem homeTabItem = (HomeTabItem) obj;
        Function1<? super HomeTabItem, Unit> function1 = this$0.f52385d;
        if (function1 != null) {
            function1.invoke(homeTabItem);
        }
    }

    public final void n0(View view) {
        List<HomeTabItem> homeTabs;
        Bundle arguments = getArguments();
        AppTab appTab = arguments != null ? (AppTab) arguments.getParcelable("homeTab") : null;
        AppTab appTab2 = appTab instanceof AppTab ? appTab : null;
        if (appTab2 == null || (homeTabs = appTab2.getHomeTabs()) == null || !(!homeTabs.isEmpty())) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.rvTabs);
        ArrayList arrayList = new ArrayList();
        for (HomeTabItem homeTabItem : homeTabs) {
            if (homeTabItem != null) {
                arrayList.add(homeTabItem);
            }
        }
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        mt.a aVar = new mt.a(arrayList);
        aVar.B0(new d() { // from class: mt.b
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                HomeTabsDialog.o0(this.f71176a, baseQuickAdapter, view2, i11);
            }
        });
        recyclerView.setAdapter(aVar);
        recyclerView.addItemDecoration(new c(2, f0.a(16.0f), true));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            dismissAllowingStateLoss();
        }
        setStyle(0, R$style.DialogRight);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        return inflater.inflate(R$layout.home_tabs_dialog_fragment_layout, viewGroup, false);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersionBar immersionBarWith = ImmersionBar.with((DialogFragment) this);
        if (o.f51321a.a()) {
            immersionBarWith.statusBarAlpha(0.0f);
            immersionBarWith.statusBarDarkFont(false);
            View view = this.f52384c;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            int statusBarHeight = ImmersionBar.getStatusBarHeight(this);
            View view2 = this.f52384c;
            ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.height = statusBarHeight;
            }
            View view3 = this.f52384c;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            immersionBarWith.statusBarAlpha(1.0f);
            immersionBarWith.statusBarDarkFont(true);
        }
        immersionBarWith.init();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("homeTab", true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        int iB = (int) (((double) d0.b()) * 0.77d);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(iB, -1);
        }
        this.f52384c = view.findViewById(R$id.topView);
        n0(view);
    }
}
