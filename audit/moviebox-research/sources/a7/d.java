package a7;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f430c = new d("COMPOSITION");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public e f432b;

    public d(d dVar) {
        this.f431a = new ArrayList(dVar.f431a);
        this.f432b = dVar.f432b;
    }

    public d(String... strArr) {
        this.f431a = Arrays.asList(strArr);
    }

    @CheckResult
    public d a(String str) {
        d dVar = new d(this);
        dVar.f431a.add(str);
        return dVar;
    }

    public final boolean b() {
        List<String> list = this.f431a;
        return list.get(list.size() - 1).equals("**");
    }

    public boolean c(String str, int i11) {
        if (i11 >= this.f431a.size()) {
            return false;
        }
        boolean z11 = i11 == this.f431a.size() - 1;
        String str2 = this.f431a.get(i11);
        if (!str2.equals("**")) {
            return (z11 || (i11 == this.f431a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z11 && this.f431a.get(i11 + 1).equals(str)) {
            return i11 == this.f431a.size() + (-2) || (i11 == this.f431a.size() + (-3) && b());
        }
        if (z11) {
            return true;
        }
        int i12 = i11 + 1;
        if (i12 < this.f431a.size() - 1) {
            return false;
        }
        return this.f431a.get(i12).equals(str);
    }

    @Nullable
    public e d() {
        return this.f432b;
    }

    public int e(String str, int i11) {
        if (f(str)) {
            return 0;
        }
        if (this.f431a.get(i11).equals("**")) {
            return (i11 != this.f431a.size() - 1 && this.f431a.get(i11 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f431a.equals(dVar.f431a)) {
            return false;
        }
        e eVar = this.f432b;
        e eVar2 = dVar.f432b;
        if (eVar != null) {
            return eVar.equals(eVar2);
        }
        return eVar2 == null;
    }

    public final boolean f(String str) {
        return "__container".equals(str);
    }

    public boolean g(String str, int i11) {
        if (f(str)) {
            return true;
        }
        if (i11 >= this.f431a.size()) {
            return false;
        }
        return this.f431a.get(i11).equals(str) || this.f431a.get(i11).equals("**") || this.f431a.get(i11).equals("*");
    }

    public boolean h(String str, int i11) {
        return "__container".equals(str) || i11 < this.f431a.size() - 1 || this.f431a.get(i11).equals("**");
    }

    public int hashCode() {
        int iHashCode = this.f431a.hashCode() * 31;
        e eVar = this.f432b;
        return iHashCode + (eVar != null ? eVar.hashCode() : 0);
    }

    public d i(e eVar) {
        d dVar = new d(this);
        dVar.f432b = eVar;
        return dVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("KeyPath{keys=");
        sb2.append(this.f431a);
        sb2.append(",resolved=");
        sb2.append(this.f432b != null);
        sb2.append('}');
        return sb2.toString();
    }
}
