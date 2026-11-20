package com.transsion.usercenter.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.report.h;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$mipmap;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.message.bean.MessageEntity;
import com.transsion.usercenter.message.model.PagerEntity;
import com.transsion.usercenter.message.model.ResponseMessage;
import com.transsion.usercenter.message.model.UserMessageFragmentViewModel;
import com.transsion.usercenter.profile.NoticeMessageViewModel;
import com.transsion.usercenter.profile.ProfileActivity;
import com.transsion.usercenter.profile.bean.ProfileNewMessage;
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
public final class UserMessageFragment extends BaseListFragment<MessageEntity> {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f59454y = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f59455p = LazyKt__LazyJVMKt.b(new Function0<UserMessageFragmentViewModel>() { // from class: com.transsion.usercenter.message.UserMessageFragment$mViewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserMessageFragmentViewModel invoke() {
            return (UserMessageFragmentViewModel) new v0(this.this$0).a(UserMessageFragmentViewModel.class);
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f59456q = LazyKt__LazyJVMKt.b(new Function0<NoticeMessageViewModel>() { // from class: com.transsion.usercenter.message.UserMessageFragment$noticeViewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NoticeMessageViewModel invoke() {
            return (NoticeMessageViewModel) new v0(this.this$0).a(NoticeMessageViewModel.class);
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f59457r = "ALL";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f59458s = "1";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f59459t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinearLayoutCompat f59460u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LinearLayoutCompat f59461v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AppCompatTextView f59462w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AppCompatTextView f59463x;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UserMessageFragment a() {
            return new UserMessageFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59464a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59464a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59464a;
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
            this.f59464a.invoke(obj);
        }
    }

    public static final void E1(UserMessageFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        MessageEntity item;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item2 = adapter.getItem(i11);
        Intrinsics.e(item2, "null cannot be cast to non-null type com.transsion.usercenter.message.bean.MessageEntity");
        MessageEntity messageEntity = (MessageEntity) item2;
        int id2 = view.getId();
        if (id2 != R$id.rlLayout) {
            if (!(id2 == R$id.imAvatar || id2 == R$id.tvNickName) || Intrinsics.b(messageEntity.getType(), "SYSTEM")) {
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
        } else {
            com.alibaba.android.arouter.launcher.a.d().b("/post/detail").withString("id", item.getTopicId()).withString(WebConstants.PAGE_FROM, "system_message").withBoolean("video_load_more", false).navigation();
        }
    }

    public static final void G1(UserMessageFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.alibaba.android.arouter.launcher.a.d().b("/profile/user_room_message").withString("msgType", "like").navigation();
        AppCompatTextView appCompatTextView = this$0.f59462w;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(this$0.getString(R$string.profile_like));
    }

    public static final void H1(UserMessageFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.alibaba.android.arouter.launcher.a.d().b("/profile/user_room_message").withString("msgType", "comment").navigation();
        AppCompatTextView appCompatTextView = this$0.f59463x;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(this$0.getString(com.transsion.baseui.R$string.name_comments));
    }

    public final UserMessageFragmentViewModel C1() {
        return (UserMessageFragmentViewModel) this.f59455p.getValue();
    }

    public final NoticeMessageViewModel D1() {
        return (NoticeMessageViewModel) this.f59456q.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        i1();
    }

    public final void F1() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.user_message_header_layout, (ViewGroup) null);
        this.f59459t = viewInflate;
        this.f59460u = viewInflate != null ? (LinearLayoutCompat) viewInflate.findViewById(R$id.ll_like) : null;
        View view = this.f59459t;
        this.f59461v = view != null ? (LinearLayoutCompat) view.findViewById(R$id.ll_comment) : null;
        View view2 = this.f59459t;
        this.f59462w = view2 != null ? (AppCompatTextView) view2.findViewById(R$id.tv_like) : null;
        View view3 = this.f59459t;
        this.f59463x = view3 != null ? (AppCompatTextView) view3.findViewById(R$id.tv_comment) : null;
        LinearLayoutCompat linearLayoutCompat = this.f59460u;
        if (linearLayoutCompat != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.message.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    UserMessageFragment.G1(this.f59479a, view4);
                }
            });
        }
        LinearLayoutCompat linearLayoutCompat2 = this.f59461v;
        if (linearLayoutCompat2 != null) {
            linearLayoutCompat2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.message.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    UserMessageFragment.H1(this.f59480a, view4);
                }
            });
        }
        if (this.f59459t != null) {
            BaseQuickAdapter<MessageEntity, BaseViewHolder> baseQuickAdapterW0 = W0();
            if (baseQuickAdapterW0 != null) {
                View view4 = this.f59459t;
                Intrinsics.d(view4);
                BaseQuickAdapter.u0(baseQuickAdapterW0, view4, 0, 0, 6, null);
            }
            BaseQuickAdapter<MessageEntity, BaseViewHolder> baseQuickAdapterW1 = W0();
            if (baseQuickAdapterW1 == null) {
                return;
            }
            baseQuickAdapterW1.v0(true);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter<MessageEntity, BaseViewHolder> T0() {
        return new dz.a(0, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        String string = getString(R$string.messages_title_name);
        Intrinsics.f(string, "getString(R.string.messages_title_name)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        if (Intrinsics.b(this.f59458s, "1")) {
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
            baseQuickAdapterW0.i(R$id.rlLayout, R$id.imAvatar, R$id.tvNickName);
        }
        BaseQuickAdapter<MessageEntity, BaseViewHolder> baseQuickAdapterW1 = W0();
        if (baseQuickAdapterW1 != null) {
            baseQuickAdapterW1.z0(new f9.b() { // from class: com.transsion.usercenter.message.e
                @Override // f9.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    UserMessageFragment.E1(this.f59484a, baseQuickAdapter, view, i11);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        C1().b().j(this, new b(new Function1<ResponseMessage, Unit>() { // from class: com.transsion.usercenter.message.UserMessageFragment.initViewModel.1
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
                    UserMessageFragment userMessageFragment = UserMessageFragment.this;
                    if (pager.getHasMore()) {
                        userMessageFragment.f59458s = pager.getNextPage();
                        userMessageFragment.j1();
                    } else {
                        BaseListFragment.l1(userMessageFragment, false, 1, null);
                    }
                }
                if (responseMessage == null || (list = responseMessage.getList()) == null) {
                    UserMessageFragment.this.v1();
                    return;
                }
                UserMessageFragment userMessageFragment2 = UserMessageFragment.this;
                if (!userMessageFragment2.h1()) {
                    BaseQuickAdapter<MessageEntity, BaseViewHolder> baseQuickAdapterW0 = userMessageFragment2.W0();
                    if (baseQuickAdapterW0 != null) {
                        baseQuickAdapterW0.m(list);
                        return;
                    }
                    return;
                }
                userMessageFragment2.q1(false);
                if (list.isEmpty()) {
                    BaseListFragment.s1(userMessageFragment2, null, 1, null);
                    return;
                }
                BaseQuickAdapter<MessageEntity, BaseViewHolder> baseQuickAdapterW1 = userMessageFragment2.W0();
                if (baseQuickAdapterW1 != null) {
                    baseQuickAdapterW1.w0(list);
                }
            }
        }));
        D1().f().j(this, new b(new Function1<ProfileNewMessage, Unit>() { // from class: com.transsion.usercenter.message.UserMessageFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileNewMessage profileNewMessage) {
                invoke2(profileNewMessage);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileNewMessage profileNewMessage) {
                TitleLayout titleLayout;
                TnTextView titleView;
                AppCompatTextView appCompatTextView;
                AppCompatTextView appCompatTextView2;
                if (profileNewMessage != null) {
                    UserMessageFragment userMessageFragment = UserMessageFragment.this;
                    if (profileNewMessage.getLikeCnt() > 0 && (appCompatTextView2 = userMessageFragment.f59462w) != null) {
                        appCompatTextView2.setText(userMessageFragment.getString(R$string.profile_like) + "(" + (profileNewMessage.getLikeCnt() < 99 ? String.valueOf(profileNewMessage.getLikeCnt()) : "99+") + ")");
                    }
                    if (profileNewMessage.getCommentCnt() > 0 && (appCompatTextView = userMessageFragment.f59463x) != null) {
                        appCompatTextView.setText(userMessageFragment.getString(com.transsion.baseui.R$string.name_comments) + "(" + (profileNewMessage.getCommentCnt() < 99 ? String.valueOf(profileNewMessage.getCommentCnt()) : "99+") + ")");
                    }
                    fs.a aVar = (fs.a) userMessageFragment.getMViewBinding();
                    if (aVar == null || (titleLayout = aVar.f65252f) == null || (titleView = titleLayout.getTitleView()) == null) {
                        return;
                    }
                    if (profileNewMessage.getSystemCnt() + profileNewMessage.getLikeCnt() + profileNewMessage.getCommentCnt() <= 0) {
                        titleView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    } else {
                        titleView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$mipmap.user_message_icon_new, 0);
                        titleView.setCompoundDrawablePadding(8);
                    }
                }
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        if (Intrinsics.b(this.f59458s, "1")) {
            D1().c();
        }
        C1().d(this.f59458s, UserMessageType.SYSTEM.getValue());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public h newLogViewConfig() {
        return new h("system_message", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
        q1(true);
        this.f59458s = "1";
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        String string = getString(R$string.messages_title_name);
        Intrinsics.f(string, "getString(R.string.messages_title_name)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        F1();
        BaseListFragment.s1(this, null, 1, null);
        q1(true);
    }
}
