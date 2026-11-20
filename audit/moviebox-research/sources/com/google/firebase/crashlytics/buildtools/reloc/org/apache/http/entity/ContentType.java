package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity;

import ck.b;
import ck.c;
import ck.g;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.a;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.i;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicNameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import fk.f;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class ContentType implements Serializable {
    public static final ContentType APPLICATION_ATOM_XML;
    public static final ContentType APPLICATION_FORM_URLENCODED;
    public static final ContentType APPLICATION_JSON;
    public static final ContentType APPLICATION_OCTET_STREAM;
    public static final ContentType APPLICATION_SVG_XML;
    public static final ContentType APPLICATION_XHTML_XML;
    public static final ContentType APPLICATION_XML;
    private static final Map<String, ContentType> CONTENT_TYPE_MAP;
    public static final ContentType DEFAULT_BINARY;
    public static final ContentType DEFAULT_TEXT;
    public static final ContentType IMAGE_BMP;
    public static final ContentType IMAGE_GIF;
    public static final ContentType IMAGE_JPEG;
    public static final ContentType IMAGE_PNG;
    public static final ContentType IMAGE_SVG;
    public static final ContentType IMAGE_TIFF;
    public static final ContentType IMAGE_WEBP;
    public static final ContentType MULTIPART_FORM_DATA;
    public static final ContentType TEXT_HTML;
    public static final ContentType TEXT_PLAIN;
    public static final ContentType TEXT_XML;
    public static final ContentType WILDCARD;
    private static final long serialVersionUID = -7768694718232371896L;
    private final Charset charset;
    private final String mimeType;
    private final o[] params;

    static {
        Charset charset = a.f40093c;
        ContentType contentTypeCreate = create("application/atom+xml", charset);
        APPLICATION_ATOM_XML = contentTypeCreate;
        ContentType contentTypeCreate2 = create("application/x-www-form-urlencoded", charset);
        APPLICATION_FORM_URLENCODED = contentTypeCreate2;
        ContentType contentTypeCreate3 = create("application/json", a.f40091a);
        APPLICATION_JSON = contentTypeCreate3;
        APPLICATION_OCTET_STREAM = create(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, (Charset) null);
        ContentType contentTypeCreate4 = create("application/svg+xml", charset);
        APPLICATION_SVG_XML = contentTypeCreate4;
        ContentType contentTypeCreate5 = create("application/xhtml+xml", charset);
        APPLICATION_XHTML_XML = contentTypeCreate5;
        ContentType contentTypeCreate6 = create("application/xml", charset);
        APPLICATION_XML = contentTypeCreate6;
        ContentType contentTypeCreate7 = create("image/bmp");
        IMAGE_BMP = contentTypeCreate7;
        ContentType contentTypeCreate8 = create("image/gif");
        IMAGE_GIF = contentTypeCreate8;
        ContentType contentTypeCreate9 = create("image/jpeg");
        IMAGE_JPEG = contentTypeCreate9;
        ContentType contentTypeCreate10 = create("image/png");
        IMAGE_PNG = contentTypeCreate10;
        ContentType contentTypeCreate11 = create("image/svg+xml");
        IMAGE_SVG = contentTypeCreate11;
        ContentType contentTypeCreate12 = create("image/tiff");
        IMAGE_TIFF = contentTypeCreate12;
        ContentType contentTypeCreate13 = create("image/webp");
        IMAGE_WEBP = contentTypeCreate13;
        ContentType contentTypeCreate14 = create("multipart/form-data", charset);
        MULTIPART_FORM_DATA = contentTypeCreate14;
        ContentType contentTypeCreate15 = create("text/html", charset);
        TEXT_HTML = contentTypeCreate15;
        ContentType contentTypeCreate16 = create("text/plain", charset);
        TEXT_PLAIN = contentTypeCreate16;
        ContentType contentTypeCreate17 = create("text/xml", charset);
        TEXT_XML = contentTypeCreate17;
        WILDCARD = create("*/*", (Charset) null);
        ContentType[] contentTypeArr = {contentTypeCreate, contentTypeCreate2, contentTypeCreate3, contentTypeCreate4, contentTypeCreate5, contentTypeCreate6, contentTypeCreate7, contentTypeCreate8, contentTypeCreate9, contentTypeCreate10, contentTypeCreate11, contentTypeCreate12, contentTypeCreate13, contentTypeCreate14, contentTypeCreate15, contentTypeCreate16, contentTypeCreate17};
        HashMap map = new HashMap();
        for (int i11 = 0; i11 < 17; i11++) {
            ContentType contentType = contentTypeArr[i11];
            map.put(contentType.getMimeType(), contentType);
        }
        CONTENT_TYPE_MAP = Collections.unmodifiableMap(map);
        DEFAULT_TEXT = TEXT_PLAIN;
        DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
    }

    public ContentType(String str, Charset charset) {
        this.mimeType = str;
        this.charset = charset;
        this.params = null;
    }

    public ContentType(String str, Charset charset, o[] oVarArr) {
        this.mimeType = str;
        this.charset = charset;
        this.params = oVarArr;
    }

    private static ContentType create(e eVar, boolean z11) {
        return create(eVar.getName(), eVar.getParameters(), z11);
    }

    public static ContentType create(String str) {
        return create(str, (Charset) null);
    }

    public static ContentType create(String str, String str2) throws UnsupportedCharsetException {
        return create(str, !f.b(str2) ? Charset.forName(str2) : null);
    }

    public static ContentType create(String str, Charset charset) {
        String lowerCase = ((String) fk.a.d(str, "MIME type")).toLowerCase(Locale.ROOT);
        fk.a.a(valid(lowerCase), "MIME type may not contain reserved characters");
        return new ContentType(lowerCase, charset);
    }

    public static ContentType create(String str, o... oVarArr) throws UnsupportedCharsetException {
        fk.a.a(valid(((String) fk.a.d(str, "MIME type")).toLowerCase(Locale.ROOT)), "MIME type may not contain reserved characters");
        return create(str, oVarArr, true);
    }

    private static ContentType create(String str, o[] oVarArr, boolean z11) {
        Charset charsetForName;
        int length = oVarArr.length;
        int i11 = 0;
        while (true) {
            if (i11 < length) {
                o oVar = oVarArr[i11];
                if (oVar.getName().equalsIgnoreCase("charset")) {
                    String value = oVar.getValue();
                    if (!f.b(value)) {
                        try {
                            charsetForName = Charset.forName(value);
                            break;
                        } catch (UnsupportedCharsetException e11) {
                            if (z11) {
                                throw e11;
                            }
                            charsetForName = null;
                            break;
                        }
                    }
                } else {
                    i11++;
                }
            }
            charsetForName = null;
            break;
        }
        if (oVarArr.length <= 0) {
            oVarArr = null;
        }
        return new ContentType(str, charsetForName, oVarArr);
    }

    public static ContentType get(i iVar) throws ParseException, UnsupportedCharsetException {
        d dVarC;
        if (iVar != null && (dVarC = iVar.c()) != null) {
            e[] elements = dVarC.getElements();
            if (elements.length > 0) {
                return create(elements[0], true);
            }
        }
        return null;
    }

    public static ContentType getByMimeType(String str) {
        if (str == null) {
            return null;
        }
        return CONTENT_TYPE_MAP.get(str);
    }

    public static ContentType getLenient(i iVar) {
        d dVarC;
        if (iVar != null && (dVarC = iVar.c()) != null) {
            try {
                e[] elements = dVarC.getElements();
                if (elements.length > 0) {
                    return create(elements[0], false);
                }
            } catch (ParseException unused) {
            }
        }
        return null;
    }

    public static ContentType getLenientOrDefault(i iVar) throws ParseException, UnsupportedCharsetException {
        ContentType contentType = get(iVar);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }

    public static ContentType getOrDefault(i iVar) throws ParseException, UnsupportedCharsetException {
        ContentType contentType = get(iVar);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }

    public static ContentType parse(String str) throws ParseException, UnsupportedCharsetException {
        fk.a.g(str, "Content type");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        e[] eVarArrA = c.f14937c.a(charArrayBuffer, new g(0, str.length()));
        if (eVarArrA.length > 0) {
            return create(eVarArrA[0], true);
        }
        throw new ParseException("Invalid content type: " + str);
    }

    private static boolean valid(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '\"' || cCharAt == ',' || cCharAt == ';') {
                return false;
            }
        }
        return true;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getParameter(String str) {
        fk.a.e(str, "Parameter name");
        o[] oVarArr = this.params;
        if (oVarArr == null) {
            return null;
        }
        for (o oVar : oVarArr) {
            if (oVar.getName().equalsIgnoreCase(str)) {
                return oVar.getValue();
            }
        }
        return null;
    }

    public String toString() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        charArrayBuffer.append(this.mimeType);
        if (this.params != null) {
            charArrayBuffer.append("; ");
            b.f14935b.e(charArrayBuffer, this.params, false);
        } else if (this.charset != null) {
            charArrayBuffer.append("; charset=");
            charArrayBuffer.append(this.charset.name());
        }
        return charArrayBuffer.toString();
    }

    public ContentType withCharset(String str) {
        return create(getMimeType(), str);
    }

    public ContentType withCharset(Charset charset) {
        return create(getMimeType(), charset);
    }

    public ContentType withParameters(o... oVarArr) throws UnsupportedCharsetException {
        if (oVarArr.length == 0) {
            return this;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        o[] oVarArr2 = this.params;
        if (oVarArr2 != null) {
            for (o oVar : oVarArr2) {
                linkedHashMap.put(oVar.getName(), oVar.getValue());
            }
        }
        for (o oVar2 : oVarArr) {
            linkedHashMap.put(oVar2.getName(), oVar2.getValue());
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size() + 1);
        if (this.charset != null && !linkedHashMap.containsKey("charset")) {
            arrayList.add(new BasicNameValuePair("charset", this.charset.name()));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return create(getMimeType(), (o[]) arrayList.toArray(new o[arrayList.size()]), true);
    }
}
