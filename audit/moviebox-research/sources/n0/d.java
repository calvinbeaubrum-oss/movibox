package n0;

import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import l.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f71320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f71321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f71322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f71323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public File f71324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f71325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o0.c<?> f71326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o0.b f71327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o0.d f71328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f71329j;

    public d(CharSequence text, int i11, long j11, boolean z11, File file, int i12, o0.c<?> cVar, o0.b bVar, o0.d dVar, Function0<Unit> function0) {
        Intrinsics.g(text, "text");
        this.f71320a = text;
        this.f71321b = i11;
        this.f71322c = j11;
        this.f71323d = z11;
        this.f71324e = file;
        this.f71325f = i12;
        this.f71326g = cVar;
        this.f71327h = bVar;
        this.f71328i = dVar;
        this.f71329j = function0;
    }

    public /* synthetic */ d(CharSequence charSequence, int i11, long j11, boolean z11, File file, int i12, o0.c cVar, o0.b bVar, o0.d dVar, Function0 function0, int i13) {
        this(charSequence, (i13 & 2) != 0 ? -1 : i11, (i13 & 4) != 0 ? 0L : j11, (i13 & 8) != 0 ? false : z11, (i13 & 16) != 0 ? null : file, (i13 & 32) != 0 ? 0 : i12, (i13 & 64) != 0 ? null : cVar, null, null, (i13 & 512) != 0 ? null : function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.b(this.f71320a, dVar.f71320a) && this.f71321b == dVar.f71321b && this.f71322c == dVar.f71322c && this.f71323d == dVar.f71323d && Intrinsics.b(this.f71324e, dVar.f71324e) && this.f71325f == dVar.f71325f && Intrinsics.b(this.f71326g, dVar.f71326g) && Intrinsics.b(this.f71327h, dVar.f71327h) && Intrinsics.b(this.f71328i, dVar.f71328i) && Intrinsics.b(this.f71329j, dVar.f71329j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        int iA = (p.a(this.f71322c) + ((this.f71321b + (this.f71320a.hashCode() * 31)) * 31)) * 31;
        boolean z11 = this.f71323d;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iA + r11) * 31;
        File file = this.f71324e;
        int iHashCode = (this.f71325f + ((i11 + (file == null ? 0 : file.hashCode())) * 31)) * 31;
        o0.c<?> cVar = this.f71326g;
        int iHashCode2 = (iHashCode + (cVar == null ? 0 : cVar.hashCode())) * 31;
        o0.b bVar = this.f71327h;
        int iHashCode3 = (iHashCode2 + (bVar == null ? 0 : bVar.hashCode())) * 31;
        o0.d dVar = this.f71328i;
        int iHashCode4 = (iHashCode3 + (dVar == null ? 0 : dVar.hashCode())) * 31;
        Function0<Unit> function0 = this.f71329j;
        return iHashCode4 + (function0 != null ? function0.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbA = hd.j.a("ToastParams(text=");
        sbA.append((Object) this.f71320a);
        sbA.append(", duration=");
        sbA.append(this.f71321b);
        sbA.append(", delayMillis=");
        sbA.append(this.f71322c);
        sbA.append(", mask=");
        sbA.append(this.f71323d);
        sbA.append(", icon=");
        sbA.append(this.f71324e);
        sbA.append(", drawableResId=");
        sbA.append(this.f71325f);
        sbA.append(", style=");
        sbA.append(this.f71326g);
        sbA.append(", strategy=");
        sbA.append(this.f71327h);
        sbA.append(", interceptor=");
        sbA.append(this.f71328i);
        sbA.append(", showCallBack=");
        sbA.append(this.f71329j);
        sbA.append(')');
        return sbA.toString();
    }
}
