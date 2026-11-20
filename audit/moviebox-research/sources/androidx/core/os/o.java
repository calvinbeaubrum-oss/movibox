package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public final class o implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f7799a;

    public o(Object obj) {
        this.f7799a = l.a(obj);
    }

    @Override // androidx.core.os.j
    public String a() {
        return this.f7799a.toLanguageTags();
    }

    @Override // androidx.core.os.j
    public Object b() {
        return this.f7799a;
    }

    public boolean equals(Object obj) {
        return this.f7799a.equals(((j) obj).b());
    }

    @Override // androidx.core.os.j
    public Locale get(int i11) {
        return this.f7799a.get(i11);
    }

    public int hashCode() {
        return this.f7799a.hashCode();
    }

    @Override // androidx.core.os.j
    public boolean isEmpty() {
        return this.f7799a.isEmpty();
    }

    @Override // androidx.core.os.j
    public int size() {
        return this.f7799a.size();
    }

    public String toString() {
        return this.f7799a.toString();
    }
}
