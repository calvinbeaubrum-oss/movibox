package org.apache.tools.ant.util;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import org.apache.tools.ant.BuildException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f72948d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Random f72949e = new Random(System.currentTimeMillis() + Runtime.getRuntime().freeMemory());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f72950f = v20.a.a("netware");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f72951g = v20.a.a("dos");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f72952h = v20.a.a("win9x");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f72953i = v20.a.a("windows");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static /* synthetic */ Class f72954j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f72955a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f72956b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f72957c = null;

    public static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static void b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void c(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void e(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void g(File file) {
        if (file != null) {
            file.delete();
        }
    }

    public static d k() {
        return f72948d;
    }

    public static boolean l(String str) {
        int iIndexOf;
        int length = str.length();
        if (length == 0) {
            return false;
        }
        char c11 = File.separatorChar;
        String strReplace = str.replace('/', c11).replace('\\', c11);
        char cCharAt = strReplace.charAt(0);
        boolean z11 = f72951g;
        if (!z11 && !f72950f) {
            return cCharAt == c11;
        }
        if (cCharAt == c11) {
            return z11 && length > 4 && strReplace.charAt(1) == c11 && (iIndexOf = strReplace.indexOf(c11, 2)) > 2 && iIndexOf + 1 < length;
        }
        int iIndexOf2 = strReplace.indexOf(58);
        return (Character.isLetter(cCharAt) && iIndexOf2 == 1 && strReplace.length() > 2 && strReplace.charAt(2) == c11) || (f72950f && iIndexOf2 > 0);
    }

    public static boolean m(String str) {
        if ((!f72951g && !f72950f) || str.length() == 0) {
            return false;
        }
        char c11 = File.separatorChar;
        String strReplace = str.replace('/', c11).replace('\\', c11);
        char cCharAt = strReplace.charAt(0);
        int length = strReplace.length();
        if (cCharAt != c11 || (length != 1 && strReplace.charAt(1) == c11)) {
            if (!Character.isLetter(cCharAt) || length <= 1 || strReplace.indexOf(58) != 1) {
                return false;
            }
            if (length != 2 && strReplace.charAt(2) == c11) {
                return false;
            }
        }
        return true;
    }

    public File f(String str, String str2, File file, boolean z11, boolean z12) {
        File fileCreateTempFile;
        File file2;
        String property = file == null ? System.getProperty("java.io.tmpdir") : file.getPath();
        if (z12) {
            try {
                fileCreateTempFile = File.createTempFile(str, str2, new File(property));
            } catch (IOException e11) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not create tempfile in ");
                stringBuffer.append(property);
                throw new BuildException(stringBuffer.toString(), e11);
            }
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("#####");
            synchronized (f72949e) {
                do {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str);
                    stringBuffer2.append(decimalFormat.format(Math.abs(f72949e.nextInt())));
                    stringBuffer2.append(str2);
                    file2 = new File(property, stringBuffer2.toString());
                } while (file2.exists());
            }
            fileCreateTempFile = file2;
        }
        if (z11) {
            fileCreateTempFile.deleteOnExit();
        }
        return fileCreateTempFile;
    }

    public String[] h(String str) {
        String strSubstring;
        String strSubstring2;
        char c11 = File.separatorChar;
        String strReplace = str.replace('/', c11).replace('\\', c11);
        if (!l(strReplace)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(strReplace);
            stringBuffer.append(" is not an absolute path");
            throw new BuildException(stringBuffer.toString());
        }
        int iIndexOf = strReplace.indexOf(58);
        if (iIndexOf > 0 && (f72951g || f72950f)) {
            int i11 = iIndexOf + 1;
            String strSubstring3 = strReplace.substring(0, i11);
            char[] charArray = strReplace.toCharArray();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(strSubstring3);
            stringBuffer2.append(c11);
            strSubstring = stringBuffer2.toString();
            if (charArray[i11] == c11) {
                i11 = iIndexOf + 2;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            while (i11 < charArray.length) {
                char c12 = charArray[i11];
                if (c12 != c11 || charArray[i11 - 1] != c11) {
                    stringBuffer3.append(c12);
                }
                i11++;
            }
            strSubstring2 = stringBuffer3.toString();
        } else if (strReplace.length() <= 1 || strReplace.charAt(1) != c11) {
            strSubstring = File.separator;
            strSubstring2 = strReplace.substring(1);
        } else {
            int iIndexOf2 = strReplace.indexOf(c11, strReplace.indexOf(c11, 2) + 1);
            strSubstring = iIndexOf2 > 2 ? strReplace.substring(0, iIndexOf2 + 1) : strReplace;
            strSubstring2 = strReplace.substring(strSubstring.length());
        }
        return new String[]{strSubstring, strSubstring2};
    }

    public String i(String str) {
        synchronized (this.f72955a) {
            try {
                if (str.equals(this.f72956b)) {
                    return this.f72957c;
                }
                String strC = u20.b.c(str);
                if (l(strC)) {
                    strC = o(strC).getAbsolutePath();
                }
                this.f72956b = str;
                this.f72957c = strC;
                return strC;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public URL j(File file) throws MalformedURLException {
        return new URL(r(file.getAbsolutePath()));
    }

    public boolean n(File file, File file2) {
        String absolutePath = o(file.getAbsolutePath()).getAbsolutePath();
        String absolutePath2 = o(file2.getAbsolutePath()).getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return true;
        }
        String str = File.separator;
        if (!absolutePath.endsWith(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(absolutePath);
            stringBuffer.append(str);
            absolutePath = stringBuffer.toString();
        }
        return absolutePath2.startsWith(absolutePath);
    }

    public File o(String str) {
        Stack stack = new Stack();
        String[] strArrH = h(str);
        stack.push(strArrH[0]);
        StringTokenizer stringTokenizer = new StringTokenizer(strArrH[1], File.separator);
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (!InstructionFileId.DOT.equals(strNextToken)) {
                if (!"..".equals(strNextToken)) {
                    stack.push(strNextToken);
                } else {
                    if (stack.size() < 2) {
                        return new File(str);
                    }
                    stack.pop();
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < stack.size(); i11++) {
            if (i11 > 1) {
                stringBuffer.append(File.separatorChar);
            }
            stringBuffer.append(stack.elementAt(i11));
        }
        return new File(stringBuffer.toString());
    }

    public String p(File file, File file2) {
        String absolutePath = o(file.getAbsolutePath()).getAbsolutePath();
        String absolutePath2 = o(file2.getAbsolutePath()).getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return "";
        }
        String str = File.separator;
        if (!absolutePath.endsWith(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(absolutePath);
            stringBuffer.append(str);
            absolutePath = stringBuffer.toString();
        }
        return absolutePath2.startsWith(absolutePath) ? absolutePath2.substring(absolutePath.length()) : absolutePath2;
    }

    public File q(File file, String str) {
        if (!l(str)) {
            char c11 = File.separatorChar;
            String strReplace = str.replace('/', c11).replace('\\', c11);
            if (m(strReplace)) {
                String property = System.getProperty("user.dir");
                if (strReplace.charAt(0) == c11 && property.charAt(0) == c11) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(h(property)[0]);
                    stringBuffer.append(strReplace.substring(1));
                    strReplace = stringBuffer.toString();
                }
                file = null;
            }
            str = new File(file, strReplace).getAbsolutePath();
        }
        return o(str);
    }

    public String r(String str) {
        Class<?> cls;
        try {
            cls = Class.forName("java.net.URI");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                File absoluteFile = new File(str).getAbsoluteFile();
                Class clsA = f72954j;
                if (clsA == null) {
                    clsA = a("java.io.File");
                    f72954j = clsA;
                }
                return (String) cls.getMethod("toASCIIString", new Class[0]).invoke(clsA.getMethod("toURI", new Class[0]).invoke(absoluteFile, new Object[0]), new Object[0]);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        boolean zIsDirectory = new File(str).isDirectory();
        StringBuffer stringBuffer = new StringBuffer("file:");
        String path = q(null, str).getPath();
        stringBuffer.append("//");
        if (!path.startsWith(File.separator)) {
            stringBuffer.append("/");
        }
        String strReplace = path.replace('\\', '/');
        try {
            stringBuffer.append(u20.b.b(strReplace));
            if (zIsDirectory && !strReplace.endsWith("/")) {
                stringBuffer.append('/');
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e12) {
            throw new BuildException(e12);
        }
    }
}
