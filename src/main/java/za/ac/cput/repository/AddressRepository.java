package za.ac.cput.repository;

import za.ac.cput.domain.Address;

import java.util.HashSet;
import java.util.Set;

public class AddressRepository implements IRepository<Address, String> {
    private static AddressRepository repository = null;
    private final Set<Address> addresses;

    private AddressRepository() {
        this.addresses = new HashSet<>();
    }

    public static AddressRepository getRepository() {
        if (repository == null) {
            repository = new AddressRepository();
        }
        return repository;
    }

    @Override
    public Address create(Address address) {
        this.addresses.add(address);
        return address;
    }

    @Override
    public Address read(String streetAddress) {
        return findByStreetAddress(streetAddress);
    }

    @Override
    public Address update(Address address) {
        Address oldAddress = findByStreetAddress(address.getStreetAddress());
        if (oldAddress != null) {
            this.addresses.remove(oldAddress);
            this.addresses.add(address);
            return address;
        }
        return null;
    }

    @Override
    public boolean delete(String streetAddress) {
        Address address = findByStreetAddress(streetAddress);
        if (address != null) {
            this.addresses.remove(address);
            return true;
        }
        return false;
    }

    @Override
    public Set<Address> getAll() {
        return this.addresses;
    }

    private Address findByStreetAddress(String streetAddress) {
        return this.addresses.stream()
                .filter(address -> address.getStreetAddress().equals(streetAddress))
                .findAny()
                .orElse(null);
    }
}
