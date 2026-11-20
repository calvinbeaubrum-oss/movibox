package com.tn.lib.util.networkinfo;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.blankj.utilcode.util.Utils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class NetWorkCallback extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f49460g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy<Handler> f49461h = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.tn.lib.util.networkinfo.NetWorkCallback$Companion$mHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<NetWorkCallback> f49462i = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<NetWorkCallback>() { // from class: com.tn.lib.util.networkinfo.NetWorkCallback$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NetWorkCallback invoke() {
            return new NetWorkCallback();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Boolean f49464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Boolean f49465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NetworkType f49466d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<g> f49463a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f49467e = new Function0<Unit>() { // from class: com.tn.lib.util.networkinfo.NetWorkCallback$lostRunnable$1
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
            f fVar = f.f49475a;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            boolean zJ = fVar.j(applicationA);
            NetWorkCallback netWorkCallback = this.this$0;
            Application applicationA2 = Utils.a();
            Intrinsics.f(applicationA2, "getApp()");
            netWorkCallback.f49465c = Boolean.valueOf(fVar.i(applicationA2));
            int iW = this.this$0.w();
            if (!zJ) {
                this.this$0.D();
                uo.b.f78622a.n("net_log", new String[]{this.this$0.v() + " --> onLost() --> disposeOnLost --> lostRunnable --> networkConnected = " + zJ + " netState = " + iW + " -- 网络断开了 "}, true);
                CopyOnWriteArrayList<g> copyOnWriteArrayList = this.this$0.f49463a;
                NetWorkCallback netWorkCallback2 = this.this$0;
                for (g gVar : copyOnWriteArrayList) {
                    if (Intrinsics.b(netWorkCallback2.f49464b, Boolean.FALSE)) {
                        gVar.onDisconnected();
                    }
                }
                return;
            }
            this.this$0.f49464b = Boolean.TRUE;
            uo.b.f78622a.n("net_log", new String[]{this.this$0.v() + " --> onLost() --> disposeOnLost --> lostRunnable --> networkConnected = " + zJ + " netState = " + iW + " --  网络重新连接了"}, true);
            CopyOnWriteArrayList<g> copyOnWriteArrayList2 = this.this$0.f49463a;
            NetWorkCallback netWorkCallback3 = this.this$0;
            for (g gVar2 : copyOnWriteArrayList2) {
                if (Intrinsics.b(netWorkCallback3.f49464b, Boolean.TRUE)) {
                    gVar2.onConnected();
                }
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f49468f = new Function0<Unit>() { // from class: com.tn.lib.util.networkinfo.NetWorkCallback$timerRunnable$1
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
            NetWorkCallback netWorkCallback = this.this$0;
            f fVar = f.f49475a;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            netWorkCallback.f49465c = Boolean.valueOf(fVar.i(applicationA));
            uo.b.a.o(uo.b.f78622a, "net_log", new String[]{this.this$0.v() + " --> timerRunnable --> isValidated = " + this.this$0.f49465c}, false, 4, null);
            this.this$0.E();
        }
    };

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NetWorkCallback a() {
            return (NetWorkCallback) NetWorkCallback.f49462i.getValue();
        }

        public final Handler b() {
            return (Handler) NetWorkCallback.f49461h.getValue();
        }
    }

    public static final void F(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void p(NetWorkCallback this$0, Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(network, "$network");
        Intrinsics.g(networkCapabilities, "$networkCapabilities");
        for (g gVar : this$0.f49463a) {
            if (Intrinsics.b(this$0.f49464b, Boolean.TRUE)) {
                gVar.onConnected(network, networkCapabilities);
            }
        }
    }

    public static final void s(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void t(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final boolean A() {
        if (this.f49465c != null) {
            return Intrinsics.b(this.f49465c, Boolean.TRUE);
        }
        f fVar = f.f49475a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        return fVar.i(applicationA);
    }

    public final void B() {
        Context applicationContext;
        Application applicationA = Utils.a();
        Object systemService = (applicationA == null || (applicationContext = applicationA.getApplicationContext()) == null) ? null : applicationContext.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager != null) {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this);
        }
        E();
    }

    public final void C(g gVar) {
        if (gVar == null || this.f49463a.contains(gVar)) {
            return;
        }
        this.f49463a.add(gVar);
    }

    public final void D() {
        Boolean bool = Boolean.FALSE;
        this.f49464b = bool;
        this.f49465c = bool;
        this.f49466d = null;
    }

    public final void E() {
        uo.b.a.o(uo.b.f78622a, "net_log", new String[]{v() + " --> startTimer() --> 开启定时任务"}, false, 4, null);
        Handler handlerB = f49460g.b();
        final Function0<Unit> function0 = this.f49468f;
        handlerB.postDelayed(new Runnable() { // from class: com.tn.lib.util.networkinfo.b
            @Override // java.lang.Runnable
            public final void run() {
                NetWorkCallback.F(function0);
            }
        }, 120000L);
    }

    public final void G(g gVar) {
        if (gVar != null) {
            this.f49463a.remove(gVar);
        }
    }

    public final void o(final Network network, final NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.hasCapability(12)) {
            Boolean bool = this.f49464b;
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.b(bool, bool2)) {
                return;
            }
            this.f49464b = bool2;
            uo.b.f78622a.n("net_log", new String[]{v() + " --> onCapabilitiesChanged --> disposeConnect --> 表示是否连接上了互联网（不关心是否可以上网"}, true);
            f49460g.b().post(new Runnable() { // from class: com.tn.lib.util.networkinfo.e
                @Override // java.lang.Runnable
                public final void run() {
                    NetWorkCallback.p(this.f49472a, network, networkCapabilities);
                }
            });
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        Intrinsics.g(network, "network");
        super.onAvailable(network);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onBlockedStatusChanged(Network network, boolean z11) {
        Intrinsics.g(network, "network");
        super.onBlockedStatusChanged(network, z11);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Object objM163constructorimpl;
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        super.onCapabilitiesChanged(network, networkCapabilities);
        try {
            Result.Companion companion = Result.Companion;
            o(network, networkCapabilities);
            u(networkCapabilities);
            q(networkCapabilities);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        uo.b.a.j(uo.b.f78622a, "net_log", v() + " --> it = " + thM166exceptionOrNullimpl, false, 4, null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        Intrinsics.g(network, "network");
        Intrinsics.g(linkProperties, "linkProperties");
        super.onLinkPropertiesChanged(network, linkProperties);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLosing(Network network, int i11) {
        Intrinsics.g(network, "network");
        super.onLosing(network, i11);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics.g(network, "network");
        super.onLost(network);
        r();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        super.onUnavailable();
    }

    public final void q(NetworkCapabilities networkCapabilities) {
        NetworkType networkTypeX;
        if (networkCapabilities.hasTransport(1)) {
            networkTypeX = NetworkType.NETWORK_WIFI;
        } else {
            networkTypeX = networkCapabilities.hasTransport(0) ? x() : NetworkType.NETWORK_UNKNOWN;
        }
        if (this.f49466d == networkTypeX) {
            return;
        }
        this.f49466d = networkTypeX;
        uo.b.f78622a.n("net_log", new String[]{"当前网络类型是 mNetworkType = " + networkTypeX}, true);
    }

    public final void r() {
        a aVar = f49460g;
        Handler handlerB = aVar.b();
        final Function0<Unit> function0 = this.f49467e;
        handlerB.removeCallbacks(new Runnable() { // from class: com.tn.lib.util.networkinfo.c
            @Override // java.lang.Runnable
            public final void run() {
                NetWorkCallback.s(function0);
            }
        });
        Handler handlerB2 = aVar.b();
        final Function0<Unit> function1 = this.f49467e;
        handlerB2.postDelayed(new Runnable() { // from class: com.tn.lib.util.networkinfo.d
            @Override // java.lang.Runnable
            public final void run() {
                NetWorkCallback.t(function1);
            }
        }, 1000L);
    }

    public final void u(NetworkCapabilities networkCapabilities) {
        this.f49465c = Build.VERSION.SDK_INT >= 23 ? Boolean.valueOf(networkCapabilities.hasCapability(16)) : Boolean.TRUE;
        uo.b.f78622a.n("net_log", new String[]{v() + " --> disposeValidated() --> isValidated = " + this.f49465c + " netState = " + w()}, true);
    }

    public final String v() {
        String simpleName = NetWorkCallback.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final int w() {
        if (z() && A()) {
            return 2;
        }
        if (z()) {
            return 1;
        }
        return !z() ? 0 : 3;
    }

    @SuppressLint({"MissingPermission"})
    public final NetworkType x() {
        if (Build.VERSION.SDK_INT >= 24 && z2.a.checkSelfPermission(Utils.a(), "android.permission.READ_PHONE_STATE") == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.a().getSystemService("phone");
            Integer numValueOf = telephonyManager != null ? Integer.valueOf(telephonyManager.getDataNetworkType()) : null;
            if ((numValueOf != null && numValueOf.intValue() == 1) || ((numValueOf != null && numValueOf.intValue() == 2) || ((numValueOf != null && numValueOf.intValue() == 4) || ((numValueOf != null && numValueOf.intValue() == 11) || (numValueOf != null && numValueOf.intValue() == 7))))) {
                return NetworkType.NETWORK_2G;
            }
            if ((numValueOf != null && numValueOf.intValue() == 5) || ((numValueOf != null && numValueOf.intValue() == 6) || ((numValueOf != null && numValueOf.intValue() == 12) || ((numValueOf != null && numValueOf.intValue() == 8) || ((numValueOf != null && numValueOf.intValue() == 9) || ((numValueOf != null && numValueOf.intValue() == 10) || ((numValueOf != null && numValueOf.intValue() == 15) || (numValueOf != null && numValueOf.intValue() == 14)))))))) {
                return NetworkType.NETWORK_3G;
            }
            if ((numValueOf != null && numValueOf.intValue() == 13) || (numValueOf != null && numValueOf.intValue() == 19)) {
                return NetworkType.NETWORK_4G;
            }
            if (numValueOf != null && numValueOf.intValue() == 20) {
                return NetworkType.NETWORK_5G;
            }
            return (numValueOf != null && numValueOf.intValue() == 0) ? NetworkType.NETWORK_UNKNOWN : NetworkType.NETWORK_UNKNOWN;
        }
        return f.f49475a.d();
    }

    public final NetworkType y() {
        NetworkType networkType = this.f49466d;
        if (networkType != null) {
            return networkType;
        }
        f fVar = f.f49475a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        if (fVar.k(applicationA)) {
            NetworkType networkType2 = NetworkType.NETWORK_WIFI;
            this.f49466d = networkType2;
            return networkType2;
        }
        NetworkType networkTypeX = x();
        this.f49466d = networkTypeX;
        return networkTypeX;
    }

    public final boolean z() {
        if (this.f49464b == null) {
            f fVar = f.f49475a;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return fVar.j(applicationA);
        }
        if (!Intrinsics.b(this.f49464b, Boolean.FALSE)) {
            return Intrinsics.b(this.f49464b, Boolean.TRUE);
        }
        f fVar2 = f.f49475a;
        Application applicationA2 = Utils.a();
        Intrinsics.f(applicationA2, "getApp()");
        return fVar2.j(applicationA2);
    }
}
