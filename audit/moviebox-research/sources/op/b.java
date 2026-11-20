package op;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tn.lib.util.device.TNDeviceHelper;
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
    public static final a f72507c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f72508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f72509b;

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
        this.f72508a = TAG;
        if (context instanceof Application) {
            this.f72509b = context;
        } else {
            this.f72509b = context.getApplicationContext();
        }
        try {
            if (context.bindService(intent, this, 1)) {
                return;
            }
            uo.b.a aVar = uo.b.f78622a;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "Service binding failed", false, 4, null);
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
                    String oaid = op.a.AbstractBinderC0783a.e0(service).getId();
                    TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
                    Intrinsics.f(oaid, "oaid");
                    tNDeviceHelper.q(oaid);
                    uo.b.a aVar = uo.b.f78622a;
                    String TAG = this.f72508a;
                    Intrinsics.f(TAG, "TAG");
                    uo.b.a.f(aVar, TAG, "onServiceConnected oaid=" + oaid, false, 4, null);
                    Context context = this.f72509b;
                    if (context != null) {
                        context.unbindService(this);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    Context context2 = this.f72509b;
                    if (context2 != null) {
                        context2.unbindService(this);
                    }
                }
            } catch (Throwable th2) {
                try {
                    Context context3 = this.f72509b;
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
