package com.mbridge.msdk.foundation.same.net.stack;

import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.chromium.net.CronetEngine;
import org.chromium.net.UploadDataProviders;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BlockingQueue<com.mbridge.msdk.foundation.same.net.a.b> f44711a = new ArrayBlockingQueue(2, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CronetEngine f44712b;

    public a() {
        ad.b("CronetStack", "Cronet stack init.");
        this.f44712b = com.mbridge.msdk.foundation.same.net.a.a.a().c();
    }

    private String a(i<?> iVar) {
        switch (iVar.l()) {
            case 0:
                return "GET";
            case 1:
                return "POST";
            case 2:
                return "PUT";
            case 3:
                return "DELETE";
            case 4:
                return "HEAD";
            case 5:
                return "OPTIONS";
            case 6:
                return "TRACE";
            case 7:
                return "PATCH";
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private void a(UrlRequest urlRequest, i<?> iVar) {
        if (urlRequest != null) {
            urlRequest.cancel();
        }
        if (iVar != null) {
            iVar.a();
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.stack.b
    public final com.mbridge.msdk.foundation.same.net.f.b performRequest(i<?> iVar) throws IOException {
        int i11;
        ad.b("CronetStack", "CronetStack request start : " + iVar.s() + " " + a(iVar));
        int iP = iVar.p();
        int iM = iVar.m();
        if (iP == 0) {
            iP = ComConstants.AD_TIMEOUT_MILLIS;
        }
        if (iM == 0) {
            iM = ComConstants.AD_TIMEOUT_MILLIS;
        }
        ad.b("CronetStack", "Cronet writeTimeout : " + iP + " readTimeout : " + iM);
        UrlRequest.Builder builderNewUrlRequestBuilder = this.f44712b.newUrlRequestBuilder(iVar.s(), new com.mbridge.msdk.foundation.same.net.a.c(this.f44711a), com.mbridge.msdk.foundation.same.net.a.a.a().b());
        int iB = iVar.b();
        if (iB != 1) {
            i11 = 4;
            if (iB != 3 && iB != 4) {
                i11 = 3;
            }
        } else {
            i11 = 2;
        }
        UrlRequest.Builder builderAllowDirectExecutor = builderNewUrlRequestBuilder.setPriority(i11).setHttpMethod(a(iVar)).allowDirectExecutor();
        if (iVar.k() != null) {
            for (Map.Entry<String, String> entry : iVar.k().entrySet()) {
                builderAllowDirectExecutor.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (iVar.h() != null) {
            builderAllowDirectExecutor.setUploadDataProvider(UploadDataProviders.create(iVar.h()), com.mbridge.msdk.foundation.same.net.a.a.a().b());
        }
        UrlRequest urlRequestBuild = builderAllowDirectExecutor.build();
        urlRequestBuild.start();
        com.mbridge.msdk.foundation.same.net.f.b bVarB = null;
        try {
            BlockingQueue<com.mbridge.msdk.foundation.same.net.a.b> blockingQueue = this.f44711a;
            long j11 = iP;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            com.mbridge.msdk.foundation.same.net.a.b bVarPoll = blockingQueue.poll(j11, timeUnit);
            if (bVarPoll == null) {
                a(urlRequestBuild, iVar);
                this.f44711a.clear();
                ad.b("CronetStack", "Request cancel because request timeout");
                throw new IOException("request timeout.");
            }
            if (bVarPoll.c() == 0) {
                bVarPoll = this.f44711a.poll(iM, timeUnit);
            }
            bVarB = bVarPoll.c() == 1 ? bVarPoll.b() : null;
            if (bVarPoll.c() == 2) {
                throw new IOException(bVarPoll.a());
            }
            if (bVarB == null) {
                a(urlRequestBuild, iVar);
                this.f44711a.clear();
                ad.b("CronetStack", "response cancel because response timeout");
                throw new IOException("Response timeout.");
            }
            ad.b("CronetStack", "HttpResponse : " + bVarB.c() + " content : " + bVarB.a().toString());
            return bVarB;
        } catch (InterruptedException e11) {
            e11.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
