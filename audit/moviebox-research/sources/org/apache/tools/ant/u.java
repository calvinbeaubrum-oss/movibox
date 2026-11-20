package org.apache.tools.ant;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringTokenizer f72932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f72933b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f72934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f72935d;

    public u(String str) {
        boolean zA = v20.a.a("netware");
        this.f72934c = zA;
        if (zA) {
            this.f72932a = new StringTokenizer(str, ":;", true);
        } else {
            this.f72932a = new StringTokenizer(str, ":;", false);
        }
        this.f72935d = File.pathSeparatorChar == ';';
    }

    public boolean a() {
        if (this.f72933b != null) {
            return true;
        }
        return this.f72932a.hasMoreTokens();
    }

    public String b() throws NoSuchElementException {
        String strTrim = this.f72933b;
        if (strTrim != null) {
            this.f72933b = null;
        } else {
            strTrim = this.f72932a.nextToken().trim();
        }
        if (!this.f72934c) {
            if (strTrim.length() != 1 || !Character.isLetter(strTrim.charAt(0)) || !this.f72935d || !this.f72932a.hasMoreTokens()) {
                return strTrim;
            }
            String strTrim2 = this.f72932a.nextToken().trim();
            if (!strTrim2.startsWith("\\") && !strTrim2.startsWith("/")) {
                this.f72933b = strTrim2;
                return strTrim;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(strTrim);
            stringBuffer.append(":");
            stringBuffer.append(strTrim2);
            return stringBuffer.toString();
        }
        String str = File.pathSeparator;
        if (strTrim.equals(str) || strTrim.equals(":")) {
            strTrim = this.f72932a.nextToken().trim();
        }
        if (!this.f72932a.hasMoreTokens()) {
            return strTrim;
        }
        String strTrim3 = this.f72932a.nextToken().trim();
        if (strTrim3.equals(str)) {
            return strTrim;
        }
        if (!strTrim3.equals(":")) {
            this.f72933b = strTrim3;
            return strTrim;
        }
        if (strTrim.startsWith("/") || strTrim.startsWith("\\") || strTrim.startsWith(InstructionFileId.DOT) || strTrim.startsWith("..")) {
            return strTrim;
        }
        String strTrim4 = this.f72932a.nextToken().trim();
        if (!strTrim4.equals(str)) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(strTrim);
            stringBuffer2.append(":");
            stringBuffer2.append(strTrim4);
            return stringBuffer2.toString();
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(strTrim);
        stringBuffer3.append(":");
        String string = stringBuffer3.toString();
        this.f72933b = strTrim4;
        return string;
    }
}
