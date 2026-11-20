package s10;

import com.applovin.sdk.AppLovinEventTypes;
import h30.h;
import ir.ac.iust.htmlchardet.Charsets;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    public static Document a(byte[] bArr, String str) {
        return c30.a.b(new String(bArr, Charset.forName(str)));
    }

    public static String b(byte[] bArr, boolean... zArr) {
        Document documentA;
        byte[] bytes = null;
        if (zArr == null || zArr.length <= 0 || !zArr[0]) {
            documentA = null;
        } else {
            documentA = a(bArr, "ISO-8859-1");
            String strD = d(documentA);
            if (Charsets.isValid(strD)) {
                return Charsets.normalize(strD);
            }
        }
        String strE = e(bArr);
        if (strE.equalsIgnoreCase("UTF-8")) {
            return Charsets.normalize(strE);
        }
        if (documentA == null) {
            documentA = a(bArr, "ISO-8859-1");
        }
        try {
            bytes = documentA.Z0().getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
        }
        if (bytes != null && bytes.length >= 40) {
            bArr = bytes;
        }
        return Charsets.normalize(c(bArr));
    }

    public static String c(byte[] bArr) {
        t10.a aVar = new t10.a();
        aVar.d(bArr);
        return aVar.b().b();
    }

    public static String d(Document document) {
        for (Element element : document.U0("meta")) {
            String strG = element.g("charset");
            if (Charsets.isValid(strG)) {
                return strG;
            }
            String strG2 = element.g(AppLovinEventTypes.USER_VIEWED_CONTENT);
            if (strG2.contains("charset")) {
                String strTrim = strG2.substring(strG2.indexOf("charset=") + 8, strG2.length()).trim();
                if (Charsets.isValid(strTrim)) {
                    return strTrim;
                }
            }
        }
        return null;
    }

    public static String e(byte[] bArr) {
        h hVar = new h(0);
        hVar.i(bArr, bArr.length, false);
        hVar.a();
        return hVar.g()[0];
    }
}
