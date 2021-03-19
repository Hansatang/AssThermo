package Client.core;

import Client.network.ClientModel;
import Client.network.ClientSocket;

public class ClientFactory
{

    private ClientModel client;

    public ClientModel getClient() {
        if(client == null) {
            client = new ClientSocket();
            client.startClient();
        }
        return client;
    }
}
