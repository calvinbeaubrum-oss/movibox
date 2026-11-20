package com.amazonaws.services.s3.internal;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AbstractAWSSigner;
import com.amazonaws.auth.SigningAlgorithm;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.HttpUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class S3Signer extends AbstractAWSSigner {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Log f15974f = LogFactory.b(S3Signer.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f15977e;

    public S3Signer() {
        this.f15975c = null;
        this.f15976d = null;
        this.f15977e = null;
    }

    public S3Signer(String str, String str2) {
        this(str, str2, null);
    }

    public S3Signer(String str, String str2, Collection<String> collection) {
        if (str2 == null) {
            throw new IllegalArgumentException("Parameter resourcePath is empty");
        }
        this.f15975c = str;
        this.f15976d = str2;
        this.f15977e = collection == null ? null : Collections.unmodifiableSet(new HashSet(collection));
    }

    @Override // com.amazonaws.auth.Signer
    public void b(Request<?> request, AWSCredentials aWSCredentials) {
        w(request, aWSCredentials, null);
    }

    public void v(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.i("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    public void w(Request<?> request, AWSCredentials aWSCredentials, Date date) {
        if (this.f15976d == null) {
            throw new UnsupportedOperationException("Cannot sign a request using a dummy S3Signer instance with no resource path");
        }
        if (aWSCredentials == null || aWSCredentials.b() == null) {
            f15974f.a("Canonical string will not be signed, as no AWS Secret Key was provided");
            return;
        }
        AWSCredentials aWSCredentialsQ = q(aWSCredentials);
        if (aWSCredentialsQ instanceof AWSSessionCredentials) {
            v(request, (AWSSessionCredentials) aWSCredentialsQ);
        }
        String strB = HttpUtils.b(request.s().getPath(), this.f15976d, true);
        Date dateL = l(m(request));
        if (date == null) {
            date = dateL;
        }
        request.i(HttpHeaders.DATE, ServiceUtils.a(date));
        String strA = RestUtils.a(this.f15975c, strB, request, null, this.f15977e);
        f15974f.a("Calculated string to sign:\n\"" + strA + "\"");
        request.i(HttpHeaders.AUTHORIZATION, "AWS " + aWSCredentialsQ.a() + ":" + super.t(strA, aWSCredentialsQ.b(), SigningAlgorithm.HmacSHA1));
    }
}
