package com.transsnet.downloader.fragment;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.view.StateView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.api.DownloadPageType;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
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
public final class DownloadedListFragment extends DownloadedBaseFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f60807u = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadedListFragment a() {
            return new DownloadedListFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60808a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60808a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60808a;
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
            this.f60808a.invoke(obj);
        }
    }

    private final void B1() {
        Function1<f00.a, Unit> function1 = new Function1<f00.a, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadedListFragment$initDeleteObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f00.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f00.a it) {
                Intrinsics.g(it, "it");
                try {
                    this.this$0.A1();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = f00.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    public final void A1() {
        DownloadViewModel.n(W0(), false, 1, null);
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public String getPageName() {
        return DownloadPageType.DOWNLOAD.getPageName();
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment, com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        W0().o().j(this, new b(new Function1<List<? extends DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadedListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DownloadBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends DownloadBean> list) {
                DownloadedListFragment.this.g1(list);
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View l0(boolean z11) {
        if (o1() == null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            StateView stateView = new StateView(contextRequireContext);
            String string = Utils.a().getString(R$string.download_no_historical_tips);
            Intrinsics.f(string, "getApp().getString(R.str…nload_no_historical_tips)");
            stateView.showData(4, 6, false, "", string);
            String string2 = Utils.a().getString(R$string.download_empty_find_free_source);
            Intrinsics.f(string2, "getApp().getString(R.str…d_empty_find_free_source)");
            stateView.setReTryTxt(string2);
            stateView.retry(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadedListFragment$getEmptyView$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.alibaba.android.arouter.launcher.a.d().b("/home/movieFilter").withInt("tabId", 2).navigation();
                }
            });
            w1(stateView);
        }
        View viewO1 = o1();
        Intrinsics.d(viewO1);
        return viewO1;
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        String string = Utils.a().getString(R$string.download_no_historical_tips);
        Intrinsics.f(string, "getApp().getString(R.str…nload_no_historical_tips)");
        return string;
    }

    @Override // com.transsnet.downloader.fragment.DownloadedBaseFragment, com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        B1();
    }
}
