package za.ac.cput.factory;

import za.ac.cput.domain.Identity;
import za.ac.cput.util.Helper;

public class IdentityFactory {
    public static Identity createIdentity(String identityType, String identityValue) {
        if (Helper.isNullOrEmpty(identityType) || Helper.isNullOrEmpty(identityValue))
            return null;

        return new Identity.Builder().setIdentityType(identityType)
                .setIdentityValue(identityValue)
                .build();
    }
}