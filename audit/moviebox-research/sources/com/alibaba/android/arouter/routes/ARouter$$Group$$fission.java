package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.fission.FissionInvitationCodeActivity;
import com.transsion.fission.FissionProvider;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$fission implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/fission/invitation_code", RouteMeta.build(RouteType.ACTIVITY, FissionInvitationCodeActivity.class, "/fission/invitation_code", "fission", null, -1, Integer.MIN_VALUE));
        map.put("/fission/provider", RouteMeta.build(RouteType.PROVIDER, FissionProvider.class, "/fission/provider", "fission", null, -1, Integer.MIN_VALUE));
    }
}
