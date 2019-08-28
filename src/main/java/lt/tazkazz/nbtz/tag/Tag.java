package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;

public abstract class Tag<T> {
    private String name;
    private T value;

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, T value) {
        this(name);
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name cannot be null");
        this.name = name;
    }

    public void setValue(T value) {
        if (value == null)
            throw new IllegalArgumentException("Value cannot be null");
        this.value = value;
    }

    public final byte getType() {
        return Type.byClass(this.getClass()).type;
    }

    public abstract void read(NBTInputStream input) throws IOException;

    public abstract void write(NBTOutputStream output) throws IOException;
}
