package com.transsion.web.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;
import com.transsion.web.api.WebConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class WebActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        WebActivity webActivity = (WebActivity) obj;
        webActivity.f60146a = webActivity.getIntent().getExtras() == null ? webActivity.f60146a : webActivity.getIntent().getExtras().getString("url", webActivity.f60146a);
        webActivity.f60147b = webActivity.getIntent().getExtras() == null ? webActivity.f60147b : webActivity.getIntent().getExtras().getString(WebConstants.FIELD_DEEPLINK, webActivity.f60147b);
        webActivity.f60148c = webActivity.getIntent().getBooleanExtra(WebConstants.FIELD_LOAD_URL_ONLY, webActivity.f60148c);
        webActivity.f60149d = webActivity.getIntent().getExtras() == null ? webActivity.f60149d : webActivity.getIntent().getExtras().getString(WebConstants.PAGE_FROM, webActivity.f60149d);
    }
}
