package com.cloud.tmc.integration.model;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class TabBarMessageStore extends b {
    private final HashMap<Integer, TabBarBadgeMessage> badgeMessageHashMap;
    private final HashMap<Integer, TabBarRedDotMessage> redDotMessageHashMap;
    private TabBarStyle tabBarStyle;

    public TabBarMessageStore() {
        this(null, null, null, 7, null);
    }

    public TabBarMessageStore(HashMap<Integer, TabBarRedDotMessage> redDotMessageHashMap, HashMap<Integer, TabBarBadgeMessage> badgeMessageHashMap, TabBarStyle tabBarStyle) {
        Intrinsics.g(redDotMessageHashMap, "redDotMessageHashMap");
        Intrinsics.g(badgeMessageHashMap, "badgeMessageHashMap");
        this.redDotMessageHashMap = redDotMessageHashMap;
        this.badgeMessageHashMap = badgeMessageHashMap;
        this.tabBarStyle = tabBarStyle;
    }

    public /* synthetic */ TabBarMessageStore(HashMap map, HashMap map2, TabBarStyle tabBarStyle, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new HashMap() : map, (i11 & 2) != 0 ? new HashMap() : map2, (i11 & 4) != 0 ? null : tabBarStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabBarMessageStore copy$default(TabBarMessageStore tabBarMessageStore, HashMap map, HashMap map2, TabBarStyle tabBarStyle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = tabBarMessageStore.redDotMessageHashMap;
        }
        if ((i11 & 2) != 0) {
            map2 = tabBarMessageStore.badgeMessageHashMap;
        }
        if ((i11 & 4) != 0) {
            tabBarStyle = tabBarMessageStore.tabBarStyle;
        }
        return tabBarMessageStore.copy(map, map2, tabBarStyle);
    }

    public final HashMap<Integer, TabBarRedDotMessage> component1() {
        return this.redDotMessageHashMap;
    }

    public final HashMap<Integer, TabBarBadgeMessage> component2() {
        return this.badgeMessageHashMap;
    }

    public final TabBarStyle component3() {
        return this.tabBarStyle;
    }

    public final TabBarMessageStore copy(HashMap<Integer, TabBarRedDotMessage> redDotMessageHashMap, HashMap<Integer, TabBarBadgeMessage> badgeMessageHashMap, TabBarStyle tabBarStyle) {
        Intrinsics.g(redDotMessageHashMap, "redDotMessageHashMap");
        Intrinsics.g(badgeMessageHashMap, "badgeMessageHashMap");
        return new TabBarMessageStore(redDotMessageHashMap, badgeMessageHashMap, tabBarStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabBarMessageStore)) {
            return false;
        }
        TabBarMessageStore tabBarMessageStore = (TabBarMessageStore) obj;
        return Intrinsics.b(this.redDotMessageHashMap, tabBarMessageStore.redDotMessageHashMap) && Intrinsics.b(this.badgeMessageHashMap, tabBarMessageStore.badgeMessageHashMap) && Intrinsics.b(this.tabBarStyle, tabBarMessageStore.tabBarStyle);
    }

    public final HashMap<Integer, TabBarBadgeMessage> getBadgeMessageHashMap() {
        return this.badgeMessageHashMap;
    }

    public final HashMap<Integer, TabBarRedDotMessage> getRedDotMessageHashMap() {
        return this.redDotMessageHashMap;
    }

    public final TabBarStyle getTabBarStyle() {
        return this.tabBarStyle;
    }

    public int hashCode() {
        int iHashCode = ((this.redDotMessageHashMap.hashCode() * 31) + this.badgeMessageHashMap.hashCode()) * 31;
        TabBarStyle tabBarStyle = this.tabBarStyle;
        return iHashCode + (tabBarStyle == null ? 0 : tabBarStyle.hashCode());
    }

    public final void setTabBarStyle(TabBarStyle tabBarStyle) {
        this.tabBarStyle = tabBarStyle;
    }

    public String toString() {
        return "TabBarMessageStore(redDotMessageHashMap=" + this.redDotMessageHashMap + ", badgeMessageHashMap=" + this.badgeMessageHashMap + ", tabBarStyle=" + this.tabBarStyle + ')';
    }
}
