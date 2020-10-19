package plateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class PlateTray {

    private final List<Plate> plates = new ArrayList<>();

    public synchronized Plate takePlate() throws InterruptedException {
        while(plates.isEmpty()) {
            wait();
        }

        return plates.remove(0);
    }

    public synchronized void putPlate(Plate plate) {
        Objects.requireNonNull(plate);
        plates.add(plate);
        notify();
    }

    public List<Plate> getPlates() {
        return plates;
    }
}
