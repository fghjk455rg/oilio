package content;

import arc.graphics.*;
import mindustry.type.*;

public class oilioLiquids {
    public static Liquid steam;

    public static void load() {
        steam = new Liquid("masut", Color.valueOf("f8feff")) {{
            temperature = 1f;
            gas = true;
        }};
    }
}

