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
public final class TabBarBadgeMessage extends b {
    private int index;
    private boolean showBadge;
    private String text;

    public TabBarBadgeMessage() {
        this(0, false, null, 7, null);
    }

    public TabBarBadgeMessage(int i11, boolean z11, String str) {
        this.index = i11;
        this.showBadge = z11;
        this.text = str;
    }

    public /* synthetic */ TabBarBadgeMessage(int i11, boolean z11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i11, (i12 & 2) != 0 ? false : z11, (i12 & 4) != 0 ? null : str);
    }

    public static /* synthetic */ TabBarBadgeMessage copy$default(TabBarBadgeMessage tabBarBadgeMessage, int i11, boolean z11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = tabBarBadgeMessage.index;
        }
        if ((i12 & 2) != 0) {
            z11 = tabBarBadgeMessage.showBadge;
        }
        if ((i12 & 4) != 0) {
            str = tabBarBadgeMessage.text;
        }
        return tabBarBadgeMessage.copy(i11, z11, str);
    }

    public final int component1() {
        return this.index;
    }

    public final boolean component2() {
        return this.showBadge;
    }

    public final String component3() {
        return this.text;
    }

    public final TabBarBadgeMessage copy(int i11, boolean z11, String str) {
        return new TabBarBadgeMessage(i11, z11, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabBarBadgeMessage)) {
            return false;
        }
        TabBarBadgeMessage tabBarBadgeMessage = (TabBarBadgeMessage) obj;
        return this.index == tabBarBadgeMessage.index && this.showBadge == tabBarBadgeMessage.showBadge && Intrinsics.b(this.text, tabBarBadgeMessage.text);
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean getShowBadge() {
        return this.showBadge;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int i11 = this.index * 31;
        boolean z11 = this.showBadge;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i12 = (i11 + r11) * 31;
        String str = this.text;
        return i12 + (str == null ? 0 : str.hashCode());
    }

    public final void setIndex(int i11) {
        this.index = i11;
    }

    public final void setShowBadge(boolean z11) {
        this.showBadge = z11;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public String toString() {
        return "TabBarBadgeMessage(index=" + this.index + ", showBadge=" + this.showBadge + ", text=" + this.text + ')';
    }
}
