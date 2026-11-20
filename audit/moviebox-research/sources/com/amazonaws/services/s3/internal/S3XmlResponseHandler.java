package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class S3XmlResponseHandler<T> extends AbstractS3ResponseHandler<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Log f15978e = LogFactory.c("com.amazonaws.request");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Unmarshaller<T, InputStream> f15979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f15980d;

    public S3XmlResponseHandler(Unmarshaller<T, InputStream> unmarshaller) {
        this.f15979c = unmarshaller;
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public AmazonWebServiceResponse<T> a(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<T> amazonWebServiceResponseC = c(httpResponse);
        this.f15980d = httpResponse.c();
        if (this.f15979c != null) {
            Log log = f15978e;
            log.k("Beginning to parse service response XML");
            T tA = this.f15979c.a(httpResponse.b());
            log.k("Done parsing service response XML");
            amazonWebServiceResponseC.d(tA);
        }
        return amazonWebServiceResponseC;
    }
}
