package rl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.firebase.perf.util.i;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.net.URI;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ql.a f75615c = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkRequestMetric f75616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f75617b;

    public c(NetworkRequestMetric networkRequestMetric, Context context) {
        this.f75617b = context;
        this.f75616a = networkRequestMetric;
    }

    @Override // rl.e
    public boolean c() {
        if (j(this.f75616a.s0())) {
            f75615c.j("URL is missing:" + this.f75616a.s0());
            return false;
        }
        URI uriG = g(this.f75616a.s0());
        if (uriG == null) {
            f75615c.j("URL cannot be parsed");
            return false;
        }
        if (!h(uriG, this.f75617b)) {
            f75615c.j("URL fails allowlist rule: " + uriG);
            return false;
        }
        if (!k(uriG.getHost())) {
            f75615c.j("URL host is null or invalid");
            return false;
        }
        if (!p(uriG.getScheme())) {
            f75615c.j("URL scheme is null or invalid");
            return false;
        }
        if (!r(uriG.getUserInfo())) {
            f75615c.j("URL user info is null");
            return false;
        }
        if (!o(uriG.getPort())) {
            f75615c.j("URL port is less than or equal to 0");
            return false;
        }
        if (!l(this.f75616a.u0() ? this.f75616a.j0() : null)) {
            f75615c.j("HTTP Method is null or invalid: " + this.f75616a.j0());
            return false;
        }
        if (this.f75616a.v0() && !m(this.f75616a.k0())) {
            f75615c.j("HTTP ResponseCode is a negative value:" + this.f75616a.k0());
            return false;
        }
        if (this.f75616a.w0() && !n(this.f75616a.m0())) {
            f75615c.j("Request Payload is a negative value:" + this.f75616a.m0());
            return false;
        }
        if (this.f75616a.x0() && !n(this.f75616a.o0())) {
            f75615c.j("Response Payload is a negative value:" + this.f75616a.o0());
            return false;
        }
        if (!this.f75616a.t0() || this.f75616a.h0() <= 0) {
            f75615c.j("Start time of the request is null, or zero, or a negative value:" + this.f75616a.h0());
            return false;
        }
        if (this.f75616a.y0() && !q(this.f75616a.p0())) {
            f75615c.j("Time to complete the request is a negative value:" + this.f75616a.p0());
            return false;
        }
        if (this.f75616a.A0() && !q(this.f75616a.r0())) {
            f75615c.j("Time from the start of the request to the start of the response is null or a negative value:" + this.f75616a.r0());
            return false;
        }
        if (this.f75616a.z0() && this.f75616a.q0() > 0) {
            if (this.f75616a.v0()) {
                return true;
            }
            f75615c.j("Did not receive a HTTP Response Code");
            return false;
        }
        f75615c.j("Time from the start of the request to the end of the response is null, negative or zero:" + this.f75616a.q0());
        return false;
    }

    @Nullable
    public final URI g(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException e11) {
            f75615c.k("getResultUrl throws exception %s", e11.getMessage());
            return null;
        }
    }

    public final boolean h(@Nullable URI uri, @NonNull Context context) {
        if (uri == null) {
            return false;
        }
        return i.a(uri, context);
    }

    public final boolean i(@Nullable String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }

    public final boolean j(@Nullable String str) {
        return i(str);
    }

    public final boolean k(@Nullable String str) {
        return (str == null || i(str) || str.length() > 255) ? false : true;
    }

    public boolean l(@Nullable NetworkRequestMetric.HttpMethod httpMethod) {
        return (httpMethod == null || httpMethod == NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN) ? false : true;
    }

    public final boolean m(int i11) {
        return i11 > 0;
    }

    public final boolean n(long j11) {
        return j11 >= 0;
    }

    public final boolean o(int i11) {
        return i11 == -1 || i11 > 0;
    }

    public final boolean p(@Nullable String str) {
        if (str == null) {
            return false;
        }
        return HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(str) || "https".equalsIgnoreCase(str);
    }

    public final boolean q(long j11) {
        return j11 >= 0;
    }

    public final boolean r(@Nullable String str) {
        return str == null;
    }
}
