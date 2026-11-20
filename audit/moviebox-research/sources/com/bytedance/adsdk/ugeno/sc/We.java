package com.bytedance.adsdk.ugeno.sc;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum We {
    TRANSLATE("translate", "translation", "point"),
    TRANSLATE_X("translateX", "translationX", "float"),
    TRANSLATE_Y("translateY", "translationY", "float"),
    ROTATE_X("rotateX", "rotationX", "float"),
    ROTATE_Y("rotateY", "rotationY", "float"),
    ROTATE_Z("rotateZ", "rotation", "float"),
    SCALE("scale", "scale", "point"),
    SCALE_X("scaleX", "scaleX", "float"),
    SCALE_Y("scaleY", "scaleY", "float"),
    ALPHA("opacity", "alpha", "float"),
    BACKGROUND_COLOR(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "int"),
    BORDER_RADIUS("borderRadius", "borderRadius", "float"),
    RIPPLE("ripple", "ripple", "float"),
    SHINE("shine", "shine", "float");

    private final String BT;
    private final String Xc;
    private final String dE;

    We(String str, String str2, String str3) {
        this.BT = str;
        this.dE = str2;
        this.Xc = str3;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static We sc(String str) {
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1721943862:
                if (str.equals("translateX")) {
                    b11 = 0;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    b11 = 1;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b11 = 2;
                }
                break;
            case -930826704:
                if (str.equals("ripple")) {
                    b11 = 3;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b11 = 4;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b11 = 5;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b11 = 6;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b11 = 7;
                }
                break;
            case 1287124693:
                if (str.equals(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    b11 = 8;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b11 = 9;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    b11 = 10;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    b11 = Ascii.VT;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    b11 = Ascii.FF;
                }
                break;
        }
        switch (b11) {
            case 0:
                return TRANSLATE_X;
            case 1:
                return TRANSLATE_Y;
            case 2:
                return ALPHA;
            case 3:
                return RIPPLE;
            case 4:
                return SCALE_X;
            case 5:
                return SCALE_Y;
            case 6:
                return SCALE;
            case 7:
                return TRANSLATE;
            case 8:
                return BACKGROUND_COLOR;
            case 9:
                return BORDER_RADIUS;
            case 10:
                return ROTATE_X;
            case 11:
                return ROTATE_Y;
            case 12:
                return ROTATE_Z;
            default:
                return TRANSLATE_X;
        }
    }

    public String pFF() {
        return this.dE;
    }

    public String sc() {
        return this.BT;
    }

    public String zY() {
        return this.Xc;
    }
}
