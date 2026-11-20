package vs;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.compressor.image.Checker;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class h implements Handler.Callback {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Random f79088i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f79089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f79090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f79091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f79092d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vs.a f79093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<d> f79094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f79095h;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f79096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f79097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f79098c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f79100e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public vs.a f79101f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f79099d = 100;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<d> f79102g = new ArrayList();

        /* JADX INFO: renamed from: vs.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0879a extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f79103b;

            public C0879a(String str) {
                this.f79103b = str;
            }

            @Override // vs.c
            public InputStream a() throws IOException {
                return new FileInputStream(this.f79103b);
            }

            @Override // vs.d
            public String getPath() {
                return this.f79103b;
            }
        }

        public a(Context context) {
            this.f79096a = context;
        }

        public static /* bridge */ /* synthetic */ f e(a aVar) {
            aVar.getClass();
            return null;
        }

        public final h h() {
            return new h(this);
        }

        public void i() {
            try {
                File fileE = j.e(this.f79096a);
                if (fileE != null) {
                    this.f79097b = fileE.getAbsolutePath();
                }
                j.d(new File(this.f79097b));
            } catch (Exception unused) {
            }
        }

        public a j(vs.a aVar) {
            this.f79101f = aVar;
            return this;
        }

        public void k() {
            h().g(this.f79096a);
        }

        public a l(String str) {
            this.f79102g.add(new C0879a(str));
            return this;
        }

        public a m(e eVar) {
            this.f79100e = eVar;
            return this;
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                f79088i = SecureRandom.getInstanceStrong();
            } else {
                f79088i = new Random();
            }
        } catch (NoSuchAlgorithmException e11) {
            j.f(Log.getStackTraceString(e11));
        }
    }

    public h(a aVar) {
        this.f79089a = aVar.f79097b;
        a.e(aVar);
        this.f79094g = aVar.f79102g;
        this.f79092d = aVar.f79100e;
        this.f79091c = aVar.f79099d;
        this.f79093f = aVar.f79101f;
        this.f79090b = aVar.f79098c;
        this.f79095h = new Handler(Looper.getMainLooper(), this);
    }

    public static a h(Context context) {
        return new a(context.getApplicationContext());
    }

    public final File c(Context context, d dVar) throws IOException {
        try {
            return d(context, dVar);
        } finally {
            dVar.close();
        }
    }

    public final File d(Context context, d dVar) throws IOException {
        Checker checker = Checker.SINGLE;
        File fileE = e(context, checker.extSuffix(dVar));
        vs.a aVar = this.f79093f;
        if (aVar != null) {
            return (aVar.a(dVar.getPath()) && checker.needCompress(this.f79091c, dVar.getPath())) ? new b(dVar, fileE, this.f79090b).a() : new File(dVar.getPath());
        }
        return checker.needCompress(this.f79091c, dVar.getPath()) ? new b(dVar, fileE, this.f79090b).a() : new File(dVar.getPath());
    }

    public final File e(Context context, String str) {
        File fileE;
        if (TextUtils.isEmpty(this.f79089a) && (fileE = j.e(context)) != null) {
            this.f79089a = fileE.getAbsolutePath();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f79089a);
        sb2.append(File.separator);
        sb2.append(System.currentTimeMillis());
        sb2.append(f79088i.nextInt(1000));
        if (TextUtils.isEmpty(str)) {
            str = ".jpg";
        }
        sb2.append(str);
        File file = new File(sb2.toString());
        j.c(file);
        return file;
    }

    public final /* synthetic */ void f(d dVar, Context context) {
        try {
            Message messageObtainMessage = this.f79095h.obtainMessage(1);
            messageObtainMessage.obj = dVar.getPath();
            this.f79095h.sendMessage(messageObtainMessage);
            File fileC = c(context, dVar);
            int[] iArrA = j.a(fileC);
            Message messageObtainMessage2 = this.f79095h.obtainMessage(0, fileC);
            Bundle bundle = new Bundle();
            bundle.putIntArray("tag_image_info", iArrA);
            bundle.putLong("tag_image_size", fileC.length() / 1024);
            messageObtainMessage2.setData(bundle);
            this.f79095h.sendMessage(messageObtainMessage2);
        } catch (IOException e11) {
            Handler handler = this.f79095h;
            handler.sendMessage(handler.obtainMessage(2, e11));
        }
    }

    public final void g(final Context context) {
        e eVar;
        e eVar2;
        if (context == null && (eVar2 = this.f79092d) != null) {
            eVar2.onError(new NullPointerException("context cannot be null"));
        }
        if (this.f79094g.size() == 0 && (eVar = this.f79092d) != null) {
            eVar.onError(new NullPointerException("image file cannot be null"));
            return;
        }
        Iterator<d> it = this.f79094g.iterator();
        while (it.hasNext()) {
            final d next = it.next();
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: vs.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f79085a.f(next, context);
                }
            });
            it.remove();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        e eVar = this.f79092d;
        if (eVar == null) {
            return true;
        }
        int i11 = message.what;
        if (i11 == 0) {
            File file = (File) message.obj;
            Bundle data = message.getData();
            this.f79092d.b(file, data.getIntArray("tag_image_info"), data.getLong("tag_image_size"));
            return false;
        }
        if (i11 == 1) {
            eVar.a((String) message.obj);
            return false;
        }
        if (i11 != 2) {
            return false;
        }
        eVar.onError((Throwable) message.obj);
        return false;
    }
}
