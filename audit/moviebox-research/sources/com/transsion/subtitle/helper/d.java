package com.transsion.subtitle.helper;

import android.content.Context;
import android.view.ViewGroup;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.subtitle.R$id;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

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
@Metadata
public final class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f58261n = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f58262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f58263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f58264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f58265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f58266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f58267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f58268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f58269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f58270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f58271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f58272k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f58273l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f58274m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f58275a;

        static {
            int[] iArr = new int[LocalVideoUiType.values().length];
            try {
                iArr[LocalVideoUiType.MIDDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LocalVideoUiType.LAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LocalVideoUiType.PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f58275a = iArr;
        }
    }

    public d(Context context) {
        Intrinsics.g(context, "context");
        this.f58262a = context;
        this.f58267f = f0.a(66.0f);
        this.f58268g = f0.a(24.0f);
        this.f58269h = f0.a(24.0f);
        this.f58270i = f0.a(68.0f);
        this.f58271j = d0.e();
        int iC = d0.c();
        this.f58272k = iC;
        int iC2 = com.blankj.utilcode.util.d.c();
        this.f58273l = iC2;
        this.f58274m = iC - iC2;
        this.f58263b = z2.a.getColor(context, R$color.black);
        this.f58264c = z2.a.getColor(context, R$color.white);
        this.f58265d = z2.a.getColor(context, com.transsion.subtitle.R$color.subtitle_color_yellow);
        this.f58266e = z2.a.getColor(context, com.transsion.subtitle.R$color.subtitle_color_green);
    }

    public final String a(int i11) {
        if (i11 == R$id.rb_background_black) {
            return "color_black";
        }
        if (i11 == R$id.rb_background_white) {
            return "color_white";
        }
        if (i11 == R$id.rb_background_yellor) {
            return "color_yellow";
        }
        return i11 == R$id.rb_background_green ? "color_green" : "color_black";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int b(String bgColorType) {
        Intrinsics.g(bgColorType, "bgColorType");
        switch (bgColorType.hashCode()) {
            case -1720275760:
                if (bgColorType.equals("color_yellow")) {
                    return R$id.rb_background_yellor;
                }
                break;
            case 1308937251:
                if (bgColorType.equals("color_black")) {
                    return R$id.rb_background_black;
                }
                break;
            case 1313737511:
                if (bgColorType.equals("color_green")) {
                    return R$id.rb_background_green;
                }
                break;
            case 1328220237:
                if (bgColorType.equals("color_white")) {
                    return R$id.rb_background_white;
                }
                break;
        }
        return R$id.rb_background_white;
    }

    public final float c(int i11) {
        if (i11 == 0) {
            return 0.1f;
        }
        if (i11 == 1) {
            return 0.25f;
        }
        if (i11 != 2) {
            return (i11 == 3 || i11 != 4) ? 0.75f : 1.0f;
        }
        return 0.5f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int d(String colorType) {
        Intrinsics.g(colorType, "colorType");
        switch (colorType.hashCode()) {
            case -1720275760:
                if (colorType.equals("color_yellow")) {
                    return this.f58265d;
                }
                break;
            case 1308937251:
                if (colorType.equals("color_black")) {
                    return this.f58263b;
                }
                break;
            case 1313737511:
                if (colorType.equals("color_green")) {
                    return this.f58266e;
                }
                break;
            case 1328220237:
                if (colorType.equals("color_white")) {
                    return this.f58264c;
                }
                break;
        }
        return this.f58264c;
    }

    public final String e(int i11) {
        if (i11 == R$id.rb_font_color_black) {
            return "color_black";
        }
        if (i11 != R$id.rb_font_color_white) {
            if (i11 == R$id.rb_font_color_yellor) {
                return "color_yellow";
            }
            if (i11 == R$id.rb_font_color_green) {
                return "color_green";
            }
        }
        return "color_white";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int f(String fontColorType) {
        Intrinsics.g(fontColorType, "fontColorType");
        switch (fontColorType.hashCode()) {
            case -1720275760:
                if (fontColorType.equals("color_yellow")) {
                    return R$id.rb_font_color_yellor;
                }
                break;
            case 1308937251:
                if (fontColorType.equals("color_black")) {
                    return R$id.rb_font_color_black;
                }
                break;
            case 1313737511:
                if (fontColorType.equals("color_green")) {
                    return R$id.rb_font_color_green;
                }
                break;
            case 1328220237:
                if (fontColorType.equals("color_white")) {
                    return R$id.rb_font_color_white;
                }
                break;
        }
        return R$id.rb_font_color_white;
    }

    public final float g(int i11) {
        switch (i11) {
            case 0:
                return 0.5f;
            case 1:
                return 0.75f;
            case 2:
            default:
                return 1.0f;
            case 3:
                return 1.5f;
            case 4:
                return 2.0f;
            case 5:
                return 3.0f;
            case 6:
                return 4.0f;
        }
    }

    public final int h(LocalVideoUiType uiType) {
        Intrinsics.g(uiType, "uiType");
        d0.c();
        int i11 = b.f58275a[uiType.ordinal()];
        if (i11 == 1) {
            return (this.f58271j * 9) / 16;
        }
        if (i11 == 2) {
            return this.f58271j;
        }
        if (i11 == 3) {
            return this.f58272k;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void i(SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, LocalVideoUiType uiType, ViewGroup viewGroup) {
        int i11;
        Intrinsics.g(uiType, "uiType");
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        String string = roomAppMMKV.a().getString("subtitle_options_font_color", "color_white");
        String str = string != null ? string : "color_white";
        int iD = d(str);
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setTextColor(iD);
        }
        if (simpleSubtitleView2 != null) {
            simpleSubtitleView2.setTextColor(iD);
        }
        float fG = g(roomAppMMKV.a().getInt("subtitle_options_font_size_progress", 2));
        if (com.transsion.baseui.util.b.a(this.f58262a)) {
            i11 = uiType == LocalVideoUiType.MIDDLE ? 18 : 30;
        } else {
            i11 = uiType == LocalVideoUiType.MIDDLE ? 12 : 20;
        }
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setTextSize(i11 * fG);
        }
        if (simpleSubtitleView2 != null) {
            simpleSubtitleView2.setTextSize(i11 * fG);
        }
        int i12 = roomAppMMKV.a().getInt("subtitle_options_position", 10);
        j(uiType, viewGroup, i12);
        boolean z11 = roomAppMMKV.a().getBoolean("subtitle_options_shadow_enabled", true);
        if (z11) {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setShadowLayer(1.0f, 3.0f, 2.0f, z2.a.getColor(simpleSubtitleView.getContext(), R$color.black_90));
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setShadowLayer(1.0f, 3.0f, 2.0f, z2.a.getColor(simpleSubtitleView2.getContext(), R$color.black_90));
            }
        } else {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        boolean z12 = roomAppMMKV.a().getBoolean("subtitle_options_bg_enabled", false);
        String string2 = roomAppMMKV.a().getString("subtitle_options_bg_color", "color_black");
        String str2 = string2 != null ? string2 : "color_black";
        int i13 = roomAppMMKV.a().getInt("subtitle_options_bg_opacity_progress", 3);
        if (z12) {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.openBg();
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.openBg();
            }
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgdRadius(f0.a(4.0f));
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgdRadius(f0.a(4.0f));
            }
            int iD2 = d(str2);
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgColor(iD2);
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgColor(iD2);
            }
            float fC = c(i13);
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgAlpha((int) (255 * fC));
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgAlpha((int) (255 * fC));
            }
        } else {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.closeBg();
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.closeBg();
            }
        }
        uo.b.a.s(uo.b.f78622a, "SubtitleOptionsView", StringsKt__IndentKt.f("\n            initSubtitleOptions, fontColorType= " + str + "， fontSizePercent = " + fG + "\n                positionPercent = " + i12 + ", openShadow =" + z11 + "\n                openBackground = " + z12 + ", bgColorType = " + str2 + ", bgOpacityProgress = " + i13 + "\n        "), false, 4, null);
    }

    public final void j(LocalVideoUiType uiType, ViewGroup viewGroup, int i11) {
        Intrinsics.g(uiType, "uiType");
        int iH = h(uiType);
        int iA = f0.a(40.0f);
        int i12 = iH - iA;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i13 = (i11 * i12) / 100;
        if (i13 >= 0) {
            if (i13 > i12 - iA) {
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = i12 - f0.a(40.0f);
                }
            } else if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = i13;
            }
            int height = viewGroup != null ? viewGroup.getHeight() : 0;
            if ((marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0) + height > iH && marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = iH - height;
            }
        }
        if (viewGroup != null) {
            viewGroup.requestLayout();
        }
    }
}
