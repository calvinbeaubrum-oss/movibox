package gd;

import com.google.gson.JsonObject;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface a {
    void create();

    void destroy();

    void execute(JsonObject jsonObject);

    void execute(HashMap<String, Object> map);

    Boolean isDestroy();

    Boolean isLoad();

    void loadJS(String str);

    void registerWorkLifeCycle(e eVar);

    void registerWorkerCallback(d dVar);

    int type();
}
