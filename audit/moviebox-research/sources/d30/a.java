package d30;

import com.applovin.sdk.AppLovinEventTypes;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.UncheckedIOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;
import org.jsoup.parser.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f62890a = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f62891b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* JADX INFO: renamed from: d30.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0644a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f62892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f62893b;

        public C0644a(String str, boolean z11) {
            this.f62892a = str;
            this.f62893b = z11;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            int i11 = inputStream.read(bArr);
            if (i11 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i11);
            }
        }
    }

    public static C0644a b(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        byte b11 = bArr[0];
        if ((b11 == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (b11 == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            return new C0644a("UTF-32", false);
        }
        if ((b11 == -2 && bArr[1] == -1) || (b11 == -1 && bArr[1] == -2)) {
            return new C0644a(C.UTF16_NAME, false);
        }
        if (b11 == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return new C0644a("UTF-8", true);
        }
        return null;
    }

    public static ByteBuffer c() {
        return ByteBuffer.allocate(0);
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f62890a.matcher(str);
        if (matcher.find()) {
            return h(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    public static String e() {
        StringBuilder sb2 = new StringBuilder(32);
        Random random = new Random();
        for (int i11 = 0; i11 < 32; i11++) {
            char[] cArr = f62891b;
            sb2.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb2.toString();
    }

    public static Document f(InputStream inputStream, String str, String str2, e eVar) throws IOException {
        if (inputStream == null) {
            return new Document(str2);
        }
        e30.a aVarD = e30.a.d(inputStream, 32768, 0);
        aVarD.mark(32768);
        ByteBuffer byteBufferG = g(aVarD, 5119);
        boolean z11 = aVarD.read() == -1;
        aVarD.reset();
        C0644a c0644aB = b(byteBufferG);
        if (c0644aB != null) {
            str = c0644aB.f62892a;
        }
        Document documentE = null;
        if (str == null) {
            Document documentF = eVar.f(Charset.forName("UTF-8").decode(byteBufferG).toString(), str2);
            String strG = null;
            for (Element element : documentF.U0("meta[http-equiv=content-type], meta[charset]")) {
                if (element.z("http-equiv")) {
                    strG = d(element.g(AppLovinEventTypes.USER_VIEWED_CONTENT));
                }
                if (strG == null && element.z("charset")) {
                    strG = element.g("charset");
                }
                if (strG != null) {
                    break;
                }
            }
            if (strG == null && documentF.o() > 0 && (documentF.n(0) instanceof j)) {
                j jVar = (j) documentF.n(0);
                if (jVar.g0().equals("xml")) {
                    strG = jVar.g("encoding");
                }
            }
            String strH = h(strG);
            if (strH != null && !strH.equalsIgnoreCase("UTF-8")) {
                str = strH.trim().replaceAll("[\"']", "");
            } else if (z11) {
                documentE = documentF;
            }
        } else {
            d.i(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
        }
        if (documentE == null) {
            String str3 = str != null ? str : "UTF-8";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(aVarD, str3), 32768);
            if (c0644aB != null && c0644aB.f62893b) {
                bufferedReader.skip(1L);
            }
            try {
                documentE = eVar.e(bufferedReader, str2);
                documentE.j1().b(str3);
            } catch (UncheckedIOException e11) {
                throw e11.ioException();
            }
        }
        aVarD.close();
        return documentE;
    }

    public static ByteBuffer g(InputStream inputStream, int i11) throws IOException {
        d.e(i11 >= 0, "maxSize must be 0 (unlimited) or larger");
        return e30.a.d(inputStream, 32768, i11).b(i11);
    }

    public static String h(String str) {
        if (str != null && str.length() != 0) {
            String strReplaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(strReplaceAll)) {
                    return strReplaceAll;
                }
                String upperCase = strReplaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }
}
