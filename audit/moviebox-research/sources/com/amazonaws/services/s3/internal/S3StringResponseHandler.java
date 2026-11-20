package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.util.StringUtils;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class S3StringResponseHandler extends AbstractS3ResponseHandler<String> {
    @Override // com.amazonaws.http.HttpResponseHandler
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public AmazonWebServiceResponse<String> a(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<String> amazonWebServiceResponseC = c(httpResponse);
        byte[] bArr = new byte[1024];
        StringBuilder sb2 = new StringBuilder();
        InputStream inputStreamB = httpResponse.b();
        while (true) {
            int i11 = inputStreamB.read(bArr);
            if (i11 <= 0) {
                amazonWebServiceResponseC.d(sb2.toString());
                return amazonWebServiceResponseC;
            }
            sb2.append(new String(bArr, 0, i11, StringUtils.f16272a));
        }
    }
}
