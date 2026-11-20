package com.bytedance.sdk.openadsdk.core.Tf.sc.sc;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    public static double pFF(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String[] strArrSplit = ExN.pFF(xmlPullParser, "Duration").split(":");
        if (strArrSplit.length != 3) {
            return 0.0d;
        }
        try {
            return (Integer.parseInt(strArrSplit[0].trim()) * 3600) + (Integer.parseInt(strArrSplit[1].trim()) * 60) + Float.parseFloat(strArrSplit[2].trim());
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:57:0x0107  */
    /* JADX WARN: Failed to find 'out' block for switch in B:56:0x0104. Please report as an issue. */
    public static com.bytedance.sdk.openadsdk.core.Tf.pFF sc(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        com.bytedance.sdk.openadsdk.core.Tf.pFF pff = null;
        while (true) {
            int i11 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals("Icons")) {
                return pff;
            }
            xmlPullParser.next();
            int i12 = 2;
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Icon")) {
                String str = ExN.f28237qr;
                int iPFF = ExN.pFF(xmlPullParser.getAttributeValue(str, "width"));
                int iPFF2 = ExN.pFF(xmlPullParser.getAttributeValue(str, "height"));
                if (iPFF <= 0 || iPFF > 300 || iPFF2 <= 0 || iPFF2 > 300) {
                    ExN.sc(xmlPullParser);
                } else {
                    int iSc = com.bytedance.sdk.openadsdk.core.Tf.pFF.sc.sc(xmlPullParser.getAttributeValue(str, "offset"));
                    int iSc2 = com.bytedance.sdk.openadsdk.core.Tf.pFF.sc.sc(xmlPullParser.getAttributeValue(str, "duration"));
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ExN.sc scVar = null;
                    String strPFF = null;
                    while (true) {
                        if (xmlPullParser.next() != i11 || !xmlPullParser.getName().equals("Icon")) {
                            arrayList3 = arrayList3;
                            ArrayList arrayList5 = arrayList4;
                            if (xmlPullParser.getEventType() == i12) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                switch (name) {
                                    case "IconViewTracking":
                                        arrayList = arrayList5;
                                        arrayList.add(new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(ExN.pFF(xmlPullParser, "IconViewTracking")).sc());
                                        break;
                                    case "IFrameResource":
                                        arrayList3 = arrayList3;
                                        if (scVar == null) {
                                            scVar = new ExN.sc(ExN.pFF(xmlPullParser, "IFrameResource"), com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.NONE, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.IFRAME_RESOURCE);
                                        } else {
                                            ExN.sc(xmlPullParser);
                                        }
                                        arrayList4 = arrayList5;
                                        break;
                                    case "StaticResource":
                                        arrayList3 = arrayList3;
                                        com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.NONE;
                                        String lowerCase = xmlPullParser.getAttributeValue(ExN.f28237qr, "creativeType").toLowerCase();
                                        Set<String> set = com.bytedance.sdk.openadsdk.core.Tf.zY.sc.f28245sc;
                                        scVar = new ExN.sc((set.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.contains(lowerCase)) ? ExN.pFF(xmlPullParser, "StaticResource") : null, set.contains(lowerCase) ? com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.IMAGE : com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.JAVASCRIPT, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.STATIC_RESOURCE);
                                        arrayList4 = arrayList5;
                                        break;
                                    case "IconClicks":
                                        while (true) {
                                            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("IconClicks")) {
                                                arrayList3 = arrayList3;
                                                arrayList4 = arrayList5;
                                            } else {
                                                if (xmlPullParser.getEventType() == 2) {
                                                    if (xmlPullParser.getName().equals("IconClickThrough")) {
                                                        strPFF = ExN.pFF(xmlPullParser, "IconClickThrough");
                                                    } else {
                                                        if (xmlPullParser.getName().equals("IconClickTracking")) {
                                                            arrayList2 = arrayList3;
                                                            arrayList2.add(new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(ExN.pFF(xmlPullParser, "IconClickTracking")).sc());
                                                        }
                                                        arrayList3 = arrayList2;
                                                    }
                                                }
                                                arrayList2 = arrayList3;
                                                arrayList3 = arrayList2;
                                            }
                                            break;
                                        }
                                        break;
                                    case "HTMLResource":
                                        if (scVar == null || scVar.zY == com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.IFRAME_RESOURCE) {
                                            scVar = new ExN.sc(ExN.pFF(xmlPullParser, "HTMLResource"), com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.NONE, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.HTML_RESOURCE);
                                            arrayList3 = arrayList3;
                                        } else {
                                            arrayList3 = arrayList3;
                                            ExN.sc(xmlPullParser);
                                        }
                                        arrayList4 = arrayList5;
                                        break;
                                    default:
                                        arrayList3 = arrayList3;
                                        ExN.sc(xmlPullParser);
                                        arrayList4 = arrayList5;
                                        break;
                                }
                                i11 = 3;
                                i12 = 2;
                            } else {
                                arrayList = arrayList5;
                            }
                            arrayList4 = arrayList;
                            i11 = 3;
                            i12 = 2;
                        } else if (scVar != null && (pff == null || TextUtils.isEmpty(pff.TRI()))) {
                            pff = new com.bytedance.sdk.openadsdk.core.Tf.pFF(iPFF, iPFF2, iSc, iSc2, scVar.pFF, scVar.zY, scVar.f28239sc, arrayList3, arrayList4, strPFF);
                            ExN.sc(xmlPullParser, "Icons", i11);
                        }
                    }
                }
            }
        }
    }

    private static String sc(XmlPullParser xmlPullParser, int i11, double d11, com.bytedance.sdk.openadsdk.core.Tf.sc scVar) throws XmlPullParserException, IOException {
        double d12 = Double.NEGATIVE_INFINITY;
        String str = null;
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MIN_VALUE;
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("MediaFiles")) {
                break;
            }
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("MediaFile")) {
                String str2 = ExN.f28237qr;
                String attributeValue = xmlPullParser.getAttributeValue(str2, "type");
                int iPFF = ExN.pFF(xmlPullParser.getAttributeValue(str2, "width"));
                int iPFF2 = ExN.pFF(xmlPullParser.getAttributeValue(str2, "height"));
                int iPFF3 = ExN.pFF(xmlPullParser.getAttributeValue(str2, "bitrate"));
                String strPFF = ExN.pFF(xmlPullParser, "MediaFile");
                if (iPFF > 0 && iPFF2 > 0 && com.bytedance.sdk.openadsdk.core.Tf.zY.We.f28243sc.contains(attributeValue) && !TextUtils.isEmpty(strPFF)) {
                    double dSc = com.bytedance.sdk.openadsdk.core.Tf.zY.We.sc(i11, d11, iPFF, iPFF2, iPFF3, attributeValue);
                    if (dSc > d12) {
                        str = strPFF;
                        d12 = dSc;
                        i12 = iPFF;
                        i13 = iPFF2;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            scVar.We(str);
            scVar.sc(i12);
            scVar.pFF(i13);
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void sc(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.Tf.We we2) throws XmlPullParserException, IOException {
        while (true) {
            byte b11 = 3;
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                if ("Tracking".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(ExN.f28237qr, NotificationCompat.CATEGORY_EVENT);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        attributeValue.hashCode();
                        switch (attributeValue.hashCode()) {
                            case -1638835128:
                                if (!attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT)) {
                                    b11 = -1;
                                } else {
                                    b11 = 0;
                                }
                                break;
                            case -1337830390:
                                if (!attributeValue.equals("thirdQuartile")) {
                                    b11 = -1;
                                } else {
                                    b11 = 1;
                                }
                                break;
                            case -934426579:
                                if (!attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_RESUME)) {
                                    b11 = -1;
                                } else {
                                    b11 = 2;
                                }
                                break;
                            case -840405966:
                                if (!attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_UNMUTE)) {
                                    b11 = -1;
                                }
                                break;
                            case -599445191:
                                if (!attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE)) {
                                    b11 = -1;
                                } else {
                                    b11 = 4;
                                }
                                break;
                            case 3363353:
                                if (!attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                                    b11 = -1;
                                } else {
                                    b11 = 5;
                                }
                                break;
                            case 3532159:
                                if (!attributeValue.equals("skip")) {
                                    b11 = -1;
                                } else {
                                    b11 = 6;
                                }
                                break;
                            case 94756344:
                                if (!attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_CLOSE)) {
                                    b11 = -1;
                                } else {
                                    b11 = 7;
                                }
                                break;
                            case 106440182:
                                if (!attributeValue.equals("pause")) {
                                    b11 = -1;
                                } else {
                                    b11 = 8;
                                }
                                break;
                            case 109757538:
                                if (!attributeValue.equals("start")) {
                                    b11 = -1;
                                } else {
                                    b11 = 9;
                                }
                                break;
                            case 560220243:
                                if (!attributeValue.equals("firstQuartile")) {
                                    b11 = -1;
                                } else {
                                    b11 = 10;
                                }
                                break;
                            case 1778167540:
                                if (!attributeValue.equals("creativeView")) {
                                    b11 = -1;
                                } else {
                                    b11 = Ascii.VT;
                                }
                                break;
                            default:
                                b11 = -1;
                                break;
                        }
                        switch (b11) {
                            case 0:
                                we2.sc(ExN.pFF(xmlPullParser, "Tracking"), 0.5f);
                                break;
                            case 1:
                                we2.sc(ExN.pFF(xmlPullParser, "Tracking"), 0.75f);
                                break;
                            case 2:
                                we2.zY(zY(xmlPullParser));
                                break;
                            case 3:
                                we2.Tf(zY(xmlPullParser));
                                break;
                            case 4:
                                we2.We(zY(xmlPullParser));
                                break;
                            case 5:
                                we2.UFX(zY(xmlPullParser));
                                break;
                            case 6:
                                we2.TRI(zY(xmlPullParser));
                                break;
                            case 7:
                                we2.ExN(zY(xmlPullParser));
                                break;
                            case 8:
                                we2.pFF(zY(xmlPullParser));
                                break;
                            case 9:
                            case 11:
                                we2.sc(ExN.pFF(xmlPullParser, "Tracking"), 0L);
                                break;
                            case 10:
                                we2.sc(ExN.pFF(xmlPullParser, "Tracking"), 0.25f);
                                break;
                        }
                    } else {
                        ExN.sc(xmlPullParser, "Tracking", 3);
                    }
                } else if (xmlPullParser.getEventType() == 4) {
                    xmlPullParser.nextTag();
                } else {
                    ExN.sc(xmlPullParser);
                }
            }
        }
    }

    private static void sc(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.Tf.sc scVar) throws XmlPullParserException, IOException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("VideoClicks")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("ClickThrough")) {
                    scVar.zY(ExN.pFF(xmlPullParser, "ClickThrough"));
                } else if (name.equals("ClickTracking")) {
                    scVar.sc().qr(ExN.sc(xmlPullParser, "ClickTracking"));
                } else {
                    ExN.sc(xmlPullParser);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    public static void sc(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.Tf.sc scVar, int i11, double d11) throws XmlPullParserException, IOException {
        boolean z11 = false;
        while (true) {
            if (xmlPullParser.next() != 3 || !xmlPullParser.getName().equals("Linear")) {
                if (xmlPullParser.getEventType() == 2) {
                    if (z11 && TextUtils.isEmpty(scVar.qr())) {
                        ExN.sc(xmlPullParser);
                    }
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    switch (name) {
                        case "VideoClicks":
                            sc(xmlPullParser, scVar);
                            break;
                        case "Duration":
                            scVar.sc(pFF(xmlPullParser));
                            break;
                        case "MediaFiles":
                            sc(xmlPullParser, i11, d11, scVar);
                            z11 = true;
                            break;
                        case "Icons":
                            com.bytedance.sdk.openadsdk.core.Tf.pFF pffSc = sc(xmlPullParser);
                            if (pffSc != null && scVar.pFF() == null) {
                                scVar.sc(pffSc);
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "TrackingEvents":
                            sc(xmlPullParser, scVar.sc());
                            break;
                        default:
                            ExN.sc(xmlPullParser);
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> zY(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return ExN.sc(xmlPullParser, "Tracking");
    }
}
