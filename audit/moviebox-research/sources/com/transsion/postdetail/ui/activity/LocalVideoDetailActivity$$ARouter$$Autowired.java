package com.transsion.postdetail.ui.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class LocalVideoDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        LocalVideoDetailActivity localVideoDetailActivity = (LocalVideoDetailActivity) obj;
        localVideoDetailActivity.f55522a = localVideoDetailActivity.getIntent().getExtras() == null ? localVideoDetailActivity.f55522a : localVideoDetailActivity.getIntent().getExtras().getString("extra_local_path", localVideoDetailActivity.f55522a);
        localVideoDetailActivity.f55523b = localVideoDetailActivity.getIntent().getExtras() == null ? localVideoDetailActivity.f55523b : localVideoDetailActivity.getIntent().getExtras().getString("extra_url", localVideoDetailActivity.f55523b);
        localVideoDetailActivity.f55524c = localVideoDetailActivity.getIntent().getExtras() == null ? localVideoDetailActivity.f55524c : localVideoDetailActivity.getIntent().getExtras().getString("extra_proxy_url", localVideoDetailActivity.f55524c);
        localVideoDetailActivity.f55525d = localVideoDetailActivity.getIntent().getExtras() == null ? localVideoDetailActivity.f55525d : localVideoDetailActivity.getIntent().getExtras().getString("extra_name", localVideoDetailActivity.f55525d);
        localVideoDetailActivity.f55526f = localVideoDetailActivity.getIntent().getExtras() == null ? localVideoDetailActivity.f55526f : localVideoDetailActivity.getIntent().getExtras().getString("extra_resource_id", localVideoDetailActivity.f55526f);
        localVideoDetailActivity.f55527g = localVideoDetailActivity.getIntent().getExtras() == null ? localVideoDetailActivity.f55527g : localVideoDetailActivity.getIntent().getExtras().getString("extra_post_id", localVideoDetailActivity.f55527g);
        localVideoDetailActivity.f55528h = localVideoDetailActivity.getIntent().getExtras() == null ? localVideoDetailActivity.f55528h : localVideoDetailActivity.getIntent().getExtras().getString("extra_subject_id", localVideoDetailActivity.f55528h);
        localVideoDetailActivity.f55529i = Boolean.valueOf(localVideoDetailActivity.getIntent().getBooleanExtra("extra_completed", localVideoDetailActivity.f55529i.booleanValue()));
        localVideoDetailActivity.f55530j = Boolean.valueOf(localVideoDetailActivity.getIntent().getBooleanExtra("extra_is_series", localVideoDetailActivity.f55530j.booleanValue()));
        localVideoDetailActivity.f55531k = localVideoDetailActivity.getIntent().getExtras() == null ? localVideoDetailActivity.f55531k : localVideoDetailActivity.getIntent().getExtras().getString("extra_page_from", localVideoDetailActivity.f55531k);
        localVideoDetailActivity.f55532l = Integer.valueOf(localVideoDetailActivity.getIntent().getIntExtra("extra_height", localVideoDetailActivity.f55532l.intValue()));
        localVideoDetailActivity.f55533m = Integer.valueOf(localVideoDetailActivity.getIntent().getIntExtra("extra_width", localVideoDetailActivity.f55533m.intValue()));
        localVideoDetailActivity.f55534n = Integer.valueOf(localVideoDetailActivity.getIntent().getIntExtra("extra_parent_position", localVideoDetailActivity.f55534n.intValue()));
        localVideoDetailActivity.f55535o = Integer.valueOf(localVideoDetailActivity.getIntent().getIntExtra("extra_position", localVideoDetailActivity.f55535o.intValue()));
    }
}
