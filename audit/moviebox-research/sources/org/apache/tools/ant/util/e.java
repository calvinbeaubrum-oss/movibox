package org.apache.tools.ant.util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.tools.ant.BuildException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f72958a = d.k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SAXParserFactory f72959b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static SAXParserFactory f72960c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static DocumentBuilderFactory f72961d = null;

    public static BuildException a(SAXException sAXException) {
        Exception exception = sAXException.getException();
        return exception != null ? new BuildException(exception) : new BuildException(sAXException);
    }

    public static synchronized SAXParserFactory b() throws BuildException {
        try {
            if (f72960c == null) {
                SAXParserFactory sAXParserFactoryD = d();
                f72960c = sAXParserFactoryD;
                sAXParserFactoryD.setNamespaceAware(true);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72960c;
    }

    public static XMLReader c() throws BuildException {
        try {
            return e(b()).getXMLReader();
        } catch (SAXException e11) {
            throw a(e11);
        }
    }

    public static SAXParserFactory d() throws BuildException {
        try {
            return SAXParserFactory.newInstance();
        } catch (FactoryConfigurationError e11) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("XML parser factory has not been configured correctly: ");
            stringBuffer.append(e11.getMessage());
            throw new BuildException(stringBuffer.toString(), e11);
        }
    }

    public static SAXParser e(SAXParserFactory sAXParserFactory) throws BuildException {
        try {
            return sAXParserFactory.newSAXParser();
        } catch (ParserConfigurationException e11) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot create parser for the given configuration: ");
            stringBuffer.append(e11.getMessage());
            throw new BuildException(stringBuffer.toString(), e11);
        } catch (SAXException e12) {
            throw a(e12);
        }
    }
}
