package com.transsion.usercenter.me;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baselib.report.h;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import f00.d;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;
import so.c;
import xy.b0;

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
public final class MeFragment extends BaseFragment<b0> implements r00.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f59420f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.usercenter.me.adapter.b f59423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f59424d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MeFragment a() {
            return new MeFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59425a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59425a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59425a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59425a.invoke(obj);
        }
    }

    public MeFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.me.MeFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f59421a = FragmentViewModelLazyKt.a(this, Reflection.b(MeViewmodel.class), new Function0<x0>() { // from class: com.transsion.usercenter.me.MeFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.me.MeFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                m mVar = objInvoke instanceof m ? (m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f59422b = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.usercenter.me.MeFragment$mLoginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
    }

    private final ILoginApi i0() {
        Object value = this.f59422b.getValue();
        Intrinsics.f(value, "<get-mLoginApi>(...)");
        return (ILoginApi) value;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        j0().v().j(this, new b(new Function1<List<MeItemInfo>, Unit>() { // from class: com.transsion.usercenter.me.MeFragment.initData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<MeItemInfo> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<MeItemInfo> list) {
                h logViewConfig = MeFragment.this.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.j(true);
                }
                com.transsion.usercenter.me.adapter.b bVar = MeFragment.this.f59423c;
                if (bVar != null) {
                    bVar.w0(list);
                }
            }
        }));
        l0();
        i0().F(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        m0();
    }

    public final MeViewmodel j0() {
        return (MeViewmodel) this.f59421a.getValue();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        b0 b0VarC = b0.c(inflater);
        Intrinsics.f(b0VarC, "inflate(inflater)");
        return b0VarC;
    }

    public final void l0() {
        Function1<d, Unit> function1 = new Function1<d, Unit>() { // from class: com.transsion.usercenter.me.MeFragment$initHistoryObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                invoke2(dVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(d value) {
                Intrinsics.g(value, "value");
                this.this$0.j0().n();
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = d.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        j0().o();
        j0().p();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.f59424d != 0) {
            FirebaseAnalyticsManager.f51235a.o("profiledetail", Long.valueOf(SystemClock.elapsedRealtime() - this.f59424d), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.f59424d = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m0() {
        b0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            ConstraintLayout root = mViewBinding.getRoot();
            Intrinsics.f(root, "it.root");
            c.e(root);
            AppCompatImageView appCompatImageView = mViewBinding.f80724c;
            Intrinsics.f(appCompatImageView, "it.ivQrCode");
            c.c(appCompatImageView, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.me.MeFragment$initTop$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.g(it, "it");
                    com.alibaba.android.arouter.launcher.a.d().b("/profile/qr_code").navigation();
                }
            }, 1, null);
            com.transsion.usercenter.me.adapter.b bVar = new com.transsion.usercenter.me.adapter.b(null, 1, 0 == true ? 1 : 0);
            this.f59423c = bVar;
            mViewBinding.f80723b.setAdapter(bVar);
            mViewBinding.f80723b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public h newLogViewConfig() {
        h hVar = new h("profiledetail", false, 2, null);
        hVar.g().put("user_status", "me");
        HashMap<String, String> mapG = hVar.g();
        UserInfo userInfoP = i0().P();
        mapG.put("user_id", String.valueOf(userInfoP != null ? userInfoP.getUserId() : null));
        return hVar;
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

    @Override // r00.a
    public void onLogin(UserInfo user) {
        Intrinsics.g(user, "user");
        r00.a.C0822a.a(this, user);
        lazyLoadData();
    }

    @Override // r00.a
    public void onLogout() {
        r00.a.C0822a.b(this);
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.d.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        lazyLoadData();
        com.transsion.baseui.activity.d.p(null, this, "visible=" + isVisible(), 1, null);
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        r00.a.C0822a.c(this, userInfo);
    }
}
