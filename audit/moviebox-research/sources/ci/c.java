package ci;

import android.text.Layout;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
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
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends vh.h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern f14862p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f14863q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Pattern f14864r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f14865s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f14866t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f14867u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pattern f14868v = Pattern.compile("^(\\d+) (\\d+)$");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final b f14869w = new b(30.0f, 1, 1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f14870x = new a(32, 15);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final XmlPullParserFactory f14871o;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14873b;

        public a(int i11, int i12) {
            this.f14872a = i11;
            this.f14873b = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f14874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14876c;

        public b(float f11, int i11, int i12) {
            this.f14874a = f11;
            this.f14875b = i11;
            this.f14876c = i12;
        }
    }

    /* JADX INFO: renamed from: ci.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0156c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14878b;

        public C0156c(int i11, int i12) {
            this.f14877a = i11;
            this.f14878b = i12;
        }
    }

    public c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f14871o = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    public static a A(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f14868v.matcher(attributeValue);
        if (!matcher.matches()) {
            s.i("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int i11 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            int i12 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
            if (i11 != 0 && i12 != 0) {
                return new a(i11, i12);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + i11 + " " + i12);
        } catch (NumberFormatException unused) {
            s.i("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    public static void B(String str, g gVar) throws SubtitleDecoderException {
        Matcher matcher;
        String[] strArrT0 = o0.T0(str, "\\s+");
        if (strArrT0.length == 1) {
            matcher = f14864r.matcher(str);
        } else {
            if (strArrT0.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + strArrT0.length + InstructionFileId.DOT);
            }
            matcher = f14864r.matcher(strArrT0[1]);
            s.i("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(3));
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
        gVar.y(Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))));
    }

    public static b C(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        float f11;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i11 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] strArrT0 = o0.T0(attributeValue2, " ");
            if (strArrT0.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f11 = Integer.parseInt(strArrT0[0]) / Integer.parseInt(strArrT0[1]);
        } else {
            f11 = 1.0f;
        }
        b bVar = f14869w;
        int i12 = bVar.f14875b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i12 = Integer.parseInt(attributeValue3);
        }
        int i13 = bVar.f14876c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i13 = Integer.parseInt(attributeValue4);
        }
        return new b(i11 * f11, i12, i13);
    }

    public static Map<String, g> D(XmlPullParser xmlPullParser, Map<String, g> map, a aVar, @Nullable C0156c c0156c, Map<String, e> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (p0.f(xmlPullParser, TtmlNode.TAG_STYLE)) {
                String strA = p0.a(xmlPullParser, TtmlNode.TAG_STYLE);
                g gVarI = I(xmlPullParser, new g());
                if (strA != null) {
                    for (String str : J(strA)) {
                        gVarI.a(map.get(str));
                    }
                }
                String strG = gVarI.g();
                if (strG != null) {
                    map.put(strG, gVarI);
                }
            } else if (p0.f(xmlPullParser, TtmlNode.TAG_REGION)) {
                e eVarG = G(xmlPullParser, aVar, c0156c);
                if (eVarG != null) {
                    map2.put(eVarG.f14892a, eVarG);
                }
            } else if (p0.f(xmlPullParser, TtmlNode.TAG_METADATA)) {
                E(xmlPullParser, map3);
            }
        } while (!p0.d(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    public static void E(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        String strA;
        do {
            xmlPullParser.next();
            if (p0.f(xmlPullParser, "image") && (strA = p0.a(xmlPullParser, "id")) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!p0.d(xmlPullParser, TtmlNode.TAG_METADATA));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:67:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:6:0x0039  */
    public static d F(XmlPullParser xmlPullParser, @Nullable d dVar, Map<String, e> map, b bVar) throws SubtitleDecoderException {
        long j11;
        long j12;
        int attributeCount = xmlPullParser.getAttributeCount();
        g gVarI = I(xmlPullParser, null);
        String[] strArr = null;
        String strSubstring = null;
        String str = "";
        long jK = C.TIME_UNSET;
        long jK2 = C.TIME_UNSET;
        long jK3 = C.TIME_UNSET;
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
                    jK3 = K(attributeValue, bVar);
                    break;
                case "end":
                    jK2 = K(attributeValue, bVar);
                    break;
                case "begin":
                    jK = K(attributeValue, bVar);
                    break;
                case "style":
                    String[] strArrJ = J(attributeValue);
                    if (strArrJ.length > 0) {
                        strArr = strArrJ;
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
        if (dVar != null) {
            long j13 = dVar.f14882d;
            j11 = C.TIME_UNSET;
            if (j13 != C.TIME_UNSET) {
                if (jK != C.TIME_UNSET) {
                    jK += j13;
                }
                if (jK2 != C.TIME_UNSET) {
                    jK2 += j13;
                }
            }
        } else {
            j11 = C.TIME_UNSET;
        }
        long j14 = jK;
        if (jK2 != j11) {
            j12 = jK2;
        } else if (jK3 != j11) {
            j12 = j14 + jK3;
        } else if (dVar != null) {
            long j15 = dVar.f14883e;
            if (j15 != j11) {
                j12 = j15;
            } else {
                j12 = jK2;
            }
        } else {
            j12 = jK2;
        }
        return d.c(xmlPullParser.getName(), j14, j12, gVarI, strArr, str, strSubstring, dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x0169  */
    /* JADX WARN: Code duplicated, block: B:49:0x018b  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b4  */
    @Nullable
    public static e G(XmlPullParser xmlPullParser, a aVar, @Nullable C0156c c0156c) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        int i11;
        int i12;
        String strA = p0.a(xmlPullParser, "id");
        if (strA == null) {
            return null;
        }
        String strA2 = p0.a(xmlPullParser, "origin");
        if (strA2 == null) {
            s.i("TtmlDecoder", "Ignoring region without an origin");
            return null;
        }
        Pattern pattern = f14866t;
        Matcher matcher = pattern.matcher(strA2);
        Pattern pattern2 = f14867u;
        Matcher matcher2 = pattern2.matcher(strA2);
        if (matcher.matches()) {
            try {
                float f16 = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) / 100.0f;
                f11 = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))) / 100.0f;
                f12 = f16;
            } catch (NumberFormatException unused) {
                s.i("TtmlDecoder", "Ignoring region with malformed origin: " + strA2);
                return null;
            }
        } else {
            if (!matcher2.matches()) {
                s.i("TtmlDecoder", "Ignoring region with unsupported origin: " + strA2);
                return null;
            }
            if (c0156c == null) {
                s.i("TtmlDecoder", "Ignoring region with missing tts:extent: " + strA2);
                return null;
            }
            try {
                int i13 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher2.group(1)));
                int i14 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher2.group(2)));
                f12 = i13 / c0156c.f14877a;
                f11 = i14 / c0156c.f14878b;
            } catch (NumberFormatException unused2) {
                s.i("TtmlDecoder", "Ignoring region with malformed origin: " + strA2);
                return null;
            }
        }
        String strA3 = p0.a(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (strA3 == null) {
            s.i("TtmlDecoder", "Ignoring region without an extent");
            return null;
        }
        Matcher matcher3 = pattern.matcher(strA3);
        Matcher matcher4 = pattern2.matcher(strA3);
        if (matcher3.matches()) {
            try {
                f13 = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher3.group(1))) / 100.0f;
                f14 = Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher3.group(2))) / 100.0f;
            } catch (NumberFormatException unused3) {
                s.i("TtmlDecoder", "Ignoring region with malformed extent: " + strA2);
                return null;
            }
        } else {
            if (!matcher4.matches()) {
                s.i("TtmlDecoder", "Ignoring region with unsupported extent: " + strA2);
                return null;
            }
            if (c0156c == null) {
                s.i("TtmlDecoder", "Ignoring region with missing tts:extent: " + strA2);
                return null;
            }
            try {
                int i15 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher4.group(1)));
                int i16 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher4.group(2)));
                f13 = i15 / c0156c.f14877a;
                f14 = i16 / c0156c.f14878b;
            } catch (NumberFormatException unused4) {
                s.i("TtmlDecoder", "Ignoring region with malformed extent: " + strA2);
                return null;
            }
        }
        String strA4 = p0.a(xmlPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
        if (strA4 != null) {
            String strE = com.google.common.base.a.e(strA4);
            strE.hashCode();
            if (strE.equals(TtmlNode.CENTER)) {
                f15 = f11 + (f14 / 2.0f);
                i11 = 1;
            } else if (strE.equals("after")) {
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
        float f17 = 1.0f / aVar.f14873b;
        String strA5 = p0.a(xmlPullParser, "writingMode");
        if (strA5 != null) {
            String strE2 = com.google.common.base.a.e(strA5);
            strE2.hashCode();
            switch (strE2) {
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
        return new e(strA, f12, f15, 0, i11, f13, f14, 1, f17, i12);
    }

    public static float H(String str) {
        Matcher matcher = f14865s.matcher(str);
        if (!matcher.matches()) {
            s.i("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)))));
        } catch (NumberFormatException e11) {
            s.j("TtmlDecoder", "Failed to parse shear: " + str, e11);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:6:0x0020  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static g I(XmlPullParser xmlPullParser, g gVar) {
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
                    gVar = x(gVar).B(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    gVar = x(gVar).x(attributeValue);
                    break;
                case 2:
                    gVar = x(gVar).H(z(attributeValue));
                    break;
                case 3:
                    String strE = com.google.common.base.a.e(attributeValue);
                    strE.hashCode();
                    switch (strE) {
                        case "nounderline":
                            gVar = x(gVar).K(false);
                            break;
                        case "underline":
                            gVar = x(gVar).K(true);
                            break;
                        case "nolinethrough":
                            gVar = x(gVar).C(false);
                            break;
                        case "linethrough":
                            gVar = x(gVar).C(true);
                            break;
                    }
                    break;
                case 4:
                    gVar = x(gVar).v(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if (TtmlNode.TAG_STYLE.equals(xmlPullParser.getName())) {
                        gVar = x(gVar).A(attributeValue);
                    }
                    break;
                case 6:
                    String strE2 = com.google.common.base.a.e(attributeValue);
                    strE2.hashCode();
                    switch (strE2) {
                        case "baseContainer":
                        case "base":
                            gVar = x(gVar).F(2);
                            break;
                        case "container":
                            gVar = x(gVar).F(1);
                            break;
                        case "delimiter":
                            gVar = x(gVar).F(4);
                            break;
                        case "textContainer":
                        case "text":
                            gVar = x(gVar).F(3);
                            break;
                    }
                    break;
                case 7:
                    gVar = x(gVar);
                    try {
                        gVar.w(com.google.android.exoplayer2.util.g.c(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        s.i("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                    }
                    break;
                case 8:
                    gVar = x(gVar).G(H(attributeValue));
                    break;
                case 9:
                    String strE3 = com.google.common.base.a.e(attributeValue);
                    strE3.hashCode();
                    if (strE3.equals("all")) {
                        gVar = x(gVar).I(true);
                    } else if (strE3.equals(DevicePublicKeyStringDef.NONE)) {
                        gVar = x(gVar).I(false);
                    }
                    break;
                case 10:
                    try {
                        gVar = x(gVar);
                        B(attributeValue, gVar);
                    } catch (SubtitleDecoderException unused2) {
                        s.i("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                    }
                    break;
                case 11:
                    gVar = x(gVar).J(ci.b.a(attributeValue));
                    break;
                case 12:
                    String strE4 = com.google.common.base.a.e(attributeValue);
                    strE4.hashCode();
                    if (strE4.equals("before")) {
                        gVar = x(gVar).E(1);
                    } else if (strE4.equals("after")) {
                        gVar = x(gVar).E(2);
                    }
                    break;
                case 13:
                    gVar = x(gVar);
                    try {
                        gVar.u(com.google.android.exoplayer2.util.g.c(attributeValue));
                    } catch (IllegalArgumentException unused3) {
                        s.i("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                    }
                    break;
                case 14:
                    gVar = x(gVar).D(z(attributeValue));
                    break;
            }
        }
        return gVar;
    }

    public static String[] J(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : o0.T0(strTrim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x00b7  */
    public static long K(String str, b bVar) throws SubtitleDecoderException {
        double d11;
        double d12;
        Matcher matcher = f14862p.matcher(str);
        if (matcher.matches()) {
            double d13 = (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) * 3600) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))) * 60) + Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3)));
            String strGroup = matcher.group(4);
            double d14 = d13 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d);
            String strGroup2 = matcher.group(5);
            double d15 = d14 + (strGroup2 != null ? Long.parseLong(strGroup2) / bVar.f14874a : 0.0d);
            String strGroup3 = matcher.group(6);
            return (long) ((d15 + (strGroup3 != null ? (Long.parseLong(strGroup3) / ((double) bVar.f14875b)) / ((double) bVar.f14874a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = f14863q.matcher(str);
        if (!matcher2.matches()) {
            throw new SubtitleDecoderException("Malformed time expression: " + str);
        }
        double d16 = Double.parseDouble((String) com.google.android.exoplayer2.util.a.e(matcher2.group(1)));
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher2.group(2));
        str2.hashCode();
        switch (str2) {
            case "f":
                d11 = bVar.f14874a;
                d16 /= d11;
                return (long) (d16 * 1000000.0d);
            case "h":
                d12 = 3600.0d;
                break;
            case "m":
                d12 = 60.0d;
                break;
            case "t":
                d11 = bVar.f14876c;
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
    public static C0156c L(XmlPullParser xmlPullParser) {
        String strA = p0.a(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (strA == null) {
            return null;
        }
        Matcher matcher = f14867u.matcher(strA);
        if (!matcher.matches()) {
            s.i("TtmlDecoder", "Ignoring non-pixel tts extent: " + strA);
            return null;
        }
        try {
            return new C0156c(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            s.i("TtmlDecoder", "Ignoring malformed tts extent: " + strA);
            return null;
        }
    }

    public static g x(@Nullable g gVar) {
        return gVar == null ? new g() : gVar;
    }

    public static boolean y(String str) {
        return str.equals(TtmlNode.TAG_TT) || str.equals(TtmlNode.TAG_HEAD) || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals(TtmlNode.TAG_P) || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals(TtmlNode.TAG_STYLE) || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals(TtmlNode.TAG_REGION) || str.equals(TtmlNode.TAG_METADATA) || str.equals("image") || str.equals("data") || str.equals("information");
    }

    @Nullable
    public static Layout.Alignment z(String str) {
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

    @Override // vh.h
    public i w(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f14871o.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new e(""));
            C0156c c0156cL = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i11), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarC = f14869w;
            a aVarA = f14870x;
            h hVar = null;
            int i12 = 0;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i12 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            bVarC = C(xmlPullParserNewPullParser);
                            aVarA = A(xmlPullParserNewPullParser, f14870x);
                            c0156cL = L(xmlPullParserNewPullParser);
                        }
                        C0156c c0156c = c0156cL;
                        b bVar2 = bVarC;
                        a aVar = aVarA;
                        if (y(name)) {
                            if (TtmlNode.TAG_HEAD.equals(name)) {
                                bVar = bVar2;
                                D(xmlPullParserNewPullParser, map, aVar, c0156c, map2, map3);
                            } else {
                                bVar = bVar2;
                                try {
                                    d dVarF = F(xmlPullParserNewPullParser, dVar, map2, bVar);
                                    arrayDeque.push(dVarF);
                                    if (dVar != null) {
                                        dVar.a(dVarF);
                                    }
                                } catch (SubtitleDecoderException e11) {
                                    s.j("TtmlDecoder", "Suppressing parser error", e11);
                                    i12++;
                                }
                            }
                            bVarC = bVar;
                        } else {
                            s.f("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i12++;
                            bVarC = bVar2;
                        }
                        c0156cL = c0156c;
                        aVarA = aVar;
                    } else if (eventType == 4) {
                        ((d) com.google.android.exoplayer2.util.a.e(dVar)).a(d.d(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            hVar = new h((d) com.google.android.exoplayer2.util.a.e((d) arrayDeque.peek()), map, map2, map3);
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
            if (hVar != null) {
                return hVar;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e12) {
            throw new IllegalStateException("Unexpected error when reading input.", e12);
        } catch (XmlPullParserException e13) {
            throw new SubtitleDecoderException("Unable to decode source", e13);
        }
    }
}
