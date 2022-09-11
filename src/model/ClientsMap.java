package model;

import exception.ClientsMapSizeExecption;

import java.io.Serializable;
import java.util.*;

public class ClientsMap implements Serializable {
    private int lastID;
    private HashMap<Integer, Client> mapByID;
    private HashMap<String, Client> mapByPesel;

    public ClientsMap() {
        this.lastID = -1;
        this.mapByID = new HashMap<>();
        this.mapByPesel = new HashMap<>();
    }

    public void put(Client client) {
        if (mapByID.isEmpty()) lastID = 0;
        if (lastID == -1) lastID = Collections.max(mapByID.keySet());
        if (client == null) return;

        mapByID.put(++lastID, client);
        mapByPesel.put(client.getPesel(), client);
    }

    public Client getFromID(Integer key) {
        return mapByID.get(key);
    }

    public Client getFromPesel(Integer key) {
        return mapByPesel.get(key);
    }

    public Set<Integer> keySetByID() {
        return mapByID.keySet();
    }

    public Set<String> keySetByPesel() {
        return mapByPesel.keySet();
    }

    public Collection<Client> values() {
        return mapByPesel.values();
    }

    public boolean containsID(Integer ID) {
        return mapByID.containsKey(ID);
    }

    public boolean containsPesel(String pesel) {
        return mapByPesel.containsKey(pesel);
    }

    public int size(){
        int clientsSize = mapByID.size();
        if (clientsSize == mapByPesel.size()) throw new ClientsMapSizeExecption("Clients database error");
        return clientsSize;
    }

}
