package com.itm.patrones.reserve;

import com.itm.patrones.client.Client;
import com.itm.patrones.table.Table;

public interface ReserveObserver {
    void notify(final String message, final Client client);
}
