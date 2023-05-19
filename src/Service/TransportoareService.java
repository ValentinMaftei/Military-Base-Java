package Service;

import Model.Transportor;

import java.io.IOException;
import java.util.List;

public interface TransportoareService {
    void addTransportoare(List<String[]> transportoare) throws IOException;
    List<Transportor> getTransportoare();
}
