package nj;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface a {

    /* JADX INFO: renamed from: nj.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @KeepForSdk
    public interface InterfaceC0771a {
    }

    /* JADX INFO: compiled from: source.java */
    @KeepForSdk
    public interface b {
        @KeepForSdk
        void a(int i11, @Nullable Bundle bundle);
    }

    /* JADX INFO: compiled from: source.java */
    @KeepForSdk
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        @KeepForSdk
        public String f71997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        @KeepForSdk
        public String f71998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        @KeepForSdk
        public Object f71999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        @KeepForSdk
        public String f72000d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @KeepForSdk
        public long f72001e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        @KeepForSdk
        public String f72002f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        @KeepForSdk
        public Bundle f72003g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        @KeepForSdk
        public String f72004h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        @KeepForSdk
        public Bundle f72005i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @KeepForSdk
        public long f72006j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        @KeepForSdk
        public String f72007k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        @KeepForSdk
        public Bundle f72008l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @KeepForSdk
        public long f72009m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @KeepForSdk
        public boolean f72010n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @KeepForSdk
        public long f72011o;
    }

    @KeepForSdk
    void a(@NonNull c cVar);

    @KeepForSdk
    void b(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle);

    @Nullable
    @KeepForSdk
    InterfaceC0771a c(@NonNull String str, @NonNull b bVar);

    @KeepForSdk
    void clearConditionalUserProperty(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle);

    @KeepForSdk
    void d(@NonNull String str, @NonNull String str2, @NonNull Object obj);

    @NonNull
    @KeepForSdk
    Map<String, Object> e(boolean z11);

    @KeepForSdk
    int f(@NonNull String str);

    @NonNull
    @KeepForSdk
    List<c> g(@NonNull String str, @Nullable String str2);
}
