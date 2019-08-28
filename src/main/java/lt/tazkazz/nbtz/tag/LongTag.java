package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;

public class LongTag extends Tag<Long> {
    public LongTag(String name) {
        super(name, 0L);
    }

    public LongTag(String name, long value) {
        super(name, value);
    }

    public LongTag(long value) {
        super("", value);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {
        setValue(input.readLong());
    }

    @Override
    public void write(NBTOutputStream output) throws IOException {
        output.writeLong(getValue());
    }
}
