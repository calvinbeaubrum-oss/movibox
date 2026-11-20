package com.cloud.tmc.integration.model;

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
public final class TabBarRedDotMessage extends b {
    private int index;
    private boolean showRedDot;
    private boolean showUnreadIcon;
    private String unreadIcon;

    public TabBarRedDotMessage() {
        this(0, false, null, false, 15, null);
    }

    public TabBarRedDotMessage(int i11, boolean z11, String str, boolean z12) {
        this.index = i11;
        this.showRedDot = z11;
        this.unreadIcon = str;
        this.showUnreadIcon = z12;
    }

    public /* synthetic */ TabBarRedDotMessage(int i11, boolean z11, String str, boolean z12, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i11, (i12 & 2) != 0 ? false : z11, (i12 & 4) != 0 ? null : str, (i12 & 8) != 0 ? false : z12);
    }

    public static /* synthetic */ TabBarRedDotMessage copy$default(TabBarRedDotMessage tabBarRedDotMessage, int i11, boolean z11, String str, boolean z12, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = tabBarRedDotMessage.index;
        }
        if ((i12 & 2) != 0) {
            z11 = tabBarRedDotMessage.showRedDot;
        }
        if ((i12 & 4) != 0) {
            str = tabBarRedDotMessage.unreadIcon;
        }
        if ((i12 & 8) != 0) {
            z12 = tabBarRedDotMessage.showUnreadIcon;
        }
        return tabBarRedDotMessage.copy(i11, z11, str, z12);
    }

    public final int component1() {
        return this.index;
    }

    public final boolean component2() {
        return this.showRedDot;
    }

    public final String component3() {
        return this.unreadIcon;
    }

    public final boolean component4() {
        return this.showUnreadIcon;
    }

    public final TabBarRedDotMessage copy(int i11, boolean z11, String str, boolean z12) {
        return new TabBarRedDotMessage(i11, z11, str, z12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabBarRedDotMessage)) {
            return false;
        }
        TabBarRedDotMessage tabBarRedDotMessage = (TabBarRedDotMessage) obj;
        return this.index == tabBarRedDotMessage.index && this.showRedDot == tabBarRedDotMessage.showRedDot && Intrinsics.b(this.unreadIcon, tabBarRedDotMessage.unreadIcon) && this.showUnreadIcon == tabBarRedDotMessage.showUnreadIcon;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean getShowRedDot() {
        return this.showRedDot;
    }

    public final boolean getShowUnreadIcon() {
        return this.showUnreadIcon;
    }

    public final String getUnreadIcon() {
        return this.unreadIcon;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int i11 = this.index * 31;
        boolean z11 = this.showRedDot;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i12 = (i11 + r11) * 31;
        String str = this.unreadIcon;
        int iHashCode = (i12 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z12 = this.showUnreadIcon;
        return iHashCode + (z12 ? 1 : z12);
    }

    public final void setIndex(int i11) {
        this.index = i11;
    }

    public final void setShowRedDot(boolean z11) {
        this.showRedDot = z11;
    }

    public final void setShowUnreadIcon(boolean z11) {
        this.showUnreadIcon = z11;
    }

    public final void setUnreadIcon(String str) {
        this.unreadIcon = str;
    }

    public String toString() {
        return "TabBarRedDotMessage(index=" + this.index + ", showRedDot=" + this.showRedDot + ", unreadIcon=" + this.unreadIcon + ", showUnreadIcon=" + this.showUnreadIcon + ')';
    }
}
