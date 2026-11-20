package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.transsion.moviedetail.provider.MovieDetailServiceImpl;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$MovieDetail implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.transsion.moviedetailapi.IMovieDetailService", RouteMeta.build(RouteType.PROVIDER, MovieDetailServiceImpl.class, "/movie/details", "movie", null, -1, Integer.MIN_VALUE));
    }
}
