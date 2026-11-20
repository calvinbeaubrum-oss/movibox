package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ResponseHeaderHandlerChain<T> extends S3XmlResponseHandler<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<HeaderHandler<T>> f15969f;

    public ResponseHeaderHandlerChain(Unmarshaller<T, InputStream> unmarshaller, HeaderHandler<T>... headerHandlerArr) {
        super(unmarshaller);
        this.f15969f = Arrays.asList(headerHandlerArr);
    }

    @Override // com.amazonaws.services.s3.internal.S3XmlResponseHandler, com.amazonaws.http.HttpResponseHandler
    /* JADX INFO: renamed from: e */
    public AmazonWebServiceResponse<T> a(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<T> amazonWebServiceResponseA = super.a(httpResponse);
        T tB = amazonWebServiceResponseA.b();
        if (tB != null) {
            Iterator<HeaderHandler<T>> it = this.f15969f.iterator();
            while (it.hasNext()) {
                it.next().a(tB, httpResponse);
            }
        }
        return amazonWebServiceResponseA;
    }
}
