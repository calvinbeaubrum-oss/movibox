package ko;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f68675a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f68676b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static List<String> a(X509Certificate x509Certificate) {
        List<String> listB = b(x509Certificate, 7);
        List<String> listB2 = b(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listB.size() + listB2.size());
        arrayList.addAll(listB);
        arrayList.addAll(listB2);
        return arrayList;
    }

    public static List<String> b(X509Certificate x509Certificate, int i11) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i11 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    public static boolean d(String str) {
        return f68676b.matcher(str).matches();
    }

    public boolean c(String str, X509Certificate x509Certificate) {
        return d(str) ? g(str, x509Certificate) : f(str, x509Certificate);
    }

    public final boolean e(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(InstructionFileId.DOT) && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(InstructionFileId.DOT) && !str2.endsWith("..")) {
            if (!str.endsWith(InstructionFileId.DOT)) {
                str = str + '.';
            }
            if (!str2.endsWith(InstructionFileId.DOT)) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    public final boolean f(String str, X509Certificate x509Certificate) {
        String strB;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listB = b(x509Certificate, 2);
        int size = listB.size();
        int i11 = 0;
        boolean z11 = false;
        while (i11 < size) {
            if (e(lowerCase, listB.get(i11))) {
                return true;
            }
            i11++;
            z11 = true;
        }
        if (z11 || (strB = new a(x509Certificate.getSubjectX500Principal()).b("cn")) == null) {
            return false;
        }
        return e(lowerCase, strB);
    }

    public final boolean g(String str, X509Certificate x509Certificate) {
        List<String> listB = b(x509Certificate, 7);
        int size = listB.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (str.equalsIgnoreCase(listB.get(i11))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return c(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
