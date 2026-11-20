package com.transsion.search.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class TabItem implements Parcelable {
    public static final Parcelable.Creator<TabItem> CREATOR = new a();
    private boolean isSelected;
    private final String name;
    private final List<TabItem> subs;
    private final String tabId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<TabItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TabItem createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i11 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 != i11; i12++) {
                arrayList.add(TabItem.CREATOR.createFromParcel(parcel));
            }
            return new TabItem(string, string2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TabItem[] newArray(int i11) {
            return new TabItem[i11];
        }
    }

    public TabItem(String tabId, String name, List<TabItem> subs) {
        Intrinsics.g(tabId, "tabId");
        Intrinsics.g(name, "name");
        Intrinsics.g(subs, "subs");
        this.tabId = tabId;
        this.name = name;
        this.subs = subs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabItem copy$default(TabItem tabItem, String str, String str2, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tabItem.tabId;
        }
        if ((i11 & 2) != 0) {
            str2 = tabItem.name;
        }
        if ((i11 & 4) != 0) {
            list = tabItem.subs;
        }
        return tabItem.copy(str, str2, list);
    }

    public static /* synthetic */ void isSelected$annotations() {
    }

    public final String component1() {
        return this.tabId;
    }

    public final String component2() {
        return this.name;
    }

    public final List<TabItem> component3() {
        return this.subs;
    }

    public final TabItem copy(String tabId, String name, List<TabItem> subs) {
        Intrinsics.g(tabId, "tabId");
        Intrinsics.g(name, "name");
        Intrinsics.g(subs, "subs");
        return new TabItem(tabId, name, subs);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabItem)) {
            return false;
        }
        TabItem tabItem = (TabItem) obj;
        return Intrinsics.b(this.tabId, tabItem.tabId) && Intrinsics.b(this.name, tabItem.name) && Intrinsics.b(this.subs, tabItem.subs);
    }

    public final String getName() {
        return this.name;
    }

    public final List<TabItem> getSubs() {
        return this.subs;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public int hashCode() {
        return (((this.tabId.hashCode() * 31) + this.name.hashCode()) * 31) + this.subs.hashCode();
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public String toString() {
        return "TabItem(tabId=" + this.tabId + ", name=" + this.name + ", subs=" + this.subs + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.tabId);
        out.writeString(this.name);
        List<TabItem> list = this.subs;
        out.writeInt(list.size());
        Iterator<TabItem> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i11);
        }
    }
}
