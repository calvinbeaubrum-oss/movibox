package com.transsion.transfer.wifi.connect.adapter;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.wifi.WifiNetworkSpecifier;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.u;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.bridge.w;
import com.transsion.transfer.wifi.util.g;
import com.vungle.warren.error.VungleException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class WifiNetworkSpecifierAdapter extends BaseWifiConnectAdapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f59163g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f59161e = LazyKt__LazyJVMKt.b(new Function0<ConnectivityManager>() { // from class: com.transsion.transfer.wifi.connect.adapter.WifiNetworkSpecifierAdapter$mConnManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectivityManager invoke() {
            Object systemService = Utils.a().getSystemService("connectivity");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            return (ConnectivityManager) systemService;
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @RequiresApi(23)
    public ConnectivityManager.NetworkCallback f59162f = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f59164h = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Object objM163constructorimpl;
            Unit unit;
            Intrinsics.g(network, "network");
            super.onAvailable(network);
            g.b(g.f59252a, WifiNetworkSpecifierAdapter.this.e() + " --> connect() --> onAvailable() --> WifiNetworkSpecifier connect success", false, 2, null);
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter = WifiNetworkSpecifierAdapter.this;
            try {
                Result.Companion companion = Result.Companion;
                wifiNetworkSpecifierAdapter.p().bindProcessToNetwork(network);
                com.transsion.transfer.wifi.connect.b bVarH = wifiNetworkSpecifierAdapter.h();
                if (bVarH != null) {
                    bVarH.c(null);
                    unit = Unit.f68710a;
                } else {
                    unit = null;
                }
                objM163constructorimpl = Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter2 = WifiNetworkSpecifierAdapter.this;
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl == null) {
                return;
            }
            g.d(g.f59252a, wifiNetworkSpecifierAdapter2.e() + " --> connect() --> onAvailable() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
            com.transsion.transfer.wifi.connect.b bVarH2 = wifiNetworkSpecifierAdapter2.h();
            if (bVarH2 != null) {
                bVarH2.b(2010);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Object objM163constructorimpl;
            Intrinsics.g(network, "network");
            super.onLost(network);
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter = WifiNetworkSpecifierAdapter.this;
            try {
                Result.Companion companion = Result.Companion;
                wifiNetworkSpecifierAdapter.p().bindProcessToNetwork(null);
                g.b(g.f59252a, wifiNetworkSpecifierAdapter.e() + " --> connect() --> onLost() --> bindProcessToNetwork(null) --> success", false, 2, null);
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            WifiNetworkSpecifierAdapter wifiNetworkSpecifierAdapter2 = WifiNetworkSpecifierAdapter.this;
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl != null) {
                g.b(g.f59252a, wifiNetworkSpecifierAdapter2.e() + " --> connect() --> onLost() --> bindProcessToNetwork() --> 发生异常 --> it = " + thM166exceptionOrNullimpl, false, 2, null);
            }
            com.transsion.transfer.wifi.connect.b bVarH = WifiNetworkSpecifierAdapter.this.h();
            if (bVarH != null) {
                bVarH.a(network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            g.b(g.f59252a, WifiNetworkSpecifierAdapter.this.e() + " --> connect() --> onUnavailable() --> 如果在指定的超时时间内没有找到网络，则调用,用户主动取消也调用这个。", false, 2, null);
            com.transsion.transfer.wifi.connect.b bVarH = WifiNetworkSpecifierAdapter.this.h();
            if (bVarH != null) {
                bVarH.b(2011);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements f {
        public b() {
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onCreate(u uVar) {
            e.a(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onDestroy(u uVar) {
            e.b(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onPause(u uVar) {
            e.c(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onResume(u owner) {
            com.transsion.transfer.wifi.connect.b bVarH;
            Intrinsics.g(owner, "owner");
            e.d(this, owner);
            if (!WifiNetworkSpecifierAdapter.this.f59163g || (bVarH = WifiNetworkSpecifierAdapter.this.h()) == null) {
                return;
            }
            bVarH.b(2012);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStart(u uVar) {
            e.e(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onStop(u owner) {
            Intrinsics.g(owner, "owner");
            e.f(this, owner);
            WifiNetworkSpecifierAdapter.this.f59163g = true;
            g.h(g.f59252a, WifiNetworkSpecifierAdapter.this.e() + " --> observer --> onStop() -- isStop = " + WifiNetworkSpecifierAdapter.this.f59163g, false, 2, null);
        }
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    @RequiresApi(23)
    public void c() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            k0 k0VarG = g();
            if (k0VarG != null) {
                j.d(k0VarG, null, null, new WifiNetworkSpecifierAdapter$doClose$1$1(this, null), 3, null);
            }
            p().unregisterNetworkCallback(this.f59162f);
            p().bindProcessToNetwork(null);
            g.h(g.f59252a, e() + " --> close() --> end", false, 2, null);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f59252a, e() + " --> close() --> 发生异常 --> it = " + thM166exceptionOrNullimpl, false, 2, null);
    }

    @Override // com.transsion.transfer.wifi.connect.adapter.BaseWifiConnectAdapter
    @RequiresApi(api = VungleException.INCORRECT_DEFAULT_API_USAGE)
    public void d() {
        String strP;
        String strO;
        g.b(g.f59252a, e() + " --> connect() --> start connect with WifiNetworkSpecifier --> start ....", false, 2, null);
        k0 k0VarG = g();
        if (k0VarG != null) {
            j.d(k0VarG, null, null, new WifiNetworkSpecifierAdapter$doConnect$1(this, null), 3, null);
        }
        WifiNetworkSpecifier.Builder builderA = w.a();
        qy.a aVarI = i();
        String str = "";
        if (aVarI == null || (strP = aVarI.p()) == null) {
            strP = "";
        }
        WifiNetworkSpecifier.Builder ssid = builderA.setSsid(strP);
        Intrinsics.f(ssid, "Builder().setSsid(mWifiInfoModel?.wifiSsid ?: \"\")");
        qy.a aVarI2 = i();
        if (!TextUtils.isEmpty(aVarI2 != null ? aVarI2.o() : null)) {
            qy.a aVarI3 = i();
            if (aVarI3 != null && (strO = aVarI3.o()) != null) {
                str = strO;
            }
            ssid.setWpa2Passphrase(str);
        }
        p().requestNetwork(new NetworkRequest.Builder().addTransportType(1).removeCapability(12).setNetworkSpecifier(com.cloud.tmc.integration.bridge.u.a(ssid.build())).build(), this.f59162f);
    }

    public final ConnectivityManager p() {
        return (ConnectivityManager) this.f59161e.getValue();
    }
}
