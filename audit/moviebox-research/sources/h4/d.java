package h4;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.Xml;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.a0;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import z3.k0;
import z3.u0;
import z3.w0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends DefaultHandler implements androidx.media3.exoplayer.upstream.o.a<c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f66265b = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f66266c = Pattern.compile("CC([1-4])=.*");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f66267d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f66268f = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f66269a;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f66270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImmutableList<b> f66271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k f66272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f66273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ArrayList<DrmInitData.SchemeData> f66274e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList<e> f66275f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f66276g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<e> f66277h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<e> f66278i;

        public a(y yVar, List<b> list, k kVar, @Nullable String str, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<e> arrayList2, List<e> list2, List<e> list3, long j11) {
            this.f66270a = yVar;
            this.f66271b = ImmutableList.copyOf((Collection) list);
            this.f66272c = kVar;
            this.f66273d = str;
            this.f66274e = arrayList;
            this.f66275f = arrayList2;
            this.f66277h = list2;
            this.f66278i = list3;
            this.f66276g = j11;
        }
    }

    public d() {
        try {
            this.f66269a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    public static int C(List<e> list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f66279a) && (str = eVar.f66280b) != null) {
                Matcher matcher = f66266c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                z3.o.h("MpdParser", "Unable to parse CEA-608 channel number from: " + eVar.f66280b);
            }
        }
        return -1;
    }

    public static int D(List<e> list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f66279a) && (str = eVar.f66280b) != null) {
                Matcher matcher = f66267d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                z3.o.h("MpdParser", "Unable to parse CEA-708 service block number from: " + eVar.f66280b);
            }
        }
        return -1;
    }

    public static long G(XmlPullParser xmlPullParser, String str, long j11) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j11 : u0.Z0(attributeValue);
    }

    public static e H(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String strQ0 = q0(xmlPullParser, "schemeIdUri", "");
        String strQ1 = q0(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, null);
        String strQ2 = q0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!w0.d(xmlPullParser, str));
        return new e(strQ0, strQ1, strQ2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public static int I(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (attributeValue == null) {
            return -1;
        }
        String strE = com.google.common.base.a.e(attributeValue);
        strE.hashCode();
        switch (strE) {
            case "4000":
                return 1;
            case "a000":
                return 2;
            case "f800":
                return 5;
            case "f801":
                return 6;
            case "fa01":
                return 8;
            default:
                return -1;
        }
    }

    public static int J(XmlPullParser xmlPullParser) {
        int iT = T(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
        if (iT <= 0 || iT >= 33) {
            return -1;
        }
        return iT;
    }

    public static int K(XmlPullParser xmlPullParser) {
        int iBitCount;
        String attributeValue = xmlPullParser.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (attributeValue == null || (iBitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return iBitCount;
    }

    public static long L(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j11 : u0.a1(attributeValue);
    }

    public static String M(List<e> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            String str = eVar.f66279a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(eVar.f66280b)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(eVar.f66280b)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
        }
        return MimeTypes.AUDIO_E_AC3;
    }

    public static float Q(XmlPullParser xmlPullParser, String str, float f11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f11 : Float.parseFloat(attributeValue);
    }

    public static float R(XmlPullParser xmlPullParser, float f11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f11;
        }
        Matcher matcher = f66265b.matcher(attributeValue);
        if (!matcher.matches()) {
            return f11;
        }
        int i11 = Integer.parseInt(matcher.group(1));
        String strGroup = matcher.group(2);
        return !TextUtils.isEmpty(strGroup) ? i11 / Integer.parseInt(strGroup) : i11;
    }

    public static int T(XmlPullParser xmlPullParser, String str, int i11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i11 : Integer.parseInt(attributeValue);
    }

    public static long V(List<e> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if (com.google.common.base.a.a("http://dashif.org/guidelines/last-segment-number", eVar.f66279a)) {
                return Long.parseLong(eVar.f66280b);
            }
        }
        return -1L;
    }

    public static long W(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j11 : Long.parseLong(attributeValue);
    }

    public static int Y(XmlPullParser xmlPullParser) {
        int iT = T(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
        if (iT < 0) {
            return -1;
        }
        int[] iArr = f66268f;
        if (iT < iArr.length) {
            return iArr[iT];
        }
        return -1;
    }

    public static int o(int i11, int i12) {
        if (i11 == -1) {
            return i12;
        }
        if (i12 == -1) {
            return i11;
        }
        z3.a.g(i11 == i12);
        return i11;
    }

    @Nullable
    public static String p(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        z3.a.g(str.equals(str2));
        return str;
    }

    public static void q(ArrayList<DrmInitData.SchemeData> arrayList) {
        String str;
        int i11 = 0;
        while (true) {
            if (i11 >= arrayList.size()) {
                str = null;
                break;
            }
            DrmInitData.SchemeData schemeData = arrayList.get(i11);
            if (androidx.media3.common.j.f9253c.equals(schemeData.uuid) && (str = schemeData.licenseServerUrl) != null) {
                arrayList.remove(i11);
                break;
            }
            i11++;
        }
        if (str == null) {
            return;
        }
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            DrmInitData.SchemeData schemeData2 = arrayList.get(i12);
            if (androidx.media3.common.j.f9252b.equals(schemeData2.uuid) && schemeData2.licenseServerUrl == null) {
                arrayList.set(i12, new DrmInitData.SchemeData(androidx.media3.common.j.f9253c, str, schemeData2.mimeType, schemeData2.data));
            }
        }
    }

    public static String q0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public static void r(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    if (arrayList.get(i11).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    }
                }
            }
        }
    }

    public static String r0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String text = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                text = xmlPullParser.getText();
            } else {
                v(xmlPullParser);
            }
        } while (!w0.d(xmlPullParser, str));
        return text;
    }

    public static long s(long j11, long j12) {
        if (j12 != C.TIME_UNSET) {
            j11 = j12;
        }
        return j11 == Long.MAX_VALUE ? C.TIME_UNSET : j11;
    }

    @Nullable
    public static String t(@Nullable String str, @Nullable String str2) {
        if (f0.o(str)) {
            return f0.c(str2);
        }
        if (f0.s(str)) {
            return f0.n(str2);
        }
        if (f0.r(str) || f0.p(str)) {
            return str;
        }
        if (!MimeTypes.APPLICATION_MP4.equals(str)) {
            return null;
        }
        String strG = f0.g(str2);
        return MimeTypes.TEXT_VTT.equals(strG) ? MimeTypes.APPLICATION_MP4VTT : strG;
    }

    public static void v(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (w0.e(xmlPullParser)) {
            int i11 = 1;
            while (i11 != 0) {
                xmlPullParser.next();
                if (w0.e(xmlPullParser)) {
                    i11++;
                } else if (w0.c(xmlPullParser)) {
                    i11--;
                }
            }
        }
    }

    public long A(XmlPullParser xmlPullParser, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j11;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    public List<b> B(XmlPullParser xmlPullParser, List<b> list, boolean z11) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int i11 = attributeValue != null ? Integer.parseInt(attributeValue) : z11 ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int i12 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String strR0 = r0(xmlPullParser, "BaseURL");
        if (k0.c(strR0)) {
            if (attributeValue3 == null) {
                attributeValue3 = strR0;
            }
            return Lists.l(new b(strR0, attributeValue3, i11, i12));
        }
        ArrayList arrayList = new ArrayList();
        for (int i13 = 0; i13 < list.size(); i13++) {
            b bVar = list.get(i13);
            String strE = k0.e(bVar.f66248a, strR0);
            String str = attributeValue3 == null ? strE : attributeValue3;
            if (z11) {
                i11 = bVar.f66250c;
                i12 = bVar.f66251d;
                str = bVar.f66249b;
            }
            arrayList.add(new b(strE, str, i11, i12));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0099  */
    /* JADX WARN: Code duplicated, block: B:67:0x0111  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public Pair<String, DrmInitData.SchemeData> E(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue;
        UUID uuid;
        UUID uuid2;
        ?? attributeValue2;
        ?? B;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue3 != null) {
            String strE = com.google.common.base.a.e(attributeValue3);
            strE.hashCode();
            switch (strE) {
                case "urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e":
                    uuid = androidx.media3.common.j.f9253c;
                    attributeValue = null;
                    uuid2 = null;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
                case "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95":
                    uuid = androidx.media3.common.j.f9255e;
                    attributeValue = null;
                    uuid2 = null;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
                case "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed":
                    uuid = androidx.media3.common.j.f9254d;
                    attributeValue = null;
                    uuid2 = null;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
                case "urn:mpeg:dash:mp4protection:2011":
                    attributeValue = xmlPullParser.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                    String strB = w0.b(xmlPullParser, "default_KID");
                    if (!TextUtils.isEmpty(strB) && !"00000000-0000-0000-0000-000000000000".equals(strB)) {
                        String[] strArrSplit = strB.split("\\s+");
                        UUID[] uuidArr = new UUID[strArrSplit.length];
                        for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                            uuidArr[i11] = UUID.fromString(strArrSplit[i11]);
                        }
                        uuid = androidx.media3.common.j.f9252b;
                        attributeValue2 = 0;
                        B = l5.l.b(uuid, uuidArr, null);
                        break;
                    } else {
                        z3.o.h("MpdParser", "Ignoring <ContentProtection> with schemeIdUri=\"urn:mpeg:dash:mp4protection:2011\" (ClearKey) due to missing required default_KID attribute.");
                        uuid = null;
                        uuid2 = uuid;
                        attributeValue2 = uuid2;
                        B = uuid2;
                        break;
                    }
                    break;
                default:
                    attributeValue = null;
                    uuid = null;
                    uuid2 = uuid;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
            }
        } else {
            attributeValue = null;
            uuid = null;
            uuid2 = uuid;
            attributeValue2 = uuid2;
            B = uuid2;
        }
        do {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "clearkey:Laurl") && xmlPullParser.next() == 4) {
                B = B;
                attributeValue2 = xmlPullParser.getText();
            } else if (w0.f(xmlPullParser, "ms:laurl")) {
                B = B;
                attributeValue2 = xmlPullParser.getAttributeValue(null, "licenseUrl");
            } else if (B == 0 && w0.g(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                byte[] bArrDecode = Base64.decode(xmlPullParser.getText(), 0);
                UUID uuidF = l5.l.f(bArrDecode);
                if (uuidF == null) {
                    z3.o.h("MpdParser", "Skipping malformed cenc:pssh data");
                    uuid = uuidF;
                    B = 0;
                    attributeValue2 = attributeValue2;
                } else {
                    B = bArrDecode;
                    uuid = uuidF;
                    attributeValue2 = attributeValue2;
                }
            } else if (B == 0) {
                UUID uuid3 = androidx.media3.common.j.f9255e;
                if (uuid3.equals(uuid) && w0.f(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                    B = l5.l.a(uuid3, Base64.decode(xmlPullParser.getText(), 0));
                    attributeValue2 = attributeValue2;
                } else {
                    v(xmlPullParser);
                    B = B;
                    attributeValue2 = attributeValue2;
                }
            } else {
                v(xmlPullParser);
                B = B;
                attributeValue2 = attributeValue2;
            }
        } while (!w0.d(xmlPullParser, "ContentProtection"));
        return Pair.create(attributeValue, uuid != null ? new DrmInitData.SchemeData(uuid, attributeValue2, MimeTypes.VIDEO_MP4, B) : null);
    }

    public int F(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (MimeTypes.BASE_TYPE_AUDIO.equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if (MimeTypes.BASE_TYPE_TEXT.equals(attributeValue)) {
            return 3;
        }
        return "image".equals(attributeValue) ? 4 : -1;
    }

    public Pair<Long, EventMessage> N(XmlPullParser xmlPullParser, String str, String str2, long j11, long j12, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        long jW = W(xmlPullParser, "id", 0L);
        long jW2 = W(xmlPullParser, "duration", C.TIME_UNSET);
        long jW3 = W(xmlPullParser, "presentationTime", 0L);
        long jF1 = u0.f1(jW2, 1000L, j11);
        long jF2 = u0.f1(jW3 - j12, 1000000L, j11);
        String strQ0 = q0(xmlPullParser, "messageData", null);
        byte[] bArrO = O(xmlPullParser, byteArrayOutputStream);
        Long lValueOf = Long.valueOf(jF2);
        if (strQ0 != null) {
            bArrO = u0.w0(strQ0);
        }
        return Pair.create(lValueOf, c(str, str2, jW, jF1, bArrO));
    }

    public byte[] O(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(byteArrayOutputStream, com.google.common.base.c.f38165c.name());
        xmlPullParser.nextToken();
        while (!w0.d(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    xmlSerializerNewSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    xmlSerializerNewSerializer.endDocument();
                    break;
                case 2:
                    xmlSerializerNewSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i11 = 0; i11 < xmlPullParser.getAttributeCount(); i11++) {
                        xmlSerializerNewSerializer.attribute(xmlPullParser.getAttributeNamespace(i11), xmlPullParser.getAttributeName(i11), xmlPullParser.getAttributeValue(i11));
                    }
                    break;
                case 3:
                    xmlSerializerNewSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    xmlSerializerNewSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    xmlSerializerNewSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    xmlSerializerNewSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    xmlSerializerNewSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    xmlSerializerNewSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    xmlSerializerNewSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    xmlSerializerNewSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        xmlSerializerNewSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public f P(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ArrayList arrayList;
        String strQ0 = q0(xmlPullParser, "schemeIdUri", "");
        String strQ1 = q0(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
        long jW = W(xmlPullParser, "timescale", 1L);
        long jW2 = W(xmlPullParser, "presentationTimeOffset", 0L);
        ArrayList arrayList2 = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "Event")) {
                byteArrayOutputStream = byteArrayOutputStream2;
                long j11 = jW2;
                arrayList = arrayList2;
                arrayList.add(N(xmlPullParser, strQ0, strQ1, jW, j11, byteArrayOutputStream));
            } else {
                byteArrayOutputStream = byteArrayOutputStream2;
                arrayList = arrayList2;
                v(xmlPullParser);
            }
            if (w0.d(xmlPullParser, "EventStream")) {
                break;
            }
            arrayList2 = arrayList;
            byteArrayOutputStream2 = byteArrayOutputStream;
            jW2 = jW2;
        }
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            Pair pair = (Pair) arrayList.get(i11);
            jArr[i11] = ((Long) pair.first).longValue();
            eventMessageArr[i11] = (EventMessage) pair.second;
        }
        return d(strQ0, strQ1, jW, jArr, eventMessageArr);
    }

    public i S(XmlPullParser xmlPullParser) {
        return c0(xmlPullParser, "sourceURL", "range");
    }

    public a0 U(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return new a0(xmlPullParser.getAttributeValue(null, "lang"), r0(xmlPullParser, "Label"));
    }

    /* JADX WARN: Code duplicated, block: B:68:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:78:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e7 A[LOOP:0: B:25:0x00a4->B:82:0x01e7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x01a3 A[SYNTHETIC] */
    public c X(XmlPullParser xmlPullParser, Uri uri) throws XmlPullParserException, IOException {
        long j11;
        long j12;
        Throwable th2;
        ArrayList arrayList;
        boolean z11;
        long j13;
        d dVar = this;
        boolean zU = dVar.u(dVar.a0(xmlPullParser, "profiles", new String[0]));
        long j14 = C.TIME_UNSET;
        long jG = G(xmlPullParser, "availabilityStartTime", C.TIME_UNSET);
        long jL = L(xmlPullParser, "mediaPresentationDuration", C.TIME_UNSET);
        long jL2 = L(xmlPullParser, "minBufferTime", C.TIME_UNSET);
        Throwable th3 = null;
        boolean zEquals = "dynamic".equals(xmlPullParser.getAttributeValue(null, "type"));
        long jL3 = zEquals ? L(xmlPullParser, "minimumUpdatePeriod", C.TIME_UNSET) : -9223372036854775807L;
        long jL4 = zEquals ? L(xmlPullParser, "timeShiftBufferDepth", C.TIME_UNSET) : -9223372036854775807L;
        long jL5 = zEquals ? L(xmlPullParser, "suggestedPresentationDelay", C.TIME_UNSET) : -9223372036854775807L;
        long jG2 = G(xmlPullParser, "publishTime", C.TIME_UNSET);
        long jA = zEquals ? 0L : -9223372036854775807L;
        ArrayList arrayListL = Lists.l(new b(uri.toString(), uri.toString(), zU ? 1 : Integer.MIN_VALUE, 1));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        long j15 = zEquals ? -9223372036854775807L : 0L;
        h hVarB0 = null;
        o oVarV0 = null;
        Uri uriF = null;
        l lVarP0 = null;
        boolean z12 = false;
        boolean z13 = false;
        while (true) {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "BaseURL")) {
                if (!z12) {
                    jA = dVar.A(xmlPullParser, jA);
                    z12 = true;
                }
                arrayList3.addAll(dVar.B(xmlPullParser, arrayListL, zU));
            } else if (w0.f(xmlPullParser, "ProgramInformation")) {
                hVarB0 = b0(xmlPullParser);
            } else if (w0.f(xmlPullParser, "UTCTiming")) {
                oVarV0 = v0(xmlPullParser);
            } else if (w0.f(xmlPullParser, HttpHeaders.LOCATION)) {
                uriF = k0.f(uri.toString(), xmlPullParser.nextText());
            } else {
                if (w0.f(xmlPullParser, "ServiceDescription")) {
                    lVarP0 = p0(xmlPullParser);
                } else {
                    if (!w0.f(xmlPullParser, "Period") || z13) {
                        j11 = jA;
                        j12 = j14;
                        th2 = th3;
                        arrayList = arrayList2;
                        v(xmlPullParser);
                    } else {
                        j11 = jA;
                        arrayList = arrayList2;
                        j12 = j14;
                        th2 = th3;
                        Pair<g, Long> pairZ = Z(xmlPullParser, !arrayList3.isEmpty() ? arrayList3 : arrayListL, j15, j11, jG, jL4, zU);
                        g gVar = (g) pairZ.first;
                        if (gVar.f66288b != j12) {
                            long jLongValue = ((Long) pairZ.second).longValue();
                            long j16 = jLongValue == j12 ? j12 : gVar.f66288b + jLongValue;
                            arrayList.add(gVar);
                            j15 = j16;
                            z11 = z13;
                        } else {
                            if (!zEquals) {
                                throw ParserException.createForMalformedManifest("Unable to determine start of period " + arrayList.size(), th2);
                            }
                            arrayList = arrayList;
                            z11 = true;
                        }
                        z13 = z11;
                    }
                    jA = j11;
                }
                if (w0.d(xmlPullParser, "MPD")) {
                    if (jL != j12) {
                        j13 = jL;
                    } else if (j15 != j12) {
                        j13 = j15;
                    } else {
                        if (!zEquals) {
                            throw ParserException.createForMalformedManifest("Unable to determine duration of static manifest.", th2);
                        }
                        j13 = jL;
                    }
                    if (arrayList.isEmpty()) {
                        throw ParserException.createForMalformedManifest("No periods found.", th2);
                    }
                    return f(jG, j13, jL2, zEquals, jL3, jL4, jL5, jG2, hVarB0, oVarV0, lVarP0, uriF, arrayList);
                }
                arrayList2 = arrayList;
                th3 = th2;
                arrayList3 = arrayList3;
                arrayListL = arrayListL;
                j14 = j12;
                dVar = this;
            }
            arrayList3 = arrayList3;
            arrayListL = arrayListL;
            j12 = j14;
            th2 = th3;
            arrayList = arrayList2;
            if (w0.d(xmlPullParser, "MPD")) {
                if (jL != j12) {
                    j13 = jL;
                } else if (j15 != j12) {
                    j13 = j15;
                } else {
                    if (!zEquals) {
                        throw ParserException.createForMalformedManifest("Unable to determine duration of static manifest.", th2);
                    }
                    j13 = jL;
                }
                if (arrayList.isEmpty()) {
                    return f(jG, j13, jL2, zEquals, jL3, jL4, jL5, jG2, hVarB0, oVarV0, lVarP0, uriF, arrayList);
                }
                throw ParserException.createForMalformedManifest("No periods found.", th2);
            }
            arrayList2 = arrayList;
            th3 = th2;
            arrayList3 = arrayList3;
            arrayListL = arrayListL;
            j14 = j12;
            dVar = this;
        }
    }

    public Pair<g, Long> Z(XmlPullParser xmlPullParser, List<b> list, long j11, long j12, long j13, long j14, boolean z11) throws XmlPullParserException, IOException {
        ArrayList arrayList;
        List<h4.a> list2;
        List<f> list3;
        Object obj;
        long j15;
        k kVarK0;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        long jL = L(xmlPullParser2, "start", j11);
        long j16 = C.TIME_UNSET;
        long j17 = j13 != C.TIME_UNSET ? j13 + jL : -9223372036854775807L;
        long jL2 = L(xmlPullParser2, "duration", C.TIME_UNSET);
        List<h4.a> arrayList2 = new ArrayList<>();
        List<f> arrayList3 = new ArrayList<>();
        ArrayList arrayList4 = new ArrayList();
        long jA = j12;
        long j18 = -9223372036854775807L;
        k kVarI0 = null;
        e eVarH = null;
        boolean z12 = false;
        while (true) {
            xmlPullParser.next();
            if (w0.f(xmlPullParser2, "BaseURL")) {
                if (!z12) {
                    jA = A(xmlPullParser2, jA);
                    z12 = true;
                }
                arrayList4.addAll(B(xmlPullParser2, list, z11));
                list3 = arrayList3;
                arrayList = arrayList4;
                j15 = j16;
                obj = obj2;
                list2 = arrayList2;
            } else {
                if (w0.f(xmlPullParser2, "AdaptationSet")) {
                    jA = jA;
                    arrayList = arrayList4;
                    list2 = arrayList2;
                    list2.add(x(xmlPullParser, !arrayList4.isEmpty() ? arrayList4 : list, kVarI0, jL2, jA, j18, j17, j14, z11));
                    xmlPullParser2 = xmlPullParser;
                    list3 = arrayList3;
                } else {
                    jA = jA;
                    List<f> list4 = arrayList3;
                    arrayList = arrayList4;
                    list2 = arrayList2;
                    xmlPullParser2 = xmlPullParser;
                    if (w0.f(xmlPullParser2, "EventStream")) {
                        list4.add(P(xmlPullParser));
                        list3 = list4;
                    } else if (w0.f(xmlPullParser2, "SegmentBase")) {
                        list3 = list4;
                        kVarI0 = i0(xmlPullParser2, null);
                        obj = null;
                        jA = jA;
                        j15 = C.TIME_UNSET;
                    } else {
                        list3 = list4;
                        if (w0.f(xmlPullParser2, "SegmentList")) {
                            long jA2 = A(xmlPullParser2, C.TIME_UNSET);
                            obj = null;
                            kVarK0 = j0(xmlPullParser, null, j17, jL2, jA, jA2, j14);
                            j18 = jA2;
                            j15 = C.TIME_UNSET;
                        } else {
                            obj = null;
                            if (w0.f(xmlPullParser2, "SegmentTemplate")) {
                                long jA3 = A(xmlPullParser2, C.TIME_UNSET);
                                j15 = -9223372036854775807L;
                                kVarK0 = k0(xmlPullParser, null, ImmutableList.of(), j17, jL2, jA, jA3, j14);
                                j18 = jA3;
                            } else {
                                j15 = C.TIME_UNSET;
                                if (w0.f(xmlPullParser2, "AssetIdentifier")) {
                                    eVarH = H(xmlPullParser2, "AssetIdentifier");
                                } else {
                                    v(xmlPullParser);
                                }
                                jA = jA;
                            }
                        }
                        kVarI0 = kVarK0;
                    }
                }
                obj = null;
                j15 = C.TIME_UNSET;
                jA = jA;
            }
            if (w0.d(xmlPullParser2, "Period")) {
                return Pair.create(g(attributeValue, jL, list2, list3, eVarH), Long.valueOf(jL2));
            }
            arrayList2 = list2;
            arrayList4 = arrayList;
            obj2 = obj;
            arrayList3 = list3;
            j16 = j15;
        }
    }

    public final long a(List<k.d> list, long j11, long j12, int i11, long j13) {
        int iL = i11 >= 0 ? i11 + 1 : (int) u0.l(j13 - j11, j12);
        for (int i12 = 0; i12 < iL; i12++) {
            list.add(l(j11, j12));
            j11 += j12;
        }
        return j11;
    }

    public String[] a0(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? strArr : attributeValue.split(",");
    }

    public h4.a b(long j11, int i11, List<j> list, List<e> list2, List<e> list3, List<e> list4) {
        return new h4.a(j11, i11, list, list2, list3, list4);
    }

    public h b0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strNextText = null;
        String strQ0 = q0(xmlPullParser, "moreInformationURL", null);
        String strQ1 = q0(xmlPullParser, "lang", null);
        String strNextText2 = null;
        String strNextText3 = null;
        while (true) {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "Title")) {
                strNextText = xmlPullParser.nextText();
            } else if (w0.f(xmlPullParser, "Source")) {
                strNextText2 = xmlPullParser.nextText();
            } else if (w0.f(xmlPullParser, "Copyright")) {
                strNextText3 = xmlPullParser.nextText();
            } else {
                v(xmlPullParser);
            }
            String str = strNextText3;
            if (w0.d(xmlPullParser, "ProgramInformation")) {
                return new h(strNextText, strNextText2, str, strQ0, strQ1);
            }
            strNextText3 = str;
        }
    }

    public EventMessage c(String str, String str2, long j11, long j12, byte[] bArr) {
        return new EventMessage(str, str2, j12, j11, bArr);
    }

    public i c0(XmlPullParser xmlPullParser, String str, String str2) {
        long j11;
        long j12;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j11 = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j12 = (Long.parseLong(strArrSplit[1]) - j11) + 1;
            }
            return h(attributeValue, j11, j12);
        }
        j11 = 0;
        j12 = -1;
        return h(attributeValue, j11, j12);
    }

    public f d(String str, String str2, long j11, long[] jArr, EventMessage[] eventMessageArr) {
        return new f(str, str2, j11, jArr, eventMessageArr);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x01ee A[LOOP:0: B:3:0x006a->B:57:0x01ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x0198 A[EDGE_INSN: B:58:0x0198->B:47:0x0198 BREAK  A[LOOP:0: B:3:0x006a->B:57:0x01ee], SYNTHETIC] */
    public a d0(XmlPullParser xmlPullParser, List<b> list, @Nullable String str, @Nullable String str2, int i11, int i12, float f11, int i13, int i14, @Nullable String str3, List<e> list2, List<e> list3, List<e> list4, List<e> list5, @Nullable k kVar, long j11, long j12, long j13, long j14, long j15, boolean z11) throws XmlPullParserException, IOException {
        long j16;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        long jA;
        ArrayList arrayList6;
        k eVar;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int iT = T(xmlPullParser, "bandwidth", -1);
        String strQ0 = q0(xmlPullParser, "mimeType", str);
        String strQ1 = q0(xmlPullParser, "codecs", str2);
        int iT2 = T(xmlPullParser, "width", i11);
        int iT3 = T(xmlPullParser, "height", i12);
        float fR = R(xmlPullParser, f11);
        int iT4 = T(xmlPullParser, "audioSamplingRate", i14);
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList(list4);
        ArrayList arrayList13 = new ArrayList(list5);
        int iZ = i13;
        k kVarK0 = kVar;
        long jA2 = j13;
        String str4 = null;
        boolean z12 = false;
        long j17 = j14;
        ArrayList arrayList14 = new ArrayList();
        while (true) {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "BaseURL")) {
                if (!z12) {
                    jA2 = A(xmlPullParser, jA2);
                    z12 = true;
                }
                arrayList14.addAll(B(xmlPullParser, list, z11));
            } else {
                if (w0.f(xmlPullParser, "AudioChannelConfiguration")) {
                    eVar = kVarK0;
                    iZ = z(xmlPullParser);
                    arrayList4 = arrayList11;
                    arrayList5 = arrayList13;
                    arrayList9 = arrayList14;
                } else if (w0.f(xmlPullParser, "SegmentBase")) {
                    kVarK0 = i0(xmlPullParser, (k.e) kVarK0);
                } else {
                    if (w0.f(xmlPullParser, "SegmentList")) {
                        jA = A(xmlPullParser, j17);
                        j16 = jA2;
                        arrayList8 = arrayList14;
                        arrayList = arrayList13;
                        arrayList2 = arrayList11;
                        arrayList3 = arrayList12;
                        kVarK0 = j0(xmlPullParser, (k.b) kVarK0, j11, j12, j16, jA, j15);
                    } else {
                        j16 = jA2;
                        ArrayList arrayList15 = arrayList14;
                        arrayList = arrayList13;
                        arrayList2 = arrayList11;
                        arrayList3 = arrayList12;
                        if (w0.f(xmlPullParser, "SegmentTemplate")) {
                            jA = A(xmlPullParser, j17);
                            kVarK0 = k0(xmlPullParser, (k.c) kVarK0, list5, j11, j12, j16, jA, j15);
                            arrayList8 = arrayList15;
                        } else {
                            arrayList10 = arrayList10;
                            if (w0.f(xmlPullParser, "ContentProtection")) {
                                Pair<String, DrmInitData.SchemeData> pairE = E(xmlPullParser);
                                Object obj = pairE.first;
                                if (obj != null) {
                                    str4 = (String) obj;
                                }
                                Object obj2 = pairE.second;
                                if (obj2 != null) {
                                    arrayList10.add((DrmInitData.SchemeData) obj2);
                                }
                                arrayList7 = arrayList15;
                                jA2 = j16;
                                arrayList5 = arrayList;
                                arrayList4 = arrayList2;
                                arrayList12 = arrayList3;
                                arrayList6 = arrayList7;
                            } else {
                                if (w0.f(xmlPullParser, "InbandEventStream")) {
                                    arrayList4 = arrayList2;
                                    arrayList4.add(H(xmlPullParser, "InbandEventStream"));
                                    arrayList5 = arrayList;
                                    arrayList12 = arrayList3;
                                } else {
                                    arrayList4 = arrayList2;
                                    if (w0.f(xmlPullParser, "EssentialProperty")) {
                                        arrayList12 = arrayList3;
                                        arrayList12.add(H(xmlPullParser, "EssentialProperty"));
                                        arrayList5 = arrayList;
                                    } else {
                                        arrayList12 = arrayList3;
                                        if (w0.f(xmlPullParser, "SupplementalProperty")) {
                                            arrayList5 = arrayList;
                                            arrayList5.add(H(xmlPullParser, "SupplementalProperty"));
                                        } else {
                                            arrayList5 = arrayList;
                                            v(xmlPullParser);
                                        }
                                    }
                                }
                                iZ = iZ;
                                jA2 = j16;
                                arrayList6 = arrayList15;
                            }
                        }
                        eVar = kVarK0;
                        arrayList9 = arrayList6;
                    }
                    j17 = jA;
                    arrayList7 = arrayList8;
                    jA2 = j16;
                    arrayList5 = arrayList;
                    arrayList4 = arrayList2;
                    arrayList12 = arrayList3;
                    arrayList6 = arrayList7;
                    eVar = kVarK0;
                    arrayList9 = arrayList6;
                }
                if (w0.d(xmlPullParser, "Representation")) {
                    break;
                }
                arrayList13 = arrayList5;
                arrayList11 = arrayList4;
                arrayList10 = arrayList10;
                kVarK0 = eVar;
                iZ = iZ;
                arrayList14 = arrayList9;
            }
            iZ = iZ;
            eVar = kVarK0;
            arrayList4 = arrayList11;
            arrayList5 = arrayList13;
            arrayList9 = arrayList14;
            if (w0.d(xmlPullParser, "Representation")) {
                break;
                break;
            }
            arrayList13 = arrayList5;
            arrayList11 = arrayList4;
            arrayList10 = arrayList10;
            kVarK0 = eVar;
            iZ = iZ;
            arrayList14 = arrayList9;
        }
        List<e> list6 = arrayList5;
        List<e> list7 = arrayList12;
        ArrayList arrayList16 = arrayList4;
        y yVarE = e(attributeValue, strQ0, iT2, iT3, fR, iZ, iT4, iT, str3, list2, list3, strQ1, list7, list6);
        if (eVar == null) {
            eVar = new k.e();
        }
        boolean zIsEmpty = arrayList9.isEmpty();
        List list8 = arrayList9;
        if (zIsEmpty) {
            list8 = list;
        }
        return new a(yVarE, list8, eVar, str4, arrayList10, arrayList16, list7, list6, -1L);
    }

    public y e(@Nullable String str, @Nullable String str2, int i11, int i12, float f11, int i13, int i14, int i15, @Nullable String str3, List<e> list, List<e> list2, @Nullable String str4, List<e> list3, List<e> list4) {
        String str5 = str4;
        String strT = t(str2, str5);
        if (MimeTypes.AUDIO_E_AC3.equals(strT)) {
            strT = M(list4);
            if (MimeTypes.AUDIO_E_AC3_JOC.equals(strT)) {
                str5 = "ec+3";
            }
        }
        int iO0 = o0(list);
        int iH0 = h0(list) | e0(list2) | g0(list3) | g0(list4);
        Pair<Integer, Integer> pairS0 = s0(list3);
        y.b bVarB0 = new y.b().X(str).O(str2).k0(strT).M(str5).f0(i15).m0(iO0).i0(iH0).b0(str3);
        int iD = -1;
        y.b bVarQ0 = bVarB0.p0(pairS0 != null ? ((Integer) pairS0.first).intValue() : -1).q0(pairS0 != null ? ((Integer) pairS0.second).intValue() : -1);
        if (f0.s(strT)) {
            bVarQ0.r0(i11).V(i12).U(f11);
        } else if (f0.o(strT)) {
            bVarQ0.L(i13).l0(i14);
        } else if (f0.r(strT)) {
            if (MimeTypes.APPLICATION_CEA608.equals(strT)) {
                iD = C(list2);
            } else if (MimeTypes.APPLICATION_CEA708.equals(strT)) {
                iD = D(list2);
            }
            bVarQ0.J(iD);
        } else if (f0.p(strT)) {
            bVarQ0.r0(i11).V(i12);
        }
        return bVarQ0.I();
    }

    public int e0(List<e> list) {
        int iT0;
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            e eVar = list.get(i12);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f66279a)) {
                iT0 = f0(eVar.f66280b);
            } else {
                if (com.google.common.base.a.a("urn:tva:metadata:cs:AudioPurposeCS:2007", eVar.f66279a)) {
                    iT0 = t0(eVar.f66280b);
                }
            }
            i11 |= iT0;
        }
        return i11;
    }

    public c f(long j11, long j12, long j13, boolean z11, long j14, long j15, long j16, long j17, @Nullable h hVar, @Nullable o oVar, @Nullable l lVar, @Nullable Uri uri, List<g> list) {
        return new c(j11, j12, j13, z11, j14, j15, j16, j17, hVar, oVar, lVar, uri, list);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public int f0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        byte b11 = -1;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    b11 = 0;
                }
                break;
            case -1724546052:
                if (str.equals(TrackingKey.DESCRIPTION)) {
                    b11 = 1;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    b11 = 2;
                }
                break;
            case -1574842690:
                if (str.equals("forced_subtitle")) {
                    b11 = 3;
                }
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    b11 = 4;
                }
                break;
            case -1396432756:
                if (str.equals("forced-subtitle")) {
                    b11 = 5;
                }
                break;
            case 99825:
                if (str.equals("dub")) {
                    b11 = 6;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    b11 = 7;
                }
                break;
            case 3530173:
                if (str.equals("sign")) {
                    b11 = 8;
                }
                break;
            case 552573414:
                if (str.equals("caption")) {
                    b11 = 9;
                }
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    b11 = 10;
                }
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    b11 = Ascii.VT;
                }
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    b11 = Ascii.FF;
                }
                break;
        }
        switch (b11) {
            case 0:
            case 3:
            case 5:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 4:
                return 2;
            case 6:
                return 16;
            case 7:
                return 1;
            case 8:
                return 256;
            case 9:
                return 64;
            case 10:
                return 8;
            case 11:
                return 32;
            case 12:
                return 4;
            default:
                return 0;
        }
    }

    public g g(@Nullable String str, long j11, List<h4.a> list, List<f> list2, @Nullable e eVar) {
        return new g(str, j11, list, list2, eVar);
    }

    public int g0(List<e> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (com.google.common.base.a.a("http://dashif.org/guidelines/trickmode", list.get(i12).f66279a)) {
                i11 |= 16384;
            }
        }
        return i11;
    }

    public i h(String str, long j11, long j12) {
        return new i(str, j11, j12);
    }

    public int h0(List<e> list) {
        int iF0 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f66279a)) {
                iF0 |= f0(eVar.f66280b);
            }
        }
        return iF0;
    }

    public j i(a aVar, @Nullable String str, List<a0> list, @Nullable String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<e> arrayList2) {
        y.b bVarB = aVar.f66270a.b();
        if (str == null || !list.isEmpty()) {
            bVarB.a0(list);
        } else {
            bVarB.Z(str);
        }
        String str3 = aVar.f66273d;
        if (str3 == null) {
            str3 = str2;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = aVar.f66274e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            q(arrayList3);
            r(arrayList3);
            bVarB.R(new DrmInitData(str3, arrayList3));
        }
        ArrayList<e> arrayList4 = aVar.f66275f;
        arrayList4.addAll(arrayList2);
        return j.n(aVar.f66276g, bVarB.I(), aVar.f66271b, aVar.f66272c, arrayList4, aVar.f66277h, aVar.f66278i, null);
    }

    public k.e i0(XmlPullParser xmlPullParser, @Nullable k.e eVar) throws XmlPullParserException, IOException {
        long j11;
        long j12;
        long jW = W(xmlPullParser, "timescale", eVar != null ? eVar.f66316b : 1L);
        long jW2 = W(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.f66317c : 0L);
        long j13 = eVar != null ? eVar.f66330d : 0L;
        long j14 = eVar != null ? eVar.f66331e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split("-");
            j12 = Long.parseLong(strArrSplit[0]);
            j11 = (Long.parseLong(strArrSplit[1]) - j12) + 1;
        } else {
            j11 = j14;
            j12 = j13;
        }
        i iVarS = eVar != null ? eVar.f66315a : null;
        do {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "Initialization")) {
                iVarS = S(xmlPullParser);
            } else {
                v(xmlPullParser);
            }
        } while (!w0.d(xmlPullParser, "SegmentBase"));
        return m(iVarS, jW, jW2, j12, j11);
    }

    public k.b j(i iVar, long j11, long j12, long j13, long j14, @Nullable List<k.d> list, long j15, @Nullable List<i> list2, long j16, long j17) {
        return new k.b(iVar, j11, j12, j13, j14, list, j15, list2, u0.S0(j16), u0.S0(j17));
    }

    public k.b j0(XmlPullParser xmlPullParser, @Nullable k.b bVar, long j11, long j12, long j13, long j14, long j15) throws XmlPullParserException, IOException {
        long jW = W(xmlPullParser, "timescale", bVar != null ? bVar.f66316b : 1L);
        long jW2 = W(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.f66317c : 0L);
        long jW3 = W(xmlPullParser, "duration", bVar != null ? bVar.f66319e : C.TIME_UNSET);
        long jW4 = W(xmlPullParser, "startNumber", bVar != null ? bVar.f66318d : 1L);
        long jS = s(j13, j14);
        List<k.d> listL0 = null;
        List<i> arrayList = null;
        i iVarS = null;
        do {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "Initialization")) {
                iVarS = S(xmlPullParser);
            } else if (w0.f(xmlPullParser, "SegmentTimeline")) {
                listL0 = l0(xmlPullParser, jW, j12);
            } else if (w0.f(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(m0(xmlPullParser));
            } else {
                v(xmlPullParser);
            }
        } while (!w0.d(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (iVarS == null) {
                iVarS = bVar.f66315a;
            }
            if (listL0 == null) {
                listL0 = bVar.f66320f;
            }
            if (arrayList == null) {
                arrayList = bVar.f66324j;
            }
        }
        return j(iVarS, jW, jW2, jW4, jW3, listL0, jS, arrayList, j15, j11);
    }

    public k.c k(i iVar, long j11, long j12, long j13, long j14, long j15, List<k.d> list, long j16, @Nullable n nVar, @Nullable n nVar2, long j17, long j18) {
        return new k.c(iVar, j11, j12, j13, j14, j15, list, j16, nVar, nVar2, u0.S0(j17), u0.S0(j18));
    }

    public k.c k0(XmlPullParser xmlPullParser, @Nullable k.c cVar, List<e> list, long j11, long j12, long j13, long j14, long j15) throws XmlPullParserException, IOException {
        long jW = W(xmlPullParser, "timescale", cVar != null ? cVar.f66316b : 1L);
        long jW2 = W(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.f66317c : 0L);
        long jW3 = W(xmlPullParser, "duration", cVar != null ? cVar.f66319e : C.TIME_UNSET);
        long jW4 = W(xmlPullParser, "startNumber", cVar != null ? cVar.f66318d : 1L);
        long jV = V(list);
        long jS = s(j13, j14);
        List<k.d> listL0 = null;
        n nVarU0 = u0(xmlPullParser, "media", cVar != null ? cVar.f66326k : null);
        n nVarU1 = u0(xmlPullParser, "initialization", cVar != null ? cVar.f66325j : null);
        i iVarS = null;
        do {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "Initialization")) {
                iVarS = S(xmlPullParser);
            } else if (w0.f(xmlPullParser, "SegmentTimeline")) {
                listL0 = l0(xmlPullParser, jW, j12);
            } else {
                v(xmlPullParser);
            }
        } while (!w0.d(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (iVarS == null) {
                iVarS = cVar.f66315a;
            }
            if (listL0 == null) {
                listL0 = cVar.f66320f;
            }
        }
        return k(iVarS, jW, jW2, jW4, jV, jW3, listL0, jS, nVarU1, nVarU0, j15, j11);
    }

    public k.d l(long j11, long j12) {
        return new k.d(j11, j12);
    }

    public List<k.d> l0(XmlPullParser xmlPullParser, long j11, long j12) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long jA = 0;
        long jW = -9223372036854775807L;
        boolean z11 = false;
        int iT = 0;
        do {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "S")) {
                long jW2 = W(xmlPullParser, "t", C.TIME_UNSET);
                if (z11) {
                    jA = a(arrayList, jA, jW, iT, jW2);
                }
                if (jW2 == C.TIME_UNSET) {
                    jW2 = jA;
                }
                jW = W(xmlPullParser, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, C.TIME_UNSET);
                iT = T(xmlPullParser, CampaignEx.JSON_KEY_AD_R, 0);
                jA = jW2;
                z11 = true;
            } else {
                v(xmlPullParser);
            }
        } while (!w0.d(xmlPullParser, "SegmentTimeline"));
        if (z11) {
            a(arrayList, jA, jW, iT, u0.f1(j12, j11, 1000L));
        }
        return arrayList;
    }

    public k.e m(i iVar, long j11, long j12, long j13, long j14) {
        return new k.e(iVar, j11, j12, j13, j14);
    }

    public i m0(XmlPullParser xmlPullParser) {
        return c0(xmlPullParser, "media", "mediaRange");
    }

    public o n(String str, String str2) {
        return new o(str, str2);
    }

    public int n0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        return (str.equals("forced_subtitle") || str.equals("forced-subtitle")) ? 2 : 0;
    }

    public int o0(List<e> list) {
        int iN0 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f66279a)) {
                iN0 |= n0(eVar.f66280b);
            }
        }
        return iN0;
    }

    public l p0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        long jW = -9223372036854775807L;
        long jW2 = -9223372036854775807L;
        long jW3 = -9223372036854775807L;
        float fQ = -3.4028235E38f;
        float fQ2 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (w0.f(xmlPullParser, "Latency")) {
                jW = W(xmlPullParser, "target", C.TIME_UNSET);
                jW2 = W(xmlPullParser, "min", C.TIME_UNSET);
                jW3 = W(xmlPullParser, AppLovinMediationProvider.MAX, C.TIME_UNSET);
            } else if (w0.f(xmlPullParser, "PlaybackRate")) {
                fQ = Q(xmlPullParser, "min", -3.4028235E38f);
                fQ2 = Q(xmlPullParser, AppLovinMediationProvider.MAX, -3.4028235E38f);
            }
            long j11 = jW;
            long j12 = jW2;
            long j13 = jW3;
            float f11 = fQ;
            float f12 = fQ2;
            if (w0.d(xmlPullParser, "ServiceDescription")) {
                return new l(j11, j12, j13, f11, f12);
            }
            jW = j11;
            jW2 = j12;
            jW3 = j13;
            fQ = f11;
            fQ2 = f12;
        }
    }

    @Nullable
    public Pair<Integer, Integer> s0(List<e> list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            if ((com.google.common.base.a.a("http://dashif.org/thumbnail_tile", eVar.f66279a) || com.google.common.base.a.a("http://dashif.org/guidelines/thumbnail_tile", eVar.f66279a)) && (str = eVar.f66280b) != null) {
                String[] strArrO1 = u0.o1(str, "x");
                if (strArrO1.length != 2) {
                    continue;
                } else {
                    try {
                        return Pair.create(Integer.valueOf(Integer.parseInt(strArrO1[0])), Integer.valueOf(Integer.parseInt(strArrO1[1])));
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public int t0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        byte b11 = -1;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    b11 = 0;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b11 = 1;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    b11 = 2;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    b11 = 3;
                }
                break;
            case 54:
                if (str.equals(PrepareException.ERROR_NO_URL)) {
                    b11 = 4;
                }
                break;
        }
        switch (b11) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    public final boolean u(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public n u0(XmlPullParser xmlPullParser, String str, @Nullable n nVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? n.b(attributeValue) : nVar;
    }

    public o v0(XmlPullParser xmlPullParser) {
        return n(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE));
    }

    @Override // androidx.media3.exoplayer.upstream.o.a
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public c parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f66269a.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            if (xmlPullParserNewPullParser.next() == 2 && "MPD".equals(xmlPullParserNewPullParser.getName())) {
                return X(xmlPullParserNewPullParser, uri);
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e11) {
            throw ParserException.createForMalformedManifest(null, e11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0351 A[LOOP:0: B:3:0x007f->B:74:0x0351, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x0310 A[EDGE_INSN: B:75:0x0310->B:68:0x0310 BREAK  A[LOOP:0: B:3:0x007f->B:74:0x0351], SYNTHETIC] */
    public h4.a x(XmlPullParser xmlPullParser, List<b> list, @Nullable k kVar, long j11, long j12, long j13, long j14, long j15, boolean z11) throws XmlPullParserException, IOException {
        List<a0> list2;
        Object obj;
        ArrayList<e> arrayList;
        String str;
        List<a0> list3;
        long j16;
        long j17;
        int i11;
        long jA;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long jW = W(xmlPullParser2, "id", -1L);
        int iF = F(xmlPullParser);
        String attributeValue = xmlPullParser2.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser2.getAttributeValue(null, "codecs");
        int iT = T(xmlPullParser2, "width", -1);
        int iT2 = T(xmlPullParser2, "height", -1);
        float fR = R(xmlPullParser2, -1.0f);
        int iT3 = T(xmlPullParser2, "audioSamplingRate", -1);
        String str2 = "lang";
        String attributeValue3 = xmlPullParser2.getAttributeValue(null, "lang");
        String attributeValue4 = xmlPullParser2.getAttributeValue(null, "label");
        List<a0> arrayList2 = new ArrayList<>();
        ArrayList<DrmInitData.SchemeData> arrayList3 = new ArrayList<>();
        ArrayList<e> arrayList4 = new ArrayList<>();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        k kVarK0 = kVar;
        String str3 = attributeValue3;
        String str4 = null;
        int iZ = -1;
        boolean z12 = false;
        long jA2 = j12;
        long j18 = j13;
        while (true) {
            xmlPullParser.next();
            if (w0.f(xmlPullParser2, "BaseURL")) {
                if (!z12) {
                    jA2 = A(xmlPullParser2, jA2);
                    z12 = true;
                }
                arrayList10.addAll(B(xmlPullParser2, list, z11));
                jA2 = jA2;
                list2 = arrayList2;
            } else {
                jA2 = jA2;
                list2 = arrayList2;
                if (w0.f(xmlPullParser2, "ContentProtection")) {
                    Pair<String, DrmInitData.SchemeData> pairE = E(xmlPullParser);
                    Object obj2 = pairE.first;
                    if (obj2 != null) {
                        str4 = (String) obj2;
                    }
                    Object obj3 = pairE.second;
                    if (obj3 != null) {
                        arrayList3.add((DrmInitData.SchemeData) obj3);
                    }
                    list2 = list2;
                    jA2 = jA2;
                } else {
                    if (w0.f(xmlPullParser2, "ContentComponent")) {
                        String strP = p(str3, xmlPullParser2.getAttributeValue(null, str2));
                        iF = o(iF, F(xmlPullParser));
                        str = strP;
                        obj = null;
                    } else {
                        String str5 = str3;
                        if (w0.f(xmlPullParser2, "Role")) {
                            arrayList6.add(H(xmlPullParser2, "Role"));
                        } else if (w0.f(xmlPullParser2, "AudioChannelConfiguration")) {
                            iZ = z(xmlPullParser);
                            obj = null;
                            str = str5;
                        } else if (w0.f(xmlPullParser2, "Accessibility")) {
                            arrayList5.add(H(xmlPullParser2, "Accessibility"));
                        } else if (w0.f(xmlPullParser2, "EssentialProperty")) {
                            arrayList7.add(H(xmlPullParser2, "EssentialProperty"));
                        } else if (w0.f(xmlPullParser2, "SupplementalProperty")) {
                            arrayList8.add(H(xmlPullParser2, "SupplementalProperty"));
                        } else {
                            if (w0.f(xmlPullParser2, "Representation")) {
                                int i12 = iF;
                                arrayList10 = arrayList10;
                                arrayList8 = arrayList8;
                                arrayList7 = arrayList7;
                                arrayList6 = arrayList6;
                                arrayList5 = arrayList5;
                                arrayList = arrayList4;
                                arrayList3 = arrayList3;
                                list3 = list2;
                                str2 = str2;
                                obj = null;
                                str = str5;
                                a aVarD0 = d0(xmlPullParser, !arrayList10.isEmpty() ? arrayList10 : list, attributeValue, attributeValue2, iT, iT2, fR, iZ, iT3, str5, arrayList6, arrayList5, arrayList7, arrayList8, kVarK0, j14, j11, jA2, j18, j15, z11);
                                int iO = o(i12, f0.k(aVarD0.f66270a.f9501m));
                                arrayList9 = arrayList9;
                                arrayList9.add(aVarD0);
                                xmlPullParser2 = xmlPullParser;
                                jA = j18;
                                iF = iO;
                                jA2 = jA2;
                            } else {
                                int i13 = iF;
                                obj = null;
                                arrayList10 = arrayList10;
                                arrayList8 = arrayList8;
                                arrayList7 = arrayList7;
                                arrayList6 = arrayList6;
                                arrayList5 = arrayList5;
                                arrayList = arrayList4;
                                arrayList3 = arrayList3;
                                str2 = str2;
                                str = str5;
                                list3 = list2;
                                j16 = jA2;
                                arrayList9 = arrayList9;
                                xmlPullParser2 = xmlPullParser;
                                if (w0.f(xmlPullParser2, "SegmentBase")) {
                                    jA = j18;
                                    kVarK0 = i0(xmlPullParser2, (k.e) kVarK0);
                                    iF = i13;
                                    jA2 = j16;
                                    arrayList4 = arrayList;
                                    list2 = list3;
                                    xmlPullParser2 = xmlPullParser2;
                                } else {
                                    if (w0.f(xmlPullParser2, "SegmentList")) {
                                        jA = A(xmlPullParser2, j18);
                                        i11 = i13;
                                        kVarK0 = j0(xmlPullParser, (k.b) kVarK0, j14, j11, j16, jA, j15);
                                    } else {
                                        j17 = j18;
                                        i11 = i13;
                                        if (w0.f(xmlPullParser2, "SegmentTemplate")) {
                                            jA = A(xmlPullParser2, j17);
                                            kVarK0 = k0(xmlPullParser, (k.c) kVarK0, arrayList8, j14, j11, j16, jA, j15);
                                        } else {
                                            xmlPullParser2 = xmlPullParser2;
                                            if (w0.f(xmlPullParser2, "InbandEventStream")) {
                                                arrayList4 = arrayList;
                                                arrayList4.add(H(xmlPullParser2, "InbandEventStream"));
                                                list2 = list3;
                                            } else {
                                                arrayList4 = arrayList;
                                                if (w0.f(xmlPullParser2, "Label")) {
                                                    list2 = list3;
                                                    list2.add(U(xmlPullParser));
                                                } else {
                                                    list2 = list3;
                                                    if (w0.e(xmlPullParser)) {
                                                        y(xmlPullParser);
                                                    }
                                                }
                                            }
                                            jA = j17;
                                            jA2 = j16;
                                            iF = i11;
                                        }
                                    }
                                    jA2 = j16;
                                    iF = i11;
                                }
                            }
                            arrayList4 = arrayList;
                            list2 = list3;
                        }
                        i11 = iF;
                        obj = null;
                        arrayList10 = arrayList10;
                        arrayList8 = arrayList8;
                        arrayList7 = arrayList7;
                        arrayList6 = arrayList6;
                        arrayList5 = arrayList5;
                        arrayList4 = arrayList4;
                        arrayList3 = arrayList3;
                        str2 = str2;
                        str = str5;
                        j16 = jA2;
                        j17 = j18;
                        arrayList9 = arrayList9;
                        list2 = list2;
                        jA = j17;
                        jA2 = j16;
                        iF = i11;
                    }
                    jA = j18;
                }
                if (w0.d(xmlPullParser2, "AdaptationSet")) {
                    break;
                }
                arrayList4 = arrayList4;
                arrayList2 = list2;
                arrayList9 = arrayList9;
                j18 = jA;
                arrayList10 = arrayList10;
                arrayList8 = arrayList8;
                arrayList7 = arrayList7;
                arrayList6 = arrayList6;
                arrayList5 = arrayList5;
                arrayList3 = arrayList3;
                str2 = str2;
                str3 = str;
            }
            str = str3;
            obj = null;
            jA = j18;
            arrayList10 = arrayList10;
            arrayList4 = arrayList4;
            if (w0.d(xmlPullParser2, "AdaptationSet")) {
                break;
                break;
            }
            arrayList4 = arrayList4;
            arrayList2 = list2;
            arrayList9 = arrayList9;
            j18 = jA;
            arrayList10 = arrayList10;
            arrayList8 = arrayList8;
            arrayList7 = arrayList7;
            arrayList6 = arrayList6;
            arrayList5 = arrayList5;
            arrayList3 = arrayList3;
            str2 = str2;
            str3 = str;
        }
        List<j> arrayList11 = new ArrayList<>(arrayList9.size());
        for (int i14 = 0; i14 < arrayList9.size(); i14++) {
            arrayList11.add(i((a) arrayList9.get(i14), attributeValue4, list2, str4, arrayList3, arrayList4));
        }
        return b(jW, iF, arrayList11, arrayList5, arrayList7, arrayList8);
    }

    public void y(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        v(xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0012  */
    public int z(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strQ0 = q0(xmlPullParser, "schemeIdUri", null);
        strQ0.hashCode();
        int iJ = -1;
        switch (strQ0) {
            case "urn:dts:dash:audio_channel_configuration:2012":
            case "tag:dts.com,2014:dash:audio_channel_configuration:2012":
                iJ = J(xmlPullParser);
                break;
            case "urn:mpeg:dash:23003:3:audio_channel_configuration:2011":
                iJ = T(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
                break;
            case "tag:dolby.com,2014:dash:audio_channel_configuration:2011":
            case "urn:dolby:dash:audio_channel_configuration:2011":
                iJ = I(xmlPullParser);
                break;
            case "urn:mpeg:mpegB:cicp:ChannelConfiguration":
                iJ = Y(xmlPullParser);
                break;
            case "tag:dts.com,2018:uhd:audio_channel_configuration":
                iJ = K(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!w0.d(xmlPullParser, "AudioChannelConfiguration"));
        return iJ;
    }
}
