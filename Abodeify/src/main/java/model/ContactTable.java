package model;

public class ContactTable {

    private String firstName;
    private String lastName;
    private Long contact;
    private String mailId;

    public ContactTable() {
        this.firstName = "";
        this.lastName = "";
        this.contact = 0L;
        this.mailId = "";
    }

    public ContactTable(String firstName, String lastName, Long contact, String mailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.mailId = mailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    @Override
    public String toString() {
        return "ContactTable [firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact + ", mailId="
                + mailId + "]";
    }
}
