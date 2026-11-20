package com.transsion.transfer.wifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.view.TitleLayout;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.transfer.R$string;
import com.transsion.transfer.impl.TransferStatusActivity;
import com.transsion.transfer.impl.client.TransferClient;
import com.transsion.transfer.impl.server.TransferServer;
import com.transsion.transfer.wifi.create.WifiCreateManager;
import com.transsion.transfer.wifi.permission.PermissionsActivity;
import com.transsion.transfer.wifi.share.ShareManager;
import com.transsion.transfer.wifi.util.WifiUtils;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
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
@Route(path = "/transfer/wifi_create")
@Metadata
@SourceDebugExtension
public final class WifiCreateActivity extends BaseNewActivity<ky.d> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public qy.a f59217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f59218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f59219k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b1.b<Intent> f59220l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f59221m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ShareManager f59222n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f59223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.transsion.baselib.report.h f59224p;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.transsion.transfer.wifi.create.a {
        public a() {
        }

        @Override // com.transsion.transfer.wifi.create.a
        public void a(qy.a aVar, long j11) {
            WifiCreateActivity.this.A0(aVar, j11);
        }

        @Override // com.transsion.transfer.wifi.create.a
        public void b(int i11, long j11) {
            WifiCreateActivity.this.z0(i11, j11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.transsion.transfer.wifi.create.a
        public void onStart() {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, WifiCreateActivity.this.getClassTag() + " --> createWifi() --> start .... --> WifiCreateActivity.hashCode() = " + WifiCreateActivity.this.hashCode(), false, 2, null);
            ((ky.d) WifiCreateActivity.this.getMViewBinding()).f69677i.setVisibility(0);
            ((ky.d) WifiCreateActivity.this.getMViewBinding()).f69674f.setImageBitmap(null);
            ((ky.d) WifiCreateActivity.this.getMViewBinding()).f69671b.setVisibility(8);
            ((ky.d) WifiCreateActivity.this.getMViewBinding()).f69672c.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59226a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59226a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59226a;
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
            this.f59226a.invoke(obj);
        }
    }

