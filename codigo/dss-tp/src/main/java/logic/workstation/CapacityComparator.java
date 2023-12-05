package logic.workstation;

import logic.WorkStation;

import java.util.Comparator;

public class CapacityComparator implements Comparator<WorkStation> {
    @Override
    public int compare(WorkStation ws1, WorkStation ws2) {
        return ws1.size() - ws2.size();
    }
}
