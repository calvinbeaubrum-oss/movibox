package com.transsion.usercenter.edit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.KeyboardUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.publish.api.IPublishApi;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.edit.api.RequstUserEntity;
import com.transsion.usercenter.edit.dialog.EditNameDialog;
import com.transsion.usercenter.edit.widget.ProfileEditBar;
import com.transsnet.loginapi.bean.UserInfo;
import io.reactivex.rxjava3.core.o;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import xy.d0;

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
@SourceDebugExtension
public final class ProfileEditCenterFragment extends BaseFragment<d0> implements com.transsion.usercenter.edit.b, bz.b.a, EditNameDialog.a, TRDialogListener {
    public static final a Companion = new a(null);
    private EditNameDialog editDialog;
    private int editType;
    private boolean isChangeAvatar;
    private boolean isClearBirthday;
    private boolean isClearGender;
    private boolean isClearRegion;
    private b1.b<Intent> photoLaunch;
    private az.b presenter;
    private long respDuration;
    private boolean retry;
    private com.bigkoo.pickerview.view.a timePickerView;
    private UserInfo userEntity;
    private final int EDIT_AVATAR = 1;
    private final int EDIT_NAME = 2;
    private final int EDIT_GENDER = 3;
    private final int EDIT_REGION = 4;
    private final int EDIT_BIRTHDAY = 5;
    private String editText = "";
    private String oldNickName = "";
    private String oldGender = "";
    private String oldBirth = "";
    private String avatarUrl = "";
    private String bucket = "";
    private String cropImage = "";
    private final Lazy publishApi$delegate = LazyKt__LazyJVMKt.b(new Function0<IPublishApi>() { // from class: com.transsion.usercenter.edit.ProfileEditCenterFragment$publishApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IPublishApi invoke() {
            return (IPublishApi) com.alibaba.android.arouter.launcher.a.d().h(IPublishApi.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileEditCenterFragment a(UserInfo userInfo) {
            ProfileEditCenterFragment profileEditCenterFragment = new ProfileEditCenterFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("user", userInfo);
            profileEditCenterFragment.setArguments(bundle);
            return profileEditCenterFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements o<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<h10.b> f59301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProfileEditCenterFragment f59302b;

        public b(Ref.ObjectRef<h10.b> objectRef, ProfileEditCenterFragment profileEditCenterFragment) {
            this.f59301a = objectRef;
            this.f59302b = profileEditCenterFragment;
        }

        @Override // io.reactivex.rxjava3.core.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Bitmap file) {
            ShapeableImageView shapeableImageView;
            Intrinsics.g(file, "file");
            d0 mViewBinding = this.f59302b.getMViewBinding();
            if (mViewBinding == null || (shapeableImageView = mViewBinding.f80771l) == null) {
                return;
            }
            shapeableImageView.setImageBitmap(file);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable e11) {
            Intrinsics.g(e11, "e");
            uo.b.a.f(uo.b.f78622a, "localAvatar", "onError e:" + e11, false, 4, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b d11) {
            Intrinsics.g(d11, "d");
            this.f59301a.element = d11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.transsion.usercenter.edit.a<String> {
        public c() {
        }

        @Override // com.transsion.usercenter.edit.a
        public void a(String str, String str2) {
            zp.b.f82110a.d(R$string.profile_saved_fail_retry);
            ProfileEditCenterFragment.this.hideRequestLoading();
        }

        @Override // com.transsion.usercenter.edit.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(String str, boolean z11, String bucket) {
            Intrinsics.g(bucket, "bucket");
            if (str != null) {
                ProfileEditCenterFragment.this.retry = false;
                ProfileEditCenterFragment profileEditCenterFragment = ProfileEditCenterFragment.this;
                profileEditCenterFragment.onAvatarUrl(str, profileEditCenterFragment.cropImage, bucket);
            }
        }
    }

    /* JADX INFO: renamed from: com.transsion.usercenter.edit.ProfileEditCenterFragment$hideRequestLoading$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.usercenter.edit.ProfileEditCenterFragment$hideRequestLoading$1", f = "ProfileEditCenterFragment.kt", l = {TTAdConstant.IMAGE_URL_CODE}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.transsion.usercenter.edit.ProfileEditCenterFragment$hideRequestLoading$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.usercenter.edit.ProfileEditCenterFragment$hideRequestLoading$1$1", f = "ProfileEditCenterFragment.kt", l = {}, m = "invokeSuspend")
        public static final class C06101 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ProfileEditCenterFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C06101(ProfileEditCenterFragment profileEditCenterFragment, Continuation<? super C06101> continuation) {
                super(2, continuation);
                this.this$0 = profileEditCenterFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C06101(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((C06101) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                ProgressBar progressBar;
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                d0 mViewBinding = this.this$0.getMViewBinding();
                if (mViewBinding != null && (progressBar = mViewBinding.f80766g) != null) {
                    so.c.g(progressBar);
                }
                return Unit.f68710a;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ProfileEditCenterFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                a2 a2VarC = w0.c();
                C06101 c06101 = new C06101(ProfileEditCenterFragment.this, null);
                this.label = 1;
                if (kotlinx.coroutines.h.g(a2VarC, c06101, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    private final void birthDayShow() {
        String birthday;
        d0 mViewBinding;
        ProfileEditBar profileEditBar;
        UserInfo userInfo = this.userEntity;
        if (userInfo == null || (birthday = userInfo.getBirthday()) == null || (mViewBinding = getMViewBinding()) == null || (profileEditBar = mViewBinding.f80762b) == null) {
            return;
        }
        profileEditBar.setBtnRight(birthday);
    }

    private final int buildGender(String str) {
        if (Intrinsics.b(str, getString(R$string.profile_female))) {
            return 2;
        }
        if (Intrinsics.b(str, getString(R$string.profile_male))) {
            return 1;
        }
        Intrinsics.b(str, "");
        return 0;
    }

    private final void defaultShow() {
    }

    private final void editAvatar(String str, String str2) {
        ProfileEditBar profileEditBar;
        this.avatarUrl = str;
        this.bucket = str2;
        this.editText = str;
        this.editType = this.EDIT_AVATAR;
        d0 mViewBinding = getMViewBinding();
        editRequest(str, this.oldNickName, buildGender(String.valueOf((mViewBinding == null || (profileEditBar = mViewBinding.f80764d) == null) ? null : profileEditBar.getBtnTextValue())), this.oldBirth, true);
    }

    private final void editBirthday(String str) {
        ProfileEditBar profileEditBar;
        this.editText = str;
        this.editType = this.EDIT_BIRTHDAY;
        d0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (profileEditBar = mViewBinding.f80762b) == null) {
            return;
        }
        profileEditBar.setBtnRight(str);
    }

    private final void editGender(String str) {
        ProfileEditBar profileEditBar;
        this.editText = str;
        this.editType = this.EDIT_GENDER;
        d0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (profileEditBar = mViewBinding.f80764d) == null) {
            return;
        }
        profileEditBar.setBtnRight(str);
    }

    private final void editNickName(String str) {
        this.editText = str;
        this.editType = this.EDIT_NAME;
        d0 mViewBinding = getMViewBinding();
        TextView textView = mViewBinding != null ? mViewBinding.f80770k : null;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    private final void editRequest(String str, String str2, int i11, String str3, boolean z11) {
        ProgressBar progressBar;
        d0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (progressBar = mViewBinding.f80766g) != null) {
            so.c.k(progressBar);
        }
        this.respDuration = System.currentTimeMillis();
        RequstUserEntity requstUserEntity = new RequstUserEntity();
        UserInfo userInfo = this.userEntity;
        requstUserEntity.setUserId(userInfo != null ? userInfo.getUserId() : null);
        if (!TextUtils.isEmpty(str)) {
            if (z11) {
                requstUserEntity.setNewAvatarPath(str);
            } else {
                requstUserEntity.setAvatar(str);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            requstUserEntity.setNickname(str2);
        }
        requstUserEntity.setGender(Integer.valueOf(i11));
        if (TextUtils.isEmpty(str3)) {
            requstUserEntity.setBirthday(this.oldBirth);
        } else if (TextUtils.equals(str3, "null")) {
            requstUserEntity.setBirthday("");
        } else {
            requstUserEntity.setBirthday(str3);
        }
        if (!TextUtils.isEmpty(this.bucket)) {
            requstUserEntity.setTempBucket(this.bucket);
        }
        az.b bVar = this.presenter;
        if (bVar != null) {
            bVar.e(requstUserEntity);
        }
    }

    public static /* synthetic */ void editRequest$default(ProfileEditCenterFragment profileEditCenterFragment, String str, String str2, int i11, String str3, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = "";
        }
        if ((i12 & 2) != 0) {
            str2 = "";
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        if ((i12 & 8) != 0) {
            str3 = "";
        }
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        profileEditCenterFragment.editRequest(str, str2, i11, str3, z11);
    }

    private final void editTipsDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.profile_back_edit_tips);
            Intrinsics.f(string, "getString(R.string.profile_back_edit_tips)");
            TRDialog.a aVarG = aVar.g(string);
            String string2 = getString(R$string.profile_back_edit_yes);
            Intrinsics.f(string2, "getString(R.string.profile_back_edit_yes)");
            TRDialog.a aVarE = aVarG.e(string2);
            String string3 = getString(R$string.profile_back_edit_no);
            Intrinsics.f(string3, "getString(R.string.profile_back_edit_no)");
            aVarE.j(string3).d(z2.a.getColor(requireContext(), R$color.text_01)).i(z2.a.getColor(requireContext(), R$color.text_01)).h(R$drawable.libui_sub_btn2_normal).c(R$drawable.libui_sub_btn2_normal).f(this).a().m0(this, "edit_tips");
        } catch (Exception unused) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void fastAvatar(String str) {
        try {
            localAvatar(str);
        } catch (Exception unused) {
        }
    }

    private final void formattingGender() {
        UserInfo userInfo = this.userEntity;
        Integer numValueOf = userInfo != null ? Integer.valueOf(userInfo.getGender()) : null;
        if (numValueOf != null && numValueOf.intValue() == 2) {
            String string = getString(R$string.profile_female);
            Intrinsics.f(string, "getString(R.string.profile_female)");
            this.oldGender = string;
        } else if (numValueOf != null && numValueOf.intValue() == 1) {
            String string2 = getString(R$string.profile_male);
            Intrinsics.f(string2, "getString(R.string.profile_male)");
            this.oldGender = string2;
        }
    }

    private final void genderShow() {
        String string;
        ProfileEditBar profileEditBar;
        UserInfo userInfo = this.userEntity;
        if (userInfo == null || userInfo.getGender() != 2) {
            UserInfo userInfo2 = this.userEntity;
            if (userInfo2 == null || userInfo2.getGender() != 1) {
                string = "";
            } else {
                string = getString(R$string.profile_male);
                Intrinsics.f(string, "getString(R.string.profile_male)");
            }
        } else {
            string = getString(R$string.profile_female);
            Intrinsics.f(string, "getString(R.string.profile_female)");
        }
        d0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (profileEditBar = mViewBinding.f80764d) == null) {
            return;
        }
        profileEditBar.setBtnRight(string);
    }

    private final IPublishApi getPublishApi() {
        return (IPublishApi) this.publishApi$delegate.getValue();
    }

    private final void headPortrait() {
        d0 mViewBinding;
        ShapeableImageView it1;
        FragmentActivity activity = getActivity();
        if (activity == null || (mViewBinding = getMViewBinding()) == null || (it1 = mViewBinding.f80771l) == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Intrinsics.f(it1, "it1");
        UserInfo userInfo = this.userEntity;
        companion.g(activity, it1, userInfo != null ? userInfo.getAvatar() : null, (112 & 8) != 0 ? R$color.cl37 : com.transsion.usercenter.R$color.color_ff999999, (112 & 16) != 0 ? 0 : 0, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
    }

    private final void headPortraitBitmap(Bitmap bitmap) {
        ShapeableImageView shapeableImageView;
        d0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (shapeableImageView = mViewBinding.f80771l) == null) {
            return;
        }
        shapeableImageView.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideRequestLoading() {
        kotlinx.coroutines.j.d(v.a(this), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void iniData() {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProfileEditBar profileEditBar;
        ProfileEditBar profileEditBar2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        az.b bVar = new az.b();
        this.presenter = bVar;
        bVar.a(this);
        d0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (relativeLayout2 = mViewBinding.f80768i) != null) {
            relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.edit.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileEditCenterFragment.iniData$lambda$1(this.f59331a, view);
                }
            });
        }
        d0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (relativeLayout = mViewBinding2.f80767h) != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.edit.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileEditCenterFragment.iniData$lambda$3(this.f59332a, view);
                }
            });
        }
        d0 mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (profileEditBar2 = mViewBinding3.f80764d) != null) {
            profileEditBar2.setClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.edit.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileEditCenterFragment.iniData$lambda$4(this.f59333a, view);
                }
            });
        }
        d0 mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (profileEditBar = mViewBinding4.f80762b) != null) {
            profileEditBar.setClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.edit.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileEditCenterFragment.iniData$lambda$8(this.f59334a, view);
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("user")) {
            d0 mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (progressBar = mViewBinding5.f80766g) != null) {
                so.c.k(progressBar);
            }
            az.b bVar2 = this.presenter;
            if (bVar2 != null) {
                bVar2.f();
                return;
            }
            return;
        }
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("user") : null;
        if (!(serializable instanceof UserInfo)) {
            d0 mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (progressBar2 = mViewBinding6.f80766g) != null) {
                so.c.k(progressBar2);
            }
            az.b bVar3 = this.presenter;
            if (bVar3 != null) {
                bVar3.f();
                return;
            }
            return;
        }
        this.userEntity = (UserInfo) serializable;
        setOldData();
        formattingGender();
        TempData.a aVar = TempData.f59304b;
        Bitmap bitmapB = aVar.a().b();
        if (bitmapB == null) {
            showEntity(null);
        } else {
            aVar.a().c(null);
            showEntity(bitmapB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void iniData$lambda$1(ProfileEditCenterFragment this$0, View view) {
        FragmentActivity activity;
        EditNameDialog editNameDialog;
        TextView textView;
        Intrinsics.g(this$0, "this$0");
        if (this$0.editDialog == null) {
            this$0.editDialog = new EditNameDialog();
        }
        EditNameDialog editNameDialog2 = this$0.editDialog;
        if ((editNameDialog2 != null && editNameDialog2.isShow()) || (activity = this$0.getActivity()) == null || (editNameDialog = this$0.editDialog) == null) {
            return;
        }
        d0 mViewBinding = this$0.getMViewBinding();
        editNameDialog.v0(activity, this$0, String.valueOf((mViewBinding == null || (textView = mViewBinding.f80770k) == null) ? null : textView.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void iniData$lambda$3(ProfileEditCenterFragment this$0, View view) {
        IPublishApi publishApi;
        Intrinsics.g(this$0, "this$0");
        b1.b<Intent> bVar = this$0.photoLaunch;
        if (bVar != null) {
            FragmentActivity activity = this$0.getActivity();
            Intent intentU1 = null;
            if (activity != null && (publishApi = this$0.getPublishApi()) != null) {
                intentU1 = publishApi.u1(activity);
            }
            bVar.a(intentU1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void iniData$lambda$4(ProfileEditCenterFragment this$0, View view) {
        ProfileEditBar profileEditBar;
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        d0 mViewBinding = this$0.getMViewBinding();
        new bz.b(activity, this$0, (mViewBinding == null || (profileEditBar = mViewBinding.f80764d) == null) ? null : profileEditBar.getBtnTextValue()).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void iniData$lambda$8(ProfileEditCenterFragment this$0, View view) {
        String birthday;
        ProfileEditBar profileEditBar;
        String setValue;
        ProfileEditBar profileEditBar2;
        ProfileEditBar profileEditBar3;
        String setValue2;
        Intrinsics.g(this$0, "this$0");
        if (this$0.isClearBirthday) {
            d0 mViewBinding = this$0.getMViewBinding();
            if (mViewBinding == null || (profileEditBar3 = mViewBinding.f80762b) == null || (setValue2 = profileEditBar3.getSetValue()) == null) {
                return;
            }
            this$0.showTimePicker(setValue2);
            return;
        }
        d0 mViewBinding2 = this$0.getMViewBinding();
        Boolean boolValueOf = (mViewBinding2 == null || (profileEditBar2 = mViewBinding2.f80762b) == null) ? null : Boolean.valueOf(profileEditBar2.isEmpty());
        Intrinsics.d(boolValueOf);
        if (!boolValueOf.booleanValue()) {
            d0 mViewBinding3 = this$0.getMViewBinding();
            if (mViewBinding3 == null || (profileEditBar = mViewBinding3.f80762b) == null || (setValue = profileEditBar.getSetValue()) == null) {
                return;
            }
            this$0.showTimePicker(setValue);
            return;
        }
        UserInfo userInfo = this$0.userEntity;
        if (TextUtils.isEmpty(userInfo != null ? userInfo.getBirthday() : null)) {
            this$0.showTimePicker("");
            return;
        }
        UserInfo userInfo2 = this$0.userEntity;
        if (userInfo2 == null || (birthday = userInfo2.getBirthday()) == null) {
            return;
        }
        this$0.showTimePicker(birthday);
    }

    private final void initView() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$23(ProfileEditCenterFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() != -1) {
            uo.b.a.f(uo.b.f78622a, "photoLaunch", "fail", false, 4, null);
            return;
        }
        Intent data = activityResult.getData();
        String stringExtra = data != null ? data.getStringExtra("clip_result") : null;
        uo.b.a.f(uo.b.f78622a, "photoLaunch", "result:" + ((Object) stringExtra), false, 4, null);
        if (stringExtra != null) {
            this$0.cropImage = stringExtra;
        }
        if (stringExtra != null) {
            this$0.uploadImage(stringExtra);
        }
    }

    private final void loadProfile() {
        d0 mViewBinding;
        ShapeableImageView it1;
        String str = this.avatarUrl;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringsKt__StringsKt.Q(str, "http:", false, 2, null);
        FragmentActivity activity = getActivity();
        if (activity == null || (mViewBinding = getMViewBinding()) == null || (it1 = mViewBinding.f80771l) == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Intrinsics.f(it1, "it1");
        companion.r(activity, it1, str, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
    }

    private final void localAvatar(final String str) {
        io.reactivex.rxjava3.core.j.f(new io.reactivex.rxjava3.core.l() { // from class: com.transsion.usercenter.edit.m
            @Override // io.reactivex.rxjava3.core.l
            public final void a(io.reactivex.rxjava3.core.k kVar) {
                ProfileEditCenterFragment.localAvatar$lambda$13(str, kVar);
            }
        }).r(io.reactivex.rxjava3.android.schedulers.b.c()).A(q10.a.b()).subscribe(new b(new Ref.ObjectRef(), this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void localAvatar$lambda$13(String localPath, io.reactivex.rxjava3.core.k emitter) {
        Intrinsics.g(localPath, "$localPath");
        Intrinsics.g(emitter, "emitter");
        uo.b.a.f(uo.b.f78622a, " localAvatar", "start....", false, 4, null);
        Bitmap bitmapB = vy.a.b(localPath);
        if (emitter.isDisposed()) {
            return;
        }
        emitter.onNext(bitmapB);
    }

    private final void nickNameShow() {
        d0 mViewBinding = getMViewBinding();
        TextView textView = mViewBinding != null ? mViewBinding.f80770k : null;
        if (textView == null) {
            return;
        }
        UserInfo userInfo = this.userEntity;
        textView.setText(userInfo != null ? userInfo.getNickname() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAvatarUrl$lambda$12(String data, ProfileEditCenterFragment this$0, String localPath, String bucket) {
        Intrinsics.g(data, "$data");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(localPath, "$localPath");
        Intrinsics.g(bucket, "$bucket");
        if (TextUtils.isEmpty(data)) {
            this$0.hideRequestLoading();
            zp.b.f82110a.d(R$string.profile_upload_fails);
        } else {
            this$0.fastAvatar(localPath);
            this$0.isChangeAvatar = true;
            this$0.editAvatar(data, bucket);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDialogConfirm$lambda$18(ProfileEditCenterFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            KeyboardUtils.d(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onError$lambda$15(ProfileEditCenterFragment this$0, String str) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.isChangeAvatar) {
            this$0.isChangeAvatar = false;
            this$0.respDuration = 0L;
            this$0.hideRequestLoading();
            zp.b.f82110a.d(R$string.profile_upload_fails);
            return;
        }
        this$0.respDuration = 0L;
        this$0.isChangeAvatar = false;
        this$0.hideRequestLoading();
        zp.b.f82110a.e(str);
    }

    private final void setCurrentBirthDay(String str, Calendar calendar) {
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str));
            com.bigkoo.pickerview.view.a aVar = this.timePickerView;
            if (aVar != null) {
                aVar.B(calendar);
            }
        } catch (ParseException e11) {
            e11.printStackTrace();
        }
    }

    private final void setOldData() {
        UserInfo userInfo = this.userEntity;
        this.oldNickName = String.valueOf(userInfo != null ? userInfo.getNickname() : null);
        UserInfo userInfo2 = this.userEntity;
        this.oldBirth = String.valueOf(userInfo2 != null ? userInfo2.getBirthday() : null);
    }

    private final void showEntity(Bitmap bitmap) {
        if (this.userEntity == null) {
            defaultShow();
            return;
        }
        if (bitmap == null) {
            headPortrait();
        } else {
            headPortraitBitmap(bitmap);
        }
        nickNameShow();
        genderShow();
        birthDayShow();
    }

    private final void showRequestLoading() {
        ProgressBar progressBar;
        d0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (progressBar = mViewBinding.f80766g) == null) {
            return;
        }
        so.c.k(progressBar);
    }

    private final void showTimePicker(String str) {
        com.bigkoo.pickerview.view.a aVar;
        if (getContext() == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(1900, 0, 1);
        if (this.timePickerView == null) {
            this.timePickerView = new e8.a(getContext(), new g8.c() { // from class: com.transsion.usercenter.edit.k
                @Override // g8.c
                public final void a(Date date, View view) {
                    ProfileEditCenterFragment.showTimePicker$lambda$16(this.f59335a, date, view);
                }
            }).d(calendar, Calendar.getInstance()).e(z2.a.getColor(requireContext(), R$color.text_01)).f(z2.a.getColor(requireContext(), R$color.text_03)).b(z2.a.getColor(requireContext(), R$color.line_01)).c("", "", "", "", "", "").a();
        }
        if (TextUtils.isEmpty(str)) {
            com.bigkoo.pickerview.view.a aVar2 = this.timePickerView;
            if (aVar2 != null) {
                aVar2.B(Calendar.getInstance());
            }
        } else {
            Intrinsics.f(calendar, "calendar");
            setCurrentBirthDay(str, calendar);
        }
        com.bigkoo.pickerview.view.a aVar3 = this.timePickerView;
        if (aVar3 == null || aVar3.q() || (aVar = this.timePickerView) == null) {
            return;
        }
        aVar.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTimePicker$lambda$16(ProfileEditCenterFragment this$0, Date date, View view) {
        Intrinsics.g(this$0, "this$0");
        if (date == null) {
            this$0.isClearBirthday = true;
            this$0.editBirthday("");
            return;
        }
        this$0.isClearBirthday = false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        Intrinsics.f(format, "format");
        this$0.editBirthday(format);
    }

    public final void checkBack() {
        checkEditSubmit(true);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0084  */
    public final void checkEditSubmit(boolean z11) {
        String strValueOf;
        boolean z12;
        boolean z13;
        String strValueOf2;
        boolean z14;
        ProfileEditBar profileEditBar;
        ProfileEditBar profileEditBar2;
        ProfileEditBar profileEditBar3;
        ProfileEditBar profileEditBar4;
        ProfileEditBar profileEditBar5;
        ProfileEditBar profileEditBar6;
        ProfileEditBar profileEditBar7;
        TextView textView;
        TextView textView2;
        String strValueOf3 = this.oldNickName;
        d0 mViewBinding = getMViewBinding();
        if (!TextUtils.equals((mViewBinding == null || (textView2 = mViewBinding.f80770k) == null) ? null : textView2.getText(), this.oldNickName)) {
            d0 mViewBinding2 = getMViewBinding();
            strValueOf3 = String.valueOf((mViewBinding2 == null || (textView = mViewBinding2.f80770k) == null) ? null : textView.getText());
        }
        String str = strValueOf3;
        d0 mViewBinding3 = getMViewBinding();
        Boolean boolValueOf = (mViewBinding3 == null || (profileEditBar7 = mViewBinding3.f80762b) == null) ? null : Boolean.valueOf(profileEditBar7.isEmpty());
        Intrinsics.d(boolValueOf);
        if (boolValueOf.booleanValue()) {
            strValueOf = "";
        } else {
            d0 mViewBinding4 = getMViewBinding();
            if (TextUtils.equals((mViewBinding4 == null || (profileEditBar6 = mViewBinding4.f80762b) == null) ? null : profileEditBar6.getBtnTextValue(), this.oldBirth)) {
                strValueOf = "";
            } else {
                d0 mViewBinding5 = getMViewBinding();
                strValueOf = String.valueOf((mViewBinding5 == null || (profileEditBar5 = mViewBinding5.f80762b) == null) ? null : profileEditBar5.getBtnTextValue());
            }
        }
        d0 mViewBinding6 = getMViewBinding();
        String strValueOf4 = String.valueOf((mViewBinding6 == null || (profileEditBar4 = mViewBinding6.f80764d) == null) ? null : profileEditBar4.getBtnTextValue());
        d0 mViewBinding7 = getMViewBinding();
        if (TextUtils.equals((mViewBinding7 == null || (profileEditBar3 = mViewBinding7.f80762b) == null) ? null : profileEditBar3.getBtnTextValue(), this.oldBirth) || !this.isClearBirthday) {
            z12 = false;
        } else {
            d0 mViewBinding8 = getMViewBinding();
            String btnTextValue = (mViewBinding8 == null || (profileEditBar2 = mViewBinding8.f80762b) == null) ? null : profileEditBar2.getBtnTextValue();
            Context context = getContext();
            if (TextUtils.equals(btnTextValue, context != null ? context.getString(R$string.profile_empty_select) : null)) {
                strValueOf = "null";
            }
            z12 = true;
        }
        d0 mViewBinding9 = getMViewBinding();
        if (TextUtils.equals((mViewBinding9 == null || (profileEditBar = mViewBinding9.f80764d) == null) ? null : profileEditBar.getBtnTextValue(), this.oldGender) || !this.isClearGender) {
            z13 = false;
        } else {
            strValueOf4 = "null";
            z13 = true;
        }
        if (!z13 && !z12 && TextUtils.equals(str, this.oldNickName) && TextUtils.isEmpty(strValueOf4) && TextUtils.isEmpty(strValueOf)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (z11) {
            editTipsDialog();
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.network_fail);
            return;
        }
        if (TextUtils.isEmpty(this.avatarUrl)) {
            UserInfo userInfo = this.userEntity;
            strValueOf2 = String.valueOf(userInfo != null ? userInfo.getAvatar() : null);
            z14 = false;
        } else {
            strValueOf2 = this.avatarUrl;
            z14 = true;
        }
        editRequest(strValueOf2, str, buildGender(strValueOf4), strValueOf, z14);
    }

    public final void confirmSubmit() {
        checkEditSubmit(false);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public d0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        d0 d0VarC = d0.c(inflater);
        Intrinsics.f(d0VarC, "inflate(inflater)");
        return d0VarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        this.photoLaunch = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.usercenter.edit.n
            @Override // b1.a
            public final void a(Object obj) {
                ProfileEditCenterFragment.initView$lambda$23(this.f59338a, (ActivityResult) obj);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        initView();
        iniData();
    }

    public void onAvatarUrl(final String data, final String localPath, final String bucket) {
        Intrinsics.g(data, "data");
        Intrinsics.g(localPath, "localPath");
        Intrinsics.g(bucket, "bucket");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.usercenter.edit.f
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileEditCenterFragment.onAvatarUrl$lambda$12(data, this, localPath, bucket);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        az.b bVar = this.presenter;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.transsion.usercenter.edit.dialog.EditNameDialog.a
    public void onDialogConfirm(String str) {
        RelativeLayout relativeLayout;
        if (!TextUtils.isEmpty(str)) {
            if (str != null) {
                editNickName(str);
            }
        } else {
            d0 mViewBinding = getMViewBinding();
            if (mViewBinding == null || (relativeLayout = mViewBinding.f80768i) == null) {
                return;
            }
            relativeLayout.postDelayed(new Runnable() { // from class: com.transsion.usercenter.edit.l
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileEditCenterFragment.onDialogConfirm$lambda$18(this.f59336a);
                }
            }, 100L);
        }
    }

    @Override // bz.b.a
    public void onDialogSelect(int i11, String result) {
        Intrinsics.g(result, "result");
        if (i11 == 2) {
            this.isClearGender = true;
            editGender("");
        } else {
            this.isClearGender = false;
            editGender(result);
        }
    }

    @Override // com.transsion.usercenter.edit.b
    public void onEditProfile(boolean z11) {
        ProgressBar progressBar;
        hideRequestLoading();
        d0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (progressBar = mViewBinding.f80766g) != null) {
            so.c.g(progressBar);
        }
        if (!z11) {
            this.isChangeAvatar = false;
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            KeyboardUtils.d(activity);
        }
        zp.b.f82110a.d(R$string.profile_saved_success);
        if (!this.isChangeAvatar) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        this.isChangeAvatar = false;
        UserInfo userInfo = this.userEntity;
        if (userInfo != null) {
            userInfo.setAvatar(this.editText);
        }
        this.editText = "";
    }

    @Override // com.transsion.usercenter.edit.b
    public void onError(String str, final String str2) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.usercenter.edit.e
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileEditCenterFragment.onError$lambda$15(this.f59325a, str2);
                }
            });
        }
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
    }

    @Override // com.transsion.usercenter.edit.b
    public void onUserInfo(UserInfo userInfo) {
        ProgressBar progressBar;
        this.userEntity = userInfo;
        d0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (progressBar = mViewBinding.f80766g) != null) {
            so.c.g(progressBar);
        }
        setOldData();
        formattingGender();
        showEntity(null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("sourceType", 2)) : null;
        Intrinsics.d(numValueOf);
        numValueOf.intValue();
        super.onViewCreated(view, bundle);
    }

    public final void uploadImage(String imagePath) {
        Intrinsics.g(imagePath, "imagePath");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.network_fail);
            return;
        }
        if (TextUtils.isEmpty(imagePath)) {
            return;
        }
        showRequestLoading();
        this.respDuration = System.currentTimeMillis();
        az.b bVar = this.presenter;
        if (bVar != null) {
            bVar.g(imagePath, new c());
        }
    }
}
