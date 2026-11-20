package com.tmc.network.strategy;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class StrategyTable implements Serializable {
    public static final a Companion = new a(null);
    private static final transient long MAX_VALID_TIME = 259200000;
    private static final long serialVersionUID = 1;
    private ConcurrentHashMap<String, Long> historyMap;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<InetAddress>> hostConnMap;
    private String networkId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StrategyTable(String networkId) {
        Intrinsics.g(networkId, "networkId");
        this.networkId = networkId;
        this.hostConnMap = new ConcurrentHashMap<>();
        this.historyMap = new ConcurrentHashMap<>();
    }

    public final void addStrategyList(String host, List<? extends InetAddress> ips) {
        Intrinsics.g(host, "host");
        Intrinsics.g(ips, "ips");
        this.hostConnMap.put(host, new CopyOnWriteArrayList<>(ips));
        this.historyMap.put(host, Long.valueOf(System.currentTimeMillis()));
    }

    public final boolean checkIsExpire(String host) {
        Intrinsics.g(host, "host");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l11 = this.historyMap.get(host);
        return l11 != null && Math.abs(jCurrentTimeMillis - l11.longValue()) >= MAX_VALID_TIME;
    }

    public final StrategyTable convertTable(StrategyTable table) {
        Intrinsics.g(table, "table");
        for (Map.Entry<String, CopyOnWriteArrayList<InetAddress>> entry : table.hostConnMap.entrySet()) {
            if (getHostConnMap().get(entry.getKey()) == null) {
                getHostConnMap().put(entry.getKey(), entry.getValue());
                Long lValueOf = table.getHistoryMap().get(entry.getKey());
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(System.currentTimeMillis());
                }
                getHistoryMap().put(entry.getKey(), Long.valueOf(lValueOf.longValue()));
            }
        }
        return this;
    }

    public final ConcurrentHashMap<String, Long> getHistoryMap() {
        return this.historyMap;
    }

    public final ConcurrentHashMap<String, CopyOnWriteArrayList<InetAddress>> getHostConnMap() {
        return this.hostConnMap;
    }

    public final String getNetworkId() {
        return this.networkId;
    }

    public final List<InetAddress> queryStrategyList(String host) {
        Intrinsics.g(host, "host");
        CopyOnWriteArrayList<InetAddress> copyOnWriteArrayList = this.hostConnMap.get(host);
        return copyOnWriteArrayList == null ? g.l() : new CopyOnWriteArrayList(copyOnWriteArrayList);
    }

    public final void removeExpired() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<String, Long> entry : this.historyMap.entrySet()) {
            if (Math.abs(jCurrentTimeMillis - entry.getValue().longValue()) >= MAX_VALID_TIME) {
                getHostConnMap().remove(entry.getKey());
                getHistoryMap().remove(entry.getKey());
            }
        }
    }

    public final void removeStrategy(String host) {
        Intrinsics.g(host, "host");
        this.hostConnMap.remove(host);
        this.historyMap.remove(host);
    }

    public final void removeStrategy(String host, InetAddress address) {
        Intrinsics.g(host, "host");
        Intrinsics.g(address, "address");
        CopyOnWriteArrayList<InetAddress> copyOnWriteArrayList = this.hostConnMap.get(host);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(address);
        if (copyOnWriteArrayList.isEmpty()) {
            this.hostConnMap.remove(host);
            this.historyMap.remove(host);
        }
    }

    public final void setHistoryMap(ConcurrentHashMap<String, Long> concurrentHashMap) {
        Intrinsics.g(concurrentHashMap, "<set-?>");
        this.historyMap = concurrentHashMap;
    }

    public final void setHostConnMap(ConcurrentHashMap<String, CopyOnWriteArrayList<InetAddress>> concurrentHashMap) {
        Intrinsics.g(concurrentHashMap, "<set-?>");
        this.hostConnMap = concurrentHashMap;
    }

    public final void setNetworkId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.networkId = str;
    }

    public String toString() {
        return "StrategyTable(networkId='" + this.networkId + "', hostConnMap=" + this.hostConnMap + ", historyMap=" + this.historyMap + ')';
    }
}
