package com.transsion.room.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.d0;
import c1.j;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.f0;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.publish.api.IPublishApi;
import com.transsion.room.R$drawable;
import com.transsion.room.R$string;
import com.transsion.room.bean.CheckNameBean;
import com.transsion.room.viewmodel.RoomCreateModel;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
@Route(path = "/room/create")
@Metadata
@SourceDebugExtension
public final class CreateRoomActivity extends BaseActivity<sw.a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f57080o = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f57081p = "field_from";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f57084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b1.b<Intent> f57085d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RoomItem f57090j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f57092l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f57093m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f57094n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f57082a = 50;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f57083b = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f57086f = LazyKt__LazyJVMKt.b(new Function0<IPublishApi>() { // from class: com.transsion.room.activity.CreateRoomActivity$publishApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IPublishApi invoke() {
            return (IPublishApi) com.alibaba.android.arouter.launcher.a.d().h(IPublishApi.class);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f57087g = LazyKt__LazyJVMKt.b(new Function0<RoomCreateModel>() { // from class: com.transsion.room.activity.CreateRoomActivity$roomCreateModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RoomCreateModel invoke() {
            return new RoomCreateModel();
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f57088h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f57089i = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f57091k = Boolean.FALSE;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CreateRoomActivity.this.b0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Integer numValueOf = editable != null ? Integer.valueOf(editable.length()) : null;
            if (numValueOf == null || numValueOf.intValue() < CreateRoomActivity.this.f57083b) {
                return;
            }
            h.f50034a.l(CreateRoomActivity.this.getString(R$string.str_community_desc_limit));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57097a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57097a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57097a;
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
            this.f57097a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements ty.a {
        public e() {
        }

        @Override // ty.a
        public void a(String localFilePath, long j11, long j12) {
            Intrinsics.g(localFilePath, "localFilePath");
        }

        @Override // ty.a
        public void b(String localFilePath, String url, String bucket) {
            Intrinsics.g(localFilePath, "localFilePath");
            Intrinsics.g(url, "url");
            Intrinsics.g(bucket, "bucket");
            CreateRoomActivity.this.f57088h = url;
            CreateRoomActivity.this.f57089i = bucket;
            CreateRoomActivity.this.b0();
        }

        @Override // ty.a
        public void c(String localFilePath, String str, String str2, UploadTstTokenStorageType uploadTstTokenStorageType) {
            Intrinsics.g(localFilePath, "localFilePath");
            uo.b.a.g(uo.b.f78622a, "uploadKey: " + localFilePath + "; clientMessage:" + str + "; serviceMessage: " + str2, false, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c0(CreateRoomActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        Editable text = ((sw.a) this$0.getMViewBinding()).f76475c.getText();
        int length = String.valueOf(text != null ? StringsKt__StringsKt.Z0(text) : null).length();
        if (length <= 0 || TextUtils.isEmpty(this$0.f57088h)) {
            ((sw.a) this$0.getMViewBinding()).f76478g.setEnabled(false);
            return;
        }
        ((sw.a) this$0.getMViewBinding()).f76478g.setEnabled(true);
        if (length >= this$0.f57082a) {
            h.f50034a.l(this$0.getString(R$string.str_community_title_limit));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        final CreateRoomActivity createRoomActivity;
        String avatar;
        Bundle extras = getIntent().getExtras();
        RoomItem roomItem = extras != null ? (RoomItem) extras.getParcelable("field_key") : null;
        this.f57090j = roomItem;
        this.f57092l = roomItem != null ? roomItem.getGroupId() : null;
        RoomItem roomItem2 = this.f57090j;
        if (roomItem2 == null || (avatar = roomItem2.getAvatar()) == null) {
            createRoomActivity = this;
        } else {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            ShapeableImageView shapeableImageView = ((sw.a) getMViewBinding()).f76476d;
            Intrinsics.f(shapeableImageView, "mViewBinding.ivAvatar");
            companion.o(this, shapeableImageView, avatar, (32704 & 8) != 0 ? R$color.skeleton : R$drawable.ic_avatar_default, (32704 & 16) != 0 ? companion.d() : f0.a(96.0f), (32704 & 32) != 0 ? companion.c() : f0.a(96.0f), (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            createRoomActivity = this;
            createRoomActivity.f57088h = avatar;
        }
        AppCompatEditText appCompatEditText = ((sw.a) getMViewBinding()).f76475c;
        RoomItem roomItem3 = createRoomActivity.f57090j;
        appCompatEditText.setText(roomItem3 != null ? roomItem3.getName() : null);
        AppCompatEditText appCompatEditText2 = ((sw.a) getMViewBinding()).f76474b;
        RoomItem roomItem4 = createRoomActivity.f57090j;
        appCompatEditText2.setText(roomItem4 != null ? roomItem4.getDescription() : null);
        if (createRoomActivity.f57090j != null) {
            createRoomActivity.f57091k = Boolean.TRUE;
            ((sw.a) getMViewBinding()).f76478g.setEnabled(true);
        }
        createRoomActivity.f57085d = createRoomActivity.registerForActivityResult(new j(), new b1.a() { // from class: com.transsion.room.activity.a
            @Override // b1.a
            public final void a(Object obj) {
                CreateRoomActivity.j0(this.f57112a, (ActivityResult) obj);
            }
        });
        ((sw.a) getMViewBinding()).f76476d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoomActivity.k0(this.f57113a, view);
            }
        });
        ((sw.a) getMViewBinding()).f76475c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(createRoomActivity.f57082a)});
        ((sw.a) getMViewBinding()).f76474b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(createRoomActivity.f57083b)});
        ((sw.a) getMViewBinding()).f76475c.addTextChangedListener(createRoomActivity.new b());
        ((sw.a) getMViewBinding()).f76474b.addTextChangedListener(createRoomActivity.new c());
        ((sw.a) getMViewBinding()).f76478g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.activity.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoomActivity.l0(this.f57114a, view);
            }
        });
    }

    public static final void j0(CreateRoomActivity this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() != -1) {
            uo.b.a.f(uo.b.f78622a, "photoLaunch", "fail", false, 4, null);
            return;
        }
        Intent data = activityResult.getData();
        String stringExtra = data != null ? data.getStringExtra("clip_result") : null;
        uo.b.a.f(uo.b.f78622a, "photoLaunch", "result:" + stringExtra, false, 4, null);
        if (stringExtra != null) {
            this$0.m0(stringExtra);
        }
    }

    public static final void k0(CreateRoomActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        b1.b<Intent> bVar = this$0.f57085d;
        if (bVar != null) {
            IPublishApi iPublishApiE0 = this$0.e0();
            bVar.a(iPublishApiE0 != null ? iPublishApiE0.u1(this$0) : null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l0(CreateRoomActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (!com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) && ((sw.a) this$0.getMViewBinding()).f76478g.isEnabled()) {
            Editable text = ((sw.a) this$0.getMViewBinding()).f76475c.getText();
            this$0.f57093m = String.valueOf(text != null ? StringsKt__StringsKt.Z0(text) : null);
            Editable text2 = ((sw.a) this$0.getMViewBinding()).f76474b.getText();
            this$0.f57094n = String.valueOf(text2 != null ? StringsKt__StringsKt.Z0(text2) : null);
            if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                h.f50034a.l(this$0.getString(com.tn.lib.widget.R$string.no_network_toast));
                return;
            }
            String str = this$0.f57093m;
            if (str != null) {
                this$0.f0().b(str);
            }
        }
    }

    public final void b0() {
        ThreadUtils.j(new Runnable() { // from class: com.transsion.room.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                CreateRoomActivity.c0(this.f57115a);
            }
        });
    }

    public final void d0() {
        if (!Intrinsics.b(this.f57091k, Boolean.TRUE)) {
            String str = this.f57093m;
            if (str != null) {
                RoomCreateModel roomCreateModelF0 = f0();
                String strValueOf = String.valueOf(this.f57088h);
                String str2 = this.f57094n;
                roomCreateModelF0.c(str, strValueOf, str2 != null ? str2 : "", this.f57089i);
                return;
            }
            return;
        }
        RoomItem roomItem = this.f57090j;
        String groupId = roomItem != null ? roomItem.getGroupId() : null;
        this.f57092l = groupId;
        String str3 = this.f57093m;
        if (str3 == null || groupId == null) {
            return;
        }
        RoomCreateModel roomCreateModelF1 = f0();
        String strValueOf2 = String.valueOf(this.f57088h);
        String str4 = this.f57094n;
        roomCreateModelF1.i(groupId, str3, strValueOf2, str4 == null ? "" : str4, this.f57089i);
    }

    public final IPublishApi e0() {
        return (IPublishApi) this.f57086f.getValue();
    }

    public final RoomCreateModel f0() {
        return (RoomCreateModel) this.f57087g.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public sw.a getViewBinding() {
        sw.a aVarC = sw.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    public final void h0(String str) {
        com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withString("id", str).navigation();
    }

    public final void i0() {
        f0().f().j(this, new d(new Function1<RoomNet, Unit>() { // from class: com.transsion.room.activity.CreateRoomActivity$initModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomNet roomNet) {
                invoke2(roomNet);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomNet roomNet) {
                if (roomNet != null) {
                    com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    if (Intrinsics.b(roomNet.getGroupId(), "update")) {
                        this.this$0.setResult(-1);
                        this.this$0.finish();
                        return;
                    }
                    String groupId = roomNet.getGroupId();
                    if (groupId != null) {
                        CreateRoomActivity createRoomActivity = this.this$0;
                        createRoomActivity.h0(groupId);
                        createRoomActivity.setResult(-1);
                        createRoomActivity.finish();
                    }
                }
            }
        }));
        f0().d().j(this, new d(new Function1<CheckNameBean, Unit>() { // from class: com.transsion.room.activity.CreateRoomActivity$initModel$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CheckNameBean checkNameBean) {
                invoke2(checkNameBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CheckNameBean checkNameBean) {
                if (checkNameBean != null) {
                    this.this$0.f57084c = checkNameBean.isExist();
                    if (!this.this$0.f57084c || TextUtils.equals(checkNameBean.getGroupId(), this.this$0.f57092l)) {
                        this.this$0.d0();
                    } else {
                        zp.b.f82110a.e(this.this$0.getString(R$string.str_rooms_duplicate));
                    }
                }
            }
        }));
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m0(String str) {
        ImageHelper.Companion companion = ImageHelper.f51371a;
        ShapeableImageView shapeableImageView = ((sw.a) getMViewBinding()).f76476d;
        Intrinsics.f(shapeableImageView, "mViewBinding.ivAvatar");
        companion.g(this, shapeableImageView, str, R$drawable.ic_avatar_default, 0, f0.a(96.0f), f0.a(96.0f));
        ty.b.f78077a.d(str, UploadFileType.OBJECT_NAME_IMAGE, true, new e());
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("createaroom", false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NestedScrollView nestedScrollViewB = ((sw.a) getMViewBinding()).getRoot();
        Intrinsics.f(nestedScrollViewB, "mViewBinding.root");
        so.c.e(nestedScrollViewB);
        initView();
        i0();
    }
}
