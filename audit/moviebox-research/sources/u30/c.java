package u30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface c<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t11);

    void onSubscribe(d dVar);
}
