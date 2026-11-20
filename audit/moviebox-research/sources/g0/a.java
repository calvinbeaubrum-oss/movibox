package g0;

import android.os.Bundle;
import hd.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f65301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f65302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f65303c;

    public a(int i11, String event, Bundle data) {
        Intrinsics.g(event, "event");
        Intrinsics.g(data, "data");
        this.f65301a = i11;
        this.f65302b = event;
        this.f65303c = data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f65301a == aVar.f65301a && Intrinsics.b(this.f65302b, aVar.f65302b) && Intrinsics.b(this.f65303c, aVar.f65303c);
    }

    public int hashCode() {
        return this.f65303c.hashCode() + ((this.f65302b.hashCode() + (this.f65301a * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbA = j.a("AthenaDataBean(athenaAppId=");
        sbA.append(this.f65301a);
        sbA.append(", event=");
        sbA.append(this.f65302b);
        sbA.append(", data=");
        sbA.append(this.f65303c);
        sbA.append(')');
        return sbA.toString();
    }
}
