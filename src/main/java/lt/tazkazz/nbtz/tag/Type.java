package lt.tazkazz.nbtz.tag;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Type {
    TAG_END(0, EndTag.class),
    TAG_BYTE(1, ByteTag.class),
    TAG_SHORT(2, ShortTag.class),
    TAG_INT(3, IntTag.class),
    TAG_LONG(4, LongTag.class),
    TAG_FLOAT(5, FloatTag.class),
    TAG_DOUBLE(6, DoubleTag.class),
    TAG_BYTE_ARRAY(7, ByteArrayTag.class),
    TAG_STRING(8, StringTag.class),
    TAG_LIST(9, ListTag.class),
    TAG_COMPOUND(10, CompoundTag.class);

    public final byte type;
    public final Class<? extends Tag> tagClass;

    Type(int type, Class<? extends Tag> tagClass) {
        this.type = (byte) type;
        this.tagClass = tagClass;
    }

    public static Type byType(byte type) {
        return findType(value -> value.type == type, "Invalid tag type: " + type);
    }

    public static Type byClass(Class<? extends Tag> tagClass) {
        return findType(value -> value.tagClass == tagClass, "Invalid tag class: " + tagClass);
    }

    private static Type findType(Predicate<Type> predicate, String errorMessage) {
        return Arrays.stream(values())
            .filter(predicate)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(errorMessage));
    }

}
