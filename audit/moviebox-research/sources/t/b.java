package t;

import com.cloud.tmc.miniapp.performanceanalyse.screen.ScreenInspectHelper;
import java.util.Map;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements uc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenInspectHelper f76649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f76650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f76651c;

    public b(ScreenInspectHelper screenInspectHelper, e eVar, String str) {
        this.f76649a = screenInspectHelper;
        this.f76650b = eVar;
        this.f76651c = str;
    }

    @Override // uc.c
    public boolean O(uc.a aVar) {
        Map<String, Object> data;
        Object obj;
        if (aVar != null && (data = aVar.getData()) != null && (obj = data.get("eventData")) != null) {
            e eVar = this.f76650b;
            ScreenInspectHelper screenInspectHelper = this.f76649a;
            String str = this.f76651c;
            if (StringsKt__StringsKt.Q(obj.toString(), "true", false, 2, null)) {
                eVar.f76662e = 3;
                eVar.f76664g = true;
                boolean z11 = eVar.f76665h;
                com.cloud.tmc.miniapp.performanceanalyse.screen.a aVar2 = eVar.f76663f;
                screenInspectHelper.OooO00o(str, 3, z11, aVar2 != null ? Long.valueOf(aVar2.a()) : null);
            } else {
                eVar.f76662e = 2;
            }
        }
        uc.b bVar = this.f76649a.OooO00o;
        if (bVar != null) {
            bVar.c("renderStatus", this);
        }
        return true;
    }
}
