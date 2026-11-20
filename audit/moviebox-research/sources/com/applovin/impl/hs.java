package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class hs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f19540a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f19541b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f19542c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    private static eb a(XmlPullParser xmlPullParser) {
        for (String str : f19542c) {
            String strA = gs.a(xmlPullParser, str);
            if (strA != null) {
                return eb.a(new mf.a("image/jpeg", "Primary", 0L, 0L), new mf.a(MimeTypes.VIDEO_MP4, "MotionPhoto", Long.parseLong(strA), 0L));
            }
        }
        return eb.h();
    }

    private static eb a(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        eb.a aVarF = eb.f();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (gs.c(xmlPullParser, str3)) {
                String strA = gs.a(xmlPullParser, str2 + ":Mime");
                String strA2 = gs.a(xmlPullParser, str2 + ":Semantic");
                String strA3 = gs.a(xmlPullParser, str2 + ":Length");
                String strA4 = gs.a(xmlPullParser, str2 + ":Padding");
                if (strA == null || strA2 == null) {
                    return eb.h();
                }
                aVarF.b(new mf.a(strA, strA2, strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L));
            }
        } while (!gs.b(xmlPullParser, str4));
        return aVarF.a();
    }

    public static mf a(String str) {
        try {
            return b(str);
        } catch (dh | NumberFormatException | XmlPullParserException unused) {
            pc.d("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static mf b(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!gs.c(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw dh.a("Couldn't find xmp metadata", null);
        }
        eb ebVarH = eb.h();
        long jC = C.TIME_UNSET;
        do {
            xmlPullParserNewPullParser.next();
            if (gs.c(xmlPullParserNewPullParser, "rdf:Description")) {
                if (!b(xmlPullParserNewPullParser)) {
                    return null;
                }
                jC = c(xmlPullParserNewPullParser);
                ebVarH = a(xmlPullParserNewPullParser);
            } else if (gs.c(xmlPullParserNewPullParser, "Container:Directory")) {
                ebVarH = a(xmlPullParserNewPullParser, "Container", "Item");
            } else if (gs.c(xmlPullParserNewPullParser, "GContainer:Directory")) {
                ebVarH = a(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!gs.b(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (ebVarH.isEmpty()) {
            return null;
        }
        return new mf(jC, ebVarH);
    }

    private static boolean b(XmlPullParser xmlPullParser) {
        for (String str : f19540a) {
            String strA = gs.a(xmlPullParser, str);
            if (strA != null) {
                return Integer.parseInt(strA) == 1;
            }
        }
        return false;
    }

    private static long c(XmlPullParser xmlPullParser) {
        for (String str : f19541b) {
            String strA = gs.a(xmlPullParser, str);
            if (strA != null) {
                long j11 = Long.parseLong(strA);
                return j11 == -1 ? C.TIME_UNSET : j11;
            }
        }
        return C.TIME_UNSET;
    }
}