    public WifiCreateActivity() {
        final Function0 function0 = null;
        this.f59218j = new ViewModelLazy(Reflection.b(com.transsion.transfer.impl.g.class), new Function0<x0>() { // from class: com.transsion.transfer.wifi.ui.WifiCreateActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = this.getViewModelStore();
                Intrinsics.f(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.transfer.wifi.ui.WifiCreateActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                v0.c defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                Intrinsics.f(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<r3.a>() { // from class: com.transsion.transfer.wifi.ui.WifiCreateActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final r3.a invoke() {
                r3.a aVar;
                Function0 function1 = function0;
                if (function1 != null && (aVar = (r3.a) function1.invoke()) != null) {
                    return aVar;
                }
                r3.a defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                Intrinsics.f(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
        b1.b<Intent> bVarRegisterForActivityResult = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.transfer.wifi.ui.g
            @Override // b1.a
            public final void a(Object obj) {
                WifiCreateActivity.I0(this.f59234a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul… finish()\n        }\n    }");
        this.f59220l = bVarRegisterForActivityResult;
        this.f59221m = true;
        this.f59222n = new ShareManager();
        this.f59224p = new com.transsion.baselib.report.h("wifi_create_page", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.transfer.impl.g C0() {
        return (com.transsion.transfer.impl.g) this.f59218j.getValue();
    }

    public static final void E0(WifiCreateActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ShareMbApkDialog shareMbApkDialog = new ShareMbApkDialog();
        shareMbApkDialog.q0(this$0.f59217i);
        FragmentManager supportFragmentManager = this$0.getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        shareMbApkDialog.show(supportFragmentManager, "ShareMbApkDialog");
    }

    public static final void F0(WifiCreateActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.f59222n.j(this$0);
    }

    public static final void G0(WifiCreateActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.d0();
    }

    public static final void H0(WifiCreateActivity this$0, SwitchButton switchButton, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        this$0.f59223o = z11;
        this$0.d0();
    }

    public static final void I0(WifiCreateActivity this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.d0();
        } else {
            this$0.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A0(qy.a aVar, long j11) {
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, getClassTag() + " --> createWifi() --> successFun() --> Wi-Fi创建成功 -- 刷新UI --> 展示二维码等信息", false, 2, null);
        this.f59217i = aVar;
        C0().A();
        kotlinx.coroutines.j.d(v.a(this), null, null, new WifiCreateActivity$createSuccess$1(aVar, this, j11, null), 3, null);
        ((ky.d) getMViewBinding()).f69686r.setText(aVar != null ? aVar.p() : null);
    }

    public final void B0() {
        com.transsion.transfer.impl.h.f59057a.b(this.f59223o ? "5g" : "2.4g");
        WifiCreateManager.f59169a.g(qy.a.f74994r.c(this.f59223o), v.a(this), new a());
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public ky.d getViewBinding() {
        ky.d dVarC = ky.d.c(getLayoutInflater());
        Intrinsics.f(dVarC, "inflate(layoutInflater)");
        return dVarC;
    }

    public final void J0() {
        if (ry.b.f75768a.i()) {
            com.transsion.transfer.wifi.util.g.h(com.transsion.transfer.wifi.util.g.f59252a, getClassTag() + " -->startServerSendData  没有数据，连接成功关闭页面", false, 2, null);
        } else {
            com.transsion.transfer.wifi.util.g.h(com.transsion.transfer.wifi.util.g.f59252a, getClassTag() + " -->startServerSendData  有数据，发送数据", false, 2, null);
        }
        this.f59219k = true;
        TransferStatusActivity.f58946m.c(this);
        finish();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
        ((ky.d) getMViewBinding()).f69684p.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiCreateActivity.E0(this.f59235a, view);
            }
        });
        ((ky.d) getMViewBinding()).f69683o.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiCreateActivity.F0(this.f59236a, view);
            }
        });
        ((ky.d) getMViewBinding()).f69681m.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiCreateActivity.G0(this.f59237a, view);
            }
        });
        ((ky.d) getMViewBinding()).f69678j.setChecked(this.f59223o);
        ((ky.d) getMViewBinding()).f69678j.setOnCheckedChangeListener(new SwitchButton.d() { // from class: com.transsion.transfer.wifi.ui.k
            @Override // com.tn.lib.view.SwitchButton.d
            public final void a(SwitchButton switchButton, boolean z11) {
                WifiCreateActivity.H0(this.f59238a, switchButton, z11);
            }
        });
        if (WifiUtils.f59242a.m()) {
            return;
        }
        ((ky.d) getMViewBinding()).f69678j.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        TitleLayout titleLayout = ((ky.d) getMViewBinding()).f69679k;
        String string = getResources().getString(R$string.transfer_wifi_create_connect_device);
        Intrinsics.f(string, "resources.getString(R.st…fi_create_connect_device)");
        titleLayout.setTitleText(string);
        this.f59222n.h(this);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean a0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void d0() {
        super.d0();
        sy.e eVar = sy.e.f76637a;
        if (!eVar.g(eVar.e())) {
            Intent intent = new Intent(this, (Class<?>) PermissionsActivity.class);
            intent.setAction("com.transsion.transfer.wifi.util.send");
            this.f59220l.a(intent);
        } else {
            if (C0().y() && C0().j()) {
                J0();
                return;
            }
            ey.a aVar = ey.a.f64470a;
            if (aVar.d() && aVar.b()) {
                aVar.h(new WifiCreateActivity$loadDefaultData$1(this));
            } else {
                B0();
            }
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.f59219k) {
            return;
        }
        WifiCreateManager.f59169a.j();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baselib.report.e
    public com.transsion.baselib.report.h getLogViewConfig() {
        return this.f59224p;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        TransferClient.f58969t.c(new Function0<Unit>() { // from class: com.transsion.transfer.wifi.ui.WifiCreateActivity.onCreate.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        });
        TransferServer.f59075s.a();
        super.onCreate(bundle);
        getWindow().addFlags(128);
        com.transsion.transfer.impl.g gVarC0 = C0();
        Function4<String, String, Boolean, String, Unit> function4R = C0().r();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadDefaultData: serverViewModel.getConnectEventSource().observe:");
        sb2.append(gVarC0);
        sb2.append(",");
        sb2.append(function4R);
        C0().x();
        C0().o().j(this, new b(new Function1<Pair<? extends String, ? extends Boolean>, Unit>() { // from class: com.transsion.transfer.wifi.ui.WifiCreateActivity.onCreate.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Boolean> pair) {
                invoke2((Pair<String, Boolean>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, Boolean> pair) {
                if (pair.getSecond().booleanValue()) {
                    py.b.f74066a.o(WifiCreateActivity.this.C0().t());
                    WifiCreateActivity.this.J0();
                }
            }
        }));
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f59221m) {
            sy.e eVar = sy.e.f76637a;
            if (eVar.g(eVar.e())) {
                py.c.f74067a.h();
            }
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z0(int i11, long j11) {
        com.transsion.transfer.wifi.util.g.h(com.transsion.transfer.wifi.util.g.f59252a, getClassTag() + " --> createWifi() --> 热点创建 失败 --> code = " + i11, false, 2, null);
        ((ky.d) getMViewBinding()).f69677i.setVisibility(8);
        ((ky.d) getMViewBinding()).f69672c.setVisibility(8);
        ((ky.d) getMViewBinding()).f69671b.setVisibility(0);
        this.f59221m = false;
        py.c.f74067a.i(i11);
    }
}
