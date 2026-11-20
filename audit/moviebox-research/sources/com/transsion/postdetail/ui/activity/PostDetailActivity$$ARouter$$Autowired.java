package com.transsion.postdetail.ui.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.web.api.WebConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class PostDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        PostDetailActivity postDetailActivity = (PostDetailActivity) obj;
        postDetailActivity.f55538i = postDetailActivity.getIntent().getExtras() == null ? postDetailActivity.f55538i : postDetailActivity.getIntent().getExtras().getString("media_type", postDetailActivity.f55538i);
        postDetailActivity.f55539j = postDetailActivity.getIntent().getExtras() == null ? postDetailActivity.f55539j : postDetailActivity.getIntent().getExtras().getString("id", postDetailActivity.f55539j);
        postDetailActivity.f55540k = postDetailActivity.getIntent().getExtras() == null ? postDetailActivity.f55540k : postDetailActivity.getIntent().getExtras().getString("item_type", postDetailActivity.f55540k);
        postDetailActivity.f55541l = postDetailActivity.getIntent().getBooleanExtra("from_comment", postDetailActivity.f55541l);
        postDetailActivity.f55542m = postDetailActivity.getIntent().getExtras() == null ? postDetailActivity.f55542m : postDetailActivity.getIntent().getExtras().getString("rec_ops", postDetailActivity.f55542m);
        postDetailActivity.f55543n = postDetailActivity.getIntent().getIntExtra("tab_id", postDetailActivity.f55543n);
        postDetailActivity.f55544o = postDetailActivity.getIntent().getBooleanExtra("video_load_more", postDetailActivity.f55544o);
        postDetailActivity.f55545p = postDetailActivity.getIntent().getExtras() == null ? postDetailActivity.f55545p : postDetailActivity.getIntent().getExtras().getString(WebConstants.PAGE_FROM, postDetailActivity.f55545p);
        postDetailActivity.f55546q = (PostSubjectItem) postDetailActivity.getIntent().getSerializableExtra("item_object");
        postDetailActivity.f55547r = postDetailActivity.getIntent().getExtras() == null ? postDetailActivity.f55547r : postDetailActivity.getIntent().getExtras().getString("comment_id", postDetailActivity.f55547r);
        postDetailActivity.f55548s = postDetailActivity.getIntent().getBooleanExtra("need_back_to_room", postDetailActivity.f55548s);
    }
}
