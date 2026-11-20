package com.transsion.postdetail.shorttv;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.transsion.moviedetailapi.bean.Subject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class ShortTvListActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        ShortTvListActivity shortTvListActivity = (ShortTvListActivity) obj;
        shortTvListActivity.f55359a = shortTvListActivity.getIntent().getIntExtra("ep", shortTvListActivity.f55359a);
        shortTvListActivity.f55360b = shortTvListActivity.getIntent().getLongExtra("ms", shortTvListActivity.f55360b);
        shortTvListActivity.f55361c = shortTvListActivity.getIntent().getBooleanExtra("historyFist", shortTvListActivity.f55361c);
        shortTvListActivity.f55362d = (Subject) shortTvListActivity.getIntent().getSerializableExtra("item_object");
        shortTvListActivity.f55363f = shortTvListActivity.getIntent().getExtras() == null ? shortTvListActivity.f55363f : shortTvListActivity.getIntent().getExtras().getString("id", shortTvListActivity.f55363f);
    }
}
