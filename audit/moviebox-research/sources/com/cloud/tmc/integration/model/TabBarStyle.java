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
public final class TabBarStyle extends b {
    private final String backgroundColor;
    private final String borderStyle;
    private final String color;
    private final String selectedColor;

    public TabBarStyle() {
        this(null, null, null, null, 15, null);
    }

    public TabBarStyle(String str, String str2, String str3, String str4) {
        this.color = str;
        this.selectedColor = str2;
        this.backgroundColor = str3;
        this.borderStyle = str4;
    }

    public /* synthetic */ TabBarStyle(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4);
    }

    public static /* synthetic */ TabBarStyle copy$default(TabBarStyle tabBarStyle, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tabBarStyle.color;
        }
        if ((i11 & 2) != 0) {
            str2 = tabBarStyle.selectedColor;
        }
        if ((i11 & 4) != 0) {
            str3 = tabBarStyle.backgroundColor;
        }
        if ((i11 & 8) != 0) {
            str4 = tabBarStyle.borderStyle;
        }
        return tabBarStyle.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.color;
    }

    public final String component2() {
        return this.selectedColor;
    }

    public final String component3() {
        return this.backgroundColor;
    }

    public final String component4() {
        return this.borderStyle;
    }

    public final TabBarStyle copy(String str, String str2, String str3, String str4) {
        return new TabBarStyle(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabBarStyle)) {
            return false;
        }
        TabBarStyle tabBarStyle = (TabBarStyle) obj;
        return Intrinsics.b(this.color, tabBarStyle.color) && Intrinsics.b(this.selectedColor, tabBarStyle.selectedColor) && Intrinsics.b(this.backgroundColor, tabBarStyle.backgroundColor) && Intrinsics.b(this.borderStyle, tabBarStyle.borderStyle);
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBorderStyle() {
        return this.borderStyle;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getSelectedColor() {
        return this.selectedColor;
    }

    public int hashCode() {
        String str = this.color;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.selectedColor;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundColor;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.borderStyle;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "TabBarStyle(color=" + this.color + ", selectedColor=" + this.selectedColor + ", backgroundColor=" + this.backgroundColor + ", borderStyle=" + this.borderStyle + ')';
    }
}
