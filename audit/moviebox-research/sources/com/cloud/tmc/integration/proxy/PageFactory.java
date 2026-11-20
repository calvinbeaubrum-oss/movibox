package com.cloud.tmc.integration.proxy;

import android.os.Bundle;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.PageNode;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.integration.defaultImpl.DefaultPageFactoryImpl")
public interface PageFactory {
    PageNode createPage(App app, String str, String str2, Bundle bundle, Bundle bundle2);
}
