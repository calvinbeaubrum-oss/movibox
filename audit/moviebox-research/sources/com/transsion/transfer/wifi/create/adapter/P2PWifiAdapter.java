package com.transsion.transfer.wifi.create.adapter;

import android.annotation.SuppressLint;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;
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
@Metadata
public final class P2PWifiAdapter extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f59174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f59175f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WifiP2pManager.Channel f59177h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f59173d = 10;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f59176g = LazyKt__LazyJVMKt.b(new Function0<WifiP2pManager>() { // from class: com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$wifiP2pManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WifiP2pManager invoke() {
            Object systemService = Utils.a().getApplicationContext().getSystemService("wifip2p");
            if (systemService instanceof WifiP2pManager) {
                return (WifiP2pManager) systemService;
            }
            return null;
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements WifiP2pManager.ActionListener {
        public a() {
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i11) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, P2PWifiAdapter.this.b() + " --> setDeviceName() --> 反射创建 --> onFailure() --> reason = " + com.transsion.transfer.wifi.util.i.f59253a.b(i11) + " --> 失败重试", false, 2, null);
            P2PWifiAdapter.this.D();
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            String string = Settings.Global.getString(Utils.a().getApplicationContext().getContentResolver(), "wifi_p2p_device_name");
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, P2PWifiAdapter.this.b() + " --> setDeviceName() --> 反射创建 --> onSuccess() --> deviceName = " + string, false, 2, null);
            P2PWifiAdapter.this.r();
        }
    }

    public static final void B(P2PWifiAdapter this$0, WifiP2pGroup wifiP2pGroup) {
        Intrinsics.g(this$0, "this$0");
        if (wifiP2pGroup != null) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, this$0.b() + " --> requestGroupInfo() --> requestGroupInfo() --> 获取Group信息成功,开始获取连接信息", false, 2, null);
            this$0.y(wifiP2pGroup);
            return;
        }
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, this$0.b() + " --> requestGroupInfo() --> 获取Group信息失败 --> wifiP2pGroup == null", false, 2, null);
        this$0.C();
    }

    public static final void z(P2PWifiAdapter this$0, WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(wifiP2pGroup, "$wifiP2pGroup");
        if (wifiP2pInfo == null) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, this$0.b() + " --> requestConnectionInfo() --> 获取可连接信息失败 (p2pInfo == null)", false, 2, null);
            this$0.C();
            return;
        }
        InetAddress inetAddress = wifiP2pInfo.groupOwnerAddress;
        com.transsion.transfer.wifi.util.g gVar = com.transsion.transfer.wifi.util.g.f59252a;
        com.transsion.transfer.wifi.util.g.b(gVar, this$0.b() + " --> requestConnectionInfo() --> Group Owner Address = " + inetAddress, false, 2, null);
        String strU = this$0.u(inetAddress);
        if (TextUtils.isEmpty(strU)) {
            com.transsion.transfer.wifi.util.g.b(gVar, this$0.b() + " --> requestConnectionInfo() --> 获取可连接Ip失败 --> correctIp 为空", false, 2, null);
            this$0.C();
            return;
        }
        qy.a aVarE = this$0.e();
        if (aVarE != null) {
            aVarE.H(wifiP2pGroup.getNetworkName());
        }
        qy.a aVarE2 = this$0.e();
        if (aVarE2 != null) {
            aVarE2.G(wifiP2pGroup.getPassphrase());
        }
        qy.a aVarE3 = this$0.e();
        if (aVarE3 != null) {
            aVarE3.F(strU);
        }
        com.transsion.transfer.wifi.util.g.b(gVar, this$0.b() + " --> requestConnectionInfo() --> 最终ip为 correctIp = " + strU, false, 2, null);
        k0 k0VarC = this$0.c();
        if (k0VarC != null) {
            kotlinx.coroutines.j.d(k0VarC, null, null, new P2PWifiAdapter$requestConnectionInfo$1$1$1(this$0, null), 3, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @SuppressLint({"MissingPermission"})
    public final Object A(Continuation<? super Unit> continuation) throws Throwable {
        P2PWifiAdapter$requestGroupInfo$1 p2PWifiAdapter$requestGroupInfo$1;
        final P2PWifiAdapter p2PWifiAdapter;
        Unit unit;
        WifiP2pManager wifiP2pManagerV;
        if (continuation instanceof P2PWifiAdapter$requestGroupInfo$1) {
            p2PWifiAdapter$requestGroupInfo$1 = (P2PWifiAdapter$requestGroupInfo$1) continuation;
            int i11 = p2PWifiAdapter$requestGroupInfo$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                p2PWifiAdapter$requestGroupInfo$1.label = i11 - Integer.MIN_VALUE;
            } else {
                p2PWifiAdapter$requestGroupInfo$1 = new P2PWifiAdapter$requestGroupInfo$1(this, continuation);
            }
        } else {
            p2PWifiAdapter$requestGroupInfo$1 = new P2PWifiAdapter$requestGroupInfo$1(this, continuation);
        }
        Object obj = p2PWifiAdapter$requestGroupInfo$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = p2PWifiAdapter$requestGroupInfo$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            if (this.f59175f >= this.f59173d) {
                w(101);
                return Unit.f68710a;
            }
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> requestGroupInfo() --> Wi-Fi P2P 创建成功之后，将自己添加到群组 --> 第" + this.f59175f + " 次获取热点相关信息", false, 2, null);
            p2PWifiAdapter$requestGroupInfo$1.L$0 = this;
            p2PWifiAdapter$requestGroupInfo$1.label = 1;
            if (r0.a(300L, p2PWifiAdapter$requestGroupInfo$1) == objE) {
                return objE;
            }
            p2PWifiAdapter = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p2PWifiAdapter = (P2PWifiAdapter) p2PWifiAdapter$requestGroupInfo$1.L$0;
            ResultKt.b(obj);
        }
        if (p2PWifiAdapter.f59177h == null || (wifiP2pManagerV = p2PWifiAdapter.v()) == null) {
            unit = null;
        } else {
            wifiP2pManagerV.requestGroupInfo(p2PWifiAdapter.f59177h, new WifiP2pManager.GroupInfoListener() { // from class: com.transsion.transfer.wifi.create.adapter.j
                @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
                public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
                    P2PWifiAdapter.B(this.f59184a, wifiP2pGroup);
                }
            });
            unit = Unit.f68710a;
        }
        if (unit == null) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, p2PWifiAdapter.b() + " --> requestGroupInfo() --> p2pChannel == null --> 失败重试 --> retryCreate()", false, 2, null);
            p2PWifiAdapter.D();
        }
        return Unit.f68710a;
    }

    public final void C() {
        k0 k0VarC = c();
        if (k0VarC != null) {
            kotlinx.coroutines.j.d(k0VarC, null, null, new P2PWifiAdapter$retry$1(this, null), 3, null);
        }
    }

    public final void D() {
        int i11 = this.f59174e + 1;
        this.f59174e = i11;
        if (i11 > this.f59173d) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> retryCreate() --> 重试次数 = " + this.f59174e + "，判定创建热点失败", false, 2, null);
            w(102);
            return;
        }
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> retryCreate() --> 重新创建热点 -- 失败次数 = " + this.f59174e, false, 2, null);
        int i12 = this.f59174e;
        if (i12 <= 1 || i12 == 5) {
            q();
            return;
        }
        k0 k0VarC = c();
        if (k0VarC != null) {
            kotlinx.coroutines.j.d(k0VarC, null, null, new P2PWifiAdapter$retryCreate$1(this, null), 3, null);
        }
    }

    public final void E() {
        Object objM163constructorimpl;
        a aVar = new a();
        try {
            Result.Companion companion = Result.Companion;
            WifiP2pManager wifiP2pManagerV = v();
            if (wifiP2pManagerV != null) {
                Method declaredMethod = wifiP2pManagerV.getClass().getDeclaredMethod("setDeviceName", WifiP2pManager.Channel.class, String.class, WifiP2pManager.ActionListener.class);
                com.transsion.transfer.wifi.util.g gVar = com.transsion.transfer.wifi.util.g.f59252a;
                String strB = b();
                int i11 = Build.VERSION.SDK_INT;
                qy.a aVarE = e();
                String strP = aVarE != null ? aVarE.p() : null;
                qy.a aVarE2 = e();
                com.transsion.transfer.wifi.util.g.b(gVar, strB + " --> setDeviceName() --> API < 29 -- Android" + i11 + "设备(Q以上下) 创建 --> WIFI名称 = " + strP + " -- WIFI频段 = " + (aVarE2 != null ? aVarE2.m() : null), false, 2, null);
                WifiP2pManager wifiP2pManagerV2 = v();
                Object[] objArr = new Object[3];
                objArr[0] = this.f59177h;
                qy.a aVarE3 = e();
                objArr[1] = aVarE3 != null ? aVarE3.p() : null;
                objArr[2] = aVar;
                declaredMethod.invoke(wifiP2pManagerV2, objArr);
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> setDeviceName() --> Build.VERSION.SDK_INT < Q --> 反射创建失败 -->exception = " + thM166exceptionOrNullimpl + " --> 失败重试", false, 2, null);
        D();
    }

    @Override // com.transsion.transfer.wifi.create.adapter.b
    public Object a(Continuation<? super Unit> continuation) {
        com.transsion.transfer.wifi.util.g gVar = com.transsion.transfer.wifi.util.g.f59252a;
        com.transsion.transfer.wifi.util.g.b(gVar, b() + " --> createWifiHot() --> start", false, 2, null);
        WifiP2pManager wifiP2pManagerV = v();
        this.f59177h = wifiP2pManagerV != null ? wifiP2pManagerV.initialize(Utils.a().getApplicationContext(), Looper.getMainLooper(), null) : null;
        int i11 = Build.VERSION.SDK_INT;
        if (WifiUtils.f59242a.r()) {
            com.transsion.transfer.wifi.util.g.b(gVar, b() + " --> createWifiHot() --> Android" + i11 + "设备(Q以下) 开始创建P2P WIFI热点", false, 2, null);
            E();
        } else {
            com.transsion.transfer.wifi.util.g.b(gVar, b() + " --> createWifiHot() --> Android" + i11 + "设备(Q及其以上) 开始创建P2P WIFI热点", false, 2, null);
            t();
        }
        return Unit.f68710a;
    }

    @Override // com.transsion.transfer.wifi.create.adapter.b
    public void f() {
        x();
        g(null);
        h(null);
        this.f59177h = null;
    }

    public final void q() {
        Ref.IntRef intRef = new Ref.IntRef();
        k0 k0VarC = c();
        if (k0VarC != null) {
            kotlinx.coroutines.j.d(k0VarC, w0.b(), null, new P2PWifiAdapter$closeWifiAndReCreateHot$1(intRef, this, null), 2, null);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void r() {
        Unit unit;
        WifiP2pManager wifiP2pManagerV;
        WifiP2pManager.Channel channel = this.f59177h;
        if (channel == null || (wifiP2pManagerV = v()) == null) {
            unit = null;
        } else {
            wifiP2pManagerV.createGroup(channel, new WifiP2pManager.ActionListener() { // from class: com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$createGroup$1$1
                @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                public void onFailure(int i11) {
                    com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, this.f59179a.b() + " --> setDeviceName() --> createGroup() --> onFailure() --> reason = " + com.transsion.transfer.wifi.util.i.f59253a.b(i11) + " --> 失败重试", false, 2, null);
                    this.f59179a.D();
                }

                @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                public void onSuccess() {
                    com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, this.f59179a.b() + " --> setDeviceName() --> createGroup() --> onSuccess()", false, 2, null);
                    k0 k0VarC = this.f59179a.c();
                    if (k0VarC != null) {
                        kotlinx.coroutines.j.d(k0VarC, null, null, new P2PWifiAdapter$createGroup$1$1$onSuccess$1(this.f59179a, null), 3, null);
                    }
                }
            });
            unit = Unit.f68710a;
        }
        if (unit == null) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> createGroup() --> p2pChannel == null --> 失败重试", false, 2, null);
            D();
        }
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    @SuppressLint({"MissingPermission"})
    public final void s(WifiP2pConfig.Builder builder) {
        Unit unit;
        WifiP2pManager wifiP2pManagerV;
        WifiP2pManager.Channel channel = this.f59177h;
        if (channel == null || (wifiP2pManagerV = v()) == null) {
            unit = null;
        } else {
            wifiP2pManagerV.createGroup(channel, builder.build(), new WifiP2pManager.ActionListener() { // from class: com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter$createGroupQ$1$1
                @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                public void onFailure(int i11) {
                    com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f59252a, this.f59180a.b() + " --> createWifiP2pGroup() --> createGroup() --> 创建群组失败 -- reason = " + com.transsion.transfer.wifi.util.i.f59253a.b(i11) + " --> 失败重试", false, 2, null);
                    this.f59180a.D();
                }

                @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                public void onSuccess() {
                    com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, this.f59180a.b() + " --> createWifiP2pGroup() --> createGroup() --> onSuccess() --> 创建群组成功", false, 2, null);
                    k0 k0VarC = this.f59180a.c();
                    if (k0VarC != null) {
                        kotlinx.coroutines.j.d(k0VarC, null, null, new P2PWifiAdapter$createGroupQ$1$1$onSuccess$1(this.f59180a, null), 3, null);
                    }
                }
            });
            unit = Unit.f68710a;
        }
        if (unit == null) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> createGroupQ() --> p2pChannel == null --> 失败重试", false, 2, null);
            D();
        }
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final void t() {
        String strP;
        Object objM163constructorimpl;
        String str;
        qy.a aVarE = e();
        if (aVarE == null || (strP = aVarE.p()) == null) {
            strP = "";
        }
        try {
            Result.Companion companion = Result.Companion;
            String strSubstring = com.transsion.transfer.wifi.util.b.f59245a.a(strP).substring(0, 8);
            Intrinsics.f(strSubstring, "substring(...)");
            objM163constructorimpl = Result.m163constructorimpl(strSubstring);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        String str2 = (String) (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null ? objM163constructorimpl : "");
        WifiP2pConfig.Builder passphrase = d.a().setNetworkName(strP).setPassphrase(str2);
        Intrinsics.f(passphrase, "Builder().setNetworkName…iSSID).setPassphrase(pwd)");
        qy.a aVarE2 = e();
        if (aVarE2 == null || !aVarE2.a()) {
            passphrase.setGroupOperatingBand(1);
            str = "2.4G";
        } else {
            passphrase.setGroupOperatingBand(2);
            str = "5G";
        }
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> createWifiP2pGroup() --> API >= 29 -- Android" + Build.VERSION.SDK_INT + "设备(Q及其以上) 创建 --> WIFI名称 = " + strP + " -- 密码 = " + str2 + " -- WIFI频段 = " + str, false, 2, null);
        s(passphrase);
    }

    public final String u(InetAddress inetAddress) {
        WifiUtils wifiUtils = WifiUtils.f59242a;
        String strF = wifiUtils.f(inetAddress);
        if (!TextUtils.isEmpty(strF)) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> getCorrectIp() --> ip --> getCorrectOwnerAddress() = " + strF, false, 2, null);
            return strF;
        }
        String strK = wifiUtils.k();
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> getCorrectIp() --> ip --> localIP() = " + strK, false, 2, null);
        return strK;
    }

    public final WifiP2pManager v() {
        return (WifiP2pManager) this.f59176g.getValue();
    }

    public final void w(int i11) {
        k0 k0VarC = c();
        if (k0VarC != null) {
            kotlinx.coroutines.j.d(k0VarC, null, null, new P2PWifiAdapter$onFail$1(this, i11, null), 3, null);
        }
    }

    public void x() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            com.transsion.transfer.wifi.util.i.f59253a.d(v(), this.f59177h, true, false, false, true);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> releaseWifiP2P() --> 关闭P2P频段异常 -- it = " + thM166exceptionOrNullimpl, false, 2, null);
    }

    public final void y(final WifiP2pGroup wifiP2pGroup) {
        Unit unit;
        WifiP2pManager wifiP2pManagerV;
        WifiP2pManager.Channel channel = this.f59177h;
        if (channel == null || (wifiP2pManagerV = v()) == null) {
            unit = null;
        } else {
            wifiP2pManagerV.requestConnectionInfo(channel, new WifiP2pManager.ConnectionInfoListener() { // from class: com.transsion.transfer.wifi.create.adapter.k
                @Override // android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener
                public final void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
                    P2PWifiAdapter.z(this.f59185a, wifiP2pGroup, wifiP2pInfo);
                }
            });
            unit = Unit.f68710a;
        }
        if (unit == null) {
            com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, b() + " --> requestConnectionInfo() --> p2pChannel == null --> 失败重试 --> retryCreate()", false, 2, null);
            D();
        }
    }
}
