package com.bumptech.glide;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class GlideExperiments {
    private final Map<Class<?>, Experiment> experiments;

    /* JADX INFO: compiled from: source.java */
    public static final class Builder {
        private final Map<Class<?>, Experiment> experiments = new HashMap();

        public Builder add(Experiment experiment) {
            this.experiments.put(experiment.getClass(), experiment);
            return this;
        }

        public GlideExperiments build() {
            return new GlideExperiments(this);
        }

        public Builder update(Experiment experiment, boolean z11) {
            if (z11) {
                add(experiment);
            } else {
                this.experiments.remove(experiment.getClass());
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface Experiment {
    }

    public GlideExperiments(Builder builder) {
        this.experiments = Collections.unmodifiableMap(new HashMap(builder.experiments));
    }

    @Nullable
    public <T extends Experiment> T get(Class<T> cls) {
        return (T) this.experiments.get(cls);
    }

    public boolean isEnabled(Class<? extends Experiment> cls) {
        return this.experiments.containsKey(cls);
    }
}
