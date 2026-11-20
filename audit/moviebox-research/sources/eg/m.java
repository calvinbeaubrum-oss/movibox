package eg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        @NonNull
        public abstract m a();

        @NonNull
        public abstract a b(@Nullable ClientInfo clientInfo);

        @NonNull
        public abstract a c(@Nullable List<l> list);

        @NonNull
        public abstract a d(@Nullable Integer num);

        @NonNull
        public abstract a e(@Nullable String str);

        @NonNull
        public abstract a f(@Nullable QosTier qosTier);

        @NonNull
        public abstract a g(long j11);

        @NonNull
        public abstract a h(long j11);

        @NonNull
        public a i(int i11) {
            return d(Integer.valueOf(i11));
        }

        @NonNull
        public a j(@NonNull String str) {
            return e(str);
        }
    }

    @NonNull
    public static a a() {
        return new g.b();
    }

    @Nullable
    public abstract ClientInfo b();

    @Nullable
    public abstract List<l> c();

    @Nullable
    public abstract Integer d();

    @Nullable
    public abstract String e();

    @Nullable
    public abstract QosTier f();

    public abstract long g();

    public abstract long h();
}
