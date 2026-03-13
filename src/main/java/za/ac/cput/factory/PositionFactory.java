package za.ac.cput.factory;

import za.ac.cput.domain.Position;
import za.ac.cput.util.Helper;

public class PositionFactory {
    public static Position createPosition(String positionCode, String status) {
        if (Helper.isNullOrEmpty(positionCode) || Helper.isNullOrEmpty(status))
            return null;

        return new Position.Builder().setPositionCode(positionCode)
                .setStatus(status)
                .build();
    }
}