package s20;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.hisavana.common.tracking.TrackingKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Stack;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Location;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.RuntimeConfigurable;
import org.apache.tools.ant.c0;
import org.apache.tools.ant.util.p;
import org.apache.tools.ant.w;
import org.apache.tools.ant.y;
import org.apache.tools.ant.z;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f75940b = new C0836b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f75941c = new f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f75942d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f75943e = new d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final org.apache.tools.ant.util.d f75944f = org.apache.tools.ant.util.d.k();

    /* JADX INFO: compiled from: source.java */
    public static class a {
        public void a(char[] cArr, int i11, int i12, s20.a aVar) throws SAXParseException {
            String strTrim = new String(cArr, i11, i12).trim();
            if (strTrim.length() <= 0) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unexpected text \"");
            stringBuffer.append(strTrim);
            stringBuffer.append("\"");
            throw new SAXParseException(stringBuffer.toString(), aVar.k());
        }

        public void b(String str, String str2, String str3, s20.a aVar) throws SAXParseException {
        }

        public void c(String str, String str2, s20.a aVar) {
        }

        public a d(String str, String str2, String str3, Attributes attributes, s20.a aVar) throws SAXParseException {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unexpected element \"");
            stringBuffer.append(str3);
            stringBuffer.append(" \"");
            throw new SAXParseException(stringBuffer.toString(), aVar.k());
        }

        public void e(String str, String str2, String str3, Attributes attributes, s20.a aVar) throws SAXParseException {
        }
    }

    /* JADX INFO: renamed from: s20.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0836b extends a {
        @Override // s20.b.a
        public void a(char[] cArr, int i11, int i12, s20.a aVar) throws SAXParseException {
            aVar.c().addText(cArr, i11, i12);
        }

        @Override // s20.b.a
        public void c(String str, String str2, s20.a aVar) {
            aVar.o();
        }

        @Override // s20.b.a
        public a d(String str, String str2, String str3, Attributes attributes, s20.a aVar) throws SAXParseException {
            return b.f75940b;
        }

        @Override // s20.b.a
        public void e(String str, String str2, String str3, Attributes attributes, s20.a aVar) throws SAXParseException {
            RuntimeConfigurable runtimeConfigurableC = aVar.c();
            Object proxy = runtimeConfigurableC != null ? runtimeConfigurableC.getProxy() : null;
            c0 c0Var = new c0(str2);
            c0Var.setProject(aVar.m());
            c0Var.U(str);
            c0Var.V(str3);
            c0Var.t(w.e(c0Var.C(), str2));
            c0Var.s(str3);
            c0Var.setLocation(new Location(aVar.k().getSystemId(), aVar.k().getLineNumber(), aVar.k().getColumnNumber()));
            c0Var.q(aVar.h());
            if (proxy != null) {
                ((c0) proxy).v(c0Var);
            } else {
                aVar.h().b(c0Var);
            }
            aVar.b(c0Var, attributes);
            RuntimeConfigurable runtimeConfigurable = new RuntimeConfigurable(c0Var, c0Var.j());
            for (int i11 = 0; i11 < attributes.getLength(); i11++) {
                String localName = attributes.getLocalName(i11);
                String uri = attributes.getURI(i11);
                if (uri != null && !uri.equals("") && !uri.equals(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(uri);
                    stringBuffer.append(":");
                    stringBuffer.append(attributes.getQName(i11));
                    localName = stringBuffer.toString();
                }
                String value = attributes.getValue(i11);
                if ("ant-type".equals(localName) || ("antlib:org.apache.tools.ant".equals(uri) && "ant-type".equals(attributes.getLocalName(i11)))) {
                    Project projectM = aVar.m();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("WARNING: the ant-type mechanism has been deprecated");
                    stringBuffer2.append(p.f72993a);
                    stringBuffer2.append("         and");
                    stringBuffer2.append(" will not be available in Ant 1.8.0 or higher");
                    projectM.x(stringBuffer2.toString(), 1);
                    int iIndexOf = value.indexOf(":");
                    if (iIndexOf >= 0) {
                        String strSubstring = value.substring(0, iIndexOf);
                        String strL = aVar.l(strSubstring);
                        if (strL == null) {
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("Unable to find XML NS prefix \"");
                            stringBuffer3.append(strSubstring);
                            stringBuffer3.append("\"");
                            throw new BuildException(stringBuffer3.toString());
                        }
                        value = w.e(strL, value.substring(iIndexOf + 1));
                    }
                    localName = "ant-type";
                }
                runtimeConfigurable.setAttribute(localName, value);
            }
            if (runtimeConfigurableC != null) {
                runtimeConfigurableC.addChild(runtimeConfigurable);
            }
            aVar.p(runtimeConfigurable);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends a {
        @Override // s20.b.a
        public a d(String str, String str2, String str3, Attributes attributes, s20.a aVar) throws SAXParseException {
            if (str2.equals("project") && (str.equals("") || str.equals("antlib:org.apache.tools.ant"))) {
                return b.f75943e;
            }
            if (!str2.equals(str3)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unexpected element \"");
                stringBuffer.append(str3);
                stringBuffer.append("\" ");
                stringBuffer.append(str2);
                throw new SAXParseException(stringBuffer.toString(), aVar.k());
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unexpected element \"{");
            stringBuffer2.append(str);
            stringBuffer2.append("}");
            stringBuffer2.append(str2);
            stringBuffer2.append("\" {");
            stringBuffer2.append("antlib:org.apache.tools.ant");
            stringBuffer2.append("}");
            stringBuffer2.append(str2);
            throw new SAXParseException(stringBuffer2.toString(), aVar.k());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends a {
        @Override // s20.b.a
        public a d(String str, String str2, String str3, Attributes attributes, s20.a aVar) throws SAXParseException {
            return (str2.equals("target") && (str.equals("") || str.equals("antlib:org.apache.tools.ant"))) ? b.f75941c : b.f75940b;
        }

        @Override // s20.b.a
        public void e(String str, String str2, String str3, Attributes attributes, s20.a aVar) throws SAXParseException {
            Project projectM = aVar.m();
            aVar.j().k(new Location(aVar.k()));
            String str4 = null;
            boolean z11 = false;
            for (int i11 = 0; i11 < attributes.getLength(); i11++) {
                String uri = attributes.getURI(i11);
                if (uri == null || uri.equals("") || uri.equals(str)) {
                    String localName = attributes.getLocalName(i11);
                    String value = attributes.getValue(i11);
                    if (localName.equals(TmcEngineFactory.ENGINE_TYPE_DEFAULT)) {
                        if (value != null && !value.equals("") && !aVar.n()) {
                            projectM.H(value);
                        }
                    } else if (localName.equals("name")) {
                        if (value != null) {
                            aVar.r(value);
                            if (!aVar.n()) {
                                projectM.I(value);
                                projectM.d(value, projectM);
                            }
                            z11 = true;
                        }
                    } else if (!localName.equals("id")) {
                        if (!localName.equals("basedir")) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Unexpected attribute \"");
                            stringBuffer.append(attributes.getQName(i11));
                            stringBuffer.append("\"");
                            throw new SAXParseException(stringBuffer.toString(), aVar.k());
                        }
                        if (!aVar.n()) {
                            str4 = value;
                        }
                    } else if (value != null && !aVar.n()) {
                        projectM.d(value, projectM);
                    }
                }
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("ant.file.");
            stringBuffer2.append(aVar.g());
            String strS = projectM.s(stringBuffer2.toString());
            if (strS != null && z11) {
                File file = new File(strS);
                if (aVar.n() && !file.equals(aVar.e())) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Duplicated project name in import. Project ");
                    stringBuffer3.append(aVar.g());
                    stringBuffer3.append(" defined first in ");
                    stringBuffer3.append(strS);
                    stringBuffer3.append(" and again in ");
                    stringBuffer3.append(aVar.e());
                    projectM.x(stringBuffer3.toString(), 1);
                }
            }
            if (aVar.e() != null && z11) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("ant.file.");
                stringBuffer4.append(aVar.g());
                projectM.M(stringBuffer4.toString(), aVar.e().toString());
            }
            if (aVar.n()) {
                return;
            }
            if (projectM.s("basedir") != null) {
                projectM.G(projectM.s("basedir"));
            } else if (str4 == null) {
                projectM.G(aVar.f().getAbsolutePath());
            } else if (new File(str4).isAbsolute()) {
                projectM.G(str4);
            } else {
                projectM.F(b.f75944f.q(aVar.f(), str4));
            }
            projectM.e("", aVar.j());
            aVar.s(aVar.j());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends DefaultHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Stack f75945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f75946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s20.a f75947c;

        public e(s20.a aVar, a aVar2) {
            Stack stack = new Stack();
            this.f75945a = stack;
            this.f75946b = aVar2;
            stack.push(aVar2);
            this.f75947c = aVar;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i11, int i12) throws SAXParseException {
            this.f75946b.a(cArr, i11, i12, this.f75947c);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            this.f75946b.c(str, str2, this.f75947c);
            a aVar = (a) this.f75945a.pop();
            this.f75946b = aVar;
            if (aVar != null) {
                aVar.b(str, str2, str3, this.f75947c);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
            this.f75947c.d(str);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) {
            Project projectM = this.f75947c.m();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("resolving systemId: ");
            stringBuffer.append(str2);
            projectM.x(stringBuffer.toString(), 3);
            if (str2.startsWith("file:")) {
                String strI = b.f75944f.i(str2);
                File file = new File(strI);
                if (!file.isAbsolute()) {
                    file = b.f75944f.q(this.f75947c.f(), strI);
                    Project projectM2 = this.f75947c.m();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Warning: '");
                    stringBuffer2.append(str2);
                    stringBuffer2.append("' in ");
                    stringBuffer2.append(this.f75947c.e());
                    stringBuffer2.append(" should be expressed simply as '");
                    stringBuffer2.append(strI.replace('\\', '/'));
                    stringBuffer2.append("' for compliance with other XML tools");
                    projectM2.x(stringBuffer2.toString(), 1);
                }
                Project projectM3 = this.f75947c.m();
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("file=");
                stringBuffer3.append(file);
                projectM3.x(stringBuffer3.toString(), 4);
                try {
                    InputSource inputSource = new InputSource(new FileInputStream(file));
                    inputSource.setSystemId(b.f75944f.r(file.getAbsolutePath()));
                    return inputSource;
                } catch (FileNotFoundException unused) {
                    Project projectM4 = this.f75947c.m();
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append(file.getAbsolutePath());
                    stringBuffer4.append(" could not be found");
                    projectM4.x(stringBuffer4.toString(), 1);
                }
            }
            this.f75947c.m().x("could not resolve systemId", 4);
            return null;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
            this.f75947c.u(locator);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXParseException {
            a aVarD = this.f75946b.d(str, str2, str3, attributes, this.f75947c);
            this.f75945a.push(this.f75946b);
            this.f75946b = aVarD;
            aVarD.e(str, str2, str3, attributes, this.f75947c);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
            this.f75947c.v(str, str2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends a {
        @Override // s20.b.a
        public void c(String str, String str2, s20.a aVar) {
            aVar.s(aVar.j());
        }

        @Override // s20.b.a
        public a d(String str, String str2, String str3, Attributes attributes, s20.a aVar) throws SAXParseException {
            return b.f75940b;
        }

        @Override // s20.b.a
        public void e(String str, String str2, String str3, Attributes attributes, s20.a aVar) throws SAXParseException {
            Project projectM = aVar.m();
            y yVar = new y();
            yVar.m(projectM);
            yVar.k(new Location(aVar.k()));
            aVar.a(yVar);
            String str4 = null;
            boolean z11 = false;
            String str5 = "";
            for (int i11 = 0; i11 < attributes.getLength(); i11++) {
                String uri = attributes.getURI(i11);
                if (uri == null || uri.equals("") || uri.equals(str)) {
                    String localName = attributes.getLocalName(i11);
                    String value = attributes.getValue(i11);
                    if (localName.equals("name")) {
                        if ("".equals(value)) {
                            throw new BuildException("name attribute must not be empty");
                        }
                        str4 = value;
                    } else if (localName.equals("depends")) {
                        str5 = value;
                    } else if (localName.equals("if")) {
                        yVar.j(value);
                    } else if (localName.equals("unless")) {
                        yVar.n(value);
                    } else if (!localName.equals("id")) {
                        if (!localName.equals(TrackingKey.DESCRIPTION)) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Unexpected attribute \"");
                            stringBuffer.append(localName);
                            stringBuffer.append("\"");
                            throw new SAXParseException(stringBuffer.toString(), aVar.k());
                        }
                        yVar.i(value);
                    } else if (value != null && !value.equals("")) {
                        aVar.m().d(value, yVar);
                    }
                }
            }
            if (str4 == null) {
                throw new SAXParseException("target element appears without a name attribute", aVar.k());
            }
            if (aVar.i().get(str4) != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Duplicate target '");
                stringBuffer2.append(str4);
                stringBuffer2.append("'");
                throw new BuildException(stringBuffer2.toString(), yVar.c());
            }
            if (projectM.u().containsKey(str4)) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Already defined in main or a previous import, ignore ");
                stringBuffer3.append(str4);
                projectM.x(stringBuffer3.toString(), 3);
            } else {
                yVar.l(str4);
                aVar.i().put(str4, yVar);
                projectM.c(str4, yVar);
                z11 = true;
            }
            if (str5.length() > 0) {
                yVar.h(str5);
            }
            if (!aVar.n() || aVar.g() == null || aVar.g().length() == 0) {
                return;
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(aVar.g());
            stringBuffer4.append(InstructionFileId.DOT);
            stringBuffer4.append(str4);
            String string = stringBuffer4.toString();
            if (z11) {
                yVar = new y(yVar);
            }
            yVar.l(string);
            aVar.i().put(string, yVar);
            projectM.c(string, yVar);
        }
    }

    public void j(Project project, Object obj, e eVar) throws BuildException {
        String string;
        URL url;
        File fileO;
        String string2;
        s20.a aVar = eVar.f75947c;
        InputStream inputStreamOpenStream = null;
        if (obj instanceof File) {
            fileO = f75944f.o(((File) obj).getAbsolutePath());
            aVar.q(fileO);
            string = fileO.toString();
            url = null;
        } else {
            if (!(obj instanceof URL)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Source ");
                stringBuffer.append(obj.getClass().getName());
                stringBuffer.append(" not supported by this plugin");
                throw new BuildException(stringBuffer.toString());
            }
            URL url2 = (URL) obj;
            string = url2.toString();
            url = url2;
            fileO = null;
        }
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                XMLReader xMLReaderC = org.apache.tools.ant.util.e.c();
                                if (fileO != null) {
                                    string2 = f75944f.r(fileO.getAbsolutePath());
                                    inputStreamOpenStream = new FileInputStream(fileO);
                                } else {
                                    inputStreamOpenStream = FirebasePerfUrlConnection.openStream(url);
                                    string2 = url.toString();
                                }
                                InputSource inputSource = new InputSource(inputStreamOpenStream);
                                if (string2 != null) {
                                    inputSource.setSystemId(string2);
                                }
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("parsing buildfile ");
                                stringBuffer2.append(string);
                                stringBuffer2.append(" with URI = ");
                                stringBuffer2.append(string2);
                                project.x(stringBuffer2.toString(), 3);
                                xMLReaderC.setContentHandler(eVar);
                                xMLReaderC.setEntityResolver(eVar);
                                xMLReaderC.setErrorHandler(eVar);
                                xMLReaderC.setDTDHandler(eVar);
                                xMLReaderC.parse(inputSource);
                                org.apache.tools.ant.util.d.b(inputStreamOpenStream);
                            } catch (UnsupportedEncodingException e11) {
                                StringBuffer stringBuffer3 = new StringBuffer();
                                stringBuffer3.append("Encoding of project file ");
                                stringBuffer3.append(string);
                                stringBuffer3.append(" is invalid.");
                                throw new BuildException(stringBuffer3.toString(), e11);
                            }
                        } catch (IOException e12) {
                            StringBuffer stringBuffer4 = new StringBuffer();
                            stringBuffer4.append("Error reading project file ");
                            stringBuffer4.append(string);
                            stringBuffer4.append(": ");
                            stringBuffer4.append(e12.getMessage());
                            throw new BuildException(stringBuffer4.toString(), e12);
                        }
                    } catch (SAXParseException e13) {
                        e = e13;
                        Location location = new Location(e.getSystemId(), e.getLineNumber(), e.getColumnNumber());
                        Exception exception = e.getException();
                        if (!(exception instanceof BuildException)) {
                            String message = e.getMessage();
                            if (exception != null) {
                                e = exception;
                            }
                            throw new BuildException(message, e, location);
                        }
                        BuildException buildException = (BuildException) exception;
                        if (buildException.getLocation() != Location.UNKNOWN_LOCATION) {
                            throw buildException;
                        }
                        buildException.setLocation(location);
                        throw buildException;
                    }
                } catch (SAXException e14) {
                    e = e14;
                    Exception exception2 = e.getException();
                    if (exception2 instanceof BuildException) {
                        throw ((BuildException) exception2);
                    }
                    String message2 = e.getMessage();
                    if (exception2 != null) {
                        e = exception2;
                    }
                    throw new BuildException(message2, e);
                }
            } catch (FileNotFoundException e15) {
                throw new BuildException(e15);
            }
        } catch (Throwable th2) {
            org.apache.tools.ant.util.d.b(inputStreamOpenStream);
            throw th2;
        }
    }

    public c0 k(Project project, URL url) throws BuildException {
        y yVar = new y();
        yVar.m(project);
        s20.a aVar = new s20.a(project);
        aVar.a(yVar);
        aVar.t(yVar);
        j(aVar.m(), url, new e(aVar, f75940b));
        z[] zVarArrF = yVar.f();
        if (zVarArrF.length == 1) {
            return (c0) zVarArrF[0];
        }
        throw new BuildException("No tasks defined");
    }
}
