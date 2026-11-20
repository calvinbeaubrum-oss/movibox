package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import bh.l;
import bh.p;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.util.f;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SsManifestParser implements b0.a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f34710a;

    /* JADX INFO: compiled from: source.java */
    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: " + str, null, true, 4);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f34712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final a f34713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Pair<String, Object>> f34714d = new LinkedList();

        public a(@Nullable a aVar, String str, String str2) {
            this.f34713c = aVar;
            this.f34711a = str;
            this.f34712b = str2;
        }

        public void a(Object obj) {
        }

        public abstract Object b();

        @Nullable
        public final Object c(String str) {
            for (int i11 = 0; i11 < this.f34714d.size(); i11++) {
                Pair<String, Object> pair = this.f34714d.get(i11);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            a aVar = this.f34713c;
            if (aVar == null) {
                return null;
            }
            return aVar.c(str);
        }

        public boolean d(String str) {
            return false;
        }

        public final a e(a aVar, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new c(aVar, str2);
            }
            if ("Protection".equals(str)) {
                return new b(aVar, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new e(aVar, str2);
            }
            return null;
        }

        public final Object f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f34712b.equals(name)) {
                        n(xmlPullParser);
                        z11 = true;
                    } else if (z11) {
                        if (i11 > 0) {
                            i11++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            a aVarE = e(this, name, this.f34711a);
                            if (aVarE == null) {
                                i11 = 1;
                            } else {
                                a(aVarE.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z11 && i11 == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z11) {
                    continue;
                } else if (i11 > 0) {
                    i11--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        public final boolean g(XmlPullParser xmlPullParser, String str, boolean z11) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z11;
        }

        public void h(XmlPullParser xmlPullParser) {
        }

        public final int i(XmlPullParser xmlPullParser, String str, int i11) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i11;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(null, e11);
            }
        }

        public final long j(XmlPullParser xmlPullParser, String str, long j11) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j11;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(null, e11);
            }
        }

        public final int k(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(null, e11);
            }
        }

        public final long l(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(null, e11);
            }
        }

        public final String m(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        public abstract void n(XmlPullParser xmlPullParser) throws ParserException;

        public void o(XmlPullParser xmlPullParser) {
        }

        public final void p(String str, @Nullable Object obj) {
            this.f34714d.add(Pair.create(str, obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34715e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public UUID f34716f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f34717g;

        public b(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        public static p[] q(byte[] bArr) {
            return new p[]{new p(true, null, 8, r(bArr), 0, 0, null)};
        }

        public static byte[] r(byte[] bArr) {
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < bArr.length; i11 += 2) {
                sb2.append((char) bArr[i11]);
            }
            String string = sb2.toString();
            byte[] bArrDecode = Base64.decode(string.substring(string.indexOf("<KID>") + 5, string.indexOf("</KID>")), 0);
            t(bArrDecode, 0, 3);
            t(bArrDecode, 1, 2);
            t(bArrDecode, 4, 5);
            t(bArrDecode, 6, 7);
            return bArrDecode;
        }

        public static String s(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        public static void t(byte[] bArr, int i11, int i12) {
            byte b11 = bArr[i11];
            bArr[i11] = bArr[i12];
            bArr[i12] = b11;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            UUID uuid = this.f34716f;
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0371a(uuid, l.a(uuid, this.f34717g), q(this.f34717g));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void h(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f34715e = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f34715e = true;
                this.f34716f = UUID.fromString(s(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void o(XmlPullParser xmlPullParser) {
            if (this.f34715e) {
                this.f34717g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public m1 f34718e;

        public c(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        public static List<byte[]> q(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] bArrJ = o0.J(str);
                byte[][] bArrJ2 = f.j(bArrJ);
                if (bArrJ2 == null) {
                    arrayList.add(bArrJ);
                } else {
                    Collections.addAll(arrayList, bArrJ2);
                }
            }
            return arrayList;
        }

        @Nullable
        public static String r(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return MimeTypes.VIDEO_H264;
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return MimeTypes.AUDIO_AAC;
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return MimeTypes.APPLICATION_TTML;
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return MimeTypes.AUDIO_AC3;
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return MimeTypes.AUDIO_E_AC3;
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return MimeTypes.AUDIO_DTS;
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return MimeTypes.AUDIO_DTS_HD;
            }
            if (str.equalsIgnoreCase("dtse")) {
                return MimeTypes.AUDIO_DTS_EXPRESS;
            }
            if (str.equalsIgnoreCase("opus")) {
                return MimeTypes.AUDIO_OPUS;
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            return this.f34718e;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x00b0  */
        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            int i11;
            m1.b bVar = new m1.b();
            String strR = r(m(xmlPullParser, "FourCC"));
            int iIntValue = ((Integer) c("Type")).intValue();
            if (iIntValue == 2) {
                bVar.K(MimeTypes.VIDEO_MP4).j0(k(xmlPullParser, "MaxWidth")).Q(k(xmlPullParser, "MaxHeight")).T(q(xmlPullParser.getAttributeValue(null, "CodecPrivateData")));
            } else if (iIntValue == 1) {
                if (strR == null) {
                    strR = MimeTypes.AUDIO_AAC;
                }
                int iK = k(xmlPullParser, "Channels");
                int iK2 = k(xmlPullParser, "SamplingRate");
                List<byte[]> listQ = q(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (listQ.isEmpty() && MimeTypes.AUDIO_AAC.equals(strR)) {
                    listQ = Collections.singletonList(com.google.android.exoplayer2.audio.a.a(iK2, iK));
                }
                bVar.K(MimeTypes.AUDIO_MP4).H(iK).f0(iK2).T(listQ);
            } else if (iIntValue == 3) {
                String str = (String) c("Subtype");
                if (str == null) {
                    i11 = 0;
                } else if (str.equals("CAPT")) {
                    i11 = 64;
                } else if (str.equals("DESC")) {
                    i11 = 1024;
                } else {
                    i11 = 0;
                }
                bVar.K(MimeTypes.APPLICATION_MP4).c0(i11);
            } else {
                bVar.K(MimeTypes.APPLICATION_MP4);
            }
            this.f34718e = bVar.S(xmlPullParser.getAttributeValue(null, "Index")).U((String) c("Name")).e0(strR).G(k(xmlPullParser, "Bitrate")).V((String) c("Language")).E();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b> f34719e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f34720f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f34721g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f34722h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f34723i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f34724j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f34725k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f34726l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0371a f34727m;

        public d(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            this.f34725k = -1;
            this.f34727m = null;
            this.f34719e = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b) {
                this.f34719e.add((com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b) obj);
            } else if (obj instanceof com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0371a) {
                com.google.android.exoplayer2.util.a.g(this.f34727m == null);
                this.f34727m = (com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0371a) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            int size = this.f34719e.size();
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b[] bVarArr = new com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b[size];
            this.f34719e.toArray(bVarArr);
            if (this.f34727m != null) {
                com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0371a c0371a = this.f34727m;
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(c0371a.f34750a, MimeTypes.VIDEO_MP4, c0371a.f34751b));
                for (int i11 = 0; i11 < size; i11++) {
                    com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = bVarArr[i11];
                    int i12 = bVar.f34753a;
                    if (i12 == 2 || i12 == 1) {
                        m1[] m1VarArr = bVar.f34762j;
                        for (int i13 = 0; i13 < m1VarArr.length; i13++) {
                            m1VarArr[i13] = m1VarArr[i13].b().M(drmInitData).E();
                        }
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a(this.f34720f, this.f34721g, this.f34722h, this.f34723i, this.f34724j, this.f34725k, this.f34726l, this.f34727m, bVarArr);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            this.f34720f = k(xmlPullParser, "MajorVersion");
            this.f34721g = k(xmlPullParser, "MinorVersion");
            this.f34722h = j(xmlPullParser, "TimeScale", 10000000L);
            this.f34723i = l(xmlPullParser, "Duration");
            this.f34724j = j(xmlPullParser, "DVRWindowLength", 0L);
            this.f34725k = i(xmlPullParser, "LookaheadCount", -1);
            this.f34726l = g(xmlPullParser, "IsLive", false);
            p("TimeScale", Long.valueOf(this.f34722h));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f34728e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<m1> f34729f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f34730g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f34731h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f34732i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f34733j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f34734k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f34735l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f34736m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f34737n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f34738o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f34739p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public ArrayList<Long> f34740q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f34741r;

        public e(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.f34728e = str;
            this.f34729f = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof m1) {
                this.f34729f.add((m1) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            m1[] m1VarArr = new m1[this.f34729f.size()];
            this.f34729f.toArray(m1VarArr);
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b(this.f34728e, this.f34734k, this.f34730g, this.f34731h, this.f34732i, this.f34733j, this.f34735l, this.f34736m, this.f34737n, this.f34738o, this.f34739p, m1VarArr, this.f34740q, this.f34741r);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "c".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            if ("c".equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }

        public final void q(XmlPullParser xmlPullParser) throws ParserException {
            int iS = s(xmlPullParser);
            this.f34730g = iS;
            p("Type", Integer.valueOf(iS));
            if (this.f34730g == 3) {
                this.f34731h = m(xmlPullParser, "Subtype");
            } else {
                this.f34731h = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            p("Subtype", this.f34731h);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Name");
            this.f34733j = attributeValue;
            p("Name", attributeValue);
            this.f34734k = m(xmlPullParser, "Url");
            this.f34735l = i(xmlPullParser, "MaxWidth", -1);
            this.f34736m = i(xmlPullParser, "MaxHeight", -1);
            this.f34737n = i(xmlPullParser, "DisplayWidth", -1);
            this.f34738o = i(xmlPullParser, "DisplayHeight", -1);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "Language");
            this.f34739p = attributeValue2;
            p("Language", attributeValue2);
            long jI = i(xmlPullParser, "TimeScale", -1);
            this.f34732i = jI;
            if (jI == -1) {
                this.f34732i = ((Long) c("TimeScale")).longValue();
            }
            this.f34740q = new ArrayList<>();
        }

        public final void r(XmlPullParser xmlPullParser) throws ParserException {
            int size = this.f34740q.size();
            long j11 = j(xmlPullParser, "t", C.TIME_UNSET);
            int i11 = 1;
            if (j11 == C.TIME_UNSET) {
                if (size == 0) {
                    j11 = 0;
                } else {
                    if (this.f34741r == -1) {
                        throw ParserException.createForMalformedManifest("Unable to infer start time", null);
                    }
                    j11 = this.f34740q.get(size - 1).longValue() + this.f34741r;
                }
            }
            this.f34740q.add(Long.valueOf(j11));
            this.f34741r = j(xmlPullParser, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, C.TIME_UNSET);
            long j12 = j(xmlPullParser, CampaignEx.JSON_KEY_AD_R, 1L);
            if (j12 > 1 && this.f34741r == C.TIME_UNSET) {
                throw ParserException.createForMalformedManifest("Repeated chunk with unspecified duration", null);
            }
            while (true) {
                long j13 = i11;
                if (j13 >= j12) {
                    return;
                }
                this.f34740q.add(Long.valueOf((this.f34741r * j13) + j11));
                i11++;
            }
        }

        public final int s(XmlPullParser xmlPullParser) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue == null) {
                throw new MissingFieldException("Type");
            }
            if (MimeTypes.BASE_TYPE_AUDIO.equalsIgnoreCase(attributeValue)) {
                return 1;
            }
            if ("video".equalsIgnoreCase(attributeValue)) {
                return 2;
            }
            if (MimeTypes.BASE_TYPE_TEXT.equalsIgnoreCase(attributeValue)) {
                return 3;
            }
            throw ParserException.createForMalformedManifest("Invalid key value[" + attributeValue + "]", null);
        }
    }

    public SsManifestParser() {
        try {
            this.f34710a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b0.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f34710a.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            return (com.google.android.exoplayer2.source.smoothstreaming.manifest.a) new d(null, uri.toString()).f(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e11) {
            throw ParserException.createForMalformedManifest(null, e11);
        }
    }
}
