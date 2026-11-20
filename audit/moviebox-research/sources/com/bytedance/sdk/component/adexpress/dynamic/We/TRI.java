package com.bytedance.sdk.component.adexpress.dynamic.We;

import androidx.core.view.MotionEventCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.warren.error.VungleException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI {
    private int AZJ;
    private int BR;
    private String BT;
    private int Bs;
    private int CYO;
    private String Cb;
    private int DNB;
    private String Dl;
    private int EZl;
    private boolean ExN;
    private String FI;
    private int Flm;
    private double GI;
    private String GOt;
    private String Gb;
    private String HBq;
    private JSONObject HC;
    private double HJN;
    private boolean IEI;
    private int II;
    private boolean JP;
    private String JPJ;
    private int JoC;
    private double McK;
    private int Mrq;
    private int MxZ;
    private int NP;
    private int NQ;
    private boolean OKY;
    private String OXF;
    private float Ol;
    private int PPh;
    private boolean Pu;
    private boolean QLv;
    private int QST;
    private float Qj;
    private String Ql;
    private String SR;
    private String Sfl;
    private String TEo;
    private long TI = -1;
    private float TRI;
    private double Tf;
    private boolean TpG;
    private double UFX;
    private JSONObject VZ;
    private float WH;
    private boolean WMT;
    private boolean WP;
    private float We;
    private String WgX;
    private String Xc;
    private String YIK;
    private boolean YdT;
    private int Yhz;
    private boolean ZM;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private int f26751ag;
    private String auq;
    private int bSP;
    private boolean bZj;

    /* JADX INFO: renamed from: bp, reason: collision with root package name */
    private int f26752bp;
    private String cD;
    private String cJ;
    private int cvk;
    private String dE;
    private String dix;

    /* JADX INFO: renamed from: ds, reason: collision with root package name */
    private double f26753ds;

    /* JADX INFO: renamed from: ef, reason: collision with root package name */
    private int f26754ef;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private int f26755eo;
    private List<sc> eoh;
    private JSONObject fT;
    private int gsl;

    /* JADX INFO: renamed from: gx, reason: collision with root package name */
    private int f26756gx;
    private int hE;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    private boolean f26757ht;
    private String idT;
    private JSONObject jcs;
    private String jxU;
    private int kDg;
    private boolean kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private boolean f26758ko;
    private int lD;
    private String mD;
    private int mbO;
    private int otH;
    private int pCa;
    private float pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private int f26759pc;
    private int qKn;
    private String qOv;
    private String qfG;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private float f26760qr;

    /* JADX INFO: renamed from: ra, reason: collision with root package name */
    private int f26761ra;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26762sc;
    private String uEA;
    private boolean vYl;

    /* JADX INFO: renamed from: vl, reason: collision with root package name */
    private int f26763vl;
    private String wjp;
    private boolean yL;
    private int ymG;
    private boolean ypJ;
    private float zY;

    private void II(String str) {
        this.TEo = str;
    }

    public static TRI sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        TRI tri = new TRI();
        tri.pFF(jSONObject.optString("adType", "embeded"));
        tri.BT(jSONObject.optString("clickArea", "creative"));
        tri.dE(jSONObject.optString("clickTigger", "click"));
        tri.zY(jSONObject.optString(TtmlNode.ATTR_TTS_FONT_FAMILY, "PingFangSC"));
        tri.We(jSONObject.optString(TtmlNode.ATTR_TTS_TEXT_ALIGN, TtmlNode.LEFT));
        tri.ExN(jSONObject.optString(TtmlNode.ATTR_TTS_COLOR, "#999999"));
        tri.TRI(jSONObject.optString("bgColor", "transparent"));
        tri.qr(jSONObject.optString("bgImgUrl", ""));
        tri.II(jSONObject.optString("bgImgData", ""));
        tri.Qj(jSONObject.optString("borderColor", "#000000"));
        tri.Ol(jSONObject.optString("borderStyle", "solid"));
        tri.WH(jSONObject.optString("heightMode", "auto"));
        tri.UFX(jSONObject.optString("widthMode", "fixed"));
        tri.Tf(jSONObject.optString("interactText", ""));
        tri.zY(jSONObject.optBoolean("isShowBgControl", false));
        tri.Ql(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            tri.qr(jSONObjectOptJSONObject.optInt("translateY", 0));
            tri.Qj(jSONObjectOptJSONObject.optInt("translateX", 0));
            tri.We(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            tri.ExN(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        tri.SR(jSONObject.optString("interactType", ""));
        tri.ExN(jSONObject.optInt("interactSlideDirection", -1));
        tri.Xc(jSONObject.optString("justifyHorizontal", "space-around"));
        tri.wjp(jSONObject.optString("justifyVertical", "flex-start"));
        tri.pFF(jSONObject.optDouble("timingStart"));
        tri.zY(jSONObject.optDouble("timingEnd"));
        tri.We((float) jSONObject.optDouble("width", 0.0d));
        tri.zY((float) jSONObject.optDouble("height", 0.0d));
        tri.sc((float) jSONObject.optDouble("borderRadius", 0.0d));
        tri.pFF((float) jSONObject.optDouble("borderSize", 0.0d));
        tri.pFF(jSONObject.optBoolean("interactValidate", false));
        tri.Ol((float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, 0.0d));
        tri.ExN((float) jSONObject.optDouble("paddingBottom", 0.0d));
        tri.TRI((float) jSONObject.optDouble("paddingLeft", 0.0d));
        tri.qr((float) jSONObject.optDouble("paddingRight", 0.0d));
        tri.Qj((float) jSONObject.optDouble("paddingTop", 0.0d));
        tri.We(jSONObject.optBoolean("lineFeed", false));
        tri.Ol(jSONObject.optInt("lineCount", 0));
        tri.TRI(jSONObject.optDouble("lineHeight", 1.2d));
        tri.SR(jSONObject.optInt("letterSpacing", 0));
        tri.ExN(jSONObject.optBoolean("isDataFixed", false));
        tri.BT(jSONObject.optInt(TtmlNode.ATTR_TTS_FONT_WEIGHT));
        tri.TRI(jSONObject.optBoolean("lineLimit"));
        tri.dE(jSONObject.optInt(RequestParameters.POSITION));
        tri.Sfl(jSONObject.optString("align"));
        tri.qr(jSONObject.optBoolean("useLeft"));
        tri.Qj(jSONObject.optBoolean("useRight"));
        tri.Ol(jSONObject.optBoolean("useTop"));
        tri.WH(jSONObject.optBoolean("useBottom"));
        tri.YIK(jSONObject.optString("data"));
        tri.pFF(jSONObject.optJSONObject("i18n"));
        tri.Tf(jSONObject.optInt("marginLeft"));
        tri.Ql(jSONObject.optInt("marginRight"));
        tri.WH(jSONObject.optInt("marginTop"));
        tri.UFX(jSONObject.optInt("marginBottom"));
        tri.Xc(jSONObject.optInt("tagMaxCount"));
        tri.UFX(jSONObject.optBoolean("allowTextFlow"));
        tri.wjp(jSONObject.optInt("textFlowType"));
        tri.Sfl(jSONObject.optInt("textFlowDuration"));
        tri.YIK(jSONObject.optInt(TtmlNode.LEFT));
        tri.Dl(jSONObject.optInt(TtmlNode.RIGHT));
        tri.uEA(jSONObject.optInt("top"));
        tri.JPJ(jSONObject.optInt("bottom"));
        tri.Dl(jSONObject.optString("alignItems", "flex-start"));
        tri.uEA(jSONObject.optString("direction", ""));
        tri.sc(jSONObject.optBoolean("loop", false));
        tri.FI(jSONObject.optInt("zIndex"));
        tri.HJN(jSONObject.optInt("interactVisibleTime"));
        tri.WP(jSONObject.optInt("interactHiddenTime"));
        tri.Ql(jSONObject.optBoolean("interactEnableMask"));
        tri.SR(jSONObject.optBoolean("interactWontHide"));
        tri.sc(jSONObject.optString("bgGradient"));
        tri.cD(jSONObject.optInt("areaType"));
        tri.Cb(jSONObject.optInt("interactSlideThreshold", 0));
        tri.kX(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.We.pFF() ? 0 : 120));
        tri.wjp(jSONObject.optBoolean("openPlayableLandingPage", false));
        tri.zY(jSONObject.optJSONObject("video"));
        tri.We(jSONObject.optJSONObject("image"));
        tri.OXF(jSONObject.optInt("borderShadowExtent"));
        tri.BT(jSONObject.optBoolean("bgGauseBlur"));
        tri.cJ(jSONObject.optInt("bgGauseBlurRadius"));
        tri.dE(jSONObject.optBoolean("showTimeProgress", false));
        tri.Xc(jSONObject.optBoolean("showPlayButton", false));
        tri.sc(jSONObject.optDouble("bgColorCg", 0.0d));
        tri.TRI(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        tri.pFF(jSONObject.optInt("borderTopLeftRadius", 0));
        tri.sc(jSONObject.optInt("borderTopRightRadius", 0));
        tri.We(jSONObject.optInt("borderBottomLeftRadius", 0));
        tri.zY(jSONObject.optInt("borderBottomRightRadius", 0));
        tri.ExN(jSONObject.optJSONObject("interactI18n"));
        tri.FI(jSONObject.optString("imageObjectFit"));
        tri.WP(jSONObject.optString("interactTitle"));
        tri.Gb(jSONObject.optInt("interactTextPositionTop"));
        tri.JPJ(jSONObject.optString("imageLottieTosPath"));
        tri.Tf(jSONObject.optBoolean("animationsLoop"));
        tri.cvk(jSONObject.optInt("lottieAppNameMaxLength"));
        tri.McK(jSONObject.optInt("lottieAdDescMaxLength"));
        tri.II(jSONObject.optInt("lottieAdTitleMaxLength"));
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i11);
                    sc scVar = new sc();
                    scVar.zY(jSONObject2.optString("animationType"));
                    scVar.sc(jSONObject2.optDouble("animationDuration"));
                    scVar.pFF(jSONObject2.optDouble("animationScaleX"));
                    scVar.zY(jSONObject2.optDouble("animationScaleY"));
                    scVar.We(jSONObject2.optString("animationTimeFunction"));
                    scVar.We(jSONObject2.optDouble("animationDelay"));
                    scVar.TRI(jSONObject2.optInt("animationIterationCount"));
                    scVar.ExN(jSONObject2.optString("animationDirection"));
                    scVar.ExN(jSONObject2.optDouble("animationInterval"));
                    scVar.sc(jSONObject2.optInt("animationBorderWidth"));
                    scVar.sc(jSONObject2.optLong("key"));
                    scVar.pFF(jSONObject2.optInt("animationEffectWidth"));
                    scVar.zY(jSONObject2.optInt("animationSwing", 1));
                    scVar.We(jSONObject2.optInt("animationTranslateX"));
                    scVar.ExN(jSONObject2.optInt("animationTranslateY"));
                    scVar.pFF(jSONObject2.optString("animationRippleBackgroundColor"));
                    scVar.sc(jSONObject2.optString("animationScaleDirection"));
                    scVar.qr(jSONObject2.optInt("animationFadeStart"));
                    scVar.Qj(jSONObject2.optInt("animationFadeEnd"));
                    scVar.TRI(jSONObject2.optString("animationFillMode"));
                    scVar.Ol(jSONObject2.optInt("animationBounceHeight"));
                    if (tri.Sfl() > 0.0d) {
                        scVar.We(scVar.SR() + tri.Sfl());
                    }
                    arrayList.add(scVar);
                }
                tri.sc(arrayList);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                tri.cvk(jSONObject.optString("triggerSlideDirection", "0"));
                tri.sc(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception unused) {
        }
        return tri;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void sc(TRI tri, JSONObject jSONObject) {
        if (tri == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            next.hashCode();
            byte b11 = -1;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        b11 = 0;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        b11 = 1;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        b11 = 2;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        b11 = 3;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        b11 = 4;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        b11 = 5;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        b11 = 6;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        b11 = 7;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        b11 = 8;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        b11 = 9;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        b11 = 10;
                    }
                    break;
                case -1224696685:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                        b11 = Ascii.VT;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        b11 = Ascii.FF;
                    }
                    break;
                case -1065511464:
                    if (next.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                        b11 = Ascii.CR;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b11 = Ascii.SO;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b11 = Ascii.SI;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b11 = Ascii.DLE;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        b11 = 17;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        b11 = Ascii.DC2;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        b11 = 19;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        b11 = Ascii.DC4;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        b11 = Ascii.NAK;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        b11 = Ascii.SYN;
                    }
                    break;
                case -734428249:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                        b11 = Ascii.ETB;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        b11 = Ascii.CAN;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        b11 = Ascii.EM;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        b11 = Ascii.SUB;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        b11 = Ascii.ESC;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        b11 = Ascii.FS;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        b11 = Ascii.GS;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        b11 = Ascii.RS;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        b11 = Ascii.US;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        b11 = 32;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        b11 = 33;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        b11 = 34;
                    }
                    break;
                case 3317767:
                    if (next.equals(TtmlNode.LEFT)) {
                        b11 = 35;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        b11 = 36;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        b11 = 37;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        b11 = 38;
                    }
                    break;
                case 94842723:
                    if (next.equals(TtmlNode.ATTR_TTS_COLOR)) {
                        b11 = 39;
                    }
                    break;
                case 108511772:
                    if (next.equals(TtmlNode.RIGHT)) {
                        b11 = 40;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        b11 = 41;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        b11 = 42;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        b11 = 43;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        b11 = 44;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        b11 = 45;
                    }
                    break;
                case 365601008:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                        b11 = 46;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        b11 = 47;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        b11 = 48;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        b11 = 49;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        b11 = 50;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        b11 = 51;
                    }
                    break;
                case 747804969:
                    if (next.equals(RequestParameters.POSITION)) {
                        b11 = 52;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        b11 = 53;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        b11 = 54;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        b11 = 55;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        b11 = 56;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        b11 = 57;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        b11 = 58;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        b11 = 59;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        b11 = 60;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        b11 = 61;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        b11 = 62;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b11 = Utf8.REPLACEMENT_BYTE;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        b11 = 64;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        b11 = 65;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        b11 = 66;
                    }
                    break;
            }
            switch (b11) {
                case 0:
                    tri.zY(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    tri.BT(jSONObject.optString(next));
                    break;
                case 2:
                    tri.cvk(jSONObject.optString(next));
                    break;
                case 3:
                    tri.qr(jSONObject.optString(next));
                    break;
                case 4:
                    tri.Ol(jSONObject.optInt(next));
                    break;
                case 5:
                    tri.wjp(jSONObject.optBoolean(next));
                    break;
                case 6:
                    tri.TRI(jSONObject.optBoolean(next));
                    break;
                case 7:
                    tri.Ql(jSONObject.optString(next));
                    break;
                case 8:
                    tri.TRI((float) jSONObject.optDouble(next));
                    break;
                case 9:
                    tri.pFF(jSONObject.optString(next));
                    break;
                case 10:
                    tri.JPJ(jSONObject.optInt(next));
                    break;
                case 11:
                    tri.zY(jSONObject.optString(next));
                    break;
                case 12:
                    tri.zY((float) jSONObject.optDouble(next));
                    break;
                case 13:
                    tri.We(jSONObject.optString(next));
                    break;
                case 14:
                    tri.Dl(jSONObject.optString(next));
                    break;
                case 15:
                    tri.pFF(jSONObject.optBoolean(next));
                    break;
                case 16:
                    tri.WH(jSONObject.optInt(next));
                    break;
                case 17:
                    tri.WH(jSONObject.optBoolean(next));
                    break;
                case 18:
                    tri.sc(jSONObject.optLong(next));
                    break;
                case 19:
                    tri.uEA(jSONObject.optString(next));
                    break;
                case 20:
                    tri.Xc(jSONObject.optInt(next));
                    break;
                case 21:
                    tri.WP(jSONObject.optInt(next));
                    break;
                case 22:
                    tri.Ol(jSONObject.optBoolean(next));
                    break;
                case 23:
                    tri.BT(jSONObject.optInt(next));
                    break;
                case 24:
                    tri.FI(jSONObject.optInt(next));
                    break;
                case 25:
                    tri.pFF(jSONObject.optDouble(next));
                    break;
                case 26:
                    tri.TRI(jSONObject.optDouble(next));
                    break;
                case 27:
                    tri.Sfl(jSONObject.optInt(next));
                    break;
                case 28:
                    tri.Qj(jSONObject.optBoolean(next));
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    tri.UFX(jSONObject.optInt(next));
                    break;
                case 30:
                    tri.TRI(jSONObject.optString(next));
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    tri.qr(jSONObject.optBoolean(next));
                    break;
                case 32:
                    tri.UFX(jSONObject.optString(next));
                    break;
                case 33:
                    tri.uEA(jSONObject.optInt(next));
                    break;
                case 34:
                    tri.YIK(jSONObject.optString(next));
                    break;
                case 35:
                    tri.YIK(jSONObject.optInt(next));
                    break;
                case 36:
                    tri.sc(jSONObject.optBoolean(next));
                    break;
                case 37:
                    tri.Qj((float) jSONObject.optDouble(next));
                    break;
                case 38:
                    tri.Sfl(jSONObject.optString(next));
                    break;
                case 39:
                    tri.ExN(jSONObject.optString(next));
                    break;
                case 40:
                    tri.Dl(jSONObject.optInt(next));
                    break;
                case 41:
                    tri.We((float) jSONObject.optDouble(next));
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    tri.zY(jSONObject.optDouble(next));
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    tri.ExN((float) jSONObject.optDouble(next));
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    tri.UFX(jSONObject.optBoolean(next));
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    tri.SR(jSONObject.optBoolean(next));
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    tri.Ol((float) jSONObject.optDouble(next));
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    tri.wjp(jSONObject.optString(next));
                    break;
                case 48:
                    tri.HJN(jSONObject.optInt(next));
                    break;
                case 49:
                    tri.qr((float) jSONObject.optDouble(next));
                    break;
                case 50:
                    tri.Qj(jSONObject.optString(next));
                    break;
                case 51:
                    tri.Ol(jSONObject.optString(next));
                    break;
                case 52:
                    tri.dE(jSONObject.optInt(next));
                    break;
                case 53:
                    tri.ExN(jSONObject.optBoolean(next));
                    break;
                case 54:
                    tri.Ql(jSONObject.optInt(next));
                    break;
                case 55:
                    tri.Xc(jSONObject.optString(next));
                    break;
                case 56:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        tri.qr(jSONObjectOptJSONObject.optInt("translateY", 0));
                        tri.Qj(jSONObjectOptJSONObject.optInt("translateX", 0));
                        tri.We(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        tri.ExN(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    tri.We(jSONObject.optBoolean(next));
                    break;
                case 58:
                    tri.Tf(jSONObject.optString(next));
                    break;
                case 59:
                    tri.SR(jSONObject.optString(next));
                    break;
                case 60:
                    tri.sc((float) jSONObject.optDouble(next));
                    break;
                case 61:
                    tri.dE(jSONObject.optString(next));
                    break;
                case 62:
                    tri.WH(jSONObject.optString(next));
                    break;
                case 63:
                    tri.wjp(jSONObject.optInt(next));
                    break;
                case 64:
                    tri.pFF((float) jSONObject.optDouble(next));
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    tri.Tf(jSONObject.optInt(next));
                    break;
                case 66:
                    tri.SR(jSONObject.optInt(next));
                    break;
            }
        }
    }

    public int AZJ() {
        return this.gsl;
    }

    public String BR() {
        return this.Gb;
    }

    public float BT() {
        return this.f26760qr;
    }

    public void BT(int i11) {
        this.f26755eo = i11;
    }

    public void BT(String str) {
        this.cD = str;
    }

    public void BT(boolean z11) {
        this.vYl = z11;
    }

    public boolean Bs() {
        return this.OKY;
    }

    public String CYO() {
        return this.Cb;
    }

    public int Cb() {
        return this.cvk;
    }

    public void Cb(int i11) {
        this.f26756gx = i11;
    }

    public JSONObject DNB() {
        return this.fT;
    }

    public String Dl() {
        return this.BT;
    }

    public void Dl(int i11) {
        this.DNB = i11;
    }

    public void Dl(String str) {
        this.mD = str;
    }

    public void EZl() {
        sc(this, this.jcs);
    }

    public int ExN() {
        return this.f26752bp;
    }

    public void ExN(double d11) {
        this.HJN = d11;
    }

    public void ExN(float f11) {
        this.TRI = f11;
    }

    public void ExN(int i11) {
        this.ymG = i11;
    }

    public void ExN(String str) {
        this.dE = str;
    }

    public void ExN(JSONObject jSONObject) {
        this.VZ = jSONObject;
    }

    public void ExN(boolean z11) {
        this.QLv = z11;
    }

    public String FI() {
        return this.wjp;
    }

    public void FI(int i11) {
        this.PPh = i11;
    }

    public void FI(String str) {
        this.WgX = str;
    }

    public String Flm() {
        return this.auq;
    }

    public boolean GI() {
        return this.kX;
    }

    public List<sc> GOt() {
        return this.eoh;
    }

    public String Gb() {
        return this.FI;
    }

    public void Gb(int i11) {
        this.f26761ra = i11;
    }

    public long HBq() {
        return this.TI;
    }

    public String HC() {
        return this.WgX;
    }

    public String HJN() {
        return this.JPJ;
    }

    public void HJN(int i11) {
        this.QST = i11;
    }

    public int IEI() {
        return this.kDg;
    }

    public String II() {
        return this.Dl;
    }

    public void II(int i11) {
        this.EZl = i11;
    }

    public int JP() {
        return this.Flm;
    }

    public String JPJ() {
        return this.Xc;
    }

    public void JPJ(int i11) {
        this.otH = i11;
    }

    public void JPJ(String str) {
        this.qOv = str;
    }

    public String JoC() {
        return this.cD;
    }

    public String McK() {
        return this.uEA;
    }

    public void McK(int i11) {
        this.lD = i11;
    }

    public String Mrq() {
        return this.dix;
    }

    public int MxZ() {
        return this.BR;
    }

    public int NP() {
        return this.Bs;
    }

    public boolean NQ() {
        return this.ZM;
    }

    public int OKY() {
        return this.MxZ;
    }

    public int OXF() {
        return this.II;
    }

    public void OXF(int i11) {
        this.AZJ = i11;
    }

    public int Ol() {
        return this.f26754ef;
    }

    public void Ol(float f11) {
        this.WH = f11;
    }

    public void Ol(int i11) {
        this.BR = i11;
    }

    public void Ol(String str) {
        this.YIK = str;
    }

    public void Ol(boolean z11) {
        this.f26757ht = z11;
    }

    public int PPh() {
        return this.DNB;
    }

    public int Pu() {
        List<sc> list = this.eoh;
        if (list == null) {
            return 0;
        }
        for (sc scVar : list) {
            if ("translate".equals(scVar.Ol()) && scVar.qr() < 0) {
                return -scVar.qr();
            }
        }
        return 0;
    }

    public int QLv() {
        return this.JoC;
    }

    public int QST() {
        return this.otH;
    }

    public double Qj() {
        return this.f26753ds;
    }

    public void Qj(float f11) {
        this.Ol = f11;
    }

    public void Qj(int i11) {
        this.II = i11;
    }

    public void Qj(String str) {
        this.Sfl = str;
    }

    public void Qj(boolean z11) {
        this.f26758ko = z11;
    }

    public void Ql(int i11) {
        this.f26759pc = i11;
    }

    public void Ql(String str) {
        this.FI = str;
    }

    public void Ql(boolean z11) {
        this.ypJ = z11;
    }

    public boolean Ql() {
        return this.ExN;
    }

    public float SR() {
        return this.TRI;
    }

    public void SR(int i11) {
        this.MxZ = i11;
    }

    public void SR(String str) {
        this.Gb = str;
    }

    public void SR(boolean z11) {
        this.Pu = z11;
    }

    public double Sfl() {
        return this.UFX;
    }

    public void Sfl(int i11) {
        this.NQ = i11;
    }

    public void Sfl(String str) {
        this.qfG = str;
    }

    public JSONObject TRI() {
        return this.VZ;
    }

    public void TRI(double d11) {
        this.GI = d11;
    }

    public void TRI(float f11) {
        this.f26760qr = f11;
    }

    public void TRI(int i11) {
        this.f26754ef = i11;
    }

    public void TRI(String str) {
        this.Xc = str;
    }

    public void TRI(boolean z11) {
        this.yL = z11;
    }

    public float Tf() {
        return this.pFF;
    }

    public void Tf(int i11) {
        this.qKn = i11;
    }

    public void Tf(String str) {
        this.JPJ = str;
    }

    public void Tf(boolean z11) {
        this.bZj = z11;
    }

    public boolean TpG() {
        return this.ypJ;
    }

    public float UFX() {
        return this.f26762sc;
    }

    public void UFX(int i11) {
        this.CYO = i11;
    }

    public void UFX(String str) {
        this.uEA = str;
    }

    public void UFX(boolean z11) {
        this.YdT = z11;
    }

    public int VZ() {
        return this.Mrq;
    }

    public String WH() {
        return this.jxU;
    }

    public void WH(int i11) {
        this.JoC = i11;
    }

    public void WH(String str) {
        this.Dl = str;
    }

    public void WH(boolean z11) {
        this.ZM = z11;
    }

    public int WMT() {
        return this.EZl;
    }

    public String WP() {
        return this.TEo;
    }

    public void WP(int i11) {
        this.gsl = i11;
    }

    public void WP(String str) {
        this.auq = str;
    }

    public int We() {
        return this.pCa;
    }

    public void We(double d11) {
        this.McK = d11;
    }

    public void We(float f11) {
        this.We = f11;
    }

    public void We(int i11) {
        this.f26752bp = i11;
    }

    public void We(String str) {
        this.BT = str;
    }

    public void We(JSONObject jSONObject) {
        this.HC = jSONObject;
    }

    public void We(boolean z11) {
        this.kX = z11;
    }

    public boolean WgX() {
        return this.WMT;
    }

    public float Xc() {
        return this.Ol;
    }

    public void Xc(int i11) {
        this.Bs = i11;
    }

    public void Xc(String str) {
        this.OXF = str;
    }

    public void Xc(boolean z11) {
        this.WMT = z11;
    }

    public double YIK() {
        return this.Tf;
    }

    public void YIK(int i11) {
        this.kDg = i11;
    }

    public void YIK(String str) {
        this.idT = str;
    }

    public boolean YdT() {
        return this.f26758ko;
    }

    public int Yhz() {
        return this.f26759pc;
    }

    public boolean ZM() {
        return this.yL;
    }

    public boolean ag() {
        return this.vYl;
    }

    public String auq() {
        return this.HBq;
    }

    public boolean bSP() {
        return this.f26757ht;
    }

    public JSONObject bZj() {
        return this.HC;
    }

    public boolean bp() {
        return this.JP;
    }

    public void cD(int i11) {
        this.Mrq = i11;
    }

    public boolean cD() {
        return this.WP;
    }

    public double cJ() {
        return this.McK;
    }

    public void cJ(int i11) {
        this.mbO = i11;
    }

    public String cvk() {
        return this.Sfl;
    }

    public void cvk(int i11) {
        this.Flm = i11;
    }

    public void cvk(String str) {
        this.HBq = str;
    }

    public float dE() {
        return this.Qj;
    }

    public void dE(int i11) {
        this.Yhz = i11;
    }

    public void dE(String str) {
        this.Cb = str;
    }

    public void dE(boolean z11) {
        this.JP = z11;
    }

    public int dix() {
        return this.NQ;
    }

    public int ds() {
        return this.QST;
    }

    public int ef() {
        return this.f26756gx;
    }

    public int eo() {
        return this.CYO;
    }

    public String eoh() {
        return this.mD;
    }

    public String fT() {
        return this.qfG;
    }

    public int gsl() {
        return this.NP;
    }

    public int gx() {
        return this.PPh;
    }

    public int hE() {
        return this.lD;
    }

    public int ht() {
        return this.f26755eo;
    }

    public int idT() {
        return this.Yhz;
    }

    public boolean jcs() {
        return this.Pu;
    }

    public String kDg() {
        return this.idT;
    }

    public double kX() {
        return this.HJN;
    }

    public void kX(int i11) {
        this.hE = i11;
    }

    public boolean ko() {
        return this.QLv;
    }

    public void lD() {
        sc(this, this.HC);
    }

    public int mD() {
        return this.bSP;
    }

    public String mbO() {
        return this.qOv;
    }

    public boolean otH() {
        return this.YdT;
    }

    public int pCa() {
        return this.mbO;
    }

    public int pFF() {
        return this.f26763vl;
    }

    public void pFF(double d11) {
        this.UFX = d11;
    }

    public void pFF(float f11) {
        this.pFF = f11;
    }

    public void pFF(int i11) {
        this.f26751ag = i11;
    }

    public void pFF(String str) {
        this.Ql = str;
    }

    public void pFF(JSONObject jSONObject) {
        this.fT = jSONObject;
    }

    public void pFF(boolean z11) {
        this.ExN = z11;
    }

    public String pc() {
        return this.cJ;
    }

    public String qKn() {
        return this.OXF;
    }

    public boolean qOv() {
        return this.TpG;
    }

    public double qfG() {
        return this.GI;
    }

    public int qr() {
        return this.ymG;
    }

    public void qr(float f11) {
        this.Qj = f11;
    }

    public void qr(int i11) {
        this.cvk = i11;
    }

    public void qr(String str) {
        this.wjp = str;
    }

    public void qr(boolean z11) {
        this.OKY = z11;
    }

    public int ra() {
        return this.hE;
    }

    public void sc(double d11) {
        this.f26753ds = d11;
    }

    public void sc(float f11) {
        this.f26762sc = f11;
    }

    public void sc(int i11) {
        this.f26763vl = i11;
    }

    public void sc(long j11) {
        this.TI = j11;
    }

    public void sc(String str) {
        this.jxU = str;
    }

    public void sc(List<sc> list) {
        this.eoh = list;
    }

    public void sc(boolean z11) {
        this.IEI = z11;
    }

    public boolean sc() {
        return this.IEI;
    }

    public String uEA() {
        return this.dE;
    }

    public void uEA(int i11) {
        this.NP = i11;
    }

    public void uEA(String str) {
        this.dix = str;
    }

    public boolean vYl() {
        return this.bZj;
    }

    public int vl() {
        return this.AZJ;
    }

    public float wjp() {
        return this.WH;
    }

    public void wjp(int i11) {
        this.bSP = i11;
    }

    public void wjp(String str) {
        this.cJ = str;
    }

    public void wjp(boolean z11) {
        this.TpG = z11;
    }

    public int yL() {
        return this.qKn;
    }

    public int ymG() {
        return this.f26761ra;
    }

    public String ypJ() {
        return this.GOt;
    }

    public int zY() {
        return this.f26751ag;
    }

    public void zY(double d11) {
        this.Tf = d11;
    }

    public void zY(float f11) {
        this.zY = f11;
    }

    public void zY(int i11) {
        this.pCa = i11;
    }

    public void zY(String str) {
        this.SR = str;
    }

    public void zY(JSONObject jSONObject) {
        this.jcs = jSONObject;
    }

    public void zY(boolean z11) {
        this.WP = z11;
    }
}
