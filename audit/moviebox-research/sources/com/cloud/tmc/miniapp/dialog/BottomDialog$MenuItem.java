package com.cloud.tmc.miniapp.dialog;

import hd.j;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class BottomDialog$MenuItem extends b implements Serializable {
    private boolean customStyle;
    private boolean dotBadge;
    private int icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f31537id;
    private String name;

    public BottomDialog$MenuItem(String id2, int i11, String str, boolean z11, boolean z12) {
        Intrinsics.g(id2, "id");
        this.f31537id = id2;
        this.icon = i11;
        this.name = str;
        this.dotBadge = z11;
        this.customStyle = z12;
    }

    public /* synthetic */ BottomDialog$MenuItem(String str, int i11, String str2, boolean z11, boolean z12, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, str2, (i12 & 8) != 0 ? false : z11, (i12 & 16) != 0 ? false : z12);
    }

    public static /* synthetic */ BottomDialog$MenuItem copy$default(BottomDialog$MenuItem bottomDialog$MenuItem, String str, int i11, String str2, boolean z11, boolean z12, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = bottomDialog$MenuItem.f31537id;
        }
        if ((i12 & 2) != 0) {
            i11 = bottomDialog$MenuItem.icon;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            str2 = bottomDialog$MenuItem.name;
        }
        String str3 = str2;
        if ((i12 & 8) != 0) {
            z11 = bottomDialog$MenuItem.dotBadge;
        }
        boolean z13 = z11;
        if ((i12 & 16) != 0) {
            z12 = bottomDialog$MenuItem.customStyle;
        }
        return bottomDialog$MenuItem.copy(str, i13, str3, z13, z12);
    }

    public final String component1() {
        return this.f31537id;
    }

    public final int component2() {
        return this.icon;
    }

    public final String component3() {
        return this.name;
    }

    public final boolean component4() {
        return this.dotBadge;
    }

    public final boolean component5() {
        return this.customStyle;
    }

    public final BottomDialog$MenuItem copy(String id2, int i11, String str, boolean z11, boolean z12) {
        Intrinsics.g(id2, "id");
        return new BottomDialog$MenuItem(id2, i11, str, z11, z12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomDialog$MenuItem)) {
            return false;
        }
        BottomDialog$MenuItem bottomDialog$MenuItem = (BottomDialog$MenuItem) obj;
        return Intrinsics.b(this.f31537id, bottomDialog$MenuItem.f31537id) && this.icon == bottomDialog$MenuItem.icon && Intrinsics.b(this.name, bottomDialog$MenuItem.name) && this.dotBadge == bottomDialog$MenuItem.dotBadge && this.customStyle == bottomDialog$MenuItem.customStyle;
    }

    public final boolean getCustomStyle() {
        return this.customStyle;
    }

    public final boolean getDotBadge() {
        return this.dotBadge;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f31537id;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = (this.icon + (this.f31537id.hashCode() * 31)) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z11 = this.dotBadge;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode2 + r11) * 31;
        boolean z12 = this.customStyle;
        return i11 + (z12 ? 1 : z12);
    }

    public final void setCustomStyle(boolean z11) {
        this.customStyle = z11;
    }

    public final void setDotBadge(boolean z11) {
        this.dotBadge = z11;
    }

    public final void setIcon(int i11) {
        this.icon = i11;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder sbA = j.a("MenuItem(id=");
        sbA.append(this.f31537id);
        sbA.append(", icon=");
        sbA.append(this.icon);
        sbA.append(", name=");
        sbA.append(this.name);
        sbA.append(", dotBadge=");
        sbA.append(this.dotBadge);
        sbA.append(", customStyle=");
        sbA.append(this.customStyle);
        sbA.append(')');
        return sbA.toString();
    }
}
