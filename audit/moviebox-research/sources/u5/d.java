package u5;

import android.text.Layout;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.SubtitleDecoderException;
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
import o5.i;
import o5.k;
import o5.r;
import o5.s;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import z3.o;
import z3.u0;
import z3.w0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f78436b = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f78437c = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f78438d = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f78439e = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f78440f = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f78441g = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f78442h = Pattern.compile("^(\\d+) (\\d+)$");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f78443i = new a(30.0f, 1, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f78444a;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f78445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f78446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f78447c;

        public a(float f11, int i11, int i12) {
            this.f78445a = f11;
            this.f78446b = i11;
            this.f78447c = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f78448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f78449b;

        public b(int i11, int i12) {
            this.f78448a = i11;
            this.f78449b = i12;
        }
    }

    public d() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f78444a = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    public static g e(@Nullable g gVar) {
        return gVar == null ? new g() : gVar;
    }

    public static boolean f(String str) {
        return str.equals(TtmlNode.TAG_TT) || str.equals(TtmlNode.TAG_HEAD) || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals(TtmlNode.TAG_P) || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals(TtmlNode.TAG_STYLE) || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals(TtmlNode.TAG_REGION) || str.equals(TtmlNode.TAG_METADATA) || str.equals("image") || str.equals("data") || str.equals("information");
    }

    @Nullable
    public static Layout.Alignment g(String str) {
        String strE = com.google.common.base.a.e(str);
        strE.hashCode();
        switch (strE) {
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

    public static int h(XmlPullParser xmlPullParser, int i11) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return i11;
        }
        Matcher matcher = f78442h.matcher(attributeValue);
        if (!matcher.matches()) {
            o.h("TtmlParser", "Ignoring malformed cell resolution: " + attributeValue);
            return i11;
        }
        boolean z11 = true;
        try {
            int i12 = Integer.parseInt((String) z3.a.e(matcher.group(1)));
            int i13 = Integer.parseInt((String) z3.a.e(matcher.group(2)));
            if (i12 == 0 || i13 == 0) {
                z11 = false;
            }
            z3.a.b(z11, "Invalid cell resolution " + i12 + " " + i13);
            return i13;
        } catch (NumberFormatException unused) {
            o.h("TtmlParser", "Ignoring malformed cell resolution: " + attributeValue);
            return i11;
        }
    }

    public static void i(String str, g gVar) throws SubtitleDecoderException {
        Matcher matcher;
        String[] strArrO1 = u0.o1(str, "\\s+");
        if (strArrO1.length == 1) {
            matcher = f78438d.matcher(str);
        } else {
            if (strArrO1.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + strArrO1.length + InstructionFileId.DOT);
            }
            matcher = f78438d.matcher(strArrO1[1]);
            o.h("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        String str2 = (String) z3.a.e(matcher.group(3));
        str2.hashCode();
        switch (str2) {
            case "%":
                gVar.z(3);
                break;
            case "em":
                gVar.z(2);
                break;
            case "px":
                gVar.z(1);
                break;
            default:
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
        }
        gVar.y(Float.parseFloat((String) z3.a.e(matcher.group(1))));
    }

    public static a j(XmlPullParser xmlPullParser) {
        float f11;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i11 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] strArrO1 = u0.o1(attributeValue2, " ");
            z3.a.b(strArrO1.length == 2, "frameRateMultiplier doesn't have 2 parts");
            f11 = Integer.parseInt(strArrO1[0]) / Integer.parseInt(strArrO1[1]);
        } else {
            f11 = 1.0f;
        }
        a aVar = f78443i;
        int i12 = aVar.f78446b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i12 = Integer.parseInt(attributeValue3);
        }
        int i13 = aVar.f78447c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i13 = Integer.parseInt(attributeValue4);
        }
        return new a(i11 * f11, i12, i13);
    }

    public static Map<String, g> k(XmlPullParser xmlPullParser, Map<String, g> map, int i11, @Nullable b bVar, Map<String, e> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, TtmlNode.TAG_STYLE)) {
                String strA = w0.a(xmlPullParser, TtmlNode.TAG_STYLE);
                g gVarP = p(xmlPullParser, new g());
                if (strA != null) {
                    for (String str : q(strA)) {
                        gVarP.a(map.get(str));
                    }
                }
                String strG = gVarP.g();
                if (strG != null) {
                    map.put(strG, gVarP);
                }
            } else if (w0.f(xmlPullParser, TtmlNode.TAG_REGION)) {
                e eVarN = n(xmlPullParser, i11, bVar);
                if (eVarN != null) {
                    map2.put(eVarN.f78450a, eVarN);
                }
            } else if (w0.f(xmlPullParser, TtmlNode.TAG_METADATA)) {
                l(xmlPullParser, map3);
            }
        } while (!w0.d(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    public static void l(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        String strA;
        do {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "image") && (strA = w0.a(xmlPullParser, "id")) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!w0.d(xmlPullParser, TtmlNode.TAG_METADATA));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:67:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:6:0x0039  */
    public static c m(XmlPullParser xmlPullParser, @Nullable c cVar, Map<String, e> map, a aVar) throws SubtitleDecoderException {
        long j11;
        long j12;
        int attributeCount = xmlPullParser.getAttributeCount();
        g gVarP = p(xmlPullParser, null);
        String[] strArr = null;
        String strSubstring = null;
        String str = "";
        long jR = C.TIME_UNSET;
        long jR2 = C.TIME_UNSET;
        long jR3 = C.TIME_UNSET;
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
                    jR3 = r(attributeValue, aVar);
                    break;
                case "end":
                    jR2 = r(attributeValue, aVar);
                    break;
                case "begin":
                    jR = r(attributeValue, aVar);
                    break;
                case "style":
                    String[] strArrQ = q(attributeValue);
                    if (strArrQ.length > 0) {
                        strArr = strArrQ;
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
        if (cVar != null) {
            long j13 = cVar.f78426d;
            j11 = C.TIME_UNSET;
            if (j13 != C.TIME_UNSET) {
                if (jR != C.TIME_UNSET) {
                    jR += j13;
                }
                if (jR2 != C.TIME_UNSET) {
                    jR2 += j13;
                }
            }
        } else {
            j11 = C.TIME_UNSET;
        }
        long j14 = jR;
        if (jR2 != j11) {
            j12 = jR2;
        } else if (jR3 != j11) {
            j12 = j14 + jR3;
        } else if (cVar != null) {
            long j15 = cVar.f78427e;
            if (j15 != j11) {
                j12 = j15;
            } else {
                j12 = jR2;
            }
        } else {
            j12 = jR2;
        }
        return c.c(xmlPullParser.getName(), j14, j12, gVarP, strArr, str, strSubstring, cVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x0165  */
    /* JADX WARN: Code duplicated, block: B:49:0x0185  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ae  */
    @Nullable
    public static e n(XmlPullParser xmlPullParser, int i11, @Nullable b bVar) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        int i12;
        int i13;
        String strA = w0.a(xmlPullParser, "id");
        if (strA == null) {
            return null;
        }
        String strA2 = w0.a(xmlPullParser, "origin");
        if (strA2 == null) {
            o.h("TtmlParser", "Ignoring region without an origin");
            return null;
        }
        Pattern pattern = f78440f;
        Matcher matcher = pattern.matcher(strA2);
        Pattern pattern2 = f78441g;
        Matcher matcher2 = pattern2.matcher(strA2);
        if (matcher.matches()) {
            try {
                float f16 = Float.parseFloat((String) z3.a.e(matcher.group(1))) / 100.0f;
                f11 = Float.parseFloat((String) z3.a.e(matcher.group(2))) / 100.0f;
                f12 = f16;
            } catch (NumberFormatException unused) {
                o.h("TtmlParser", "Ignoring region with malformed origin: " + strA2);
                return null;
            }
        } else {
            if (!matcher2.matches()) {
                o.h("TtmlParser", "Ignoring region with unsupported origin: " + strA2);
                return null;
            }
            if (bVar == null) {
                o.h("TtmlParser", "Ignoring region with missing tts:extent: " + strA2);
                return null;
            }
            try {
                int i14 = Integer.parseInt((String) z3.a.e(matcher2.group(1)));
                int i15 = Integer.parseInt((String) z3.a.e(matcher2.group(2)));
                f12 = i14 / bVar.f78448a;
                f11 = i15 / bVar.f78449b;
            } catch (NumberFormatException unused2) {
                o.h("TtmlParser", "Ignoring region with malformed origin: " + strA2);
                return null;
            }
        }
        String strA3 = w0.a(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (strA3 == null) {
            o.h("TtmlParser", "Ignoring region without an extent");
            return null;
        }
        Matcher matcher3 = pattern.matcher(strA3);
        Matcher matcher4 = pattern2.matcher(strA3);
        if (matcher3.matches()) {
            try {
                f13 = Float.parseFloat((String) z3.a.e(matcher3.group(1))) / 100.0f;
                f14 = Float.parseFloat((String) z3.a.e(matcher3.group(2))) / 100.0f;
            } catch (NumberFormatException unused3) {
                o.h("TtmlParser", "Ignoring region with malformed extent: " + strA2);
                return null;
            }
        } else {
            if (!matcher4.matches()) {
                o.h("TtmlParser", "Ignoring region with unsupported extent: " + strA2);
                return null;
            }
            if (bVar == null) {
                o.h("TtmlParser", "Ignoring region with missing tts:extent: " + strA2);
                return null;
            }
            try {
                int i16 = Integer.parseInt((String) z3.a.e(matcher4.group(1)));
                int i17 = Integer.parseInt((String) z3.a.e(matcher4.group(2)));
                f13 = i16 / bVar.f78448a;
                f14 = i17 / bVar.f78449b;
            } catch (NumberFormatException unused4) {
                o.h("TtmlParser", "Ignoring region with malformed extent: " + strA2);
                return null;
            }
        }
        String strA4 = w0.a(xmlPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
        if (strA4 != null) {
            String strE = com.google.common.base.a.e(strA4);
            strE.hashCode();
            if (strE.equals(TtmlNode.CENTER)) {
                f15 = f11 + (f14 / 2.0f);
                i12 = 1;
            } else if (strE.equals("after")) {
                f15 = f11 + f14;
                i12 = 2;
            } else {
                f15 = f11;
                i12 = 0;
            }
        } else {
            f15 = f11;
            i12 = 0;
        }
        float f17 = 1.0f / i11;
        String strA5 = w0.a(xmlPullParser, "writingMode");
        if (strA5 != null) {
            String strE2 = com.google.common.base.a.e(strA5);
            strE2.hashCode();
            switch (strE2) {
                case "tb":
                case "tblr":
                    i13 = 2;
                    break;
                case "tbrl":
                    i13 = 1;
                    break;
                default:
                    i13 = Integer.MIN_VALUE;
                    break;
            }
        } else {
            i13 = Integer.MIN_VALUE;
        }
        return new e(strA, f12, f15, 0, i12, f13, f14, 1, f17, i13);
    }

    public static float o(String str) {
        Matcher matcher = f78439e.matcher(str);
        if (!matcher.matches()) {
            o.h("TtmlParser", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) z3.a.e(matcher.group(1)))));
        } catch (NumberFormatException e11) {
            o.i("TtmlParser", "Failed to parse shear: " + str, e11);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:6:0x0020  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static g p(XmlPullParser xmlPullParser, g gVar) {
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
                    gVar = e(gVar).B(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    gVar = e(gVar).x(attributeValue);
                    break;
                case 2:
                    gVar = e(gVar).H(g(attributeValue));
                    break;
                case 3:
                    String strE = com.google.common.base.a.e(attributeValue);
                    strE.hashCode();
                    switch (strE) {
                        case "nounderline":
                            gVar = e(gVar).K(false);
                            break;
                        case "underline":
                            gVar = e(gVar).K(true);
                            break;
                        case "nolinethrough":
                            gVar = e(gVar).C(false);
                            break;
                        case "linethrough":
                            gVar = e(gVar).C(true);
                            break;
                    }
                    break;
                case 4:
                    gVar = e(gVar).v(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if (TtmlNode.TAG_STYLE.equals(xmlPullParser.getName())) {
                        gVar = e(gVar).A(attributeValue);
                    }
                    break;
                case 6:
                    String strE2 = com.google.common.base.a.e(attributeValue);
                    strE2.hashCode();
                    switch (strE2) {
                        case "baseContainer":
                        case "base":
                            gVar = e(gVar).F(2);
                            break;
                        case "container":
                            gVar = e(gVar).F(1);
                            break;
                        case "delimiter":
                            gVar = e(gVar).F(4);
                            break;
                        case "textContainer":
                        case "text":
                            gVar = e(gVar).F(3);
                            break;
                    }
                    break;
                case 7:
                    gVar = e(gVar);
                    try {
                        gVar.w(z3.f.c(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        o.h("TtmlParser", "Failed parsing color value: " + attributeValue);
                    }
                    break;
                case 8:
                    gVar = e(gVar).G(o(attributeValue));
                    break;
                case 9:
                    String strE3 = com.google.common.base.a.e(attributeValue);
                    strE3.hashCode();
                    if (strE3.equals("all")) {
                        gVar = e(gVar).I(true);
                    } else if (strE3.equals(DevicePublicKeyStringDef.NONE)) {
                        gVar = e(gVar).I(false);
                    }
                    break;
                case 10:
                    try {
                        gVar = e(gVar);
                        i(attributeValue, gVar);
                    } catch (SubtitleDecoderException unused2) {
                        o.h("TtmlParser", "Failed parsing fontSize value: " + attributeValue);
                    }
                    break;
                case 11:
                    gVar = e(gVar).J(u5.b.a(attributeValue));
                    break;
                case 12:
                    String strE4 = com.google.common.base.a.e(attributeValue);
                    strE4.hashCode();
                    if (strE4.equals("before")) {
                        gVar = e(gVar).E(1);
                    } else if (strE4.equals("after")) {
                        gVar = e(gVar).E(2);
                    }
                    break;
                case 13:
                    gVar = e(gVar);
                    try {
                        gVar.u(z3.f.c(attributeValue));
                    } catch (IllegalArgumentException unused3) {
                        o.h("TtmlParser", "Failed parsing background value: " + attributeValue);
                    }
                    break;
                case 14:
                    gVar = e(gVar).D(g(attributeValue));
                    break;
            }
        }
        return gVar;
    }

    public static String[] q(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : u0.o1(strTrim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x00b7  */
    public static long r(String str, a aVar) throws SubtitleDecoderException {
        double d11;
        double d12;
        Matcher matcher = f78436b.matcher(str);
        if (matcher.matches()) {
            double d13 = (Long.parseLong((String) z3.a.e(matcher.group(1))) * 3600) + (Long.parseLong((String) z3.a.e(matcher.group(2))) * 60) + Long.parseLong((String) z3.a.e(matcher.group(3)));
            String strGroup = matcher.group(4);
            double d14 = d13 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d);
            String strGroup2 = matcher.group(5);
            double d15 = d14 + (strGroup2 != null ? Long.parseLong(strGroup2) / aVar.f78445a : 0.0d);
            String strGroup3 = matcher.group(6);
            return (long) ((d15 + (strGroup3 != null ? (Long.parseLong(strGroup3) / ((double) aVar.f78446b)) / ((double) aVar.f78445a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = f78437c.matcher(str);
        if (!matcher2.matches()) {
            throw new SubtitleDecoderException("Malformed time expression: " + str);
        }
        double d16 = Double.parseDouble((String) z3.a.e(matcher2.group(1)));
        String str2 = (String) z3.a.e(matcher2.group(2));
        str2.hashCode();
        switch (str2) {
            case "f":
                d11 = aVar.f78445a;
                d16 /= d11;
                return (long) (d16 * 1000000.0d);
            case "h":
                d12 = 3600.0d;
                break;
            case "m":
                d12 = 60.0d;
                break;
            case "t":
                d11 = aVar.f78447c;
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

    @Nullable
    public static b s(XmlPullParser xmlPullParser) {
        String strA = w0.a(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (strA == null) {
            return null;
        }
        Matcher matcher = f78441g.matcher(strA);
        if (!matcher.matches()) {
            o.h("TtmlParser", "Ignoring non-pixel tts extent: " + strA);
            return null;
        }
        try {
            return new b(Integer.parseInt((String) z3.a.e(matcher.group(1))), Integer.parseInt((String) z3.a.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            o.h("TtmlParser", "Ignoring malformed tts extent: " + strA);
            return null;
        }
    }

    @Override // o5.s
    public /* synthetic */ void a(byte[] bArr, s.b bVar, z3.h hVar) {
        r.a(this, bArr, bVar, hVar);
    }

    @Override // o5.s
    public k b(byte[] bArr, int i11, int i12) {
        a aVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f78444a.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new e(""));
            b bVarS = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i11, i12), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            a aVarJ = f78443i;
            h hVar = null;
            int iH = 15;
            int i13 = 0;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                c cVar = (c) arrayDeque.peek();
                if (i13 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            aVarJ = j(xmlPullParserNewPullParser);
                            iH = h(xmlPullParserNewPullParser, 15);
                            bVarS = s(xmlPullParserNewPullParser);
                        }
                        b bVar = bVarS;
                        a aVar2 = aVarJ;
                        int i14 = iH;
                        if (f(name)) {
                            if (TtmlNode.TAG_HEAD.equals(name)) {
                                aVar = aVar2;
                                k(xmlPullParserNewPullParser, map, i14, bVar, map2, map3);
                            } else {
                                aVar = aVar2;
                                try {
                                    c cVarM = m(xmlPullParserNewPullParser, cVar, map2, aVar);
                                    arrayDeque.push(cVarM);
                                    if (cVar != null) {
                                        cVar.a(cVarM);
                                    }
                                } catch (SubtitleDecoderException e11) {
                                    o.i("TtmlParser", "Suppressing parser error", e11);
                                    i13++;
                                }
                            }
                            aVarJ = aVar;
                        } else {
                            o.f("TtmlParser", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i13++;
                            aVarJ = aVar2;
                        }
                        bVarS = bVar;
                        iH = i14;
                    } else if (eventType == 4) {
                        ((c) z3.a.e(cVar)).a(c.d(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            hVar = new h((c) z3.a.e((c) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i13++;
                } else if (eventType == 3) {
                    i13--;
                }
                xmlPullParserNewPullParser.next();
            }
            return (k) z3.a.e(hVar);
        } catch (IOException e12) {
            throw new IllegalStateException("Unexpected error when reading input.", e12);
        } catch (XmlPullParserException e13) {
            throw new IllegalStateException("Unable to decode source", e13);
        }
    }

    @Override // o5.s
    public void c(byte[] bArr, int i11, int i12, s.b bVar, z3.h<o5.e> hVar) {
        i.c(b(bArr, i11, i12), bVar, hVar);
    }

    @Override // o5.s
    public int d() {
        return 1;
    }

    @Override // o5.s
    public /* synthetic */ void reset() {
        r.c(this);
    }
}
