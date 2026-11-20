package t;

import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.performanceanalyse.screen.ScreenInspectHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements uc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f76655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScreenInspectHelper f76656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f76657c;

    public d(a aVar, ScreenInspectHelper screenInspectHelper, e eVar) {
        this.f76655a = aVar;
        this.f76656b = screenInspectHelper;
        this.f76657c = eVar;
    }

    @Override // uc.c
    public boolean O(uc.a aVar) {
        p.e("miniapp", "connectWorker success");
        this.f76655a.f76647d = 2;
        uc.b bVar = this.f76656b.OooO00o;
        if (bVar != null) {
            bVar.c("connectionWorker", this);
        }
        e eVar = this.f76657c;
        if (eVar.f76659b != 2) {
            return true;
        }
        ScreenInspectHelper.access$checkWhiteScreen(this.f76656b, eVar);
        return true;
    }
}
