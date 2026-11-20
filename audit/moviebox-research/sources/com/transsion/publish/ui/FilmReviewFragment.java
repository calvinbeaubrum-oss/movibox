package com.transsion.publish.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.permissionx.guolindev.PermissionX;
import com.tencent.mmkv.MMKV;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.PublishManager;
import com.transsion.publish.PublishService;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.api.AudioEntity;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.api.LinkEntity;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.api.bean.MediaAudioEntity;
import com.transsion.publish.api.bean.MediaCoverEntity;
import com.transsion.publish.api.bean.MediaImageEntity;
import com.transsion.publish.api.bean.MediaLinkEntity;
import com.transsion.publish.api.bean.MediaVideoEntity;
import com.transsion.publish.api.bean.RequestPostEntity;
import com.transsion.publish.api.bean.RequestPostMediaEntity;
import com.transsion.publish.bean.BigImageBean;
import com.transsion.publish.bean.CoverEntity;
import com.transsion.publish.model.PublishModel;
import com.transsion.publish.view.ObservableScrollView;
import com.transsion.publish.view.operation.OperationBarView;
import com.transsion.publish.view.operation.OperationVerticalBarView;
import com.transsion.publish.viewmodel.PostViewModel;
import com.transsion.room.api.IRoomApi;
import com.transsion.room.api.bean.LocationPlace;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.SyncManager;
import com.transsnet.loginapi.ILoginApi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;

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
public final class FilmReviewFragment extends BaseFragment<ew.h> implements TRDialogListener, com.transsion.publish.adapter.a, fw.b.InterfaceC0679b {
    public static final a Companion = new a(null);
    public static final String PAGE_NAME = "publish_post";
    private CoverEntity coverPath;
    private LocationPlace curLocationBean;
    private GroupBean groupBean;
    private boolean hasFocus;
    private com.transsion.publish.adapter.g imageAdapter;
    private ImageView imageIcon;
    private boolean isBold;
    private boolean isNeedShowLoginActivity;
    private MediaLinkEntity linkEntity;
    private LocationPlace locationBean;
    private b1.b<Intent> loginLaunch;
    private final Runnable mRunnable;
    private Subject mSubject;
    private com.transsion.publish.adapter.r managerAdapter;
    private cw.a operationMenu;
    private int postStar;
    private PostViewModel postViewModel;
    private int publishType;
    private boolean requestGroup;
    private long showTime;
    private int sourceMode;
    private int sourceType;
    private boolean underOS33;
    private com.transsion.publish.adapter.v videoAdapter;
    private ImageView videoIcon;
    private b1.b<b1.e> videoSelectLauncher;
    private final int TITLE_MAX = 100;
    private final int DESC_MAX = 1000;
    private String TAG = PublishManager.TAG;
    private final Lazy mRoomApi$delegate = LazyKt__LazyJVMKt.b(new Function0<IRoomApi>() { // from class: com.transsion.publish.ui.FilmReviewFragment$mRoomApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IRoomApi invoke() {
            return (IRoomApi) com.alibaba.android.arouter.launcher.a.d().h(IRoomApi.class);
        }
    });
    private final Lazy loginApi$delegate = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.publish.ui.FilmReviewFragment$loginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });
    private final Lazy publishModel$delegate = LazyKt__LazyJVMKt.b(new Function0<PublishModel>() { // from class: com.transsion.publish.ui.FilmReviewFragment$publishModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PublishModel invoke() {
            return new PublishModel();
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

        public final FilmReviewFragment a(int i11, Subject subject, int i12, GroupBean groupBean) {
            FilmReviewFragment filmReviewFragment = new FilmReviewFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("sourceType", i11);
            bundle.putInt("sourceMode", i12);
            if (subject != null) {
                bundle.putSerializable("subject", subject);
            }
            if (groupBean != null) {
                bundle.putSerializable("group", groupBean);
            }
            filmReviewFragment.setArguments(bundle);
            return filmReviewFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Typeface> f56496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Typeface> f56497c;

        public b(Ref.ObjectRef<Typeface> objectRef, Ref.ObjectRef<Typeface> objectRef2) {
            this.f56496b = objectRef;
            this.f56497c = objectRef2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditText editText;
            EditText editText2;
            EditText editText3;
            EditText editText4;
            EditText editText5;
            EditText editText6;
            int length = editable != null ? editable.length() : 0;
            if (length <= 0) {
                FilmReviewFragment.this.isBold = false;
                ew.h mViewBinding = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding != null && (editText2 = mViewBinding.f64422d) != null) {
                    editText2.setTypeface(this.f56497c.element, 0);
                }
                ew.h mViewBinding2 = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding2 != null && (editText = mViewBinding2.f64422d) != null) {
                    editText.invalidate();
                }
            } else if (!FilmReviewFragment.this.isBold) {
                ew.h mViewBinding3 = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding3 != null && (editText6 = mViewBinding3.f64422d) != null) {
                    editText6.setTypeface(this.f56496b.element, 1);
                }
                ew.h mViewBinding4 = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding4 != null && (editText5 = mViewBinding4.f64422d) != null) {
                    editText5.invalidate();
                }
                FilmReviewFragment.this.isBold = true;
            }
            if (length < FilmReviewFragment.this.TITLE_MAX - 20 || length > FilmReviewFragment.this.TITLE_MAX) {
                ew.h mViewBinding5 = FilmReviewFragment.this.getMViewBinding();
                TextView textView = mViewBinding5 != null ? mViewBinding5.f64441x : null;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else {
                ew.h mViewBinding6 = FilmReviewFragment.this.getMViewBinding();
                TextView textView2 = mViewBinding6 != null ? mViewBinding6.f64441x : null;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                ew.h mViewBinding7 = FilmReviewFragment.this.getMViewBinding();
                TextView textView3 = mViewBinding7 != null ? mViewBinding7.f64441x : null;
                if (textView3 != null) {
                    textView3.setText(String.valueOf(FilmReviewFragment.this.TITLE_MAX - length));
                }
            }
            if (length > FilmReviewFragment.this.TITLE_MAX) {
                com.tn.lib.widget.toast.core.h.f50034a.k(R$string.post_title_length_max);
                if (TextUtils.isEmpty(editable)) {
                    return;
                }
                Integer numValueOf = editable != null ? Integer.valueOf(editable.length()) : null;
                Intrinsics.d(numValueOf);
                if (numValueOf.intValue() > FilmReviewFragment.this.TITLE_MAX) {
                    String string = editable.subSequence(0, FilmReviewFragment.this.TITLE_MAX).toString();
                    ew.h mViewBinding8 = FilmReviewFragment.this.getMViewBinding();
                    if (mViewBinding8 != null && (editText4 = mViewBinding8.f64422d) != null) {
                        editText4.setText(string);
                    }
                    ew.h mViewBinding9 = FilmReviewFragment.this.getMViewBinding();
                    if (mViewBinding9 == null || (editText3 = mViewBinding9.f64422d) == null) {
                        return;
                    }
                    editText3.setSelection(string.length());
                }
            }
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
    @SourceDebugExtension
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            OperationBarView operationBarView;
            OperationBarView operationBarView2;
            OperationBarView operationBarView3;
            ew.h mViewBinding;
            EditText editText;
            EditText editText2;
            OperationBarView operationBarView4;
            EditText editText3;
            Integer numValueOf = editable != null ? Integer.valueOf(editable.length()) : null;
            ew.h mViewBinding2 = FilmReviewFragment.this.getMViewBinding();
            if (mViewBinding2 != null && (editText3 = mViewBinding2.f64421c) != null) {
                Linkify.addLinks(editText3, 1);
            }
            if (numValueOf != null) {
                FragmentActivity activity = FilmReviewFragment.this.getActivity();
                Intrinsics.e(activity, "null cannot be cast to non-null type com.transsion.publish.ui.FilmReviewActivity");
                ((FilmReviewActivity) activity).W(FilmReviewFragment.this.isPostEnable());
                if (numValueOf.intValue() >= 995) {
                    ew.h mViewBinding3 = FilmReviewFragment.this.getMViewBinding();
                    if (mViewBinding3 != null && (operationBarView4 = mViewBinding3.f64431n) != null) {
                        operationBarView4.setInputLimitColor(R$color.error_50);
                    }
                } else {
                    ew.h mViewBinding4 = FilmReviewFragment.this.getMViewBinding();
                    if (mViewBinding4 != null && (operationBarView2 = mViewBinding4.f64431n) != null) {
                        operationBarView2.setInputLimitColor(R$color.white_80);
                    }
                }
                if (numValueOf.intValue() >= FilmReviewFragment.this.DESC_MAX) {
                    if (TextUtils.isEmpty(editable)) {
                        return;
                    }
                    Integer numValueOf2 = editable != null ? Integer.valueOf(editable.length()) : null;
                    Intrinsics.d(numValueOf2);
                    if (numValueOf2.intValue() > FilmReviewFragment.this.DESC_MAX) {
                        String string = editable != null ? editable.subSequence(0, FilmReviewFragment.this.DESC_MAX).toString() : null;
                        ew.h mViewBinding5 = FilmReviewFragment.this.getMViewBinding();
                        if (mViewBinding5 != null && (editText2 = mViewBinding5.f64421c) != null) {
                            editText2.setText(string);
                        }
                        if (string != null && (mViewBinding = FilmReviewFragment.this.getMViewBinding()) != null && (editText = mViewBinding.f64421c) != null) {
                            editText.setSelection(string.length());
                        }
                        ew.h mViewBinding6 = FilmReviewFragment.this.getMViewBinding();
                        if (mViewBinding6 == null || (operationBarView3 = mViewBinding6.f64431n) == null) {
                            return;
                        }
                        operationBarView3.updateInputNum(string != null ? string.length() : 0);
                        return;
                    }
                    return;
                }
            }
            ew.h mViewBinding7 = FilmReviewFragment.this.getMViewBinding();
            if (mViewBinding7 == null || (operationBarView = mViewBinding7.f64431n) == null) {
                return;
            }
            operationBarView.updateInputNum(numValueOf != null ? numValueOf.intValue() : 0);
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
    public static final class d extends CountDownTimer {
        public d() {
            super(5000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ew.h mViewBinding = FilmReviewFragment.this.getMViewBinding();
            BubbleTextView bubbleTextView = mViewBinding != null ? mViewBinding.f64420b : null;
            if (bubbleTextView == null) {
                return;
            }
            bubbleTextView.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
        }
    }

    public FilmReviewFragment() {
        this.underOS33 = Build.VERSION.SDK_INT < 33;
        this.mRunnable = new Runnable() { // from class: com.transsion.publish.ui.h
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.mRunnable$lambda$29(this.f56589a);
            }
        };
    }

    private final void backSaveDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.cover_save_des);
            Intrinsics.f(string, "getString(R.string.cover_save_des)");
            TRDialog.a aVarG = aVar.g(string);
            String string2 = getString(R$string.cover_save_right);
            Intrinsics.f(string2, "getString(R.string.cover_save_right)");
            TRDialog.a aVarE = aVarG.e(string2);
            String string3 = getString(R$string.cover_save_left);
            Intrinsics.f(string3, "getString(R.string.cover_save_left)");
            aVarE.j(string3).h(R$drawable.btn_bg_dialog_edit_selector).c(R$drawable.btn_bg_dialog_edit_selector).i(com.blankj.utilcode.util.h.a(R$color.error_50)).f(this).a().m0(this, "back_save");
            HashMap map = new HashMap();
            map.put("module_name", "back_save_dialog");
            com.transsion.baselib.report.m.f51277a.t(getPageName(), "browse", map);
        } catch (Exception unused) {
        }
    }

    private final RequestPostEntity buildRequest() {
        String groupId;
        String name;
        Double lat;
        Double lon;
        EditText editText;
        String subjectId;
        EditText editText2;
        ew.h mViewBinding = getMViewBinding();
        Editable text = null;
        String strF = kotlin.text.l.F(kotlin.text.l.F(String.valueOf((mViewBinding == null || (editText2 = mViewBinding.f64421c) == null) ? null : editText2.getText()), "\\n", "", false, 4, null), "\\t", "", false, 4, null);
        RequestPostEntity requestPostEntity = new RequestPostEntity();
        GroupBean groupBean = this.groupBean;
        String str = "0";
        if (groupBean == null || (groupId = groupBean.getGroupId()) == null) {
            groupId = "0";
        }
        requestPostEntity.setGroupId(groupId);
        requestPostEntity.setScore(String.valueOf(this.postStar));
        requestPostEntity.setLink(this.linkEntity);
        Subject subject = this.mSubject;
        if (subject != null && (subjectId = subject.getSubjectId()) != null) {
            str = subjectId;
        }
        requestPostEntity.setSubjectId(str);
        ew.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (editText = mViewBinding2.f64422d) != null) {
            text = editText.getText();
        }
        requestPostEntity.setTitle(String.valueOf(text));
        requestPostEntity.setContent(strF);
        requestPostEntity.setPublishType(this.sourceType);
        LocationPlace locationPlace = this.locationBean;
        double dDoubleValue = 0.0d;
        requestPostEntity.setLon((locationPlace == null || (lon = locationPlace.getLon()) == null) ? 0.0d : lon.doubleValue());
        LocationPlace locationPlace2 = this.locationBean;
        if (locationPlace2 != null && (lat = locationPlace2.getLat()) != null) {
            dDoubleValue = lat.doubleValue();
        }
        requestPostEntity.setLat(dDoubleValue);
        LocationPlace locationPlace3 = this.locationBean;
        if (locationPlace3 == null || (name = locationPlace3.getName()) == null) {
            name = "";
        }
        requestPostEntity.setPoiName(name);
        detectionSelect(requestPostEntity);
        return requestPostEntity;
    }

    private final void checkBottomMargin() {
    }

    private final void checkCover(RequestPostMediaEntity requestPostMediaEntity) {
        Integer height;
        Integer width;
        Long size;
        if (this.coverPath != null) {
            MediaCoverEntity mediaCoverEntity = new MediaCoverEntity();
            CoverEntity coverEntity = this.coverPath;
            mediaCoverEntity.setUrl(coverEntity != null ? coverEntity.getUrl() : null);
            CoverEntity coverEntity2 = this.coverPath;
            mediaCoverEntity.setSize((coverEntity2 == null || (size = coverEntity2.getSize()) == null) ? 0L : size.longValue());
            CoverEntity coverEntity3 = this.coverPath;
            int iIntValue = 0;
            mediaCoverEntity.setWidth((coverEntity3 == null || (width = coverEntity3.getWidth()) == null) ? 0 : width.intValue());
            CoverEntity coverEntity4 = this.coverPath;
            if (coverEntity4 != null && (height = coverEntity4.getHeight()) != null) {
                iIntValue = height.intValue();
            }
            mediaCoverEntity.setHeight(iIntValue);
            requestPostMediaEntity.setCover(mediaCoverEntity);
        }
    }

    private final boolean checkLogin() {
        ILoginApi loginApi = getLoginApi();
        if (loginApi == null || loginApi.N()) {
            return true;
        }
        b1.b<Intent> bVar = this.loginLaunch;
        if (bVar == null) {
            this.isNeedShowLoginActivity = true;
        }
        if (bVar == null) {
            return false;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        Intent intentO1 = loginApi.o1(contextRequireContext);
        intentO1.putExtra("title_name", getString(R$string.post_login_title));
        bVar.a(intentO1);
        return false;
    }

    private final void checkVideoCover(RequestPostMediaEntity requestPostMediaEntity, VsMediaInfo vsMediaInfo) {
        if (TextUtils.isEmpty(vsMediaInfo.getImagePath())) {
            return;
        }
        int[] iArrD = ImageUtils.d(vsMediaInfo.getImagePath());
        MediaCoverEntity mediaCoverEntity = new MediaCoverEntity();
        mediaCoverEntity.setUrl(vsMediaInfo.getImagePath());
        mediaCoverEntity.setSize(iArrD[0] * iArrD[1]);
        mediaCoverEntity.setWidth(iArrD[0]);
        mediaCoverEntity.setHeight(iArrD[1]);
        requestPostMediaEntity.setCover(mediaCoverEntity);
    }

    private final void clickPostTrace() {
        HashMap map = new HashMap();
        map.put("module_name", "post");
        com.transsion.baselib.report.m.f51277a.m(getPageName(), "click", map);
    }

    private final void clickTrace(String str) {
        HashMap map = new HashMap();
        map.put("click", str);
        com.transsion.baselib.report.m.f51277a.m(getPageName(), "click", map);
    }

    private final void coverClearDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.cover_clear_des);
            Intrinsics.f(string, "getString(R.string.cover_clear_des)");
            TRDialog.a aVarG = aVar.g(string);
            String string2 = getString(R$string.cover_clear_left);
            Intrinsics.f(string2, "getString(R.string.cover_clear_left)");
            TRDialog.a aVarE = aVarG.e(string2);
            String string3 = getString(R$string.cover_clear_right);
            Intrinsics.f(string3, "getString(R.string.cover_clear_right)");
            aVarE.j(string3).h(R$drawable.btn_bg_dialog_edit_selector).c(R$drawable.btn_bg_dialog_edit_selector).i(com.blankj.utilcode.util.h.a(com.transsion.baseui.R$color.base_color_black)).f(this).a().m0(this, "clear_cover");
        } catch (Exception unused) {
        }
    }

    private final void deleteAudio() {
        OperationBarView operationBarView;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        ImageView imageView;
        ImageView imageView2;
        this.coverPath = null;
        ew.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (relativeLayout = mViewBinding.f64433p) != null && relativeLayout.getVisibility() == 0) {
            ew.h mViewBinding2 = getMViewBinding();
            RelativeLayout relativeLayout2 = mViewBinding2 != null ? mViewBinding2.f64433p : null;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            if (this.sourceType == 1) {
                ew.h mViewBinding3 = getMViewBinding();
                RelativeLayout relativeLayout3 = mViewBinding3 != null ? mViewBinding3.f64435r : null;
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(0);
                }
            } else {
                ew.h mViewBinding4 = getMViewBinding();
                RelativeLayout relativeLayout4 = mViewBinding4 != null ? mViewBinding4.f64435r : null;
                if (relativeLayout4 != null) {
                    relativeLayout4.setVisibility(8);
                }
            }
            ew.h mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (imageView2 = mViewBinding5.f64425h) != null) {
                imageView2.setImageResource(0);
            }
            ew.h mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (imageView = mViewBinding6.f64425h) != null) {
                imageView.setBackgroundResource(0);
            }
            ew.h mViewBinding7 = getMViewBinding();
            if (mViewBinding7 != null && (linearLayout = mViewBinding7.f64428k) != null) {
                linearLayout.requestLayout();
            }
        }
        ew.h mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null && (operationBarView = mViewBinding8.f64431n) != null) {
            operationBarView.resetItem();
        }
        cw.a aVar = this.operationMenu;
        if (aVar != null) {
            if ((aVar != null ? aVar.a() : null) != null) {
                com.transsion.publish.adapter.r rVar = this.managerAdapter;
                if (rVar != null) {
                    cw.a aVar2 = this.operationMenu;
                    AudioEntity audioEntityA = aVar2 != null ? aVar2.a() : null;
                    Intrinsics.d(audioEntityA);
                    rVar.F(audioEntityA);
                }
                this.operationMenu = null;
            }
        }
        com.transsion.publish.adapter.r rVar2 = this.managerAdapter;
        if (rVar2 != null) {
            rVar2.destroy();
        }
    }

    private final void deleteLocation() {
        cw.a aVar = this.operationMenu;
        if (aVar != null) {
            if ((aVar != null ? aVar.g() : null) != null) {
                com.transsion.publish.adapter.r rVar = this.managerAdapter;
                if (rVar != null) {
                    cw.a aVar2 = this.operationMenu;
                    LocationPlace locationPlaceG = aVar2 != null ? aVar2.g() : null;
                    Intrinsics.d(locationPlaceG);
                    rVar.F(locationPlaceG);
                }
                this.locationBean = null;
                this.operationMenu = null;
            }
        }
    }

    private final void detectionSelect(RequestPostEntity requestPostEntity) {
        List<xu.a> listS;
        List<VsMediaInfo> listJ;
        List<PhotoEntity> listK;
        OperationBarView operationBarView;
        ew.h mViewBinding = getMViewBinding();
        List<Integer> selectItem = (mViewBinding == null || (operationBarView = mViewBinding.f64431n) == null) ? null : operationBarView.getSelectItem();
        RequestPostMediaEntity requestPostMediaEntity = new RequestPostMediaEntity();
        requestPostEntity.setMedia(requestPostMediaEntity);
        if (selectItem != null) {
            Iterator<T> it = selectItem.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (iIntValue == 0) {
                    requestPostMediaEntity.setMediaType(1);
                    ArrayList arrayList = new ArrayList();
                    com.transsion.publish.adapter.g gVar = this.imageAdapter;
                    if (gVar != null && (listK = gVar.k()) != null) {
                        for (PhotoEntity photoEntity : listK) {
                            if (!photoEntity.isAdd()) {
                                MediaImageEntity mediaImageEntity = new MediaImageEntity();
                                mediaImageEntity.setUrl(String.valueOf(photoEntity.getLocalPath()));
                                if (photoEntity.getWidth() > 0) {
                                    mediaImageEntity.setWidth(Integer.valueOf(photoEntity.getWidth()));
                                }
                                if (photoEntity.getHeight() > 0) {
                                    mediaImageEntity.setHeight(Integer.valueOf(photoEntity.getHeight()));
                                }
                                if (photoEntity.getImageSize() > 0) {
                                    mediaImageEntity.setSize(Long.valueOf(photoEntity.getImageSize()));
                                }
                                arrayList.add(mediaImageEntity);
                            }
                        }
                    }
                    requestPostMediaEntity.setImage(arrayList);
                } else if (iIntValue == 1) {
                    requestPostMediaEntity.setMediaType(4);
                    requestPostMediaEntity.setVideo(new ArrayList());
                    com.transsion.publish.adapter.v vVar = this.videoAdapter;
                    if (vVar != null && (listJ = vVar.j()) != null) {
                        for (VsMediaInfo vsMediaInfo : listJ) {
                            if (!vsMediaInfo.isAdd()) {
                                MediaVideoEntity mediaVideoEntity = new MediaVideoEntity();
                                mediaVideoEntity.setUrl(String.valueOf(vsMediaInfo.getVideoPath()));
                                mediaVideoEntity.setImagePath(vsMediaInfo.getImagePath());
                                if (vsMediaInfo.getWidth() > 0) {
                                    mediaVideoEntity.setWidth(vsMediaInfo.getWidth());
                                }
                                if (vsMediaInfo.getHeight() > 0) {
                                    mediaVideoEntity.setHeight(vsMediaInfo.getHeight());
                                }
                                if (vsMediaInfo.getVideoDuration() > 0) {
                                    mediaVideoEntity.setDuration(vsMediaInfo.getVideoDuration() / ((long) 1000));
                                }
                                mediaVideoEntity.setSize(vsMediaInfo.getVideoSize());
                                mediaVideoEntity.setFps(0);
                                mediaVideoEntity.setBitrate(0);
                                mediaVideoEntity.setDefinition(0);
                                List<MediaVideoEntity> video = requestPostMediaEntity.getVideo();
                                if (video != null) {
                                    video.add(mediaVideoEntity);
                                }
                                checkVideoCover(requestPostMediaEntity, vsMediaInfo);
                            }
                        }
                    }
                } else if (iIntValue == 2) {
                    requestPostMediaEntity.setMediaType(2);
                    requestPostMediaEntity.setAudio(new ArrayList());
                    com.transsion.publish.adapter.r rVar = this.managerAdapter;
                    if (rVar != null && (listS = rVar.s()) != null) {
                        for (xu.a aVar : listS) {
                            if (aVar instanceof AudioEntity) {
                                MediaAudioEntity mediaAudioEntity = new MediaAudioEntity();
                                AudioEntity audioEntity = (AudioEntity) aVar;
                                mediaAudioEntity.setUrl(String.valueOf(audioEntity.getLocalPath()));
                                mediaAudioEntity.setSize(audioEntity.getSize());
                                Long duration = audioEntity.getDuration();
                                if ((duration != null ? duration.longValue() : 0L) > 0) {
                                    Long duration2 = audioEntity.getDuration();
                                    mediaAudioEntity.setDuration(duration2 != null ? duration2.longValue() / ((long) 1000) : 0L);
                                }
                                mediaAudioEntity.setBitrate(0L);
                                List<MediaAudioEntity> audio = requestPostMediaEntity.getAudio();
                                if (audio != null) {
                                    audio.add(mediaAudioEntity);
                                }
                            }
                        }
                    }
                    checkCover(requestPostMediaEntity);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposeOperate(cw.a aVar) {
        Integer numE;
        this.operationMenu = aVar;
        hideOpertaionDialog();
        Integer numE2 = aVar.e();
        if (numE2 != null && numE2.intValue() == 0) {
            refreshImage(aVar);
        } else if (numE2 != null && numE2.intValue() == 1) {
            refreshVideo(aVar);
        } else if (numE2 != null && numE2.intValue() == 2) {
            refreshAudio(aVar);
        } else if (numE2 != null && numE2.intValue() == 5) {
            refreshCover(aVar);
        } else if (numE2 != null && numE2.intValue() == 3) {
            refreshWork(aVar);
        } else if (numE2 != null && numE2.intValue() == 6) {
            refreshGroup(aVar);
        } else if (numE2 != null && numE2.intValue() == 4) {
            refreshLink(aVar);
        } else if (numE2 != null && numE2.intValue() == 8) {
            refreshLocation(aVar);
        }
        Integer numE3 = aVar.e();
        if (numE3 != null && numE3.intValue() == 5 && (numE = aVar.e()) != null && numE.intValue() == 6) {
            return;
        }
        checkBottomMargin();
    }

    private final List<PhotoEntity> getAddImageEntity() {
        ArrayList arrayList = new ArrayList();
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setAdd(true);
        arrayList.add(photoEntity);
        return arrayList;
    }

    private final List<VsMediaInfo> getAddVideoEntity() {
        ArrayList arrayList = new ArrayList();
        VsMediaInfo vsMediaInfo = new VsMediaInfo();
        vsMediaInfo.setAdd(true);
        arrayList.add(vsMediaInfo);
        return arrayList;
    }

    private final void getImageIconView() {
        OperationBarView operationBarView;
        RecyclerView rv2;
        ew.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (operationBarView = mViewBinding.f64431n) == null || (rv2 = operationBarView.getRv()) == null) {
            return;
        }
        rv2.post(new Runnable() { // from class: com.transsion.publish.ui.r
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.getImageIconView$lambda$8(this.f56607a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getImageIconView$lambda$8(FilmReviewFragment this$0) {
        OperationBarView operationBarView;
        RecyclerView rv2;
        Intrinsics.g(this$0, "this$0");
        ew.h mViewBinding = this$0.getMViewBinding();
        RecyclerView.a0 a0VarFindViewHolderForAdapterPosition = (mViewBinding == null || (operationBarView = mViewBinding.f64431n) == null || (rv2 = operationBarView.getRv()) == null) ? null : rv2.findViewHolderForAdapterPosition(0);
        if (a0VarFindViewHolderForAdapterPosition instanceof jw.f) {
            this$0.imageIcon = (ImageView) ((jw.f) a0VarFindViewHolderForAdapterPosition).itemView.findViewById(R$id.image);
        }
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.loginApi$delegate.getValue();
    }

    private final IRoomApi getMRoomApi() {
        return (IRoomApi) this.mRoomApi$delegate.getValue();
    }

    private final String getPageName() {
        return PAGE_NAME;
    }

    private final PublishModel getPublishModel() {
        return (PublishModel) this.publishModel$delegate.getValue();
    }

    private final void getVideoIconView() {
        OperationBarView operationBarView;
        RecyclerView rv2;
        ew.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (operationBarView = mViewBinding.f64431n) == null || (rv2 = operationBarView.getRv()) == null) {
            return;
        }
        rv2.post(new Runnable() { // from class: com.transsion.publish.ui.s
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.getVideoIconView$lambda$7(this.f56609a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getVideoIconView$lambda$7(FilmReviewFragment this$0) {
        OperationBarView operationBarView;
        RecyclerView rv2;
        Intrinsics.g(this$0, "this$0");
        ew.h mViewBinding = this$0.getMViewBinding();
        RecyclerView.a0 a0VarFindViewHolderForAdapterPosition = (mViewBinding == null || (operationBarView = mViewBinding.f64431n) == null || (rv2 = operationBarView.getRv()) == null) ? null : rv2.findViewHolderForAdapterPosition(1);
        if (a0VarFindViewHolderForAdapterPosition instanceof jw.f) {
            this$0.videoIcon = (ImageView) ((jw.f) a0VarFindViewHolderForAdapterPosition).itemView.findViewById(R$id.image);
        }
    }

    private final void hideOpertaionDialog() {
    }

    private final void initImageAdapter() {
        RecyclerView recyclerView;
        if (this.imageAdapter == null) {
            this.imageAdapter = new com.transsion.publish.adapter.g();
            ew.h mViewBinding = getMViewBinding();
            RecyclerView recyclerView2 = mViewBinding != null ? mViewBinding.f64437t : null;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(new NpaGridLayoutManager(getContext(), 3));
            }
            ew.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (recyclerView = mViewBinding2.f64437t) != null) {
                recyclerView.addItemDecoration(new ro.b(com.blankj.utilcode.util.f0.a(2.0f), com.blankj.utilcode.util.f0.a(2.0f), 0, com.blankj.utilcode.util.f0.a(8.0f)));
            }
        }
        ew.h mViewBinding3 = getMViewBinding();
        RecyclerView recyclerView3 = mViewBinding3 != null ? mViewBinding3.f64437t : null;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.imageAdapter);
    }

    private final void initManagerAdapter() {
        if (this.managerAdapter == null) {
            this.managerAdapter = new com.transsion.publish.adapter.r();
            ew.h mViewBinding = getMViewBinding();
            RecyclerView recyclerView = mViewBinding != null ? mViewBinding.f64436s : null;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
            }
            ew.h mViewBinding2 = getMViewBinding();
            RecyclerView recyclerView2 = mViewBinding2 != null ? mViewBinding2.f64436s : null;
            if (recyclerView2 == null) {
                return;
            }
            recyclerView2.setAdapter(this.managerAdapter);
        }
    }

    private final void initRegisterMediaSelector() {
        if (this.underOS33) {
            return;
        }
        this.videoSelectLauncher = requireActivity().registerForActivityResult(new c1.g(), new b1.a() { // from class: com.transsion.publish.ui.n
            @Override // b1.a
            public final void a(Object obj) {
                FilmReviewFragment.initRegisterMediaSelector$lambda$25(this.f56600a, (Uri) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRegisterMediaSelector$lambda$25(FilmReviewFragment this$0, Uri uri) {
        Intrinsics.g(this$0, "this$0");
        if (uri != null) {
            cw.a aVar = new cw.a();
            aVar.o(1);
            aVar.n(1);
            VsMediaInfo vsMediaInfo = new VsMediaInfo();
            iw.f fVar = iw.f.f67743a;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            dw.a aVarB = fVar.b(contextRequireContext, uri);
            if (aVarB != null) {
                vsMediaInfo.setVideoPath(aVarB.c());
                vsMediaInfo.setVideoTitle(aVarB.e());
                vsMediaInfo.setVideoDuration(aVarB.a());
                vsMediaInfo.setWidth(aVarB.f());
                vsMediaInfo.setHeight(aVarB.b());
                vsMediaInfo.setVideoSize(aVarB.d());
            }
            aVar.t(vsMediaInfo);
            this$0.refreshVideo(aVar);
            this$0.requireActivity().getContentResolver().takePersistableUriPermission(uri, 1);
        }
    }

    private final void initVideoAdapter() {
        RecyclerView recyclerView;
        if (this.videoAdapter == null) {
            this.videoAdapter = new com.transsion.publish.adapter.v();
            ew.h mViewBinding = getMViewBinding();
            RecyclerView recyclerView2 = mViewBinding != null ? mViewBinding.f64437t : null;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(new NpaGridLayoutManager(getContext(), 3));
            }
            ew.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (recyclerView = mViewBinding2.f64437t) != null) {
                recyclerView.addItemDecoration(new ro.b(com.blankj.utilcode.util.f0.a(2.0f), com.blankj.utilcode.util.f0.a(2.0f), 0, com.blankj.utilcode.util.f0.a(8.0f)));
            }
        }
        ew.h mViewBinding3 = getMViewBinding();
        RecyclerView recyclerView3 = mViewBinding3 != null ? mViewBinding3.f64437t : null;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.videoAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(FilmReviewFragment this$0, RatingBar ratingBar, float f11, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        this$0.postStar = (int) f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FilmReviewFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        SelectImageActivity.a aVar = SelectImageActivity.f56514r;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.transsion.publish.adapter.g gVar = this$0.imageAdapter;
        aVar.a(contextRequireContext, 5, 1, gVar != null ? gVar.k() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(FilmReviewFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() != -1) {
            uo.b.a.f(uo.b.f78622a, "loginStatus", "登录失败或者取消", false, 4, null);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "loginStatus", "登录成功", false, 4, null);
        com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.f50034a;
        ILoginApi loginApi = this$0.getLoginApi();
        hVar.l(loginApi != null ? loginApi.b() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(FilmReviewFragment this$0, View view, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        view.dispatchWindowFocusChanged(z11);
        this$0.hasFocus = z11;
        if (z11) {
            this$0.hideOpertaionDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(final FilmReviewFragment this$0, View view, boolean z11) {
        ew.h mViewBinding;
        EditText editText;
        EditText editText2;
        Intrinsics.g(this$0, "this$0");
        view.dispatchWindowFocusChanged(z11);
        if (z11) {
            this$0.hideOpertaionDialog();
            ew.h mViewBinding2 = this$0.getMViewBinding();
            if (!TextUtils.isEmpty((mViewBinding2 == null || (editText2 = mViewBinding2.f64421c) == null) ? null : editText2.getText()) || (mViewBinding = this$0.getMViewBinding()) == null || (editText = mViewBinding.f64421c) == null) {
                return;
            }
            editText.post(new Runnable() { // from class: com.transsion.publish.ui.p
                @Override // java.lang.Runnable
                public final void run() {
                    FilmReviewFragment.initView$lambda$5$lambda$4(this.f56604a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5$lambda$4(FilmReviewFragment this$0) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Intrinsics.g(this$0, "this$0");
        ew.h mViewBinding = this$0.getMViewBinding();
        if (mViewBinding != null && (editText3 = mViewBinding.f64421c) != null) {
            editText3.setText("");
        }
        ew.h mViewBinding2 = this$0.getMViewBinding();
        if (mViewBinding2 != null && (editText2 = mViewBinding2.f64421c) != null) {
            editText2.setSelection(0);
        }
        ew.h mViewBinding3 = this$0.getMViewBinding();
        if (mViewBinding3 == null || (editText = mViewBinding3.f64421c) == null) {
            return;
        }
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(int i11) {
    }

    @SuppressLint({"InflateParams"})
    private final void initViewModel() {
        observe();
    }

    private final boolean isMoreThanADay(long j11, long j12) {
        return j11 - j12 > ((long) 604800000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRunnable$lambda$29(FilmReviewFragment this$0) {
        EditText editText;
        Intrinsics.g(this$0, "this$0");
        ew.h mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f64421c) == null) {
            return;
        }
        editText.clearFocus();
        editText.requestFocus();
        KeyboardUtils.i(editText);
    }

    private final void observe() {
        Function1<cw.a, Unit> function1 = new Function1<cw.a, Unit>() { // from class: com.transsion.publish.ui.FilmReviewFragment.observe.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cw.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cw.a it) {
                Intrinsics.g(it, "it");
                FilmReviewFragment.this.disposeOperate(it);
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, w0.c().q(), false, function1);
        Function1<BigImageBean, Unit> function2 = new Function1<BigImageBean, Unit>() { // from class: com.transsion.publish.ui.FilmReviewFragment.observe.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BigImageBean bigImageBean) {
                invoke2(bigImageBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BigImageBean it) {
                Integer operator;
                Intrinsics.g(it, "it");
                Integer from = it.getFrom();
                if (from != null && from.intValue() == 2 && (operator = it.getOperator()) != null && operator.intValue() == 1) {
                    FilmReviewFragment.this.selectPhotosDispose(it.getSelect());
                }
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = BigImageBean.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.observeEvent(this, name2, state, w0.c().q(), false, function2);
    }

    private final void openRoomList() {
        com.alibaba.android.arouter.launcher.a.d().b("/room/list").withBoolean("is_select_room", true).withInt("index", 1).navigation();
    }

    private final void postService(RequestPostEntity requestPostEntity, int i11) {
        PublishService.a aVar = PublishService.f56349f;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        aVar.a(contextRequireContext, requestPostEntity, this.sourceType);
    }

    private final void refreshAudio(cw.a aVar) {
        RelativeLayout relativeLayout;
        OperationBarView operationBarView;
        Integer numD = aVar.d();
        if (numD == null || numD.intValue() != 1) {
            if (numD != null && numD.intValue() == 2) {
                if (this.coverPath != null) {
                    coverClearDialog();
                    return;
                } else {
                    deleteAudio();
                    return;
                }
            }
            return;
        }
        if (aVar.a() == null) {
            return;
        }
        ew.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (operationBarView = mViewBinding.f64431n) != null) {
            operationBarView.selectItem(2);
        }
        initManagerAdapter();
        AudioEntity audioEntityA = aVar.a();
        if (audioEntityA != null) {
            audioEntityA.setType(2);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.G(aVar.a());
        }
        ew.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (relativeLayout = mViewBinding2.f64433p) == null || relativeLayout.getVisibility() != 0) {
            ew.h mViewBinding3 = getMViewBinding();
            RelativeLayout relativeLayout2 = mViewBinding3 != null ? mViewBinding3.f64433p : null;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            ew.h mViewBinding4 = getMViewBinding();
            RelativeLayout relativeLayout3 = mViewBinding4 != null ? mViewBinding4.f64435r : null;
            if (relativeLayout3 == null) {
                return;
            }
            relativeLayout3.setVisibility(8);
        }
    }

    private final void refreshCover(cw.a aVar) {
        if (aVar.b() == null) {
            return;
        }
        if (this.coverPath == null) {
            this.coverPath = new CoverEntity();
        }
        CoverEntity coverEntity = this.coverPath;
        if (coverEntity != null) {
            PhotoEntity photoEntityB = aVar.b();
            coverEntity.setUrl(photoEntityB != null ? photoEntityB.getLocalPath() : null);
        }
        CoverEntity coverEntity2 = this.coverPath;
        if (coverEntity2 != null) {
            PhotoEntity photoEntityB2 = aVar.b();
            coverEntity2.setSize(photoEntityB2 != null ? Long.valueOf(photoEntityB2.getImageSize()) : null);
        }
        CoverEntity coverEntity3 = this.coverPath;
        if (coverEntity3 != null) {
            PhotoEntity photoEntityB3 = aVar.b();
            coverEntity3.setWidth(photoEntityB3 != null ? Integer.valueOf(photoEntityB3.getWidth()) : null);
        }
        CoverEntity coverEntity4 = this.coverPath;
        if (coverEntity4 != null) {
            PhotoEntity photoEntityB4 = aVar.b();
            coverEntity4.setHeight(photoEntityB4 != null ? Integer.valueOf(photoEntityB4.getHeight()) : null);
        }
        ew.h mViewBinding = getMViewBinding();
        ImageView imageView = mViewBinding != null ? mViewBinding.f64425h : null;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        ew.h mViewBinding2 = getMViewBinding();
        ImageView imageView2 = mViewBinding2 != null ? mViewBinding2.f64425h : null;
        Intrinsics.d(imageView2);
        PhotoEntity photoEntityB5 = aVar.b();
        companion.g(contextRequireContext, imageView2, photoEntityB5 != null ? photoEntityB5.getLocalPath() : null, (112 & 8) != 0 ? R$color.cl37 : com.transsion.publish.R$color.color_ff999999, (112 & 16) != 0 ? 0 : 0, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
    }

    private final void refreshGroup(cw.a aVar) {
        this.groupBean = aVar.c();
        Integer numD = aVar.d();
        if (numD != null && numD.intValue() == 1) {
            GroupBean groupBeanC = aVar.c();
            if (groupBeanC != null) {
                setGroup(groupBeanC);
            }
        } else if (numD != null && numD.intValue() == 2) {
            cw.a aVar2 = this.operationMenu;
            if (aVar2 != null) {
                if ((aVar2 != null ? aVar2.c() : null) != null) {
                    com.transsion.publish.adapter.r rVar = this.managerAdapter;
                    if (rVar != null) {
                        cw.a aVar3 = this.operationMenu;
                        GroupBean groupBeanC2 = aVar3 != null ? aVar3.c() : null;
                        Intrinsics.d(groupBeanC2);
                        rVar.F(groupBeanC2);
                    }
                    this.operationMenu = null;
                }
            }
            this.groupBean = null;
        }
        HashMap map = new HashMap();
        GroupBean groupBean = this.groupBean;
        map.put("group_id", String.valueOf(groupBean != null ? groupBean.getGroupId() : null));
        com.transsion.baselib.report.m.f51277a.m(getPageName(), "click", map);
    }

    private final void refreshImage(cw.a aVar) {
        com.transsion.publish.adapter.g gVar;
        ew.h mViewBinding;
        OperationBarView operationBarView;
        List<PhotoEntity> listJ;
        List<PhotoEntity> listJ2;
        com.transsion.publish.adapter.g gVar2;
        List<PhotoEntity> listJ3;
        PhotoEntity photoEntity;
        OperationBarView operationBarView2;
        List<PhotoEntity> listJ4;
        List<PhotoEntity> listJ5;
        Integer numD = aVar.d();
        if (numD != null && numD.intValue() == 1) {
            com.transsion.publish.adapter.g gVar3 = this.imageAdapter;
            if (gVar3 == null || (listJ5 = gVar3.j()) == null || listJ5.size() < 9) {
                com.transsion.publish.adapter.g gVar4 = this.imageAdapter;
                if (gVar4 != null) {
                    List<PhotoEntity> listH = aVar.h();
                    if (listH == null) {
                        listH = new ArrayList<>();
                    }
                    listH.addAll(gVar4.j());
                    aVar.r(listH);
                }
                selectPhotosDispose(aVar.h());
            }
        } else {
            Integer numD2 = aVar.d();
            if (numD2 != null && numD2.intValue() == 2) {
                com.transsion.publish.adapter.g gVar5 = this.imageAdapter;
                if ((gVar5 == null || (listJ4 = gVar5.j()) == null || listJ4.size() != 0) && ((gVar = this.imageAdapter) == null || (listJ2 = gVar.j()) == null || listJ2.size() != 1 || (gVar2 = this.imageAdapter) == null || (listJ3 = gVar2.j()) == null || (photoEntity = listJ3.get(0)) == null || !photoEntity.isAdd())) {
                    com.transsion.publish.adapter.g gVar6 = this.imageAdapter;
                    if ((gVar6 == null || (listJ = gVar6.j()) == null || listJ.size() < 9) && (mViewBinding = getMViewBinding()) != null && (operationBarView = mViewBinding.f64431n) != null) {
                        operationBarView.selectItem(0);
                    }
                } else {
                    ew.h mViewBinding2 = getMViewBinding();
                    if (mViewBinding2 != null && (operationBarView2 = mViewBinding2.f64431n) != null) {
                        operationBarView2.resetItem();
                    }
                }
            }
        }
        FragmentActivity activity = getActivity();
        Intrinsics.e(activity, "null cannot be cast to non-null type com.transsion.publish.ui.FilmReviewActivity");
        ((FilmReviewActivity) activity).W(isPostEnable());
    }

    private final void refreshLink(cw.a aVar) {
        ew.h mViewBinding;
        OperationBarView operationBarView;
        OperationBarView operationBarView2;
        Integer numD = aVar.d();
        if (numD == null || numD.intValue() != 1) {
            if (numD == null || numD.intValue() != 2 || (mViewBinding = getMViewBinding()) == null || (operationBarView = mViewBinding.f64431n) == null) {
                return;
            }
            operationBarView.resetItem(true);
            return;
        }
        if (aVar.f() == null) {
            return;
        }
        ew.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (operationBarView2 = mViewBinding2.f64431n) != null) {
            operationBarView2.selectItem(4);
        }
        initManagerAdapter();
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.G(aVar.f());
        }
        LinkEntity linkEntityF = aVar.f();
        this.linkEntity = new MediaLinkEntity(linkEntityF != null ? linkEntityF.getUrl() : null, linkEntityF != null ? linkEntityF.getTitle() : null, linkEntityF != null ? linkEntityF.getCover() : null);
        LinkEntity linkEntityF2 = aVar.f();
        if (linkEntityF2 == null || !linkEntityF2.getLoading()) {
            return;
        }
        com.tn.lib.widget.toast.core.h.f50034a.k(R$string.postint_state_added);
    }

    private final void refreshLocation(cw.a aVar) {
        OperationBarView operationBarView;
        this.locationBean = aVar.g();
        Integer numD = aVar.d();
        if (numD == null || numD.intValue() != 1) {
            if (numD != null && numD.intValue() == 2) {
                deleteLocation();
                return;
            }
            return;
        }
        if (aVar.g() == null) {
            return;
        }
        ew.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (operationBarView = mViewBinding.f64431n) != null) {
            operationBarView.selectItem(8);
        }
        initManagerAdapter();
        LocationPlace locationPlaceG = aVar.g();
        if (locationPlaceG != null) {
            locationPlaceG.setType(8);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.G(aVar.g());
        }
    }

    private final void refreshVideo(cw.a aVar) {
        OperationBarView operationBarView;
        List<VsMediaInfo> listI;
        ImageView imageView;
        OperationBarView operationBarView2;
        Integer numD = aVar.d();
        if (numD != null && numD.intValue() == 1) {
            if (aVar.j() == null) {
                return;
            }
            VsMediaInfo vsMediaInfoJ = aVar.j();
            if ((vsMediaInfoJ != null ? vsMediaInfoJ.getVideoDuration() : 0L) > TTAdConstant.AD_MAX_EVENT_TIME) {
                com.tn.lib.widget.toast.core.h.f50034a.l(getString(R$string.publish_video_limit));
                return;
            }
            initVideoAdapter();
            ArrayList arrayList = new ArrayList();
            VsMediaInfo vsMediaInfoJ2 = aVar.j();
            Intrinsics.d(vsMediaInfoJ2);
            arrayList.add(vsMediaInfoJ2);
            com.transsion.publish.adapter.v vVar = this.videoAdapter;
            if (vVar != null) {
                vVar.r(arrayList);
            }
            ew.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (operationBarView2 = mViewBinding.f64431n) != null) {
                operationBarView2.selectItem(1);
            }
            com.transsion.publish.adapter.v vVar2 = this.videoAdapter;
            if (vVar2 != null && (listI = vVar2.i()) != null && listI.size() >= 1 && (imageView = this.videoIcon) != null) {
                imageView.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilmReviewFragment.refreshVideo$lambda$21(this.f56614a);
                    }
                }, 200L);
            }
        } else if (numD != null && numD.intValue() == 2) {
            this.coverPath = null;
            com.transsion.publish.adapter.v vVar3 = this.videoAdapter;
            if (vVar3 != null) {
                vVar3.q();
            }
            ew.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (operationBarView = mViewBinding2.f64431n) != null) {
                operationBarView.resetItem();
            }
        }
        FragmentActivity activity = getActivity();
        Intrinsics.e(activity, "null cannot be cast to non-null type com.transsion.publish.ui.FilmReviewActivity");
        ((FilmReviewActivity) activity).W(isPostEnable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshVideo$lambda$21(FilmReviewFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        ImageView imageView = this$0.videoIcon;
        if (imageView != null) {
            imageView.setImageResource(R$drawable.icon_post_video_unable);
        }
    }

    private final void refreshWork(cw.a aVar) {
        com.transsion.publish.adapter.g gVar;
        com.transsion.publish.adapter.v vVar;
        ew.h mViewBinding;
        OperationBarView operationBarView;
        String subjectId;
        this.mSubject = aVar.i();
        Integer numD = aVar.d();
        if (numD != null && numD.intValue() == 1) {
            Subject subjectI = aVar.i();
            if (subjectI != null) {
                setSubject(subjectI);
            }
            HashMap map = new HashMap();
            Subject subjectI2 = aVar.i();
            if (subjectI2 == null || (subjectId = subjectI2.getSubjectId()) == null) {
                subjectId = "";
            }
            map.put("subject_id", subjectId);
            com.transsion.baselib.report.m.f51277a.m(getPageName(), "click", map);
            return;
        }
        if (numD == null || numD.intValue() != 2 || (gVar = this.imageAdapter) == null || !gVar.l() || (vVar = this.videoAdapter) == null || !vVar.k() || (mViewBinding = getMViewBinding()) == null || (operationBarView = mViewBinding.f64431n) == null) {
            return;
        }
        operationBarView.resetItem();
    }

    private final void requestCurrentLocation() {
        FragmentActivity activity = getActivity();
        if (activity != null && PermissionX.f48641a.e(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            getMRoomApi().M0(activity, new Function1<LocationPlace, Unit>() { // from class: com.transsion.publish.ui.FilmReviewFragment.requestCurrentLocation.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LocationPlace locationPlace) {
                    invoke2(locationPlace);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LocationPlace locationPlace) {
                    String name = locationPlace != null ? locationPlace.getName() : null;
                    if (name == null || name.length() == 0) {
                        return;
                    }
                    FilmReviewFragment.this.setLocation(locationPlace);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectPhotosDispose(List<PhotoEntity> list) {
        com.transsion.publish.adapter.g gVar;
        ImageView imageView;
        List<PhotoEntity> listJ;
        OperationBarView operationBarView;
        OperationBarView operationBarView2;
        if (list != null && list.isEmpty()) {
            com.transsion.publish.adapter.g gVar2 = this.imageAdapter;
            if (gVar2 == null) {
                initImageAdapter();
                return;
            }
            if (gVar2 != null) {
                gVar2.s();
            }
            ew.h mViewBinding = getMViewBinding();
            if (mViewBinding == null || (operationBarView2 = mViewBinding.f64431n) == null) {
                return;
            }
            operationBarView2.resetItem();
            return;
        }
        initImageAdapter();
        com.transsion.publish.adapter.g gVar3 = this.imageAdapter;
        if (gVar3 != null) {
            gVar3.t(list);
        }
        com.transsion.publish.adapter.g gVar4 = this.imageAdapter;
        if ((gVar4 == null || gVar4.getItemCount() < 9) && (gVar = this.imageAdapter) != null) {
            gVar.g(getAddImageEntity());
        }
        ew.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (operationBarView = mViewBinding2.f64431n) != null) {
            operationBarView.selectItem(0);
        }
        com.transsion.publish.adapter.g gVar5 = this.imageAdapter;
        Integer numValueOf = (gVar5 == null || (listJ = gVar5.j()) == null) ? null : Integer.valueOf(listJ.size());
        Intrinsics.d(numValueOf);
        if (numValueOf.intValue() < 9 || (imageView = this.imageIcon) == null) {
            return;
        }
        imageView.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.o
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.selectPhotosDispose$lambda$20(this.f56602a);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectPhotosDispose$lambda$20(FilmReviewFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        ImageView imageView = this$0.imageIcon;
        if (imageView != null) {
            imageView.setImageResource(R$drawable.icon_post_select_image_unable);
        }
    }

    private final void setGroup(GroupBean groupBean) {
        if (groupBean == null) {
            return;
        }
        initManagerAdapter();
        groupBean.setType(6);
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.G(groupBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLocation(LocationPlace locationPlace) {
        this.locationBean = locationPlace;
        this.curLocationBean = locationPlace;
        initManagerAdapter();
        if (locationPlace != null) {
            locationPlace.setType(8);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.G(locationPlace);
        }
    }

    private final void setStarTips(int i11) {
        TextView textView;
        ew.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (textView = mViewBinding.f64440w) == null) {
            return;
        }
        textView.setText(i11);
    }

    private final void setSubject(Subject subject) {
        if (subject == null) {
            return;
        }
        initManagerAdapter();
        subject.setType(3);
        if (this.sourceType == 1) {
            subject.setCorrelation(true);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.G(subject);
        }
    }

    private final void showActivityTips() {
        BubbleTextView bubbleTextView;
        ew.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f64420b) == null) {
            return;
        }
        bubbleTextView.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.q
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.showActivityTips$lambda$11(this.f56605a);
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showActivityTips$lambda$11(final FilmReviewFragment this$0) {
        OperationBarView operationBarView;
        RecyclerView rv2;
        Intrinsics.g(this$0, "this$0");
        if (this$0.isMoreThanADay(System.currentTimeMillis(), RoomAppMMKV.f51271a.a().getLong("publish_show_guide_time", 0L))) {
            if (this$0.groupBean == null && this$0.mSubject == null && this$0.locationBean != null) {
                return;
            }
            if (this$0.mSubject != null || this$0.locationBean == null) {
                final d dVar = this$0.new d();
                ew.h mViewBinding = this$0.getMViewBinding();
                if (mViewBinding == null || (operationBarView = mViewBinding.f64431n) == null || (rv2 = operationBarView.getRv()) == null) {
                    return;
                }
                rv2.post(new Runnable() { // from class: com.transsion.publish.ui.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilmReviewFragment.showActivityTips$lambda$11$lambda$10(this.f56611a, dVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showActivityTips$lambda$11$lambda$10(FilmReviewFragment this$0, d countDownTimer) {
        float f11;
        BubbleTextView bubbleTextView;
        OperationBarView operationBarView;
        RecyclerView rv2;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(countDownTimer, "$countDownTimer");
        String string = this$0.getString(R$string.publish_tip_text);
        Intrinsics.f(string, "getString(R.string.publish_tip_text)");
        GroupBean groupBean = this$0.groupBean;
        int i11 = 3;
        if (groupBean == null && this$0.mSubject == null) {
            string = this$0.getString(R$string.publish_tip_text);
            Intrinsics.f(string, "getString(R.string.publish_tip_text)");
            f11 = 30.0f;
        } else if (this$0.mSubject == null) {
            string = this$0.getString(R$string.publish_tip_text_no_subject);
            Intrinsics.f(string, "getString(R.string.publish_tip_text_no_subject)");
            f11 = 6.0f;
        } else if (groupBean == null) {
            string = this$0.getString(R$string.publish_tip_text_no_group);
            Intrinsics.f(string, "getString(R.string.publish_tip_text_no_group)");
            f11 = 6.0f;
            i11 = 2;
        } else {
            f11 = 0.0f;
            i11 = 0;
        }
        ew.h mViewBinding = this$0.getMViewBinding();
        View childAt = (mViewBinding == null || (operationBarView = mViewBinding.f64431n) == null || (rv2 = operationBarView.getRv()) == null) ? null : rv2.getChildAt(i11);
        int[] iArr = new int[2];
        if (childAt != null) {
            childAt.getLocationOnScreen(iArr);
        }
        ew.h mViewBinding2 = this$0.getMViewBinding();
        if (mViewBinding2 == null || (bubbleTextView = mViewBinding2.f64420b) == null) {
            return;
        }
        countDownTimer.start();
        bubbleTextView.setVisibility(0);
        RoomAppMMKV.f51271a.a().putLong("publish_show_guide_time", System.currentTimeMillis());
        bubbleTextView.setText(string);
        int i12 = iArr[0];
        tp.f fVar = tp.f.f77260a;
        Context context = bubbleTextView.getContext();
        Intrinsics.f(context, "context");
        bubbleTextView.setArrowPosition(i12 + fVar.a(context, f11));
    }

    private final void showLinkEditInputDialog(Context context) {
        clickTrace("url");
        fw.b.a aVar = new fw.b.a(context);
        ew.h mViewBinding = getMViewBinding();
        fw.b bVarA = aVar.a(this, mViewBinding != null ? mViewBinding.f64434q : null);
        bVarA.show();
        bVarA.setCancelable(true);
        bVarA.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLink$lambda$26(FilmReviewFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.completeLoad();
    }

    private final void userGrade() {
        com.transsion.publish.adapter.r rVar;
        com.transsion.publish.adapter.g gVar;
        com.transsion.publish.adapter.v vVar;
        RatingBar ratingBar;
        EditText editText;
        Editable text;
        this.publishType = 2;
        ew.h mViewBinding = getMViewBinding();
        Float fValueOf = null;
        if (TextUtils.isEmpty((mViewBinding == null || (editText = mViewBinding.f64421c) == null || (text = editText.getText()) == null) ? null : StringsKt__StringsKt.Z0(text)) && (rVar = this.managerAdapter) != null && rVar.y() && (((gVar = this.imageAdapter) == null || (gVar != null && gVar.l())) && ((vVar = this.videoAdapter) == null || (vVar != null && vVar.k())))) {
            ew.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (ratingBar = mViewBinding2.f64432o) != null) {
                fValueOf = Float.valueOf(ratingBar.getRating());
            }
            Intrinsics.d(fValueOf);
            if (fValueOf.floatValue() > 0.0f && this.coverPath == null) {
                postService(buildRequest(), 2);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
        }
        if (checkLogin()) {
            postService(buildRequest(), 2);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    private final void userPost() {
        this.publishType = 1;
        if (checkLogin()) {
            postService(buildRequest(), 1);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final void checkPost() {
        String strT;
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            com.tn.lib.widget.toast.core.h.f50034a.k(com.transsion.baseui.R$string.base_network_fail);
            return;
        }
        clickPostTrace();
        KeyboardUtils.d(requireActivity());
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null && (strT = rVar.t()) != null) {
            SyncManager.f61414a.a().g(1, strT);
        }
        int i11 = this.sourceType;
        if (i11 == 1) {
            userGrade();
        } else {
            if (i11 != 2) {
                return;
            }
            userPost();
        }
    }

    public final void closeAffirm() {
        EditText editText;
        Editable text;
        ew.h mViewBinding = getMViewBinding();
        boolean z11 = !TextUtils.isEmpty((mViewBinding == null || (editText = mViewBinding.f64421c) == null || (text = editText.getText()) == null) ? null : StringsKt__StringsKt.Z0(text));
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        boolean z12 = (rVar == null || rVar.x()) ? false : true;
        com.transsion.publish.adapter.g gVar = this.imageAdapter;
        boolean z13 = (gVar == null || gVar.l()) ? false : true;
        com.transsion.publish.adapter.v vVar = this.videoAdapter;
        boolean z14 = (vVar == null || vVar.k()) ? false : true;
        if (z11 || z12 || z13 || z14) {
            backSaveDialog();
            return;
        }
        KeyboardUtils.d(requireActivity());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // fw.b.InterfaceC0679b
    public void completeLoad() {
        ew.h mViewBinding;
        OperationBarView operationBarView;
        OperationBarView operationBarView2;
        ew.h mViewBinding2 = getMViewBinding();
        if ((mViewBinding2 != null && (operationBarView2 = mViewBinding2.f64431n) != null && operationBarView2.getVisibility() == 0) || (mViewBinding = getMViewBinding()) == null || (operationBarView = mViewBinding.f64431n) == null) {
            return;
        }
        so.c.k(operationBarView);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public ew.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        ew.h hVarC = ew.h.c(inflater);
        Intrinsics.f(hVarC, "inflate(inflater)");
        return hVarC;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.graphics.Typeface] */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, android.graphics.Typeface] */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        RatingBar ratingBar;
        ObservableScrollView observableScrollView;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        EditText editText6;
        EditText editText7;
        OperationBarView operationBarView;
        OperationBarView operationBarView2;
        RelativeLayout relativeLayout;
        Intrinsics.g(view, "view");
        int i11 = this.sourceType;
        Typeface typeface = null;
        if (i11 == 1) {
            ew.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (ratingBar = mViewBinding.f64432o) != null) {
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.transsion.publish.ui.w
                    @Override // android.widget.RatingBar.OnRatingBarChangeListener
                    public final void onRatingChanged(RatingBar ratingBar2, float f11, boolean z11) {
                        FilmReviewFragment.initView$lambda$0(this.f56619a, ratingBar2, f11, z11);
                    }
                });
            }
            ew.h mViewBinding2 = getMViewBinding();
            TextView textView = mViewBinding2 != null ? mViewBinding2.f64439v : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            ew.h mViewBinding3 = getMViewBinding();
            RatingBar ratingBar2 = mViewBinding3 != null ? mViewBinding3.f64432o : null;
            if (ratingBar2 != null) {
                ratingBar2.setVisibility(0);
            }
            ew.h mViewBinding4 = getMViewBinding();
            RelativeLayout relativeLayout2 = mViewBinding4 != null ? mViewBinding4.f64435r : null;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
        } else if (i11 == 2) {
            ew.h mViewBinding5 = getMViewBinding();
            TextView textView2 = mViewBinding5 != null ? mViewBinding5.f64439v : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            ew.h mViewBinding6 = getMViewBinding();
            RatingBar ratingBar3 = mViewBinding6 != null ? mViewBinding6.f64432o : null;
            if (ratingBar3 != null) {
                ratingBar3.setVisibility(8);
            }
            ew.h mViewBinding7 = getMViewBinding();
            RelativeLayout relativeLayout3 = mViewBinding7 != null ? mViewBinding7.f64435r : null;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(8);
            }
            ew.h mViewBinding8 = getMViewBinding();
            if (mViewBinding8 != null && (relativeLayout = mViewBinding8.f64433p) != null) {
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        FilmReviewFragment.initView$lambda$1(this.f56591a, view2);
                    }
                });
            }
        }
        ew.h mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (operationBarView2 = mViewBinding9.f64431n) != null) {
            operationBarView2.setClickListener(this);
        }
        ew.h mViewBinding10 = getMViewBinding();
        if (mViewBinding10 != null && (operationBarView = mViewBinding10.f64431n) != null) {
            operationBarView.init(this.sourceType, this.groupBean, this.mSubject);
        }
        this.loginLaunch = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.publish.ui.j
            @Override // b1.a
            public final void a(Object obj) {
                FilmReviewFragment.initView$lambda$2(this.f56593a, (ActivityResult) obj);
            }
        });
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ew.h mViewBinding11 = getMViewBinding();
        objectRef.element = Typeface.create((mViewBinding11 == null || (editText7 = mViewBinding11.f64422d) == null) ? null : editText7.getTypeface(), 1);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        ew.h mViewBinding12 = getMViewBinding();
        if (mViewBinding12 != null && (editText6 = mViewBinding12.f64422d) != null) {
            typeface = editText6.getTypeface();
        }
        objectRef2.element = Typeface.create(typeface, 0);
        ew.h mViewBinding13 = getMViewBinding();
        if (mViewBinding13 != null && (editText5 = mViewBinding13.f64422d) != null) {
            editText5.addTextChangedListener(new b(objectRef, objectRef2));
        }
        ew.h mViewBinding14 = getMViewBinding();
        if (mViewBinding14 != null && (editText4 = mViewBinding14.f64422d) != null) {
            editText4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.publish.ui.k
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z11) {
                    FilmReviewFragment.initView$lambda$3(this.f56595a, view2, z11);
                }
            });
        }
        ew.h mViewBinding15 = getMViewBinding();
        if (mViewBinding15 != null && (editText3 = mViewBinding15.f64421c) != null) {
            editText3.addTextChangedListener(new c());
        }
        ew.h mViewBinding16 = getMViewBinding();
        if (mViewBinding16 != null && (editText2 = mViewBinding16.f64421c) != null) {
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.publish.ui.l
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z11) {
                    FilmReviewFragment.initView$lambda$5(this.f56597a, view2, z11);
                }
            });
        }
        ew.h mViewBinding17 = getMViewBinding();
        if (mViewBinding17 != null && (editText = mViewBinding17.f64421c) != null) {
            editText.postDelayed(this.mRunnable, 500L);
        }
        ew.h mViewBinding18 = getMViewBinding();
        if (mViewBinding18 != null && (observableScrollView = mViewBinding18.f64438u) != null) {
            observableScrollView.setScrollListener(new ObservableScrollView.a() { // from class: com.transsion.publish.ui.m
                @Override // com.transsion.publish.view.ObservableScrollView.a
                public final void a(int i12) {
                    FilmReviewFragment.initView$lambda$6(i12);
                }
            });
        }
        requestCurrentLocation();
        showActivityTips();
        getVideoIconView();
        getImageIconView();
    }

    public final boolean isPostEnable() {
        com.transsion.publish.adapter.v vVar;
        ew.h mViewBinding;
        EditText editText;
        Editable text;
        com.transsion.publish.adapter.g gVar = this.imageAdapter;
        return ((gVar == null || gVar.l()) && ((vVar = this.videoAdapter) == null || vVar.k()) && ((mViewBinding = getMViewBinding()) == null || (editText = mViewBinding.f64421c) == null || (text = editText.getText()) == null || text.length() == 0)) ? false : true;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(PAGE_NAME, false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.destroy();
        }
        MMKV mmkvZ = MMKV.z("kv_link_record");
        if (mmkvZ != null) {
            mmkvZ.putString("link", "");
        }
        uo.b.a.f(uo.b.f78622a, this.TAG, "FilmReviewFragment onDestroy", false, 4, null);
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        System.currentTimeMillis();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        FragmentActivity activity;
        Intrinsics.g(dialog, "dialog");
        String tag = dialog.getTag();
        if (tag != null) {
            int iHashCode = tag.hashCode();
            if (iHashCode == -1257717947) {
                if (tag.equals("clear_cover")) {
                    deleteAudio();
                }
            } else if (iHashCode == 1335127509 && tag.equals("back_save") && (activity = getActivity()) != null) {
                activity.finish();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.E();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("sourceType", 2)) : null;
        Intrinsics.d(numValueOf);
        this.sourceType = numValueOf.intValue();
        Bundle arguments2 = getArguments();
        Integer numValueOf2 = arguments2 != null ? Integer.valueOf(arguments2.getInt("sourceMode", 0)) : null;
        Intrinsics.d(numValueOf2);
        this.sourceMode = numValueOf2.intValue();
        Bundle arguments3 = getArguments();
        if (arguments3 != null && arguments3.containsKey("subject")) {
            Bundle arguments4 = getArguments();
            Serializable serializable = arguments4 != null ? arguments4.getSerializable("subject") : null;
            if (serializable != null && (serializable instanceof Subject)) {
                this.mSubject = (Subject) serializable;
            }
        }
        Bundle arguments5 = getArguments();
        if (arguments5 != null && arguments5.containsKey("group")) {
            Bundle arguments6 = getArguments();
            Serializable serializable2 = arguments6 != null ? arguments6.getSerializable("group") : null;
            if (serializable2 != null && (serializable2 instanceof GroupBean)) {
                this.groupBean = (GroupBean) serializable2;
            }
        }
        super.onViewCreated(view, bundle);
        initViewModel();
        initRegisterMediaSelector();
        this.showTime = System.currentTimeMillis();
        uo.b.a.f(uo.b.f78622a, this.TAG, "FilmReviewFragment onViewCreated", false, 4, null);
    }

    @Override // com.transsion.publish.adapter.a
    public void put(Context context) {
        EditText editText;
        Intrinsics.g(context, "context");
        ew.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f64421c) == null) {
            return;
        }
        KeyboardUtils.e(editText);
    }

    @Override // com.transsion.publish.adapter.a
    public void startAudio(Context context) {
        Intrinsics.g(context, "context");
        clickTrace(MimeTypes.BASE_TYPE_AUDIO);
        SelectMusicActivity.f56545l.a(context);
    }

    @Override // com.transsion.publish.adapter.a
    public void startGroup(Context context) {
        Intrinsics.g(context, "context");
        openRoomList();
    }

    @Override // com.transsion.publish.adapter.a
    public void startLink(Context context) {
        OperationVerticalBarView operationVerticalBarView;
        EditText editText;
        OperationBarView operationBarView;
        Intrinsics.g(context, "context");
        ew.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (operationVerticalBarView = mViewBinding.f64430m) == null || operationVerticalBarView.getVisibility() != 0) {
            showLinkEditInputDialog(context);
            return;
        }
        ew.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (operationBarView = mViewBinding2.f64431n) != null) {
            so.c.g(operationBarView);
        }
        hideOpertaionDialog();
        showLinkEditInputDialog(context);
        ew.h mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (editText = mViewBinding3.f64421c) == null) {
            return;
        }
        editText.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.v
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.startLink$lambda$26(this.f56617a);
            }
        }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    @Override // com.transsion.publish.adapter.a
    public void startLocation(final Context context) {
        Intrinsics.g(context, "context");
        FragmentActivity activity = getActivity();
        if (activity == null || !isAdded() || isDetached() || isRemoving()) {
            return;
        }
        if (!PermissionX.f48641a.e(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            getMRoomApi().E0(activity, true, new Function1<Boolean, Unit>() { // from class: com.transsion.publish.ui.FilmReviewFragment.startLocation.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    if (z11) {
                        Intent intent = new Intent(context, (Class<?>) SelectLocationActivity.class);
                        if (this.curLocationBean != null) {
                            intent.putExtra("location_data", this.curLocationBean);
                        }
                        intent.setFlags(ASTNode.DEOP);
                        context.startActivity(intent);
                    }
                }
            });
            return;
        }
        Intent intent = new Intent(context, (Class<?>) SelectLocationActivity.class);
        LocationPlace locationPlace = this.curLocationBean;
        if (locationPlace != null) {
            intent.putExtra("location_data", locationPlace);
        }
        intent.setFlags(ASTNode.DEOP);
        context.startActivity(intent);
    }

    @Override // com.transsion.publish.adapter.a
    public void startPhoto(Context context) {
        List<PhotoEntity> listJ;
        List<PhotoEntity> listJ2;
        String string;
        Intrinsics.g(context, "context");
        com.transsion.publish.adapter.g gVar = this.imageAdapter;
        if (gVar == null || (listJ2 = gVar.j()) == null || listJ2.size() < 9) {
            clickTrace("image");
            SelectImageActivity.a aVar = SelectImageActivity.f56514r;
            com.transsion.publish.adapter.g gVar2 = this.imageAdapter;
            aVar.a(context, 0, 9 - ((gVar2 == null || (listJ = gVar2.j()) == null) ? 0 : listJ.size()), new ArrayList());
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (string = activity.getString(R$string.add_img_max_tips)) == null) {
            string = "";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format(string, Arrays.copyOf(new Object[]{9}, 1));
        Intrinsics.f(str, "format(...)");
        com.tn.lib.widget.toast.core.h.f50034a.l(str);
    }

    @Override // com.transsion.publish.adapter.a
    public void startVideo(Context context) {
        List<VsMediaInfo> listI;
        String string;
        Intrinsics.g(context, "context");
        com.transsion.publish.adapter.v vVar = this.videoAdapter;
        if (vVar != null && (listI = vVar.i()) != null && listI.size() >= 1) {
            FragmentActivity activity = getActivity();
            if (activity == null || (string = activity.getString(R$string.add_video_max_tips)) == null) {
                string = "";
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str = String.format(string, Arrays.copyOf(new Object[]{1}, 1));
            Intrinsics.f(str, "format(...)");
            com.tn.lib.widget.toast.core.h.f50034a.l(str);
            return;
        }
        clickTrace("vidio");
        if (this.underOS33) {
            Intent intent = new Intent(context, (Class<?>) SelectVideoActivity.class);
            intent.setFlags(ASTNode.DEOP);
            startActivity(intent);
        } else {
            b1.b<b1.e> bVar = this.videoSelectLauncher;
            if (bVar != null) {
                bVar.a(b1.f.a(c1.g.e.f14546a));
            }
        }
    }

    @Override // com.transsion.publish.adapter.a
    public void startWork(Context context) {
        Intrinsics.g(context, "context");
        clickTrace("choose a subject");
        es.b bVar = (es.b) es.a.f64348a.a(es.b.class);
        if (bVar != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            bVar.d(contextRequireContext);
        }
    }
}
