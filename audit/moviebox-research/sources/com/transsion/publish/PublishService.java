package com.transsion.publish;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.transsion.publish.PublishService;
import com.transsion.publish.api.bean.RequestPostEntity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uo.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PublishService extends Service {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f56350g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f56352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56353b = 100012;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RequestPostEntity f56354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56355d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f56349f = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f56351h = "PublishService";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, RequestPostEntity entity, int i11) {
            Intrinsics.g(context, "context");
            Intrinsics.g(entity, "entity");
            Intent intent = new Intent(context, (Class<?>) PublishService.class);
            intent.putExtra("entity", entity);
            intent.putExtra("sourceType", i11);
            context.startService(intent);
        }
    }

    public static final void e(PublishService this$0, Intent intent) {
        Intrinsics.g(this$0, "this$0");
        this$0.c(intent);
    }

    public final void b(Runnable runnable) {
        ThreadExecute.f56362b.a().b(runnable);
    }

    public final void c(Intent intent) {
        f56350g = true;
        Intrinsics.d(intent);
        Serializable serializableExtra = intent.getSerializableExtra("entity");
        this.f56355d = intent.getIntExtra("sourceType", 0);
        if (serializableExtra != null && (serializableExtra instanceof RequestPostEntity)) {
            this.f56354c = (RequestPostEntity) serializableExtra;
        }
        d();
    }

    public final void d() {
        if (this.f56354c == null) {
            return;
        }
        b.a aVar = b.f78622a;
        b.a.f(aVar, f56351h, "disposePost", false, 4, null);
        b.a.f(aVar, f56351h, String.valueOf(this.f56354c), false, 4, null);
        PublishManager publishManagerA = PublishManager.Companion.a();
        RequestPostEntity requestPostEntity = this.f56354c;
        Intrinsics.d(requestPostEntity);
        publishManagerA.publish(requestPostEntity, this.f56355d);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f56352a = getApplicationContext();
    }

    @Override // android.app.Service
    public void onDestroy() {
        b.a.f(b.f78622a, f56351h, "onDestroy", false, 4, null);
        f56350g = false;
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i11, int i12) {
        b.a.f(b.f78622a, f56351h, "onStartCommand", false, 4, null);
        b(new Runnable() { // from class: bw.g
            @Override // java.lang.Runnable
            public final void run() {
                PublishService.e(this.f14433a, intent);
            }
        });
        return super.onStartCommand(intent, i11, i12);
    }
}
