package com.cloud.tmc.integration.structure;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.node.Node;
import dd.d;
import java.util.List;
import java.util.Stack;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.integration.structure.impl.AppManagerImpl")
public interface AppManager extends Node {
    void exitApp(App app);

    App findApp(long j11);

    @Nullable
    App findApp(String str);

    App findAppByToken(long j11);

    Stack<App> getAppStack();

    @Override // com.cloud.tmc.kernel.node.Node
    /* synthetic */ d getGroup();

    @Override // com.cloud.tmc.kernel.node.Node
    /* synthetic */ void inquiry(List list, dd.c.a aVar);

    App startApp(String str, Bundle bundle, Bundle bundle2);

    @Override // com.cloud.tmc.kernel.node.Node
    /* synthetic */ List usePermissions();
}
