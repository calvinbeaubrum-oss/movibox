package com.transsion.publish;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.tracking.TrackingKey;
import com.tn.lib.util.networkinfo.NetworkType;
import com.transsion.baselib.report.m;
import com.transsion.publish.PublishManager;
import com.transsion.publish.api.bean.MediaAudioEntity;
import com.transsion.publish.api.bean.MediaCoverEntity;
import com.transsion.publish.api.bean.MediaImageEntity;
import com.transsion.publish.api.bean.MediaVideoEntity;
import com.transsion.publish.api.bean.RequestPostEntity;
import com.transsion.publish.api.bean.RequestPostMediaEntity;
import com.transsion.publish.bean.PublishResult;
import com.transsion.publish.bean.PublishValue;
import com.transsion.publish.model.PublishModel;
import com.transsion.publish.net.PostResuleEntity;
import com.transsion.upload.bean.TstTokenEntity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.SyncManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
@SourceDebugExtension
public final class PublishManager {
    public static final a Companion = new a(null);
    private static final Lazy<PublishManager> INSTANCE$delegate = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<PublishManager>() { // from class: com.transsion.publish.PublishManager$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PublishManager invoke() {
            return new PublishManager(null);
        }
    });
    public static final String TAG = "TNPublish";
    private final int INTERVALTIME;
    private long NETWORK_MONITOR;
    private volatile boolean cancelIng;
    private final List<MediaImageEntity> compressorList;
    private final int coverProgress;
    private volatile boolean createIng;
    private int currentProgress;
    private Handler handler;
    private final int imageProgress;
    private long lastRefreshTime;
    private Runnable netRunnable;
    private NetworkReceiver netWorkReceiver;
    private RequestPostEntity postEntity;
    private final int postProgress;
    private final Lazy publishModel$delegate;
    private ConcurrentHashMap<String, PublishValue> publishQueue;
    private int publishType;
    private String tempBucket;
    private TstTokenEntity tstToken;
    private volatile boolean uploadFail;
    private volatile boolean uploadRetry;
    private int uploadType;
    private volatile boolean uploading;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PublishManager a() {
            return (PublishManager) PublishManager.INSTANCE$delegate.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public static final class b extends zo.a<PostResuleEntity> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f56337f;

        public b(boolean z11) {
            this.f56337f = z11;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            PublishManager.this.failureCallback(str, str2, this.f56337f);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(PostResuleEntity postResuleEntity) {
            PublishManager.this.successCallback(postResuleEntity);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public static final class c extends zo.a<PostResuleEntity> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f56339f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ RequestPostEntity f56340g;

        public c(boolean z11, RequestPostEntity requestPostEntity) {
            this.f56339f = z11;
            this.f56340g = requestPostEntity;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            PublishManager.this.failureCallback(str, str2, this.f56339f);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(PostResuleEntity postResuleEntity) {
            if (postResuleEntity != null) {
                postResuleEntity.setScore(this.f56340g.getScore());
            }
            PublishManager.this.successCallback(postResuleEntity);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public static final class d implements vs.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaImageEntity f56341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PublishManager f56342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<MediaImageEntity> f56343c;

        public d(MediaImageEntity mediaImageEntity, PublishManager publishManager, List<MediaImageEntity> list) {
            this.f56341a = mediaImageEntity;
            this.f56342b = publishManager;
            this.f56343c = list;
        }

        @Override // vs.e
        public void a(String path) {
            Intrinsics.g(path, "path");
        }

        @Override // vs.e
        public void b(File file, int[] ints, long j11) {
            Intrinsics.g(file, "file");
            Intrinsics.g(ints, "ints");
            uo.b.a.f(uo.b.f78622a, PublishManager.TAG, "TranCompressor success...file " + file, false, 4, null);
            MediaImageEntity mediaImageEntity = this.f56341a;
            String absolutePath = file.getAbsolutePath();
            Intrinsics.f(absolutePath, "file.absolutePath");
            mediaImageEntity.setUrl(absolutePath);
            this.f56341a.setWidth(Integer.valueOf(ints[0]));
            this.f56341a.setHeight(Integer.valueOf(ints[1]));
            this.f56341a.setSize(Long.valueOf(j11));
            this.f56342b.check(this.f56341a, this.f56343c.size());
        }

        @Override // vs.e
        public void onError(Throwable th2) {
            this.f56342b.check(this.f56341a, this.f56343c.size());
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public static final class e implements vy.c.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<RequestPostMediaEntity> f56345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f56346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RequestPostEntity f56347d;

        public e(Ref.ObjectRef<RequestPostMediaEntity> objectRef, boolean z11, RequestPostEntity requestPostEntity) {
            this.f56345b = objectRef;
            this.f56346c = z11;
            this.f56347d = requestPostEntity;
        }

        @Override // vy.c.b
        public void a(String path) {
            Intrinsics.g(path, "path");
            try {
                if (!TextUtils.isEmpty(path) && !PublishManager.this.publishQueue.contains(path)) {
                    if (PublishManager.this.isUploadSucceed(path)) {
                        PublishManager.this.disposeVideo(this.f56345b.element.getVideo(), this.f56346c);
                        return;
                    }
                    RequestPostMediaEntity media = this.f56347d.getMedia();
                    MediaCoverEntity cover = media != null ? media.getCover() : null;
                    if (cover == null) {
                        cover = new MediaCoverEntity();
                        RequestPostMediaEntity media2 = this.f56347d.getMedia();
                        if (media2 != null) {
                            media2.setCover(cover);
                        }
                    }
                    cover.setUrl(path);
                    int[] iArrD = ImageUtils.d(path);
                    cover.setSize(iArrD[0] * iArrD[1]);
                    cover.setWidth(iArrD[0]);
                    cover.setHeight(iArrD[1]);
                    PublishManager.this.publishQueue.put(path, new PublishValue(1));
                    ty.b.f78077a.d(path, UploadFileType.OBJECT_NAME_IMAGE, true, PublishManager.this.uploadCallback());
                    PublishManager.this.disposeVideo(this.f56345b.element.getVideo(), this.f56346c);
                    return;
                }
                PublishManager.this.disposeVideo(this.f56345b.element.getVideo(), this.f56346c);
            } catch (Exception e11) {
                uo.b.a.f(uo.b.f78622a, PublishManager.TAG, "onFirstFrame ext:" + e11.getMessage(), false, 4, null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public static final class f implements ty.a {
        public f() {
        }

        @Override // ty.a
        public void a(String localFilePath, long j11, long j12) {
            Intrinsics.g(localFilePath, "localFilePath");
            if (PublishManager.this.cancelIng) {
                return;
            }
            PublishManager.this.uploadProgress(localFilePath, j11, j12);
            PublishValue publishValue = (PublishValue) PublishManager.this.publishQueue.get(localFilePath);
            if (publishValue == null) {
                return;
            }
            publishValue.setState(3);
        }

        @Override // ty.a
        public void b(String localFilePath, String url, String bucket) {
            Intrinsics.g(localFilePath, "localFilePath");
            Intrinsics.g(url, "url");
            Intrinsics.g(bucket, "bucket");
            if (PublishManager.this.cancelIng) {
                return;
            }
            PublishValue publishValue = (PublishValue) PublishManager.this.publishQueue.get(localFilePath);
            if (publishValue != null) {
                publishValue.setUploadUrl(url);
            }
            PublishValue publishValue2 = (PublishValue) PublishManager.this.publishQueue.get(localFilePath);
            if (publishValue2 != null) {
                publishValue2.setState(1);
            }
            if (!TextUtils.isEmpty(bucket)) {
                PublishManager.this.tempBucket = bucket;
            }
            vy.b.f79124a.a(PublishManager.this.getClassTag() + " --> bucket = " + bucket);
            PublishManager.this.uploadSuccess();
        }

        @Override // ty.a
        public void c(String localFilePath, String str, String str2, UploadTstTokenStorageType uploadTstTokenStorageType) {
            Intrinsics.g(localFilePath, "localFilePath");
            if (PublishManager.this.cancelIng) {
                return;
            }
            PublishValue publishValue = (PublishValue) PublishManager.this.publishQueue.get(localFilePath);
            if (publishValue != null) {
                publishValue.setState(2);
            }
            PublishManager.this.uploadFail();
        }
    }

    private PublishManager() {
        this.publishQueue = new ConcurrentHashMap<>();
        this.tempBucket = "";
        this.postProgress = 10;
        this.coverProgress = 10;
        this.imageProgress = 90;
        this.INTERVALTIME = 2000;
        this.NETWORK_MONITOR = 3600000L;
        this.handler = new Handler(Looper.getMainLooper());
        this.publishModel$delegate = LazyKt__LazyJVMKt.b(new Function0<PublishModel>() { // from class: com.transsion.publish.PublishManager$publishModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishModel invoke() {
                return new PublishModel();
            }
        });
        this.compressorList = new ArrayList();
        this.netRunnable = new Runnable() { // from class: bw.d
            @Override // java.lang.Runnable
            public final void run() {
                PublishManager.netRunnable$lambda$13(this.f14427a);
            }
        };
        setNetMonitor();
    }

    public /* synthetic */ PublishManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void asyn(Runnable runnable) {
        ThreadExecute.f56362b.a().b(runnable);
    }

    private final void audioSourceReplace() {
        RequestPostMediaEntity media;
        RequestPostEntity requestPostEntity = this.postEntity;
        List<MediaAudioEntity> audio = (requestPostEntity == null || (media = requestPostEntity.getMedia()) == null) ? null : media.getAudio();
        if (audio != null) {
            for (MediaAudioEntity mediaAudioEntity : audio) {
                PublishValue publishValue = this.publishQueue.get(mediaAudioEntity.getUrl());
                mediaAudioEntity.setUrl(String.valueOf(publishValue != null ? publishValue.getUploadUrl() : null));
            }
        }
        coverSourceReplace();
        RequestPostEntity requestPostEntity2 = this.postEntity;
        if (requestPostEntity2 != null) {
            create(requestPostEntity2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void check(MediaImageEntity mediaImageEntity, int i11) {
        this.compressorList.add(mediaImageEntity);
        if (this.compressorList.size() == i11) {
            disposeImage();
        }
    }

    private final boolean checkImageNext() {
        RequestPostMediaEntity media;
        RequestPostEntity requestPostEntity = this.postEntity;
        return 1 == this.uploadType && ((requestPostEntity == null || (media = requestPostEntity.getMedia()) == null) ? null : media.getImage()) != null;
    }

    private final boolean checkImageUploadState() {
        RequestPostMediaEntity media;
        RequestPostEntity requestPostEntity = this.postEntity;
        List<MediaImageEntity> image = (requestPostEntity == null || (media = requestPostEntity.getMedia()) == null) ? null : media.getImage();
        if (1 != this.uploadType || image == null) {
            return true;
        }
        return isCompleteAll();
    }

    @Deprecated
    private final boolean checkUploadState(String str, long j11, long j12) {
        return false;
    }

    private static final void checkUploadState$lambda$16(PublishManager this$0, String uploadKey) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(uploadKey, "$uploadKey");
        PublishValue publishValue = this$0.publishQueue.get(uploadKey);
        if (publishValue != null) {
            publishValue.getState();
        }
    }

    private final void coverSourceReplace() {
        RequestPostMediaEntity media;
        RequestPostMediaEntity media2;
        MediaCoverEntity cover;
        RequestPostEntity requestPostEntity = this.postEntity;
        String url = (requestPostEntity == null || (media2 = requestPostEntity.getMedia()) == null || (cover = media2.getCover()) == null) ? null : cover.getUrl();
        RequestPostEntity requestPostEntity2 = this.postEntity;
        MediaCoverEntity cover2 = (requestPostEntity2 == null || (media = requestPostEntity2.getMedia()) == null) ? null : media.getCover();
        if (cover2 == null) {
            return;
        }
        PublishValue publishValue = this.publishQueue.get(url);
        cover2.setUrl(publishValue != null ? publishValue.getUploadUrl() : null);
    }

    private final void create(RequestPostEntity requestPostEntity) {
        create(requestPostEntity, false);
    }

    private final void create(RequestPostEntity requestPostEntity, boolean z11) {
        if (TextUtils.isEmpty(this.tempBucket)) {
            RequestPostMediaEntity media = requestPostEntity.getMedia();
            if (media != null) {
                media.setTempBucket("tempBucket");
            }
        } else {
            RequestPostMediaEntity media2 = requestPostEntity.getMedia();
            if (media2 != null) {
                media2.setTempBucket(this.tempBucket);
            }
        }
        filterExceptionData(requestPostEntity);
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, TAG, "Upload create...", false, 4, null);
        if (this.createIng) {
            uo.b.a.f(aVar, TAG, "Repeated requests", false, 4, null);
            return;
        }
        this.createIng = true;
        int i11 = this.publishType;
        if (i11 == 2) {
            uo.b.a.f(aVar, TAG, "Upload create... type_post_publish", false, 4, null);
            getPublishModel().d(requestPostEntity).e(zo.d.f82109a.c()).subscribe(new b(z11));
        } else if (i11 == 1) {
            uo.b.a.f(aVar, TAG, "Upload create... type_star_publish", false, 4, null);
            getPublishModel().e(requestPostEntity).e(zo.d.f82109a.c()).subscribe(new c(z11, requestPostEntity));
        }
    }

    private final void disposeAudio(List<MediaAudioEntity> list, boolean z11) {
        if (list != null) {
            for (MediaAudioEntity mediaAudioEntity : list) {
                if (!isUploadSucceed(mediaAudioEntity.getUrl())) {
                    this.publishQueue.put(mediaAudioEntity.getUrl(), new PublishValue(2));
                    ty.b.f78077a.d(mediaAudioEntity.getUrl(), UploadFileType.OBJECT_NAME_AUDIO, true, uploadCallback());
                }
            }
        }
    }

    private final void disposeAudioVideoProgress(String str, long j11, long j12, int i11) {
        int iProgress = progress(j11, j12);
        PublishValue publishValue = this.publishQueue.get(str);
        Integer numValueOf = publishValue != null ? Integer.valueOf(publishValue.getFileType()) : null;
        if (numValueOf != null && numValueOf.intValue() == i11) {
            int i12 = iProgress - this.postProgress;
            uo.b.a.f(uo.b.f78622a, TAG, "uploadProgress progress: " + iProgress + " " + str, false, 4, null);
            for (Map.Entry<String, PublishValue> entry : this.publishQueue.entrySet()) {
                if (!Intrinsics.b(entry.getKey(), str) && entry.getValue().getFileType() != i11 && entry.getValue().getState() == 1) {
                    i12 += this.coverProgress;
                }
            }
            if (i12 <= 0) {
                i12 = 0;
            }
            uploadIng(i12);
        }
    }

    private final void disposeCover(MediaCoverEntity mediaCoverEntity, boolean z11) {
        String url;
        if (isUploadSucceed(mediaCoverEntity != null ? mediaCoverEntity.getUrl() : null) || mediaCoverEntity == null || (url = mediaCoverEntity.getUrl()) == null) {
            return;
        }
        this.publishQueue.put(url, new PublishValue(1));
        ty.b.f78077a.d(url, UploadFileType.OBJECT_NAME_IMAGE, true, uploadCallback());
    }

    private final void disposeImage() {
        this.publishQueue.clear();
        int i11 = 0;
        for (Object obj : this.compressorList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            MediaImageEntity mediaImageEntity = (MediaImageEntity) obj;
            this.publishQueue.put(mediaImageEntity.getUrl(), new PublishValue(1));
            ty.b.f78077a.d(mediaImageEntity.getUrl(), UploadFileType.OBJECT_NAME_IMAGE, true, uploadCallback());
            i11 = i12;
        }
    }

    private final void disposeImage(List<MediaImageEntity> list, boolean z11) {
        this.compressorList.clear();
        if (list != null) {
            int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    g.u();
                }
                MediaImageEntity mediaImageEntity = (MediaImageEntity) obj;
                ts.a.f77424a.a(Utils.a()).l(mediaImageEntity.getUrl()).j(new vs.a() { // from class: bw.c
                    @Override // vs.a
                    public final boolean a(String str) {
                        return PublishManager.disposeImage$lambda$8$lambda$7(str);
                    }
                }).m(new d(mediaImageEntity, this, list)).k();
                i11 = i12;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disposeImage$lambda$8$lambda$7(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        Intrinsics.f(path, "path");
        Locale locale = Locale.getDefault();
        Intrinsics.f(locale, "getDefault()");
        String lowerCase = path.toLowerCase(locale);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        return !l.u(lowerCase, ".gif", false, 2, null);
    }

    private final void disposeImageProgress(String str, long j11, long j12) {
        int i11;
        ConcurrentHashMap<String, PublishValue> concurrentHashMap = this.publishQueue;
        if (concurrentHashMap != null && concurrentHashMap.isEmpty()) {
            uo.b.a.f(uo.b.f78622a, TAG, "disposeImageProgress isNullOrEmpty", false, 4, null);
            return;
        }
        ConcurrentHashMap<String, PublishValue> concurrentHashMap2 = this.publishQueue;
        Integer numValueOf = concurrentHashMap2 != null ? Integer.valueOf(concurrentHashMap2.size()) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            if (isInterceptProgress()) {
                checkUploadState(str, j11, j12);
                return;
            }
            int iProgress = progress(j11, j12);
            int i12 = iProgress - this.postProgress;
            i11 = i12 >= 0 ? i12 : 0;
            uploadIng(i11);
            uo.b.a.f(uo.b.f78622a, TAG, "single uploadProgress progress " + iProgress + " imageProgress:" + i11 + " " + str, false, 4, null);
            return;
        }
        if (isInterceptProgress()) {
            checkUploadState(str, j11, j12);
            return;
        }
        int i13 = this.imageProgress;
        Intrinsics.d(numValueOf);
        int iIntValue = i13 / numValueOf.intValue();
        Iterator<Map.Entry<String, PublishValue>> it = this.publishQueue.entrySet().iterator();
        int i14 = 0;
        while (it.hasNext()) {
            if (it.next().getValue().getState() == 1) {
                i14 += iIntValue;
            }
        }
        int i15 = i14 - this.postProgress;
        i11 = i15 > 0 ? i15 : 0;
        uploadIng(i14);
        uo.b.a.f(uo.b.f78622a, TAG, "uploadProgress imageProgress:" + i11 + " " + str, false, 4, null);
        setLastRefreshTime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, com.transsion.publish.api.bean.RequestPostMediaEntity] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void disposePost(Context context, RequestPostEntity requestPostEntity, boolean z11) {
        RequestPostMediaEntity requestPostMediaEntity;
        List<MediaAudioEntity> audio;
        RequestPostMediaEntity requestPostMediaEntity2;
        List<MediaVideoEntity> video;
        List<MediaVideoEntity> video2;
        MediaVideoEntity mediaVideoEntity;
        RequestPostMediaEntity requestPostMediaEntity3;
        List<MediaImageEntity> image;
        uo.b.a.f(uo.b.f78622a, TAG, "uploading=" + this.uploading, false, 4, null);
        vy.b.f79124a.b(getClassTag() + " --> publish() --> publishType = " + this.publishType + " --> postEntity = " + requestPostEntity);
        this.uploading = true;
        postUploadState$default(this, 0, 0, null, 4, null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? media = requestPostEntity.getMedia();
        objectRef.element = media;
        url = null;
        url = null;
        String url = null;
        if ((media != 0 ? media.getImage() : null) != null && (requestPostMediaEntity3 = (RequestPostMediaEntity) objectRef.element) != null && (image = requestPostMediaEntity3.getImage()) != null && (!image.isEmpty())) {
            this.uploadType = 1;
            disposeImage(((RequestPostMediaEntity) objectRef.element).getImage(), z11);
            return;
        }
        RequestPostMediaEntity requestPostMediaEntity4 = (RequestPostMediaEntity) objectRef.element;
        if ((requestPostMediaEntity4 != null ? requestPostMediaEntity4.getVideo() : null) != null && (requestPostMediaEntity2 = (RequestPostMediaEntity) objectRef.element) != null && (video = requestPostMediaEntity2.getVideo()) != null && (!video.isEmpty())) {
            this.uploadType = 4;
            RequestPostMediaEntity requestPostMediaEntity5 = (RequestPostMediaEntity) objectRef.element;
            if (requestPostMediaEntity5 != null && (video2 = requestPostMediaEntity5.getVideo()) != null && (mediaVideoEntity = video2.get(0)) != null) {
                url = mediaVideoEntity.getUrl();
            }
            vy.c.f79125a.a(context, url, new e(objectRef, z11, requestPostEntity));
            return;
        }
        RequestPostMediaEntity requestPostMediaEntity6 = (RequestPostMediaEntity) objectRef.element;
        if ((requestPostMediaEntity6 != null ? requestPostMediaEntity6.getAudio() : null) == null || (requestPostMediaEntity = (RequestPostMediaEntity) objectRef.element) == null || (audio = requestPostMediaEntity.getAudio()) == null || !(!audio.isEmpty())) {
            RequestPostMediaEntity media2 = requestPostEntity.getMedia();
            if (media2 != null) {
                media2.setMediaType(0);
            }
            create(requestPostEntity, z11);
            return;
        }
        this.uploadType = 2;
        disposeAudio(((RequestPostMediaEntity) objectRef.element).getAudio(), z11);
        if (((RequestPostMediaEntity) objectRef.element).getCover() != null) {
            disposeCover(((RequestPostMediaEntity) objectRef.element).getCover(), z11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposeVideo(List<MediaVideoEntity> list, boolean z11) {
        if (list != null) {
            for (MediaVideoEntity mediaVideoEntity : list) {
                if (!isUploadSucceed(mediaVideoEntity.getUrl())) {
                    this.publishQueue.put(mediaVideoEntity.getUrl(), new PublishValue(4));
                    ty.b.f78077a.d(mediaVideoEntity.getUrl(), UploadFileType.OBJECT_NAME_VIDEO, true, uploadCallback());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failureCallback(String str, String str2, boolean z11) {
        HashMap map = new HashMap();
        map.put(TrackingKey.ERROR_CODE, str == null ? "" : str);
        RequestPostEntity requestPostEntity = this.postEntity;
        map.put("subject_id", String.valueOf(requestPostEntity != null ? requestPostEntity.getSubjectId() : null));
        m.f51277a.m(getPageName(), "click", map);
        this.createIng = false;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, TAG, "Upload onFailure... code:" + str + "msg:" + str2, false, 4, null);
        uo.b.a.f(aVar, TAG, "Upload onFailure... retry:" + z11 + ",uploadFail:" + this.uploadFail + ",uploadRetry:" + this.uploadRetry, false, 4, null);
        if (z11 || this.uploadRetry) {
            reset();
        } else {
            uploadFail();
        }
    }

    private final void filterExceptionData(RequestPostEntity requestPostEntity) {
        List<MediaVideoEntity> video;
        List<MediaImageEntity> image;
        RequestPostMediaEntity media = requestPostEntity.getMedia();
        Iterator<MediaVideoEntity> it = null;
        Iterator<MediaImageEntity> it2 = (media == null || (image = media.getImage()) == null) ? null : image.iterator();
        while (it2 != null && it2.hasNext()) {
            if (isExceptionData(it2.next().getUrl())) {
                it2.remove();
            }
        }
        RequestPostMediaEntity media2 = requestPostEntity.getMedia();
        if (media2 != null && (video = media2.getVideo()) != null) {
            it = video.iterator();
        }
        while (it != null && it.hasNext()) {
            if (isExceptionData(it.next().getUrl())) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = PublishManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public static final PublishManager getINSTANCE() {
        return Companion.a();
    }

    private final PublishModel getPublishModel() {
        return (PublishModel) this.publishModel$delegate.getValue();
    }

    private final void imageSourceReplace() {
        RequestPostMediaEntity media;
        RequestPostEntity requestPostEntity = this.postEntity;
        List<MediaImageEntity> image = (requestPostEntity == null || (media = requestPostEntity.getMedia()) == null) ? null : media.getImage();
        if (image != null) {
            for (MediaImageEntity mediaImageEntity : image) {
                PublishValue publishValue = this.publishQueue.get(mediaImageEntity.getUrl());
                mediaImageEntity.setUrl(String.valueOf(publishValue != null ? publishValue.getUploadUrl() : null));
            }
        }
        RequestPostEntity requestPostEntity2 = this.postEntity;
        if (requestPostEntity2 != null) {
            create(requestPostEntity2);
        }
    }

    private final boolean isComplete(int i11) {
        return i11 == 1;
    }

    private final boolean isCompleteAll() {
        boolean zIsComplete = true;
        for (Map.Entry<String, PublishValue> entry : this.publishQueue.entrySet()) {
            vy.b bVar = vy.b.f79124a;
            String classTag = getClassTag();
            String key = entry.getKey();
            bVar.a(classTag + " --> check state:" + ((Object) key) + ",state:" + entry.getValue().getState() + "size=" + this.publishQueue.size());
            zIsComplete = isComplete(entry.getValue().getState());
            if (!zIsComplete) {
                break;
            }
        }
        return zIsComplete;
    }

    private final boolean isExceptionData(String str) {
        return str == null || str.length() == 0 || StringsKt__StringsKt.Q(str, "/data/user", false, 2, null) || StringsKt__StringsKt.Q(str, "/storage/emulated", false, 2, null);
    }

    private final boolean isInterceptProgress() {
        return this.lastRefreshTime != 0 && System.currentTimeMillis() - this.lastRefreshTime < ((long) this.INTERVALTIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isUploadSucceed(String str) {
        PublishValue publishValue;
        return (TextUtils.isEmpty(str) || this.publishQueue.get(str) == null || (publishValue = this.publishQueue.get(str)) == null || publishValue.getState() != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void netRunnable$lambda$13(PublishManager this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.uploading) {
            return;
        }
        this$0.reset();
        postUploadState$default(this$0, 4, 0, null, 6, null);
    }

    private final void netWorkMonitor() {
        this.handler.postDelayed(this.netRunnable, this.NETWORK_MONITOR);
    }

    private final void postSucceed(Object obj) {
        RequestPostMediaEntity media;
        if (obj == null) {
            uo.b.a.f(uo.b.f78622a, TAG, "postSucceed data null", false, 4, null);
            postUploadState(1, 100, "");
            syncPost("");
        } else if (obj instanceof PostResuleEntity) {
            PostResuleEntity postResuleEntity = (PostResuleEntity) obj;
            String postId = postResuleEntity.getPostId();
            uo.b.a.f(uo.b.f78622a, TAG, "postSucceed data postid:" + postId, false, 4, null);
            syncPost(postId);
            postUploadState(1, 100, postId);
            HashMap map = new HashMap();
            map.put("post_id", postId);
            RequestPostEntity requestPostEntity = this.postEntity;
            map.put("post_media_type", String.valueOf((requestPostEntity == null || (media = requestPostEntity.getMedia()) == null) ? null : Integer.valueOf(media.getMediaType())));
            RequestPostEntity requestPostEntity2 = this.postEntity;
            map.put("subject_id", String.valueOf(requestPostEntity2 != null ? requestPostEntity2.getSubjectId() : null));
            map.put("post_score", postResuleEntity.getScore());
            m.f51277a.m(getPageName(), "click", map);
        } else {
            postUploadState(1, 100, "");
            syncPost("");
        }
        reset();
    }

    private final void postUploadState(int i11, int i12, String str) {
        PublishResult publishResult = new PublishResult();
        publishResult.setProgress(i12);
        publishResult.setState(i11);
        publishResult.setPostId(str);
        publishResult.setSource(this.publishType);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PublishResult.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, publishResult, 0L);
    }

    public static /* synthetic */ void postUploadState$default(PublishManager publishManager, int i11, int i12, String str, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        if ((i13 & 4) != 0) {
            str = "";
        }
        publishManager.postUploadState(i11, i12, str);
    }

    private final int progress(long j11, long j12) {
        return 100 - ((int) (((j12 - j11) * ((long) 100)) / j12));
    }

    private final void setLastRefreshTime() {
        this.lastRefreshTime = System.currentTimeMillis();
    }

    private final void setNetMonitor() {
        try {
            if (this.netWorkReceiver != null) {
                return;
            }
            this.netWorkReceiver = new NetworkReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (Build.VERSION.SDK_INT >= 33) {
                Application applicationA = Utils.a();
                if (applicationA != null) {
                    applicationA.registerReceiver(this.netWorkReceiver, intentFilter, 2);
                }
            } else {
                Application applicationA2 = Utils.a();
                if (applicationA2 != null) {
                    applicationA2.registerReceiver(this.netWorkReceiver, intentFilter);
                }
            }
        } catch (Exception e11) {
            uo.b.a.f(uo.b.f78622a, TAG, "setNetMonitor ext:" + e11.getMessage(), false, 4, null);
        }
    }

    private final void startPost(final Context context, final boolean z11) {
        asyn(new Runnable() { // from class: bw.f
            @Override // java.lang.Runnable
            public final void run() {
                PublishManager.startPost$lambda$2(this.f14430a, context, z11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startPost$lambda$2(PublishManager this$0, Context context, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        try {
            RequestPostEntity requestPostEntity = this$0.postEntity;
            if (requestPostEntity != null) {
                this$0.disposePost(context, requestPostEntity, z11);
            }
        } catch (Exception e11) {
            uo.b.a.f(uo.b.f78622a, TAG, "startPost ext:" + e11.getMessage(), false, 4, null);
            this$0.uploadFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void successCallback(Object obj) {
        this.createIng = false;
        uo.b.a.f(uo.b.f78622a, TAG, "Upload onSuccess...", false, 4, null);
        try {
            uploadIng(100);
            postSucceed(obj);
        } catch (Exception e11) {
            uo.b.a.f(uo.b.f78622a, TAG, "onSuccess ext:" + e11.getMessage(), false, 4, null);
            postSucceed(obj);
        }
        ts.a.f77424a.a(Utils.a()).i();
    }

    private final void syncPost(final String str) {
        asyn(new Runnable() { // from class: bw.e
            @Override // java.lang.Runnable
            public final void run() {
                PublishManager.syncPost$lambda$25(str, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void syncPost$lambda$25(String postId, PublishManager this$0) {
        Intrinsics.g(postId, "$postId");
        Intrinsics.g(this$0, "this$0");
        SyncManager syncManagerA = SyncManager.f61414a.a();
        RequestPostEntity requestPostEntity = this$0.postEntity;
        syncManagerA.f(postId, requestPostEntity != null ? requestPostEntity.getGroupId() : null, this$0.publishType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ty.a uploadCallback() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadFail() {
        uo.b.a.f(uo.b.f78622a, TAG, "uploadFail", false, 4, null);
        this.uploadFail = true;
        postUploadState$default(this, 2, 0, null, 6, null);
    }

    private final void uploadIng(int i11) {
        postUploadState$default(this, 3, i11, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadProgress(String str, long j11, long j12) {
        int i11 = this.uploadType;
        if (i11 == 1) {
            disposeImageProgress(str, j11, j12);
            return;
        }
        if (i11 == 2) {
            if (isInterceptProgress()) {
                checkUploadState(str, j11, j12);
                return;
            }
            checkUploadState(str, j11, j12);
            disposeAudioVideoProgress(str, j11, j12, 2);
            setLastRefreshTime();
            return;
        }
        if (i11 != 4) {
            return;
        }
        if (isInterceptProgress()) {
            checkUploadState(str, j11, j12);
            return;
        }
        checkUploadState(str, j11, j12);
        disposeAudioVideoProgress(str, j11, j12, 4);
        setLastRefreshTime();
    }

    private final void uploadSucceed() {
        postUploadState$default(this, 1, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadSuccess() {
        boolean zIsCompleteAll = isCompleteAll();
        if (!zIsCompleteAll) {
            uo.b.a.f(uo.b.f78622a, TAG, "Upload unfinished...", false, 4, null);
            return;
        }
        int i11 = this.uploadType;
        if (i11 == 1) {
            if (zIsCompleteAll) {
                imageSourceReplace();
            }
        } else if (i11 == 2) {
            if (zIsCompleteAll) {
                audioSourceReplace();
            }
        } else if (i11 == 4 && zIsCompleteAll) {
            videoSourceReplace();
        }
    }

    private final void videoSourceReplace() {
        RequestPostMediaEntity media;
        RequestPostMediaEntity media2;
        uo.b.a.f(uo.b.f78622a, TAG, "videoSourceReplace", false, 4, null);
        RequestPostEntity requestPostEntity = this.postEntity;
        List<MediaVideoEntity> video = (requestPostEntity == null || (media2 = requestPostEntity.getMedia()) == null) ? null : media2.getVideo();
        if (video != null) {
            for (MediaVideoEntity mediaVideoEntity : video) {
                PublishValue publishValue = this.publishQueue.get(mediaVideoEntity.getUrl());
                mediaVideoEntity.setUrl(String.valueOf(publishValue != null ? publishValue.getUploadUrl() : null));
            }
        }
        Iterator<Map.Entry<String, PublishValue>> it = this.publishQueue.entrySet().iterator();
        while (it.hasNext()) {
            String uploadUrl = it.next().getValue().getUploadUrl();
            if (StringsKt__StringsKt.Q(uploadUrl, ".jpg", false, 2, null) || StringsKt__StringsKt.Q(uploadUrl, ".png", false, 2, null) || StringsKt__StringsKt.Q(uploadUrl, ".webp", false, 2, null) || StringsKt__StringsKt.Q(uploadUrl, ".gif", false, 2, null)) {
                RequestPostEntity requestPostEntity2 = this.postEntity;
                MediaCoverEntity cover = (requestPostEntity2 == null || (media = requestPostEntity2.getMedia()) == null) ? null : media.getCover();
                if (cover != null) {
                    cover.setUrl(uploadUrl);
                }
            }
        }
        RequestPostEntity requestPostEntity3 = this.postEntity;
        if (requestPostEntity3 != null) {
            create(requestPostEntity3);
        }
    }

    public final void cancel() {
        this.cancelIng = true;
        ty.b.f78077a.b();
        reset();
        postUploadState$default(this, 4, 0, null, 6, null);
    }

    public final String getPageName() {
        return this.publishType == 2 ? "create_post" : "create_review";
    }

    public final boolean isFail() {
        return this.uploadFail;
    }

    public final void onConnected(NetworkType networkType) {
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, TAG, "onConnected:" + (networkType != null ? networkType.name() : null), false, 4, null);
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.netRunnable);
        }
        uo.b.a.f(aVar, TAG, "uploadFail=" + this.uploadFail, false, 4, null);
        if (this.uploadFail) {
            this.uploading = false;
            uo.b.a.f(aVar, TAG, "uploading=" + this.uploading, false, 4, null);
            retry();
        }
    }

    public final void onDisconnected() {
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, TAG, "onDisconnected", false, 4, null);
        if (this.uploading) {
            netWorkMonitor();
            uploadFail();
            this.uploadFail = true;
            uo.b.a.f(aVar, TAG, "uploadFail=" + this.uploadFail, false, 4, null);
        }
    }

    public final void publish(RequestPostEntity requestPostEntity, int i11) {
        Intrinsics.g(requestPostEntity, "requestPostEntity");
        this.postEntity = requestPostEntity;
        this.publishType = i11;
        Application applicationA = Utils.a();
        if (applicationA != null) {
            startPost(applicationA, false);
        }
    }

    public final void reset() {
        this.publishQueue.clear();
        this.postEntity = null;
        this.uploading = false;
        this.cancelIng = false;
        this.uploadFail = false;
        this.uploadRetry = false;
        this.tstToken = null;
        uo.b.a.f(uo.b.f78622a, TAG, "reset", false, 4, null);
    }

    public final void retry() {
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, TAG, "retry", false, 4, null);
        if (this.uploading) {
            uo.b.a.f(aVar, TAG, "Upload in progress", false, 4, null);
            return;
        }
        this.uploading = true;
        this.uploadFail = false;
        uo.b.a.f(aVar, TAG, "retry uploading=" + this.uploading + " uploadFail=" + this.uploadFail, false, 4, null);
        boolean zIsCompleteAll = isCompleteAll();
        this.uploadRetry = true;
        if (zIsCompleteAll) {
            RequestPostEntity requestPostEntity = this.postEntity;
            if (requestPostEntity != null) {
                create(requestPostEntity, true);
                return;
            }
            return;
        }
        Application applicationA = Utils.a();
        if (applicationA != null) {
            startPost(applicationA, false);
        }
    }

    public final boolean uploading() {
        return this.uploading;
    }
}
