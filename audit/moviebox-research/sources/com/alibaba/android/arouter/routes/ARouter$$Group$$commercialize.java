package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.commercialization.InterceptReportProvider;
import com.transsion.commercialization.aha.AhaGameProvider;
import com.transsion.commercialization.dialog.CommonDialogProvider;
import com.transsion.commercialization.gameres.GameResProvider;
import com.transsion.commercialization.pslink.PsLinkProvider;
import com.transsion.commercialization.task.TaskCenterProvider;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$commercialize implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.PROVIDER;
        map.put("/commercialize/AhaGameProvider", RouteMeta.build(routeType, AhaGameProvider.class, "/commercialize/ahagameprovider", "commercialize", null, -1, Integer.MIN_VALUE));
        map.put("/commercialize/CommonDialogProvider", RouteMeta.build(routeType, CommonDialogProvider.class, "/commercialize/commondialogprovider", "commercialize", null, -1, Integer.MIN_VALUE));
        map.put("/commercialize/GameResTabProvider", RouteMeta.build(routeType, GameResProvider.class, "/commercialize/gamerestabprovider", "commercialize", null, -1, Integer.MIN_VALUE));
        map.put("/commercialize/InterceptReportProvider", RouteMeta.build(routeType, InterceptReportProvider.class, "/commercialize/interceptreportprovider", "commercialize", null, -1, Integer.MIN_VALUE));
        map.put("/commercialize/PsLinkProvider", RouteMeta.build(routeType, PsLinkProvider.class, "/commercialize/pslinkprovider", "commercialize", null, -1, Integer.MIN_VALUE));
        map.put("/commercialize/TaskCenterProvider", RouteMeta.build(routeType, TaskCenterProvider.class, "/commercialize/taskcenterprovider", "commercialize", null, -1, Integer.MIN_VALUE));
    }
}
