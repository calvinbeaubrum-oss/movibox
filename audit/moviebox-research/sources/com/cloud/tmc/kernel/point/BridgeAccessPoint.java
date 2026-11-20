package com.cloud.tmc.kernel.point;

import com.cloud.tmc.kernel.bridge.NativeCallContext;
import dd.d;
import dd.e;
import dd.f;
import java.util.List;
import mc.a;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.integration.invoke.extension.BridgeAccessExtension")
public interface BridgeAccessPoint extends com.cloud.tmc.kernel.extension.c {
    boolean asyncCheckPermission(f fVar, dd.c cVar, NativeCallContext nativeCallContext, a aVar);

    boolean bizCheckPermission(f fVar, dd.c cVar, NativeCallContext nativeCallContext, a aVar);

    boolean checkPermission(f fVar, dd.c cVar, NativeCallContext nativeCallContext, a aVar);

    d manageAccessorGroup(dd.c cVar);

    List<f> manageAccessorPermissions(dd.c cVar);

    boolean needPermissionCheck(dd.c cVar, List<? extends e> list);

    @Override // com.cloud.tmc.kernel.extension.c
    /* synthetic */ void onFinalized();

    @Override // com.cloud.tmc.kernel.extension.c
    /* synthetic */ void onInitialized();
}
