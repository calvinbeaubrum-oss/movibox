package com.cloud.tmc.integration.permission.model;

import com.cloud.tmc.integration.permission.PermissionConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.security.DefaultGroup;
import dd.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TmcGroupInit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30899a = "Tmcintegration:" + TmcGroupInit.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f30900b = false;

    public static void a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b("forExample", "forExample"));
        DefaultGroup.EXTERNAL.assignPermissions(arrayList);
        DefaultGroup.INTERNAL.assignPermissions(arrayList);
        DefaultGroup.PARTNER.assignPermissions(arrayList);
    }

    public static void b() {
        new HashMap();
        Map<String, Map<String, f>> groupPermissionMap = PermissionConfig.getInstance().getGroupPermissionMap();
        DefaultGroup[] defaultGroupArr = {DefaultGroup.INTERNAL, DefaultGroup.PARTNER, DefaultGroup.EXTERNAL};
        for (int i11 = 0; i11 < 3; i11++) {
            defaultGroupArr[i11].clearPermissions();
        }
        for (int i12 = 0; i12 < 3; i12++) {
            DefaultGroup defaultGroup = defaultGroupArr[i12];
            Map<String, f> map = groupPermissionMap.get(defaultGroup.groupName());
            if (map != null && map.values() != null) {
                defaultGroup.assignPermissions(new ArrayList(map.values()));
            }
        }
        for (int i13 = 0; i13 < 3; i13++) {
            DefaultGroup defaultGroup2 = defaultGroupArr[i13];
            TmcLogger.c(f30899a, "DefaultGroup  init result  group=" + defaultGroup2.groupName() + ", permissions=" + defaultGroup2.permissions());
        }
    }

    public static synchronized void init() {
        if (f30900b) {
            return;
        }
        f30900b = true;
        synchronized (TmcGroupInit.class) {
            b();
            a();
        }
    }
}
