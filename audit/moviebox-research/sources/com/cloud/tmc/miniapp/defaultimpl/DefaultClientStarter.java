package com.cloud.tmc.miniapp.defaultimpl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.cloud.tmc.integration.activity.StartClientBundle;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.NewTaskManager;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.controller.a;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.process.AppRecord;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import hd.j;
import lb.g;
import org.mvel2.ast.ASTNode;
import v.b;
import v.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultClientStarter implements IClientStarter {
    @Override // com.cloud.tmc.miniapp.proxy.IClientStarter
    public synchronized Fragment createFragment(Context context, Bundle bundle) {
        return null;
    }

    @Override // com.cloud.tmc.miniapp.proxy.IClientStarter
    public PrepareController createPrepareController(g gVar, c0 c0Var) {
        return new b(gVar, c0Var);
    }

    @Override // com.cloud.tmc.miniapp.proxy.IClientStarter
    @NonNull
    public PrepareController createQuickModePrepareController(g gVar, c0 c0Var) {
        gVar.C(false);
        return new c(gVar, c0Var);
    }

    @Override // com.cloud.tmc.miniapp.proxy.IClientStarter
    @NonNull
    public PrepareController createSubpackagePrepareController(g gVar, c0 c0Var, int i11, String str) {
        return new a(gVar, c0Var, i11, str);
    }

    @Override // com.cloud.tmc.miniapp.proxy.IClientStarter
    public PrepareController createWarmupController(g gVar, c0 c0Var) {
        gVar.C(true);
        return new v.a(gVar, c0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.tmc.miniapp.proxy.IClientStarter
    public Class<? extends Activity> startClient(Context context, Intent intent, Bundle bundle) {
        Class clsA;
        Class clsN;
        Class cls;
        StringBuilder sbA = j.a("fromContext:");
        sbA.append(context.getClass().getSimpleName());
        TmcLogger.c("DefaultClientStarter", sbA.toString());
        if (!(context instanceof Activity)) {
            intent.addFlags(ASTNode.DEOP);
        }
        StartClientBundle startClientBundle = (StartClientBundle) com.cloud.tmc.kernel.utils.a.d(intent.getExtras(), "startBundle");
        String stringExtra = intent.getStringExtra("miniAppId");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (intent.getFlags() == 536870912) {
            Class cls2 = NewTaskManager.f31301b.getInstance().h(stringExtra) ? context.getClass() : MiniAppLaunch.N(intent);
            TmcLogger.c("DefaultClientStarter", "launch activity FLAG_ACTIVITY_SINGLE_TOP :" + cls2);
            cls = cls2;
        } else {
            NewTaskManager.a aVarB = NewTaskManager.f31301b.getInstance().B(context, new AppRecord(stringExtra, startClientBundle.startParams, startClientBundle.sceneParams));
            if (aVarB == null) {
                clsN = MiniAppLaunch.N(intent);
            } else {
                clsA = aVarB.a();
            }
        }
        if (cls != null) {
            cls = clsA;
            cls = clsN;
            StringBuilder sbA2 = j.a("target class:");
            sbA2.append(cls.getSimpleName());
            TmcLogger.c("DefaultClientStarter", sbA2.toString());
        }
        try {
            cls = clsA;
            cls = clsN;
            intent.putExtra("record_id", stringExtra);
            intent.putExtra("record_token", jCurrentTimeMillis);
            if (cls != null) {
                intent.setClass(context, cls);
            }
            h.f31061a.a(intent, context);
            context.startActivity(intent, bundle);
            TmcLogger.c("DefaultClientStarter", "start finish");
        } catch (Throwable th2) {
            TmcLogger.g("DefaultClientStarter", "startClient exception:", th2);
        }
        return cls;
    }
}
