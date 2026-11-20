package gc;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f65473a;

    public a(Bundle bundle) {
        this.f65473a = bundle;
    }

    public Bundle a() {
        return new Bundle(this.f65473a);
    }

    public String toString() {
        if (this.f65473a == null) {
            return "ImmutableBundle{NULL}";
        }
        return "ImmutableBundle{" + this.f65473a.toString() + "}";
    }
}
