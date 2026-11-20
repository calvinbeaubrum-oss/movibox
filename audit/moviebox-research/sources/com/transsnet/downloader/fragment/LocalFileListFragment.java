package com.transsnet.downloader.fragment;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.view.StateView;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.dialog.DownloadConfirmDialog;
import com.transsnet.downloader.dialog.DownloadMoreDialog;
import com.transsnet.downloader.viewmodel.LocalFileViewModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
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
public final class LocalFileListFragment extends DownloadedBaseFragment {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f60841y = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f60842u = FragmentViewModelLazyKt.a(this, Reflection.b(LocalFileViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.LocalFileListFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.LocalFileListFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f60843v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f60844w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b1.b<String[]> f60845x;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalFileListFragment a() {
            return new LocalFileListFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60846a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60846a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60846a;
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
            this.f60846a.invoke(obj);
        }
    }

    public LocalFileListFragment() {
        b1.b<String[]> bVarRegisterForActivityResult = registerForActivityResult(new c1.h(), new b1.a() { // from class: com.transsnet.downloader.fragment.q1
            @Override // b1.a
            public final void a(Object obj) {
                LocalFileListFragment.H1(this.f60952a, (Map) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…{\n            }\n        }");
        this.f60845x = bVarRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1() {
        LocalFileViewModel.k(F1(), false, 1, null);
    }

    public static final void H1(LocalFileListFragment this$0, Map result) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(result, "result");
        if (com.transsion.baselib.helper.c.f51185a.c(this$0.requireContext())) {
            this$0.G1();
        }
    }

    public final void E1(DownloadBean downloadBean) {
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), kotlinx.coroutines.w0.b(), null, new LocalFileListFragment$deleteItem$1(downloadBean, this, null), 2, null);
    }

    public final LocalFileViewModel F1() {
        return (LocalFileViewModel) this.f60842u.getValue();
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public String getPageName() {
        return "file_manager_tab_local_files";
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment, com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        F1().i().j(this, new b(new Function1<List<DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.LocalFileListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<DownloadBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<DownloadBean> list) {
                LocalFileListFragment.this.g1(list);
            }
        }));
        F1().e().j(this, new b(new Function1<DownloadBean, Unit>() { // from class: com.transsnet.downloader.fragment.LocalFileListFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                invoke2(downloadBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadBean downloadBean) {
                List<DownloadBean> listD;
                com.transsnet.downloader.adapter.g gVarV0;
                com.transsnet.downloader.adapter.g gVarV1 = LocalFileListFragment.this.V0();
                if (gVarV1 == null || (listD = gVarV1.D()) == null) {
                    return;
                }
                Iterator<DownloadBean> it = listD.iterator();
                int i11 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i11 = -1;
                        break;
                    } else if (Intrinsics.b(it.next().getResourceId(), downloadBean.getResourceId())) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 < 0 || (gVarV0 = LocalFileListFragment.this.V0()) == null) {
                    return;
                }
                gVarV0.notifyItemChanged(i11);
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View l0(boolean z11) {
        if (com.transsnet.downloader.viewmodel.c.f61276a.a()) {
            if (o1() == null) {
                w1(super.l0(false));
            }
            View viewO1 = o1();
            Intrinsics.d(viewO1);
            return viewO1;
        }
        if (this.f60844w == null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            StateView stateView = new StateView(contextRequireContext);
            stateView.updateNoContentResId(R$mipmap.ic_no_permission);
            String string = Utils.a().getString(R$string.download_file_permission_tips);
            Intrinsics.f(string, "getApp().getString(R.str…oad_file_permission_tips)");
            stateView.showData(4, 6, false, "", string);
            String string2 = Utils.a().getString(R$string.download_no_permission_btn);
            Intrinsics.f(string2, "getApp().getString(R.str…wnload_no_permission_btn)");
            stateView.setReTryTxt(string2);
            stateView.retry(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.LocalFileListFragment$getEmptyView$1$1
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
                    FragmentActivity activity = this.this$0.getActivity();
                    if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                        return;
                    }
                    com.transsnet.downloader.viewmodel.c cVar = com.transsnet.downloader.viewmodel.c.f61276a;
                    if (!cVar.s(activity)) {
                        this.this$0.f60845x.a(com.transsion.baselib.helper.c.f51185a.a());
                    } else {
                        this.this$0.f60843v = true;
                        cVar.C();
                    }
                }
            });
            this.f60844w = stateView;
        }
        View view = this.f60844w;
        Intrinsics.d(view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f60843v) {
            this.f60843v = false;
            G1();
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment
    public void r1(final DownloadBean bean, View view, int i11) {
        Intrinsics.g(bean, "bean");
        Intrinsics.g(view, "view");
        DownloadMoreDialog downloadMoreDialogA = DownloadMoreDialog.f60517i.a(kotlin.collections.g.q(new Pair(Utils.a().getString(R$string.download_transfer_tips), "transfer_file_2_mb")));
        downloadMoreDialogA.s0(new Function3<Integer, String, String, Unit>() { // from class: com.transsnet.downloader.fragment.LocalFileListFragment$moreClick$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
                invoke(num.intValue(), str, str2);
                return Unit.f68710a;
            }

            public final void invoke(int i12, String str, String str2) {
                Intrinsics.g(str, "<anonymous parameter 1>");
                if (Intrinsics.b(str2, "transfer_file_2_mb")) {
                    com.alibaba.android.arouter.launcher.a.d().b("/download/transfer").navigation();
                    return;
                }
                if (Intrinsics.b(str2, RequestParameters.SUBRESOURCE_DELETE)) {
                    DownloadConfirmDialog downloadConfirmDialogA = DownloadConfirmDialog.f60505j.a(Utils.a().getString(R$string.cancel), Utils.a().getString(R$string.delete), Utils.a().getString(R$string.download_delete_tips, bean.getTitleName()), null);
                    final LocalFileListFragment localFileListFragment = this;
                    final DownloadBean downloadBean = bean;
                    downloadConfirmDialogA.r0(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.LocalFileListFragment$moreClick$1$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(boolean z11) {
                            if (z11) {
                                localFileListFragment.E1(downloadBean);
                            }
                        }
                    });
                    downloadConfirmDialogA.k0(localFileListFragment, "confirm_Dialog");
                }
            }
        });
        downloadMoreDialogA.k0(this, "DownloadMoreDialog");
    }
}
