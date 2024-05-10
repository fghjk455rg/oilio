package example;

import arc.Events;
import arc.util.Log;
import arc.util.Time;
import content.oilioBlocks;
import content.oilioItems;
import content.oilioLiquids;
import content.oilioUnitTypes;
import content.oilioPlanets;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

public class ExampleJavaMod extends Mod{

    public ExampleJavaMod(){
        Log.info("Loaded ExampleJavaMod constructor.");
        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("WIP");
                dialog.cont.add("And so do i...").row();
                dialog.cont.button("SAY GOODBYE", dialog::hide).size(200f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        oilioItems.load();
        oilioLiquids.load();
        oilioUnitTypes.load();
        oilioBlocks.load();
        oilioPlanets.load();
    }
}