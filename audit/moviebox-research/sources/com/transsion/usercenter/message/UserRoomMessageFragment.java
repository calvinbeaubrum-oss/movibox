package com.transsion.usercenter.message;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.d0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.message.bean.MessageEntity;
import com.transsion.usercenter.message.model.PagerEntity;
import com.transsion.usercenter.message.model.ResponseMessage;
import com.transsion.usercenter.message.model.UserMessageFragmentViewModel;
import com.transsion.usercenter.profile.ProfileActivity;
import com.transsion.web.api.WebConstants;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class UserRoomMessageFragment extends BaseListFragment<MessageEntity> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f59466t = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f59467p = LazyKt__LazyJVMKt.b(new Function0<UserMessageFragmentViewModel>() { // from class: com.transsion.usercenter.message.UserRoomMessageFragment$mViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserMessageFragmentViewModel invoke() {
            return new UserMessageFragmentViewModel();
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f59468q = "ALL";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f59469r = "1";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f59470s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UserRoomMessageFragment a(String str) {
            UserRoomMessageFragment userRoomMessageFragment = new UserRoomMessageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("msgType", str);
            userRoomMessageFragment.setArguments(bundle);
            return userRoomMessageFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59471a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59471a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59471a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59471a.invoke(obj);
        }
    }

    private final String getPageName() {
        String str = this.f59470s;
        return (!Intrinsics.b(str, "like") && Intrinsics.b(str, "comment")) ? "comment_message" : "like_message";
    }

    private final UserMessageFragmentViewModel y1() {
        return (UserMessageFragmentViewModel) this.f59467p.getValue();
    }

    public static final void z1(UserRoomMessageFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        MessageEntity item;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item2 = adapter.getItem(i11);
        Intrinsics.e(item2, "null cannot be cast to non-null type com.transsion.usercenter.message.bean.MessageEntity");
        MessageEntity messageEntity = (MessageEntity) item2;
        int id2 = view.getId();
        if (id2 != R$id.clLayout) {
            if (id2 != R$id.iv_avatar || Intrinsics.b(messageEntity.getType(), "SYSTEM")) {
                return;
            }
            ProfileActivity.f59512l.b(messageEntity.getSendUid());
            return;
        }
        BaseQuickAdapter<MessageEntity, BaseViewHolder> baseQuickAdapterW0 = this$0.W0();
        if (baseQuickAdapterW0 == null || (item = baseQuickAdapterW0.getItem(i11)) == null) {
            return;
        }
        if (Intrinsics.b(messageEntity.getType(), "SYSTEM")) {
            com.alibaba.android.arouter.launcher.a.d().b("/profile/message_detail").withString("msg_content", item.getContent()).withString("msg_nickname", item.getNickname()).withString("msg_create_time", item.getCreatedAt()).navigation();
            return;
        }
        boolean z11 = item.getCommentId().length() == 0;
        if (item.getCommentId().length() <= 0 || !Intrinsics.b(item.getCommentStatus(), "DELETED")) {
            com.alibaba.android.arouter.launcher.a.d().b("/post/detail").withString("id", item.getTopicId()).withString(WebConstants.PAGE_FROM, "system_message").withString("comment_id", item.getCommentId()).withBoolean("video_load_more", false).withBoolean("from_comment", z11).navigation();
        } else {
            h.f50034a.l(this$0.getString(R$string.comment_deleted_tips));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        String string;
        super.D0();
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("msgType")) == null) {
            string = "like";
        }
        this.f59470s = string;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        i1();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter<MessageEntity, BaseViewHolder> T0() {
        return new dz.b(0, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        return Intrinsics.b(this.f59470s, "like") ? "Likes" : "Comments";
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        if (Intrinsics.b(this.f59469r, "1")) {
            BaseListFragment.l1(this, false, 1, null);
        } else {
            lazyLoadData();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        super.initListener();
        BaseQuickAdapter<MessageEntity, BaseViewHolder> baseQuickAdapterW0 = W0();
        if (baseQuickAdapterW0 != null) {
            baseQuickAdapterW0.i(R$id.clLayout, R$id.iv_avatar);
        }
        BaseQuickAdapter<MessageEntity, BaseViewHolder> baseQuickAdapterW1 = W0();
        if (baseQuickAdapterW1 != null) {
            baseQuickAdapterW1.z0(new f9.b() { // from class: com.transsion.usercenter.message.f
                @Override // f9.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    UserRoomMessageFragment.z1(this.f59485a, baseQuickAdapter, view, i11);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        y1().b().j(this, new b(new Function1<ResponseMessage, Unit>() { // from class: com.transsion.usercenter.message.UserRoomMessageFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResponseMessage responseMessage) {
                invoke2(responseMessage);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ResponseMessage responseMessage) {
                List<MessageEntity> list;
                PagerEntity pager;
                if (responseMessage != null && (pager = responseMessage.getPager()) != null) {
                    UserRoomMessageFragment userRoomMessageFragment = UserRoomMessageFragment.this;
                    if (pager.getHasMore()) {
                        userRoomMessageFragment.f59469r = pager.getNextPage();
                        userRoomMessageFragment.j1();
                    } else {
                        BaseListFragment.l1(userRoomMessageFragment, false, 1, null);
                    }
                }
                if (responseMessage == null || (list = responseMessage.getList()) == null) {
                    UserRoomMessageFragment.this.v1();
                    return;
                }
                UserRoomMessageFragment userRoomMessageFragment2 = UserRoomMessageFragment.this;
                if (!userRoomMessageFragment2.h1()) {
                    BaseQuickAdapter<MessageEntity, BaseViewHolder> baseQuickAdapterW0 = userRoomMessageFragment2.W0();
                    if (baseQuickAdapterW0 != null) {
                        baseQuickAdapterW0.m(list);
                        return;
                    }
                    return;
                }
                userRoomMessageFragment2.q1(false);
                if (list.isEmpty()) {
                    BaseListFragment.s1(userRoomMessageFragment2, null, 1, null);
                    return;
                }
                BaseQuickAdapter<MessageEntity, BaseViewHolder> baseQuickAdapterW1 = userRoomMessageFragment2.W0();
                if (baseQuickAdapterW1 != null) {
                    baseQuickAdapterW1.w0(list);
                }
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        y1().d(this.f59469r, (Intrinsics.b(this.f59470s, "like") ? UserMessageType.LIKE : UserMessageType.COMMENT).getValue());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
        q1(true);
        this.f59469r = "1";
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        String string = getString(R$string.user_messaeg_title);
        Intrinsics.f(string, "getString(R.string.user_messaeg_title)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        BaseListFragment.s1(this, null, 1, null);
        q1(true);
    }
}
