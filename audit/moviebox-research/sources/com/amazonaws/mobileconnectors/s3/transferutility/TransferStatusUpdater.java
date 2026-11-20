package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class TransferStatusUpdater {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Log f15847c = LogFactory.b(TransferStatusUpdater.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashSet<TransferState> f15848d = new HashSet<>(Arrays.asList(TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Integer, List<TransferListener>> f15849e = new ConcurrentHashMap<Integer, List<TransferListener>>() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.1
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static TransferDBUtil f15850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static TransferStatusUpdater f15851g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, TransferRecord> f15852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f15853b;

    /* JADX INFO: compiled from: source.java */
    public class TransferProgressListener implements ProgressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TransferRecord f15854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f15855b;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.f15854a = transferRecord;
        }

        @Override // com.amazonaws.event.ProgressListener
        public synchronized void a(ProgressEvent progressEvent) {
            try {
                if (32 == progressEvent.b()) {
                    TransferStatusUpdater.f15847c.d("Reset Event triggered. Resetting the bytesCurrent to 0.");
                    this.f15855b = 0L;
                } else {
                    long jA = this.f15855b + progressEvent.a();
                    this.f15855b = jA;
                    TransferRecord transferRecord = this.f15854a;
                    if (jA > transferRecord.f15824i) {
                        transferRecord.f15824i = jA;
                        TransferStatusUpdater.this.k(transferRecord.f15816a, jA, transferRecord.f15823h, true);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public TransferStatusUpdater(TransferDBUtil transferDBUtil) {
        f15850f = transferDBUtil;
        this.f15853b = new Handler(Looper.getMainLooper());
        this.f15852a = new ConcurrentHashMap();
    }

    public static synchronized TransferStatusUpdater c(Context context) {
        try {
            if (f15851g == null) {
                TransferDBUtil transferDBUtil = new TransferDBUtil(context);
                f15850f = transferDBUtil;
                f15851g = new TransferStatusUpdater(transferDBUtil);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f15851g;
    }

    public static void g(int i11, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        Map<Integer, List<TransferListener>> map = f15849e;
        synchronized (map) {
            try {
                List<TransferListener> list = map.get(Integer.valueOf(i11));
                if (list == null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(transferListener);
                    map.put(Integer.valueOf(i11), copyOnWriteArrayList);
                } else if (!list.contains(transferListener)) {
                    list.add(transferListener);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void j(int i11, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        Map<Integer, List<TransferListener>> map = f15849e;
        synchronized (map) {
            try {
                List<TransferListener> list = map.get(Integer.valueOf(i11));
                if (list != null && !list.isEmpty()) {
                    list.remove(transferListener);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized void b(TransferRecord transferRecord) {
        this.f15852a.put(Integer.valueOf(transferRecord.f15816a), transferRecord);
    }

    public synchronized TransferRecord d(int i11) {
        return this.f15852a.get(Integer.valueOf(i11));
    }

    public synchronized Map<Integer, TransferRecord> e() {
        return Collections.unmodifiableMap(this.f15852a);
    }

    public synchronized ProgressListener f(int i11) {
        TransferRecord transferRecordD;
        transferRecordD = d(i11);
        if (transferRecordD == null) {
            f15847c.d("TransferStatusUpdater doesn't track the transfer: " + i11);
            throw new IllegalArgumentException("transfer " + i11 + " doesn't exist");
        }
        f15847c.d("Creating a new progress listener for transfer: " + i11);
        return new TransferProgressListener(transferRecordD);
    }

    public synchronized void h(int i11) {
        try {
            TransferRecord transferRecordJ = f15850f.j(i11);
            if (transferRecordJ != null) {
                String str = transferRecordJ.f15834s;
                if (new File(str).getName().startsWith("aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002")) {
                    new File(str).delete();
                }
            }
            S3ClientReference.c(Integer.valueOf(i11));
            f15850f.c(i11);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void i(final int i11, final Exception exc) {
        Map<Integer, List<TransferListener>> map = f15849e;
        synchronized (map) {
            try {
                List<TransferListener> list = map.get(Integer.valueOf(i11));
                if (list != null && !list.isEmpty()) {
                    for (final TransferListener transferListener : list) {
                        this.f15853b.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.4
                            @Override // java.lang.Runnable
                            public void run() {
                                transferListener.c(i11, exc);
                            }
                        });
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized void k(final int i11, final long j11, final long j12, boolean z11) {
        try {
            TransferRecord transferRecord = this.f15852a.get(Integer.valueOf(i11));
            if (transferRecord != null) {
                transferRecord.f15824i = j11;
                transferRecord.f15823h = j12;
            }
            f15850f.p(i11, j11);
            if (z11) {
                Map<Integer, List<TransferListener>> map = f15849e;
                synchronized (map) {
                    try {
                        List<TransferListener> list = map.get(Integer.valueOf(i11));
                        if (list != null && !list.isEmpty()) {
                            for (Iterator<TransferListener> it = list.iterator(); it.hasNext(); it = it) {
                                final TransferListener next = it.next();
                                this.f15853b.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        next.b(i11, j11, j12);
                                    }
                                });
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public synchronized void l(final int i11, final TransferState transferState) {
        try {
            boolean zContains = f15848d.contains(transferState);
            TransferRecord transferRecord = this.f15852a.get(Integer.valueOf(i11));
            if (transferRecord != null) {
                zContains |= transferState.equals(transferRecord.f15830o);
                transferRecord.f15830o = transferState;
                if (f15850f.t(transferRecord) == 0) {
                    f15847c.j("Failed to update the status of transfer " + i11);
                }
            } else if (f15850f.s(i11, transferState) == 0) {
                f15847c.j("Failed to update the status of transfer " + i11);
            }
            if (zContains) {
                return;
            }
            if (TransferState.COMPLETED.equals(transferState)) {
                h(i11);
            }
            Map<Integer, List<TransferListener>> map = f15849e;
            synchronized (map) {
                try {
                    List<TransferListener> list = map.get(Integer.valueOf(i11));
                    if (list != null && !list.isEmpty()) {
                        for (final TransferListener transferListener : list) {
                            this.f15853b.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    transferListener.a(i11, transferState);
                                }
                            });
                        }
                        if (TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState)) {
                            list.clear();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }
}
