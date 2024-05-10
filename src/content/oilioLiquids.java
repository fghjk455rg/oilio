package content;

import arc.graphics.*;
import mindustry.content.StatusEffects;
import mindustry.type.*;

public class oilioLiquids {
    public static Liquid steam, boron;

    public static void load() {
        steam = new Liquid("steam", Color.valueOf("f8feff")) {{
            lightColor = Color.valueOf("ffffff").a(0.2f);
            temperature = 1f;
            gas = true;
        }};
        boron = new Liquid("boron", Color.valueOf("79270a")) {{
            effect = StatusEffects.corroded;
        }};
    }
}

