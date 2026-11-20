package com.transsion.home.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MovieFilterActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        MovieFilterActivity movieFilterActivity = (MovieFilterActivity) obj;
        movieFilterActivity.f51984a = movieFilterActivity.getIntent().getIntExtra("tabId", movieFilterActivity.f51984a);
        movieFilterActivity.f51985b = movieFilterActivity.getIntent().getBooleanExtra("showViewPager", movieFilterActivity.f51985b);
        movieFilterActivity.f51986c = movieFilterActivity.getIntent().getExtras() == null ? movieFilterActivity.f51986c : movieFilterActivity.getIntent().getExtras().getString("tabCode", movieFilterActivity.f51986c);
        movieFilterActivity.f51987d = movieFilterActivity.getIntent().getExtras() == null ? movieFilterActivity.f51987d : movieFilterActivity.getIntent().getExtras().getString("filterType", movieFilterActivity.f51987d);
    }
}
