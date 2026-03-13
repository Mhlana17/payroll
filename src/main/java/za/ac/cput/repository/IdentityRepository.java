package za.ac.cput.repository;

import za.ac.cput.domain.Identity;

import java.util.HashSet;
import java.util.Set;

public class IdentityRepository implements IRepository<Identity, String> {
    private static IdentityRepository repository = null;
    private final Set<Identity> identities;

    private IdentityRepository() {
        this.identities = new HashSet<>();
    }

    public static IdentityRepository getRepository() {
        if (repository == null) {
            repository = new IdentityRepository();
        }
        return repository;
    }

    @Override
    public Identity create(Identity identity) {
        this.identities.add(identity);
        return identity;
    }

    @Override
    public Identity read(String identityValue) {
        return findByIdentityValue(identityValue);
    }

    @Override
    public Identity update(Identity identity) {
        Identity oldIdentity = findByIdentityValue(identity.getIdentityValue());
        if (oldIdentity != null) {
            this.identities.remove(oldIdentity);
            this.identities.add(identity);
            return identity;
        }
        return null;
    }

    @Override
    public boolean delete(String identityValue) {
        Identity identity = findByIdentityValue(identityValue);
        if (identity != null) {
            this.identities.remove(identity);
            return true;
        }
        return false;
    }

    @Override
    public Set<Identity> getAll() {
        return this.identities;
    }

    private Identity findByIdentityValue(String identityValue) {
        return this.identities.stream()
                .filter(identity -> identity.getIdentityValue().equals(identityValue))
                .findAny()
                .orElse(null);
    }
}
