package com.bytedance.sdk.openadsdk.core.Tf.sc.sc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends com.bytedance.sdk.openadsdk.core.Tf.sc.pFF {

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public static final String f28237qr = null;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        String We;
        com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        String f28239sc;
        com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF zY;
        final List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> ExN = new ArrayList();
        final List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> TRI = new ArrayList();

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        float f28238qr = Float.MIN_VALUE;

        public sc() {
        }

        public sc(String str, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF pff) {
            sc(str, enumC0293sc, pff);
        }

        public void pFF(String str) {
            this.TRI.add(new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(str).sc());
        }

        public void sc(String str) {
            this.ExN.add(new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(str).sc());
        }

        public void sc(String str, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF pff) {
            this.f28239sc = str;
            this.pFF = enumC0293sc;
            this.zY = pff;
        }
    }

    public ExN(Context context, int i11, int i12) {
        super(context, i11, i12);
    }

    private static List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> We(String str) {
        return sc(str, false);
    }

    public static int pFF(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0062  */
    private com.bytedance.sdk.openadsdk.core.Tf.sc pFF(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) throws Throwable {
        if (this.f28233sc >= 5) {
            sc(xmlPullParser);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.Tf.We we2 = new com.bytedance.sdk.openadsdk.core.Tf.We(null);
        String strPFF = null;
        com.bytedance.sdk.openadsdk.core.Tf.zY zYVarSc = null;
        while (true) {
            if (xmlPullParser.getEventType() == 3 && "Wrapper".equals(xmlPullParser.getName())) {
                com.bytedance.sdk.openadsdk.core.Tf.sc scVarSc = sc(strPFF, list);
                if (scVarSc != null) {
                    if (scVarSc.zY() == null) {
                        scVarSc.sc(zYVarSc);
                    }
                    scVarSc.sc().sc(we2);
                }
                return scVarSc;
            }
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "VASTAdTagURI":
                        strPFF = pFF(pFF(xmlPullParser, "VASTAdTagURI"), list);
                        if (!TextUtils.isEmpty(strPFF)) {
                            break;
                        } else {
                            sc(xmlPullParser, "Wrapper", 3);
                            this.ExN = -2;
                            return null;
                        }
                        break;
                    case "Error":
                        list.add(new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(pFF(xmlPullParser, "Error")).sc());
                        break;
                    case "TrackingEvents":
                        zY.sc(xmlPullParser, we2);
                        break;
                    case "CompanionAds":
                        zYVarSc = com.bytedance.sdk.openadsdk.core.Tf.sc.sc.sc.sc(this.pFF, xmlPullParser);
                        break;
                    case "ClickTracking":
                        we2.qr(sc(xmlPullParser, "ClickTracking"));
                        break;
                    case "Impression":
                        we2.sc(sc(xmlPullParser, name));
                        break;
                }
            }
        }
    }

    public static String pFF(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String strTrim;
        String str2 = f28237qr;
        xmlPullParser.require(2, str2, str);
        if (xmlPullParser.next() == 4) {
            strTrim = xmlPullParser.getText().trim();
            xmlPullParser.nextTag();
        } else {
            strTrim = "";
        }
        xmlPullParser.require(3, str2, str);
        return strTrim;
    }

    private com.bytedance.sdk.openadsdk.core.Tf.sc sc(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) throws Throwable {
        xmlPullParser.require(2, f28237qr, "VAST");
        boolean z11 = false;
        String strPFF = null;
        while (xmlPullParser.next() != 1) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if ("Error".equals(name)) {
                    strPFF = pFF(xmlPullParser, name);
                } else if ("Ad".equals(name)) {
                    if (sc(xmlPullParser.getAttributeValue(f28237qr, "sequence"))) {
                        while (true) {
                            if (xmlPullParser.next() == 3 && "Ad".equals(xmlPullParser.getName())) {
                                break;
                            }
                            if (xmlPullParser.getEventType() == 2) {
                                String name2 = xmlPullParser.getName();
                                if ("InLine".equals(name2)) {
                                    com.bytedance.sdk.openadsdk.core.Tf.sc scVarSc = pFF.sc(this.pFF, xmlPullParser, list, this.zY, this.We);
                                    if (scVarSc != null) {
                                        if (!TextUtils.isEmpty(scVarSc.qr())) {
                                            return scVarSc;
                                        }
                                        this.ExN = -6;
                                        return null;
                                    }
                                } else if ("Wrapper".equals(name2)) {
                                    com.bytedance.sdk.openadsdk.core.Tf.sc scVarPFF = pFF(xmlPullParser, list);
                                    if (scVarPFF != null) {
                                        return scVarPFF;
                                    }
                                } else {
                                    sc(xmlPullParser);
                                }
                            }
                        }
                    } else {
                        sc(xmlPullParser);
                    }
                    z11 = true;
                } else {
                    sc(xmlPullParser);
                }
            }
        }
        if (!z11) {
            this.ExN = -4;
            zY(strPFF);
        }
        if (this.ExN == 0) {
            this.ExN = -5;
        }
        return null;
    }

    private static List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> sc(String str, boolean z11) {
        return TextUtils.isEmpty(str) ? new ArrayList() : Collections.singletonList(new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(str).sc(z11).sc());
    }

    public static List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> sc(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        return We(pFF(xmlPullParser, str));
    }

    private void sc(com.bytedance.sdk.openadsdk.core.Tf.sc scVar) {
        if (this.TRI == null) {
            this.TRI = new com.bytedance.sdk.openadsdk.core.Tf.sc.pFF.sc();
        }
        com.bytedance.sdk.openadsdk.core.Tf.sc.pFF.sc scVar2 = this.TRI;
        scVar2.f28234sc = this.ExN;
        scVar2.pFF = this.f28233sc;
        if (scVar != null) {
            scVar2.zY = scVar.sc().pFF.size() <= 0;
        }
    }

    public static void sc(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i11 = 1;
        while (i11 != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i11++;
            } else if (next == 3) {
                i11--;
            }
        }
    }

    public static void sc(XmlPullParser xmlPullParser, String str, int i11) throws XmlPullParserException, IOException {
        while (xmlPullParser.getEventType() != 1) {
            if (str.equals(xmlPullParser.getName()) && xmlPullParser.getEventType() == i11) {
                return;
            } else {
                xmlPullParser.next();
            }
        }
    }

    private void zY(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(Collections.singletonList(new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(str).sc()), this.f28233sc > 0 ? com.bytedance.sdk.openadsdk.core.Tf.sc.sc.NO_ADS_VAST_RESPONSE : com.bytedance.sdk.openadsdk.core.Tf.sc.sc.UNDEFINED_ERROR, -1L, null), (com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    @Override // com.bytedance.sdk.openadsdk.core.Tf.sc.pFF
    public com.bytedance.sdk.openadsdk.core.Tf.sc sc(String str, List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        this.ExN = 0;
        ?? r11 = 0;
        if (this.pFF == null) {
            this.ExN = -1;
            return null;
        }
        ?? IsEmpty = TextUtils.isEmpty(str);
        try {
            if (IsEmpty != 0) {
                this.ExN = -2;
                return null;
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                    xmlPullParserNewPullParser.setInput(byteArrayInputStream, "UTF-8");
                    xmlPullParserNewPullParser.nextTag();
                    com.bytedance.sdk.openadsdk.core.Tf.sc scVarSc = sc(xmlPullParserNewPullParser, list);
                    sc(scVarSc);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException unused) {
                    }
                    return scVarSc;
                } catch (Exception unused2) {
                    this.ExN = -3;
                    sc((com.bytedance.sdk.openadsdk.core.Tf.sc) null);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            } catch (Exception unused4) {
                byteArrayInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (r11 != 0) {
                    try {
                        r11.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            r11 = IsEmpty;
        }
    }
}
