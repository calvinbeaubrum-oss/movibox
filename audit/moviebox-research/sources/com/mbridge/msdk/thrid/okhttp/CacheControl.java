package com.mbridge.msdk.thrid.okhttp;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class CacheControl {
    String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Api.BaseClientBuilder.API_PRIORITY_OTHER, TimeUnit.SECONDS).build();

    /* JADX INFO: compiled from: source.java */
    public static final class Builder {
        boolean immutable;
        int maxAgeSeconds = -1;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public CacheControl build() {
            return new CacheControl(this);
        }

        public Builder immutable() {
            this.immutable = true;
            return this;
        }

        public Builder maxAge(int i11, TimeUnit timeUnit) {
            if (i11 >= 0) {
                long seconds = timeUnit.toSeconds(i11);
                this.maxAgeSeconds = seconds > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i11);
        }

        public Builder maxStale(int i11, TimeUnit timeUnit) {
            if (i11 >= 0) {
                long seconds = timeUnit.toSeconds(i11);
                this.maxStaleSeconds = seconds > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i11);
        }

        public Builder minFresh(int i11, TimeUnit timeUnit) {
            if (i11 >= 0) {
                long seconds = timeUnit.toSeconds(i11);
                this.minFreshSeconds = seconds > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i11);
        }

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    public CacheControl(Builder builder) {
        this.noCache = builder.noCache;
        this.noStore = builder.noStore;
        this.maxAgeSeconds = builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = builder.maxStaleSeconds;
        this.minFreshSeconds = builder.minFreshSeconds;
        this.onlyIfCached = builder.onlyIfCached;
        this.noTransform = builder.noTransform;
        this.immutable = builder.immutable;
    }

    private CacheControl(boolean z11, boolean z12, int i11, int i12, boolean z13, boolean z14, boolean z15, int i13, int i14, boolean z16, boolean z17, boolean z18, String str) {
        this.noCache = z11;
        this.noStore = z12;
        this.maxAgeSeconds = i11;
        this.sMaxAgeSeconds = i12;
        this.isPrivate = z13;
        this.isPublic = z14;
        this.mustRevalidate = z15;
        this.maxStaleSeconds = i13;
        this.minFreshSeconds = i14;
        this.onlyIfCached = z16;
        this.noTransform = z17;
        this.immutable = z18;
        this.headerValue = str;
    }

    private String headerValue() {
        StringBuilder sb2 = new StringBuilder();
        if (this.noCache) {
            sb2.append("no-cache, ");
        }
        if (this.noStore) {
            sb2.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb2.append("max-age=");
            sb2.append(this.maxAgeSeconds);
            sb2.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.sMaxAgeSeconds);
            sb2.append(", ");
        }
        if (this.isPrivate) {
            sb2.append("private, ");
        }
        if (this.isPublic) {
            sb2.append("public, ");
        }
        if (this.mustRevalidate) {
            sb2.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb2.append("max-stale=");
            sb2.append(this.maxStaleSeconds);
            sb2.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.minFreshSeconds);
            sb2.append(", ");
        }
        if (this.onlyIfCached) {
            sb2.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb2.append("no-transform, ");
        }
        if (this.immutable) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    /* JADX WARN: Code duplicated, block: B:21:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:32:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00be  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00de  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:53:0x010a  */
    /* JADX WARN: Code duplicated, block: B:55:0x0112  */
    /* JADX WARN: Code duplicated, block: B:56:0x011a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0123  */
    /* JADX WARN: Code duplicated, block: B:59:0x0126  */
    /* JADX WARN: Code duplicated, block: B:61:0x012e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0131  */
    /* JADX WARN: Code duplicated, block: B:64:0x0139  */
    /* JADX WARN: Code duplicated, block: B:87:0x013b A[SYNTHETIC] */
    public static CacheControl parse(Headers headers) {
        int i11;
        int iSkipUntil;
        String strTrim;
        int iSkipUntil2;
        String strTrim2;
        int size = headers.size();
        boolean z11 = true;
        String str = null;
        boolean z12 = false;
        boolean z13 = false;
        int seconds = -1;
        int seconds2 = -1;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        int seconds3 = -1;
        int seconds4 = -1;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        for (int i12 = 0; i12 < size; i12++) {
            String strName = headers.name(i12);
            String strValue = headers.value(i12);
            if (strName.equalsIgnoreCase(HttpHeaders.CACHE_CONTROL)) {
                if (str == null) {
                    str = strValue;
                }
                for (i11 = 0; i11 < strValue.length(); i11 = iSkipUntil2) {
                    iSkipUntil = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.skipUntil(strValue, i11, "=,;");
                    strTrim = strValue.substring(i11, iSkipUntil).trim();
                    if (iSkipUntil != strValue.length() || strValue.charAt(iSkipUntil) == ',' || strValue.charAt(iSkipUntil) == ';') {
                        iSkipUntil2 = iSkipUntil + 1;
                        strTrim2 = null;
                    } else {
                        int iSkipWhitespace = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.skipWhitespace(strValue, iSkipUntil + 1);
                        if (iSkipWhitespace >= strValue.length() || strValue.charAt(iSkipWhitespace) != '\"') {
                            iSkipUntil2 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.skipUntil(strValue, iSkipWhitespace, ",;");
                            strTrim2 = strValue.substring(iSkipWhitespace, iSkipUntil2).trim();
                        } else {
                            int i13 = iSkipWhitespace + 1;
                            int iSkipUntil3 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.skipUntil(strValue, i13, "\"");
                            strTrim2 = strValue.substring(i13, iSkipUntil3);
                            iSkipUntil2 = iSkipUntil3 + 1;
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(strTrim)) {
                        z12 = true;
                    } else if ("no-store".equalsIgnoreCase(strTrim)) {
                        z13 = true;
                    } else if ("max-age".equalsIgnoreCase(strTrim)) {
                        seconds = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(strTrim2, -1);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                        seconds2 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(strTrim2, -1);
                    } else if ("private".equalsIgnoreCase(strTrim)) {
                        z14 = true;
                    } else if ("public".equalsIgnoreCase(strTrim)) {
                        z15 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                        z16 = true;
                    } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                        seconds3 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(strTrim2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
                    } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                        seconds4 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(strTrim2, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                        z17 = true;
                    } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                        z18 = true;
                    } else if ("immutable".equalsIgnoreCase(strTrim)) {
                        z19 = true;
                    }
                }
            } else {
                if (strName.equalsIgnoreCase("Pragma")) {
                }
            }
            z11 = false;
            while (i11 < strValue.length()) {
                iSkipUntil = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.skipUntil(strValue, i11, "=,;");
                strTrim = strValue.substring(i11, iSkipUntil).trim();
                if (iSkipUntil != strValue.length()) {
                    iSkipUntil2 = iSkipUntil + 1;
                    strTrim2 = null;
                } else {
                    iSkipUntil2 = iSkipUntil + 1;
                    strTrim2 = null;
                }
                if ("no-cache".equalsIgnoreCase(strTrim)) {
                    z12 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim)) {
                    z13 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim)) {
                    seconds = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(strTrim2, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                    seconds2 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(strTrim2, -1);
                } else if ("private".equalsIgnoreCase(strTrim)) {
                    z14 = true;
                } else if ("public".equalsIgnoreCase(strTrim)) {
                    z15 = true;
                } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                    z16 = true;
                } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                    seconds3 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(strTrim2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
                } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                    seconds4 = com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseSeconds(strTrim2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                    z17 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                    z18 = true;
                } else if ("immutable".equalsIgnoreCase(strTrim)) {
                    z19 = true;
                }
            }
        }
        return new CacheControl(z12, z13, seconds, seconds2, z14, z15, z16, seconds3, seconds4, z17, z18, z19, !z11 ? null : str);
    }

    public boolean immutable() {
        return this.immutable;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public boolean noCache() {
        return this.noCache;
    }

    public boolean noStore() {
        return this.noStore;
    }

    public boolean noTransform() {
        return this.noTransform;
    }

    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        String strHeaderValue = headerValue();
        this.headerValue = strHeaderValue;
        return strHeaderValue;
    }
}
