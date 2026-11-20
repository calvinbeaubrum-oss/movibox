package cg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14786a;

    public c(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f14786a = str;
    }

    public static c b(@NonNull String str) {
        return new c(str);
    }

    public String a() {
        return this.f14786a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.f14786a.equals(((c) obj).f14786a);
        }
        return false;
    }

    public int hashCode() {
        return this.f14786a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f14786a + "\"}";
    }
}
