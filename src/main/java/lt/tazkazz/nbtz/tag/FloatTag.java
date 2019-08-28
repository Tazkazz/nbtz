package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;

public class FloatTag extends Tag<Float> {
    public FloatTag(String name) {
        super(name, 0F);
    }

    public FloatTag(String name, float value) {
        super(name, value);
    }

    public FloatTag(float value) {
        super("", value);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {
        setValue(input.readFloat());
    }

    @Override
    public void write(NBTOutputStream output) throws IOException {
        output.writeFloat(getValue());
    }
}
