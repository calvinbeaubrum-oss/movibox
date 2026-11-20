package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompat {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f8276o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f8277p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public static volatile EmojiCompat f8278q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Set<f> f8280b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final b f8283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final g f8284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final i f8285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f8287i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final int[] f8288j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f8289k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f8290l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f8291m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f8292n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ReadWriteLock f8279a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f8281c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Handler f8282d = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    public static class ListenerDispatcher implements Runnable {
        private final List<f> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        public ListenerDispatcher(@NonNull f fVar, int i11) {
            this(Arrays.asList((f) androidx.core.util.i.h(fVar, "initCallback cannot be null")), i11, null);
        }

        public ListenerDispatcher(@NonNull Collection<f> collection, int i11) {
            this(collection, i11, null);
        }

        public ListenerDispatcher(@NonNull Collection<f> collection, int i11, @Nullable Throwable th2) {
            androidx.core.util.i.h(collection, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(collection);
            this.mLoadState = i11;
            this.mThrowable = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.mInitCallbacks.size();
            int i11 = 0;
            if (this.mLoadState != 1) {
                while (i11 < size) {
                    this.mInitCallbacks.get(i11).a(this.mThrowable);
                    i11++;
                }
            } else {
                while (i11 < size) {
                    this.mInitCallbacks.get(i11).b();
                    i11++;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(19)
    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile androidx.emoji2.text.h f8293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile m f8294c;

        /* JADX INFO: renamed from: androidx.emoji2.text.EmojiCompat$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0082a extends h {
            public C0082a() {
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void a(@Nullable Throwable th2) {
                a.this.f8296a.n(th2);
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void b(@NonNull m mVar) {
                a.this.d(mVar);
            }
        }

        public a(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        public void a() {
            try {
                this.f8296a.f8284f.a(new C0082a());
            } catch (Throwable th2) {
                this.f8296a.n(th2);
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        public CharSequence b(@NonNull CharSequence charSequence, int i11, int i12, int i13, boolean z11) {
            return this.f8293b.h(charSequence, i11, i12, i13, z11);
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        public void c(@NonNull EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f8294c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f8296a.f8286h);
        }

        public void d(@NonNull m mVar) {
            if (mVar == null) {
                this.f8296a.n(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f8294c = mVar;
            m mVar2 = this.f8294c;
            i iVar = this.f8296a.f8285g;
            e eVar = this.f8296a.f8292n;
            EmojiCompat emojiCompat = this.f8296a;
            this.f8293b = new androidx.emoji2.text.h(mVar2, iVar, eVar, emojiCompat.f8287i, emojiCompat.f8288j, androidx.emoji2.text.g.a());
            this.f8296a.o();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EmojiCompat f8296a;

        public b(EmojiCompat emojiCompat) {
            this.f8296a = emojiCompat;
        }

        public void a() {
            throw null;
        }

        public CharSequence b(@NonNull CharSequence charSequence, int i11, int i12, int i13, boolean z11) {
            throw null;
        }

        public void c(@NonNull EditorInfo editorInfo) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final g f8297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i f8298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8299c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8300d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public int[] f8301e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public Set<f> f8302f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f8303g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8304h = -16711936;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8305i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @NonNull
        public e f8306j = new androidx.emoji2.text.e();

        public c(@NonNull g gVar) {
            androidx.core.util.i.h(gVar, "metadataLoader cannot be null.");
            this.f8297a = gVar;
        }

        @NonNull
        public final g a() {
            return this.f8297a;
        }

        @NonNull
        public c b(int i11) {
            this.f8305i = i11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class d implements i {
        @Override // androidx.emoji2.text.EmojiCompat.i
        @NonNull
        @RequiresApi(19)
        public androidx.emoji2.text.i a(@NonNull o oVar) {
            return new p(oVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface e {
        boolean a(@NonNull CharSequence charSequence, int i11, int i12, int i13);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class f {
        public void a(@Nullable Throwable th2) {
        }

        public void b() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface g {
        void a(@NonNull h hVar);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class h {
        public abstract void a(@Nullable Throwable th2);

        public abstract void b(@NonNull m mVar);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface i {
        @NonNull
        @RequiresApi(19)
        androidx.emoji2.text.i a(@NonNull o oVar);
    }

    public EmojiCompat(@NonNull c cVar) {
        this.f8286h = cVar.f8299c;
        this.f8287i = cVar.f8300d;
        this.f8288j = cVar.f8301e;
        this.f8289k = cVar.f8303g;
        this.f8290l = cVar.f8304h;
        this.f8284f = cVar.f8297a;
        this.f8291m = cVar.f8305i;
        this.f8292n = cVar.f8306j;
        androidx.collection.b bVar = new androidx.collection.b();
        this.f8280b = bVar;
        i iVar = cVar.f8298b;
        this.f8285g = iVar == null ? new d() : iVar;
        Set<f> set = cVar.f8302f;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(cVar.f8302f);
        }
        this.f8283e = new a(this);
        m();
    }

    @NonNull
    public static EmojiCompat c() {
        EmojiCompat emojiCompat;
        synchronized (f8276o) {
            emojiCompat = f8278q;
            androidx.core.util.i.i(emojiCompat != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public static boolean f(@NonNull InputConnection inputConnection, @NonNull Editable editable, int i11, int i12, boolean z11) {
        return androidx.emoji2.text.h.b(inputConnection, editable, i11, i12, z11);
    }

    public static boolean g(@NonNull Editable editable, int i11, @NonNull KeyEvent keyEvent) {
        return androidx.emoji2.text.h.c(editable, i11, keyEvent);
    }

    @NonNull
    public static EmojiCompat h(@NonNull c cVar) {
        EmojiCompat emojiCompat = f8278q;
        if (emojiCompat == null) {
            synchronized (f8276o) {
                try {
                    emojiCompat = f8278q;
                    if (emojiCompat == null) {
                        emojiCompat = new EmojiCompat(cVar);
                        f8278q = emojiCompat;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return emojiCompat;
    }

    public static boolean i() {
        return f8278q != null;
    }

    public int d() {
        return this.f8290l;
    }

    public int e() {
        this.f8279a.readLock().lock();
        try {
            return this.f8281c;
        } finally {
            this.f8279a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.f8289k;
    }

    public final boolean k() {
        return e() == 1;
    }

    public void l() {
        androidx.core.util.i.i(this.f8291m == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.f8279a.writeLock().lock();
        try {
            if (this.f8281c == 0) {
                this.f8279a.writeLock().unlock();
                return;
            }
            this.f8281c = 0;
            this.f8279a.writeLock().unlock();
            this.f8283e.a();
        } catch (Throwable th2) {
            this.f8279a.writeLock().unlock();
            throw th2;
        }
    }

    public final void m() {
        this.f8279a.writeLock().lock();
        try {
            if (this.f8291m == 0) {
                this.f8281c = 0;
            }
            this.f8279a.writeLock().unlock();
            if (e() == 0) {
                this.f8283e.a();
            }
        } catch (Throwable th2) {
            this.f8279a.writeLock().unlock();
            throw th2;
        }
    }

    public void n(@Nullable Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.f8279a.writeLock().lock();
        try {
            this.f8281c = 2;
            arrayList.addAll(this.f8280b);
            this.f8280b.clear();
            this.f8279a.writeLock().unlock();
            this.f8282d.post(new ListenerDispatcher(arrayList, this.f8281c, th2));
        } catch (Throwable th3) {
            this.f8279a.writeLock().unlock();
            throw th3;
        }
    }

    public void o() {
        ArrayList arrayList = new ArrayList();
        this.f8279a.writeLock().lock();
        try {
            this.f8281c = 1;
            arrayList.addAll(this.f8280b);
            this.f8280b.clear();
            this.f8279a.writeLock().unlock();
            this.f8282d.post(new ListenerDispatcher(arrayList, this.f8281c));
        } catch (Throwable th2) {
            this.f8279a.writeLock().unlock();
            throw th2;
        }
    }

    @Nullable
    @CheckResult
    public CharSequence p(@Nullable CharSequence charSequence) {
        return q(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    @Nullable
    @CheckResult
    public CharSequence q(@Nullable CharSequence charSequence, int i11, int i12) {
        return r(charSequence, i11, i12, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Nullable
    @CheckResult
    public CharSequence r(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
        return s(charSequence, i11, i12, i13, 0);
    }

    @Nullable
    @CheckResult
    public CharSequence s(@Nullable CharSequence charSequence, int i11, int i12, int i13, int i14) {
        boolean z11;
        androidx.core.util.i.i(k(), "Not initialized yet");
        androidx.core.util.i.e(i11, "start cannot be negative");
        androidx.core.util.i.e(i12, "end cannot be negative");
        androidx.core.util.i.e(i13, "maxEmojiCount cannot be negative");
        androidx.core.util.i.b(i11 <= i12, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        androidx.core.util.i.b(i11 <= charSequence.length(), "start should be < than charSequence length");
        androidx.core.util.i.b(i12 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i11 == i12) {
            return charSequence;
        }
        if (i14 != 1) {
            z11 = i14 != 2 ? this.f8286h : false;
        } else {
            z11 = true;
        }
        return this.f8283e.b(charSequence, i11, i12, i13, z11);
    }

    public void t(@NonNull f fVar) {
        androidx.core.util.i.h(fVar, "initCallback cannot be null");
        this.f8279a.writeLock().lock();
        try {
            if (this.f8281c == 1 || this.f8281c == 2) {
                this.f8282d.post(new ListenerDispatcher(fVar, this.f8281c));
            } else {
                this.f8280b.add(fVar);
            }
        } finally {
            this.f8279a.writeLock().unlock();
        }
    }

    public void u(@NonNull f fVar) {
        androidx.core.util.i.h(fVar, "initCallback cannot be null");
        this.f8279a.writeLock().lock();
        try {
            this.f8280b.remove(fVar);
        } finally {
            this.f8279a.writeLock().unlock();
        }
    }

    public void v(@NonNull EditorInfo editorInfo) {
        if (!k() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f8283e.c(editorInfo);
    }
}
