package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.XpathUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class S3ErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Log f15971a = LogFactory.b(S3ErrorResponseHandler.class);

    @Override // com.amazonaws.http.HttpResponseHandler
    public boolean b() {
        return false;
    }

    public final AmazonServiceException.ErrorType c(int i11) {
        return i11 >= 500 ? AmazonServiceException.ErrorType.Service : AmazonServiceException.ErrorType.Client;
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public AmazonServiceException a(HttpResponse httpResponse) throws IOException {
        InputStream inputStreamB = httpResponse.b();
        if (inputStreamB == null) {
            return e(httpResponse.f(), httpResponse);
        }
        try {
            String string = IOUtils.toString(inputStreamB);
            try {
                Document documentD = XpathUtils.d(string);
                String strB = XpathUtils.b("Error/Message", documentD);
                String strB2 = XpathUtils.b("Error/Code", documentD);
                String strB3 = XpathUtils.b("Error/RequestId", documentD);
                String strB4 = XpathUtils.b("Error/HostId", documentD);
                AmazonS3Exception amazonS3Exception = new AmazonS3Exception(strB);
                int iE = httpResponse.e();
                amazonS3Exception.setStatusCode(iE);
                amazonS3Exception.setErrorType(c(iE));
                amazonS3Exception.setErrorCode(strB2);
                amazonS3Exception.setRequestId(strB3);
                amazonS3Exception.setExtendedRequestId(strB4);
                amazonS3Exception.setCloudFrontId(httpResponse.c().get("X-Amz-Cf-Id"));
                return amazonS3Exception;
            } catch (Exception e11) {
                Log log = f15971a;
                if (log.b()) {
                    log.g("Failed in parsing the response as XML: " + string, e11);
                }
                return e(string, httpResponse);
            }
        } catch (IOException e12) {
            if (f15971a.b()) {
                f15971a.g("Failed in reading the error response", e12);
            }
            return e(httpResponse.f(), httpResponse);
        }
    }

    public final AmazonS3Exception e(String str, HttpResponse httpResponse) {
        AmazonS3Exception amazonS3Exception = new AmazonS3Exception(str);
        int iE = httpResponse.e();
        amazonS3Exception.setErrorCode(iE + " " + httpResponse.f());
        amazonS3Exception.setStatusCode(iE);
        amazonS3Exception.setErrorType(c(iE));
        Map<String, String> mapC = httpResponse.c();
        amazonS3Exception.setRequestId(mapC.get("x-amz-request-id"));
        amazonS3Exception.setExtendedRequestId(mapC.get("x-amz-id-2"));
        amazonS3Exception.setCloudFrontId(mapC.get("X-Amz-Cf-Id"));
        HashMap map = new HashMap();
        map.put("x-amz-bucket-region", mapC.get("x-amz-bucket-region"));
        amazonS3Exception.setAdditionalDetails(map);
        return amazonS3Exception;
    }
}
