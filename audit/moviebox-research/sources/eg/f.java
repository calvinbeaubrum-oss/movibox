package eg;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ComplianceData;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f64138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f64139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ComplianceData f64140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f64141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f64142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f64143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f64144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NetworkConnectionInfo f64145h;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f64146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f64147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ComplianceData f64148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f64149d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f64150e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f64151f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Long f64152g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public NetworkConnectionInfo f64153h;

        @Override // eg.l.a
        public l a() {
            String str = "";
            if (this.f64146a == null) {
                str = " eventTimeMs";
            }
            if (this.f64149d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f64152g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.f64146a.longValue(), this.f64147b, this.f64148c, this.f64149d.longValue(), this.f64150e, this.f64151f, this.f64152g.longValue(), this.f64153h);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // eg.l.a
        public l.a b(@Nullable ComplianceData complianceData) {
            this.f64148c = complianceData;
            return this;
        }

        @Override // eg.l.a
        public l.a c(@Nullable Integer num) {
            this.f64147b = num;
            return this;
        }

        @Override // eg.l.a
        public l.a d(long j11) {
            this.f64146a = Long.valueOf(j11);
            return this;
        }

        @Override // eg.l.a
        public l.a e(long j11) {
            this.f64149d = Long.valueOf(j11);
            return this;
        }

        @Override // eg.l.a
        public l.a f(@Nullable NetworkConnectionInfo networkConnectionInfo) {
            this.f64153h = networkConnectionInfo;
            return this;
        }

        @Override // eg.l.a
        public l.a g(@Nullable byte[] bArr) {
            this.f64150e = bArr;
            return this;
        }

        @Override // eg.l.a
        public l.a h(@Nullable String str) {
            this.f64151f = str;
            return this;
        }

        @Override // eg.l.a
        public l.a i(long j11) {
            this.f64152g = Long.valueOf(j11);
            return this;
        }
    }

    public f(long j11, @Nullable Integer num, @Nullable ComplianceData complianceData, long j12, @Nullable byte[] bArr, @Nullable String str, long j13, @Nullable NetworkConnectionInfo networkConnectionInfo) {
        this.f64138a = j11;
        this.f64139b = num;
        this.f64140c = complianceData;
        this.f64141d = j12;
        this.f64142e = bArr;
        this.f64143f = str;
        this.f64144g = j13;
        this.f64145h = networkConnectionInfo;
    }

    @Override // eg.l
    @Nullable
    public ComplianceData b() {
        return this.f64140c;
    }

    @Override // eg.l
    @Nullable
    public Integer c() {
        return this.f64139b;
    }

    @Override // eg.l
    public long d() {
        return this.f64138a;
    }

    @Override // eg.l
    public long e() {
        return this.f64141d;
    }

    public boolean equals(Object obj) {
        Integer num;
        ComplianceData complianceData;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f64138a == lVar.d() && ((num = this.f64139b) != null ? num.equals(lVar.c()) : lVar.c() == null) && ((complianceData = this.f64140c) != null ? complianceData.equals(lVar.b()) : lVar.b() == null) && this.f64141d == lVar.e()) {
            if (Arrays.equals(this.f64142e, lVar instanceof f ? ((f) lVar).f64142e : lVar.g()) && ((str = this.f64143f) != null ? str.equals(lVar.h()) : lVar.h() == null) && this.f64144g == lVar.i()) {
                NetworkConnectionInfo networkConnectionInfo = this.f64145h;
                if (networkConnectionInfo == null) {
                    if (lVar.f() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(lVar.f())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // eg.l
    @Nullable
    public NetworkConnectionInfo f() {
        return this.f64145h;
    }

    @Override // eg.l
    @Nullable
    public byte[] g() {
        return this.f64142e;
    }

    @Override // eg.l
    @Nullable
    public String h() {
        return this.f64143f;
    }

    public int hashCode() {
        long j11 = this.f64138a;
        int i11 = (((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f64139b;
        int iHashCode = (i11 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        ComplianceData complianceData = this.f64140c;
        int iHashCode2 = complianceData == null ? 0 : complianceData.hashCode();
        long j12 = this.f64141d;
        int iHashCode3 = (((((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f64142e)) * 1000003;
        String str = this.f64143f;
        int iHashCode4 = str == null ? 0 : str.hashCode();
        long j13 = this.f64144g;
        int i12 = (((iHashCode3 ^ iHashCode4) * 1000003) ^ ((int) ((j13 >>> 32) ^ j13))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f64145h;
        return i12 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    @Override // eg.l
    public long i() {
        return this.f64144g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f64138a + ", eventCode=" + this.f64139b + ", complianceData=" + this.f64140c + ", eventUptimeMs=" + this.f64141d + ", sourceExtension=" + Arrays.toString(this.f64142e) + ", sourceExtensionJsonProto3=" + this.f64143f + ", timezoneOffsetSeconds=" + this.f64144g + ", networkConnectionInfo=" + this.f64145h + "}";
    }
}
