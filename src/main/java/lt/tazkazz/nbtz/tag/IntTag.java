package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;

public class IntTag extends Tag<Integer> {
    public IntTag(String name) {
        super(name, 0);
    }

    public IntTag(String name, int value) {
        super(name, value);
    }

    public IntTag(int value) {
        super("", value);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {
        setValue(input.readInt());
    }

    @Override
    public void write(NBTOutputStream output) throws IOException {
        output.writeInt(getValue());
    }
}
