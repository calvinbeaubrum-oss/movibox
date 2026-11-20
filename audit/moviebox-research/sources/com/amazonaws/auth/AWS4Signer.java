package com.amazonaws.auth;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AWS4Signer extends AbstractAWSSigner implements ServiceAwareSigner, RegionAwareSigner {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Log f15656g = LogFactory.b(AWS4Signer.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f15658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Date f15659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15660f;

    /* JADX INFO: compiled from: source.java */
    public static class HeaderSigningResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f15663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f15664d;

        public HeaderSigningResult(String str, String str2, byte[] bArr, byte[] bArr2) {
            this.f15661a = str;
            this.f15662b = str2;
            this.f15663c = bArr;
            this.f15664d = bArr2;
        }

        public String a() {
            return this.f15661a;
        }

        public byte[] b() {
            byte[] bArr = this.f15663c;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        public String c() {
            return this.f15662b;
        }

        public byte[] d() {
            byte[] bArr = this.f15664d;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
    }

    public AWS4Signer() {
        this(true);
    }

    public AWS4Signer(boolean z11) {
        this.f15660f = z11;
    }

    public String A(URI uri) {
        String str = this.f15657c;
        return str != null ? str : AwsHostNameUtils.c(uri);
    }

    public String B(Request<?> request, String str) {
        String str2 = request.n().toString() + "\n" + j(HttpUtils.a(request.s().getPath(), request.q()), this.f15660f) + "\n" + h(request) + "\n" + C(request) + "\n" + G(request) + "\n" + str;
        f15656g.a("AWS4 Canonical Request: '\"" + str2 + "\"");
        return str2;
    }

    public String C(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb2 = new StringBuilder();
        for (String str : arrayList) {
            if (J(str)) {
                String strReplaceAll = StringUtils.b(str).replaceAll("\\s+", " ");
                String str2 = request.getHeaders().get(str);
                sb2.append(strReplaceAll);
                sb2.append(":");
                if (str2 != null) {
                    sb2.append(str2.replaceAll("\\s+", " "));
                }
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    public final long D(Request<?> request) {
        Date dateL = l(m(request));
        Date date = this.f15659e;
        if (date != null) {
            dateL = date;
        }
        return dateL.getTime();
    }

    public final String E(long j11) {
        return DateUtils.c("yyyyMMdd", new Date(j11));
    }

    public String F(Request<?> request, String str) {
        return str + "/" + z(request.s()) + "/" + A(request.s()) + "/aws4_request";
    }

    public String G(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb2 = new StringBuilder();
        for (String str : arrayList) {
            if (J(str)) {
                if (sb2.length() > 0) {
                    sb2.append(";");
                }
                sb2.append(StringUtils.b(str));
            }
        }
        return sb2.toString();
    }

    public String H(String str, String str2, String str3, String str4) {
        String str5 = str + "\n" + str2 + "\n" + str3 + "\n" + BinaryUtils.d(o(str4));
        f15656g.a("AWS4 String to Sign: '\"" + str5 + "\"");
        return str5;
    }

    public final String I(long j11) {
        return DateUtils.c("yyyyMMdd'T'HHmmss'Z'", new Date(j11));
    }

    public boolean J(String str) {
        return "date".equalsIgnoreCase(str) || HttpHeaders.CONTENT_MD5.equalsIgnoreCase(str) || "host".equalsIgnoreCase(str) || str.startsWith("x-amz") || str.startsWith("X-Amz");
    }

    public void K(Request<?> request, HeaderSigningResult headerSigningResult) {
    }

    @Override // com.amazonaws.auth.ServiceAwareSigner
    public void a(String str) {
        this.f15657c = str;
    }

    @Override // com.amazonaws.auth.Signer
    public void b(Request<?> request, AWSCredentials aWSCredentials) {
        AWSCredentials aWSCredentialsQ = q(aWSCredentials);
        if (aWSCredentialsQ instanceof AWSSessionCredentials) {
            w(request, (AWSSessionCredentials) aWSCredentialsQ);
        }
        v(request);
        long jD = D(request);
        String strE = E(jD);
        String strF = F(request, strE);
        String strX = x(request);
        String strI = I(jD);
        request.i("X-Amz-Date", strI);
        if (request.getHeaders().get("x-amz-content-sha256") != null && "required".equals(request.getHeaders().get("x-amz-content-sha256"))) {
            request.i("x-amz-content-sha256", strX);
        }
        String str = aWSCredentialsQ.a() + "/" + strF;
        HeaderSigningResult headerSigningResultY = y(request, strE, strI, "AWS4-HMAC-SHA256", strX, aWSCredentialsQ);
        request.i(HttpHeaders.AUTHORIZATION, "AWS4-HMAC-SHA256 " + ("Credential=" + str) + ", " + ("SignedHeaders=" + G(request)) + ", " + ("Signature=" + BinaryUtils.d(headerSigningResultY.d())));
        K(request, headerSigningResultY);
    }

    @Override // com.amazonaws.auth.RegionAwareSigner
    public void c(String str) {
        this.f15658d = str;
    }

    public void v(Request<?> request) {
        String host = request.s().getHost();
        if (HttpUtils.d(request.s())) {
            host = host + ":" + request.s().getPort();
        }
        request.i(HttpHeaders.HOST, host);
    }

    public void w(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.i("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    public String x(Request<?> request) {
        InputStream inputStreamE = e(request);
        inputStreamE.mark(-1);
        String strD = BinaryUtils.d(n(inputStreamE));
        try {
            inputStreamE.reset();
            return strD;
        } catch (IOException e11) {
            throw new AmazonClientException("Unable to reset stream after calculating AWS4 signature", e11);
        }
    }

    public final HeaderSigningResult y(Request<?> request, String str, String str2, String str3, String str4, AWSCredentials aWSCredentials) {
        String strZ = z(request.s());
        String strA = A(request.s());
        String str5 = str + "/" + strZ + "/" + strA + "/aws4_request";
        String strH = H(str3, str2, str5, B(request, str4));
        String str6 = "AWS4" + aWSCredentials.b();
        Charset charset = StringUtils.f16272a;
        byte[] bytes = str6.getBytes(charset);
        SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
        byte[] bArrR = r("aws4_request", r(strA, r(strZ, r(str, bytes, signingAlgorithm), signingAlgorithm), signingAlgorithm), signingAlgorithm);
        return new HeaderSigningResult(str2, str5, bArrR, s(strH.getBytes(charset), bArrR, signingAlgorithm));
    }

    public String z(URI uri) {
        String str = this.f15658d;
        return str != null ? str : AwsHostNameUtils.a(uri.getHost(), this.f15657c);
    }
}
