package com.applovin.impl;

import android.text.Layout;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.gslb.Utils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class fp extends ek {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Pattern f19063p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Pattern f19064q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Pattern f19065r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final Pattern f19066s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final Pattern f19067t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Pattern f19068u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Pattern f19069v = Pattern.compile("^(\\d+) (\\d+)$");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final b f19070w = new b(30.0f, 1, 1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final a f19071x = new a(32, 15);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final XmlPullParserFactory f19072o;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f19073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f19074b;

        public a(int i11, int i12) {
            this.f19073a = i11;
            this.f19074b = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f19075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f19076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f19077c;

        public b(float f11, int i11, int i12) {
            this.f19075a = f11;
            this.f19076b = i11;
            this.f19077c = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f19078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f19079b;

        public c(int i11, int i12) {
            this.f19078a = i11;
            this.f19079b = i12;
        }
    }

    public fp() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f19072o = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x00b7  */
    private static long a(String str, b bVar) throws pl {
        double d11;
        double d12;
        Matcher matcher = f19063p.matcher(str);
        if (matcher.matches()) {
            double d13 = (Long.parseLong((String) b1.a((Object) matcher.group(1))) * 3600) + (Long.parseLong((String) b1.a((Object) matcher.group(2))) * 60) + Long.parseLong((String) b1.a((Object) matcher.group(3)));
            String strGroup = matcher.group(4);
            double d14 = d13 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d);
            String strGroup2 = matcher.group(5);
            double d15 = d14 + (strGroup2 != null ? Long.parseLong(strGroup2) / bVar.f19075a : 0.0d);
            String strGroup3 = matcher.group(6);
            return (long) ((d15 + (strGroup3 != null ? (Long.parseLong(strGroup3) / ((double) bVar.f19076b)) / ((double) bVar.f19075a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = f19064q.matcher(str);
        if (!matcher2.matches()) {
            throw new pl("Malformed time expression: " + str);
        }
        double d16 = Double.parseDouble((String) b1.a((Object) matcher2.group(1)));
        String str2 = (String) b1.a((Object) matcher2.group(2));
        str2.hashCode();
        switch (str2) {
            case "f":
                d11 = bVar.f19075a;
                d16 /= d11;
                return (long) (d16 * 1000000.0d);
            case "h":
                d12 = 3600.0d;
                break;
            case "m":
                d12 = 60.0d;
                break;
            case "t":
                d11 = bVar.f19077c;
                d16 /= d11;
                return (long) (d16 * 1000000.0d);
            case "ms":
                d11 = 1000.0d;
                d16 /= d11;
                return (long) (d16 * 1000000.0d);
            default:
                return (long) (d16 * 1000000.0d);
        }
        d16 *= d12;
        return (long) (d16 * 1000000.0d);
    }

    private static a a(XmlPullParser xmlPullParser, a aVar) throws pl {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f19069v.matcher(attributeValue);
        if (!matcher.matches()) {
            pc.d("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int i11 = Integer.parseInt((String) b1.a((Object) matcher.group(1)));
            int i12 = Integer.parseInt((String) b1.a((Object) matcher.group(2)));
            if (i11 != 0 && i12 != 0) {
                return new a(i11, i12);
            }
            throw new pl("Invalid cell resolution " + i11 + " " + i12);
        } catch (NumberFormatException unused) {
            pc.d("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    private static b a(XmlPullParser xmlPullParser) throws pl {
        float f11;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i11 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] strArrA = xp.a(attributeValue2, " ");
            if (strArrA.length != 2) {
                throw new pl("frameRateMultiplier doesn't have 2 parts");
            }
            f11 = Integer.parseInt(strArrA[0]) / Integer.parseInt(strArrA[1]);
        } else {
            f11 = 1.0f;
        }
        b bVar = f19070w;
        int i12 = bVar.f19076b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i12 = Integer.parseInt(attributeValue3);
        }
        int i13 = bVar.f19077c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i13 = Integer.parseInt(attributeValue4);
        }
        return new b(i11 * f11, i12, i13);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:67:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:6:0x0039  */
    private static gp a(XmlPullParser xmlPullParser, gp gpVar, Map map, b bVar) throws pl {
        long j11;
        long j12;
        int attributeCount = xmlPullParser.getAttributeCount();
        jp jpVarA = a(xmlPullParser, (jp) null);
        String[] strArr = null;
        String strSubstring = null;
        String str = "";
        long jA = C.TIME_UNSET;
        long jA2 = C.TIME_UNSET;
        long jA3 = C.TIME_UNSET;
        for (int i11 = 0; i11 < attributeCount; i11++) {
            String attributeName = xmlPullParser.getAttributeName(i11);
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            attributeName.hashCode();
            switch (attributeName) {
                case "region":
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                    break;
                case "dur":
                    jA3 = a(attributeValue, bVar);
                    break;
                case "end":
                    jA2 = a(attributeValue, bVar);
                    break;
                case "begin":
                    jA = a(attributeValue, bVar);
                    break;
                case "style":
                    String[] strArrD = d(attributeValue);
                    if (strArrD.length > 0) {
                        strArr = strArrD;
                        break;
                    }
                    break;
                case "backgroundImage":
                    if (attributeValue.startsWith(Utils.SEPARATOR)) {
                        strSubstring = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (gpVar != null) {
            long j13 = gpVar.f19280d;
            j11 = C.TIME_UNSET;
            if (j13 != C.TIME_UNSET) {
                if (jA != C.TIME_UNSET) {
                    jA += j13;
                }
                if (jA2 != C.TIME_UNSET) {
                    jA2 += j13;
                }
            }
        } else {
            j11 = C.TIME_UNSET;
        }
        long j14 = jA;
        if (jA2 != j11) {
            j12 = jA2;
        } else if (jA3 != j11) {
            j12 = j14 + jA3;
        } else if (gpVar != null) {
            long j15 = gpVar.f19281e;
            if (j15 != j11) {
                j12 = j15;
            } else {
                j12 = jA2;
            }
        } else {
            j12 = jA2;
        }
        return gp.a(xmlPullParser.getName(), j14, j12, jpVarA, strArr, str, strSubstring, gpVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x0169  */
    /* JADX WARN: Code duplicated, block: B:49:0x018b  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b4  */
    private static hp a(XmlPullParser xmlPullParser, a aVar, c cVar) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        int i11;
        int i12;
        String strA = gs.a(xmlPullParser, "id");
        if (strA == null) {
            return null;
        }
        String strA2 = gs.a(xmlPullParser, "origin");
        if (strA2 == null) {
            pc.d("TtmlDecoder", "Ignoring region without an origin");
            return null;
        }
        Pattern pattern = f19067t;
        Matcher matcher = pattern.matcher(strA2);
        Pattern pattern2 = f19068u;
        Matcher matcher2 = pattern2.matcher(strA2);
        if (matcher.matches()) {
            try {
                float f16 = Float.parseFloat((String) b1.a((Object) matcher.group(1))) / 100.0f;
                f11 = Float.parseFloat((String) b1.a((Object) matcher.group(2))) / 100.0f;
                f12 = f16;
            } catch (NumberFormatException unused) {
                pc.d("TtmlDecoder", "Ignoring region with malformed origin: " + strA2);
                return null;
            }
        } else {
            if (!matcher2.matches()) {
                pc.d("TtmlDecoder", "Ignoring region with unsupported origin: " + strA2);
                return null;
            }
            if (cVar == null) {
                pc.d("TtmlDecoder", "Ignoring region with missing tts:extent: " + strA2);
                return null;
            }
            try {
                int i13 = Integer.parseInt((String) b1.a((Object) matcher2.group(1)));
                int i14 = Integer.parseInt((String) b1.a((Object) matcher2.group(2)));
                f12 = i13 / cVar.f19078a;
                f11 = i14 / cVar.f19079b;
            } catch (NumberFormatException unused2) {
                pc.d("TtmlDecoder", "Ignoring region with malformed origin: " + strA2);
                return null;
            }
        }
        String strA3 = gs.a(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (strA3 == null) {
            pc.d("TtmlDecoder", "Ignoring region without an extent");
            return null;
        }
        Matcher matcher3 = pattern.matcher(strA3);
        Matcher matcher4 = pattern2.matcher(strA3);
        if (matcher3.matches()) {
            try {
                f13 = Float.parseFloat((String) b1.a((Object) matcher3.group(1))) / 100.0f;
                f14 = Float.parseFloat((String) b1.a((Object) matcher3.group(2))) / 100.0f;
            } catch (NumberFormatException unused3) {
                pc.d("TtmlDecoder", "Ignoring region with malformed extent: " + strA2);
                return null;
            }
        } else {
            if (!matcher4.matches()) {
                pc.d("TtmlDecoder", "Ignoring region with unsupported extent: " + strA2);
                return null;
            }
            if (cVar == null) {
                pc.d("TtmlDecoder", "Ignoring region with missing tts:extent: " + strA2);
                return null;
            }
            try {
                int i15 = Integer.parseInt((String) b1.a((Object) matcher4.group(1)));
                int i16 = Integer.parseInt((String) b1.a((Object) matcher4.group(2)));
                f13 = i15 / cVar.f19078a;
                f14 = i16 / cVar.f19079b;
            } catch (NumberFormatException unused4) {
                pc.d("TtmlDecoder", "Ignoring region with malformed extent: " + strA2);
                return null;
            }
        }
        String strA4 = gs.a(xmlPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
        if (strA4 != null) {
            String lowerCase = Ascii.toLowerCase(strA4);
            lowerCase.hashCode();
            if (lowerCase.equals(TtmlNode.CENTER)) {
                f15 = f11 + (f14 / 2.0f);
                i11 = 1;
            } else if (lowerCase.equals("after")) {
                f15 = f11 + f14;
                i11 = 2;
            } else {
                f15 = f11;
                i11 = 0;
            }
        } else {
            f15 = f11;
            i11 = 0;
        }
        float f17 = 1.0f / aVar.f19074b;
        String strA5 = gs.a(xmlPullParser, "writingMode");
        if (strA5 != null) {
            String lowerCase2 = Ascii.toLowerCase(strA5);
            lowerCase2.hashCode();
            switch (lowerCase2) {
                case "tb":
                case "tblr":
                    i12 = 2;
                    break;
                case "tbrl":
                    i12 = 1;
                    break;
                default:
                    i12 = Integer.MIN_VALUE;
                    break;
            }
        } else {
            i12 = Integer.MIN_VALUE;
        }
        return new hp(strA, f12, f15, 0, i11, f13, f14, 1, f17, i12);
    }

    private static jp a(jp jpVar) {
        return jpVar == null ? new jp() : jpVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:6:0x0020  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static jp a(XmlPullParser xmlPullParser, jp jpVar) {
        byte b11;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            String attributeName = xmlPullParser.getAttributeName(i11);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_STYLE)) {
                        b11 = 0;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -1224696685:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                        b11 = 1;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                        b11 = 2;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                        b11 = 3;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -734428249:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                        b11 = 4;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        b11 = 5;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        b11 = 6;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 94842723:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_COLOR)) {
                        b11 = 7;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 109403361:
                    if (attributeName.equals("shear")) {
                        b11 = 8;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        b11 = 9;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                        b11 = 10;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 921125321:
                    if (attributeName.equals("textEmphasis")) {
                        b11 = Ascii.VT;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        b11 = Ascii.FF;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                        b11 = Ascii.CR;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 1754920356:
                    if (attributeName.equals("multiRowAlign")) {
                        b11 = Ascii.SO;
                    } else {
                        b11 = -1;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            switch (b11) {
                case 0:
                    jpVar = a(jpVar).b(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    jpVar = a(jpVar).a(attributeValue);
                    break;
                case 2:
                    jpVar = a(jpVar).b(b(attributeValue));
                    break;
                case 3:
                    String lowerCase = Ascii.toLowerCase(attributeValue);
                    lowerCase.hashCode();
                    switch (lowerCase) {
                        case "nounderline":
                            jpVar = a(jpVar).e(false);
                            break;
                        case "underline":
                            jpVar = a(jpVar).e(true);
                            break;
                        case "nolinethrough":
                            jpVar = a(jpVar).c(false);
                            break;
                        case "linethrough":
                            jpVar = a(jpVar).c(true);
                            break;
                    }
                    break;
                case 4:
                    jpVar = a(jpVar).a(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if (TtmlNode.TAG_STYLE.equals(xmlPullParser.getName())) {
                        jpVar = a(jpVar).b(attributeValue);
                    }
                    break;
                case 6:
                    String lowerCase2 = Ascii.toLowerCase(attributeValue);
                    lowerCase2.hashCode();
                    switch (lowerCase2) {
                        case "baseContainer":
                        case "base":
                            jpVar = a(jpVar).e(2);
                            break;
                        case "container":
                            jpVar = a(jpVar).e(1);
                            break;
                        case "delimiter":
                            jpVar = a(jpVar).e(4);
                            break;
                        case "textContainer":
                        case "text":
                            jpVar = a(jpVar).e(3);
                            break;
                    }
                    break;
                case 7:
                    jpVar = a(jpVar);
                    try {
                        jpVar.b(s3.b(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        pc.d("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                    }
                    break;
                case 8:
                    jpVar = a(jpVar).b(c(attributeValue));
                    break;
                case 9:
                    String lowerCase3 = Ascii.toLowerCase(attributeValue);
                    lowerCase3.hashCode();
                    if (lowerCase3.equals("all")) {
                        jpVar = a(jpVar).d(true);
                    } else if (lowerCase3.equals(DevicePublicKeyStringDef.NONE)) {
                        jpVar = a(jpVar).d(false);
                    }
                    break;
                case 10:
                    try {
                        jpVar = a(jpVar);
                        a(attributeValue, jpVar);
                    } catch (pl unused2) {
                        pc.d("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                    }
                    break;
                case 11:
                    jpVar = a(jpVar).a(xn.a(attributeValue));
                    break;
                case 12:
                    String lowerCase4 = Ascii.toLowerCase(attributeValue);
                    lowerCase4.hashCode();
                    if (lowerCase4.equals("before")) {
                        jpVar = a(jpVar).d(1);
                    } else if (lowerCase4.equals("after")) {
                        jpVar = a(jpVar).d(2);
                    }
                    break;
                case 13:
                    jpVar = a(jpVar);
                    try {
                        jpVar.a(s3.b(attributeValue));
                    } catch (IllegalArgumentException unused3) {
                        pc.d("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                    }
                    break;
                case 14:
                    jpVar = a(jpVar).a(b(attributeValue));
                    break;
            }
        }
        return jpVar;
    }

    private static Map a(XmlPullParser xmlPullParser, Map map, a aVar, c cVar, Map map2, Map map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (gs.c(xmlPullParser, TtmlNode.TAG_STYLE)) {
                String strA = gs.a(xmlPullParser, TtmlNode.TAG_STYLE);
                jp jpVarA = a(xmlPullParser, new jp());
                if (strA != null) {
                    for (String str : d(strA)) {
                        jpVarA.a((jp) map.get(str));
                    }
                }
                String strF = jpVarA.f();
                if (strF != null) {
                    map.put(strF, jpVarA);
                }
            } else if (gs.c(xmlPullParser, TtmlNode.TAG_REGION)) {
                hp hpVarA = a(xmlPullParser, aVar, cVar);
                if (hpVarA != null) {
                    map2.put(hpVarA.f19520a, hpVarA);
                }
            } else if (gs.c(xmlPullParser, TtmlNode.TAG_METADATA)) {
                a(xmlPullParser, map3);
            }
        } while (!gs.b(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    private static void a(String str, jp jpVar) throws pl {
        Matcher matcher;
        String[] strArrA = xp.a(str, "\\s+");
        if (strArrA.length == 1) {
            matcher = f19065r.matcher(str);
        } else {
            if (strArrA.length != 2) {
                throw new pl("Invalid number of entries for fontSize: " + strArrA.length + InstructionFileId.DOT);
            }
            matcher = f19065r.matcher(strArrA[1]);
            pc.d("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new pl("Invalid expression for fontSize: '" + str + "'.");
        }
        String str2 = (String) b1.a((Object) matcher.group(3));
        str2.hashCode();
        switch (str2) {
            case "%":
                jpVar.c(3);
                break;
            case "em":
                jpVar.c(2);
                break;
            case "px":
                jpVar.c(1);
                break;
            default:
                throw new pl("Invalid unit for fontSize: '" + str2 + "'.");
        }
        jpVar.a(Float.parseFloat((String) b1.a((Object) matcher.group(1))));
    }

    private static void a(XmlPullParser xmlPullParser, Map map) throws XmlPullParserException, IOException {
        String strA;
        do {
            xmlPullParser.next();
            if (gs.c(xmlPullParser, "image") && (strA = gs.a(xmlPullParser, "id")) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!gs.b(xmlPullParser, TtmlNode.TAG_METADATA));
    }

    private static boolean a(String str) {
        return str.equals(TtmlNode.TAG_TT) || str.equals(TtmlNode.TAG_HEAD) || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals(TtmlNode.TAG_P) || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals(TtmlNode.TAG_STYLE) || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals(TtmlNode.TAG_REGION) || str.equals(TtmlNode.TAG_METADATA) || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static Layout.Alignment b(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static c b(XmlPullParser xmlPullParser) {
        String strA = gs.a(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (strA == null) {
            return null;
        }
        Matcher matcher = f19068u.matcher(strA);
        if (!matcher.matches()) {
            pc.d("TtmlDecoder", "Ignoring non-pixel tts extent: " + strA);
            return null;
        }
        try {
            return new c(Integer.parseInt((String) b1.a((Object) matcher.group(1))), Integer.parseInt((String) b1.a((Object) matcher.group(2))));
        } catch (NumberFormatException unused) {
            pc.d("TtmlDecoder", "Ignoring malformed tts extent: " + strA);
            return null;
        }
    }

    private static float c(String str) {
        Matcher matcher = f19066s.matcher(str);
        if (!matcher.matches()) {
            pc.d("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) b1.a((Object) matcher.group(1)))));
        } catch (NumberFormatException e11) {
            pc.c("TtmlDecoder", "Failed to parse shear: " + str, e11);
            return Float.MAX_VALUE;
        }
    }

    private static String[] d(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : xp.a(strTrim, "\\s+");
    }

    @Override // com.applovin.impl.ek
    public nl a(byte[] bArr, int i11, boolean z11) throws pl {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f19072o.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new hp(""));
            c cVarB = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i11), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarA = f19070w;
            a aVarA = f19071x;
            kp kpVar = null;
            int i12 = 0;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                gp gpVar = (gp) arrayDeque.peek();
                if (i12 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            bVarA = a(xmlPullParserNewPullParser);
                            aVarA = a(xmlPullParserNewPullParser, f19071x);
                            cVarB = b(xmlPullParserNewPullParser);
                        }
                        c cVar = cVarB;
                        b bVar2 = bVarA;
                        a aVar = aVarA;
                        if (a(name)) {
                            if (TtmlNode.TAG_HEAD.equals(name)) {
                                bVar = bVar2;
                                a(xmlPullParserNewPullParser, map, aVar, cVar, map2, map3);
                            } else {
                                bVar = bVar2;
                                try {
                                    gp gpVarA = a(xmlPullParserNewPullParser, gpVar, map2, bVar);
                                    arrayDeque.push(gpVarA);
                                    if (gpVar != null) {
                                        gpVar.a(gpVarA);
                                    }
                                } catch (pl e11) {
                                    pc.c("TtmlDecoder", "Suppressing parser error", e11);
                                    bVarA = bVar;
                                    cVarB = cVar;
                                    aVarA = aVar;
                                    i12++;
                                }
                            }
                            bVarA = bVar;
                            cVarB = cVar;
                            aVarA = aVar;
                        } else {
                            pc.c("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            bVar = bVar2;
                        }
                        bVarA = bVar;
                        cVarB = cVar;
                        aVarA = aVar;
                        i12++;
                    } else if (eventType == 4) {
                        ((gp) b1.a(gpVar)).a(gp.a(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            kpVar = new kp((gp) b1.a((gp) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i12++;
                } else if (eventType == 3) {
                    i12--;
                }
                xmlPullParserNewPullParser.next();
            }
            if (kpVar != null) {
                return kpVar;
            }
            throw new pl("No TTML subtitles found");
        } catch (IOException e12) {
            throw new IllegalStateException("Unexpected error when reading input.", e12);
        } catch (XmlPullParserException e13) {
            throw new pl("Unable to decode source", e13);
        }
    }
}
