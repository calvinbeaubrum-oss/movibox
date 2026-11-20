package eg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ComplianceData;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class l {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        @NonNull
        public abstract l a();

        @NonNull
        public abstract a b(@Nullable ComplianceData complianceData);

        @NonNull
        public abstract a c(@Nullable Integer num);

        @NonNull
        public abstract a d(long j11);

        @NonNull
        public abstract a e(long j11);

        @NonNull
        public abstract a f(@Nullable NetworkConnectionInfo networkConnectionInfo);

        @NonNull
        public abstract a g(@Nullable byte[] bArr);

        @NonNull
        public abstract a h(@Nullable String str);

        @NonNull
        public abstract a i(long j11);
    }

    public static a a() {
        return new f.b();
    }

    @NonNull
    public static a j(@NonNull String str) {
        return a().h(str);
    }

    @NonNull
    public static a k(@NonNull byte[] bArr) {
        return a().g(bArr);
    }

    @Nullable
    public abstract ComplianceData b();

    @Nullable
    public abstract Integer c();

    public abstract long d();

    public abstract long e();

    @Nullable
    public abstract NetworkConnectionInfo f();

    @Nullable
    public abstract byte[] g();

    @Nullable
    public abstract String h();

    public abstract long i();
}
