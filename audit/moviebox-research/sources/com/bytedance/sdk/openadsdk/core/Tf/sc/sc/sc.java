package com.bytedance.sdk.openadsdk.core.Tf.sc.sc;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.IOException;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    public static com.bytedance.sdk.openadsdk.core.Tf.zY sc(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i11;
        ExN.sc scVar;
        int i12;
        int i13;
        if (context == null) {
            ExN.sc(xmlPullParser);
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i14 = displayMetrics.widthPixels;
        int i15 = displayMetrics.heightPixels;
        float f11 = displayMetrics.density;
        int i16 = (int) (i14 / f11);
        int i17 = (int) (i15 / f11);
        float f12 = Float.MIN_VALUE;
        com.bytedance.sdk.openadsdk.core.Tf.zY zYVar = null;
        while (true) {
            int i18 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals("CompanionAds")) {
                return zYVar;
            }
            xmlPullParser.next();
            int i19 = 2;
            if (xmlPullParser.getEventType() == 2) {
                String str = "Companion";
                if (xmlPullParser.getName().equals("Companion")) {
                    String str2 = ExN.f28237qr;
                    int iPFF = ExN.pFF(xmlPullParser.getAttributeValue(str2, "width"));
                    int iPFF2 = ExN.pFF(xmlPullParser.getAttributeValue(str2, "height"));
                    if (iPFF < 300 || iPFF2 < 250) {
                        ExN.sc(xmlPullParser);
                        zYVar = zYVar;
                        i17 = i17;
                    } else {
                        ExN.sc scVar2 = new ExN.sc();
                        while (true) {
                            if (xmlPullParser.getEventType() != i18 || !xmlPullParser.getName().equals(str)) {
                                xmlPullParser.next();
                                if (xmlPullParser.getEventType() == i19) {
                                    String name = xmlPullParser.getName();
                                    name.hashCode();
                                    zYVar = zYVar;
                                    str = str;
                                    switch (name) {
                                        case "IFrameResource":
                                            i11 = i17;
                                            ExN.sc scVar3 = scVar2;
                                            int i21 = iPFF2;
                                            int i22 = iPFF;
                                            Point pointSc = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.sc(context, i22, i21, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.HTML_RESOURCE);
                                            int i23 = pointSc.x;
                                            int i24 = pointSc.y;
                                            com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF pff = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.IFRAME_RESOURCE;
                                            com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.NONE;
                                            float fSc = com.bytedance.sdk.openadsdk.core.Tf.zY.sc(i16, i11, i23, i24, pff, enumC0293sc);
                                            String strPFF = ExN.pFF(xmlPullParser, "IFrameResource");
                                            if (TextUtils.isEmpty(strPFF) || fSc <= scVar3.f28238qr || fSc <= f12) {
                                                ExN.sc(xmlPullParser, "IFrameResource", 3);
                                            } else {
                                                scVar3.f28238qr = fSc;
                                                scVar3.sc(strPFF, enumC0293sc, pff);
                                            }
                                            scVar2 = scVar3;
                                            iPFF = i22;
                                            iPFF2 = i21;
                                            i17 = i11;
                                            break;
                                        case "CompanionClickThrough":
                                            scVar2.We = ExN.pFF(xmlPullParser, "CompanionClickThrough");
                                            iPFF = iPFF;
                                            break;
                                        case "TrackingEvents":
                                            i11 = i17;
                                            scVar = scVar2;
                                            i12 = iPFF2;
                                            i13 = iPFF;
                                            while (true) {
                                                if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                                                    iPFF = i13;
                                                    iPFF2 = i12;
                                                    scVar2 = scVar;
                                                    i17 = i11;
                                                    break;
                                                } else if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Tracking")) {
                                                    scVar.pFF(ExN.pFF(xmlPullParser, "Tracking"));
                                                }
                                            }
                                            break;
                                        case "StaticResource":
                                            scVar = scVar2;
                                            i12 = iPFF2;
                                            i13 = iPFF;
                                            com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc2 = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.NONE;
                                            String lowerCase = xmlPullParser.getAttributeValue(ExN.f28237qr, "creativeType").toLowerCase();
                                            Set<String> set = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.f28245sc;
                                            com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc3 = set.contains(lowerCase) ? com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.IMAGE : com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.JAVASCRIPT;
                                            com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF pff2 = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.STATIC_RESOURCE;
                                            Point pointSc2 = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.sc(context, i13, i12, pff2);
                                            i11 = i17;
                                            float fSc2 = com.bytedance.sdk.openadsdk.core.Tf.zY.sc(i16, i17, pointSc2.x, pointSc2.y, pff2, enumC0293sc3);
                                            String strPFF2 = (set.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.contains(lowerCase)) ? ExN.pFF(xmlPullParser, "StaticResource") : null;
                                            if (fSc2 < scVar.f28238qr || fSc2 <= f12 || TextUtils.isEmpty(strPFF2)) {
                                                ExN.sc(xmlPullParser, "StaticResource", 3);
                                            } else {
                                                scVar.f28238qr = fSc2;
                                                scVar.sc(strPFF2, enumC0293sc3, pff2);
                                            }
                                            iPFF = i13;
                                            iPFF2 = i12;
                                            scVar2 = scVar;
                                            i17 = i11;
                                            break;
                                        case "CompanionClickTracking":
                                            scVar2.sc(ExN.pFF(xmlPullParser, "CompanionClickTracking"));
                                            break;
                                        case "HTMLResource":
                                            com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF pff3 = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.HTML_RESOURCE;
                                            Point pointSc3 = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.sc(context, iPFF, iPFF2, pff3);
                                            int i25 = pointSc3.x;
                                            int i26 = pointSc3.y;
                                            com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc4 = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.NONE;
                                            ExN.sc scVar4 = scVar2;
                                            int i27 = iPFF2;
                                            int i28 = iPFF;
                                            float fSc3 = com.bytedance.sdk.openadsdk.core.Tf.zY.sc(i16, i17, i25, i26, pff3, enumC0293sc4);
                                            String strPFF3 = ExN.pFF(xmlPullParser, "HTMLResource");
                                            if (TextUtils.isEmpty(strPFF3) || fSc3 <= scVar4.f28238qr || fSc3 <= f12) {
                                                ExN.sc(xmlPullParser, "HTMLResource", 3);
                                            } else {
                                                scVar4.f28238qr = fSc3;
                                                scVar4.sc(strPFF3, enumC0293sc4, pff3);
                                            }
                                            iPFF = i28;
                                            scVar2 = scVar4;
                                            iPFF2 = i27;
                                            break;
                                        default:
                                            ExN.sc(xmlPullParser);
                                            i11 = i17;
                                            scVar = scVar2;
                                            i12 = iPFF2;
                                            i13 = iPFF;
                                            iPFF = i13;
                                            iPFF2 = i12;
                                            scVar2 = scVar;
                                            i17 = i11;
                                            break;
                                    }
                                    i18 = 3;
                                    i19 = 2;
                                } else {
                                    i17 = i17;
                                    i18 = 3;
                                }
                            } else if (!TextUtils.isEmpty(scVar2.f28239sc) && scVar2.f28238qr >= f12) {
                                zYVar = new com.bytedance.sdk.openadsdk.core.Tf.zY(iPFF, iPFF2, scVar2.pFF, scVar2.zY, scVar2.f28239sc, scVar2.ExN, scVar2.TRI, scVar2.We);
                                f12 = scVar2.f28238qr;
                            }
                        }
                    }
                }
            }
            zYVar = zYVar;
            i17 = i17;
        }
    }
}
