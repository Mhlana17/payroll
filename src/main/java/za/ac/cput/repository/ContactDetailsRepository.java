package za.ac.cput.repository;

import za.ac.cput.domain.ContactDetails;

import java.util.HashSet;
import java.util.Set;

public class ContactDetailsRepository implements IRepository<ContactDetails, String> {
    private static ContactDetailsRepository repository = null;
    private final Set<ContactDetails> contactDetailsSet;

    private ContactDetailsRepository() {
        this.contactDetailsSet = new HashSet<>();
    }

    public static ContactDetailsRepository getRepository() {
        if (repository == null) {
            repository = new ContactDetailsRepository();
        }
        return repository;
    }

    @Override
    public ContactDetails create(ContactDetails contactDetails) {
        this.contactDetailsSet.add(contactDetails);
        return contactDetails;
    }

    @Override
    public ContactDetails read(String email) {
        return findByEmail(email);
    }

    @Override
    public ContactDetails update(ContactDetails contactDetails) {
        ContactDetails oldContactDetails = findByEmail(contactDetails.getEmail());
        if (oldContactDetails != null) {
            this.contactDetailsSet.remove(oldContactDetails);
            this.contactDetailsSet.add(contactDetails);
            return contactDetails;
        }
        return null;
    }

    @Override
    public boolean delete(String email) {
        ContactDetails contactDetails = findByEmail(email);
        if (contactDetails != null) {
            this.contactDetailsSet.remove(contactDetails);
            return true;
        }
        return false;
    }

    @Override
    public Set<ContactDetails> getAll() {
        return this.contactDetailsSet;
    }

    private ContactDetails findByEmail(String email) {
        return this.contactDetailsSet.stream()
                .filter(contactDetails -> contactDetails.getEmail().equals(email))
                .findAny()
                .orElse(null);
    }
}
