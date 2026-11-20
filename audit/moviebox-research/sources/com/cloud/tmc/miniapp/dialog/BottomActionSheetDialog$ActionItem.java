package com.cloud.tmc.miniapp.dialog;

import hd.j;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class BottomActionSheetDialog$ActionItem extends b implements Serializable {
    private final String color;
    private final String disabledColor;
    private final boolean enable;
    private final String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f31536id;
    private final String maskColor;
    private final String text;

    public BottomActionSheetDialog$ActionItem() {
        this(null, null, null, null, false, null, null, 127, null);
    }

    public BottomActionSheetDialog$ActionItem(String str, String str2, String str3, String disabledColor, boolean z11, String str4, String maskColor) {
        Intrinsics.g(disabledColor, "disabledColor");
        Intrinsics.g(maskColor, "maskColor");
        this.f31536id = str;
        this.text = str2;
        this.color = str3;
        this.disabledColor = disabledColor;
        this.enable = z11;
        this.icon = str4;
        this.maskColor = maskColor;
    }

    public /* synthetic */ BottomActionSheetDialog$ActionItem(String str, String str2, String str3, String str4, boolean z11, String str5, String str6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? "#4D191F2B" : str4, (i11 & 16) != 0 ? true : z11, (i11 & 32) == 0 ? str5 : null, (i11 & 64) != 0 ? "#0F191F2B" : str6);
    }

    public static /* synthetic */ BottomActionSheetDialog$ActionItem copy$default(BottomActionSheetDialog$ActionItem bottomActionSheetDialog$ActionItem, String str, String str2, String str3, String str4, boolean z11, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bottomActionSheetDialog$ActionItem.f31536id;
        }
        if ((i11 & 2) != 0) {
            str2 = bottomActionSheetDialog$ActionItem.text;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = bottomActionSheetDialog$ActionItem.color;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = bottomActionSheetDialog$ActionItem.disabledColor;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            z11 = bottomActionSheetDialog$ActionItem.enable;
        }
        boolean z12 = z11;
        if ((i11 & 32) != 0) {
            str5 = bottomActionSheetDialog$ActionItem.icon;
        }
        String str10 = str5;
        if ((i11 & 64) != 0) {
            str6 = bottomActionSheetDialog$ActionItem.maskColor;
        }
        return bottomActionSheetDialog$ActionItem.copy(str, str7, str8, str9, z12, str10, str6);
    }

    public final String component1() {
        return this.f31536id;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.color;
    }

    public final String component4() {
        return this.disabledColor;
    }

    public final boolean component5() {
        return this.enable;
    }

    public final String component6() {
        return this.icon;
    }

    public final String component7() {
        return this.maskColor;
    }

    public final BottomActionSheetDialog$ActionItem copy(String str, String str2, String str3, String disabledColor, boolean z11, String str4, String maskColor) {
        Intrinsics.g(disabledColor, "disabledColor");
        Intrinsics.g(maskColor, "maskColor");
        return new BottomActionSheetDialog$ActionItem(str, str2, str3, disabledColor, z11, str4, maskColor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomActionSheetDialog$ActionItem)) {
            return false;
        }
        BottomActionSheetDialog$ActionItem bottomActionSheetDialog$ActionItem = (BottomActionSheetDialog$ActionItem) obj;
        return Intrinsics.b(this.f31536id, bottomActionSheetDialog$ActionItem.f31536id) && Intrinsics.b(this.text, bottomActionSheetDialog$ActionItem.text) && Intrinsics.b(this.color, bottomActionSheetDialog$ActionItem.color) && Intrinsics.b(this.disabledColor, bottomActionSheetDialog$ActionItem.disabledColor) && this.enable == bottomActionSheetDialog$ActionItem.enable && Intrinsics.b(this.icon, bottomActionSheetDialog$ActionItem.icon) && Intrinsics.b(this.maskColor, bottomActionSheetDialog$ActionItem.maskColor);
    }

    public final String getColor() {
        return this.color;
    }

    public final String getDisabledColor() {
        return this.disabledColor;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f31536id;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    public int hashCode() {
        String str = this.f31536id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.color;
        int iHashCode3 = (this.disabledColor.hashCode() + ((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31;
        boolean z11 = this.enable;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode3 + r11) * 31;
        String str4 = this.icon;
        return this.maskColor.hashCode() + ((i11 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbA = j.a("ActionItem(id=");
        sbA.append(this.f31536id);
        sbA.append(", text=");
        sbA.append(this.text);
        sbA.append(", color=");
        sbA.append(this.color);
        sbA.append(", disabledColor=");
        sbA.append(this.disabledColor);
        sbA.append(", enable=");
        sbA.append(this.enable);
        sbA.append(", icon=");
        sbA.append(this.icon);
        sbA.append(", maskColor=");
        sbA.append(this.maskColor);
        sbA.append(')');
        return sbA.toString();
    }
}
