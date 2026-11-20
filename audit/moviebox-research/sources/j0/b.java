package j0;

import android.content.Context;
import java.util.List;
import k0.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f67803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f67804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e> f67805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f67806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f67807e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context context, String str, List<? extends e> steps, int i11, a athenaReportBean) {
        Intrinsics.g(steps, "steps");
        Intrinsics.g(athenaReportBean, "athenaReportBean");
        this.f67803a = context;
        this.f67804b = str;
        this.f67805c = steps;
        this.f67806d = i11;
        this.f67807e = athenaReportBean;
    }

    public a a(boolean z11) {
        if (this.f67806d >= this.f67805c.size() || z11) {
            return this.f67807e;
        }
        return this.f67805c.get(this.f67806d).a(new b(this.f67803a, this.f67804b, this.f67805c, this.f67806d + 1, this.f67807e));
    }
}
