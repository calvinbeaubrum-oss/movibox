package y00;

import android.os.Bundle;
import com.vungle.warren.log.LogManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f81051b = "j";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LogManager f81052a;

    public j(LogManager logManager) {
        this.f81052a = logManager;
    }

    public static g b() {
        return new g(f81051b).m(2);
    }

    @Override // y00.e
    public int a(Bundle bundle, h hVar) {
        this.f81052a.l();
        return 0;
    }
}
