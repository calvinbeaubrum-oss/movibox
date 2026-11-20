package com.transsion.home.category;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class CategoryActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        CategoryActivity categoryActivity = (CategoryActivity) obj;
        categoryActivity.f52334a = categoryActivity.getIntent().getExtras() == null ? categoryActivity.f52334a : categoryActivity.getIntent().getExtras().getString("categoryType", categoryActivity.f52334a);
        categoryActivity.f52335b = categoryActivity.getIntent().getExtras() == null ? categoryActivity.f52335b : categoryActivity.getIntent().getExtras().getString("showType", categoryActivity.f52335b);
    }
}
