package dev.masa.masuitecore.core.api;

import dev.masa.masuitecore.bungee.MaSuiteCore;
import dev.masa.masuitecore.core.services.DatabaseService;
import dev.masa.masuitecore.core.services.PlayerService;

public class MaSuiteCoreAPI {

    public static MaSuiteCore getCore() {
        return MaSuiteCore.getInstance();
    }

    public PlayerService getPlayerService() {
        return MaSuiteCore.getInstance().getPlayerService();
    }

    public DatabaseService getDatabaseService() {
        return MaSuiteCore.getInstance().getDatabaseService();
    }
}
