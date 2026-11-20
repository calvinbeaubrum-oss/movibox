package t;

import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.performanceanalyse.screen.ScreenInspectHelper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements uc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f76652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScreenInspectHelper f76653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f76654c;

    public c(e eVar, ScreenInspectHelper screenInspectHelper, a aVar) {
        this.f76652a = eVar;
        this.f76653b = screenInspectHelper;
        this.f76654c = aVar;
    }

    @Override // uc.c
    public boolean O(uc.a aVar) {
        p.e("miniapp", "connectRender success");
        this.f76652a.f76659b = 2;
        uc.b bVar = this.f76653b.OooO00o;
        if (bVar != null) {
            bVar.c("connectionRender", this);
        }
        if (this.f76654c.f76647d != 2) {
            return true;
        }
        ScreenInspectHelper.access$checkWhiteScreen(this.f76653b, this.f76652a);
        return true;
    }
}
