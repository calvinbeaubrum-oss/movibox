package com.transsion.home.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class FilterActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        FilterActivity filterActivity = (FilterActivity) obj;
        filterActivity.f51981a = filterActivity.getIntent().getIntExtra("tabId", filterActivity.f51981a);
        filterActivity.f51982b = filterActivity.getIntent().getExtras() == null ? filterActivity.f51982b : filterActivity.getIntent().getExtras().getString("tabCode", filterActivity.f51982b);
        filterActivity.f51983c = filterActivity.getIntent().getExtras() == null ? filterActivity.f51983c : filterActivity.getIntent().getExtras().getString("filterType", filterActivity.f51983c);
    }
}
