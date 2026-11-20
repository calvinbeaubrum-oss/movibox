package com.transsnet.downloader.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.activity.AllHistoricalPlayRecordActivity;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import com.transsnet.downloader.dialog.ClearHistoryDialog;
import com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class HistoricalPlayRecordFragment extends PageStatusFragment<h00.j0> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.transsnet.downloader.adapter.c0 f60829k = new com.transsnet.downloader.adapter.c0();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f60830l = LazyKt__LazyJVMKt.b(new Function0<HistoricalPlayRecordViewModel>() { // from class: com.transsnet.downloader.fragment.HistoricalPlayRecordFragment$mViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HistoricalPlayRecordViewModel invoke() {
            return new HistoricalPlayRecordViewModel();
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b1.b<Intent> f60831m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FrameLayout f60832n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.l {
        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter == null || childAdapterPosition != adapter.getItemCount() - 1) {
                return;
            }
            outRect.right = com.blankj.utilcode.util.f0.a(16.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60833a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60833a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60833a;
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
            this.f60833a.invoke(obj);
        }
    }

    public HistoricalPlayRecordFragment() {
        b1.b<Intent> bVarRegisterForActivityResult = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.downloader.fragment.k1
            @Override // b1.a
            public final void a(Object obj) {
                HistoricalPlayRecordFragment.h1(this.f60932a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.f60831m = bVarRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(int i11) {
        if (i11 >= this.f60829k.D().size()) {
            return;
        }
        this.f60829k.D().remove(i11);
        this.f60829k.notifyItemRemoved(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HistoricalPlayRecordViewModel Z0() {
        return (HistoricalPlayRecordViewModel) this.f60830l.getValue();
    }

    private final void b1() {
        Function1<f00.d, Unit> function1 = new Function1<f00.d, Unit>() { // from class: com.transsnet.downloader.fragment.HistoricalPlayRecordFragment$initVideoObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f00.d dVar) {
                invoke2(dVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f00.d value) {
                Intrinsics.g(value, "value");
                try {
                    this.this$0.B0();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = f00.d.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    public static final void c1(HistoricalPlayRecordFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.f60831m.a(new Intent(this$0.requireContext(), (Class<?>) AllHistoricalPlayRecordActivity.class));
    }

    public static final void d1(HistoricalPlayRecordFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.f1(adapter, view, i11);
    }

    public static final boolean e1(HistoricalPlayRecordFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.g1(adapter, view, i11);
        return true;
    }

    private final void f1(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i11) {
        HistoricalPlayRecordBean historical;
        HistoricalPlayRecordBean historical2;
        DownloadBean video;
        if (view.getId() == R$id.historyRoot) {
            Object obj = baseQuickAdapter.D().get(i11);
            HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity = obj instanceof HistoricalPlayRecordMultipleEntity ? (HistoricalPlayRecordMultipleEntity) obj : null;
            if (historicalPlayRecordMultipleEntity != null && (historical2 = historicalPlayRecordMultipleEntity.getHistorical()) != null && historical2.getType() == 2 && (video = historical2.getVideo()) != null && video.getFileType() == 2) {
                DownloadBean video2 = historical2.getVideo();
                if (!com.transsnet.downloader.viewmodel.c.f61276a.r(video2 != null ? video2.getPath() : null)) {
                    HistoricalPlayRecordBean historical3 = historicalPlayRecordMultipleEntity.getHistorical();
                    if (historical3 != null) {
                        historical3.setLocalFileDelete(Boolean.TRUE);
                    }
                    this.f60829k.notifyItemChanged(i11);
                    return;
                }
            }
            if (historicalPlayRecordMultipleEntity == null || (historical = historicalPlayRecordMultipleEntity.getHistorical()) == null || !Intrinsics.b(historical.isLocalFileDelete(), Boolean.TRUE)) {
                Z0().L(historicalPlayRecordMultipleEntity, requireActivity(), getPageName());
            } else {
                zp.b.f82110a.e(getString(R$string.download_no_local_file_tips));
            }
        }
    }

    private final String getPageName() {
        return "historical_play_record";
    }

    public static final void h1(HistoricalPlayRecordFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.B0();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        Z0().Q(0);
        HistoricalPlayRecordViewModel.I(Z0(), false, false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public h00.j0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.j0 j0VarC = h00.j0.c(inflater);
        Intrinsics.f(j0VarC, "inflate(inflater)");
        return j0VarC;
    }

    public final void g1(final BaseQuickAdapter<?, ?> baseQuickAdapter, View view, final int i11) {
        ClearHistoryDialog clearHistoryDialog = new ClearHistoryDialog();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        clearHistoryDialog.q0(childFragmentManager, "javaClass", "clear", new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.HistoricalPlayRecordFragment$onItemLongClick$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                HistoricalPlayRecordViewModel historicalPlayRecordViewModelZ0 = this.this$0.Z0();
                Object objO = baseQuickAdapter.O(i11);
                HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity = objO instanceof HistoricalPlayRecordMultipleEntity ? (HistoricalPlayRecordMultipleEntity) objO : null;
                final int i12 = i11;
                final BaseQuickAdapter<?, ?> baseQuickAdapter2 = baseQuickAdapter;
                final HistoricalPlayRecordFragment historicalPlayRecordFragment = this.this$0;
                historicalPlayRecordViewModelZ0.p(historicalPlayRecordMultipleEntity, new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.HistoricalPlayRecordFragment$onItemLongClick$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        if (i12 >= baseQuickAdapter2.D().size()) {
                            return;
                        }
                        HistoricalPlayRecordViewModel historicalPlayRecordViewModelZ1 = historicalPlayRecordFragment.Z0();
                        Object obj = baseQuickAdapter2.D().get(i12);
                        HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity2 = obj instanceof HistoricalPlayRecordMultipleEntity ? (HistoricalPlayRecordMultipleEntity) obj : null;
                        final HistoricalPlayRecordFragment historicalPlayRecordFragment2 = historicalPlayRecordFragment;
                        final int i13 = i12;
                        historicalPlayRecordViewModelZ1.p(historicalPlayRecordMultipleEntity2, new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.HistoricalPlayRecordFragment.onItemLongClick.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                historicalPlayRecordFragment2.Y0(i13);
                            }
                        });
                    }
                });
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        Z0().v().j(this, new b(new Function1<List<HistoricalPlayRecordMultipleEntity>, Unit>() { // from class: com.transsnet.downloader.fragment.HistoricalPlayRecordFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<HistoricalPlayRecordMultipleEntity> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<HistoricalPlayRecordMultipleEntity> list) {
                if (!list.isEmpty()) {
                    FrameLayout frameLayout = HistoricalPlayRecordFragment.this.f60832n;
                    ViewGroup.LayoutParams layoutParams = frameLayout != null ? frameLayout.getLayoutParams() : null;
                    if (layoutParams != null) {
                        layoutParams.height = -2;
                    }
                    FrameLayout frameLayout2 = HistoricalPlayRecordFragment.this.f60832n;
                    if (frameLayout2 != null) {
                        frameLayout2.setLayoutParams(layoutParams);
                    }
                    if (list.size() >= 10) {
                        HistoricalPlayRecordFragment.this.f60829k.w0(list.subList(0, 10));
                        return;
                    } else {
                        HistoricalPlayRecordFragment.this.f60829k.w0(list);
                        return;
                    }
                }
                FrameLayout frameLayout3 = HistoricalPlayRecordFragment.this.f60832n;
                ViewGroup.LayoutParams layoutParams2 = frameLayout3 != null ? frameLayout3.getLayoutParams() : null;
                if (layoutParams2 != null) {
                    layoutParams2.height = 0;
                }
                FrameLayout frameLayout4 = HistoricalPlayRecordFragment.this.f60832n;
                if (frameLayout4 != null) {
                    frameLayout4.setLayoutParams(layoutParams2);
                }
                FrameLayout frameLayout5 = HistoricalPlayRecordFragment.this.f60832n;
                if ((frameLayout5 != null ? frameLayout5.getParent() : null) == null) {
                    FrameLayout frameLayout6 = HistoricalPlayRecordFragment.this.f60832n;
                    ViewParent parent = frameLayout6 != null ? frameLayout6.getParent() : null;
                    Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    if (((ViewGroup) parent).getParent() != null) {
                        FrameLayout frameLayout7 = HistoricalPlayRecordFragment.this.f60832n;
                        ViewParent parent2 = frameLayout7 != null ? frameLayout7.getParent() : null;
                        Intrinsics.e(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                        ViewParent parent3 = ((ViewGroup) parent2).getParent();
                        Intrinsics.e(parent3, "null cannot be cast to non-null type android.view.ViewGroup");
                        ((ViewGroup) parent3).invalidate();
                    }
                }
                HistoricalPlayRecordFragment.this.f60829k.r0(PageStatusFragment.m0(HistoricalPlayRecordFragment.this, false, 1, null));
            }
        }));
        b1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        com.transsion.baseui.util.m mVar = com.transsion.baseui.util.m.f51477a;
        View[] viewArr = new View[1];
        h00.j0 mViewBinding = getMViewBinding();
        viewArr[0] = mViewBinding != null ? mViewBinding.f65914c : null;
        mVar.a(viewArr, new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HistoricalPlayRecordFragment.c1(this.f60935a, view);
            }
        });
        h00.j0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.f65913b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        recyclerView.setAdapter(this.f60829k);
        com.transsnet.downloader.adapter.c0 c0Var = this.f60829k;
        c0Var.i(R$id.historyRoot);
        c0Var.z0(new f9.b() { // from class: com.transsnet.downloader.fragment.m1
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                HistoricalPlayRecordFragment.d1(this.f60938a, baseQuickAdapter, view, i11);
            }
        });
        c0Var.D0(new f9.e() { // from class: com.transsnet.downloader.fragment.n1
            @Override // f9.e
            public final boolean a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                return HistoricalPlayRecordFragment.e1(this.f60942a, baseQuickAdapter, view, i11);
            }
        });
        recyclerView.addItemDecoration(new a());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }
}
