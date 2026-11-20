package com.transsion.postdetail.ui.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.web.api.WebConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class PostDetailVideoActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        PostDetailVideoActivity postDetailVideoActivity = (PostDetailVideoActivity) obj;
        postDetailVideoActivity.f55555i = postDetailVideoActivity.getIntent().getExtras() == null ? postDetailVideoActivity.f55555i : postDetailVideoActivity.getIntent().getExtras().getString("media_type", postDetailVideoActivity.f55555i);
        postDetailVideoActivity.f55556j = postDetailVideoActivity.getIntent().getExtras() == null ? postDetailVideoActivity.f55556j : postDetailVideoActivity.getIntent().getExtras().getString("id", postDetailVideoActivity.f55556j);
        postDetailVideoActivity.f55557k = postDetailVideoActivity.getIntent().getExtras() == null ? postDetailVideoActivity.f55557k : postDetailVideoActivity.getIntent().getExtras().getString("item_type", postDetailVideoActivity.f55557k);
        postDetailVideoActivity.f55558l = postDetailVideoActivity.getIntent().getBooleanExtra("from_comment", postDetailVideoActivity.f55558l);
        postDetailVideoActivity.f55559m = postDetailVideoActivity.getIntent().getExtras() == null ? postDetailVideoActivity.f55559m : postDetailVideoActivity.getIntent().getExtras().getString("rec_ops", postDetailVideoActivity.f55559m);
        postDetailVideoActivity.f55560n = postDetailVideoActivity.getIntent().getIntExtra("tab_id", postDetailVideoActivity.f55560n);
        postDetailVideoActivity.f55561o = postDetailVideoActivity.getIntent().getBooleanExtra("video_load_more", postDetailVideoActivity.f55561o);
        postDetailVideoActivity.f55562p = postDetailVideoActivity.getIntent().getExtras() == null ? postDetailVideoActivity.f55562p : postDetailVideoActivity.getIntent().getExtras().getString(WebConstants.PAGE_FROM, postDetailVideoActivity.f55562p);
        postDetailVideoActivity.f55563q = (PostSubjectItem) postDetailVideoActivity.getIntent().getSerializableExtra("item_object");
        postDetailVideoActivity.f55564r = postDetailVideoActivity.getIntent().getBooleanExtra("is_build_in", postDetailVideoActivity.f55564r);
    }
}
