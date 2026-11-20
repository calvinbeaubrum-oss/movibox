package com.cloud.tmc.integration.bridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class MakePhoneCallBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void makePhoneCall(@cc.g(name = {"phoneNumber"}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            aVar.b();
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            aVar.b();
            return;
        }
        Context context = appContext.getContext();
        if (context == null) {
            aVar.b();
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
            intent.addFlags(ASTNode.DEOP);
            context.startActivity(intent);
            aVar.g();
        } catch (Exception e11) {
            TmcLogger.h("MakePhoneCall", e11);
            aVar.b();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }
}
