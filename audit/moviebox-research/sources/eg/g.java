package eg;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f64154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f64155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ClientInfo f64156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f64157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f64158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<l> f64159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final QosTier f64160g;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f64161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f64162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ClientInfo f64163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f64164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f64165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<l> f64166f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public QosTier f64167g;

        @Override // eg.m.a
        public m a() {
            String str = "";
            if (this.f64161a == null) {
                str = " requestTimeMs";
            }
            if (this.f64162b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.f64161a.longValue(), this.f64162b.longValue(), this.f64163c, this.f64164d, this.f64165e, this.f64166f, this.f64167g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // eg.m.a
        public m.a b(@Nullable ClientInfo clientInfo) {
            this.f64163c = clientInfo;
            return this;
        }

        @Override // eg.m.a
        public m.a c(@Nullable List<l> list) {
            this.f64166f = list;
            return this;
        }

        @Override // eg.m.a
        public m.a d(@Nullable Integer num) {
            this.f64164d = num;
            return this;
        }

        @Override // eg.m.a
        public m.a e(@Nullable String str) {
            this.f64165e = str;
            return this;
        }

        @Override // eg.m.a
        public m.a f(@Nullable QosTier qosTier) {
            this.f64167g = qosTier;
            return this;
        }

        @Override // eg.m.a
        public m.a g(long j11) {
            this.f64161a = Long.valueOf(j11);
            return this;
        }

        @Override // eg.m.a
        public m.a h(long j11) {
            this.f64162b = Long.valueOf(j11);
            return this;
        }
    }

    public g(long j11, long j12, @Nullable ClientInfo clientInfo, @Nullable Integer num, @Nullable String str, @Nullable List<l> list, @Nullable QosTier qosTier) {
        this.f64154a = j11;
        this.f64155b = j12;
        this.f64156c = clientInfo;
        this.f64157d = num;
        this.f64158e = str;
        this.f64159f = list;
        this.f64160g = qosTier;
    }

    @Override // eg.m
    @Nullable
    public ClientInfo b() {
        return this.f64156c;
    }

    @Override // eg.m
    @Nullable
    public List<l> c() {
        return this.f64159f;
    }

    @Override // eg.m
    @Nullable
    public Integer d() {
        return this.f64157d;
    }

    @Override // eg.m
    @Nullable
    public String e() {
        return this.f64158e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<l> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f64154a == mVar.g() && this.f64155b == mVar.h() && ((clientInfo = this.f64156c) != null ? clientInfo.equals(mVar.b()) : mVar.b() == null) && ((num = this.f64157d) != null ? num.equals(mVar.d()) : mVar.d() == null) && ((str = this.f64158e) != null ? str.equals(mVar.e()) : mVar.e() == null) && ((list = this.f64159f) != null ? list.equals(mVar.c()) : mVar.c() == null)) {
            QosTier qosTier = this.f64160g;
            if (qosTier == null) {
                if (mVar.f() == null) {
                    return true;
                }
            } else if (qosTier.equals(mVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // eg.m
    @Nullable
    public QosTier f() {
        return this.f64160g;
    }

    @Override // eg.m
    public long g() {
        return this.f64154a;
    }

    @Override // eg.m
    public long h() {
        return this.f64155b;
    }

    public int hashCode() {
        long j11 = this.f64154a;
        long j12 = this.f64155b;
        int i11 = (((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        ClientInfo clientInfo = this.f64156c;
        int iHashCode = (i11 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f64157d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f64158e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<l> list = this.f64159f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f64160g;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f64154a + ", requestUptimeMs=" + this.f64155b + ", clientInfo=" + this.f64156c + ", logSource=" + this.f64157d + ", logSourceName=" + this.f64158e + ", logEvents=" + this.f64159f + ", qosTier=" + this.f64160g + "}";
    }
}
