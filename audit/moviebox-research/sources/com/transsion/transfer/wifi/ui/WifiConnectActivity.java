package com.transsion.transfer.wifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Network;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.zxing.BarcodeFormat;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.transfer.R$string;
import com.transsion.transfer.impl.ClientViewModel;
import com.transsion.transfer.impl.TransferStatusActivity;
import com.transsion.transfer.impl.client.TransferClient;
import com.transsion.transfer.impl.server.TransferServer;
import com.transsion.transfer.wifi.connect.TransferWifiConnectDialog;
import com.transsion.transfer.wifi.connect.WifiConnectionManager;
import com.transsion.transfer.wifi.permission.PermissionsActivity;
import com.transsion.transfer.wifi.qrcode.QrCodeUtil;
import com.transsion.transfer.wifi.util.WifiUtils;
import java.net.InetAddress;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

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
@Route(path = "/transfer/wifi_connect")
@Metadata
public final class WifiConnectActivity extends BaseNewActivity<ky.c> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f59205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f59206k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f59208m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TransferWifiConnectDialog f59209n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b1.b<Intent> f59211p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.transsion.baselib.report.h f59212q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f59204i = LazyKt__LazyJVMKt.b(new Function0<ClientViewModel>() { // from class: com.transsion.transfer.wifi.ui.WifiConnectActivity$clientViewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClientViewModel invoke() {
            return (ClientViewModel) new v0(this.this$0).a(ClientViewModel.class);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f59207l = System.currentTimeMillis();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final xn.a f59210o = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements xn.a {
        public a() {
        }

        @Override // xn.a
        public void a(List<? extends com.google.zxing.k> resultPoints) {
            Intrinsics.g(resultPoints, "resultPoints");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xn.a
        public void b(xn.c result) {
            Intrinsics.g(result, "result");
            if (result.e() != null) {
                ((ky.c) WifiConnectActivity.this.getMViewBinding()).f69669d.pause();
                String scannedText = result.e();
                WifiConnectActivity wifiConnectActivity = WifiConnectActivity.this;
                Intrinsics.f(scannedText, "scannedText");
                wifiConnectActivity.L0(scannedText);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.transsion.transfer.wifi.connect.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ qy.a f59215b;

        public b(qy.a aVar) {
            this.f59215b = aVar;
        }

        @Override // com.transsion.transfer.wifi.connect.b
        public void a(Network network) {
            com.transsion.transfer.wifi.connect.b.a.b(this, network);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.transsion.transfer.wifi.connect.b
        public void b(int i11) {
            com.transsion.transfer.wifi.util.g.h(com.transsion.transfer.wifi.util.g.f59252a, WifiConnectActivity.this.getClassTag() + " --> connectWifi() --> onFail() --> code = " + i11, false, 2, null);
            ((ky.c) WifiConnectActivity.this.getMViewBinding()).f69669d.resume();
            WifiConnectActivity.this.F0();
            zp.b.f82110a.e(WifiConnectActivity.this.getResources().getString(R$string.transfer_wifi_connect_dialog_failed));
        }

        @Override // com.transsion.transfer.wifi.connect.b
        public void c(InetAddress inetAddress) {
            com.transsion.transfer.wifi.connect.b.a.e(this, inetAddress);
        }

        @Override // com.transsion.transfer.wifi.connect.b
        public void d(int i11) {
            com.transsion.transfer.wifi.connect.b.a.a(this, i11);
        }

        @Override // com.transsion.transfer.wifi.connect.b
        public void e(String ip2) {
            Intrinsics.g(ip2, "ip");
            com.transsion.transfer.wifi.connect.b.a.c(this, ip2);
            String strK = WifiUtils.f59242a.k();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onParsingSuccess: ip:");
            sb2.append(ip2);
            sb2.append(", WifiUtils.getLocalIP():");
            sb2.append(strK);
            if (WifiConnectActivity.this.f59206k) {
                WifiConnectActivity.this.G0(ip2);
            } else {
                WifiConnectActivity.this.f59205j = ip2;
            }
        }

        @Override // com.transsion.transfer.wifi.connect.b
        public void onStart() {
            com.transsion.transfer.wifi.connect.b.a.d(this);
            WifiConnectActivity.this.O0(this.f59215b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59216a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59216a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59216a;
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
            this.f59216a.invoke(obj);
        }
    }

    public WifiConnectActivity() {
        b1.b<Intent> bVarRegisterForActivityResult = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.transfer.wifi.ui.e
            @Override // b1.a
            public final void a(Object obj) {
                WifiConnectActivity.M0(this.f59231a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul… finish()\n        }\n    }");
        this.f59211p = bVarRegisterForActivityResult;
        this.f59212q = new com.transsion.baselib.report.h("wifi_connect_page", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClientViewModel I0() {
        return (ClientViewModel) this.f59204i.getValue();
    }

    public static final void K0(WifiConnectActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    public static final void M0(WifiConnectActivity this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() != -1) {
            this$0.finish();
        }
    }

    public final void E0(qy.a aVar) {
        WifiConnectionManager.f59120a.n(this, aVar, v.a(this), new b(aVar));
    }

    public final void F0() {
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            TransferWifiConnectDialog transferWifiConnectDialog = this.f59209n;
            if (transferWifiConnectDialog != null) {
                transferWifiConnectDialog.dismissAllowingStateLoss();
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        this.f59209n = null;
    }

    public final void G0(String str) {
        TransferClient.Companion companion = TransferClient.f58969t;
        TransferClient.Companion.j(companion, str, WifiUtils.f59242a.k(), null, new Function0<Unit>() { // from class: com.transsion.transfer.wifi.ui.WifiConnectActivity$doConnect$1
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
                ClientViewModel clientViewModelI0 = this.this$0.I0();
                final WifiConnectActivity wifiConnectActivity = this.this$0;
                clientViewModelI0.h(new Function2<Boolean, String, Unit>() { // from class: com.transsion.transfer.wifi.ui.WifiConnectActivity$doConnect$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                        invoke(bool.booleanValue(), str2);
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z11, String error) {
                        Intrinsics.g(error, "error");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("connectWifi connect res:");
                        sb2.append(z11);
                        if (z11) {
                            py.b.f74066a.e(TransferClient.f58969t.h());
                            return;
                        }
                        ClientViewModel clientViewModelI1 = wifiConnectActivity.I0();
                        final WifiConnectActivity wifiConnectActivity2 = wifiConnectActivity;
                        clientViewModelI1.h(new Function2<Boolean, String, Unit>() { // from class: com.transsion.transfer.wifi.ui.WifiConnectActivity.doConnect.1.1.1

                            /* JADX INFO: renamed from: com.transsion.transfer.wifi.ui.WifiConnectActivity$doConnect$1$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: source.java */
                            @Metadata
                            @DebugMetadata(c = "com.transsion.transfer.wifi.ui.WifiConnectActivity$doConnect$1$1$1$1", f = "WifiConnectActivity.kt", l = {}, m = "invokeSuspend")
                            public static final class C06071 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                                int label;
                                final /* synthetic */ WifiConnectActivity this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C06071(WifiConnectActivity wifiConnectActivity, Continuation<? super C06071> continuation) {
                                    super(2, continuation);
                                    this.this$0 = wifiConnectActivity;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C06071(this.this$0, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                                    return ((C06071) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) throws Throwable {
                                    kotlin.coroutines.intrinsics.a.e();
                                    if (this.label != 0) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.b(obj);
                                    ((ky.c) this.this$0.getMViewBinding()).f69669d.resume();
                                    zp.b.f82110a.e(this.this$0.getResources().getString(R$string.transfer_wifi_connect_dialog_failed));
                                    return Unit.f68710a;
                                }
                            }

                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                                invoke(bool.booleanValue(), str2);
                                return Unit.f68710a;
                            }

                            public final void invoke(boolean z12, String autoError) {
                                Intrinsics.g(autoError, "autoError");
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("connectWifi auto retry connect res:");
                                sb3.append(z12);
                                sb3.append(", autoError:");
                                sb3.append(autoError);
                                if (z12) {
                                    py.b.f74066a.e(TransferClient.f58969t.h());
                                    return;
                                }
                                py.b.f74066a.d(autoError, TransferClient.f58969t.h());
                                wifiConnectActivity2.F0();
                                WifiConnectionManager.f59120a.s();
                                kotlinx.coroutines.j.d(v.a(wifiConnectActivity2), w0.c(), null, new C06071(wifiConnectActivity2, null), 2, null);
                            }
                        });
                    }
                });
            }
        }, 4, null);
        py.b.f74066a.n(companion.h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H0() {
        ((ky.c) getMViewBinding()).f69669d.setDecoderFactory(new xn.n(kotlin.collections.g.o(BarcodeFormat.QR_CODE, BarcodeFormat.CODE_39)));
        ((ky.c) getMViewBinding()).f69669d.initializeFromIntent(getIntent());
        ((ky.c) getMViewBinding()).f69669d.decodeContinuous(this.f59210o);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public ky.c getViewBinding() {
        ky.c cVarC = ky.c.c(getLayoutInflater());
        Intrinsics.f(cVarC, "inflate(layoutInflater)");
        return cVarC;
    }

    public final void L0(String str) {
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, getClassTag() + " --> onScanSuccess() --> scannedText = " + str + " --> 扫码成功 开始解析 建立连接", false, 2, null);
        QrCodeUtil.f59192a.e(str, new Function1<qy.a, Unit>() { // from class: com.transsion.transfer.wifi.ui.WifiConnectActivity$onScanSuccess$1

            /* JADX INFO: renamed from: com.transsion.transfer.wifi.ui.WifiConnectActivity$onScanSuccess$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                final /* synthetic */ qy.a $it;
                final /* synthetic */ WifiConnectActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(WifiConnectActivity wifiConnectActivity, qy.a aVar) {
                    super(0);
                    this.this$0 = wifiConnectActivity;
                    this.$it = aVar;
                }

                public static final void b(WifiConnectActivity this$0, qy.a aVar) {
                    Intrinsics.g(this$0, "this$0");
                    this$0.E0(aVar);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConstraintLayout root = ((ky.c) this.this$0.getMViewBinding()).getRoot();
                    final WifiConnectActivity wifiConnectActivity = this.this$0;
                    final qy.a aVar = this.$it;
                    root.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE 
                          (r0v3 'root' androidx.constraintlayout.widget.ConstraintLayout)
                          (wrap java.lang.Runnable:0x0012: CONSTRUCTOR 
                          (r1v0 'wifiConnectActivity' com.transsion.transfer.wifi.ui.WifiConnectActivity A[DONT_INLINE])
                          (r2v0 'aVar' qy.a A[DONT_INLINE])
                         A[MD:(com.transsion.transfer.wifi.ui.WifiConnectActivity, qy.a):void (m), WRAPPED] call: com.transsion.transfer.wifi.ui.f.<init>(com.transsion.transfer.wifi.ui.WifiConnectActivity, qy.a):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (c)] in method: com.transsion.transfer.wifi.ui.WifiConnectActivity$onScanSuccess$1.1.invoke():void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.transsion.transfer.wifi.ui.f, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        com.transsion.transfer.wifi.ui.WifiConnectActivity r0 = r4.this$0
                        n6.a r0 = r0.getMViewBinding()
                        ky.c r0 = (ky.c) r0
                        androidx.constraintlayout.widget.ConstraintLayout r0 = r0.getRoot()
                        com.transsion.transfer.wifi.ui.WifiConnectActivity r1 = r4.this$0
                        qy.a r2 = r4.$it
                        com.transsion.transfer.wifi.ui.f r3 = new com.transsion.transfer.wifi.ui.f
                        r3.<init>(r1, r2)
                        r0.post(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.wifi.ui.WifiConnectActivity$onScanSuccess$1.AnonymousClass1.invoke2():void");
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(qy.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(qy.a aVar) {
                if (aVar == null) {
                    zp.b.f82110a.e(this.this$0.getResources().getString(R$string.transfer_wifi_connect_error_tip_no_mb_qr_code, com.blankj.utilcode.util.c.a()));
                    ((ky.c) this.this$0.getMViewBinding()).f69669d.resume();
                    return;
                }
                if (TextUtils.equals("5G", aVar.m()) && !WifiUtils.f59242a.m()) {
                    if (System.currentTimeMillis() - this.this$0.f59207l > 1000) {
                        zp.b.f82110a.e(this.this$0.getResources().getString(R$string.transfer_wifi_connect_error_tip_no_support));
                    }
                    ((ky.c) this.this$0.getMViewBinding()).f69669d.resume();
                    com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f59252a, this.this$0.getClassTag() + " --> onScanSuccess() --> 预期使用5G通道，但是设备不支持", false, 2, null);
                    this.this$0.f59207l = System.currentTimeMillis();
                    return;
                }
                com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, this.this$0.getClassTag() + " --> onScanSuccess() --> 预期使用" + aVar.m() + "通道，且设备支持 -- 开始连接....", false, 2, null);
                ey.a aVar2 = ey.a.f64470a;
                if (aVar2.c() && aVar2.a()) {
                    aVar2.g(new AnonymousClass1(this.this$0, aVar));
                } else {
                    this.this$0.E0(aVar);
                }
            }
        });
    }

    public final void N0(View view, int i11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).topMargin = i11;
        view.setLayoutParams(bVar);
    }

    public final void O0(qy.a aVar) {
        TransferWifiConnectDialog transferWifiConnectDialog = new TransferWifiConnectDialog();
        transferWifiConnectDialog.o0(new Function0<Unit>() { // from class: com.transsion.transfer.wifi.ui.WifiConnectActivity$showLoadingDialog$1$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WifiConnectionManager.f59120a.b(2001);
            }
        });
        transferWifiConnectDialog.p0(aVar);
        this.f59209n = transferWifiConnectDialog;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        transferWifiConnectDialog.show(supportFragmentManager, "TransferWifiConnectDialog");
    }

    public final void P0() {
        finish();
        TransferStatusActivity.f58946m.b(this);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
        ((ky.c) getMViewBinding()).f69667b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiConnectActivity.K0(this.f59230a, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        H0();
        I0().k().j(this, new c(new Function1<Boolean, Unit>() { // from class: com.transsion.transfer.wifi.ui.WifiConnectActivity$initViewData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Intrinsics.f(it, "it");
                if (!it.booleanValue() || this.this$0.f59208m) {
                    return;
                }
                py.b.f74066a.e(TransferClient.f58969t.h());
                this.this$0.f59208m = true;
                this.this$0.P0();
            }
        }));
        int statusBarHeight = ImmersionBar.getStatusBarHeight((Activity) this);
        AppCompatImageView appCompatImageView = ((ky.c) getMViewBinding()).f69667b;
        Intrinsics.f(appCompatImageView, "mViewBinding.ivClose");
        N0(appCompatImageView, statusBarHeight);
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
        if (eVar.g(eVar.c())) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) PermissionsActivity.class);
        intent.setAction("com.transsion.transfer.wifi.util.receive");
        this.f59211p.a(intent);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baselib.report.e
    public com.transsion.baselib.report.h getLogViewConfig() {
        return this.f59212q;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        TransferClient.f58969t.c(new Function0<Unit>() { // from class: com.transsion.transfer.wifi.ui.WifiConnectActivity.onCreate.1
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
                WifiConnectActivity.this.f59206k = true;
                String str = WifiConnectActivity.this.f59205j;
                if (str != null) {
                    WifiConnectActivity.this.G0(str);
                }
            }
        });
        TransferServer.f59075s.a();
        super.onCreate(bundle);
        getWindow().addFlags(128);
        ImmersionBar.with(this).transparentBar().init();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((ky.c) getMViewBinding()).f69669d.pause();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((ky.c) getMViewBinding()).f69669d.resume();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean setImmersionStatusBar() {
        return false;
    }
}
