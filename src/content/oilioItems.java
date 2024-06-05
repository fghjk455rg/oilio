package content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

import static mindustry.content.Items.*;

public class oilioItems {
    public static Item
            salt,sulphur,tellurium,moss,spr243,steel,quartz,carbonfiber;

    public static final Seq<Item> ddItems = new Seq<>();

    public static void load(){
        salt = new Item("salt",Color.valueOf("e3c367")){{
            cost = 0f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        sulphur = new Item("salt",Color.valueOf("e3c367")){{
            cost = 0f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        tellurium = new Item("salt",Color.valueOf("e3c367")){{
            cost = 0f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        moss = new Item("salt",Color.valueOf("e3c367")){{
            cost = 0f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        steel = new Item("salt",Color.valueOf("e3c367")){{
            cost = 0f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        quartz = new Item("salt",Color.valueOf("e3c367")){{
            cost = 0f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        carbonfiber = new Item("salt",Color.valueOf("e3c367")){{
            cost = 0f;
            hardness = 0;
            alwaysUnlocked = true;
        }};

        ddItems.addAll (
                graphite,titanium,silicon,plastanium,tungsten,thorium,fissileMatter
        );
    }
}
