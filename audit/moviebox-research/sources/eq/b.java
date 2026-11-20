package eq;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tn.tranpay.device.TNDeviceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b implements ServiceConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f64343c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f64345b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, Intent intent) {
            Intrinsics.g(context, "context");
            Intrinsics.g(intent, "intent");
            new b(context, intent, null);
        }
    }

    public b(Context context, Intent intent) {
        String TAG = b.class.getSimpleName();
        this.f64344a = TAG;
        if (context instanceof Application) {
            this.f64345b = context;
        } else {
            this.f64345b = context.getApplicationContext();
        }
        try {
            if (context.bindService(intent, this, 1)) {
                return;
            }
            fq.a aVar = fq.a.f65215a;
            Intrinsics.f(TAG, "TAG");
            aVar.b("Service binding failed", TAG);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public /* synthetic */ b(Context context, Intent intent, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        Intrinsics.g(name, "name");
        Intrinsics.g(service, "service");
        try {
            try {
                try {
                    String oaid = eq.a.AbstractBinderC0664a.e0(service).getId();
                    TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f50078a;
                    Intrinsics.f(oaid, "oaid");
                    tNDeviceHelper.f(oaid);
                    String TAG = this.f64344a;
                    Intrinsics.f(TAG, "TAG");
                    fq.a.f65215a.b("onServiceConnected oaid=" + oaid, TAG);
                    Context context = this.f64345b;
                    if (context != null) {
                        context.unbindService(this);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    Context context2 = this.f64345b;
                    if (context2 != null) {
                        context2.unbindService(this);
                    }
                }
            } catch (Throwable th2) {
                try {
                    Context context3 = this.f64345b;
                    if (context3 != null) {
                        context3.unbindService(this);
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
                throw th2;
            }
        } catch (Exception e13) {
            e13.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        Intrinsics.g(name, "name");
    }
}
