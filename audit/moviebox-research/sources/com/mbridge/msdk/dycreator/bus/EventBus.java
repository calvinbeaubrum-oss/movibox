package com.mbridge.msdk.dycreator.bus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class EventBus {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile EventBus f43627b;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f43639n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static ExecutorService f43626a = Executors.newCachedThreadPool();
    public static String TAG = "Event";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f43628c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> f43629d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f43630e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, Object> f43631f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ThreadLocal<List<Object>> f43632g = new ThreadLocal<List<Object>>() { // from class: com.mbridge.msdk.dycreator.bus.EventBus.1
        @Override // java.lang.ThreadLocal
        public /* synthetic */ List<Object> initialValue() {
            return new ArrayList();
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ThreadLocal<BooleanWrapper> f43633h = new ThreadLocal<BooleanWrapper>() { // from class: com.mbridge.msdk.dycreator.bus.EventBus.2
        @Override // java.lang.ThreadLocal
        public /* synthetic */ BooleanWrapper initialValue() {
            return new BooleanWrapper();
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f43634i = "onEvent";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HandlerPoster f43635j = new HandlerPoster(this, Looper.getMainLooper(), 10);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final BackgroundPoster f43636k = new BackgroundPoster(this);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AsyncPoster f43637l = new AsyncPoster(this);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SubscriberMethodFinder f43638m = new SubscriberMethodFinder();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f43640o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Map<String, Object> f43641p = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.bus.EventBus$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f43644a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f43644a = iArr;
            try {
                iArr[ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43644a[ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43644a[ThreadMode.BackgroundThread.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43644a[ThreadMode.Async.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class BooleanWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f43645a;
    }

    /* JADX INFO: compiled from: source.java */
    public interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    private List<Class<?>> a(Class<?> cls) {
        List<Class<?>> arrayList;
        Map<Class<?>, List<Class<?>>> map = f43628c;
        synchronized (map) {
            try {
                arrayList = map.get(cls);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                        arrayList.add(superclass);
                        a(arrayList, superclass.getInterfaces());
                    }
                    f43628c.put(cls, arrayList);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    private void a(Subscription subscription, Object obj) throws Error {
        try {
            subscription.f43663b.f43656a.invoke(subscription.f43662a, obj);
        } catch (IllegalAccessException e11) {
            throw new IllegalStateException("Unexpected exception", e11);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (!(obj instanceof SubscriberExceptionEvent)) {
                if (this.f43640o) {
                    Log.e(TAG, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.f43662a.getClass(), cause);
                }
                post(new SubscriberExceptionEvent(this, cause, obj, subscription.f43662a));
                return;
            }
            Log.e(TAG, "SubscriberExceptionEvent subscriber " + subscription.f43662a.getClass() + " threw an exception", cause);
            SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
            Log.e(TAG, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
        }
    }

    private void a(Subscription subscription, Object obj, boolean z11) {
        int i11 = AnonymousClass3.f43644a[subscription.f43663b.f43657b.ordinal()];
        if (i11 == 1) {
            a(subscription, obj);
            return;
        }
        if (i11 == 2) {
            if (z11) {
                a(subscription, obj);
                return;
            } else {
                this.f43635j.a(subscription, obj);
                return;
            }
        }
        if (i11 == 3) {
            if (z11) {
                this.f43636k.enqueue(subscription, obj);
                return;
            } else {
                a(subscription, obj);
                return;
            }
        }
        if (i11 == 4) {
            this.f43637l.enqueue(subscription, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + subscription.f43663b.f43657b);
    }

    private void a(Object obj, SubscriberMethod subscriberMethod, boolean z11) {
        Object obj2;
        this.f43639n = true;
        Class<?> cls = subscriberMethod.f43658c;
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.f43629d.get(cls);
        Subscription subscription = new Subscription(obj, subscriberMethod);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f43629d.put(cls, copyOnWriteArrayList);
        } else {
            Iterator<Subscription> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().equals(subscription)) {
                    throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        subscriberMethod.f43656a.setAccessible(true);
        copyOnWriteArrayList.add(subscription);
        List<Class<?>> arrayList = this.f43630e.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f43630e.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (z11) {
            synchronized (this.f43631f) {
                obj2 = this.f43631f.get(cls);
            }
            if (obj2 != null) {
                a(subscription, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.f43629d.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i11 = 0;
            while (i11 < size) {
                if (copyOnWriteArrayList.get(i11).f43662a == obj) {
                    copyOnWriteArrayList.remove(i11);
                    i11--;
                    size--;
                }
                i11++;
            }
        }
    }

    private void a(Object obj, String str, boolean z11) {
        Iterator<SubscriberMethod> it = this.f43638m.a(obj.getClass(), str).iterator();
        while (it.hasNext()) {
            a(obj, it.next(), z11);
        }
    }

    private synchronized void a(Object obj, String str, boolean z11, Class<?> cls, Class<?>... clsArr) {
        try {
            for (SubscriberMethod subscriberMethod : this.f43638m.a(obj.getClass(), str)) {
                if (cls == subscriberMethod.f43658c) {
                    a(obj, subscriberMethod, z11);
                } else if (clsArr != null) {
                    for (Class<?> cls2 : clsArr) {
                        if (cls2 == subscriberMethod.f43658c) {
                            a(obj, subscriberMethod, z11);
                            break;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static void clearCaches() {
        SubscriberMethodFinder.a();
        f43628c.clear();
    }

    public static void clearSkipMethodNameVerifications() {
        SubscriberMethodFinder.clearSkipMethodNameVerifications();
    }

    public static EventBus getDefault() {
        if (f43627b == null) {
            synchronized (EventBus.class) {
                try {
                    if (f43627b == null) {
                        f43627b = new EventBus();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f43627b;
    }

    public static void skipMethodNameVerificationFor(Class<?> cls) {
        SubscriberMethodFinder.a(cls);
    }

    public final void a(PendingPost pendingPost) {
        Object obj = pendingPost.f43651a;
        Subscription subscription = pendingPost.f43652b;
        PendingPost.a(pendingPost);
        a(subscription, obj);
    }

    public final void configureLogSubscriberExceptions(boolean z11) {
        if (this.f43639n) {
            throw new EventBusException("This method must be called before any registration");
        }
        this.f43640o = z11;
    }

    public final Object getStickyEvent(Class<?> cls) {
        Object obj;
        synchronized (this.f43631f) {
            obj = this.f43631f.get(cls);
        }
        return obj;
    }

    public final void post(Object obj) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList;
        List<Object> list = this.f43632g.get();
        list.add(obj);
        BooleanWrapper booleanWrapper = this.f43633h.get();
        if (booleanWrapper.f43645a) {
            return;
        }
        boolean z11 = Looper.getMainLooper() == Looper.myLooper();
        booleanWrapper.f43645a = true;
        while (!list.isEmpty()) {
            try {
                Object objRemove = list.remove(0);
                if (objRemove != null) {
                    try {
                        Class<?> cls = objRemove.getClass();
                        List<Class<?>> listA = a(cls);
                        int size = listA.size();
                        boolean z12 = false;
                        for (int i11 = 0; i11 < size; i11++) {
                            Class<?> cls2 = listA.get(i11);
                            synchronized (this) {
                                try {
                                    copyOnWriteArrayList = this.f43629d.get(cls2);
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                            if (copyOnWriteArrayList != null) {
                                Iterator<Subscription> it = copyOnWriteArrayList.iterator();
                                while (it.hasNext()) {
                                    a(it.next(), objRemove, z11);
                                }
                                z12 = true;
                            }
                        }
                        if (!z12) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("No subscripers registered for event ");
                            sb2.append(cls);
                            if (cls != NoSubscriberEvent.class && cls != SubscriberExceptionEvent.class) {
                                post(new NoSubscriberEvent(this, objRemove));
                            }
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                booleanWrapper.f43645a = false;
                throw th3;
            }
        }
        booleanWrapper.f43645a = false;
    }

    public final void postSticky(Object obj) {
        post(obj);
        synchronized (this.f43631f) {
            this.f43631f.put(obj.getClass(), obj);
        }
    }

    public final void register(Object obj) {
        a(obj, this.f43634i, false);
    }

    public final void register(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f43634i, false, cls, clsArr);
    }

    public final void register(Object obj, String str) {
        a(obj, str, false);
    }

    public final synchronized void register(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        a(obj, str, false, cls, clsArr);
    }

    public final void register(String str, Object obj) {
        Map<String, Object> map = this.f43641p;
        if (map != null && map.containsKey(str)) {
            unregister(this.f43641p.get(str));
        }
        this.f43641p.put(str, obj);
        a(obj, this.f43634i, false);
    }

    public final void registerSticky(Object obj) {
        a(obj, this.f43634i, true);
    }

    public final void registerSticky(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f43634i, true, cls, clsArr);
    }

    public final void registerSticky(Object obj, String str) {
        a(obj, str, true);
    }

    public final synchronized void registerSticky(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        a(obj, str, true, cls, clsArr);
    }

    public final void release() {
        if (f43627b != null) {
            f43627b = null;
            f43626a = null;
            Map<Class<?>, List<Class<?>>> map = f43628c;
            if (map != null && map.size() > 0) {
                map.clear();
            }
            Map<Class<?>, CopyOnWriteArrayList<Subscription>> map2 = this.f43629d;
            if (map2 != null && map2.size() > 0) {
                this.f43629d.clear();
            }
            Map<Object, List<Class<?>>> map3 = this.f43630e;
            if (map3 != null && map3.size() > 0) {
                this.f43630e.clear();
            }
            Map<Class<?>, Object> map4 = this.f43631f;
            if (map4 != null && map4.size() > 0) {
                this.f43631f.clear();
            }
            Map<String, Object> map5 = this.f43641p;
            if (map5 == null || map5.size() <= 0) {
                return;
            }
            this.f43641p.clear();
        }
    }

    public final Object removeStickyEvent(Class<?> cls) {
        Object objRemove;
        synchronized (this.f43631f) {
            objRemove = this.f43631f.remove(cls);
        }
        return objRemove;
    }

    public final boolean removeStickyEvent(Object obj) {
        synchronized (this.f43631f) {
            try {
                Class<?> cls = obj.getClass();
                if (!obj.equals(this.f43631f.get(cls))) {
                    return false;
                }
                this.f43631f.remove(cls);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized void unregister(Object obj) {
        try {
            List<Class<?>> list = this.f43630e.get(obj);
            if (list != null) {
                Iterator<Class<?>> it = list.iterator();
                while (it.hasNext()) {
                    a(obj, it.next());
                }
                this.f43630e.remove(obj);
            } else {
                Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void unregister(Object obj, Class<?>... clsArr) {
        try {
            if (clsArr.length == 0) {
                throw new IllegalArgumentException("Provide at least one event class");
            }
            List<Class<?>> list = this.f43630e.get(obj);
            if (list != null) {
                for (Class<?> cls : clsArr) {
                    a(obj, cls);
                    list.remove(cls);
                }
                if (list.isEmpty()) {
                    this.f43630e.remove(obj);
                }
            } else {
                Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void unregister(String str) {
        try {
            Map<String, Object> map = this.f43641p;
            if (map != null && map.containsKey(str)) {
                Object objRemove = this.f43641p.remove(str);
                List<Class<?>> list = this.f43630e.get(objRemove);
                if (list != null) {
                    Iterator<Class<?>> it = list.iterator();
                    while (it.hasNext()) {
                        a(objRemove, it.next());
                    }
                    this.f43630e.remove(objRemove);
                } else {
                    Log.w(TAG, "Subscriber to unregister was not registered before: " + objRemove.getClass());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
