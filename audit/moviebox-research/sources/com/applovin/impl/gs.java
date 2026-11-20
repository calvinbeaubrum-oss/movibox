package com.applovin.impl;

import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class gs {
    public static String a(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            if (xmlPullParser.getAttributeName(i11).equals(str)) {
                return xmlPullParser.getAttributeValue(i11);
            }
        }
        return null;
    }

    public static boolean a(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    public static boolean b(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    public static boolean b(XmlPullParser xmlPullParser, String str) {
        return a(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean c(XmlPullParser xmlPullParser, String str) {
        return b(xmlPullParser) && xmlPullParser.getName().equals(str);
    }
}
