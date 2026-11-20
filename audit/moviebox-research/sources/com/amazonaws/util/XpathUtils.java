package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class XpathUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Log f16290a = LogFactory.b(XpathUtils.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DocumentBuilderFactory f16291b = DocumentBuilderFactory.newInstance();

    public static Node a(String str, Node node) throws XPathExpressionException {
        if (node == null) {
            return null;
        }
        return (Node) g().evaluate(str, node, XPathConstants.NODE);
    }

    public static String b(String str, Node node) throws XPathExpressionException {
        return e(str, node);
    }

    public static Document c(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        NamespaceRemovingInputStream namespaceRemovingInputStream = new NamespaceRemovingInputStream(inputStream);
        Document document = f16291b.newDocumentBuilder().parse(namespaceRemovingInputStream);
        namespaceRemovingInputStream.close();
        return document;
    }

    public static Document d(String str) throws ParserConfigurationException, SAXException, IOException {
        return c(new ByteArrayInputStream(str.getBytes(StringUtils.f16272a)));
    }

    public static String e(String str, Node node) throws XPathExpressionException {
        if (f(node)) {
            return null;
        }
        if (InstructionFileId.DOT.equals(str) || a(str, node) != null) {
            return g().evaluate(str, node).trim();
        }
        return null;
    }

    public static boolean f(Node node) {
        return node == null;
    }

    public static XPath g() {
        return XPathFactory.newInstance().newXPath();
    }
}
