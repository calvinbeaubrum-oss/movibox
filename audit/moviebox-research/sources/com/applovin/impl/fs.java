package com.applovin.impl;

import android.util.Xml;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class fs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f19120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Stack f19121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StringBuilder f19122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f19123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f19124e;

    /* JADX INFO: compiled from: source.java */
    public class a implements ContentHandler {
        public a() {
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i11, int i12) {
            String strTrim = new String(Arrays.copyOfRange(cArr, i11, i12)).trim();
            if (StringUtils.isValidString(strTrim)) {
                fs.this.f19122c.append(strTrim);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - fs.this.f19123d;
            com.applovin.impl.sdk.n unused = fs.this.f19120a;
            if (com.applovin.impl.sdk.n.a()) {
                fs.this.f19120a.a("XmlParser", "Finished parsing in " + seconds + " seconds");
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            fs fsVar = fs.this;
            fsVar.f19124e = (b) fsVar.f19121b.pop();
            fs.this.f19124e.d(fs.this.f19122c.toString().trim());
            fs.this.f19122c.setLength(0);
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i11, int i12) {
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() {
            com.applovin.impl.sdk.n unused = fs.this.f19120a;
            if (com.applovin.impl.sdk.n.a()) {
                fs.this.f19120a.a("XmlParser", "Begin parsing...");
            }
            fs.this.f19123d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            try {
                b bVar = !fs.this.f19121b.isEmpty() ? (b) fs.this.f19121b.peek() : null;
                b bVar2 = new b(str2, fs.this.a(attributes), bVar);
                if (bVar != null) {
                    bVar.a(bVar2);
                }
                fs.this.f19121b.push(bVar2);
            } catch (Exception e11) {
                com.applovin.impl.sdk.n unused = fs.this.f19120a;
                if (com.applovin.impl.sdk.n.a()) {
                    fs.this.f19120a.a("XmlParser", "Unable to process element <" + str2 + ">", e11);
                }
                throw new SAXException("Failed to start element", e11);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends es {
        public b(String str, Map map, es esVar) {
            super(str, map, esVar);
        }

        public void a(es esVar) {
            if (esVar == null) {
                throw new IllegalArgumentException("None specified.");
            }
            this.f18782e.add(esVar);
        }

        public void d(String str) {
            this.f18781d = str;
        }
    }

    public fs(com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f19120a = jVar.J();
    }

    public static es a(String str, com.applovin.impl.sdk.j jVar) {
        return new fs(jVar).a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map a(Attributes attributes) {
        if (attributes == null) {
            return Collections.emptyMap();
        }
        int length = attributes.getLength();
        HashMap map = new HashMap(length);
        for (int i11 = 0; i11 < length; i11++) {
            map.put(attributes.getQName(i11), attributes.getValue(i11));
        }
        return map;
    }

    public es a(String str) throws SAXException {
        if (str == null) {
            throw new IllegalArgumentException("Unable to parse. No XML specified.");
        }
        this.f19122c = new StringBuilder();
        this.f19121b = new Stack();
        this.f19124e = null;
        Xml.parse(str, new a());
        b bVar = this.f19124e;
        if (bVar != null) {
            return bVar;
        }
        throw new SAXException("Unable to parse XML into node");
    }
}
