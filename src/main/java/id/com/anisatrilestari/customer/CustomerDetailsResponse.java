package id.com.anisatrilestari.customer;

public record CustomerDetailsResponse(
        Long id,
        String name,
        String phoneNumber) {
    public CustomerDetailsResponse(Customer customer) {
        this(
                customer.getId(),
                customer.getName(),
                customer.getPhoneNumber()
        );
    }
}
