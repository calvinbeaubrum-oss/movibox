package h;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.activity.StartAction;
import com.cloud.tmc.integration.activity.StartClientBundle;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.PrepareData;
import com.cloud.tmc.integration.performance.WarmupType;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.r;
import java.util.concurrent.atomic.AtomicLong;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f65665f = new AtomicLong(Process.myPid());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lb.g f65667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f65668c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f65666a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f65669d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f65670e = false;

    public c(lb.g gVar, r rVar) {
        this.f65667b = gVar;
        this.f65668c = rVar;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void OooO00o() {
        r rVar = this.f65668c;
        if (rVar != null) {
            rVar.c();
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void OooO00o(boolean z11) {
        r rVar;
        this.f65669d = z11;
        if (!z11 || (rVar = this.f65668c) == null) {
            return;
        }
        rVar.h(null);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void a(String str) {
        r rVar = this.f65668c;
        if (rVar != null) {
            rVar.a(str);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void b() {
        r rVar = this.f65668c;
        if (rVar != null) {
            rVar.b();
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void c(lb.f fVar, int i11) {
        if (i11 == WarmupType.NORMAL_WORKER.getType() || i11 == WarmupType.NORMAL_RENDER.getType()) {
            return;
        }
        if (i11 == WarmupType.INNER_WORKER.getType()) {
            ((IInnerWorkerPool) tc.a.a(IInnerWorkerPool.class)).warmupWorker(fVar);
        } else if (i11 == WarmupType.INNER_RENNDER.getType()) {
            ((IInnerRenderPool) tc.a.a(IInnerRenderPool.class)).warmupRender(fVar);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void d(@Nullable String str, @Nullable String str2) {
        r rVar;
        if (this.f65670e || (rVar = this.f65668c) == null) {
            return;
        }
        this.f65670e = true;
        rVar.d(str, str2);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void e(@NonNull AppModel appModel) {
        r rVar = this.f65668c;
        if (rVar != null) {
            rVar.e(appModel);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void f(PrepareData prepareData, PrepareException prepareException) {
        r rVar = this.f65668c;
        if (rVar != null) {
            rVar.z(prepareData, prepareException);
            this.f65668c.f(prepareData, prepareException);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void g(@NonNull AppModel appModel, boolean z11) {
        r rVar = this.f65668c;
        if (rVar != null) {
            rVar.g(appModel, z11);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void h(EntryInfo entryInfo) {
        r rVar;
        if (!this.f65669d || (rVar = this.f65668c) == null) {
            return;
        }
        rVar.h(entryInfo);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void i(LoadStepAction loadStepAction) {
        r rVar = this.f65668c;
        if (rVar != null) {
            rVar.i(loadStepAction);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void j(PrepareData prepareData, @Nullable AppModel appModel, @Nullable Bundle bundle, @Nullable Bundle bundle2) {
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void k(lb.f fVar, PrepareController prepareController) {
        if (this.f65666a) {
            return;
        }
        this.f65666a = true;
        Intent intent = new Intent();
        EntryInfo entryInfoK = this.f65667b.k();
        Bundle bundleQ = this.f65667b.q();
        Bundle bundleO = this.f65667b.o();
        AppModel appModel = fVar.f70182c;
        if (appModel != null) {
            bundleO.putParcelable("appInfo", appModel);
        }
        AppLoadResult appLoadResult = fVar.f70183d;
        if (appLoadResult != null) {
            bundleO.putParcelable("appLoadResult", appLoadResult);
        }
        if (entryInfoK != null) {
            bundleO.putParcelable("entryInfo", entryInfoK);
        }
        StartClientBundle startClientBundle = new StartClientBundle();
        startClientBundle.appId = fVar.f70182c.getAppId();
        long jAddAndGet = f65665f.addAndGet(1L) + System.currentTimeMillis();
        startClientBundle.startToken = jAddAndGet;
        bundleO.putLong("startToken", jAddAndGet);
        startClientBundle.startParams = bundleQ;
        startClientBundle.sceneParams = bundleO;
        StartAction startAction = fVar.f70181b;
        if (startAction != null) {
            startClientBundle.startAction = startAction;
        } else {
            startClientBundle.startAction = StartAction.DIRECT_START;
        }
        intent.putExtra("startBundle", startClientBundle);
        AppModel appModel2 = fVar.f70182c;
        intent.putExtra("record_id", appModel2 != null ? appModel2.getAppId() : "");
        intent.putExtra("record_token", System.currentTimeMillis());
        intent.setFlags(ASTNode.DISCARD);
        com.cloud.tmc.integration.utils.h.f31061a.a(intent, this.f65667b.p());
        r rVar = this.f65668c;
        if (rVar != null) {
            rVar.q(intent);
        } else {
            prepareController.moveToError(new PrepareException("loadListener is null"));
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.c0
    public void l(lb.f fVar, PrepareController prepareController) {
        try {
            if (this.f65668c != null) {
                Intent intent = new Intent();
                EntryInfo entryInfoK = this.f65667b.k();
                Bundle bundleQ = this.f65667b.q();
                Bundle bundleO = this.f65667b.o();
                bundleO.putParcelable("appLoadResult", fVar.f70183d);
                if (entryInfoK != null) {
                    bundleO.putParcelable("entryInfo", entryInfoK);
                }
                StartClientBundle startClientBundle = new StartClientBundle();
                AppModel appModel = fVar.f70182c;
                startClientBundle.appId = appModel != null ? appModel.getAppId() : "";
                startClientBundle.startParams = bundleQ;
                startClientBundle.sceneParams = bundleO;
                startClientBundle.startAction = StartAction.DIRECT_START;
                intent.putExtra("startBundle", startClientBundle);
                intent.putExtra("startAppModel", (Parcelable) appModel);
                this.f65668c.y(intent);
            }
        } catch (Throwable unused) {
        }
    }
}
