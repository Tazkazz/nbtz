package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;

public class DoubleTag extends Tag<Double> {
    public DoubleTag(String name) {
        super(name, 0D);
    }

    public DoubleTag(String name, double value) {
        super(name, value);
    }

    public DoubleTag(double value) {
        super("", value);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {
        setValue(input.readDouble());
    }

    @Override
    public void write(NBTOutputStream output) throws IOException {
        output.writeDouble(getValue());
    }
}
