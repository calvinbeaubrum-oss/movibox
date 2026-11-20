package a10;

import androidx.annotation.Nullable;
import com.vungle.warren.model.m;
import com.vungle.warren.utility.ActivityManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f implements ActivityManager.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b10.b.a f364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f365b;

    public f(@Nullable b10.b.a aVar, @Nullable m mVar) {
        this.f364a = aVar;
        this.f365b = mVar;
    }

    @Override // com.vungle.warren.utility.ActivityManager.d
    public void a() {
        b10.b.a aVar = this.f364a;
        if (aVar != null) {
            m mVar = this.f365b;
            aVar.a("open", "adLeftApplication", mVar == null ? null : mVar.d());
        }
    }
}
