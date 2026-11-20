package com.transsion.transfer.wifi.connect.adapter;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Handler;
import android.os.Looper;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.g;
import com.transsion.transfer.wifi.util.i;
import java.net.InetAddress;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;

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
public final class DirectConnectAdapter extends BaseWifiConnectAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WifiP2PReceive f59149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WifiP2pManager.Channel f59150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WifiP2pDevice f59151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InetAddress f59152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f59153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f59154k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f59158o;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f59148e = LazyKt__LazyJVMKt.b(new Function0<WifiP2pManager>() { // from class: com.transsion.transfer.wifi.connect.adapter.DirectConnectAdapter$mWifiP2pManager$2
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

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f59155l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f59156m = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Runnable f59157n = new Runnable() { // from class: com.transsion.transfer.wifi.connect.adapter.b
        @Override // java.lang.Runnable
        public final void run() {
            DirectConnectAdapter.G(this.f59168a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class WifiP2PReceive extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function2<? super Context, ? super Intent, Unit> f59159a;

        public final void a(Function2<? super Context, ? super Intent, Unit> callback) {
            Intrinsics.g(callback, "callback");
            this.f59159a = callback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Function2<? super Context, ? super Intent, Unit> function2 = this.f59159a;
            if (function2 != null) {
                function2.invoke(context, intent);
            }
        }
    }

    public DirectConnectAdapter() {
        WifiP2pManager wifiP2pManagerY = y();
        this.f59150g = wifiP2pManagerY != null ? wifiP2pManagerY.initialize(Utils.a(), Looper.getMainLooper(), null) : null;
    }

    public static final void F(DirectConnectAdapter this$0, WifiP2pInfo wifiP2pInfo) {
        Intrinsics.g(this$0, "this$0");
        g gVar = g.f59252a;
        g.b(gVar, this$0.e() + " --> requestConnectionInfo() --> start --> info = " + wifiP2pInfo, false, 2, null);
        if (wifiP2pInfo == null) {
            k0 k0VarG = this$0.g();
            if (k0VarG != null) {
                j.d(k0VarG, null, null, new DirectConnectAdapter$requestConnectionInfo$1$1$2(this$0, null), 3, null);
                return;
            }
            return;
        }
        if (!wifiP2pInfo.groupFormed) {
            k0 k0VarG2 = this$0.g();
            if (k0VarG2 != null) {
                j.d(k0VarG2, null, null, new DirectConnectAdapter$requestConnectionInfo$1$1$1(this$0, null), 3, null);
                return;
            }
            return;
        }
        this$0.f59152i = wifiP2pInfo.groupOwnerAddress;
        g.b(gVar, this$0.e() + " --> requestConnectionInfo() --> start --> 11111", false, 2, null);
        this$0.A();
    }

    public static final void G(DirectConnectAdapter this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.z(2022);
    }

    public final void A() {
        g.b(g.f59252a, e() + " --> onSuccess() --> mAddress = " + this.f59152i, false, 2, null);
        this.f59158o = true;
        this.f59156m.removeCallbacks(this.f59157n);
        com.transsion.transfer.wifi.connect.b bVarH = h();
        if (bVarH != null) {
            bVarH.c(this.f59152i);
        }
    }

    public final void B(Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case -1772632330:
                    if (action.equals("android.net.wifi.p2p.CONNECTION_STATE_CHANGE")) {
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        g gVar = g.f59252a;
                        g.b(gVar, e() + " --> registerReceiver() --> onReceive() --> networkInfo = " + networkInfo, false, 2, null);
                        if (networkInfo != null && networkInfo.isConnected()) {
                            g.b(gVar, e() + " --> registerReceiver() --> onReceive() --> 已连接到对等设备 --> requestConnectionInfo()", false, 2, null);
                            WifiP2pGroup wifiP2pGroup = (WifiP2pGroup) intent.getParcelableExtra("p2pGroupInfo");
                            if (wifiP2pGroup != null) {
                                this.f59151h = wifiP2pGroup.getOwner();
                            }
                            WifiP2pInfo wifiP2pInfo = (WifiP2pInfo) intent.getParcelableExtra("wifiP2pInfo");
                            if (wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                                this.f59152i = wifiP2pInfo.groupOwnerAddress;
                                A();
                            } else {
                                E();
                            }
                        } else if ((networkInfo != null ? networkInfo.getState() : null) == NetworkInfo.State.DISCONNECTED) {
                            this.f59153j = false;
                            D();
                        }
                        break;
                    }
                    break;
                case -1566767901:
                    if (action.equals("android.net.wifi.p2p.THIS_DEVICE_CHANGED")) {
                        WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) intent.getParcelableExtra("wifiP2pDevice");
                        g.b(g.f59252a, e() + " --> registerReceiver() --> onReceive() --> 本设备的 Wi-Fi 状态已更改 --> CONNECTED = 0｜INVITED = 1｜FAILED = 2｜AVAILABLE = 3｜UNAVAILABLE = 4 --> " + (wifiP2pDevice != null ? Integer.valueOf(wifiP2pDevice.status) : null) + " ", false, 2, null);
                        break;
                    }
                    break;
                case -1394739139:
                    action.equals("android.net.wifi.p2p.PEERS_CHANGED");
                    break;
                case 1695662461:
                    if (action.equals("android.net.wifi.p2p.STATE_CHANGED")) {
                        if (intent.getIntExtra("wifi_p2p_state", -1) != 2) {
                            g.b(g.f59252a, e() + " --> registerReceiver() --> onReceive() --> Wi-Fi P2P 未启用 -- Wi-Fi P2P is not enabled.", false, 2, null);
                        } else {
                            g.b(g.f59252a, e() + " --> registerReceiver() --> onReceive() --> Wi-Fi P2P 已启用 -- Wi-Fi P2P is enabled.", false, 2, null);
                        }
                        break;
                    }
                    break;
            }
        }
    }

    public final void C() {
        if (this.f59149f == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.PEERS_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
            WifiP2PReceive wifiP2PReceive = new WifiP2PReceive();
            this.f59149f = wifiP2PReceive;
            wifiP2PReceive.a(new Function2<Context, Intent, Unit>() { // from class: com.transsion.transfer.wifi.connect.adapter.DirectConnectAdapter$registerReceiver$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Context context, Intent intent) {
                    invoke2(context, intent);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Context context, Intent intent) {
                    if (!this.this$0.f59158o) {
                        this.this$0.B(intent);
                        return;
                    }
                    g.b(g.f59252a, this.this$0.e() + " --> isSuccess = " + this.this$0.f59158o + " --> 如果已经连接成功了，后续的广播就不再处理了， 这一个操作是为了兼容业务 --> 这里将导致断开重连功能失效", false, 2, null);
                }
            });
            Utils.a().registerReceiver(this.f59149f, intentFilter);
            g.b(g.f59252a, e() + " --> registerReceiver() --> 广播注册成功", false, 2, null);
        }
    }

    public final void D() {
        if (this.f59153j) {
            g.d(g.f59252a, e() + " --> requestConnect() --> mConnecting = " + this.f59153j, false, 2, null);
            return;
        }
        int i11 = this.f59154k;
        if (i11 >= this.f59155l) {
            g.b(g.f59252a, e() + " --> requestConnect() --> connectRetry = " + this.f59154k + " --> retryCount = " + this.f59155l + " --> 重试次数用完了,请求失败", false, 2, null);
            z(2020);
            return;
        }
        int i12 = i11 + 1;
        this.f59154k = i12;
        if (i12 == 5) {
            k0 k0VarG = g();
            if (k0VarG != null) {
                j.d(k0VarG, null, null, new DirectConnectAdapter$requestConnect$1(this, null), 3, null);
                return;
            }
            return;
        }
        g.b(g.f59252a, e() + " --> requestConnect() --> connectRetry = " + this.f59154k + " --> retryCount = " + this.f59155l, false, 2, null);
        x();
    }

    public final void E() {
        WifiP2pManager wifiP2pManagerY;
        Unit unit = null;
        g.b(g.f59252a, e() + " --> requestConnectionInfo() --> start...", false, 2, null);
        WifiP2pManager.Channel channel = this.f59150g;
        if (channel != null && (wifiP2pManagerY = y()) != null) {
            wifiP2pManagerY.requestConnectionInfo(channel, new WifiP2pManager.ConnectionInfoListener() { // from class: com.transsion.transfer.wifi.connect.adapter.a
                @Override // android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener
                public final void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
                    DirectConnectAdapter.F(this.f59167a, wifiP2pInfo);
                }
            });
            unit = Unit.f68710a;
        }
        if (unit == null) {
            z(2023);
        }
    }

    public final void H() {
        WifiP2PReceive wifiP2PReceive = this.f59149f;
        if (wifiP2PReceive != null) {
            Utils.a().unregisterReceiver(wifiP2PReceive);
            g.b(g.f59252a, e() + " --> unregisterReceiver() --> success", false, 2, null);
        }
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    public void c() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            this.f59156m.removeCallbacksAndMessages(null);
            this.f59151h = null;
            this.f59152i = null;
            this.f59154k = 0;
            this.f59153j = false;
            i.f59253a.d(y(), this.f59150g, (60 & 4) != 0, (60 & 8) != 0, (60 & 16) != 0, (60 & 32) != 0);
            this.f59150g = null;
            H();
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f59252a, e() + " --> stop() --> p2p stop Exception = " + thM166exceptionOrNullimpl, false, 2, null);
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    public void d() {
        g.b(g.f59252a, e() + " --> start() --> 开启直连....", false, 2, null);
        C();
        D();
        this.f59156m.postDelayed(this.f59157n, 90000L);
    }

    @SuppressLint({"MissingPermission"})
    public final void x() {
        this.f59153j = true;
        WifiP2pManager.Channel channel = this.f59150g;
        Unit unit = null;
        if (channel != null) {
            WifiP2pManager wifiP2pManagerY = y();
            if (wifiP2pManagerY != null) {
                wifiP2pManagerY.cancelConnect(channel, null);
            }
            WifiP2pConfig wifiP2pConfigE = WifiUtils.f59242a.e(i(), this.f59151h);
            if (wifiP2pConfigE == null) {
                z(2021);
                return;
            }
            g.b(g.f59252a, e() + " --> connectP2P() --> 开始连接 --> mWifiP2pManager.connect()", false, 2, null);
            WifiP2pManager wifiP2pManagerY2 = y();
            if (wifiP2pManagerY2 != null) {
                wifiP2pManagerY2.connect(channel, wifiP2pConfigE, new WifiP2pManager.ActionListener() { // from class: com.transsion.transfer.wifi.connect.adapter.DirectConnectAdapter$connectP2P$1$1
                    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                    public void onFailure(int i11) {
                        g.d(g.f59252a, this.f59160a.e() + " --> connectP2P() --> onFailure() --> reason = " + i11 + " --> 重试", false, 2, null);
                        this.f59160a.f59153j = false;
                        k0 k0VarG = this.f59160a.g();
                        if (k0VarG != null) {
                            j.d(k0VarG, null, null, new DirectConnectAdapter$connectP2P$1$1$onFailure$1(this.f59160a, null), 3, null);
                        }
                    }

                    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                    public void onSuccess() {
                        g.b(g.f59252a, this.f59160a.e() + " --> connectP2P() --> onSuccess() --> 等待广播通知", false, 2, null);
                    }
                });
                unit = Unit.f68710a;
            }
        }
        if (unit == null) {
            z(2023);
        }
    }

    public final WifiP2pManager y() {
        return (WifiP2pManager) this.f59148e.getValue();
    }

    public final void z(int i11) {
        g.d(g.f59252a, e() + " --> onFail() --> reason = " + i11, false, 2, null);
        this.f59156m.removeCallbacks(this.f59157n);
        com.transsion.transfer.wifi.connect.b bVarH = h();
        if (bVarH != null) {
            bVarH.b(i11);
        }
    }
}
