package com.transsion.moviedetail.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.android.arouter.facade.Postcard;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baselib.report.m;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.ninegridview.preview.ImagePreviewActivity;
import com.transsion.web.share.ImageShareDialog;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class MoviePosterActivity extends BaseActivity<tu.b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f53434b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Subject f53435a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W() {
        ((tu.b) getMViewBinding()).f77430c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoviePosterActivity.X(this.f53441a, view);
            }
        });
        ((tu.b) getMViewBinding()).f77431d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.activity.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoviePosterActivity.Y(this.f53442a, view);
            }
        });
        ((tu.b) getMViewBinding()).f77432f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.activity.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoviePosterActivity.Z(this.f53443a, view);
            }
        });
        ((tu.b) getMViewBinding()).f77429b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.activity.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoviePosterActivity.a0(this.f53444a, view);
            }
        });
    }

    public static final void X(MoviePosterActivity this$0, View view) {
        Cover cover;
        Intrinsics.g(this$0, "this$0");
        Subject subject = this$0.f53435a;
        if (subject == null || (cover = subject.getCover()) == null) {
            return;
        }
        com.transsion.baselib.helper.a.f51183a.g("movie_poster", "preview", (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.bigImageUrl = cover.getUrl();
        imageInfo.thumbnailUrl = cover.getThumbnail();
        Integer height = cover.getHeight();
        imageInfo.imageViewHeight = height != null ? height.intValue() : 0.0f;
        Integer width = cover.getWidth();
        imageInfo.imageViewWidth = width != null ? width.intValue() : 0.0f;
        ImagePreviewActivity.Companion.a(this$0, 0, kotlin.collections.g.q(imageInfo));
    }

    public static final void Y(MoviePosterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baselib.helper.a.f51183a.g("movie_poster", "save_picture", (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
        this$0.saveToAlbum(new Function2<Boolean, File, Unit>() { // from class: com.transsion.moviedetail.activity.MoviePosterActivity$initListener$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, File file) {
                invoke(bool.booleanValue(), file);
                return Unit.f68710a;
            }

            public final void invoke(boolean z11, File file) {
                if (z11) {
                    zp.b.f82110a.d(R$string.has_been_saved);
                } else {
                    zp.b.f82110a.d(R$string.image_save_success);
                }
            }
        });
    }

    public static final void Z(MoviePosterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baselib.helper.a.f51183a.g("movie_poster", AppLovinEventTypes.USER_SHARED_LINK, (28 & 4) != 0 ? "" : "", (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
        this$0.imageShareClick();
    }

    public static final void a0(MoviePosterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    public static final void d0(List list, BaseQuickAdapter adapter, View view, int i11) {
        String staffId;
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        HashMap map = new HashMap();
        map.put("module_name", "staff");
        map.put("source", m.f51277a.f());
        Staff staff = (Staff) CollectionsKt___CollectionsKt.h0(list, i11);
        if (staff == null || (staffId = staff.getStaffId()) == null) {
            staffId = "";
        }
        map.put("related_staff_id", staffId);
        com.transsion.baselib.helper.a.f51183a.h("movie_poster", map);
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/staff");
        Object item = adapter.getItem(i11);
        Intrinsics.e(item, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Staff");
        postcardB.withSerializable("staff", (Staff) item).navigation();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public tu.b getViewBinding() {
        tu.b bVarC = tu.b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b0(Subject subject) {
        String url;
        if (subject != null) {
            this.f53435a = subject;
            ((tu.b) getMViewBinding()).f77438l.setText(subject.getTitle());
            ((tu.b) getMViewBinding()).f77437k.setText(subject.getDescription());
            AppCompatImageView appCompatImageView = ((tu.b) getMViewBinding()).f77430c;
            Intrinsics.f(appCompatImageView, "mViewBinding.ivCover");
            Cover cover = subject.getCover();
            if (cover == null || (url = cover.getUrl()) == null) {
                url = "";
            }
            qw.a.c(appCompatImageView, url, 0.0f, 2, null);
            c0(subject.getStaffList());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void c0(final List<? extends Staff> list) {
        if (list == null) {
            return;
        }
        ((tu.b) getMViewBinding()).f77439m.setText(getString(com.transsion.moviedetail.R$string.starring) + "(" + list.size() + ")");
        ((tu.b) getMViewBinding()).f77434h.setLayoutManager(new LinearLayoutManager(this, 0, false));
        ((tu.b) getMViewBinding()).f77434h.addItemDecoration(new ro.c(f0.a(8.0f)));
        com.transsion.moviedetail.adapter.a aVar = new com.transsion.moviedetail.adapter.a(list);
        aVar.B0(new f9.d() { // from class: com.transsion.moviedetail.activity.f
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                MoviePosterActivity.d0(list, baseQuickAdapter, view, i11);
            }
        });
        ((tu.b) getMViewBinding()).f77434h.setAdapter(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void imageShareClick() {
        ((tu.b) getMViewBinding()).f77432f.setEnabled(false);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        saveToAlbum(new Function2<Boolean, File, Unit>() { // from class: com.transsion.moviedetail.activity.MoviePosterActivity.imageShareClick.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, File file) {
                invoke(bool.booleanValue(), file);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(boolean z11, File file) {
                if (file != null) {
                    MoviePosterActivity moviePosterActivity = MoviePosterActivity.this;
                    Uri imageUri = FileProvider.getUriForFile(moviePosterActivity, moviePosterActivity.getApplication().getPackageName() + ".download.fileprovider", file);
                    MoviePosterActivity moviePosterActivity2 = MoviePosterActivity.this;
                    Intrinsics.f(imageUri, "imageUri");
                    moviePosterActivity2.shareImage(imageUri);
                } else {
                    h.f50034a.k(com.transsion.web.R$string.share_failed_tips);
                }
                ((tu.b) MoviePosterActivity.this.getMViewBinding()).f77432f.setEnabled(true);
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("share: 耗时=");
                sb2.append(jCurrentTimeMillis2);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("movie_poster", false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Function1<g, Unit> function1 = new Function1<g, Unit>() { // from class: com.transsion.moviedetail.activity.MoviePosterActivity.onCreate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(g gVar) {
                invoke2(gVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(g it) {
                Intrinsics.g(it, "it");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("PostEventPlayRecord: ");
                sb2.append(it);
                MoviePosterActivity.this.b0(it.a());
            }
        };
        a2 a2VarQ = w0.c().q();
        Lifecycle.State state = Lifecycle.State.STARTED;
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = g.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, state, a2VarQ, true, function1);
        W();
        ViewGroup.LayoutParams layoutParams = ((tu.b) getMViewBinding()).f77429b.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = com.blankj.utilcode.util.d.c();
            ((tu.b) getMViewBinding()).f77429b.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void saveToAlbum(Function2<? super Boolean, ? super File, Unit> function2) {
        Cover cover;
        FileHelper fileHelper = FileHelper.f53955a;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        AppCompatImageView appCompatImageView = ((tu.b) getMViewBinding()).f77430c;
        Intrinsics.f(appCompatImageView, "mViewBinding.ivCover");
        Bitmap bitmapA = companion.a(appCompatImageView);
        Subject subject = this.f53435a;
        fileHelper.r(this, bitmapA, fileHelper.j((subject == null || (cover = subject.getCover()) == null) ? null : cover.getUrl()), function2);
    }

    public final void shareImage(Uri uri) {
        try {
            if (getSupportFragmentManager().findFragmentByTag("ImageShareDialog") != null) {
                return;
            }
            ImageShareDialog imageShareDialogA = ImageShareDialog.f60203g.a(uri);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.f(supportFragmentManager, "supportFragmentManager");
            imageShareDialogA.show(supportFragmentManager, "ImageShareDialog");
        } catch (Exception unused) {
            h.f50034a.k(com.transsion.web.R$string.share_failed_tips);
        }
    }
}
