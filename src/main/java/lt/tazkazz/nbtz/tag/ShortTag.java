package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;

public class ShortTag extends Tag<Short> {
    public ShortTag(String name) {
        super(name, (short) 0);
    }

    public ShortTag(String name, short value) {
        super(name, value);
    }

    public ShortTag(short value) {
        super("", value);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {
        setValue(input.readShort());
    }

    @Override
    public void write(NBTOutputStream output) throws IOException {
        output.writeShort(getValue());
    }
}
