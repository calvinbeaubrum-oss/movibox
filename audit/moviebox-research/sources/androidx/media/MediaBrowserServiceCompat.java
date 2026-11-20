package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f8828j = Log.isLoggable("MBServiceCompat", 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f8829a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConnectionRecord f8834g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaSessionCompat.Token f8836i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ServiceBinderImpl f8830b = new ServiceBinderImpl();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConnectionRecord f8831c = new ConnectionRecord("android.media.session.MediaController", -1, -1, null, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<ConnectionRecord> f8832d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.collection.a<IBinder, ConnectionRecord> f8833f = new androidx.collection.a<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f8835h = new o(this);

    /* JADX INFO: compiled from: source.java */
    public class ConnectionRecord implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8839c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.media.b f8840d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f8841e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final m f8842f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final HashMap<String, List<androidx.core.util.e<IBinder, Bundle>>> f8843g = new HashMap<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public e f8844h;

        public ConnectionRecord(String str, int i11, int i12, Bundle bundle, m mVar) {
            this.f8837a = str;
            this.f8838b = i11;
            this.f8839c = i12;
            this.f8840d = new androidx.media.b(str, i11, i12);
            this.f8841e = bundle;
            this.f8842f = mVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f8835h.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ConnectionRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = ConnectionRecord.this;
                    MediaBrowserServiceCompat.this.f8833f.remove(connectionRecord.f8842f.asBinder());
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public class MediaBrowserServiceImplApi21 implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Bundle> f8846a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaBrowserService f8847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Messenger f8848c;

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;

            public AnonymousClass3(String str, Bundle bundle) {
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<IBinder> it = MediaBrowserServiceCompat.this.f8833f.keySet().iterator();
                while (it.hasNext()) {
                    MediaBrowserServiceImplApi21.this.b(MediaBrowserServiceCompat.this.f8833f.get(it.next()), this.val$parentId, this.val$options);
                }
            }
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;
            final /* synthetic */ androidx.media.b val$remoteUserInfo;

            public AnonymousClass4(androidx.media.b bVar, String str, Bundle bundle) {
                this.val$remoteUserInfo = bVar;
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i11 = 0; i11 < MediaBrowserServiceCompat.this.f8833f.size(); i11++) {
                    ConnectionRecord connectionRecordValueAt = MediaBrowserServiceCompat.this.f8833f.valueAt(i11);
                    if (connectionRecordValueAt.f8840d.equals(this.val$remoteUserInfo)) {
                        MediaBrowserServiceImplApi21.this.b(connectionRecordValueAt, this.val$parentId, this.val$options);
                    }
                }
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        public class a extends k<List<MediaBrowserCompat.MediaItem>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ l f8850f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, l lVar) {
                super(obj);
                this.f8850f = lVar;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.k
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(@Nullable List<MediaBrowserCompat.MediaItem> list) {
                List listEmptyList;
                if (list == null) {
                    listEmptyList = Build.VERSION.SDK_INT >= 24 ? null : Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                    listEmptyList = arrayList;
                }
                this.f8850f.b(listEmptyList);
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        @RequiresApi(21)
        public class b extends MediaBrowserService {
            public b(Context context) {
                attachBaseContext(context);
            }

            @Override // android.service.media.MediaBrowserService
            public MediaBrowserService.BrowserRoot onGetRoot(String str, int i11, Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                e eVarC = MediaBrowserServiceImplApi21.this.c(str, i11, bundle == null ? null : new Bundle(bundle));
                if (eVarC == null) {
                    return null;
                }
                return new MediaBrowserService.BrowserRoot(eVarC.f8865a, eVarC.f8866b);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
                MediaBrowserServiceImplApi21.this.d(str, new l<>(result));
            }
        }

        public MediaBrowserServiceImplApi21() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.f
        public void a(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.f8835h.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserServiceImplApi21.this.e(token);
                }
            });
        }

        public void b(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<androidx.core.util.e<IBinder, Bundle>> list = connectionRecord.f8843g.get(str);
            if (list != null) {
                for (androidx.core.util.e<IBinder, Bundle> eVar : list) {
                    if (androidx.media.a.b(bundle, eVar.f7890b)) {
                        MediaBrowserServiceCompat.this.n(str, connectionRecord, eVar.f7890b, bundle);
                    }
                }
            }
        }

        public e c(String str, int i11, Bundle bundle) {
            Bundle bundleC;
            int i12;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundleC = null;
                i12 = -1;
            } else {
                bundle.remove("extra_client_version");
                this.f8848c = new Messenger(MediaBrowserServiceCompat.this.f8835h);
                bundleC = new Bundle();
                bundleC.putInt("extra_service_version", 2);
                androidx.core.app.e.b(bundleC, "extra_messenger", this.f8848c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f8836i;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    androidx.core.app.e.b(bundleC, "extra_session_binder", extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.f8846a.add(bundleC);
                }
                int i13 = bundle.getInt("extra_calling_pid", -1);
                bundle.remove("extra_calling_pid");
                i12 = i13;
            }
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i12, i11, bundle, null);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f8834g = connectionRecord;
            e eVarF = mediaBrowserServiceCompat.f(str, i11, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat2.f8834g = null;
            if (eVarF == null) {
                return null;
            }
            if (this.f8848c != null) {
                mediaBrowserServiceCompat2.f8832d.add(connectionRecord);
            }
            if (bundleC == null) {
                bundleC = eVarF.c();
            } else if (eVarF.c() != null) {
                bundleC.putAll(eVarF.c());
            }
            return new e(eVarF.d(), bundleC);
        }

        public void d(String str, l<List<Parcel>> lVar) {
            a aVar = new a(str, lVar);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f8834g = mediaBrowserServiceCompat.f8831c;
            mediaBrowserServiceCompat.g(str, aVar);
            MediaBrowserServiceCompat.this.f8834g = null;
        }

        public void e(MediaSessionCompat.Token token) {
            if (!this.f8846a.isEmpty()) {
                IMediaSession extraBinder = token.getExtraBinder();
                if (extraBinder != null) {
                    Iterator<Bundle> it = this.f8846a.iterator();
                    while (it.hasNext()) {
                        androidx.core.app.e.b(it.next(), "extra_session_binder", extraBinder.asBinder());
                    }
                }
                this.f8846a.clear();
            }
            this.f8847b.setSessionToken((MediaSession.Token) token.getToken());
        }

        @Override // androidx.media.MediaBrowserServiceCompat.f
        public IBinder onBind(Intent intent) {
            return this.f8847b.onBind(intent);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.f
        public void onCreate() {
            b bVar = new b(MediaBrowserServiceCompat.this);
            this.f8847b = bVar;
            bVar.onCreate();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class ServiceBinderImpl {
        public ServiceBinderImpl() {
        }

        public void a(final String str, final IBinder iBinder, final Bundle bundle, final m mVar) {
            MediaBrowserServiceCompat.this.f8835h.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f8833f.get(mVar.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.a(str, connectionRecord, iBinder, bundle);
                        return;
                    }
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                }
            });
        }

        public void b(final String str, final int i11, final int i12, final Bundle bundle, final m mVar) {
            if (MediaBrowserServiceCompat.this.d(str, i12)) {
                MediaBrowserServiceCompat.this.f8835h.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IBinder iBinderAsBinder = mVar.asBinder();
                        MediaBrowserServiceCompat.this.f8833f.remove(iBinderAsBinder);
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i11, i12, bundle, mVar);
                        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat.f8834g = connectionRecord;
                        e eVarF = mediaBrowserServiceCompat.f(str, i12, bundle);
                        connectionRecord.f8844h = eVarF;
                        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat2.f8834g = null;
                        if (eVarF == null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("No root for client ");
                            sb2.append(str);
                            sb2.append(" from service ");
                            sb2.append(getClass().getName());
                            try {
                                mVar.b();
                                return;
                            } catch (RemoteException unused) {
                                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                                return;
                            }
                        }
                        try {
                            mediaBrowserServiceCompat2.f8833f.put(iBinderAsBinder, connectionRecord);
                            iBinderAsBinder.linkToDeath(connectionRecord, 0);
                            if (MediaBrowserServiceCompat.this.f8836i != null) {
                                mVar.c(connectionRecord.f8844h.d(), MediaBrowserServiceCompat.this.f8836i, connectionRecord.f8844h.c());
                            }
                        } catch (RemoteException unused2) {
                            Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str);
                            MediaBrowserServiceCompat.this.f8833f.remove(iBinderAsBinder);
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i12 + " package=" + str);
        }

        public void c(final m mVar) {
            MediaBrowserServiceCompat.this.f8835h.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecordRemove = MediaBrowserServiceCompat.this.f8833f.remove(mVar.asBinder());
                    if (connectionRecordRemove != null) {
                        connectionRecordRemove.f8842f.asBinder().unlinkToDeath(connectionRecordRemove, 0);
                    }
                }
            });
        }

        public void d(final String str, final ResultReceiver resultReceiver, final m mVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f8835h.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f8833f.get(mVar.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.o(str, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                }
            });
        }

        public void e(final m mVar, final String str, final int i11, final int i12, final Bundle bundle) {
            MediaBrowserServiceCompat.this.f8835h.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord;
                    IBinder iBinderAsBinder = mVar.asBinder();
                    MediaBrowserServiceCompat.this.f8833f.remove(iBinderAsBinder);
                    Iterator<ConnectionRecord> it = MediaBrowserServiceCompat.this.f8832d.iterator();
                    while (true) {
                        connectionRecord = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        ConnectionRecord next = it.next();
                        if (next.f8839c == i12) {
                            connectionRecord = (TextUtils.isEmpty(str) || i11 <= 0) ? MediaBrowserServiceCompat.this.new ConnectionRecord(next.f8837a, next.f8838b, next.f8839c, bundle, mVar) : null;
                            it.remove();
                            break;
                        }
                    }
                    if (connectionRecord == null) {
                        connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(str, i11, i12, bundle, mVar);
                    }
                    MediaBrowserServiceCompat.this.f8833f.put(iBinderAsBinder, connectionRecord);
                    try {
                        iBinderAsBinder.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            });
        }

        public void f(final String str, final IBinder iBinder, final m mVar) {
            MediaBrowserServiceCompat.this.f8835h.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f8833f.get(mVar.asBinder());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                        return;
                    }
                    if (MediaBrowserServiceCompat.this.q(str, connectionRecord, iBinder)) {
                        return;
                    }
                    Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                }
            });
        }

        public void g(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final m mVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f8835h.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f8833f.get(mVar.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.p(str, bundle, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str);
                }
            });
        }

        public void h(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final m mVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f8835h.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f8833f.get(mVar.asBinder());
                    if (connectionRecord != null) {
                        MediaBrowserServiceCompat.this.m(str, bundle, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle);
                }
            });
        }

        public void i(final m mVar) {
            MediaBrowserServiceCompat.this.f8835h.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    IBinder iBinderAsBinder = mVar.asBinder();
                    ConnectionRecord connectionRecordRemove = MediaBrowserServiceCompat.this.f8833f.remove(iBinderAsBinder);
                    if (connectionRecordRemove != null) {
                        iBinderAsBinder.unlinkToDeath(connectionRecordRemove, 0);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a extends k<List<MediaBrowserCompat.MediaItem>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ConnectionRecord f8854f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f8855g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Bundle f8856h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Bundle f8857i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, ConnectionRecord connectionRecord, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f8854f = connectionRecord;
            this.f8855g = str;
            this.f8856h = bundle;
            this.f8857i = bundle2;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable List<MediaBrowserCompat.MediaItem> list) {
            if (MediaBrowserServiceCompat.this.f8833f.get(this.f8854f.f8842f.asBinder()) != this.f8854f) {
                if (MediaBrowserServiceCompat.f8828j) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                    sb2.append(this.f8854f.f8837a);
                    sb2.append(" id=");
                    sb2.append(this.f8855g);
                    return;
                }
                return;
            }
            if ((a() & 1) != 0) {
                list = MediaBrowserServiceCompat.this.b(list, this.f8856h);
            }
            try {
                this.f8854f.f8842f.a(this.f8855g, list, this.f8856h, this.f8857i);
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.f8855g + " package=" + this.f8854f.f8837a);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b extends k<MediaBrowserCompat.MediaItem> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f8859f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f8859f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable MediaBrowserCompat.MediaItem mediaItem) {
            if ((a() & 2) != 0) {
                this.f8859f.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", mediaItem);
            this.f8859f.send(0, bundle);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c extends k<List<MediaBrowserCompat.MediaItem>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f8861f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f8861f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable List<MediaBrowserCompat.MediaItem> list) {
            if ((a() & 4) != 0 || list == null) {
                this.f8861f.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f8861f.send(0, bundle);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d extends k<Bundle> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f8863f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f8863f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        public void c(@Nullable Bundle bundle) {
            this.f8863f.send(-1, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable Bundle bundle) {
            this.f8863f.send(0, bundle);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f8866b;

        public e(@NonNull String str, @Nullable Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
            }
            this.f8865a = str;
            this.f8866b = bundle;
        }

        public Bundle c() {
            return this.f8866b;
        }

        public String d() {
            return this.f8865a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface f {
        void a(MediaSessionCompat.Token token);

        IBinder onBind(Intent intent);

        void onCreate();
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(23)
    public class g extends MediaBrowserServiceImplApi21 {

        /* JADX INFO: compiled from: source.java */
        public class a extends k<MediaBrowserCompat.MediaItem> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ l f8868f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, l lVar) {
                super(obj);
                this.f8868f = lVar;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.k
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(@Nullable MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f8868f.b(null);
                    return;
                }
                Parcel parcelObtain = Parcel.obtain();
                mediaItem.writeToParcel(parcelObtain, 0);
                this.f8868f.b(parcelObtain);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends MediaBrowserServiceImplApi21.b {
            public b(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
                g.this.f(str, new l<>(result));
            }
        }

        public g() {
            super();
        }

        public void f(String str, l<Parcel> lVar) {
            a aVar = new a(str, lVar);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f8834g = mediaBrowserServiceCompat.f8831c;
            mediaBrowserServiceCompat.i(str, aVar);
            MediaBrowserServiceCompat.this.f8834g = null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.f
        public void onCreate() {
            b bVar = new b(MediaBrowserServiceCompat.this);
            this.f8847b = bVar;
            bVar.onCreate();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(26)
    public class h extends g {

        /* JADX INFO: compiled from: source.java */
        public class a extends k<List<MediaBrowserCompat.MediaItem>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ l f8872f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Bundle f8873g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, l lVar, Bundle bundle) {
                super(obj);
                this.f8872f = lVar;
                this.f8873g = bundle;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.k
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(@Nullable List<MediaBrowserCompat.MediaItem> list) {
                if (list == null) {
                    this.f8872f.b(null);
                    return;
                }
                if ((a() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.b(list, this.f8873g);
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (MediaBrowserCompat.MediaItem mediaItem : list) {
                    Parcel parcelObtain = Parcel.obtain();
                    mediaItem.writeToParcel(parcelObtain, 0);
                    arrayList.add(parcelObtain);
                }
                this.f8872f.b(arrayList);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends g.b {
            public b(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                h hVar = h.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f8834g = mediaBrowserServiceCompat.f8831c;
                hVar.g(str, new l<>(result), bundle);
                MediaBrowserServiceCompat.this.f8834g = null;
            }
        }

        public h() {
            super();
        }

        public void g(String str, l<List<Parcel>> lVar, Bundle bundle) {
            a aVar = new a(str, lVar, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f8834g = mediaBrowserServiceCompat.f8831c;
            mediaBrowserServiceCompat.h(str, aVar, bundle);
            MediaBrowserServiceCompat.this.f8834g = null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.f
        public void onCreate() {
            b bVar = new b(MediaBrowserServiceCompat.this);
            this.f8847b = bVar;
            bVar.onCreate();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(28)
    public class i extends h {
        public i() {
            super();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class j implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f8877a;

        public void b(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f8878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8882e;

        public k(Object obj) {
            this.f8878a = obj;
        }

        public int a() {
            return this.f8882e;
        }

        public boolean b() {
            return this.f8879b || this.f8880c || this.f8881d;
        }

        public void c(@Nullable Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f8878a);
        }

        public void d(@Nullable T t11) {
            throw null;
        }

        public void e(@Nullable Bundle bundle) {
            if (!this.f8880c && !this.f8881d) {
                this.f8881d = true;
                c(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f8878a);
            }
        }

        public void f(@Nullable T t11) {
            if (!this.f8880c && !this.f8881d) {
                this.f8880c = true;
                d(t11);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f8878a);
            }
        }

        public void g(int i11) {
            this.f8882e = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(21)
    public static class l<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaBrowserService.Result f8883a;

        public l(MediaBrowserService.Result result) {
            this.f8883a = result;
        }

        public List<MediaBrowser.MediaItem> a(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(T t11) {
            if (t11 instanceof List) {
                this.f8883a.sendResult(a((List) t11));
                return;
            }
            if (!(t11 instanceof Parcel)) {
                this.f8883a.sendResult(null);
                return;
            }
            Parcel parcel = (Parcel) t11;
            parcel.setDataPosition(0);
            this.f8883a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface m {
        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;

        IBinder asBinder();

        void b() throws RemoteException;

        void c(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class n implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Messenger f8884a;

        public n(Messenger messenger) {
            this.f8884a = messenger;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            d(3, bundle3);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        public IBinder asBinder() {
            return this.f8884a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        public void b() throws RemoteException {
            d(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        public void c(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            d(1, bundle2);
        }

        public final void d(int i11, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i11;
            messageObtain.arg1 = 2;
            messageObtain.setData(bundle);
            this.f8884a.send(messageObtain);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class o extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public MediaBrowserServiceCompat f8885a;

        public o(@NonNull MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.f8885a = mediaBrowserServiceCompat;
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public void b() {
            this.f8885a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f8885a;
            if (mediaBrowserServiceCompat != null) {
                mediaBrowserServiceCompat.c(message);
            } else {
                removeCallbacksAndMessages(null);
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j11) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid > 0) {
                data.putInt("data_calling_pid", callingPid);
            } else if (!data.containsKey("data_calling_pid")) {
                data.putInt("data_calling_pid", -1);
            }
            return super.sendMessageAtTime(message, j11);
        }
    }

    public void a(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<androidx.core.util.e<IBinder, Bundle>> arrayList = connectionRecord.f8843g.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        for (androidx.core.util.e<IBinder, Bundle> eVar : arrayList) {
            if (iBinder == eVar.f7889a && androidx.media.a.a(bundle, eVar.f7890b)) {
                return;
            }
        }
        arrayList.add(new androidx.core.util.e<>(iBinder, bundle));
        connectionRecord.f8843g.put(str, arrayList);
        n(str, connectionRecord, bundle, null);
        this.f8834g = connectionRecord;
        k(str, bundle);
        this.f8834g = null;
    }

    public List<MediaBrowserCompat.MediaItem> b(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i11 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i12 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i11 == -1 && i12 == -1) {
            return list;
        }
        int i13 = i12 * i11;
        int size = i13 + i12;
        if (i11 < 0 || i12 < 1 || i13 >= list.size()) {
            return Collections.emptyList();
        }
        if (size > list.size()) {
            size = list.size();
        }
        return list.subList(i13, size);
    }

    public void c(Message message) {
        Bundle data = message.getData();
        switch (message.what) {
            case 1:
                Bundle bundle = data.getBundle("data_root_hints");
                MediaSessionCompat.ensureClassLoader(bundle);
                this.f8830b.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new n(message.replyTo));
                break;
            case 2:
                this.f8830b.c(new n(message.replyTo));
                break;
            case 3:
                Bundle bundle2 = data.getBundle("data_options");
                MediaSessionCompat.ensureClassLoader(bundle2);
                this.f8830b.a(data.getString("data_media_item_id"), androidx.core.app.e.a(data, "data_callback_token"), bundle2, new n(message.replyTo));
                break;
            case 4:
                this.f8830b.f(data.getString("data_media_item_id"), androidx.core.app.e.a(data, "data_callback_token"), new n(message.replyTo));
                break;
            case 5:
                this.f8830b.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new n(message.replyTo));
                break;
            case 6:
                Bundle bundle3 = data.getBundle("data_root_hints");
                MediaSessionCompat.ensureClassLoader(bundle3);
                this.f8830b.e(new n(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                break;
            case 7:
                this.f8830b.i(new n(message.replyTo));
                break;
            case 8:
                Bundle bundle4 = data.getBundle("data_search_extras");
                MediaSessionCompat.ensureClassLoader(bundle4);
                this.f8830b.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new n(message.replyTo));
                break;
            case 9:
                Bundle bundle5 = data.getBundle("data_custom_action_extras");
                MediaSessionCompat.ensureClassLoader(bundle5);
                this.f8830b.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new n(message.replyTo));
                break;
            default:
                Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                break;
        }
    }

    public boolean d(String str, int i11) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i11)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void e(@NonNull String str, Bundle bundle, @NonNull k<Bundle> kVar) {
        kVar.e(null);
    }

    @Nullable
    public abstract e f(@NonNull String str, int i11, @Nullable Bundle bundle);

    public abstract void g(@NonNull String str, @NonNull k<List<MediaBrowserCompat.MediaItem>> kVar);

    public void h(@NonNull String str, @NonNull k<List<MediaBrowserCompat.MediaItem>> kVar, @NonNull Bundle bundle) {
        kVar.g(1);
        g(str, kVar);
    }

    public void i(String str, @NonNull k<MediaBrowserCompat.MediaItem> kVar) {
        kVar.g(2);
        kVar.f(null);
    }

    public void j(@NonNull String str, Bundle bundle, @NonNull k<List<MediaBrowserCompat.MediaItem>> kVar) {
        kVar.g(4);
        kVar.f(null);
    }

    public void k(String str, Bundle bundle) {
    }

    public void l(String str) {
    }

    public void m(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        d dVar = new d(str, resultReceiver);
        this.f8834g = connectionRecord;
        e(str, bundle, dVar);
        this.f8834g = null;
        if (dVar.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    public void n(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, connectionRecord, str, bundle, bundle2);
        this.f8834g = connectionRecord;
        if (bundle == null) {
            g(str, aVar);
        } else {
            h(str, aVar, bundle);
        }
        this.f8834g = null;
        if (aVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.f8837a + " id=" + str);
    }

    public void o(String str, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.f8834g = connectionRecord;
        i(str, bVar);
        this.f8834g = null;
        if (bVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f8829a.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            this.f8829a = new i();
        } else if (i11 >= 26) {
            this.f8829a = new h();
        } else if (i11 >= 23) {
            this.f8829a = new g();
        } else {
            this.f8829a = new MediaBrowserServiceImplApi21();
        }
        this.f8829a.onCreate();
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.f8835h.b();
    }

    public void p(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.f8834g = connectionRecord;
        j(str, bundle, cVar);
        this.f8834g = null;
        if (cVar.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    public boolean q(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z11 = false;
        try {
            if (iBinder != null) {
                List<androidx.core.util.e<IBinder, Bundle>> list = connectionRecord.f8843g.get(str);
                if (list != null) {
                    Iterator<androidx.core.util.e<IBinder, Bundle>> it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == it.next().f7889a) {
                            it.remove();
                            z11 = true;
                        }
                    }
                    if (list.size() == 0) {
                        connectionRecord.f8843g.remove(str);
                    }
                }
            } else if (connectionRecord.f8843g.remove(str) != null) {
                z11 = true;
            }
            this.f8834g = connectionRecord;
            l(str);
            this.f8834g = null;
            return z11;
        } catch (Throwable th2) {
            this.f8834g = connectionRecord;
            l(str);
            this.f8834g = null;
            throw th2;
        }
    }

    public void r(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null");
        }
        if (this.f8836i != null) {
            throw new IllegalStateException("The session token has already been set");
        }
        this.f8836i = token;
        this.f8829a.a(token);
    }
}
