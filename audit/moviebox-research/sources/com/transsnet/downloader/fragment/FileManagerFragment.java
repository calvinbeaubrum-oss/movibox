package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.memberapi.IMemberApi;
import com.transsion.transfer.impl.entity.FileData;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.config.Config;
import com.transsnet.downloader.fragment.ad.AppDownloadAdFragment;
import com.transsnet.downloader.fragment.ad.TopCardAdFragment;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.viewmodel.LocalFileViewModel;
import com.transsnet.downloader.viewmodel.TransferReceivedViewModel;
import com.transsnet.downloader.widget.FileManagerTabTitleView;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class FileManagerFragment extends DownloadTabBaseFragment<h00.i0> implements su.e {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f60819t = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Fragment f60823o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Fragment f60824p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DownloadPanelFragment f60825q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f60827s;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f60820l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f60821m = FragmentViewModelLazyKt.a(this, Reflection.b(TransferReceivedViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f60822n = FragmentViewModelLazyKt.a(this, Reflection.b(LocalFileViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$special$$inlined$activityViewModels$default$3
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$special$$inlined$activityViewModels$default$4
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

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f60826r = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.manager.a invoke() {
            return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        }
    });

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FileManagerFragment a(int i11) {
            FileManagerFragment fileManagerFragment = new FileManagerFragment();
            fileManagerFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_page_index", Integer.valueOf(i11))));
            return fileManagerFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60828a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60828a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60828a;
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
            this.f60828a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.FileManagerFragment$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.FileManagerFragment$initData$1", f = "FileManagerFragment.kt", l = {154}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileManagerFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                com.transsnet.downloader.manager.a aVarE0 = FileManagerFragment.this.E0();
                this.label = 1;
                if (aVarE0.C(this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.a E0() {
        return (com.transsnet.downloader.manager.a) this.f60826r.getValue();
    }

    private final LocalFileViewModel H0() {
        return (LocalFileViewModel) this.f60822n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TransferReceivedViewModel I0() {
        return (TransferReceivedViewModel) this.f60821m.getValue();
    }

    private final void K0() {
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag("TopCardAdFragment");
        this.f60823o = fragmentFindFragmentByTag;
        if (fragmentFindFragmentByTag == null) {
            this.f60823o = new TopCardAdFragment();
        }
        Fragment fragment = this.f60823o;
        if (fragment != null) {
            com.transsion.baselib.utils.j jVar = com.transsion.baselib.utils.j.f51318a;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            com.transsion.baselib.utils.j.b(jVar, childFragmentManager, R$id.flTopCardAd, fragment, false, null, 24, null);
        }
        Fragment fragmentFindFragmentByTag2 = getChildFragmentManager().findFragmentByTag("AppDownloadAdFragment");
        this.f60824p = fragmentFindFragmentByTag2;
        if (fragmentFindFragmentByTag2 == null) {
            this.f60824p = new AppDownloadAdFragment();
        }
        Fragment fragment2 = this.f60824p;
        if (fragment2 != null) {
            com.transsion.baselib.utils.j jVar2 = com.transsion.baselib.utils.j.f51318a;
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.f(childFragmentManager2, "childFragmentManager");
            com.transsion.baselib.utils.j.b(jVar2, childFragmentManager2, R$id.flAppDownloadAd, fragment2, false, null, 24, null);
        }
    }

    private final void L0() {
        Function1<DownloadRefreshEvent, Unit> function1 = new Function1<DownloadRefreshEvent, Unit>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$initVideoObserve$1
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
                Intrinsics.g(value, "value");
                String resourceId = value.getResourceId();
                if (resourceId == null || resourceId.length() == 0) {
                    this.this$0.m0().j();
                }
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadRefreshEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, kotlinx.coroutines.w0.c().q(), false, function1);
        Function1<AddToDownloadEvent, Unit> function2 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$initVideoObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AddToDownloadEvent addToDownloadEvent) {
                invoke2(addToDownloadEvent);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AddToDownloadEvent value) {
                FrameLayout frameLayout;
                Intrinsics.g(value, "value");
                h00.i0 i0Var = (h00.i0) this.this$0.getMViewBinding();
                if (i0Var == null || (frameLayout = i0Var.f65902d) == null || frameLayout.getVisibility() == 0 || !this.this$0.isVisible() || !value.getAdd()) {
                    return;
                }
                this.this$0.F0();
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = AddToDownloadEvent.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.observeEvent(this, name2, state, kotlinx.coroutines.w0.c().q(), false, function2);
        Function1<oy.c, Unit> function3 = new Function1<oy.c, Unit>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$initVideoObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(oy.c cVar) {
                invoke2(cVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(oy.c value) {
                Intrinsics.g(value, "value");
                uo.b.f78622a.c(TransferBottomToolsView.TAG, "TransferFinishEvent， 有传输完成，刷新页面", true);
                DownloadViewModel downloadViewModelM0 = this.this$0.m0();
                FileData fileDataA = value.a();
                final FileManagerFragment fileManagerFragment = this.this$0;
                downloadViewModelM0.K(fileDataA, new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment$initVideoObserve$3.1
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
                        TransferReceivedViewModel.i(fileManagerFragment.I0(), false, 1, null);
                        fileManagerFragment.m0().z().q(Boolean.TRUE);
                    }
                });
            }
        };
        FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name3 = oy.c.class.getName();
        Intrinsics.f(name3, "T::class.java.name");
        flowEventBus3.observeEvent(this, name3, state, kotlinx.coroutines.w0.c().q(), false, function3);
    }

    private final void initViewModel() {
        m0().o().j(this, new b(new Function1<List<? extends DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment.initViewModel.1
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
                FileManagerFragment.this.N0(0, list != null ? list.size() : 0);
            }
        }));
        H0().i().j(this, new b(new Function1<List<DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment.initViewModel.2
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
                FileManagerFragment.this.N0(1, list != null ? list.size() : 0);
            }
        }));
        I0().j().j(this, new b(new Function1<List<DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment.initViewModel.3
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
                FileManagerFragment.this.N0(2, list != null ? list.size() : 0);
            }
        }));
        m0().q().j(this, new b(new Function1<List<? extends DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.FileManagerFragment.initViewModel.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DownloadBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends DownloadBean> list) {
                FrameLayout frameLayout;
                FrameLayout frameLayout2;
                FrameLayout frameLayout3;
                List<? extends DownloadBean> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    uo.b.a.u(uo.b.f78622a, FileManagerFragment.this.p0(), "downloading null- hide fragment", false, 4, null);
                    h00.i0 i0Var = (h00.i0) FileManagerFragment.this.getMViewBinding();
                    if (i0Var == null || (frameLayout = i0Var.f65902d) == null) {
                        return;
                    }
                    so.c.g(frameLayout);
                    return;
                }
                h00.i0 i0Var2 = (h00.i0) FileManagerFragment.this.getMViewBinding();
                if (i0Var2 != null && (frameLayout3 = i0Var2.f65902d) != null && frameLayout3.getVisibility() == 0) {
                    uo.b.a.f(uo.b.f78622a, FileManagerFragment.this.p0(), "downloading have data, fragment is shown", false, 4, null);
                    return;
                }
                h00.i0 i0Var3 = (h00.i0) FileManagerFragment.this.getMViewBinding();
                if (i0Var3 != null && (frameLayout2 = i0Var3.f65902d) != null) {
                    so.c.k(frameLayout2);
                }
                uo.b.a aVar = uo.b.f78622a;
                uo.b.a.f(aVar, FileManagerFragment.this.p0(), "downloading have data, show fragment", false, 4, null);
                Fragment fragmentFindFragmentByTag = FileManagerFragment.this.getChildFragmentManager().findFragmentByTag("DownloadingListFragment");
                if (fragmentFindFragmentByTag == null) {
                    fragmentFindFragmentByTag = new DownloadingListFragment();
                }
                Fragment fragment = fragmentFindFragmentByTag;
                if (fragment.isAdded()) {
                    uo.b.a.f(aVar, FileManagerFragment.this.p0(), "downloading have data, isAdded, show", false, 4, null);
                    FileManagerFragment.this.getChildFragmentManager().beginTransaction().show(fragment).commitNowAllowingStateLoss();
                } else {
                    uo.b.a.f(aVar, FileManagerFragment.this.p0(), "downloading have data, add", false, 4, null);
                    FileManagerFragment.this.getChildFragmentManager().beginTransaction().add(R$id.flDownloadingContainer, fragment, "DownloadingListFragment").commitNowAllowingStateLoss();
                }
            }
        }));
        D0();
        G0();
    }

    public final void D0() {
        m0().j();
        TransferReceivedViewModel.i(I0(), false, 1, null);
    }

    public final void F0() {
        m0().p();
    }

    public final void G0() {
        LocalFileViewModel.k(H0(), false, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public h00.i0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.i0 i0VarC = h00.i0.c(inflater);
        Intrinsics.f(i0VarC, "inflate(inflater)");
        return i0VarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M0() {
        long jA = com.blankj.utilcode.util.b0.a();
        if (jA > 0) {
            String strA = tp.a.a(jA, 1);
            h00.i0 i0Var = (h00.i0) getMViewBinding();
            AppCompatTextView appCompatTextView = i0Var != null ? i0Var.f65905h : null;
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setText(strA);
        }
    }

    public final void N0(int i11, int i12) {
        String str;
        uo.b.a.u(uo.b.f78622a, p0(), "updateTabTitle - position:" + i11 + ",count:" + i12, false, 4, null);
        if (i11 >= l0().size()) {
            return;
        }
        String str2 = l0().get(i11);
        if (i12 > 0) {
            str = " " + i12;
        } else {
            str = "";
        }
        String str3 = ((Object) str2) + str;
        ORCommonNavigator oRCommonNavigatorJ0 = j0();
        h20.d pagerTitleView = oRCommonNavigatorJ0 != null ? oRCommonNavigatorJ0.getPagerTitleView(i11) : null;
        FileManagerTabTitleView fileManagerTabTitleView = pagerTitleView instanceof FileManagerTabTitleView ? (FileManagerTabTitleView) pagerTitleView : null;
        if (fileManagerTabTitleView != null) {
            fileManagerTabTitleView.setTitle(str3, i12, i11);
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public Fragment h0(int i11) {
        if (i11 == 0) {
            return DownloadedListFragment.f60807u.a();
        }
        if (i11 != 1) {
            return i11 != 2 ? DownloadedListFragment.f60807u.a() : TransferReceivedFragment.f60866v.a();
        }
        return LocalFileListFragment.f60841y.a();
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public List<String> i0() {
        return m0().l().f();
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment, com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        M0();
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new AnonymousClass1(null), 3, null);
        DownloadSDCardUtil.f61130a.b();
        initViewModel();
        L0();
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initView(view, bundle);
        K0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.f60827s != 0) {
            FirebaseAnalyticsManager.f51235a.o("downloadpage", Long.valueOf(SystemClock.elapsedRealtime() - this.f60827s), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.f60827s = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        x0(arguments != null ? arguments.getInt("extra_page_index") : 0);
        if (com.transsnet.downloader.manager.b.f61062a.a(Utils.a()).i()) {
            x0(0);
        }
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).w(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).V0(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (z11) {
            return;
        }
        Fragment fragment = this.f60823o;
        TopCardAdFragment topCardAdFragment = fragment instanceof TopCardAdFragment ? (TopCardAdFragment) fragment : null;
        if (topCardAdFragment != null) {
            topCardAdFragment.R0();
        }
        Fragment fragment2 = this.f60824p;
        AppDownloadAdFragment appDownloadAdFragment = fragment2 instanceof AppDownloadAdFragment ? (AppDownloadAdFragment) fragment2 : null;
        if (appDownloadAdFragment != null) {
            appDownloadAdFragment.V0();
        }
        D0();
    }

    @Override // su.e
    public void onMemberStateChange() {
        boolean zM = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).m();
        uo.b.a.f(uo.b.f78622a, "co_mem", "下载管理页面收到回调 --> skipShowAd = " + zM, false, 4, null);
        Config config = new Config();
        UserInfo userInfoP = ((ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class)).P();
        if (userInfoP == null || userInfoP.getUserType() != 0) {
            config.g(((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).j1());
        } else {
            config.g(1);
        }
        com.transsnet.downloader.manager.b.a aVar = com.transsnet.downloader.manager.b.f61062a;
        com.transsnet.downloader.manager.b.a.b(aVar, null, 1, null).l(config);
        com.transsnet.downloader.manager.b.a.b(aVar, null, 1, null).w();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.d.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DownloadPanelFragment downloadPanelFragment = this.f60825q;
        if (downloadPanelFragment != null) {
            downloadPanelFragment.o1();
        }
        com.transsion.baseui.activity.d.p(null, this, "visible=" + isVisible(), 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (isVisible()) {
            if (this.f60820l) {
                this.f60820l = false;
            } else {
                D0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public MagicIndicator s0() {
        h00.i0 i0Var = (h00.i0) getMViewBinding();
        if (i0Var != null) {
            return i0Var.f65904g;
        }
        return null;
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void t0(int i11) {
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void u0(int i11) {
    }

    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public void v0(List<String> list) {
        m0().l().q(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsnet.downloader.fragment.DownloadTabBaseFragment
    public ViewPager2 y0() {
        h00.i0 i0Var = (h00.i0) getMViewBinding();
        if (i0Var != null) {
            return i0Var.f65906i;
        }
        return null;
    }
}
