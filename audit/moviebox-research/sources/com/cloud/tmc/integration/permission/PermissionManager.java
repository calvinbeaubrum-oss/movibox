package com.cloud.tmc.integration.permission;

import com.cloud.tmc.kernel.bridge.NativeCallContext;
import dd.c;
import dd.d;
import dd.f;
import java.util.List;
import mc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface PermissionManager {
    boolean asyncCheckPermission(f fVar, c cVar, NativeCallContext nativeCallContext, a aVar);

    boolean bizCheckPermission(f fVar, c cVar, NativeCallContext nativeCallContext, a aVar);

    boolean checkPermission(f fVar, c cVar, NativeCallContext nativeCallContext, a aVar);

    void init(c cVar);

    d manageAccessorGroup(c cVar);

    List<f> manageAccessorPermissions(c cVar);
}
