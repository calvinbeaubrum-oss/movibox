package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.GradientTextView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.activity.DownloadPanelActivity;
import com.transsnet.downloader.api.DownloadPageType;
import com.transsnet.downloader.util.BatteryPermissionUtils;
import com.transsnet.downloader.viewmodel.LocalFileViewModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class DownloadMainFragment extends BaseFragment<h00.x> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f60643f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f60644a = "DownloadMain";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60645b = "DownloadPanel";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f60646c = FragmentViewModelLazyKt.a(this, Reflection.b(LocalFileViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.DownloadMainFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadMainFragment$special$$inlined$activityViewModels$default$2
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
    public final b1.b<String[]> f60647d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadMainFragment a(int i11) {
            DownloadMainFragment downloadMainFragment = new DownloadMainFragment();
            downloadMainFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_page_index", Integer.valueOf(i11))));
            return downloadMainFragment;
        }
    }

    public DownloadMainFragment() {
        b1.b<String[]> bVarRegisterForActivityResult = registerForActivityResult(new c1.h(), new b1.a() { // from class: com.transsnet.downloader.fragment.i
            @Override // b1.a
            public final void a(Object obj) {
                DownloadMainFragment.t0(this.f60923a, (Map) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.f60647d = bVarRegisterForActivityResult;
    }

    private final void l0() {
        ConstraintLayout constraintLayoutB;
        h00.x mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayoutB = mViewBinding.getRoot()) == null) {
            return;
        }
        constraintLayoutB.post(new Runnable() { // from class: com.transsnet.downloader.fragment.l
            @Override // java.lang.Runnable
            public final void run() {
                DownloadMainFragment.m0(this.f60933a);
            }
        });
    }

    public static final void m0(final DownloadMainFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        BatteryPermissionUtils.f61124a.c(activity, DownloadPageType.DOWNLOAD.getPageName(), new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadMainFragment$checkPermission$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.n0();
            }
        });
    }

    private final LocalFileViewModel p0() {
        return (LocalFileViewModel) this.f60646c.getValue();
    }

    public static final void r0(View view) {
        com.alibaba.android.arouter.launcher.a.d().b("/download/transfer").navigation();
    }

    public static final void s0(DownloadMainFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void t0(DownloadMainFragment this$0, Map result) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(result, "result");
        if (com.transsion.baselib.helper.c.f51185a.c(this$0.requireContext())) {
            this$0.o0();
        }
        Context context = this$0.getContext();
        if (context != null) {
            co.c.f15010a.c(context);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        h00.x mViewBinding;
        AppCompatImageView appCompatImageView;
        GradientTextView gradientTextView;
        ImageView imageView;
        Intrinsics.g(view, "view");
        h00.x mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (imageView = mViewBinding2.f66092i) != null) {
            so.c.e(imageView);
        }
        h00.x mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (gradientTextView = mViewBinding3.f66090g) != null) {
            gradientTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DownloadMainFragment.r0(view2);
                }
            });
        }
        if (!(getActivity() instanceof DownloadPanelActivity) || (mViewBinding = getMViewBinding()) == null || (appCompatImageView = mViewBinding.f66088d) == null) {
            return;
        }
        so.c.k(appCompatImageView);
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadMainFragment.s0(this.f60930a, view2);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        l0();
    }

    public final void n0() {
        if (com.transsnet.downloader.viewmodel.c.f61276a.a()) {
            Context context = getContext();
            if (context != null) {
                co.c.f15010a.c(context);
            }
            o0();
            return;
        }
        if (com.transsnet.downloader.util.k.f61163a.a()) {
            try {
                Result.Companion companion = Result.Companion;
                this.f60647d.a(com.transsion.baselib.helper.c.f51185a.a());
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }

    public final void o0() {
        uo.b.a.f(uo.b.f78622a, this.f60644a, "getOutsidePlayHistoricalList", false, 4, null);
        if (isAdded()) {
            LocalFileViewModel.k(p0(), false, 1, null);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ImmersionBar.with(this).statusBarDarkFont(!com.transsion.baselib.utils.o.f51321a.a()).init();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        fragmentTransactionBeginTransaction.replace(R$id.fl_container, FileManagerFragment.f60819t.a(0));
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public h00.x getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.x xVarC = h00.x.c(inflater);
        Intrinsics.f(xVarC, "inflate(inflater)");
        return xVarC;
    }
}
