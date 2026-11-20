package com.cloud.tmc.integration.ui.data;

import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
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
public final class NativeTabBean extends b {
    private String backgroundColor;
    private String color;
    private String selectBackgroundColor;
    private String selectedColor;
    private int selectedIndex = -1;
    private List<String> tabList;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.b(NativeTabBean.class, obj.getClass())) {
            return false;
        }
        NativeTabBean nativeTabBean = (NativeTabBean) obj;
        if (Intrinsics.b(this.color, nativeTabBean.color) && Intrinsics.b(this.selectedColor, nativeTabBean.selectedColor) && this.selectedIndex == nativeTabBean.selectedIndex && Intrinsics.b(this.selectBackgroundColor, nativeTabBean.selectBackgroundColor)) {
            List<String> list = this.tabList;
            String string = list != null ? list.toString() : null;
            List<String> list2 = nativeTabBean.tabList;
            if (Intrinsics.b(string, list2 != null ? list2.toString() : null)) {
                return true;
            }
        }
        return false;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getSelectBackgroundColor() {
        return this.selectBackgroundColor;
    }

    public final String getSelectedColor() {
        return this.selectedColor;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final List<String> getTabList() {
        return this.tabList;
    }

    public int hashCode() {
        Object[] objArr = new Object[6];
        objArr[0] = this.color;
        objArr[1] = this.selectedColor;
        objArr[2] = this.backgroundColor;
        objArr[3] = Integer.valueOf(this.selectedIndex);
        objArr[4] = this.selectBackgroundColor;
        List<String> list = this.tabList;
        objArr[5] = list != null ? list.toString() : null;
        return Objects.hash(objArr);
    }

    public final void setBackgroundColor(String str) {
        this.backgroundColor = str;
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final void setSelectBackgroundColor(String str) {
        this.selectBackgroundColor = str;
    }

    public final void setSelectedColor(String str) {
        this.selectedColor = str;
    }

    public final void setSelectedIndex(int i11) {
        this.selectedIndex = i11;
    }

    public final void setTabList(List<String> list) {
        this.tabList = list;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NativeTabBean(color=");
        sb2.append(this.color);
        sb2.append(", selectedColor=");
        sb2.append(this.selectedColor);
        sb2.append(", backgroundColor=");
        sb2.append(this.backgroundColor);
        sb2.append(", selectBackgroundColor=");
        sb2.append(this.selectBackgroundColor);
        sb2.append(", selectedIndex=");
        sb2.append(this.selectedIndex);
        sb2.append(", tabList=");
        List<String> list = this.tabList;
        sb2.append(list != null ? list.toString() : null);
        sb2.append(')');
        return sb2.toString();
    }
}
