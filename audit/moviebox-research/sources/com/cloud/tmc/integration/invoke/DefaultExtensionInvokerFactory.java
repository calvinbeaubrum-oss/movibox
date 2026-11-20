package com.cloud.tmc.integration.invoke;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultExtensionInvokerFactory implements ExtensionInvokerFactory {
    @Override // com.cloud.tmc.integration.invoke.ExtensionInvokerFactory
    public d createPermissionExtensionInvoker(dd.b bVar, d dVar) {
        return new g(bVar, dVar);
    }

    @Override // com.cloud.tmc.integration.invoke.ExtensionInvokerFactory
    public d createScheduleExtensionInvoker(d dVar) {
        return new ScheduleExtensionInvoker(dVar);
    }
}
