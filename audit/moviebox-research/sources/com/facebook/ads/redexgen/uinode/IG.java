package com.facebook.ads.redexgen.uinode;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class IG {
    public static String A00(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            if (xmlPullParser.getAttributeName(i11).equals(str)) {
                return xmlPullParser.getAttributeValue(i11);
            }
        }
        return null;
    }

    public static boolean A01(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 3;
    }

    public static boolean A02(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 2;
    }

    public static boolean A03(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return A01(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean A04(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return A02(xmlPullParser) && xmlPullParser.getName().equals(str);
    }
}
