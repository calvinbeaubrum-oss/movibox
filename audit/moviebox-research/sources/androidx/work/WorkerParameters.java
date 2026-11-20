package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkerParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public UUID f13241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public d f13242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public Set<String> f13243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public a f13244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public Executor f13246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public t6.c f13247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public s f13248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public n f13249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public f f13250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13251k;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public List<String> f13252a = Collections.emptyList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public List<Uri> f13253b = Collections.emptyList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        @RequiresApi(28)
        public Network f13254c;
    }

    public WorkerParameters(@NonNull UUID uuid, @NonNull d dVar, @NonNull Collection<String> collection, @NonNull a aVar, int i11, int i12, @NonNull Executor executor, @NonNull t6.c cVar, @NonNull s sVar, @NonNull n nVar, @NonNull f fVar) {
        this.f13241a = uuid;
        this.f13242b = dVar;
        this.f13243c = new HashSet(collection);
        this.f13244d = aVar;
        this.f13245e = i11;
        this.f13251k = i12;
        this.f13246f = executor;
        this.f13247g = cVar;
        this.f13248h = sVar;
        this.f13249i = nVar;
        this.f13250j = fVar;
    }

    @NonNull
    public Executor a() {
        return this.f13246f;
    }

    @NonNull
    public f b() {
        return this.f13250j;
    }

    @NonNull
    public UUID c() {
        return this.f13241a;
    }

    @NonNull
    public d d() {
        return this.f13242b;
    }

    @Nullable
    @RequiresApi(28)
    public Network e() {
        return this.f13244d.f13254c;
    }

    @NonNull
    public n f() {
        return this.f13249i;
    }

    public int g() {
        return this.f13245e;
    }

    @NonNull
    public Set<String> h() {
        return this.f13243c;
    }

    @NonNull
    public t6.c i() {
        return this.f13247g;
    }

    @NonNull
    @RequiresApi(24)
    public List<String> j() {
        return this.f13244d.f13252a;
    }

    @NonNull
    @RequiresApi(24)
    public List<Uri> k() {
        return this.f13244d.f13253b;
    }

    @NonNull
    public s l() {
        return this.f13248h;
    }
}
