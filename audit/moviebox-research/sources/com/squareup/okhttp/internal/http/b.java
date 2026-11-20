package com.squareup.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.hisavana.common.constant.ComConstants;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Request f49226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Response f49227b;

    /* JADX INFO: renamed from: com.squareup.okhttp.internal.http.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0536b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f49228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Request f49229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Response f49230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Date f49231d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f49232e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Date f49233f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f49234g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Date f49235h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f49236i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f49237j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f49238k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f49239l;

        public C0536b(long j11, Request request, Response response) {
            this.f49239l = -1;
            this.f49228a = j11;
            this.f49229b = request;
            this.f49230c = response;
            if (response != null) {
                Headers headers = response.headers();
                int size = headers.size();
                for (int i11 = 0; i11 < size; i11++) {
                    String strName = headers.name(i11);
                    String strValue = headers.value(i11);
                    if (HttpHeaders.DATE.equalsIgnoreCase(strName)) {
                        this.f49231d = f.b(strValue);
                        this.f49232e = strValue;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(strName)) {
                        this.f49235h = f.b(strValue);
                    } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(strName)) {
                        this.f49233f = f.b(strValue);
                        this.f49234g = strValue;
                    } else if ("ETag".equalsIgnoreCase(strName)) {
                        this.f49238k = strValue;
                    } else if ("Age".equalsIgnoreCase(strName)) {
                        this.f49239l = c.a(strValue, -1);
                    } else if (OkHeaders.f49221c.equalsIgnoreCase(strName)) {
                        this.f49236i = Long.parseLong(strValue);
                    } else if (OkHeaders.f49222d.equalsIgnoreCase(strName)) {
                        this.f49237j = Long.parseLong(strValue);
                    }
                }
            }
        }

        public static boolean e(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        public final long a() {
            Date date = this.f49231d;
            long jMax = date != null ? Math.max(0L, this.f49237j - date.getTime()) : 0L;
            int i11 = this.f49239l;
            if (i11 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i11));
            }
            long j11 = this.f49237j;
            return jMax + (j11 - this.f49236i) + (this.f49228a - j11);
        }

        public final long b() {
            CacheControl cacheControl = this.f49230c.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
            }
            if (this.f49235h != null) {
                Date date = this.f49231d;
                long time = this.f49235h.getTime() - (date != null ? date.getTime() : this.f49237j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f49233f == null || this.f49230c.request().httpUrl().query() != null) {
                return 0L;
            }
            Date date2 = this.f49231d;
            long time2 = (date2 != null ? date2.getTime() : this.f49236i) - this.f49233f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b c() {
            b bVarD = d();
            return (bVarD.f49226a == null || !this.f49229b.cacheControl().onlyIfCached()) ? bVarD : new b(null, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b d() {
            Response response = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            if (this.f49230c == null) {
                return new b(this.f49229b, response);
            }
            if (this.f49229b.isHttps() && this.f49230c.handshake() == null) {
                return new b(this.f49229b, objArr11 == true ? 1 : 0);
            }
            if (!b.a(this.f49230c, this.f49229b)) {
                return new b(this.f49229b, objArr9 == true ? 1 : 0);
            }
            CacheControl cacheControl = this.f49229b.cacheControl();
            if (cacheControl.noCache() || e(this.f49229b)) {
                return new b(this.f49229b, objArr2 == true ? 1 : 0);
            }
            long jA = a();
            long jB = b();
            if (cacheControl.maxAgeSeconds() != -1) {
                jB = Math.min(jB, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
            CacheControl cacheControl2 = this.f49230c.cacheControl();
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j11 = millis2 + jA;
                if (j11 < millis + jB) {
                    Response.Builder builderNewBuilder = this.f49230c.newBuilder();
                    if (j11 >= jB) {
                        builderNewBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED && f()) {
                        builderNewBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new b(objArr7 == true ? 1 : 0, builderNewBuilder.build());
                }
            }
            Request.Builder builderNewBuilder2 = this.f49229b.newBuilder();
            String str = this.f49238k;
            if (str != null) {
                builderNewBuilder2.header("If-None-Match", str);
            } else if (this.f49233f != null) {
                builderNewBuilder2.header("If-Modified-Since", this.f49234g);
            } else if (this.f49231d != null) {
                builderNewBuilder2.header("If-Modified-Since", this.f49232e);
            }
            Request requestBuild = builderNewBuilder2.build();
            return e(requestBuild) ? new b(requestBuild, this.f49230c) : new b(requestBuild, objArr4 == true ? 1 : 0);
        }

        public final boolean f() {
            return this.f49230c.cacheControl().maxAgeSeconds() == -1 && this.f49235h == null;
        }
    }

    public b(Request request, Response response) {
        this.f49226a = request;
        this.f49227b = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.cacheControl().isPrivate() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Response response, Request request) {
        int iCode = response.code();
        if (iCode != 200 && iCode != 410 && iCode != 414 && iCode != 501 && iCode != 203 && iCode != 204) {
            if (iCode != 307) {
                if (iCode != 308 && iCode != 404 && iCode != 405) {
                    switch (iCode) {
                        case NOTICE_VALUE:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (response.header(HttpHeaders.EXPIRES) == null) {
                if (response.cacheControl().maxAgeSeconds() == -1) {
                    if (!response.cacheControl().isPublic()) {
                    }
                }
            }
        }
        return (response.cacheControl().noStore() || request.cacheControl().noStore()) ? false : true;
    }
}
