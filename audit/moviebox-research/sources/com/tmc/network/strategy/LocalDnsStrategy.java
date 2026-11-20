package com.tmc.network.strategy;

import android.content.Context;
import com.applovin.sdk.AppLovinMediationProvider;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tmc.network.NetworkConfig;
import com.tmc.network.NetworkMonitor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Dns;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LocalDnsStrategy implements Dns {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f49355c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static AtomicBoolean f49356d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, StrategyTable> f49357a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f49358b = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalDnsStrategy a() {
            return b.f49359a.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f49359a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final LocalDnsStrategy f49360b = new LocalDnsStrategy();

        public final LocalDnsStrategy a() {
            return f49360b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class c implements NetworkMonitor.INetworkChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalDnsStrategy f49361a;

        public c(LocalDnsStrategy this$0) {
            Intrinsics.g(this$0, "this$0");
            this.f49361a = this$0;
        }

        @Override // com.tmc.network.NetworkMonitor.INetworkChangeListener
        public void onNetworkChanged(NetworkMonitor.NetworkStatus status) {
            Intrinsics.g(status, "status");
            this.f49361a.j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(Ref.ObjectRef table, String host, LocalDnsStrategy this$0) {
        Intrinsics.g(table, "$table");
        Intrinsics.g(host, "$host");
        Intrinsics.g(this$0, "this$0");
        try {
            if (((StrategyTable) table.element).checkIsExpire(host)) {
                ((StrategyTable) table.element).removeStrategy(host);
                InetAddress[] ips = InetAddress.getAllByName(host);
                if (ips != null && ips.length != 0) {
                    StrategyTable strategyTable = (StrategyTable) table.element;
                    Intrinsics.f(ips, "ips");
                    strategyTable.addStrategyList(host, kotlin.collections.d.D0(ips));
                    this$0.l();
                }
            }
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }

    public static final void k(String netId, LocalDnsStrategy this$0) {
        Intrinsics.g(netId, "$netId");
        Intrinsics.g(this$0, "this$0");
        if (Intrinsics.b(netId, AppLovinMediationProvider.UNKNOWN)) {
            po.b.f73956a.c("network is invalid.");
            return;
        }
        oo.b bVar = oo.b.f72499a;
        StrategyTable strategyTable = (StrategyTable) bVar.l(netId);
        if (strategyTable == null) {
            return;
        }
        strategyTable.removeExpired();
        StrategyTable strategyTable2 = this$0.f49357a.get(netId);
        if (strategyTable2 != null) {
            strategyTable.convertTable(strategyTable2);
        }
        this$0.f49357a.put(netId, strategyTable);
        po.b.f73956a.c(Intrinsics.p("restore file ", strategyTable));
        bVar.j();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10, types: [T, com.tmc.network.strategy.StrategyTable, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final List<InetAddress> f(final String str) {
        try {
            String networkId = NetworkMonitor.INSTANCE.getNetworkId();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? r11 = this.f49357a.get(networkId);
            objectRef.element = r11;
            if (r11 == 0) {
                ?? strategyTable = new StrategyTable(networkId);
                objectRef.element = strategyTable;
                this.f49357a.put(networkId, (StrategyTable) strategyTable);
            }
            List<InetAddress> listQueryStrategyList = ((StrategyTable) objectRef.element).queryStrategyList(str);
            List<InetAddress> list = listQueryStrategyList;
            if (list != null && !list.isEmpty()) {
                po.c cVarA = po.c.f73961c.a();
                if (cVarA != null) {
                    cVarA.a(new Runnable() { // from class: com.tmc.network.strategy.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocalDnsStrategy.g(objectRef, str, this);
                        }
                    });
                }
                return listQueryStrategyList;
            }
            InetAddress[] ips = InetAddress.getAllByName(str);
            if (ips != null && ips.length != 0) {
                StrategyTable strategyTable2 = (StrategyTable) objectRef.element;
                Intrinsics.f(ips, "ips");
                strategyTable2.addStrategyList(str, kotlin.collections.d.D0(ips));
                l();
                return kotlin.collections.d.A0(ips);
            }
            return null;
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
            return null;
        }
    }

    public final void h(Context context) {
        Intrinsics.g(context, "context");
        try {
            if (this.f49358b.compareAndSet(false, true)) {
                j();
                NetworkMonitor.INSTANCE.registerListener(new c(this));
            }
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }

    public final void i(String host, InetAddress address) {
        Intrinsics.g(host, "host");
        Intrinsics.g(address, "address");
        try {
            StrategyTable strategyTable = this.f49357a.get(NetworkMonitor.INSTANCE.getNetworkId());
            if (strategyTable == null) {
                return;
            }
            strategyTable.removeStrategy(host, address);
            l();
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }

    public final void j() {
        final String networkId = NetworkMonitor.INSTANCE.getNetworkId();
        if (this.f49357a.get(networkId) != null) {
            po.b.f73956a.c("map already has this strategy.");
            return;
        }
        po.c cVarA = po.c.f73961c.a();
        if (cVarA == null) {
            return;
        }
        cVarA.b(new Runnable() { // from class: com.tmc.network.strategy.a
            @Override // java.lang.Runnable
            public final void run() {
                LocalDnsStrategy.k(networkId, this);
            }
        });
    }

    public final void l() {
        po.c cVarA;
        if (!f49356d.compareAndSet(false, true) || (cVarA = po.c.f73961c.a()) == null) {
            return;
        }
        cVarA.d(new Runnable() { // from class: com.tmc.network.strategy.LocalDnsStrategy$updateLocalDnsStrategy$1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LocalDnsStrategy.f49356d.set(false);
                    String networkId = NetworkMonitor.INSTANCE.getNetworkId();
                    StrategyTable strategyTable = (StrategyTable) this.this$0.f49357a.get(networkId);
                    if (strategyTable == null) {
                        return;
                    }
                    po.b.f73956a.c(Intrinsics.p("updateLocalDnsStrategy  table = ", strategyTable));
                    oo.b.f72499a.i(strategyTable, networkId);
                } catch (Throwable th2) {
                    po.b.f73956a.e(th2);
                }
            }
        }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, TimeUnit.MILLISECONDS);
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String hostname) throws UnknownHostException {
        Intrinsics.g(hostname, "hostname");
        if (this.f49358b.get() && NetworkConfig.INSTANCE.isNetworkImproveEnable()) {
            List<InetAddress> listF = f(hostname);
            if (listF != null) {
                return listF;
            }
            throw new UnknownHostException(hostname);
        }
        try {
            return Dns.SYSTEM.lookup(hostname);
        } catch (Throwable th2) {
            po.b.f73956a.d("LocalDnsStrategy", th2.getMessage());
            throw new UnknownHostException(hostname);
        }
    }
}
