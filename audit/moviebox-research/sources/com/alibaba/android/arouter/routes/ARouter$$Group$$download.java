package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.activity.AllHistoricalPlayRecordActivity;
import com.transsnet.downloader.activity.DownloadPanelActivity;
import com.transsnet.downloader.activity.DownloadSeriesListActivity;
import com.transsnet.downloader.activity.TransferActivity;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$download implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/download/panel_activity", RouteMeta.build(routeType, DownloadPanelActivity.class, "/download/panel_activity", DownloadBaseRunnable.TAG, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$download.1
            {
                put("extra_page_index", 3);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/download/play_history", RouteMeta.build(routeType, AllHistoricalPlayRecordActivity.class, "/download/play_history", DownloadBaseRunnable.TAG, null, -1, Integer.MIN_VALUE));
        map.put("/download/provider", RouteMeta.build(RouteType.PROVIDER, DownloadManagerApi.class, "/download/provider", DownloadBaseRunnable.TAG, null, -1, Integer.MIN_VALUE));
        map.put("/download/series_list", RouteMeta.build(routeType, DownloadSeriesListActivity.class, "/download/series_list", DownloadBaseRunnable.TAG, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$download.2
            {
                put("extra_subject_id", 8);
                put("extra_parent_position", 3);
                put("extra_name", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/download/transfer", RouteMeta.build(routeType, TransferActivity.class, "/download/transfer", DownloadBaseRunnable.TAG, null, -1, Integer.MIN_VALUE));
    }
}
