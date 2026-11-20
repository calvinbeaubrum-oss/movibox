package com.transsnet.downloader.fragment;

import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import com.transsnet.flow.event.sync.event.LocalVideoEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public abstract class DownloadListBaseFragment extends PageStatusFragment<h00.w> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.transsnet.downloader.adapter.g f60641l;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f60640k = "DownloadList_" + getClass().getSimpleName();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f60642m = FragmentViewModelLazyKt.a(this, Reflection.b(DownloadViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.DownloadListBaseFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadListBaseFragment$special$$inlined$activityViewModels$default$2
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
    public static final class a extends DiffUtil.e<DownloadBean> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(DownloadBean oldItem, DownloadBean newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return oldItem.getStatus() == newItem.getStatus() && oldItem.getProgress() == newItem.getProgress();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(DownloadBean oldItem, DownloadBean newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getResourceId(), newItem.getResourceId());
        }
    }

    public static final void a1(DownloadListBaseFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        this$0.e1((com.transsnet.downloader.adapter.g) adapter, view, i11);
    }

    public static final void b1(DownloadListBaseFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        this$0.d1((com.transsnet.downloader.adapter.g) adapter, view, i11);
    }

    public static final boolean c1(DownloadListBaseFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return false;
        }
        this$0.f1((com.transsnet.downloader.adapter.g) adapter, view, i11);
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public abstract void T0(com.transsnet.downloader.adapter.g gVar);

    public DownloadViewModel U0() {
        return null;
    }

    public final com.transsnet.downloader.adapter.g V0() {
        return this.f60641l;
    }

    public final DownloadViewModel W0() {
        return (DownloadViewModel) this.f60642m.getValue();
    }

    public final String X0() {
        return this.f60640k;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public h00.w getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.w wVarC = h00.w.c(inflater);
        Intrinsics.f(wVarC, "inflate(inflater)");
        return wVarC;
    }

    public final void Z0() {
        Function1<LocalVideoEvent, Unit> function1 = new Function1<LocalVideoEvent, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadListBaseFragment$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocalVideoEvent localVideoEvent) {
                invoke2(localVideoEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LocalVideoEvent value) {
                com.transsnet.downloader.adapter.g gVarV0;
                List<DownloadBean> listD;
                DownloadBean downloadBean;
                List<DownloadBean> listD2;
                Intrinsics.g(value, "value");
                try {
                    uo.b.a.f(uo.b.f78622a, "LocalVideo-d", "observeEvent resourceId:" + value.getResourceId() + ",readProgress: " + value.getReadProgress() + ", isSeries: " + value.isSeries(), false, 4, null);
                    com.transsnet.downloader.adapter.g gVarV1 = this.this$0.V0();
                    int i11 = -1;
                    if (gVarV1 != null && (listD2 = gVarV1.D()) != null) {
                        Iterator<DownloadBean> it = listD2.iterator();
                        int i12 = 0;
                        while (it.hasNext()) {
                            if (Intrinsics.b(it.next().getResourceId(), value.getResourceId())) {
                                i11 = i12;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (value.isSeries()) {
                        DownloadListBaseFragment downloadListBaseFragment = this.this$0;
                        if ((downloadListBaseFragment instanceof DownloadedListFragment) && i11 < 0) {
                            DownloadViewModel.n(downloadListBaseFragment.W0(), false, 1, null);
                            return;
                        }
                    }
                    if (i11 >= 0) {
                        com.transsnet.downloader.adapter.g gVarV2 = this.this$0.V0();
                        if (i11 < (gVarV2 != null ? gVarV2.getItemCount() : 0) && (gVarV0 = this.this$0.V0()) != null && (listD = gVarV0.D()) != null && (downloadBean = listD.get(i11)) != null) {
                            uo.b.a.f(uo.b.f78622a, "LocalVideo-d", "observeEvent index:" + i11 + ", " + downloadBean.getTotalTitleName(), false, 4, null);
                            if (value.getReadProgress() >= 0) {
                                downloadBean.setReadProgress(value.getReadProgress());
                            }
                            if (value.getDuration() >= 0) {
                                downloadBean.setDuration(Long.valueOf(value.getDuration()));
                            }
                            if (value.getRefreshItemAll()) {
                                com.transsnet.downloader.adapter.g gVarV3 = this.this$0.V0();
                                if (gVarV3 != null) {
                                    gVarV3.notifyItemChanged(i11);
                                    return;
                                }
                                return;
                            }
                            com.transsnet.downloader.adapter.g gVarV4 = this.this$0.V0();
                            if (gVarV4 != null) {
                                gVarV4.notifyItemChanged(i11, downloadBean);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LocalVideoEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, kotlinx.coroutines.w0.c().q(), false, function1);
        Function1<DownloadRefreshEvent, Unit> function2 = new Function1<DownloadRefreshEvent, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadListBaseFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadRefreshEvent downloadRefreshEvent) {
                invoke2(downloadRefreshEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadRefreshEvent value) {
                int i11;
                com.transsnet.downloader.adapter.g gVarV0;
                List<DownloadBean> listD;
                com.transsnet.downloader.adapter.g gVarV1;
                List<DownloadBean> listD2;
                Intrinsics.g(value, "value");
                String resourceId = value.getResourceId();
                if (resourceId == null || resourceId.length() == 0) {
                    return;
                }
                String subjectId = value.getSubjectId();
                int i12 = 0;
                int i13 = -1;
                if (subjectId != null && subjectId.length() != 0 && (gVarV1 = this.this$0.V0()) != null && (listD2 = gVarV1.D()) != null) {
                    Iterator<DownloadBean> it = listD2.iterator();
                    i11 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i11 = -1;
                            break;
                        } else if (Intrinsics.b(it.next().getSubjectId(), value.getSubjectId())) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    i11 = -1;
                    break;
                }
                if (i11 >= 0) {
                    com.transsnet.downloader.adapter.g gVarV2 = this.this$0.V0();
                    if (gVarV2 != null) {
                        gVarV2.notifyItemChanged(i11);
                        return;
                    }
                    return;
                }
                com.transsnet.downloader.adapter.g gVarV3 = this.this$0.V0();
                if (gVarV3 != null && (listD = gVarV3.D()) != null) {
                    Iterator<DownloadBean> it2 = listD.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics.b(it2.next().getResourceId(), value.getResourceId())) {
                            i13 = i12;
                            break;
                        }
                        i12++;
                    }
                }
                if (i13 < 0 || (gVarV0 = this.this$0.V0()) == null) {
                    return;
                }
                gVarV0.notifyItemChanged(i13);
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = DownloadRefreshEvent.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.observeEvent(this, name2, state, kotlinx.coroutines.w0.c().q(), false, function2);
    }

    public abstract void d1(com.transsnet.downloader.adapter.g gVar, View view, int i11);

    public abstract void e1(com.transsnet.downloader.adapter.g gVar, View view, int i11);

    public abstract void f1(com.transsnet.downloader.adapter.g gVar, View view, int i11);

    public void g1(List<? extends DownloadBean> list) {
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        com.transsnet.downloader.adapter.g gVar = this.f60641l;
        if (gVar != null) {
            gVar.w0(list);
        }
    }

    public abstract String getPageName();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        Z0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
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

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        com.transsnet.downloader.adapter.g gVar = new com.transsnet.downloader.adapter.g(U0());
        gVar.o0(new a());
        gVar.B0(new f9.d() { // from class: com.transsnet.downloader.fragment.f
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadListBaseFragment.a1(this.f60912a, baseQuickAdapter, view, i11);
            }
        });
        T0(gVar);
        gVar.z0(new f9.b() { // from class: com.transsnet.downloader.fragment.g
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadListBaseFragment.b1(this.f60915a, baseQuickAdapter, view, i11);
            }
        });
        gVar.D0(new f9.e() { // from class: com.transsnet.downloader.fragment.h
            @Override // f9.e
            public final boolean a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                return DownloadListBaseFragment.c1(this.f60918a, baseQuickAdapter, view, i11);
            }
        });
        this.f60641l = gVar;
        h00.w mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f66070f) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f60641l);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }
}
