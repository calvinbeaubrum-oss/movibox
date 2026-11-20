package com.bytedance.sdk.openadsdk.core.Tf.sc.sc;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    public static com.bytedance.sdk.openadsdk.core.Tf.sc sc(Context context, XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list, int i11, double d11) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, ExN.f28237qr, "InLine");
        com.bytedance.sdk.openadsdk.core.Tf.sc scVar = new com.bytedance.sdk.openadsdk.core.Tf.sc();
        while (true) {
            if (xmlPullParser.next() == 3 && "InLine".equals(xmlPullParser.getName())) {
                scVar.sc().WH(list);
                return scVar;
            }
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "AdVerifications":
                        scVar.sc(We.sc(xmlPullParser));
                        continue;
                        break;
                    case "Creatives":
                        if (!TextUtils.isEmpty(scVar.qr()) && scVar.zY() != null) {
                            break;
                        } else {
                            while (xmlPullParser.next() != 3) {
                                if (xmlPullParser.getEventType() == 2) {
                                    if ("Creative".equals(xmlPullParser.getName())) {
                                        sc(context, xmlPullParser, scVar, i11, d11);
                                    } else {
                                        ExN.sc(xmlPullParser);
                                    }
                                }
                            }
                            break;
                        }
                        break;
                    case "Description":
                        scVar.pFF(ExN.pFF(xmlPullParser, name));
                        continue;
                        break;
                    case "Error":
                        list.addAll(ExN.sc(xmlPullParser, name));
                        continue;
                        break;
                    case "Extensions":
                        while (true) {
                            if (xmlPullParser.getEventType() == 3 && "Extensions".equals(xmlPullParser.getName())) {
                                continue;
                                break;
                            } else {
                                xmlPullParser.next();
                                if (xmlPullParser.getEventType() == 2 && "AdVerifications".equals(xmlPullParser.getName())) {
                                    scVar.sc(We.sc(xmlPullParser));
                                }
                            }
                        }
                        break;
                    case "AdTitle":
                        scVar.sc(ExN.pFF(xmlPullParser, name));
                        continue;
                        break;
                    case "Impression":
                        scVar.sc().sc(ExN.sc(xmlPullParser, name));
                        continue;
                        break;
                }
                ExN.sc(xmlPullParser);
            }
        }
    }

    public static void sc(Context context, XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.Tf.sc scVar, int i11, double d11) throws XmlPullParserException, IOException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Linear".equals(xmlPullParser.getName()) && TextUtils.isEmpty(scVar.qr())) {
                    zY.sc(xmlPullParser, scVar, i11, d11);
                } else if ("CompanionAds".equals(xmlPullParser.getName()) && scVar.zY() == null) {
                    scVar.sc(sc.sc(context, xmlPullParser));
                } else {
                    ExN.sc(xmlPullParser);
                }
            }
        }
    }
}
