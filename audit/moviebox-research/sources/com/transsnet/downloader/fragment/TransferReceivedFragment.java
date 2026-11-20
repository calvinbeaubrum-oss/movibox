package com.transsnet.downloader.fragment;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.view.StateView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.dialog.DownloadConfirmDialog;
import com.transsnet.downloader.dialog.DownloadMoreDialog;
import com.transsnet.downloader.viewmodel.TransferReceivedViewModel;
import java.util.List;
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
public final class TransferReceivedFragment extends DownloadedBaseFragment {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f60866v = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f60867u = FragmentViewModelLazyKt.a(this, Reflection.b(TransferReceivedViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.TransferReceivedFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.TransferReceivedFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransferReceivedFragment a() {
            return new TransferReceivedFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60868a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60868a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60868a;
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
            this.f60868a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(DownloadBean downloadBean) {
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), kotlinx.coroutines.w0.b(), null, new TransferReceivedFragment$deleteItem$1(downloadBean, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1() {
        TransferReceivedViewModel.i(C1(), false, 1, null);
    }

    public final TransferReceivedViewModel C1() {
        return (TransferReceivedViewModel) this.f60867u.getValue();
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public String getPageName() {
        return "file_manager_tab_received";
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment, com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        C1().j().j(this, new b(new Function1<List<DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.TransferReceivedFragment.initViewModel.1
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
                TransferReceivedFragment.this.g1(list);
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View l0(boolean z11) {
        if (o1() == null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            StateView stateView = new StateView(contextRequireContext);
            String string = Utils.a().getString(R$string.download_transfer_received_empty_tips);
            Intrinsics.f(string, "getApp().getString(R.str…sfer_received_empty_tips)");
            stateView.showData(4, 6, false, "", string);
            String string2 = Utils.a().getString(R$string.download_empty_transfer_tips);
            Intrinsics.f(string2, "getApp().getString(R.str…load_empty_transfer_tips)");
            stateView.setReTryTxt(string2);
            stateView.retry(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.TransferReceivedFragment$getEmptyView$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.alibaba.android.arouter.launcher.a.d().b("/download/transfer").navigation();
                }
            });
            w1(stateView);
        }
        View viewO1 = o1();
        Intrinsics.d(viewO1);
        return viewO1;
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment
    public void r1(final DownloadBean bean, View view, int i11) {
        Intrinsics.g(bean, "bean");
        Intrinsics.g(view, "view");
        DownloadMoreDialog downloadMoreDialogA = DownloadMoreDialog.f60517i.a(kotlin.collections.g.q(new Pair(Utils.a().getString(R$string.download_transfer_tips), "transfer_file_2_mb"), new Pair(Utils.a().getString(R$string.delete), RequestParameters.SUBRESOURCE_DELETE)));
        downloadMoreDialogA.s0(new Function3<Integer, String, String, Unit>() { // from class: com.transsnet.downloader.fragment.TransferReceivedFragment$moreClick$1$1
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
                    final TransferReceivedFragment transferReceivedFragment = this;
                    final DownloadBean downloadBean = bean;
                    downloadConfirmDialogA.r0(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.TransferReceivedFragment$moreClick$1$1$1$1
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
                                transferReceivedFragment.B1(downloadBean);
                            }
                        }
                    });
                    downloadConfirmDialogA.k0(transferReceivedFragment, "confirm_Dialog");
                }
            }
        });
        downloadMoreDialogA.k0(this, "DownloadMoreDialog");
    }
}
