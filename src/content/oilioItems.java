package content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

import static mindustry.content.Items.*;

public class oilioItems {
    public static Item
            salt;

    public static final Seq<Item> ddItems = new Seq<>();

    public static void load(){
        salt = new Item("salt",Color.valueOf("e3c367")){{
            cost = 0f;
            hardness = 0;
            alwaysUnlocked = true;
        }};

        ddItems.addAll (
                graphite,titanium,silicon,plastanium,tungsten,thorium,fissileMatter
        );
    }
}
