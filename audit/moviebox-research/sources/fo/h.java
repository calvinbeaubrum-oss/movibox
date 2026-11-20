package fo;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface h {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f65180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f65181b;

        public a(String str, boolean z11) {
            this.f65180a = str;
            this.f65181b = z11;
        }

        public String a() {
            return this.f65180a;
        }

        public boolean b() {
            return this.f65181b;
        }
    }

    String a();

    a b(p007do.m mVar, Context context) throws Exception;
}
