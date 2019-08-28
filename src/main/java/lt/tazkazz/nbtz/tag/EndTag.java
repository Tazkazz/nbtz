package lt.tazkazz.nbtz.tag;

import lt.tazkazz.nbtz.stream.NBTInputStream;
import lt.tazkazz.nbtz.stream.NBTOutputStream;

import java.io.IOException;

public class EndTag extends Tag<Void> {
    public EndTag() {
        super("", null);
    }

    public EndTag(String name) {
        super(name);
    }

    @Override
    public void read(NBTInputStream input) throws IOException {}

    @Override
    public void write(NBTOutputStream output) throws IOException {}
}
