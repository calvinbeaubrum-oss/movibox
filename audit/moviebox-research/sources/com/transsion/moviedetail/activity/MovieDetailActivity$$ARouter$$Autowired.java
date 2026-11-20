package com.transsion.moviedetail.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MovieDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        MovieDetailActivity movieDetailActivity = (MovieDetailActivity) obj;
        movieDetailActivity.f53424i = movieDetailActivity.getIntent().getExtras() == null ? movieDetailActivity.f53424i : movieDetailActivity.getIntent().getExtras().getString("id", movieDetailActivity.f53424i);
        movieDetailActivity.f53425j = movieDetailActivity.getIntent().getExtras() == null ? movieDetailActivity.f53425j : movieDetailActivity.getIntent().getExtras().getString("ops", movieDetailActivity.f53425j);
        movieDetailActivity.f53426k = movieDetailActivity.getIntent().getBooleanExtra("autoDownload", movieDetailActivity.f53426k);
        movieDetailActivity.f53427l = movieDetailActivity.getIntent().getBooleanExtra("autoPlay", movieDetailActivity.f53427l);
        movieDetailActivity.f53428m = movieDetailActivity.getIntent().getExtras() == null ? movieDetailActivity.f53428m : movieDetailActivity.getIntent().getExtras().getString("resourceId", movieDetailActivity.f53428m);
        movieDetailActivity.f53429n = movieDetailActivity.getIntent().getExtras() == null ? movieDetailActivity.f53429n : movieDetailActivity.getIntent().getExtras().getString("module_name", movieDetailActivity.f53429n);
        movieDetailActivity.f53430o = movieDetailActivity.getIntent().getIntExtra("yy_preload_id", movieDetailActivity.f53430o);
        movieDetailActivity.f53431p = movieDetailActivity.getIntent().getIntExtra("season", movieDetailActivity.f53431p);
        movieDetailActivity.f53432q = movieDetailActivity.getIntent().getIntExtra("subject_type", movieDetailActivity.f53432q);
    }
}
