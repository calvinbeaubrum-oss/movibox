package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.transsion.commercialization.InterceptReportProvider;
import com.transsion.commercialization.aha.AhaGameProvider;
import com.transsion.commercialization.dialog.CommonDialogProvider;
import com.transsion.commercialization.gameres.GameResProvider;
import com.transsion.commercialization.pslink.PsLinkProvider;
import com.transsion.commercialization.task.TaskCenterProvider;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$Commercialization implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.PROVIDER;
        map.put("com.transsion.commercializationapi.IAhaGameApi", RouteMeta.build(routeType, AhaGameProvider.class, "/commercialize/AhaGameProvider", "commercialize", null, -1, Integer.MIN_VALUE));
        map.put("com.transsion.commercializationapi.ICommonDialogApi", RouteMeta.build(routeType, CommonDialogProvider.class, "/commercialize/CommonDialogProvider", "commercialize", null, -1, Integer.MIN_VALUE));
        map.put("com.transsion.commercializationapi.IGameResApi", RouteMeta.build(routeType, GameResProvider.class, "/commercialize/GameResTabProvider", "commercialize", null, -1, Integer.MIN_VALUE));
        map.put("com.transsion.commercializationapi.IInterceptReportApi", RouteMeta.build(routeType, InterceptReportProvider.class, "/commercialize/InterceptReportProvider", "commercialize", null, -1, Integer.MIN_VALUE));
        map.put("com.transsion.commercializationapi.IPsLinkApi", RouteMeta.build(routeType, PsLinkProvider.class, "/commercialize/PsLinkProvider", "commercialize", null, -1, Integer.MIN_VALUE));
        map.put("com.transsion.commercializationapi.ITaskCenterApi", RouteMeta.build(routeType, TaskCenterProvider.class, "/commercialize/TaskCenterProvider", "commercialize", null, -1, Integer.MIN_VALUE));
    }
}
