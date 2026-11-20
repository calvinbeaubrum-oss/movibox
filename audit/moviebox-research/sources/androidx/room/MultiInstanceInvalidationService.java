package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MultiInstanceInvalidationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, String> f12764b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RemoteCallbackList<j> f12765c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k.a f12766d = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends k.a {
        public a() {
        }

        @Override // androidx.room.k
        public int H(j callback, String str) {
            Intrinsics.g(callback, "callback");
            int i11 = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList<j> remoteCallbackListA = MultiInstanceInvalidationService.this.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (remoteCallbackListA) {
                try {
                    multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() + 1);
                    int iC = multiInstanceInvalidationService.c();
                    if (multiInstanceInvalidationService.a().register(callback, Integer.valueOf(iC))) {
                        multiInstanceInvalidationService.b().put(Integer.valueOf(iC), str);
                        i11 = iC;
                    } else {
                        multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() - 1);
                        multiInstanceInvalidationService.c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return i11;
        }

        @Override // androidx.room.k
        public void c0(j callback, int i11) {
            Intrinsics.g(callback, "callback");
            RemoteCallbackList<j> remoteCallbackListA = MultiInstanceInvalidationService.this.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (remoteCallbackListA) {
                multiInstanceInvalidationService.a().unregister(callback);
                multiInstanceInvalidationService.b().remove(Integer.valueOf(i11));
            }
        }

        @Override // androidx.room.k
        public void y(int i11, String[] tables) {
            Intrinsics.g(tables, "tables");
            RemoteCallbackList<j> remoteCallbackListA = MultiInstanceInvalidationService.this.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (remoteCallbackListA) {
                String str = multiInstanceInvalidationService.b().get(Integer.valueOf(i11));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.a().beginBroadcast();
                for (int i12 = 0; i12 < iBeginBroadcast; i12++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.a().getBroadcastCookie(i12);
                        Intrinsics.e(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        int iIntValue = ((Integer) broadcastCookie).intValue();
                        String str2 = multiInstanceInvalidationService.b().get(Integer.valueOf(iIntValue));
                        if (i11 != iIntValue && Intrinsics.b(str, str2)) {
                            try {
                                ((j) multiInstanceInvalidationService.a().getBroadcastItem(i12)).c(tables);
                            } catch (RemoteException e11) {
                                Log.w("ROOM", "Error invoking a remote callback", e11);
                            }
                        }
                    } catch (Throwable th2) {
                        multiInstanceInvalidationService.a().finishBroadcast();
                        throw th2;
                    }
                }
                multiInstanceInvalidationService.a().finishBroadcast();
                Unit unit = Unit.f68710a;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends RemoteCallbackList<j> {
        public b() {
        }

        @Override // android.os.RemoteCallbackList
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(j callback, Object cookie) {
            Intrinsics.g(callback, "callback");
            Intrinsics.g(cookie, "cookie");
            MultiInstanceInvalidationService.this.b().remove((Integer) cookie);
        }
    }

    public final RemoteCallbackList<j> a() {
        return this.f12765c;
    }

    public final Map<Integer, String> b() {
        return this.f12764b;
    }

    public final int c() {
        return this.f12763a;
    }

    public final void d(int i11) {
        this.f12763a = i11;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.g(intent, "intent");
        return this.f12766d;
    }
}
