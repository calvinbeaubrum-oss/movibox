package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.android.arouter.facade.Postcard;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
@Metadata
public final class PostDetailHeaderView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f56038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintLayout f56039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintLayout f56040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatTextView f56041d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatTextView f56042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AppCompatTextView f56043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppCompatTextView f56044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ShapeableImageView f56045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PostSubjectItem f56046j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostDetailHeaderView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostDetailHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostDetailHeaderView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.view_post_detail_header_layout, this);
        g();
        c();
    }

    private final void c() {
        ConstraintLayout constraintLayout = this.f56039b;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailHeaderView.e(this.f56164a, view);
                }
            });
        }
        ConstraintLayout constraintLayout2 = this.f56040c;
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailHeaderView.f(this.f56165a, view);
                }
            });
        }
    }

    public static final void e(PostDetailHeaderView this$0, View view) {
        User user;
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center");
        PostSubjectItem postSubjectItem = this$0.f56046j;
        postcardB.withString("userId", (postSubjectItem == null || (user = postSubjectItem.getUser()) == null) ? null : user.getUserId()).navigation();
        com.transsion.postdetail.helper.a.d(com.transsion.postdetail.helper.a.f55063a, this$0.f56046j, null, null, 6, null);
    }

    public static final void f(PostDetailHeaderView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f56038a;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void g() {
        this.f56045i = (ShapeableImageView) findViewById(R$id.ivAvatar);
        this.f56044h = (AppCompatTextView) findViewById(R$id.tvName);
        this.f56043g = (AppCompatTextView) findViewById(R$id.tvPostTime);
        this.f56042f = (AppCompatTextView) findViewById(R$id.tvTip);
        this.f56041d = (AppCompatTextView) findViewById(R$id.tvSubject);
        this.f56040c = (ConstraintLayout) findViewById(R$id.llSubject);
        this.f56039b = (ConstraintLayout) findViewById(R$id.llHeaderRootView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showData$default(PostDetailHeaderView postDetailHeaderView, PostSubjectItem postSubjectItem, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        postDetailHeaderView.showData(postSubjectItem, function0);
    }

    public final void showData(PostSubjectItem postSubjectItem, Function0<Unit> function0) {
        String avatar;
        Intrinsics.g(postSubjectItem, "postSubjectItem");
        this.f56046j = postSubjectItem;
        this.f56038a = function0;
        AppCompatTextView appCompatTextView = this.f56044h;
        if (appCompatTextView != null) {
            User user = postSubjectItem.getUser();
            appCompatTextView.setText(user != null ? user.getNickname() : null);
        }
        ShapeableImageView shapeableImageView = this.f56045i;
        if (shapeableImageView != null) {
            int iA = com.blankj.utilcode.util.f0.a(32.0f);
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView.getContext();
            Intrinsics.f(context, "context");
            User user2 = postSubjectItem.getUser();
            if (user2 == null || (avatar = user2.getAvatar()) == null) {
                avatar = "";
            }
            companion.r(context, shapeableImageView, avatar, (4088 & 8) != 0 ? companion.d() : iA, (4088 & 16) != 0 ? companion.c() : iA, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        AppCompatTextView appCompatTextView2 = this.f56043g;
        if (appCompatTextView2 != null) {
            if (postSubjectItem.getCreatedAt() == null) {
                so.c.g(appCompatTextView2);
            } else {
                so.c.k(appCompatTextView2);
                String createdAt = postSubjectItem.getCreatedAt();
                appCompatTextView2.setText(com.transsion.postdetail.util.i.a(createdAt != null ? Long.parseLong(createdAt) : 0L));
            }
        }
        if (postSubjectItem.getGroup() == null) {
            ConstraintLayout constraintLayout = this.f56040c;
            if (constraintLayout != null) {
                so.c.g(constraintLayout);
            }
            AppCompatTextView appCompatTextView3 = this.f56042f;
            if (appCompatTextView3 != null) {
                so.c.g(appCompatTextView3);
                return;
            }
            return;
        }
        ConstraintLayout constraintLayout2 = this.f56040c;
        if (constraintLayout2 != null) {
            so.c.k(constraintLayout2);
        }
        AppCompatTextView appCompatTextView4 = this.f56042f;
        if (appCompatTextView4 != null) {
            so.c.k(appCompatTextView4);
        }
        AppCompatTextView appCompatTextView5 = this.f56041d;
        if (appCompatTextView5 == null) {
            return;
        }
        Group group = postSubjectItem.getGroup();
        appCompatTextView5.setText(group != null ? group.getName() : null);
    }
}
