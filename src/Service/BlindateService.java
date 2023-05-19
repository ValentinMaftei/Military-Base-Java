package Service;

import Model.Blindat;

import java.io.IOException;
import java.util.List;

public interface BlindateService {
    void addBlindate(List<String[]> blindate) throws IOException;
    List<Blindat> getBlindate();
}
