package com.transsion.usercenter.message.detail;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class MessageDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        MessageDetailActivity messageDetailActivity = (MessageDetailActivity) obj;
        messageDetailActivity.f59481a = messageDetailActivity.getIntent().getExtras() == null ? messageDetailActivity.f59481a : messageDetailActivity.getIntent().getExtras().getString("msg_content", messageDetailActivity.f59481a);
        messageDetailActivity.f59482b = messageDetailActivity.getIntent().getExtras() == null ? messageDetailActivity.f59482b : messageDetailActivity.getIntent().getExtras().getString("msg_create_time", messageDetailActivity.f59482b);
        messageDetailActivity.f59483c = messageDetailActivity.getIntent().getExtras() == null ? messageDetailActivity.f59483c : messageDetailActivity.getIntent().getExtras().getString("msg_nickname", messageDetailActivity.f59483c);
    }
}
